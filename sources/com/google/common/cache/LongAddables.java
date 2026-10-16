package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class LongAddables {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Supplier f83638a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public void a() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long j3) {
            getAndAdd(j3);
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.1
                @Override // com.google.common.base.Supplier
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable unused) {
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.2
                @Override // com.google.common.base.Supplier
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        f83638a = supplier;
    }

    public static LongAddable a() {
        return (LongAddable) f83638a.get();
    }
}
