package org.mql.services;

import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import org.mql.entities.Payment;
import org.mql.metier.IPaymentMetier;
import org.mql.property.BraintreeGatewayInitializer;
import org.mql.property.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PaymentService {

    @Autowired
    private BraintreeGatewayInitializer braintreeGateway;
    @Autowired
    private IPaymentMetier paymentMetier;

    @RequestMapping(value = "/client/token", method = RequestMethod.GET)
    public TokenResponse generateClientToken() {
        String token = braintreeGateway.getGateway().clientToken().generate();
        return new TokenResponse(token);
    }

    @RequestMapping(value = "/client/payment/process", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> processTransaction(
            @RequestBody Payment payment) {

        Transaction transaction = null;
        BigDecimal decimalAmount = null;
        try {
            decimalAmount = new BigDecimal(payment.getChargeAmount());
        } catch (NumberFormatException e) {
            //logger.info("NumberFormatException {}", e);
        }
        TransactionRequest request = new TransactionRequest().amount(decimalAmount)
                .paymentMethodNonce(payment.getNonce()).options().submitForSettlement(true).done();
        Result<Transaction> result = braintreeGateway.getGateway().transaction().sale(request);
        //logger.info("result.isSuccess() {}", result.isSuccess());
        if (result.isSuccess() || result.getTransaction() != null) {
            try {
                transaction = result.getTarget();
                transaction = braintreeGateway.getGateway().transaction().find(transaction.getId());


            } catch (Exception e) {
               // logger.info("Exception {}", e);

            }
            paymentMetier.save(payment);
            return ResponseEntity.ok(transaction);

        } else {

            return ResponseEntity.ok(result.getMessage());
        }
    }
}
