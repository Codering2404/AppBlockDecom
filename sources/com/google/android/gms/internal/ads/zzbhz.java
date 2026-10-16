package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbhz implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Object zza = new Object();
    private SharedPreferences zzb = null;
    private JSONObject zzc = new JSONObject();

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzc = new JSONObject((String) zzbis.zza(new zzgub() { // from class: com.google.android.gms.internal.ads.zzbhy
                    @Override // com.google.android.gms.internal.ads.zzgub
                    public final /* synthetic */ Object zza() {
                        return sharedPreferences.getString("flag_configuration", JsonUtils.EMPTY_JSON);
                    }
                }));
            } catch (JSONException unused) {
            }
        }
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            zzg(sharedPreferences);
        }
    }

    public final void zza(Context context) {
        SharedPreferences sharedPreferences;
        synchronized (this.zza) {
            try {
                if (this.zzb != null) {
                    return;
                }
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                com.google.android.gms.ads.internal.client.zzba.a();
                SharedPreferences sharedPreferencesZza = zzbij.zza(context);
                this.zzb = sharedPreferencesZza;
                zzg(sharedPreferencesZza);
                if (!((Boolean) zzbkq.zzb.zze()).booleanValue() && (sharedPreferences = this.zzb) != null) {
                    sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String zzb(String str, String str2) {
        return !str.startsWith("adapter:") ? str2 : this.zzc.optString(str, str2);
    }

    public final long zzc(String str, long j3) {
        return !str.startsWith("adapter:") ? j3 : this.zzc.optLong(str, j3);
    }

    public final int zzd(String str, int i3) {
        return !str.startsWith("adapter:") ? i3 : this.zzc.optInt(str, i3);
    }

    public final float zze(String str, float f3) {
        return !str.startsWith("adapter:") ? f3 : (float) this.zzc.optDouble(str, f3);
    }

    public final boolean zzf(String str, boolean z2) {
        return !str.startsWith("adapter:") ? z2 : this.zzc.optBoolean(str, z2);
    }
}
