package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdd implements zzcfv {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcfh f77646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f77647b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    byte f77648c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f77649d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f77650f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    short f77651g;

    public zzcdd(zzcfh zzcfhVar) {
        this.f77646a = zzcfhVar;
    }

    @Override // com.google.android.libraries.places.internal.zzcfv
    public final long A2(zzcff zzcffVar, long j3) throws IOException {
        int i3;
        int iZzm;
        do {
            int i4 = this.f77650f;
            if (i4 == 0) {
                zzcfh zzcfhVar = this.f77646a;
                zzcfhVar.x0(this.f77651g);
                this.f77651g = (short) 0;
                if ((this.f77648c & 4) == 0) {
                    i3 = this.f77649d;
                    int iF = zzcdh.f(zzcfhVar);
                    this.f77650f = iF;
                    this.f77647b = iF;
                    int iZzj = zzcfhVar.zzj() & 255;
                    this.f77648c = (byte) (zzcfhVar.zzj() & 255);
                    Logger logger = zzcdh.f77663a;
                    Level level = Level.FINE;
                    byte b3 = (byte) iZzj;
                    if (logger.isLoggable(level)) {
                        zzcdh.f77663a.logp(level, "io.grpc.okhttp.internal.framed.Http2$ContinuationSource", "readContinuationHeader", zzcde.a(true, this.f77649d, this.f77647b, b3, this.f77648c));
                    }
                    iZzm = zzcfhVar.zzm() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                    this.f77649d = iZzm;
                    if (b3 != 9) {
                        throw zzcdh.i("%s != TYPE_CONTINUATION", Byte.valueOf(b3));
                    }
                }
            } else {
                long jA2 = this.f77646a.A2(zzcffVar, Math.min(j3, i4));
                if (jA2 != -1) {
                    this.f77650f -= (int) jA2;
                    return jA2;
                }
            }
            return -1L;
        } while (iZzm == i3);
        throw zzcdh.i("TYPE_CONTINUATION streamId changed", new Object[0]);
    }

    @Override // com.google.android.libraries.places.internal.zzcfv, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
