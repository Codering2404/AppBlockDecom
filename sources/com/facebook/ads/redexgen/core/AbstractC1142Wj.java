package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1142Wj {
    public static final AtomicReference<InterfaceC1141Wi> A00 = new AtomicReference<>(null);

    public static InterfaceC1141Wi A00() {
        InterfaceC1141Wi errorLogger = A00.get();
        if (errorLogger == null) {
            return new R1();
        }
        return errorLogger;
    }

    public static void A01(InterfaceC1141Wi interfaceC1141Wi) {
        A00.set(interfaceC1141Wi);
    }
}
