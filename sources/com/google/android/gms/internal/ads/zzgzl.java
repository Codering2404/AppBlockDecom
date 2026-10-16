package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzl extends FilterInputStream {
    private long zza;
    private long zzb;

    zzgzl(InputStream inputStream, long j3) {
        super(inputStream);
        this.zzb = -1L;
        inputStream.getClass();
        zzgtj.zzb(j3 >= 0, "limit must be non-negative");
        this.zza = j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return (int) Math.min(((FilterInputStream) this).in.available(), this.zza);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
        ((FilterInputStream) this).in.mark(i3);
        this.zzb = this.zza;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.zza == 0) {
            return -1;
        }
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 != -1) {
            this.zza--;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() throws IOException {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.zzb == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.zza = this.zzb;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j3) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(Math.min(j3, this.zza));
        this.zza -= jSkip;
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        long j3 = this.zza;
        if (j3 == 0) {
            return -1;
        }
        int i5 = ((FilterInputStream) this).in.read(bArr, i3, (int) Math.min(i4, j3));
        if (i5 != -1) {
            this.zza -= (long) i5;
        }
        return i5;
    }
}
