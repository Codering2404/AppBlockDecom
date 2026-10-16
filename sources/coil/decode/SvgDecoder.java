package coil.decode;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import coil.ImageLoader;
import coil.decode.Decoder;
import coil.fetch.SourceResult;
import coil.request.Options;
import coil.request.Svgs;
import coil.size.Scale;
import coil.size.Size;
import coil.size.Sizes;
import coil.util.SvgUtils;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlinx.coroutines.InterruptibleKt;
import okio.BufferedSource;

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
public final class SvgDecoder implements Decoder {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f55743d = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ImageSource f55744a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Options f55745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f55746c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SvgDecoder(ImageSource imageSource, Options options, boolean z2) {
        this.f55744a = imageSource;
        this.f55745b = options;
        this.f55746c = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Pair e(float f3, float f4, Scale scale) {
        if (!Sizes.a(this.f55745b.o())) {
            Size sizeO = this.f55745b.o();
            return TuplesKt.a(Float.valueOf(SvgUtils.c(sizeO.a(), scale)), Float.valueOf(SvgUtils.c(sizeO.b(), scale)));
        }
        if (f3 <= 0.0f) {
            f3 = 512.0f;
        }
        if (f4 <= 0.0f) {
            f4 = 512.0f;
        }
        return TuplesKt.a(Float.valueOf(f3), Float.valueOf(f4));
    }

    @Override // coil.decode.Decoder
    public Object a(Continuation continuation) {
        return InterruptibleKt.c(null, new Function0<DecodeResult>() { // from class: coil.decode.SvgDecoder$decode$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final DecodeResult invoke() {
                float fH;
                float f3;
                int iD;
                int iD2;
                BufferedSource bufferedSourceB = this.f55748a.f55744a.b();
                try {
                    SVG svgL = SVG.l(bufferedSourceB.H2());
                    CloseableKt.a(bufferedSourceB, null);
                    RectF rectFG = svgL.g();
                    if (!this.f55748a.f() || rectFG == null) {
                        fH = svgL.h();
                        f3 = svgL.f();
                    } else {
                        fH = rectFG.width();
                        f3 = rectFG.height();
                    }
                    SvgDecoder svgDecoder = this.f55748a;
                    Pair pairE = svgDecoder.e(fH, f3, svgDecoder.f55745b.n());
                    float fFloatValue = ((Number) pairE.a()).floatValue();
                    float fFloatValue2 = ((Number) pairE.b()).floatValue();
                    if (fH <= 0.0f || f3 <= 0.0f) {
                        iD = MathKt.d(fFloatValue);
                        iD2 = MathKt.d(fFloatValue2);
                    } else {
                        float fD = DecodeUtils.d(fH, f3, fFloatValue, fFloatValue2, this.f55748a.f55745b.n());
                        iD = (int) (fD * fH);
                        iD2 = (int) (fD * f3);
                    }
                    if (rectFG == null && fH > 0.0f && f3 > 0.0f) {
                        svgL.z(0.0f, 0.0f, fH, f3);
                    }
                    svgL.B("100%");
                    svgL.y("100%");
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iD, iD2, SvgUtils.d(this.f55748a.f55745b.f()));
                    Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(width, height, config)");
                    String strA = Svgs.a(this.f55748a.f55745b.l());
                    svgL.r(new Canvas(bitmapCreateBitmap), strA != null ? new RenderOptions().a(strA) : null);
                    return new DecodeResult(new BitmapDrawable(this.f55748a.f55745b.g().getResources(), bitmapCreateBitmap), true);
                } finally {
                }
            }
        }, continuation, 1, null);
    }

    public final boolean f() {
        return this.f55746c;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Decoder.Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f55747a;

        public Factory(boolean z2) {
            this.f55747a = z2;
        }

        private final boolean b(SourceResult sourceResult) {
            return Intrinsics.areEqual(sourceResult.b(), "image/svg+xml") || SvgDecodeUtils.a(DecodeUtils.f55706a, sourceResult.c().b());
        }

        @Override // coil.decode.Decoder.Factory
        public Decoder a(SourceResult sourceResult, Options options, ImageLoader imageLoader) {
            if (b(sourceResult)) {
                return new SvgDecoder(sourceResult.c(), options, this.f55747a);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Factory) && this.f55747a == ((Factory) obj).f55747a;
        }

        public int hashCode() {
            return Boolean.hashCode(this.f55747a);
        }

        public /* synthetic */ Factory(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z2);
        }
    }
}
