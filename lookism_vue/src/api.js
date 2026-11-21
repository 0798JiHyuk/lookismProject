export async function request(path, options) {
  try {
    return await fetch(path, options)
  } catch {
    throw new Error('서버에 연결할 수 없습니다.')
  }
}

export async function submit(path, body) {
  const csrf = await request('/members/csrf', { cache: 'no-store' })
  if (!csrf.ok) throw new Error('요청 설정을 불러오지 못했습니다.')
  const { headerName, token } = await csrf.json()
  const headers = { [headerName]: token }
  if (body && !(body instanceof URLSearchParams)) {
    headers['Content-Type'] = 'application/json'
    body = JSON.stringify(body)
  }
  return request(path, { method: 'POST', headers, body })
}
