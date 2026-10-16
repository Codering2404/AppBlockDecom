package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzwa implements zzvy {
    private final int zza;
    private MediaCodecInfo[] zzb;

    public zzwa(boolean z2, boolean z3, boolean z4) {
        int i3 = 1;
        if (!z2 && !z3 && !z4) {
            i3 = 0;
        }
        this.zza = i3;
    }

    @EnsuresNonNull
    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final MediaCodecInfo zzb(int i3) {
        zzf();
        return this.zzb[i3];
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final boolean zzc() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final boolean zze(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }
}
