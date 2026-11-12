import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { login1, saveAuth } from '../api'

// GdLogin1 — giao diện Đăng nhập (nhân viên)
export default function GdLogin1() {
  const navigate = useNavigate()
  const [username, setUsername] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [submitting, setSubmitting] = useState(false)

  async function handleSubmit(e) {
    e.preventDefault()
    setError('')
    setSubmitting(true)
    try {
      const data = await login1(username.trim(), password)
      saveAuth(data)
      navigate('/bao-cao')
    } catch (err) {
      if (err.status === 401) {
        setError('Tên đăng nhập hoặc mật khẩu không đúng.')
      } else {
        setError(err.message || 'Đăng nhập thất bại, vui lòng thử lại sau.')
      }
    } finally {
      setSubmitting(false)
    }
  }

  return (
    <div className="container">
      <h1 className="page-title">Đăng nhập</h1>
      <p className="page-subtitle">Dành cho nhân viên rạp CineMan. Sau khi đăng nhập, nhân viên quản lí có thể xem các báo cáo thống kê.</p>

      {error && <div className="alert alert-error">{error}</div>}

      <form className="panel" onSubmit={handleSubmit}>
        <div className="form-group">
          <label htmlFor="username">Tên đăng nhập<span className="required">(*)</span></label>
          <input
            id="username" type="text" value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Ví dụ: quanly" autoComplete="username"
          />
        </div>
        <div className="form-group">
          <label htmlFor="password">Mật khẩu<span className="required">(*)</span></label>
          <input
            id="password" type="password" value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Nhập mật khẩu" autoComplete="current-password"
          />
        </div>
        <button className="btn" type="submit" disabled={submitting}>
          {submitting ? 'Đang đăng nhập…' : 'Đăng nhập'}
        </button>
      </form>
    </div>
  )
}
