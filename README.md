# Ứng dụng Web: Hệ thống Quản lý Bán hàng

## 1. Nguyên tắc, Mẫu thiết kế và Thực hành phát triển phần mềm

Dự án này áp dụng các nguyên tắc, mẫu thiết kế và thực hành sau để đảm bảo việc phát triển dễ bảo trì, mở rộng và hiệu quả:

### **Nguyên tắc**
- **Nguyên tắc Trách nhiệm Đơn (SRP):** Mỗi lớp và hàm đảm nhận một trách nhiệm duy nhất.
- **Phân tách Mối quan tâm (SoC):** Logic được chia thành các tầng như Controller, Service, Repository, v.v.
- **Tiêm phụ thuộc (DI):** Sử dụng framework DI của Spring Boot để giảm phụ thuộc chặt chẽ và tăng khả năng kiểm thử.

### **Mẫu thiết kế**
- **Model-View-Controller (MVC):** Phân tách dữ liệu (Model), giao diện người dùng (View) và logic điều khiển (Controller).
- **Builder Pattern:** Sử dụng để xây dựng các đối tượng phức tạp (ví dụ: đối tượng `UserResponse`).
- **Repository Pattern:** Logic truy cập dữ liệu được trừu tượng hóa trong lớp repository.

### **Thực hành tốt**
- Xử lý lỗi đúng cách thông qua xử lý ngoại lệ toàn cục trong Spring Boot.
- Xác thực đầu vào của người dùng bằng các annotation (ví dụ: `@Valid`, `@NotNull`).
- Lưu trữ mật khẩu an toàn bằng cách sử dụng mã hóa bcrypt.

---

## 2. Cấu trúc mã nguồn

Mã nguồn được tổ chức thành các tầng riêng biệt để dễ dàng phân tách mối quan tâm:


