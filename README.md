# lookismProject

Spring Boot + Vue based Lookism project.

## This Update
- Renamed member view files to `Login.vue`, `Enroll.vue` and fixed router imports.
- Added email verification UI and signup API call flow in `Enroll.vue`.
- Updated signup API to accept `MemberVo` and map it into `Member`.
- Added `/members/email` endpoint for duplicate email check and verification-mail send.
- Added `getMember(email)` in `MemberService`.
- Improved `userEnrolldate` mapping in `Member` entity.
- Added `SecurityFilterChain` config (CSRF off, allow all for test scope).
- Added dependencies: `spring-boot-starter-mail`, `spring-boot-starter-actuator`.
- Added frontend build outputs under `src/main/resources/static/js`.

## Security Update
- Replaced sensitive values in `application.properties` with environment variables:
  - `spring.mail.username=${MAIL_USERNAME}`
  - `spring.mail.password=${MAIL_PASSWORD}`
  - `jwt.secret=${JWT_SECRET:mySecretKey}`

## Run
### Backend
1. Prepare Java 17+ and Gradle.
2. Set environment variables:
   - `MAIL_USERNAME`
   - `MAIL_PASSWORD`
   - `JWT_SECRET` (optional)
3. Run:
   - `./gradlew bootRun`

### Frontend
1. In `lookism_vue`:
   - `npm install`
2. Run:
   - `npm run serve`

## Main Changed Files
- `build.gradle`
- `lookism_vue/src/router/index.js`
- `lookism_vue/src/views/member/Enroll.vue`
- `lookism_vue/src/views/member/Login.vue`
- `src/main/java/org/ict/lookism/LookismApplication.java`
- `src/main/java/org/ict/lookism/config/SecurityConfig.java`
- `src/main/java/org/ict/lookism/member/controller/MemberController.java`
- `src/main/java/org/ict/lookism/member/entity/Member.java`
- `src/main/java/org/ict/lookism/member/service/MemberService.java`
- `src/main/resources/application.properties`
- `src/main/resources/static/js/*`
