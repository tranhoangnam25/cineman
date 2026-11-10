import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { getMovieStatistics1 } from '../api'
import { formatVND } from '../format'

// GdMovieStatistics1 — giao diện Thống kê phim theo doanh thu
export default function GdMovieStatistics1() {
  const navigate = useNavigate()
  const [startDate, setStartDate] = useState('2026-11-01')
  const [endDate, setEndDate] = useState('2026-11-10')
  const [dateError, setDateError] = useState('')
  const [error, setError] = useState('')
  const [result, setResult] = useState(null)
  const [loading, setLoading] = useState(false)

  async function handleView(e) {
    e.preventDefault()
    setDateError('')
    setError('')
    // Kiểm tra phía client: ngày kết thúc không được nhỏ hơn ngày bắt đầu
    if (endDate < startDate) {
      setDateError('Ngày kết thúc phải lớn hơn hoặc bằng ngày bắt đầu')
      return
    }
    setLoading(true)
    try {
      const data = await getMovieStatistics1(startDate, endDate)
      setResult(data)
    } catch (err) {
      if (err.status === 401) {
        navigate('/dang-nhap')
        return
      }
      setError(err.message || 'Không tải được dữ liệu thống kê.')
    } finally {
      setLoading(false)
    }
  }

  const items = result?.items || result?.danhSach || []

  return (
    <div className="container">
      <button className="btn btn-ghost btn-back" onClick={() => navigate('/bao-cao')}>‹ Quay lại Báo cáo</button>
      <h1 className="page-title">Thống kê phim theo doanh thu</h1>
      <p className="page-subtitle">Chọn khoảng ngày để xem doanh thu và số vé đã bán của từng phim. Click vào một phim để xem chi tiết các suất chiếu.</p>

      <form className="panel filter-panel" onSubmit={handleView}>
        <div className="form-row">
          <div className="form-group">
            <label htmlFor="startDate">Ngày bắt đầu</label>
            <input id="startDate" type="date" value={startDate} onChange={(e) => setStartDate(e.target.value)} />
          </div>
          <div className="form-group">
            <label htmlFor="endDate">Ngày kết thúc</label>
            <input id="endDate" type="date" value={endDate} onChange={(e) => setEndDate(e.target.value)} />
            {dateError && <div className="field-error">{dateError}</div>}
          </div>
        </div>
        <button className="btn btn-gold" type="submit" disabled={loading}>
          {loading ? 'Đang tải…' : 'Xem thống kê'}
        </button>
      </form>

      {error && <div className="alert alert-error">{error}</div>}

      {result && (
        <table className="data-table">
          <thead>
            <tr>
              <th className="center" style={{ width: 56 }}>TT</th>
              <th>Tên phim</th>
              <th className="num">Số vé đã bán</th>
              <th className="num">Doanh thu</th>
            </tr>
          </thead>
          <tbody>
            {items.length === 0 ? (
              <tr>
                <td colSpan={4} className="empty-note">Không có dữ liệu thống kê trong khoảng thời gian này</td>
              </tr>
            ) : (
              items.map((item, idx) => (
                <tr
                  key={item.movieId}
                  className="clickable"
                  title="Xem chi tiết các suất chiếu của phim"
                  onClick={() => navigate(`/bao-cao/thong-ke-phim/${item.movieId}?startDate=${startDate}&endDate=${endDate}`)}
                >
                  <td className="center">{idx + 1}</td>
                  <td>{item.tenMovie1}</td>
                  <td className="num">{item.soVeDaBan}</td>
                  <td className="num">{formatVND(item.doanhThu)}</td>
                </tr>
              ))
            )}
          </tbody>
          {items.length > 0 && (
            <tfoot>
              <tr>
                <td colSpan={2}>Tổng cộng</td>
                <td className="num">{result.tongSoVe}</td>
                <td className="num">{formatVND(result.tongDoanhThu)}</td>
              </tr>
            </tfoot>
          )}
        </table>
      )}
    </div>
  )
}
