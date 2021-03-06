<h1 align="center">Welcome to Yogiyo_test_Server_Swan ๐</h1>
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

### ๐ [API DOCUMENT](https://docs.google.com/spreadsheets/d/1s8GNufaq29cz1syn87m0NE5NpaMzJrwugm5NDU_7r5k/edit?usp=sharing)

## ๊ธฐ์ ์คํ

<p>
  <img src="https://img.shields.io/badge/-SpringBoot-blue"/>&nbsp
  <img src="https://img.shields.io/badge/-JPA-red"/>&nbsp
  <img src="https://img.shields.io/badge/-MySQL-yellow"/>&nbsp
  <img src="https://img.shields.io/badge/-JWT-blue"/>&nbsp
  <img src="https://img.shields.io/badge/-AWS-orange"/>&nbsp
  <img src="https://img.shields.io/badge/-Nginx-red"/>&nbsp
  <img src="https://img.shields.io/badge/-SpringSecurity-black"/>&nbsp
</p>

## ๊ฐ๋ฐํ๊ฒฝ

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


## ๊ฐ๋ฐ์ผ์ง

### 2021-07-31 ์งํ์ํฉ
- - -
- ์ด๊ธฐ ํ๋ก์ ํธ ์์ฑ ๋ฐ build.gradle ์ธํ
- EC2 ์๋ฒ ๊ตฌ์ถ ๋ฐ ๋ณด์ ๊ทธ๋ฃน ์ค์ 
- ERD ์ค๊ณ ์์

