package com.google.android.gms.internal.ads;

import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcwn implements zzddl {
    private final zzcku zza;
    private final zzdzl zzb;
    private final zzfkf zzc;

    zzcwn(zzcku zzckuVar, zzdzl zzdzlVar, zzfkf zzfkfVar) {
        this.zza = zzckuVar;
        this.zzb = zzdzlVar;
        this.zzc = zzfkfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzddl
    public final void zzdr() {
        zzcku zzckuVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzot)).booleanValue() || (zzckuVar = this.zza) == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzab.a(zzckuVar.zzE()) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        zzdzk zzdzkVarZza = this.zzb.zza();
        zzdzkVarZza.zzc("action", "hcp");
        zzdzkVarZza.zzc("hcp", str);
        zzdzkVarZza.zzb(this.zzc);
        zzdzkVarZza.zzd();
    }
}
