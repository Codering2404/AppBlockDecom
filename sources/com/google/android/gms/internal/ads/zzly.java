package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzly {
    default void zza(zzqf zzqfVar) {
        throw new IllegalStateException("onPrepared not implemented");
    }

    default void zzb(zzlx zzlxVar, zzzn zzznVar, zzaba[] zzabaVarArr) {
        throw new IllegalStateException("onTracksSelected not implemented");
    }

    default void zzc(zzqf zzqfVar) {
        throw new IllegalStateException("onStopped not implemented");
    }

    default void zzd(zzqf zzqfVar) {
        throw new IllegalStateException("onReleased not implemented");
    }

    zzabl zze(zzqf zzqfVar);

    default long zzf(zzqf zzqfVar) {
        throw new IllegalStateException("getBackBufferDurationUs not implemented");
    }

    default boolean zzg(zzqf zzqfVar) {
        throw new IllegalStateException("retainBackBufferFromKeyframe not implemented");
    }

    default boolean zzh(zzlx zzlxVar) {
        long j3 = zzlxVar.zzd;
        throw null;
    }

    default boolean zzi(zzlx zzlxVar) {
        zzbf zzbfVar = zzlxVar.zzb;
        throw null;
    }

    default boolean zzj(zzqf zzqfVar, zzbf zzbfVar, zzxk zzxkVar, long j3) {
        zzeg.zzc("LoadControl", "shouldContinuePreloading needs to be implemented when playlist preloading is enabled");
        return false;
    }
}
