# AlgorithmTest


Swagger 주소
http://localhost:8080/swagger-ui/index.html

요구사항 구현여부
1. 회원 가입 : O
2. 로그인 : O
3. 가입한 회원 정보 조회 : O
4. 가입한 유저의 정보를 스크랩 : O
5. 유저의 환급액 계산 : O

요구사항 구현방법 - 공통 
1. Spring Boot2.6.4 기반 스프링 부트 프로젝트 생성
2. Embedded DB H2 설정 및 JPA 설정
3. Swagger config 설정
4. Spring Security 설정
5. 로그인 설정 - JWT Token 설정

요구사항 구현방법
1. 회원 가입 : [POST] http://localhost:8080/szs/signup
   1. MemberController 클래스 생성, 
      1. @RestController @RequestMapping 설정
      2. signup 메소드 생성 및 @RequestMapping 설정
   2. MemberRequest Dto 클래스 생성 및 @RequestBody, @Valid 설정 
   3. parameter validation exception 처리를 위한 @RestControllerAdvice ApiControllerAdvice 추가
   4. MemberService 생성, 암호화를 위해 SecurityConfig에 BCryptPasswordEncoder, TextEncryptor 설정 
      1. 비밀번호는 BCryptPasswordEncoder, 주민등록번호는 TextEncryptor(AES-256/GCM) 사용 
      2. 회원가입 가능 사용자 목록 체크 
      3. 사용자 아이디 중복 체크 
      4. 사용자 이름, 주민번호 중복 체크
   5. Member entity 생성 , MemberRepository 생성
   6. 응답 처리를 위한 MemberResponse Dto 생성 
   7. Test case 구현
      1. controller
         1. success_member_signup
         2. fail_member_signup_required_param
         3. fail_member_signup_invalid_username_and_regno
      2. sevice 
         1. success_member_signup
         2. fail_member_signup_exist_userid
      3. repository
         1. success_member_save
2. 로그인 : [POST] http://localhost:8080/szs/login
   1. 로그인 처리 및 url permit 처리를 위해 SecurityConfig 수정
      1. 인증 / 인가 실패 처리 handler 추가
      2. jwttoken filter 추가
   2. MemberController 에 login 메소스 생성 및 @RequestMapping 설정 
   3. LoginRequest dto 생성 
   4. UserNamePassword 인증 처리를 위하여 CustomUserDetailsService 생성 및 UserDetails(User) 생성 처리 
      1. userid 를 이용하여 사용자 정보 조회해서 비밀번호 확인 
   5. 인증 성공시 JWT Token 응답을 위해 TokenProvider 생성 및 jwt 토큰 생성 
      1. userid를 jwt 토큰에 저장
      2. refreshToken은 생성만 해놈
   6. LoginResponse dto 생성 토큰 응답 
   7. Test case 구현 
      1. controller
         1. success_member_login
         2. fail_member_login_authentication
      2. service 
         1. success_member_login
         2. fail_member_login_invalid_userid_password
      3. repository
3. 가입한 회원 정보 조회 : [GET] http://localhost:8080/szs/me -header "Authorization: Bearer JwtToken"
   1. MemberController 에 me 메소드 생성 및 @RequestMapping 설정
   2. JwtFilter 에서 수신받은 jwttoken 유효 체크 및 유효하다면 token claims 에서 userid 조회, 해당 userid 기반으로 UsernamePasswordAuthenticationToken 생성
   3. me 메소드 파라미터로 Authentication authentication을 할당 받음, Principal 정보에서 username(userId)를 조회
   4. 조회한 userId를 토대로 member 정보 조회 하여 응답
   5. Test case 구현
      1. controller
         1. success_login_member_get_info
         2. fail_login_member_get_info_invalid_token
      2. service
         1. success_member_findById
      3. repository
