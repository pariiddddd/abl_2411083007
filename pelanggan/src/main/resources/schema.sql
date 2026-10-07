-- Drop tabel jika sudah ada agar data ter-reset setiap restart server
DROP TABLE IF EXISTS orders CASCADE;
DROP TABLE IF EXISTS pelanggan CASCADE;

-- Tabel Pelanggan
CREATE TABLE pelanggan (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(255) NOT NULL,
    email VARCHAR(255),
    nomor_hp VARCHAR(50),
    alamat TEXT
);

-- Tabel Order (orders)
CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    produk_id BIGINT NOT NULL,
    pelanggan_id BIGINT NOT NULL,
    tanggal_transaksi TIMESTAMP,
    jumlah INT,
    total DOUBLE,
    CONSTRAINT fk_order_pelanggan FOREIGN KEY (pelanggan_id) REFERENCES pelanggan(id) ON DELETE CASCADE
);

