package cz.mobilesoft.coreblock.scene.onboarding.statistics;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class OnboardingTimeOnPhoneScreenKt {
    public static final void c(final float f3, Function1 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final Function1 function1;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(-98699290);
        if ((i3 & 6) == 0) {
            i4 = (composerK.c(f3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onContinueClicked) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-98699290, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingTimeOnPhoneScreen (OnboardingTimeOnPhoneScreen.kt:14)");
            }
            Unit unit = Unit.f139807a;
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new OnboardingTimeOnPhoneScreenKt$OnboardingTimeOnPhoneScreen$1$1(null);
                composerK.w(objG);
            }
            EffectsKt.g(unit, (Function2) objG, composerK, 6);
            function1 = onContinueClicked;
            StatsQuestionScreenKt.n(StringResources_androidKt.b(R.string.Cm, composerK, 0), RangesKt.b(1.0f, 12.0f), new Function3() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.x0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return OnboardingTimeOnPhoneScreenKt.d(((Float) obj).floatValue(), (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, function1, Float.valueOf(f3), composerK, ((i4 << 6) & 7168) | ((i4 << 12) & 57344), 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function1 = onContinueClicked;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.statistics.y0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingTimeOnPhoneScreenKt.e(f3, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String d(float f3, Composer composer, int i3) {
        composer.a0(-737498807);
        if (ComposerKt.M()) {
            ComposerKt.U(-737498807, i3, -1, "cz.mobilesoft.coreblock.scene.onboarding.statistics.OnboardingTimeOnPhoneScreen.<anonymous> (OnboardingTimeOnPhoneScreen.kt:22)");
        }
        String strC = StringResources_androidKt.c(R.string.wk, new Object[]{Integer.valueOf(MathKt.d(f3))}, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(float f3, Function1 function1, int i3, Composer composer, int i4) {
        c(f3, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
