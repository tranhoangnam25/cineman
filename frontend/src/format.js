// Tiện ích định dạng hiển thị
export function formatVND(value) {
  const n = Number(value) || 0
  return n.toLocaleString('vi-VN') + ' ₫'
}

export function formatDate(value) {
  if (!value) return ''
  // value dạng '2026-11-05' hoặc ISO datetime
  const d = new Date(value)
  if (isNaN(d.getTime())) return String(value)
  return d.toLocaleDateString('vi-VN')
}

export function formatDateTime(value) {
  if (!value) return ''
  const d = new Date(value)
  if (isNaN(d.getTime())) return String(value)
  return d.toLocaleString('vi-VN')
}

export function formatTime(value) {
  if (!value) return ''
  // value dạng '19:30:00' hoặc '19:30'
  return String(value).slice(0, 5)
}
