package com.cineman1.config;

import com.cineman1.model.Customer1;
import com.cineman1.model.Employee1;
import com.cineman1.model.Invoice1;
import com.cineman1.model.Member1;
import com.cineman1.model.MembershipCard1;
import com.cineman1.model.Movie1;
import com.cineman1.model.ScreeningRoom1;
import com.cineman1.model.Showtime1;
import com.cineman1.model.Ticket1;
import com.cineman1.repository.EmployeeRepository1;
import com.cineman1.repository.InvoiceRepository1;
import com.cineman1.repository.MemberInfoRepository1;
import com.cineman1.repository.MemberRepository1;
import com.cineman1.repository.MembershipCardRepository1;
import com.cineman1.repository.MovieRepository1;
import com.cineman1.repository.ScreeningRoomRepository1;
import com.cineman1.repository.ShowtimeRepository1;
import com.cineman1.repository.TicketRepository1;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Seed du lieu mau cho CineMan1. Chi chay khi bang tblEmployee1 dang rong.
 */
@Component
public class DataSeed1 implements ApplicationRunner {

    private final EmployeeRepository1 employeeRepository1;
    private final MovieRepository1 movieRepository1;
    private final ScreeningRoomRepository1 screeningRoomRepository1;
    private final ShowtimeRepository1 showtimeRepository1;
    private final MemberRepository1 memberRepository1;
    private final MemberInfoRepository1 memberInfoRepository1;
    private final MembershipCardRepository1 membershipCardRepository1;
    private final InvoiceRepository1 invoiceRepository1;
    private final TicketRepository1 ticketRepository1;

    public DataSeed1(EmployeeRepository1 employeeRepository1,
                     MovieRepository1 movieRepository1,
                     ScreeningRoomRepository1 screeningRoomRepository1,
                     ShowtimeRepository1 showtimeRepository1,
                     MemberRepository1 memberRepository1,
                     MemberInfoRepository1 memberInfoRepository1,
                     MembershipCardRepository1 membershipCardRepository1,
                     InvoiceRepository1 invoiceRepository1,
                     TicketRepository1 ticketRepository1) {
        this.employeeRepository1 = employeeRepository1;
        this.movieRepository1 = movieRepository1;
        this.screeningRoomRepository1 = screeningRoomRepository1;
        this.showtimeRepository1 = showtimeRepository1;
        this.memberRepository1 = memberRepository1;
        this.memberInfoRepository1 = memberInfoRepository1;
        this.membershipCardRepository1 = membershipCardRepository1;
        this.invoiceRepository1 = invoiceRepository1;
        this.ticketRepository1 = ticketRepository1;
    }

