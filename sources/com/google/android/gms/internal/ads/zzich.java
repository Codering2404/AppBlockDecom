package com.google.android.gms.internal.ads;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzich extends FilterInputStream {
    private int zza;

    zzich(InputStream inputStream, int i3) {
        super(inputStream);
        this.zza = i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int available() throws IOException {
        return Math.min(super.available(), this.zza);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        if (this.zza <= 0) {
            return -1;
        }
        int i3 = super.read();
        if (i3 >= 0) {
            this.zza--;
        }
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j3) throws IOException {
        int iSkip = (int) super.skip(Math.min(j3, this.zza));
        if (iSkip >= 0) {
            this.zza -= iSkip;
        }
        return iSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = this.zza;
        if (i5 <= 0) {
            return -1;
        }
        int i6 = super.read(bArr, i3, Math.min(i4, i5));
        if (i6 >= 0) {
            this.zza -= i6;
        }
        return i6;
    }
}
