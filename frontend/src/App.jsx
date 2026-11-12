import { Routes, Route, Link, Navigate, useNavigate } from 'react-router-dom'
import HomePage from './components/HomePage'
import GdMemberRegistration1 from './components/GdMemberRegistration1'
import GdLogin1 from './components/GdLogin1'
import GdReport1 from './components/GdReport1'
import GdMovieStatistics1 from './components/GdMovieStatistics1'
import GdMovieDetail1 from './components/GdMovieDetail1'
import GdShowtimeDetail1 from './components/GdShowtimeDetail1'
import { getToken, clearAuth } from './api'

// Bảo vệ route: chưa có token đăng nhập thì chuyển về /dang-nhap
function RequireAuth({ children }) {
  if (!getToken()) return <Navigate to="/dang-nhap" replace />
  return children
}

function TopBar() {
  const navigate = useNavigate()
  const userRaw = localStorage.getItem('cineman_user')
  const user = userRaw ? JSON.parse(userRaw) : null
  const loggedIn = !!getToken()

  function handleLogout() {
    clearAuth()
    navigate('/')
  }

  return (
    <header className="topbar">
      <Link className="logo" to="/">CINE<span>MAN</span></Link>
      <div className="user-info">
        {loggedIn && user ? (
          <>
            <span>Xin chào, <strong>{user.fullName}</strong> ({user.role})</span>
            <button className="btn btn-ghost" onClick={handleLogout}>Đăng xuất</button>
          </>
        ) : (
          <Link to="/dang-nhap">Đăng nhập nhân viên</Link>
        )}
      </div>
    </header>
  )
}

export default function App() {
  return (
    <>
      <TopBar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/dang-ki-thanh-vien" element={<GdMemberRegistration1 />} />
        <Route path="/dang-nhap" element={<GdLogin1 />} />
        <Route
          path="/bao-cao"
          element={<RequireAuth><GdReport1 /></RequireAuth>}
        />
        <Route
          path="/bao-cao/thong-ke-phim"
          element={<RequireAuth><GdMovieStatistics1 /></RequireAuth>}
        />
        <Route
          path="/bao-cao/thong-ke-phim/:movieId"
          element={<RequireAuth><GdMovieDetail1 /></RequireAuth>}
        />
        <Route
          path="/bao-cao/suat-chieu/:showtimeId"
          element={<RequireAuth><GdShowtimeDetail1 /></RequireAuth>}
        />
        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </>
  )
}
