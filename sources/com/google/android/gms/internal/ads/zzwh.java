package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzwh implements zzvk {
    private final MediaCodec zza;

    public zzwh(MediaCodec mediaCodec) {
        this.zza = mediaCodec;
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzb(int i3, int i4, int i5, long j3, int i6) {
        this.zza.queueInputBuffer(i3, 0, i5, j3, i6);
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzc(int i3, int i4, zzis zzisVar, long j3, int i5) {
        this.zza.queueSecureInputBuffer(i3, 0, zzisVar.zzb(), j3, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzd(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zza() {
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzvk
    public final void zzg() {
    }
}
