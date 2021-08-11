<h1 align="center">Welcome to Yogiyo_test_Server_Swan 👋</h1>
<p>
  <img alt="Version" src="https://img.shields.io/badge/version-1.0.0-blue.svg?cacheSeconds=2592000" />
  <a href="https://github.com/kefranabg/readme-md-generator#readme" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="https://github.com/kefranabg/readme-md-generator/graphs/commit-activity" target="_blank">
    <img alt="Maintenance" src="https://img.shields.io/badge/Maintained%3F-yes-green.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/github/license/vividswan/Yogiyo_test_Server_Swan" />
  </a>
</p>

> Yogiyo Back-End Project

### 🏠 [Homepage](https://github.com/mock-rc1/Yogiyo_test_Server_Swan)

### ✨ [Demo](https://prod.yogiyo-backend.shop)

### 📘 [API DOCUMENT](https://docs.google.com/spreadsheets/d/1s8GNufaq29cz1syn87m0NE5NpaMzJrwugm5NDU_7r5k/edit?usp=sharing)

## 기술스택

<p>
  <img src="https://img.shields.io/badge/-SpringBoot-blue"/>&nbsp
  <img src="https://img.shields.io/badge/-JPA-red"/>&nbsp
  <img src="https://img.shields.io/badge/-MySQL-yellow"/>&nbsp
  <img src="https://img.shields.io/badge/-JWT-blue"/>&nbsp
  <img src="https://img.shields.io/badge/-AWS-orange"/>&nbsp
  <img src="https://img.shields.io/badge/-Nginx-red"/>&nbsp
  <img src="https://img.shields.io/badge/-SpringSecurity-black"/>&nbsp
</p>

## 개발환경

- backend
  - java11
  - gradle
  - spring-boot 2.5.3


## Usage

```sh
$ cd yogiyo
$ .gradlew clean build
```

### Access server side using following URL

```
https://prod.yogiyo-backend.shop
```

## ERD(v1)

![1](https://user-images.githubusercontent.com/54254402/127853971-cd688a19-347c-4fcb-bedd-f146e7646d53.png)


## 개발일지

### 2021-07-31 진행상황
- - -
- 초기 프로젝트 생성 및 build.gradle 세팅
- EC2 서버 구축 및 보안 그룹 설정
- ERD 설계 시작

### 2021-08-01 진행상황
- - -
- 배포용 RDS 생성
- 도메인 및 서브 도메인 생성 후 서버 ip와 연결
- nginx에서 서브 도메인 분리(dev, prod)
- https 인증 적용(main, dev, prod + 리다이렉트 설정)
- [도메인 & 서브도메인 구입, 설정, https 인증 과정 Link](https://vividswan.github.io/2021/08/01/AWS+%EB%B0%B0%ED%8F%AC-Sub-Domain%EC%97%90-HTTPS-%EC%9D%B8%EC%A6%9D%EB%B0%9B%EA%B8%B0.html)
- ip 주소를 prod 도메인으로 리다이렉션
- 스프링 시큐리티 초기 설정
- JWT 설정 및 JWT Provider, Filter 생성

### 2021-08-02 진행상황
- - -
- [ERD v1 완성](https://user-images.githubusercontent.com/54254402/127853971-cd688a19-347c-4fcb-bedd-f146e7646d53.png)
- 공통 Reponse 처리 기능 추가
- 예외처리 기능 추가 및 예외처리 코드 Enum 생성
- Spring Security를 사용하는 Authentication 기능 추가

### 2021-08-03 진행상황
- - -
- 로그인, 회원가입 API 구현
- 형식적, 의미적 Validation 추가 및 고도화
- JWT Authentication 관련 Validation 추가
- Event 조회 API 추가
- Restaurant API 구현
  - 특정 조건으로 가게 리스트 조회 API
  - 페이징 된 전체 가게 조회 API
  - 가게 세부 내용 조회 API
- 가게 관련 테스트 데이터 생성

### 2021-08-04 진행상황
- - -
- 가게 상세 정보 API 호출 시 가게의 메뉴도 같이 조회할 수 있도록 기능 추가
- 자료 요청 시 Status를 확인하는 코드를 추가하여 유효한 자료들만 보낼 수 있도록 기능 추가
- 메뉴 상세 조회 API 구현
- 주문 생성 API 구현
- 오류 수정
  - 잘못된 변수명
  - JWT 토큰 유효시간
  - application-key 관련 코드
  - 주문 추가 오류

### 2021-08-05 진행상황
- - -
- 진행 중인 주문 조회 API 구현
- Account 관련 인증 리팩터링 (UserDetails로 Account 호출)
- 진행 중인 주문 조회 API 주문 메뉴 옵션 표시 수정
- ERD 보완 및 수정

### 2021-08-06 진행상황
- - -
- 진행 중인 주문을 주문처리하는 API 완성
- 주문 완료 Entity 및 관련 메서드에 주문 사용자 전화번호, 주소 추가
- Exception Status 수정 및 보안
- Feat 로그인 한 유저의 완료된 주문들 조회 API 완성

### 2021-08-07 진행상황
- - -
- 전체 카테고리, 메뉴 카테고리 조회 API 완성
- Enum Type에 관련된 오류 수정
- 카테고리로 가게 리스트 조회, 메뉴 리스트 조회 API 완성
- API 문서 최신화

### 2021-08-08 진행상황
- - -
- 리뷰 생성 API 완성
- 리뷰 댓글 작성 API 완성
- 대댓글 생성 API 완성
- 소스 코드 보완
  - JPA @OneToOne fetch 방식 변경
  - 리뷰 생성 API 호출 URI, 호출 방식 변경
  - 리뷰 가게의 사장님이 아닐 땐 리뷰 댓글 작성 시 Exception 처리


### 2021-08-09 진행상황
- - -
- 가게 리뷰 조회 API 완성
- 리뷰 조회 API 고도화
  - 해시태그용 음식 이름 리스트 추가
  - 전체 이미지 리스트 추가
- 가게 세부 조회 API 고도화
  - 로그인한 상태에서 가게 세부 조회를 하면 계정의 찜 여부 데이터를 전송
- 인증된 계정에서 가게 좋아요 추가 or 취소 기능 API 완성

### 2021-08-10 진행상황
- - -
- Account Table 및 관련 Entity 수정
- 카카오 OAuth 로그인 기능 완성
  - JSON Parser 라이브러리 추가
  - 콜백 URL로 인가토큰이 전달된 후 카카오 로그인이 되는 기능

### 2021-08-11 진행상황
- - -
- 계정 SMS 인증 관련 라이브러리, 예외 Status Enum 추가
- SMS 전달 서비스와 프로젝트 연결
- SMS 인증 토큰 생성 API 완성
- 토큰으로 해당 계정 SMS 인증 처리 API 완성

## Author

👤 **vividswan**

* Website: vividswan.github.io
* Github: [@vividswan](https://github.com/vividswan)

## 🤝 Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](https://github.com/mock-rc1/Yogiyo_test_Server_Swan/issues). 

## Show your support

Give a ⭐️ if this project helped you!

***
_This README was generated with ❤️ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_