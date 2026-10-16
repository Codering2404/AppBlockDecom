package cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.IconButtonKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.base.activity.BaseComposeActivity;
import cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersViewEvent;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.view.AppIconCache;
import cz.mobilesoft.coreblock.view.compose.IconClusterKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ExcludedUnsupportedBrowsersActivity extends BaseComposeActivity {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A0(Function1 function1, Application application) {
        function1.invoke(new ExcludedUnsupportedBrowsersViewEvent.RemoveUnsupportedBrowser(application.d()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B0(ExcludedUnsupportedBrowsersActivity excludedUnsupportedBrowsersActivity, List list, Function1 function1, int i3, Composer composer, int i4) {
        excludedUnsupportedBrowsersActivity.x0(list, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t0(final ExcludedUnsupportedBrowsersActivity excludedUnsupportedBrowsersActivity, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1605308252, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersActivity.RootCompose.<anonymous> (ExcludedUnsupportedBrowsersActivity.kt:66)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer, 48);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            boolean zI = composer.I(excludedUnsupportedBrowsersActivity);
            Object objG = composer.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExcludedUnsupportedBrowsersActivity.u0(this.f109672a);
                    }
                };
                composer.w(objG);
            }
            IconButtonKt.a((Function0) objG, null, false, null, ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.f109642a.e(), composer, 24576, 14);
            SpacerKt.a(SizeKt.A(companion, Dp.g(16)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.Yd, composer, 0), null, 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65022);
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
    public static final Unit u0(ExcludedUnsupportedBrowsersActivity excludedUnsupportedBrowsersActivity) {
        excludedUnsupportedBrowsersActivity.finish();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v0(ExcludedUnsupportedBrowsersViewState excludedUnsupportedBrowsersViewState, ExcludedUnsupportedBrowsersActivity excludedUnsupportedBrowsersActivity, Function1 function1, PaddingValues it, Composer composer, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1380008533, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersActivity.RootCompose.<anonymous> (ExcludedUnsupportedBrowsersActivity.kt:45)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.h(companion, it), 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierF);
            ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
            Function0 function0A = companion3.a();
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
            Updater.e(composerA, measurePolicyG, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            if (excludedUnsupportedBrowsersViewState.b().isEmpty()) {
                composer.a0(-1577203534);
                TextKt.c(StringResources_androidKt.b(R.string.Wd, composer, 0), PaddingKt.k(boxScopeInstance.f(companion, companion2.e()), Dp.g(36), 0.0f, 2, null), ComposeColorsKt.j(composer, 0).O(), 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65016);
                composer.U();
            } else {
                composer.a0(-1577370128);
                excludedUnsupportedBrowsersActivity.x0(excludedUnsupportedBrowsersViewState.b(), function1, composer, 0);
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
    public static final Unit w0(ExcludedUnsupportedBrowsersActivity excludedUnsupportedBrowsersActivity, PaddingValues paddingValues, int i3, Composer composer, int i4) {
        excludedUnsupportedBrowsersActivity.c0(paddingValues, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private final void x0(final List list, final Function1 function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-102455315);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(list) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-102455315, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersActivity.UnsupportedBrowsersList (ExcludedUnsupportedBrowsersActivity.kt:96)");
            }
            final AppIconCache appIconCache = new AppIconCache();
            boolean zI = composerK.I(list) | composerK.Z(appIconCache) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExcludedUnsupportedBrowsersActivity.y0(list, appIconCache, function1, (LazyListScope) obj);
                    }
                };
                composerK.w(objG);
            }
            LazyDslKt.b(null, null, null, false, null, null, null, false, null, (Function1) objG, composerK, 0, 511);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExcludedUnsupportedBrowsersActivity.B0(this.f109676a, list, function1, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y0(List list, final AppIconCache appIconCache, final Function1 function1, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        LazyListScope.c(LazyColumn, null, null, ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.f109642a.f(), 3, null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final Application application = (Application) it.next();
            LazyListScope.c(LazyColumn, null, null, ComposableLambdaKt.c(2007869919, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ExcludedUnsupportedBrowsersActivity.z0(appIconCache, application, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }), 3, null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z0(AppIconCache appIconCache, final Application application, final Function1 function1, LazyItemScope item, Composer composer, int i3) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if (composer2.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2007869919, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersActivity.UnsupportedBrowsersList.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ExcludedUnsupportedBrowsersActivity.kt:131)");
            }
            Alignment.Vertical verticalI = Alignment.f25072a.i();
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierJ = PaddingKt.j(SizeKt.h(companion, 0.0f, 1, null), Dp.g(f3), Dp.g(8));
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), verticalI, composer2, 48);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF = ComposedModifierKt.f(composer2, modifierJ);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
            if (composer2.m() == null) {
                ComposablesKt.c();
            }
            composer2.L();
            if (composer2.i()) {
                composer2.P(function0A);
            } else {
                composer2.v();
            }
            Composer composerA = Updater.a(composer2);
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            Drawable drawableE = appIconCache.e(application.d());
            if (drawableE == null) {
                composer2.a0(-47300097);
            } else {
                composer2.a0(-47300096);
                IconClusterKt.g(drawableE, false, false, false, null, composer, 3456, 18);
                composer2 = composer;
            }
            composer2.U();
            TextKt.c(application.b(), RowScope.c(rowScopeInstance, PaddingKt.i(companion, Dp.g(f3)), 1.0f, false, 2, null), ComposeColorsKt.j(composer2, 0).L(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).h(), composer, 0, 0, 65528);
            boolean Z = composer.Z(function1) | composer.Z(application);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExcludedUnsupportedBrowsersActivity.A0(function1, application);
                    }
                };
                composer.w(objG);
            }
            IconButtonKt.a((Function0) objG, null, false, null, ComposableSingletons$ExcludedUnsupportedBrowsersActivityKt.f109642a.d(), composer, 24576, 14);
            composer.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    @Override // cz.mobilesoft.coreblock.base.activity.BaseComposeActivity
    public void c0(final PaddingValues paddingValues, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer composerK = composer.k(1222573975);
        if ((i3 & 48) == 0) {
            i4 = (composerK.I(this) ? 32 : 16) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 17) != 16, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1222573975, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.ExcludedUnsupportedBrowsersActivity.RootCompose (ExcludedUnsupportedBrowsersActivity.kt:38)");
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
            KClass kClassB = Reflection.b(ExcludedUnsupportedBrowsersViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            ExcludedUnsupportedBrowsersViewModel excludedUnsupportedBrowsersViewModel = (ExcludedUnsupportedBrowsersViewModel) viewModelA;
            final ExcludedUnsupportedBrowsersViewState excludedUnsupportedBrowsersViewState = (ExcludedUnsupportedBrowsersViewState) FlowExtKt.m(excludedUnsupportedBrowsersViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(excludedUnsupportedBrowsersViewModel, composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(null, null, ComposableLambdaKt.e(1605308252, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExcludedUnsupportedBrowsersActivity.t0(this.f109665a, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1380008533, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ExcludedUnsupportedBrowsersActivity.v0(excludedUnsupportedBrowsersViewState, this, function1N, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.excludedBrowsers.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExcludedUnsupportedBrowsersActivity.w0(this.f109669a, paddingValues, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
