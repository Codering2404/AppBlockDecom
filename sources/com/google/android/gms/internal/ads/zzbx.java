package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbx extends BroadcastReceiver {
    private final zzdz zza;

    /* synthetic */ zzbx(zzbz zzbzVar, zzdz zzdzVar, zzby zzbyVar, byte[] bArr) {
        Objects.requireNonNull(zzbzVar);
        this.zza = zzdzVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
            this.zza.zzm(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                }
            });
        }
    }
}
