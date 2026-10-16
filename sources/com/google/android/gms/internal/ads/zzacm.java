package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacm {
    private final Spatializer zza;
    private final boolean zzb;
    private final Handler zzc;
    private final Spatializer$OnSpatializerStateChangedListener zzd;

    public zzacm(Context context, Runnable runnable, Boolean bool) {
        AudioManager audioManagerZza = context == null ? null : zzcj.zza(context);
        if (audioManagerZza == null || (bool != null && bool.booleanValue())) {
            this.zza = null;
            this.zzb = false;
            this.zzc = null;
            this.zzd = null;
            return;
        }
        Spatializer spatializer = audioManagerZza.getSpatializer();
        this.zza = spatializer;
        this.zzb = spatializer.getImmersiveAudioLevel() != 0;
        Looper looperMyLooper = Looper.myLooper();
        looperMyLooper.getClass();
        final Handler handler = new Handler(looperMyLooper);
        this.zzc = handler;
        zzack zzackVar = new zzack(this, runnable);
        this.zzd = zzackVar;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new Executor() { // from class: com.google.android.gms.internal.ads.zzacl
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable2) {
                handler.post(runnable2);
            }
        }, zzackVar);
    }

    public final boolean zza() {
        return this.zza != null && this.zzb && zzc() && zzd();
    }

    public final boolean zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        Spatializer spatializer = this.zza;
        return spatializer != null && spatializer.isAvailable();
    }

    public final boolean zzd() {
        Spatializer spatializer = this.zza;
        return spatializer != null && spatializer.isEnabled();
    }

    public final boolean zze(zzd zzdVar, zzv zzvVar) {
        int i3;
        if (!zza()) {
            return false;
        }
        String str = zzvVar.zzp;
        if (Objects.equals(str, "audio/eac3-joc")) {
            i3 = zzvVar.zzH;
            if (i3 == 16) {
                i3 = 12;
            }
        } else if (Objects.equals(str, "audio/iamf")) {
            i3 = zzvVar.zzH;
            if (i3 == -1) {
                i3 = 6;
            }
        } else if (Objects.equals(str, "audio/ac4")) {
            i3 = zzvVar.zzH;
            if (i3 == 18 || i3 == 21) {
                i3 = 24;
            }
        } else {
            i3 = zzvVar.zzH;
        }
        int iZzE = zzfl.zzE(i3);
        if (iZzE == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iZzE);
        int i4 = zzvVar.zzI;
        if (i4 != -1) {
            channelMask.setSampleRate(i4);
        }
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return androidx.media3.exoplayer.trackselection.p.a(spatializer).canBeSpatialized(zzdVar.zza(), channelMask.build());
    }

    public final List zzf() {
        if (!zza()) {
            return zzgwm.zzi();
        }
        if (Build.VERSION.SDK_INT < 36) {
            return zzgwm.zzj(252);
        }
        Spatializer spatializer = this.zza;
        spatializer.getClass();
        return androidx.media3.exoplayer.trackselection.p.a(spatializer).getSpatializedChannelMasks();
    }

    public final void zzg() {
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
        Handler handler;
        Spatializer spatializer = this.zza;
        if (spatializer == null || (spatializer$OnSpatializerStateChangedListener = this.zzd) == null || (handler = this.zzc) == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
        handler.removeCallbacksAndMessages(null);
    }
}
