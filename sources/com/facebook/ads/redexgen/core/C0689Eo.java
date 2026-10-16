package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Eo, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0689Eo {
    public final int A00;
    public final C2038nW A01;
    public final int[] A02;
    public final int[] A03;
    public final C2038nW[] A04;
    public final String[] A05;
    public final int[][][] A06;

    public C0689Eo(String[] strArr, int[] iArr, C2038nW[] c2038nWArr, int[] iArr2, int[][][] iArr3, C2038nW c2038nW) {
        this.A05 = strArr;
        this.A03 = iArr;
        this.A04 = c2038nWArr;
        this.A06 = iArr3;
        this.A02 = iArr2;
        this.A01 = c2038nW;
        this.A00 = iArr.length;
    }

    private final int A00(int i3, int i4, int i5) {
        return this.A06[i3][i4][i5];
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int A01(int r8, int r9, int[] r10) {
        /*
            r7 = this;
            r6 = 0
            r2 = 16
            r5 = 0
            r4 = 0
            r3 = 0
        L6:
            int r0 = r10.length
            if (r3 >= r0) goto L3b
            r1 = r10[r3]
            com.facebook.ads.redexgen.X.nW[] r0 = r7.A04
            r0 = r0[r8]
            com.facebook.ads.redexgen.X.pg r0 = r0.A05(r9)
            com.facebook.ads.redexgen.X.qI r0 = r0.A08(r1)
            java.lang.String r0 = r0.A0W
            int r1 = r6 + 1
            if (r6 != 0) goto L32
            r4 = r0
        L1e:
            int[][][] r0 = r7.A06
            r0 = r0[r8]
            r0 = r0[r9]
            r0 = r0[r3]
            int r0 = com.facebook.ads.redexgen.core.AbstractC05207i.A01(r0)
            int r2 = java.lang.Math.min(r2, r0)
            int r3 = r3 + 1
            r6 = r1
            goto L6
        L32:
            boolean r0 = com.facebook.ads.redexgen.core.C5C.A1E(r4, r0)
            r0 = r0 ^ 1
            r0 = r0 | r5
            r5 = r0
            goto L1e
        L3b:
            if (r5 == 0) goto L45
            int[] r0 = r7.A02
            r0 = r0[r8]
            int r2 = java.lang.Math.min(r2, r0)
        L45:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0689Eo.A01(int, int, int[]):int");
    }

    public final int A02() {
        return this.A00;
    }

    public final int A03(int i3) {
        return this.A03[i3];
    }

    public final int A04(int i3, int i4, int i5) {
        return AbstractC05207i.A03(A00(i3, i4, i5));
    }

    public final int A05(int i3, int i4, boolean z2) {
        int i5 = this.A04[i3].A05(i4).A01;
        int[] iArr = new int[i5];
        int i6 = 0;
        for (int trackIndexCount = 0; trackIndexCount < i5; trackIndexCount++) {
            int iA04 = A04(i3, i4, trackIndexCount);
            if (iA04 == 4 || (z2 && iA04 == 3)) {
                int trackCount = i6 + 1;
                iArr[i6] = trackIndexCount;
                i6 = trackCount;
            }
        }
        int trackCount2 = A01(i3, i4, Arrays.copyOf(iArr, i6));
        return trackCount2;
    }

    public final C2038nW A06() {
        return this.A01;
    }

    public final C2038nW A07(int i3) {
        return this.A04[i3];
    }
}
