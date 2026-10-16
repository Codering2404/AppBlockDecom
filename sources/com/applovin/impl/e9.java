package com.applovin.impl;

import android.os.Bundle;
import com.applovin.impl.o2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class e9 implements o2 {
    private static final e9 H = new b().a();
    public static final o2.a I = new o2.a() { // from class: com.applovin.impl.xu
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return e9.a(bundle);
        }
    };
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    private int G;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f59383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f59386d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f59387f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f59388g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f59389h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f59390i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f59391j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final af f59392k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f59393l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f59394m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f59395n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final List f59396o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final x6 f59397p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f59398q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f59399r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f59400s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final float f59401t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f59402u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final float f59403v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final byte[] f59404w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f59405x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r3 f59406y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f59407z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b {
        private int A;
        private int B;
        private int C;
        private int D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f59408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f59409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f59410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f59411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f59412e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f59413f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f59414g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private String f59415h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private af f59416i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f59417j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f59418k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f59419l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private List f59420m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private x6 f59421n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private long f59422o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private int f59423p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private int f59424q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private float f59425r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private int f59426s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private float f59427t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private byte[] f59428u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private int f59429v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        private r3 f59430w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        private int f59431x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        private int f59432y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        private int f59433z;

        public b() {
            this.f59413f = -1;
            this.f59414g = -1;
            this.f59419l = -1;
            this.f59422o = Long.MAX_VALUE;
            this.f59423p = -1;
            this.f59424q = -1;
            this.f59425r = -1.0f;
            this.f59427t = 1.0f;
            this.f59429v = -1;
            this.f59431x = -1;
            this.f59432y = -1;
            this.f59433z = -1;
            this.C = -1;
            this.D = 0;
        }

        public b a(int i3) {
            this.C = i3;
            return this;
        }

        public b b(int i3) {
            this.f59413f = i3;
            return this;
        }

        public b c(int i3) {
            this.f59431x = i3;
            return this;
        }

        public b d(int i3) {
            this.D = i3;
            return this;
        }

        public b e(int i3) {
            this.A = i3;
            return this;
        }

        public b f(int i3) {
            this.B = i3;
            return this;
        }

        public b g(int i3) {
            this.f59424q = i3;
            return this;
        }

        public b h(int i3) {
            this.f59408a = Integer.toString(i3);
            return this;
        }

        public b i(int i3) {
            this.f59419l = i3;
            return this;
        }

        public b j(int i3) {
            this.f59433z = i3;
            return this;
        }

        public b k(int i3) {
            this.f59414g = i3;
            return this;
        }

        public b l(int i3) {
            this.f59412e = i3;
            return this;
        }

        public b m(int i3) {
            this.f59426s = i3;
            return this;
        }

        public b n(int i3) {
            this.f59432y = i3;
            return this;
        }

        public b o(int i3) {
            this.f59411d = i3;
            return this;
        }

        public b p(int i3) {
            this.f59429v = i3;
            return this;
        }

        public b q(int i3) {
            this.f59423p = i3;
            return this;
        }

        public b a(String str) {
            this.f59415h = str;
            return this;
        }

        public b b(String str) {
            this.f59417j = str;
            return this;
        }

        public b c(String str) {
            this.f59408a = str;
            return this;
        }

        public b d(String str) {
            this.f59409b = str;
            return this;
        }

        public b e(String str) {
            this.f59410c = str;
            return this;
        }

        public b f(String str) {
            this.f59418k = str;
            return this;
        }

        public b a(r3 r3Var) {
            this.f59430w = r3Var;
            return this;
        }

        public b b(float f3) {
            this.f59427t = f3;
            return this;
        }

        public b a(x6 x6Var) {
            this.f59421n = x6Var;
            return this;
        }

        public b a(float f3) {
            this.f59425r = f3;
            return this;
        }

        public b a(List list) {
            this.f59420m = list;
            return this;
        }

        public b a(af afVar) {
            this.f59416i = afVar;
            return this;
        }

        public b a(byte[] bArr) {
            this.f59428u = bArr;
            return this;
        }

        public b a(long j3) {
            this.f59422o = j3;
            return this;
        }

        public e9 a() {
            return new e9(this);
        }

        private b(e9 e9Var) {
            this.f59408a = e9Var.f59383a;
            this.f59409b = e9Var.f59384b;
            this.f59410c = e9Var.f59385c;
            this.f59411d = e9Var.f59386d;
            this.f59412e = e9Var.f59387f;
            this.f59413f = e9Var.f59388g;
            this.f59414g = e9Var.f59389h;
            this.f59415h = e9Var.f59391j;
            this.f59416i = e9Var.f59392k;
            this.f59417j = e9Var.f59393l;
            this.f59418k = e9Var.f59394m;
            this.f59419l = e9Var.f59395n;
            this.f59420m = e9Var.f59396o;
            this.f59421n = e9Var.f59397p;
            this.f59422o = e9Var.f59398q;
            this.f59423p = e9Var.f59399r;
            this.f59424q = e9Var.f59400s;
            this.f59425r = e9Var.f59401t;
            this.f59426s = e9Var.f59402u;
            this.f59427t = e9Var.f59403v;
            this.f59428u = e9Var.f59404w;
            this.f59429v = e9Var.f59405x;
            this.f59430w = e9Var.f59406y;
            this.f59431x = e9Var.f59407z;
            this.f59432y = e9Var.A;
            this.f59433z = e9Var.B;
            this.A = e9Var.C;
            this.B = e9Var.D;
            this.C = e9Var.E;
            this.D = e9Var.F;
        }
    }

    private e9(b bVar) {
        this.f59383a = bVar.f59408a;
        this.f59384b = bVar.f59409b;
        this.f59385c = xp.f(bVar.f59410c);
        this.f59386d = bVar.f59411d;
        this.f59387f = bVar.f59412e;
        int i3 = bVar.f59413f;
        this.f59388g = i3;
        int i4 = bVar.f59414g;
        this.f59389h = i4;
        this.f59390i = i4 != -1 ? i4 : i3;
        this.f59391j = bVar.f59415h;
        this.f59392k = bVar.f59416i;
        this.f59393l = bVar.f59417j;
        this.f59394m = bVar.f59418k;
        this.f59395n = bVar.f59419l;
        this.f59396o = bVar.f59420m == null ? Collections.EMPTY_LIST : bVar.f59420m;
        x6 x6Var = bVar.f59421n;
        this.f59397p = x6Var;
        this.f59398q = bVar.f59422o;
        this.f59399r = bVar.f59423p;
        this.f59400s = bVar.f59424q;
        this.f59401t = bVar.f59425r;
        this.f59402u = bVar.f59426s == -1 ? 0 : bVar.f59426s;
        this.f59403v = bVar.f59427t == -1.0f ? 1.0f : bVar.f59427t;
        this.f59404w = bVar.f59428u;
        this.f59405x = bVar.f59429v;
        this.f59406y = bVar.f59430w;
        this.f59407z = bVar.f59431x;
        this.A = bVar.f59432y;
        this.B = bVar.f59433z;
        this.C = bVar.A == -1 ? 0 : bVar.A;
        this.D = bVar.B != -1 ? bVar.B : 0;
        this.E = bVar.C;
        if (bVar.D != 0 || x6Var == null) {
            this.F = bVar.D;
        } else {
            this.F = 1;
        }
    }

    private static Object a(Object obj, Object obj2) {
        return obj != null ? obj : obj2;
    }

    private static String c(int i3) {
        return b(12) + "_" + Integer.toString(i3, 36);
    }

    public boolean equals(Object obj) {
        int i3;
        if (this == obj) {
            return true;
        }
        if (obj != null && e9.class == obj.getClass()) {
            e9 e9Var = (e9) obj;
            int i4 = this.G;
            if ((i4 == 0 || (i3 = e9Var.G) == 0 || i4 == i3) && this.f59386d == e9Var.f59386d && this.f59387f == e9Var.f59387f && this.f59388g == e9Var.f59388g && this.f59389h == e9Var.f59389h && this.f59395n == e9Var.f59395n && this.f59398q == e9Var.f59398q && this.f59399r == e9Var.f59399r && this.f59400s == e9Var.f59400s && this.f59402u == e9Var.f59402u && this.f59405x == e9Var.f59405x && this.f59407z == e9Var.f59407z && this.A == e9Var.A && this.B == e9Var.B && this.C == e9Var.C && this.D == e9Var.D && this.E == e9Var.E && this.F == e9Var.F && Float.compare(this.f59401t, e9Var.f59401t) == 0 && Float.compare(this.f59403v, e9Var.f59403v) == 0 && xp.a((Object) this.f59383a, (Object) e9Var.f59383a) && xp.a((Object) this.f59384b, (Object) e9Var.f59384b) && xp.a((Object) this.f59391j, (Object) e9Var.f59391j) && xp.a((Object) this.f59393l, (Object) e9Var.f59393l) && xp.a((Object) this.f59394m, (Object) e9Var.f59394m) && xp.a((Object) this.f59385c, (Object) e9Var.f59385c) && Arrays.equals(this.f59404w, e9Var.f59404w) && xp.a(this.f59392k, e9Var.f59392k) && xp.a(this.f59406y, e9Var.f59406y) && xp.a(this.f59397p, e9Var.f59397p) && a(e9Var)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.G == 0) {
            String str = this.f59383a;
            int iHashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.f59384b;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f59385c;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f59386d) * 31) + this.f59387f) * 31) + this.f59388g) * 31) + this.f59389h) * 31;
            String str4 = this.f59391j;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            af afVar = this.f59392k;
            int iHashCode5 = (iHashCode4 + (afVar == null ? 0 : afVar.hashCode())) * 31;
            String str5 = this.f59393l;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f59394m;
            this.G = ((((((((((((((((((((((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f59395n) * 31) + ((int) this.f59398q)) * 31) + this.f59399r) * 31) + this.f59400s) * 31) + Float.floatToIntBits(this.f59401t)) * 31) + this.f59402u) * 31) + Float.floatToIntBits(this.f59403v)) * 31) + this.f59405x) * 31) + this.f59407z) * 31) + this.A) * 31) + this.B) * 31) + this.C) * 31) + this.D) * 31) + this.E) * 31) + this.F;
        }
        return this.G;
    }

    public String toString() {
        return "Format(" + this.f59383a + ", " + this.f59384b + ", " + this.f59393l + ", " + this.f59394m + ", " + this.f59391j + ", " + this.f59390i + ", " + this.f59385c + ", [" + this.f59399r + ", " + this.f59400s + ", " + this.f59401t + "], [" + this.f59407z + ", " + this.A + "])";
    }

    public e9 a(int i3) {
        return a().d(i3).a();
    }

    public int b() {
        int i3;
        int i4 = this.f59399r;
        if (i4 == -1 || (i3 = this.f59400s) == -1) {
            return -1;
        }
        return i4 * i3;
    }

    private static String b(int i3) {
        return Integer.toString(i3, 36);
    }

    public boolean a(e9 e9Var) {
        if (this.f59396o.size() != e9Var.f59396o.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.f59396o.size(); i3++) {
            if (!Arrays.equals((byte[]) this.f59396o.get(i3), (byte[]) e9Var.f59396o.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public b a() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e9 a(Bundle bundle) {
        b bVar = new b();
        p2.a(bundle);
        int i3 = 0;
        String string = bundle.getString(b(0));
        e9 e9Var = H;
        bVar.c((String) a(string, e9Var.f59383a)).d((String) a(bundle.getString(b(1)), e9Var.f59384b)).e((String) a(bundle.getString(b(2)), e9Var.f59385c)).o(bundle.getInt(b(3), e9Var.f59386d)).l(bundle.getInt(b(4), e9Var.f59387f)).b(bundle.getInt(b(5), e9Var.f59388g)).k(bundle.getInt(b(6), e9Var.f59389h)).a((String) a(bundle.getString(b(7)), e9Var.f59391j)).a((af) a((af) bundle.getParcelable(b(8)), e9Var.f59392k)).b((String) a(bundle.getString(b(9)), e9Var.f59393l)).f((String) a(bundle.getString(b(10)), e9Var.f59394m)).i(bundle.getInt(b(11), e9Var.f59395n));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(c(i3));
            if (byteArray == null) {
                b bVarA = bVar.a(arrayList).a((x6) bundle.getParcelable(b(13)));
                String strB = b(14);
                e9 e9Var2 = H;
                bVarA.a(bundle.getLong(strB, e9Var2.f59398q)).q(bundle.getInt(b(15), e9Var2.f59399r)).g(bundle.getInt(b(16), e9Var2.f59400s)).a(bundle.getFloat(b(17), e9Var2.f59401t)).m(bundle.getInt(b(18), e9Var2.f59402u)).b(bundle.getFloat(b(19), e9Var2.f59403v)).a(bundle.getByteArray(b(20))).p(bundle.getInt(b(21), e9Var2.f59405x)).a((r3) p2.a(r3.f62721g, bundle.getBundle(b(22)))).c(bundle.getInt(b(23), e9Var2.f59407z)).n(bundle.getInt(b(24), e9Var2.A)).j(bundle.getInt(b(25), e9Var2.B)).e(bundle.getInt(b(26), e9Var2.C)).f(bundle.getInt(b(27), e9Var2.D)).a(bundle.getInt(b(28), e9Var2.E)).d(bundle.getInt(b(29), e9Var2.F));
                return bVar.a();
            }
            arrayList.add(byteArray);
            i3++;
        }
    }
}
