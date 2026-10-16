package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcmf {
    private final zzcme zza;
    private final zzcmg zzb;

    public zzcmf(zzcmg zzcmgVar, zzcme zzcmeVar) {
        this.zza = zzcmeVar;
        this.zzb = zzcmgVar;
    }

    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zze.k("Click string is empty, not proceeding.");
            return "";
        }
        zzcmg zzcmgVar = this.zzb;
        zzbap zzbapVarZzS = ((zzcmn) zzcmgVar).zzS();
        if (zzbapVarZzS == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signal utils is empty, ignoring.");
            return "";
        }
        zzbak zzbakVarZzb = zzbapVarZzS.zzb();
        if (zzbakVarZzb == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcmgVar.getContext() != null) {
            return zzbakVarZzb.zzf(zzcmgVar.getContext(), str, ((zzcmp) zzcmgVar).zzE(), zzcmgVar.zzj());
        }
        com.google.android.gms.ads.internal.util.zze.k("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignals() {
        zzcmg zzcmgVar = this.zzb;
        zzbap zzbapVarZzS = ((zzcmn) zzcmgVar).zzS();
        if (zzbapVarZzS == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signal utils is empty, ignoring.");
            return "";
        }
        zzbak zzbakVarZzb = zzbapVarZzS.zzb();
        if (zzbakVarZzb == null) {
            com.google.android.gms.ads.internal.util.zze.k("Signals object is empty, ignoring.");
            return "";
        }
        if (zzcmgVar.getContext() != null) {
            return zzbakVarZzb.zzj(zzcmgVar.getContext(), ((zzcmp) zzcmgVar).zzE(), zzcmgVar.zzj());
        }
        com.google.android.gms.ads.internal.util.zze.k("Context is null, ignoring.");
        return "";
    }

    @JavascriptInterface
    public String getViewSignalsJson() {
        zzcmg zzcmgVar = this.zzb;
        zzbiq.zza(zzcmgVar.getContext());
        String viewSignals = getViewSignals();
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzpj)).booleanValue()) {
            return viewSignals;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ms", viewSignals);
            zzcms zzcmsVarZzP = ((zzcku) zzcmgVar).zzP();
            zzdbn zzdbnVarZzK = zzcmsVarZzP != null ? zzcmsVarZzP.zzK() : null;
            if (zzdbnVarZzK != null) {
                long jZza = zzdbnVarZzK.zza();
                if (jZza > 0) {
                    jSONObject.put("plcmtid", jZza);
                }
            }
            return jSONObject.toString();
        } catch (JSONException e3) {
            com.google.android.gms.ads.internal.util.zze.l("Error constructing JSON.", e3);
            return "";
        }
    }

    @JavascriptInterface
    public void notify(final String str) {
        if (!TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.zzs.f70374l.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcmc
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zza(str);
                }
            });
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f("URL is empty, ignoring message");
        }
    }

    final /* synthetic */ void zza(String str) {
        this.zza.zza(Uri.parse(str));
    }
}
