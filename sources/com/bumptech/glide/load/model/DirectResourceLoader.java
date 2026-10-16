package com.bumptech.glide.load.model;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.signature.ObjectKey;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class DirectResourceLoader<DataT> implements ModelLoader<Integer, DataT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f66686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ResourceOpener f66687b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor>, ResourceOpener<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66688a;

        AssetFileDescriptorFactory(Context context) {
            this.f66688a = context;
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class a() {
            return AssetFileDescriptor.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.f66688a, this);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor c(Resources.Theme theme, Resources resources, int i3) {
            return resources.openRawResourceFd(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class InputStreamFactory implements ModelLoaderFactory<Integer, InputStream>, ResourceOpener<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66690a;

        InputStreamFactory(Context context) {
            this.f66690a = context;
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class a() {
            return InputStream.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.f66690a, this);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InputStream c(Resources.Theme theme, Resources resources, int i3) {
            return resources.openRawResource(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface ResourceOpener<DataT> {
        Class a();

        void b(Object obj);

        Object c(Resources.Theme theme, Resources resources, int i3);
    }

    DirectResourceLoader(Context context, ResourceOpener resourceOpener) {
        this.f66686a = context.getApplicationContext();
        this.f66687b = resourceOpener;
    }

    public static ModelLoaderFactory c(Context context) {
        return new AssetFileDescriptorFactory(context);
    }

    public static ModelLoaderFactory e(Context context) {
        return new DrawableFactory(context);
    }

    public static ModelLoaderFactory g(Context context) {
        return new InputStreamFactory(context);
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ModelLoader.LoadData b(Integer num, int i3, int i4, Options options) {
        Resources.Theme theme = (Resources.Theme) options.c(ResourceDrawableDecoder.f66955b);
        return new ModelLoader.LoadData(new ObjectKey(num), new ResourceDataFetcher(theme, theme != null ? theme.getResources() : this.f66686a.getResources(), this.f66687b, num.intValue()));
    }

    @Override // com.bumptech.glide.load.model.ModelLoader
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ResourceDataFetcher<DataT> implements DataFetcher<DataT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Resources.Theme f66691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Resources f66692b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ResourceOpener f66693c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f66694d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Object f66695f;

        ResourceDataFetcher(Resources.Theme theme, Resources resources, ResourceOpener resourceOpener, int i3) {
            this.f66691a = theme;
            this.f66692b = resources;
            this.f66693c = resourceOpener;
            this.f66694d = i3;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public Class a() {
            return this.f66693c.a();
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void b() {
            Object obj = this.f66695f;
            if (obj != null) {
                try {
                    this.f66693c.b(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public DataSource d() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void e(Priority priority, DataFetcher.DataCallback dataCallback) {
            try {
                Object objC = this.f66693c.c(this.f66691a, this.f66692b, this.f66694d);
                this.f66695f = objC;
                dataCallback.f(objC);
            } catch (Resources.NotFoundException e3) {
                dataCallback.c(e3);
            }
        }

        @Override // com.bumptech.glide.load.data.DataFetcher
        public void cancel() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class DrawableFactory implements ModelLoaderFactory<Integer, Drawable>, ResourceOpener<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f66689a;

        DrawableFactory(Context context) {
            this.f66689a = context;
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        public Class a() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.model.ModelLoaderFactory
        public ModelLoader d(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DirectResourceLoader(this.f66689a, this);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Drawable c(Resources.Theme theme, Resources resources, int i3) {
            return DrawableDecoderCompat.a(this.f66689a, i3, theme);
        }

        @Override // com.bumptech.glide.load.model.DirectResourceLoader.ResourceOpener
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(Drawable drawable) {
        }
    }
}
