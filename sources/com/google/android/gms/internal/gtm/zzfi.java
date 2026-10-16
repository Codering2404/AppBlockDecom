package com.google.android.gms.internal.gtm;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfi {
    final /* synthetic */ zzfj zza;
    private final String zzb;
    private final long zzc;

    /* synthetic */ zzfi(zzfj zzfjVar, String str, long j3, zzfh zzfhVar) {
        this.zza = zzfjVar;
        Preconditions.g("monitoring");
        Preconditions.a(j3 > 0);
        this.zzb = "monitoring";
        this.zzc = j3;
    }

    private final long zzd() {
        return this.zza.zza.getLong(zzf(), 0L);
    }

    private final String zze() {
        return this.zzb.concat(":count");
    }

    private final String zzf() {
        return this.zzb.concat(":start");
    }

    private final void zzg() {
        long jCurrentTimeMillis = this.zza.zzC().currentTimeMillis();
        SharedPreferences.Editor editorEdit = this.zza.zza.edit();
        editorEdit.remove(zze());
        editorEdit.remove(zzb());
        editorEdit.putLong(zzf(), jCurrentTimeMillis);
        editorEdit.commit();
    }

    public final Pair zza() {
        long jZzd = zzd();
        long jAbs = jZzd == 0 ? 0L : Math.abs(jZzd - this.zza.zzC().currentTimeMillis());
        long j3 = this.zzc;
        if (jAbs < j3) {
            return null;
        }
        if (jAbs > j3 + j3) {
            zzg();
            return null;
        }
        String string = this.zza.zza.getString(zzb(), null);
        long j4 = this.zza.zza.getLong(zze(), 0L);
        zzg();
        if (string == null || j4 <= 0) {
            return null;
        }
        return new Pair(string, Long.valueOf(j4));
    }

    protected final String zzb() {
        return this.zzb.concat(":value");
    }

    public final void zzc(String str) {
        if (zzd() == 0) {
            zzg();
        }
        if (str == null) {
            str = "";
        }
        synchronized (this) {
            try {
                long j3 = this.zza.zza.getLong(zze(), 0L);
                if (j3 <= 0) {
                    SharedPreferences.Editor editorEdit = this.zza.zza.edit();
                    editorEdit.putString(zzb(), str);
                    editorEdit.putLong(zze(), 1L);
                    editorEdit.apply();
                    return;
                }
                long leastSignificantBits = UUID.randomUUID().getLeastSignificantBits() & Long.MAX_VALUE;
                long j4 = j3 + 1;
                long j5 = Long.MAX_VALUE / j4;
                SharedPreferences.Editor editorEdit2 = this.zza.zza.edit();
                if (leastSignificantBits < j5) {
                    editorEdit2.putString(zzb(), str);
                }
                editorEdit2.putLong(zze(), j4);
                editorEdit2.apply();
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
