package coil.decode;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.decode.ImageSource;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.Bitmaps;
import coil.util.Utils;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.sync.Semaphore;
import kotlinx.coroutines.sync.SemaphoreKt;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class BitmapFactoryDecoder implements Decoder {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f55684e = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageSource f55685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Semaphore f55687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExifOrientationPolicy f55688d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ExceptionCatchingSource extends ForwardingSource {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Exception f55689b;

        public ExceptionCatchingSource(Source source) {
            super(source);
        }

        public final Exception b() {
            return this.f55689b;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long t2(Buffer buffer, long j3) throws Exception {
            try {
                return super.t2(buffer, j3);
            } catch (Exception e3) {
                this.f55689b = e3;
                throw e3;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Decoder.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ExifOrientationPolicy f55690a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Semaphore f55691b;

        public Factory(int i3, ExifOrientationPolicy exifOrientationPolicy) {
            this.f55690a = exifOrientationPolicy;
            this.f55691b = SemaphoreKt.b(i3, 0, 2, null);
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder a(SourceResult sourceResult, Options options, ImageLoader imageLoader) {
            return new BitmapFactoryDecoder(sourceResult.c(), options, this.f55691b, this.f55690a);
        }

        public boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public int hashCode() {
            return Factory.class.hashCode();
        }
    }

    public BitmapFactoryDecoder(ImageSource imageSource, Options options, Semaphore semaphore, ExifOrientationPolicy exifOrientationPolicy) {
        this.f55685a = imageSource;
        this.f55686b = options;
        this.f55687c = semaphore;
        this.f55688d = exifOrientationPolicy;
    }

    private final void c(BitmapFactory.Options options, ExifData exifData) {
        Bitmap.Config configF = this.f55686b.f();
        if (exifData.b() || ExifUtilsKt.a(exifData)) {
            configF = Bitmaps.e(configF);
        }
        if (this.f55686b.d() && configF == Bitmap.Config.ARGB_8888 && Intrinsics.areEqual(options.outMimeType, "image/jpeg")) {
            configF = Bitmap.Config.RGB_565;
        }
        Bitmap.Config config = options.outConfig;
        Bitmap.Config config2 = Bitmap.Config.RGBA_F16;
        if (config == config2 && configF != Bitmap.Config.HARDWARE) {
            configF = config2;
        }
        options.inPreferredConfig = configF;
    }

    private final void d(BitmapFactory.Options options, ExifData exifData) {
        ImageSource.Metadata metadataA = this.f55685a.a();
        if ((metadataA instanceof ResourceMetadata) && Sizes.a(this.f55686b.o())) {
            options.inSampleSize = 1;
            options.inScaled = true;
            options.inDensity = ((ResourceMetadata) metadataA).a();
            options.inTargetDensity = this.f55686b.g().getResources().getDisplayMetrics().densityDpi;
            return;
        }
        if (options.outWidth <= 0 || options.outHeight <= 0) {
            options.inSampleSize = 1;
            options.inScaled = false;
            return;
        }
        int i3 = ExifUtilsKt.b(exifData) ? options.outHeight : options.outWidth;
        int i4 = ExifUtilsKt.b(exifData) ? options.outWidth : options.outHeight;
        Size sizeO = this.f55686b.o();
        int iB = Sizes.a(sizeO) ? i3 : Utils.B(sizeO.d(), this.f55686b.n());
        Size sizeO2 = this.f55686b.o();
        int iB2 = Sizes.a(sizeO2) ? i4 : Utils.B(sizeO2.c(), this.f55686b.n());
        int iA = DecodeUtils.a(i3, i4, iB, iB2, this.f55686b.n());
        options.inSampleSize = iA;
        double dB = DecodeUtils.b(((double) i3) / ((double) iA), ((double) i4) / ((double) iA), iB, iB2, this.f55686b.n());
        if (this.f55686b.c()) {
            dB = RangesKt.i(dB, 1.0d);
        }
        boolean z2 = dB == 1.0d;
        options.inScaled = !z2;
        if (z2) {
            return;
        }
        if (dB > 1.0d) {
            options.inDensity = MathKt.c(((double) Api.BaseClientBuilder.API_PRIORITY_OTHER) / dB);
            options.inTargetDensity = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        } else {
            options.inDensity = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            options.inTargetDensity = MathKt.c(((double) Api.BaseClientBuilder.API_PRIORITY_OTHER) * dB);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DecodeResult e(BitmapFactory.Options options) throws Exception {
        ExceptionCatchingSource exceptionCatchingSource = new ExceptionCatchingSource(this.f55685a.b());
        BufferedSource bufferedSourceD = Okio.d(exceptionCatchingSource);
        boolean z2 = true;
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(bufferedSourceD.peek().H2(), null, options);
        Exception excB = exceptionCatchingSource.b();
        if (excB != null) {
            throw excB;
        }
        options.inJustDecodeBounds = false;
        ExifUtils exifUtils = ExifUtils.f55718a;
        ExifData exifDataA = exifUtils.a(options.outMimeType, bufferedSourceD, this.f55688d);
        Exception excB2 = exceptionCatchingSource.b();
        if (excB2 != null) {
            throw excB2;
        }
        options.inMutable = false;
        if (this.f55686b.e() != null) {
            options.inPreferredColorSpace = this.f55686b.e();
        }
        options.inPremultiplied = this.f55686b.m();
        c(options, exifDataA);
        d(options, exifDataA);
        try {
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(bufferedSourceD.H2(), null, options);
            CloseableKt.a(bufferedSourceD, null);
            Exception excB3 = exceptionCatchingSource.b();
            if (excB3 != null) {
                throw excB3;
            }
            if (bitmapDecodeStream == null) {
                throw new IllegalStateException("BitmapFactory returned a null bitmap. Often this means BitmapFactory could not decode the image data read from the input source (e.g. network, disk, or memory) as it's not encoded as a valid image format.");
            }
            bitmapDecodeStream.setDensity(this.f55686b.g().getResources().getDisplayMetrics().densityDpi);
            BitmapDrawable bitmapDrawable = new BitmapDrawable(this.f55686b.g().getResources(), exifUtils.b(bitmapDecodeStream, exifDataA));
            if (options.inSampleSize <= 1 && !options.inScaled) {
                z2 = false;
            }
            return new DecodeResult(bitmapDrawable, z2);
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // coil.decode.Decoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object a(kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r8 instanceof coil.decode.BitmapFactoryDecoder$decode$1
            if (r0 == 0) goto L13
            r0 = r8
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = (coil.decode.BitmapFactoryDecoder$decode$1) r0
            int r1 = r0.f55696f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f55696f = r1
            goto L18
        L13:
            coil.decode.BitmapFactoryDecoder$decode$1 r0 = new coil.decode.BitmapFactoryDecoder$decode$1
            r0.<init>(r7, r8)
        L18:
            java.lang.Object r8 = r0.f55694c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f55696f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L47
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r0 = r0.f55692a
            kotlinx.coroutines.sync.Semaphore r0 = (kotlinx.coroutines.sync.Semaphore) r0
            kotlin.ResultKt.b(r8)     // Catch: java.lang.Throwable -> L30
            goto L70
        L30:
            r8 = move-exception
            goto L7a
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L3a:
            java.lang.Object r2 = r0.f55693b
            kotlinx.coroutines.sync.Semaphore r2 = (kotlinx.coroutines.sync.Semaphore) r2
            java.lang.Object r5 = r0.f55692a
            coil.decode.BitmapFactoryDecoder r5 = (coil.decode.BitmapFactoryDecoder) r5
            kotlin.ResultKt.b(r8)
            r8 = r2
            goto L5a
        L47:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.sync.Semaphore r8 = r7.f55687c
            r0.f55692a = r7
            r0.f55693b = r8
            r0.f55696f = r4
            java.lang.Object r2 = r8.d(r0)
            if (r2 != r1) goto L59
            goto L6c
        L59:
            r5 = r7
        L5a:
            coil.decode.BitmapFactoryDecoder$decode$2$1 r2 = new coil.decode.BitmapFactoryDecoder$decode$2$1     // Catch: java.lang.Throwable -> L76
            r2.<init>()     // Catch: java.lang.Throwable -> L76
            r0.f55692a = r8     // Catch: java.lang.Throwable -> L76
            r5 = 0
            r0.f55693b = r5     // Catch: java.lang.Throwable -> L76
            r0.f55696f = r3     // Catch: java.lang.Throwable -> L76
            java.lang.Object r0 = kotlinx.coroutines.InterruptibleKt.c(r5, r2, r0, r4, r5)     // Catch: java.lang.Throwable -> L76
            if (r0 != r1) goto L6d
        L6c:
            return r1
        L6d:
            r6 = r0
            r0 = r8
            r8 = r6
        L70:
            coil.decode.DecodeResult r8 = (coil.decode.DecodeResult) r8     // Catch: java.lang.Throwable -> L30
            r0.release()
            return r8
        L76:
            r0 = move-exception
            r6 = r0
            r0 = r8
            r8 = r6
        L7a:
            r0.release()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.decode.BitmapFactoryDecoder.a(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
