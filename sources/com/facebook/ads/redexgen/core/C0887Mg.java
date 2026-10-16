package com.facebook.ads.redexgen.core;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C0887Mg {
    public static byte[] A05;
    public static String[] A06 = {"nQDli3B322dNyuNUEmcA1lNjVYYmcThQ", "JG8wfEU3nZ2EADYXO0uZDMHFqmVSkpWr", "8K0NmfCVVugnhGVgpCD", "5JHmUKWu4ei3dzUY0lNr", "xKwnuhTKVDH3YhaAiUGpqwLltg47C3CG", "Jcwv8MY0", "vBOLiuiZ", "hny3hth3cGmNH4IG9ndqfAmzri4VXjHL"};
    public C1858kN A00;
    public final int A01;
    public final String A02;
    public final ArrayList<C0886Mf> A03;
    public final TreeSet<C1856kL> A04;

    public static String A00(int i3, int i4, int i5) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i3, i3 + i4);
        for (int i6 = 0; i6 < bArrCopyOfRange.length; i6++) {
            bArrCopyOfRange[i6] = (byte) ((bArrCopyOfRange[i6] - i5) - 47);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{115, -57, -62, 115, -100, -70, -68, -63, -66, -67, -100, -56, -57, -51, -66, -57, -51, -57, -30, -22, -19, -26, -27, -95, -11, -16, -95, -13, -26, -17, -30, -18, -26, -95};
    }

    static {
        A01();
    }

    public C0887Mg(int i3, String str) {
        this(i3, str, C1858kN.A03);
    }

    public C0887Mg(int i3, String str, C1858kN c1858kN) {
        this.A01 = i3;
        this.A02 = str;
        this.A00 = c1858kN;
        this.A04 = new TreeSet<>();
        this.A03 = new ArrayList<>();
    }

    public final long A02(long j3, long j4) {
        boolean z2 = true;
        AbstractC04323y.A07(j3 >= 0);
        if (j4 < 0) {
            z2 = false;
        }
        AbstractC04323y.A07(z2);
        C1856kL c1856kLA04 = A04(j3, j4);
        if (c1856kLA04.A03()) {
            return -Math.min(c1856kLA04.A04() ? Long.MAX_VALUE : c1856kLA04.A01, j4);
        }
        long j5 = j3 + j4;
        if (j5 < 0) {
            j5 = Long.MAX_VALUE;
        }
        long currentEndPosition = c1856kLA04.A02 + c1856kLA04.A01;
        if (currentEndPosition < j5) {
            TreeSet<C1856kL> treeSet = this.A04;
            String[] strArr = A06;
            if (strArr[5].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "31viDRwdD8ErVcI5dXS";
            strArr2[3] = "q1k4diPGE3D0s4ujqDJA";
            for (C1856kL c1856kL : treeSet.tailSet(c1856kLA04, false)) {
                if (c1856kL.A02 > currentEndPosition) {
                    break;
                }
                long j6 = c1856kL.A02;
                long queryEndPosition = c1856kL.A01;
                currentEndPosition = Math.max(currentEndPosition, j6 + queryEndPosition);
                if (currentEndPosition >= j5) {
                    break;
                }
            }
        }
        return Math.min(currentEndPosition - j3, j4);
    }

    public final C1858kN A03() {
        return this.A00;
    }

    public final C1856kL A04(long j3, long j4) {
        C1856kL c1856kLA03 = C1856kL.A03(this.A02, j3);
        C1856kL c1856kLFloor = this.A04.floor(c1856kLA03);
        if (c1856kLFloor != null && c1856kLFloor.A02 + c1856kLFloor.A01 > j3) {
            return c1856kLFloor;
        }
        C1856kL lookupSpan = this.A04.ceiling(c1856kLA03);
        if (lookupSpan != null) {
            long jMin = lookupSpan.A02 - j3;
            if (j4 != -1) {
                jMin = Math.min(jMin, j4);
            }
            j4 = jMin;
        }
        return C1856kL.A04(this.A02, j3, j4);
    }

    public final C1856kL A05(C1856kL c1856kL, long j3, boolean z2) {
        AbstractC04323y.A08(this.A04.remove(c1856kL));
        File file = (File) AbstractC04323y.A01(c1856kL.A03);
        if (z2) {
            File file2 = file.getParentFile();
            File fileA05 = C1856kL.A05((File) AbstractC04323y.A01(file2), this.A01, c1856kL.A02, j3);
            if (file.renameTo(fileA05)) {
                file = fileA05;
            } else {
                AbstractC04404g.A07(A00(4, 13, 42), A00(17, 17, 82) + file + A00(0, 4, 36) + fileA05);
            }
        }
        C1856kL newCacheSpan = c1856kL.A09(file, j3);
        this.A04.add(newCacheSpan);
        return newCacheSpan;
    }

    public final TreeSet<C1856kL> A06() {
        return this.A04;
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A07(long r5) {
        /*
            r4 = this;
            r3 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r4.A03
            int r0 = r0.size()
            if (r3 >= r0) goto L20
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r4.A03
            java.lang.Object r0 = r0.get(r3)
            com.facebook.ads.redexgen.X.Mf r0 = (com.facebook.ads.redexgen.core.C0886Mf) r0
            long r1 = r0.A01
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L1d
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r4.A03
            r0.remove(r3)
            return
        L1d:
            int r3 = r3 + 1
            goto L1
        L20:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0887Mg.A07(long):void");
    }

    public final void A08(C1856kL c1856kL) {
        this.A04.add(c1856kL);
    }

    public final boolean A09() {
        return this.A04.isEmpty();
    }

    public final boolean A0A() {
        return this.A03.isEmpty();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0B(long r3, long r5) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.Mf r0 = (com.facebook.ads.redexgen.core.C0886Mf) r0
            boolean r0 = r0.A00(r3, r5)
            if (r0 == 0) goto L19
            r0 = 1
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0887Mg.A0B(long, long):boolean");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A0C(long r3, long r5) {
        /*
            r2 = this;
            r1 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            int r0 = r0.size()
            if (r1 >= r0) goto L1c
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r0 = r2.A03
            java.lang.Object r0 = r0.get(r1)
            com.facebook.ads.redexgen.X.Mf r0 = (com.facebook.ads.redexgen.core.C0886Mf) r0
            boolean r0 = r0.A01(r3, r5)
            if (r0 == 0) goto L19
            r0 = 0
            return r0
        L19:
            int r1 = r1 + 1
            goto L1
        L1c:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Mf> r1 = r2.A03
            com.facebook.ads.redexgen.X.Mf r0 = new com.facebook.ads.redexgen.X.Mf
            r0.<init>(r3, r5)
            r1.add(r0)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C0887Mg.A0C(long, long):boolean");
    }

    public final boolean A0D(MZ mz) {
        if (this.A04.remove(mz)) {
            if (mz.A03 != null) {
                mz.A03.delete();
                return true;
            }
            return true;
        }
        String[] strArr = A06;
        if (strArr[2].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A06;
        strArr2[2] = "U4uu0ltzeeg5QMm1KwS";
        strArr2[3] = "VtFGErd1YdVsfyUNL3Po";
        return false;
    }

    public final boolean A0E(C0892Ml c0892Ml) {
        C1858kN c1858kN = this.A00;
        C1858kN oldMetadata = this.A00;
        this.A00 = oldMetadata.A05(c0892Ml);
        C1858kN oldMetadata2 = this.A00;
        return !oldMetadata2.equals(c1858kN);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0887Mg c0887Mg = (C0887Mg) obj;
        if (this.A01 == c0887Mg.A01 && this.A02.equals(c0887Mg.A02) && this.A04.equals(c0887Mg.A04) && this.A00.equals(c0887Mg.A00)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int result = this.A01;
        int i3 = result * 31;
        int result2 = this.A02.hashCode();
        return ((i3 + result2) * 31) + this.A00.hashCode();
    }
}
