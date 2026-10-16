package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzasd implements zzase {
    private final ByteBuffer zza;

    public zzasd(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    @Override // com.google.android.gms.internal.ads.zzase
    public final long zza() {
        return this.zza.capacity();
    }

    @Override // com.google.android.gms.internal.ads.zzase
    public final void zzb(MessageDigest[] messageDigestArr, long j3, int i3) throws IOException {
        ByteBuffer byteBufferSlice;
        ByteBuffer byteBuffer = this.zza;
        synchronized (byteBuffer) {
            int i4 = (int) j3;
            byteBuffer.position(i4);
            byteBuffer.limit(i4 + i3);
            byteBufferSlice = byteBuffer.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }
}
