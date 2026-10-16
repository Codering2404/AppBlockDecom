package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.applovin.impl.sdk.utils.JsonUtils;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@ParametersAreNonnullByDefault
public final class zzbio implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context zzg;
    private final Object zzb = new Object();
    private final ConditionVariable zzc = new ConditionVariable();
    private volatile boolean zzd = false;
    volatile boolean zza = false;
    private SharedPreferences zze = null;
    private Bundle zzf = new Bundle();
    private JSONObject zzh = new JSONObject();
    private boolean zzi = false;
    private boolean zzj = false;

    private final void zzg(final SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            try {
                this.zzh = new JSONObject((String) zzbis.zza(new zzgub() { // from class: com.google.android.gms.internal.ads.zzbil
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

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #2 {all -> 0x0054, blocks: (B:22:0x0046, B:37:0x0064, B:39:0x006d, B:40:0x0075, B:42:0x007b, B:44:0x008b, B:46:0x00a0, B:51:0x00ae, B:53:0x00b2, B:55:0x00c2, B:57:0x00d7, B:60:0x00e0, B:70:0x011f, B:74:0x0128, B:76:0x0135, B:78:0x0143, B:79:0x014c, B:81:0x015a, B:83:0x015e, B:84:0x0161, B:63:0x00f1, B:65:0x00ff, B:67:0x0107, B:68:0x0112, B:26:0x004d, B:32:0x005a), top: B:98:0x0046, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e0 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #2 {all -> 0x0054, blocks: (B:22:0x0046, B:37:0x0064, B:39:0x006d, B:40:0x0075, B:42:0x007b, B:44:0x008b, B:46:0x00a0, B:51:0x00ae, B:53:0x00b2, B:55:0x00c2, B:57:0x00d7, B:60:0x00e0, B:70:0x011f, B:74:0x0128, B:76:0x0135, B:78:0x0143, B:79:0x014c, B:81:0x015a, B:83:0x015e, B:84:0x0161, B:63:0x00f1, B:65:0x00ff, B:67:0x0107, B:68:0x0112, B:26:0x004d, B:32:0x005a), top: B:98:0x0046, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0123 A[Catch: all -> 0x000f, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x000f, blocks: (B:7:0x0009, B:9:0x000d, B:13:0x0012, B:15:0x0017, B:16:0x0019, B:18:0x002b, B:19:0x002f, B:20:0x0031, B:47:0x00a4, B:48:0x00a8, B:49:0x00ab, B:58:0x00db, B:72:0x0123, B:85:0x0168, B:86:0x016f, B:88:0x0171, B:89:0x0178, B:22:0x0046, B:37:0x0064, B:39:0x006d, B:40:0x0075, B:42:0x007b, B:44:0x008b, B:46:0x00a0, B:51:0x00ae, B:53:0x00b2, B:55:0x00c2, B:57:0x00d7, B:60:0x00e0, B:70:0x011f, B:74:0x0128, B:76:0x0135, B:78:0x0143, B:79:0x014c, B:81:0x015a, B:83:0x015e, B:84:0x0161, B:63:0x00f1, B:65:0x00ff, B:67:0x0107, B:68:0x0112, B:26:0x004d, B:32:0x005a), top: B:101:0x0009, inners: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0128 A[Catch: all -> 0x0054, TRY_ENTER, TryCatch #2 {all -> 0x0054, blocks: (B:22:0x0046, B:37:0x0064, B:39:0x006d, B:40:0x0075, B:42:0x007b, B:44:0x008b, B:46:0x00a0, B:51:0x00ae, B:53:0x00b2, B:55:0x00c2, B:57:0x00d7, B:60:0x00e0, B:70:0x011f, B:74:0x0128, B:76:0x0135, B:78:0x0143, B:79:0x014c, B:81:0x015a, B:83:0x015e, B:84:0x0161, B:63:0x00f1, B:65:0x00ff, B:67:0x0107, B:68:0x0112, B:26:0x004d, B:32:0x005a), top: B:98:0x0046, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(android.content.Context r11) {
        /*
            Method dump skipped, instruction units count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbio.zza(android.content.Context):void");
    }

    final boolean zzb() {
        return this.zzi;
    }

    public final boolean zzc() {
        return this.zzj;
    }

    public final Object zzd(final zzbih zzbihVar) {
        if (!this.zzc.block(5000L)) {
            synchronized (this.zzb) {
                try {
                    if (!this.zza) {
                        throw new IllegalStateException("Flags.initialize() was not called!");
                    }
                } finally {
                }
            }
        }
        if (!this.zzd || this.zze == null || this.zzj) {
            synchronized (this.zzb) {
                if (this.zzd && this.zze != null && !this.zzj) {
                }
                return zzbihVar.zzf();
            }
        }
        if (zzbihVar.zzm() != 2) {
            return (zzbihVar.zzm() == 1 && this.zzh.has(zzbihVar.zze())) ? zzbihVar.zzc(this.zzh) : zzbis.zza(new zzgub() { // from class: com.google.android.gms.internal.ads.zzbin
                @Override // com.google.android.gms.internal.ads.zzgub
                public final /* synthetic */ Object zza() {
                    return this.zza.zzf(zzbihVar);
                }
            });
        }
        Bundle bundle = this.zzf;
        return bundle == null ? zzbihVar.zzf() : zzbihVar.zza(bundle);
    }

    public final Object zze(zzbih zzbihVar) {
        return (this.zzd || this.zza) ? zzd(zzbihVar) : zzbihVar.zzf();
    }

    final /* synthetic */ Object zzf(zzbih zzbihVar) {
        return zzbihVar.zzd(this.zze);
    }
}
