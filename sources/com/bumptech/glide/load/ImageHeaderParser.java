package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public interface ImageHeaderParser {

    /* JADX INFO: renamed from: com.bumptech.glide.load.ImageHeaderParser$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f66235a;

        static {
            int[] iArr = new int[ImageType.values().length];
            f66235a = iArr;
            try {
                iArr[ImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66235a[ImageType.WEBP_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f66235a[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        ANIMATED_AVIF(true),
        UNKNOWN(false);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f66236a;

        ImageType(boolean z2) {
            this.f66236a = z2;
        }

        public boolean hasAlpha() {
            return this.f66236a;
        }

        public boolean isWebp() {
            int i3 = AnonymousClass1.f66235a[ordinal()];
            return i3 == 1 || i3 == 2 || i3 == 3;
        }
    }

    ImageType a(ByteBuffer byteBuffer);

    boolean b(ByteBuffer byteBuffer, ArrayPool arrayPool);

    int c(ByteBuffer byteBuffer, ArrayPool arrayPool);

    ImageType d(InputStream inputStream);

    int e(InputStream inputStream, ArrayPool arrayPool);

    boolean f(InputStream inputStream, ArrayPool arrayPool);
}
