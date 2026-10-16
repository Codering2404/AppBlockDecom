package com.facebook.ads.redexgen.core;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class YS {
    public static YS A02;
    public final C0971Pp A00;
    public final YU A01;

    public YS(C1648gi c1648gi, Executor executor, C1079Tw c1079Tw) {
        this.A01 = new YU(c1648gi);
        this.A00 = new C0971Pp(executor, c1079Tw, c1648gi);
    }

    private void A00() {
        this.A01.A03(this.A00);
    }

    public static void A01(C1648gi c1648gi, Executor executor, C1079Tw c1079Tw) {
        if (!C1098Up.A1c(c1648gi)) {
            return;
        }
        if (A02 == null) {
            A02 = new YS(c1648gi, executor, c1079Tw);
            A02.A00();
        } else {
            A02.A02(c1079Tw);
        }
    }

    private void A02(C1079Tw c1079Tw) {
        this.A00.A07(c1079Tw);
    }
}
