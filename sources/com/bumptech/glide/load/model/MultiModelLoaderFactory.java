package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MultiModelLoaderFactory {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Factory f66745e = new Factory();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ModelLoader f66746f = new EmptyModelLoader();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f66747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Factory f66748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f66749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Pools.Pool f66750d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        EmptyModelLoader() {
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public boolean a(Object obj) {
            return false;
        }

        @Override // com.bumptech.glide.load.model.ModelLoader
        public ModelLoader.LoadData b(Object obj, int i3, int i4, Options options) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Entry<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Class f66751a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Class f66752b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ModelLoaderFactory f66753c;

        public Entry(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
            this.f66751a = cls;
            this.f66752b = cls2;
            this.f66753c = modelLoaderFactory;
        }

        public boolean a(Class cls) {
            return this.f66751a.isAssignableFrom(cls);
        }

        public boolean b(Class cls, Class cls2) {
            return a(cls) && this.f66752b.isAssignableFrom(cls2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Factory {
        Factory() {
        }

        public MultiModelLoader a(List list, Pools.Pool pool) {
            return new MultiModelLoader(list, pool);
        }
    }

    public MultiModelLoaderFactory(Pools.Pool pool) {
        this(pool, f66745e);
    }

    private void a(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory, boolean z2) {
        Entry entry = new Entry(cls, cls2, modelLoaderFactory);
        List list = this.f66747a;
        list.add(z2 ? list.size() : 0, entry);
    }

    private ModelLoader c(Entry entry) {
        return (ModelLoader) Preconditions.e(entry.f66753c.d(this));
    }

    private static ModelLoader f() {
        return f66746f;
    }

    synchronized void b(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        a(cls, cls2, modelLoaderFactory, true);
    }

    public synchronized ModelLoader d(Class cls, Class cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z2 = false;
            for (Entry entry : this.f66747a) {
                if (this.f66749c.contains(entry)) {
                    z2 = true;
                } else if (entry.b(cls, cls2)) {
                    this.f66749c.add(entry);
                    arrayList.add(c(entry));
                    this.f66749c.remove(entry);
                }
            }
            if (arrayList.size() > 1) {
                return this.f66748b.a(arrayList, this.f66750d);
            }
            if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            }
            if (!z2) {
                throw new Registry.NoModelLoaderAvailableException(cls, cls2);
            }
            return f();
        } catch (Throwable th) {
            this.f66749c.clear();
            throw th;
        }
    }

    synchronized List e(Class cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry entry : this.f66747a) {
                if (!this.f66749c.contains(entry) && entry.a(cls)) {
                    this.f66749c.add(entry);
                    arrayList.add(c(entry));
                    this.f66749c.remove(entry);
                }
            }
        } finally {
        }
        return arrayList;
    }

    synchronized List g(Class cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Entry entry : this.f66747a) {
            if (!arrayList.contains(entry.f66752b) && entry.a(cls)) {
                arrayList.add(entry.f66752b);
            }
        }
        return arrayList;
    }

    MultiModelLoaderFactory(Pools.Pool pool, Factory factory) {
        this.f66747a = new ArrayList();
        this.f66749c = new HashSet();
        this.f66750d = pool;
        this.f66748b = factory;
    }
}
