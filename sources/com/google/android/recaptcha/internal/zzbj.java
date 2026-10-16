package com.google.android.recaptcha.internal;

import kotlin.comparisons.ComparisonsKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzbj implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        return "avgExecutionTime: " + StringsKt.A0(String.valueOf(this.zzb / ((long) this.zza)), 10, (char) 0, 2, null) + " us| maxExecutionTime: " + StringsKt.A0(String.valueOf(this.zzc), 10, (char) 0, 2, null) + " us| totalTime: " + StringsKt.A0(String.valueOf(this.zzb), 10, (char) 0, 2, null) + " us| #Usages: " + StringsKt.A0(String.valueOf(this.zza), 5, (char) 0, 2, null);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzbj zzbjVar) {
        return ComparisonsKt.d(Long.valueOf(this.zzb), Long.valueOf(zzbjVar.zzb));
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j3) {
        this.zzc = j3;
    }

    public final void zzf(long j3) {
        this.zzb = j3;
    }

    public final void zzg(int i3) {
        this.zza = i3;
    }
}
