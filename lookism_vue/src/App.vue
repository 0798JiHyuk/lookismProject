<template>
  <div class="shell">
    <header class="site-header">
      <RouterLink to="/" class="brand"><span class="brand-mark" aria-hidden="true">L</span>Lookism</RouterLink>
      <nav aria-label="회원 메뉴">
        <RouterLink to="/">로그인</RouterLink>
        <RouterLink to="/signup">회원가입</RouterLink>
        <RouterLink to="/board">게시판</RouterLink>
        <RouterLink to="/discovery">회원 탐색</RouterLink>
      </nav>
    </header>
    <main id="main">
      <RouterView />
    </main>
  </div>
</template>

<style>
:root {
  font-family: system-ui, "Malgun Gothic", sans-serif;
  color: #201b27;
  background: #f6f4f8;
  --primary: #55328c;
  --muted: #5e5669;
  --border: #d3cbdc;
  --tint: #f1ebf8;
}
* { box-sizing: border-box; }
body { margin: 0; }
.shell { max-width: 72rem; margin: auto; padding: 0 clamp(1rem, 4vw, 3rem); }
.site-header { min-height: 4.75rem; display: flex; align-items: center; justify-content: space-between; gap: .75rem; border-bottom: 1px solid var(--border); }
.brand, nav { display: flex; align-items: center; gap: .55rem; }
.brand { color: inherit; font-size: 1.3rem; font-weight: 780; letter-spacing: -.035em; text-decoration: none; }
.brand-mark { display: grid; place-items: center; width: 2rem; height: 2rem; border-radius: .65rem; background: var(--primary); color: #fff; }
nav { gap: .15rem; }
nav a { display: grid; place-items: center; min-height: 2.75rem; padding: .45rem .7rem; border-radius: .55rem; font-size: .875rem; font-weight: 650; text-decoration: none; white-space: nowrap; }
nav a.router-link-exact-active, nav a:hover { background: var(--tint); }
a { color: var(--primary); }
main { padding: clamp(1.25rem, 5vw, 4rem) 0 3rem; }
.member-card { width: min(100%, 31rem); margin: auto; padding: clamp(1.25rem, 5vw, 2.5rem); background: #fff; border: 1px solid var(--border); border-radius: 1.25rem; box-shadow: 0 14px 40px #26133c0c; }
.member-card--wide { width: min(100%, 39rem); }
h1 { margin: 0 0 .5rem; font-size: clamp(1.65rem, 5vw, 2.15rem); letter-spacing: -.05em; overflow-wrap: anywhere; }
.intro, .form-footer, .hint { color: var(--muted); line-height: 1.55; }
.intro { margin: 0 0 1.5rem; overflow-wrap: anywhere; }
.form-footer { margin: 1.25rem 0 0; text-align: center; }
.form-grid, .field, .details-grid label { display: grid; gap: .5rem; min-width: 0; }
.form-grid { gap: 1rem; }
.field label { font-size: .925rem; font-weight: 650; }
.hint { margin: 0; font-size: .8rem; }
input, textarea, button, .button { font: inherit; }
input, textarea { min-width: 0; width: 100%; min-height: 2.85rem; padding: .65rem .75rem; border: 1px solid #a59aaf; border-radius: .6rem; color: inherit; background: #fff; }
textarea { min-height: 5rem; resize: vertical; }
button, .button { display: inline-grid; place-items: center; min-height: 2.85rem; padding: .65rem .9rem; border: 1px solid transparent; border-radius: .6rem; background: var(--primary); color: white; font-weight: 650; text-decoration: none; cursor: pointer; }
button:hover:not(:disabled), .button:hover { background: #43246f; }
button:disabled { opacity: .62; cursor: default; }
button.secondary { background: var(--tint); color: var(--primary); border-color: var(--border); white-space: nowrap; }
button.secondary:hover:not(:disabled) { background: #e7dcf3; }
.inline-control { display: grid; grid-template-columns: minmax(0, 1fr) auto; align-items: stretch; gap: .5rem; }
.notice { border-radius: .6rem; padding: .65rem .8rem; background: var(--tint); color: #48306a; font-size: .9rem; line-height: 1.5; }
.notice:empty { display: none; }
.notice-error { background: #fcebef; color: #8b2340; }
.details { border: 1px solid var(--border); border-radius: .65rem; padding: .15rem .8rem; }
.details summary { padding: .65rem 0; font-weight: 650; cursor: pointer; }
.details-grid { display: grid; grid-template-columns: repeat(2, minmax(0, 1fr)); gap: .85rem; padding: .35rem 0 .85rem; }
.full { grid-column: 1 / -1; }
.profile-email { overflow-wrap: anywhere; }
.feature-card { width: min(100%, 46rem); }
.feature-card form, .entry-list { margin-top: 1.25rem; }
.entry-list { display: grid; gap: .85rem; padding: 0; list-style: none; }
.entry { padding: 1rem; border: 1px solid var(--border); border-radius: .75rem; overflow-wrap: anywhere; }
.entry h2 { margin: 0 0 .4rem; font-size: 1.1rem; }
.entry p { white-space: pre-wrap; line-height: 1.55; }
.action-row { display: flex; gap: .5rem; align-items: center; flex-wrap: wrap; }
.check-label { display: flex; align-items: center; gap: .5rem; }
.check-label input { width: auto; min-height: auto; }
:focus-visible { outline: 3px solid #7950ae; outline-offset: 2px; }
@media (max-width: 440px) {
  .site-header { justify-content: center; min-height: 4rem; flex-wrap: wrap; padding: .65rem 0; }
  nav { justify-content: center; flex-wrap: wrap; }
  .details-grid, .email-control { grid-template-columns: minmax(0, 1fr); }
}
</style>
