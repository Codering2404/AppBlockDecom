package com.facebook.ads.redexgen.core;

import android.util.Log;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class CE implements InterfaceC1698hW {
    public int A00;

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final void A9t(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final void A9u(String str, String str2, Throwable th) {
        Log.i(str, str2, th);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final boolean AAY(int i3) {
        return this.A00 <= i3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1698hW
    public final void AJY(int i3) {
        this.A00 = i3;
    }
}
