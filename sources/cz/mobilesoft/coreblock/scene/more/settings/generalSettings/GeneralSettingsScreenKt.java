package cz.mobilesoft.coreblock.scene.more.settings.generalSettings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.more.settings.AllowCategoriesBottomSheetKt;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsActivity;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.DayBeginningSelectorDialog;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.DayNightPickerDialogFragment;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.EventTimePickerDialogFragment;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.LanguagePickerDialogFragment;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.permissions.PermissionHelper;
import cz.mobilesoft.coreblock.view.compose.SectionedItemKt;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
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
public final class GeneralSettingsScreenKt {
    public static final void A(Composer composer, final int i3) {
        Composer composer2;
        Bundle bundleB;
        Composer composerK = composer.k(730933996);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(730933996, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen (GeneralSettingsScreen.kt:64)");
            }
            final Context context = (Context) composerK.q(AndroidCompositionLocals_androidKt.g());
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            final FragmentManager supportFragmentManager = fragmentActivity != null ? fragmentActivity.getSupportFragmentManager() : null;
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            ActivityResultContracts.StartActivityForResult startActivityForResult = new ActivityResultContracts.StartActivityForResult();
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return GeneralSettingsScreenKt.D(mutableState, (ActivityResult) obj);
                    }
                };
                composerK.w(objG2);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(startActivityForResult, (Function1) objG2, composerK, 48);
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
            KClass kClassB = Reflection.b(GeneralSettingsViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            GeneralSettingsViewModel generalSettingsViewModel = (GeneralSettingsViewModel) viewModelA;
            final GeneralSettingsViewState generalSettingsViewState = (GeneralSettingsViewState) FlowExtKt.m(generalSettingsViewModel, composerK, 0);
            final Function1 function1N = FlowExtKt.n(generalSettingsViewModel, composerK, 0);
            final ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                objG3 = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG3);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objG3;
            generalSettingsViewModel.f1();
            y(generalSettingsViewModel, scaffoldStateG, composerK, 0);
            final String strB = StringResources_androidKt.b(StrictModeTitleAlternatives.Companion.a(), composerK, 0);
            composer2 = composerK;
            ScaffoldKt.a(null, scaffoldStateG, null, null, ComposableSingletons$GeneralSettingsScreenKt.f109687a.b(), null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(1525993130, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return GeneralSettingsScreenKt.E(generalSettingsViewState, function1N, supportFragmentManager, coroutineScope, scaffoldStateG, strB, context, managedActivityResultLauncherA, mutableState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerK, 54), composer2, 24576, 12582912, 131053);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GeneralSettingsScreenKt.Z(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean B(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(MutableState mutableState, ActivityResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.d() == -1) {
            if (B(mutableState)) {
                AnswersHelper.f128199a.v6();
            } else {
                AnswersHelper.f128199a.t6();
            }
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(final GeneralSettingsViewState generalSettingsViewState, final Function1 function1, final FragmentManager fragmentManager, final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final String str, final Context context, final ManagedActivityResultLauncher managedActivityResultLauncher, final MutableState mutableState, PaddingValues padding, Composer composer, int i3) throws XmlPullParserException, IOException {
        int i4;
        int i5;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(padding, "padding");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer2.Z(padding) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer2.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1525993130, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen.<anonymous> (GeneralSettingsScreen.kt:100)");
            }
            if (generalSettingsViewState.m()) {
                composer2.a0(-1367409961);
                boolean Z = composer2.Z(function1);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return GeneralSettingsScreenKt.F(function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer2.w(objG);
                }
                AllowCategoriesBottomSheetKt.f((Function1) objG, null, composer2, 0, 2);
                composer2.U();
            } else {
                composer2.a0(-1366772136);
                Modifier.Companion companion = Modifier.b8;
                float f3 = 16;
                Modifier modifierI = PaddingKt.i(PaddingKt.h(ScrollKt.g(companion, ScrollKt.c(0, composer2, 0, 1), false, null, false, 14, null), padding), Dp.g(f3));
                MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                int iA = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU = composer2.u();
                Modifier modifierF = ComposedModifierKt.f(composer2, modifierI);
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
                if (fragmentManager == null) {
                    composer2.a0(-1675798071);
                } else {
                    composer2.a0(-1675798070);
                    String strB = StringResources_androidKt.b(R.string.wi, composer2, 0);
                    String strH = generalSettingsViewState.h();
                    ImageVector.Companion companion3 = ImageVector.f26323k;
                    ImageVector imageVectorB = VectorResources_androidKt.b(companion3, R.drawable.e5, composer2, 6);
                    boolean Z2 = composer2.Z(generalSettingsViewState) | composer2.I(fragmentManager);
                    Object objG2 = composer2.G();
                    if (Z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.f
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.G(generalSettingsViewState, fragmentManager);
                            }
                        };
                        composer2.w(objG2);
                    }
                    GeneralSettingsViewState.SettingsItem settingsItem = new GeneralSettingsViewState.SettingsItem(strB, null, strH, null, imageVectorB, false, false, (Function0) objG2, 106, null);
                    String strB2 = StringResources_androidKt.b(R.string.Eo, composer2, 0);
                    String strB3 = StringResources_androidKt.b(R.string.Do, composer2, 0);
                    String strE = generalSettingsViewState.e();
                    ImageVector imageVectorB2 = VectorResources_androidKt.b(companion3, R.drawable.k5, composer2, 6);
                    boolean zI = composer2.I(fragmentManager) | composer2.Z(generalSettingsViewState) | composer2.I(coroutineScope) | composer2.Z(scaffoldState) | composer2.Z(str);
                    Object objG3 = composer2.G();
                    if (zI || objG3 == Composer.f23746a.a()) {
                        i5 = 6;
                        Function0 function0 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.g
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.H(fragmentManager, generalSettingsViewState, coroutineScope, scaffoldState, str);
                            }
                        };
                        composer2.w(function0);
                        objG3 = function0;
                    } else {
                        i5 = 6;
                    }
                    int i6 = i5;
                    GeneralSettingsViewState.SettingsItem settingsItem2 = new GeneralSettingsViewState.SettingsItem(strB2, strB3, strE, null, imageVectorB2, false, false, (Function0) objG3, 104, null);
                    String strB4 = StringResources_androidKt.b(R.string.Bw, composer2, 0);
                    String strC = StringResources_androidKt.c(R.string.zw, new Object[]{StringResources_androidKt.b(R.string.f95790f1, composer2, 0)}, composer2, 0);
                    boolean zP = generalSettingsViewState.p();
                    ImageVector imageVectorB3 = VectorResources_androidKt.b(companion3, R.drawable.c5, composer2, i6);
                    Boolean boolValueOf = Boolean.valueOf(zP);
                    boolean Z3 = composer2.Z(generalSettingsViewState) | composer2.I(context) | composer2.I(managedActivityResultLauncher);
                    Object objG4 = composer2.G();
                    if (Z3 || objG4 == Composer.f23746a.a()) {
                        objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.h
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.R(generalSettingsViewState, context, managedActivityResultLauncher, mutableState);
                            }
                        };
                        composer2.w(objG4);
                    }
                    GeneralSettingsViewState.SettingsItem settingsItem3 = new GeneralSettingsViewState.SettingsItem(strB4, strC, null, boolValueOf, imageVectorB3, false, false, (Function0) objG4, 100, null);
                    String strB5 = StringResources_androidKt.b(R.string.f95828o1, composer2, 0);
                    String strB6 = StringResources_androidKt.b(R.string.f95823n1, composer2, 0);
                    boolean zG = generalSettingsViewState.g();
                    ImageVector imageVectorB4 = VectorResources_androidKt.b(companion3, R.drawable.j5, composer2, i6);
                    Boolean boolValueOf2 = Boolean.valueOf(zG);
                    boolean Z4 = composer2.Z(function1);
                    Object objG5 = composer2.G();
                    if (Z4 || objG5 == Composer.f23746a.a()) {
                        objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.i
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.S(function1);
                            }
                        };
                        composer2.w(objG5);
                    }
                    GeneralSettingsViewState.SettingsItem settingsItem4 = new GeneralSettingsViewState.SettingsItem(strB5, strB6, null, boolValueOf2, imageVectorB4, false, false, (Function0) objG5, 100, null);
                    String strB7 = StringResources_androidKt.b(R.string.f95855w0, composer2, 0);
                    String strB8 = StringResources_androidKt.b(R.string.f95852v0, composer2, 0);
                    boolean zC = generalSettingsViewState.c();
                    ImageVector imageVectorB5 = VectorResources_androidKt.b(companion3, R.drawable.Y0, composer2, i6);
                    Boolean boolValueOf3 = Boolean.valueOf(zC);
                    boolean Z5 = composer2.Z(function1);
                    Object objG6 = composer2.G();
                    if (Z5 || objG6 == Composer.f23746a.a()) {
                        objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.j
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.T(function1);
                            }
                        };
                        composer2.w(objG6);
                    }
                    List listMutableListOf = CollectionsKt.mutableListOf(settingsItem, settingsItem2, settingsItem3, settingsItem4, new GeneralSettingsViewState.SettingsItem(strB7, strB8, null, boolValueOf3, imageVectorB5, false, false, (Function0) objG6, 100, null));
                    if (PermissionHelper.k(context)) {
                        composer2.a0(-927566669);
                        String strB9 = StringResources_androidKt.b(R.string.U8, composer2, 0);
                        String strB10 = StringResources_androidKt.b(R.string.V8, composer2, 0);
                        boolean zF = generalSettingsViewState.f();
                        ImageVector imageVectorB6 = VectorResources_androidKt.b(companion3, R.drawable.f95551p1, composer2, i6);
                        Boolean boolValueOf4 = Boolean.valueOf(zF);
                        boolean Z6 = composer2.Z(function1);
                        Object objG7 = composer2.G();
                        if (Z6 || objG7 == Composer.f23746a.a()) {
                            objG7 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.k
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GeneralSettingsScreenKt.U(function1);
                                }
                            };
                            composer2.w(objG7);
                        }
                        listMutableListOf.add(new GeneralSettingsViewState.SettingsItem(strB9, strB10, null, boolValueOf4, imageVectorB6, false, false, (Function0) objG7, 100, null));
                    } else {
                        composer2.a0(-938553658);
                    }
                    composer2.U();
                    String strB11 = StringResources_androidKt.b(R.string.ek, composer2, 0);
                    String strB12 = StringResources_androidKt.b(R.string.dk, composer2, 0);
                    boolean zI2 = generalSettingsViewState.i();
                    ImageVector imageVectorB7 = VectorResources_androidKt.b(companion3, R.drawable.J3, composer2, i6);
                    Boolean boolValueOf5 = Boolean.valueOf(zI2);
                    boolean Z7 = composer2.Z(function1);
                    Object objG8 = composer2.G();
                    if (Z7 || objG8 == Composer.f23746a.a()) {
                        objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.l
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.V(function1);
                            }
                        };
                        composer2.w(objG8);
                    }
                    listMutableListOf.add(new GeneralSettingsViewState.SettingsItem(strB11, strB12, null, boolValueOf5, imageVectorB7, false, false, (Function0) objG8, 100, null));
                    if (generalSettingsViewState.n()) {
                        composer2.a0(-925731624);
                        String strB13 = StringResources_androidKt.b(R.string.AB, composer2, 0);
                        String strB14 = StringResources_androidKt.b(R.string.zB, composer2, 0);
                        boolean zO = generalSettingsViewState.o();
                        ImageVector imageVectorB8 = VectorResources_androidKt.b(companion3, R.drawable.L5, composer2, i6);
                        Boolean boolValueOf6 = Boolean.valueOf(zO);
                        boolean Z8 = composer2.Z(function1);
                        Object objG9 = composer2.G();
                        if (Z8 || objG9 == Composer.f23746a.a()) {
                            objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.n
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GeneralSettingsScreenKt.W(function1);
                                }
                            };
                            composer2.w(objG9);
                        }
                        listMutableListOf.add(new GeneralSettingsViewState.SettingsItem(strB13, strB14, null, boolValueOf6, imageVectorB8, false, true, (Function0) objG9, 36, null));
                    } else {
                        composer2.a0(-938553658);
                    }
                    composer2.U();
                    Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.o
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return GeneralSettingsScreenKt.X((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    Function3 function32 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.t
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return GeneralSettingsScreenKt.Y((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    Function3 function33 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.u
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return GeneralSettingsScreenKt.J((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    Function3 function34 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.v
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return GeneralSettingsScreenKt.K((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    Function3 function35 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.w
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return GeneralSettingsScreenKt.L((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    };
                    Function3 function36 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.x
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return Boolean.valueOf(GeneralSettingsScreenKt.M((GeneralSettingsViewState.SettingsItem) obj, (Composer) obj2, ((Integer) obj3).intValue()));
                        }
                    };
                    Object objG10 = composer2.G();
                    Composer.Companion companion4 = Composer.f23746a;
                    if (objG10 == companion4.a()) {
                        objG10 = new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.y
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return GeneralSettingsScreenKt.N((GeneralSettingsViewState.SettingsItem) obj, ((Integer) obj2).intValue());
                            }
                        };
                        composer2.w(objG10);
                    }
                    SectionedItemKt.f0(listMutableListOf, function3, function32, function33, function34, null, null, function35, null, null, null, function36, null, false, false, true, 0L, null, null, 0L, null, null, 0L, null, null, (Function2) objG10, composer2, 0, 196608, 196608, 16759728);
                    SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer2, 6);
                    String strB15 = StringResources_androidKt.b(R.string.NC, composer2, 0);
                    MaterialTheme materialTheme = MaterialTheme.f13091a;
                    int i7 = MaterialTheme.f13092b;
                    TextKt.c(strB15, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer2, i7).g(), composer, 0, 0, 65534);
                    SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
                    String strB16 = StringResources_androidKt.b(R.string.C1, composer, 0);
                    String strD = generalSettingsViewState.d();
                    ImageVector imageVectorB9 = VectorResources_androidKt.b(companion3, R.drawable.b5, composer, 6);
                    boolean zI3 = composer.I(fragmentManager);
                    Object objG11 = composer.G();
                    if (zI3 || objG11 == companion4.a()) {
                        objG11 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.c
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.O(fragmentManager);
                            }
                        };
                        composer.w(objG11);
                    }
                    SectionedItemKt.L(null, strB16, strD, null, imageVectorB9, 0L, true, false, 0L, null, 0L, 0L, null, null, null, false, (Function0) objG11, composer, 1572864, 0, 65449);
                    SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
                    TextKt.c(StringResources_androidKt.b(R.string.x4, composer, 0), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, materialTheme.c(composer, i7).g(), composer, 0, 0, 65534);
                    SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
                    String strB17 = StringResources_androidKt.b(R.string.br, composer, 0);
                    String strB18 = StringResources_androidKt.b(R.string.Cw, composer, 0);
                    boolean zJ = generalSettingsViewState.j();
                    ImageVector imageVectorB10 = VectorResources_androidKt.b(companion3, R.drawable.f95542n0, composer, 6);
                    boolean Z9 = composer.Z(function1);
                    Object objG12 = composer.G();
                    if (Z9 || objG12 == companion4.a()) {
                        objG12 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.d
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return GeneralSettingsScreenKt.P(function1);
                            }
                        };
                        composer.w(objG12);
                    }
                    SectionedItemKt.P(null, strB17, null, strB18, null, imageVectorB10, 0L, 0L, 0L, null, null, (Function0) objG12, Boolean.valueOf(zJ), false, composer, 0, 0, 10197);
                    composer2 = composer;
                    SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer2, 6);
                    if (BuildConfig.f95357b.booleanValue()) {
                        composer2.a0(-922082180);
                        String strB19 = StringResources_androidKt.b(R.string.Fb, composer2, 0);
                        ImageVector imageVectorB11 = VectorResources_androidKt.b(companion3, R.drawable.Q1, composer2, 6);
                        boolean zI4 = composer2.I(context);
                        Object objG13 = composer2.G();
                        if (zI4 || objG13 == companion4.a()) {
                            objG13 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.e
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return GeneralSettingsScreenKt.Q(context);
                                }
                            };
                            composer2.w(objG13);
                        }
                        SectionedItemKt.G(null, strB19, null, null, null, null, imageVectorB11, null, null, false, 0L, 0L, null, false, (Function0) objG13, false, null, 0L, composer, 0, 0, 245693);
                        composer2 = composer;
                    } else {
                        composer2.a0(-938553658);
                    }
                    composer2.U();
                    Unit unit = Unit.f139807a;
                }
                composer2.U();
                composer2.y();
                composer2.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer2.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F(Function1 function1, boolean z2) {
        function1.invoke(new GeneralSettingsViewEvent.OnCategoriesAllowed(z2));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G(GeneralSettingsViewState generalSettingsViewState, FragmentManager fragmentManager) {
        d0(generalSettingsViewState.l(), fragmentManager);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(FragmentManager fragmentManager, GeneralSettingsViewState generalSettingsViewState, final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final String str) {
        b0(fragmentManager, generalSettingsViewState.q(), new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return GeneralSettingsScreenKt.I(coroutineScope, scaffoldState, str);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(CoroutineScope coroutineScope, ScaffoldState scaffoldState, String str) {
        BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$2$1$1$1(scaffoldState, str, null), 3, null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String J(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1551311577);
        if (ComposerKt.M()) {
            ComposerKt.U(1551311577, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralSettingsScreen.kt:232)");
        }
        String strA = it.a();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ImageVector K(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1048263511);
        if (ComposerKt.M()) {
            ComposerKt.U(1048263511, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralSettingsScreen.kt:235)");
        }
        ImageVector imageVectorB = it.b();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return imageVectorB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Boolean L(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1839034308);
        if (ComposerKt.M()) {
            ComposerKt.U(1839034308, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralSettingsScreen.kt:234)");
        }
        Boolean boolG = it.g();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return boolG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1738689177);
        if (ComposerKt.M()) {
            ComposerKt.U(1738689177, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralSettingsScreen.kt:236)");
        }
        boolean zF = it.f();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return zF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(GeneralSettingsViewState.SettingsItem item, int i3) {
        Intrinsics.checkNotNullParameter(item, "item");
        item.c().invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(FragmentManager fragmentManager) {
        e0(fragmentManager);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1) {
        function1.invoke(GeneralSettingsViewEvent.OnQuickBlockSwitchClicked.f109719a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(Context context) {
        ((FragmentActivity) context).startActivity(new Intent(context, (Class<?>) DeveloperSettingsActivity.class));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(GeneralSettingsViewState generalSettingsViewState, Context context, ManagedActivityResultLauncher managedActivityResultLauncher, MutableState mutableState) {
        CoroutinesHelperExtKt.d(new GeneralSettingsScreenKt$GeneralSettingsScreen$1$2$1$generalSettings$3$1$1(generalSettingsViewState, context, managedActivityResultLauncher, mutableState, null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(Function1 function1) {
        function1.invoke(GeneralSettingsViewEvent.OnInAppsUpdateClicked.f109717a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(Function1 function1) {
        function1.invoke(GeneralSettingsViewEvent.OnAllowCategoriesClicked.f109714a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(Function1 function1) {
        function1.invoke(GeneralSettingsViewEvent.OnDailyTrendBadgeClicked.f109716a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(Function1 function1) {
        function1.invoke(GeneralSettingsViewEvent.OnMoodCheckInAutoShowClicked.f109718a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W(Function1 function1) {
        function1.invoke(GeneralSettingsViewEvent.OnStreaksEnabledClicked.f109720a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String X(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(1056177239);
        if (ComposerKt.M()) {
            ComposerKt.U(1056177239, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralSettingsScreen.kt:230)");
        }
        String strE = it.e();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String Y(GeneralSettingsViewState.SettingsItem it, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.a0(-843739240);
        if (ComposerKt.M()) {
            ComposerKt.U(-843739240, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.GeneralSettingsScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (GeneralSettingsScreen.kt:231)");
        }
        String strD = it.d();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return strD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z(int i3, Composer composer, int i4) {
        A(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void b0(FragmentManager fragmentManager, boolean z2, Function0 function0) {
        if (z2) {
            function0.invoke();
        } else {
            DayBeginningSelectorDialog.f109545f.a().show(fragmentManager, "pref_day_beginning");
        }
    }

    public static final void c0(AppCompatActivity activity, EventTimePickerDialogFragment.EventType eventType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        EventTimePickerDialogFragment.f109567g.a(eventType).show(activity.getSupportFragmentManager(), eventType.name());
    }

    private static final void d0(Locale locale, FragmentManager fragmentManager) {
        LanguagePickerDialogFragment.f109591b.a(locale != null ? locale.toLanguageTag() : null).show(fragmentManager, Reflection.b(LanguagePickerDialogFragment.class).m());
    }

    private static final void e0(FragmentManager fragmentManager) {
        DayNightPickerDialogFragment.f109564b.a().show(fragmentManager, "pref_day_night_mode");
    }

    private static final void y(GeneralSettingsViewModel generalSettingsViewModel, final ScaffoldState scaffoldState, Composer composer, final int i3) {
        int i4;
        final GeneralSettingsViewModel generalSettingsViewModel2;
        Composer composerK = composer.k(1548911216);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(generalSettingsViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1548911216, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.generalSettings.CommandProcessor (GeneralSettingsScreen.kt:297)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScope = (CoroutineScope) objG;
            boolean zI = composerK.I(coroutineScope) | ((i4 & 112) == 32);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion.a()) {
                objG2 = new GeneralSettingsScreenKt$CommandProcessor$1$1(coroutineScope, scaffoldState, null);
                composerK.w(objG2);
            }
            generalSettingsViewModel2 = generalSettingsViewModel;
            FlowExtKt.g(generalSettingsViewModel2, null, (Function2) objG2, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            generalSettingsViewModel2 = generalSettingsViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.generalSettings.p
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return GeneralSettingsScreenKt.z(generalSettingsViewModel2, scaffoldState, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z(GeneralSettingsViewModel generalSettingsViewModel, ScaffoldState scaffoldState, int i3, Composer composer, int i4) {
        y(generalSettingsViewModel, scaffoldState, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }
}
