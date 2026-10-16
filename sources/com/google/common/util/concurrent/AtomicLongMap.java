package com.google.common.util.concurrent;

import com.google.common.base.Function;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class AtomicLongMap<K> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap f85714a;

    /* JADX INFO: renamed from: com.google.common.util.concurrent.AtomicLongMap$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements Function<AtomicLong, Long> {
        @Override // com.google.common.base.Function
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long apply(AtomicLong atomicLong) {
            return Long.valueOf(atomicLong.get());
        }
    }

    public String toString() {
        return this.f85714a.toString();
    }
}
