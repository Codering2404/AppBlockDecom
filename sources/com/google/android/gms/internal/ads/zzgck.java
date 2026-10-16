package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgck extends zzgcj {
    private static zzgck zzd;

    private zzgck(Context context) {
        super(context, "paidv1_id", "paidv1_creation_time", "PaidV1LifecycleImpl");
    }

    public static final zzgck zzh(Context context) {
        zzgck zzgckVar;
        synchronized (zzgck.class) {
            try {
                if (zzd == null) {
                    zzd = new zzgck(context);
                }
                zzgckVar = zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgckVar;
    }

    public final zzgcg zzi(long j3, boolean z2) throws IOException {
        zzgcg zzgcgVarZza;
        synchronized (zzgck.class) {
            zzgcgVarZza = zza(null, null, j3, z2);
        }
        return zzgcgVarZza;
    }

    public final zzgcg zzj(String str, String str2, long j3, boolean z2) throws IOException {
        zzgcg zzgcgVarZza;
        synchronized (zzgck.class) {
            zzgcgVarZza = zza(str, str2, j3, z2);
        }
        return zzgcgVarZza;
    }

    public final void zzk() throws IOException {
        synchronized (zzgck.class) {
            zzc(false);
        }
    }

    public final void zzl() throws IOException {
        synchronized (zzgck.class) {
            zzc(true);
        }
    }
}
