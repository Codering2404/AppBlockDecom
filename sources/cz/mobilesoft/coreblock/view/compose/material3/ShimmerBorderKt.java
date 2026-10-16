package cz.mobilesoft.coreblock.view.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ShimmerBorderKt {
    private static final float b(float f3, float f4, float f5) {
        return f3 + ((f4 - f3) * f5);
    }

    public static final ShimmerBorderState c(ShimmerBorderSpec spec, String str, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(spec, "spec");
        if ((i4 & 2) != 0) {
            str = "shimmerBorder";
        }
        if (ComposerKt.M()) {
            ComposerKt.U(487898559, i3, -1, "cz.mobilesoft.coreblock.view.compose.material3.rememberShimmerBorderState (ShimmerBorder.kt:42)");
        }
        int iF = RangesKt.f(spec.g(), 1);
        int iF2 = RangesKt.f(spec.f(), 0) + iF;
        float f3 = iF / iF2;
        State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c(str + "Transition", composer, 0, 0), 0.0f, 1.0f, AnimationSpecKt.e(AnimationSpecKt.n(iF2, 0, EasingKt.e(), 2, null), RepeatMode.f4052a, 0L, 4, null), str + "CycleProgress", composer, InfiniteTransition.f3967f | 432 | (InfiniteRepeatableSpec.f3963d << 9), 0);
        float fO = d(stateA) <= f3 ? RangesKt.o(d(stateA) / f3, 0.0f, 1.0f) : 0.0f;
        ShimmerBorderState shimmerBorderState = new ShimmerBorderState(fO, d(stateA) <= f3 ? i(fO, spec.c()) : 0.0f);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return shimmerBorderState;
    }

    private static final float d(State state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static final Modifier e(Modifier shimmerBorder, final Shape shape, final float f3, final long j3, final float f4, final float f5, final ShimmerBorderSpec spec) {
        Intrinsics.checkNotNullParameter(shimmerBorder, "$this$shimmerBorder");
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(spec, "spec");
        return DrawModifierKt.d(shimmerBorder, new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.material3.b2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ShimmerBorderKt.f(shape, f3, f4, f5, spec, j3, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Shape shape, float f3, float f4, float f5, ShimmerBorderSpec shimmerBorderSpec, long j3, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.i2();
        Outline outlineMo29createOutlinePq9zytI = shape.mo29createOutlinePq9zytI(drawWithContent.b(), drawWithContent.getLayoutDirection(), drawWithContent);
        float fM1 = drawWithContent.M1(f3);
        float fO = RangesKt.o(f4, 0.0f, 1.0f);
        float fO2 = RangesKt.o(f5, 0.0f, 1.0f);
        float fE = RangesKt.e(Math.max(Float.intBitsToFloat((int) (drawWithContent.b() >> 32)), Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L))) * RangesKt.e(shimmerBorderSpec.b(), 0.01f), RangesKt.e(shimmerBorderSpec.e(), 1.0f) * fM1);
        long jE = Offset.e((((long) Float.floatToRawIntBits(b(0.0f, Float.intBitsToFloat((int) (drawWithContent.b() >> 32)), fO))) << 32) | (((long) Float.floatToRawIntBits(b(Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L)), 0.0f, fO))) & 4294967295L));
        h(outlineMo29createOutlinePq9zytI, drawWithContent, fM1, Color.n(j3), null, 16, null);
        if (fO2 <= 0.0f) {
            return Unit.f139807a;
        }
        Brush.Companion companion = Brush.Companion;
        Color.Companion companion2 = Color.f25715b;
        List listListOf = CollectionsKt.listOf((Object[]) new Color[]{Color.n(companion2.j()), Color.n(Color.r(companion2.l(), RangesKt.o(shimmerBorderSpec.d(), 0.0f, 1.0f) * fO2, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(companion2.j())});
        int i3 = (int) (jE >> 32);
        int i4 = (int) (jE & 4294967295L);
        long jE2 = Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i3) - fE)) << 32) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4) + fE)) & 4294967295L));
        float fIntBitsToFloat = Float.intBitsToFloat(i3) + fE;
        h(outlineMo29createOutlinePq9zytI, drawWithContent, fM1, null, Brush.Companion.e(companion, listListOf, jE2, Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat(i4) - fE)) & 4294967295L) | (Float.floatToRawIntBits(fIntBitsToFloat) << 32)), 0, 8, null), 8, null);
        return Unit.f139807a;
    }

    private static final void g(Outline outline, ContentDrawScope contentDrawScope, float f3, Color color, Brush brush) {
        if (outline instanceof Outline.Rounded) {
            if (brush != null) {
                Path pathA = AndroidPath_androidKt.a();
                Path.s(pathA, ((Outline.Rounded) outline).b(), null, 2, null);
                DrawScope.F1(contentDrawScope, pathA, brush, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                return;
            } else {
                Path pathA2 = AndroidPath_androidKt.a();
                Path.s(pathA2, ((Outline.Rounded) outline).b(), null, 2, null);
                DrawScope.u0(contentDrawScope, pathA2, color != null ? color.B() : Color.f25715b.j(), 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                return;
            }
        }
        if (outline instanceof Outline.Rectangle) {
            if (brush != null) {
                DrawScope.k1(contentDrawScope, brush, 0L, 0L, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
                return;
            } else {
                DrawScope.L1(contentDrawScope, color != null ? color.B() : Color.f25715b.j(), 0L, 0L, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 110, null);
                return;
            }
        }
        if (!(outline instanceof Outline.Generic)) {
            throw new NoWhenBranchMatchedException();
        }
        if (brush != null) {
            DrawScope.F1(contentDrawScope, ((Outline.Generic) outline).b(), brush, 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        } else {
            DrawScope.u0(contentDrawScope, ((Outline.Generic) outline).b(), color != null ? color.B() : Color.f25715b.j(), 0.0f, new Stroke(f3, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
        }
    }

    static /* synthetic */ void h(Outline outline, ContentDrawScope contentDrawScope, float f3, Color color, Brush brush, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            color = null;
        }
        if ((i3 & 16) != 0) {
            brush = null;
        }
        g(outline, contentDrawScope, f3, color, brush);
    }

    public static final float i(float f3, float f4) {
        float fO = RangesKt.o(f3, 0.0f, 1.0f);
        float fO2 = RangesKt.o(f4, 0.0f, 0.5f);
        if (fO2 <= 0.0f) {
            return 1.0f;
        }
        return RangesKt.o(Math.min(1.0f, Math.min(fO / fO2, (1.0f - fO) / fO2)), 0.0f, 1.0f);
    }
}
