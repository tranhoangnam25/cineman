import { useState } from 'react'
import { registerMember1 } from '../api'

// GdMemberRegistration1 — giao diện Đăng kí thành viên (khách hàng)
export default function GdMemberRegistration1() {
  const [form, setForm] = useState({
    hoTen: '',
    ngaySinh: '',
    gioiTinh: 'Nam',
    soDienThoai: '',
    email: '',
    diaChi: '',
  })
  const [errors, setErrors] = useState({})
  const [generalError, setGeneralError] = useState('')
  const [success, setSuccess] = useState(null)
  const [submitting, setSubmitting] = useState(false)

  const set = (field) => (e) => {
    setForm({ ...form, [field]: e.target.value })
    if (errors[field]) setErrors({ ...errors, [field]: undefined })
  }

  async function handleSubmit(e) {
    e.preventDefault()
    setErrors({})
    setGeneralError('')
    setSuccess(null)
    setSubmitting(true)
    try {
      const payload = {
        hoTen: form.hoTen.trim(),
        ngaySinh: form.ngaySinh || null,
        gioiTinh: form.gioiTinh,
        soDienThoai: form.soDienThoai.trim(),
        email: form.email.trim(),
        diaChi: form.diaChi.trim(),
      }
      const result = await registerMember1(payload)
      setSuccess(result)
    } catch (err) {
      if (err.status === 400 && err.data) {
        // Lỗi theo trường: map field -> message, hoặc {errors: {...}}, hoặc message chung
        const fieldMap = err.data.errors || err.data.fields || err.data
        const known = ['hoTen', 'ngaySinh', 'gioiTinh', 'soDienThoai', 'email', 'diaChi']
        const collected = {}
        if (fieldMap && typeof fieldMap === 'object') {
          for (const k of known) {
            if (typeof fieldMap[k] === 'string') collected[k] = fieldMap[k]
          }
        }
        if (Object.keys(collected).length > 0) {
          setErrors(collected)
        } else {
          setGeneralError(err.data.message || 'Thông tin đăng kí không hợp lệ. Vui lòng kiểm tra lại.')
        }
      } else {
        setGeneralError(err.message || 'Đăng kí thất bại, vui lòng thử lại sau.')
      }
    } finally {
      setSubmitting(false)
    }
  }

  const field = (name, label, required, input) => (
    <div className="form-group">
      <label htmlFor={name}>
        {label}
        {required && <span className="required">(*)</span>}
      </label>
      {input}
      {errors[name] && <div className="field-error">{errors[name]}</div>}
    </div>
  )

  return (
    <div className="container">
      <h1 className="page-title">Đăng kí thành viên</h1>
      <p className="page-subtitle">Điền thông tin cá nhân để trở thành thành viên của rạp CineMan và được cấp thẻ thành viên.</p>

      {success && (
        <div className="alert alert-success">
          <h3>Đăng kí thành viên thành công</h3>
          <div className="card-info">
            <div className="row"><span>Họ tên thành viên</span><strong>{success.hoTen}</strong></div>
            <div className="row"><span>Mã thẻ thành viên</span><strong className="gold">{success.maThe}</strong></div>
            <div className="row"><span>Hạng thành viên</span><strong>{success.hangMember1 || 'Thường'}</strong></div>
            <div className="row"><span>Ngày cấp</span><strong>{success.ngayCap}</strong></div>
            <div className="row"><span>Ngày hết hạn</span><strong>{success.ngayHetHan}</strong></div>
          </div>
        </div>
      )}

      {generalError && <div className="alert alert-error">{generalError}</div>}

      <form className="panel" onSubmit={handleSubmit} noValidate>
        {field('hoTen', 'Họ tên', true,
          <input id="hoTen" type="text" value={form.hoTen} onChange={set('hoTen')} placeholder="Ví dụ: Nguyễn Văn A" />)}
        {field('ngaySinh', 'Ngày sinh', false,
          <input id="ngaySinh" type="date" value={form.ngaySinh} onChange={set('ngaySinh')} />)}
        {field('gioiTinh', 'Giới tính', false,
          <select id="gioiTinh" value={form.gioiTinh} onChange={set('gioiTinh')}>
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
            <option value="Khác">Khác</option>
          </select>)}
        {field('soDienThoai', 'Số điện thoại', true,
          <input id="soDienThoai" type="tel" value={form.soDienThoai} onChange={set('soDienThoai')} placeholder="Ví dụ: 0901234567" />)}
        {field('email', 'Email', true,
          <input id="email" type="email" value={form.email} onChange={set('email')} placeholder="Ví dụ: nguyenvana@email.com" />)}
        {field('diaChi', 'Địa chỉ', false,
          <input id="diaChi" type="text" value={form.diaChi} onChange={set('diaChi')} placeholder="Số nhà, đường, quận/huyện, tỉnh/thành phố" />)}
        <button className="btn" type="submit" disabled={submitting}>
          {submitting ? 'Đang đăng kí…' : 'Đăng kí'}
        </button>
      </form>
    </div>
  )
}
