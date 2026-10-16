package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzcav implements zzccy {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Logger f77360d = Logger.getLogger(zzcbp.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzcau f77361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzccy f77362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcbs f77363c = new zzcbs(Level.FINE, zzcbp.class);

    zzcav(zzcau zzcauVar, zzccy zzccyVar) {
        this.f77361a = (zzcau) Preconditions.u(zzcauVar, "transportExceptionHandler");
        this.f77362b = (zzccy) Preconditions.u(zzccyVar, "frameWriter");
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void D0(boolean z2, boolean z3, int i3, int i4, List list) {
        try {
            this.f77362b.D0(false, false, i3, 0, list);
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void E1(int i3, long j3) {
        this.f77363c.j(2, i3, j3);
        try {
            this.f77362b.E1(i3, j3);
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void G(int i3, zzccv zzccvVar) {
        this.f77363c.c(2, i3, zzccvVar);
        try {
            this.f77362b.G(i3, zzccvVar);
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void L0(boolean z2, int i3, int i4) {
        long j3 = (((long) i3) << 32) | (((long) i4) & 4294967295L);
        if (z2) {
            this.f77363c.g(2, j3);
        } else {
            this.f77363c.f(2, j3);
        }
        try {
            this.f77362b.L0(z2, i3, i4);
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void T0(zzcdk zzcdkVar) {
        this.f77363c.e(2, zzcdkVar);
        try {
            this.f77362b.T0(zzcdkVar);
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void Y0(boolean z2, int i3, zzcff zzcffVar, int i4) {
        this.f77363c.a(2, i3, zzcffVar, i4, z2);
        try {
            this.f77362b.Y0(z2, i3, zzcffVar, i4);
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void Z(int i3, zzccv zzccvVar, byte[] bArr) {
        zzcfj zzcfjVar = zzcfj.f77742d;
        this.f77363c.i(2, 0, zzccvVar, zzcfi.b(bArr));
        try {
            zzccy zzccyVar = this.f77362b;
            zzccyVar.Z(0, zzccvVar, bArr);
            zzccyVar.zze();
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f77362b.close();
        } catch (IOException e3) {
            f77360d.logp(e3.getClass().equals(IOException.class) ? Level.FINE : Level.INFO, "io.grpc.okhttp.ExceptionHandlingFrameWriter", "close", "Failed closing connection", (Throwable) e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void v2(zzcdk zzcdkVar) {
        this.f77363c.d(2);
        try {
            this.f77362b.v2(zzcdkVar);
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void zzd() {
        try {
            this.f77362b.zzd();
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final void zze() {
        try {
            this.f77362b.zze();
        } catch (IOException e3) {
            this.f77361a.d(e3);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzccy
    public final int zzg() {
        return this.f77362b.zzg();
    }
}
