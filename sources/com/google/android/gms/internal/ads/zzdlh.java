package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdlh extends zzdip implements zzbqi {
    public zzdlh(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final synchronized void zza() {
        zzs(zzdlg.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzb(final zzccb zzccbVar) {
        zzs(new zzdio() { // from class: com.google.android.gms.internal.ads.zzdle
            @Override // com.google.android.gms.internal.ads.zzdio
            public final /* synthetic */ void zza(Object obj) {
                ((zzbqi) obj).zzb(zzccbVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzc() {
        zzs(zzdlf.zza);
    }
}
