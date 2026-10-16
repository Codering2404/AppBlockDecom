package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.facebook.appevents.AppEventsConstants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzezh implements zzfci {
    public final String zza;
    public final boolean zzb;

    public zzezh(String str, boolean z2) {
        this.zza = str;
        this.zzb = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zza);
        if (this.zzb) {
            bundle.putString("de", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
    }
}
