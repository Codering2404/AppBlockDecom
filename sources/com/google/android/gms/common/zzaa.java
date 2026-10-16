package com.google.android.gms.common;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.common.zzah;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f72318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f72319b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzah f72320c = zzah.zzj();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzah f72321d = zzah.zzj();

    zzaa() {
    }

    final zzaa a(String str) {
        this.f72318a = str;
        return this;
    }

    final zzaa b(long j3) {
        this.f72319b = j3;
        return this;
    }

    final zzaa c(List list) {
        Preconditions.m(list);
        this.f72320c = zzah.zzp(list);
        return this;
    }

    final zzaa d(List list) {
        Preconditions.m(list);
        this.f72321d = zzah.zzp(list);
        return this;
    }

    final zzab e() {
        if (this.f72318a == null) {
            throw new IllegalStateException("packageName must be defined");
        }
        if (this.f72319b < 0) {
            throw new IllegalStateException("minimumStampedVersionNumber must be greater than or equal to 0");
        }
        if (this.f72320c.isEmpty() && this.f72321d.isEmpty()) {
            throw new IllegalStateException("Either orderedTestCerts or orderedProdCerts must have at least one cert");
        }
        return new zzab(this.f72318a, this.f72319b, this.f72320c, this.f72321d, null);
    }
}
