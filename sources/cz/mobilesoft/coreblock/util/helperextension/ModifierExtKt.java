package cz.mobilesoft.coreblock.util.helperextension;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ModifierExtKt {
    public static final Modifier e(Modifier modifier, final int i3) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return OffsetKt.b(modifier, new Function1() { // from class: cz.mobilesoft.coreblock.util.helperextension.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModifierExtKt.f(i3, (Density) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset f(int i3, Density offset) {
        Intrinsics.checkNotNullParameter(offset, "$this$offset");
        return IntOffset.c(IntOffset.f((((long) MathKt.d(i3 / 2.0f)) & 4294967295L) | (((long) 0) << 32)));
    }

    public static final Modifier g(Modifier modifier, FocusManager localFocusManager) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(localFocusManager, "localFocusManager");
        return SuspendingPointerInputFilterKt.d(modifier, Unit.f139807a, new ModifierExtKt$clearFocusOnTap$1(localFocusManager));
    }

    public static final Modifier h(Modifier contentShimmer, final long j3, final long j4, final int i3) {
        Intrinsics.checkNotNullParameter(contentShimmer, "$this$contentShimmer");
        return ComposedModifierKt.c(contentShimmer, null, new Function3() { // from class: cz.mobilesoft.coreblock.util.helperextension.b0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return ModifierExtKt.j(i3, j4, j3, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, null);
    }

    public static /* synthetic */ Modifier i(Modifier modifier, long j3, long j4, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j3 = Color.f25715b.l();
        }
        long j5 = j3;
        if ((i4 & 2) != 0) {
            j4 = Color.f25715b.j();
        }
        long j6 = j4;
        if ((i4 & 4) != 0) {
            i3 = 5000;
        }
        return h(modifier, j5, j6, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier j(int i3, long j3, long j4, Modifier composed, Composer composer, int i4) {
        Intrinsics.checkNotNullParameter(composed, "$this$composed");
        composer.a0(-541845939);
        if (ComposerKt.M()) {
            ComposerKt.U(-541845939, i4, -1, "cz.mobilesoft.coreblock.util.helperextension.contentShimmer.<anonymous> (ModifierExt.kt:48)");
        }
        State stateA = InfiniteTransitionKt.a(InfiniteTransitionKt.c("ShimmerTransition", composer, 6, 0), 0.0f, 1500.0f, AnimationSpecKt.e(AnimationSpecKt.n(i3, 0, EasingKt.e(), 2, null), RepeatMode.f4052a, 0L, 4, null), "ShimmerTranslateAnimation", composer, InfiniteTransition.f3967f | 25008 | (InfiniteRepeatableSpec.f3963d << 9), 0);
        List listListOf = CollectionsKt.listOf((Object[]) new Color[]{Color.n(j3), Color.n(Color.r(j4, 0.8f, 0.0f, 0.0f, 0.0f, 14, null)), Color.n(j3)});
        final Brush brushE = Brush.Companion.e(Brush.Companion, listListOf, Offset.e((((long) Float.floatToRawIntBits(((Number) stateA.getValue()).floatValue() - 500.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(((Number) stateA.getValue()).floatValue())) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L)), 0, 8, null);
        Modifier modifierC = GraphicsLayerModifierKt.c(composed, 0.0f, 0.0f, 0.99f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
        boolean Z = composer.Z(brushE);
        Object objG = composer.G();
        if (Z || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.util.helperextension.c0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ModifierExtKt.k(brushE, (ContentDrawScope) obj);
                }
            };
            composer.w(objG);
        }
        Modifier modifierD = DrawModifierKt.d(modifierC, (Function1) objG);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return modifierD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Brush brush, ContentDrawScope drawWithContent) {
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.i2();
        DrawScope.k1(drawWithContent, brush, 0L, 0L, 0.0f, null, null, BlendMode.f25667b.z(), 62, null);
        return Unit.f139807a;
    }

    public static final Modifier l(Modifier fadingTopBottomEdgesDp, float f3, float f4, Composer composer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(fadingTopBottomEdgesDp, "$this$fadingTopBottomEdgesDp");
        if ((i4 & 1) != 0) {
            f3 = Dp.g(24);
        }
        if ((i4 & 2) != 0) {
            f4 = Dp.g(24);
        }
        if (ComposerKt.M()) {
            ComposerKt.U(-1057103849, i3, -1, "cz.mobilesoft.coreblock.util.helperextension.fadingTopBottomEdgesDp (ModifierExt.kt:101)");
        }
        Density density = (Density) composer.q(CompositionLocalsKt.f());
        Modifier modifierM = m(fadingTopBottomEdgesDp, density.M1(f3), density.M1(f4));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return modifierM;
    }

    public static final Modifier m(Modifier modifier, final float f3, final float f4) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        return DrawModifierKt.d(GraphicsLayerModifierKt.c(modifier, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, CompositingStrategy.f25737b.c(), 65535, null), new Function1() { // from class: cz.mobilesoft.coreblock.util.helperextension.z
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ModifierExtKt.n(f3, f4, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(float f3, float f4, ContentDrawScope drawWithContent) {
        Float fValueOf = Float.valueOf(1.0f);
        Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
        drawWithContent.i2();
        Float fValueOf2 = Float.valueOf(0.0f);
        if (f3 > 0.0f) {
            Brush.Companion companion = Brush.Companion;
            Color.Companion companion2 = Color.f25715b;
            DrawScope.k1(drawWithContent, Brush.Companion.n(companion, new Pair[]{TuplesKt.a(fValueOf2, Color.n(companion2.j())), TuplesKt.a(fValueOf, Color.n(companion2.a()))}, 0.0f, f3, 0, 8, null), 0L, Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawWithContent.b() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f3)) & 4294967295L)), 0.0f, null, null, BlendMode.f25667b.i(), 58, null);
        }
        if (f4 > 0.0f) {
            Brush.Companion companion3 = Brush.Companion;
            Color.Companion companion4 = Color.f25715b;
            Brush brushN = Brush.Companion.n(companion3, new Pair[]{TuplesKt.a(fValueOf2, Color.n(companion4.a())), TuplesKt.a(fValueOf, Color.n(companion4.j()))}, Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L)) - f4, Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L)), 0, 8, null);
            float fIntBitsToFloat = Float.intBitsToFloat((int) (drawWithContent.b() & 4294967295L)) - f4;
            DrawScope.k1(drawWithContent, brushN, Offset.e((((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) & 4294967295L)), Size.d((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (drawWithContent.b() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L)), 0.0f, null, null, BlendMode.f25667b.i(), 56, null);
        }
        return Unit.f139807a;
    }

    public static final Modifier o(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        if (ComposerKt.M()) {
            ComposerKt.U(640262061, i5, -1, "cz.mobilesoft.coreblock.util.helperextension.paddingBottomForCenteredChildOverflow (ModifierExt.kt:179)");
        }
        float f3 = i4 / 2.0f;
        Modifier modifierM = PaddingKt.m(modifier, 0.0f, 0.0f, 0.0f, ((Density) composer.q(CompositionLocalsKt.f())).G(RangesKt.e((f3 + f3) - (i3 / 2.0f), 0.0f)), 7, null);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return modifierM;
    }
}
