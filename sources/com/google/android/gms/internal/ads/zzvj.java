package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public interface zzvj {
    void zza(int i3, int i4, int i5, long j3, int i6);

    void zzb(int i3, int i4, zzis zzisVar, long j3, int i5);

    void zzc(int i3, boolean z2);

    void zzd(int i3, long j3);

    int zze();

    int zzf(MediaCodec.BufferInfo bufferInfo);

    MediaFormat zzg();

    ByteBuffer zzh(int i3);

    default void zzi(Runnable runnable) {
        runnable.run();
    }

    ByteBuffer zzj(int i3);

    void zzk();

    void zzl();

    default boolean zzm(zzvi zzviVar) {
        return false;
    }

    void zzn(Surface surface);

    void zzo();

    void zzp(Bundle bundle);

    void zzq(int i3);

    void zzr(List list);
}
