package cz.mobilesoft.coreblock.scene.dashboard.profile.account;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.BackHandlerKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.ScaffoldState;
import androidx.compose.material.TextFieldColors;
import androidx.compose.material.TextFieldDefaults;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.res.VectorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardCapitalization;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.navigation.NavBackStackEntry;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.enums.StrictModeTitleAlternatives;
import cz.mobilesoft.coreblock.scene.dashboard.profile.ProfileImageKt;
import cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailViewEvent;
import cz.mobilesoft.coreblock.util.Loading;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.FlowExtKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
import cz.mobilesoft.coreblock.util.media.SingleImageActivityContract;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeDialogsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
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
import kotlinx.coroutines.CoroutineScopeKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AccountDetailScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(Function0 function0, int i3, Composer composer, int i4) {
        z(function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void B(AccountDetailViewModel accountDetailViewModel, final ScaffoldState scaffoldState, final CoroutineScope coroutineScope, final Function0 function0, Composer composer, final int i3) {
        int i4;
        AccountDetailViewModel accountDetailViewModel2;
        Composer composerK = composer.k(-2040869791);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(accountDetailViewModel) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(coroutineScope) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2040869791, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.CommandProcessor (AccountDetailScreen.kt:189)");
            }
            boolean zI = ((i4 & 7168) == 2048) | composerK.I(coroutineScope) | ((i4 & 112) == 32);
            Object objG = composerK.G();
            if (zI || objG == Composer.f23746a.a()) {
                objG = new AccountDetailScreenKt$CommandProcessor$1$1(function0, coroutineScope, scaffoldState, null);
                composerK.w(objG);
            }
            accountDetailViewModel2 = accountDetailViewModel;
            FlowExtKt.g(accountDetailViewModel2, null, (Function2) objG, composerK, i4 & 14, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            accountDetailViewModel2 = accountDetailViewModel;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final AccountDetailViewModel accountDetailViewModel3 = accountDetailViewModel2;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccountDetailScreenKt.C(accountDetailViewModel3, scaffoldState, coroutineScope, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C(AccountDetailViewModel accountDetailViewModel, ScaffoldState scaffoldState, CoroutineScope coroutineScope, Function0 function0, int i3, Composer composer, int i4) {
        B(accountDetailViewModel, scaffoldState, coroutineScope, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void D(final androidx.compose.runtime.MutableState r26, final androidx.compose.material.ScaffoldState r27, final kotlin.jvm.functions.Function0 r28, final kotlin.jvm.functions.Function0 r29, kotlin.jvm.functions.Function0 r30, androidx.compose.runtime.Composer r31, final int r32, final int r33) {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailScreenKt.D(androidx.compose.runtime.MutableState, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E(MutableState mutableState, ScaffoldState scaffoldState, Function0 function0, Function0 function02, Function0 function03, int i3, int i4, Composer composer, int i5) {
        D(mutableState, scaffoldState, function0, function02, function03, composer, RecomposeScopeImplKt.a(i3 | 1), i4);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(final AccountDetailViewState accountDetailViewState, final ScaffoldState scaffoldState, Function1 function1, final Function0 function0, final CoroutineScope coroutineScope, final ManagedActivityResultLauncher managedActivityResultLauncher, Composer composer, final int i3) {
        int i4;
        final Function0 function02;
        Composer composer2;
        String str;
        final Function1 function12 = function1;
        Composer composerK = composer.k(-572712574);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(accountDetailViewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(scaffoldState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function12) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(coroutineScope) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((196608 & i3) == 0) {
            i4 |= (262144 & i3) == 0 ? composerK.Z(managedActivityResultLauncher) : composerK.I(managedActivityResultLauncher) ? 131072 : NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (composerK.r((74899 & i4) != 74898, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-572712574, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.RootCompose (AccountDetailScreen.kt:224)");
            }
            String strB = StringResources_androidKt.b(StrictModeTitleAlternatives.Companion.a(), composerK, 0);
            String strD = accountDetailViewState.d();
            if (strD == null) {
                strD = "";
            }
            boolean Z = composerK.Z(strD);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(strD, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            Object objG3 = composerK.G();
            if (objG3 == companion.a()) {
                MutableState mutableStateE = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(mutableStateE);
                objG3 = mutableStateE;
            }
            final MutableState mutableState3 = (MutableState) objG3;
            Object objG4 = composerK.G();
            if (objG4 == companion.a()) {
                str = strB;
                objG4 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG4);
            } else {
                str = strB;
            }
            final MutableState mutableState4 = (MutableState) objG4;
            boolean Z2 = composerK.Z(strD);
            Object objG5 = composerK.G();
            if (Z2 || objG5 == companion.a()) {
                objG5 = SnapshotStateKt__SnapshotStateKt.e(Boolean.valueOf(strD.length() > 0), null, 2, null);
                composerK.w(objG5);
            }
            final MutableState mutableState5 = (MutableState) objG5;
            final SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) composerK.q(CompositionLocalsKt.q());
            final boolean z2 = !accountDetailViewState.g();
            boolean zG = accountDetailViewState.g();
            Object objG6 = composerK.G();
            if (objG6 == companion.a()) {
                objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.c
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.b0();
                    }
                };
                composerK.w(objG6);
            }
            BackHandlerKt.a(zG, (Function0) objG6, composerK, 48, 0);
            SingleImageActivityContract singleImageActivityContract = new SingleImageActivityContract();
            int i5 = i4 & 896;
            boolean z3 = i5 == 256;
            Object objG7 = composerK.G();
            if (z3 || objG7 == companion.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccountDetailScreenKt.c0(function12, (Uri) obj);
                    }
                };
                composerK.w(objG7);
            }
            final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(singleImageActivityContract, (Function1) objG7, composerK, SingleImageActivityContract.f128864a);
            Modifier modifierD = WindowInsetsPaddingKt.d(Modifier.b8, WindowInsets_androidKt.c(WindowInsets.f7172a, composerK, 6));
            int i6 = i4;
            ComposableLambda composableLambdaE = ComposableLambdaKt.e(958980445, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccountDetailScreenKt.H(z2, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54);
            ComposableLambda composableLambdaE2 = ComposableLambdaKt.e(1404517756, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccountDetailScreenKt.J(accountDetailViewState, z2, mutableState5, function12, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54);
            Function3 function3H = ComposableSingletons$AccountDetailScreenKt.f101173a.h();
            composer2 = composerK;
            boolean z4 = true;
            final String str2 = str;
            Function3 function3 = new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.v
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AccountDetailScreenKt.L(softwareKeyboardController, z2, mutableState, function12, accountDetailViewState, coroutineScope, scaffoldState, str2, mutableState4, managedActivityResultLauncherA, managedActivityResultLauncher, mutableState2, mutableState3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            function12 = function12;
            ScaffoldKt.a(modifierD, scaffoldState, composableLambdaE, composableLambdaE2, function3H, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.e(762628228, true, function3, composer2, 54), composer2, (i6 & 112) | 28032, 12582912, 131040);
            String strB2 = StringResources_androidKt.b(R.string.es, composer2, 0);
            String strB3 = StringResources_androidKt.b(R.string.tx, composer2, 0);
            boolean z5 = (i5 == 256) | ((i6 & 7168) == 2048);
            Object objG8 = composer2.G();
            if (z5 || objG8 == companion.a()) {
                function02 = function0;
                objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.w
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.W(function12, function02);
                    }
                };
                composer2.w(objG8);
            } else {
                function02 = function0;
            }
            ComposeDialogsKt.x0(mutableState2, strB2, null, null, strB3, 0L, false, (Function0) objG8, null, 0L, null, composer2, 390, 0, 1896);
            String strB4 = StringResources_androidKt.b(R.string.Tb, composer2, 0);
            String strB5 = StringResources_androidKt.b(R.string.r9, composer2, 0);
            if (i5 != 256) {
                z4 = false;
            }
            Object objG9 = composer2.G();
            if (z4 || objG9 == companion.a()) {
                objG9 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.x
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.X(function12);
                    }
                };
                composer2.w(objG9);
            }
            ComposeDialogsKt.x0(mutableState3, strB4, null, null, strB5, 0L, z2, (Function0) objG9, null, 0L, null, composer2, 390, 0, 1832);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function02 = function0;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            final Function0 function03 = function02;
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccountDetailScreenKt.Y(accountDetailViewState, scaffoldState, function12, function03, coroutineScope, managedActivityResultLauncher, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String G(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H(boolean z2, final Function0 function0, Composer composer, int i3) throws XmlPullParserException, IOException {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(958980445, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.RootCompose.<anonymous> (AccountDetailScreen.kt:261)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierH);
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
            Updater.e(composerA, modifierF, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierF2 = boxScopeInstance.f(companion, companion2.h());
            ImageVector imageVectorB = VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.C1, composer, 6);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.a0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.I(function0);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.q0(modifierF2, imageVectorB, null, z2, 0.0f, 0.0f, 0L, null, (Function0) objG, composer, 0, 244);
            TextKt.c(StringResources_androidKt.b(R.string.f95834q, composer, 0), boxScopeInstance.f(companion, companion2.e()), ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65528);
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
    public static final Unit I(Function0 function0) {
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J(AccountDetailViewState accountDetailViewState, final boolean z2, final MutableState mutableState, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1404517756, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.RootCompose.<anonymous> (AccountDetailScreen.kt:281)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 8;
            Modifier modifierM = PaddingKt.m(PaddingKt.j(companion, PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), Dp.g(f3)), 0.0f, 0.0f, 0.0f, Dp.g(f3), 7, null);
            MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            Updater.e(composerA, measurePolicyG, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            ButtonType.ProgressButton progressButton = new ButtonType.ProgressButton(StringResources_androidKt.b(R.string.Lt, composer, 0), null, Intrinsics.areEqual(accountDetailViewState.f(), Loading.f127895a), 2, null);
            ButtonColor.Accent accent = new ButtonColor.Accent(a0(mutableState) && z2, null, false, null, 14, null);
            boolean Z = composer.Z(mutableState) | composer.b(z2) | composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.z
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.K(z2, function1, mutableState);
                    }
                };
                composer.w(objG);
            }
            ComposeButtonsKt.i0(modifierH, progressButton, accent, (Function0) objG, composer, 6, 0);
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
    public static final Unit K(boolean z2, Function1 function1, MutableState mutableState) {
        if (a0(mutableState) && z2) {
            function1.invoke(AccountDetailViewEvent.UpdateUserProfile.f101120a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(final SoftwareKeyboardController softwareKeyboardController, final boolean z2, final MutableState mutableState, final Function1 function1, final AccountDetailViewState accountDetailViewState, final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, final String str, final MutableState mutableState2, final ManagedActivityResultLauncher managedActivityResultLauncher, final ManagedActivityResultLauncher managedActivityResultLauncher2, final MutableState mutableState3, final MutableState mutableState4, PaddingValues it, Composer composer, int i3) {
        int i4;
        Function0 function0;
        AccountDetailViewState accountDetailViewState2;
        final AccountDetailViewState accountDetailViewState3;
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(it) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(762628228, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.RootCompose.<anonymous> (AccountDetailScreen.kt:305)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(ScrollKt.g(SizeKt.f(PaddingKt.h(companion, it), 0.0f, 1, null), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), PrimitiveResources_androidKt.a(R.dimen.f95467a, composer, 0), 0.0f, 2, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierK);
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
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = InteractionSourceKt.a();
                composer.w(objG);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objG;
            Modifier modifierV = SizeKt.v(boxScopeInstance.f(companion, companion2.e()), Dp.g(100));
            Object objG2 = composer.G();
            if (objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.d
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.M(mutableState2);
                    }
                };
                composer.w(objG2);
            }
            Modifier modifierD = ClickableKt.d(modifierV, mutableInteractionSource, null, z2, null, null, (Function0) objG2, 24, null);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion2.o(), false);
            int iA3 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU3 = composer.u();
            Modifier modifierF3 = ComposedModifierKt.f(composer, modifierD);
            Function0 function0A3 = companion3.a();
            if (composer.m() == null) {
                ComposablesKt.c();
            }
            composer.L();
            if (composer.i()) {
                composer.P(function0A3);
            } else {
                composer.v();
            }
            Composer composerA3 = Updater.a(composer);
            Updater.e(composerA3, measurePolicyG2, companion3.e());
            Updater.e(composerA3, compositionLocalMapU3, companion3.g());
            Function2 function2B3 = companion3.b();
            if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                composerA3.w(Integer.valueOf(iA3));
                composerA3.p(Integer.valueOf(iA3), function2B3);
            }
            Updater.e(composerA3, modifierF3, companion3.f());
            ProfileImageKt.A(boxScopeInstance, false, accountDetailViewState.e(), null, composer, 6, 5);
            ImageKt.b(VectorResources_androidKt.b(ImageVector.f26323k, R.drawable.f95539m1, composer, 6), "Camera icon", PaddingKt.i(BackgroundKt.c(PaddingKt.i(boxScopeInstance.f(companion, companion2.c()), Dp.g(3)), ComposeColorsKt.j(composer, 0).b(), RoundedCornerShapeKt.g()), Dp.g(8)), null, null, 0.0f, null, composer, 48, 120);
            boolean zI = composer.I(managedActivityResultLauncher);
            Object objG3 = composer.G();
            if (zI || objG3 == companion4.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.e
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.N(managedActivityResultLauncher);
                    }
                };
                composer.w(objG3);
            }
            Function0 function02 = (Function0) objG3;
            boolean zI2 = composer.I(managedActivityResultLauncher2);
            Object objG4 = composer.G();
            if (zI2 || objG4 == companion4.a()) {
                objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.f
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.O(managedActivityResultLauncher2);
                    }
                };
                composer.w(objG4);
            }
            Function0 function03 = (Function0) objG4;
            if (accountDetailViewState.e().a()) {
                composer.a0(319751099);
                composer.U();
                function0 = null;
            } else {
                composer.a0(319769514);
                boolean Z = composer.Z(function1);
                Object objG5 = composer.G();
                if (Z || objG5 == companion4.a()) {
                    objG5 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.g
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AccountDetailScreenKt.P(function1);
                        }
                    };
                    composer.w(objG5);
                }
                function0 = (Function0) objG5;
                composer.U();
            }
            D(mutableState2, scaffoldState, function02, function03, function0, composer, 6, 0);
            composer.y();
            composer.y();
            float f3 = 24;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            Modifier modifierH2 = SizeKt.h(companion, 0.0f, 1, null);
            float f4 = 16;
            RoundedCornerShape roundedCornerShapeD = RoundedCornerShapeKt.d(Dp.g(f4));
            String strG = G(mutableState);
            MaterialTheme materialTheme = MaterialTheme.f13091a;
            int i5 = MaterialTheme.f13092b;
            TextStyle textStyleE = TextStyle.e(materialTheme.c(composer, i5).g(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, TextAlign.f29616b.a(), 0, 0L, null, null, null, 0, 0, null, 16744447, null);
            TextFieldColors textFieldColorsH0 = h0(composer, 0);
            KeyboardOptions keyboardOptionsD = KeyboardOptions.d(KeyboardOptions.f9764h.a(), KeyboardCapitalization.f29372b.e(), null, KeyboardType.f29379b.h(), ImeAction.f29348b.b(), null, null, null, 114, null);
            boolean Z2 = composer.Z(softwareKeyboardController);
            Object objG6 = composer.G();
            if (Z2 || objG6 == companion4.a()) {
                objG6 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.h
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccountDetailScreenKt.Q(softwareKeyboardController, (KeyboardActionScope) obj);
                    }
                };
                composer.w(objG6);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG6, null, null, null, null, null, 62, null);
            boolean zB = composer.b(z2) | composer.Z(mutableState) | composer.Z(function1);
            Object objG7 = composer.G();
            if (zB || objG7 == companion4.a()) {
                objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccountDetailScreenKt.R(z2, function1, mutableState, (String) obj);
                    }
                };
                composer.w(objG7);
            }
            ComposableSingletons$AccountDetailScreenKt composableSingletons$AccountDetailScreenKt = ComposableSingletons$AccountDetailScreenKt.f101173a;
            ComposeTextFieldsKt.h(strG, (Function1) objG7, modifierH2, z2, false, false, textStyleE, null, composableSingletons$AccountDetailScreenKt.i(), null, null, false, null, keyboardOptionsD, keyboardActions, true, 1, null, roundedCornerShapeD, null, textFieldColorsH0, 0L, 0.0f, 0.0f, composer, 100663680, 1769472, 0, 15343280);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f3)), composer, 6);
            TextKt.c(StringResources_androidKt.b(R.string.f95834q, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f4)), composer, 6);
            Modifier modifierH3 = SizeKt.h(companion, 0.0f, 1, null);
            RoundedCornerShape roundedCornerShapeD2 = RoundedCornerShapeKt.d(Dp.g(f4));
            String strC = accountDetailViewState.c();
            TextStyle textStyleE2 = TextStyle.e(materialTheme.c(composer, i5).a(), ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777214, null);
            TextFieldColors textFieldColorsH02 = h0(composer, 0);
            Object objG8 = composer.G();
            if (objG8 == companion4.a()) {
                objG8 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AccountDetailScreenKt.S((String) obj);
                    }
                };
                composer.w(objG8);
            }
            ComposeTextFieldsKt.h(strC, (Function1) objG8, modifierH3, false, true, false, textStyleE2, null, null, composableSingletons$AccountDetailScreenKt.j(), null, false, null, null, null, false, 0, null, roundedCornerShapeD2, null, textFieldColorsH02, 0L, 0.0f, 0.0f, composer, 805334448, 0, 0, 15465888);
            float f5 = 32;
            SpacerKt.a(SizeKt.v(companion, Dp.g(f5)), composer, 6);
            Modifier modifierC = columnScopeInstance.c(companion, companion2.g());
            ButtonType.TinyRound tinyRound = new ButtonType.TinyRound(null, null, StringResources_androidKt.b(R.string.tx, composer, 0), 3, null);
            ButtonColor.Surface surface = new ButtonColor.Surface(z2, null, false, null, Color.n(ComposeColorsKt.j(composer, 0).b()), 14, null);
            boolean zB2 = composer.b(z2) | composer.Z(accountDetailViewState) | composer.I(coroutineScope) | composer.Z(scaffoldState) | composer.Z(str);
            Object objG9 = composer.G();
            if (zB2 || objG9 == companion4.a()) {
                Function0 function04 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.k
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.T(z2, accountDetailViewState, coroutineScope, mutableState3, scaffoldState, str);
                    }
                };
                accountDetailViewState2 = accountDetailViewState;
                composer.w(function04);
                objG9 = function04;
            } else {
                accountDetailViewState2 = accountDetailViewState;
            }
            ComposeButtonsKt.i0(modifierC, tinyRound, surface, (Function0) objG9, composer, 0, 0);
            SpacerKt.a(SizeKt.v(companion, Dp.g(f5)), composer, 6);
            Modifier modifierC2 = columnScopeInstance.c(companion, companion2.g());
            boolean Z3 = composer.Z(accountDetailViewState2) | composer.I(coroutineScope) | composer.Z(scaffoldState) | composer.Z(str);
            Object objG10 = composer.G();
            if (Z3 || objG10 == companion4.a()) {
                final AccountDetailViewState accountDetailViewState4 = accountDetailViewState2;
                Function0 function05 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AccountDetailScreenKt.U(accountDetailViewState4, coroutineScope, mutableState4, scaffoldState, str);
                    }
                };
                accountDetailViewState3 = accountDetailViewState4;
                composer.w(function05);
                objG10 = function05;
            } else {
                accountDetailViewState3 = accountDetailViewState2;
            }
            ButtonKt.c((Function0) objG10, modifierC2, z2, null, null, null, null, null, null, ComposableLambdaKt.e(1724187953, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.m
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AccountDetailScreenKt.V(accountDetailViewState3, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805306368, 504);
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
    public static final Unit M(MutableState mutableState) {
        mutableState.setValue(Boolean.TRUE);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N(ManagedActivityResultLauncher managedActivityResultLauncher) {
        AnswersHelper.f128199a.i4();
        managedActivityResultLauncher.b(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O(ManagedActivityResultLauncher managedActivityResultLauncher) {
        AnswersHelper.f128199a.j4();
        managedActivityResultLauncher.b("android.permission.CAMERA");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P(Function1 function1) {
        AnswersHelper.f128199a.h4();
        function1.invoke(new AccountDetailViewEvent.UpdateProfilePicture(null));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q(SoftwareKeyboardController softwareKeyboardController, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        if (softwareKeyboardController != null) {
            softwareKeyboardController.a();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R(boolean z2, Function1 function1, MutableState mutableState, String newValue) {
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        if (z2 && newValue.length() <= 250) {
            Z(mutableState, newValue);
            function1.invoke(new AccountDetailViewEvent.UpdateUserNickname(newValue));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T(boolean z2, AccountDetailViewState accountDetailViewState, CoroutineScope coroutineScope, MutableState mutableState, ScaffoldState scaffoldState, String str) {
        if (!z2) {
            return Unit.f139807a;
        }
        if (accountDetailViewState.h()) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AccountDetailScreenKt$RootCompose$4$1$5$1$1(scaffoldState, str, null), 3, null);
        } else {
            mutableState.setValue(Boolean.TRUE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U(AccountDetailViewState accountDetailViewState, CoroutineScope coroutineScope, MutableState mutableState, ScaffoldState scaffoldState, String str) {
        if (accountDetailViewState.h()) {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AccountDetailScreenKt$RootCompose$4$1$6$1$1(scaffoldState, str, null), 3, null);
        } else {
            mutableState.setValue(Boolean.TRUE);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V(AccountDetailViewState accountDetailViewState, RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1724187953, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.RootCompose.<anonymous>.<anonymous>.<anonymous> (AccountDetailScreen.kt:465)");
            }
            if (accountDetailViewState.g()) {
                composer.a0(1769471722);
                ProgressIndicatorKt.b(SizeKt.v(Modifier.b8, Dp.g(24)), ComposeColorsKt.j(composer, 0).b(), 0.0f, 0L, 0, composer, 6, 28);
                composer.U();
            } else {
                composer.a0(1769699603);
                TextKt.c(StringResources_androidKt.b(R.string.r9, composer, 0), null, ComposeColorsKt.j(composer, 0).s(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f13091a.c(composer, MaterialTheme.f13092b).b(), composer, 196608, 0, 65498);
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
    public static final Unit W(Function1 function1, Function0 function0) {
        function1.invoke(AccountDetailViewEvent.SignOut.f101117a);
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X(Function1 function1) {
        function1.invoke(AccountDetailViewEvent.DeleteAccount.f101116a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y(AccountDetailViewState accountDetailViewState, ScaffoldState scaffoldState, Function1 function1, Function0 function0, CoroutineScope coroutineScope, ManagedActivityResultLauncher managedActivityResultLauncher, int i3, Composer composer, int i4) {
        F(accountDetailViewState, scaffoldState, function1, function0, coroutineScope, managedActivityResultLauncher, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void Z(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final boolean a0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b0() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c0(Function1 function1, Uri uri) {
        if (uri != null) {
            function1.invoke(new AccountDetailViewEvent.UpdateProfilePicture(uri));
        }
        return Unit.f139807a;
    }

    private static final ManagedActivityResultLauncher e0(final Function1 function1, final AccountDetailViewModel accountDetailViewModel, final CoroutineScope coroutineScope, final ScaffoldState scaffoldState, Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1201232539, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.getCameraLauncher (AccountDetailScreen.kt:154)");
        }
        final Context context = (Context) composer.q(AndroidCompositionLocals_androidKt.g());
        ActivityResultContracts.TakePicture takePicture = new ActivityResultContracts.TakePicture();
        boolean z2 = true;
        boolean zI = ((((i3 & 14) ^ 6) > 4 && composer.Z(function1)) || (i3 & 6) == 4) | composer.I(accountDetailViewModel);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AccountDetailScreenKt.f0(function1, accountDetailViewModel, ((Boolean) obj).booleanValue());
                }
            };
            composer.w(objG);
        }
        final ManagedActivityResultLauncher managedActivityResultLauncherA = ActivityResultRegistryKt.a(takePicture, (Function1) objG, composer, 0);
        ActivityResultContracts.RequestPermission requestPermission = new ActivityResultContracts.RequestPermission();
        boolean zI2 = composer.I(managedActivityResultLauncherA) | composer.I(accountDetailViewModel) | composer.I(context) | composer.I(coroutineScope);
        if ((((i3 & 7168) ^ 3072) <= 2048 || !composer.Z(scaffoldState)) && (i3 & 3072) != 2048) {
            z2 = false;
        }
        boolean z3 = zI2 | z2;
        Object objG2 = composer.G();
        if (z3 || objG2 == Composer.f23746a.a()) {
            objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return AccountDetailScreenKt.g0(managedActivityResultLauncherA, accountDetailViewModel, context, coroutineScope, scaffoldState, ((Boolean) obj).booleanValue());
                }
            };
            composer.w(objG2);
        }
        ManagedActivityResultLauncher managedActivityResultLauncherA2 = ActivityResultRegistryKt.a(requestPermission, (Function1) objG2, composer, 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return managedActivityResultLauncherA2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f0(Function1 function1, AccountDetailViewModel accountDetailViewModel, boolean z2) {
        if (z2) {
            function1.invoke(new AccountDetailViewEvent.UpdateProfilePicture(accountDetailViewModel.h1()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g0(ManagedActivityResultLauncher managedActivityResultLauncher, AccountDetailViewModel accountDetailViewModel, Context context, CoroutineScope coroutineScope, ScaffoldState scaffoldState, boolean z2) {
        if (z2) {
            managedActivityResultLauncher.b(accountDetailViewModel.i1(context));
        } else {
            BuildersKt__Builders_commonKt.d(coroutineScope, null, null, new AccountDetailScreenKt$getCameraLauncher$permissionsLauncher$1$1$1(scaffoldState, context, null), 3, null);
        }
        return Unit.f139807a;
    }

    private static final TextFieldColors h0(Composer composer, int i3) {
        if (ComposerKt.M()) {
            ComposerKt.U(-1530398146, i3, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.surfaceTextFieldColors (AccountDetailScreen.kt:506)");
        }
        TextFieldDefaults textFieldDefaults = TextFieldDefaults.f14636a;
        long jL0 = ComposeColorsKt.j(composer, 0).l0();
        Color.Companion companion = Color.f25715b;
        TextFieldColors textFieldColorsO = textFieldDefaults.o(0L, 0L, jL0, 0L, 0L, companion.j(), companion.j(), companion.j(), companion.j(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 115015680, 0, 48, 2096667);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return textFieldColorsO;
    }

    public static final void z(Function0 onRequestDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Bundle bundleB;
        Intrinsics.checkNotNullParameter(onRequestDismiss, "onRequestDismiss");
        Composer composerK = composer.k(1977958049);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onRequestDismiss) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if (composerK.r((i4 & 3) != 2, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1977958049, i4, -1, "cz.mobilesoft.coreblock.scene.dashboard.profile.account.AccountDetailScreen (AccountDetailScreen.kt:118)");
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
            KClass kClassB = Reflection.b(AccountDetailViewModel.class);
            ViewModelStore viewModelStore = viewModelStoreOwnerC.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "viewModelStoreOwner.viewModelStore");
            ViewModel viewModelA = GetViewModelKt.a(kClassB, viewModelStore, null, creationExtrasA2 == null ? creationExtrasA : creationExtrasA2, null, scopeD, null);
            composerK.Y();
            composerK.Y();
            AccountDetailViewModel accountDetailViewModel = (AccountDetailViewModel) viewModelA;
            AccountDetailViewState accountDetailViewState = (AccountDetailViewState) FlowExtKt.m(accountDetailViewModel, composerK, 0);
            Function1 function1N = FlowExtKt.n(accountDetailViewModel, composerK, 0);
            ScaffoldState scaffoldStateG = ScaffoldKt.g(null, null, composerK, 0, 3);
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = EffectsKt.l(EmptyCoroutineContext.f139889a, composerK);
                composerK.w(objG);
            }
            CoroutineScope coroutineScopeI = CoroutineScopeKt.i((CoroutineScope) objG, CoroutinesHelperExtKt.b());
            int i5 = (i4 << 9) & 7168;
            B(accountDetailViewModel, scaffoldStateG, coroutineScopeI, onRequestDismiss, composerK, i5);
            function0 = onRequestDismiss;
            F(accountDetailViewState, scaffoldStateG, function1N, function0, coroutineScopeI, e0(function1N, accountDetailViewModel, coroutineScopeI, scaffoldStateG, composerK, 0), composerK, i5 | (ManagedActivityResultLauncher.f461c << 15));
            composerK = composerK;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onRequestDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.dashboard.profile.account.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AccountDetailScreenKt.A(function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
