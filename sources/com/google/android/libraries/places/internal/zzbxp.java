package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxp extends InputStream implements zzbla {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbxo f77163a;

    public zzbxp(zzbxo zzbxoVar) {
        this.f77163a = (zzbxo) Preconditions.u(zzbxoVar, "buffer");
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f77163a.zzf();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f77163a.close();
    }

    @Override // java.io.InputStream
    public final void mark(int i3) {
        this.f77163a.zzb();
    }

    @Override // java.io.InputStream
    public final boolean markSupported() {
        return this.f77163a.zza();
    }

    @Override // java.io.InputStream
    public final int read() {
        zzbxo zzbxoVar = this.f77163a;
        if (zzbxoVar.zzf() == 0) {
            return -1;
        }
        return zzbxoVar.zzg();
    }

    @Override // java.io.InputStream
    public final void reset() {
        this.f77163a.zzc();
    }

    @Override // java.io.InputStream
    public final long skip(long j3) {
        zzbxo zzbxoVar = this.f77163a;
        int iMin = (int) Math.min(zzbxoVar.zzf(), j3);
        zzbxoVar.zzh(iMin);
        return iMin;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i3, int i4) {
        zzbxo zzbxoVar = this.f77163a;
        if (zzbxoVar.zzf() == 0) {
            return -1;
        }
        int iMin = Math.min(zzbxoVar.zzf(), i4);
        zzbxoVar.zzi(bArr, i3, iMin);
        return iMin;
    }
}
