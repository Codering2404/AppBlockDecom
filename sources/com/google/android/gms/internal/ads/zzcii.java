package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcii implements zzimg {
    private final ByteBuffer zza;

    zzcii(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzimg
    public final int zza(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBuffer2 = this.zza;
        if (byteBuffer2.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), byteBuffer2.remaining());
        byte[] bArr = new byte[iMin];
        byteBuffer2.get(bArr);
        byteBuffer.put(bArr);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzimg
    public final long zzb() throws IOException {
        return this.zza.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzimg
    public final long zzc() throws IOException {
        return this.zza.position();
    }

    @Override // com.google.android.gms.internal.ads.zzimg
    public final void zzd(long j3) throws IOException {
        this.zza.position((int) j3);
    }

    @Override // com.google.android.gms.internal.ads.zzimg
    public final ByteBuffer zze(long j3, long j4) throws IOException {
        ByteBuffer byteBuffer = this.zza;
        int iPosition = byteBuffer.position();
        byteBuffer.position((int) j3);
        ByteBuffer byteBufferSlice = byteBuffer.slice();
        byteBufferSlice.limit((int) j4);
        byteBuffer.position(iPosition);
        return byteBufferSlice;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
