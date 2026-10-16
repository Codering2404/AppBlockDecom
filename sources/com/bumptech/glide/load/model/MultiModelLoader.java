package com.bumptech.glide.load.model;

import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f66736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Pools.Pool f66737b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f66738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Pools.Pool f66739b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f66740c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Priority f66741d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private DataFetcher.DataCallback f66742f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List f66743g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f66744h;

        MultiFetcher(List list, Pools.Pool pool) {
            this.f66739b = pool;
            Preconditions.d(list);
            this.f66738a = list;
            this.f66740c = 0;
        }

        private void g() {
            if (this.f66744h) {
                return;
            }
            if (this.f66740c < this.f66738a.size() - 1) {
                this.f66740c++;
                e(this.f66741d, this.f66742f);
            } else {
                Preconditions.e(this.f66743g);
                this.f66742f.c(new GlideException("Fetch failed", new ArrayList(this.f66743g)));
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return ((DataFetcher) this.f66738a.get(0)).a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            List list = this.f66743g;
            if (list != null) {
                this.f66739b.b(list);
            }
            this.f66743g = null;
            Iterator it = this.f66738a.iterator();
            while (it.hasNext()) {
                ((DataFetcher) it.next()).b();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void c(Exception exc) {
            ((List) Preconditions.e(this.f66743g)).add(exc);
            g();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
            this.f66744h = true;
            Iterator it = this.f66738a.iterator();
            while (it.hasNext()) {
                ((DataFetcher) it.next()).cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return ((DataFetcher) this.f66738a.get(0)).d();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            this.f66741d = priority;
            this.f66742f = dataCallback;
            this.f66743g = (List) this.f66739b.a();
            ((DataFetcher) this.f66738a.get(this.f66740c)).e(priority, this);
            if (this.f66744h) {
                cancel();
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher.DataCallback
        public void f(Object obj) {
            if (obj != null) {
                this.f66742f.f(obj);
            } else {
                g();
            }
        }
    }

    MultiModelLoader(List list, Pools.Pool pool) {
        this.f66736a = list;
        this.f66737b = pool;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Object obj) {
        Iterator it = this.f66736a.iterator();
        while (it.hasNext()) {
            if (((ModelLoader) it.next()).a(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData b(Object obj, int i3, int i4, Options options) {
        ModelLoader.LoadData loadDataB;
        int size = this.f66736a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i5 = 0; i5 < size; i5++) {
            ModelLoader modelLoader = (ModelLoader) this.f66736a.get(i5);
            if (modelLoader.a(obj) && (loadDataB = modelLoader.b(obj, i3, i4, options)) != null) {
                key = loadDataB.f66729a;
                arrayList.add(loadDataB.f66731c);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData(key, new MultiFetcher(arrayList, this.f66737b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f66736a.toArray()) + '}';
    }
}
