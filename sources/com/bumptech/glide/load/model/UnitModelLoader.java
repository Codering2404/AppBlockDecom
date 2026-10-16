package com.bumptech.glide.load.model;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final UnitModelLoader f66766a = new UnitModelLoader();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final Factory f66767a = new Factory();

        public static Factory a() {
            return f66767a;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.c();
        }
    }

    public static UnitModelLoader c() {
        return f66766a;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public boolean a(Object obj) {
        return true;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    public ModelLoader.LoadData b(Object obj, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(obj), new UnitFetcher(obj));
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class UnitFetcher<Model> implements DataFetcher<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f66768a;

        UnitFetcher(Object obj) {
            this.f66768a = obj;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return this.f66768a.getClass();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            dataCallback.f(this.f66768a);
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }
    }
}
