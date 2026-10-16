package cz.mobilesoft.coreblock.scene.emergency_unblock.screens;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import com.facebook.ads.AdError;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class EmergencyUnblockCloseSuccessScreenKt {
    public static final void c(final Function0 onFinish, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(onFinish, "onFinish");
        Composer composerK = composer.k(905505988);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onFinish) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(905505988, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockCloseSuccessScreen (EmergencyUnblockCloseSuccessScreen.kt:34)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            Object obj = objG;
            if (objG == companion.a()) {
                MutableTransitionState mutableTransitionState = new MutableTransitionState(Boolean.FALSE);
                mutableTransitionState.h(Boolean.TRUE);
                composerK.w(mutableTransitionState);
                obj = mutableTransitionState;
            }
            final MutableTransitionState mutableTransitionState2 = (MutableTransitionState) obj;
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(mutableTransitionState2) | ((i4 & 14) == 4);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new EmergencyUnblockCloseSuccessScreenKt$EmergencyUnblockCloseSuccessScreen$1$1(mutableTransitionState2, onFinish, null);
                composerK.w(objG2);
            }
            EffectsKt.g(unit, (Function2) objG2, composerK, 6);
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-430180270, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.h
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return EmergencyUnblockCloseSuccessScreenKt.d(mutableTransitionState2, (BoxScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), composerK, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.emergency_unblock.screens.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return EmergencyUnblockCloseSuccessScreenKt.e(onFinish, i3, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d(MutableTransitionState mutableTransitionState, BoxScope GradientBox, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if ((i3 & 6) == 0) {
            i4 = (composer.Z(GradientBox) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-430180270, i4, -1, "cz.mobilesoft.coreblock.scene.emergency_unblock.screens.EmergencyUnblockCloseSuccessScreen.<anonymous> (EmergencyUnblockCloseSuccessScreen.kt:49)");
            }
            AnimatedVisibilityKt.d(mutableTransitionState, GradientBox.f(Modifier.b8, Alignment.f25072a.e()), EnterExitTransitionKt.o(AnimationSpecKt.n(2500, 0, null, 6, null), 0.0f, 2, null), EnterExitTransitionKt.q(AnimationSpecKt.n(AdError.SERVER_ERROR_CODE, 0, null, 6, null), 0.0f, 2, null), null, ComposableSingletons$EmergencyUnblockCloseSuccessScreenKt.f101907a.b(), composer, MutableTransitionState.f4020d | 200064, 16);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(Function0 function0, int i3, Composer composer, int i4) {
        c(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
