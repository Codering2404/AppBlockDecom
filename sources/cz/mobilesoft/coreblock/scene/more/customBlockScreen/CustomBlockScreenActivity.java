package cz.mobilesoft.coreblock.scene.more.customBlockScreen;

import android.os.Bundle;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavBackStackEntryKt;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockingViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.core.ConfigType;
import cz.mobilesoft.coreblock.storage.room.entity.core.CustomBlockingScreenConfigEntity;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.koin.androidx.compose.ViewModelComposeExtKt;
import org.koin.androidx.viewmodel.GetViewModelKt;
import org.koin.androidx.viewmodel.ext.android.BundleExtKt;
import org.koin.core.context.GlobalContext;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class CustomBlockScreenActivity extends BaseComposeActivity {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f107064a;

        static {
            int[] iArr = new int[ConfigType.values().length];
            try {
                iArr[ConfigType.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfigType.ROTATING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f107064a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(CustomBlockingViewState customBlockingViewState, Function1 function1, final CustomBlockScreenActivity customBlockScreenActivity, final NavHostController navHostController, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        if (ComposerKt.M()) {
            ComposerKt.U(2086651644, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockScreenActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (CustomBlockScreenActivity.kt:43)");
        }
        boolean zI = composer.I(customBlockScreenActivity);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.m
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CustomBlockScreenActivity.B0(this.f107280a);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean zI2 = composer.I(navHostController);
        Object objG2 = composer.G();
        if (zI2 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomBlockScreenActivity.C0(navHostController, (CustomBlockingScreenConfigEntity) obj);
                }
            };
            composer.w(objG2);
        }
        CustomBlockingScreenKt.B(customBlockingViewState, function1, function0, (Function1) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(CustomBlockScreenActivity customBlockScreenActivity) {
        customBlockScreenActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C0(NavHostController navHostController, CustomBlockingScreenConfigEntity customBlockingScreenConfigEntity) {
        ConfigType configTypeM = customBlockingScreenConfigEntity != null ? customBlockingScreenConfigEntity.m() : null;
        int i3 = configTypeM == null ? -1 : WhenMappings.f107064a[configTypeM.ordinal()];
        if (i3 == 1 || i3 == 2) {
            NavController.O(navHostController, new NavCustomizeScreen(customBlockingScreenConfigEntity.i()), null, null, 6, null);
        } else {
            NavController.O(navHostController, new NavCustomConfigDetail(customBlockingScreenConfigEntity != null ? customBlockingScreenConfigEntity.i() : null), null, null, 6, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D0(CustomBlockingViewState customBlockingViewState, final NavHostController navHostController, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry backstackEntry, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(backstackEntry, "backstackEntry");
        if (ComposerKt.M()) {
            ComposerKt.U(-1215682637, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockScreenActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (CustomBlockScreenActivity.kt:62)");
        }
        NavCustomizeScreen navCustomizeScreen = (NavCustomizeScreen) NavBackStackEntryKt.a(backstackEntry, Reflection.b(NavCustomizeScreen.class));
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.o
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CustomBlockScreenActivity.E0(navHostController);
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        boolean Z = composer.Z(function1);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomBlockScreenActivity.F0(function1, (CustomBlockingScreenConfigEntity) obj);
                }
            };
            composer.w(objG2);
        }
        PreferencesScreenKt.q(customBlockingViewState, function0, (Function1) objG2, navCustomizeScreen.a(), null, composer, 0, 16);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E0(NavHostController navHostController) {
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F0(Function1 function1, CustomBlockingScreenConfigEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new CustomBlockingViewEvent.OnConfigUpdated(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G0(CustomBlockingViewState customBlockingViewState, final NavHostController navHostController, final Function1 function1, AnimatedContentScope composable, NavBackStackEntry backstackEntry, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(backstackEntry, "backstackEntry");
        if (ComposerKt.M()) {
            ComposerKt.U(50388148, i3, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockScreenActivity.RootCompose.<anonymous>.<anonymous>.<anonymous> (CustomBlockScreenActivity.kt:75)");
        }
        NavCustomConfigDetail navCustomConfigDetail = (NavCustomConfigDetail) NavBackStackEntryKt.a(backstackEntry, Reflection.b(NavCustomConfigDetail.class));
        boolean zI = composer.I(navHostController);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(CustomBlockScreenActivity.H0(navHostController));
                }
            };
            composer.w(objG);
        }
        Function0 function0 = (Function0) objG;
        String strA = navCustomConfigDetail.a();
        boolean Z = composer.Z(function1) | composer.I(navHostController);
        Object objG2 = composer.G();
        if (Z || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return CustomBlockScreenActivity.I0(function1, navHostController, (CustomBlockingScreenConfigEntity) obj);
                }
            };
            composer.w(objG2);
        }
        CustomConfigDetailScreenKt.F(customBlockingViewState, function0, strA, (Function1) objG2, composer, 0, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H0(NavHostController navHostController) {
        return navHostController.R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I0(Function1 function1, NavHostController navHostController, CustomBlockingScreenConfigEntity it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new CustomBlockingViewEvent.OnConfigUpdated(it));
        navHostController.R();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J0(CustomBlockScreenActivity customBlockScreenActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        customBlockScreenActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void x0(CustomBlockingViewModel customBlockingViewModel, Composer composer, final int i3) {
        int i4;
        final CustomBlockingViewModel customBlockingViewModel2;
        Composer composerK = composer.k(-1080270567);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(customBlockingViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(this) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1080270567, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockScreenActivity.CommandProcessor (CustomBlockScreenActivity.kt:92)");
            }
            boolean zI = composerK.I(this);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new CustomBlockScreenActivity$CommandProcessor$1$1(this, null);
                composerK.w(objG);
            }
            customBlockingViewModel2 = customBlockingViewModel;
            FlowExtKt.g(customBlockingViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            customBlockingViewModel2 = customBlockingViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomBlockScreenActivity.y0(this.f107222a, customBlockingViewModel2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(CustomBlockScreenActivity customBlockScreenActivity, CustomBlockingViewModel customBlockingViewModel, int i3, Composer composer, int i4) {
        customBlockScreenActivity.x0(customBlockingViewModel, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(final CustomBlockingViewState customBlockingViewState, final Function1 function1, final CustomBlockScreenActivity customBlockScreenActivity, final NavHostController navHostController, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        ComposableLambda composableLambdaC = ComposableLambdaKt.c(2086651644, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.j
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomBlockScreenActivity.A0(customBlockingViewState, function1, customBlockScreenActivity, navHostController, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavCustomBlockingOverview.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC);
        ComposableLambda composableLambdaC2 = ComposableLambdaKt.c(-1215682637, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.k
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomBlockScreenActivity.D0(customBlockingViewState, navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavCustomizeScreen.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC2);
        ComposableLambda composableLambdaC3 = ComposableLambdaKt.c(50388148, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.l
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return CustomBlockScreenActivity.G0(customBlockingViewState, navHostController, function1, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        });
        NavGraphBuilderKt.b(NavHost, Reflection.b(NavCustomConfigDetail.class), MapsKt.emptyMap(), CollectionsKt.emptyList(), null, null, null, null, null, composableLambdaC3);
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(561688187);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(561688187, i4, -1, "cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockScreenActivity.RootCompose (CustomBlockScreenActivity.kt:28)");
            }
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
            KClass kClassB = Reflection.b(CustomBlockingViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            CustomBlockingViewModel customBlockingViewModel = (CustomBlockingViewModel) viewModelA;
            final Function1 function1N = FlowExtKt.n(customBlockingViewModel, composerK, 0);
            final CustomBlockingViewState customBlockingViewState = (CustomBlockingViewState) FlowExtKt.m(customBlockingViewModel, composerK, 0);
            final NavHostController navHostControllerB = NavHostControllerKt.b(new Navigator[0], composerK, 0);
            x0(customBlockingViewModel, composerK, i4 & 112);
            NavCustomBlockingOverview navCustomBlockingOverview = NavCustomBlockingOverview.INSTANCE;
            boolean Z = composerK.Z(customBlockingViewState) | composerK.Z(function1N) | composerK.I(this) | composerK.I(navHostControllerB);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CustomBlockScreenActivity.z0(customBlockingViewState, function1N, this, navHostControllerB, (NavGraphBuilder) obj);
                    }
                };
                composerK.w(objG);
            }
            composer2 = composerK;
            NavHostKt.u(navHostControllerB, navCustomBlockingOverview, null, null, null, null, null, null, null, null, null, (Function1) objG, composer2, 0, 0, 2044);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.customBlockScreen.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CustomBlockScreenActivity.J0(this.f107211a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
