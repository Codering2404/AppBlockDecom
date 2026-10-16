package com.google.android.gms.internal.ads;

import android.os.Build;
import android.webkit.WebView;
import java.util.Date;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzfvy {
    private final String zza;
    private zzfxa zzb;
    private long zzc;
    private int zzd;

    public zzfvy(String str) {
        zzp();
        this.zza = str;
        this.zzb = new zzfxa(null);
    }

    public void zzb() {
        this.zzb.clear();
    }

    final void zzc(WebView webView) {
        this.zzb = new zzfxa(webView);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView zzd() {
        return (WebView) this.zzb.get();
    }

    public final boolean zze() {
        return this.zzb.get() != 0;
    }

    public final void zzf(boolean z2) {
        if (zze()) {
            zzfvp.zza().zzf(zzd(), this.zza, true != z2 ? "backgrounded" : "foregrounded");
        }
    }

    public final void zzg(boolean z2) {
        if (zze()) {
            zzfvp.zza().zzg(zzd(), this.zza, true != z2 ? "unlocked" : "locked");
        }
    }

    public final void zzh(String str, long j3) {
        if (j3 >= this.zzc) {
            this.zzd = 2;
            zzfvp.zza().zze(zzd(), this.zza, str);
        }
    }

    public final void zzi(String str, long j3) {
        if (j3 < this.zzc || this.zzd == 3) {
            return;
        }
        this.zzd = 3;
        zzfvp.zza().zze(zzd(), this.zza, str);
    }

    public final void zzj(zzful zzfulVar) {
        zzfvp.zza().zzb(zzd(), this.zza, zzfulVar.zzb());
    }

    public void zzk(zzfuo zzfuoVar, zzfum zzfumVar) {
        zzl(zzfuoVar, zzfumVar, null);
    }

    protected final void zzl(zzfuo zzfuoVar, zzfum zzfumVar, JSONObject jSONObject) {
        String strZzh = zzfuoVar.zzh();
        JSONObject jSONObject2 = new JSONObject();
        zzfwe.zzc(jSONObject2, "environment", "app");
        zzfwe.zzc(jSONObject2, "adSessionType", zzfumVar.zzi());
        JSONObject jSONObject3 = new JSONObject();
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("; ");
        sb.append(str2);
        zzfwe.zzc(jSONObject3, "deviceType", sb.toString());
        zzfwe.zzc(jSONObject3, "osVersion", Integer.toString(Build.VERSION.SDK_INT));
        zzfwe.zzc(jSONObject3, "os", "Android");
        zzfwe.zzc(jSONObject2, "deviceInfo", jSONObject3);
        zzfwe.zzc(jSONObject2, "deviceCategory", zzfwd.zzb().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        zzfwe.zzc(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject4 = new JSONObject();
        zzfwe.zzc(jSONObject4, "partnerName", zzfumVar.zzc().zzb());
        zzfwe.zzc(jSONObject4, "partnerVersion", zzfumVar.zzc().zzc());
        zzfwe.zzc(jSONObject2, "omidNativeInfo", jSONObject4);
        JSONObject jSONObject5 = new JSONObject();
        zzfwe.zzc(jSONObject5, "libraryVersion", "1.5.2-google_20241009");
        zzfwe.zzc(jSONObject5, "appId", zzfvn.zza().zzb().getApplicationContext().getPackageName());
        zzfwe.zzc(jSONObject2, "app", jSONObject5);
        if (zzfumVar.zzg() != null) {
            zzfwe.zzc(jSONObject2, "contentUrl", zzfumVar.zzg());
        }
        if (zzfumVar.zzh() != null) {
            zzfwe.zzc(jSONObject2, "customReferenceData", zzfumVar.zzh());
        }
        JSONObject jSONObject6 = new JSONObject();
        Iterator it = zzfumVar.zzd().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzfvp.zza().zzc(zzd(), strZzh, jSONObject2, jSONObject6, jSONObject);
    }

    public final void zzm() {
        zzfvp.zza().zzd(zzd(), this.zza);
    }

    public final void zzn(Date date) {
        if (date == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        zzfwe.zzc(jSONObject, "timestamp", Long.valueOf(date.getTime()));
        zzfvp.zza().zzi(zzd(), jSONObject);
    }

    public final void zzo(float f3) {
        zzfvp.zza().zzh(zzd(), this.zza, f3);
    }

    public final void zzp() {
        this.zzc = System.nanoTime();
        this.zzd = 1;
    }

    public void zza() {
    }
}
