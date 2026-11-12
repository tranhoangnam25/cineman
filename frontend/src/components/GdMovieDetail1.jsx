import { useEffect, useState } from 'react'
import { useNavigate, useParams, useSearchParams } from 'react-router-dom'
import { getMovieShowtimes1, getMovieStatistics1 } from '../api'
import { formatVND, formatDate, formatTime } from '../format'

// GdMovieDetail1 — giao diện Chi tiết phim: thống kê các suất chiếu của một phim
export default function GdMovieDetail1() {
  const { movieId } = useParams()
  const [searchParams] = useSearchParams()
  const navigate = useNavigate()
  const startDate = searchParams.get('startDate') || '2026-11-01'
  const endDate = searchParams.get('endDate') || '2026-11-10'

  const [movieName, setMovieName] = useState('')
  const [showtimes, setShowtimes] = useState(null)
  const [error, setError] = useState('')

  useEffect(() => {
    let cancelled = false
    async function load() {
      try {
        const [stats, sts] = await Promise.all([
          getMovieStatistics1(startDate, endDate).catch(() => null),
          getMovieShowtimes1(movieId, startDate, endDate),
        ])
        if (cancelled) return
        const found = (stats?.items || stats?.movies)?.find((i) => String(i.movieId) === String(movieId))
        if (found) setMovieName(found.movieName)
        setShowtimes(Array.isArray(sts) ? sts : [])
      } catch (err) {
        if (cancelled) return
        if (err.status === 401) {
          navigate('/dang-nhap')
          return
        }
        setError(err.message || 'Không tải được dữ liệu suất chiếu.')
      }
    }
    load()
    return () => { cancelled = true }
  }, [movieId, startDate, endDate, navigate])

  return (
    <div className="container">
      <button
        className="btn btn-ghost btn-back"
        onClick={() => navigate(`/bao-cao/thong-ke-phim`)}
      >
        ‹ Quay lại Thống kê phim
      </button>

      <div className="detail-head">
        <h2>{movieName || 'Chi tiết phim'}</h2>
        <p>Khoảng ngày thống kê: {formatDate(startDate)} — {formatDate(endDate)}. Click vào một suất chiếu để xem các hóa đơn bán vé.</p>
      </div>

      {error && <div className="alert alert-error">{error}</div>}
      {showtimes === null && !error && <div className="loading">Đang tải dữ liệu…</div>}

      {showtimes !== null && (
        <table className="data-table">
          <thead>
            <tr>
              <th className="center" style={{ width: 56 }}>TT</th>
              <th>Ngày chiếu</th>
              <th>Giờ bắt đầu</th>
              <th>Phòng chiếu</th>
              <th className="num">Số vé đã bán</th>
              <th className="num">Doanh thu</th>
            </tr>
          </thead>
          <tbody>
            {showtimes.length === 0 ? (
              <tr>
                <td colSpan={6} className="empty-note">Phim không có suất chiếu nào trong khoảng ngày đã chọn</td>
              </tr>
            ) : (
              showtimes.map((st, idx) => (
                <tr
                  key={st.showtimeId}
                  className="clickable"
                  title="Xem các hóa đơn bán vé của suất chiếu"
                  onClick={() => navigate(`/bao-cao/suat-chieu/${st.showtimeId}`)}
                >
                  <td className="center">{idx + 1}</td>
                  <td>{formatDate(st.showDate)}</td>
                  <td>{formatTime(st.startTime)}</td>
                  <td>{st.roomName}</td>
                  <td className="num">{st.ticketsSold}</td>
                  <td className="num">{formatVND(st.revenue)}</td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      )}
    </div>
  )
}