    @Override
    public void run(ApplicationArguments args) {
        if (employeeRepository1.count() > 0) {
            return;
        }

        // ---------- Nhan vien ----------
        Employee1 quanLi = employeeRepository1.save(new Employee1(
                "Nguyễn Văn Quản", LocalDate.of(1988, 3, 12), "0912345678",
                "quanli@cineman1.vn", "quanli", "123456", "Quản lí"));
        Employee1 salesStaff = employeeRepository1.save(new Employee1(
                "Trần Thị Bán", LocalDate.of(1995, 7, 25), "0987654321",
                "banhang@cineman1.vn", "banhang", "123456", "Bán hàng"));

        // ---------- Phong chieu ----------
        ScreeningRoom1 phong1 = screeningRoomRepository1.save(
                new ScreeningRoom1("Phòng 1", 120, "2D", "Đang hoạt động"));
        ScreeningRoom1 phong2 = screeningRoomRepository1.save(
                new ScreeningRoom1("Phòng 2", 100, "3D", "Đang hoạt động"));
        ScreeningRoom1 phongVip = screeningRoomRepository1.save(
                new ScreeningRoom1("Phòng VIP", 80, "VIP", "Đang hoạt động"));

        // ---------- Phim ----------
        Movie1 movie1 = movieRepository1.save(new Movie1(
                "Mưa Trên Phố Cũ", "Tình cảm", "Lê Thanh Sơn", "Thu Trang, Tiến Luật",
                115, LocalDate.of(2026, 10, 30), "Câu chuyện tình yêu và ký ức trên những con phố xưa.", "Đang chiếu"));
        Movie1 movie2 = movieRepository1.save(new Movie1(
                "Truy Kích Lúc Nửa Đêm", "Hành động", "Ngô Quang Huy", "Johnny Trí Nguyễn, Ngô Thanh Vân",
                128, LocalDate.of(2026, 10, 24), "Một điệp viên truy đuổi nhóm tội phạm xuyên quốc gia.", "Đang chiếu"));
        Movie1 movie3 = movieRepository1.save(new Movie1(
                "Cười Xuyên Việt", "Hài", "Trần Hàm", "Trường Giang, Nhã Phương",
                102, LocalDate.of(2026, 11, 1), "Chuyến xuyên Việt đầy tiếng cười của hai anh em.", "Đang chiếu"));
        Movie1 movie4 = movieRepository1.save(new Movie1(
                "Bóng Ma Nhà Hát", "Kinh dị", "Victor Vũ", "Khả Ngân, Song Luân",
                109, LocalDate.of(2026, 10, 31), "Bí ẩn rùng rợn trong nhà hát cổ giữa lòng thành phố.", "Đang chiếu"));

        // ---------- Suat chieu (2026-11-03 .. 2026-11-09) ----------
        Showtime1 s1 = showtimeRepository1.save(new Showtime1(movie1, phong1,
                LocalDate.of(2026, 11, 3), LocalTime.of(9, 0), LocalTime.of(10, 55), new BigDecimal("75000")));
        Showtime1 s2 = showtimeRepository1.save(new Showtime1(movie1, phong1,
                LocalDate.of(2026, 11, 5), LocalTime.of(14, 30), LocalTime.of(16, 25), new BigDecimal("90000")));
        Showtime1 s3 = showtimeRepository1.save(new Showtime1(movie1, phongVip,
                LocalDate.of(2026, 11, 8), LocalTime.of(19, 30), LocalTime.of(21, 25), new BigDecimal("150000")));
        Showtime1 s4 = showtimeRepository1.save(new Showtime1(movie2, phong2,
                LocalDate.of(2026, 11, 3), LocalTime.of(13, 0), LocalTime.of(15, 8), new BigDecimal("100000")));
        Showtime1 s5 = showtimeRepository1.save(new Showtime1(movie2, phong2,
                LocalDate.of(2026, 11, 6), LocalTime.of(18, 0), LocalTime.of(20, 8), new BigDecimal("120000")));
        Showtime1 s6 = showtimeRepository1.save(new Showtime1(movie2, phong1,
                LocalDate.of(2026, 11, 9), LocalTime.of(21, 0), LocalTime.of(23, 8), new BigDecimal("110000")));
        Showtime1 s7 = showtimeRepository1.save(new Showtime1(movie3, phong1,
                LocalDate.of(2026, 11, 4), LocalTime.of(10, 0), LocalTime.of(11, 42), new BigDecimal("80000")));
        Showtime1 s8 = showtimeRepository1.save(new Showtime1(movie3, phong2,
                LocalDate.of(2026, 11, 7), LocalTime.of(16, 0), LocalTime.of(17, 42), new BigDecimal("95000")));
        // Suat chieu CHUA CO hoa don nao - de test drill-down rong
        Showtime1 s9 = showtimeRepository1.save(new Showtime1(movie4, phong2,
                LocalDate.of(2026, 11, 9), LocalTime.of(22, 30), LocalTime.of(0, 19), new BigDecimal("105000")));
        Showtime1 s10 = showtimeRepository1.save(new Showtime1(movie4, phong1,
                LocalDate.of(2026, 11, 5), LocalTime.of(20, 0), LocalTime.of(21, 49), new BigDecimal("100000")));

        // ---------- Khach hang (6 nguoi, 2 nguoi la thanh vien co the) ----------
        Customer1 customer1 = memberRepository1.save(new Customer1(
                "Phạm Minh Tuấn", LocalDate.of(1998, 5, 14), "Nam", "0901112233",
                "tuan.pm@gmail.com", "Quận 1, TP. Hồ Chí Minh"));
        Customer1 customer2 = memberRepository1.save(new Customer1(
                "Lê Ngọc Anh", LocalDate.of(2000, 9, 2), "Nữ", "0902223344",
                "anh.ln@gmail.com", "Quận 3, TP. Hồ Chí Minh"));
        Customer1 customer3 = memberRepository1.save(new Customer1(
                "Hoàng Văn Đức", LocalDate.of(1995, 1, 20), "Nam", "0903334455",
                "duc.hv@gmail.com", "Bình Thạnh, TP. Hồ Chí Minh"));
        Customer1 customer4 = memberRepository1.save(new Customer1(
                "Ngô Thị Mai", LocalDate.of(1999, 12, 8), "Nữ", "0904445566",
                "mai.nt@gmail.com", "Phú Nhuận, TP. Hồ Chí Minh"));
        Customer1 customer5 = memberRepository1.save(new Customer1(
                "Đặng Quốc Bảo", LocalDate.of(1997, 6, 30), "Nam", "0905556677",
                "bao.dq@gmail.com", "Quận 7, TP. Hồ Chí Minh"));
        Customer1 customer6 = memberRepository1.save(new Customer1(
                "Vũ Thu Hằng", LocalDate.of(2001, 4, 17), "Nữ", "0906667788",
                "hang.vt@gmail.com", "Tân Bình, TP. Hồ Chí Minh"));

        Member1 tv1 = memberInfoRepository1.save(new Member1(
                customer1, LocalDate.of(2026, 10, 15), "Thường", 120));
        MembershipCard1 the1 = membershipCardRepository1.save(new MembershipCard1(
                tv1, "TEMP", LocalDate.of(2026, 10, 15), LocalDate.of(2027, 10, 15), "Đang dùng"));
        the1.setCardNumber(String.format("CM%08d", the1.getId()));
        membershipCardRepository1.save(the1);

        Member1 tv2 = memberInfoRepository1.save(new Member1(
                customer2, LocalDate.of(2026, 10, 20), "Thường", 45));
        MembershipCard1 the2 = membershipCardRepository1.save(new MembershipCard1(
                tv2, "TEMP", LocalDate.of(2026, 10, 20), LocalDate.of(2027, 10, 20), "Đang dùng"));
        the2.setCardNumber(String.format("CM%08d", the2.getId()));
        membershipCardRepository1.save(the2);

        // ---------- Hoa don + ve ----------
        // S1 - movie1, 2026-11-03
        createInvoice(customer1, salesStaff, LocalDateTime.of(2026, 11, 3, 8, 45), "Tiền mặt", s1, 2, false);
        createInvoice(null, salesStaff, LocalDateTime.of(2026, 11, 3, 8, 50), "Thẻ", s1, 3, false);
        // S2 - movie1, 2026-11-05
        createInvoice(customer3, salesStaff, LocalDateTime.of(2026, 11, 5, 14, 0), "Tiền mặt", s2, 4, false);
        createInvoice(customer2, salesStaff, LocalDateTime.of(2026, 11, 5, 14, 5), "Chuyển khoản", s2, 2, true); // co 1 ve huy
        // S3 - movie1 VIP, 2026-11-08
        createInvoice(customer1, salesStaff, LocalDateTime.of(2026, 11, 8, 19, 0), "Thẻ", s3, 2, false);
        // S4 - movie2, 2026-11-03
        createInvoice(customer4, salesStaff, LocalDateTime.of(2026, 11, 3, 12, 30), "Tiền mặt", s4, 2, false);
        createInvoice(customer5, salesStaff, LocalDateTime.of(2026, 11, 3, 12, 40), "Tiền mặt", s4, 1, false);
        // S5 - movie2, 2026-11-06
        createInvoice(customer6, salesStaff, LocalDateTime.of(2026, 11, 6, 17, 30), "Thẻ", s5, 3, false);
        createInvoice(null, salesStaff, LocalDateTime.of(2026, 11, 6, 17, 45), "Tiền mặt", s5, 2, true); // co 1 ve huy
        // S6 - movie2, 2026-11-09
        createInvoice(customer2, salesStaff, LocalDateTime.of(2026, 11, 9, 20, 30), "Chuyển khoản", s6, 2, false);
        // S7 - movie3, 2026-11-04
        createInvoice(customer3, salesStaff, LocalDateTime.of(2026, 11, 4, 9, 30), "Tiền mặt", s7, 4, false);
        createInvoice(customer4, salesStaff, LocalDateTime.of(2026, 11, 4, 9, 40), "Tiền mặt", s7, 2, false);
        // S8 - movie3, 2026-11-07
        createInvoice(customer5, salesStaff, LocalDateTime.of(2026, 11, 7, 15, 30), "Thẻ", s8, 3, false);
        // S10 - movie4, 2026-11-05
        createInvoice(customer6, salesStaff, LocalDateTime.of(2026, 11, 5, 19, 30), "Tiền mặt", s10, 2, false);
        createInvoice(customer1, salesStaff, LocalDateTime.of(2026, 11, 5, 19, 40), "Thẻ", s10, 1, false);
        // S9 khong co hoa don nao (de trong)
    }

