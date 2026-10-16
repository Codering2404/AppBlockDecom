package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcfn implements zzcft {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final OutputStream f77749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcfx f77750b;

    public zzcfn(OutputStream out, zzcfx timeout) {
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f77749a = out;
        this.f77750b = timeout;
    }

    @Override // com.google.android.libraries.places.internal.zzcft, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f77749a.close();
    }

    @Override // com.google.android.libraries.places.internal.zzcft, java.io.Flushable
    public final void flush() throws IOException {
        this.f77749a.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzcft
    public final void i2(zzcff source, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        zzcfb.a(source.zzb(), 0L, j3);
        while (j3 > 0) {
            this.f77750b.a();
            zzcfq zzcfqVar = source.f77740a;
            Intrinsics.checkNotNull(zzcfqVar);
            int iMin = (int) Math.min(j3, zzcfqVar.f77759c - zzcfqVar.f77758b);
            this.f77749a.write(zzcfqVar.f77757a, zzcfqVar.f77758b, iMin);
            zzcfqVar.f77758b += iMin;
            long j4 = iMin;
            source.zzd(source.zzb() - j4);
            j3 -= j4;
            if (zzcfqVar.f77758b == zzcfqVar.f77759c) {
                source.f77740a = zzcfqVar.b();
                zzcfr.b(zzcfqVar);
            }
        }
    }

    public final String toString() {
        OutputStream outputStream = this.f77749a;
        StringBuilder sb = new StringBuilder(String.valueOf(outputStream).length() + 6);
        sb.append("sink(");
        sb.append(outputStream);
        sb.append(")");
        return sb.toString();
    }
}
