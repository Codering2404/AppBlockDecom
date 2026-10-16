package com.google.android.gms.internal.ads;

import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqj extends AudioDeviceCallback {
    final /* synthetic */ zzqn zza;

    /* synthetic */ zzqj(zzqn zzqnVar, byte[] bArr) {
        Objects.requireNonNull(zzqnVar);
        this.zza = zzqnVar;
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
        this.zza.zzi();
    }

    @Override // android.media.AudioDeviceCallback
    public final void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
        String str = zzfl.zza;
        int length = audioDeviceInfoArr.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            zzqn zzqnVar = this.zza;
            if (Objects.equals(audioDeviceInfoArr[i3], zzqnVar.zzj())) {
                zzqnVar.zzk(null);
                break;
            }
            i3++;
        }
        this.zza.zzi();
    }
}
