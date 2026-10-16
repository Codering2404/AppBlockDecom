package com.google.android.gms.internal.ads;

import android.media.MediaPlayer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgi implements Runnable {
    final /* synthetic */ MediaPlayer zza;
    final /* synthetic */ zzcgr zzb;

    zzcgi(zzcgr zzcgrVar, MediaPlayer mediaPlayer) {
        this.zza = mediaPlayer;
        Objects.requireNonNull(zzcgrVar);
        this.zzb = zzcgrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzcgr zzcgrVar = this.zzb;
        zzcgrVar.zzs(this.zza);
        if (zzcgrVar.zzt() != null) {
            zzcgrVar.zzt().zzb();
        }
    }
}
