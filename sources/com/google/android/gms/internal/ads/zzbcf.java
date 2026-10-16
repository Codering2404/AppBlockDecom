package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbcf extends zzbdf {
    private static final zzbdg zzh = new zzbdg();
    private final Context zzi;

    public zzbcf(zzbbs zzbbsVar, String str, String str2, zzaxm zzaxmVar, int i3, int i4, Context context) {
        super(zzbbsVar, "00Zqkn2vthPYFLR6iH1rsdxNkw6KyQ/MlAMxaONveqkDgXIjpGg039P2HSigYq2Q", "KTJvuGh/PMe9EapQHUkRl8FZKF5qWyAzLDZ/DWV/log=", zzaxmVar, i3, 29);
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzp("E");
        Context context = this.zzi;
        AtomicReference atomicReferenceZza = zzh.zza(context.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                try {
                    if (atomicReferenceZza.get() == null) {
                        atomicReferenceZza.set((String) this.zze.invoke(null, context));
                    }
                } finally {
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        zzaxm zzaxmVar = this.zzd;
        synchronized (zzaxmVar) {
            zzaxmVar.zzp(zzazi.zza(str.getBytes(), true));
        }
    }
}
