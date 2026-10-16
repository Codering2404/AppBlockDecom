package com.applovin.impl;

import android.util.Pair;
import com.applovin.impl.fo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b extends fo {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f58524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final wj f58525d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f58526f;

    public b(boolean z2, wj wjVar) {
        this.f58526f = z2;
        this.f58525d = wjVar;
        this.f58524c = wjVar.a();
    }

    public static Object a(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public static Object c(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object d(Object obj) {
        return ((Pair) obj).first;
    }

    protected abstract int b(Object obj);

    @Override // com.applovin.impl.fo
    public int b(boolean z2) {
        int i3 = this.f58524c;
        if (i3 == 0) {
            return -1;
        }
        if (this.f58526f) {
            z2 = false;
        }
        int iC = z2 ? this.f58525d.c() : i3 - 1;
        while (i(iC).c()) {
            iC = b(iC, z2);
            if (iC == -1) {
                return -1;
            }
        }
        return h(iC) + i(iC).b(z2);
    }

    protected abstract int d(int i3);

    protected abstract int e(int i3);

    protected abstract Object f(int i3);

    protected abstract int g(int i3);

    protected abstract int h(int i3);

    protected abstract fo i(int i3);

    @Override // com.applovin.impl.fo
    public int a(boolean z2) {
        if (this.f58524c == 0) {
            return -1;
        }
        if (this.f58526f) {
            z2 = false;
        }
        int iB = z2 ? this.f58525d.b() : 0;
        while (i(iB).c()) {
            iB = a(iB, z2);
            if (iB == -1) {
                return -1;
            }
        }
        return h(iB) + i(iB).a(z2);
    }

    private int b(int i3, boolean z2) {
        if (z2) {
            return this.f58525d.b(i3);
        }
        if (i3 > 0) {
            return i3 - 1;
        }
        return -1;
    }

    @Override // com.applovin.impl.fo
    public final int a(Object obj) {
        int iA;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object objD = d(obj);
        Object objC = c(obj);
        int iB = b(objD);
        if (iB == -1 || (iA = i(iB).a(objC)) == -1) {
            return -1;
        }
        return g(iB) + iA;
    }

    @Override // com.applovin.impl.fo
    public int b(int i3, int i4, boolean z2) {
        if (this.f58526f) {
            if (i4 == 1) {
                i4 = 2;
            }
            z2 = false;
        }
        int iE = e(i3);
        int iH = h(iE);
        int iB = i(iE).b(i3 - iH, i4 != 2 ? i4 : 0, z2);
        if (iB != -1) {
            return iH + iB;
        }
        int iB2 = b(iE, z2);
        while (iB2 != -1 && i(iB2).c()) {
            iB2 = b(iB2, z2);
        }
        if (iB2 != -1) {
            return h(iB2) + i(iB2).b(z2);
        }
        if (i4 == 2) {
            return b(z2);
        }
        return -1;
    }

    private int a(int i3, boolean z2) {
        if (z2) {
            return this.f58525d.a(i3);
        }
        if (i3 < this.f58524c - 1) {
            return i3 + 1;
        }
        return -1;
    }

    @Override // com.applovin.impl.fo
    public int a(int i3, int i4, boolean z2) {
        if (this.f58526f) {
            if (i4 == 1) {
                i4 = 2;
            }
            z2 = false;
        }
        int iE = e(i3);
        int iH = h(iE);
        int iA = i(iE).a(i3 - iH, i4 != 2 ? i4 : 0, z2);
        if (iA != -1) {
            return iH + iA;
        }
        int iA2 = a(iE, z2);
        while (iA2 != -1 && i(iA2).c()) {
            iA2 = a(iA2, z2);
        }
        if (iA2 != -1) {
            return h(iA2) + i(iA2).a(z2);
        }
        if (i4 == 2) {
            return a(z2);
        }
        return -1;
    }

    @Override // com.applovin.impl.fo
    public final Object b(int i3) {
        int iD = d(i3);
        return a(f(iD), i(iD).b(i3 - g(iD)));
    }

    @Override // com.applovin.impl.fo
    public final fo.b a(int i3, fo.b bVar, boolean z2) {
        int iD = d(i3);
        int iH = h(iD);
        i(iD).a(i3 - g(iD), bVar, z2);
        bVar.f59737c += iH;
        if (z2) {
            bVar.f59736b = a(f(iD), b1.a(bVar.f59736b));
        }
        return bVar;
    }

    @Override // com.applovin.impl.fo
    public final fo.b a(Object obj, fo.b bVar) {
        Object objD = d(obj);
        Object objC = c(obj);
        int iB = b(objD);
        int iH = h(iB);
        i(iB).a(objC, bVar);
        bVar.f59737c += iH;
        bVar.f59736b = obj;
        return bVar;
    }

    @Override // com.applovin.impl.fo
    public final fo.d a(int i3, fo.d dVar, long j3) {
        int iE = e(i3);
        int iH = h(iE);
        int iG = g(iE);
        i(iE).a(i3 - iH, dVar, j3);
        Object objF = f(iE);
        if (!fo.d.f59746s.equals(dVar.f59750a)) {
            objF = a(objF, dVar.f59750a);
        }
        dVar.f59750a = objF;
        dVar.f59764p += iG;
        dVar.f59765q += iG;
        return dVar;
    }
}
