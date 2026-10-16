package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzefs {
    private static final Pattern zza = Pattern.compile("\\?");
    private final zzcnj zzb;
    private final Context zzc;
    private final VersionInfoParcel zzd;
    private final zzfky zze;
    private final Executor zzf;
    private final ScheduledExecutorService zzg;
    private final String zzh;
    private final zzfqg zzi;
    private final zzdzg zzj;
    private final zzfsc zzk;
    private final zzdfv zzl;
    private final Object zzm = new Object();
    private String zzn;
    private List zzo;
    private Bundle zzp;
    private final zzcbl zzq;

    zzefs(zzcnj zzcnjVar, Context context, VersionInfoParcel versionInfoParcel, zzfky zzfkyVar, Executor executor, String str, zzfqg zzfqgVar, zzdzg zzdzgVar, zzcbl zzcblVar, zzein zzeinVar, ScheduledExecutorService scheduledExecutorService, zzfsc zzfscVar, zzdfv zzdfvVar) {
        this.zzb = zzcnjVar;
        this.zzc = context;
        this.zzd = versionInfoParcel;
        this.zze = zzfkyVar;
        this.zzf = executor;
        this.zzh = str;
        this.zzi = zzfqgVar;
        zzcnjVar.zzB();
        this.zzj = zzdzgVar;
        this.zzq = zzcblVar;
        this.zzg = scheduledExecutorService;
        this.zzk = zzfscVar;
        this.zzl = zzdfvVar;
    }

    private final void zzh(zzdyu zzdyuVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzih)).booleanValue()) {
            this.zzj.zzf(zzdyuVar.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        }
    }

    private final String zzi(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && "unknown".equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzh));
            }
            return jSONObject.toString();
        } catch (JSONException e3) {
            String strConcat = "Failed to update the ad types for rendering. ".concat(e3.toString());
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.f(strConcat);
            return str;
        }
    }

    private static final String zzj(String str) {
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x01ea A[Catch: all -> 0x00e0, TryCatch #0 {all -> 0x00e0, blocks: (B:21:0x007c, B:23:0x009a, B:25:0x00a2, B:27:0x00af, B:29:0x00c9, B:33:0x00f9, B:36:0x0105, B:38:0x010d, B:40:0x0113, B:44:0x011c, B:53:0x0154, B:47:0x0130, B:52:0x013f, B:55:0x0159, B:32:0x00e3, B:56:0x016d, B:63:0x018a, B:66:0x0192, B:70:0x01b4, B:72:0x01c9, B:76:0x01ea, B:78:0x01ff, B:81:0x0213, B:83:0x0219, B:84:0x0226, B:86:0x0228, B:89:0x0231, B:88:0x022e, B:77:0x01f4, B:73:0x01dc, B:69:0x01a0, B:60:0x017a, B:61:0x017f), top: B:112:0x007c, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f4 A[Catch: all -> 0x00e0, TryCatch #0 {all -> 0x00e0, blocks: (B:21:0x007c, B:23:0x009a, B:25:0x00a2, B:27:0x00af, B:29:0x00c9, B:33:0x00f9, B:36:0x0105, B:38:0x010d, B:40:0x0113, B:44:0x011c, B:53:0x0154, B:47:0x0130, B:52:0x013f, B:55:0x0159, B:32:0x00e3, B:56:0x016d, B:63:0x018a, B:66:0x0192, B:70:0x01b4, B:72:0x01c9, B:76:0x01ea, B:78:0x01ff, B:81:0x0213, B:83:0x0219, B:84:0x0226, B:86:0x0228, B:89:0x0231, B:88:0x022e, B:77:0x01f4, B:73:0x01dc, B:69:0x01a0, B:60:0x017a, B:61:0x017f), top: B:112:0x007c, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0211 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x022e A[Catch: all -> 0x00e0, TryCatch #0 {all -> 0x00e0, blocks: (B:21:0x007c, B:23:0x009a, B:25:0x00a2, B:27:0x00af, B:29:0x00c9, B:33:0x00f9, B:36:0x0105, B:38:0x010d, B:40:0x0113, B:44:0x011c, B:53:0x0154, B:47:0x0130, B:52:0x013f, B:55:0x0159, B:32:0x00e3, B:56:0x016d, B:63:0x018a, B:66:0x0192, B:70:0x01b4, B:72:0x01c9, B:76:0x01ea, B:78:0x01ff, B:81:0x0213, B:83:0x0219, B:84:0x0226, B:86:0x0228, B:89:0x0231, B:88:0x022e, B:77:0x01f4, B:73:0x01dc, B:69:0x01a0, B:60:0x017a, B:61:0x017f), top: B:112:0x007c, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0238  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.common.util.concurrent.ListenableFuture zza() {
        /*
            Method dump skipped, instruction units count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefs.zza():com.google.common.util.concurrent.ListenableFuture");
    }

    final /* synthetic */ ListenableFuture zzb(zzbty zzbtyVar, JSONObject jSONObject) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcP)).booleanValue()) {
            this.zzj.zzf(zzdyu.SCAR_PRELOADER_PROCESSING_DONE.zza(), com.google.android.gms.ads.internal.zzt.o().currentTimeMillis());
        }
        return zzbtyVar.zzb(jSONObject);
    }

    final /* synthetic */ ListenableFuture zzc(JSONObject jSONObject) {
        zzfkn zzfknVar = new zzfkn(this.zze);
        String string = jSONObject.toString();
        return zzhbw.zza(new zzfkq(zzfknVar, zzfkp.zza(new StringReader(string), this.zzp)));
    }

    final /* synthetic */ String zzd(zzeik zzeikVar) throws zzeph {
        zzh(zzdyu.RENDERING_ADSTRING_TYPE2_FETCH_START);
        int i3 = 0;
        int i4 = -1;
        while (true) {
            try {
                if (i3 >= ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzig)).intValue()) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 40);
                    sb.append("Received HTTP error code from ad server:");
                    sb.append(i4);
                    throw new zzeph(1, sb.toString());
                }
                zzeil zzeilVarZzb = new zzeim(this.zzc, this.zzd.f70149a, this.zzq, Binder.getCallingUid(), null).zza(zzeikVar);
                int i5 = zzeilVarZzb.zza;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzih)).booleanValue()) {
                    this.zzj.zzd("fr", String.valueOf(i3));
                }
                if (i5 == 200) {
                    zzh(zzdyu.RENDERING_ADSTRING_TYPE2_FETCH_END);
                    return zzeilVarZzb.zzc;
                }
                i3++;
                i4 = i5;
            } catch (Exception e3) {
                throw new zzeph(1, e3.getMessage() == null ? "Fetch failed." : e3.getMessage(), e3);
            }
        }
    }

    final /* synthetic */ ListenableFuture zze(List list, Exception exc) {
        zzeph zzephVar;
        com.google.android.gms.ads.internal.zzt.l().zzh(exc, "PreloadedLoader.getTypeTwoAdResponseString");
        if (exc instanceof TimeoutException) {
            zzephVar = new zzeph(1, "Timed out waiting for ad response.");
        } else if (exc instanceof zzeph) {
            zzephVar = (zzeph) exc;
        } else {
            zzephVar = new zzeph(1, exc.getMessage() == null ? "Fetch failed." : exc.getMessage());
        }
        String message = zzephVar.getMessage() == null ? "" : zzephVar.getMessage();
        if (list != null && !list.isEmpty()) {
            String str = "0.6.0.0";
            if (!TextUtils.isEmpty(message)) {
                if (message.contains("Timed out waiting for ad response.")) {
                    message = "timeout";
                    str = "0.2.0.0";
                } else if (message.contains("Received HTTP error code from ad server:")) {
                    List listZze = zzgty.zza(zzgsx.zzc(':')).zze(message);
                    if (listZze.size() == 2) {
                        message = (String) listZze.get(1);
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzfry.zzd(zzfry.zzd((String) it.next(), "@gw_adnetstatus@", str), "@error_code@", message));
            }
            this.zzk.zza(arrayList, null);
        }
        return zzhbw.zzc(zzephVar);
    }

    final /* synthetic */ zzdfv zzf() {
        return this.zzl;
    }

    private final ListenableFuture zzg(String str, final String str2) {
        ListenableFuture listenableFutureZza;
        String str3;
        String str4 = "";
        if (TextUtils.isEmpty(str)) {
            return zzhbw.zzc(new zzeph(15, "Invalid ad string."));
        }
        Context context = this.zzc;
        zzfpw zzfpwVarZzn = zzfpw.zzn(context, 11);
        zzfpwVarZzn.zza();
        zzbui zzbuiVarZzb = com.google.android.gms.ads.internal.zzt.v().zzb(context, this.zzd, this.zzb.zzx());
        zzbuc zzbucVar = zzbuf.zza;
        final zzbty zzbtyVarZza = zzbuiVarZzb.zza("google.afma.response.normalize", zzbucVar, zzbucVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzic)).booleanValue()) {
            try {
                str3 = str;
            } catch (JSONException unused) {
                str3 = str;
            }
            try {
                JSONObject jSONObject = new JSONObject(str3);
                this.zzn = jSONObject.optString(cJfnYMIyomoWf.XZbfWc, "");
                this.zzo = com.google.android.gms.ads.internal.util.zzbp.a(new JSONObject(jSONObject.optString("settings", "")).getJSONArray("nofill_urls"), null);
            } catch (JSONException unused2) {
                int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                com.google.android.gms.ads.internal.util.client.zzo.f("Invalid ad response.");
            }
            String string = this.zzn;
            final List list = this.zzo;
            if (TextUtils.isEmpty(string)) {
                listenableFutureZza = zzhbw.zza(str3);
                this.zzj.zzd("sst", AppEventsConstants.EVENT_PARAM_VALUE_YES);
            } else {
                this.zzj.zzd("sst", "2");
                String str5 = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzie);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzid)).booleanValue()) {
                    List listZze = zzgty.zzb(zza).zze(string);
                    if (listZze.size() < 2) {
                        listenableFutureZza = zzhbw.zzc(new zzeph(1, "Invalid fetch URL."));
                    } else {
                        str4 = (String) listZze.get(1);
                        com.google.android.gms.ads.internal.zzt.g();
                        string = Uri.parse(string).buildUpon().query(null).build().toString();
                        final zzeik zzeikVar = new zzeik(string, 60000, new HashMap(), str4.getBytes(StandardCharsets.UTF_8), str5, false);
                        listenableFutureZza = (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzi(zzhbo.zzw(zzcfr.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzefp
                            @Override // java.util.concurrent.Callable
                            public final /* synthetic */ Object call() {
                                return this.zza.zzd(zzeikVar);
                            }
                        })), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzif)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefq
                            @Override // com.google.android.gms.internal.ads.zzhbe
                            public final /* synthetic */ ListenableFuture zza(Object obj) {
                                return this.zza.zze(list, (Exception) obj);
                            }
                        }, this.zzf);
                    }
                } else {
                    final zzeik zzeikVar2 = new zzeik(string, 60000, new HashMap(), str4.getBytes(StandardCharsets.UTF_8), str5, false);
                    listenableFutureZza = (zzhbo) zzhbw.zzh((zzhbo) zzhbw.zzi(zzhbo.zzw(zzcfr.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzefp
                        @Override // java.util.concurrent.Callable
                        public final /* synthetic */ Object call() {
                            return this.zza.zzd(zzeikVar2);
                        }
                    })), ((Integer) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzif)).intValue(), TimeUnit.MILLISECONDS, this.zzg), Exception.class, new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefq
                        @Override // com.google.android.gms.internal.ads.zzhbe
                        public final /* synthetic */ ListenableFuture zza(Object obj) {
                            return this.zza.zze(list, (Exception) obj);
                        }
                    }, this.zzf);
                }
            }
        } else {
            listenableFutureZza = zzhbw.zza(str);
            this.zzj.zzd("sst", AppEventsConstants.EVENT_PARAM_VALUE_YES);
        }
        zzhbe zzhbeVar = new zzhbe(this) { // from class: com.google.android.gms.internal.ads.zzefr
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) throws JSONException {
                String str6 = (String) obj;
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                JSONObject jSONObject4 = new JSONObject();
                String str7 = str2;
                try {
                    jSONObject4.put("headers", new JSONObject());
                    jSONObject4.put("body", str6);
                    jSONObject3.put("base_url", "");
                    jSONObject3.put("signals", new JSONObject(str7));
                    jSONObject2.put("request", jSONObject3);
                    jSONObject2.put("response", jSONObject4);
                    jSONObject2.put("flags", new JSONObject());
                    return zzhbw.zza(jSONObject2);
                } catch (JSONException e3) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(e3.getCause())));
                }
            }
        };
        Executor executor = this.zzf;
        ListenableFuture listenableFutureZzj = zzhbw.zzj(zzhbw.zzj(zzhbw.zzj(listenableFutureZza, zzhbeVar, executor), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefn
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzb(zzbtyVarZza, (JSONObject) obj);
            }
        }, executor), new zzhbe() { // from class: com.google.android.gms.internal.ads.zzefo
            @Override // com.google.android.gms.internal.ads.zzhbe
            public final /* synthetic */ ListenableFuture zza(Object obj) {
                return this.zza.zzc((JSONObject) obj);
            }
        }, executor);
        zzfqf.zzd(listenableFutureZzj, this.zzi, zzfpwVarZzn);
        zzhbw.zzr(listenableFutureZzj, new zzefm(this), zzcfr.zzh);
        return listenableFutureZzj;
    }
}
