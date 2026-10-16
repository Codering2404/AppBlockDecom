package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.webkit.WebViewFeature;
import com.facebook.appevents.AppEventsConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdys implements zzdfx, zzdef, zzdcu, zzdlk {
    private final zzdzg zza;
    private final zzdzq zzb;

    zzdys(zzdzg zzdzgVar, zzdzq zzdzqVar) {
        this.zza = zzdzgVar;
        this.zzb = zzdzqVar;
    }

    private final void zzc(Bundle bundle, zzgwm zzgwmVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcN)).booleanValue() || bundle == null) {
            return;
        }
        bundle.putLong(zzdyu.PUBLIC_API_CALLBACK.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        zzdzg zzdzgVar = this.zza;
        zzdzgVar.zzh();
        if (bundle.containsKey("ls")) {
            zzdzgVar.zzd("ls", true != bundle.getBoolean("ls") ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        int size = zzgwmVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzdyv zzdyvVar = (zzdyv) zzgwmVar.get(i3);
            long j3 = bundle.getLong(zzdyvVar.zzb().zza(), -1L);
            long j4 = bundle.getLong(zzdyvVar.zzc().zza(), -1L);
            if (j3 > 0 && j4 > 0) {
                zzdzgVar.zzd(zzdyvVar.zza(), String.valueOf(j4 - j3));
            }
        }
        zzf(bundle.getBundle("client_sig_latency_key"));
        zzf(bundle.getBundle("gms_sig_latency_key"));
    }

    private final void zzf(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        for (String str : bundle.keySet()) {
            long j3 = bundle.getLong(str);
            if (j3 >= 0) {
                this.zza.zzd(str, String.valueOf(j3));
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zzd(com.google.android.gms.ads.nonagon.signalgeneration.zzbc zzbcVar) {
        String str;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhT)).booleanValue()) {
            if (zzbcVar == null) {
                zzdzg zzdzgVar = this.zza;
                zzdzgVar.zzc().put("action", "sgs");
                zzdzgVar.zzc().put("request_id", "-1");
                this.zzb.zzb(zzdzgVar.zzc());
                return;
            }
            zzcbd zzcbdVar = zzbcVar.f70708c;
            if (zzcbdVar != null) {
                zzc(zzcbdVar.zzm, zzdyv.zza);
            }
            try {
                JSONObject jSONObject = new JSONObject(zzbcVar.f70707b);
                zzdzg zzdzgVar2 = this.zza;
                zzdzgVar2.zzc().put("action", "sgs");
                Map mapZzc = zzdzgVar2.zzc();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlc)).booleanValue()) {
                    try {
                        str = jSONObject.getJSONObject("extras").getBoolean("accept_3p_cookie") ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO;
                    } catch (JSONException e3) {
                        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                        com.google.android.gms.ads.internal.util.client.zzo.d("Error retrieving JSONObject from the requestJson, ", e3);
                        str = "na";
                    }
                } else {
                    str = "na";
                }
                mapZzc.put("tpc", str);
                zzcbd zzcbdVar2 = zzbcVar.f70708c;
                if (zzcbdVar2 != null) {
                    this.zza.zzb(zzcbdVar2.zza);
                }
                zzdzg zzdzgVar3 = this.zza;
                zzdzgVar3.zzi();
                this.zzb.zzb(zzdzgVar3.zzc());
            } catch (JSONException unused) {
                zzdzg zzdzgVar4 = this.zza;
                zzdzgVar4.zzc().put("action", "sgf");
                zzdzgVar4.zzc().put("sgf_reason", "request_invalid");
                this.zzb.zzb(zzdzgVar4.zzc());
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcu
    public final void zzdJ(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zzdzg zzdzgVar = this.zza;
        zzdzgVar.zzc().put("action", "ftl");
        zzdzgVar.zzd("ftl", String.valueOf(zzeVar.f69851a));
        zzdzgVar.zzd("ed", zzeVar.f69853c);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzii)).booleanValue()) {
            zzdzgVar.zzd("emsg", zzeVar.f69852b);
        }
        zzdzgVar.zzi();
        this.zzb.zzb(zzdzgVar.zzc());
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdP(zzcbd zzcbdVar) {
        this.zza.zzb(zzcbdVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzdfx
    public final void zzdQ(zzfkq zzfkqVar) {
        this.zza.zza(zzfkqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdlk
    public final void zze(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhT)).booleanValue()) {
            zzdzg zzdzgVar = this.zza;
            zzdzgVar.zzc().put("action", "sgf");
            zzdzgVar.zzd("sgf_reason", str);
            zzdzgVar.zzi();
            this.zzb.zzb(zzdzgVar.zzc());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdef
    public final void zzg() {
        zzdzg zzdzgVar = this.zza;
        zzdzgVar.zzc().put("action", "loaded");
        zzc(zzdzgVar.zze(), zzdyv.zzb);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzod)).booleanValue()) {
            zzdzgVar.zzc().put("mafe", true != WebViewFeature.a("MUTE_AUDIO") ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        zzdzgVar.zzi();
        this.zzb.zzb(zzdzgVar.zzc());
    }
}
