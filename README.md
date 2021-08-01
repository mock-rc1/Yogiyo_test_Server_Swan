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
