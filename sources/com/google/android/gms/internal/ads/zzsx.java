package com.google.android.gms.internal.ads;

import android.media.AudioTrack$StreamEventCallback;
import android.os.Handler;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsx {
    final /* synthetic */ zzsy zza;
    private final Handler zzb;
    private final AudioTrack$StreamEventCallback zzc;

    /* synthetic */ zzsx(zzsy zzsyVar, byte[] bArr) {
        Objects.requireNonNull(zzsyVar);
        this.zza = zzsyVar;
        final Handler handlerZzd = zzfl.zzd(null);
        this.zzb = handlerZzd;
        zzsv zzsvVar = new zzsv(this);
        this.zzc = zzsvVar;
        Objects.requireNonNull(handlerZzd);
        zzsyVar.zzt().registerStreamEventCallback(new Executor() { // from class: com.google.android.gms.internal.ads.zzsw
            @Override // java.util.concurrent.Executor
            public final /* synthetic */ void execute(Runnable runnable) {
                handlerZzd.post(runnable);
            }
        }, zzsvVar);
    }

    final /* synthetic */ void zza() {
        this.zza.zzt().unregisterStreamEventCallback(this.zzc);
        this.zzb.removeCallbacksAndMessages(null);
    }
}
