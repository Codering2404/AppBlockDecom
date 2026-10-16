package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AggregateFuture<InputT, OutputT> extends AggregateFutureState<OutputT> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final LazyLogger f85701n = new LazyLogger(AggregateFuture.class);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ImmutableCollection f85702m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum ReleaseResourcesReason {
        OUTPUT_FUTURE_DONE,
        ALL_INPUT_FUTURES_PROCESSED
    }

    void F(ReleaseResourcesReason releaseResourcesReason) {
        Preconditions.t(releaseResourcesReason);
        this.f85702m = null;
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final void m() {
        super.m();
        ImmutableCollection immutableCollection = this.f85702m;
        F(ReleaseResourcesReason.OUTPUT_FUTURE_DONE);
        if (isCancelled() && (immutableCollection != null)) {
            boolean zE = E();
            UnmodifiableIterator it = immutableCollection.iterator();
            while (it.hasNext()) {
                ((Future) it.next()).cancel(zE);
            }
        }
    }

    @Override // com.google.common.util.concurrent.AbstractFuture
    protected final String y() {
        ImmutableCollection immutableCollection = this.f85702m;
        if (immutableCollection == null) {
            return super.y();
        }
        return "futures=" + immutableCollection;
    }
}
