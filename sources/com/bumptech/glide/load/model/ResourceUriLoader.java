package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class ResourceUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f66760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ModelLoader f66761b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66762a;

        AssetFileDescriptorFactory(Context context) {
            this.f66762a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.f66762a, multiModelLoaderFactory.d(Integer.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InputStreamFactory implements ModelLoaderFactory<Uri, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66763a;

        InputStreamFactory(Context context) {
            this.f66763a = context;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceUriLoader(this.f66763a, multiModelLoaderFactory.d(Integer.class, InputStream.class));
        }
    }

    ResourceUriLoader(Context context, ModelLoader modelLoader) {
        this.f66760a = context.getApplicationContext();
        this.f66761b = modelLoader;
    }

    public static ModelLoaderFactory e(Context context) {
        return new AssetFileDescriptorFactory(context);
    }

    public static ModelLoaderFactory f(Context context) {
        return new InputStreamFactory(context);
    }

    private ModelLoader.LoadData g(Uri uri, int i3, int i4, Options options) {
        try {
            int i5 = Integer.parseInt(uri.getPathSegments().get(0));
            if (i5 != 0) {
                return this.f66761b.b(Integer.valueOf(i5), i3, i4, options);
            }
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse a valid non-0 resource id from: " + uri);
            }
            return null;
        } catch (NumberFormatException e3) {
            if (Log.isLoggable("ResourceUriLoader", 5)) {
                Log.w("ResourceUriLoader", "Failed to parse resource id from: " + uri, e3);
            }
            return null;
        }
    }

    private ModelLoader.LoadData h(Uri uri, int i3, int i4, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        int identifier = this.f66760a.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), this.f66760a.getPackageName());
        if (identifier != 0) {
            return this.f66761b.b(Integer.valueOf(identifier), i3, i4, options);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to find resource id for: " + uri);
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Uri uri, int i3, int i4, Options options) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 1) {
            return g(uri, i3, i4, options);
        }
        if (pathSegments.size() == 2) {
            return h(uri, i3, i4, options);
        }
        if (!Log.isLoggable("ResourceUriLoader", 5)) {
            return null;
        }
        Log.w("ResourceUriLoader", "Failed to parse resource uri: " + uri);
        return null;
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return "android.resource".equals(uri.getScheme()) && this.f66760a.getPackageName().equals(uri.getAuthority());
    }
}
