package com.bumptech.glide.load.model.stream;

import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Option f66781b = Option.f("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ModelCache f66782a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ModelCache f66783a = new ModelCache(500);

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f66783a);
        }
    }

    public HttpGlideUrlLoader(ModelCache modelCache) {
        this.f66782a = modelCache;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(GlideUrl glideUrl, int i3, int i4, Options options) {
        ModelCache modelCache = this.f66782a;
        if (modelCache != null) {
            GlideUrl glideUrl2 = (GlideUrl) modelCache.a(glideUrl, 0, 0);
            if (glideUrl2 == null) {
                this.f66782a.b(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = glideUrl2;
            }
        }
        return new ModelLoader.LoadData(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.c(f66781b)).intValue()));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(GlideUrl glideUrl) {
        return true;
    }
}
