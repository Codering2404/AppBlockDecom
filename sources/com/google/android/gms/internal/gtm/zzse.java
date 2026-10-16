package com.google.android.gms.internal.gtm;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzse {
    public static final Integer zza = 0;
    public static final Integer zzb = 1;
    private final Context zzc;
    private final ExecutorService zzd;

    public zzse(Context context) {
        ExecutorService executorServiceZza = zzgb.zza().zza(2);
        this.zzc = context;
        this.zzd = executorServiceZza;
    }
}
