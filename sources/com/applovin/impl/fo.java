package com.applovin.impl;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.applovin.impl.db;
import com.applovin.impl.fo;
import com.applovin.impl.o2;
import com.applovin.impl.sd;
import com.applovin.impl.u;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class fo implements o2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fo f59732a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o2.a f59733b = new o2.a() { // from class: com.applovin.impl.cx
        @Override // com.applovin.impl.o2.a
        public final o2 a(Bundle bundle) {
            return fo.a(bundle);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends fo {
        a() {
        }

        @Override // com.applovin.impl.fo
        public int a() {
            return 0;
        }

        @Override // com.applovin.impl.fo
        public int b() {
            return 0;
        }

        @Override // com.applovin.impl.fo
        public int a(Object obj) {
            return -1;
        }

        @Override // com.applovin.impl.fo
        public Object b(int i3) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.applovin.impl.fo
        public d a(int i3, d dVar, long j3) {
            throw new IndexOutOfBoundsException();
        }

        @Override // com.applovin.impl.fo
        public b a(int i3, b bVar, boolean z2) {
            throw new IndexOutOfBoundsException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class b implements o2 {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final o2.a f59734i = new o2.a() { // from class: com.applovin.impl.dx
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return fo.b.a(bundle);
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f59735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f59736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f59737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f59738d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f59739f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f59740g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private u f59741h = u.f64003h;

        private static String g(int i3) {
            return Integer.toString(i3, 36);
        }

        public long c(int i3) {
            return this.f59741h.a(i3).f64018g;
        }

        public int d(int i3) {
            return this.f59741h.a(i3).a();
        }

        public long e() {
            return this.f59739f;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && b.class.equals(obj.getClass())) {
                b bVar = (b) obj;
                if (xp.a(this.f59735a, bVar.f59735a) && xp.a(this.f59736b, bVar.f59736b) && this.f59737c == bVar.f59737c && this.f59738d == bVar.f59738d && this.f59739f == bVar.f59739f && this.f59740g == bVar.f59740g && xp.a(this.f59741h, bVar.f59741h)) {
                    return true;
                }
            }
            return false;
        }

        public int f() {
            return this.f59741h.f64010f;
        }

        public int hashCode() {
            Object obj = this.f59735a;
            int iHashCode = ((obj == null ? 0 : obj.hashCode()) + 217) * 31;
            Object obj2 = this.f59736b;
            int iHashCode2 = (((iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31) + this.f59737c) * 31;
            long j3 = this.f59738d;
            int i3 = (iHashCode2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f59739f;
            return ((((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + (this.f59740g ? 1 : 0)) * 31) + this.f59741h.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b a(Bundle bundle) {
            int i3 = bundle.getInt(g(0), 0);
            long j3 = bundle.getLong(g(1), -9223372036854775807L);
            long j4 = bundle.getLong(g(2), 0L);
            boolean z2 = bundle.getBoolean(g(3));
            Bundle bundle2 = bundle.getBundle(g(4));
            u uVar = bundle2 != null ? (u) u.f64005j.a(bundle2) : u.f64003h;
            b bVar = new b();
            bVar.a(null, null, i3, j3, j4, uVar, z2);
            return bVar;
        }

        public int b(long j3) {
            return this.f59741h.b(j3, this.f59738d);
        }

        public long c() {
            return this.f59738d;
        }

        public long d() {
            return t2.b(this.f59739f);
        }

        public boolean e(int i3) {
            return !this.f59741h.a(i3).b();
        }

        public boolean f(int i3) {
            return this.f59741h.a(i3).f64019h;
        }

        public long b(int i3) {
            return this.f59741h.a(i3).f64013a;
        }

        public long b() {
            return this.f59741h.f64008c;
        }

        public int b(int i3, int i4) {
            return this.f59741h.a(i3).a(i4);
        }

        public int a(int i3) {
            return this.f59741h.a(i3).f64014b;
        }

        public long a(int i3, int i4) {
            u.a aVarA = this.f59741h.a(i3);
            if (aVarA.f64014b != -1) {
                return aVarA.f64017f[i4];
            }
            return -9223372036854775807L;
        }

        public int a() {
            return this.f59741h.f64007b;
        }

        public int a(long j3) {
            return this.f59741h.a(j3, this.f59738d);
        }

        public b a(Object obj, Object obj2, int i3, long j3, long j4) {
            return a(obj, obj2, i3, j3, j4, u.f64003h, false);
        }

        public b a(Object obj, Object obj2, int i3, long j3, long j4, u uVar, boolean z2) {
            this.f59735a = obj;
            this.f59736b = obj2;
            this.f59737c = i3;
            this.f59738d = j3;
            this.f59739f = j4;
            this.f59741h = uVar;
            this.f59740g = z2;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class d implements o2 {

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final Object f59746s = new Object();

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private static final Object f59747t = new Object();

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private static final sd f59748u = new sd.c().b("com.applovin.exoplayer2.Timeline").a(Uri.EMPTY).a();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final o2.a f59749v = new o2.a() { // from class: com.applovin.impl.ex
            @Override // com.applovin.impl.o2.a
            public final o2 a(Bundle bundle) {
                return fo.d.a(bundle);
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f59751b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f59753d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f59754f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f59755g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f59756h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f59757i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f59758j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f59759k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public sd.f f59760l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f59761m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f59762n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f59763o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f59764p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f59765q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f59766r;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f59750a = f59746s;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public sd f59752c = f59748u;

        /* JADX INFO: Access modifiers changed from: private */
        public static d a(Bundle bundle) {
            Bundle bundle2 = bundle.getBundle(a(1));
            sd sdVar = bundle2 != null ? (sd) sd.f63034h.a(bundle2) : null;
            long j3 = bundle.getLong(a(2), -9223372036854775807L);
            long j4 = bundle.getLong(a(3), -9223372036854775807L);
            long j5 = bundle.getLong(a(4), -9223372036854775807L);
            boolean z2 = bundle.getBoolean(a(5), false);
            boolean z3 = bundle.getBoolean(a(6), false);
            Bundle bundle3 = bundle.getBundle(a(7));
            sd.f fVar = bundle3 != null ? (sd.f) sd.f.f63078h.a(bundle3) : null;
            boolean z4 = bundle.getBoolean(a(8), false);
            long j6 = bundle.getLong(a(9), 0L);
            long j7 = bundle.getLong(a(10), -9223372036854775807L);
            int i3 = bundle.getInt(a(11), 0);
            int i4 = bundle.getInt(a(12), 0);
            long j8 = bundle.getLong(a(13), 0L);
            d dVar = new d();
            dVar.a(f59747t, sdVar, null, j3, j4, j5, z2, z3, fVar, j6, j7, i3, i4, j8);
            dVar.f59761m = z4;
            return dVar;
        }

        public long c() {
            return this.f59762n;
        }

        public long d() {
            return t2.b(this.f59763o);
        }

        public boolean e() {
            b1.b(this.f59759k == (this.f59760l != null));
            return this.f59760l != null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && d.class.equals(obj.getClass())) {
                d dVar = (d) obj;
                if (xp.a(this.f59750a, dVar.f59750a) && xp.a(this.f59752c, dVar.f59752c) && xp.a(this.f59753d, dVar.f59753d) && xp.a(this.f59760l, dVar.f59760l) && this.f59754f == dVar.f59754f && this.f59755g == dVar.f59755g && this.f59756h == dVar.f59756h && this.f59757i == dVar.f59757i && this.f59758j == dVar.f59758j && this.f59761m == dVar.f59761m && this.f59762n == dVar.f59762n && this.f59763o == dVar.f59763o && this.f59764p == dVar.f59764p && this.f59765q == dVar.f59765q && this.f59766r == dVar.f59766r) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            int iHashCode = (((this.f59750a.hashCode() + 217) * 31) + this.f59752c.hashCode()) * 31;
            Object obj = this.f59753d;
            int iHashCode2 = (iHashCode + (obj == null ? 0 : obj.hashCode())) * 31;
            sd.f fVar = this.f59760l;
            int iHashCode3 = fVar != null ? fVar.hashCode() : 0;
            long j3 = this.f59754f;
            int i3 = (((iHashCode2 + iHashCode3) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j4 = this.f59755g;
            int i4 = (i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31;
            long j5 = this.f59756h;
            int i5 = (((((((i4 + ((int) (j5 ^ (j5 >>> 32)))) * 31) + (this.f59757i ? 1 : 0)) * 31) + (this.f59758j ? 1 : 0)) * 31) + (this.f59761m ? 1 : 0)) * 31;
            long j6 = this.f59762n;
            int i6 = (i5 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
            long j7 = this.f59763o;
            int i7 = (((((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + this.f59764p) * 31) + this.f59765q) * 31;
            long j8 = this.f59766r;
            return i7 + ((int) (j8 ^ (j8 >>> 32)));
        }

        public long b() {
            return t2.b(this.f59762n);
        }

        public long a() {
            return xp.a(this.f59756h);
        }

        private static String a(int i3) {
            return Integer.toString(i3, 36);
        }

        public d a(Object obj, sd sdVar, Object obj2, long j3, long j4, long j5, boolean z2, boolean z3, sd.f fVar, long j6, long j7, int i3, int i4, long j8) {
            sd.g gVar;
            this.f59750a = obj;
            this.f59752c = sdVar != null ? sdVar : f59748u;
            this.f59751b = (sdVar == null || (gVar = sdVar.f63036b) == null) ? null : gVar.f63095g;
            this.f59753d = obj2;
            this.f59754f = j3;
            this.f59755g = j4;
            this.f59756h = j5;
            this.f59757i = z2;
            this.f59758j = z3;
            this.f59759k = fVar != null;
            this.f59760l = fVar;
            this.f59762n = j6;
            this.f59763o = j7;
            this.f59764p = i3;
            this.f59765q = i4;
            this.f59766r = j8;
            this.f59761m = false;
            return this;
        }
    }

    protected fo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static fo a(Bundle bundle) {
        db dbVarA = a(d.f59749v, n2.a(bundle, c(0)));
        db dbVarA2 = a(b.f59734i, n2.a(bundle, c(1)));
        int[] intArray = bundle.getIntArray(c(2));
        if (intArray == null) {
            intArray = a(dbVarA.size());
        }
        return new c(dbVarA, dbVarA2, intArray);
    }

    public abstract int a();

    public abstract int a(Object obj);

    public abstract b a(int i3, b bVar, boolean z2);

    public abstract d a(int i3, d dVar, long j3);

    public abstract int b();

    public abstract Object b(int i3);

    public final boolean c() {
        return b() == 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fo)) {
            return false;
        }
        fo foVar = (fo) obj;
        if (foVar.b() != b() || foVar.a() != a()) {
            return false;
        }
        d dVar = new d();
        b bVar = new b();
        d dVar2 = new d();
        b bVar2 = new b();
        for (int i3 = 0; i3 < b(); i3++) {
            if (!a(i3, dVar).equals(foVar.a(i3, dVar2))) {
                return false;
            }
        }
        for (int i4 = 0; i4 < a(); i4++) {
            if (!a(i4, bVar, true).equals(foVar.a(i4, bVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        d dVar = new d();
        b bVar = new b();
        int iB = b() + 217;
        for (int i3 = 0; i3 < b(); i3++) {
            iB = (iB * 31) + a(i3, dVar).hashCode();
        }
        int iA = (iB * 31) + a();
        for (int i4 = 0; i4 < a(); i4++) {
            iA = (iA * 31) + a(i4, bVar, true).hashCode();
        }
        return iA;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class c extends fo {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final db f59742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final db f59743d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int[] f59744f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int[] f59745g;

        public c(db dbVar, db dbVar2, int[] iArr) {
            b1.a(dbVar.size() == iArr.length);
            this.f59742c = dbVar;
            this.f59743d = dbVar2;
            this.f59744f = iArr;
            this.f59745g = new int[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                this.f59745g[iArr[i3]] = i3;
            }
        }

        @Override // com.applovin.impl.fo
        public int a(boolean z2) {
            if (c()) {
                return -1;
            }
            if (z2) {
                return this.f59744f[0];
            }
            return 0;
        }

        @Override // com.applovin.impl.fo
        public int b(boolean z2) {
            if (c()) {
                return -1;
            }
            return z2 ? this.f59744f[b() - 1] : b() - 1;
        }

        @Override // com.applovin.impl.fo
        public int a(int i3, int i4, boolean z2) {
            if (i4 == 1) {
                return i3;
            }
            if (i3 != b(z2)) {
                return z2 ? this.f59744f[this.f59745g[i3] + 1] : i3 + 1;
            }
            if (i4 == 2) {
                return a(z2);
            }
            return -1;
        }

        @Override // com.applovin.impl.fo
        public int b(int i3, int i4, boolean z2) {
            if (i4 == 1) {
                return i3;
            }
            if (i3 != a(z2)) {
                return z2 ? this.f59744f[this.f59745g[i3] - 1] : i3 - 1;
            }
            if (i4 == 2) {
                return b(z2);
            }
            return -1;
        }

        @Override // com.applovin.impl.fo
        public b a(int i3, b bVar, boolean z2) {
            b bVar2 = (b) this.f59743d.get(i3);
            bVar.a(bVar2.f59735a, bVar2.f59736b, bVar2.f59737c, bVar2.f59738d, bVar2.f59739f, bVar2.f59741h, bVar2.f59740g);
            return bVar;
        }

        @Override // com.applovin.impl.fo
        public int b() {
            return this.f59742c.size();
        }

        @Override // com.applovin.impl.fo
        public Object b(int i3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.applovin.impl.fo
        public int a() {
            return this.f59743d.size();
        }

        @Override // com.applovin.impl.fo
        public d a(int i3, d dVar, long j3) {
            d dVar2 = (d) this.f59742c.get(i3);
            dVar.a(dVar2.f59750a, dVar2.f59752c, dVar2.f59753d, dVar2.f59754f, dVar2.f59755g, dVar2.f59756h, dVar2.f59757i, dVar2.f59758j, dVar2.f59760l, dVar2.f59762n, dVar2.f59763o, dVar2.f59764p, dVar2.f59765q, dVar2.f59766r);
            dVar.f59761m = dVar2.f59761m;
            return dVar;
        }

        @Override // com.applovin.impl.fo
        public int a(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    private static String c(int i3) {
        return Integer.toString(i3, 36);
    }

    public int b(boolean z2) {
        if (c()) {
            return -1;
        }
        return b() - 1;
    }

    public int b(int i3, int i4, boolean z2) {
        if (i4 == 0) {
            if (i3 == a(z2)) {
                return -1;
            }
            return i3 - 1;
        }
        if (i4 == 1) {
            return i3;
        }
        if (i4 == 2) {
            return i3 == a(z2) ? b(z2) : i3 - 1;
        }
        throw new IllegalStateException();
    }

    public final boolean b(int i3, b bVar, d dVar, int i4, boolean z2) {
        return a(i3, bVar, dVar, i4, z2) == -1;
    }

    private static db a(o2.a aVar, IBinder iBinder) {
        if (iBinder == null) {
            return db.h();
        }
        db.a aVar2 = new db.a();
        db dbVarA = m2.a(iBinder);
        for (int i3 = 0; i3 < dbVarA.size(); i3++) {
            aVar2.b(aVar.a((Bundle) dbVarA.get(i3)));
        }
        return aVar2.a();
    }

    private static int[] a(int i3) {
        int[] iArr = new int[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i4] = i4;
        }
        return iArr;
    }

    public int a(boolean z2) {
        return c() ? -1 : 0;
    }

    public final int a(int i3, b bVar, d dVar, int i4, boolean z2) {
        int i5 = a(i3, bVar).f59737c;
        if (a(i5, dVar).f59765q != i3) {
            return i3 + 1;
        }
        int iA = a(i5, i4, z2);
        if (iA == -1) {
            return -1;
        }
        return a(iA, dVar).f59764p;
    }

    public int a(int i3, int i4, boolean z2) {
        if (i4 == 0) {
            if (i3 == b(z2)) {
                return -1;
            }
            return i3 + 1;
        }
        if (i4 == 1) {
            return i3;
        }
        if (i4 == 2) {
            return i3 == b(z2) ? a(z2) : i3 + 1;
        }
        throw new IllegalStateException();
    }

    public final b a(int i3, b bVar) {
        return a(i3, bVar, false);
    }

    public b a(Object obj, b bVar) {
        return a(a(obj), bVar, true);
    }

    public final Pair a(d dVar, b bVar, int i3, long j3) {
        return (Pair) b1.a(a(dVar, bVar, i3, j3, 0L));
    }

    public final Pair a(d dVar, b bVar, int i3, long j3, long j4) {
        b1.a(i3, 0, b());
        a(i3, dVar, j4);
        if (j3 == -9223372036854775807L) {
            j3 = dVar.c();
            if (j3 == -9223372036854775807L) {
                return null;
            }
        }
        int i4 = dVar.f59764p;
        a(i4, bVar);
        while (i4 < dVar.f59765q && bVar.f59739f != j3) {
            int i5 = i4 + 1;
            if (a(i5, bVar).f59739f > j3) {
                break;
            }
            i4 = i5;
        }
        a(i4, bVar, true);
        long jMin = j3 - bVar.f59739f;
        long j5 = bVar.f59738d;
        if (j5 != -9223372036854775807L) {
            jMin = Math.min(jMin, j5 - 1);
        }
        return Pair.create(b1.a(bVar.f59736b), Long.valueOf(Math.max(0L, jMin)));
    }

    public final d a(int i3, d dVar) {
        return a(i3, dVar, 0L);
    }
}
