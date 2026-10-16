package cz.mobilesoft.coreblock.scene.subscriptionob;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SubscriptionOnboardingActivityKt {
    /* JADX WARN: Removed duplicated region for block: B:53:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void f(final java.lang.String r11, java.lang.String r12, final kotlin.jvm.functions.Function0 r13, final kotlin.jvm.functions.Function3 r14, androidx.compose.runtime.Composer r15, final int r16, final int r17) {
        /*
            Method dump skipped, instruction units count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.subscriptionob.SubscriptionOnboardingActivityKt.f(java.lang.String, java.lang.String, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g(Function3 function3, BoxScope BaseScreen, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseScreen, "$this$BaseScreen");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(BaseScreen) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2029159929, i3, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.BasePremiumOnboardingScreen.<anonymous> (SubscriptionOnboardingActivity.kt:292)");
            }
            function3.invoke(BaseScreen, composer, Integer.valueOf(i3 & 14));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(String str, String str2, Function0 function0, Function3 function3, int i3, int i4, Composer composer, int i5) {
        f(str, str2, function0, function3, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    public static final void i(String title, Function0 onNavigateToNext, final int i3, Composer composer, final int i4) {
        int i5;
        final String str;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onNavigateToNext, "onNavigateToNext");
        Composer composerK = composer.k(-2000642301);
        if ((i4 & 6) == 0) {
            i5 = (composerK.Z(title) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(onNavigateToNext) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2000642301, i5, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.BaseSimpleScreen (SubscriptionOnboardingActivity.kt:256)");
            }
            str = title;
            function0 = onNavigateToNext;
            f(str, null, function0, ComposableLambdaKt.e(-177812357, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.y0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return SubscriptionOnboardingActivityKt.j(i3, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, (i5 & 14) | 3072 | ((i5 << 3) & 896), 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            str = title;
            function0 = onNavigateToNext;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SubscriptionOnboardingActivityKt.k(str, function0, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(int i3, BoxScope BasePremiumOnboardingScreen, Composer composer, int i4) {
        int i5;
        Intrinsics.checkNotNullParameter(BasePremiumOnboardingScreen, "$this$BasePremiumOnboardingScreen");
        if ((i4 & 6) == 0) {
            i5 = (composer.Z(BasePremiumOnboardingScreen) ? 4 : 2) | i4;
        } else {
            i5 = i4;
        }
        if (composer.r((i5 & 19) != 18, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-177812357, i5, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.BaseSimpleScreen.<anonymous> (SubscriptionOnboardingActivity.kt:261)");
            }
            ImageKt.a(PainterResources_androidKt.c(i3, composer, 0), null, BasePremiumOnboardingScreen.f(Modifier.b8, Alignment.f25072a.b()), null, ContentScale.f27054a.d(), 0.0f, null, composer, 24624, 104);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(String str, Function0 function0, int i3, int i4, Composer composer, int i5) {
        i(str, function0, i3, composer, RecomposeScopeImplKt.a(i4 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final Screen screen, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(195710556);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(screen) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(195710556, i4, -1, "cz.mobilesoft.coreblock.scene.subscriptionob.LogScreen (SubscriptionOnboardingActivity.kt:299)");
            }
            Unit unit = Unit.f139807a;
            boolean z2 = (i4 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new SubscriptionOnboardingActivityKt$LogScreen$1$1(screen, null);
                composerK.w(objG);
            }
            EffectsKt.g(unit, (Function2) objG, composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.subscriptionob.x0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return SubscriptionOnboardingActivityKt.m(screen, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Screen screen, int i3, Composer composer, int i4) {
        l(screen, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
