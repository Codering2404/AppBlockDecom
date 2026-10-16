package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzafv implements zzahk {
    private final byte[] zza = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzahk
    public final int zzb(zzj zzjVar, int i3, boolean z2, int i4) throws IOException {
        int iZza = zzjVar.zza(this.zza, 0, Math.min(4096, i3));
        if (iZza != -1) {
            return iZza;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzd(zzet zzetVar, int i3, int i4) {
        zzetVar.zzk(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zzA(zzv zzvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzahk
    public final void zze(long j3, int i3, int i4, int i5, zzahj zzahjVar) {
    }
}
