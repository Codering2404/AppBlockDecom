package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.gms.ads.nonagon.util.logging.csi.CsiUrlBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzdzu {
    protected final Map zza;
    protected final Context zzb;
    protected final Executor zzc;
    protected final com.google.android.gms.ads.internal.util.client.zzu zzd;
    protected final boolean zze;
    private final CsiUrlBuilder zzf;
    private final boolean zzg;
    private final AtomicBoolean zzh;
    private final AtomicReference zzi;

    protected zzdzu(Executor executor, com.google.android.gms.ads.internal.util.client.zzu zzuVar, CsiUrlBuilder csiUrlBuilder, Context context) {
        this.zza = new HashMap();
        this.zzh = new AtomicBoolean();
        this.zzi = new AtomicReference(new Bundle());
        this.zzc = executor;
        this.zzd = zzuVar;
        this.zze = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzcI)).booleanValue();
        this.zzf = csiUrlBuilder;
        this.zzg = ((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzhU)).booleanValue();
        this.zzb = context;
    }

    private final void zza(Map map) {
        if (map == null || map.isEmpty()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty or null paramMap.");
            return;
        }
        if (!this.zzh.getAndSet(true)) {
            final String str = (String) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzlV);
            this.zzi.set(com.google.android.gms.ads.internal.util.zzac.c(this.zzb, str, new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.internal.ads.zzdzs
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final /* synthetic */ void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str2) {
                    this.zza.zzg(str, sharedPreferences, str2);
                }
            }));
        }
        Bundle bundle = (Bundle) this.zzi.get();
        for (String str2 : bundle.keySet()) {
            map.put(str2, String.valueOf(bundle.get(str2)));
        }
    }

    public final void zzb(Map map) {
        if (map.isEmpty()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty paramMap.");
            return;
        }
        zza(map);
        final String strA = this.zzf.a(map);
        com.google.android.gms.ads.internal.util.zze.k(strA);
        boolean z2 = Boolean.parseBoolean((String) map.get("scar"));
        if (this.zze) {
            if (!z2 || this.zzg) {
                this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zzd.b(strA, null);
                    }
                });
            }
        }
    }

    protected final String zzc(Map map) {
        return this.zzf.a(map);
    }

    public final ConcurrentHashMap zzd() {
        return new ConcurrentHashMap(this.zza);
    }

    public final com.google.android.gms.ads.internal.util.client.zzt zze(Map map) {
        if (map.isEmpty()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty paramMap.");
            return com.google.android.gms.ads.internal.util.client.zzt.SUCCESS;
        }
        String strA = this.zzf.a(map);
        com.google.android.gms.ads.internal.util.zze.k(strA);
        return this.zzd.b(strA, null);
    }

    public final void zzf(Map map) {
        if (map.isEmpty()) {
            int i3 = com.google.android.gms.ads.internal.util.zze.f70328b;
            com.google.android.gms.ads.internal.util.client.zzo.a("Empty paramMap.");
            return;
        }
        zza(map);
        final String strA = this.zzf.a(map);
        com.google.android.gms.ads.internal.util.zze.k(strA);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzoG)).booleanValue() || this.zze) {
            this.zzc.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdzr
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzd.b(strA, null);
                }
            });
        }
    }

    final /* synthetic */ void zzg(String str, SharedPreferences sharedPreferences, String str2) {
        this.zzi.set(com.google.android.gms.ads.internal.util.zzac.b(this.zzb, str));
    }
}
