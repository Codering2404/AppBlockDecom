package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class Painter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f26288a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f26289b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ColorFilter f26290c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f26291d = 1.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LayoutDirection f26292f = LayoutDirection.f30001a;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function1 f26293g = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.painter.Painter$drawLambda$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((DrawScope) obj);
            return Unit.f139807a;
        }

        public final void invoke(DrawScope drawScope) {
            this.f26294a.n(drawScope);
        }
    };

    private final void g(float f3) {
        if (this.f26291d == f3) {
            return;
        }
        if (!a(f3)) {
            if (f3 == 1.0f) {
                Paint paint = this.f26288a;
                if (paint != null) {
                    paint.c(f3);
                }
                this.f26289b = false;
            } else {
                m().c(f3);
                this.f26289b = true;
            }
        }
        this.f26291d = f3;
    }

    private final void h(ColorFilter colorFilter) {
        if (Intrinsics.areEqual(this.f26290c, colorFilter)) {
            return;
        }
        if (!b(colorFilter)) {
            if (colorFilter == null) {
                Paint paint = this.f26288a;
                if (paint != null) {
                    paint.B(null);
                }
                this.f26289b = false;
            } else {
                m().B(colorFilter);
                this.f26289b = true;
            }
        }
        this.f26290c = colorFilter;
    }

    private final void i(LayoutDirection layoutDirection) {
        if (this.f26292f != layoutDirection) {
            f(layoutDirection);
            this.f26292f = layoutDirection;
        }
    }

    public static /* synthetic */ void k(Painter painter, DrawScope drawScope, long j3, float f3, ColorFilter colorFilter, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: draw-x_KDEd0");
        }
        if ((i3 & 2) != 0) {
            f3 = 1.0f;
        }
        float f4 = f3;
        if ((i3 & 4) != 0) {
            colorFilter = null;
        }
        painter.j(drawScope, j3, f4, colorFilter);
    }

    private final Paint m() {
        Paint paint = this.f26288a;
        if (paint != null) {
            return paint;
        }
        Paint paintA = AndroidPaint_androidKt.a();
        this.f26288a = paintA;
        return paintA;
    }

    protected boolean a(float f3) {
        return false;
    }

    protected boolean b(ColorFilter colorFilter) {
        return false;
    }

    protected boolean f(LayoutDirection layoutDirection) {
        return false;
    }

    public final void j(DrawScope drawScope, long j3, float f3, ColorFilter colorFilter) {
        g(f3);
        h(colorFilter);
        i(drawScope.getLayoutDirection());
        int i3 = (int) (j3 >> 32);
        float fIntBitsToFloat = Float.intBitsToFloat((int) (drawScope.b() >> 32)) - Float.intBitsToFloat(i3);
        int i4 = (int) (j3 & 4294967295L);
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (drawScope.b() & 4294967295L)) - Float.intBitsToFloat(i4);
        drawScope.Q1().e().k(0.0f, 0.0f, fIntBitsToFloat, fIntBitsToFloat2);
        if (f3 > 0.0f) {
            try {
                if (Float.intBitsToFloat(i3) > 0.0f && Float.intBitsToFloat(i4) > 0.0f) {
                    if (this.f26289b) {
                        long jC = Offset.f25596b.c();
                        float fIntBitsToFloat3 = Float.intBitsToFloat(i3);
                        Rect rectC = RectKt.c(jC, Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4))) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat3) << 32)));
                        Canvas canvasG = drawScope.Q1().g();
                        try {
                            canvasG.p(rectC, m());
                            n(drawScope);
                            canvasG.k();
                        } catch (Throwable th) {
                            canvasG.k();
                            throw th;
                        }
                    } else {
                        n(drawScope);
                    }
                }
            } catch (Throwable th2) {
                drawScope.Q1().e().k(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
                throw th2;
            }
        }
        drawScope.Q1().e().k(-0.0f, -0.0f, -fIntBitsToFloat, -fIntBitsToFloat2);
    }

    public abstract long l();

    protected abstract void n(DrawScope drawScope);
}
