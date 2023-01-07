# 오늘의 집 클론코딩 팀 프로젝트

<br><br>

## 프로젝트 정보

#### 1. 프로젝트 기간 : 2022.12~ 2023.01 (2주)

#### 2. Language : java, SQL

#### 3. Tools : Inteli j , MySQL Workbench, SpringBoot 2.7.5

#### 4. DataBase : MySQL<br>

#### 5. Environment : AWS(프리티어) EC2 Ubuntu 18.0.4, RDS, ROUTE53, S3

#### 6. Skill Set : JWT, Spring Security, JdbcTemplate, BeanValidation

#### 7. API 명세서 : https://docs.google.com/spreadsheets/d/1SXbu_G3MzdjnHe1dAhFsKCaYNRuAiPw_zs1ee79t3QU/edit?usp=sharing

#### 8. 프로젝트 링크 : https://prod.baliserver.shop

#### 9. ERD

![todayHouse_20230107_221457](https://user-images.githubusercontent.com/108322891/211152584-5707e4c4-396e-47c4-be72-33f7e20c01a0.png)

----
<br>

## 프로젝트 설명

컴공선배 라이징캠프를 수료하기 위한 마지막 과제, 2주간 팀 클론코딩 프로젝트로 '오늘의집' 어플리케이션을 배정받았습니다.<br>
'오늘의집' 은 이커머스 시스템으로, 오늘날 많은 자취생 및 인테리어와 집을 꾸미는데 관심이 있는 많은 사람들이 찾는 어플리케이션 입니다. <br>
짧은 시간이기에, 또 처음 본 팀원과 함께하는 첫 팀단위 프로젝트 이기에, 최대한 간소화하여 크게 게시글(집 소개) 와 상품 크게 두 파트로 구성하였습니다.<br>
기본적인 기능으로는, 게시글 작성 수정 조회 삭제, 그리고 회원가입 및 로그인기능, 상품 조회 및 리뷰작성 또 장바구니 추가와<br>
결제 (실제로 결제 API 를 구현하는데 제한이있어 그냥 상품 수량 조절로 결제 기능을 대체하였습니다.) 마지막으로 마이페이지를 구성으로 프로젝트를 진행하였습니다.
로그인을 할 시, JWT 를 발급받아 추후에 모든 요청에 JWT 를 RequestHeader에 첨부하여 보내주면, JWTFilter 로 권한을 확인하도록 하여 보안적인 부분을 구성하였습니다.

---

## API 설명

