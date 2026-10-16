package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfdk implements zzfci {
    private final AdvertisingIdClient.Info zza;
    private final String zzb;
    private final zzgcg zzc;

    public zzfdk(AdvertisingIdClient.Info info, String str, zzgcg zzgcgVar) {
        this.zza = info;
        this.zzb = str;
        this.zzc = zzgcgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfci
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            JSONObject jSONObjectH = com.google.android.gms.ads.internal.util.zzbp.h((JSONObject) obj, "pii");
            AdvertisingIdClient.Info info = this.zza;
            if (info == null || TextUtils.isEmpty(info.getId())) {
                String str = this.zzb;
                if (str != null) {
                    jSONObjectH.put("pdid", str);
                    jSONObjectH.put("pdidtype", "ssaid");
                    return;
                }
                return;
            }
            jSONObjectH.put("rdid", info.getId());
            jSONObjectH.put("is_lat", info.isLimitAdTrackingEnabled());
            jSONObjectH.put("idtype", "adid");
            zzgcg zzgcgVar = this.zzc;
            if (zzgcgVar.zzc()) {
                jSONObjectH.put("paidv1_id_android_3p", zzgcgVar.zza());
                jSONObjectH.put("paidv1_creation_time_android_3p", zzgcgVar.zzb());
            }
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Failed putting Ad ID.", e3);
        }
    }
}