4. 가입한 유저의 정보를 스크랩 : [POST] http://localhost:8080/szs/scrap -header "Authorization: Bearer JwtToken"
   1. MemberScrapController 생성 및 scrap 메소드 생성 및 @RequestMapping 설정
   2. 사용자 정보 받아오는거는 3번 me 메소드와 동일
   3. 사용자 정보에서 이름, 주민등록번호를 조회해서 External Scrap API로 조회 요청 
      1. External Scrap API Url은 application-szs.yml 에 따로 지정 
   4. External Scrap API 가 1~20초 정도 걸리므로 내부 scrap API는 accept 응답 처리 하고 가상의 MQ(ScrapQueue)로 publish 처리
   5. 가상의 MQ(ScrapQueue) subscribe로 메시지 조회해서 thread로 external Scrap API로 실제 조회 요청
   6. external Scrap API 조회 실패시 실패 데이터 MemberScrap entity 에 저장
   7. external Scrap API 조회 성공시 JsonPath를 이용하여 급여, 산출세액 조회 하여 성공 데이터 MemberScrap entity 에 저장
   8. Test case 구현
      1. controller
         1. success_login_member_scrap
         2. fail_login_member_scrap
      2. service
         1. success_member_tax_scrap
         2. fail_member_tax_scrap_not_found_userid
         3. fail_member_tax_scrap_publish_queue_error
      3. repository
         1. success_member_tax_save
5. 유저의 환급액 계산 :  [POST] http://localhost:8080/szs/refund -header "Authorization: Bearer JwtToken"
   1. MemberScrapController 에 refund 메소드 생성 및 @RequestMapping 설정
   2. 사용자 정보 받아오는거는 3번 me 메소드와 동일
   3. 사용자 아이디를 이용하여 MemberScrap 정보 조회 
   4. MemberScrap 상태는 ACCEPT - scrap 요청 수락, PROGRESS - scrap 요청 처리 중, SUCCESS - scrap 요청 성공, FAIL - scrap  요청 실패 로 나뉜다. 
   5. ACCEPT와 PROGRESS 상태는 ACCEPTED_WAIT 응답을 처리한다. 
   6. FAIL 상태는 scrap api 를 다시요청해 달라는 응답 처리 
   7. SUCCESS 상태에서는 환급액 계산 
      1. TaxUtil 을 통해 TaxCreditLimit-세액공제한도, TaxCredit-세액공제액, Refund-환급액 을 계산한다. 
   8. MemberRefundResponse dto 생성 및 응답 
   9. Test case 구현
      1. controller
         1. success_login_member_tax_refund
         2. fail_login_member_tax_refund
      2. service
         1. success_member_tax_refund
         2. fail_member_tax_refund
      3. repository
         1. success_member_tax_findById
      4. TaxUtil
         1. success_tax_credit_limit_calculate
         2. success_tax_credit_calculate
         3. success_refund_calculate


주관식 과제
해당 과제는 정답이 있는 과제가 아닙니다. 본인이 생각하시는 바를 서술해 주시면 됩니다. 총 7 문항 중 최소 1문항 이상을 선택하여 서술해 주시면 됩니다.
1. 테스트코드 작성시 setup 해야 할 데이터가 대용량이라면 어떤 방식으로 테스트코드를 작성하실지 서술해 주세요.
2. 이벤트 드리븐 기반으로 서비스를 만들 때 이벤트를 구성하는 방식과 실패 처리하는 방식에 대해 서술해 주세요.
   > 이벤트 기반 서비스는 Event Producer(발행), Event Broker(중계), Event Subscriber(구독)로 구성되어 있습니다. 
   > 실패를 처리 하는 방식은 크게 롤백, 재시도로 나눠 집니다.
   > 재시도는 브로커로 부터 받아온 데이터를 실패처리하고 dead letter queue에 넣고 다시 불러와서 처리 하는 것이고
   > 롤백은 실패 이벤트를 새로 만들어 발행하고 실패처리 된 이벤트를 정상 수행한 서비스에서 실패 이벤트를 구독하여 정상 수행했던 이벤트를 특정데이터(로그) 기반으로 롤백을 처리합니다.
