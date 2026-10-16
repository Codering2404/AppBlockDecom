package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbfy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f76170a = 100;

    zzbfy() {
    }

    abstract void a(Object obj, int i3, long j3);

    abstract void b(Object obj, int i3, int i4);

    abstract void c(Object obj, int i3, long j3);

    abstract void d(Object obj, int i3, zzbcl zzbclVar);

    abstract void e(Object obj, int i3, Object obj2);

    abstract Object f();

    abstract Object g(Object obj);

    abstract Object h(Object obj);

    abstract void i(Object obj, Object obj2);

    abstract void j(Object obj);

    final boolean k(Object obj, zzbfk zzbfkVar, int i3) throws zzbed {
        int iZzc = zzbfkVar.zzc();
        int i4 = iZzc >>> 3;
        int i5 = iZzc & 7;
        if (i5 == 0) {
            a(obj, i4, zzbfkVar.zzh());
            return true;
        }
        if (i5 == 1) {
            c(obj, i4, zzbfkVar.zzj());
            return true;
        }
        if (i5 == 2) {
            d(obj, i4, zzbfkVar.zzs());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                if (i3 != 0) {
                    return false;
                }
                throw new zzbed("Protocol message end-group tag did not match expected tag.");
            }
            if (i5 != 5) {
                throw new zzbec("Protocol message tag had invalid wire type.");
            }
            b(obj, i4, zzbfkVar.zzk());
            return true;
        }
        Object objF = f();
        int i6 = i4 << 3;
        int i7 = i3 + 1;
        if (i7 >= f76170a) {
            throw new zzbed("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        while (zzbfkVar.zzb() != Integer.MAX_VALUE && k(objF, zzbfkVar, i7)) {
        }
        if ((i6 | 4) != zzbfkVar.zzc()) {
            throw new zzbed("Protocol message end-group tag did not match expected tag.");
        }
        e(obj, i4, g(objF));
        return true;
    }
}
