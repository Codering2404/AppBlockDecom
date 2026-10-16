package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdda extends zzdip implements zzdcv {
    public zzdda(Set set) {
        super(set);
    }

    @Override // com.google.android.gms.internal.ads.zzdcv
    public final void zzc(final com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzs(new zzdio() { // from class: com.google.android.gms.internal.ads.zzdcz
            @Override // com.google.android.gms.internal.ads.zzdio
            public final /* synthetic */ void zza(Object obj) {
                ((zzddh) obj).zzj(zzeVar);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcv
    public final void zzd(final zzdnn zzdnnVar) {
        zzs(new zzdio() { // from class: com.google.android.gms.internal.ads.zzdcx
            @Override // com.google.android.gms.internal.ads.zzdio
            public final /* synthetic */ void zza(Object obj) {
                zzddh zzddhVar = (zzddh) obj;
                String message = zzdnnVar.getMessage();
                if (message == null) {
                    message = "Internal show error.";
                }
                zzddhVar.zzj(zzfma.zzd(12, message, null));
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzdcv
    public final void zze() {
        zzs(zzdcy.zza);
    }
}
