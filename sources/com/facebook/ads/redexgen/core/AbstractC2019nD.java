package com.facebook.ads.redexgen.core;

import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.nD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2019nD extends AbstractC0697Ew {
    public static String[] A01 = {"LN1kZ6lR3vZBqqrviA4uTSOzBGS9o2bO", "mUQPITaRnEXTrG2Wr7xIAnPzPHhU6DS3", "avW0I4bwWNzzQZleeOInYpLZY9PTle7", "LGUT8ZIo3joumZn9NybI7JCchk0DSCTG", "S4WFRdtC0lcE2afHWARgiwpUU5tNPmtd", "SbOYlLigHNVPkFHrMvYK7wwtNeL", "2fmBOvz22OTh8nUuYBKjoVDFU", "lR30iWlIbuozJgbVtB9O9DOed4NJenPq"};
    public C0689Eo A00;

    public abstract Pair<C05307s[], InterfaceC2020nE[]> A0d(C0689Eo c0689Eo, int[][][] iArr, int[] iArr2, C2056no c2056no, Timeline timeline) throws AD;

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x000d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int A0Y(com.facebook.ads.redexgen.core.InterfaceC05277p[] r8, com.facebook.ads.redexgen.core.C2171pg r9, int[] r10, boolean r11) throws com.facebook.ads.redexgen.core.AD {
        /*
            int r6 = r8.length
            r5 = 0
            r7 = 1
            r4 = 0
        L4:
            int r0 = r8.length
            if (r4 >= r0) goto L39
            r3 = r8[r4]
            r2 = 0
            r1 = 0
        Lb:
            int r0 = r9.A01
            if (r1 >= r0) goto L22
            com.facebook.ads.redexgen.X.qI r0 = r9.A08(r1)
            int r0 = r3.AKM(r0)
            int r0 = com.facebook.ads.redexgen.core.AbstractC05207i.A03(r0)
            int r2 = java.lang.Math.max(r2, r0)
            int r1 = r1 + 1
            goto Lb
        L22:
            r0 = r10[r4]
            if (r0 != 0) goto L37
            r0 = 1
        L27:
            if (r2 > r5) goto L31
            if (r2 != r5) goto L34
            if (r11 == 0) goto L34
            if (r7 != 0) goto L34
            if (r0 == 0) goto L34
        L31:
            r6 = r4
            r5 = r2
            r7 = r0
        L34:
            int r4 = r4 + 1
            goto L4
        L37:
            r0 = 0
            goto L27
        L39:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2019nD.A0Y(com.facebook.ads.redexgen.X.7p[], com.facebook.ads.redexgen.X.pg, int[], boolean):int");
    }

    public static int[] A0Z(InterfaceC05277p interfaceC05277p, C2171pg c2171pg) throws AD {
        int[] iArr = new int[c2171pg.A01];
        for (int i3 = 0; i3 < c2171pg.A01; i3++) {
            iArr[i3] = interfaceC05277p.AKM(c2171pg.A08(i3));
        }
        return iArr;
    }

    public static int[] A0a(InterfaceC05277p[] interfaceC05277pArr) throws AD {
        int[] iArr = new int[interfaceC05277pArr.length];
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int iAKO = interfaceC05277pArr[i3].AKO();
            String[] strArr = A01;
            String str = strArr[4];
            String str2 = strArr[1];
            int i4 = str.charAt(23);
            if (i4 == str2.charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[4] = "1ViYEGUZxGRCVXLKV1NACncyCaxKGcLE";
            strArr2[1] = "WZkUCc71MckdncxFpAml539B1oxWjr0A";
            iArr[i3] = iAKO;
        }
        return iArr;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0697Ew
    public final C0698Ex A0b(InterfaceC05277p[] interfaceC05277pArr, C2038nW c2038nW, C2056no c2056no, Timeline timeline) throws AD {
        int[] rendererTrackGroupCounts;
        int[] iArr = new int[interfaceC05277pArr.length + 1];
        C2171pg[][] c2171pgArr = new C2171pg[interfaceC05277pArr.length + 1][];
        int[][][] iArr2 = new int[interfaceC05277pArr.length + 1][][];
        for (int i3 = 0; i3 < c2171pgArr.length; i3++) {
            c2171pgArr[i3] = new C2171pg[c2038nW.A01];
            iArr2[i3] = new int[c2038nW.A01][];
        }
        int[] iArrA0a = A0a(interfaceC05277pArr);
        for (int i4 = 0; i4 < c2038nW.A01; i4++) {
            C2171pg c2171pgA05 = c2038nW.A05(i4);
            int groupIndex = A0Y(interfaceC05277pArr, c2171pgA05, iArr, c2171pgA05.A02 == 5);
            if (groupIndex == interfaceC05277pArr.length) {
                rendererTrackGroupCounts = new int[c2171pgA05.A01];
            } else {
                rendererTrackGroupCounts = A0Z(interfaceC05277pArr[groupIndex], c2171pgA05);
            }
            int i5 = iArr[groupIndex];
            c2171pgArr[groupIndex][i5] = c2171pgA05;
            iArr2[groupIndex][i5] = rendererTrackGroupCounts;
            iArr[groupIndex] = iArr[groupIndex] + 1;
        }
        C2038nW[] c2038nWArr = new C2038nW[interfaceC05277pArr.length];
        String[] strArr = new String[interfaceC05277pArr.length];
        int[] iArr3 = new int[interfaceC05277pArr.length];
        int i6 = 0;
        while (true) {
            int length = interfaceC05277pArr.length;
            String[] strArr2 = A01;
            if (strArr2[4].charAt(23) == strArr2[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr3 = A01;
            strArr3[4] = "hppY0P6sht5kF7is4RCKyMBKsFUVAoRB";
            strArr3[1] = "XeHPWbHBeoBDFVDQc4DbmKa9NYqMdrJh";
            if (i6 < length) {
                int i7 = iArr[i6];
                c2038nWArr[i6] = new C2038nW((C2171pg[]) C5C.A1I(c2171pgArr[i6], i7));
                iArr2[i6] = (int[][]) C5C.A1I(iArr2[i6], i7);
                strArr[i6] = interfaceC05277pArr[i6].getName();
                iArr3[i6] = interfaceC05277pArr[i6].A9N();
                i6++;
            } else {
                C0689Eo c0689Eo = new C0689Eo(strArr, iArr3, c2038nWArr, iArrA0a, iArr2, new C2038nW((C2171pg[]) C5C.A1I(c2171pgArr[interfaceC05277pArr.length], iArr[interfaceC05277pArr.length])));
                Pair<C05307s[], InterfaceC2020nE[]> pairA0d = A0d(c0689Eo, iArr2, iArrA0a, c2056no, timeline);
                return new C0698Ex((C05307s[]) pairA0d.first, (InterfaceC2020nE[]) pairA0d.second, AbstractC0694Et.A00(c0689Eo, (InterfaceC0691Eq[]) pairA0d.second), c0689Eo);
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC0697Ew
    public final void A0c(Object obj) {
        this.A00 = (C0689Eo) obj;
    }
}
