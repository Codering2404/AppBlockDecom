package com.google.common.math;

import com.applovin.sdk.AppLovinMediationProvider;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Stats implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f85329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double f85330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f85331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f85332d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final double f85333f;

    public long a() {
        return this.f85329a;
    }

    public double b() {
        return Math.sqrt(c());
    }

    public double c() {
        Preconditions.z(this.f85329a > 0);
        if (Double.isNaN(this.f85331c)) {
            return Double.NaN;
        }
        if (this.f85329a == 1) {
            return 0.0d;
        }
        return DoubleUtils.a(this.f85331c) / a();
    }

    public boolean equals(Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.f85329a == stats.f85329a && Double.doubleToLongBits(this.f85330b) == Double.doubleToLongBits(stats.f85330b) && Double.doubleToLongBits(this.f85331c) == Double.doubleToLongBits(stats.f85331c) && Double.doubleToLongBits(this.f85332d) == Double.doubleToLongBits(stats.f85332d) && Double.doubleToLongBits(this.f85333f) == Double.doubleToLongBits(stats.f85333f);
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.f85329a), Double.valueOf(this.f85330b), Double.valueOf(this.f85331c), Double.valueOf(this.f85332d), Double.valueOf(this.f85333f));
    }

    public String toString() {
        return a() > 0 ? MoreObjects.c(this).c("count", this.f85329a).a("mean", this.f85330b).a("populationStandardDeviation", b()).a("min", this.f85332d).a(AppLovinMediationProvider.MAX, this.f85333f).toString() : MoreObjects.c(this).c("count", this.f85329a).toString();
    }
}
