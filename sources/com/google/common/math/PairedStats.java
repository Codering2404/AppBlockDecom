package com.google.common.math;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class PairedStats implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Stats f85326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Stats f85327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f85328c;

    public long a() {
        return this.f85326a.a();
    }

    public double b() {
        Preconditions.z(a() != 0);
        return this.f85328c / a();
    }

    public boolean equals(Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        return this.f85326a.equals(pairedStats.f85326a) && this.f85327b.equals(pairedStats.f85327b) && Double.doubleToLongBits(this.f85328c) == Double.doubleToLongBits(pairedStats.f85328c);
    }

    public int hashCode() {
        return Objects.b(this.f85326a, this.f85327b, Double.valueOf(this.f85328c));
    }

    public String toString() {
        return a() > 0 ? MoreObjects.c(this).d("xStats", this.f85326a).d("yStats", this.f85327b).a("populationCovariance", b()).toString() : MoreObjects.c(this).d("xStats", this.f85326a).d("yStats", this.f85327b).toString();
    }
}
