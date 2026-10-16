package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Api;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcdg implements zzccy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcfg f77658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzcff f77659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcdb f77660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f77661d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f77662f;

    zzcdg(zzcfg zzcfgVar, boolean z2) {
        this.f77658a = zzcfgVar;
        zzcff zzcffVar = new zzcff();
        this.f77659b = zzcffVar;
        this.f77660c = new zzcdb(4096, false, zzcffVar);
        this.f77661d = 16384;
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void D0(boolean z2, boolean z3, int i3, int i4, List list) {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        this.f77660c.a(list);
        zzcff zzcffVar = this.f77659b;
        long jZzb = zzcffVar.zzb();
        int iMin = (int) Math.min(this.f77661d, jZzb);
        long j3 = iMin;
        a(i3, iMin, (byte) 1, jZzb == j3 ? (byte) 4 : (byte) 0);
        zzcfg zzcfgVar = this.f77658a;
        zzcfgVar.i2(zzcffVar, j3);
        if (jZzb > j3) {
            long j4 = jZzb - j3;
            while (j4 > 0) {
                int iMin2 = (int) Math.min(this.f77661d, j4);
                long j5 = iMin2;
                j4 -= j5;
                a(i3, iMin2, (byte) 9, j4 == 0 ? (byte) 4 : (byte) 0);
                zzcfgVar.i2(zzcffVar, j5);
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void E1(int i3, long j3) {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        if (j3 == 0) {
            throw zzcdh.c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[]{0L});
        }
        a(i3, 4, (byte) 8, (byte) 0);
        zzcfg zzcfgVar = this.f77658a;
        zzcfgVar.C1((int) j3);
        zzcfgVar.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void G(int i3, zzccv zzccvVar) {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        int i4 = zzccvVar.f77621a;
        if (i4 == -1) {
            throw new IllegalArgumentException();
        }
        a(i3, 4, (byte) 3, (byte) 0);
        zzcfg zzcfgVar = this.f77658a;
        zzcfgVar.C1(i4);
        zzcfgVar.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void L0(boolean z2, int i3, int i4) {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, z2 ? (byte) 1 : (byte) 0);
        zzcfg zzcfgVar = this.f77658a;
        zzcfgVar.C1(i3);
        zzcfgVar.C1(i4);
        zzcfgVar.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void T0(zzcdk zzcdkVar) {
        int i3;
        try {
            if (this.f77662f) {
                throw new IOException("closed");
            }
            int i4 = 0;
            a(0, zzcdkVar.d() * 6, (byte) 4, (byte) 0);
            while (i4 < 10) {
                if (zzcdkVar.b(i4)) {
                    if (i4 == 4) {
                        int i5 = i4;
                        i4 = 3;
                        i3 = i5;
                    } else {
                        i3 = 7;
                        if (i4 == 7) {
                            i4 = 4;
                        } else {
                            i3 = i4;
                        }
                    }
                    zzcfg zzcfgVar = this.f77658a;
                    zzcfgVar.v1(i4);
                    zzcfgVar.C1(zzcdkVar.c(i3));
                    i4 = i3;
                }
                i4++;
            }
            this.f77658a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void Y0(boolean z2, int i3, zzcff zzcffVar, int i4) {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        a(i3, i4, (byte) 0, z2 ? (byte) 1 : (byte) 0);
        if (i4 > 0) {
            this.f77658a.i2(zzcffVar, i4);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void Z(int i3, zzccv zzccvVar, byte[] bArr) {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        int i4 = zzccvVar.f77621a;
        if (i4 == -1) {
            throw zzcdh.c("errorCode.httpCode == -1", new Object[0]);
        }
        a(0, 8, (byte) 7, (byte) 0);
        zzcfg zzcfgVar = this.f77658a;
        zzcfgVar.C1(0);
        zzcfgVar.C1(i4);
        zzcfgVar.flush();
    }

    final void a(int i3, int i4, byte b3, byte b4) {
        Logger logger = zzcdh.f77663a;
        Level level = Level.FINE;
        if (logger.isLoggable(level)) {
            zzcdh.f77663a.logp(level, "io.grpc.okhttp.internal.framed.Http2$Writer", "frameHeader", zzcde.a(false, i3, i4, b3, b4));
        }
        int i5 = this.f77661d;
        if (i4 > i5) {
            throw zzcdh.c("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(i5), Integer.valueOf(i4)});
        }
        if ((Integer.MIN_VALUE & i3) != 0) {
            throw zzcdh.c("reserved bit set: %s", new Object[]{Integer.valueOf(i3)});
        }
        zzcfg zzcfgVar = this.f77658a;
        zzcfgVar.X1((i4 >>> 16) & 255);
        zzcfgVar.X1((i4 >>> 8) & 255);
        zzcfgVar.X1(i4 & 255);
        zzcfgVar.X1(b3);
        zzcfgVar.X1(b4);
        zzcfgVar.C1(i3 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.f77662f = true;
        this.f77658a.close();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void v2(zzcdk zzcdkVar) {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        this.f77661d = zzcdkVar.f(this.f77661d);
        a(0, 0, (byte) 4, (byte) 1);
        this.f77658a.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void zzd() {
        try {
            if (this.f77662f) {
                throw new IOException("closed");
            }
            Logger logger = zzcdh.f77663a;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                zzcdh.f77663a.logp(level, "io.grpc.okhttp.internal.framed.Http2$Writer", "connectionPreface", String.format(">> CONNECTION %s", zzcdh.f77664b.g()));
            }
            zzcfg zzcfgVar = this.f77658a;
            zzcfgVar.n1(zzcdh.f77664b.k());
            zzcfgVar.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final synchronized void zze() {
        if (this.f77662f) {
            throw new IOException("closed");
        }
        this.f77658a.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final int zzg() {
        return this.f77661d;
    }
}