### 2021-08-01 ์งํ์ํฉ
- - -
- ๋ฐฐํฌ์ฉ RDS ์์ฑ
- ๋๋ฉ์ธ ๋ฐ ์๋ธ ๋๋ฉ์ธ ์์ฑ ํ ์๋ฒ ip์ ์ฐ๊ฒฐ
- nginx์์ ์๋ธ ๋๋ฉ์ธ ๋ถ๋ฆฌ(dev, prod)
- https ์ธ์ฆ ์ ์ฉ(main, dev, prod + ๋ฆฌ๋ค์ด๋ ํธ ์ค์ )
- [๋๋ฉ์ธ & ์๋ธ๋๋ฉ์ธ ๊ตฌ์, ์ค์ , https ์ธ์ฆ ๊ณผ์  Link](https://vividswan.github.io/2021/08/01/AWS+%EB%B0%B0%ED%8F%AC-Sub-Domain%EC%97%90-HTTPS-%EC%9D%B8%EC%A6%9D%EB%B0%9B%EA%B8%B0.html)
- ip ์ฃผ์๋ฅผ prod ๋๋ฉ์ธ์ผ๋ก ๋ฆฌ๋ค์ด๋ ์
- ์คํ๋ง ์ํ๋ฆฌํฐ ์ด๊ธฐ ์ค์ 
- JWT ์ค์  ๋ฐ JWT Provider, Filter ์์ฑ

### 2021-08-02 ์งํ์ํฉ
- - -
- [ERD](https://user-images.githubusercontent.com/54254402/129259180-1db87916-e437-4753-8bd7-19920fa15139.png)
- ๊ณตํต Reponse ์ฒ๋ฆฌ ๊ธฐ๋ฅ ์ถ๊ฐ
- ์์ธ์ฒ๋ฆฌ ๊ธฐ๋ฅ ์ถ๊ฐ ๋ฐ ์์ธ์ฒ๋ฆฌ ์ฝ๋ Enum ์์ฑ
- Spring Security๋ฅผ ์ฌ์ฉํ๋ Authentication ๊ธฐ๋ฅ ์ถ๊ฐ

### 2021-08-03 ์งํ์ํฉ
- - -
- ๋ก๊ทธ์ธ, ํ์๊ฐ์ API ๊ตฌํ
- ํ์์ , ์๋ฏธ์  Validation ์ถ๊ฐ ๋ฐ ๊ณ ๋ํ
- JWT Authentication ๊ด๋ จ Validation ์ถ๊ฐ
- Event ์กฐํ API ์ถ๊ฐ
- Restaurant API ๊ตฌํ
  - ํน์  ์กฐ๊ฑด์ผ๋ก ๊ฐ๊ฒ ๋ฆฌ์คํธ ์กฐํ API
  - ํ์ด์ง ๋ ์ ์ฒด ๊ฐ๊ฒ ์กฐํ API
  - ๊ฐ๊ฒ ์ธ๋ถ ๋ด์ฉ ์กฐํ API
- ๊ฐ๊ฒ ๊ด๋ จ ํ์คํธ ๋ฐ์ดํฐ ์์ฑ
- ERD : Event Table ์ถ๊ฐ

### 2021-08-04 ์งํ์ํฉ
- - -
- ๊ฐ๊ฒ ์์ธ ์ ๋ณด API ํธ์ถ ์ ๊ฐ๊ฒ์ ๋ฉ๋ด๋ ๊ฐ์ด ์กฐํํ  ์ ์๋๋ก ๊ธฐ๋ฅ ์ถ๊ฐ
- ์๋ฃ ์์ฒญ ์ Status๋ฅผ ํ์ธํ๋ ์ฝ๋๋ฅผ ์ถ๊ฐํ์ฌ ์ ํจํ ์๋ฃ๋ค๋ง ๋ณด๋ผ ์ ์๋๋ก ๊ธฐ๋ฅ ์ถ๊ฐ
- ๋ฉ๋ด ์์ธ ์กฐํ API ๊ตฌํ
- ์ฃผ๋ฌธ ์์ฑ API ๊ตฌํ
- ์ค๋ฅ ์์ 
  - ์๋ชป๋ ๋ณ์๋ช
  - JWT ํ ํฐ ์ ํจ์๊ฐ
  - application-key ๊ด๋ จ ์ฝ๋
  - ์ฃผ๋ฌธ ์ถ๊ฐ ์ค๋ฅ
- ERD : Event Table์ isAd(TINYINT) ์นผ๋ผ ์ถ๊ฐ

### 2021-08-05 ์งํ์ํฉ
- - -
- ์งํ ์ค์ธ ์ฃผ๋ฌธ ์กฐํ API ๊ตฌํ
- Account ๊ด๋ จ ์ธ์ฆ ๋ฆฌํฉํฐ๋ง (UserDetails๋ก Account ํธ์ถ)
- ์งํ ์ค์ธ ์ฃผ๋ฌธ ์กฐํ API ์ฃผ๋ฌธ ๋ฉ๋ด ์ต์ ํ์ ์์ 
- ERD ๋ณด์ ๋ฐ ์์ 

### 2021-08-06 ์งํ์ํฉ
- - -
- ์งํ ์ค์ธ ์ฃผ๋ฌธ์ ์ฃผ๋ฌธ์ฒ๋ฆฌํ๋ API ์์ฑ
- ์ฃผ๋ฌธ ์๋ฃ Entity ๋ฐ ๊ด๋ จ ๋ฉ์๋์ ์ฃผ๋ฌธ ์ฌ์ฉ์ ์ ํ๋ฒํธ, ์ฃผ์ ์ถ๊ฐ
- Exception Status ์์  ๋ฐ ๋ณด์
- Feat ๋ก๊ทธ์ธ ํ ์ ์ ์ ์๋ฃ๋ ์ฃผ๋ฌธ๋ค ์กฐํ API ์์ฑ
- ERD : CompleteOrders Table์ accountPhoneNumber(VARCHAR(45)), accountAddress(VARCHAR(45)) ์ถ๊ฐ

### 2021-08-07 ์งํ์ํฉ
- - -
- ์ ์ฒด ์นดํ๊ณ ๋ฆฌ, ๋ฉ๋ด ์นดํ๊ณ ๋ฆฌ ์กฐํ API ์์ฑ
- Enum Type์ ๊ด๋ จ๋ ์ค๋ฅ ์์ 
- ์นดํ๊ณ ๋ฆฌ๋ก ๊ฐ๊ฒ ๋ฆฌ์คํธ ์กฐํ, ๋ฉ๋ด ๋ฆฌ์คํธ ์กฐํ API ์์ฑ
- ERD : Category Table์ isFood(TINYINT) ์ถ๊ฐ

### 2021-08-08 ์งํ์ํฉ
- - -
- ๋ฆฌ๋ทฐ ์์ฑ API ์์ฑ
- ๋ฆฌ๋ทฐ ๋๊ธ ์์ฑ API ์์ฑ
- ๋๋๊ธ ์์ฑ API ์์ฑ
- ์์ค ์ฝ๋ ๋ณด์
  - JPA @OneToOne fetch ๋ฐฉ์ ๋ณ๊ฒฝ
  - ๋ฆฌ๋ทฐ ์์ฑ API ํธ์ถ URI, ํธ์ถ ๋ฐฉ์ ๋ณ๊ฒฝ
  - ๋ฆฌ๋ทฐ ๊ฐ๊ฒ์ ์ฌ์ฅ๋์ด ์๋ ๋ ๋ฆฌ๋ทฐ ๋๊ธ ์์ฑ ์ Exception ์ฒ๋ฆฌ


### 2021-08-09 ์งํ์ํฉ
- - -
- ๊ฐ๊ฒ ๋ฆฌ๋ทฐ ์กฐํ API ์์ฑ
- ๋ฆฌ๋ทฐ ์กฐํ API ๊ณ ๋ํ
  - ํด์ํ๊ทธ์ฉ ์์ ์ด๋ฆ ๋ฆฌ์คํธ ์ถ๊ฐ
  - ์ ์ฒด ์ด๋ฏธ์ง ๋ฆฌ์คํธ ์ถ๊ฐ
- ๊ฐ๊ฒ ์ธ๋ถ ์กฐํ API ๊ณ ๋ํ
  - ๋ก๊ทธ์ธํ ์ํ์์ ๊ฐ๊ฒ ์ธ๋ถ ์กฐํ๋ฅผ ํ๋ฉด ๊ณ์ ์ ์ฐ ์ฌ๋ถ ๋ฐ์ดํฐ๋ฅผ ์ ์ก
- ์ธ์ฆ๋ ๊ณ์ ์์ ๊ฐ๊ฒ ์ข์์ ์ถ๊ฐ or ์ทจ์ ๊ธฐ๋ฅ API ์์ฑ

### 2021-08-10 ์งํ์ํฉ
- - -
- Account Table ๋ฐ ๊ด๋ จ Entity ์์ 
- ์นด์นด์ค OAuth ๋ก๊ทธ์ธ ๊ธฐ๋ฅ ์์ฑ
  - JSON Parser ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ถ๊ฐ
  - ์ฝ๋ฐฑ URL๋ก ์ธ๊ฐํ ํฐ์ด ์ ๋ฌ๋ ํ ์นด์นด์ค ๋ก๊ทธ์ธ์ด ๋๋ ๊ธฐ๋ฅ
- ERD : Account Table์ KakaoId(BIGINT) ์นผ๋ผ ์ถ๊ฐ

### 2021-08-11 ์งํ์ํฉ
- - -
- ๊ณ์  SMS ์ธ์ฆ ๊ด๋ จ ๋ผ์ด๋ธ๋ฌ๋ฆฌ, ์์ธ Status Enum ์ถ๊ฐ
- SMS ์ ๋ฌ ์๋น์ค์ ํ๋ก์ ํธ ์ฐ๊ฒฐ
- SMS ์ธ์ฆ ํ ํฐ ์์ฑ API ์์ฑ
- ํ ํฐ์ผ๋ก ํด๋น ๊ณ์  SMS ์ธ์ฆ ์ฒ๋ฆฌ API ์์ฑ
- ERD : Account Table์ smsAuthToken(INTEGER), isSmsCertified(TINYINT) ์นผ๋ผ ์ถ๊ฐ

### 2021-08-12 ์งํ์ํฉ
- - -
- Naver Direction 5 API ์๋ฒ์ ์ ์ฉ (๋ ์ขํ๊ฐ์ ์ต์ ๊ฑฐ๋ฆฌ)
- Naver geocoding API ์๋ฒ์ ์ ์ฉ (์ฃผ์์ ๋ํ ์ขํ ์ถ๋ ฅ)
- ์ขํ๋ฅผ ์ฐพ๋ ๊ณผ์ ์์ ์ ํจํ ์ฃผ์๊ฐ ์๋ ๋ Exception์ ๋ํ ์ฒ๋ฆฌ
- ์ขํ ์ถ๋ ฅ API, ๋ก๊ทธ์ธ ํ ์ฌ์ฉ์์ ๊ฐ๊ฒ์ ๊ฑฐ๋ฆฌ ์ถ๋ ฅ API ์์ฑ

### 2021-08-12 ์งํ์ํฉ
- - -
- ์ธ์ฆ์ด ํ์ํ ์ปจํธ๋กค๋ฌ ๋ฉ์๋ URL ๋ณ๊ฒฝ
- ์ฃผ๋ฌธ ์์ฑ ์ค๋ฅ ํด๊ฒฐ(DTO ์์ฑ์ ์ฌ์ฉ)
- README์ ERD ์ต์ ํ

## Author

๐ค **vividswan**

* Website: vividswan.github.io
* Github: [@vividswan](https://github.com/vividswan)

## ๐ค Contributing

Contributions, issues and feature requests are welcome!<br />Feel free to check [issues page](https://github.com/mock-rc1/Yogiyo_test_Server_Swan/issues). 

## Show your support

Give a โญ๏ธ if this project helped you!

***
_This README was generated with โค๏ธ by [readme-md-generator](https://github.com/kefranabg/readme-md-generator)_