3. MSA 구성하는 방식에는 어떤 것들이 있고, 그중 선택하신다면 어떤 방식을 선택하실 건가요?
4. 외부 의존성이 높은 서비스를 만들 때 고려해야 할 사항이 무엇인지 서술해 주세요.
   > 외부 의존성이 높은 서비스를 만들어야 할때 고려해야될 사항은 외부시스템 안정성, 외부시스템 변경주기 으로 생각합니다.
   > 외부시스템 안정성은 외부시스템의 오류로 인하여 연계가 되지 않을 경우 사용자는 사용하고 있는 시스템의 오류로 판단하게 되어 해당 시스템의 신뢰도를 잃게 됩니다.
   > 그렇기에 외부시스템 상태 모니터링을 주기적으로 하여 해당 시스템에 대한 오류를 즉각 파악하고 해당 오류를 회피할 방안을 만들어 놔야 합니다.
   > 다음은 외부시스템 변경주기 입니다. 기존에 연동해 놓은 API가 있는데 해당 API가 변경될 가능성은 충분히 존재함으로 연계되는 외부시스템의 API 에 대해서 얼마나 자주 변경 되는지 체크 해야 합니다.
5. 제공되는 스크랩 URL의 문제점을 생각하셨나요? 어떤 방법으로 해결할 수 있을까요?
   > "제공되는 스크랩 URL은 요청에 따라 최대 1~ 20초까지 걸릴 수 있습니다." 이 부분이 문제점으로 보여집니다.
   > 이유는 요청 한번에 최대 20초 걸리기 때문에 해당 요청을 한 경우 최대 20 초 동안은 응답을 받을 때 까지 대기 해야됩니다.
   > 외부 Scrap API 이므로 해당 API는 변경하기는 어렵고 자체적으로 그나마 문제점을 해결 하기 위해서는
   > 내부사용자가 Scrap API 요청을 하면 우선 요청에 대한 응답을 처리해 주고, 나중에 요청이 마무리 되면 websocket을 통해 완료 되었다고 noti를 줌으로 써 브라우저 및 앱에서 해당 요청을 계속 잡고 있을 필요가 없도록 만들어야 될거 같습니다.
6. 일정이 촉박한 프로젝트를 진행하게 되었습니다. 이 경우 본인의 평소 습관에 맞춰 개발을 진행할 지, 회사의 코드 컨벤션에 맞춰 개발할 지 선택해 주세요. 그리고 그 이유를 서술해주세요.
   > 회사 코드 컨벤션에 맞춰서 개발해야 된다고 생각합니다.
   > 빠르게 개발 하고 나중에 리펙토링으로 다시 회사 코딩 스타일에 맞게 리팩토링 하면 되긴 하지만 그 리팩토링에 드는 시간과 비용이 처음부터 회사 코딩 스타일에 맞게  코딩하는 비용보다 많이 들기 때문입니다.
   > 또한 혹시나 변경 하지 않고 퇴사라도 하면 나중에 그 코드를 보는 사람은 새로운 방식으로 그 코드를 분석 해야 하기 때문에 분석 비용이 더 많이 들어가게됩니다. 그래서 저는 회사 코트 컨벤션에 맞게 코딩을 해야한다고 생각합니다.
   > 그리고 촉박한 일정이라도 해당 프로젝트 관리자 , 프로젝트의 클라이언트에게 요청시 몇일간의 딜레이는 충분히 수용가능 할 것이라고 생각하기 때문입니다.
7. 민감정보 암호화 알고리즘에는 어떤 것들이 있고, 그중 선택하신다면 어떤 것을 선택하실 건가요? 그 이유는 무엇인가요?
   > 암호화는 단반향 / 양방향 이 있고 양방향에는 대칭키/비대칭키 암호화가 있습니다.
   > 단방향에는 해시 알고리즘으로 sha-256, sha512, bcrypt 등이 있고, 대칭키 암호화로는 DES, AES, SEED 등이 있으며 비대칭 키는 대표적으로 RSA 가 있습니다.
   > 민감정보 중에 비밀번호는 복호화 되지 않도록 해야 하므로 해쉬 암호화(단방향) 을 이용해서 암호화 하고
   > 그 이외의 민감정보에 대해서는 복호화가 가능해도 되므로 대칭키 암호화 중 빠른 편에 속하는 AES 그중에서도 가장 강력한 AES-256 암호화로 처리 하겠습니다. 
