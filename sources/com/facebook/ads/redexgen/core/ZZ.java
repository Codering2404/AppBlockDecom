package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class ZZ implements View.OnClickListener {
    public final /* synthetic */ C1209Zb A00;

    public ZZ(C1209Zb c1209Zb) {
        this.A00 = c1209Zb;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        try {
            this.A00.A04.AAp();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
