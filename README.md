# Lookism · 회원 가입 및 매칭 서비스 개발 기록

Spring Boot와 Vue를 이용한 이상형 매칭 서비스 프로젝트의 일부 구현을 보관합니다. 현재 저장소에는 회원가입·로그인 화면, 회원 서비스, 이메일 관련 컨트롤러와 보안 설정이 있습니다.

## 기술적 구성
- Backend: Spring Boot, Spring Security, BCrypt
- Frontend: Vue 회원가입·로그인 화면
- 외부 연동: 이메일 발송 설정
- 경로: `src/main/java/org/ict/lookism/`, `lookism_vue/src/`

## 구현을 살펴볼 파일
| 파일 | 관심 지점 |
|---|---|
| member/service/MemberService.java | 비밀번호 해싱 및 로그인 검증 |
| member/controller/MemberController.java | 회원·이메일 요청 처리 |
| config/SecurityConfig.java | 보안 필터 및 비밀번호 인코더 |
| lookism_vue/src/views/member/Enroll.vue | 가입·이메일 UI |
| lookism_vue/src/views/member/Login.vue | 로그인 UI |

## 현재 실행 상태
현재 트리에는 Gradle Wrapper와 Vue의 package.json이 없고, MemberRepository·MemberVo·UnauthorizedException 등 참조 클래스도 누락되어 있습니다. 따라서 새로 clone한 상태에서 전체 빌드와 실행을 재현할 수 없습니다.

기존 README의 `./gradlew bootRun`, `npm run serve` 안내는 필요한 파일 복원 이후 검증해야 합니다.

## 복원 순서
1. 원본 프로젝트에서 누락된 소스·빌드 설정을 복원합니다.
2. DB 및 메일 환경 설정을 로컬 환경 변수로 구성합니다.
3. 서버 빌드 → 회원가입 → 로그인 → 이메일 확인 흐름을 검증합니다.
4. 매칭 기능은 실제 구현이 확인된 뒤 문서에 추가합니다.

## 개선 기록 및 한계
로그인 성공 시 비밀번호 해시를 콘솔에 출력하던 코드를 제거했습니다.
현재 SecurityConfig는 모든 요청을 허용하는 테스트 설정입니다. 인증·인가가 완성된 서비스로 제출하기 전에 보호 경로와 토큰 검증을 구현·검증해야 합니다.
