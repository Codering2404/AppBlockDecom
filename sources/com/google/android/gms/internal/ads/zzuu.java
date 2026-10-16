package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import com.google.firebase.sessions.api.ITd.wgbAZXYjrv;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzuu implements zzvj {
    private final MediaCodec zza;
    private final zzuz zzb;
    private final zzvk zzc;
    private final zzvf zzd;
    private boolean zze;
    private int zzf = 0;

    /* synthetic */ zzuu(MediaCodec mediaCodec, HandlerThread handlerThread, zzvk zzvkVar, zzvf zzvfVar, byte[] bArr) {
        this.zza = mediaCodec;
        this.zzb = new zzuz(handlerThread);
        this.zzc = zzvkVar;
        this.zzd = zzvfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zza(int i3, int i4, int i5, long j3, int i6) {
        this.zzc.zzb(i3, 0, i5, j3, i6);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzb(int i3, int i4, zzis zzisVar, long j3, int i5) {
        this.zzc.zzc(i3, 0, zzisVar, j3, i5);
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
        this.zzc.zzg();
        return this.zzb.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final int zzf(MediaCodec.BufferInfo bufferInfo) {
        this.zzc.zzg();
        return this.zzb.zze(bufferInfo);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final MediaFormat zzg() {
        return this.zzb.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final ByteBuffer zzh(int i3) {
        return this.zza.getInputBuffer(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzi(final Runnable runnable) {
        this.zzb.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzuq
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzs(runnable);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final ByteBuffer zzj(int i3) {
        return this.zza.getOutputBuffer(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzk() {
        this.zzc.zze();
        MediaCodec mediaCodec = this.zza;
        mediaCodec.flush();
        this.zzb.zzg();
        mediaCodec.start();
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzl() {
        zzvf zzvfVar;
        zzvf zzvfVar2;
        zzvf zzvfVar3;
        try {
            try {
                if (this.zzf == 1) {
                    this.zzc.zzf();
                    this.zzb.zzb();
                }
                this.zzf = 2;
                if (this.zze) {
                    return;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 30 && i3 < 33) {
                    this.zza.stop();
                }
                if (i3 >= 35 && (zzvfVar3 = this.zzd) != null) {
                    zzvfVar3.zzc(this.zza);
                }
                this.zza.release();
                this.zze = true;
            } catch (Throwable th) {
                if (!this.zze) {
                    int i4 = Build.VERSION.SDK_INT;
                    if (i4 >= 30 && i4 < 33) {
                        this.zza.stop();
                    }
                    if (i4 >= 35 && (zzvfVar2 = this.zzd) != null) {
                        zzvfVar2.zzc(this.zza);
                    }
                    this.zza.release();
                    this.zze = true;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (Build.VERSION.SDK_INT >= 35 && (zzvfVar = this.zzd) != null) {
                zzvfVar.zzc(this.zza);
            }
            this.zza.release();
            this.zze = true;
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final boolean zzm(zzvi zzviVar) {
        this.zzb.zzh(zzviVar);
        return true;
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
        this.zzc.zzd(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzq(int i3) {
        this.zza.setVideoScalingMode(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzvj
    public final void zzr(List list) {
        this.zza.subscribeToVendorParameters(list);
    }

    final /* synthetic */ void zzs(Runnable runnable) {
        this.zzc.zzg();
        this.zzb.zzc(runnable);
    }

    final /* synthetic */ void zzt(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i3) {
        zzvf zzvfVar;
        zzuz zzuzVar = this.zzb;
        MediaCodec mediaCodec = this.zza;
        zzuzVar.zza(mediaCodec);
        Trace.beginSection("configureCodec");
        mediaCodec.configure(mediaFormat, surface, (MediaCrypto) null, i3);
        Trace.endSection();
        this.zzc.zza();
        Trace.beginSection("startCodec");
        mediaCodec.start();
        Trace.endSection();
        if (Build.VERSION.SDK_INT >= 35 && (zzvfVar = this.zzd) != null) {
            zzvfVar.zzb(mediaCodec);
        }
        this.zzf = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzw(int i3, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i3 == 1) {
            sb.append("Audio");
        } else if (i3 == 2) {
            sb.append("Video");
        } else {
            sb.append(wgbAZXYjrv.vGEroHHrDFi);
            sb.append(i3);
            sb.append(")");
        }
        return sb.toString();
    }
}
