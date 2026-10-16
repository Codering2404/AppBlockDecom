package androidx.navigation.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.SaveableStateHolder;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.InitializerViewModelFactoryBuilder;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.compose.internal.WeakReference;
import androidx.savedstate.compose.LocalSavedStateRegistryOwnerKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class NavBackStackEntryProviderKt {
    public static final void d(final NavBackStackEntry navBackStackEntry, final SaveableStateHolder saveableStateHolder, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(233973821);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(navBackStackEntry) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(saveableStateHolder) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(233973821, i4, -1, "androidx.navigation.compose.LocalOwnersProvider (NavBackStackEntryProvider.kt:49)");
            }
            CompositionLocalKt.c(new ProvidedValue[]{LocalViewModelStoreOwner.f40240a.d(navBackStackEntry), LocalLifecycleOwnerKt.c().d(navBackStackEntry), LocalSavedStateRegistryOwnerKt.c().d(navBackStackEntry)}, ComposableLambdaKt.e(1808964477, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.navigation.compose.NavBackStackEntryProviderKt$LocalOwnersProvider$1
                public final void c(Composer composer2, int i5) {
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1808964477, i5, -1, "androidx.navigation.compose.LocalOwnersProvider.<anonymous> (NavBackStackEntryProvider.kt:55)");
                    }
                    NavBackStackEntryProviderKt.f(saveableStateHolder, function2, composer2, 0);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }
            }, composerK, 54), composerK, ProvidedValue.f24012i | 48);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: androidx.navigation.compose.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavBackStackEntryProviderKt.e(navBackStackEntry, saveableStateHolder, function2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e(NavBackStackEntry navBackStackEntry, SaveableStateHolder saveableStateHolder, Function2 function2, int i3, Composer composer, int i4) {
        d(navBackStackEntry, saveableStateHolder, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(final SaveableStateHolder saveableStateHolder, final Function2 function2, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(832919318);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(saveableStateHolder) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function2) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(832919318, i4, -1, "androidx.navigation.compose.SaveableStateProvider (NavBackStackEntryProvider.kt:60)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: androidx.navigation.compose.g
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NavBackStackEntryProviderKt.g((CreationExtras) obj);
                    }
                };
                composerK.w(objG);
            }
            Function1 function1 = (Function1) objG;
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composerK, 6);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            KClass kClassB = Reflection.b(BackStackEntryIdViewModel.class);
            InitializerViewModelFactoryBuilder initializerViewModelFactoryBuilder = new InitializerViewModelFactoryBuilder();
            initializerViewModelFactoryBuilder.a(Reflection.b(BackStackEntryIdViewModel.class), function1);
            BackStackEntryIdViewModel backStackEntryIdViewModel = (BackStackEntryIdViewModel) ViewModelKt.b(kClassB, viewModelStoreOwnerC, null, initializerViewModelFactoryBuilder.b(), viewModelStoreOwnerC instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwnerC).getDefaultViewModelCreationExtras() : CreationExtras.Empty.f40230c, composerK, 0, 0);
            backStackEntryIdViewModel.A0(new WeakReference(saveableStateHolder));
            saveableStateHolder.d(backStackEntryIdViewModel.y0(), function2, composerK, ((i4 << 6) & 896) | (i4 & 112));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: androidx.navigation.compose.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NavBackStackEntryProviderKt.h(saveableStateHolder, function2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BackStackEntryIdViewModel g(CreationExtras creationExtras) {
        return new BackStackEntryIdViewModel(SavedStateHandleSupport.a(creationExtras));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(SaveableStateHolder saveableStateHolder, Function2 function2, int i3, Composer composer, int i4) {
        f(saveableStateHolder, function2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
