package com.google.accompanist.drawablepainter;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.AndroidColorFilter_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.accompanist.drawablepainter.DrawablePainter$callback$2;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DrawablePainter extends Painter implements RememberObserver {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Drawable f68845h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f68846i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final MutableState f68847j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Lazy f68848k;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f68849a;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.f30001a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.f30002b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f68849a = iArr;
        }
    }

    public DrawablePainter(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.f68845h = drawable;
        this.f68846i = SnapshotStateKt__SnapshotStateKt.e(0, null, 2, null);
        this.f68847j = SnapshotStateKt__SnapshotStateKt.e(Size.c(DrawablePainterKt.c(drawable)), null, 2, null);
        this.f68848k = LazyKt.b(new Function0<DrawablePainter$callback$2.AnonymousClass1>() { // from class: com.google.accompanist.drawablepainter.DrawablePainter$callback$2
            {
                super(0);
            }

            /* JADX WARN: Type inference failed for: r0v0, types: [com.google.accompanist.drawablepainter.DrawablePainter$callback$2$1] */
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final AnonymousClass1 invoke() {
                final DrawablePainter drawablePainter = this.f68850a;
                return new Drawable.Callback() { // from class: com.google.accompanist.drawablepainter.DrawablePainter$callback$2.1
                    @Override // android.graphics.drawable.Drawable.Callback
                    public void invalidateDrawable(Drawable d3) {
                        Intrinsics.checkNotNullParameter(d3, "d");
                        DrawablePainter drawablePainter2 = drawablePainter;
                        drawablePainter2.v(drawablePainter2.s() + 1);
                        DrawablePainter drawablePainter3 = drawablePainter;
                        drawablePainter3.w(DrawablePainterKt.c(drawablePainter3.t()));
                    }

                    @Override // android.graphics.drawable.Drawable.Callback
                    public void scheduleDrawable(Drawable d3, Runnable what, long j3) {
                        Intrinsics.checkNotNullParameter(d3, "d");
                        Intrinsics.checkNotNullParameter(what, "what");
                        DrawablePainterKt.d().postAtTime(what, j3);
                    }

                    @Override // android.graphics.drawable.Drawable.Callback
                    public void unscheduleDrawable(Drawable d3, Runnable what) {
                        Intrinsics.checkNotNullParameter(d3, "d");
                        Intrinsics.checkNotNullParameter(what, "what");
                        DrawablePainterKt.d().removeCallbacks(what);
                    }
                };
            }
        });
        if (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) {
            return;
        }
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    private final Drawable.Callback r() {
        return (Drawable.Callback) this.f68848k.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s() {
        return ((Number) this.f68846i.getValue()).intValue();
    }

    private final long u() {
        return ((Size) this.f68847j.getValue()).m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v(int i3) {
        this.f68846i.setValue(Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(long j3) {
        this.f68847j.setValue(Size.c(j3));
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f3) {
        this.f68845h.setAlpha(RangesKt.p(MathKt.d(f3 * 255), 0, 255));
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(ColorFilter colorFilter) {
        this.f68845h.setColorFilter(colorFilter != null ? AndroidColorFilter_androidKt.d(colorFilter) : null);
        return true;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        this.f68845h.setCallback(r());
        this.f68845h.setVisible(true, true);
        Object obj = this.f68845h;
        if (obj instanceof Animatable) {
            ((Animatable) obj).start();
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        e();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        Object obj = this.f68845h;
        if (obj instanceof Animatable) {
            ((Animatable) obj).stop();
        }
        this.f68845h.setVisible(false, false);
        this.f68845h.setCallback(null);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean f(LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Drawable drawable = this.f68845h;
        int i3 = WhenMappings.f68849a[layoutDirection.ordinal()];
        int i4 = 1;
        if (i3 == 1) {
            i4 = 0;
        } else if (i3 != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return drawable.setLayoutDirection(i4);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long l() {
        return u();
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected void n(DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        Canvas canvasG = drawScope.Q1().g();
        s();
        this.f68845h.setBounds(0, 0, MathKt.d(Size.i(drawScope.b())), MathKt.d(Size.g(drawScope.b())));
        try {
            canvasG.t();
            this.f68845h.draw(AndroidCanvas_androidKt.d(canvasG));
        } finally {
            canvasG.k();
        }
    }

    public final Drawable t() {
        return this.f68845h;
    }
}
