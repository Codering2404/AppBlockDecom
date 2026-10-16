package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzir {
    private final MediaCodec.CryptoInfo zza;
    private final MediaCodec.CryptoInfo.Pattern zzb = new MediaCodec.CryptoInfo.Pattern(0, 0);

    final /* synthetic */ void zza(int i3, int i4) {
        MediaCodec.CryptoInfo.Pattern pattern = this.zzb;
        pattern.set(i3, i4);
        this.zza.setPattern(pattern);
    }
}
