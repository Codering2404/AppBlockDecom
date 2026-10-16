package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ly, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1955ly extends AbstractC0804Jb {
    public static String[] A02 = {"WZkrugZ9k", "x4SWtznAL", "HpTT9hwXiF", "GejxPsVIqdMqn4uNSueU2CvK5QdcE", "kY6PJZpIMUpeuimCFjYxSQzMMPc04", "AyPx1MENxNPCbM7HZGi1kOnAmMtkHxm9", "mMmHuZ9NaaUgibHMJoRcA4q0AdWca5ys", "Hii3DdXYVzyt8ReiNrO7wglp0i"};
    public HJ A00;
    public C1956lz A01;

    private int A00(C04554v c04554v) {
        int i3 = (c04554v.A0l()[2] & 255) >> 4;
        if (i3 == 6 || i3 == 7) {
            c04554v.A0g(4);
            String[] strArr = A02;
            String str = strArr[6];
            String str2 = strArr[5];
            int iCharAt = str.charAt(19);
            int blockSizeKey = str2.charAt(19);
            if (iCharAt == blockSizeKey) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[1] = "Cisj8wK8S";
            strArr2[0] = "koTyuZ08X";
            c04554v.A0S();
        }
        int result = HF.A00(c04554v, i3);
        c04554v.A0f(0);
        return result;
    }

    public static boolean A01(C04554v c04554v) {
        return c04554v.A07() >= 5 && c04554v.A0I() == 127 && c04554v.A0Q() == 1179402563;
    }

    public static boolean A02(byte[] bArr) {
        return bArr[0] == -1;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0804Jb
    public final long A09(C04554v c04554v) {
        if (!A02(c04554v.A0l())) {
            return -1L;
        }
        return A00(c04554v);
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0804Jb
    public final void A0B(boolean z2) {
        super.A0B(z2);
        if (z2) {
            this.A00 = null;
            this.A01 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0804Jb
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public final boolean A0C(C04554v c04554v, long j3, C0803Ja c0803Ja) {
        byte[] bArrA0l = c04554v.A0l();
        HJ hj = this.A00;
        if (hj == null) {
            HJ hj2 = new HJ(bArrA0l, 17);
            this.A00 = hj2;
            c0803Ja.A00 = hj2.A08(Arrays.copyOfRange(bArrA0l, 9, c04554v.A0A()), null);
            return true;
        }
        if ((bArrA0l[0] & Ascii.DEL) == 3) {
            HI hiA03 = HH.A03(c04554v);
            HJ streamMetadata = hj.A09(hiA03);
            this.A00 = streamMetadata;
            this.A01 = new C1956lz(streamMetadata, hiA03);
            return true;
        }
        if (!A02(bArrA0l)) {
            return true;
        }
        if (this.A01 != null) {
            this.A01.A00(j3);
            c0803Ja.A01 = this.A01;
        }
        C2208qI c2208qI = c0803Ja.A00;
        String[] strArr = A02;
        if (strArr[4].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[3] = "zwTfeKiQLRobCpiZaAgtU0oyP8s29";
        strArr2[2] = "wrCWS6iAkk";
        AbstractC04323y.A01(c2208qI);
        return false;
    }
}
