package com.example.hotelmanage.paymentStatus;

import java.util.List;

public interface PaymentStatusServiceInterface {
    PaymentStatusDto findPaymentById(int id);
    void deletePaymentStatus(int id);
    PaymentStatusDto createPaymentStatus(PaymentStatusDto paymentStatusDto);
    PaymentStatusDto updatePaymentStatus(PaymentStatusDto paymentStatusDto);
    List<PaymentStatusDto> getAllPaymentStatus();

}
