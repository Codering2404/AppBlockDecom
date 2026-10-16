package com.google.android.libraries.places.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcbv extends zzboh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcff f77473a;

    zzcbv(zzcff zzcffVar) {
        this.f77473a = zzcffVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void M0(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws EOFException {
        zzcff zzcffVar = this.f77473a;
        zzcffVar.x0(zzcffVar.zzb());
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void j2(OutputStream outputStream, int i3) throws IOException {
        this.f77473a.r(outputStream, i3);
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final int zzf() {
        return (int) this.f77473a.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final int zzg() {
        try {
            return this.f77473a.zzj() & 255;
        } catch (EOFException e3) {
            throw new IndexOutOfBoundsException(e3.getMessage());
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void zzh(int i3) {
        try {
            this.f77473a.x0(i3);
        } catch (EOFException e3) {
            throw new IndexOutOfBoundsException(e3.getMessage());
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void zzi(byte[] bArr, int i3, int i4) {
        while (i4 > 0) {
            int iL = this.f77473a.L(bArr, i3, i4);
            if (iL == -1) {
                StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 25);
                sb.append("EOF trying to read ");
                sb.append(i4);
                sb.append(" bytes");
                throw new IndexOutOfBoundsException(sb.toString());
            }
            i4 -= iL;
            i3 += iL;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final zzbxo zzl(int i3) {
        zzcff zzcffVar = new zzcff();
        zzcffVar.i2(this.f77473a, i3);
        return new zzcbv(zzcffVar);
    }
}
