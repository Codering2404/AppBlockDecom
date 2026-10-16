package com.google.android.gms.internal.fido;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfj {
    private static final String[] zza = {"com.google.common.flogger.util.StackWalkerStackGetter", "com.google.common.flogger.util.JavaLangAccessStackGetter"};
    private static final zzfn zzb;

    static {
        zzfn zzfoVar;
        int i3 = 0;
        while (true) {
            if (i3 >= 2) {
                zzfoVar = new zzfo();
                break;
            }
            zzfoVar = null;
            try {
                zzfoVar = (zzfn) Class.forName(zza[i3]).asSubclass(zzfn.class).getDeclaredConstructor(null).newInstance(null);
            } catch (Throwable unused) {
            }
            if (zzfoVar != null) {
                break;
            } else {
                i3++;
            }
        }
        zzb = zzfoVar;
    }

    @NullableDecl
    public static StackTraceElement zza(Class cls, int i3) {
        zzfk.zza(cls, "target");
        return zzb.zza(cls, 2);
    }
}
