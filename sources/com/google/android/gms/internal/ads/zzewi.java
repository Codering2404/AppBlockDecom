package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzewi implements zzfck {
    private final zzhcg zza;
    private final Context zzb;

    public zzewi(zzhcg zzhcgVar, Context context) {
        this.zza = zzhcgVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final ListenableFuture zza() {
        return this.zza.submit(new Callable() { // from class: com.google.android.gms.internal.ads.zzewh
            @Override // java.util.concurrent.Callable
            public final /* synthetic */ Object call() {
                return this.zza.zzc();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzfck
    public final int zzb() {
        return 13;
    }

    final /* synthetic */ zzewj zzc() {
        int i3;
        int streamMaxVolume;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        float fB = com.google.android.gms.ads.internal.zzt.m().b();
        boolean zD = com.google.android.gms.ads.internal.zzt.m().d();
        if (audioManager == null) {
            return new zzewj(-1, false, false, -1, -1, -1, -1, -1, fB, zD, true);
        }
        int mode = audioManager.getMode();
        boolean zIsMusicActive = audioManager.isMusicActive();
        boolean zIsSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.c().zzd(zzbiq.zzmt)).booleanValue()) {
            int iJ = com.google.android.gms.ads.internal.zzt.j().j(audioManager);
            streamMaxVolume = audioManager.getStreamMaxVolume(3);
            i3 = iJ;
        } else {
            i3 = -1;
            streamMaxVolume = -1;
        }
        return new zzewj(mode, zIsMusicActive, zIsSpeakerphoneOn, streamVolume, i3, streamMaxVolume, audioManager.getRingerMode(), audioManager.getStreamVolume(2), fB, zD, false);
    }
}
