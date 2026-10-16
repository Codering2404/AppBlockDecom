package com.google.android.gms.internal.fido;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzee {
    private static final zzeg zza = zzb(zzeg.zzd);

    private static zzeg zzb(String[] strArr) {
        zzeg zzegVarZza;
        try {
            zzegVarZza = zzeh.zza();
        } catch (NoClassDefFoundError unused) {
            zzegVarZza = null;
        }
        if (zzegVarZza != null) {
            return zzegVarZza;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzeg) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
