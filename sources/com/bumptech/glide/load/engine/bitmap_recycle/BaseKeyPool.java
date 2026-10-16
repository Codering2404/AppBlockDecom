package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class BaseKeyPool<T extends Poolable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Queue f66540a = Util.g(20);

    BaseKeyPool() {
    }

    abstract Poolable a();

    Poolable b() {
        Poolable poolable = (Poolable) this.f66540a.poll();
        return poolable == null ? a() : poolable;
    }

    public void c(Poolable poolable) {
        if (this.f66540a.size() < 20) {
            this.f66540a.offer(poolable);
        }
    }
}
