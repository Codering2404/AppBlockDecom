package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzvh;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzlh {
    public static final zzxb zza;
    private static final byte[] zzb;

    static {
        byte[] bArr = new byte[0];
        zzb = bArr;
        zzvw zzvwVar = zzvw.NIST_P256;
        zzvy zzvyVar = zzvy.SHA256;
        zzvb zzvbVar = zzvb.UNCOMPRESSED;
        zzxb zzxbVar = zzcv.zza;
        zzxz zzxzVar = zzxz.TINK;
        zza = zza(zzvwVar, zzvyVar, zzvbVar, zzxbVar, zzxzVar, bArr);
        zza(zzvwVar, zzvyVar, zzvb.COMPRESSED, zzxbVar, zzxz.RAW, bArr);
        zza(zzvwVar, zzvyVar, zzvbVar, zzcv.zzc, zzxzVar, bArr);
    }

    @Deprecated
    private static zzxb zza(zzvw zzvwVar, zzvy zzvyVar, zzvb zzvbVar, zzxb zzxbVar, zzxz zzxzVar, byte[] bArr) {
        zzvh.zza zzaVarZza = zzvh.zza();
        zzvt zzvtVar = (zzvt) ((zzalf) zzvt.zza().zza(zzvwVar).zza(zzvyVar).zza(zzajv.zza(bArr)).zze());
        return (zzxb) ((zzalf) zzxb.zza().zza(zzjx.zza()).zza(zzxzVar).zza(((zzvh) ((zzalf) zzaVarZza.zza((zzvk) ((zzalf) zzvk.zzc().zza(zzvtVar).zza((zzve) ((zzalf) zzve.zza().zza(zzxbVar).zze())).zza(zzvbVar).zze())).zze())).zzj()).zze());
    }
}
