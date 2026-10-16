package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzasf implements zzase {
    private final FileChannel zza;
    private final long zzb;
    private final long zzc;

    public zzasf(FileChannel fileChannel, long j3, long j4) {
        this.zza = fileChannel;
        this.zzb = j3;
        this.zzc = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzase
    public final long zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzase
    public final void zzb(MessageDigest[] messageDigestArr, long j3, int i3) throws IOException {
        MappedByteBuffer map = this.zza.map(FileChannel.MapMode.READ_ONLY, this.zzb + j3, i3);
        map.load();
        for (MessageDigest messageDigest : messageDigestArr) {
            map.position(0);
            messageDigest.update(map);
        }
    }
}
