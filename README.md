# Java/Spring


## Part 1. 나만의 MVC 프래임워크 만들기

### Ch01. 강의 소개

...

### Ch02. 개발환경 구성하기


#### 00. 웹 프로젝트 환경 구성

##### 빌드 설정 셋팅
1. 'IntelliJ IDEA > Preferences > Build, Execution, Deployment > Build Tools > Gradle > Build And Run Using: IntelliJ IDEA 적용'
2. Project Structure('커맨드 + 세미콜론' 단축키) > Output Path 를 '프로젝트경로/webapps/WEB-INF/classes' 로 설정

- 프로젝트: [mvc-practice](part_01/mvc-practice) 


#### 01. 도커 및 도커 컴포즈 소개

...


#### 02. 도커를 이용한 환경 구성하기

도커 설치   

...

MySQL 도커 이미지 다운로드 

```
docker pull mysql:{version}
```



##### MySQL 도커 컨테이너 생성 및 실행

```
docker run --name mysql-sample-container -e MYSQL_ROOT_PASSWORD=<password> -d -p 3306:3306 mysql: {version}
```

##### 현재 실행중인 도커 컨테이너 목록 출력
```
docker ps -a
```

##### MySQL 도커 컨테이너 접속

```
docker exec -it {도커 커테이너 이름} bash
```

##### My SQL 접속
``` 
mysql -u root - p
```

### Ch03. 객체지향 패러다임


#### 01. 테스트코드 실습

- 프로젝트: [oop-practice](part_01/oop-practice) 

#### 02. 객체지향 개념 다지기

- Package: password

#### 03. 객체지향 프로그래밍 실슴 - 사칙연산 계산기

- Package: calculate 

#### 04. 객체지향 프로그래밍 실슴 - 학점 계산기

- Package: grade 

#### 05. 객체지향 프로그램 실슴 - 음식점에서 음식 주문하는 과정

- Package: order


### Ch04. 웹 애플리케이션의 이해

#### 01. 개념다지기

...

#### 02~04. 계산기 웹 프로그램 구현하기 -Step 1, 2, 3

- 프로젝트: [was-practice](part_01/was-practice) 
- 강좌 calculator 파일 링크: https://github.com/serverwizard/was-practice/tree/master/src/main/java/org/example/calculator


#### 05. CGI 프로그램과 서블릿

- 강좌 calculator 파일 링크: https://github.com/serverwizard/servlet-practice/tree/master/src/main/java/org/example/calculator

- 프로젝트: [servlet-practice](part_01/servlet-practice) 

#### 06. 계산기 서블릿 만들기

- 프로젝트: [servlet-practice](part_01/servlet-practice) 



### Ch05. JDBC 프로그래밍

- 프로젝트: [jdbc-practice](part_01/jdbc-practice) 

#### 01. JDBC  개념 소개

#### 02. DB 커넥션 풀 개념 소개

#### 03. JDBC 프로그래밍 실슴

#### 04. 실습한 JDBC 코드 리팩토링 및 DB 커넥션 풀 적용



### Ch06. MVC 프레임워크 만들기

#### 01.리플랙션 API 개념 소개 및 실습

- 프로젝트: [mvc-framework-practice](part_01/mvc-framework-practice) 

#### 02. 프런트 컨트롤러 패턴 개념 소개


#### 03. 프런트 컨트롤러 패턴 실습

- 프로젝트: [mvc-framework-practice2](part_01/mvc-framework-practice2) 

#### 04. MVC 프레임워크 만들기 개념 소개

#### 05. MVC 프레임워크 만들기 실습

- 프로젝트: [mvc-framework-practice3](part_01/mvc-framework-practice3) 





### CH07. DI 프레임워크 만들기

- 프로젝트: [di-practice](part_01/di-practice)



### CH08. Spring Boot 코드 분석




## Part 2. 게시판 서비스





