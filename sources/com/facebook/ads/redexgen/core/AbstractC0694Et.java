package com.facebook.ads.redexgen.core;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Et, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC0694Et {
    public static String[] A00 = {"94gd2lHaz6driogpt3Nl1tWsjXgriMxS", "VA5F17cuoV6wg6So0a0DluDefxsQAbFW", "BZfou2TK48MMfd1yJcRZTZ4JcnnWlmHT", "ilV1kn3efEuJyycOIV0UyN70TAMLymqY", "v19hT7CAJaCb1rntEZC2LQpyBVrX3IkZ", "rkpPVUKbY", "FKwb9S", "XsKsPoEAnPyrLBiotdeURrQ5Q46xoiIz"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static C2163pY A01(C0689Eo c0689Eo, List<? extends InterfaceC0691Eq>[] listArr) {
        C2K c2k = new C2K();
        int i3 = 0;
        loop0: while (true) {
            boolean z2 = false;
            if (i3 >= c0689Eo.A02()) {
                C2038nW c2038nWA06 = c0689Eo.A06();
                for (int i4 = 0; i4 < c2038nWA06.A01; i4++) {
                    C2171pg c2171pgA05 = c2038nWA06.A05(i4);
                    int[] iArr = new int[c2171pgA05.A01];
                    Arrays.fill(iArr, 0);
                    c2k.A04(new C2164pZ(c2171pgA05, false, iArr, new boolean[c2171pgA05.A01]));
                }
                return new C2163pY(c2k.A05());
            }
            C2038nW c2038nWA07 = c0689Eo.A07(i3);
            List<? extends InterfaceC0691Eq> list = listArr[i3];
            int i5 = 0;
            while (i5 < c2038nWA07.A01) {
                C2171pg c2171pgA052 = c2038nWA07.A05(i5);
                int iA05 = c0689Eo.A05(i3, i5, z2);
                String[] strArr = A00;
                if (strArr[7].charAt(11) != strArr[0].charAt(11)) {
                    break loop0;
                }
                String[] strArr2 = A00;
                strArr2[7] = "wVGS7RX5kLdrLFKtRIe7uQsNtd1z6IxW";
                strArr2[0] = "7aERijPLyLRrdgSw5lQfoyda5cW2h3c0";
                boolean z3 = iA05 != 0;
                int[] iArr2 = new int[c2171pgA052.A01];
                boolean[] zArr = new boolean[c2171pgA052.A01];
                for (int i6 = 0; i6 < c2171pgA052.A01; i6++) {
                    iArr2[i6] = c0689Eo.A04(i3, i5, i6);
                    boolean z4 = false;
                    if (A00[5].length() != 9) {
                        break loop0;
                    }
                    String[] strArr3 = A00;
                    strArr3[2] = "3DHxmUKuGZITV4091m9MLUNqu1ZkNm0q";
                    strArr3[3] = "2BQZhu0LL1SbQMNt9wHOkoks63NLimX3";
                    int i7 = 0;
                    while (true) {
                        if (i7 < list.size()) {
                            InterfaceC0691Eq interfaceC0691Eq = list.get(i7);
                            if (interfaceC0691Eq.A9L().equals(c2171pgA052) && interfaceC0691Eq.AA6(i6) != -1) {
                                z4 = true;
                                break;
                            }
                            i7++;
                        }
                    }
                    zArr[i6] = z4;
                }
                c2k.A04(new C2164pZ(c2171pgA052, z3, iArr2, zArr));
                i5++;
                z2 = false;
            }
            i3++;
        }
        throw new RuntimeException();
    }

    public static C2163pY A00(C0689Eo c0689Eo, InterfaceC0691Eq[] interfaceC0691EqArr) {
        List listA01;
        List[] listArr = new List[interfaceC0691EqArr.length];
        for (int i3 = 0; i3 < interfaceC0691EqArr.length; i3++) {
            InterfaceC0691Eq interfaceC0691Eq = interfaceC0691EqArr[i3];
            if (interfaceC0691Eq != null) {
                listA01 = BP.A04(interfaceC0691Eq);
            } else {
                listA01 = MetaExoPlayerCustomizedCollections.A01();
            }
            listArr[i3] = listA01;
        }
        return A01(c0689Eo, listArr);
    }
}
