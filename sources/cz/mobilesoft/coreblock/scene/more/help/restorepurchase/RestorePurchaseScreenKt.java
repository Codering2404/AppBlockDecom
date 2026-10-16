package cz.mobilesoft.coreblock.scene.more.help.restorepurchase;

import android.content.Context;
import android.os.Bundle;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material.AppBarKt;
import androidx.compose.material.ProgressIndicatorKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.util.DataState;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.runnability.RunnabilityHelper;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeCommonsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
import org.xmlpull.v1.XmlPullParserException;

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
public final class RestorePurchaseScreenKt {
    private static final void h(RestorePurchaseViewModel restorePurchaseViewModel, final Function0 function0, Composer composer, final int i3) {
        int i4;
        final RestorePurchaseViewModel restorePurchaseViewModel2;
        Composer composerK = composer.k(1093279797);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(restorePurchaseViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1093279797, i4, -1, "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.CommandProcessor (RestorePurchaseScreen.kt:137)");
            }
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new RestorePurchaseScreenKt$CommandProcessor$1$1(function0, null);
                composerK.w(objG);
            }
            restorePurchaseViewModel2 = restorePurchaseViewModel;
            FlowExtKt.g(restorePurchaseViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            restorePurchaseViewModel2 = restorePurchaseViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RestorePurchaseScreenKt.i(restorePurchaseViewModel2, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i(RestorePurchaseViewModel restorePurchaseViewModel, Function0 function0, int i3, Composer composer, int i4) {
        h(restorePurchaseViewModel, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void j(final Function0 onClose, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerK = composer.k(405974284);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onClose) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(405974284, i4, -1, "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseScreen (RestorePurchaseScreen.kt:44)");
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
            KClass kClassB = Reflection.b(RestorePurchaseViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            RestorePurchaseViewModel restorePurchaseViewModel = (RestorePurchaseViewModel) viewModelA;
            final RestorePurchaseViewState restorePurchaseViewState = (RestorePurchaseViewState) FlowExtKt.m(restorePurchaseViewModel, composerK, 0);
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            h(restorePurchaseViewModel, onClose, composerK, (i4 << 3) & 112);
            composer2 = composerK;
            ScaffoldKt.a(WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.e(WindowInsets.f7172a, composerK, 6)), null, ComposableLambdaKt.e(-689708313, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RestorePurchaseScreenKt.k(onClose, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(2027270158, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.e
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RestorePurchaseScreenKt.n(restorePurchaseViewState, context, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 384, 12582912, 131066);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RestorePurchaseScreenKt.p(onClose, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-689708313, i3, -1, "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseScreen.<anonymous> (RestorePurchaseScreen.kt:57)");
            }
            AppBarKt.g(ComposableSingletons$RestorePurchaseScreenKt.f107823a.b(), BackgroundKt.d(SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(56)), ComposeColorsKt.j(composer, 0).e(), null, 2, null), ComposableLambdaKt.e(-555414099, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RestorePurchaseScreenKt.l(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposeColorsKt.j(composer, 0).e(), 0L, Dp.g(0), composer, 1573254, 40);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-555414099, i3, -1, "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseScreen.<anonymous>.<anonymous> (RestorePurchaseScreen.kt:66)");
            }
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            String strB = StringResources_androidKt.b(R.string.Re, composer, 0);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.j
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RestorePurchaseScreenKt.m(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(null, imageVectorB, null, false, 0.0f, 0.0f, 0L, strB, (Function0) objG, composer, 0, 125);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(RestorePurchaseViewState restorePurchaseViewState, final Context context, PaddingValues it, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        float f3;
        Modifier.Companion companion;
        int i5;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2027270158, i4, -1, "cz.mobilesoft.coreblock.scene.more.help.restorepurchase.RestorePurchaseScreen.<anonymous> (RestorePurchaseScreen.kt:77)");
            }
            Alignment.Companion companion2 = Alignment.f25072a;
            Alignment alignmentE = companion2.e();
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierF = SizeKt.f(PaddingKt.h(companion3, it), 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(alignmentE, false);
            int iA = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierF);
            ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
            Function0 function0A = companion4.a();
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
            Updater.e(composerA, measurePolicyG, companion4.e());
            Updater.e(composerA, compositionLocalMapU, companion4.g());
            Function2 function2B = companion4.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion4.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            DataState dataStateB = restorePurchaseViewState.b();
            if (dataStateB instanceof DataState.Success) {
                composer2.a0(-795629441);
                ComposeCommonsKt.g(null, 0.0f, composer2, 0, 3);
                composer2.U();
            } else if (dataStateB instanceof DataState.Error) {
                composer2.a0(-795453609);
                Alignment.Horizontal horizontalG = companion2.g();
                float f4 = 16;
                Modifier modifierI = PaddingKt.i(companion3, Dp.g(f4));
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), horizontalG, composer2, 48);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierI);
                Function0 function0A2 = companion4.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A2);
                } else {
                    composer2.v();
                }
                Composer composerA2 = Updater.a(composer2);
                Updater.e(composerA2, measurePolicyA, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF3, companion4.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                Throwable thC = ((DataState.Error) restorePurchaseViewState.b()).c();
                PurchasesException purchasesException = thC instanceof PurchasesException ? (PurchasesException) thC : null;
                if ((purchasesException != null ? purchasesException.getCode() : null) == PurchasesErrorCode.NetworkError) {
                    composer2.a0(1604550791);
                    companion = companion3;
                    i5 = 0;
                    f3 = f4;
                    TextKt.c(StringResources_androidKt.b(R.string.qD, composer2, 0), PaddingKt.i(companion3, Dp.g(f4)), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, composer, 48, 0, 130556);
                    composer2 = composer;
                    composer2.U();
                } else {
                    f3 = f4;
                    companion = companion3;
                    i5 = 0;
                    composer2.a0(1604845849);
                    String message = purchasesException != null ? purchasesException.getMessage() : null;
                    if (message == null) {
                        composer2.a0(190318462);
                        message = StringResources_androidKt.b(R.string.Vz, composer2, 0);
                    } else {
                        composer2.a0(190317904);
                    }
                    composer2.U();
                    TextKt.c(message, PaddingKt.i(companion, Dp.g(f3)), 0L, 0L, null, null, null, 0L, null, TextAlign.h(TextAlign.f29616b.a()), 0L, 0, false, 0, 0, null, null, composer, 48, 0, 130556);
                    composer2 = composer;
                    composer2.U();
                }
                Modifier modifierM = PaddingKt.m(companion, 0.0f, Dp.g(f3), 0.0f, 0.0f, 13, null);
                ButtonType.SmallRound smallRound = new ButtonType.SmallRound(null, null, StringResources_androidKt.b(R.string.i8, composer2, i5), null, false, 27, null);
                ButtonColor.Accent accent = new ButtonColor.Accent(false, Color.n(ComposeColorsKt.j(composer2, i5).e()), false, null, 13, null);
                boolean zI = composer2.I(context);
                Object objG = composer2.G();
                if (zI || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.help.restorepurchase.i
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RestorePurchaseScreenKt.o(context);
                        }
                    };
                    composer2.w(objG);
                }
                ComposeButtonsKt.i0(modifierM, smallRound, accent, (Function0) objG, composer2, 6, 0);
                composer2.y();
                composer2.U();
            } else {
                if (!(dataStateB instanceof DataState.Loading)) {
                    composer2.a0(944165936);
                    composer2.U();
                    throw new NoWhenBranchMatchedException();
                }
                composer2.a0(-793575753);
                ProgressIndicatorKt.b(null, 0L, 0.0f, 0L, 0, composer, 0, 31);
                composer2 = composer;
                composer2.U();
            }
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o(Context context) {
        RunnabilityHelper.V(context, 0, null, false, null, false, "restore_purchase", 62, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(Function0 function0, int i3, Composer composer, int i4) {
        j(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
