package com.google.android.gms.internal.ads;

import android.view.View;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdqu {
    private final zzdzl zza;

    zzdqu(zzdzl zzdzlVar) {
        this.zza = zzdzlVar;
    }

    public final void zza(View view, zzfkf zzfkfVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzot)).booleanValue() || view == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzab.a(view) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES;
        zzdzk zzdzkVarZza = this.zza.zza();
        zzdzkVarZza.zzc("action", "hcp");
        zzdzkVarZza.zzc("hcp", str);
        zzdzkVarZza.zzb(zzfkfVar);
        zzdzkVarZza.zzd();
    }
}
