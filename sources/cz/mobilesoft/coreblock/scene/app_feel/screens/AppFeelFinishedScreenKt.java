package cz.mobilesoft.coreblock.scene.app_feel.screens;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.AspectRatioKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppFeelFinishedScreenKt {
    public static final void g(final Function0 onFinishClicked, Composer composer, final int i3) throws XmlPullParserException, IOException {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onFinishClicked, "onFinishClicked");
        Composer composerK = composer.k(1950575944);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onFinishClicked) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1950575944, i4, -1, "cz.mobilesoft.coreblock.scene.app_feel.screens.AppFeelFinishedScreen (AppFeelFinishedScreen.kt:53)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = AnimatableKt.b(0.0f, 0.0f, 2, null);
                composerK.w(objG);
            }
            final Animatable animatable = (Animatable) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = AnimatableKt.b(0.0f, 0.0f, 2, null);
                composerK.w(objG2);
            }
            final Animatable animatable2 = (Animatable) objG2;
            boolean zI = composerK.I(animatable) | composerK.I(animatable2);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new AppFeelFinishedScreenKt$AppFeelFinishedScreen$1$1(animatable, animatable2, null);
                composerK.w(objG3);
            }
            int i5 = Animatable.f3769m;
            EffectsKt.f(animatable, animatable2, (Function2) objG3, composerK, i5 | (i5 << 3));
            Modifier.Companion companion2 = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.k(BackgroundKt.d(SizeKt.f(companion2, 0.0f, 1, null), ComposeColorsKt.j(composerK, 0).e(), null, 2, null), Dp.g(f3), 0.0f, 2, null), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion3 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion3.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierG);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A);
            } else {
                composerK.v();
            }
            Composer composerA = Updater.a(composerK);
            Updater.e(composerA, measurePolicyA, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion4.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strB = StringResources_androidKt.b(R.string.P0, composerK, 0);
            TextStyle textStyleF = ComposeTypographyKt.g(composerK, 0).f();
            TextAlign.Companion companion5 = TextAlign.f29616b;
            TextKt.c(strB, null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, textStyleF, composerK, 0, 0, 65022);
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composerK, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Q0, composerK, 0), null, ComposeColorsKt.j(composerK, 0).L(), 0L, null, null, null, 0L, null, TextAlign.h(companion5.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65018);
            Modifier modifierB = ColumnScope.b(columnScopeInstance, SizeKt.h(companion2, 0.0f, 1, null), 1.0f, false, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion3.e(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierB);
            Function0 function0A2 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG, companion4.e());
            Updater.e(composerA2, compositionLocalMapU2, companion4.g());
            Function2 function2B2 = companion4.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            final long jE = ComposeColorsKt.j(composerK, 0).e();
            Modifier modifierC = GraphicsLayerModifierKt.c(ClipKt.a(AspectRatioKt.b(SizeKt.g(companion2, 0.9f), 1.0f, false, 2, null), RoundedCornerShapeKt.g()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, CompositingStrategy.f25737b.c(), 65535, null);
            boolean zF = composerK.f(jE);
            Object objG4 = composerK.G();
            if (zF || objG4 == companion.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelFinishedScreenKt.h(jE, (CacheDrawScope) obj);
                    }
                };
                composerK.w(objG4);
            }
            Modifier modifierC2 = DrawModifierKt.c(modifierC, (Function1) objG4);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion3.e(), false);
            int iA3 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU3 = composerK.u();
            Modifier modifierF3 = ComposedModifierKt.f(composerK, modifierC2);
            Function0 function0A3 = companion4.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A3);
            } else {
                composerK.v();
            }
            Composer composerA3 = Updater.a(composerK);
            Updater.e(composerA3, measurePolicyG2, companion4.e());
            Updater.e(composerA3, compositionLocalMapU3, companion4.g());
            Function2 function2B3 = companion4.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion4.f());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95501d, composerK, 6);
            ContentScale.Companion companion6 = ContentScale.f27054a;
            ContentScale contentScaleE = companion6.e();
            Modifier modifierF4 = boxScopeInstance.f(SizeKt.g(companion2, 0.9f), companion3.b());
            boolean zI2 = composerK.I(animatable);
            Object objG5 = composerK.G();
            if (zI2 || objG5 == companion.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelFinishedScreenKt.j(animatable, (GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG5);
            }
            ImageKt.b(imageVectorB, null, GraphicsLayerModifierKt.a(modifierF4, (Function1) objG5), null, contentScaleE, 0.0f, null, composerK, 24624, 104);
            final long jE2 = ComposeColorsKt.j(composerK, 0).e();
            Modifier modifierF5 = SizeKt.f(companion2, 0.0f, 1, null);
            boolean zF2 = composerK.f(jE2);
            Object objG6 = composerK.G();
            if (zF2 || objG6 == companion.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelFinishedScreenKt.k(jE2, (DrawScope) obj);
                    }
                };
                composerK.w(objG6);
            }
            BoxKt.a(DrawModifierKt.b(modifierF5, (Function1) objG6), composerK, 0);
            Modifier modifierE = SizeKt.e(companion2, 0.5f);
            boolean zI3 = composerK.I(animatable2);
            Object objG7 = composerK.G();
            if (zI3 || objG7 == companion.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppFeelFinishedScreenKt.l(animatable2, (GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG7);
            }
            ImageKt.a(PainterResources_androidKt.c(R.drawable.f95497c, composerK, 0), null, GraphicsLayerModifierKt.a(modifierE, (Function1) objG7), null, companion6.e(), 0.0f, null, composerK, 24624, 104);
            composer2 = composerK;
            composer2.y();
            composer2.y();
            SpacerKt.a(SizeKt.i(companion2, Dp.g(f3)), composer2, 6);
            ComposeButtonsKt.J(null, StringResources_androidKt.b(R.string.Ue, composer2, 0), false, false, null, onFinishClicked, composer2, ((i4 << 15) & 458752) | 3072, 21);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppFeelFinishedScreenKt.m(onFinishClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult h(final long j3, CacheDrawScope drawWithCache) {
        Intrinsics.checkNotNullParameter(drawWithCache, "$this$drawWithCache");
        return drawWithCache.x(new Function1() { // from class: cz.mobilesoft.coreblock.scene.app_feel.screens.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return AppFeelFinishedScreenKt.i(j3, (ContentDrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(long j3, ContentDrawScope onDrawWithContent) {
        Intrinsics.checkNotNullParameter(onDrawWithContent, "$this$onDrawWithContent");
        onDrawWithContent.i2();
        DrawScope.k1(onDrawWithContent, Brush.Companion.i(Brush.Companion, new Pair[]{TuplesKt.a(Float.valueOf(0.6f), Color.n(j3)), TuplesKt.a(Float.valueOf(1.0f), Color.n(Color.f25715b.j()))}, 0L, 0.0f, 0, 14, null), 0L, 0L, 0.0f, null, null, BlendMode.f25667b.i(), 62, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Animatable animatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.k(((Number) animatable.n()).floatValue());
        graphicsLayer.A0(TransformOriginKt.a(0.5f, 1.0f));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(long j3, DrawScope drawBehind) {
        Intrinsics.checkNotNullParameter(drawBehind, "$this$drawBehind");
        DrawScope.z1(drawBehind, Brush.Companion.i(Brush.Companion, new Pair[]{TuplesKt.a(Float.valueOf(0.6f), Color.n(Color.f25715b.j())), TuplesKt.a(Float.valueOf(1.0f), Color.n(j3))}, 0L, 0.0f, 0, 14, null), 0.0f, 0L, 0.0f, null, null, 0, 126, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(Animatable animatable, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.e(((Number) animatable.n()).floatValue());
        graphicsLayer.k(((Number) animatable.n()).floatValue());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0, int i3, Composer composer, int i4) throws XmlPullParserException, IOException {
        g(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
