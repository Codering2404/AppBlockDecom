package com.facebook.ads.redexgen.core;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@MetaExoPlayerCustomization("Making NalUnitTargetBuffer public to be accessible by the Oculus Readers")
public final class L4 {
    public int A00;
    public byte[] A01;
    public boolean A02;
    public boolean A03;
    public final int A04;

    public L4(int i3, int i4) {
        this.A04 = i3;
        this.A01 = new byte[i4 + 3];
        this.A01[2] = 1;
    }

    public final void A00() {
        this.A03 = false;
        this.A02 = false;
    }

    public final void A01(int i3) {
        AbstractC04323y.A08(!this.A03);
        this.A03 = i3 == this.A04;
        if (this.A03) {
            this.A00 = 3;
            this.A02 = false;
        }
    }

    public final void A02(byte[] bArr, int i3, int i4) {
        if (!this.A03) {
            return;
        }
        int i5 = i4 - i3;
        int length = this.A01.length;
        int readLength = this.A00;
        if (length < readLength + i5) {
            byte[] bArr2 = this.A01;
            int readLength2 = this.A00;
            this.A01 = Arrays.copyOf(bArr2, (readLength2 + i5) * 2);
        }
        byte[] bArr3 = this.A01;
        int readLength3 = this.A00;
        System.arraycopy(bArr, i3, bArr3, readLength3, i5);
        int readLength4 = this.A00;
        this.A00 = readLength4 + i5;
    }

    public final boolean A03() {
        return this.A02;
    }

    public final boolean A04(int i3) {
        if (!this.A03) {
            return false;
        }
        this.A00 -= i3;
        this.A03 = false;
        this.A02 = true;
        return true;
    }
}
