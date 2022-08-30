package com.example.yogiyo;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test03 {

    public static void main(String[] args) {

//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
//        System.out.println(LocalDateTime.now(ZoneOffset.UTC).format(format));
//        System.out.println(ZonedDateTime.now(ZoneOffset.UTC).format(format));
//        String tmp = ZonedDateTime.now(ZoneOffset.UTC).format(format).toString();

        String format = "asdf" ;
//        switch (format) {
//            case
//        }

        HealthCheckResponseDto tmpn = new HealthCheckResponseDto();

    }

    public static class HealthCheckResponseDto {
        private String status;
        private String currentTime;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }
    }

}


