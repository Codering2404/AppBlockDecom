package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgcm {
    private static zzgcm zzb;
    final zzgci zza;

    private zzgcm(Context context) {
        this.zza = zzgci.zza(context);
        zzgch.zza(context);
    }

    public static final zzgcm zza(Context context) {
        zzgcm zzgcmVar;
        synchronized (zzgcm.class) {
            try {
                if (zzb == null) {
                    zzb = new zzgcm(context);
                }
                zzgcmVar = zzb;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzgcmVar;
    }

    public final void zzb(zzgcg zzgcgVar) throws IOException {
        synchronized (zzgcm.class) {
            zzgci zzgciVar = this.zza;
            zzgciVar.zzf("vendor_scoped_gpid_v2_id");
            zzgciVar.zzf("vendor_scoped_gpid_v2_creation_time");
        }
    }
}
