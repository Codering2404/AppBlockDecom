package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzal {
    private final Context zza;
    private final Random zzb;
    private final String zzc;

    private final long zze(long j3, long j4) {
        long jMax = Math.max(0L, zzf().getLong("FORBIDDEN_COUNT", 0L));
        return (long) (this.zzb.nextFloat() * (j3 + ((long) ((jMax / ((jMax + Math.max(0L, r0.getLong("SUCCESSFUL_COUNT", 0L))) + 1)) * (j4 - j3)))));
    }

    private final SharedPreferences zzf() {
        return this.zza.getSharedPreferences("_gtmContainerRefreshPolicy_".concat(String.valueOf(this.zzc)), 0);
    }

    public final long zza() {
        return zze(7200000L, 259200000L) + 43200000;
    }

    public final long zzb() {
        return zze(600000L, 86400000L) + 3600000;
    }

    public final void zzc() {
        SharedPreferences sharedPreferencesZzf = zzf();
        long j3 = sharedPreferencesZzf.getLong("FORBIDDEN_COUNT", 0L);
        long j4 = sharedPreferencesZzf.getLong("SUCCESSFUL_COUNT", 0L);
        SharedPreferences.Editor editorEdit = sharedPreferencesZzf.edit();
        long jMin = j3 == 0 ? 3L : Math.min(10L, j3 + 1);
        long jMax = Math.max(0L, Math.min(j4, 10 - jMin));
        editorEdit.putLong("FORBIDDEN_COUNT", jMin);
        editorEdit.putLong("SUCCESSFUL_COUNT", jMax);
        editorEdit.apply();
    }

    public final void zzd() {
        SharedPreferences sharedPreferencesZzf = zzf();
        long j3 = sharedPreferencesZzf.getLong("SUCCESSFUL_COUNT", 0L);
        long j4 = sharedPreferencesZzf.getLong("FORBIDDEN_COUNT", 0L);
        long jMin = Math.min(10L, j3 + 1);
        long jMax = Math.max(0L, Math.min(j4, 10 - jMin));
        SharedPreferences.Editor editorEdit = sharedPreferencesZzf.edit();
        editorEdit.putLong("SUCCESSFUL_COUNT", jMin);
        editorEdit.putLong("FORBIDDEN_COUNT", jMax);
        editorEdit.apply();
    }
}
