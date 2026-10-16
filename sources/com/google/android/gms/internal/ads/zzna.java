package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzna extends zzmv {
    String zzU();

    default long zzV(long j3, long j4) {
        if (zze() == 1) {
            return (zzaa() || zzab()) ? 1000000L : 10000L;
        }
        return 10000L;
    }

    default boolean zzW(long j3) {
        return false;
    }

    void zzZ(long j3, long j4) throws zzjk;

    int zza();

    boolean zzaa();

    boolean zzab();

    zznc zzb();

    void zzc(int i3, zzqf zzqfVar, zzdo zzdoVar);

    void zzcT() throws zzjk;

    void zzcU(zzv[] zzvVarArr, zzzc zzzcVar, long j3, long j4, zzxk zzxkVar) throws zzjk;

    zzzc zzcV();

    boolean zzcW();

    zzmb zzd();

    int zze();

    void zzf(zznd zzndVar, zzv[] zzvVarArr, zzzc zzzcVar, long j3, boolean z2, boolean z3, long j4, long j5, zzxk zzxkVar) throws zzjk;

    long zzk();

    void zzl();

    boolean zzm();

    void zzn() throws IOException;

    void zzo(zzbf zzbfVar);

    void zzp(long j3, boolean z2) throws zzjk;

    void zzq();

    void zzr();

    void zzs();

    default void zzY() {
    }

    default void zzt() {
    }

    default void zzX(float f3, float f4) throws zzjk {
    }
}
