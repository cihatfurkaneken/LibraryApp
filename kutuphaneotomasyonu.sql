-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 20 Ara 2020, 15:06:40
-- Sunucu sürümü: 10.4.14-MariaDB
-- PHP Sürümü: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `kutuphaneotomasyon`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `accounts`
--

CREATE TABLE `accounts` (
  `Id` int(11) NOT NULL,
  `YetkiId` int(11) DEFAULT NULL,
  `PersonelId` int(11) DEFAULT NULL,
  `Sifre` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `accounts`
--

INSERT INTO `accounts` (`Id`, `YetkiId`, `PersonelId`, `Sifre`) VALUES
(4, 1, 3, '123'),
(5, 2, 4, '1234'),
(6, 2, 7, 'maraba'),
(7, 2, 8, '1234'),
(8, 3, 9, '1234');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kategori`
--

CREATE TABLE `kategori` (
  `Id` int(11) NOT NULL,
  `Adi` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `ParentId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kategori`
--

INSERT INTO `kategori` (`Id`, `Adi`, `ParentId`) VALUES
(1, 'Roman', 0),
(2, 'Bilim', 0),
(3, 'Araştırma-İnceleme', 0),
(4, 'Biyografi', 0),
(5, 'Deneme', 0),
(6, 'Eğitim', 0),
(7, 'Felsefe', 0),
(15, 'Astroloji-Fal-Büyü', 0);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitapalma`
--

CREATE TABLE `kitapalma` (
  `Id` int(11) NOT NULL,
  `KitapId` int(11) DEFAULT NULL,
  `PersonelId` int(11) DEFAULT NULL,
  `OgrId` int(11) DEFAULT NULL,
  `Tarih` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `Adet` int(11) DEFAULT NULL,
  `TeslimTarihi` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kitapalma`
--

INSERT INTO `kitapalma` (`Id`, `KitapId`, `PersonelId`, `OgrId`, `Tarih`, `Adet`, `TeslimTarihi`) VALUES
(8, 12, 3, 9, '2020/Aralık/17', 1, '2021/Ocak/16'),
(11, 13, 3, 10, '2020/Aralık/17', 1, '2021/Ocak/16'),
(12, 11, 3, 11, '2020/Aralık/17', 1, '2021/Ocak/16'),
(13, 10, 3, 10, '2020/Aralık/17', 1, '2021/Ocak/16'),
(14, 10, 3, 10, '2020/Aralık/17', 1, '2021/Ocak/16'),
(15, 10, 3, 8, '2020/Aralık/17', 1, '2021/Ocak/16'),
(16, 11, 3, 9, '2020/Aralık/17', 1, '2021/Ocak/16'),
(17, 15, 3, 11, '2020/Aralık/01', 1, '2021/Ocak/15'),
(18, 11, 3, 11, '2020/Aralık/19', 1, '2021/Ocak/18'),
(19, 14, 3, 10, '2020/Aralık/19', 1, '2021/Ocak/18'),
(20, 13, 3, 10, '2020/Aralık/19', 1, '2021/Ocak/18'),
(21, 12, 4, 10, '2020/Aralık/19', 1, '2021/Ocak/18'),
(22, 17, 4, 13, '2020/Aralık/19', 1, '2021/Ocak/19'),
(23, 16, 4, 12, '2020/Aralık/19', 1, '2021/Ocak/19'),
(24, 13, 4, 11, '2020/Aralık/20', 1, '2021/Ocak/19'),
(25, 18, 4, 12, '2020/Aralık/20', 1, '2021/Ocak/19'),
(26, 17, 3, 11, '2020/Aralık/20', 1, '2021/Ocak/19'),
(27, 19, 4, 13, '2020/Aralık/20', 1, '2021/Ocak/19');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitaplar`
--

CREATE TABLE `kitaplar` (
  `Id` int(11) NOT NULL,
  `Adi` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `KategoriId` int(11) DEFAULT NULL,
  `Tarih` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `Sayfa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `kitaplar`
--

INSERT INTO `kitaplar` (`Id`, `Adi`, `KategoriId`, `Tarih`, `Sayfa`) VALUES
(7, '2021 Var Olmak ', 15, '2020/Aralık/17', 440),
(8, 'Ben Kazanmadan Bitmez', 6, '2020/Aralık/16', 240),
(9, 'İmzalı - Okunmamış Mesaj', 1, '2020/Aralık/16', 304),
(10, 'Yaşam Terapisi', 6, '2020/Aralık/17', 208),
(11, 'Düştüğünde Kalkarsan', 6, '2020/Aralık/14', 153),
(12, 'Duygusal Zeka', 6, '2020/Aralık/09', 96),
(13, 'Tekboynuz Kitap', 7, '2020/Aralık/09', 155),
(14, 'Valizler Dolusu Umut ', 3, '2020/Aralık/15', 216),
(15, 'Ekmeğin Fethi', 3, '2020/Aralık/16', 337),
(16, 'Savaş Sanatı', 6, '2020/Aralık/19', 51),
(17, 'Türlerin Kökeni', 2, '2020/Aralık/19', 472),
(18, 'Savaş ve Barış', 1, '2020/Aralık/20', 500),
(19, 'Suç ve Ceza', 1, '2020/Aralık/20', 530);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `personel`
--

CREATE TABLE `personel` (
  `Id` int(11) NOT NULL,
  `AdiSoyadi` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `Email` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `yetkiId` int(11) DEFAULT 2
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `personel`
--

INSERT INTO `personel` (`Id`, `AdiSoyadi`, `Email`, `yetkiId`) VALUES
(3, 'Furkan Sale', 'salefurkan@gmail.com', 1),
(4, 'Cihat Furkan Eken', 'cihatfurkaneken@gmail.com', 2),
(8, 'Tayfun Zorcu', 'tayfunzorcu@gmail.com', 2),
(9, 'Doğukan Yılmaz', 'yilmazdogukan@gmail.com', 2);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `stok`
--

CREATE TABLE `stok` (
  `Id` int(11) NOT NULL,
  `PersonelId` int(11) DEFAULT NULL,
  `KitapId` int(11) DEFAULT NULL,
  `Adet` int(11) DEFAULT NULL,
  `Tarih` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `stok`
--

INSERT INTO `stok` (`Id`, `PersonelId`, `KitapId`, `Adet`, `Tarih`) VALUES
(33, 3, 7, 10, '2020/Aralık/17'),
(34, 3, 8, 7, '2020/Aralık/17'),
(35, 3, 9, 13, '2020/Aralık/17'),
(36, 3, 10, 18, '2020/Aralık/17'),
(37, 3, 11, 4, '2020/Aralık/17'),
(38, 3, 12, 19, '2020/Aralık/17'),
(39, 3, 13, 20, '2020/Aralık/17'),
(40, 3, 14, 6, '2020/Aralık/17'),
(41, 3, 15, 15, '2020/Aralık/17'),
(42, 3, 12, -1, '2020/Aralık/18'),
(43, 3, 10, -1, '2020/Aralık/17'),
(44, 3, 15, -1, '2020/Aralık/17'),
(45, 3, 13, -1, '2020/Aralık/18'),
(46, 3, 11, -1, '2020/Aralık/18'),
(47, 3, 10, -1, '2020/Aralık/18'),
(48, 3, 10, -1, '2020/Aralık/15'),
(49, 3, 10, -1, '2020/Aralık/29'),
(50, 3, 11, -1, '2020/Aralık/14'),
(51, 3, 15, -1, '2020/Aralık/01'),
(52, 3, 11, -1, '2020/Aralık/19'),
(53, 3, 14, -1, '2020/Aralık/19'),
(54, 3, 13, -1, '2020/Aralık/19'),
(55, 4, 12, -1, '2020/Aralık/19'),
(56, 4, 13, 5, '2020/Aralık/18'),
(57, 4, 16, 2, '2020/Aralık/18'),
(58, 4, 17, 3, '2020/Aralık/19'),
(59, 4, 17, -1, '2020/Aralık/19'),
(60, 4, 16, -1, '2020/Aralık/19'),
(61, 4, 13, -1, '2020/Aralık/20'),
(62, 4, 12, 2, '2020/Aralık/20'),
(63, 4, 18, 5, '2020/Aralık/20'),
(64, 4, 18, -1, '2020/Aralık/20'),
(65, 3, 17, -1, '2020/Aralık/20'),
(66, 4, 19, 3, '2020/Aralık/20'),
(67, 4, 19, -1, '2020/Aralık/20');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `uye`
--

CREATE TABLE `uye` (
  `Id` int(11) NOT NULL,
  `AdiSoyadi` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `OgrNo` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `Fakulte` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `Bolum` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL,
  `Sinif` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `uye`
--

INSERT INTO `uye` (`Id`, `AdiSoyadi`, `OgrNo`, `Fakulte`, `Bolum`, `Sinif`) VALUES
(8, 'Doğukan Yılnaz', '172120009', 'Teknoloji Fakültesi', 'Elektrik Elektronik Mühenidisliği', 3),
(9, 'Ayşegül Akbaş', '192160006', 'Teknoloji Fakültesi', 'Bilgisayar Mühendisliği', 2),
(10, 'Etem Gelen', '172120012', 'Mühendislik Fakültesi', 'İnşaat Mühendisliği', 2),
(11, 'İlayda Çelik', '162120002', 'İlahiyat Fakültesi', 'İlahiyat', 4),
(12, 'Tayfun Zorcu', '162120015', 'Teknoloji Fakültesi', 'Elektrik Elektronik Mühendisliği', 3),
(13, 'Fahri Zereyalp', '212120006', 'Spor Bilimleri', 'Beden Eğitimi Öğretmenliği', 1);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `yetkiler`
--

CREATE TABLE `yetkiler` (
  `Id` int(11) NOT NULL,
  `Adi` varchar(255) COLLATE utf8mb4_turkish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_turkish_ci;

--
-- Tablo döküm verisi `yetkiler`
--

INSERT INTO `yetkiler` (`Id`, `Adi`) VALUES
(1, 'admin'),
(2, 'Kütüphane Görevlisi'),
(3, 'Temizlik Görevlisi');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `kitapalma`
--
ALTER TABLE `kitapalma`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `kitaplar`
--
ALTER TABLE `kitaplar`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `personel`
--
ALTER TABLE `personel`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `stok`
--
ALTER TABLE `stok`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `uye`
--
ALTER TABLE `uye`
  ADD PRIMARY KEY (`Id`);

--
-- Tablo için indeksler `yetkiler`
--
ALTER TABLE `yetkiler`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `accounts`
--
ALTER TABLE `accounts`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Tablo için AUTO_INCREMENT değeri `kategori`
--
ALTER TABLE `kategori`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `kitapalma`
--
ALTER TABLE `kitapalma`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- Tablo için AUTO_INCREMENT değeri `kitaplar`
--
ALTER TABLE `kitaplar`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Tablo için AUTO_INCREMENT değeri `personel`
--
ALTER TABLE `personel`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Tablo için AUTO_INCREMENT değeri `stok`
--
ALTER TABLE `stok`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- Tablo için AUTO_INCREMENT değeri `uye`
--
ALTER TABLE `uye`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- Tablo için AUTO_INCREMENT değeri `yetkiler`
--
ALTER TABLE `yetkiler`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
