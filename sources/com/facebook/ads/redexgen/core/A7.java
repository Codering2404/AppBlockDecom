package com.facebook.ads.redexgen.core;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class A7 extends AbstractC2093oQ {
    public int[] A00;
    public int[] A01;

    @Override // com.facebook.ads.redexgen.core.AbstractC2093oQ
    public final C04163i A09(C04163i c04163i) throws C04173j {
        int[] iArr = this.A01;
        if (iArr == null) {
            return C04163i.A05;
        }
        if (c04163i.A02 == 2) {
            int i3 = c04163i.A01 != iArr.length ? 1 : 0;
            int i4 = 0;
            while (i4 < iArr.length) {
                int i5 = iArr[i4];
                if (i5 < c04163i.A01) {
                    i3 |= i5 != i4 ? 1 : 0;
                    i4++;
                } else {
                    throw new C04173j(c04163i);
                }
            }
            if (i3 != 0) {
                return new C04163i(c04163i.A03, iArr.length, 2);
            }
            return C04163i.A05;
        }
        throw new C04173j(c04163i);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2093oQ
    public final void A0A() {
        this.A00 = this.A01;
    }

    public final void A0C(int[] iArr) {
        this.A01 = iArr;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC04183k
    public final void AHH(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) AbstractC04323y.A01(this.A00);
        int iPosition = byteBuffer.position();
        int outputSize = byteBuffer.limit();
        int position = outputSize - iPosition;
        ByteBuffer byteBufferA00 = A00(this.A06.A00 * (position / this.A05.A00));
        while (iPosition < outputSize) {
            for (int i3 : iArr) {
                byteBufferA00.putShort(byteBuffer.getShort((i3 * 2) + iPosition));
            }
            iPosition += this.A05.A00;
        }
        byteBuffer.position(outputSize);
        byteBufferA00.flip();
    }
}
