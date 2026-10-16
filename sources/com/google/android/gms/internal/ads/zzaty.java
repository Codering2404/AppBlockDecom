package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzaty extends FilterInputStream {
    private final long zza;
    private long zzb;

    zzaty(InputStream inputStream, long j3) {
        super(inputStream);
        this.zza = j3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i3 = super.read();
        if (i3 != -1) {
            this.zzb++;
        }
        return i3;
    }

    final long zza() {
        return this.zza - this.zzb;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = super.read(bArr, i3, i4);
        if (i5 != -1) {
            this.zzb += (long) i5;
        }
        return i5;
    }
}
