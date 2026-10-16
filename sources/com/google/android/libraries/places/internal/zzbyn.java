package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbyn extends zzbje {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbzd f77206b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    long f77207c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbzf f77208d;

    zzbyn(zzbzf zzbzfVar, zzbzd zzbzdVar) {
        Objects.requireNonNull(zzbzfVar);
        this.f77208d = zzbzfVar;
        this.f77206b = zzbzdVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbnt
    public final void a(long j3) {
        zzbzf zzbzfVar = this.f77208d;
        if (zzbzfVar.x().f77226f != null) {
            return;
        }
        synchronized (zzbzfVar.r()) {
            try {
                if (zzbzfVar.x().f77226f == null) {
                    zzbzd zzbzdVar = this.f77206b;
                    if (!zzbzdVar.f77245b) {
                        long j4 = this.f77207c + j3;
                        this.f77207c = j4;
                        if (j4 <= zzbzfVar.D()) {
                            return;
                        }
                        if (j4 > zzbzfVar.t()) {
                            zzbzdVar.f77246c = true;
                        } else {
                            long jA = zzbzfVar.s().a(j4 - zzbzfVar.D());
                            zzbzfVar.E(this.f77207c);
                            if (jA > zzbzfVar.u()) {
                                zzbzdVar.f77246c = true;
                            }
                        }
                        Runnable runnableY = zzbzdVar.f77246c ? zzbzfVar.Y(zzbzdVar) : null;
                        if (runnableY != null) {
                            runnableY.run();
                        }
                    }
                }
            } finally {
            }
        }
    }
}
