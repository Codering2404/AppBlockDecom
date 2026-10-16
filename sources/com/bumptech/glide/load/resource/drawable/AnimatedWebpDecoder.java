package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
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
@Deprecated
public final class AnimatedWebpDecoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f66948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ArrayPool f66949b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AnimatedImageDrawableResource implements Resource<Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedImageDrawable f66950a;

        AnimatedImageDrawableResource(AnimatedImageDrawable animatedImageDrawable) {
            this.f66950a = animatedImageDrawable;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public void a() {
            this.f66950a.stop();
            this.f66950a.clearAnimationCallbacks();
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public Class b() {
            return Drawable.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f66950a;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        public int getSize() {
            return this.f66950a.getIntrinsicWidth() * this.f66950a.getIntrinsicHeight() * Util.j(Bitmap.Config.ARGB_8888) * 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class ByteBufferAnimatedWebpDecoder implements ResourceDecoder<ByteBuffer, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedWebpDecoder f66951a;

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Resource b(ByteBuffer byteBuffer, int i3, int i4, Options options) {
            return this.f66951a.a(ImageDecoder.createSource(byteBuffer), i3, i4, options);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(ByteBuffer byteBuffer, Options options) {
            return this.f66951a.c(byteBuffer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StreamAnimatedWebpDecoder implements ResourceDecoder<InputStream, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AnimatedWebpDecoder f66952a;

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Resource b(InputStream inputStream, int i3, int i4, Options options) {
            return this.f66952a.a(ImageDecoder.createSource(ByteBufferUtil.b(inputStream)), i3, i4, options);
        }

        @Override // com.bumptech.glide.load.ResourceDecoder
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean a(InputStream inputStream, Options options) {
            return this.f66952a.b(inputStream);
        }
    }

    private boolean d(ImageHeaderParser.ImageType imageType) {
        return imageType == ImageHeaderParser.ImageType.ANIMATED_WEBP;
    }

    Resource a(ImageDecoder.Source source, int i3, int i4, Options options) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new DefaultOnHeaderDecodedListener(i3, i4, options));
        if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
            return new AnimatedImageDrawableResource((AnimatedImageDrawable) drawableDecodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated webp, failing: " + drawableDecodeDrawable);
    }

    boolean b(InputStream inputStream) {
        return d(ImageHeaderParserUtils.f(this.f66948a, inputStream, this.f66949b));
    }

    boolean c(ByteBuffer byteBuffer) {
        return d(ImageHeaderParserUtils.g(this.f66948a, byteBuffer));
    }
}
