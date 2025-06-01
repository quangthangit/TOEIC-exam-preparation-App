# 📝 TOEIC Exam Preparation App
## 🛠️
### 👨‍💻 **Mobile (Android)**
- `Kotlin`
- `Room Database` – lưu trữ cục bộ
- `ViewModel`, `LiveData`, `Coroutines` – kiến trúc MVVM
- `Retrofit` – giao tiếp API
- `Firebase` – xác thực người dùng, lưu trữ
### 🖥️ **Backend**
- `Spring Boot`
- `MySQL`

---

## 📌 Task Management

Bạn có thể theo dõi chi tiết tiến độ và các đầu việc tại:  
👉 [Task Management Wiki (Lark)](https://wsgsuq86nf7w.sg.larksuite.com/wiki/HfjMwLIqCina8VkhUNvlZIIAgzb?from=from_copylink)

---

## 📂 

```bash
app/
├── data/
│   ├── api/           # Khai báo các API endpoint sử dụng Retrofit
│   ├── repository/    # Logic giao tiếp giữa UI và data (API/Room)
│   ├── remote/        # Các class liên quan đến dữ liệu từ server
│
├── ui/
│   ├── activity/      # Các màn hình chính của ứng dụng
│   ├── fragment/      # Các fragment tương ứng với các chức năng
│   └── adapter/       # Adapter cho RecyclerView/ListView,...
│
├── utils/             # Hàm tiện ích
└── design/            # Thành phần thiết kế: màu sắc, style, icon...
