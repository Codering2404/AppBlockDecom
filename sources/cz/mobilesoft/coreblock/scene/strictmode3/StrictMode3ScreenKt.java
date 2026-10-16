package cz.mobilesoft.coreblock.scene.strictmode3;

import android.content.Context;
import android.content.Intent;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.material.ScaffoldState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.enums.PremiumFeature;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.enums.StrictModeDeactivation;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.scene.strictmode.StrictModeInfoActivity;
import cz.mobilesoft.coreblock.scene.strictmode3.AccessMethodConfiguration;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewEvent;
import cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ViewModel;
import cz.mobilesoft.coreblock.scene.strictmode3.component.emailinput.StrictModeEmailInputBottomSheetKt;
import cz.mobilesoft.coreblock.scene.strictmode3.confirmation.StrictModeConfirmationViewState;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.compose.ActivityLauncher;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StrictMode3ScreenKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f121161a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f121161a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MutableState mutableState, MutableState mutableState2, Function1 function1, StrictMode3ViewState strictMode3ViewState, int i3, Composer composer, int i4) {
        w(mutableState, mutableState2, function1, strictMode3ViewState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void B(final StrictMode3ViewModel strictMode3ViewModel, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-409454060);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(strictMode3ViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-409454060, i4, -1, "cz.mobilesoft.coreblock.scene.strictmode3.AttachLifecycleObserverToViewModel (StrictMode3Screen.kt:482)");
            }
            final State stateP = SnapshotStateKt.p(composerK.q(LocalLifecycleOwnerKt.c()), composerK, 0);
            boolean Z = composerK.Z(stateP) | composerK.I(strictMode3ViewModel);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.t2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ScreenKt.C(stateP, strictMode3ViewModel, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG);
            }
            EffectsKt.c(stateP, (Function1) objG, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.u2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3ScreenKt.D(strictMode3ViewModel, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult C(final State state, final StrictMode3ViewModel strictMode3ViewModel, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        ((LifecycleOwner) state.getValue()).getLifecycle().addObserver(strictMode3ViewModel);
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt$AttachLifecycleObserverToViewModel$lambda$0$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                ((LifecycleOwner) state.getValue()).getLifecycle().removeObserver(strictMode3ViewModel);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(StrictMode3ViewModel strictMode3ViewModel, int i3, Composer composer, int i4) {
        B(strictMode3ViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void E(final StrictMode3ViewModel viewModel, final Function1 onEvent, final ScaffoldState scaffoldState, final MutableState showCooldownTimerBottomSheet, Composer composer, final int i3) {
        int i4;
        Context context;
        int i5;
        SnapshotMutationPolicy snapshotMutationPolicy;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Intrinsics.checkNotNullParameter(scaffoldState, "scaffoldState");
        Intrinsics.checkNotNullParameter(showCooldownTimerBottomSheet, "showCooldownTimerBottomSheet");
        Composer composerK = composer.k(-641481966);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(viewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.Z(scaffoldState) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(showCooldownTimerBottomSheet) ? 2048 : 1024;
        }
        int i6 = i4;
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-641481966, i6, -1, "cz.mobilesoft.coreblock.scene.strictmode3.CommandProcessor (StrictMode3Screen.kt:198)");
            }
            final Context context2 = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG3);
            }
            MutableState mutableState2 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG4);
            }
            MutableState mutableState3 = (MutableState) objG4;
            int i7 = i6 & 14;
            w(mutableState2, mutableState3, onEvent, (StrictMode3ViewState) FlowExtKt.m(viewModel, composerK, i7), composerK, ((i6 << 3) & 896) | 54);
            PermissionRequestReason permissionRequestReason = PermissionRequestReason.General;
            int i8 = i6 & 112;
            boolean z2 = i8 == 32;
            Object objG5 = composerK.G();
            if (z2 || objG5 == companion.a()) {
                objG5 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.v2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return StrictMode3ScreenKt.G(onEvent, (ActivityResult) obj, (PermissionRequestReason) obj2);
                    }
                };
                composerK.w(objG5);
            }
            ActivityLauncher activityLauncherP = ComposeCommonsKt.p(permissionRequestReason, (Function2) objG5, composerK, 6);
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            boolean z3 = i8 == 32;
            Object objG6 = composerK.G();
            if (z3 || objG6 == companion.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.b2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ScreenKt.H(onEvent, (ActivityResult) obj);
                    }
                };
                composerK.w(objG6);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG6, composerK, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult2 = new ActivityResultContracts.StartActivityForResult();
            boolean zI = (i8 == 32) | composerK.I(context2) | composerK.I(managedActivityResultLauncherA);
            Object objG7 = composerK.G();
            if (zI || objG7 == companion.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.c2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ScreenKt.I(mutableState, context2, managedActivityResultLauncherA, onEvent, (ActivityResult) obj);
                    }
                };
                composerK.w(objG7);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(startActivityForResult2, (Function1) objG7, composerK, 0);
            ActivityResultContracts.StartActivityForResult startActivityForResult3 = new ActivityResultContracts.StartActivityForResult();
            boolean z4 = i8 == 32;
            Object objG8 = composerK.G();
            if (z4 || objG8 == companion.a()) {
                objG8 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.d2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ScreenKt.J(onEvent, (ActivityResult) obj);
                    }
                };
                composerK.w(objG8);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA3 = ActivityResultRegistryKt.a(startActivityForResult3, (Function1) objG8, composerK, 0);
            int i9 = (i6 >> 3) & 14;
            ManagedActivityResultLauncher managedActivityResultLauncherX = X(onEvent, composerK, i9);
            ManagedActivityResultLauncher managedActivityResultLauncherV = V(onEvent, composerK, i9);
            ActivityResultContracts.StartActivityForResult startActivityForResult4 = new ActivityResultContracts.StartActivityForResult();
            boolean z5 = i8 == 32;
            Object objG9 = composerK.G();
            if (z5 || objG9 == companion.a()) {
                objG9 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.e2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return StrictMode3ScreenKt.K(onEvent, (ActivityResult) obj);
                    }
                };
                composerK.w(objG9);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA4 = ActivityResultRegistryKt.a(startActivityForResult4, (Function1) objG9, composerK, 0);
            Object objG10 = composerK.G();
            if (objG10 == companion.a()) {
                MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(mutableStateE);
                objG10 = mutableStateE;
            }
            MutableState mutableState4 = (MutableState) objG10;
            Object objG11 = composerK.G();
            if (objG11 == companion.a()) {
                context = context2;
                i5 = 2;
                snapshotMutationPolicy = null;
                objG11 = SnapshotStateKt__SnapshotStateKt.e(TuplesKt.a("", ""), null, 2, null);
                composerK.w(objG11);
            } else {
                context = context2;
                i5 = 2;
                snapshotMutationPolicy = null;
            }
            MutableState mutableState5 = (MutableState) objG11;
            SnapshotMutationPolicy snapshotMutationPolicy2 = snapshotMutationPolicy;
            int i10 = i5;
            Context context3 = context;
            ComposeDialogsKt.R0(mutableState4, (String) ((Pair) mutableState5.getValue()).e(), (String) ((Pair) mutableState5.getValue()).f(), null, null, null, composerK, 6, 56);
            Object objG12 = composerK.G();
            if (objG12 == companion.a()) {
                objG12 = SnapshotStateKt__SnapshotStateKt.e(snapshotMutationPolicy2, snapshotMutationPolicy2, i10, snapshotMutationPolicy2);
                composerK.w(objG12);
            }
            MutableState mutableState6 = (MutableState) objG12;
            ManagedActivityResultLauncher managedActivityResultLauncherT = T(onEvent, mutableState6, composerK, i9 | 48);
            boolean zI2 = composerK.I(context3) | composerK.I(managedActivityResultLauncherA4) | composerK.I(activityLauncherP) | composerK.I(managedActivityResultLauncherT) | composerK.I(managedActivityResultLauncherX) | composerK.I(managedActivityResultLauncherV) | ((i6 & 7168) == 2048) | composerK.I(coroutineScope) | ((i6 & 896) == 256) | composerK.I(managedActivityResultLauncherA2) | composerK.I(managedActivityResultLauncherA) | composerK.I(managedActivityResultLauncherA3);
            Object objG13 = composerK.G();
            if (zI2 || objG13 == companion.a()) {
                composer2 = composerK;
                StrictMode3ScreenKt$CommandProcessor$1$1 strictMode3ScreenKt$CommandProcessor$1$1 = new StrictMode3ScreenKt$CommandProcessor$1$1(context3, managedActivityResultLauncherA4, activityLauncherP, mutableState6, managedActivityResultLauncherT, managedActivityResultLauncherX, managedActivityResultLauncherV, showCooldownTimerBottomSheet, mutableState5, mutableState4, coroutineScope, mutableState2, mutableState, managedActivityResultLauncherA2, managedActivityResultLauncherA, managedActivityResultLauncherA3, scaffoldState, mutableState3, null);
                composer2.w(strictMode3ScreenKt$CommandProcessor$1$1);
                objG13 = strictMode3ScreenKt$CommandProcessor$1$1;
            } else {
                composer2 = composerK;
            }
            composerK = composer2;
            FlowExtKt.g(viewModel, null, (Function2) objG13, composerK, i7, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.f2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3ScreenKt.F(viewModel, onEvent, scaffoldState, showCooldownTimerBottomSheet, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(StrictMode3ViewModel strictMode3ViewModel, Function1 function1, ScaffoldState scaffoldState, MutableState mutableState, int i3, Composer composer, int i4) {
        E(strictMode3ViewModel, function1, scaffoldState, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, ActivityResult activityResult, PermissionRequestReason value) {
        Intrinsics.checkNotNullParameter(activityResult, "<unused var>");
        Intrinsics.checkNotNullParameter(value, "value");
        function1.invoke(new StrictMode3ViewEvent.OnMissingPermissionsChanged(value));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(Function1 function1, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
        if (activityResult.d() == -1) {
            function1.invoke(StrictMode3ViewEvent.OnActiveStateChangeButtonClicked.f121190a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(MutableState mutableState, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, Function1 function1, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
        if (activityResult.d() == -1) {
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                managedActivityResultLauncher.b(Paywall.c(Paywall.f113165a, context, new PaywallTarget.LimitScreen(PremiumFeature.STRICT_MODE_APPROVAL), "strict_mode_setup", "by_approval_button", false, false, false, null, 240, null));
            } else {
                function1.invoke(StrictMode3ViewEvent.OnActiveStateChangeButtonClicked.f121190a);
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Function1 function1, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(activityResult, "activityResult");
        if (activityResult.d() == -1) {
            Intent intentC = activityResult.c();
            Serializable serializableExtra = intentC != null ? intentC.getSerializableExtra("STRICT_MODE_DEACTIVATION") : null;
            StrictModeDeactivation strictModeDeactivation = serializableExtra instanceof StrictModeDeactivation ? (StrictModeDeactivation) serializableExtra : null;
            if (strictModeDeactivation == null) {
                strictModeDeactivation = StrictModeDeactivation.Deactivate;
            }
            function1.invoke(new StrictMode3ViewEvent.OnStrictModeDeactivation(strictModeDeactivation));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Intent intentC = it.c();
        Serializable serializableExtra = intentC != null ? intentC.getSerializableExtra("ACCESS_METHOD") : null;
        StrictModeAccessMethod strictModeAccessMethod = serializableExtra instanceof StrictModeAccessMethod ? (StrictModeAccessMethod) serializableExtra : null;
        if (strictModeAccessMethod != null) {
            Intent intentC2 = it.c();
            Serializable serializableExtra2 = intentC2 != null ? intentC2.getSerializableExtra("ACCESS_METHOD_CONFIGURATION") : null;
            List listEmptyList = serializableExtra2 instanceof ArrayList ? (ArrayList) serializableExtra2 : null;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            function1.invoke(new StrictMode3ViewEvent.OnAccessMethodConfirmed(strictModeAccessMethod, listEmptyList));
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:164:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void L(androidx.compose.material.ScaffoldState r30, kotlin.jvm.functions.Function0 r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 1032
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.strictmode3.StrictMode3ScreenKt.L(androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnActiveStateChangeButtonClicked.f121190a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(ScaffoldState scaffoldState, Function0 function0, int i3, int i4, Composer composer, int i5) {
        L(scaffoldState, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Context context, StrictMode3ViewState strictMode3ViewState) {
        context.startActivity(StrictModeInfoActivity.f121042h.a(context, strictMode3ViewState.m(), strictMode3ViewState.h()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(event, "event");
        if (WhenMappings.f121161a[event.ordinal()] == 1) {
            function1.invoke(StrictMode3ViewEvent.OnResumed.f121204a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnActivationConfirmed.f121189a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(Function1 function1) {
        function1.invoke(StrictMode3ViewEvent.OnDismissActivationConfirmationBottomSheet.f121193a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function1 function1, long j3) {
        function1.invoke(new StrictMode3ViewEvent.OnTimerValueSet(j3));
        return Unit.f139807a;
    }

    private static final ManagedActivityResultLauncher T(final Function1 function1, final MutableState mutableState, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(749172030, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.getPinCodeLauncher (StrictMode3Screen.kt:437)");
        }
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        boolean z2 = true;
        boolean z3 = (((i3 & 112) ^ 48) > 32 && composer.Z(mutableState)) || (i3 & 48) == 32;
        if ((((i3 & 14) ^ 6) <= 4 || !composer.Z(function1)) && (i3 & 6) != 4) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        Object objG = composer.G();
        if (z4 || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.n2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ScreenKt.U(mutableState, function1, (ActivityResult) obj);
                }
            };
            composer.w(objG);
        }
        ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return managedActivityResultLauncherA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(MutableState mutableState, Function1 function1, ActivityResult result) {
        Intent intentC;
        String stringExtra;
        Intrinsics.checkNotNullParameter(result, "result");
        StrictMode3ViewModel.PinCodeParams pinCodeParams = (StrictMode3ViewModel.PinCodeParams) mutableState.getValue();
        if (pinCodeParams != null) {
            if (result.d() == -1 && (intentC = result.c()) != null && (stringExtra = intentC.getStringExtra("PIN")) != null) {
                function1.invoke(new StrictMode3ViewEvent.OnPinConfirmed(pinCodeParams.a(), stringExtra, pinCodeParams.b()));
            }
            mutableState.setValue(null);
        }
        return Unit.f139807a;
    }

    private static final ManagedActivityResultLauncher V(final Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-393612034, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.getScheduleSelectLauncher (StrictMode3Screen.kt:425)");
        }
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(function1)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.h2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ScreenKt.W(function1, (ActivityResult) obj);
                }
            };
            composer.w(objG);
        }
        ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return managedActivityResultLauncherA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function1 function1, ActivityResult it) {
        long[] longArrayExtra;
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            if (intentC == null || (longArrayExtra = intentC.getLongArrayExtra("PROFILE_IDS")) == null) {
                longArrayExtra = new long[0];
            }
            Intent intentC2 = it.c();
            Serializable serializableExtra = intentC2 != null ? intentC2.getSerializableExtra("SCHEDULE_BLOCKING_MODE") : null;
            AccessMethodConfiguration.Schedules.SchedulesBlockingMode schedulesBlockingMode = serializableExtra instanceof AccessMethodConfiguration.Schedules.SchedulesBlockingMode ? (AccessMethodConfiguration.Schedules.SchedulesBlockingMode) serializableExtra : null;
            if (schedulesBlockingMode == null) {
                schedulesBlockingMode = AccessMethodConfiguration.Schedules.SchedulesBlockingMode.AllBlockings;
            }
            function1.invoke(new StrictMode3ViewEvent.OnScheduleIdsSet(longArrayExtra, schedulesBlockingMode));
        }
        return Unit.f139807a;
    }

    private static final ManagedActivityResultLauncher X(final Function1 function1, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(731667072, i3, -1, "cz.mobilesoft.coreblock.scene.strictmode3.getTimerLauncher (StrictMode3Screen.kt:418)");
        }
        ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(function1)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.g2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return StrictMode3ScreenKt.Y(function1, (ActivityResult) obj);
                }
            };
            composer.w(objG);
        }
        ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return managedActivityResultLauncherA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(Function1 function1, ActivityResult it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (it.d() == -1) {
            Intent intentC = it.c();
            function1.invoke(new StrictMode3ViewEvent.OnTimerValueSet(intentC != null ? intentC.getLongExtra("MILLIS", 0L) : 0L));
        }
        return Unit.f139807a;
    }

    private static final StrictModeConfirmationViewState Z(StrictMode3ViewState strictMode3ViewState) {
        StrictModeAccessMethod strictModeAccessMethodC = strictMode3ViewState.c();
        AccessMethodConfiguration accessMethodConfigurationD = strictMode3ViewState.d();
        ImmutableList immutableListR = strictMode3ViewState.r();
        PremiumState premiumStateS = strictMode3ViewState.s();
        String strJ = strictMode3ViewState.j();
        if (strJ.length() == 0) {
            strJ = null;
        }
        return new StrictModeConfirmationViewState(strictModeAccessMethodC, accessMethodConfigurationD, immutableListR, premiumStateS, strJ);
    }

    private static final void w(final MutableState mutableState, final MutableState mutableState2, final Function1 function1, final StrictMode3ViewState strictMode3ViewState, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        int i5;
        Composer composerK = composer.k(-183727859);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(mutableState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(mutableState2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.Z(strictMode3ViewState) ? 2048 : 1024;
        }
        int i6 = i4;
        if (composerK.r((i6 & 1171) != 1170, i6 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-183727859, i6, -1, "cz.mobilesoft.coreblock.scene.strictmode3.ApprovalBottomSheets (StrictMode3Screen.kt:461)");
            }
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                composerK.a0(-1648014763);
                boolean z2 = (i6 & 896) == 256;
                Object objG = composerK.G();
                if (z2 || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.i2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return StrictMode3ScreenKt.x(function1, (String) obj);
                        }
                    };
                    composerK.w(objG);
                }
                Function1 function12 = (Function1) objG;
                boolean z3 = (i6 & 14) == 4;
                Object objG2 = composerK.G();
                if (z3 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.j2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StrictMode3ScreenKt.y(mutableState);
                        }
                    };
                    composerK.w(objG2);
                }
                i5 = -1668832875;
                composer2 = composerK;
                StrictModeEmailInputBottomSheetKt.t(function12, (Function0) objG2, strictMode3ViewState.j(), composer2, 0, 0);
            } else {
                i5 = -1668832875;
                composer2 = composerK;
                composer2.a0(-1668832875);
            }
            composer2.U();
            if (((Boolean) mutableState2.getValue()).booleanValue()) {
                composer2.a0(-1647607454);
                boolean z4 = (i6 & 112) == 32;
                Object objG3 = composer2.G();
                if (z4 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.k2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return StrictMode3ScreenKt.z(mutableState2);
                        }
                    };
                    composer2.w(objG3);
                }
                Composer composer3 = composer2;
                StrictMode3OverviewKt.V0(function1, (Function0) objG3, strictMode3ViewState.i(), composer3, (i6 >> 6) & 14, 0);
                composer2 = composer3;
            } else {
                composer2.a0(i5);
            }
            composer2.U();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.strictmode3.m2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return StrictMode3ScreenKt.A(mutableState, mutableState2, function1, strictMode3ViewState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(Function1 function1, String email) {
        Intrinsics.checkNotNullParameter(email, "email");
        function1.invoke(new StrictMode3ViewEvent.OnApprovalEmailChanged(email));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(MutableState mutableState) {
        mutableState.setValue(Boolean.FALSE);
        return Unit.f139807a;
    }
}
