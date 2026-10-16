package com.facebook.ads.redexgen.core;

import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdSize;
import com.facebook.stetho.dumpapp.Framer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class XG {
    public static byte[] A00;
    public static String[] A01 = {"NoYeCqw0NuwsBVSvR8aiyPnoj7", "APA6ODPEmALJh8xHCjcwQdd6vsoZzjc", "og2YXunKDp8EqsbnYhzdu6qR", "YLuKSEsrRIdzXIjkloLmDmBrtZDR6KFi", "8qSAHAaIpnwwIsCvL7AfoFTJYv1h46H2", "PXVMr", "05SrQOor", "5yYP5"};
    public static final Map<EnumC1122Vp, EnumC1123Vq> A02;

    public static String A06(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] ^ i5) ^ 18);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A00 = new byte[]{104, 74, 69, Ascii.FF, Framer.STDIN_REQUEST_FRAME_PREFIX, Ascii.VT, 72, 89, 78, 74, Framer.STDIN_REQUEST_FRAME_PREFIX, 78, Ascii.VT, 106, 79, Framer.EXIT_FRAME_PREFIX, 66, 81, 78, Ascii.VT, 94, 88, 66, 69, 76, Ascii.VT, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, 66, 88, Ascii.VT, 92, 66, 79, Framer.STDIN_REQUEST_FRAME_PREFIX, 67, Ascii.VT, 74, 69, 79, Ascii.VT, 67, 78, 66, 76, 67, Framer.STDIN_REQUEST_FRAME_PREFIX, 5, Framer.STDERR_FRAME_PREFIX, 9, Ascii.FF, 9, 8, Ascii.DLE, 9, 71, 38, 3, 52, Ascii.SO, Ascii.GS, 2, 71, 19, Ascii.RS, Ascii.ETB, 2, 73};
    }

    static {
        A07();
        A02 = new HashMap();
        A02.put(EnumC1122Vp.A09, EnumC1123Vq.A0D);
        A02.put(EnumC1122Vp.A07, EnumC1123Vq.A0F);
        A02.put(EnumC1122Vp.A06, EnumC1123Vq.A0E);
    }

    public static AdSize A00(EnumC1122Vp enumC1122Vp) {
        return AdSize.fromWidthAndHeight(enumC1122Vp.A04(), enumC1122Vp.A03());
    }

    public static AdSize A01(EnumC1123Vq enumC1123Vq) {
        for (Map.Entry<EnumC1122Vp, EnumC1123Vq> entry : A02.entrySet()) {
            if (entry.getValue() == enumC1123Vq) {
                EnumC1122Vp key = entry.getKey();
                if (A01[3].charAt(31) == 'z') {
                    throw new RuntimeException();
                }
                String[] strArr = A01;
                strArr[5] = "vUJqh";
                strArr[7] = "m1G2X";
                return A00(key);
            }
        }
        return AdSize.BANNER_320_50;
    }

    public static EnumC1122Vp A02(int i3) {
        switch (i3) {
            case 4:
                return EnumC1122Vp.A05;
            case 5:
                return EnumC1122Vp.A06;
            case 6:
                return EnumC1122Vp.A07;
            case 7:
                return EnumC1122Vp.A09;
            case 100:
                return EnumC1122Vp.A08;
            default:
                throw new IllegalArgumentException(A06(48, 20, 117));
        }
    }

    public static EnumC1122Vp A03(int i3, int i4) {
        if (EnumC1122Vp.A08.A03() == i4 && EnumC1122Vp.A08.A04() == i3) {
            return EnumC1122Vp.A08;
        }
        if (EnumC1122Vp.A05.A03() == i4) {
            int iA04 = EnumC1122Vp.A05.A04();
            String[] strArr = A01;
            if (strArr[5].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A01[3] = "mZi1y4qoTe3Eq90wST2K5ufjmqQARasa";
            if (iA04 == i3) {
                return EnumC1122Vp.A05;
            }
        }
        if (EnumC1122Vp.A06.A03() == i4 && EnumC1122Vp.A06.A04() == i3) {
            return EnumC1122Vp.A06;
        }
        if (EnumC1122Vp.A07.A03() == i4 && EnumC1122Vp.A07.A04() == i3) {
            return EnumC1122Vp.A07;
        }
        if (EnumC1122Vp.A09.A03() == i4) {
            EnumC1122Vp enumC1122Vp = EnumC1122Vp.A09;
            String[] strArr2 = A01;
            if (strArr2[6].length() == strArr2[0].length()) {
                throw new RuntimeException();
            }
            A01[3] = "Hv8n5Vk5MDnKIrkb6r8Yx0AFcMxyPOg2";
            if (enumC1122Vp.A04() == i3) {
                return EnumC1122Vp.A09;
            }
        }
        throw new IllegalArgumentException(A06(0, 48, 57));
    }

    public static EnumC1122Vp A04(AdSize adSize) {
        return A03(adSize.getWidth(), adSize.getHeight());
    }

    public static EnumC1123Vq A05(EnumC1122Vp enumC1122Vp) {
        EnumC1123Vq adTemplate = A02.get(enumC1122Vp);
        if (adTemplate == null) {
            return EnumC1123Vq.A0G;
        }
        return adTemplate;
    }
}
