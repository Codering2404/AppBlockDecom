package com.applovin.impl;

import android.util.Pair;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.impl.af;
import com.applovin.impl.e9;
import com.applovin.impl.j1;
import com.revenuecat.purchases.ui.revenuecatui.components.SensibleDefaults;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f60864a = xp.c("OpusHead");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60865a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f60866b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f60867c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f60868d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f60869e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ah f60870f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final ah f60871g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f60872h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f60873i;

        public a(ah ahVar, ah ahVar2, boolean z2) throws ch {
            this.f60871g = ahVar;
            this.f60870f = ahVar2;
            this.f60869e = z2;
            ahVar2.f(12);
            this.f60865a = ahVar2.A();
            ahVar.f(12);
            this.f60873i = ahVar.A();
            m8.a(ahVar.j() == 1, "first_chunk must be 1");
            this.f60866b = -1;
        }

        public boolean a() {
            int i3 = this.f60866b + 1;
            this.f60866b = i3;
            if (i3 == this.f60865a) {
                return false;
            }
            this.f60868d = this.f60869e ? this.f60870f.B() : this.f60870f.y();
            if (this.f60866b == this.f60872h) {
                this.f60867c = this.f60871g.A();
                this.f60871g.g(4);
                int i4 = this.f60873i - 1;
                this.f60873i = i4;
                this.f60872h = i4 > 0 ? this.f60871g.A() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface b {
        int a();

        int b();

        int c();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final mo[] f60874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e9 f60875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f60876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f60877d = 0;

        public c(int i3) {
            this.f60874a = new mo[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f60878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f60879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ah f60880c;

        public d(j1.b bVar, e9 e9Var) {
            ah ahVar = bVar.f60575b;
            this.f60880c = ahVar;
            ahVar.f(12);
            int iA = ahVar.A();
            if ("audio/raw".equals(e9Var.f59394m)) {
                int iB = xp.b(e9Var.B, e9Var.f59407z);
                if (iA == 0 || iA % iB != 0) {
                    oc.d("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iB + ", stsz sample size: " + iA);
                    iA = iB;
                }
            }
            this.f60878a = iA == 0 ? -1 : iA;
            this.f60879b = ahVar.A();
        }

        @Override // com.applovin.impl.k1.b
        public int a() {
            return this.f60878a;
        }

        @Override // com.applovin.impl.k1.b
        public int b() {
            return this.f60879b;
        }

        @Override // com.applovin.impl.k1.b
        public int c() {
            int i3 = this.f60878a;
            return i3 == -1 ? this.f60880c.A() : i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ah f60881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f60882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f60883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f60884d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f60885e;

        public e(j1.b bVar) {
            ah ahVar = bVar.f60575b;
            this.f60881a = ahVar;
            ahVar.f(12);
            this.f60883c = ahVar.A() & 255;
            this.f60882b = ahVar.A();
        }

        @Override // com.applovin.impl.k1.b
        public int a() {
            return -1;
        }

        @Override // com.applovin.impl.k1.b
        public int b() {
            return this.f60882b;
        }

        @Override // com.applovin.impl.k1.b
        public int c() {
            int i3 = this.f60883c;
            if (i3 == 8) {
                return this.f60881a.w();
            }
            if (i3 == 16) {
                return this.f60881a.C();
            }
            int i4 = this.f60884d;
            this.f60884d = i4 + 1;
            if (i4 % 2 != 0) {
                return this.f60885e & 15;
            }
            int iW = this.f60881a.w();
            this.f60885e = iW;
            return (iW & 240) >> 4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f60886a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f60887b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f60888c;

        public f(int i3, long j3, int i4) {
            this.f60886a = i3;
            this.f60887b = j3;
            this.f60888c = i4;
        }
    }

    private static int a(int i3) {
        if (i3 == 1936684398) {
            return 1;
        }
        if (i3 == 1986618469) {
            return 2;
        }
        if (i3 == 1952807028 || i3 == 1935832172 || i3 == 1937072756 || i3 == 1668047728) {
            return 3;
        }
        return i3 == 1835365473 ? 5 : -1;
    }

    static Pair b(ah ahVar, int i3, int i4) throws ch {
        int i5 = i3 + 8;
        int i6 = -1;
        int i7 = 0;
        String strC = null;
        Integer numValueOf = null;
        while (i5 - i3 < i4) {
            ahVar.f(i5);
            int iJ = ahVar.j();
            int iJ2 = ahVar.j();
            if (iJ2 == 1718775137) {
                numValueOf = Integer.valueOf(ahVar.j());
            } else if (iJ2 == 1935894637) {
                ahVar.g(4);
                strC = ahVar.c(4);
            } else if (iJ2 == 1935894633) {
                i6 = i5;
                i7 = iJ;
            }
            i5 += iJ;
        }
        if (!"cenc".equals(strC) && !"cbc1".equals(strC) && !"cens".equals(strC) && !"cbcs".equals(strC)) {
            return null;
        }
        m8.a(numValueOf != null, "frma atom is mandatory");
        m8.a(i6 != -1, "schi atom is mandatory");
        mo moVarA = a(ahVar, i6, i7, strC);
        m8.a(moVarA != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (mo) xp.a(moVarA));
    }

    private static int c(ah ahVar) {
        ahVar.f(16);
        return ahVar.j();
    }

    private static Pair d(ah ahVar) {
        ahVar.f(8);
        int iC = j1.c(ahVar.j());
        ahVar.g(iC == 0 ? 8 : 16);
        long jY = ahVar.y();
        ahVar.g(iC == 0 ? 4 : 8);
        int iC2 = ahVar.C();
        return Pair.create(Long.valueOf(jY), "" + ((char) (((iC2 >> 10) & 31) + 96)) + ((char) (((iC2 >> 5) & 31) + 96)) + ((char) ((iC2 & 31) + 96)));
    }

    private static long e(ah ahVar) {
        ahVar.f(8);
        ahVar.g(j1.c(ahVar.j()) != 0 ? 16 : 8);
        return ahVar.y();
    }

    private static f f(ah ahVar) {
        long j3;
        ahVar.f(8);
        int iC = j1.c(ahVar.j());
        ahVar.g(iC == 0 ? 8 : 16);
        int iJ = ahVar.j();
        ahVar.g(4);
        int iD = ahVar.d();
        int i3 = iC == 0 ? 4 : 8;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            j3 = -9223372036854775807L;
            if (i5 >= i3) {
                ahVar.g(i3);
                break;
            }
            if (ahVar.c()[iD + i5] != -1) {
                long jY = iC == 0 ? ahVar.y() : ahVar.B();
                if (jY != 0) {
                    j3 = jY;
                }
            } else {
                i5++;
            }
        }
        ahVar.g(16);
        int iJ2 = ahVar.j();
        int iJ3 = ahVar.j();
        ahVar.g(4);
        int iJ4 = ahVar.j();
        int iJ5 = ahVar.j();
        if (iJ2 == 0 && iJ3 == 65536 && iJ4 == -65536 && iJ5 == 0) {
            i4 = 90;
        } else if (iJ2 == 0 && iJ3 == -65536 && iJ4 == 65536 && iJ5 == 0) {
            i4 = 270;
        } else if (iJ2 == -65536 && iJ3 == 0 && iJ4 == 0 && iJ5 == -65536) {
            i4 = SensibleDefaults.X_OFFSET;
        }
        return new f(iJ, j3, i4);
    }

    private static boolean a(long[] jArr, long j3, long j4, long j5) {
        int length = jArr.length - 1;
        return jArr[0] <= j4 && j4 < jArr[xp.a(4, 0, length)] && jArr[xp.a(jArr.length - 4, 0, length)] < j5 && j5 <= j3;
    }

    private static float c(ah ahVar, int i3) {
        ahVar.f(i3 + 8);
        return ahVar.A() / ahVar.A();
    }

    private static byte[] c(ah ahVar, int i3, int i4) {
        int i5 = i3 + 8;
        while (i5 - i3 < i4) {
            ahVar.f(i5);
            int iJ = ahVar.j();
            if (ahVar.j() == 1886547818) {
                return Arrays.copyOfRange(ahVar.c(), i5, iJ + i5);
            }
            i5 += iJ;
        }
        return null;
    }

    private static af e(ah ahVar, int i3) {
        ahVar.g(8);
        a(ahVar);
        while (ahVar.d() < i3) {
            int iD = ahVar.d();
            int iJ = ahVar.j();
            if (ahVar.j() == 1768715124) {
                ahVar.f(iD);
                return b(ahVar, iD + iJ);
            }
            ahVar.f(iD + iJ);
        }
        return null;
    }

    private static int a(ah ahVar, int i3, int i4) throws ch {
        int iD = ahVar.d();
        while (iD - i3 < i4) {
            ahVar.f(iD);
            int iJ = ahVar.j();
            m8.a(iJ > 0, "childAtomSize must be positive");
            if (ahVar.j() == 1702061171) {
                return iD;
            }
            iD += iJ;
        }
        return -1;
    }

    private static Pair d(ah ahVar, int i3, int i4) throws ch {
        Pair pairB;
        int iD = ahVar.d();
        while (iD - i3 < i4) {
            ahVar.f(iD);
            int iJ = ahVar.j();
            m8.a(iJ > 0, "childAtomSize must be positive");
            if (ahVar.j() == 1936289382 && (pairB = b(ahVar, iD, iJ)) != null) {
                return pairB;
            }
            iD += iJ;
        }
        return null;
    }

    public static void a(ah ahVar) {
        int iD = ahVar.d();
        ahVar.g(4);
        if (ahVar.j() != 1751411826) {
            iD += 4;
        }
        ahVar.f(iD);
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x0157  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.applovin.impl.ah r20, int r21, int r22, int r23, int r24, java.lang.String r25, boolean r26, com.applovin.impl.x6 r27, com.applovin.impl.k1.c r28, int r29) throws com.applovin.impl.ch {
        /*
            Method dump skipped, instruction units count: 759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.k1.a(com.applovin.impl.ah, int, int, int, int, java.lang.String, boolean, com.applovin.impl.x6, com.applovin.impl.k1$c, int):void");
    }

    private static int b(ah ahVar) {
        int iW = ahVar.w();
        int i3 = iW & 127;
        while ((iW & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) == 128) {
            iW = ahVar.w();
            i3 = (i3 << 7) | (iW & 127);
        }
        return i3;
    }

    private static af d(ah ahVar, int i3) {
        ahVar.g(12);
        while (ahVar.d() < i3) {
            int iD = ahVar.d();
            int iJ = ahVar.j();
            if (ahVar.j() == 1935766900) {
                if (iJ < 14) {
                    return null;
                }
                ahVar.g(5);
                int iW = ahVar.w();
                if (iW != 12 && iW != 13) {
                    return null;
                }
                float f3 = iW == 12 ? 240.0f : 120.0f;
                ahVar.g(1);
                return new af(new kk(f3, ahVar.w()));
            }
            ahVar.f(iD + iJ);
        }
        return null;
    }

    private static af b(ah ahVar, int i3) {
        ahVar.g(8);
        ArrayList arrayList = new ArrayList();
        while (ahVar.d() < i3) {
            af.b bVarB = gf.b(ahVar);
            if (bVarB != null) {
                arrayList.add(bVarB);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new af(arrayList);
    }

    public static af b(j1.a aVar) {
        j1.b bVarE = aVar.e(1751411826);
        j1.b bVarE2 = aVar.e(1801812339);
        j1.b bVarE3 = aVar.e(1768715124);
        if (bVarE == null || bVarE2 == null || bVarE3 == null || c(bVarE.f60575b) != 1835299937) {
            return null;
        }
        ah ahVar = bVarE2.f60575b;
        ahVar.f(12);
        int iJ = ahVar.j();
        String[] strArr = new String[iJ];
        for (int i3 = 0; i3 < iJ; i3++) {
            int iJ2 = ahVar.j();
            ahVar.g(4);
            strArr[i3] = ahVar.c(iJ2 - 8);
        }
        ah ahVar2 = bVarE3.f60575b;
        ahVar2.f(8);
        ArrayList arrayList = new ArrayList();
        while (ahVar2.a() > 8) {
            int iD = ahVar2.d();
            int iJ3 = ahVar2.j();
            int iJ4 = ahVar2.j() - 1;
            if (iJ4 >= 0 && iJ4 < iJ) {
                ed edVarA = gf.a(ahVar2, iD + iJ3, strArr[iJ4]);
                if (edVarA != null) {
                    arrayList.add(edVarA);
                }
            } else {
                oc.d("AtomParsers", "Skipped metadata with unknown key index: " + iJ4);
            }
            ahVar2.f(iD + iJ3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new af(arrayList);
    }

    private static Pair a(j1.a aVar) {
        j1.b bVarE = aVar.e(1701606260);
        if (bVarE == null) {
            return null;
        }
        ah ahVar = bVarE.f60575b;
        ahVar.f(8);
        int iC = j1.c(ahVar.j());
        int iA = ahVar.A();
        long[] jArr = new long[iA];
        long[] jArr2 = new long[iA];
        for (int i3 = 0; i3 < iA; i3++) {
            jArr[i3] = iC == 1 ? ahVar.B() : ahVar.y();
            jArr2[i3] = iC == 1 ? ahVar.s() : ahVar.j();
            if (ahVar.u() == 1) {
                ahVar.g(2);
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair a(ah ahVar, int i3) {
        ahVar.f(i3 + 12);
        ahVar.g(1);
        b(ahVar);
        ahVar.g(2);
        int iW = ahVar.w();
        if ((iW & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            ahVar.g(2);
        }
        if ((iW & 64) != 0) {
            ahVar.g(ahVar.C());
        }
        if ((iW & 32) != 0) {
            ahVar.g(2);
        }
        ahVar.g(1);
        b(ahVar);
        String strA = hf.a(ahVar.w());
        if (!"audio/mpeg".equals(strA) && !"audio/vnd.dts".equals(strA) && !"audio/vnd.dts.hd".equals(strA)) {
            ahVar.g(12);
            ahVar.g(1);
            int iB = b(ahVar);
            byte[] bArr = new byte[iB];
            ahVar.a(bArr, 0, iB);
            return Pair.create(strA, bArr);
        }
        return Pair.create(strA, null);
    }

    private static void a(ah ahVar, int i3, int i4, int i5, c cVar) {
        ahVar.f(i4 + 16);
        if (i3 == 1835365492) {
            ahVar.t();
            String strT = ahVar.t();
            if (strT != null) {
                cVar.f60875b = new e9.b().h(i5).f(strT).a();
            }
        }
    }

    private static mo a(ah ahVar, int i3, int i4, String str) {
        int i5;
        int i6;
        int i7 = i3 + 8;
        while (true) {
            byte[] bArr = null;
            if (i7 - i3 >= i4) {
                return null;
            }
            ahVar.f(i7);
            int iJ = ahVar.j();
            if (ahVar.j() == 1952804451) {
                int iC = j1.c(ahVar.j());
                ahVar.g(1);
                if (iC == 0) {
                    ahVar.g(1);
                    i6 = 0;
                    i5 = 0;
                } else {
                    int iW = ahVar.w();
                    i5 = iW & 15;
                    i6 = (iW & 240) >> 4;
                }
                boolean z2 = ahVar.w() == 1;
                int iW2 = ahVar.w();
                byte[] bArr2 = new byte[16];
                ahVar.a(bArr2, 0, 16);
                if (z2 && iW2 == 0) {
                    int iW3 = ahVar.w();
                    bArr = new byte[iW3];
                    ahVar.a(bArr, 0, iW3);
                }
                return new mo(z2, str, iW2, bArr2, i6, i5, bArr);
            }
            i7 += iJ;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x027d  */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v35 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.applovin.impl.ro a(com.applovin.impl.lo r36, com.applovin.impl.j1.a r37, com.applovin.impl.y9 r38) throws com.applovin.impl.ch {
        /*
            Method dump skipped, instruction units count: 1246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.k1.a(com.applovin.impl.lo, com.applovin.impl.j1$a, com.applovin.impl.y9):com.applovin.impl.ro");
    }

    private static c a(ah ahVar, int i3, int i4, String str, x6 x6Var, boolean z2) throws ch {
        ahVar.f(12);
        int iJ = ahVar.j();
        c cVar = new c(iJ);
        int i5 = 0;
        while (i5 < iJ) {
            int iD = ahVar.d();
            int iJ2 = ahVar.j();
            m8.a(iJ2 > 0, "childAtomSize must be positive");
            int iJ3 = ahVar.j();
            if (iJ3 == 1635148593 || iJ3 == 1635148595 || iJ3 == 1701733238 || iJ3 == 1831958048 || iJ3 == 1836070006 || iJ3 == 1752589105 || iJ3 == 1751479857 || iJ3 == 1932670515 || iJ3 == 1211250227 || iJ3 == 1987063864 || iJ3 == 1987063865 || iJ3 == 1635135537 || iJ3 == 1685479798 || iJ3 == 1685479729 || iJ3 == 1685481573 || iJ3 == 1685481521) {
                c cVar2 = cVar;
                int i6 = i5;
                a(ahVar, iJ3, iD, iJ2, i3, i4, x6Var, cVar2, i6);
                cVar = cVar2;
                i5 = i6;
            } else if (iJ3 == 1836069985 || iJ3 == 1701733217 || iJ3 == 1633889587 || iJ3 == 1700998451 || iJ3 == 1633889588 || iJ3 == 1685353315 || iJ3 == 1685353317 || iJ3 == 1685353320 || iJ3 == 1685353324 || iJ3 == 1685353336 || iJ3 == 1935764850 || iJ3 == 1935767394 || iJ3 == 1819304813 || iJ3 == 1936684916 || iJ3 == 1953984371 || iJ3 == 778924082 || iJ3 == 778924083 || iJ3 == 1835557169 || iJ3 == 1835560241 || iJ3 == 1634492771 || iJ3 == 1634492791 || iJ3 == 1970037111 || iJ3 == 1332770163 || iJ3 == 1716281667) {
                c cVar3 = cVar;
                a(ahVar, iJ3, iD, iJ2, i3, str, z2, x6Var, cVar3, i5);
                cVar = cVar3;
            } else if (iJ3 == 1414810956 || iJ3 == 1954034535 || iJ3 == 2004251764 || iJ3 == 1937010800 || iJ3 == 1664495672) {
                a(ahVar, iJ3, iD, iJ2, i3, str, cVar);
            } else if (iJ3 == 1835365492) {
                a(ahVar, iJ3, iD, i3, cVar);
            } else if (iJ3 == 1667329389) {
                cVar.f60875b = new e9.b().h(i3).f("application/x-camera-motion").a();
            }
            ahVar.f(iD + iJ2);
            i5++;
        }
        return cVar;
    }

    private static void a(ah ahVar, int i3, int i4, int i5, int i6, String str, c cVar) {
        ahVar.f(i4 + 16);
        String str2 = "application/ttml+xml";
        db dbVarA = null;
        long j3 = Long.MAX_VALUE;
        if (i3 != 1414810956) {
            if (i3 == 1954034535) {
                int i7 = i5 - 16;
                byte[] bArr = new byte[i7];
                ahVar.a(bArr, 0, i7);
                dbVarA = db.a(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i3 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i3 == 1937010800) {
                j3 = 0;
            } else if (i3 == 1664495672) {
                cVar.f60877d = 1;
                str2 = "application/x-mp4-cea-608";
            } else {
                throw new IllegalStateException();
            }
        }
        cVar.f60875b = new e9.b().h(i6).f(str2).e(str).a(j3).a(dbVarA).a();
    }

    private static lo a(j1.a aVar, j1.b bVar, long j3, x6 x6Var, boolean z2, boolean z3) throws ch {
        long[] jArr;
        long[] jArr2;
        j1.a aVarD;
        Pair pairA;
        j1.a aVar2 = (j1.a) b1.a(aVar.d(1835297121));
        int iA = a(c(((j1.b) b1.a(aVar2.e(1751411826))).f60575b));
        if (iA == -1) {
            return null;
        }
        f fVarF = f(((j1.b) b1.a(aVar.e(1953196132))).f60575b);
        long j4 = j3 == -9223372036854775807L ? fVarF.f60887b : j3;
        long jE = e(bVar.f60575b);
        long jC = j4 != -9223372036854775807L ? xp.c(j4, 1000000L, jE) : -9223372036854775807L;
        j1.a aVar3 = (j1.a) b1.a(((j1.a) b1.a(aVar2.d(1835626086))).d(1937007212));
        Pair pairD = d(((j1.b) b1.a(aVar2.e(1835296868))).f60575b);
        c cVarA = a(((j1.b) b1.a(aVar3.e(1937011556))).f60575b, fVarF.f60886a, fVarF.f60888c, (String) pairD.second, x6Var, z3);
        if (z2 || (aVarD = aVar.d(1701082227)) == null || (pairA = a(aVarD)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairA.first;
            jArr2 = (long[]) pairA.second;
            jArr = jArr3;
        }
        if (cVarA.f60875b == null) {
            return null;
        }
        return new lo(fVarF.f60886a, iA, ((Long) pairD.first).longValue(), jE, jC, cVarA.f60875b, cVarA.f60877d, cVarA.f60874a, cVarA.f60876c, jArr, jArr2);
    }

    public static Pair a(j1.b bVar) {
        ah ahVar = bVar.f60575b;
        ahVar.f(8);
        af afVarE = null;
        af afVarD = null;
        while (ahVar.a() >= 8) {
            int iD = ahVar.d();
            int iJ = ahVar.j();
            int iJ2 = ahVar.j();
            if (iJ2 == 1835365473) {
                ahVar.f(iD);
                afVarE = e(ahVar, iD + iJ);
            } else if (iJ2 == 1936553057) {
                ahVar.f(iD);
                afVarD = d(ahVar, iD + iJ);
            }
            ahVar.f(iD + iJ);
        }
        return Pair.create(afVarE, afVarD);
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01a4 A[PHI: r7
      0x01a4: PHI (r7v33 int) = (r7v32 int), (r7v34 int) binds: [B:103:0x019c, B:106:0x01a1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(com.applovin.impl.ah r21, int r22, int r23, int r24, int r25, int r26, com.applovin.impl.x6 r27, com.applovin.impl.k1.c r28, int r29) throws com.applovin.impl.ch {
        /*
            Method dump skipped, instruction units count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.k1.a(com.applovin.impl.ah, int, int, int, int, int, com.applovin.impl.x6, com.applovin.impl.k1$c, int):void");
    }

    public static List a(j1.a aVar, y9 y9Var, long j3, x6 x6Var, boolean z2, boolean z3, Function function) {
        lo loVar;
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < aVar.f60574d.size(); i3++) {
            j1.a aVar2 = (j1.a) aVar.f60574d.get(i3);
            if (aVar2.f60571a == 1953653099 && (loVar = (lo) function.apply(a(aVar2, (j1.b) b1.a(aVar.e(1836476516)), j3, x6Var, z2, z3))) != null) {
                arrayList.add(a(loVar, (j1.a) b1.a(((j1.a) b1.a(((j1.a) b1.a(aVar2.d(1835297121))).d(1835626086))).d(1937007212)), y9Var));
            }
        }
        return arrayList;
    }
}
