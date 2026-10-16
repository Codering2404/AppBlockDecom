package com.google.android.libraries.places.internal;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzcfc implements zzcft {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcft f77737a;

    zzcfc(zzcfe zzcfeVar, zzcft zzcftVar) {
        this.f77737a = zzcftVar;
    }

    @Override // com.google.android.libraries.places.internal.zzcft, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            this.f77737a.close();
            Unit unit = Unit.f139807a;
        } catch (IOException e3) {
            throw e3;
        } finally {
            zzcfe.b();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcft, java.io.Flushable
    public final void flush() {
        try {
            this.f77737a.flush();
            Unit unit = Unit.f139807a;
        } catch (IOException e3) {
            throw e3;
        } finally {
            zzcfe.b();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzcft
    public final void i2(zzcff source, long j3) {
        Intrinsics.checkNotNullParameter(source, "source");
        zzcfb.a(source.zzb(), 0L, j3);
        while (true) {
            long j4 = 0;
            if (j3 <= 0) {
                return;
            }
            zzcfq zzcfqVar = source.f77740a;
            Intrinsics.checkNotNull(zzcfqVar);
            while (true) {
                if (j4 >= 65536) {
                    break;
                }
                j4 += (long) (zzcfqVar.f77759c - zzcfqVar.f77758b);
                if (j4 >= j3) {
                    j4 = j3;
                    break;
                } else {
                    zzcfqVar = zzcfqVar.f77762f;
                    Intrinsics.checkNotNull(zzcfqVar);
                }
            }
            try {
                try {
                    this.f77737a.i2(source, j4);
                    Unit unit = Unit.f139807a;
                    zzcfe.b();
                    j3 -= j4;
                } catch (IOException e3) {
                    zzcfe.b();
                    throw e3;
                }
            } catch (Throwable th) {
                zzcfe.b();
                throw th;
            }
        }
    }

    public final String toString() {
        zzcft zzcftVar = this.f77737a;
        StringBuilder sb = new StringBuilder(zzcftVar.toString().length() + 19);
        sb.append("AsyncTimeout.sink(");
        sb.append(zzcftVar);
        sb.append(")");
        return sb.toString();
    }
}
