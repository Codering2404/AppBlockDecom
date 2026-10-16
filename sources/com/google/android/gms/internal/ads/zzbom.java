package com.google.android.gms.internal.ads;

import com.applovin.impl.privacy.consentFlow.as.KLAQHFCRAUejH;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbom implements zzbpq {
    zzbom() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzd;
        zzcku zzckuVar = (zzcku) obj;
        zzblr zzblrVarZzar = zzckuVar.zzar();
        String str = KLAQHFCRAUejH.Zzmz;
        if (zzblrVarZzar == null || (jSONObjectZzd = zzblrVarZzar.zzd()) == null) {
            zzckuVar.zzd(str, new JSONObject());
        } else {
            zzckuVar.zzd(str, jSONObjectZzd);
        }
    }
}
