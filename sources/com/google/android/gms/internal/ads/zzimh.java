package com.google.android.gms.internal.ads;

import android.util.Log;
import com.revenuecat.purchases.common.Constants;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzimh extends zzimm {
    final String zza;

    public zzimh(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzimm
    public final void zza(String str) {
        String str2 = this.zza;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
