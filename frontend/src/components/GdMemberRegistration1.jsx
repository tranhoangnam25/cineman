import { useState } from 'react'
import { registerMember1 } from '../api'

// GdMemberRegistration1 — giao diện Đăng kí thành viên (khách hàng)
export default function GdMemberRegistration1() {
  const [form, setForm] = useState({
    fullName: '',
    dateOfBirth: '',
    gender: 'Nam',
    phoneNumber: '',
    email: '',
    address: '',
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
        fullName: form.fullName.trim(),
        dateOfBirth: form.dateOfBirth || null,
        gender: form.gender,
        phoneNumber: form.phoneNumber.trim(),
        email: form.email.trim(),
        address: form.address.trim(),
      }
      const result = await registerMember1(payload)
      setSuccess(result)
    } catch (err) {
      if (err.status === 400 && err.data) {
        // Lỗi theo trường: map field -> message, hoặc {errors: {...}}, hoặc message chung
        const fieldMap = err.data.errors || err.data.fields || err.data
        const known = ['fullName', 'dateOfBirth', 'gender', 'phoneNumber', 'email', 'address']
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
            <div className="row"><span>Họ tên thành viên</span><strong>{success.fullName}</strong></div>
            <div className="row"><span>Mã thẻ thành viên</span><strong className="gold">{success.cardNumber}</strong></div>
            <div className="row"><span>Hạng thành viên</span><strong>{success.membershipTier || 'Thường'}</strong></div>
            <div className="row"><span>Ngày cấp</span><strong>{success.issueDate}</strong></div>
            <div className="row"><span>Ngày hết hạn</span><strong>{success.expiryDate}</strong></div>
          </div>
        </div>
      )}

      {generalError && <div className="alert alert-error">{generalError}</div>}

      <form className="panel" onSubmit={handleSubmit} noValidate>
        {field('fullName', 'Họ tên', true,
          <input id="fullName" type="text" value={form.fullName} onChange={set('fullName')} placeholder="Ví dụ: Nguyễn Văn A" />)}
        {field('dateOfBirth', 'Ngày sinh', false,
          <input id="dateOfBirth" type="date" value={form.dateOfBirth} onChange={set('dateOfBirth')} />)}
        {field('gender', 'Giới tính', false,
          <select id="gender" value={form.gender} onChange={set('gender')}>
            <option value="Nam">Nam</option>
            <option value="Nữ">Nữ</option>
            <option value="Khác">Khác</option>
          </select>)}
        {field('phoneNumber', 'Số điện thoại', true,
          <input id="phoneNumber" type="tel" value={form.phoneNumber} onChange={set('phoneNumber')} placeholder="Ví dụ: 0901234567" />)}
        {field('email', 'Email', true,
          <input id="email" type="email" value={form.email} onChange={set('email')} placeholder="Ví dụ: nguyenvana@email.com" />)}
        {field('address', 'Địa chỉ', false,
          <input id="address" type="text" value={form.address} onChange={set('address')} placeholder="Số nhà, đường, quận/huyện, tỉnh/thành phố" />)}
        <button className="btn" type="submit" disabled={submitting}>
          {submitting ? 'Đang đăng kí…' : 'Đăng kí'}
        </button>
      </form>
    </div>
  )
}
