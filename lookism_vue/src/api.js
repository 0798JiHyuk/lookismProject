export async function request(path, options) {
  try {
    return await fetch(path, options)
  } catch {
    throw new Error('서버에 연결할 수 없습니다.')
  }
}

export async function submit(path, body, method = 'POST') {
  const csrf = await request('/members/csrf', { cache: 'no-store' })
  if (!csrf.ok) throw new Error('요청 설정을 불러오지 못했습니다.')
  const { headerName, token } = await csrf.json()
  const headers = { [headerName]: token }
  if (body && !(body instanceof URLSearchParams)) {
    headers['Content-Type'] = 'application/json'
    body = JSON.stringify(body)
  }
  return request(path, { method, headers, body })
}

export async function memberRequest(path, method = 'GET', body) {
  const response = method === 'GET' ? await request(path) : await submit(path, body, method)
  if (response.status === 401) throw new Error('로그인 후 이용할 수 있습니다.')
  if (response.status === 403) throw new Error('이 작업을 할 권한이 없습니다.')
  if (response.status === 404) throw new Error('대상을 찾을 수 없습니다. 목록을 새로고침해 주세요.')
  if (response.status === 409) throw new Error('내용이 변경되었습니다. 다시 시도해 주세요.')
  if (!response.ok) throw new Error('요청을 처리하지 못했습니다. 입력 내용을 확인해 주세요.')
  return response.status === 204 ? null : response.json()
}
