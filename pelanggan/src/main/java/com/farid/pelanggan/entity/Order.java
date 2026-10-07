package com.farid.pelanggan.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "produk_id", nullable = false)
    private Long produkId;

    @Column(name = "pelanggan_id", nullable = false)
    private Long pelangganId;

    @Column(name = "tanggal_transaksi")
    private LocalDateTime tanggalTransaksi;

    private Integer jumlah;

    private Double total;

    public Order() {
    }

    public Order(Long produkId, Long pelangganId, LocalDateTime tanggalTransaksi, Integer jumlah, Double total) {
        this.produkId = produkId;
        this.pelangganId = pelangganId;
        this.tanggalTransaksi = tanggalTransaksi;
        this.jumlah = jumlah;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProdukId() {
        return produkId;
    }

    public void setProdukId(Long produkId) {
        this.produkId = produkId;
    }

    public Long getPelangganId() {
        return pelangganId;
    }

    public void setPelangganId(Long pelangganId) {
        this.pelangganId = pelangganId;
    }

    public LocalDateTime getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(LocalDateTime tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public Integer getJumlah() {
        return jumlah;
    }

    public void setJumlah(Integer jumlah) {
        this.jumlah = jumlah;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
