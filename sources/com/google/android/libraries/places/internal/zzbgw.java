package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbgw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile zzbml f76230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile zzbml f76231b;

    private zzbgw() {
    }

    public static zzbml a() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f76230a;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbgw.class) {
            try {
                zzbmlVarF = f76230a;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.internal.maps.gmpsdksbackend.v1.GmpSdksBackendService", "InitMapsJwt"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzbgy.H()));
                    zzbmhVarI.b(zzcds.a(zzbha.I()));
                    zzbmlVarF = zzbmhVarI.f();
                    f76230a = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbml b() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f76231b;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbgw.class) {
            try {
                zzbmlVarF = f76231b;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.internal.maps.gmpsdksbackend.v1.GmpSdksBackendService", "GetPlaceWidgetMetadata"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzbgt.H()));
                    zzbmhVarI.b(zzcds.a(zzbhc.H()));
                    zzbmlVarF = zzbmhVarI.f();
                    f76231b = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbgv c(zzbit zzbitVar) {
        return (zzbgv) zzcdu.e(new zzbgu(), zzbitVar, zzbis.f76259h);
    }
}
