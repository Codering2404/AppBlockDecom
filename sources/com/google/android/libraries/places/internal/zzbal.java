package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile zzbml f75970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile zzbml f75971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile zzbml f75972c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile zzbml f75973d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile zzbml f75974e;

    private zzbal() {
    }

    public static zzbml a() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f75970a;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbal.class) {
            try {
                zzbmlVarF = f75970a;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.maps.places.v1.Places", "SearchNearby"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzbbi.H()));
                    zzbmhVarI.b(zzcds.a(zzbbk.I()));
                    zzbmlVarF = zzbmhVarI.f();
                    f75970a = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbml b() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f75971b;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbal.class) {
            try {
                zzbmlVarF = f75971b;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.maps.places.v1.Places", "SearchText"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzbbu.H()));
                    zzbmhVarI.b(zzcds.a(zzbbw.K()));
                    zzbmlVarF = zzbmhVarI.f();
                    f75971b = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbml c() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f75972c;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbal.class) {
            try {
                zzbmlVarF = f75972c;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.maps.places.v1.Places", "GetPhotoMedia"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzayg.H()));
                    zzbmhVarI.b(zzcds.a(zzayo.H()));
                    zzbmlVarF = zzbmhVarI.f();
                    f75972c = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbml d() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f75973d;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbal.class) {
            try {
                zzbmlVarF = f75973d;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.maps.places.v1.Places", "GetPlace"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzayi.H()));
                    zzbmhVarI.b(zzcds.a(zzbai.q1()));
                    zzbmlVarF = zzbmhVarI.f();
                    f75973d = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbml e() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f75974e;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbal.class) {
            try {
                zzbmlVarF = f75974e;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.maps.places.v1.Places", "AutocompletePlaces"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzawm.H()));
                    zzbmhVarI.b(zzcds.a(zzaxa.H()));
                    zzbmlVarF = zzbmhVarI.f();
                    f75974e = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbak f(zzbit zzbitVar) {
        return (zzbak) zzcdu.e(new zzbaj(), zzbitVar, zzbis.f76259h);
    }
}
