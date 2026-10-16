package com.google.android.libraries.places.internal;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public interface zzbxo extends Closeable {
    void M0(ByteBuffer byteBuffer);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void j2(OutputStream outputStream, int i3);

    boolean zza();

    void zzb();

    void zzc();

    int zzf();

    int zzg();

    void zzh(int i3);

    void zzi(byte[] bArr, int i3, int i4);

    zzbxo zzl(int i3);
}
