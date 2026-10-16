package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbhg extends PushbackInputStream {
    final /* synthetic */ zzbhj zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbhg(zzbhj zzbhjVar, InputStream inputStream, int i3) {
        super(inputStream, 1);
        Objects.requireNonNull(zzbhjVar);
        this.zza = zzbhjVar;
    }

    @Override // java.io.PushbackInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.zza.zzc.zzb();
        super.close();
    }
}
