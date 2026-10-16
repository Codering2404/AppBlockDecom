package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.applovin.sdk.AppLovinEventTypes;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class UriLoader<Data> implements ModelLoader<Uri, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f66769b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", AppLovinEventTypes.USER_VIEWED_CONTENT, "android.resource")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LocalUriFetcherFactory f66770a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f66771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f66772b;

        public AssetFileDescriptorFactory(ContentResolver contentResolver, boolean z2) {
            this.f66771a = contentResolver;
            this.f66772b = z2;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher a(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f66771a, uri, this.f66772b);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f66773a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f66774b;

        public FileDescriptorFactory(ContentResolver contentResolver, boolean z2) {
            this.f66773a = contentResolver;
            this.f66774b = z2;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher a(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f66773a, uri, this.f66774b);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LocalUriFetcherFactory<Data> {
        DataFetcher a(Uri uri);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f66775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f66776b;

        public StreamFactory(ContentResolver contentResolver, boolean z2) {
            this.f66775a = contentResolver;
            this.f66776b = z2;
        }

        @Override // com.bumptech.glide.load.model.UriLoader.LocalUriFetcherFactory
        public DataFetcher a(Uri uri) {
            return new StreamLocalUriFetcher(this.f66775a, uri, this.f66776b);
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public UriLoader(LocalUriFetcherFactory localUriFetcherFactory) {
        this.f66770a = localUriFetcherFactory;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Uri uri, int i3, int i4, Options options) {
        return new ModelLoader.LoadData(new ObjectKey(uri), this.f66770a.a(uri));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return f66769b.contains(uri.getScheme());
    }
}
