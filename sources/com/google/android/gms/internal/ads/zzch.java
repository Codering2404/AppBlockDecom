package com.google.android.gms.internal.ads;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzch {
    private final AudioManager.OnAudioFocusChangeListener zzb;
    private final Handler zzc;
    private final zzd zzd;
    private final Object zzf;
    private final int zza = 1;
    private final boolean zze = false;

    zzch(int i3, AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler, zzd zzdVar, boolean z2, boolean z3) {
        this.zzc = handler;
        this.zzd = zzdVar;
        this.zzb = onAudioFocusChangeListener;
        this.zzf = new AudioFocusRequest.Builder(1).setAudioAttributes(zzdVar.zza()).setWillPauseWhenDucked(false).setOnAudioFocusChangeListener(onAudioFocusChangeListener, handler).setAcceptsDelayedFocusGain(z3).build();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzch)) {
            return false;
        }
        zzch zzchVar = (zzch) obj;
        return Objects.equals(this.zzb, zzchVar.zzb) && Objects.equals(this.zzc, zzchVar.zzc) && Objects.equals(this.zzd, zzchVar.zzd);
    }

    public final int hashCode() {
        return Objects.hash(1, this.zzb, this.zzc, this.zzd, Boolean.FALSE);
    }

    public final zzd zza() {
        return this.zzd;
    }

    public final AudioManager.OnAudioFocusChangeListener zzb() {
        return this.zzb;
    }

    final AudioFocusRequest zzc() {
        Object obj = this.zzf;
        obj.getClass();
        return (AudioFocusRequest) obj;
    }
}
