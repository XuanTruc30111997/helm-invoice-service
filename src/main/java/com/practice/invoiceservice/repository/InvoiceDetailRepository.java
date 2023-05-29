package com.practice.invoiceservice.repository;

import com.practice.invoiceservice.model.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, String> {
    @Modifying
    @Query(value = "INSERT INTO invoice_detail(id, invoice_id, product_id, quantity, price) values (:id, :invoiceId, :productId, :quantity, :price)", nativeQuery = true)
    @Transactional
    void insertInvoice(@Param("id") String id, @Param("invoiceId") String invoiceId, @Param("productId") String productId, @Param("quantity") int quantity, @Param("price") float price);

    @Query(value = "SELECT * FROM invoice_detail d WHERE d.invoice_id = :invoiceId", nativeQuery = true)
    Collection<InvoiceDetail> getInvoiceDetailsByInvoiceId(@Param(value = "invoiceId") String invoiceId);
}
