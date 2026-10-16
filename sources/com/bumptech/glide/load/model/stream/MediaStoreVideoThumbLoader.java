package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class MediaStoreVideoThumbLoader implements ModelLoader<Uri, InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f66786a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66787a;

        public Factory(Context context) {
            this.f66787a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreVideoThumbLoader(this.f66787a);
        }
    }

    public MediaStoreVideoThumbLoader(Context context) {
        this.f66786a = context.getApplicationContext();
    }

    private boolean e(Options options) {
        Long l3 = (Long) options.c(VideoDecoder.f66930d);
        return l3 != null && l3.longValue() == -1;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Uri uri, int i3, int i4, Options options) {
        if (MediaStoreUtil.f(i3, i4) && e(options)) {
            return new ModelLoader.LoadData(new ObjectKey(uri), ThumbFetcher.g(this.f66786a, uri));
        }
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return MediaStoreUtil.e(uri);
    }
}
