package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ModelLoader f66754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Resources f66755b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f66756a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f66756a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f66756a, multiModelLoaderFactory.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Deprecated
    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f66757a;

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f66757a, multiModelLoaderFactory.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f66758a;

        public StreamFactory(Resources resources) {
            this.f66758a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f66758a, multiModelLoaderFactory.d(Uri.class, InputStream.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources f66759a;

        public UriFactory(Resources resources) {
            this.f66759a = resources;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f66759a, UnitModelLoader.c());
        }
    }

    public ResourceLoader(Resources resources, ModelLoader modelLoader) {
        this.f66755b = resources;
        this.f66754a = modelLoader;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f66755b.getResourcePackageName(num.intValue()) + '/' + num);
        } catch (Resources.NotFoundException e3) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e3);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Integer num, int i3, int i4, Options options) {
        Uri uriD = d(num);
        if (uriD == null) {
            return null;
        }
        return this.f66754a.b(uriD, i3, i4, options);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
