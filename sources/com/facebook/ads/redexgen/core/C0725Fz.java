package com.facebook.ads.redexgen.core;

import android.view.View;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C0725Fz implements InterfaceC1412cs {
    public final /* synthetic */ C0724Fy A00;

    public C0725Fz(C0724Fy c0724Fy) {
        this.A00 = c0724Fy;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1412cs
    public final void AGW(View view) {
        if (this.A00.A09) {
            this.A00.A07 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1412cs
    public final void AGY(View view) {
        AbstractC0809Jg abstractC0809Jg = (AbstractC0809Jg) view;
        abstractC0809Jg.A1T();
        if (this.A00.A09) {
            this.A00.A07 = true;
        }
        if (this.A00.A04.A0Z() && ((Integer) abstractC0809Jg.getTag(-1593835536)).intValue() == 0) {
            this.A00.A04.A0U();
        }
    }
}
