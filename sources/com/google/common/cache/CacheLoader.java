package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class CacheLoader<K, V> {

    /* JADX INFO: renamed from: com.google.common.cache.CacheLoader$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends CacheLoader<Object, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CacheLoader f83487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Executor f83488b;

        @Override // com.google.common.cache.CacheLoader
        public Object a(Object obj) {
            return this.f83487a.a(obj);
        }

        @Override // com.google.common.cache.CacheLoader
        public ListenableFuture b(final Object obj, final Object obj2) {
            final CacheLoader cacheLoader = this.f83487a;
            ListenableFutureTask listenableFutureTaskA = ListenableFutureTask.a(new Callable() { // from class: com.google.common.cache.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return cacheLoader.b(obj, obj2).get();
                }
            });
            this.f83488b.execute(listenableFutureTaskA);
            return listenableFutureTaskA;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function f83489a;

        @Override // com.google.common.cache.CacheLoader
        public Object a(Object obj) {
            return this.f83489a.apply(Preconditions.t(obj));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class InvalidCacheLoadException extends RuntimeException {
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Supplier f83490a;

        @Override // com.google.common.cache.CacheLoader
        public Object a(Object obj) {
            Preconditions.t(obj);
            return this.f83490a.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        UnsupportedLoadingOperationException() {
        }
    }

    protected CacheLoader() {
    }

    public abstract Object a(Object obj);

    public ListenableFuture b(Object obj, Object obj2) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        return Futures.f(a(obj));
    }
}
