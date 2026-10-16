package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgim extends zzgix {
    private static volatile Long zza;
    private static final Object zzb = new Object();

    zzgim(zzaxm zzaxmVar, zzght zzghtVar, zzgqh zzgqhVar) {
        super("F5pwKdQUkBR2T28FTRLzecwttaHUl7VLDmgba7+ac24MPIR3NLD5sQMDLkLV832D", "Zvn3l46JDaJW0+pj8K/1DTe7U1wFUhv/KBF/UwuPk/A=", zzaxmVar, zzghtVar, zzgqhVar.zza(117));
    }

    @Override // com.google.android.gms.internal.ads.zzgix
    protected final void zza(Method method, zzaxm zzaxmVar) throws IllegalAccessException, InvocationTargetException {
        if (zza == null) {
            synchronized (zzb) {
                try {
                    if (zza == null) {
                        Long l3 = (Long) method.invoke("", null);
                        if (l3 == null) {
                            throw null;
                        }
                        zza = l3;
                    }
                } finally {
                }
            }
        }
        synchronized (zzaxmVar) {
            try {
                if (zza != null) {
                    zzaxmVar.zzm(zza.longValue());
                }
            } finally {
            }
        }
    }
}
