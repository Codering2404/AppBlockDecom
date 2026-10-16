package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgug {
    public static final /* synthetic */ int zza = 0;
    private static final Object zzb;

    static {
        Object objZzc = zzc();
        zzb = objZzc;
        if (objZzc != null) {
            zze("getStackTraceElement", Throwable.class, Integer.TYPE);
        }
        if (objZzc == null) {
            return;
        }
        zzd(objZzc);
    }

    public static void zza(Throwable th, Class cls) throws Throwable {
        if (cls.isInstance(th)) {
            throw ((Throwable) cls.cast(th));
        }
    }

    public static void zzb(Throwable th) {
        if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
    }

    private static Object zzc() {
        try {
            return Class.forName("sun.misc.SharedSecrets", false, null).getMethod("getJavaLangAccess", null).invoke(null, null);
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method zzd(Object obj) {
        try {
            Method methodZze = zze("getStackTraceDepth", Throwable.class);
            if (methodZze == null) {
                return null;
            }
            methodZze.invoke(obj, new Throwable());
            return methodZze;
        } catch (IllegalAccessException | UnsupportedOperationException | InvocationTargetException unused) {
            return null;
        }
    }

    private static Method zze(String str, Class... clsArr) throws ThreadDeath {
        try {
            return Class.forName("sun.misc.JavaLangAccess", false, null).getMethod(str, clsArr);
        } catch (ThreadDeath e3) {
            throw e3;
        } catch (Throwable unused) {
            return null;
        }
    }
}
