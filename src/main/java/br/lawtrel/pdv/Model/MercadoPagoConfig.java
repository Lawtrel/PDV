package br.lawtrel.pdv.Model;

import com.mercadopago.MercadoPago;
import com.mercadopago.exceptions.MPException;

public class MercadoPagoConfig {
    public static void initialize() {
        try {
            MercadoPago.SDK.setClientSecret("");
            MercadoPago.SDK.setClientId("");
            MercadoPago.SDK.setAccessToken("");
        } catch (MPException e) {
            e.printStackTrace();
        }
    }
}
