package cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;
import androidx.compose.animation.AnimationModifierKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.KeyboardArrowUpKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.GenericFontFamily;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsComponentsKt;
import cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesViewEvent;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.ModifierExtKt;
import cz.mobilesoft.coreblock.view.compose.material3.CardsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
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
public final class RemoteConfigValuesScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(final RemoteConfigValue remoteConfigValue, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(984421603);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(remoteConfigValue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(984421603, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValueCard (RemoteConfigValuesScreen.kt:198)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            Object systemService = context.getSystemService("clipboard");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            final ClipboardManager clipboardManager = (ClipboardManager) systemService;
            boolean Z = composerK.Z(remoteConfigValue.a());
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            boolean Z2 = composerK.Z(remoteConfigValue.b());
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            Modifier.Companion companion = Modifier.b8;
            int i5 = i4 & 14;
            boolean zI = composerK.I(clipboardManager) | (i5 == 4) | composerK.I(context);
            Object objG3 = composerK.G();
            if (zI || objG3 == Composer.f23746a.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.i
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RemoteConfigValuesScreenKt.F(clipboardManager, remoteConfigValue, context);
                    }
                };
                composerK.w(objG3);
            }
            Function0 function0 = (Function0) objG3;
            boolean zI2 = composerK.I(clipboardManager) | (i5 == 4) | composerK.I(context);
            Object objG4 = composerK.G();
            if (zI2 || objG4 == Composer.f23746a.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RemoteConfigValuesScreenKt.G(clipboardManager, remoteConfigValue, context);
                    }
                };
                composerK.w(objG4);
            }
            CardsKt.k(ClickableKt.j(companion, false, null, null, null, function0, null, false, (Function0) objG4, 111, null), 0L, 0.0f, null, null, ComposableLambdaKt.e(540340384, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.r
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RemoteConfigValuesScreenKt.H(remoteConfigValue, mutableState2, mutableState, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, 221184, 14);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RemoteConfigValuesScreenKt.L(remoteConfigValue, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean B(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void C(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean D(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    private static final void E(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(ClipboardManager clipboardManager, RemoteConfigValue remoteConfigValue, Context context) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("parameter_value", remoteConfigValue.b()));
        Toast.makeText(context, "Parameter value copied to clipboard", 0).show();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(ClipboardManager clipboardManager, RemoteConfigValue remoteConfigValue, Context context) {
        clipboardManager.setPrimaryClip(ClipData.newPlainText("parameter_name", remoteConfigValue.a()));
        Toast.makeText(context, "Parameter name copied to clipboard", 0).show();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(RemoteConfigValue remoteConfigValue, final MutableState mutableState, final MutableState mutableState2, ColumnScope BaseCard, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(BaseCard, "$this$BaseCard");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(540340384, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValueCard.<anonymous> (RemoteConfigValuesScreen.kt:217)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierB = AnimationModifierKt.b(PaddingKt.i(companion, Dp.g(16)), null, null, 3, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalO = Arrangement.f6574a.o(Dp.g(8));
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(horizontalOrVerticalO, companion2.k(), composer, 6);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierB);
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
            Updater.e(composerA, measurePolicyA, companion3.e());
            Updater.e(composerA, compositionLocalMapU, companion3.g());
            Function2 function2B = companion3.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion3.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            String strA = remoteConfigValue.a();
            TextStyle textStyleA = ComposeTypographyKt.g(composer, 0).a();
            long jL = ComposeColorsKt.j(composer, 0).L();
            FontFamily.Companion companion4 = FontFamily.f29155b;
            TextKt.c(strA, null, jL, 0L, null, null, companion4.c(), 0L, null, null, 0L, 0, false, 0, 0, null, textStyleA, composer, 0, 0, 65466);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierH);
            Function0 function0A2 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A2);
            } else {
                composer.v();
            }
            Composer composerA2 = Updater.a(composer);
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            String strB = remoteConfigValue.b();
            if (StringsKt.p0(strB)) {
                strB = "∅";
            }
            TextStyle textStyleB = ComposeTypographyKt.g(composer, 0).b();
            long jO = ComposeColorsKt.j(composer, 0).O();
            GenericFontFamily genericFontFamilyC = companion4.c();
            Modifier modifierM = PaddingKt.m(SizeKt.h(companion, 0.0f, 1, null), 0.0f, 0.0f, Dp.g(D(mutableState) ? 48 : 0), 0.0f, 11, null);
            int i4 = B(mutableState2) ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 2;
            boolean Z = composer.Z(mutableState);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RemoteConfigValuesScreenKt.I(mutableState, (TextLayoutResult) obj);
                    }
                };
                composer.w(objG);
            }
            TextKt.c(strB, modifierM, jO, 0L, null, null, genericFontFamilyC, 0L, null, null, 0L, 0, false, i4, 0, (Function1) objG, textStyleB, composer, 0, 0, 24504);
            if (D(mutableState)) {
                composer.a0(59344478);
                boolean Z2 = composer.Z(mutableState2);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.u
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return RemoteConfigValuesScreenKt.J(mutableState2);
                        }
                    };
                    composer.w(objG2);
                }
                IconButtonKt.e((Function0) objG2, boxScopeInstance.f(companion, companion2.n()), false, null, null, ComposableLambdaKt.e(424511148, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.v
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return RemoteConfigValuesScreenKt.K(mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer, 54), composer, 196608, 28);
            } else {
                composer.a0(48673534);
            }
            composer.U();
            composer.y();
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
    public static final Unit I(MutableState mutableState, TextLayoutResult layoutResult) {
        Intrinsics.checkNotNullParameter(layoutResult, "layoutResult");
        E(mutableState, layoutResult.i());
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(MutableState mutableState) {
        C(mutableState, !B(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K(MutableState mutableState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(424511148, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValueCard.<anonymous>.<anonymous>.<anonymous>.<anonymous> (RemoteConfigValuesScreen.kt:248)");
            }
            IconKt.d(B(mutableState) ? KeyboardArrowUpKt.a(Icons.Filled.f15154a) : KeyboardArrowDownKt.a(Icons.Filled.f15154a), B(mutableState) ? "Collapse value" : "Expand value", null, ComposeColorsKt.j(composer, 0).O(), composer, 0, 4);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(RemoteConfigValue remoteConfigValue, int i3, Composer composer, int i4) {
        A(remoteConfigValue, composer, RecomposeScopeImplKt.a(i3 | 1));
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
    public static final void M(PaddingValues paddingValues, final Function0 onCloseClick, Composer composer, final int i3, final int i4) {
        PaddingValues paddingValues2;
        int i5;
        final PaddingValues paddingValues3;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerK = composer.k(-1249333420);
        int i6 = i4 & 1;
        if (i6 != 0) {
            i5 = i3 | 6;
            paddingValues2 = paddingValues;
        } else if ((i3 & 6) == 0) {
            paddingValues2 = paddingValues;
            i5 = (composerK.Z(paddingValues2) ? 4 : 2) | i3;
        } else {
            paddingValues2 = paddingValues;
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerK.I(onCloseClick) ? 32 : 16;
        }
        if (composerK.r((i5 & 19) != 18, i5 & 1)) {
            PaddingValues paddingValuesA = i6 != 0 ? PaddingKt.a(Dp.g(0)) : paddingValues2;
            if (ComposerKt.M()) {
                ComposerKt.U(-1249333420, i5, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesScreen (RemoteConfigValuesScreen.kt:62)");
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
            KClass kClassB = Reflection.b(RemoteConfigValuesViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            RemoteConfigValuesViewModel remoteConfigValuesViewModel = (RemoteConfigValuesViewModel) viewModelA;
            RemoteConfigValuesViewState remoteConfigValuesViewState = (RemoteConfigValuesViewState) FlowExtKt.m(remoteConfigValuesViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(remoteConfigValuesViewModel, composerK, 0);
            boolean Z = composerK.Z(function1N);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.k
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return RemoteConfigValuesScreenKt.N(function1N, (String) obj);
                    }
                };
                composerK.w(objG);
            }
            Function1 function1 = (Function1) objG;
            boolean Z2 = composerK.Z(function1N);
            Object objG2 = composerK.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return RemoteConfigValuesScreenKt.O(function1N);
                    }
                };
                composerK.w(objG2);
            }
            paddingValues3 = paddingValuesA;
            r(paddingValues3, remoteConfigValuesViewState, onCloseClick, function1, (Function0) objG2, composerK, (i5 & 14) | ((i5 << 3) & 896));
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
            paddingValues3 = paddingValues2;
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RemoteConfigValuesScreenKt.P(paddingValues3, onCloseClick, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new RemoteConfigValuesViewEvent.OnSearchQueryChanged(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(Function1 function1) {
        function1.invoke(RemoteConfigValuesViewEvent.OnRefreshRequested.f109298a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(PaddingValues paddingValues, Function0 function0, int i3, int i4, Composer composer, int i5) {
        M(paddingValues, function0, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final PaddingValues paddingValues, final RemoteConfigValuesViewState remoteConfigValuesViewState, final Function0 function0, final Function1 function1, final Function0 function02, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-1934207874);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(paddingValues) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(remoteConfigValuesViewState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function0) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function02) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if (composerK.r((i4 & 9363) != 9362, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1934207874, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.Content (RemoteConfigValuesScreen.kt:83)");
            }
            final FocusManager focusManager = (FocusManager) composerK.q(CompositionLocalsKt.g());
            PullToRefreshKt.d(remoteConfigValuesViewState.g(), function02, PaddingKt.h(SizeKt.f(Modifier.b8, 0.0f, 1, null), paddingValues), null, null, null, ComposableLambdaKt.e(-2081942172, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.w
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RemoteConfigValuesScreenKt.s(function0, remoteConfigValuesViewState, focusManager, function1, (BoxScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 9) & 112) | 1572864, 56);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RemoteConfigValuesScreenKt.x(paddingValues, remoteConfigValuesViewState, function0, function1, function02, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(final Function0 function0, final RemoteConfigValuesViewState remoteConfigValuesViewState, final FocusManager focusManager, final Function1 function1, BoxScope PullToRefreshBox, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(PullToRefreshBox, "$this$PullToRefreshBox");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2081942172, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.Content.<anonymous> (RemoteConfigValuesScreen.kt:93)");
            }
            ScaffoldKt.a(null, ComposableLambdaKt.e(-402511320, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RemoteConfigValuesScreenKt.t(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, null, null, 0, ComposeColorsKt.j(composer, 0).e(), 0L, null, ComposableLambdaKt.e(2031442163, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.j
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return RemoteConfigValuesScreenKt.v(remoteConfigValuesViewState, focusManager, function1, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306416, 445);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(final Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-402511320, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.Content.<anonymous>.<anonymous> (RemoteConfigValuesScreen.kt:95)");
            }
            AppBarKt.p(ComposableSingletons$RemoteConfigValuesScreenKt.f109273a.g(), null, ComposableLambdaKt.e(-64229726, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.n
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RemoteConfigValuesScreenKt.u(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, TopAppBarDefaults.f21543a.p(ComposeColorsKt.j(composer, 0).e(), 0L, 0L, 0L, 0L, composer, TopAppBarDefaults.f21549g << 15, 30), null, composer, 390, 186);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(Function0 function0, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-64229726, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.Content.<anonymous>.<anonymous>.<anonymous> (RemoteConfigValuesScreen.kt:104)");
            }
            IconButtonKt.e(function0, null, false, null, null, ComposableSingletons$RemoteConfigValuesScreenKt.f109273a.h(), composer, 196608, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(final RemoteConfigValuesViewState remoteConfigValuesViewState, FocusManager focusManager, Function1 function1, PaddingValues innerPadding, Composer composer, int i3) {
        int i4;
        int i5;
        Modifier.Companion companion;
        int i6;
        Arrangement arrangement;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(innerPadding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2031442163, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.Content.<anonymous>.<anonymous> (RemoteConfigValuesScreen.kt:119)");
            }
            if (remoteConfigValuesViewState.e().isEmpty() && remoteConfigValuesViewState.g()) {
                composer2.a0(-1690558251);
                Modifier modifierH = PaddingKt.h(SizeKt.f(Modifier.b8, 0.0f, 1, null), innerPadding);
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.g(), composer2, 54);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierH);
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
                Updater.e(composerA, measurePolicyA, companion2.e());
                Updater.e(composerA, compositionLocalMapU, companion2.g());
                Function2 function2B = companion2.b();
                if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                    composerA.w(Integer.valueOf(iA));
                    composerA.p(Integer.valueOf(iA), function2B);
                }
                Updater.e(composerA, modifierF, companion2.f());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
                ProgressIndicatorKt.d(null, ComposeColorsKt.j(composer2, 0).b(), 0.0f, 0L, 0, composer2, 0, 29);
                composer2.y();
                composer2.U();
            } else {
                composer2.a0(-1690009024);
                Modifier.Companion companion3 = Modifier.b8;
                Modifier modifierG = ModifierExtKt.g(PaddingKt.h(SizeKt.f(companion3, 0.0f, 1, null), innerPadding), focusManager);
                Alignment.Companion companion4 = Alignment.f25072a;
                MeasurePolicy measurePolicyG = BoxKt.g(companion4.o(), false);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierG);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
                Function0 function0A2 = companion5.a();
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
                Updater.e(composerA2, measurePolicyG, companion5.e());
                Updater.e(composerA2, compositionLocalMapU2, companion5.g());
                Function2 function2B2 = companion5.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion5.f());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                Modifier modifierF3 = SizeKt.f(companion3, 0.0f, 1, null);
                Arrangement arrangement2 = Arrangement.f6574a;
                MeasurePolicy measurePolicyA2 = ColumnKt.a(arrangement2.h(), companion4.k(), composer2, 0);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF4 = ComposedModifierKt.f(composer2, modifierF3);
                Function0 function0A3 = companion5.a();
                if (composer2.m() == null) {
                    ComposablesKt.c();
                }
                composer2.L();
                if (composer2.i()) {
                    composer2.P(function0A3);
                } else {
                    composer2.v();
                }
                Composer composerA3 = Updater.a(composer2);
                Updater.e(composerA3, measurePolicyA2, companion5.e());
                Updater.e(composerA3, compositionLocalMapU3, companion5.g());
                Function2 function2B3 = companion5.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF4, companion5.f());
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.f6666a;
                DeveloperSettingsComponentsKt.k(remoteConfigValuesViewState.f(), function1, null, "Search by key or value", composer2, 3072, 4);
                String strC = remoteConfigValuesViewState.c();
                if (strC == null) {
                    composer2.a0(77281088);
                    composer2.U();
                    i5 = 1;
                    i6 = 0;
                    companion = companion3;
                    arrangement = arrangement2;
                } else {
                    composer2.a0(77281089);
                    i5 = 1;
                    companion = companion3;
                    i6 = 0;
                    arrangement = arrangement2;
                    TextKt.c(strC, PaddingKt.j(SizeKt.h(companion3, 0.0f, 1, null), Dp.g(16), Dp.g(8)), ComposeColorsKt.j(composer2, 0).k(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).b(), composer, 48, 0, 65528);
                    composer2 = composer;
                    Unit unit = Unit.f139807a;
                    composer2.U();
                }
                if (remoteConfigValuesViewState.d().isEmpty()) {
                    composer2.a0(77868973);
                    y(!StringsKt.p0(remoteConfigValuesViewState.f()), composer2, i6);
                    composer2.U();
                } else {
                    composer2.a0(78016254);
                    Modifier modifierF5 = SizeKt.f(companion, 0.0f, i5, null);
                    PaddingValues paddingValuesB = PaddingKt.b(Dp.g(16), Dp.g(12));
                    Arrangement.HorizontalOrVertical horizontalOrVerticalO = arrangement.o(Dp.g(8));
                    boolean Z = composer2.Z(remoteConfigValuesViewState);
                    Object objG = composer2.G();
                    if (Z || objG == Composer.f23746a.a()) {
                        objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.o
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return RemoteConfigValuesScreenKt.w(remoteConfigValuesViewState, (LazyListScope) obj);
                            }
                        };
                        composer2.w(objG);
                    }
                    LazyDslKt.b(modifierF5, null, paddingValuesB, false, horizontalOrVerticalO, null, null, false, null, (Function1) objG, composer2, 24966, 490);
                    composer.U();
                }
                composer.y();
                composer.y();
                composer.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w(RemoteConfigValuesViewState remoteConfigValuesViewState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final ImmutableList immutableListD = remoteConfigValuesViewState.d();
        final RemoteConfigValuesScreenKt$Content$lambda$0$1$1$0$1$0$$inlined$items$default$1 remoteConfigValuesScreenKt$Content$lambda$0$1$1$0$1$0$$inlined$items$default$1 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesScreenKt$Content$lambda$0$1$1$0$1$0$$inlined$items$default$1
            @Override // kotlin.jvm.functions.Function1
            public final Void invoke(Object obj) {
                return null;
            }
        };
        LazyColumn.h(immutableListD.size(), null, new Function1<Integer, Object>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesScreenKt$Content$lambda$0$1$1$0$1$0$$inlined$items$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return invoke(((Number) obj).intValue());
            }

            public final Object invoke(int i3) {
                return remoteConfigValuesScreenKt$Content$lambda$0$1$1$0$1$0$$inlined$items$default$1.invoke(immutableListD.get(i3));
            }
        }, ComposableLambdaKt.c(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.RemoteConfigValuesScreenKt$Content$lambda$0$1$1$0$1$0$$inlined$items$default$4
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
                    ComposerKt.U(-632812321, i5, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                RemoteConfigValue remoteConfigValue = (RemoteConfigValue) immutableListD.get(i3);
                composer.a0(821082439);
                RemoteConfigValuesScreenKt.A(remoteConfigValue, composer, 0);
                composer.U();
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
            }
        }));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(PaddingValues paddingValues, RemoteConfigValuesViewState remoteConfigValuesViewState, Function0 function0, Function1 function1, Function0 function02, int i3, Composer composer, int i4) {
        r(paddingValues, remoteConfigValuesViewState, function0, function1, function02, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void y(final boolean z2, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        String strB;
        Composer composerK = composer.k(-299811619);
        if ((i3 & 6) == 0) {
            i4 = (composerK.b(z2) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-299811619, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.EmptyState (RemoteConfigValuesScreen.kt:181)");
            }
            Modifier modifierI = PaddingKt.i(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(32));
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.b(), Alignment.f25072a.g(), composerK, 54);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierI);
            ComposeUiNode.Companion companion = ComposeUiNode.f8;
            Function0 function0A = companion.a();
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
            Updater.e(composerA, measurePolicyA, companion.e());
            Updater.e(composerA, compositionLocalMapU, companion.g());
            Function2 function2B = companion.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            if (z2) {
                composerK.a0(1865719958);
                composerK.U();
                strB = "No parameters match your search.";
            } else {
                composerK.a0(-780237259);
                strB = StringResources_androidKt.b(R.string.Ra, composerK, 0);
                composerK.U();
            }
            composer2 = composerK;
            TextKt.c(strB, null, ComposeColorsKt.j(composerK, 0).O(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).a(), composer2, 0, 0, 65530);
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
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.remoteconfigvalues.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return RemoteConfigValuesScreenKt.z(z2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(boolean z2, int i3, Composer composer, int i4) {
        y(z2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
