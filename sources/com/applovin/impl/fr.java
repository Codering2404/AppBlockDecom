package com.applovin.impl;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class fr {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f59802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f59803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long[] f59804c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f59805d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f59806e;

        public a(int i3, int i4, long[] jArr, int i5, boolean z2) {
            this.f59802a = i3;
            this.f59803b = i4;
            this.f59804c = jArr;
            this.f59805d = i5;
            this.f59806e = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f59807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f59808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f59809c;

        public b(String str, String[] strArr, int i3) {
            this.f59807a = str;
            this.f59808b = strArr;
            this.f59809c = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f59810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f59811b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f59812c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f59813d;

        public c(boolean z2, int i3, int i4, int i5) {
            this.f59810a = z2;
            this.f59811b = i3;
            this.f59812c = i4;
            this.f59813d = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f59814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f59815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f59816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f59817d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f59818e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f59819f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f59820g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f59821h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f59822i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final byte[] f59823j;

        public d(int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z2, byte[] bArr) {
            this.f59814a = i3;
            this.f59815b = i4;
            this.f59816c = i5;
            this.f59817d = i6;
            this.f59818e = i7;
            this.f59819f = i8;
            this.f59820g = i9;
            this.f59821h = i10;
            this.f59822i = z2;
            this.f59823j = bArr;
        }
    }

    public static int a(int i3) {
        int i4 = 0;
        while (i3 > 0) {
            i4++;
            i3 >>>= 1;
        }
        return i4;
    }

    private static void b(cr crVar) throws ch {
        int iA = crVar.a(6) + 1;
        for (int i3 = 0; i3 < iA; i3++) {
            int iA2 = crVar.a(16);
            if (iA2 == 0) {
                crVar.b(8);
                crVar.b(16);
                crVar.b(16);
                crVar.b(6);
                crVar.b(8);
                int iA3 = crVar.a(4) + 1;
                for (int i4 = 0; i4 < iA3; i4++) {
                    crVar.b(8);
                }
            } else {
                if (iA2 != 1) {
                    throw ch.a("floor type greater than 1 not decodable: " + iA2, null);
                }
                int iA4 = crVar.a(5);
                int[] iArr = new int[iA4];
                int i5 = -1;
                for (int i6 = 0; i6 < iA4; i6++) {
                    int iA5 = crVar.a(4);
                    iArr[i6] = iA5;
                    if (iA5 > i5) {
                        i5 = iA5;
                    }
                }
                int i7 = i5 + 1;
                int[] iArr2 = new int[i7];
                for (int i8 = 0; i8 < i7; i8++) {
                    iArr2[i8] = crVar.a(3) + 1;
                    int iA6 = crVar.a(2);
                    if (iA6 > 0) {
                        crVar.b(8);
                    }
                    for (int i9 = 0; i9 < (1 << iA6); i9++) {
                        crVar.b(8);
                    }
                }
                crVar.b(2);
                int iA7 = crVar.a(4);
                int i10 = 0;
                int i11 = 0;
                for (int i12 = 0; i12 < iA4; i12++) {
                    i10 += iArr2[iArr[i12]];
                    while (i11 < i10) {
                        crVar.b(iA7);
                        i11++;
                    }
                }
            }
        }
    }

    private static c[] c(cr crVar) {
        int iA = crVar.a(6) + 1;
        c[] cVarArr = new c[iA];
        for (int i3 = 0; i3 < iA; i3++) {
            cVarArr[i3] = new c(crVar.c(), crVar.a(16), crVar.a(16), crVar.a(8));
        }
        return cVarArr;
    }

    private static void d(cr crVar) throws ch {
        int iA = crVar.a(6) + 1;
        for (int i3 = 0; i3 < iA; i3++) {
            if (crVar.a(16) > 2) {
                throw ch.a("residueType greater than 2 is not decodable", null);
            }
            crVar.b(24);
            crVar.b(24);
            crVar.b(24);
            int iA2 = crVar.a(6) + 1;
            crVar.b(8);
            int[] iArr = new int[iA2];
            for (int i4 = 0; i4 < iA2; i4++) {
                iArr[i4] = ((crVar.c() ? crVar.a(5) : 0) * 8) + crVar.a(3);
            }
            for (int i5 = 0; i5 < iA2; i5++) {
                for (int i6 = 0; i6 < 8; i6++) {
                    if ((iArr[i5] & (1 << i6)) != 0) {
                        crVar.b(8);
                    }
                }
            }
        }
    }

    private static long a(long j3, long j4) {
        return (long) Math.floor(Math.pow(j3, 1.0d / j4));
    }

    private static a a(cr crVar) throws ch {
        if (crVar.a(24) == 5653314) {
            int iA = crVar.a(16);
            int iA2 = crVar.a(24);
            long[] jArr = new long[iA2];
            boolean zC = crVar.c();
            long jA = 0;
            if (!zC) {
                boolean zC2 = crVar.c();
                for (int i3 = 0; i3 < iA2; i3++) {
                    if (zC2) {
                        if (crVar.c()) {
                            jArr[i3] = crVar.a(5) + 1;
                        } else {
                            jArr[i3] = 0;
                        }
                    } else {
                        jArr[i3] = crVar.a(5) + 1;
                    }
                }
            } else {
                int iA3 = crVar.a(5) + 1;
                int i4 = 0;
                while (i4 < iA2) {
                    int iA4 = crVar.a(a(iA2 - i4));
                    for (int i5 = 0; i5 < iA4 && i4 < iA2; i5++) {
                        jArr[i4] = iA3;
                        i4++;
                    }
                    iA3++;
                }
            }
            int iA5 = crVar.a(4);
            if (iA5 <= 2) {
                if (iA5 == 1 || iA5 == 2) {
                    crVar.b(32);
                    crVar.b(32);
                    int iA6 = crVar.a(4) + 1;
                    crVar.b(1);
                    if (iA5 != 1) {
                        jA = ((long) iA2) * ((long) iA);
                    } else if (iA != 0) {
                        jA = a(iA2, iA);
                    }
                    crVar.b((int) (jA * ((long) iA6)));
                }
                return new a(iA, iA2, jArr, iA5, zC);
            }
            throw ch.a("lookup type greater than 2 not decodable: " + iA5, null);
        }
        throw ch.a("expected code book to start with [0x56, 0x43, 0x42] at " + crVar.b(), null);
    }

    public static d b(ah ahVar) throws ch {
        a(1, ahVar, false);
        int iQ = ahVar.q();
        int iW = ahVar.w();
        int iQ2 = ahVar.q();
        int iM = ahVar.m();
        if (iM <= 0) {
            iM = -1;
        }
        int iM2 = ahVar.m();
        if (iM2 <= 0) {
            iM2 = -1;
        }
        int iM3 = ahVar.m();
        if (iM3 <= 0) {
            iM3 = -1;
        }
        int iW2 = ahVar.w();
        return new d(iQ, iW, iQ2, iM, iM2, iM3, (int) Math.pow(2.0d, iW2 & 15), (int) Math.pow(2.0d, (iW2 & 240) >> 4), (ahVar.w() & 1) > 0, Arrays.copyOf(ahVar.c(), ahVar.e()));
    }

    private static void a(int i3, cr crVar) throws ch {
        int iA = crVar.a(6) + 1;
        for (int i4 = 0; i4 < iA; i4++) {
            int iA2 = crVar.a(16);
            if (iA2 != 0) {
                oc.b("VorbisUtil", "mapping type other than 0 not supported: " + iA2);
            } else {
                int iA3 = crVar.c() ? crVar.a(4) + 1 : 1;
                if (crVar.c()) {
                    int iA4 = crVar.a(8) + 1;
                    for (int i5 = 0; i5 < iA4; i5++) {
                        int i6 = i3 - 1;
                        crVar.b(a(i6));
                        crVar.b(a(i6));
                    }
                }
                if (crVar.a(2) != 0) {
                    throw ch.a("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (iA3 > 1) {
                    for (int i7 = 0; i7 < i3; i7++) {
                        crVar.b(4);
                    }
                }
                for (int i8 = 0; i8 < iA3; i8++) {
                    crVar.b(8);
                    crVar.b(8);
                    crVar.b(8);
                }
            }
        }
    }

    public static b a(ah ahVar) {
        return a(ahVar, true, true);
    }

    public static b a(ah ahVar, boolean z2, boolean z3) throws ch {
        if (z2) {
            a(3, ahVar, false);
        }
        String strC = ahVar.c((int) ahVar.p());
        int length = strC.length();
        long jP = ahVar.p();
        String[] strArr = new String[(int) jP];
        int length2 = length + 15;
        for (int i3 = 0; i3 < jP; i3++) {
            String strC2 = ahVar.c((int) ahVar.p());
            strArr[i3] = strC2;
            length2 = length2 + 4 + strC2.length();
        }
        if (z3 && (ahVar.w() & 1) == 0) {
            throw ch.a("framing bit expected to be set", null);
        }
        return new b(strC, strArr, length2 + 1);
    }

    public static c[] a(ah ahVar, int i3) throws ch {
        a(5, ahVar, false);
        int iW = ahVar.w() + 1;
        cr crVar = new cr(ahVar.c());
        crVar.b(ahVar.d() * 8);
        for (int i4 = 0; i4 < iW; i4++) {
            a(crVar);
        }
        int iA = crVar.a(6) + 1;
        for (int i5 = 0; i5 < iA; i5++) {
            if (crVar.a(16) != 0) {
                throw ch.a("placeholder of time domain transforms not zeroed out", null);
            }
        }
        b(crVar);
        d(crVar);
        a(i3, crVar);
        c[] cVarArrC = c(crVar);
        if (crVar.c()) {
            return cVarArrC;
        }
        throw ch.a("framing bit after modes not set as expected", null);
    }

    public static boolean a(int i3, ah ahVar, boolean z2) throws ch {
        if (ahVar.a() < 7) {
            if (z2) {
                return false;
            }
            throw ch.a("too short header: " + ahVar.a(), null);
        }
        if (ahVar.w() != i3) {
            if (z2) {
                return false;
            }
            throw ch.a("expected header type " + Integer.toHexString(i3), null);
        }
        if (ahVar.w() == 118 && ahVar.w() == 111 && ahVar.w() == 114 && ahVar.w() == 98 && ahVar.w() == 105 && ahVar.w() == 115) {
            return true;
        }
        if (z2) {
            return false;
        }
        throw ch.a("expected characters 'vorbis'", null);
    }
}
