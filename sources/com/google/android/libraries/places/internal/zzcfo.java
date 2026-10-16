package com.google.android.libraries.places.internal;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfo implements zzcfg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zzcft f77751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzcff f77752b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f77753c;

    public zzcfo(zzcft sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        this.f77751a = sink;
        this.f77752b = new zzcff();
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final zzcfg C1(int i3) {
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        this.f77752b.c(i3);
        return a();
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final zzcfg X1(int i3) {
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        this.f77752b.a(i3);
        return a();
    }

    public final zzcfg a() {
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        zzcff zzcffVar = this.f77752b;
        long jZzi = zzcffVar.zzi();
        if (jZzi > 0) {
            this.f77751a.i2(zzcffVar, jZzi);
        }
        return this;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzcft
    public final void close() throws Throwable {
        Throwable th;
        if (this.f77753c) {
            return;
        }
        try {
            zzcff zzcffVar = this.f77752b;
            th = null;
            if (zzcffVar.zzb() > 0) {
                this.f77751a.i2(zzcffVar, zzcffVar.zzb());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f77751a.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f77753c = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcfg, com.google.android.libraries.places.internal.zzcft, java.io.Flushable
    public final void flush() {
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        zzcff zzcffVar = this.f77752b;
        if (zzcffVar.zzb() > 0) {
            this.f77751a.i2(zzcffVar, zzcffVar.zzb());
        }
        this.f77751a.flush();
    }

    @Override // com.google.android.libraries.places.internal.zzcft
    public final void i2(zzcff source, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        this.f77752b.i2(source, j3);
        a();
    }

    @Override // java.nio.channels.Channel
    public final boolean isOpen() {
        return !this.f77753c;
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final zzcfg n1(byte[] source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        this.f77752b.e0(source);
        return a();
    }

    public final String toString() {
        zzcft zzcftVar = this.f77751a;
        StringBuilder sb = new StringBuilder(zzcftVar.toString().length() + 8);
        sb.append("buffer(");
        sb.append(zzcftVar);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final zzcfg v1(int i3) {
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        this.f77752b.b(i3);
        return a();
    }

    @Override // java.nio.channels.WritableByteChannel
    public final int write(ByteBuffer source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        int iWrite = this.f77752b.write(source);
        a();
        return iWrite;
    }

    @Override // com.google.android.libraries.places.internal.zzcfg
    public final zzcfg zzH(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        if (this.f77753c) {
            throw new IllegalStateException("closed");
        }
        this.f77752b.N(string);
        return a();
    }
}
