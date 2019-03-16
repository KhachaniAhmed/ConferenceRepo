package org.mql.metier;

import org.mql.entities.Payment;

public interface IPaymentMetier {
    Payment save(Payment payment);
}
