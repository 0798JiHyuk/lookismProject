<template>
  <main>
    <header>
      <RouterLink to="/" class="brand">Lookism</RouterLink>
      <nav aria-label="회원 메뉴">
        <RouterLink to="/">로그인</RouterLink>
        <RouterLink to="/signup">회원가입</RouterLink>
      </nav>
    </header>
    <RouterView />
  </main>
</template>

<style>
:root { font-family: system-ui, sans-serif; color: #261d29; background: #faf7fb; }
* { box-sizing: border-box; }
main { max-width: 38rem; margin: 2rem auto; padding: 0 1rem; }
header, nav, .email-row { display: flex; align-items: center; gap: .75rem; flex-wrap: wrap; }
header { justify-content: space-between; margin-bottom: 1rem; }
a { color: #623381; }
.brand { font-size: 1.5rem; font-weight: 750; text-decoration: none; }
section { background: white; border: 1px solid #e4d8eb; border-radius: 1rem; padding: clamp(1rem, 5vw, 2rem); }
h1 { margin: 0 0 1rem; }
form, label { display: grid; gap: .5rem; }
form { gap: 1rem; }
input, textarea, button { font: inherit; }
input, textarea { min-width: 0; width: 100%; padding: .65rem; border: 1px solid #84748b; border-radius: .45rem; }
button { padding: .65rem .85rem; border: 0; border-radius: .45rem; background: #623381; color: white; cursor: pointer; }
button:disabled { opacity: .6; cursor: default; }
.email-row label { flex: 1 1 14rem; }
.email-row { align-items: end; }
details > div { display: grid; gap: .75rem; margin-top: .75rem; }
:focus-visible { outline: 3px solid #713b9d; outline-offset: 3px; }
</style>
