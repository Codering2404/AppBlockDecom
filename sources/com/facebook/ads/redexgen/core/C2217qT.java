package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.qT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2217qT implements AnonymousClass24 {
    public final int A00;
    public final int A01;
    public final long A02;
    public final long A03;
    public final boolean A04;
    public final int[] A05;
    public final long[] A06;
    public final Uri[] A07;
    public static String[] A08 = {"OkxecgD0Gv2GK", "dTJXSSjTvXtvCpVWxsqZ6", "wYzs5zgiK5G18", "klAEANkVopL6T8N0G4GCOYVrDlyPlXqI", "4WcRthq3aJhjltodanyM1lxGrZBe12qe", "Nzs6zPyAK9Q7ZYWQPcJbQV1Iqfi6la98", "CqWpbShPfJkKIhE6JIbgz0xValvGrdcB", "ap1AkjUIhWjw5r6nQb"};
    public static final String A0G = C5C.A0h(0);
    public static final String A0B = C5C.A0h(1);
    public static final String A0H = C5C.A0h(2);
    public static final String A0F = C5C.A0h(3);
    public static final String A0C = C5C.A0h(4);
    public static final String A0A = C5C.A0h(5);
    public static final String A0D = C5C.A0h(6);
    public static final String A0E = C5C.A0h(7);
    public static final AnonymousClass23<C2217qT> A09 = new AnonymousClass23() { // from class: com.facebook.ads.redexgen.X.qU
        @Override // com.facebook.ads.redexgen.core.AnonymousClass23
        public final AnonymousClass24 A6f(Bundle bundle) {
            return C2217qT.A00(bundle);
        }
    };

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 16 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static C2217qT A00(Bundle bundle) {
        long j3 = bundle.getLong(A0G);
        int i3 = bundle.getInt(A0B);
        int i4 = bundle.getInt(A0E);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(A0H);
        int[] intArray = bundle.getIntArray(A0F);
        long[] longArray = bundle.getLongArray(A0C);
        long j4 = bundle.getLong(A0A);
        boolean z2 = bundle.getBoolean(A0D);
        if (intArray == null) {
            intArray = new int[0];
        }
        Uri[] uriArr = new Uri[0];
        String[] strArr = A08;
        if (strArr[2].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[2] = "h5Cz72DlneqkJ";
        strArr2[0] = "HzHttfqxNoxwC";
        if (parcelableArrayList != null) {
            uriArr = (Uri[]) parcelableArrayList.toArray(uriArr);
        }
        if (longArray == null) {
            longArray = new long[0];
        }
        return new C2217qT(j3, i3, i4, intArray, uriArr, longArray, j4, z2);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 15
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final C2217qT A06(int i3) {
        int[] iArrA02 = A02(this.A05, i3);
        long[] jArrA03 = A03(this.A06, i3);
        return new C2217qT(this.A03, i3, this.A01, iArrA02, (Uri[]) Arrays.copyOf(this.A07, i3), jArrA03, this.A02, this.A04);
    }

    public C2217qT(long j3) {
        this(j3, -1, -1, new int[0], new Uri[0], new long[0], 0L, false);
    }

    public C2217qT(long j3, int i3, int i4, int[] iArr, Uri[] uriArr, long[] jArr, long j4, boolean z2) {
        AbstractC04323y.A07(iArr.length == uriArr.length);
        this.A03 = j3;
        this.A00 = i3;
        this.A01 = i4;
        this.A05 = iArr;
        this.A07 = uriArr;
        this.A06 = jArr;
        this.A02 = j4;
        this.A04 = z2;
    }

    public static int[] A02(int[] iArr, int i3) {
        int length = iArr.length;
        int iMax = Math.max(i3, length);
        int[] iArrCopyOf = Arrays.copyOf(iArr, iMax);
        Arrays.fill(iArrCopyOf, length, iMax, 0);
        return iArrCopyOf;
    }

    public static long[] A03(long[] jArr, int i3) {
        int length = jArr.length;
        int iMax = Math.max(i3, length);
        long[] jArrCopyOf = Arrays.copyOf(jArr, iMax);
        Arrays.fill(jArrCopyOf, length, iMax, -9223372036854775807L);
        return jArrCopyOf;
    }

    public final int A04() {
        return A05(-1);
    }

    public final int A05(int i3) {
        int i4 = i3 + 1;
        while (true) {
            int[] iArr = this.A05;
            String[] strArr = A08;
            String str = strArr[3];
            String str2 = strArr[4];
            int iCharAt = str.charAt(30);
            int nextAdIndexToPlay = str2.charAt(30);
            if (iCharAt != nextAdIndexToPlay) {
                throw new RuntimeException();
            }
            A08[6] = "Wtq62hhDQ1jo9VyQ6cIhlPoFSuywDvdH";
            int nextAdIndexToPlay2 = iArr.length;
            if (i4 >= nextAdIndexToPlay2 || this.A04) {
                break;
            }
            int nextAdIndexToPlay3 = this.A05[i4];
            if (nextAdIndexToPlay3 == 0 || this.A05[i4] == 1) {
                break;
            }
            i4++;
        }
        return i4;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A07() {
        /*
            r3 = this;
            int r1 = r3.A00
            r0 = -1
            r2 = 1
            if (r1 != r0) goto L7
            return r2
        L7:
            r1 = 0
        L8:
            int r0 = r3.A00
            if (r1 >= r0) goto L1c
            int[] r0 = r3.A05
            r0 = r0[r1]
            if (r0 == 0) goto L18
            int[] r0 = r3.A05
            r0 = r0[r1]
            if (r0 != r2) goto L19
        L18:
            return r2
        L19:
            int r1 = r1 + 1
            goto L8
        L1c:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2217qT.A07():boolean");
    }

    public final boolean A08() {
        return this.A00 == -1 || A04() < this.A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2217qT c2217qT = (C2217qT) obj;
        if (this.A03 == c2217qT.A03 && this.A00 == c2217qT.A00 && this.A01 == c2217qT.A01 && Arrays.equals(this.A07, c2217qT.A07) && Arrays.equals(this.A05, c2217qT.A05) && Arrays.equals(this.A06, c2217qT.A06)) {
            long j3 = this.A02;
            if (A08[5].charAt(25) != 'f') {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[3] = "oTIVhrwO4wW48XZtZFkmZHaHYFeLbVqJ";
            strArr[4] = "xLWtDigMD9KXXhkKgPNBVDDiVfKu3Nqc";
            if (j3 == c2217qT.A02 && this.A04 == c2217qT.A04) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((this.A00 * 31) + this.A01) * 31) + ((int) (this.A03 ^ (this.A03 >>> 32)))) * 31) + Arrays.hashCode(this.A07)) * 31) + Arrays.hashCode(this.A05)) * 31) + Arrays.hashCode(this.A06)) * 31) + ((int) (this.A02 ^ (this.A02 >>> 32)))) * 31) + (this.A04 ? 1 : 0);
    }
}
