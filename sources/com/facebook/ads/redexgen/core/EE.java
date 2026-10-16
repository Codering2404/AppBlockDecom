package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class EE implements InterfaceC1533er {
    public final View A00;
    public final C1648gi A01;

    public EE(C1648gi c1648gi, View view) {
        this.A01 = c1648gi;
        this.A00 = view;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1533er
    public final double A9V() {
        C1594fq result = C1593fp.A0E(this.A00, 0, this.A01);
        return result.A00();
    }
}
