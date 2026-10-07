-- Initial Data Pelanggan
INSERT INTO pelanggan (nama, email, nomor_hp, alamat) VALUES ('Budi Santoso', 'budi@example.com', '081234567890', 'Jl. Merdeka No. 10, Jakarta');
INSERT INTO pelanggan (nama, email, nomor_hp, alamat) VALUES ('Siti Aminah', 'siti@example.com', '089876543210', 'Jl. Sudirman No. 45, Bandung');

-- Initial Data Orders
INSERT INTO orders (produk_id, pelanggan_id, tanggal_transaksi, jumlah, total) VALUES (101, 1, CURRENT_TIMESTAMP, 2, 150000.0);
INSERT INTO orders (produk_id, pelanggan_id, tanggal_transaksi, jumlah, total) VALUES (102, 2, CURRENT_TIMESTAMP, 1, 75000.0);
