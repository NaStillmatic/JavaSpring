# JavaSpring

## Ch02. 개발환경 구성하기

### 00. 웹 프로젝트 환경 구성

#### 빌드 설정 셋팅
1. 'IntelliJ IDEA > Preferences > Build, Execution, Deployment > Build Tools > Gradle > Build And Run Using: IntelliJ IDEA 적용'
2. Project Structure('커맨드 + 세미콜론' 단축키) > Output Path 를 '프로젝트경로/webapps/WEB-INF/classes' 로 설정


### 01. 도커 및 도커 컴포즈 소개

...


### 02. 도커를 이용한 환경 구성하기

도커 설치   

...

MySQL 도커 이미지 다운로드 

```
docker pull mysql:{version}
```



#### MySQL 도커 컨테이너 생성 및 실행

```
docker run --name mysql-sample-container -e MYSQL_ROOT_PASSWORD=<password> -d -p 3306:3306 mysql: {version}
```

#### 현재 실행중인 도커 컨테이너 목록 출력
```
docker ps -a
```

#### MySQL 도커 컨테이너 접속

```
docker exec -if {도커 커테이너 이름} bash
```

#### My SQL 접속
``` 
mysql -u root - p
```
