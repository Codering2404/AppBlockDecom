package com.google.crypto.tink.prf;

import com.google.crypto.tink.config.TinkFips;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class PrfConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f86414a = new HkdfPrfKeyManager().c();

    public static void a() {
        PrfSetWrapper.b();
        HmacPrfKeyManager.f(true);
        if (TinkFips.a()) {
            return;
        }
        AesCmacPrfKeyManager.f(true);
        HkdfPrfKeyManager.f(true);
    }
}
