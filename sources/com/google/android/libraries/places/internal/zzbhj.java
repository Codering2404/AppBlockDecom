package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbhj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile zzbml f76232a;

    private zzbhj() {
    }

    public static zzbml a() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f76232a;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzbhj.class) {
            try {
                zzbmlVarF = f76232a;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.internal.maps.mapsmobilesdks.v1.MapsMobileSDKsService", "GetSession"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzbhe.H()));
                    zzbmhVarI.b(zzcds.a(zzbhg.H()));
                    zzbmlVarF = zzbmhVarI.f();
                    f76232a = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzbhi b(zzbit zzbitVar) {
        return (zzbhi) zzcdu.e(new zzbhh(), zzbitVar, zzbis.f76259h);
    }
}
