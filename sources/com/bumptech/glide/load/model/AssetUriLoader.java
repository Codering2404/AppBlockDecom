package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f66669c = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f66670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetFetcherFactory f66671b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AssetFetcherFactory<Data> {
        DataFetcher a(AssetManager assetManager, String str);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, AssetFetcherFactory<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f66672a;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.f66672a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher a(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f66672a, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f66673a;

        public StreamFactory(AssetManager assetManager) {
            this.f66673a = assetManager;
        }

        @Override // com.bumptech.glide.load.model.AssetUriLoader.AssetFetcherFactory
        public DataFetcher a(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f66673a, this);
        }
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory assetFetcherFactory) {
        this.f66670a = assetManager;
        this.f66671b = assetFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Uri uri, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), this.f66671b.a(this.f66670a, uri.toString().substring(f66669c)));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
