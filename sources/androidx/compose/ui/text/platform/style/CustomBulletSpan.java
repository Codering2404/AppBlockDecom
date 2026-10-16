package androidx.compose.ui.text.platform.style;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class CustomBulletSpan implements LeadingMarginSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Shape f29532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f29533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f29534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Brush f29535d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f29536f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DrawStyle f29537g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Density f29538h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f29539i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f29540j;

    public CustomBulletSpan(Shape shape, float f3, float f4, float f5, Brush brush, float f6, DrawStyle drawStyle, Density density, float f7) {
        this.f29532a = shape;
        this.f29533b = f3;
        this.f29534c = f4;
        this.f29535d = brush;
        this.f29536f = f6;
        this.f29537g = drawStyle;
        this.f29538h = density;
        int iD = MathKt.d(f3 + f5);
        this.f29539i = iD;
        this.f29540j = MathKt.d(f7) - iD;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(final Canvas canvas, final Paint paint, int i3, final int i4, int i5, int i6, int i7, CharSequence charSequence, int i8, int i9, boolean z2, Layout layout) {
        if (canvas == null) {
            return;
        }
        final float f3 = (i5 + i7) / 2.0f;
        final int iF = RangesKt.f(i3 - this.f29539i, 0);
        Intrinsics.checkNotNull(charSequence, "null cannot be cast to non-null type android.text.Spanned");
        if (((Spanned) charSequence).getSpanStart(this) != i8 || paint == null) {
            return;
        }
        Paint.Style style = paint.getStyle();
        BulletSpan_androidKt.f(paint, this.f29537g);
        float f4 = this.f29533b;
        final long jD = Size.d((((long) Float.floatToRawIntBits(this.f29534c)) & 4294967295L) | (Float.floatToRawIntBits(f4) << 32));
        BulletSpan_androidKt.e(paint, this.f29535d, this.f29536f, jD, new Function0<Unit>() { // from class: androidx.compose.ui.text.platform.style.CustomBulletSpan$drawLeadingMargin$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m260invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m260invoke() {
                BulletSpan_androidKt.d(this.f29541a.f29532a.mo29createOutlinePq9zytI(jD, i4 > 0 ? LayoutDirection.f30001a : LayoutDirection.f30002b, this.f29541a.f29538h), canvas, paint, iF, f3, i4);
            }
        });
        paint.setStyle(style);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z2) {
        int i3 = this.f29540j;
        if (i3 >= 0) {
            return 0;
        }
        return Math.abs(i3);
    }
}
