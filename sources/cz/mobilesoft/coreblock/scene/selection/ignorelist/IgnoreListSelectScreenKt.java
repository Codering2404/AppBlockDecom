package cz.mobilesoft.coreblock.scene.selection.ignorelist;

import android.os.Bundle;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionScreenKt;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewModel;
import cz.mobilesoft.coreblock.scene.selection.base.BaseSelectionViewState;
import cz.mobilesoft.coreblock.scene.selection.components.TabItem;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
public final class IgnoreListSelectScreenKt {
    public static final void c(final BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO, final Function4 onApplicationsWebsitesSelected, final Function0 onCloseClicked, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(applicationWebsiteSelectDTO, "applicationWebsiteSelectDTO");
        Intrinsics.checkNotNullParameter(onApplicationsWebsitesSelected, "onApplicationsWebsitesSelected");
        Intrinsics.checkNotNullParameter(onCloseClicked, "onCloseClicked");
        Composer composerK = composer.k(1447492777);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(applicationWebsiteSelectDTO) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onApplicationsWebsitesSelected) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onCloseClicked) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1447492777, i4, -1, "cz.mobilesoft.coreblock.scene.selection.ignorelist.IgnoreListSelectScreen (IgnoreListSelectScreen.kt:21)");
            }
            boolean zI = composerK.I(applicationWebsiteSelectDTO);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.selection.ignorelist.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return IgnoreListSelectScreenKt.d(applicationWebsiteSelectDTO);
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
            KClass kClassB = Reflection.b(IgnoreListSelectViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, function0);
            composerK.Y();
            composerK.Y();
            IgnoreListSelectViewModel ignoreListSelectViewModel = (IgnoreListSelectViewModel) viewModelA;
            int i5 = i4 << 9;
            BaseSelectionScreenKt.p0(ignoreListSelectViewModel, (BaseSelectionViewState) FlowExtKt.m(ignoreListSelectViewModel, composerK, 0), StringResources_androidKt.b(R.string.Sd, composerK, 0), TabItem.Companion.a(), onApplicationsWebsitesSelected, onCloseClicked, true, false, false, null, 0.0f, composerK, (57344 & i5) | 1572864 | (i5 & 458752), 0, 1920);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.selection.ignorelist.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return IgnoreListSelectScreenKt.e(applicationWebsiteSelectDTO, onApplicationsWebsitesSelected, onCloseClicked, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParametersHolder d(BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO) {
        return ParametersHolderKt.b(applicationWebsiteSelectDTO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(BaseSelectionViewModel.ApplicationWebsiteSelectDTO applicationWebsiteSelectDTO, Function4 function4, Function0 function0, int i3, Composer composer, int i4) {
        c(applicationWebsiteSelectDTO, function4, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
