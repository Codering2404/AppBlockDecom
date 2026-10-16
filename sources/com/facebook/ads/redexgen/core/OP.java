package com.facebook.ads.redexgen.core;

import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class OP {

    @Nullable
    public static OO A00;
    public static final AtomicBoolean A01 = new AtomicBoolean();

    public static OO A00(C1644ge c1644ge) {
        if (A00 == null) {
            A00 = new OO(c1644ge);
        }
        return A00;
    }

    public static void A01(C1644ge c1644ge) {
        if (AbstractC1101Us.A0F(c1644ge)) {
            A03(c1644ge);
        }
    }

    public static void A02(C1644ge c1644ge) {
        if (AbstractC1101Us.A0E(c1644ge)) {
            A03(c1644ge);
        }
    }

    public static void A03(C1644ge c1644ge) {
        if (A01.compareAndSet(false, true)) {
            Y4.A01.execute(new C1747iN(c1644ge));
        }
    }
}
