package androidx.compose.ui.text.android.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.style.ReplacementSpan;
import androidx.compose.ui.text.internal.InlineClassHelperKt;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class PlaceholderSpan extends ReplacementSpan {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Companion f29063l = new Companion(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f29064m = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f29065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f29067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f29068d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f29069f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f29070g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Paint.FontMetricsInt f29071h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f29072i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f29073j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f29074k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        public @interface Unit {
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention
        public @interface VerticalAlign {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PlaceholderSpan(float f3, int i3, float f4, int i4, float f5, int i5) {
        this.f29065a = f3;
        this.f29066b = i3;
        this.f29067c = f4;
        this.f29068d = i4;
        this.f29069f = f5;
        this.f29070g = i5;
    }

    public final Paint.FontMetricsInt a() {
        Paint.FontMetricsInt fontMetricsInt = this.f29071h;
        if (fontMetricsInt != null) {
            return fontMetricsInt;
        }
        Intrinsics.throwUninitializedPropertyAccessException("fontMetrics");
        return null;
    }

    public final int b() {
        if (!this.f29074k) {
            InlineClassHelperKt.c("PlaceholderSpan is not laid out yet.");
        }
        return this.f29073j;
    }

    public final int c() {
        return this.f29070g;
    }

    public final int d() {
        if (!this.f29074k) {
            InlineClassHelperKt.c("PlaceholderSpan is not laid out yet.");
        }
        return this.f29072i;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        float f3;
        int iA;
        this.f29074k = true;
        float textSize = paint.getTextSize();
        this.f29071h = paint.getFontMetricsInt();
        if (!(a().descent > a().ascent)) {
            InlineClassHelperKt.a("Invalid fontMetrics: line height can not be negative.");
        }
        int i5 = this.f29066b;
        if (i5 == 0) {
            f3 = this.f29065a * this.f29069f;
        } else {
            if (i5 != 1) {
                InlineClassHelperKt.b("Unsupported unit.");
                throw new KotlinNothingValueException();
            }
            f3 = this.f29065a * textSize;
        }
        this.f29072i = PlaceholderSpan_androidKt.a(f3);
        int i6 = this.f29068d;
        if (i6 == 0) {
            iA = PlaceholderSpan_androidKt.a(this.f29067c * this.f29069f);
        } else {
            if (i6 != 1) {
                InlineClassHelperKt.b("Unsupported unit.");
                throw new KotlinNothingValueException();
            }
            iA = PlaceholderSpan_androidKt.a(this.f29067c * textSize);
        }
        this.f29073j = iA;
        if (fontMetricsInt != null) {
            fontMetricsInt.ascent = a().ascent;
            fontMetricsInt.descent = a().descent;
            fontMetricsInt.leading = a().leading;
            switch (this.f29070g) {
                case 0:
                    if (fontMetricsInt.ascent > (-b())) {
                        fontMetricsInt.ascent = -b();
                    }
                    break;
                case 1:
                case 4:
                    if (fontMetricsInt.ascent + b() > fontMetricsInt.descent) {
                        fontMetricsInt.descent = fontMetricsInt.ascent + b();
                    }
                    break;
                case 2:
                case 5:
                    if (fontMetricsInt.ascent > fontMetricsInt.descent - b()) {
                        fontMetricsInt.ascent = fontMetricsInt.descent - b();
                    }
                    break;
                case 3:
                case 6:
                    if (fontMetricsInt.descent - fontMetricsInt.ascent < b()) {
                        int iB = fontMetricsInt.ascent - ((b() - (fontMetricsInt.descent - fontMetricsInt.ascent)) / 2);
                        fontMetricsInt.ascent = iB;
                        fontMetricsInt.descent = iB + b();
                    }
                    break;
                default:
                    InlineClassHelperKt.a("Unknown verticalAlign.");
                    break;
            }
            fontMetricsInt.top = Math.min(a().top, fontMetricsInt.ascent);
            fontMetricsInt.bottom = Math.max(a().bottom, fontMetricsInt.descent);
        }
        return d();
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i3, int i4, float f3, int i5, int i6, int i7, Paint paint) {
    }
}
