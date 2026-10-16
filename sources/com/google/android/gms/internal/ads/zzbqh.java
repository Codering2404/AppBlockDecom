package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbqh implements zzbpq {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    @Override // com.google.android.gms.internal.ads.zzbpq
    public final void zza(Object obj, Map map) {
        String str = (String) map.get("id");
        String str2 = (String) map.get("fail");
        String str3 = (String) map.get("fail_reason");
        String str4 = (String) map.get("fail_stack");
        String str5 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        String strConcat = TextUtils.isEmpty(str4) ? "" : "\n".concat(String.valueOf(str4));
        synchronized (this.zza) {
            try {
                zzbqg zzbqgVar = (zzbqg) this.zzb.remove(str);
                if (zzbqgVar == null) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 50);
                    sb.append("Received result for unexpected method invocation: ");
                    sb.append(str);
                    String string = sb.toString();
                    int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
                    com.google.android.gms.ads.internal.util.client.zzo.f(string);
                    return;
                }
                if (!TextUtils.isEmpty(str2)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + strConcat.length());
                    sb2.append(str3);
                    sb2.append(strConcat);
                    zzbqgVar.zzb(sb2.toString());
                    return;
                }
                if (str5 == null) {
                    zzbqgVar.zza(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (com.google.android.gms.ads.internal.util.zze.m()) {
                        String string2 = jSONObject.toString(2);
                        StringBuilder sb3 = new StringBuilder(String.valueOf(string2).length() + 13);
                        sb3.append("Result GMSG: ");
                        sb3.append(string2);
                        com.google.android.gms.ads.internal.util.zze.k(sb3.toString());
                    }
                    zzbqgVar.zza(jSONObject);
                } catch (JSONException e3) {
                    zzbqgVar.zzb(e3.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzb(String str, zzbqg zzbqgVar) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbqgVar);
        }
    }

    public final ListenableFuture zzc(zzbsy zzbsyVar, String str, JSONObject jSONObject) {
        zzcfw zzcfwVar = new zzcfw();
        com.google.android.gms.ads.internal.zzt.g();
        String string = UUID.randomUUID().toString();
        zzb(string, new zzbqf(this, zzcfwVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", string);
            jSONObject2.put("args", jSONObject);
            zzbsyVar.zzb(str, jSONObject2);
            return zzcfwVar;
        } catch (Exception e3) {
            zzcfwVar.zzd(e3);
            return zzcfwVar;
        }
    }
}
