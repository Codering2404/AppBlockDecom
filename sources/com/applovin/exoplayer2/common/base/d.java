package com.applovin.exoplayer2.common.base;

import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class d extends Optional {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f57971a;

    d(Object obj) {
        this.f57971a = obj;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Set asSet() {
        return Collections.singleton(this.f57971a);
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            return this.f57971a.equals(((d) obj).f57971a);
        }
        return false;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object get() {
        return this.f57971a;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public int hashCode() {
        return this.f57971a.hashCode() + 1502476572;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object or(Object obj) {
        Preconditions.checkNotNull(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.f57971a;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object orNull() {
        return this.f57971a;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public String toString() {
        return "Optional.of(" + this.f57971a + ")";
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Optional transform(Function function) {
        return new d(Preconditions.checkNotNull(function.apply(this.f57971a), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Optional or(Optional optional) {
        Preconditions.checkNotNull(optional);
        return this;
    }

    @Override // com.applovin.exoplayer2.common.base.Optional
    public Object or(Supplier supplier) {
        Preconditions.checkNotNull(supplier);
        return this.f57971a;
    }
}
