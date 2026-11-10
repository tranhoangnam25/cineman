// Lớp gọi API CineMan.
// Dev: base '' + proxy Vite ('/api' -> http://localhost:8080) nên không vướng CORS.
// Backend chạy tại http://localhost:8080.
const API_BASE = ''

export function getToken() {
  return localStorage.getItem('cineman_token')
}

export function saveAuth(data) {
  localStorage.setItem('cineman_token', data.token)
  localStorage.setItem('cineman_user', JSON.stringify({ hoTen: data.hoTen, vaiTro: data.vaiTro }))
}

export function clearAuth() {
  localStorage.removeItem('cineman_token')
  localStorage.removeItem('cineman_user')
}

async function request(path, { method = 'GET', body, auth = false } = {}) {
  const headers = { 'Content-Type': 'application/json' }
  if (auth) {
    const token = getToken()
    if (token) headers['Authorization'] = `Bearer ${token}`
  }
  const res = await fetch(API_BASE + path, {
    method,
    headers,
    body: body !== undefined ? JSON.stringify(body) : undefined,
  })
  let data = null
  const text = await res.text()
  if (text) {
    try { data = JSON.parse(text) } catch { data = { message: text } }
  }
  if (!res.ok) {
    const err = new Error((data && (data.message || data.error)) || `Lỗi ${res.status}`)
    err.status = res.status
    err.data = data
    throw err
  }
  return data
}

// POST /api/auth/login1 {tenDangNhap, matKhau} -> {token, hoTen, vaiTro}
export function login1(tenDangNhap, matKhau) {
  return request('/api/auth/login1', { method: 'POST', body: { tenDangNhap, matKhau } })
}

// POST /api/members/register1 -> 201 + thông tin thành viên & thẻ
export function registerMember1(payload) {
  return request('/api/members/register1', { method: 'POST', body: payload })
}

// GET /api/statistics/movies1?startDate&endDate (cần token)
export function getMovieStatistics1(startDate, endDate) {
  return request(`/api/statistics/movies1?startDate=${startDate}&endDate=${endDate}`, { auth: true })
}

// GET /api/statistics/movies1/{movieId}/showtimes1?startDate&endDate
export function getMovieShowtimes1(movieId, startDate, endDate) {
  return request(`/api/statistics/movies1/${movieId}/showtimes1?startDate=${startDate}&endDate=${endDate}`, { auth: true })
}

// GET /api/statistics/showtimes1/{showtimeId}/invoices1
export function getShowtimeInvoices1(showtimeId) {
  return request(`/api/statistics/showtimes1/${showtimeId}/invoices1`, { auth: true })
}
