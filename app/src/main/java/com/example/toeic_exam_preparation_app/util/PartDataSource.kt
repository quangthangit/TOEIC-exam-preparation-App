package com.example.toeic_exam_preparation_app.util

import com.example.toeic_exam_preparation_app.data.remote.Part
import com.example.toeic_exam_preparation_app.data.remote.Tag

object PartDataSource {
    val fakeParts = listOf(
        Part(
            partId = 1,
            name = "Part 1: Photographs",
            questionNumber = 6,
            tags = listOf(
                Tag(1, "[Part 1] Tranh tả người"),
                Tag(2, "[Part 1] Tranh tả vật")
            )
        ),
        Part(
            partId = 2,
            name = "Part 2: Question-Response",
            questionNumber = 25,
            tags = listOf(
                Tag(3, "[Part 2] Câu hỏi WHAT"),
                Tag(4, "[Part 2] Câu hỏi WHO"),
                Tag(5, "[Part 2] Câu hỏi WHERE"),
                Tag(6, "[Part 2] Câu hỏi WHEN"),
                Tag(7, "[Part 2] Câu hỏi HOW"),
                Tag(8, "[Part 2] Câu hỏi WHY"),
                Tag(9, "[Part 2] Câu hỏi YES/NO"),
                Tag(10, "[Part 2] Câu hỏi đuôi"),
                Tag(11, "[Part 2] Câu hỏi lựa chọn"),
                Tag(12, "[Part 2] Câu yêu cầu, đề nghị"),
                Tag(13, "[Part 2] Câu trần thuật")
            )
        ),
        Part(
            partId = 3,
            name = "Part 3: Conversations",
            questionNumber = 39,
            tags = listOf(
                Tag(14, "[Part 3] Câu hỏi về chủ đề, mục đích"),
                Tag(15, "[Part 3] Câu hỏi về danh tính người nói"),
                Tag(16, "[Part 3] Câu hỏi về chi tiết cuộc hội thoại"),
                Tag(17, "[Part 3] Câu hỏi về hành động tương lai"),
                Tag(18, "[Part 3] Câu hỏi kết hợp bảng biểu"),
                Tag(19, "[Part 3] Câu hỏi về hàm ý câu nói"),
                Tag(20, "[Part 3] Chủ đề: Company - General Office Work"),
                Tag(21, "[Part 3] Chủ đề: Company - Personnel"),
                Tag(22, "[Part 3] Chủ đề: Company - Event, Project"),
                Tag(23, "[Part 3] Chủ đề: Company - Facility"),
                Tag(24, "[Part 3] Chủ đề: Shopping, Service"),
                Tag(25, "[Part 3] Chủ đề: Order, delivery"),
                Tag(26, "[Part 3] Chủ đề: Transportation"),
                Tag(27, "[Part 3] Câu hỏi về yêu cầu, gợi ý")
            )
        ),
        Part(
            partId = 4,
            name = "Part 4: Talks",
            questionNumber = 30,
            tags = listOf(
                Tag(28, "[Part 4] Câu hỏi về chủ đề, mục đích"),
                Tag(29, "[Part 4] Câu hỏi về danh tính, địa điểm"),
                Tag(30, "[Part 4] Câu hỏi về chi tiết"),
                Tag(31, "[Part 4] Câu hỏi về hành động tương lai"),
                Tag(32, "[Part 4] Câu hỏi kết hợp bảng biểu"),
                Tag(33, "[Part 4] Câu hỏi về hàm ý câu nói"),
                Tag(34, "[Part 4] Dạng bài: Telephone message - Tin nhắn thoại"),
                Tag(35, "[Part 4] Dạng bài: Announcement - Thông báo"),
                Tag(36, "[Part 4] Dạng bài: News report, Broadcast - Bản tin"),
                Tag(37, "[Part 4] Dạng bài: Talk - Bài phát biểu, diễn văn"),
                Tag(38, "[Part 4] Dạng bài: Excerpt from a meeting - Trích dẫn từ buổi họp"),
                Tag(39, "[Part 4] Câu hỏi yêu cầu, gợi ý")
            )
        ),
        Part(
            partId = 5,
            name = "Part 5: Incomplete Sentences",
            questionNumber = 30,
            tags = listOf(
                Tag(40, "[Part 5] Câu hỏi từ loại"),
                Tag(41, "[Part 5] Câu hỏi ngữ pháp"),
                Tag(42, "[Part 5] Câu hỏi từ vựng"),
                Tag(43, "[Grammar] Danh từ"),
                Tag(44, "[Grammar] Đại từ"),
                Tag(45, "[Grammar] Tính từ"),
                Tag(46, "[Grammar] Thì"),
                Tag(47, "[Grammar] Trạng từ"),
                Tag(48, "[Grammar] Động từ nguyên mẫu có to"),
                Tag(49, "[Grammar] Danh động từ"),
                Tag(50, "[Grammar] Giới từ"),
                Tag(51, "[Grammar] Liên từ"),
                Tag(52, "[Grammar] Mệnh đề quan hệ"),
                Tag(53, "[Grammar] Cấu trúc so sánh")
            )
        ),
        Part(
            partId = 6,
            name = "Part 6: Text Completion",
            questionNumber = 16,
            tags = listOf(
                Tag(54, "[Part 6] Câu hỏi từ loại"),
                Tag(55, "[Part 6] Câu hỏi ngữ pháp"),
                Tag(56, "[Part 6] Câu hỏi từ vựng"),
                Tag(57, "[Part 6] Câu hỏi điền câu vào đoạn văn"),
                Tag(58, "[Part 6] Hình thức: Thư điện tử/ thư tay (Email/ Letter)"),
                Tag(59, "[Part 6] Hình thức: Thông báo/ văn bản hướng dẫn (Notice/ Announcement Information)"),
                Tag(60, "[Grammar] Danh từ"),
                Tag(61, "[Grammar] Tính từ"),
                Tag(62, "[Grammar] Thì"),
                Tag(63, "[Grammar] Thể"),
                Tag(64, "[Grammar] Phân từ và Cấu trúc phân từ"),
                Tag(65, "[Grammar] Giới từ"),
                Tag(66, "[Grammar] Liên từ")
            )
        ),
        Part(
            partId = 7,
            name = "Part 7: Reading Comprehension",
            questionNumber = 54,
            tags = listOf(
                Tag(67, "[Part 7] Câu hỏi tìm thông tin"),
                Tag(68, "[Part 7] Câu hỏi tìm chi tiết sai"),
                Tag(69, "[Part 7] Câu hỏi về chủ đề, mục đích"),
                Tag(70, "[Part 7] Câu hỏi suy luận"),
                Tag(71, "[Part 7] Câu hỏi điền câu"),
                Tag(72, "[Part 7] Cấu trúc: một đoạn"),
                Tag(73, "[Part 7] Cấu trúc: nhiều đoạn"),
                Tag(74, "[Part 7] Dạng bài: Email/ Letter: Thư điện tử/ Thư tay"),
                Tag(75, "[Part 7] Dạng bài: Form - Đơn từ, biểu mẫu"),
                Tag(76, "[Part 7] Dạng bài: Article/ Review: Bài báo/ Bài đánh giá"),
                Tag(77, "[Part 7] Dạng bài: Advertisement - Quảng cáo"),
                Tag(78, "[Part 7] Dạng bài: Announcement/ Notice: Thông báo"),
                Tag(79, "[Part 7] Dạng bài: Text message chain - Chuỗi tin nhắn"),
                Tag(80, "[Part 7] Câu hỏi tìm từ đồng nghĩa"),
                Tag(81, "[Part 7] Câu hỏi về hàm ý câu nói")
            )
        )
    )
}