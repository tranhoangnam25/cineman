import { Link } from 'react-router-dom'

// GdReport1 — giao diện menu Báo cáo (nhân viên quản lí)
export default function GdReport1() {
  return (
    <div className="container">
      <h1 className="page-title">Báo cáo thống kê</h1>
      <p className="page-subtitle">Chọn loại thống kê cần xem.</p>

      <div className="report-menu">
        <Link className="report-item available" to="/bao-cao/thong-ke-phim">
          <span className="icon">🎬</span>
          <div>
            <h3>Thống kê phim theo doanh thu</h3>
            <p>Xem doanh thu và số vé đã bán của từng phim trong một khoảng ngày, drill-down xuống suất chiếu và hóa đơn.</p>
          </div>
          <span className="badge-go">›</span>
        </Link>

        <div className="report-item disabled" aria-disabled="true">
          <span className="icon">👥</span>
          <div>
            <h3>Thống kê khách hàng</h3>
            <p>Thống kê số lượng và tình hình khách hàng, thành viên của rạp.</p>
          </div>
          <span className="badge-soon">Chưa triển khai</span>
        </div>

        <div className="report-item disabled" aria-disabled="true">
          <span className="icon">💰</span>
          <div>
            <h3>Thống kê doanh thu</h3>
            <p>Thống kê tổng doanh thu bán vé của rạp theo thời gian.</p>
          </div>
          <span className="badge-soon">Chưa triển khai</span>
        </div>
      </div>
    </div>
  )
}
