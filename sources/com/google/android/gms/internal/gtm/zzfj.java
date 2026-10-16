package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfj extends zzbu {
    private SharedPreferences zza;
    private long zzb;
    private long zzc;
    private final zzfi zzd;

    protected zzfj(zzbx zzbxVar) {
        super(zzbxVar);
        this.zzc = -1L;
        zzw();
        this.zzd = new zzfi(this, "monitoring", ((Long) zzew.zzP.zzb()).longValue(), null);
    }

    public final long zza() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        long j3 = this.zzb;
        if (j3 != 0) {
            return j3;
        }
        long j4 = this.zza.getLong("first_run", 0L);
        if (j4 != 0) {
            this.zzb = j4;
            return j4;
        }
        long jCurrentTimeMillis = zzC().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zza.edit();
        editorEdit.putLong("first_run", jCurrentTimeMillis);
        if (!editorEdit.commit()) {
            zzQ("Failed to commit first run time");
        }
        this.zzb = jCurrentTimeMillis;
        return jCurrentTimeMillis;
    }

    public final long zzb() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        long j3 = this.zzc;
        if (j3 != -1) {
            return j3;
        }
        long j4 = this.zza.getLong("last_dispatch", 0L);
        this.zzc = j4;
        return j4;
    }

    @Override // com.google.android.gms.internal.gtm.zzbu
    protected final void zzd() {
        this.zza = zzo().getSharedPreferences("com.google.android.gms.analytics.prefs", 0);
    }

    public final zzfi zze() {
        return this.zzd;
    }

    public final zzfq zzf() {
        return new zzfq(zzC(), zza());
    }

    public final String zzg() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        String string = this.zza.getString("installation_campaign", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return string;
    }

    public final void zzh(String str) {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        SharedPreferences.Editor editorEdit = this.zza.edit();
        if (TextUtils.isEmpty(str)) {
            editorEdit.remove("installation_campaign");
        } else {
            editorEdit.putString("installation_campaign", str);
        }
        if (editorEdit.commit()) {
            return;
        }
        zzQ("Failed to commit campaign data");
    }

    public final void zzi() {
        com.google.android.gms.analytics.zzr.h();
        zzV();
        long jCurrentTimeMillis = zzC().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zza.edit();
        editorEdit.putLong("last_dispatch", jCurrentTimeMillis);
        editorEdit.apply();
        this.zzc = jCurrentTimeMillis;
    }
}
