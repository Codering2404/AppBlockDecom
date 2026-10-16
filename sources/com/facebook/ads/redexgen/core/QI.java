package com.facebook.ads.redexgen.core;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class QI implements InterfaceC1173Xr {
    public int A00;
    public final InterfaceC1173Xr A01;

    public QI(InterfaceC1173Xr interfaceC1173Xr, int i3) {
        this.A01 = interfaceC1173Xr;
        this.A00 = i3;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1173Xr
    public final void AH8(String str) {
        if (this.A00 > 0) {
            this.A01.AH8(str);
            this.A00--;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1173Xr
    public final void flush() {
        this.A01.flush();
    }
}
