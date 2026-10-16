package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzfuk {
    public static zzfuk zze(zzful zzfulVar, zzfum zzfumVar) {
        zzfwi.zza();
        return new zzfuo(zzfulVar, zzfumVar, UUID.randomUUID().toString());
    }

    public abstract void zza();

    public abstract void zzb(View view);

    public abstract void zzc();

    public abstract void zzd(View view, zzfur zzfurVar, String str);
}
