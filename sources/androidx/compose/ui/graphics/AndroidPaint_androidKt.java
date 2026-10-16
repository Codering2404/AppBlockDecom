package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AndroidPaint_androidKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f25646b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f25647c;

        static {
            int[] iArr = new int[Paint.Style.values().length];
            try {
                iArr[Paint.Style.STROKE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f25645a = iArr;
            int[] iArr2 = new int[Paint.Cap.values().length];
            try {
                iArr2[Paint.Cap.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr2[Paint.Cap.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[Paint.Cap.SQUARE.ordinal()] = 3;
            } catch (NoSuchFieldError unused4) {
            }
            f25646b = iArr2;
            int[] iArr3 = new int[Paint.Join.values().length];
            try {
                iArr3[Paint.Join.MITER.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr3[Paint.Join.BEVEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr3[Paint.Join.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f25647c = iArr3;
        }
    }

    public static final Paint a() {
        return new AndroidPaint();
    }

    public static final Paint b(android.graphics.Paint paint) {
        return new AndroidPaint(paint);
    }

    public static final float c(android.graphics.Paint paint) {
        return paint.getAlpha() / 255.0f;
    }

    public static final long d(android.graphics.Paint paint) {
        return ColorKt.b(paint.getColor());
    }

    public static final int e(android.graphics.Paint paint) {
        return !paint.isFilterBitmap() ? FilterQuality.f25743b.b() : FilterQuality.f25743b.a();
    }

    public static final int f(android.graphics.Paint paint) {
        Paint.Cap strokeCap = paint.getStrokeCap();
        int i3 = strokeCap == null ? -1 : WhenMappings.f25646b[strokeCap.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? StrokeCap.f25935b.a() : StrokeCap.f25935b.c() : StrokeCap.f25935b.b() : StrokeCap.f25935b.a();
    }

    public static final int g(android.graphics.Paint paint) {
        Paint.Join strokeJoin = paint.getStrokeJoin();
        int i3 = strokeJoin == null ? -1 : WhenMappings.f25647c[strokeJoin.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? StrokeJoin.f25940b.b() : StrokeJoin.f25940b.c() : StrokeJoin.f25940b.a() : StrokeJoin.f25940b.b();
    }

    public static final float h(android.graphics.Paint paint) {
        return paint.getStrokeMiter();
    }

    public static final float i(android.graphics.Paint paint) {
        return paint.getStrokeWidth();
    }

    public static final android.graphics.Paint j() {
        return new android.graphics.Paint(7);
    }

    public static final void k(android.graphics.Paint paint, float f3) {
        paint.setAlpha((int) Math.rint(f3 * 255.0f));
    }

    public static final void l(android.graphics.Paint paint, boolean z2) {
        paint.setAntiAlias(z2);
    }

    public static final void m(android.graphics.Paint paint, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            WrapperVerificationHelperMethods.f25963a.a(paint, i3);
        } else {
            paint.setXfermode(new PorterDuffXfermode(AndroidBlendMode_androidKt.b(i3)));
        }
    }

    public static final void n(android.graphics.Paint paint, long j3) {
        paint.setColor(ColorKt.k(j3));
    }

    public static final void o(android.graphics.Paint paint, ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.d(colorFilter) : null);
    }

    public static final void p(android.graphics.Paint paint, int i3) {
        paint.setFilterBitmap(!FilterQuality.e(i3, FilterQuality.f25743b.b()));
    }

    public static final void q(android.graphics.Paint paint, PathEffect pathEffect) {
        AndroidPathEffect androidPathEffect = (AndroidPathEffect) pathEffect;
        paint.setPathEffect(androidPathEffect != null ? androidPathEffect.a() : null);
    }

    public static final void r(android.graphics.Paint paint, Shader shader) {
        paint.setShader(shader);
    }

    public static final void s(android.graphics.Paint paint, int i3) {
        StrokeCap.Companion companion = StrokeCap.f25935b;
        paint.setStrokeCap(StrokeCap.g(i3, companion.c()) ? Paint.Cap.SQUARE : StrokeCap.g(i3, companion.b()) ? Paint.Cap.ROUND : StrokeCap.g(i3, companion.a()) ? Paint.Cap.BUTT : Paint.Cap.BUTT);
    }

    public static final void t(android.graphics.Paint paint, int i3) {
        StrokeJoin.Companion companion = StrokeJoin.f25940b;
        paint.setStrokeJoin(StrokeJoin.g(i3, companion.b()) ? Paint.Join.MITER : StrokeJoin.g(i3, companion.a()) ? Paint.Join.BEVEL : StrokeJoin.g(i3, companion.c()) ? Paint.Join.ROUND : Paint.Join.MITER);
    }

    public static final void u(android.graphics.Paint paint, float f3) {
        paint.setStrokeMiter(f3);
    }

    public static final void v(android.graphics.Paint paint, float f3) {
        paint.setStrokeWidth(f3);
    }

    public static final void w(android.graphics.Paint paint, int i3) {
        paint.setStyle(PaintingStyle.e(i3, PaintingStyle.f25822b.b()) ? Paint.Style.STROKE : Paint.Style.FILL);
    }
}
