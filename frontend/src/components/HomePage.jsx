import { Link } from 'react-router-dom'

// Trang chủ CineMan — 2 lối vào chính
export default function HomePage() {
  return (
    <div className="container">
      <div className="home-hero">
        <h1>CINE<span>MAN</span></h1>
        <p>Hệ thống quản lí rạp chiếu phim — chọn chức năng bạn muốn sử dụng:</p>
      </div>
      <div className="home-cards">
        <Link className="home-card" to="/dang-ki-thanh-vien">
          <span className="icon">🎟️</span>
          <h2>Đăng kí thành viên</h2>
          <p>Dành cho khách hàng: nhập thông tin cá nhân để trở thành thành viên và nhận thẻ thành viên CineMan.</p>
        </Link>
        <Link className="home-card" to="/bao-cao">
          <span className="icon">📊</span>
          <h2>Báo cáo thống kê</h2>
          <p>Dành cho nhân viên quản lí: xem thống kê phim theo doanh thu, chi tiết suất chiếu và hóa đơn bán vé.</p>
        </Link>
      </div>
    </div>
  )
}
