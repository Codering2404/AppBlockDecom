package cz.mobilesoft.coreblock.scene.auto_trial.components.card;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AutoTrialSettledCardKt {
    public static final void c(final Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Composer composerK = composer.k(473962100);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
        } else if ((i3 & 6) == 0) {
            i5 = (composerK.Z(modifier) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            if (i6 != 0) {
                modifier = Modifier.b8;
            }
            if (ComposerKt.M()) {
                ComposerKt.U(473962100, i5, -1, "cz.mobilesoft.coreblock.scene.auto_trial.components.card.AutoTrialSettledCard (AutoTrialSettledCard.kt:32)");
            }
            final WindowInfo windowInfo = (WindowInfo) composerK.q(CompositionLocalsKt.u());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = AnimatableKt.b(0.0f, 0.0f, 2, null);
                composerK.w(objG);
            }
            final Animatable animatable = (Animatable) objG;
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(animatable);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new AutoTrialSettledCardKt$AutoTrialSettledCard$1$1(animatable, null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            Painter painterC = PainterResources_androidKt.c(R.drawable.L0, composerK, 0);
            Modifier modifierI = SizeKt.i(SizeKt.A(modifier, AutoTrialCardKt.p()), Dp.g(AutoTrialCardKt.p() * 1.4736842f));
            boolean zI2 = composerK.I(animatable) | composerK.Z(windowInfo);
            Object objG3 = composerK.G();
            if (zI2 || objG3 == companion.a()) {
                objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.components.card.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AutoTrialSettledCardKt.d(animatable, windowInfo, (GraphicsLayerScope) obj);
                    }
                };
                composerK.w(objG3);
            }
            ImageKt.a(painterC, null, ClipKt.a(GraphicsLayerModifierKt.a(modifierI, (Function1) objG3), RoundedCornerShapeKt.d(Dp.g(AutoTrialCardKt.p() * 0.10526316f))), null, null, 0.0f, null, composerK, 48, 120);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.auto_trial.components.card.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AutoTrialSettledCardKt.e(modifier, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Animatable animatable, WindowInfo windowInfo, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        float fFloatValue = ((Number) animatable.n()).floatValue();
        graphicsLayer.l(((int) (windowInfo.a() >> 32)) * 0.45f * fFloatValue);
        graphicsLayer.d((-((int) (windowInfo.a() & 4294967295L))) * 0.26f * fFloatValue);
        graphicsLayer.j(20.0f * fFloatValue);
        float f3 = 1.4f - (fFloatValue * 0.4f);
        graphicsLayer.e(f3);
        graphicsLayer.k(f3);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        c(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }
}
