package com.bumptech.glide.util.pool;

import android.util.Log;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class FactoryPools {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Resetter f67301a = new Resetter<Object>() { // from class: com.bumptech.glide.util.pool.FactoryPools.1
        @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
        public void a(Object obj) {
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Factory<T> {
        Object create();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class FactoryPool<T> implements Pools.Pool<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Factory f67302a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Resetter f67303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Pools.Pool f67304c;

        FactoryPool(Pools.Pool pool, Factory factory, Resetter resetter) {
            this.f67304c = pool;
            this.f67302a = factory;
            this.f67303b = resetter;
        }

        @Override // androidx.core.util.Pools.Pool
        public Object a() {
            Object objA = this.f67304c.a();
            if (objA == null) {
                objA = this.f67302a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + objA.getClass());
                }
            }
            if (objA instanceof Poolable) {
                ((Poolable) objA).d().b(false);
            }
            return objA;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean b(Object obj) {
            if (obj instanceof Poolable) {
                ((Poolable) obj).d().b(true);
            }
            this.f67303b.a(obj);
            return this.f67304c.b(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Poolable {
        StateVerifier d();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface Resetter<T> {
        void a(Object obj);
    }

    private static Pools.Pool a(Pools.Pool pool, Factory factory) {
        return b(pool, factory, c());
    }

    private static Pools.Pool b(Pools.Pool pool, Factory factory, Resetter resetter) {
        return new FactoryPool(pool, factory, resetter);
    }

    private static Resetter c() {
        return f67301a;
    }

    public static Pools.Pool d(int i3, Factory factory) {
        return a(new Pools.SynchronizedPool(i3), factory);
    }

    public static Pools.Pool e() {
        return f(20);
    }

    public static Pools.Pool f(int i3) {
        return b(new Pools.SynchronizedPool(i3), new Factory<List<Object>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.2
            @Override // com.bumptech.glide.util.pool.FactoryPools.Factory
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public List create() {
                return new ArrayList();
            }
        }, new Resetter<List<Object>>() { // from class: com.bumptech.glide.util.pool.FactoryPools.3
            @Override // com.bumptech.glide.util.pool.FactoryPools.Resetter
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(List list) {
                list.clear();
            }
        });
    }
}
