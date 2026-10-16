package cz.mobilesoft.coreblock.scene.permission.location;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.AuthenticationToken;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.tasks.OnSuccessListener;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionEvent;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.PermissionsHeaderKt;
import cz.mobilesoft.coreblock.scene.permission.permissions.components.StepsItemKt;
import cz.mobilesoft.coreblock.service.CheckGrantedPermissionService;
import cz.mobilesoft.coreblock.util.LocationHelper;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.compose.ComposeBackgroundKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarButtonType;
import cz.mobilesoft.coreblock.view.compose.material3.ToolbarKt;
import cz.mobilesoft.coreblock.view.viewholder.StepDTO;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;

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
public final class LocationPermissionScreenKt {
    private static final void D(LocationPermissionViewModel locationPermissionViewModel, final Activity activity, Composer composer, final int i3) {
        int i4;
        final LocationPermissionViewModel locationPermissionViewModel2;
        Composer composerK = composer.k(-1790406961);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(locationPermissionViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(activity) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1790406961, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.CommandProcessor (LocationPermissionScreen.kt:494)");
            }
            boolean zI = composerK.I(activity);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new LocationPermissionScreenKt$CommandProcessor$1$1(activity, null);
                composerK.w(objG);
            }
            locationPermissionViewModel2 = locationPermissionViewModel;
            FlowExtKt.g(locationPermissionViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            locationPermissionViewModel2 = locationPermissionViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.l0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.E(locationPermissionViewModel2, activity, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(LocationPermissionViewModel locationPermissionViewModel, Activity activity, int i3, Composer composer, int i4) {
        D(locationPermissionViewModel, activity, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void F(final LocationPermissionViewState locationPermissionViewState, final Function1 function1, final ActivityResultLauncher activityResultLauncher, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(251313991);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(locationPermissionViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(activityResultLauncher) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(251313991, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.DefaultButton (LocationPermissionScreen.kt:476)");
            }
            String strB = StringResources_androidKt.b(locationPermissionViewState.j() ? R.string.l8 : R.string.Qm, composerK, 0);
            boolean zI = ((i4 & 112) == 32) | ((i4 & 14) == 4) | composerK.I(activityResultLauncher);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.q0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.G(function1, locationPermissionViewState, activityResultLauncher);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, false, false, (Function0) objG, composer2, 805306368, 0, 7615);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.r0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.H(locationPermissionViewState, function1, activityResultLauncher, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(Function1 function1, LocationPermissionViewState locationPermissionViewState, ActivityResultLauncher activityResultLauncher) {
        function1.invoke(new LocationPermissionEvent.OnGoToSettingsClick(null));
        w0(locationPermissionViewState, activityResultLauncher);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(LocationPermissionViewState locationPermissionViewState, Function1 function1, ActivityResultLauncher activityResultLauncher, int i3, Composer composer, int i4) {
        F(locationPermissionViewState, function1, activityResultLauncher, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void I(final Activity activity, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1903244861);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(activity) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1903244861, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.FallbackButton (LocationPermissionScreen.kt:422)");
            }
            String strB = StringResources_androidKt.b(R.string.Qm, composerK, 0);
            boolean zI = composerK.I(activity) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.t
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.J(activity, function1);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, false, false, (Function0) objG, composer2, 805306368, 0, 7615);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.e0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.K(activity, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(Activity activity, Function1 function1) {
        LockieApplication.r(activity);
        function1.invoke(new LocationPermissionEvent.OnGoToSettingsClick(activity.getComponentName()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(Activity activity, Function1 function1, int i3, Composer composer, int i4) {
        I(activity, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void L(final Activity activity, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-425699147);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(activity) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-425699147, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.LocationAvailabilityButton (LocationPermissionScreen.kt:457)");
            }
            String strB = StringResources_androidKt.b(R.string.Qm, composerK, 0);
            boolean zI = composerK.I(activity) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.s0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.M(function1, activity);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, false, false, (Function0) objG, composer2, 805306368, 0, 7615);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.t0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.N(activity, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M(Function1 function1, Activity activity) {
        function1.invoke(new LocationPermissionEvent.OnGoToSettingsClick(null));
        u0(activity, function1);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Activity activity, Function1 function1, int i3, Composer composer, int i4) {
        L(activity, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(Modifier modifier, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        final Modifier modifier3;
        Composer composerK = composer.k(-1496611856);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1496611856, i5, -1, "cz.mobilesoft.coreblock.scene.permission.location.LocationIntroContent (LocationPermissionScreen.kt:214)");
            }
            Modifier modifierK = PaddingKt.k(SizeKt.f(modifier4, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.location.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationPermissionScreenKt.P((LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            modifier3 = modifier4;
            LazyDslKt.b(modifierK, null, null, false, null, horizontalG, null, false, null, (Function1) objG, composerK, 805502976, 478);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.z
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.Q(modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$LocationPermissionScreenKt composableSingletons$LocationPermissionScreenKt = ComposableSingletons$LocationPermissionScreenKt.f111827a;
        LazyListScope.c(LazyColumn, "toolbar_spacer", null, composableSingletons$LocationPermissionScreenKt.C(), 2, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$LocationPermissionScreenKt.u(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$LocationPermissionScreenKt.z(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$LocationPermissionScreenKt.v(), 3, null);
        LazyListScope.c(LazyColumn, null, null, composableSingletons$LocationPermissionScreenKt.y(), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        O(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Modifier modifier, Composer composer, final int i3, final int i4) {
        final Modifier modifier2;
        int i5;
        Painter painterC;
        Composer composerK = composer.k(-684616249);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if (composerK.r((i5 & 3) != 2, i5 & 1)) {
            Modifier modifier3 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(-684616249, i5, -1, "cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionHint (LocationPermissionScreen.kt:349)");
            }
            Object[] objArr = new Object[0];
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.v0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.S();
                    }
                };
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) RememberSaveableKt.e(objArr, null, null, (Function0) objG, composerK, 0, 6);
            Modifier modifierB = AnimationModifierKt.b(PaddingKt.m(SizeKt.h(modifier3, 0.0f, 1, null), 0.0f, Dp.g(24), 0.0f, 0.0f, 13, null), null, null, 3, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierB);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            Modifier.Companion companion4 = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion4, 0.0f, 1, null);
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = InteractionSourceKt.a();
                composerK.w(objG2);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG2;
            boolean Z = composerK.Z(mutableState);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.V(mutableState);
                    }
                };
                composerK.w(objG3);
            }
            Modifier modifierD = ClickableKt.d(modifierH, mutableInteractionSource, null, false, null, null, (Function0) objG3, 28, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composerK, 48);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierD);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Painter painterC2 = PainterResources_androidKt.c(R.drawable.v2, composerK, 0);
            ColorFilter.Companion companion5 = ColorFilter.f25730b;
            ImageKt.a(painterC2, null, null, null, null, 0.0f, ColorFilter.Companion.c(companion5, ComposeColorsKt.j(composerK, 0).q(), 0, 2, null), composerK, 48, 60);
            float f3 = 8;
            Modifier modifier4 = modifier3;
            TextKt.c(StringResources_androidKt.b(R.string.K2, composerK, 0), RowScope.c(rowScopeInstance, PaddingKt.m(companion4, Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null), ComposeColorsKt.j(composerK, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composerK, MaterialTheme.f13092b).b(), composerK, 0, 0, 65528);
            composerK = composerK;
            if (T(mutableState)) {
                composerK.a0(-1129502114);
                painterC = PainterResources_androidKt.c(R.drawable.f95583z1, composerK, 0);
                composerK.U();
            } else {
                composerK.a0(-1129397892);
                painterC = PainterResources_androidKt.c(R.drawable.f95574w1, composerK, 0);
                composerK.U();
            }
            ImageKt.a(painterC, null, PaddingKt.m(companion4, Dp.g(f3), 0.0f, 0.0f, 0.0f, 14, null), null, null, 0.0f, ColorFilter.Companion.c(companion5, ComposeColorsKt.j(composerK, 0).q(), 0, 2, null), composerK, 432, 56);
            composerK.y();
            AnimatedVisibilityKt.g(columnScopeInstance, T(mutableState), null, EnterExitTransitionKt.m(null, null, false, null, 15, null), EnterExitTransitionKt.A(null, null, false, null, 15, null), null, ComposableSingletons$LocationPermissionScreenKt.f111827a.t(), composerK, 1600518, 18);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier2 = modifier4;
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.W(modifier2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState S() {
        return SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
    }

    private static final boolean T(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void U(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(MutableState mutableState) {
        U(mutableState, !T(mutableState));
        if (T(mutableState)) {
            AnswersHelper.f128199a.E2();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Modifier modifier, int i3, int i4, Composer composer, int i5) {
        R(modifier, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void X(final boolean z2, final boolean z3, final Function0 onClosed, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onClosed, "onClosed");
        Composer composerK = composer.k(-735546969);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.b(z3) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onClosed) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-735546969, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionScreen (LocationPermissionScreen.kt:87)");
            }
            boolean z4 = ((i4 & 14) == 4) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (z4 || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.c0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.Y(z2, z3);
                    }
                };
                composerK.w(objG);
            }
            Function0 function0 = (Function0) objG;
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            CreationExtras creationExtrasA2 = null;
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            if (navBackStackEntry != null && (bundleB = navBackStackEntry.b()) != null) {
                creationExtrasA2 = BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            }
            KClass kClassB = Reflection.b(LocationPermissionViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            LocationPermissionViewModel locationPermissionViewModel = (LocationPermissionViewModel) viewModelA;
            final Function1 function1N = FlowExtKt.n(locationPermissionViewModel, composerK, 0);
            LocationPermissionViewState locationPermissionViewState = (LocationPermissionViewState) FlowExtKt.m(locationPermissionViewModel, composerK, 0);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
            final Activity activity = (Activity) context;
            Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
            boolean Z = composerK.Z(function1N);
            Object objG2 = composerK.G();
            if (Z || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.d0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.Z(function1N);
                    }
                };
                composerK.w(objG2);
            }
            LifecycleEffectKt.d(event, null, (Function0) objG2, composerK, 6, 2);
            boolean z5 = (i4 & 896) == 256;
            Object objG3 = composerK.G();
            if (z5 || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.f0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.a0(onClosed);
                    }
                };
                composerK.w(objG3);
            }
            BackHandlerKt.a(false, (Function0) objG3, composerK, 0, 1);
            Unit unit = Unit.f139807a;
            boolean zI = composerK.I(context);
            Object objG4 = composerK.G();
            if (zI || objG4 == Composer.f23746a.a()) {
                objG4 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.location.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationPermissionScreenKt.b0(context, (DisposableEffectScope) obj);
                    }
                };
                composerK.w(objG4);
            }
            EffectsKt.c(unit, (Function1) objG4, composerK, 6);
            ActivityResultContracts.RequestMultiplePermissions requestMultiplePermissions = new ActivityResultContracts.RequestMultiplePermissions();
            boolean zI2 = composerK.I(activity) | composerK.I(context) | composerK.Z(function1N);
            Object objG5 = composerK.G();
            if (zI2 || objG5 == Composer.f23746a.a()) {
                objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.location.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationPermissionScreenKt.c0(activity, context, function1N, (Map) obj);
                    }
                };
                composerK.w(objG5);
            }
            ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(requestMultiplePermissions, (Function1) objG5, composerK, 0);
            D(locationPermissionViewModel, activity, composerK, 0);
            h0(context, locationPermissionViewState, function1N, managedActivityResultLauncherA, onClosed, composerK, (ManagedActivityResultLauncher.f461c << 9) | ((i4 << 6) & 57344));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.i0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.d0(z2, z3, onClosed, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder Y(boolean z2, boolean z3) {
        return ParametersHolderKt.b(Boolean.valueOf(z2), Boolean.valueOf(z3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(Function1 function1) {
        function1.invoke(LocationPermissionEvent.OnUpdatePermissionState.f111848a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a0(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult b0(final Context context, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionScreenKt$LocationPermissionScreen$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() throws Throwable {
                CheckGrantedPermissionService.f123093j.d(context);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Activity activity, Context context, Function1 function1, Map permissions) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        PermissionHelper.a(activity, permissions);
        if (PermissionHelper.e(context)) {
            function1.invoke(LocationPermissionEvent.OnAllPermissionsGranted.f111846a);
        } else {
            function1.invoke(LocationPermissionEvent.OnUpdatePermissionState.f111848a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d0(boolean z2, boolean z3, Function0 function0, int i3, Composer composer, int i4) {
        X(z2, z3, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void e0(final Activity activity, final LocationPermissionViewState locationPermissionViewState, final Function1 function1, final ActivityResultLauncher activityResultLauncher, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1741221322);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(activity) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(locationPermissionViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? 256 : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(activityResultLauncher) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1741221322, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.OldAndroidLocationButton (LocationPermissionScreen.kt:439)");
            }
            String strB = StringResources_androidKt.b(R.string.Qm, composerK, 0);
            boolean zI = ((i4 & 896) == 256) | composerK.I(activity) | ((i4 & 112) == 32) | composerK.I(activityResultLauncher);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.permission.location.o0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return LocationPermissionScreenKt.f0(function1, activity, locationPermissionViewState, activityResultLauncher);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, null, null, strB, null, 0L, null, null, false, false, (Function0) objG, composer2, 805306368, 0, 7615);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.g0(activity, locationPermissionViewState, function1, activityResultLauncher, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Function1 function1, Activity activity, LocationPermissionViewState locationPermissionViewState, ActivityResultLauncher activityResultLauncher) {
        function1.invoke(new LocationPermissionEvent.OnGoToSettingsClick(activity.getComponentName()));
        w0(locationPermissionViewState, activityResultLauncher);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(Activity activity, LocationPermissionViewState locationPermissionViewState, Function1 function1, ActivityResultLauncher activityResultLauncher, int i3, Composer composer, int i4) {
        e0(activity, locationPermissionViewState, function1, activityResultLauncher, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void h0(final Context context, final LocationPermissionViewState locationPermissionViewState, final Function1 function1, final ActivityResultLauncher activityResultLauncher, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(244514235);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(context) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(locationPermissionViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(activityResultLauncher) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(244514235, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.Screen (LocationPermissionScreen.kt:141)");
            }
            composer2 = composerK;
            ComposeBackgroundKt.m(null, false, false, false, null, 0L, null, ComposableLambdaKt.e(-525439507, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.j0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LocationPermissionScreenKt.i0(locationPermissionViewState, context, function1, activityResultLauncher, function0, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 12582912, 127);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.k0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.l0(context, locationPermissionViewState, function1, activityResultLauncher, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i0(final LocationPermissionViewState locationPermissionViewState, final Context context, final Function1 function1, final ActivityResultLauncher activityResultLauncher, final Function0 function0, BoxScope GradientBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(GradientBox, "$this$GradientBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-525439507, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.Screen.<anonymous> (LocationPermissionScreen.kt:143)");
            }
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.b(WindowInsets.f7172a, composer, 6)), null, null, ComposableLambdaKt.e(1487722291, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.m0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.j0(locationPermissionViewState, context, function1, activityResultLauncher, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, Color.f25715b.j(), 0L, ComposableLambdaKt.e(209470763, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.n0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return LocationPermissionScreenKt.k0(locationPermissionViewState, context, function0, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 3072, 12779520, 98294);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j0(LocationPermissionViewState locationPermissionViewState, Context context, Function1 function1, ActivityResultLauncher activityResultLauncher, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1487722291, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.Screen.<anonymous>.<anonymous> (LocationPermissionScreen.kt:148)");
            }
            Modifier modifierM = PaddingKt.m(PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.g(16), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (!locationPermissionViewState.j()) {
                composer.a0(1213653910);
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                I((Activity) context, function1, composer, 0);
                composer.U();
            } else if (RunnabilityHelper.f129617a.s() && !locationPermissionViewState.g() && locationPermissionViewState.h()) {
                composer.a0(1214014316);
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                e0((Activity) context, locationPermissionViewState, function1, activityResultLauncher, composer, 0);
                composer.U();
            } else if (locationPermissionViewState.e()) {
                composer.a0(1214772607);
                F(locationPermissionViewState, function1, activityResultLauncher, composer, 0);
                composer.U();
            } else {
                composer.a0(1214480618);
                Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
                L((Activity) context, function1, composer, 0);
                composer.U();
            }
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k0(LocationPermissionViewState locationPermissionViewState, Context context, Function0 function0, PaddingValues paddingValues, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(paddingValues) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(209470763, i4, -1, "cz.mobilesoft.coreblock.scene.permission.location.Screen.<anonymous>.<anonymous> (LocationPermissionScreen.kt:186)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = PaddingKt.h(companion, paddingValues);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A);
            } else {
                composer.v();
            }
            Composer composerA = Updater.a(composer);
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (locationPermissionViewState.i(context).isEmpty()) {
                composer.a0(917842051);
                O(null, composer, 0, 1);
                composer.U();
            } else {
                composer.a0(917934803);
                m0(companion, locationPermissionViewState.f(context), locationPermissionViewState.i(context), locationPermissionViewState.k(), composer, 6, 0);
                composer.U();
            }
            ToolbarKt.e(null, function0, null, locationPermissionViewState.d(), ToolbarButtonType.Close, false, false, null, null, composer, 24576, 485);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l0(Context context, LocationPermissionViewState locationPermissionViewState, Function1 function1, ActivityResultLauncher activityResultLauncher, Function0 function0, int i3, Composer composer, int i4) {
        h0(context, locationPermissionViewState, function1, activityResultLauncher, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(Modifier modifier, final String str, final List list, final boolean z2, Composer composer, final int i3, final int i4) {
        Modifier modifier2;
        int i5;
        Composer composer2;
        final Modifier modifier3;
        Composer composerK = composer.k(482344809);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            modifier2 = modifier;
        } else if ((i3 & 6) == 0) {
            modifier2 = modifier;
            i5 = (composerK.Z(modifier2) ? 4 : 2) | i3;
        } else {
            modifier2 = modifier;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.Z(str) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerK.I(list) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerK.b(z2) ? 2048 : 1024;
        }
        if (composerK.r((i5 & 1171) != 1170, i5 & 1)) {
            Modifier modifier4 = i6 != 0 ? Modifier.b8 : modifier2;
            if (ComposerKt.M()) {
                ComposerKt.U(482344809, i5, -1, "cz.mobilesoft.coreblock.scene.permission.location.StepsContent (LocationPermissionScreen.kt:291)");
            }
            final boolean zBooleanValue = ((Boolean) composerK.q(InspectionModeKt.a())).booleanValue();
            Modifier modifierK = PaddingKt.k(SizeKt.h(modifier4, 0.0f, 1, null), Dp.g(16), 0.0f, 2, null);
            Alignment.Horizontal horizontalG = Alignment.f25072a.g();
            boolean zB = ((i5 & 112) == 32) | composerK.b(zBooleanValue) | composerK.I(list) | ((i5 & 7168) == 2048);
            Object objG = composerK.G();
            if (zB || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.permission.location.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LocationPermissionScreenKt.n0(zBooleanValue, list, z2, str, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            Modifier modifier5 = modifier4;
            composer2 = composerK;
            LazyDslKt.b(modifierK, null, null, false, null, horizontalG, null, false, null, (Function1) objG, composer2, 196608, 478);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
            modifier3 = modifier5;
        } else {
            composer2 = composerK;
            composer2.Q();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.q0(modifier3, str, list, z2, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n0(boolean z2, final List list, boolean z3, final String str, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        ComposableSingletons$LocationPermissionScreenKt composableSingletons$LocationPermissionScreenKt = ComposableSingletons$LocationPermissionScreenKt.f111827a;
        LazyListScope.c(LazyColumn, "toolbar_spacer", null, composableSingletons$LocationPermissionScreenKt.A(), 2, null);
        LazyListScope.c(LazyColumn, AuthenticationToken.HEADER_KEY, null, ComposableLambdaKt.c(-472313739, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.permission.location.a0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return LocationPermissionScreenKt.o0(str, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 2, null);
        if (!z2 && !list.isEmpty()) {
            LazyListScope.c(LazyColumn, null, null, composableSingletons$LocationPermissionScreenKt.x(), 3, null);
            final Function2 function2 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.permission.location.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return LocationPermissionScreenKt.p0(((Integer) obj).intValue(), (StepDTO) obj2);
                }
            };
            LazyColumn.h(list.size(), new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionScreenKt$StepsContent$lambda$0$0$$inlined$itemsIndexed$default$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    return function2.invoke(Integer.valueOf(i3), list.get(i3));
                }
            }, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionScreenKt$StepsContent$lambda$0$0$$inlined$itemsIndexed$default$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return invoke(((Number) obj).intValue());
                }

                public final Object invoke(int i3) {
                    list.get(i3);
                    return null;
                }
            }, ComposableLambdaKt.c(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.permission.location.LocationPermissionScreenKt$StepsContent$lambda$0$0$$inlined$itemsIndexed$default$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(4);
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((LazyItemScope) obj, ((Number) obj2).intValue(), (Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(LazyItemScope lazyItemScope, int i3, Composer composer, int i4) {
                    int i5;
                    if ((i4 & 6) == 0) {
                        i5 = (composer.Z(lazyItemScope) ? 4 : 2) | i4;
                    } else {
                        i5 = i4;
                    }
                    if ((i4 & 48) == 0) {
                        i5 |= composer.e(i3) ? 32 : 16;
                    }
                    if (!composer.r((i5 & 147) != 146, i5 & 1)) {
                        composer.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1091073711, i5, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                    }
                    StepDTO stepDTO = (StepDTO) list.get(i3);
                    composer.a0(1334051180);
                    Modifier.Companion companion = Modifier.b8;
                    StepsItemKt.c(SizeKt.h(companion, 0.0f, 1, null), stepDTO.a(), stepDTO.b().toString(), composer, 6, 0);
                    if (i3 < CollectionsKt.getLastIndex(list)) {
                        composer.a0(1334278936);
                        SpacerKt.a(SizeKt.i(companion, Dp.g(8)), composer, 6);
                    } else {
                        composer.a0(1320981672);
                    }
                    composer.U();
                    composer.U();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }));
        }
        if (z3) {
            LazyListScope.c(LazyColumn, ViewHierarchyConstants.HINT_KEY, null, composableSingletons$LocationPermissionScreenKt.w(), 2, null);
        }
        LazyListScope.c(LazyColumn, "bottom_spacer", null, composableSingletons$LocationPermissionScreenKt.B(), 2, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o0(String str, LazyItemScope item, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-472313739, i3, -1, "cz.mobilesoft.coreblock.scene.permission.location.StepsContent.<anonymous>.<anonymous>.<anonymous> (LocationPermissionScreen.kt:310)");
            }
            PermissionsHeaderKt.e(false, StringResources_androidKt.b(R.string.fj, composer, 0), StringResources_androidKt.b(R.string.Zt, composer, 0), str, composer, 0, 1);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object p0(int i3, StepDTO step) {
        Intrinsics.checkNotNullParameter(step, "step");
        return Integer.valueOf(step.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(Modifier modifier, String str, List list, boolean z2, int i3, int i4, Composer composer, int i5) {
        m0(modifier, str, list, z2, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    private static final void u0(Activity activity, final Function1 function1) {
        LocationHelper.b(activity, new OnSuccessListener() { // from class: cz.mobilesoft.coreblock.scene.permission.location.u0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                LocationPermissionScreenKt.v0(function1, (LocationSettingsResponse) obj);
            }
        }, 901);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(Function1 function1, LocationSettingsResponse locationSettingsResponse) {
        function1.invoke(LocationPermissionEvent.OnUpdatePermissionState.f111848a);
    }

    private static final void w0(LocationPermissionViewState locationPermissionViewState, ActivityResultLauncher activityResultLauncher) {
        String[] strArrD = locationPermissionViewState.k() ? PermissionHelper.d() : PermissionHelper.b();
        Intrinsics.checkNotNull(strArrD);
        activityResultLauncher.b(strArrD);
    }
}
