package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Trace;
import android.view.Surface;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzut implements zzvh {
    private final zzgub zza;
    private final zzgub zzb;
    private boolean zzc;

    public zzut(final int i3) {
        zzgub zzgubVar = new zzgub() { // from class: com.google.android.gms.internal.ads.zzus
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzuu.zzw(i3, "ExoPlayer:MediaCodecAsyncAdapter:"));
            }
        };
        zzgub zzgubVar2 = new zzgub() { // from class: com.google.android.gms.internal.ads.zzur
            @Override // com.google.android.gms.internal.ads.zzgub
            public final /* synthetic */ Object zza() {
                return new HandlerThread(zzuu.zzw(i3, "ExoPlayer:MediaCodecQueueingThread:"));
            }
        };
        this.zza = zzgubVar;
        this.zzb = zzgubVar2;
        this.zzc = true;
    }

    public final void zza(boolean z2) {
        this.zzc = true;
    }

    public final zzuu zzb(zzvg zzvgVar) throws Exception {
        Exception exc;
        MediaCodec mediaCodecCreateByCodecName;
        zzvk zzwhVar;
        int i3;
        zzvm zzvmVar = zzvgVar.zza;
        String str = zzvmVar.zza;
        zzuu zzuuVar = null;
        try {
            StringBuilder sb = new StringBuilder(str.length() + 12);
            sb.append("createCodec:");
            sb.append(str);
            Trace.beginSection(sb.toString());
            mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            try {
                if (this.zzc && Build.VERSION.SDK_INT >= 36) {
                    zzwhVar = new zzwh(mediaCodecCreateByCodecName);
                    i3 = 4;
                } else {
                    zzwhVar = new zzux(mediaCodecCreateByCodecName, (HandlerThread) this.zzb.zza());
                    i3 = 0;
                }
                zzuu zzuuVar2 = new zzuu(mediaCodecCreateByCodecName, (HandlerThread) this.zza.zza(), zzwhVar, zzvgVar.zzf, null);
                try {
                    Trace.endSection();
                    Surface surface = zzvgVar.zzd;
                    if (surface == null && zzvmVar.zzh && Build.VERSION.SDK_INT >= 35) {
                        i3 |= 8;
                    }
                    zzuuVar2.zzt(zzvgVar.zzb, surface, null, i3);
                    return zzuuVar2;
                } catch (Exception e3) {
                    exc = e3;
                    zzuuVar = zzuuVar2;
                    if (zzuuVar != null) {
                        zzuuVar.zzl();
                        throw exc;
                    }
                    if (mediaCodecCreateByCodecName == null) {
                        throw exc;
                    }
                    mediaCodecCreateByCodecName.release();
                    throw exc;
                }
            } catch (Exception e4) {
                exc = e4;
            }
        } catch (Exception e5) {
            exc = e5;
            mediaCodecCreateByCodecName = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final /* bridge */ /* synthetic */ zzvj zzc(zzvg zzvgVar) throws IOException {
        throw null;
    }
}
