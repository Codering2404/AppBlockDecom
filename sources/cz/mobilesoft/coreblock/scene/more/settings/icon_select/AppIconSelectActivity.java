package cz.mobilesoft.coreblock.scene.more.settings.icon_select;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.enums.AppIcon;
import cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectViewEvent;
import cz.mobilesoft.coreblock.scene.schedule.emoji.IconPickerScreenKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class AppIconSelectActivity extends BaseComposeActivity {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f109892f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f109893g = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Intent a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Intent(context, (Class<?>) AppIconSelectActivity.class);
        }

        private Companion() {
        }
    }

    private final void p0(AppIconSelectViewModel appIconSelectViewModel, final MutableState mutableState, Composer composer, final int i3) {
        int i4;
        final AppIconSelectViewModel appIconSelectViewModel2;
        Composer composerK = composer.k(1984366047);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(appIconSelectViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(mutableState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(this) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1984366047, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectActivity.CommandProcessor (AppIconSelectActivity.kt:68)");
            }
            Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            boolean zI = composerK.I(this) | composerK.I(context) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new AppIconSelectActivity$CommandProcessor$1$1(this, context, mutableState, null);
                composerK.w(objG);
            }
            appIconSelectViewModel2 = appIconSelectViewModel;
            FlowExtKt.g(appIconSelectViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            appIconSelectViewModel2 = appIconSelectViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppIconSelectActivity.q0(this.f109932a, appIconSelectViewModel2, mutableState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q0(AppIconSelectActivity appIconSelectActivity, AppIconSelectViewModel appIconSelectViewModel, MutableState mutableState, int i3, Composer composer, int i4) {
        appIconSelectActivity.p0(appIconSelectViewModel, mutableState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s0(Function1 function1, AppIcon icon) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        function1.invoke(new AppIconSelectViewEvent.OnIconSelected(icon));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(AppIconSelectActivity appIconSelectActivity) {
        appIconSelectActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u0(Function1 function1) {
        function1.invoke(AppIconSelectViewEvent.OnRestartConfirmed.f109902a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(AppIconSelectActivity appIconSelectActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        appIconSelectActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(-2073317112);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2073317112, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.icon_select.AppIconSelectActivity.RootCompose (AppIconSelectActivity.kt:30)");
            }
            composerK.F(-101221098);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 8);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            CreationExtras creationExtrasA = ViewModelComposeExtKt.a(viewModelStoreOwnerC, composerK, 8);
            Scope scopeD = GlobalContext.f145907a.get().j().d();
            composerK.F(-1072256281);
            NavBackStackEntry navBackStackEntry = viewModelStoreOwnerC instanceof NavBackStackEntry ? (NavBackStackEntry) viewModelStoreOwnerC : null;
            CreationExtras creationExtrasA2 = (navBackStackEntry == null || (bundleB = navBackStackEntry.b()) == null) ? null : BundleExtKt.a(bundleB, viewModelStoreOwnerC);
            KClass kClassB = Reflection.b(AppIconSelectViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            AppIconSelectViewModel appIconSelectViewModel = (AppIconSelectViewModel) viewModelA;
            AppIconSelectViewState appIconSelectViewState = (AppIconSelectViewState) FlowExtKt.m(appIconSelectViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(appIconSelectViewModel, composerK, 0);
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            MutableState mutableState = (MutableState) objG;
            AppIcon appIconC = appIconSelectViewState.c();
            boolean z2 = !appIconSelectViewState.d();
            boolean Z = composerK.Z(function1N);
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AppIconSelectActivity.s0(function1N, (AppIcon) obj);
                    }
                };
                composerK.w(objG2);
            }
            Function1 function1 = (Function1) objG2;
            boolean zI = composerK.I(this);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppIconSelectActivity.t0(this.f109927a);
                    }
                };
                composerK.w(objG3);
            }
            IconPickerScreenKt.v(appIconC, function1, (Function0) objG3, z2, composerK, 0, 0);
            String string = getString(R.string.f95776c1);
            String strB = StringResources_androidKt.b(R.string.Yb, composerK, 0);
            String string2 = getString(R.string.Nl);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            boolean Z2 = composerK.Z(function1N);
            Object objG4 = composerK.G();
            if (Z2 || objG4 == companion.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppIconSelectActivity.u0(function1N);
                    }
                };
                composerK.w(objG4);
            }
            ComposeDialogsKt.R0(mutableState, string, strB, null, string2, (Function0) objG4, composerK, 6, 8);
            composerK = composerK;
            p0(appIconSelectViewModel, mutableState, composerK, ((i4 << 3) & 896) | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.icon_select.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppIconSelectActivity.v0(this.f109929a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
