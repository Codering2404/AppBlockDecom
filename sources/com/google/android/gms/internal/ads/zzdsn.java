package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdsn {
    private final zzhcg zza;
    private final zzdtc zzb;
    private final zzdth zzc;
    private final zzdzg zzd;

    zzdsn(zzhcg zzhcgVar, zzdtc zzdtcVar, zzdth zzdthVar, zzdzg zzdzgVar) {
        this.zza = zzhcgVar;
        this.zzb = zzdtcVar;
        this.zzc = zzdthVar;
        this.zzd = zzdzgVar;
    }

    private final ListenableFuture zze(ListenableFuture listenableFuture, zzdyu zzdyuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcU)).booleanValue()) {
            zzhbw.zzr(listenableFuture, new zzdsk(this, zzdyuVar), this.zza);
        }
        return listenableFuture;
    }

    private static final boolean zzf(JSONObject jSONObject) {
        return jSONObject.optInt("template_id") == 3;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zza(final com.google.android.gms.internal.ads.zzfkq r15, final com.google.android.gms.internal.ads.zzfkf r16, final org.json.JSONObject r17, com.google.android.gms.ads.internal.zzb r18, com.google.android.gms.internal.ads.zzcdn r19) {
        /*
            Method dump skipped, instruction units count: 372
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdsn.zza(com.google.android.gms.internal.ads.zzfkq, com.google.android.gms.internal.ads.zzfkf, org.json.JSONObject, com.google.android.gms.ads.internal.zzb, com.google.android.gms.internal.ads.zzcdn):com.google.common.util.concurrent.ListenableFuture");
    }

    final /* synthetic */ zzdpt zzb(zzfkq zzfkqVar, zzfkf zzfkfVar, JSONObject jSONObject) throws zzeph {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcU)).booleanValue()) {
            this.zzd.zzf(zzdyu.NATIVE_ASSETS_LOADING_BASIC_START.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        }
        zzdpt zzdptVar = new zzdpt();
        zzdptVar.zza(jSONObject.optInt("template_id", -1));
        zzdptVar.zzl(jSONObject.optString("custom_template_id"));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings");
        zzdptVar.zzv(jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.optString("omid_partner_name") : null);
        zzfky zzfkyVar = zzfkqVar.zza.zza;
        if (!zzfkyVar.zzh.contains(Integer.toString(zzdptVar.zzx()))) {
            int iZzx = zzdptVar.zzx();
            StringBuilder sb = new StringBuilder(String.valueOf(iZzx).length() + 21);
            sb.append("Invalid template ID: ");
            sb.append(iZzx);
            throw new zzeph(1, sb.toString());
        }
        if (zzdptVar.zzx() == 3) {
            if (zzdptVar.zzS() == null) {
                throw new zzeph(1, "No custom template id for custom template ad response.");
            }
            if (!zzfkyVar.zzi.contains(zzdptVar.zzS())) {
                throw new zzeph(1, "Unexpected custom template id in the response.");
            }
        }
        zzdptVar.zzi(jSONObject.optDouble("rating", -1.0d));
        String strOptString = jSONObject.optString("headline", null);
        if (zzfkfVar.zzM) {
            com.google.android.gms.ads.internal.zzt.g();
            String strB = com.google.android.gms.ads.internal.util.zzs.b();
            StringBuilder sb2 = new StringBuilder(String.valueOf(strB).length() + 3 + String.valueOf(strOptString).length());
            sb2.append(strB);
            sb2.append(" : ");
            sb2.append(strOptString);
            strOptString = sb2.toString();
        }
        zzdptVar.zzs("headline", strOptString);
        zzdptVar.zzs("body", jSONObject.optString("body", null));
        zzdptVar.zzs("call_to_action", jSONObject.optString("call_to_action", null));
        zzdptVar.zzs(ProductResponseJsonKeys.STORE, jSONObject.optString(ProductResponseJsonKeys.STORE, null));
        zzdptVar.zzs("price", jSONObject.optString("price", null));
        zzdptVar.zzs("advertiser", jSONObject.optString("advertiser", null));
        return zzdptVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzdpt zzc(ListenableFuture listenableFuture, ListenableFuture listenableFuture2, ListenableFuture listenableFuture3, ListenableFuture listenableFuture4, ListenableFuture listenableFuture5, JSONObject jSONObject, ListenableFuture listenableFuture6, ListenableFuture listenableFuture7, ListenableFuture listenableFuture8, ListenableFuture listenableFuture9, ListenableFuture listenableFuture10) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcP)).booleanValue()) {
            this.zzd.zzf(zzdyu.RENDERING_NATIVE_ASSETS_LOADING_END.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        }
        zzdpt zzdptVar = (zzdpt) listenableFuture.get();
        zzdptVar.zzd((List) listenableFuture2.get());
        zzdptVar.zzj((zzbme) listenableFuture3.get());
        zzdptVar.zzk((zzbme) listenableFuture4.get());
        zzdptVar.zzc((zzblx) listenableFuture5.get());
        zzdptVar.zze(zzdtc.zzl(jSONObject));
        zzdptVar.zzf(zzdtc.zzk(jSONObject));
        zzcku zzckuVar = (zzcku) listenableFuture6.get();
        if (zzckuVar != null) {
            zzdptVar.zzm(zzckuVar);
            zzdptVar.zzg(zzckuVar.zzE());
            zzdptVar.zzb(zzckuVar.zzh());
        }
        zzdptVar.zzH().putAll((Bundle) listenableFuture7.get());
        zzcku zzckuVar2 = (zzcku) listenableFuture8.get();
        if (zzckuVar2 != null) {
            zzdptVar.zzn(zzckuVar2);
            zzdptVar.zzh(zzckuVar2.zzE());
        }
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzgr)).booleanValue() || zzf(jSONObject)) {
            zzcku zzckuVar3 = (zzcku) listenableFuture9.get();
            if (zzckuVar3 != null) {
                zzdptVar.zzo(zzckuVar3);
            }
        } else {
            zzdptVar.zzp(listenableFuture9);
            zzdptVar.zzr(new zzcfw());
        }
        for (zzdte zzdteVar : (List) listenableFuture10.get()) {
            if (zzdteVar.zza != 1) {
                zzdptVar.zzt(zzdteVar.zzb, zzdteVar.zzd);
            } else {
                zzdptVar.zzs(zzdteVar.zzb, zzdteVar.zzc);
            }
        }
        return zzdptVar;
    }

    final /* synthetic */ zzdzg zzd() {
        return this.zzd;
    }
}
