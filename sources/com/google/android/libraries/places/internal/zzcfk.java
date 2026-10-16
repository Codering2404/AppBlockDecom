package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcfk implements zzcfv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InputStream f77746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcfx f77747b;

    public zzcfk(InputStream input, zzcfx timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.f77746a = input;
        this.f77747b = timeout;
    }

    @Override // com.google.android.libraries.places.internal.zzcfv
    public final long A2(zzcff sink, long j3) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            this.f77747b.a();
            zzcfq zzcfqVarJ = sink.j(1);
            int i3 = this.f77746a.read(zzcfqVarJ.f77757a, zzcfqVarJ.f77759c, (int) Math.min(j3, 8192 - zzcfqVarJ.f77759c));
            if (i3 != -1) {
                zzcfqVarJ.f77759c += i3;
                long j4 = i3;
                sink.zzd(sink.zzb() + j4);
                return j4;
            }
            if (zzcfqVarJ.f77758b != zzcfqVarJ.f77759c) {
                return -1L;
            }
            sink.f77740a = zzcfqVarJ.b();
            zzcfr.b(zzcfqVarJ);
            return -1L;
        } catch (AssertionError e3) {
            if (zzcfm.a(e3)) {
                throw new IOException(e3);
            }
            throw e3;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcfv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f77746a.close();
    }

    public final String toString() {
        InputStream inputStream = this.f77746a;
        StringBuilder sb = new StringBuilder(String.valueOf(inputStream).length() + 8);
        sb.append("source(");
        sb.append(inputStream);
        sb.append(")");
        return sb.toString();
    }
}
