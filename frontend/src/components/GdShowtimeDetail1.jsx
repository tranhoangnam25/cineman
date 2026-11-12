import { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import { getShowtimeInvoices1 } from '../api'
import { formatVND, formatDateTime } from '../format'

// GdShowtimeDetail1 — giao diện Chi tiết suất chiếu: các hóa đơn bán vé của một suất chiếu
export default function GdShowtimeDetail1() {
  const { showtimeId } = useParams()
  const navigate = useNavigate()
  const [invoices, setInvoices] = useState(null)
  const [error, setError] = useState('')

  useEffect(() => {
    let cancelled = false
    async function load() {
      try {
        const data = await getShowtimeInvoices1(showtimeId)
        if (!cancelled) setInvoices(Array.isArray(data) ? data : [])
      } catch (err) {
        if (cancelled) return
        if (err.status === 401) {
          navigate('/dang-nhap')
          return
        }
        setError(err.message || 'Không tải được dữ liệu hóa đơn.')
      }
    }
    load()
    return () => { cancelled = true }
  }, [showtimeId, navigate])

  return (
    <div className="container">
      <button className="btn btn-ghost btn-back" onClick={() => navigate(-1)}>‹ Quay lại Chi tiết phim</button>

      <div className="detail-head">
        <h2>Chi tiết suất chiếu</h2>
        <p>Danh sách các hóa đơn bán vé của suất chiếu đã chọn.</p>
      </div>

      {error && <div className="alert alert-error">{error}</div>}
      {invoices === null && !error && <div className="loading">Đang tải dữ liệu…</div>}

      {invoices !== null && (
        <table className="data-table">
          <thead>
            <tr>
              <th className="center" style={{ width: 56 }}>TT</th>
              <th>Mã hóa đơn</th>
              <th>Ngày lập</th>
              <th>Khách hàng</th>
              <th className="num">Số vé</th>
              <th className="num">Tổng tiền</th>
            </tr>
          </thead>
          <tbody>
            {invoices.length === 0 ? (
              <tr>
                <td colSpan={6} className="empty-note">Suất chiếu chưa có hóa đơn bán vé nào</td>
              </tr>
            ) : (
              invoices.map((inv, idx) => (
                <tr key={inv.invoiceId}>
                  <td className="center">{idx + 1}</td>
                  <td>{inv.invoiceId}</td>
                  <td>{formatDateTime(inv.issuedAt)}</td>
                  <td>{inv.customerName || 'Khách vãng lai'}</td>
                  <td className="num">{inv.ticketCount}</td>
                  <td className="num">{formatVND(inv.totalAmount)}</td>
                </tr>
              ))
            )}
          </tbody>
        </table>
      )}
    </div>
  )
}
