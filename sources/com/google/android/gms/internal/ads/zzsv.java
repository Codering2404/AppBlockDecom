package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsv extends AudioTrack$StreamEventCallback {
    final /* synthetic */ zzsx zza;

    zzsv(zzsx zzsxVar) {
        Objects.requireNonNull(zzsxVar);
        this.zza = zzsxVar;
    }

    public final void onDataRequest(AudioTrack audioTrack, int i3) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzsu.zza);
        zzefVarZzu.zzf();
    }

    public final void onPresentationEnded(AudioTrack audioTrack) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzss.zza);
        zzefVarZzu.zzf();
    }

    public final void onTearDown(AudioTrack audioTrack) {
        zzef zzefVarZzu = this.zza.zza.zzu();
        zzefVarZzu.zze(-1, zzst.zza);
        zzefVarZzu.zzf();
    }
}
