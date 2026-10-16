package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzmo implements zzmg {
    public final zzxf zza;
    public int zzd;
    public boolean zze;
    public final List zzc = new ArrayList();
    public final Object zzb = new Object();

    public zzmo(zzxm zzxmVar, boolean z2) {
        this.zza = new zzxf(zzxmVar, z2);
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final Object zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzmg
    public final zzbf zzb() {
        return this.zza.zzz();
    }

    public final void zzc(int i3) {
        this.zzd = i3;
        this.zze = false;
        this.zzc.clear();
    }
}
