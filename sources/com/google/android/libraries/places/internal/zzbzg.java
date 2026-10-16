package com.google.android.libraries.places.internal;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbzg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f77278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f77279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f77280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final double f77281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Long f77282e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Set f77283f;

    zzbzg(int i3, long j3, long j4, double d3, Long l3, Set set) {
        this.f77278a = i3;
        this.f77279b = j3;
        this.f77280c = j4;
        this.f77281d = d3;
        this.f77282e = l3;
        this.f77283f = ImmutableSet.u(set);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbzg)) {
            return false;
        }
        zzbzg zzbzgVar = (zzbzg) obj;
        return this.f77278a == zzbzgVar.f77278a && this.f77279b == zzbzgVar.f77279b && this.f77280c == zzbzgVar.f77280c && Double.compare(this.f77281d, zzbzgVar.f77281d) == 0 && Objects.a(this.f77282e, zzbzgVar.f77282e) && Objects.a(this.f77283f, zzbzgVar.f77283f);
    }

    public final int hashCode() {
        return Objects.b(Integer.valueOf(this.f77278a), Long.valueOf(this.f77279b), Long.valueOf(this.f77280c), Double.valueOf(this.f77281d), this.f77282e, this.f77283f);
    }

    public final String toString() {
        return MoreObjects.c(this).b("maxAttempts", this.f77278a).c("initialBackoffNanos", this.f77279b).c("maxBackoffNanos", this.f77280c).a("backoffMultiplier", this.f77281d).d("perAttemptRecvTimeoutNanos", this.f77282e).d("retryableStatusCodes", this.f77283f).toString();
    }
}
