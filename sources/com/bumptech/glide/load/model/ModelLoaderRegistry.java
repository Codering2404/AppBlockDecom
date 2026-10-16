package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ModelLoaderRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MultiModelLoaderFactory f66732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ModelLoaderCache f66733b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ModelLoaderCache {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f66734a = new HashMap();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static class Entry<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final List f66735a;

            public Entry(List list) {
                this.f66735a = list;
            }
        }

        ModelLoaderCache() {
        }

        public void a() {
            this.f66734a.clear();
        }

        public List b(Class cls) {
            Entry entry = (Entry) this.f66734a.get(cls);
            if (entry == null) {
                return null;
            }
            return entry.f66735a;
        }

        public void c(Class cls, List list) {
            if (((Entry) this.f66734a.put(cls, new Entry(list))) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public ModelLoaderRegistry(Pools.Pool pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    private static Class b(Object obj) {
        return obj.getClass();
    }

    private synchronized List e(Class cls) {
        List listB;
        listB = this.f66733b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.f66732a.e(cls));
            this.f66733b.c(cls, listB);
        }
        return listB;
    }

    public synchronized void a(Class cls, Class cls2, ModelLoaderFactory modelLoaderFactory) {
        this.f66732a.b(cls, cls2, modelLoaderFactory);
        this.f66733b.a();
    }

    public synchronized List c(Class cls) {
        return this.f66732a.g(cls);
    }

    public List d(Object obj) {
        List listE = e(b(obj));
        if (listE.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(obj);
        }
        int size = listE.size();
        List arrayList = Collections.EMPTY_LIST;
        boolean z2 = true;
        for (int i3 = 0; i3 < size; i3++) {
            ModelLoader modelLoader = (ModelLoader) listE.get(i3);
            if (modelLoader.a(obj)) {
                if (z2) {
                    arrayList = new ArrayList(size - i3);
                    z2 = false;
                }
                arrayList.add(modelLoader);
            }
        }
        if (arrayList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(obj, listE);
        }
        return arrayList;
    }

    private ModelLoaderRegistry(MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f66733b = new ModelLoaderCache();
        this.f66732a = multiModelLoaderFactory;
    }
}
