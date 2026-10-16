package com.bumptech.glide;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.tracing.Trace;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.InputStreamRewinder;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.AssetUriLoader;
import com.bumptech.glide.load.model.ByteArrayLoader;
import com.bumptech.glide.load.model.ByteBufferEncoder;
import com.bumptech.glide.load.model.ByteBufferFileLoader;
import com.bumptech.glide.load.model.DataUrlLoader;
import com.bumptech.glide.load.model.DirectResourceLoader;
import com.bumptech.glide.load.model.FileLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.MediaStoreFileLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import com.bumptech.glide.load.model.ResourceUriLoader;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.model.StringLoader;
import com.bumptech.glide.load.model.UnitModelLoader;
import com.bumptech.glide.load.model.UriLoader;
import com.bumptech.glide.load.model.UrlUriLoader;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.model.stream.MediaStoreImageThumbLoader;
import com.bumptech.glide.load.model.stream.MediaStoreVideoThumbLoader;
import com.bumptech.glide.load.model.stream.QMediaStoreUriLoader;
import com.bumptech.glide.load.model.stream.UrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableEncoder;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ByteBufferBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.ExifInterfaceImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.InputStreamBitmapImageDecoderResourceDecoder;
import com.bumptech.glide.load.resource.bitmap.ParcelFileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ResourceBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.UnitBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.bytes.ByteBufferRewinder;
import com.bumptech.glide.load.resource.drawable.AnimatedImageDecoder;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;
import com.bumptech.glide.load.resource.drawable.UnitDrawableDecoder;
import com.bumptech.glide.load.resource.file.FileDecoder;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableEncoder;
import com.bumptech.glide.load.resource.gif.GifFrameResourceDecoder;
import com.bumptech.glide.load.resource.gif.StreamGifDecoder;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.BitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.DrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.module.AppGlideModule;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.util.GlideSuppliers;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class RegistryFactory {
    static Registry a(Glide glide, List list, AppGlideModule appGlideModule) {
        BitmapPool bitmapPoolF = glide.f();
        ArrayPool arrayPoolE = glide.e();
        Context applicationContext = glide.i().getApplicationContext();
        GlideExperiments glideExperimentsG = glide.i().g();
        Registry registry = new Registry();
        b(applicationContext, registry, bitmapPoolF, arrayPoolE, glideExperimentsG);
        c(applicationContext, glide, registry, list, appGlideModule);
        return registry;
    }

    private static void b(Context context, Registry registry, BitmapPool bitmapPool, ArrayPool arrayPool, GlideExperiments glideExperiments) {
        ResourceDecoder byteBufferBitmapDecoder;
        ResourceDecoder streamBitmapDecoder;
        Registry registry2;
        registry.p(new DefaultImageHeaderParser());
        int i3 = Build.VERSION.SDK_INT;
        registry.p(new ExifInterfaceImageHeaderParser());
        Resources resources = context.getResources();
        List listG = registry.g();
        ByteBufferGifDecoder byteBufferGifDecoder = new ByteBufferGifDecoder(context, listG, bitmapPool, arrayPool);
        ResourceDecoder resourceDecoderM = VideoDecoder.m(bitmapPool);
        Downsampler downsampler = new Downsampler(registry.g(), resources.getDisplayMetrics(), bitmapPool, arrayPool);
        if (glideExperiments.a(GlideBuilder.EnableImageDecoderForBitmaps.class)) {
            streamBitmapDecoder = new InputStreamBitmapImageDecoderResourceDecoder();
            byteBufferBitmapDecoder = new ByteBufferBitmapImageDecoderResourceDecoder();
        } else {
            byteBufferBitmapDecoder = new ByteBufferBitmapDecoder(downsampler);
            streamBitmapDecoder = new StreamBitmapDecoder(downsampler, arrayPool);
        }
        registry.e("Animation", InputStream.class, Drawable.class, AnimatedImageDecoder.f(listG, arrayPool));
        registry.e("Animation", ByteBuffer.class, Drawable.class, AnimatedImageDecoder.a(listG, arrayPool));
        ResourceDrawableDecoder resourceDrawableDecoder = new ResourceDrawableDecoder(context);
        BitmapEncoder bitmapEncoder = new BitmapEncoder(arrayPool);
        BitmapBytesTranscoder bitmapBytesTranscoder = new BitmapBytesTranscoder();
        GifDrawableBytesTranscoder gifDrawableBytesTranscoder = new GifDrawableBytesTranscoder();
        ContentResolver contentResolver = context.getContentResolver();
        registry.a(ByteBuffer.class, new ByteBufferEncoder()).a(InputStream.class, new StreamEncoder(arrayPool)).e("Bitmap", ByteBuffer.class, Bitmap.class, byteBufferBitmapDecoder).e("Bitmap", InputStream.class, Bitmap.class, streamBitmapDecoder);
        if (ParcelFileDescriptorRewinder.c()) {
            registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, new ParcelFileDescriptorBitmapDecoder(downsampler));
        }
        registry.e("Bitmap", AssetFileDescriptor.class, Bitmap.class, VideoDecoder.c(bitmapPool));
        registry.e("Bitmap", ParcelFileDescriptor.class, Bitmap.class, resourceDecoderM).d(Bitmap.class, Bitmap.class, UnitModelLoader.Factory.a()).e("Bitmap", Bitmap.class, Bitmap.class, new UnitBitmapDecoder()).b(Bitmap.class, bitmapEncoder).e("BitmapDrawable", ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, byteBufferBitmapDecoder)).e("BitmapDrawable", InputStream.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, streamBitmapDecoder)).e("BitmapDrawable", ParcelFileDescriptor.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, resourceDecoderM)).b(BitmapDrawable.class, new BitmapDrawableEncoder(bitmapPool, bitmapEncoder)).e("Animation", InputStream.class, GifDrawable.class, new StreamGifDecoder(listG, byteBufferGifDecoder, arrayPool)).e("Animation", ByteBuffer.class, GifDrawable.class, byteBufferGifDecoder).b(GifDrawable.class, new GifDrawableEncoder()).d(GifDecoder.class, GifDecoder.class, UnitModelLoader.Factory.a()).e("Bitmap", GifDecoder.class, Bitmap.class, new GifFrameResourceDecoder(bitmapPool)).c(Uri.class, Drawable.class, resourceDrawableDecoder).c(Uri.class, Bitmap.class, new ResourceBitmapDecoder(resourceDrawableDecoder, bitmapPool)).q(new ByteBufferRewinder.Factory()).d(File.class, ByteBuffer.class, new ByteBufferFileLoader.Factory()).d(File.class, InputStream.class, new FileLoader.StreamFactory()).c(File.class, File.class, new FileDecoder()).d(File.class, ParcelFileDescriptor.class, new FileLoader.FileDescriptorFactory()).d(File.class, File.class, UnitModelLoader.Factory.a()).q(new InputStreamRewinder.Factory(arrayPool));
        if (ParcelFileDescriptorRewinder.c()) {
            registry2 = registry;
            registry2.q(new ParcelFileDescriptorRewinder.Factory());
        } else {
            registry2 = registry;
        }
        ModelLoaderFactory modelLoaderFactoryG = DirectResourceLoader.g(context);
        ModelLoaderFactory modelLoaderFactoryC = DirectResourceLoader.c(context);
        ModelLoaderFactory modelLoaderFactoryE = DirectResourceLoader.e(context);
        Class cls = Integer.TYPE;
        registry2.d(cls, InputStream.class, modelLoaderFactoryG).d(Integer.class, InputStream.class, modelLoaderFactoryG).d(cls, AssetFileDescriptor.class, modelLoaderFactoryC).d(Integer.class, AssetFileDescriptor.class, modelLoaderFactoryC).d(cls, Drawable.class, modelLoaderFactoryE).d(Integer.class, Drawable.class, modelLoaderFactoryE).d(Uri.class, InputStream.class, ResourceUriLoader.f(context)).d(Uri.class, AssetFileDescriptor.class, ResourceUriLoader.e(context));
        ResourceLoader.UriFactory uriFactory = new ResourceLoader.UriFactory(resources);
        ResourceLoader.AssetFileDescriptorFactory assetFileDescriptorFactory = new ResourceLoader.AssetFileDescriptorFactory(resources);
        ResourceLoader.StreamFactory streamFactory = new ResourceLoader.StreamFactory(resources);
        registry2.d(Integer.class, Uri.class, uriFactory).d(cls, Uri.class, uriFactory).d(Integer.class, AssetFileDescriptor.class, assetFileDescriptorFactory).d(cls, AssetFileDescriptor.class, assetFileDescriptorFactory).d(Integer.class, InputStream.class, streamFactory).d(cls, InputStream.class, streamFactory);
        registry2.d(String.class, InputStream.class, new DataUrlLoader.StreamFactory()).d(Uri.class, InputStream.class, new DataUrlLoader.StreamFactory()).d(String.class, InputStream.class, new StringLoader.StreamFactory()).d(String.class, ParcelFileDescriptor.class, new StringLoader.FileDescriptorFactory()).d(String.class, AssetFileDescriptor.class, new StringLoader.AssetFileDescriptorFactory()).d(Uri.class, InputStream.class, new AssetUriLoader.StreamFactory(context.getAssets())).d(Uri.class, AssetFileDescriptor.class, new AssetUriLoader.FileDescriptorFactory(context.getAssets())).d(Uri.class, InputStream.class, new MediaStoreImageThumbLoader.Factory(context)).d(Uri.class, InputStream.class, new MediaStoreVideoThumbLoader.Factory(context));
        if (i3 >= 29) {
            registry2.d(Uri.class, InputStream.class, new QMediaStoreUriLoader.InputStreamFactory(context));
            registry2.d(Uri.class, ParcelFileDescriptor.class, new QMediaStoreUriLoader.FileDescriptorFactory(context));
        }
        boolean zA = glideExperiments.a(GlideBuilder.UseMediaStoreOpenFileApisIfPossible.class);
        registry2.d(Uri.class, InputStream.class, new UriLoader.StreamFactory(contentResolver, zA)).d(Uri.class, ParcelFileDescriptor.class, new UriLoader.FileDescriptorFactory(contentResolver, zA)).d(Uri.class, AssetFileDescriptor.class, new UriLoader.AssetFileDescriptorFactory(contentResolver, zA)).d(Uri.class, InputStream.class, new UrlUriLoader.StreamFactory()).d(URL.class, InputStream.class, new UrlLoader.StreamFactory()).d(Uri.class, File.class, new MediaStoreFileLoader.Factory(context)).d(GlideUrl.class, InputStream.class, new HttpGlideUrlLoader.Factory()).d(byte[].class, ByteBuffer.class, new ByteArrayLoader.ByteBufferFactory()).d(byte[].class, InputStream.class, new ByteArrayLoader.StreamFactory()).d(Uri.class, Uri.class, UnitModelLoader.Factory.a()).d(Drawable.class, Drawable.class, UnitModelLoader.Factory.a()).c(Drawable.class, Drawable.class, new UnitDrawableDecoder()).r(Bitmap.class, BitmapDrawable.class, new BitmapDrawableTranscoder(resources)).r(Bitmap.class, byte[].class, bitmapBytesTranscoder).r(Drawable.class, byte[].class, new DrawableBytesTranscoder(bitmapPool, bitmapBytesTranscoder, gifDrawableBytesTranscoder)).r(GifDrawable.class, byte[].class, gifDrawableBytesTranscoder);
        ResourceDecoder resourceDecoderD = VideoDecoder.d(bitmapPool);
        registry2.c(ByteBuffer.class, Bitmap.class, resourceDecoderD);
        registry2.c(ByteBuffer.class, BitmapDrawable.class, new BitmapDrawableDecoder(resources, resourceDecoderD));
    }

    private static void c(Context context, Glide glide, Registry registry, List list, AppGlideModule appGlideModule) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            GlideModule glideModule = (GlideModule) it.next();
            try {
                glideModule.b(context, glide, registry);
            } catch (AbstractMethodError e3) {
                throw new IllegalStateException("Attempting to register a Glide v3 module. If you see this, you or one of your dependencies may be including Glide v3 even though you're using Glide v4. You'll need to find and remove (or update) the offending dependency. The v3 module name is: " + glideModule.getClass().getName(), e3);
            }
        }
        if (appGlideModule != null) {
            appGlideModule.b(context, glide, registry);
        }
    }

    static GlideSuppliers.GlideSupplier d(final Glide glide, final List list, final AppGlideModule appGlideModule) {
        return new GlideSuppliers.GlideSupplier<Registry>() { // from class: com.bumptech.glide.RegistryFactory.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private boolean f66106a;

            @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Registry get() {
                if (this.f66106a) {
                    throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
                }
                Trace.a("Glide registry");
                this.f66106a = true;
                try {
                    return RegistryFactory.a(glide, list, appGlideModule);
                } finally {
                    this.f66106a = false;
                    Trace.b();
                }
            }
        };
    }
}
