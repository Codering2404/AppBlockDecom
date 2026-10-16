package cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.BlockingState;
import cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsViewEvent;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class UnlockAllAppsScreenKt {
    public static final void i(final UnlockAllAppsViewState viewState, final Function1 onEvent, final Function0 onDismissSuccess, Composer composer, final int i3) {
        int i4;
        ScopeUpdateScope scopeUpdateScopeN;
        Function2 function2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(onDismissSuccess, "onDismissSuccess");
        Composer composerK = composer.k(1173712525);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismissSuccess) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1173712525, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.UnlockAllAppsScreen (UnlockAllAppsScreen.kt:17)");
            }
            if (viewState.c() instanceof BlockingState.Loading) {
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.a
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return UnlockAllAppsScreenKt.j(viewState, onEvent, onDismissSuccess, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else if (viewState.d()) {
                composerK.a0(741315543);
                Unit unit = Unit.f139807a;
                boolean z2 = (i4 & 896) == 256;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new UnlockAllAppsScreenKt$UnlockAllAppsScreen$2$1(onDismissSuccess, null);
                    composerK.w(objG);
                }
                EffectsKt.g(unit, (Function2) objG, composerK, 6);
                composerK.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                scopeUpdateScopeN = composerK.n();
                if (scopeUpdateScopeN == null) {
                    return;
                } else {
                    function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.b
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return UnlockAllAppsScreenKt.m(viewState, onEvent, onDismissSuccess, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    };
                }
            } else {
                composerK.a0(740562677);
                composerK.U();
                BlockingState blockingStateC = viewState.c();
                if (blockingStateC instanceof BlockingState.NoActiveBlockings) {
                    composerK.a0(741502473);
                    Object objG2 = composerK.G();
                    Composer.Companion companion = Composer.f23746a;
                    if (objG2 == companion.a()) {
                        objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                        composerK.w(objG2);
                    }
                    MutableState mutableState = (MutableState) objG2;
                    String strB = StringResources_androidKt.b(R.string.Jk, composerK, 0);
                    String strB2 = StringResources_androidKt.b(R.string.Kk, composerK, 0);
                    boolean z3 = (i4 & 112) == 32;
                    Object objG3 = composerK.G();
                    if (z3 || objG3 == companion.a()) {
                        objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.c
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UnlockAllAppsScreenKt.n(onEvent);
                            }
                        };
                        composerK.w(objG3);
                    }
                    ComposeDialogsKt.R0(mutableState, strB, strB2, null, null, (Function0) objG3, composerK, 6, 24);
                    composerK.U();
                } else if (blockingStateC instanceof BlockingState.StrictModeOn) {
                    composerK.a0(741950423);
                    Object objG4 = composerK.G();
                    Composer.Companion companion2 = Composer.f23746a;
                    if (objG4 == companion2.a()) {
                        objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                        composerK.w(objG4);
                    }
                    MutableState mutableState2 = (MutableState) objG4;
                    String strB3 = StringResources_androidKt.b(R.string.OB, composerK, 0);
                    String strB4 = StringResources_androidKt.b(R.string.BB, composerK, 0);
                    String strB5 = StringResources_androidKt.b(R.string.vs, composerK, 0);
                    long jX = ComposeColorsKt.j(composerK, 0).x();
                    int i5 = i4 & 112;
                    boolean z4 = i5 == 32;
                    Object objG5 = composerK.G();
                    if (z4 || objG5 == companion2.a()) {
                        objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.d
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UnlockAllAppsScreenKt.o(onEvent);
                            }
                        };
                        composerK.w(objG5);
                    }
                    Function0 function0 = (Function0) objG5;
                    String strB6 = StringResources_androidKt.b(R.string.ki, composerK, 0);
                    long jB = ComposeColorsKt.j(composerK, 0).b();
                    boolean z5 = i5 == 32;
                    Object objG6 = composerK.G();
                    if (z5 || objG6 == companion2.a()) {
                        objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.e
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UnlockAllAppsScreenKt.p(onEvent);
                            }
                        };
                        composerK.w(objG6);
                    }
                    ComposeDialogsKt.x0(mutableState2, strB3, strB4, null, strB5, jX, false, function0, strB6, jB, (Function0) objG6, composerK, 6, 0, 72);
                    composerK = composerK;
                    composerK.U();
                } else if (blockingStateC instanceof BlockingState.BlockingsActive) {
                    composerK.a0(742784819);
                    Object objG7 = composerK.G();
                    Composer.Companion companion3 = Composer.f23746a;
                    if (objG7 == companion3.a()) {
                        objG7 = SnapshotStateKt__SnapshotStateKt.e(Boolean.TRUE, null, 2, null);
                        composerK.w(objG7);
                    }
                    MutableState mutableState3 = (MutableState) objG7;
                    String strB7 = StringResources_androidKt.b(R.string.fs, composerK, 0);
                    String strB8 = StringResources_androidKt.b(R.string.yH, composerK, 0);
                    long jX2 = ComposeColorsKt.j(composerK, 0).x();
                    int i6 = i4 & 112;
                    boolean z6 = i6 == 32;
                    Object objG8 = composerK.G();
                    if (z6 || objG8 == companion3.a()) {
                        objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UnlockAllAppsScreenKt.q(onEvent);
                            }
                        };
                        composerK.w(objG8);
                    }
                    Function0 function02 = (Function0) objG8;
                    String strB9 = StringResources_androidKt.b(R.string.hi, composerK, 0);
                    long jB2 = ComposeColorsKt.j(composerK, 0).b();
                    boolean z7 = i6 == 32;
                    Object objG9 = composerK.G();
                    if (z7 || objG9 == companion3.a()) {
                        objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return UnlockAllAppsScreenKt.k(onEvent);
                            }
                        };
                        composerK.w(objG9);
                    }
                    ComposeDialogsKt.x0(mutableState3, strB7, null, null, strB8, jX2, false, function02, strB9, jB2, (Function0) objG9, composerK, 6, 0, 76);
                    composerK = composerK;
                    composerK.U();
                } else {
                    composerK.a0(743481203);
                    composerK.U();
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
            scopeUpdateScopeN.a(function2);
        }
        composerK.Q();
        scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.shortcuts.unlock_all_apps.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return UnlockAllAppsScreenKt.l(viewState, onEvent, onDismissSuccess, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeN.a(function2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(UnlockAllAppsViewState unlockAllAppsViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        i(unlockAllAppsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(Function1 function1) {
        function1.invoke(UnlockAllAppsViewEvent.Dismiss.f101488a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(UnlockAllAppsViewState unlockAllAppsViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        i(unlockAllAppsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(UnlockAllAppsViewState unlockAllAppsViewState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        i(unlockAllAppsViewState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(Function1 function1) {
        function1.invoke(UnlockAllAppsViewEvent.Dismiss.f101488a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Function1 function1) {
        function1.invoke(UnlockAllAppsViewEvent.RequestEmergencyUnlock.f101489a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function1 function1) {
        function1.invoke(UnlockAllAppsViewEvent.Dismiss.f101488a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Function1 function1) {
        function1.invoke(UnlockAllAppsViewEvent.ConfirmUnlock.f101487a);
        return Unit.f139807a;
    }
}
