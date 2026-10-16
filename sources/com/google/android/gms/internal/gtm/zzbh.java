package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbh extends com.google.android.gms.analytics.zzj {
    private int zza;

    public zzbh() {
        UUID uuidRandomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (uuidRandomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0 && (leastSignificantBits = (int) (uuidRandomUUID.getMostSignificantBits() & 2147483647L)) == 0) {
            Log.e("GAv4", "UUID.randomUUID() returned 0.");
            leastSignificantBits = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        Preconditions.o(leastSignificantBits);
        this.zza = leastSignificantBits;
    }

    public final String toString() {
        HashMap map = new HashMap();
        map.put("screenName", null);
        Boolean bool = Boolean.FALSE;
        map.put("interstitial", bool);
        map.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, bool);
        map.put("screenId", Integer.valueOf(this.zza));
        map.put("referrerScreenId", 0);
        map.put("referrerScreenName", null);
        map.put("referrerUri", null);
        return com.google.android.gms.analytics.zzj.zza(map);
    }

    @Override // com.google.android.gms.analytics.zzj
    public final /* bridge */ /* synthetic */ void zzc(com.google.android.gms.analytics.zzj zzjVar) {
        zzbh zzbhVar = (zzbh) zzjVar;
        TextUtils.isEmpty(null);
        int i3 = this.zza;
        if (i3 != 0) {
            zzbhVar.zza = i3;
        }
        TextUtils.isEmpty(null);
        if (TextUtils.isEmpty(null)) {
            return;
        }
        TextUtils.isEmpty(null);
    }

    public final int zzd() {
        return this.zza;
    }
}
