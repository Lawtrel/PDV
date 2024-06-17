package br.lawtrel.pdv.Model;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;

public class MercadoPagoConfig {
    public static void initialize() {
        try {
            MercadoPago.SDK.setClientSecret("NfekSAnNXQTqGhpD92Eej8pZjFei4ZHV");
            MercadoPago.SDK.setClientId("6007420216512497");
            MercadoPago.SDK.setAccessToken("APP_USR-6007420216512497-061517-c486e84f8fd8671a2f85ab3e6bb27796-254791948");
        } catch (MPException e) {
            e.printStackTrace();
        }
    }
}
