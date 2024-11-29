# Ứng dụng Web: Hệ thống Quản lý Bán hàng

## 1. Nguyên , Mẫu thiết kế và Thực hành phát triển phần mềm

Dự án này áp dụng các nguyên tắc, mẫu thiết kế và thực hành sau để đảm bảo việc phát triển dễ bảo trì, mở rộng và hiệu quả:

### **Nguyên lý**
- **Nguyên lý SOLID:** Mỗi lớp và hàm đảm nhận một trách nhiệm duy nhất.
- **DRY (Don’t Repeat Yourself):** Các đoạn code được cấu trúc để tránh sự dư thừa, có khả năng tận dùng lại thông qua các tiện ích dùng .
- **KISS (Keep It Simple, Stupid):** Thiết kế ưu tiên sự đơn giản và tránh sự phức tạp không cần thiết.

### **Patterns**
- **Model-View-Controller (MVC):** Phân tách dữ liệu (Model), giao diện người dùng (View) và logic điều khiển (Controller).
- **Builder Pattern:** Sử dụng để xây dựng các đối tượng phức tạp (ví dụ: đối tượng `UserResponse`).
- **Repository Pattern:** Logic truy cập dữ liệu được trừu tượng hóa trong lớp repository.

### **Thực hành tốt**
- Xử lý lỗi đúng cách thông qua xử lý ngoại lệ toàn cục trong Spring Boot.
- Xác thực đầu vào của người dùng bằng các annotation (ví dụ: `@Valid`, `@NotNull`).
- Lưu trữ mật khẩu an toàn bằng cách sử dụng mã hóa bcrypt.
- Phần phụ trợ tuân theo các quy ước RESTful dành cho điểm cuối API để đảm bảo liên lạc nhất quán giữa máy khách và máy chủ.

---

## 2. Cấu trúc mã nguồn

Mã nguồn được tổ chức thành các tầng riêng biệt để dễ dàng phân tách mối quan tâm. Các folder chính nhu sau:
### **src/main/java**
- **com.example**:
  + **config**: Có file SecurityConfig dùng để cấu hình và cài đặt các chế bảo mật và xác thực của Spring Security.
  + **controller**: Có nhiệm vụ điều hướng đến một trang html, và chứa bộ điều khiển RESTful xử lý các yêu cầu và phản hồi HTTP.
  + **service**: Có nhiệm vụ xử lý các logic nghiệp vụ trong hệ thống và là một tầng trung gian giữa controller và repository, có nhiệm vụ tương tác với cơ sở dữ liệu trong repository và trả về dữ liệu cho controller.
  + **repository**: Cho phép truy cập dữ liệu bằng cách sử dụng Spring Data JPA.
  + **entity**: Các đối tượng sễ được ánh xạ thành các table trong cơ sở dữ liệu.
  + **dto**: Bao gồm các đối tượng được định dạng theo cấu trúc, dùng để làm đầu vào (input) hoặc đầu ra (output) cho các hàm xử lý.

### **src/main/resources**
- **static**: Bao gồm các mục như: css, images, img, js, vendor, scss. Các thư mục này dùng để liên kết đến các file html để xử lý hình ảnh và giao diện.
- **template**:
  + **admin**: Trong thư mục admin chứa các file html về giao diện cho trang admin khi sử dụng.
  + **home**: Trong thư mục home chứa các file html về giao diện chính cho người dùng của trang web bán hàng.
- **application.properties**: Dùng để cấu hình các thuộc tính cho ứng như liên kết đến cơ sở dữ liệu, hibernate, multipart,...

## 3. Các bước để khởi chạy ứng dụng
### **Yêu cầu**:
- Java Development Kit (JDK): Phiên bản 17 trở lên.
- Database: MySQL hoặc Postgres DBMS.
- Git: Clone repository.
### **Các bước cài đặt (setup)**:
**1. Clone the repository**:
      git clone https://github.com/your-repo/project.git
      cd project

**2. Cấu hình Database**:
- Vào thư mục src/main/resources/application.properties:
  ![config-database](https://github.com/user-attachments/assets/9dffcf26-b466-4d45-be80-edabcd1c600b)



  


