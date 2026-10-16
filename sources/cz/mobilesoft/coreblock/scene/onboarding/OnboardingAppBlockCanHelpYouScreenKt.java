package cz.mobilesoft.coreblock.scene.onboarding;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.res.StringResources_androidKt;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.view.compose.ComposeCommitmentScreenKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class OnboardingAppBlockCanHelpYouScreenKt {
    public static final void c(float f3, final Function0 onContinueClicked, Composer composer, final int i3) {
        int i4;
        final float f4;
        Intrinsics.checkNotNullParameter(onContinueClicked, "onContinueClicked");
        Composer composerK = composer.k(147391738);
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
                ComposerKt.U(147391738, i4, -1, "cz.mobilesoft.coreblock.scene.onboarding.OnboardingAppBlockCanHelpYouScreen (OnboardingAppBlockCanHelpYouScreen.kt:24)");
            }
            String strB = StringResources_androidKt.b(R.string.Xl, composerK, 0);
            String strB2 = StringResources_androidKt.b(R.string.Wl, composerK, 0);
            String strB3 = StringResources_androidKt.b(R.string.Vi, composerK, 0);
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.onboarding.r1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return OnboardingAppBlockCanHelpYouScreenKt.d(onContinueClicked);
                    }
                };
                composerK.w(objG);
            }
            f4 = f3;
            ComposeCommitmentScreenKt.o(f4, strB, strB2, strB3, null, (Function0) objG, true, CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.Rl), Integer.valueOf(R.string.Sl), Integer.valueOf(R.string.Tl), Integer.valueOf(R.string.Ul), Integer.valueOf(R.string.Vl)}), composerK, (i4 & 14) | 1597440, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            f4 = f3;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.onboarding.s1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OnboardingAppBlockCanHelpYouScreenKt.e(f4, onContinueClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(float f3, Function0 function0, int i3, Composer composer, int i4) {
        c(f3, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
