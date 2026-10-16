package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbxq extends zzboh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f77164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f77165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final byte[] f77166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f77167d = -1;

    zzbxq(byte[] bArr, int i3, int i4) {
        Preconditions.e(i3 >= 0, "offset must be >= 0");
        Preconditions.e(i4 >= 0, "length must be >= 0");
        int i5 = i4 + i3;
        Preconditions.e(i5 <= bArr.length, "offset + length exceeds array boundary");
        this.f77166c = (byte[]) Preconditions.u(bArr, "bytes");
        this.f77164a = i3;
        this.f77165b = i5;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void M0(ByteBuffer byteBuffer) {
        Preconditions.u(byteBuffer, "dest");
        int iRemaining = byteBuffer.remaining();
        a(iRemaining);
        byteBuffer.put(this.f77166c, this.f77164a, iRemaining);
        this.f77164a += iRemaining;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void j2(OutputStream outputStream, int i3) throws IOException {
        a(i3);
        outputStream.write(this.f77166c, this.f77164a, i3);
        this.f77164a += i3;
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo
    public final void zzb() {
        this.f77167d = this.f77164a;
    }

    @Override // com.google.android.libraries.places.internal.zzboh, com.google.android.libraries.places.internal.zzbxo
    public final void zzc() {
        int i3 = this.f77167d;
        if (i3 == -1) {
            throw new InvalidMarkException();
        }
        this.f77164a = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final int zzf() {
        return this.f77165b - this.f77164a;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final int zzg() {
        a(1);
        int i3 = this.f77164a;
        this.f77164a = i3 + 1;
        return this.f77166c[i3] & 255;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void zzh(int i3) {
        a(i3);
        this.f77164a += i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final void zzi(byte[] bArr, int i3, int i4) {
        System.arraycopy(this.f77166c, this.f77164a, bArr, i3, i4);
        this.f77164a += i4;
    }

    @Override // com.google.android.libraries.places.internal.zzbxo
    public final /* bridge */ /* synthetic */ zzbxo zzl(int i3) {
        a(i3);
        int i4 = this.f77164a;
        this.f77164a = i4 + i3;
        return new zzbxq(this.f77166c, i4, i3);
    }
}
