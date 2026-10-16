package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.resource.DefaultOnHeaderDecodedListener;
import com.bumptech.glide.util.ByteBufferUtil;
import com.bumptech.glide.util.Util;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class AnimatedImageDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f66943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayPool f66944b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AnimatedImageDrawableResource implements Resource<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedImageDrawable f66945a;

        AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable) {
            this.f66945a = animatedImageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void a() {
            this.f66945a.stop();
            this.f66945a.clearAnimationCallbacks();
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class b() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f66945a;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return this.f66945a.getIntrinsicWidth() * this.f66945a.getIntrinsicHeight() * Util.j(Bitmap.Config.ARGB_8888) * 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ByteBufferAnimatedImageDecoder implements ResourceDecoder<ByteBuffer, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedImageDecoder f66946a;

        ByteBufferAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.f66946a = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Resource b(ByteBuffer byteBuffer, int i3, int i4, Options options) {
            return this.f66946a.b(ImageDecoder.createSource(byteBuffer), i3, i4, options);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(ByteBuffer byteBuffer, Options options) {
            return this.f66946a.d(byteBuffer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StreamAnimatedImageDecoder implements ResourceDecoder<InputStream, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedImageDecoder f66947a;

        StreamAnimatedImageDecoder(AnimatedImageDecoder animatedImageDecoder) {
            this.f66947a = animatedImageDecoder;
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Resource b(InputStream inputStream, int i3, int i4, Options options) {
            return this.f66947a.b(ImageDecoder.createSource(ByteBufferUtil.b(inputStream)), i3, i4, options);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(InputStream inputStream, Options options) {
            return this.f66947a.c(inputStream);
        }
    }

    private AnimatedImageDecoder(List list, ArrayPool arrayPool) {
        this.f66943a = list;
        this.f66944b = arrayPool;
    }

    public static ResourceDecoder a(List list, ArrayPool arrayPool) {
        return new ByteBufferAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    private boolean e(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        return true;
    }

    public static ResourceDecoder f(List list, ArrayPool arrayPool) {
        return new StreamAnimatedImageDecoder(new AnimatedImageDecoder(list, arrayPool));
    }

    Resource b(ImageDecoder.Source source, int i3, int i4, Options options) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(i3, i4, options));
        if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
            return new AnimatedImageDrawableResource((AnimatedImageDrawable) drawableDecodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }

    boolean c(InputStream inputStream) {
        return e(ImageHeaderParserUtils.f(this.f66943a, inputStream, this.f66944b));
    }

    boolean d(ByteBuffer byteBuffer) {
        return e(ImageHeaderParserUtils.g(this.f66943a, byteBuffer));
    }
}
