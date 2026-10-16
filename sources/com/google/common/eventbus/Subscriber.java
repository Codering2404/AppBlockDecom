package com.google.common.eventbus;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class Subscriber {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final Object f84901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f84902b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class SynchronizedSubscriber extends Subscriber {
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Subscriber) {
            Subscriber subscriber = (Subscriber) obj;
            if (this.f84901a == subscriber.f84901a && this.f84902b.equals(subscriber.f84902b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f84902b.hashCode() + 31) * 31) + System.identityHashCode(this.f84901a);
    }
}
