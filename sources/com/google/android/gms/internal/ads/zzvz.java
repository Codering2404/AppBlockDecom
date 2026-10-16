package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzvz implements zzvy {
    private zzvz() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final int zza() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final MediaCodecInfo zzb(int i3) {
        return MediaCodecList.getCodecInfoAt(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final boolean zzc() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "secure-playback".equals(str) && "video/avc".equals(str2);
    }

    @Override // com.google.android.gms.internal.ads.zzvy
    public final boolean zze(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return false;
    }

    /* synthetic */ zzvz(byte[] bArr) {
    }
}
