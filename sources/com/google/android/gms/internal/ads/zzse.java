package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzse {
    void zzA();

    void zzB();

    void zzC();

    void zza(zzsb zzsbVar);

    boolean zzd(zzv zzvVar);

    int zze(zzv zzvVar);

    default zzqs zzf(zzv zzvVar) {
        throw null;
    }

    long zzg(boolean z2);

    default void zzh(zzrx zzrxVar) throws zzrz {
        throw null;
    }

    void zzi();

    void zzj();

    boolean zzk(ByteBuffer byteBuffer, long j3, int i3) throws zzsa, zzsd;

    void zzl() throws zzsd;

    boolean zzm();

    boolean zzn();

    void zzo(zzav zzavVar);

    zzav zzp();

    void zzq(boolean z2);

    void zzr(zzd zzdVar);

    default zzqh zzs() {
        throw null;
    }

    void zzt(int i3);

    void zzu(zze zzeVar);

    long zzx();

    void zzz(float f3);

    default void zzD() {
    }

    default void zzb(zzqf zzqfVar) {
    }

    default void zzc(zzdo zzdoVar) {
    }

    default void zzv(AudioDeviceInfo audioDeviceInfo) {
    }

    default void zzw(int i3) {
    }

    default void zzy(int i3, int i4) {
    }
}
