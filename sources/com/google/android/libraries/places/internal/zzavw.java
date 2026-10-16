package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzavw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile zzbml f75906a;

    private zzavw() {
    }

    public static zzbml a() {
        zzbml zzbmlVarF;
        zzbml zzbmlVar = f75906a;
        if (zzbmlVar != null) {
            return zzbmlVar;
        }
        synchronized (zzavw.class) {
            try {
                zzbmlVarF = f75906a;
                if (zzbmlVarF == null) {
                    zzbmh zzbmhVarI = zzbml.i(null, null);
                    zzbmhVarI.c(zzbmj.UNARY);
                    zzbmhVarI.d(zzbml.h("google.maps.geocode.v4.GeocodeService", "GeocodeLocation"));
                    zzbmhVarI.e(true);
                    zzbmhVarI.a(zzcds.a(zzavn.H()));
                    zzbmhVarI.b(zzcds.a(zzavp.H()));
                    zzbmlVarF = zzbmhVarI.f();
                    f75906a = zzbmlVarF;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzbmlVarF;
    }

    public static zzavv b(zzbit zzbitVar) {
        return (zzavv) zzcdt.e(new zzavu(), zzbitVar, zzbis.f76259h);
    }
}
