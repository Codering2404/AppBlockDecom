package cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist;

import android.os.Bundle;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.collections.immutable.ImmutableList;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class BrowsersListScreenKt {
    private static final void g(final BrowserState browserState, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        long jM;
        long jK;
        Composer composerK = composer.k(823134624);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(browserState) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(823134624, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowserRow (BrowsersListScreen.kt:112)");
            }
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = arrangement.e();
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composerK, 0), Dp.g(8));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyB = RowKt.b(horizontalOrVerticalE, companion2.l(), composerK, 6);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierJ);
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
            Updater.e(composerA, measurePolicyB, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            float f3 = 4;
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(f3));
            Modifier modifierM = PaddingKt.m(companion, 0.0f, 0.0f, Dp.g(16), 0.0f, 11, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.k(), composerK, 6);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierM);
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
            Updater.e(composerA2, measurePolicyA, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strA = browserState.a();
            if (strA == null) {
                strA = browserState.b();
            }
            TextKt.c(strA, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composerK, 0, 0, 65534);
            Composer composer3 = composerK;
            if (browserState.a() != null) {
                composer3.a0(-1039891638);
                TextKt.c(browserState.b(), null, ComposeColorsKt.j(composer3, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer3, 0).b(), composer3, 0, 0, 65530);
                composer3 = composer3;
            } else {
                composer3.a0(-1045020836);
            }
            composer3.U();
            composer3.y();
            MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement.o(Dp.g(f3)), companion2.j(), composer3, 54);
            int iA3 = ComposablesKt.a(composer3, 0);
            CompositionLocalMap compositionLocalMapU3 = composer3.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer3, companion);
            Function0 function0A3 = companion3.a();
            if (composer3.m() == null) {
                ComposablesKt.c();
            }
            composer3.L();
            if (composer3.i()) {
                composer3.P(function0A3);
            } else {
                composer3.v();
            }
            Composer composerA3 = Updater.a(composer3);
            Updater.e(composerA3, measurePolicyA2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            String strB = StringResources_androidKt.b(browserState.c() ? R.string.la : R.string.pa, composer3, 0);
            TextStyle textStyleD = ComposeTypographyKt.g(composer3, 0).d();
            if (browserState.c()) {
                composer3.a0(-811899819);
                jM = ComposeColorsKt.j(composer3, 0).b();
            } else {
                composer3.a0(-811899205);
                jM = ComposeColorsKt.j(composer3, 0).M();
            }
            composer3.U();
            Composer composer4 = composer3;
            TextKt.c(strB, null, jM, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD, composer4, 0, 0, 65530);
            String strB2 = StringResources_androidKt.b(browserState.d() ? R.string.Ab : R.string.qa, composer4, 0);
            TextStyle textStyleD2 = ComposeTypographyKt.g(composer4, 0).d();
            if (browserState.d()) {
                composer4.a0(-811889772);
                jK = ComposeColorsKt.j(composer4, 0).A();
            } else {
                composer4.a0(-811889193);
                jK = ComposeColorsKt.j(composer4, 0).k();
            }
            composer4.U();
            composer2 = composer4;
            TextKt.c(strB2, null, jK, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, textStyleD2, composer2, 0, 0, 65530);
            composer2.y();
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowsersListScreenKt.h(browserState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h(BrowserState browserState, int i3, Composer composer, int i4) {
        g(browserState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void i(final Function0 onCloseClick, Composer composer, final int i3) {
        int i4;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerK = composer.k(-1175258018);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCloseClick) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1175258018, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.BrowsersListScreen (BrowsersListScreen.kt:63)");
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
            KClass kClassB = Reflection.b(BrowsersListViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            k(((BrowsersListViewState) FlowExtKt.m((BrowsersListViewModel) viewModelA, composerK, 0)).b(), onCloseClick, composerK, (i4 << 3) & 112);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowsersListScreenKt.j(onCloseClick, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(Function0 function0, int i3, Composer composer, int i4) {
        i(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(final ImmutableList immutableList, final Function0 function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-32847326);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(immutableList) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-32847326, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.Content (BrowsersListScreen.kt:71)");
            }
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(2101474557, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowsersListScreenKt.l(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(25406244, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.c
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BrowsersListScreenKt.n(immutableList, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 384, 12582912, 131067);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowsersListScreenKt.o(immutableList, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2101474557, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.Content.<anonymous> (BrowsersListScreen.kt:74)");
            }
            AppBarKt.g(ComposableSingletons$BrowsersListScreenKt.f109052a.d(), null, ComposableLambdaKt.e(-614008381, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowsersListScreenKt.m(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposeColorsKt.j(composer, 0).e(), 0L, Dp.g(0), composer, 1573254, 42);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-614008381, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.Content.<anonymous>.<anonymous> (BrowsersListScreen.kt:82)");
            }
            ComposeButtonsKt.q0(null, VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.G0, composer, 6), null, false, 0.0f, 0.0f, ComposeColorsKt.j(composer, 0).b(), StringResources_androidKt.b(R.string.N7, composer, 0), function0, composer, 0, 61);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(ImmutableList immutableList, PaddingValues it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i3 |= composer.Z(it) ? 4 : 2;
        }
        if (composer.r((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(25406244, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.browserslist.Content.<anonymous> (BrowsersListScreen.kt:94)");
            }
            Modifier modifierK = PaddingKt.k(PaddingKt.h(ScrollKt.g(SizeKt.f(Modifier.b8, 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), it), PrimitiveResources_androidKt.a(R.dimen.f95486t, composer, 0), 0.0f, 2, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.o(Dp.g(16)), Alignment.f25072a.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            composer.a0(-1117155538);
            Iterator<E> it2 = immutableList.iterator();
            while (it2.hasNext()) {
                g((BrowserState) it2.next(), composer, 0);
            }
            composer.U();
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
    public static final Unit o(ImmutableList immutableList, Function0 function0, int i3, Composer composer, int i4) {
        k(immutableList, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
