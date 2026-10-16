package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwg implements zzvj {
    private final MediaCodec zza;
    private final zzvf zzb;

    /* synthetic */ zzwg(MediaCodec mediaCodec, zzvf zzvfVar, byte[] bArr) {
        this.zza = mediaCodec;
        this.zzb = zzvfVar;
        if (Build.VERSION.SDK_INT < 35 || zzvfVar == null) {
            return;
        }
        zzvfVar.zzb(mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zza(int i3, int i4, int i5, long j3, int i6) {
        this.zza.queueInputBuffer(i3, 0, i5, j3, i6);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzb(int i3, int i4, zzis zzisVar, long j3, int i5) {
        this.zza.queueSecureInputBuffer(i3, 0, zzisVar.zzb(), j3, i5);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzc(int i3, boolean z2) {
        this.zza.releaseOutputBuffer(i3, false);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzd(int i3, long j3) {
        this.zza.releaseOutputBuffer(i3, j3);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final int zze() {
        return this.zza.dequeueInputBuffer(0L);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final int zzf(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.zza.dequeueOutputBuffer(bufferInfo, 0L);
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final MediaFormat zzg() {
        return this.zza.getOutputFormat();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final ByteBuffer zzh(int i3) {
        return this.zza.getInputBuffer(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final ByteBuffer zzj(int i3) {
        return this.zza.getOutputBuffer(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzk() {
        this.zza.flush();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzl() {
        zzvf zzvfVar;
        zzvf zzvfVar2;
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 30 && i3 < 33) {
                this.zza.stop();
            }
            if (i3 >= 35 && (zzvfVar2 = this.zzb) != null) {
                zzvfVar2.zzc(this.zza);
            }
            this.zza.release();
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 35 && (zzvfVar = this.zzb) != null) {
                zzvfVar.zzc(this.zza);
            }
            this.zza.release();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzn(Surface surface) {
        this.zza.setOutputSurface(surface);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzo() {
        this.zza.detachOutputSurface();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzp(Bundle bundle) {
        this.zza.setParameters(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzq(int i3) {
        this.zza.setVideoScalingMode(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzr(List list) {
        this.zza.subscribeToVendorParameters(list);
    }
}
