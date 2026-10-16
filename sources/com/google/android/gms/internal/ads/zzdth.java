package com.google.android.gms.internal.ads;

import com.facebook.LegacyTokenHelper;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdth {
    private final Executor zza;
    private final zzdtc zzb;
    private final zzdzg zzc;

    zzdth(Executor executor, zzdtc zzdtcVar, zzdzg zzdzgVar) {
        this.zza = executor;
        this.zzb = zzdtcVar;
        this.zzc = zzdzgVar;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFutureZza;
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("custom_assets");
        if (jSONArrayOptJSONArray == null) {
            return zzhbw.zza(Collections.EMPTY_LIST);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcU)).booleanValue()) {
            this.zzc.zzf(zzdyu.NATIVE_ASSETS_LOADING_CUSTOM_START.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        }
        ArrayList arrayList = new ArrayList();
        int length = jSONArrayOptJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i3);
            if (jSONObjectOptJSONObject == null) {
                listenableFutureZza = zzhbw.zza(null);
            } else {
                final String strOptString = jSONObjectOptJSONObject.optString("name");
                if (strOptString == null) {
                    listenableFutureZza = zzhbw.zza(null);
                } else {
                    String strOptString2 = jSONObjectOptJSONObject.optString("type");
                    listenableFutureZza = LegacyTokenHelper.TYPE_STRING.equals(strOptString2) ? zzhbw.zza(new zzdte(strOptString, jSONObjectOptJSONObject.optString("string_value"))) : "image".equals(strOptString2) ? zzhbw.zzk(this.zzb.zza(jSONObjectOptJSONObject, "image_value", null), new zzgta() { // from class: com.google.android.gms.internal.ads.zzdtf
                        @Override // com.google.android.gms.internal.ads.zzgta
                        public final /* synthetic */ Object apply(Object obj) {
                            return new zzdte(strOptString, (zzblp) obj);
                        }
                    }, this.zza) : zzhbw.zza(null);
                }
            }
            arrayList.add(listenableFutureZza);
        }
        return zzhbw.zzk(zzhbw.zzm(arrayList), zzdtg.zza, this.zza);
    }
}
