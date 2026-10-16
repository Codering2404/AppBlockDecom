package com.google.android.libraries.places.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbwg extends FilterInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f77065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcaa f77066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f77067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f77068d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f77069f;

    zzbwg(InputStream inputStream, int i3, zzcaa zzcaaVar) {
        super(inputStream);
        this.f77069f = -1L;
        this.f77065a = i3;
        this.f77066b = zzcaaVar;
    }

    private final void a() {
        long j3 = this.f77068d;
        long j4 = this.f77067c;
        if (j3 > j4) {
            this.f77066b.l(j3 - j4);
            this.f77067c = this.f77068d;
        }
    }

    private final void zzb() {
        long j3 = this.f77068d;
        int i3 = this.f77065a;
        if (j3 <= i3) {
            return;
        }
        zzbnp zzbnpVar = zzbnp.f76493j;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 47);
        sb.append("Decompressed gRPC message exceeds maximum size ");
        sb.append(i3);
        throw new zzbns(zzbnpVar.e(sb.toString()), null);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void mark(int i3) {
        ((FilterInputStream) this).in.mark(i3);
        this.f77069f = this.f77068d;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read() throws IOException {
        int i3 = ((FilterInputStream) this).in.read();
        if (i3 != -1) {
            this.f77068d++;
        }
        zzb();
        a();
        return i3;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final synchronized void reset() {
        if (!((FilterInputStream) this).in.markSupported()) {
            throw new IOException("Mark not supported");
        }
        if (this.f77069f == -1) {
            throw new IOException("Mark not set");
        }
        ((FilterInputStream) this).in.reset();
        this.f77068d = this.f77069f;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final long skip(long j3) throws IOException {
        long jSkip = ((FilterInputStream) this).in.skip(j3);
        this.f77068d += jSkip;
        zzb();
        a();
        return jSkip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) throws IOException {
        int i5 = ((FilterInputStream) this).in.read(bArr, i3, i4);
        if (i5 != -1) {
            this.f77068d += (long) i5;
        }
        zzb();
        a();
        return i5;
    }
}
