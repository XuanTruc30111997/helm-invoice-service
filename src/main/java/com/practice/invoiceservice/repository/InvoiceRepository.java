package com.practice.invoiceservice.repository;

import com.practice.invoiceservice.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Collection;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

    @Modifying
    @Query(value = "INSERT INTO invoice(id, customer_name) values (:id, :customerName)", nativeQuery = true)
    @Transactional
    void insertInvoice(@Param("id") String id, @Param("customerName") String customerName);

    @Query(value = "SELECT * FROM invoice", nativeQuery = true)
    Collection<Invoice> getAllInvoice();

    @Query(value = "SELECT * FROM invoice i where i.id = :invoice_id", nativeQuery = true)
    Collection<Invoice> getInvoiceById(@Param(value = "invoice_id") String invoiceId);
}
