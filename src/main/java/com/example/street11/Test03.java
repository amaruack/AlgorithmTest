package com.example.street11;

public class Test03 {

    /*
    -- write your code in PostgreSQL 9.4
-- SELECT * FROM test_groups;

-- SELECT name,  FROM test_groups
-- LEFT JOIN (
--     SELECT group_name, count(id) FROM test_cases
--     GROUP BY group_name
-- ) as summery_cases ON test_groups.name = summery_cases.group_name;

SELECT test_groups.name, summery_cases.all_test_cases, passed_test_cases  FROM test_groups
LEFT JOIN (
    SELECT group_name, count(id) as all_test_cases,
        count(CASE WHEN status = 'OK' THEN 1 ELSE NULL END) as passed_test_cases
        FROM test_cases
    GROUP BY group_name
) as summery_cases ON test_groups.name = summery_cases.group_name
ORDER BY summery_cases.all_test_cases DESC, test_groups.name ASC

;
     */
}
