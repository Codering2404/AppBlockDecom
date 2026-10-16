package com.bumptech.glide.load.model;

import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ModelCache<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LruCache f66723a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ModelKey<A> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final Queue f66725d = Util.g(0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f66726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f66727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Object f66728c;

        private ModelKey() {
        }

        static ModelKey a(Object obj, int i3, int i4) {
            ModelKey modelKey;
            Queue queue = f66725d;
            synchronized (queue) {
                modelKey = (ModelKey) queue.poll();
            }
            if (modelKey == null) {
                modelKey = new ModelKey();
            }
            modelKey.b(obj, i3, i4);
            return modelKey;
        }

        private void b(Object obj, int i3, int i4) {
            this.f66728c = obj;
            this.f66727b = i3;
            this.f66726a = i4;
        }

        public void c() {
            Queue queue = f66725d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (obj instanceof ModelKey) {
                ModelKey modelKey = (ModelKey) obj;
                if (this.f66727b == modelKey.f66727b && this.f66726a == modelKey.f66726a && this.f66728c.equals(modelKey.f66728c)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return (((this.f66726a * 31) + this.f66727b) * 31) + this.f66728c.hashCode();
        }
    }

    public ModelCache(long j3) {
        this.f66723a = new LruCache<ModelKey<A>, B>(j3) { // from class: com.bumptech.glide.load.model.ModelCache.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.bumptech.glide.util.LruCache
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public void k(ModelKey modelKey, Object obj) {
                modelKey.c();
            }
        };
    }

    public Object a(Object obj, int i3, int i4) {
        ModelKey modelKeyA = ModelKey.a(obj, i3, i4);
        Object objI = this.f66723a.i(modelKeyA);
        modelKeyA.c();
        return objI;
    }

    public void b(Object obj, int i3, int i4, Object obj2) {
        this.f66723a.l(ModelKey.a(obj, i3, i4), obj2);
    }
}
