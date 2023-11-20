create database QuanLySinhVien
go

use QuanLySinhVien
go

create table TaiKhoan(
	TenTK varchar(20) PRIMARY KEY,
	MatKhau varchar(30)
)

create table SinhVien(
	MaSV varchar(10) PRIMARY KEY,
	HoTen nvarchar(30),
	NgaySinh date,
	GioiTinh nvarchar(10),
	SDT varchar(20),
	DiaChi nvarchar(30)
)

create table MonHoc(
	MaMH varchar(10) PRIMARY KEY,
	TenMH nvarchar(30),
	SoTC int
)

create table LopHocPhan(
	MaLopHP varchar(15) PRIMARY KEY,
	TenLopHP varchar(20),
	MaMH varchar(10) FOREIGN KEY(MaMH) REFERENCES MonHoc(MaMH) ON UPDATE CASCADE ON DELETE CASCADE,
	TenGV nvarchar(30),
	NgayBatDau date,
	NgayKetThuc date,
	SoTiet int
)

create table Diem(
	MaSV varchar(10) FOREIGN KEY(MaSV) REFERENCES SinhVien(MaSV) ON UPDATE CASCADE ON DELETE CASCADE,
	MaLopHP varchar(15) FOREIGN KEY(MaLopHP) REFERENCES LopHocPhan(MaLopHP) ON UPDATE CASCADE ON DELETE CASCADE,
	SoTietNghi int,
	DiemKTTX1 float,
	DiemKTTX2 float,
	DiemCuoiKy float,
	PRIMARY KEY(MaSV, MaLopHP)
)

drop table Diem
drop table LopHocPhan

delete from TaiKhoan
delete from SinhVien
delete from MonHoc
delete from SinhVien
delete from Diem
delete from LopHocPhan



insert into TaiKhoan values('admin','123456')
insert into TaiKhoan values('camly','6789@')
insert into TaiKhoan values('quynhanh','1234@')
insert into TaiKhoan values('minhduong','5678@')

select * from TaiKhoan

insert into SinhVien values('SV01',N'Nguyễn Văn Dũng','2002-08-10',N'Nam','09134689076',N'Hà Nội')
insert into SinhVien values('SV02',N'Chử Thị Cẩm Ly','2002-09-23',N'Nữ','06537976523',N'Hải Dương')
insert into SinhVien values('SV03',N'Trần Thanh Minh','2001-04-14',N'Nam','07464390156',N'Hà Đông')
insert into SinhVien values('SV04',N'Nguyễn Thu Thảo','2002-05-07',N'Nữ','08765356754',N'Bắc Ninh')
insert into SinhVien values('SV05',N'Trần Ngọc Minh','2002-08-20',N'Nữ','09689678851',N'Bắc Giang')
insert into SinhVien values('SV06',N'Phạm Minh Anh','2002-08-10',N'Nữ','0913468904',N'Hải Dương')
select * from SinhVien


insert into MonHoc values('MH01',N'Tiếng Anh CNTT 1',5)
insert into MonHoc values('MH02',N'Tiếng Anh CNTT 2',5)
insert into MonHoc values('MH03',N'Ứng dụng thuật toán',3)
insert into MonHoc values('MH04',N'Lập trình .NET',4)
insert into MonHoc values('MH05',N'Lập trình .NET',4)
insert into MonHoc values('MH06',N'Thiết kế phần mềm',3)
insert into MonHoc values('MH07',N'Công nghệ phần mềm',3)
insert into MonHoc values('MH08',N'Thiết kế phần mềm',3)
select * from MonHoc

insert into LopHocPhan values('202110503106001', '0503106.1', 'MH01', N'Trần Thu Trang', '2022-09-10', '2023-01-10', 30),
							('202110503188004', '0503188.4', 'MH01', N'Nguyễn Minh Hoàng', '2020-08-21', '2021-02-08', 45),
							('202110503130001', '0503130.1', 'MH03', N'Vũ Văn Cường', '2022-09-10', '2023-01-10', 60),
							('202111303192012', '1303192.12', 'MH04', N'Nguyễn Thanh Huyền', '2021-03-03', '2021-09-20', 32),
							('20212IT6012012', 'IT6012.12', 'MH02', N'Phạm Đức Dương', '2021-09-06', '2022-09-23', 30),
							('20212IT6097004', '1IT6097.4', 'MH04', N'Nguyễn Thanh Huyền', '2021-02-12', '2022-09-16', 45),
							('202021003108001', '1003108.1', 'MH04', N'Lê Bá Thiện', '2020-09-12', '2021-02-14', 50)

select * from LopHocPhan

insert into Diem values('SV04', '202110503106001', 0, null, 6.8, null)
insert into Diem values('SV02', '202110503188004', 2, 8.5, 6.8, null)
insert into Diem values('SV04', '202110503188004', 30, 6.8, null, null)
insert into Diem values('SV02', '202110503106001', 0, 6.5, 6.0, null)
insert into Diem values('SV03', '202110503106001', 9, null, null, null)
insert into Diem values('SV01', '202110503106001', 9, null, null, null)
insert into Diem values('SV05', '202110503106001', 9, null, null, null)
insert into Diem values('SV06', '202110503106001', 9, null, null, null)
insert into Diem values('SV02', '202110503188004', 30, 6.8, null, null)
select * from Diem







