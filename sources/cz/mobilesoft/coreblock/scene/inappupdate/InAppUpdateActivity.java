package cz.mobilesoft.coreblock.scene.inappupdate;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.ProgressIndicatorKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateViewEvent;
import cz.mobilesoft.coreblock.util.FailedWithError;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.ViewModelState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ErrorPlaceholderKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.android.ext.android.AndroidKoinScopeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.Qualifier;
import org.koin.core.scope.Scope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class InAppUpdateActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f102432h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f102433i = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lazy f102434f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Lazy f102435g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context, String source) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(source, "source");
            Intent intent = new Intent(context, (Class<?>) InAppUpdateActivity.class);
            intent.putExtra("SOURCE", source);
            return intent;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InAppUpdateActivity() {
        final Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return InAppUpdateActivity.z0(this.f102462a);
            }
        };
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.f139763c;
        final Qualifier qualifier = null;
        final Object[] objArr = 0 == true ? 1 : 0;
        this.f102434f = LazyKt.a(lazyThreadSafetyMode, new Function0<InAppUpdateViewModel>() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity$special$$inlined$viewModel$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final ViewModel invoke() {
                CreationExtras defaultViewModelCreationExtras;
                ComponentActivity componentActivity = this;
                Qualifier qualifier2 = qualifier;
                Function0 function02 = objArr;
                Function0 function03 = function0;
                ViewModelStore viewModelStore = componentActivity.getViewModelStore();
                if (function02 == null || (defaultViewModelCreationExtras = (CreationExtras) function02.invoke()) == null) {
                    defaultViewModelCreationExtras = componentActivity.getDefaultViewModelCreationExtras();
                    Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "this.defaultViewModelCreationExtras");
                }
                CreationExtras creationExtras = defaultViewModelCreationExtras;
                Scope scopeA = AndroidKoinScopeExtKt.a(componentActivity);
                KClass kClassB = Reflection.b(InAppUpdateViewModel.class);
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStore");
                return GetViewModelKt.b(kClassB, viewModelStore, null, creationExtras, qualifier2, scopeA, function03, 4, null);
            }
        });
        LazyThreadSafetyMode lazyThreadSafetyMode2 = LazyThreadSafetyMode.f139761a;
        final Object[] objArr2 = 0 == true ? 1 : 0;
        final Object[] objArr3 = 0 == true ? 1 : 0;
        this.f102435g = LazyKt.a(lazyThreadSafetyMode2, new Function0<AppUpdateManager>() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity$special$$inlined$inject$default$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ComponentCallbacks componentCallbacks = this;
                return AndroidKoinScopeExtKt.a(componentCallbacks).e(Reflection.b(AppUpdateManager.class), objArr2, objArr3);
            }
        });
    }

    private final void p0(final InAppUpdateViewState inAppUpdateViewState, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(24685593);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(inAppUpdateViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        int i5 = i4;
        if (composerK.r((i5 & 147) != 146, i5 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(24685593, i5, -1, "cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity.Content (InAppUpdateActivity.kt:103)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95486t, composerK, 0), 0.0f, 2, null), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierF3 = boxScopeInstance.f(companion, companion2.o());
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return InAppUpdateActivity.q0(this.f102466a);
                    }
                };
                composerK.w(objG);
            }
            ComposeButtonsKt.o0(modifierF3, null, 0, (Function0) objG, composerK, 0, 6);
            Modifier modifierF4 = boxScopeInstance.f(PaddingKt.k(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), 0.0f, 2, null), companion2.e());
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF5 = ComposedModifierKt.f(composerK, modifierF4);
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
            Updater.e(composerA2, measurePolicyG2, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF5, companion3.f());
            ViewModelState viewModelStateB = inAppUpdateViewState.b();
            if (Intrinsics.areEqual(viewModelStateB, Loading.f127895a)) {
                composerK.a0(721861838);
                ProgressIndicatorKt.b(SizeKt.v(boxScopeInstance.f(companion, companion2.e()), Dp.g(100)), 0L, 0.0f, 0L, 0, composerK, 0, 30);
                composerK = composerK;
                composerK.U();
            } else if (viewModelStateB instanceof FailedWithError) {
                composerK.a0(-1777819562);
                String strD = ((FailedWithError) inAppUpdateViewState.b()).d();
                boolean z2 = (i5 & 112) == 32;
                Object objG2 = composerK.G();
                if (z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.d
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return InAppUpdateActivity.s0(function1);
                        }
                    };
                    composerK.w(objG2);
                }
                ErrorPlaceholderKt.c(null, null, strD, (Function0) objG2, composerK, 0, 3);
                composerK.U();
            } else {
                composerK.a0(722309788);
                composerK.U();
            }
            composerK.y();
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InAppUpdateActivity.t0(this.f102468a, inAppUpdateViewState, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(InAppUpdateActivity inAppUpdateActivity) {
        inAppUpdateActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Function1 function1) {
        function1.invoke(InAppUpdateViewEvent.Reload.f102448a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(InAppUpdateActivity inAppUpdateActivity, InAppUpdateViewState inAppUpdateViewState, Function1 function1, int i3, Composer composer, int i4) {
        inAppUpdateActivity.p0(inAppUpdateViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(InAppUpdateActivity inAppUpdateActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        inAppUpdateActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final AppUpdateManager w0() {
        return (AppUpdateManager) this.f102435g.getValue();
    }

    private final InAppUpdateViewModel x0() {
        return (InAppUpdateViewModel) this.f102434f.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y0(AppUpdateInfo appUpdateInfo, Function1 function1) {
        AnswersHelper answersHelper = AnswersHelper.f128199a;
        answersHelper.i2(appUpdateInfo.a());
        if (w0().c(appUpdateInfo, 1, this, 956)) {
            return;
        }
        answersHelper.d2(Integer.valueOf(appUpdateInfo.a()));
        function1.invoke(InAppUpdateViewEvent.OnFailed.f102447a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder z0(InAppUpdateActivity inAppUpdateActivity) {
        return ParametersHolderKt.b(inAppUpdateActivity.getIntent().getStringExtra("SOURCE"));
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1960521053);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1960521053, i4, -1, "cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity.RootCompose (InAppUpdateActivity.kt:88)");
            }
            InAppUpdateViewState inAppUpdateViewState = (InAppUpdateViewState) FlowExtKt.m(x0(), composerK, 0);
            Function1 function1N = FlowExtKt.n(x0(), composerK, 0);
            p0(inAppUpdateViewState, function1N, composerK, (i4 << 3) & 896);
            AppUpdateInfo appUpdateInfoW0 = x0().W0();
            boolean zI = composerK.I(appUpdateInfoW0) | composerK.I(this) | composerK.Z(function1N);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new InAppUpdateActivity$RootCompose$1$1(appUpdateInfoW0, this, function1N, null);
                composerK.w(objG);
            }
            EffectsKt.g(appUpdateInfoW0, (Function2) objG, composerK, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.inappupdate.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return InAppUpdateActivity.u0(this.f102463a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i3, int i4, Intent intent) {
        if (i3 != 956) {
            super.onActivityResult(i3, i4, intent);
            return;
        }
        if (i4 == -1) {
            finish();
            return;
        }
        if (i4 != 0) {
            if (i4 != 1) {
                return;
            }
            x0().a1();
        } else {
            AnswersHelper answersHelper = AnswersHelper.f128199a;
            AppUpdateInfo appUpdateInfoW0 = x0().W0();
            answersHelper.Z1(appUpdateInfoW0 != null ? Integer.valueOf(appUpdateInfoW0.a()) : null);
            finish();
        }
    }
}
