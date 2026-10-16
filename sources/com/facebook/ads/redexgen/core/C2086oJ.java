package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.oJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2086oJ implements InterfaceC04183k {
    public long A03;
    public long A04;
    public C9Y A09;
    public boolean A0D;
    public boolean A0E;
    public float A01 = 1.0f;
    public float A00 = 1.0f;
    public C04163i A07 = C04163i.A05;
    public C04163i A08 = C04163i.A05;
    public C04163i A05 = C04163i.A05;
    public C04163i A06 = C04163i.A05;
    public ByteBuffer A0A = InterfaceC04183k.A00;
    public ShortBuffer A0C = this.A0A.asShortBuffer();
    public ByteBuffer A0B = InterfaceC04183k.A00;
    public int A02 = -1;

    public final long A00(long j3) {
        if (this.A04 >= 1024) {
            long jA0I = this.A03 - ((long) ((C9Y) AbstractC04323y.A01(this.A09)).A0I());
            if (this.A06.A03 == this.A05.A03) {
                long processedInputBytes = C5C.A0U(j3, jA0I, this.A04);
                return processedInputBytes;
            }
            long processedInputBytes2 = this.A06.A03;
            long j4 = jA0I * processedInputBytes2;
            long j5 = this.A04;
            long processedInputBytes3 = this.A05.A03;
            return C5C.A0U(j3, j4, j5 * processedInputBytes3);
        }
        return (long) (((double) this.A01) * j3);
    }

    public final void A01(float f3) {
        if (this.A00 != f3) {
            this.A00 = f3;
            this.A0E = true;
        }
    }

    public final void A02(float f3) {
        if (this.A01 != f3) {
            this.A01 = f3;
            this.A0E = true;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final C04163i A57(C04163i c04163i) throws C04173j {
        int i3;
        if (c04163i.A02 == 2) {
            if (this.A02 == -1) {
                i3 = c04163i.A03;
            } else {
                i3 = this.A02;
            }
            this.A07 = c04163i;
            this.A08 = new C04163i(i3, c04163i.A01, 2);
            this.A0E = true;
            return this.A08;
        }
        throw new C04173j(c04163i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final ByteBuffer A8d() {
        int iA0H;
        C9Y c9y = this.A09;
        if (c9y != null && (iA0H = c9y.A0H()) > 0) {
            if (this.A0A.capacity() < iA0H) {
                this.A0A = ByteBuffer.allocateDirect(iA0H).order(ByteOrder.nativeOrder());
                this.A0C = this.A0A.asShortBuffer();
            } else {
                this.A0A.clear();
                this.A0C.clear();
            }
            c9y.A0L(this.A0C);
            this.A04 += (long) iA0H;
            this.A0A.limit(iA0H);
            this.A0B = this.A0A;
        }
        ByteBuffer outputBuffer = this.A0B;
        this.A0B = InterfaceC04183k.A00;
        return outputBuffer;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final boolean AAL() {
        return this.A08.A03 != -1 && (Math.abs(this.A01 - 1.0f) >= 1.0E-4f || Math.abs(this.A00 - 1.0f) >= 1.0E-4f || this.A08.A03 != this.A07.A03);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final boolean AAP() {
        return this.A0D && (this.A09 == null || this.A09.A0H() == 0);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final void AHG() {
        if (this.A09 != null) {
            this.A09.A0K();
        }
        this.A0D = true;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final void AHH(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            return;
        }
        C9Y c9y = (C9Y) AbstractC04323y.A01(this.A09);
        ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
        int iRemaining = byteBuffer.remaining();
        this.A03 += (long) iRemaining;
        c9y.A0M(shortBufferAsShortBuffer);
        byteBuffer.position(byteBuffer.position() + iRemaining);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final void flush() {
        if (AAL()) {
            this.A05 = this.A07;
            this.A06 = this.A08;
            if (this.A0E) {
                this.A09 = new C9Y(this.A05.A03, this.A05.A01, this.A01, this.A00, this.A06.A03);
            } else if (this.A09 != null) {
                this.A09.A0J();
            }
        }
        this.A0B = InterfaceC04183k.A00;
        this.A03 = 0L;
        this.A04 = 0L;
        this.A0D = false;
    }
}
