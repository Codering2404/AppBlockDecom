package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyv implements zzabk {
    public long zza;
    public long zzb;
    public zzabj zzc;
    public zzyv zzd;

    public zzyv(long j3, int i3) {
        zza(j3, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
    }

    public final void zza(long j3, int i3) {
        zzgtj.zzi(this.zzc == null);
        this.zza = j3;
        this.zzb = j3 + 65536;
    }

    public final int zzb(long j3) {
        long j4 = j3 - this.zza;
        int i3 = this.zzc.zzb;
        return (int) j4;
    }

    public final zzyv zzc() {
        this.zzc = null;
        zzyv zzyvVar = this.zzd;
        this.zzd = null;
        return zzyvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final zzabj zzd() {
        zzabj zzabjVar = this.zzc;
        zzabjVar.getClass();
        return zzabjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final zzabk zze() {
        zzyv zzyvVar = this.zzd;
        if (zzyvVar == null || zzyvVar.zzc == null) {
            return null;
        }
        return zzyvVar;
    }
}
