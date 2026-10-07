package com.farid.pelanggan.controller;

import com.farid.pelanggan.entity.Order;
import com.farid.pelanggan.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pelanggan/{pelangganId}")
    public List<Order> getOrdersByPelangganId(@PathVariable Long pelangganId) {
        return orderRepository.findByPelangganId(pelangganId);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        if (order.getTanggalTransaksi() == null) {
            order.setTanggalTransaksi(LocalDateTime.now());
        }
        Order savedOrder = orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order orderDetails) {
        return orderRepository.findById(id)
                .map(order -> {
                    order.setProdukId(orderDetails.getProdukId());
                    order.setPelangganId(orderDetails.getPelangganId());
                    if (orderDetails.getTanggalTransaksi() != null) {
                        order.setTanggalTransaksi(orderDetails.getTanggalTransaksi());
                    }
                    order.setJumlah(orderDetails.getJumlah());
                    order.setTotal(orderDetails.getTotal());
                    Order updatedOrder = orderRepository.save(order);
                    return ResponseEntity.ok(updatedOrder);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
