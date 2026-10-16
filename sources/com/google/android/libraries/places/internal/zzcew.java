package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcew {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f77735a = 0;

    static {
        Object obj;
        Class<?> cls;
        zzceu zzceuVar;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
            obj = null;
        } catch (Throwable th) {
            obj = th;
            cls = null;
        }
        if (cls != null) {
            try {
                zzceuVar = (zzceu) cls.asSubclass(zzceu.class).getConstructor(zzcex.class).newInstance(zzceu.f77733a);
            } catch (Throwable th2) {
                obj = th2;
                zzceuVar = null;
            }
        } else {
            zzceuVar = null;
        }
        if (zzceuVar == null) {
            new zzceu(zzceu.f77733a);
        }
        if (obj != null) {
            try {
                if (Boolean.getBoolean("io.perfmark.PerfMark.debug")) {
                    Class<?> cls2 = Class.forName("java.util.logging.Logger");
                    Object objInvoke = cls2.getMethod("getLogger", String.class).invoke(null, zzcew.class.getName());
                    Class<?> cls3 = Class.forName("java.util.logging.Level");
                    cls2.getMethod("log", cls3, String.class, Throwable.class).invoke(objInvoke, cls3.getField("FINE").get(null), "Error during PerfMark.<clinit>", obj);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private zzcew() {
    }

    public static zzcex a(String str) {
        return zzceu.f77733a;
    }

    public static zzcev b() {
        return zzceu.f77734b;
    }
}
