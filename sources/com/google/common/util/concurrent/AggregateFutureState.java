package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicHelper f85706k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final LazyLogger f85707l = new LazyLogger(AggregateFutureState.class);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile Set f85708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile int f85709j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static abstract class AtomicHelper {
        private AtomicHelper() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SafeAtomicHelper extends AtomicHelper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AtomicReferenceFieldUpdater f85710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicIntegerFieldUpdater f85711b;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.f85710a = atomicReferenceFieldUpdater;
            this.f85711b = atomicIntegerFieldUpdater;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        AtomicHelper synchronizedAtomicHelper;
        Throwable th = null;
        Object[] objArr = 0;
        try {
            synchronizedAtomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AggregateFutureState.class, Set.class, "i"), AtomicIntegerFieldUpdater.newUpdater(AggregateFutureState.class, "j"));
        } catch (Throwable th2) {
            synchronizedAtomicHelper = new SynchronizedAtomicHelper();
            th = th2;
        }
        f85706k = synchronizedAtomicHelper;
        if (th != null) {
            f85707l.a().log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }
}
