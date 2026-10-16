package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbkv;
import java.util.Locale;
import java.util.Objects;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzbf extends QueryInfoGenerationCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f70716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TaggingLibraryJsInterface f70717b;

    zzbf(TaggingLibraryJsInterface taggingLibraryJsInterface, String str) {
        this.f70716a = str;
        Objects.requireNonNull(taggingLibraryJsInterface);
        this.f70717b = taggingLibraryJsInterface;
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onFailure(String str) {
        int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
        com.google.android.gms.ads.internal.util.client.zzo.f("Failed to generate query info for the tagging library, error: ".concat(String.valueOf(str)));
        String strConcat = ((Boolean) zzbkv.zzc.zze()).booleanValue() ? ",\"as\":".concat(this.f70717b.e().b().toString()) : "";
        String str2 = this.f70716a;
        Locale locale = Locale.getDefault();
        zzbka zzbkaVar = zzbkv.zze;
        final String str3 = String.format(locale, "window.postMessage({\"paw_id\":\"%1$s\",\"error\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", str2, str, Long.valueOf(((Boolean) zzbkaVar.zze()).booleanValue() ? ((Long) zzbkv.zzh.zze()).longValue() : 0L), strConcat);
        if (((Boolean) zzbkaVar.zze()).booleanValue()) {
            try {
                this.f70717b.d().execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbd
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f70712a.f70717b.c().evaluateJavascript(str3, null);
                    }
                });
            } catch (RuntimeException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzh(e3, "TaggingLibraryJsInterface.getQueryInfo.onFailure");
            }
        } else {
            this.f70717b.c().evaluateJavascript(str3, null);
        }
        if (((Boolean) zzbkv.zzc.zze()).booleanValue() && ((Boolean) zzbkv.zzd.zze()).booleanValue()) {
            this.f70717b.f().a();
        }
    }

    @Override // com.google.android.gms.ads.query.QueryInfoGenerationCallback
    public final void onSuccess(QueryInfo queryInfo) {
        final String str;
        String strB = queryInfo.b();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("paw_id", this.f70716a);
            if (((Boolean) zzbkv.zzc.zze()).booleanValue()) {
                jSONObject.put("as", this.f70717b.e().b());
            }
            jSONObject.put("sdk_ttl_ms", ((Boolean) zzbkv.zze.zze()).booleanValue() ? ((Long) zzbkv.zzh.zze()).longValue() : 0L);
            jSONObject.put("signal", strB);
            str = String.format(Locale.getDefault(), "window.postMessage(%1$s, '*');", jSONObject);
        } catch (JSONException unused) {
            String strConcat = ((Boolean) zzbkv.zzc.zze()).booleanValue() ? ",\"as\":".concat(this.f70717b.e().b().toString()) : "";
            str = String.format(Locale.getDefault(), "window.postMessage({\"paw_id\":\"%1$s\",\"signal\":\"%2$s\",\"sdk_ttl_ms\":%3$d%4$s}, '*');", this.f70716a, queryInfo.b(), Long.valueOf(((Boolean) zzbkv.zze.zze()).booleanValue() ? ((Long) zzbkv.zzh.zze()).longValue() : 0L), strConcat);
        }
        if (((Boolean) zzbkv.zze.zze()).booleanValue()) {
            try {
                this.f70717b.d().execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzbe
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.f70714a.f70717b.c().evaluateJavascript(str, null);
                    }
                });
            } catch (RuntimeException e3) {
                com.google.android.gms.ads.internal.zzt.l().zzh(e3, "TaggingLibraryJsInterface.getQueryInfo.onSuccess");
            }
        } else {
            this.f70717b.c().evaluateJavascript(str, null);
        }
        if (((Boolean) zzbkv.zzc.zze()).booleanValue() && ((Boolean) zzbkv.zzd.zze()).booleanValue()) {
            this.f70717b.f().a();
        }
    }
}
