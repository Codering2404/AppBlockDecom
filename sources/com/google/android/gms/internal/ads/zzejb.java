package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzejb implements zzdef, zzdcu {
    private static final Object zza = new Object();
    private static int zzb;
    private final com.google.android.gms.ads.internal.util.zzg zzc;
    private final zzejl zzd;

    public zzejb(zzejl zzejlVar, com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zzd = zzejlVar;
        this.zzc = zzgVar;
    }

    private final void zzb(boolean z2) {
        int i3;
        int iIntValue;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhh)).booleanValue() && !this.zzc.zzx()) {
            Object obj = zza;
            synchronized (obj) {
                i3 = zzb;
                iIntValue = ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhi)).intValue();
            }
            if (i3 < iIntValue) {
                this.zzd.zza(z2);
                synchronized (obj) {
                    zzb++;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        zzb(true);
    }
}
