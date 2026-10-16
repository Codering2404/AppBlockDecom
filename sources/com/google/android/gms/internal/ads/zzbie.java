package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbie extends zzbih {
    zzbie(int i3, String str, Long l3, Long l4) {
        super(1, str, l3, l4, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbih
    public final /* bridge */ /* synthetic */ Object zza(Bundle bundle) {
        return bundle.containsKey("com.google.android.gms.ads.flag.".concat(zze())) ? Long.valueOf(bundle.getLong("com.google.android.gms.ads.flag.".concat(zze()))) : (Long) zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzbih
    public final /* bridge */ /* synthetic */ void zzb(SharedPreferences.Editor editor, Object obj) {
        editor.putLong(zze(), ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzbih
    public final /* bridge */ /* synthetic */ Object zzc(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(zze(), ((Long) zzf()).longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzbih
    public final /* bridge */ /* synthetic */ Object zzd(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(zze(), ((Long) zzf()).longValue()));
    }
}