    /**
     * Tao 1 hoa don kem cac ve cho 1 suat chieu.
     * totalAmount cua hoa don chi tinh cac ve "Da ban".
     * Neu hasCancelledTicket = true thi them 1 ve "Da huy" (khong tinh vao totalAmount).
     */
    private void createInvoice(Customer1 customer, Employee1 salesStaff, LocalDateTime issuedAt,
                           String paymentMethod, Showtime1 showtime, int ticketsSold, boolean hasCancelledTicket) {
        BigDecimal ticketPrice = showtime.getTicketPrice();
        BigDecimal totalAmount = ticketPrice.multiply(BigDecimal.valueOf(ticketsSold));
        Invoice1 invoice = invoiceRepository1.save(new Invoice1(
                customer, salesStaff, issuedAt, totalAmount, paymentMethod));

        List<Ticket1> ticketList = new ArrayList<>();
        for (int i = 0; i < ticketsSold; i++) {
            ticketList.add(new Ticket1(showtime, invoice, "A" + (i + 1), ticketPrice, "Đã bán"));
        }
        if (hasCancelledTicket) {
            ticketList.add(new Ticket1(showtime, invoice, "A" + (ticketsSold + 1), ticketPrice, "Đã hủy"));
        }
        ticketRepository1.saveAll(ticketList);
    }
}
