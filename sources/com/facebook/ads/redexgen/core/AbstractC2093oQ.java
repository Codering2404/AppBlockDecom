package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2093oQ implements InterfaceC04183k {
    public boolean A04;
    public ByteBuffer A02 = InterfaceC04183k.A00;
    public ByteBuffer A03 = InterfaceC04183k.A00;
    public C04163i A00 = C04163i.A05;
    public C04163i A01 = C04163i.A05;
    public C04163i A05 = C04163i.A05;
    public C04163i A06 = C04163i.A05;

    public abstract C04163i A09(C04163i c04163i) throws C04173j;

    public final ByteBuffer A00(int i3) {
        if (this.A02.capacity() < i3) {
            this.A02 = ByteBuffer.allocateDirect(i3).order(ByteOrder.nativeOrder());
        } else {
            this.A02.clear();
        }
        this.A03 = this.A02;
        return this.A02;
    }

    public final boolean A01() {
        return this.A03.hasRemaining();
    }

    public void A0A() {
    }

    public void A0B() {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final C04163i A57(C04163i c04163i) throws C04173j {
        this.A00 = c04163i;
        this.A01 = A09(c04163i);
        return AAL() ? this.A01 : C04163i.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public ByteBuffer A8d() {
        ByteBuffer byteBuffer = this.A03;
        ByteBuffer outputBuffer = InterfaceC04183k.A00;
        this.A03 = outputBuffer;
        return byteBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public boolean AAL() {
        return this.A01 != C04163i.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public boolean AAP() {
        return this.A04 && this.A03 == InterfaceC04183k.A00;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final void AHG() {
        this.A04 = true;
        A0B();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final void flush() {
        this.A03 = InterfaceC04183k.A00;
        this.A04 = false;
        this.A05 = this.A00;
        this.A06 = this.A01;
        A0A();
    }
}
