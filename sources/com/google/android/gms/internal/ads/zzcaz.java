package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.glance.color.Tq.KqqtdetwHMIO;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcaz extends zzcaw {
    private final Context zzb;
    private SharedPreferences zzc;
    private final zzbty zzd;
    private final VersionInfoParcel zze;
    private final Executor zzg;
    private final Object zza = new Object();
    private final AtomicBoolean zzf = new AtomicBoolean(false);

    public zzcaz(Context context, zzbty zzbtyVar, VersionInfoParcel versionInfoParcel, Executor executor) {
        this.zzb = context.getApplicationContext();
        this.zze = versionInfoParcel;
        this.zzd = zzbtyVar;
        this.zzg = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final ListenableFuture zza() {
        synchronized (this.zza) {
            try {
                if (this.zzc == null) {
                    this.zzc = this.zzb.getSharedPreferences("google_ads_flags_meta", 0);
                }
            } finally {
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        if (com.google.android.gms.ads.internal.zzt.o().currentTimeMillis() - (sharedPreferences != null ? sharedPreferences.getLong("js_last_update", 0L) : 0L) < ((Long) zzbkq.zzh.zze()).longValue()) {
            return zzhbw.zza(null);
        }
        return zzhbw.zzk(this.zzd.zzb(zzc(this.zzb, this.zze)), new zzgta() { // from class: com.google.android.gms.internal.ads.zzcax
            @Override // com.google.android.gms.internal.ads.zzgta
            public final /* synthetic */ Object apply(Object obj) {
                this.zza.zze((JSONObject) obj);
                return null;
            }
        }, ((Boolean) zzbkq.zzm.zze()).booleanValue() ? this.zzg : zzcfr.zzh);
    }

    @Override // com.google.android.gms.internal.ads.zzcaw
    public final ListenableFuture zzb() {
        if (!((Boolean) zzbkq.zza.zze()).booleanValue()) {
            return zza();
        }
        if (!this.zzf.compareAndSet(false, true)) {
            return zzhbw.zzb();
        }
        ListenableFuture listenableFutureZza = zza();
        listenableFutureZza.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcay
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzd();
            }
        }, zzcfr.zzh);
        return listenableFutureZza;
    }

    final /* synthetic */ void zzd() {
        this.zzf.set(false);
    }

    final /* synthetic */ Void zze(JSONObject jSONObject) {
        zzbih zzbihVar = zzbiq.zza;
        com.google.android.gms.ads.internal.client.zzba.a();
        Context context = this.zzb;
        SharedPreferences sharedPreferencesZzb = zzbij.zzb(context);
        if (sharedPreferencesZzb == null) {
            return null;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesZzb.edit();
        Objects.requireNonNull(com.google.android.gms.ads.internal.client.zzba.b());
        int i3 = zzbkg.zza;
        com.google.android.gms.ads.internal.client.zzba.b().zzd(editorEdit, 1, jSONObject);
        if ((((Boolean) zzbkq.zzo.zze()).booleanValue() || ((Boolean) zzbkq.zzp.zze()).booleanValue()) && !ClientLibraryUtils.a()) {
            com.google.android.gms.ads.internal.client.zzba.a();
            editorEdit.apply();
        } else {
            com.google.android.gms.ads.internal.client.zzba.a();
            editorEdit.commit();
        }
        if (((Boolean) zzbkq.zze.zze()).booleanValue() && !TextUtils.equals(context.getPackageName(), "com.google.android.gms")) {
            com.google.android.gms.ads.internal.client.zzba.a();
            SharedPreferences sharedPreferencesZza = zzbij.zza(context);
            if (sharedPreferencesZza != null) {
                SharedPreferences.Editor editorEdit2 = sharedPreferencesZza.edit();
                com.google.android.gms.ads.internal.client.zzba.b();
                JSONObject jSONObject2 = new JSONObject();
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (next.startsWith("adapter:")) {
                        try {
                            jSONObject2.put(next, jSONObject.get(next));
                        } catch (JSONException unused) {
                        }
                    }
                }
                editorEdit2.putString("flag_configuration", jSONObject2.toString());
                editorEdit2.apply();
            }
        }
        SharedPreferences sharedPreferences = this.zzc;
        if (sharedPreferences == null) {
            return null;
        }
        sharedPreferences.edit().putLong("js_last_update", com.google.android.gms.ads.internal.zzt.o().currentTimeMillis()).apply();
        return null;
    }

    public static JSONObject zzc(Context context, VersionInfoParcel versionInfoParcel) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (((Boolean) zzbkq.zzf.zze()).booleanValue()) {
                jSONObject.put("package_name", context.getPackageName());
            }
            jSONObject.put("js", versionInfoParcel.f70149a);
            jSONObject.put("mf", zzbkq.zzg.zze());
            jSONObject.put("cl", "885195211");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", KqqtdetwHMIO.VcLbYCDC);
            jSONObject.put("admob_module_version", 12451000);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.c(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }
}
