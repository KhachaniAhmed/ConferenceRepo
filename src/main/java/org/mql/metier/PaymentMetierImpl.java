package org.mql.metier;

import org.mql.dao.PaymentRepository;
import org.mql.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMetierImpl implements  IPaymentMetier {

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }
}
