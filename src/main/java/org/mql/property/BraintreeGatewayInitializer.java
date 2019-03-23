package org.mql.property;

import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "braintree")
@Data
public class BraintreeGatewayInitializer {

    private BraintreeGateway gateway;

    @Value("${braintree.BT_MERCHANT_ID}")
    private String marchantId;
    @Value("${braintree.BT_PUBLIC_KEY}")
    private String publicKey;
    @Value("${braintree.BT_PRIVATE_KEY}")
    private String privateKey;

    public BraintreeGateway getGateway() {
        return gateway = new BraintreeGateway(Environment.SANDBOX, marchantId, publicKey, privateKey);
    }
}
