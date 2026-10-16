package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.text.TextPaint;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class AndroidTextPaint extends TextPaint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f29497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TextDecoration f29498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Shadow f29500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Color f29501e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Brush f29502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private State f29503g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Size f29504h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private DrawStyle f29505i;

    public AndroidTextPaint(int i3, float f3) {
        super(i3);
        ((TextPaint) this).density = f3;
        this.f29498b = TextDecoration.f29625b.c();
        this.f29499c = DrawScope.e8.a();
        this.f29500d = Shadow.f25903d.a();
    }

    private final void a() {
        this.f29503g = null;
        this.f29502f = null;
        this.f29504h = null;
        setShader(null);
    }

    private final Paint c() {
        Paint paint = this.f29497a;
        if (paint != null) {
            return paint;
        }
        Paint paintB = AndroidPaint_androidKt.b(this);
        this.f29497a = paintB;
        return paintB;
    }

    public final int b() {
        return this.f29499c;
    }

    public final void d(int i3) {
        if (BlendMode.F(i3, this.f29499c)) {
            return;
        }
        c().p(i3);
        this.f29499c = i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void e(final androidx.compose.ui.graphics.Brush r5, final long r6, float r8) {
        /*
            r4 = this;
            if (r5 != 0) goto L6
            r4.a()
            return
        L6:
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.SolidColor
            if (r0 == 0) goto L18
            androidx.compose.ui.graphics.SolidColor r5 = (androidx.compose.ui.graphics.SolidColor) r5
            long r5 = r5.a()
            long r5 = androidx.compose.ui.text.style.TextDrawStyleKt.c(r5, r8)
            r4.f(r5)
            return
        L18:
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.ShaderBrush
            if (r0 == 0) goto L6d
            androidx.compose.ui.graphics.Brush r0 = r4.f29502f
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r5)
            r1 = 0
            if (r0 == 0) goto L35
            androidx.compose.ui.geometry.Size r0 = r4.f29504h
            if (r0 != 0) goto L2b
            r0 = r1
            goto L33
        L2b:
            long r2 = r0.m()
            boolean r0 = androidx.compose.ui.geometry.Size.f(r2, r6)
        L33:
            if (r0 != 0) goto L54
        L35:
            r2 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L3f
            r1 = 1
        L3f:
            if (r1 == 0) goto L54
            r4.f29502f = r5
            androidx.compose.ui.geometry.Size r0 = androidx.compose.ui.geometry.Size.c(r6)
            r4.f29504h = r0
            androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1 r0 = new androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
            r0.<init>()
            androidx.compose.runtime.State r5 = androidx.compose.runtime.SnapshotStateKt.e(r0)
            r4.f29503g = r5
        L54:
            androidx.compose.ui.graphics.Paint r5 = r4.c()
            androidx.compose.runtime.State r6 = r4.f29503g
            r7 = 0
            if (r6 == 0) goto L64
            java.lang.Object r6 = r6.getValue()
            android.graphics.Shader r6 = (android.graphics.Shader) r6
            goto L65
        L64:
            r6 = r7
        L65:
            r5.z(r6)
            r4.f29501e = r7
            androidx.compose.ui.text.platform.AndroidTextPaint_androidKt.a(r4, r8)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.e(androidx.compose.ui.graphics.Brush, long, float):void");
    }

    public final void f(long j3) {
        Color color = this.f29501e;
        if (color == null ? false : Color.t(color.B(), j3)) {
            return;
        }
        if (j3 != 16) {
            this.f29501e = Color.n(j3);
            setColor(ColorKt.k(j3));
            a();
        }
    }

    public final void g(DrawStyle drawStyle) {
        if (drawStyle == null || Intrinsics.areEqual(this.f29505i, drawStyle)) {
            return;
        }
        this.f29505i = drawStyle;
        if (Intrinsics.areEqual(drawStyle, Fill.f26098a)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (drawStyle instanceof Stroke) {
            c().E(PaintingStyle.f25822b.b());
            Stroke stroke = (Stroke) drawStyle;
            c().F(stroke.f());
            c().C(stroke.d());
            c().t(stroke.c());
            c().o(stroke.b());
            c().s(stroke.e());
        }
    }

    public final void h(Shadow shadow) {
        if (shadow == null || Intrinsics.areEqual(this.f29500d, shadow)) {
            return;
        }
        this.f29500d = shadow;
        if (Intrinsics.areEqual(shadow, Shadow.f25903d.a())) {
            clearShadowLayer();
        } else {
            setShadowLayer(TextPaintExtensions_androidKt.b(this.f29500d.b()), Float.intBitsToFloat((int) (this.f29500d.d() >> 32)), Float.intBitsToFloat((int) (this.f29500d.d() & 4294967295L)), ColorKt.k(this.f29500d.c()));
        }
    }

    public final void i(TextDecoration textDecoration) {
        if (textDecoration == null || Intrinsics.areEqual(this.f29498b, textDecoration)) {
            return;
        }
        this.f29498b = textDecoration;
        TextDecoration.Companion companion = TextDecoration.f29625b;
        setUnderlineText(textDecoration.d(companion.d()));
        setStrikeThruText(this.f29498b.d(companion.b()));
    }
}
