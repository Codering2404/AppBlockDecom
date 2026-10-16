package com.google.android.libraries.places.internal;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfp implements zzcfh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzcfv f77754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzcff f77755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f77756c;

    public zzcfp(zzcfv source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.f77754a = source;
        this.f77755b = new zzcff();
    }

    @Override // com.google.android.libraries.places.internal.zzcfv
    public final long A2(zzcff sink, long j3) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (j3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 15);
            sb.append("byteCount < 0: ");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f77756c) {
            throw new IllegalStateException("closed");
        }
        zzcff zzcffVar = this.f77755b;
        if (zzcffVar.zzb() == 0) {
            if (j3 == 0) {
                return 0L;
            }
            if (this.f77754a.A2(zzcffVar, 8192L) == -1) {
                return -1L;
            }
        }
        return zzcffVar.A2(sink, Math.min(j3, zzcffVar.zzb()));
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzcfv
    public final void close() throws EOFException {
        if (this.f77756c) {
            return;
        }
        this.f77756c = true;
        this.f77754a.close();
        zzcff zzcffVar = this.f77755b;
        zzcffVar.x0(zzcffVar.zzb());
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f77756c;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public final int read(ByteBuffer sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzcff zzcffVar = this.f77755b;
        if (zzcffVar.zzb() == 0 && this.f77754a.A2(zzcffVar, 8192L) == -1) {
            return -1;
        }
        return zzcffVar.read(sink);
    }

    public final String toString() {
        zzcfv zzcfvVar = this.f77754a;
        StringBuilder sb = new StringBuilder(zzcfvVar.toString().length() + 8);
        sb.append("buffer(");
        sb.append(zzcfvVar);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final void x0(long j3) throws EOFException {
        if (this.f77756c) {
            throw new IllegalStateException("closed");
        }
        while (j3 > 0) {
            zzcff zzcffVar = this.f77755b;
            if (zzcffVar.zzb() == 0 && this.f77754a.A2(zzcffVar, 8192L) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j3, zzcffVar.zzb());
            zzcffVar.x0(jMin);
            j3 -= jMin;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final zzcfj z1(long j3) throws EOFException {
        zzg(j3);
        return this.f77755b.z1(j3);
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final zzcff zze() {
        return this.f77755b;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final boolean zzf() {
        if (this.f77756c) {
            throw new IllegalStateException("closed");
        }
        zzcff zzcffVar = this.f77755b;
        return zzcffVar.zzf() && this.f77754a.A2(zzcffVar, 8192L) == -1;
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final void zzg(long j3) throws EOFException {
        zzcff zzcffVar;
        if (j3 < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(j3).length() + 15);
            sb.append("byteCount < 0: ");
            sb.append(j3);
            throw new IllegalArgumentException(sb.toString());
        }
        if (this.f77756c) {
            throw new IllegalStateException("closed");
        }
        do {
            zzcffVar = this.f77755b;
            if (zzcffVar.zzb() >= j3) {
                return;
            }
        } while (this.f77754a.A2(zzcffVar, 8192L) != -1);
        throw new EOFException();
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final byte zzj() throws EOFException {
        zzg(1L);
        return this.f77755b.zzj();
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final short zzl() throws EOFException {
        zzg(2L);
        return this.f77755b.zzl();
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final int zzm() throws EOFException {
        zzg(4L);
        return this.f77755b.zzm();
    }

    @Override // com.google.android.libraries.places.internal.zzcfh
    public final byte[] zzr(long j3) throws EOFException {
        zzg(j3);
        return this.f77755b.zzr(j3);
    }
}
