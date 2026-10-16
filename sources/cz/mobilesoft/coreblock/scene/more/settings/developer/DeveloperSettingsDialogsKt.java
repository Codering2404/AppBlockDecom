package cz.mobilesoft.coreblock.scene.more.settings.developer;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.OutlinedTextFieldDefaults;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.RadioButtonDefaults;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SheetState;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.activity.rating.RatingDialogType;
import cz.mobilesoft.coreblock.enums.PremiumDevState;
import cz.mobilesoft.coreblock.enums.RevenueCatOffering;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewEvent;
import cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsViewState;
import cz.mobilesoft.coreblock.scene.more.settings.developer.streaks.StreakDebugSeedPattern;
import cz.mobilesoft.coreblock.scene.more.settings.dialog.InAppUpdateMockSettingsDialogKt;
import cz.mobilesoft.coreblock.scene.onboarding.OnboardingFlowVariant;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevPrefState;
import cz.mobilesoft.coreblock.util.compose.ComposeTypographyKt;
import cz.mobilesoft.coreblock.util.compose.colors.ComposeColorsKt;
import cz.mobilesoft.coreblock.util.constants.WhatsNewData;
import cz.mobilesoft.coreblock.util.updates.InAppUpdatesMockSettingsDTO;
import cz.mobilesoft.coreblock.view.compose.ButtonColor;
import cz.mobilesoft.coreblock.view.compose.ButtonType;
import cz.mobilesoft.coreblock.view.compose.ComposeBottomSheetsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeButtonsKt;
import cz.mobilesoft.coreblock.view.compose.ComposeTextFieldsKt;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonColors;
import cz.mobilesoft.coreblock.view.compose.material3.FlatButtonsKt;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class DeveloperSettingsDialogsKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f108277a;

        static {
            int[] iArr = new int[DeveloperSettingsViewState.DeveloperDialogType.values().length];
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowPremiumStateDialog.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowPremiumProductDialog.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowStreakSeedDialog.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowActivateCampaignDialog.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowQuestionnaireDialog.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowTestTargetingGroupDialog.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowTimeChangeLimitDialog.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowRemoteConfigMockDialog.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowParseSupportJsonDialog.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowInAppUpdatesMockDialog.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowWhatsNewVersionsDialog.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowAdsDialog.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowSkipDiscountTimerDialog.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.OverridePaywallSettings.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowAllDiscountsDialog.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowIntroDialog.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowWhatsNewCard.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowAniaInfoDialog.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowForceRatingDialogType.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[DeveloperSettingsViewState.DeveloperDialogType.ShowOnboardingFlowVariantDialog.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            f108277a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A1(Function1 function1, DevPrefState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnOverridePaywallSettingsSelected(it));
        return Unit.f139807a;
    }

    private static final void A2(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit B2(final MutableState mutableState, Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2115739115, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.QuestionnaireConfigDialog.<anonymous> (DeveloperSettingsDialogs.kt:702)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierI = PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(f4));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            TextKt.c(StringResources_androidKt.b(R.string.La, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strZ2 = z2(mutableState);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.z2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.C2(mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.b(strZ2, (Function1) objG, SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(200)), false, false, null, null, ComposableSingletons$DeveloperSettingsDialogsKt.f108252a.n(), null, null, null, null, null, false, null, null, null, false, 0, 0, null, null, OutlinedTextFieldDefaults.f18898a.e(ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).p(), 0L, 0L, 0L, 0L, 0L, 0L, ComposeColorsKt.j(composer, 0).b(), 0L, null, ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).q(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 2147477244, 4095), composer, 12583344, 0, 0, 4194168);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.u(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8110);
            SpacerKt.a(SizeKt.A(companion, Dp.g(8)), composer, 6);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.D2(function1, mutableState);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierC, 0.0f, 0.0f, null, primary, null, strB, null, 0L, null, null, false, false, (Function0) objG2, composer, 24576, 0, 8110);
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
    public static final Unit C1(Function1 function1, DevPrefState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnShowAllDiscountsStateSelected(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit C2(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        A2(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D2(Function1 function1, MutableState mutableState) {
        function1.invoke(z2(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E1(Function1 function1, DevPrefState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnShowIntroStateSelected(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit E2(String str, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        y2(str, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit F1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    public static final void F2(final String initialValue, final Function1 onSave, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(1395471833);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(initialValue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onSave) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1395471833, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RemoteConfigMockDialog (DeveloperSettingsDialogs.kt:861)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(initialValue, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(1094465392, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.I2(mutableState, onDismiss, onSave, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.L2(initialValue, onSave, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit G1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    private static final String G2(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit H1(Function1 function1, DevPrefState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnWhatsNewCardStateSelected(it));
        return Unit.f139807a;
    }

    private static final void H2(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I2(final MutableState mutableState, Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1094465392, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.RemoteConfigMockDialog.<anonymous> (DeveloperSettingsDialogs.kt:865)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierI = PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(f4));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            TextKt.c(StringResources_androidKt.b(R.string.Oa, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strG2 = G2(mutableState);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.J2(mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.b(strG2, (Function1) objG, SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(200)), false, false, null, null, ComposableSingletons$DeveloperSettingsDialogsKt.f108252a.k(), null, null, null, null, null, false, null, null, null, false, 0, 0, null, null, OutlinedTextFieldDefaults.f18898a.e(ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).p(), 0L, 0L, 0L, 0L, 0L, 0L, ComposeColorsKt.j(composer, 0).b(), 0L, null, ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).q(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 2147477244, 4095), composer, 12583344, 0, 0, 4194168);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.u(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8110);
            SpacerKt.a(SizeKt.A(companion, Dp.g(8)), composer, 6);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.K2(function1, mutableState);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierC, 0.0f, 0.0f, null, primary, null, strB, null, 0L, null, null, false, false, (Function0) objG2, composer, 24576, 0, 8110);
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
    public static final Unit J1(Function1 function1, DevPrefState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnShowAniaInfoDialogStateSelected(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J2(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        H2(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K2(Function1 function1, MutableState mutableState) {
        function1.invoke(G2(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L1(Function1 function1, RatingDialogType ratingDialogType) {
        function1.invoke(new DeveloperSettingsViewEvent.OnForceRatingDialogTypeSelected(ratingDialogType));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L2(String str, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        F2(str, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    public static final void M2(final Function1 onPatternEntered, Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onPatternEntered, "onPatternEntered");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(-1704431005);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onPatternEntered) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDismiss) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1704431005, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.StreakSeedBottomSheet (DeveloperSettingsDialogs.kt:1141)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e("5", null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            boolean Z = composerK.Z(N2(mutableState));
            Object objG2 = composerK.G();
            if (Z || objG2 == companion.a()) {
                objG2 = StreakDebugSeedPattern.f109420a.e(N2(mutableState));
                composerK.w(objG2);
            }
            final StreakDebugSeedPattern.Result result = (StreakDebugSeedPattern.Result) objG2;
            final boolean z2 = result instanceof StreakDebugSeedPattern.Result.Parsed;
            boolean zI = composerK.I(result) | ((i4 & 14) == 4);
            Object objG3 = composerK.G();
            if (zI || objG3 == companion.a()) {
                objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.P2(result, onPatternEntered);
                    }
                };
                composerK.w(objG3);
            }
            final Function0 function02 = (Function0) objG3;
            function0 = onDismiss;
            ComposeBottomSheetsKt.f(null, null, true, ComposableLambdaKt.e(-156550844, true, new Function4() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o0
                @Override // kotlin.jvm.functions.Function4
                public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    return DeveloperSettingsDialogsKt.Q2(z2, function02, result, mutableState, (ColumnScope) obj, (SheetState) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerK, 54), null, function0, composerK, ((i4 << 12) & 458752) | 3456, 19);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.z0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.T2(onPatternEntered, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N1(Function1 function1, OnboardingFlowVariant it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnOnboardingFlowVariantSelected(it));
        return Unit.f139807a;
    }

    private static final String N2(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    private static final void O2(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(DeveloperSettingsViewState developerSettingsViewState, Function1 function1, int i3, Composer composer, int i4) {
        h1(developerSettingsViewState, function1, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P2(StreakDebugSeedPattern.Result result, Function1 function1) {
        if (result instanceof StreakDebugSeedPattern.Result.Parsed) {
            function1.invoke(((StreakDebugSeedPattern.Result.Parsed) result).a());
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q1(Function1 function1, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnStreakSeedPatternEntered(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q2(boolean z2, final Function0 function0, StreakDebugSeedPattern.Result result, final MutableState mutableState, ColumnScope AppBottomSheet, SheetState it, Composer composer, int i3) {
        int i4;
        Composer composer2;
        Intrinsics.checkNotNullParameter(AppBottomSheet, "$this$AppBottomSheet");
        Intrinsics.checkNotNullParameter(it, "it");
        if ((i3 & 6) == 0) {
            i4 = i3 | (composer.Z(AppBottomSheet) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if (composer.r((i4 & 131) != 130, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-156550844, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.StreakSeedBottomSheet.<anonymous> (DeveloperSettingsDialogs.kt:1159)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 8;
            Modifier modifierM = PaddingKt.m(PaddingKt.k(ScrollKt.g(AppBottomSheet.a(companion, 1.0f, false), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null), Dp.g(f3), 0.0f, 2, null), 0.0f, Dp.g(f4), 0.0f, 0.0f, 13, null);
            Arrangement.Vertical verticalH = Arrangement.f6574a.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierM);
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
            TextKt.c("Seed a streak history", null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).g(), composer, 6, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(4)), composer, 6);
            TextKt.c("One letter per day. The first letter is yesterday, and the pattern walks backwards from there.", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            float f5 = 12;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f5)), composer, 6);
            U2(composer, 0);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f5)), composer, 6);
            TextKt.c("Repeat counts allowed: 3o is three obtained days. Separators are optional. A bare number means that many obtained days.\n3o,l,3o  ·  5o,r,5o  ·  30  ·  20o,r,20o,r,19o for a long calendar", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strN2 = N2(mutableState);
            boolean z3 = !z2;
            TextStyle textStyleA = ComposeTypographyKt.g(composer, 0).a();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, 0, ImeAction.f29348b.b(), null, null, null, 119, null);
            boolean Z = composer.Z(function0);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.R2(function0, (KeyboardActionScope) obj);
                    }
                };
                composer.w(objG);
            }
            KeyboardActions keyboardActions = new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null);
            PaddingValues paddingValuesC = PaddingKt.c(Dp.g(f5), 0.0f, 2, null);
            Modifier modifierC = BackgroundKt.c(SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(56)), ComposeColorsKt.j(composer, 0).u(), RoundedCornerShapeKt.d(Dp.g(f3)));
            Object objG2 = composer.G();
            if (objG2 == Composer.f23746a.a()) {
                objG2 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.v1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.S2(mutableState, (String) obj);
                    }
                };
                composer.w(objG2);
            }
            ComposeTextFieldsKt.h(strN2, (Function1) objG2, modifierC, false, false, false, textStyleA, null, ComposableSingletons$DeveloperSettingsDialogsKt.f108252a.m(), null, null, z3, null, keyboardOptions, keyboardActions, true, 0, null, null, paddingValuesC, null, 0L, 0.0f, 0.0f, composer, 100859952, 805506048, 0, 16193176);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            if (result instanceof StreakDebugSeedPattern.Result.Parsed) {
                composer.a0(-1368994409);
                TextKt.c(StreakDebugSeedPattern.d(StreakDebugSeedPattern.f109420a, ((StreakDebugSeedPattern.Result.Parsed) result).a(), null, 2, null), null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 0, 0, 65530);
                composer2 = composer;
                composer2.U();
            } else {
                if (!(result instanceof StreakDebugSeedPattern.Result.Invalid)) {
                    composer.a0(1064215262);
                    composer.U();
                    throw new NoWhenBranchMatchedException();
                }
                composer.a0(-1368687292);
                TextKt.c(((StreakDebugSeedPattern.Result.Invalid) result).a(), null, Color.f25715b.i(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).d(), composer, 384, 0, 65530);
                composer2 = composer;
                composer2.U();
            }
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            composer2.y();
            Modifier modifierK = PaddingKt.k(WindowInsetsPadding_androidKt.a(companion), Dp.g(f3), 0.0f, 2, null);
            MeasurePolicy measurePolicyG = BoxKt.g(companion2.o(), false);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierK);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyG, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
            ComposeButtonsKt.i0(null, new ButtonType.Big(null, null, StringResources_androidKt.b(android.R.string.ok, composer2, 6), 0.0f, 11, null), new ButtonColor.Accent(z2, null, false, null, 14, null), function0, composer2, 0, 1);
            composer2.y();
            SpacerKt.a(SizeKt.i(companion, Dp.g(32)), composer2, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R2(Function0 function0, KeyboardActionScope KeyboardActions) {
        Intrinsics.checkNotNullParameter(KeyboardActions, "$this$KeyboardActions");
        function0.invoke();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S1(Function1 function1, long j3) {
        function1.invoke(new DeveloperSettingsViewEvent.OnCampaignIdEntered(j3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S2(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        O2(mutableState, it);
        return Unit.f139807a;
    }

    public static final void T0(final Function1 onCampaignIdEntered, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onCampaignIdEntered, "onCampaignIdEntered");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(-2134658459);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onCampaignIdEntered) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDismiss) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-2134658459, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ActivateCampaignDialog (DeveloperSettingsDialogs.kt:527)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(-1875166034, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.Y0(mutableState, mutableState2, onDismiss, onCampaignIdEntered, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 3) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.b1(onCampaignIdEntered, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T2(Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        M2(function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final String U0(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnQuestionnaireConfigSaved(it));
        return Unit.f139807a;
    }

    private static final void U2(Composer composer, final int i3) {
        Composer composerK = composer.k(-1678618163);
        if (composerK.r(i3 != 0, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1678618163, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.StreakSeedLegend (DeveloperSettingsDialogs.kt:1269)");
            }
            Modifier.Companion companion = Modifier.b8;
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, companion);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            W2("O", "Obtained — an hour blocked, or a qualifying schedule. Raises the count", composerK, 54);
            W2("R", "Rest — day missed, but a streak was running, so it survives. No count", composerK, 54);
            W2("I", "Inactive — day missed with no streak running. Nothing to keep alive", composerK, 54);
            W2("L", "Lost — a pause over 15 min, or a 4th pause. Kills the streak outright", composerK, 54);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.V2(i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void V0(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V2(int i3, Composer composer, int i4) {
        U2(composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final boolean W0(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    public static final void W1(final RatingDialogType ratingDialogType, final Function1 onTypeSelected, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onTypeSelected, "onTypeSelected");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(1180412331);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(ratingDialogType == null ? -1 : ratingDialogType.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onTypeSelected) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1180412331, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ForceRatingDialogTypeDialog (DeveloperSettingsDialogs.kt:1003)");
            }
            final List listListOf = CollectionsKt.listOf((Object[]) new DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option[]{new DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option(null, "App Decides (None)"), new DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option(RatingDialogType.Native, "Native (A)"), new DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option(RatingDialogType.RatingFlow, "RatingFlow (B)"), new DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option(RatingDialogType.SimpleDialog, "SimpleDialog (C)"), new DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option(RatingDialogType.RatingDialog, "RatingDialog (D)")});
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(928278324, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.X1(listListOf, onDismiss, onTypeSelected, ratingDialogType, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.a2(ratingDialogType, onTypeSelected, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void W2(final String str, String str2, Composer composer, final int i3) {
        int i4;
        final String str3;
        Composer composer2;
        Composer composerK = composer.k(196008131);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.Z(str) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str2) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(196008131, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.StreakSeedLegendRow (DeveloperSettingsDialogs.kt:1282)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierK = PaddingKt.k(companion, 0.0f, Dp.g(2), 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composerK, 48);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF = ComposedModifierKt.f(composerK, modifierK);
            ComposeUiNode.Companion companion2 = ComposeUiNode.f8;
            Function0 function0A = companion2.a();
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
            Updater.e(composerA, measurePolicyB, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            composer2 = composerK;
            TextKt.c(str, SizeKt.A(companion, Dp.g(40)), ComposeColorsKt.j(composerK, 0).p(), 0L, null, FontWeight.f29233b.b(), null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composerK, 0).d(), composer2, (i4 & 14) | 196656, 0, 65496);
            str3 = str2;
            TextKt.c(str3, null, ComposeColorsKt.j(composer2, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer2, (i4 >> 3) & 14, 0, 65530);
            composer2.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            str3 = str2;
            composer2 = composerK;
            composer2.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.r2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.X2(str, str3, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void X0(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X1(List list, Function0 function0, final Function1 function1, RatingDialogType ratingDialogType, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(928278324, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ForceRatingDialogTypeDialog.<anonymous> (DeveloperSettingsDialogs.kt:1015)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(24)), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c("Force Rating Dialog Type", null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 6, 0, 65530);
            Composer composer2 = composer;
            int i4 = 6;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            composer2.a0(1379054335);
            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                final DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option = (DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option) it.next();
                Modifier.Companion companion3 = Modifier.b8;
                float f4 = 8;
                Modifier modifierA = ClipKt.a(SizeKt.h(companion3, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(f4)));
                boolean Z = composer2.Z(function1) | composer2.Z(developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option);
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.r3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.Y1(function1, developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option);
                        }
                    };
                    composer2.w(objG);
                }
                Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), 0.0f, Dp.g(f4), 1, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierK);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
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
                Updater.e(composerA2, measurePolicyB, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                boolean z2 = developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option.b() == ratingDialogType;
                boolean Z2 = composer2.Z(function1) | composer2.Z(developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option);
                Object objG2 = composer2.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.s3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.Z1(function1, developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option);
                        }
                    };
                    composer2.w(objG2);
                }
                RadioButtonKt.a(z2, (Function0) objG2, null, false, RadioButtonDefaults.f19329a.b(ComposeColorsKt.j(composer2, 0).b(), ComposeColorsKt.j(composer2, 0).q(), 0L, 0L, composer2, RadioButtonDefaults.f19330b << 12, 12), null, composer, 0, 44);
                SpacerKt.a(SizeKt.A(companion3, Dp.g(f4)), composer, i4);
                TextKt.c(developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option.a(), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
                composer2 = composer;
                composer2.y();
                i4 = i4;
            }
            int i5 = i4;
            composer2.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer2, i5);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer2, i5), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8111);
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
    public static final Unit X2(String str, String str2, int i3, Composer composer, int i4) {
        W2(str, str2, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(final MutableState mutableState, final MutableState mutableState2, Function0 function0, final Function1 function1, Composer composer, int i3) {
        long jB;
        long jQ;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1875166034, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ActivateCampaignDialog.<anonymous> (DeveloperSettingsDialogs.kt:532)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierI = PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(f4));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            TextKt.c(StringResources_androidKt.b(R.string.N9, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strU0 = U0(mutableState);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, KeyboardType.f29379b.d(), 0, null, null, null, 123, null);
            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.f18898a;
            long jP = ComposeColorsKt.j(composer, 0).p();
            long jP2 = ComposeColorsKt.j(composer, 0).p();
            long jB2 = ComposeColorsKt.j(composer, 0).b();
            if (W0(mutableState2)) {
                composer.a0(1637539771);
                composer.U();
                jB = Color.f25715b.i();
            } else {
                composer.a0(1637540286);
                jB = ComposeColorsKt.j(composer, 0).b();
                composer.U();
            }
            long j3 = jB;
            if (W0(mutableState2)) {
                composer.a0(1637542715);
                composer.U();
                jQ = Color.f25715b.i();
            } else {
                composer.a0(1637543237);
                jQ = ComposeColorsKt.j(composer, 0).q();
                composer.U();
            }
            TextFieldColors textFieldColorsE = outlinedTextFieldDefaults.e(jP, jP2, 0L, 0L, 0L, 0L, 0L, 0L, jB2, 0L, null, j3, jQ, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 2147477244, 4095);
            boolean zW0 = W0(mutableState2);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.Z0(mutableState, mutableState2, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.b(strU0, (Function1) objG, modifierH, false, false, null, null, ComposableSingletons$DeveloperSettingsDialogsKt.f108252a.q(), null, null, null, null, null, zW0, null, keyboardOptions, null, true, 0, 0, null, null, textFieldColorsE, composer, 12583344, 12779520, 0, 4022136);
            Composer composer2 = composer;
            if (W0(mutableState2)) {
                composer2.a0(-775649186);
                SpacerKt.a(SizeKt.i(companion, Dp.g(4)), composer2, 6);
                TextKt.c("Please enter a valid number", null, Color.f25715b.i(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 390, 0, 65530);
                composer2 = composer;
            } else {
                composer2.a0(-801241174);
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer2, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer2, 0);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, companion);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.u(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer2, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8110);
            SpacerKt.a(SizeKt.A(companion, Dp.g(8)), composer, 6);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            String strB = StringResources_androidKt.b(android.R.string.ok, composer, 6);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.a1(function1, mutableState, mutableState2);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierC, 0.0f, 0.0f, null, primary, null, strB, null, 0L, null, null, false, false, (Function0) objG2, composer, 24576, 0, 8110);
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
    public static final Unit Y1(Function1 function1, DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option) {
        function1.invoke(developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option.b());
        return Unit.f139807a;
    }

    public static final void Y2(final String initialValue, final Function1 onSave, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(985079403);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(initialValue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onSave) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(985079403, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.TestTargetingGroupDialog (DeveloperSettingsDialogs.kt:619)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(initialValue, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(-519301566, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.b3(mutableState, onDismiss, onSave, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.e3(initialValue, onSave, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        V0(mutableState, it);
        X0(mutableState2, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z1(Function1 function1, DeveloperSettingsDialogsKt$ForceRatingDialogTypeDialog$Option developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option) {
        function1.invoke(developerSettingsDialogsKt$ForceRatingDialogTypeDialog$Option.b());
        return Unit.f139807a;
    }

    private static final String Z2(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a1(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        Long lW = StringsKt.w(U0(mutableState));
        if (lW != null) {
            function1.invoke(lW);
        } else {
            X0(mutableState2, true);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(RatingDialogType ratingDialogType, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        W1(ratingDialogType, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final void a3(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b1(Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        T0(function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    public static final void b2(final Function1 onVariantSelected, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onVariantSelected, "onVariantSelected");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(-18028862);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onVariantSelected) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDismiss) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-18028862, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.OnboardingFlowVariantDialog (DeveloperSettingsDialogs.kt:1073)");
            }
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(-80911847, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.c2(onDismiss, onVariantSelected, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 3) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.e2(onVariantSelected, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b3(final MutableState mutableState, Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-519301566, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.TestTargetingGroupDialog.<anonymous> (DeveloperSettingsDialogs.kt:623)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierI = PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(f4));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            TextKt.c("Test targeting group", null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 6, 0, 65530);
            float f5 = 8;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f5)), composer, 6);
            TextKt.c("Sent to RevenueCat as the custom attribute test_targeting_group. Leave empty to remove it. After a change, open the paywall again.", null, ComposeColorsKt.j(composer, 0).q(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).b(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strZ2 = Z2(mutableState);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            TextFieldColors textFieldColorsE = OutlinedTextFieldDefaults.f18898a.e(ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).p(), 0L, 0L, 0L, 0L, 0L, 0L, ComposeColorsKt.j(composer, 0).b(), 0L, null, ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).q(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 2147477244, 4095);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.x2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.c3(mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.b(strZ2, (Function1) objG, modifierH, false, false, null, null, ComposableSingletons$DeveloperSettingsDialogsKt.f108252a.o(), null, null, null, null, null, false, null, null, null, true, 0, 0, null, null, textFieldColorsE, composer, 12583344, 12582912, 0, 4063096);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.u(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8110);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f5)), composer, 6);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.d3(function1, mutableState);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierC, 0.0f, 0.0f, null, primary, null, strB, null, 0L, null, null, false, false, (Function0) objG2, composer, 24576, 0, 8110);
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

    public static final void c1(final String title, final DevPrefState selectedState, final Function1 onSelected, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(selectedState, "selectedState");
        Intrinsics.checkNotNullParameter(onSelected, "onSelected");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(-1727615926);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(title) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.e(selectedState.ordinal()) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onSelected) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onDismiss) ? 2048 : 1024;
        }
        if (composerK.r((i4 & 1171) != 1170, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1727615926, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.BaseDeveloperSettingsDialog (DeveloperSettingsDialogs.kt:253)");
            }
            AndroidDialog_androidKt.a(onDismiss, null, ComposableLambdaKt.e(-1154017759, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.z1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.d1(title, onDismiss, onSelected, selectedState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 9) & 14) | 384, 2);
            function0 = onDismiss;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.g1(title, selectedState, onSelected, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c2(Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-80911847, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.OnboardingFlowVariantDialog.<anonymous> (DeveloperSettingsDialogs.kt:1075)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(24)), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.ma, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            Modifier modifierI = SizeKt.i(companion, Dp.g(f3));
            int i4 = 6;
            SpacerKt.a(modifierI, composer2, 6);
            composer2.a0(677854966);
            for (Iterator<OnboardingFlowVariant> it = OnboardingFlowVariant.getEntries().iterator(); it.hasNext(); it = it) {
                final OnboardingFlowVariant next = it.next();
                float f4 = 8;
                Modifier modifierA = ClipKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(f4)));
                boolean Z = composer2.Z(function1) | composer2.e(next.ordinal());
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.t2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.d2(function1, next);
                        }
                    };
                    composer2.w(objG);
                }
                Modifier modifierJ = PaddingKt.j(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), Dp.g(f4), Dp.g(12));
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierJ);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
                Function0 function0A2 = companion3.a();
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
                Updater.e(composerA2, measurePolicyB, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                TextKt.c(next.getKey(), null, ComposeColorsKt.j(composer2, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).a(), composer, 0, 0, 65530);
                composer2 = composer;
                composer2.y();
                i4 = i4;
            }
            int i5 = i4;
            composer2.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer2, i5);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer2, i5), null, 0L, null, null, false, false, function0, composer2, 24576, 0, 8111);
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
    public static final Unit c3(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        a3(mutableState, it);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d1(String str, Function0 function0, final Function1 function1, DevPrefState devPrefState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1154017759, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.BaseDeveloperSettingsDialog.<anonymous> (DeveloperSettingsDialogs.kt:255)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(24)), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            int i4 = 6;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            composer2.a0(-636603198);
            for (Iterator<DevPrefState> it = DevPrefState.getEntries().iterator(); it.hasNext(); it = it) {
                final DevPrefState next = it.next();
                Modifier.Companion companion3 = Modifier.b8;
                float f4 = 8;
                Modifier modifierA = ClipKt.a(SizeKt.h(companion3, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(f4)));
                boolean Z = composer2.Z(function1) | composer2.e(next.ordinal());
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.e1(function1, next);
                        }
                    };
                    composer2.w(objG);
                }
                Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), 0.0f, Dp.g(f4), 1, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierK);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
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
                Updater.e(composerA2, measurePolicyB, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                boolean z2 = next == devPrefState;
                boolean Z2 = composer2.Z(function1) | composer2.e(next.ordinal());
                Object objG2 = composer2.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.f1(function1, next);
                        }
                    };
                    composer2.w(objG2);
                }
                RadioButtonKt.a(z2, (Function0) objG2, null, false, RadioButtonDefaults.f19329a.b(ComposeColorsKt.j(composer2, 0).b(), ComposeColorsKt.j(composer2, 0).q(), 0L, 0L, composer2, RadioButtonDefaults.f19330b << 12, 12), null, composer, 0, 44);
                SpacerKt.a(SizeKt.A(companion3, Dp.g(f4)), composer, i4);
                TextKt.c(next.toString(), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
                composer2 = composer;
                composer2.y();
                i4 = i4;
            }
            int i5 = i4;
            composer2.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer2, i5);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer2, i5), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8111);
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
    public static final Unit d2(Function1 function1, OnboardingFlowVariant onboardingFlowVariant) {
        function1.invoke(onboardingFlowVariant);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit d3(Function1 function1, MutableState mutableState) {
        function1.invoke(Z2(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e1(Function1 function1, DevPrefState devPrefState) {
        function1.invoke(devPrefState);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e2(Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        b2(function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit e3(String str, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        Y2(str, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(Function1 function1, DevPrefState devPrefState) {
        function1.invoke(devPrefState);
        return Unit.f139807a;
    }

    public static final void f2(final Function1 onParse, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onParse, "onParse");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(1682624678);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(onParse) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onDismiss) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1682624678, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ParseSupportJsonDialog (DeveloperSettingsDialogs.kt:931)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e("", null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(1942117103, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.x1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.i2(mutableState, onDismiss, onParse, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 3) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.l2(onParse, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void f3(final long j3, final Function1 onSave, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(2075241940);
        if ((i3 & 6) == 0) {
            i4 = (composerK.f(j3) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onSave) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2075241940, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.TimeChangeLimitDialog (DeveloperSettingsDialogs.kt:769)");
            }
            Object objG = composerK.G();
            Composer.Companion companion = Composer.f23746a;
            if (objG == companion.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(String.valueOf(j3), null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            Object objG2 = composerK.G();
            if (objG2 == companion.a()) {
                objG2 = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
                composerK.w(objG2);
            }
            final MutableState mutableState2 = (MutableState) objG2;
            AndroidDialog_androidKt.a(onDismiss, null, ComposableLambdaKt.e(-1806111843, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.k3(mutableState, mutableState2, onDismiss, onSave, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            function0 = onDismiss;
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.s2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.n3(j3, onSave, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit g1(String str, DevPrefState devPrefState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        c1(str, devPrefState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    private static final String g2(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    private static final String g3(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    public static final void h1(final DeveloperSettingsViewState viewState, final Function1 onEvent, Composer composer, final int i3) {
        int i4;
        boolean z2;
        Intrinsics.checkNotNullParameter(viewState, "viewState");
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer composerK = composer.k(412754577);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(viewState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onEvent) ? 32 : 16;
        }
        if (composerK.r((i4 & 19) != 18, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(412754577, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.DeveloperSettingsDialogContent (DeveloperSettingsDialogs.kt:90)");
            }
            DeveloperSettingsViewState.DeveloperDialogType developerDialogTypeG = viewState.g();
            switch (developerDialogTypeG != null ? WhenMappings.f108277a[developerDialogTypeG.ordinal()] : -1) {
                case -1:
                    composerK.a0(-119595345);
                    composerK.U();
                    Unit unit = Unit.f139807a;
                    break;
                case 0:
                default:
                    composerK.a0(1520168867);
                    composerK.U();
                    throw new NoWhenBranchMatchedException();
                case 1:
                    composerK.a0(-119506406);
                    PremiumDevState premiumDevStateW = viewState.w();
                    int i5 = i4 & 112;
                    boolean z3 = i5 == 32;
                    Object objG = composerK.G();
                    if (z3 || objG == Composer.f23746a.a()) {
                        objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.i1(onEvent, (PremiumDevState) obj);
                            }
                        };
                        composerK.w(objG);
                    }
                    Function1 function1 = (Function1) objG;
                    z2 = i5 == 32;
                    Object objG2 = composerK.G();
                    if (z2 || objG2 == Composer.f23746a.a()) {
                        objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.j1(onEvent);
                            }
                        };
                        composerK.w(objG2);
                    }
                    t2(premiumDevStateW, function1, (Function0) objG2, composerK, 0);
                    composerK.U();
                    Unit unit2 = Unit.f139807a;
                    break;
                case 2:
                    composerK.a0(-119160663);
                    RevenueCatOffering revenueCatOfferingV = viewState.v();
                    int i6 = i4 & 112;
                    boolean z4 = i6 == 32;
                    Object objG3 = composerK.G();
                    if (z4 || objG3 == Composer.f23746a.a()) {
                        objG3 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.y0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.u1(onEvent, (RevenueCatOffering) obj);
                            }
                        };
                        composerK.w(objG3);
                    }
                    Function1 function12 = (Function1) objG3;
                    z2 = i6 == 32;
                    Object objG4 = composerK.G();
                    if (z2 || objG4 == Composer.f23746a.a()) {
                        objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.F1(onEvent);
                            }
                        };
                        composerK.w(objG4);
                    }
                    m2(revenueCatOfferingV, function12, (Function0) objG4, composerK, 0);
                    composerK.U();
                    Unit unit3 = Unit.f139807a;
                    break;
                case 3:
                    composerK.a0(-118804690);
                    int i7 = i4 & 112;
                    boolean z5 = i7 == 32;
                    Object objG5 = composerK.G();
                    if (z5 || objG5 == Composer.f23746a.a()) {
                        objG5 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.Q1(onEvent, (List) obj);
                            }
                        };
                        composerK.w(objG5);
                    }
                    Function1 function13 = (Function1) objG5;
                    z2 = i7 == 32;
                    Object objG6 = composerK.G();
                    if (z2 || objG6 == Composer.f23746a.a()) {
                        objG6 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.R1(onEvent);
                            }
                        };
                        composerK.w(objG6);
                    }
                    M2(function13, (Function0) objG6, composerK, 0);
                    composerK.U();
                    Unit unit4 = Unit.f139807a;
                    break;
                case 4:
                    composerK.a0(-118509167);
                    int i8 = i4 & 112;
                    boolean z6 = i8 == 32;
                    Object objG7 = composerK.G();
                    if (z6 || objG7 == Composer.f23746a.a()) {
                        objG7 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.S1(onEvent, ((Long) obj).longValue());
                            }
                        };
                        composerK.w(objG7);
                    }
                    Function1 function14 = (Function1) objG7;
                    z2 = i8 == 32;
                    Object objG8 = composerK.G();
                    if (z2 || objG8 == Composer.f23746a.a()) {
                        objG8 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.T1(onEvent);
                            }
                        };
                        composerK.w(objG8);
                    }
                    T0(function14, (Function0) objG8, composerK, 0);
                    composerK.U();
                    Unit unit5 = Unit.f139807a;
                    break;
                case 5:
                    composerK.a0(-118217426);
                    String strX = viewState.x();
                    int i9 = i4 & 112;
                    boolean z7 = i9 == 32;
                    Object objG9 = composerK.G();
                    if (z7 || objG9 == Composer.f23746a.a()) {
                        objG9 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.U1(onEvent, (String) obj);
                            }
                        };
                        composerK.w(objG9);
                    }
                    Function1 function15 = (Function1) objG9;
                    z2 = i9 == 32;
                    Object objG10 = composerK.G();
                    if (z2 || objG10 == Composer.f23746a.a()) {
                        objG10 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.r1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.V1(onEvent);
                            }
                        };
                        composerK.w(objG10);
                    }
                    y2(strX, function15, (Function0) objG10, composerK, 0);
                    composerK.U();
                    Unit unit6 = Unit.f139807a;
                    break;
                case 6:
                    composerK.a0(-117856555);
                    String strP = viewState.P();
                    int i10 = i4 & 112;
                    boolean z8 = i10 == 32;
                    Object objG11 = composerK.G();
                    if (z8 || objG11 == Composer.f23746a.a()) {
                        objG11 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.k1(onEvent, (String) obj);
                            }
                        };
                        composerK.w(objG11);
                    }
                    Function1 function16 = (Function1) objG11;
                    z2 = i10 == 32;
                    Object objG12 = composerK.G();
                    if (z2 || objG12 == Composer.f23746a.a()) {
                        objG12 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.v3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.l1(onEvent);
                            }
                        };
                        composerK.w(objG12);
                    }
                    Y2(strP, function16, (Function0) objG12, composerK, 0);
                    composerK.U();
                    Unit unit7 = Unit.f139807a;
                    break;
                case 7:
                    composerK.a0(-117504581);
                    long minutes = TimeUnit.MILLISECONDS.toMinutes(viewState.Q());
                    int i11 = i4 & 112;
                    boolean z9 = i11 == 32;
                    Object objG13 = composerK.G();
                    if (z9 || objG13 == Composer.f23746a.a()) {
                        objG13 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.m1(onEvent, ((Long) obj).longValue());
                            }
                        };
                        composerK.w(objG13);
                    }
                    Function1 function17 = (Function1) objG13;
                    z2 = i11 == 32;
                    Object objG14 = composerK.G();
                    if (z2 || objG14 == Composer.f23746a.a()) {
                        objG14 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.n1(onEvent);
                            }
                        };
                        composerK.w(objG14);
                    }
                    f3(minutes, function17, (Function0) objG14, composerK, 0);
                    composerK.U();
                    Unit unit8 = Unit.f139807a;
                    break;
                case 8:
                    composerK.a0(-117127621);
                    String strQ = viewState.q();
                    int i12 = i4 & 112;
                    boolean z10 = i12 == 32;
                    Object objG15 = composerK.G();
                    if (z10 || objG15 == Composer.f23746a.a()) {
                        objG15 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.o1(onEvent, (String) obj);
                            }
                        };
                        composerK.w(objG15);
                    }
                    Function1 function18 = (Function1) objG15;
                    z2 = i12 == 32;
                    Object objG16 = composerK.G();
                    if (z2 || objG16 == Composer.f23746a.a()) {
                        objG16 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.p1(onEvent);
                            }
                        };
                        composerK.w(objG16);
                    }
                    F2(strQ, function18, (Function0) objG16, composerK, 0);
                    composerK.U();
                    Unit unit9 = Unit.f139807a;
                    break;
                case 9:
                    composerK.a0(-116783335);
                    int i13 = i4 & 112;
                    boolean z11 = i13 == 32;
                    Object objG17 = composerK.G();
                    if (z11 || objG17 == Composer.f23746a.a()) {
                        objG17 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.q1(onEvent, (String) obj);
                            }
                        };
                        composerK.w(objG17);
                    }
                    Function1 function19 = (Function1) objG17;
                    z2 = i13 == 32;
                    Object objG18 = composerK.G();
                    if (z2 || objG18 == Composer.f23746a.a()) {
                        objG18 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.r1(onEvent);
                            }
                        };
                        composerK.w(objG18);
                    }
                    f2(function19, (Function0) objG18, composerK, 0);
                    composerK.U();
                    Unit unit10 = Unit.f139807a;
                    break;
                case 10:
                    composerK.a0(-116442211);
                    final InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTOO = viewState.o();
                    if (inAppUpdatesMockSettingsDTOO == null) {
                        composerK.a0(-116442212);
                    } else {
                        composerK.a0(-116442211);
                        boolean zI = composerK.I(inAppUpdatesMockSettingsDTOO) | ((i4 & 112) == 32);
                        Object objG19 = composerK.G();
                        if (zI || objG19 == Composer.f23746a.a()) {
                            objG19 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.k0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return DeveloperSettingsDialogsKt.s1(onEvent, inAppUpdatesMockSettingsDTOO, ((Boolean) obj).booleanValue());
                                }
                            };
                            composerK.w(objG19);
                        }
                        InAppUpdateMockSettingsDialogKt.n(inAppUpdatesMockSettingsDTOO, (Function1) objG19, composerK, InAppUpdatesMockSettingsDTO.$stable);
                        Unit unit11 = Unit.f139807a;
                    }
                    composerK.U();
                    composerK.U();
                    break;
                case 11:
                    composerK.a0(-115902532);
                    List list = CollectionsKt.toList(WhatsNewData.f128462a.a().keySet());
                    int i14 = i4 & 112;
                    boolean z12 = i14 == 32;
                    Object objG20 = composerK.G();
                    if (z12 || objG20 == Composer.f23746a.a()) {
                        objG20 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.l0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.t1(onEvent, (String) obj);
                            }
                        };
                        composerK.w(objG20);
                    }
                    Function1 function110 = (Function1) objG20;
                    z2 = i14 == 32;
                    Object objG21 = composerK.G();
                    if (z2 || objG21 == Composer.f23746a.a()) {
                        objG21 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.n0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.v1(onEvent);
                            }
                        };
                        composerK.w(objG21);
                    }
                    o3(list, function110, (Function0) objG21, composerK, 0);
                    composerK.U();
                    Unit unit12 = Unit.f139807a;
                    break;
                case 12:
                    composerK.a0(-115537135);
                    String strB = StringResources_androidKt.b(R.string.Zw, composerK, 0);
                    DevPrefState devPrefStateB = viewState.B();
                    int i15 = i4 & 112;
                    boolean z13 = i15 == 32;
                    Object objG22 = composerK.G();
                    if (z13 || objG22 == Composer.f23746a.a()) {
                        objG22 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.w1(onEvent, (DevPrefState) obj);
                            }
                        };
                        composerK.w(objG22);
                    }
                    Function1 function111 = (Function1) objG22;
                    z2 = i15 == 32;
                    Object objG23 = composerK.G();
                    if (z2 || objG23 == Composer.f23746a.a()) {
                        objG23 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.x1(onEvent);
                            }
                        };
                        composerK.w(objG23);
                    }
                    c1(strB, devPrefStateB, function111, (Function0) objG23, composerK, 0);
                    composerK.U();
                    Unit unit13 = Unit.f139807a;
                    break;
                case 13:
                    composerK.a0(-115115442);
                    String strB2 = StringResources_androidKt.b(R.string.wb, composerK, 0);
                    DevPrefState devPrefStateL = viewState.L();
                    int i16 = i4 & 112;
                    boolean z14 = i16 == 32;
                    Object objG24 = composerK.G();
                    if (z14 || objG24 == Composer.f23746a.a()) {
                        objG24 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.r0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.y1(onEvent, (DevPrefState) obj);
                            }
                        };
                        composerK.w(objG24);
                    }
                    Function1 function112 = (Function1) objG24;
                    z2 = i16 == 32;
                    Object objG25 = composerK.G();
                    if (z2 || objG25 == Composer.f23746a.a()) {
                        objG25 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.s0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.z1(onEvent);
                            }
                        };
                        composerK.w(objG25);
                    }
                    c1(strB2, devPrefStateL, function112, (Function0) objG25, composerK, 0);
                    composerK.U();
                    Unit unit14 = Unit.f139807a;
                    break;
                case 14:
                    composerK.a0(-114663834);
                    String strB3 = StringResources_androidKt.b(R.string.Ca, composerK, 0);
                    DevPrefState devPrefStateT = viewState.t();
                    int i17 = i4 & 112;
                    boolean z15 = i17 == 32;
                    Object objG26 = composerK.G();
                    if (z15 || objG26 == Composer.f23746a.a()) {
                        objG26 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.t0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.A1(onEvent, (DevPrefState) obj);
                            }
                        };
                        composerK.w(objG26);
                    }
                    Function1 function113 = (Function1) objG26;
                    z2 = i17 == 32;
                    Object objG27 = composerK.G();
                    if (z2 || objG27 == Composer.f23746a.a()) {
                        objG27 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.u0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.B1(onEvent);
                            }
                        };
                        composerK.w(objG27);
                    }
                    c1(strB3, devPrefStateT, function113, (Function0) objG27, composerK, 0);
                    composerK.U();
                    Unit unit15 = Unit.f139807a;
                    break;
                case 15:
                    composerK.a0(-114205871);
                    String strB4 = StringResources_androidKt.b(R.string.ib, composerK, 0);
                    DevPrefState devPrefStateC = viewState.C();
                    int i18 = i4 & 112;
                    boolean z16 = i18 == 32;
                    Object objG28 = composerK.G();
                    if (z16 || objG28 == Composer.f23746a.a()) {
                        objG28 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.v0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.C1(onEvent, (DevPrefState) obj);
                            }
                        };
                        composerK.w(objG28);
                    }
                    Function1 function114 = (Function1) objG28;
                    z2 = i18 == 32;
                    Object objG29 = composerK.G();
                    if (z2 || objG29 == Composer.f23746a.a()) {
                        objG29 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.D1(onEvent);
                            }
                        };
                        composerK.w(objG29);
                    }
                    c1(strB4, devPrefStateC, function114, (Function0) objG29, composerK, 0);
                    composerK.U();
                    Unit unit16 = Unit.f139807a;
                    break;
                case 16:
                    composerK.a0(-113766105);
                    String strB5 = StringResources_androidKt.b(R.string.ob, composerK, 0);
                    DevPrefState devPrefStateF = viewState.F();
                    int i19 = i4 & 112;
                    boolean z17 = i19 == 32;
                    Object objG30 = composerK.G();
                    if (z17 || objG30 == Composer.f23746a.a()) {
                        objG30 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.x0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.E1(onEvent, (DevPrefState) obj);
                            }
                        };
                        composerK.w(objG30);
                    }
                    Function1 function115 = (Function1) objG30;
                    z2 = i19 == 32;
                    Object objG31 = composerK.G();
                    if (z2 || objG31 == Composer.f23746a.a()) {
                        objG31 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.a1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.G1(onEvent);
                            }
                        };
                        composerK.w(objG31);
                    }
                    c1(strB5, devPrefStateF, function115, (Function0) objG31, composerK, 0);
                    composerK.U();
                    Unit unit17 = Unit.f139807a;
                    break;
                case 17:
                    composerK.a0(-113346179);
                    String strB6 = StringResources_androidKt.b(R.string.Lb, composerK, 0);
                    DevPrefState devPrefStateW = viewState.W();
                    int i20 = i4 & 112;
                    boolean z18 = i20 == 32;
                    Object objG32 = composerK.G();
                    if (z18 || objG32 == Composer.f23746a.a()) {
                        objG32 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.H1(onEvent, (DevPrefState) obj);
                            }
                        };
                        composerK.w(objG32);
                    }
                    Function1 function116 = (Function1) objG32;
                    z2 = i20 == 32;
                    Object objG33 = composerK.G();
                    if (z2 || objG33 == Composer.f23746a.a()) {
                        objG33 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.c1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.I1(onEvent);
                            }
                        };
                        composerK.w(objG33);
                    }
                    c1(strB6, devPrefStateW, function116, (Function0) objG33, composerK, 0);
                    composerK.U();
                    Unit unit18 = Unit.f139807a;
                    break;
                case 18:
                    composerK.a0(-112914225);
                    String strB7 = StringResources_androidKt.b(R.string.lb, composerK, 0);
                    DevPrefState devPrefStateE = viewState.E();
                    int i21 = i4 & 112;
                    boolean z19 = i21 == 32;
                    Object objG34 = composerK.G();
                    if (z19 || objG34 == Composer.f23746a.a()) {
                        objG34 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.J1(onEvent, (DevPrefState) obj);
                            }
                        };
                        composerK.w(objG34);
                    }
                    Function1 function117 = (Function1) objG34;
                    z2 = i21 == 32;
                    Object objG35 = composerK.G();
                    if (z2 || objG35 == Composer.f23746a.a()) {
                        objG35 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.e1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.K1(onEvent);
                            }
                        };
                        composerK.w(objG35);
                    }
                    c1(strB7, devPrefStateE, function117, (Function0) objG35, composerK, 0);
                    composerK.U();
                    Unit unit19 = Unit.f139807a;
                    break;
                case 19:
                    composerK.a0(-112464415);
                    RatingDialogType ratingDialogTypeN = viewState.n();
                    int i22 = i4 & 112;
                    boolean z20 = i22 == 32;
                    Object objG36 = composerK.G();
                    if (z20 || objG36 == Composer.f23746a.a()) {
                        objG36 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.f1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.L1(onEvent, (RatingDialogType) obj);
                            }
                        };
                        composerK.w(objG36);
                    }
                    Function1 function118 = (Function1) objG36;
                    z2 = i22 == 32;
                    Object objG37 = composerK.G();
                    if (z2 || objG37 == Composer.f23746a.a()) {
                        objG37 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.M1(onEvent);
                            }
                        };
                        composerK.w(objG37);
                    }
                    W1(ratingDialogTypeN, function118, (Function0) objG37, composerK, 0);
                    composerK.U();
                    Unit unit20 = Unit.f139807a;
                    break;
                case 20:
                    composerK.a0(-112089470);
                    int i23 = i4 & 112;
                    boolean z21 = i23 == 32;
                    Object objG38 = composerK.G();
                    if (z21 || objG38 == Composer.f23746a.a()) {
                        objG38 = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return DeveloperSettingsDialogsKt.N1(onEvent, (OnboardingFlowVariant) obj);
                            }
                        };
                        composerK.w(objG38);
                    }
                    Function1 function119 = (Function1) objG38;
                    z2 = i23 == 32;
                    Object objG39 = composerK.G();
                    if (z2 || objG39 == Composer.f23746a.a()) {
                        objG39 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return DeveloperSettingsDialogsKt.O1(onEvent);
                            }
                        };
                        composerK.w(objG39);
                    }
                    b2(function119, (Function0) objG39, composerK, 0);
                    composerK.U();
                    Unit unit21 = Unit.f139807a;
                    break;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.P1(viewState, onEvent, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void h2(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    private static final void h3(MutableState mutableState, String str) {
        mutableState.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(Function1 function1, PremiumDevState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnPremiumStateSelected(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i2(final MutableState mutableState, Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1942117103, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.ParseSupportJsonDialog.<anonymous> (DeveloperSettingsDialogs.kt:935)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierI = PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(f4));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            TextKt.c(StringResources_androidKt.b(R.string.tn, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strG2 = g2(mutableState);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.g3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.j2(mutableState, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.b(strG2, (Function1) objG, SizeKt.i(SizeKt.h(companion, 0.0f, 1, null), Dp.g(200)), false, false, null, null, ComposableSingletons$DeveloperSettingsDialogsKt.f108252a.p(), null, null, null, null, null, false, null, null, null, false, 0, 0, null, null, OutlinedTextFieldDefaults.f18898a.e(ComposeColorsKt.j(composer, 0).p(), ComposeColorsKt.j(composer, 0).p(), 0L, 0L, 0L, 0L, 0L, 0L, ComposeColorsKt.j(composer, 0).b(), 0L, null, ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).q(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 2147477244, 4095), composer, 12583344, 0, 0, 4194168);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer, 0);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, companion);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.u(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8110);
            SpacerKt.a(SizeKt.A(companion, Dp.g(8)), composer, 6);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean z2 = !StringsKt.p0(g2(mutableState));
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.h3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.k2(function1, mutableState);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierC, 0.0f, 0.0f, null, primary, null, "Parse", null, 0L, null, null, z2, false, (Function0) objG2, composer, 1597440, 0, 6062);
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

    private static final boolean i3(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j2(MutableState mutableState, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        h2(mutableState, it);
        return Unit.f139807a;
    }

    private static final void j3(MutableState mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnTestTargetingGroupSaved(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k2(Function1 function1, MutableState mutableState) {
        function1.invoke(g2(mutableState));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit k3(final MutableState mutableState, final MutableState mutableState2, Function0 function0, final Function1 function1, Composer composer, int i3) {
        long jB;
        long jQ;
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1806111843, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.TimeChangeLimitDialog.<anonymous> (DeveloperSettingsDialogs.kt:774)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            float f4 = 24;
            Modifier modifierI = PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(f4));
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierI);
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
            TextKt.c(StringResources_androidKt.b(R.string.Bb, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            String strG3 = g3(mutableState);
            Modifier modifierH = SizeKt.h(companion, 0.0f, 1, null);
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, KeyboardType.f29379b.d(), 0, null, null, null, 123, null);
            OutlinedTextFieldDefaults outlinedTextFieldDefaults = OutlinedTextFieldDefaults.f18898a;
            long jP = ComposeColorsKt.j(composer, 0).p();
            long jP2 = ComposeColorsKt.j(composer, 0).p();
            long jB2 = ComposeColorsKt.j(composer, 0).b();
            if (i3(mutableState2)) {
                composer.a0(1469291178);
                composer.U();
                jB = Color.f25715b.i();
            } else {
                composer.a0(1469291693);
                jB = ComposeColorsKt.j(composer, 0).b();
                composer.U();
            }
            long j3 = jB;
            if (i3(mutableState2)) {
                composer.a0(1469294122);
                composer.U();
                jQ = Color.f25715b.i();
            } else {
                composer.a0(1469294644);
                jQ = ComposeColorsKt.j(composer, 0).q();
                composer.U();
            }
            TextFieldColors textFieldColorsE = outlinedTextFieldDefaults.e(jP, jP2, 0L, 0L, 0L, 0L, 0L, 0L, jB2, 0L, null, j3, jQ, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composer, 0, 0, 0, 0, 3072, 2147477244, 4095);
            boolean zI3 = i3(mutableState2);
            Object objG = composer.G();
            Composer.Companion companion4 = Composer.f23746a;
            if (objG == companion4.a()) {
                objG = new Function1() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.t3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DeveloperSettingsDialogsKt.l3(mutableState, mutableState2, (String) obj);
                    }
                };
                composer.w(objG);
            }
            OutlinedTextFieldKt.b(strG3, (Function1) objG, modifierH, false, false, null, null, ComposableSingletons$DeveloperSettingsDialogsKt.f108252a.l(), null, null, null, null, null, zI3, null, keyboardOptions, null, true, 0, 0, null, null, textFieldColorsE, composer, 12583344, 12779520, 0, 4022136);
            Composer composer2 = composer;
            if (i3(mutableState2)) {
                composer2.a0(-1696388273);
                SpacerKt.a(SizeKt.i(companion, Dp.g(4)), composer2, 6);
                TextKt.c("Please enter a valid number", null, Color.f25715b.i(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer2, 0).d(), composer, 390, 0, 65530);
                composer2 = composer;
            } else {
                composer2.a0(-1730741605);
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(companion, Dp.g(f4)), composer2, 6);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.l(), composer2, 0);
            int iA2 = ComposablesKt.a(composer2, 0);
            CompositionLocalMap compositionLocalMapU2 = composer2.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer2, companion);
            Function0 function0A2 = companion3.a();
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            FlatButtonsKt.u(RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null), 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer2, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8110);
            SpacerKt.a(SizeKt.A(companion, Dp.g(8)), composer, 6);
            Modifier modifierC = RowScope.c(rowScopeInstance, companion, 1.0f, false, 2, null);
            String strB = StringResources_androidKt.b(R.string.Lt, composer, 0);
            FlatButtonColors.Primary primary = FlatButtonColors.Primary.f131166a;
            boolean Z = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z || objG2 == companion4.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.u3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.m3(function1, mutableState, mutableState2);
                    }
                };
                composer.w(objG2);
            }
            FlatButtonsKt.u(modifierC, 0.0f, 0.0f, null, primary, null, strB, null, 0L, null, null, false, false, (Function0) objG2, composer, 24576, 0, 8110);
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
    public static final Unit l1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l2(Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        f2(function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l3(MutableState mutableState, MutableState mutableState2, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        h3(mutableState, it);
        j3(mutableState2, false);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m1(Function1 function1, long j3) {
        function1.invoke(new DeveloperSettingsViewEvent.OnTimeChangeLimitSaved(j3));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit m3(Function1 function1, MutableState mutableState, MutableState mutableState2) {
        Long lW = StringsKt.w(g3(mutableState));
        if (lW == null || lW.longValue() < 0) {
            j3(mutableState2, true);
        } else {
            function1.invoke(lW);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n2(final Function1 function1, Function0 function0, RevenueCatOffering revenueCatOffering, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1738802727, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.PremiumProductDialog.<anonymous> (DeveloperSettingsDialogs.kt:383)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(24)), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            Arrangement arrangement = Arrangement.f6574a;
            Arrangement.Vertical verticalH = arrangement.h();
            Alignment.Companion companion2 = Alignment.f25072a;
            MeasurePolicy measurePolicyA = ColumnKt.a(verticalH, companion2.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            TextKt.c(StringResources_androidKt.b(R.string.Tv, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            float f4 = 8;
            Modifier modifierA = ClipKt.a(SizeKt.h(companion, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(f4)));
            boolean Z = composer.Z(function1);
            Object objG = composer.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.m3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.o2(function1);
                    }
                };
                composer.w(objG);
            }
            Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), 0.0f, Dp.g(f4), 1, null);
            MeasurePolicy measurePolicyB = RowKt.b(arrangement.g(), companion2.i(), composer, 48);
            int iA2 = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU2 = composer.u();
            Modifier modifierF2 = ComposedModifierKt.f(composer, modifierK);
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
            Updater.e(composerA2, measurePolicyB, companion3.e());
            Updater.e(composerA2, compositionLocalMapU2, companion3.g());
            Function2 function2B2 = companion3.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF2, companion3.f());
            RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
            boolean z2 = revenueCatOffering == null;
            boolean Z2 = composer.Z(function1);
            Object objG2 = composer.G();
            if (Z2 || objG2 == Composer.f23746a.a()) {
                objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return DeveloperSettingsDialogsKt.p2(function1);
                    }
                };
                composer.w(objG2);
            }
            RadioButtonKt.a(z2, (Function0) objG2, null, false, RadioButtonDefaults.f19329a.b(ComposeColorsKt.j(composer, 0).b(), ComposeColorsKt.j(composer, 0).q(), 0L, 0L, composer, RadioButtonDefaults.f19330b << 12, 12), null, composer, 0, 44);
            SpacerKt.a(SizeKt.A(companion, Dp.g(f4)), composer, 6);
            float f5 = 0.0f;
            TextKt.c("Clear", null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 6, 0, 65530);
            Composer composer2 = composer;
            composer2.y();
            composer2.a0(1721986108);
            Iterator<RevenueCatOffering> it = RevenueCatOffering.getEntries().iterator();
            while (it.hasNext()) {
                final RevenueCatOffering next = it.next();
                Modifier.Companion companion4 = Modifier.b8;
                Modifier modifierA2 = ClipKt.a(SizeKt.h(companion4, f5, 1, null), RoundedCornerShapeKt.d(Dp.g(f4)));
                boolean Z3 = composer2.Z(function1) | composer2.e(next.ordinal());
                Object objG3 = composer2.G();
                if (Z3 || objG3 == Composer.f23746a.a()) {
                    objG3 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.q2(function1, next);
                        }
                    };
                    composer2.w(objG3);
                }
                Modifier modifierK2 = PaddingKt.k(ClickableKt.f(modifierA2, false, null, null, (Function0) objG3, 7, null), f5, Dp.g(f4), 1, null);
                MeasurePolicy measurePolicyB2 = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
                int iA3 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU3 = composer2.u();
                Modifier modifierF3 = ComposedModifierKt.f(composer2, modifierK2);
                ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
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
                Updater.e(composerA3, measurePolicyB2, companion5.e());
                Updater.e(composerA3, compositionLocalMapU3, companion5.g());
                Function2 function2B3 = companion5.b();
                if (composerA3.i() || !Intrinsics.areEqual(composerA3.G(), Integer.valueOf(iA3))) {
                    composerA3.w(Integer.valueOf(iA3));
                    composerA3.p(Integer.valueOf(iA3), function2B3);
                }
                Updater.e(composerA3, modifierF3, companion5.f());
                RowScopeInstance rowScopeInstance2 = RowScopeInstance.f7101a;
                boolean z3 = next == revenueCatOffering;
                boolean Z4 = composer2.Z(function1) | composer2.e(next.ordinal());
                Object objG4 = composer2.G();
                if (Z4 || objG4 == Composer.f23746a.a()) {
                    objG4 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.q3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.r2(function1, next);
                        }
                    };
                    composer2.w(objG4);
                }
                RadioButtonKt.a(z3, (Function0) objG4, null, false, RadioButtonDefaults.f19329a.b(ComposeColorsKt.j(composer2, 0).b(), ComposeColorsKt.j(composer2, 0).q(), 0L, 0L, composer2, RadioButtonDefaults.f19330b << 12, 12), null, composer, 0, 44);
                SpacerKt.a(SizeKt.A(companion4, Dp.g(f4)), composer, 6);
                TextKt.c(next.toString(), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
                composer2 = composer;
                composer2.y();
                f5 = 0.0f;
            }
            composer2.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer2, 6);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer2, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8111);
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
    public static final Unit n3(long j3, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        f3(j3, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnMockRemoteConfigSaved(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o2(Function1 function1) {
        function1.invoke(null);
        return Unit.f139807a;
    }

    public static final void o3(final List versions, final Function1 onVersionSelected, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(versions, "versions");
        Intrinsics.checkNotNullParameter(onVersionSelected, "onVersionSelected");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(535008269);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(versions) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onVersionSelected) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(535008269, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.WhatsNewVersionDialog (DeveloperSettingsDialogs.kt:470)");
            }
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(948621782, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.s1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.p3(versions, onDismiss, onVersionSelected, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.t1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.t3(versions, onVersionSelected, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p2(Function1 function1) {
        function1.invoke(null);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p3(List list, Function0 function0, final Function1 function1, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(948621782, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.WhatsNewVersionDialog.<anonymous> (DeveloperSettingsDialogs.kt:472)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(24)), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.fb, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer, 6);
            composer.a0(-1226547186);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final String str = (String) it.next();
                float f4 = 8;
                Modifier modifierA = ClipKt.a(SizeKt.h(Modifier.b8, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(f4)));
                boolean Z = composer.Z(function1) | composer.Z(str);
                Object objG = composer.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.u2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.q3(function1, str);
                        }
                    };
                    composer.w(objG);
                }
                Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), 0.0f, Dp.g(f4), 1, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer, 48);
                int iA2 = ComposablesKt.a(composer, 0);
                CompositionLocalMap compositionLocalMapU2 = composer.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer, modifierK);
                ComposeUiNode.Companion companion3 = ComposeUiNode.f8;
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
                Updater.e(composerA2, measurePolicyB, companion3.e());
                Updater.e(composerA2, compositionLocalMapU2, companion3.g());
                Function2 function2B2 = companion3.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion3.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                boolean Z2 = composer.Z(function1) | composer.Z(str);
                Object objG2 = composer.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.v2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.r3(function1, str);
                        }
                    };
                    composer.w(objG2);
                }
                ButtonKt.e((Function0) objG2, null, false, null, null, null, null, null, null, ComposableLambdaKt.e(-1810051919, true, new Function3() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return DeveloperSettingsDialogsKt.s3(str, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 805306368, 510);
                composer.y();
            }
            composer.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer, 6);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer, 6), null, 0L, null, null, false, false, function0, composer, 24576, 0, 8111);
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
    public static final Unit q1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnParseSupportJsonSaved(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q2(Function1 function1, RevenueCatOffering revenueCatOffering) {
        function1.invoke(revenueCatOffering);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q3(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r2(Function1 function1, RevenueCatOffering revenueCatOffering) {
        function1.invoke(revenueCatOffering);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r3(Function1 function1, String str) {
        function1.invoke(str);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s1(Function1 function1, InAppUpdatesMockSettingsDTO inAppUpdatesMockSettingsDTO, boolean z2) {
        if (z2) {
            function1.invoke(new DeveloperSettingsViewEvent.OnMockInAppUpdatesSaved(inAppUpdatesMockSettingsDTO));
        } else {
            function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s2(RevenueCatOffering revenueCatOffering, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        m2(revenueCatOffering, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s3(String str, RowScope TextButton, Composer composer, int i3) {
        Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
        if (composer.r((i3 & 17) != 16, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1810051919, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.WhatsNewVersionDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (DeveloperSettingsDialogs.kt:498)");
            }
            TextKt.c(str, null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            composer.Q();
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t1(Function1 function1, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnWhatsNewVersionSelected(it));
        return Unit.f139807a;
    }

    public static final void t2(final PremiumDevState selectedState, final Function1 onStateSelected, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(selectedState, "selectedState");
        Intrinsics.checkNotNullParameter(onStateSelected, "onStateSelected");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(2123164067);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(selectedState.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onStateSelected) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(2123164067, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.PremiumStateDialog (DeveloperSettingsDialogs.kt:317)");
            }
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(-1201516948, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.u1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.u2(onDismiss, onStateSelected, selectedState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.w1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.x2(selectedState, onStateSelected, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t3(List list, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        o3(list, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u1(Function1 function1, RevenueCatOffering revenueCatOffering) {
        function1.invoke(new DeveloperSettingsViewEvent.OnPremiumProductSelected(revenueCatOffering));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u2(Function0 function0, final Function1 function1, PremiumDevState premiumDevState, Composer composer, int i3) {
        if (composer.r((i3 & 3) != 2, i3 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-1201516948, i3, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.PremiumStateDialog.<anonymous> (DeveloperSettingsDialogs.kt:319)");
            }
            Modifier.Companion companion = Modifier.b8;
            float f3 = 16;
            Modifier modifierG = ScrollKt.g(PaddingKt.i(BackgroundKt.d(ClipKt.a(companion, RoundedCornerShapeKt.d(Dp.g(f3))), ComposeColorsKt.j(composer, 0).l0(), null, 2, null), Dp.g(24)), ScrollKt.c(0, composer, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer, 0);
            int iA = ComposablesKt.a(composer, 0);
            CompositionLocalMap compositionLocalMapU = composer.u();
            Modifier modifierF = ComposedModifierKt.f(composer, modifierG);
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
            Updater.e(composerA, measurePolicyA, companion2.e());
            Updater.e(composerA, compositionLocalMapU, companion2.g());
            Function2 function2B = companion2.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            TextKt.c(StringResources_androidKt.b(R.string.JD, composer, 0), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).h(), composer, 0, 0, 65530);
            Composer composer2 = composer;
            int i4 = 6;
            SpacerKt.a(SizeKt.i(companion, Dp.g(f3)), composer2, 6);
            composer2.a0(925672491);
            for (Iterator<PremiumDevState> it = PremiumDevState.getEntries().iterator(); it.hasNext(); it = it) {
                final PremiumDevState next = it.next();
                Modifier.Companion companion3 = Modifier.b8;
                float f4 = 8;
                Modifier modifierA = ClipKt.a(SizeKt.h(companion3, 0.0f, 1, null), RoundedCornerShapeKt.d(Dp.g(f4)));
                boolean Z = composer2.Z(function1) | composer2.e(next.ordinal());
                Object objG = composer2.G();
                if (Z || objG == Composer.f23746a.a()) {
                    objG = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.b3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.v2(function1, next);
                        }
                    };
                    composer2.w(objG);
                }
                Modifier modifierK = PaddingKt.k(ClickableKt.f(modifierA, false, null, null, (Function0) objG, 7, null), 0.0f, Dp.g(f4), 1, null);
                MeasurePolicy measurePolicyB = RowKt.b(Arrangement.f6574a.g(), Alignment.f25072a.i(), composer2, 48);
                int iA2 = ComposablesKt.a(composer2, 0);
                CompositionLocalMap compositionLocalMapU2 = composer2.u();
                Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierK);
                ComposeUiNode.Companion companion4 = ComposeUiNode.f8;
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
                Updater.e(composerA2, measurePolicyB, companion4.e());
                Updater.e(composerA2, compositionLocalMapU2, companion4.g());
                Function2 function2B2 = companion4.b();
                if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                    composerA2.w(Integer.valueOf(iA2));
                    composerA2.p(Integer.valueOf(iA2), function2B2);
                }
                Updater.e(composerA2, modifierF2, companion4.f());
                RowScopeInstance rowScopeInstance = RowScopeInstance.f7101a;
                boolean z2 = next == premiumDevState;
                boolean Z2 = composer2.Z(function1) | composer2.e(next.ordinal());
                Object objG2 = composer2.G();
                if (Z2 || objG2 == Composer.f23746a.a()) {
                    objG2 = new Function0() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.d3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return DeveloperSettingsDialogsKt.w2(function1, next);
                        }
                    };
                    composer2.w(objG2);
                }
                RadioButtonKt.a(z2, (Function0) objG2, null, false, RadioButtonDefaults.f19329a.b(ComposeColorsKt.j(composer2, 0).b(), ComposeColorsKt.j(composer2, 0).q(), 0L, 0L, composer2, RadioButtonDefaults.f19330b << 12, 12), null, composer, 0, 44);
                SpacerKt.a(SizeKt.A(companion3, Dp.g(f4)), composer, i4);
                TextKt.c(next.toString(), null, ComposeColorsKt.j(composer, 0).p(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, ComposeTypographyKt.g(composer, 0).a(), composer, 0, 0, 65530);
                composer2 = composer;
                composer2.y();
                i4 = i4;
            }
            int i5 = i4;
            composer2.U();
            SpacerKt.a(SizeKt.i(Modifier.b8, Dp.g(f3)), composer2, i5);
            FlatButtonsKt.u(null, 0.0f, 0.0f, null, FlatButtonColors.Secondary.f131167a, null, StringResources_androidKt.b(android.R.string.cancel, composer2, i5), null, 0L, null, null, false, false, function0, composer2, 24576, 0, 8111);
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
    public static final Unit v1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v2(Function1 function1, PremiumDevState premiumDevState) {
        function1.invoke(premiumDevState);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w1(Function1 function1, DevPrefState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnShowAdsStateSelected(it));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit w2(Function1 function1, PremiumDevState premiumDevState) {
        function1.invoke(premiumDevState);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x2(PremiumDevState premiumDevState, Function1 function1, Function0 function0, int i3, Composer composer, int i4) {
        t2(premiumDevState, function1, function0, composer, RecomposeScopeImplKt.a(i3 | 1));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y1(Function1 function1, DevPrefState it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(new DeveloperSettingsViewEvent.OnSkipDiscountTimerStateSelected(it));
        return Unit.f139807a;
    }

    public static final void y2(final String initialValue, final Function1 onSave, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(initialValue, "initialValue");
        Intrinsics.checkNotNullParameter(onSave, "onSave");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(1506908898);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(initialValue) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(onSave) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(1506908898, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.QuestionnaireConfigDialog (DeveloperSettingsDialogs.kt:698)");
            }
            Object objG = composerK.G();
            if (objG == Composer.f23746a.a()) {
                objG = SnapshotStateKt__SnapshotStateKt.e(initialValue, null, 2, null);
                composerK.w(objG);
            }
            final MutableState mutableState = (MutableState) objG;
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(2115739115, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.o2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.B2(mutableState, onDismiss, onSave, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.p2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.E2(initialValue, onSave, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit z1(Function1 function1) {
        function1.invoke(DeveloperSettingsViewEvent.OnDismissDialog.f108366a);
        return Unit.f139807a;
    }

    private static final String z2(MutableState mutableState) {
        return (String) mutableState.getValue();
    }

    public static final void m2(final RevenueCatOffering revenueCatOffering, final Function1 function1, final Function0 onDismiss, Composer composer, final int i3) {
        int i4;
        final Function0 function0;
        Intrinsics.checkNotNullParameter(function1, QgXempTBEfV.IvNABoTSJ);
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Composer composerK = composer.k(-109786878);
        if ((i3 & 6) == 0) {
            i4 = (composerK.e(revenueCatOffering == null ? -1 : revenueCatOffering.ordinal()) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if (composerK.r((i4 & 147) != 146, i4 & 1)) {
            if (ComposerKt.M()) {
                ComposerKt.U(-109786878, i4, -1, "cz.mobilesoft.coreblock.scene.more.settings.developer.PremiumProductDialog (DeveloperSettingsDialogs.kt:381)");
            }
            function0 = onDismiss;
            AndroidDialog_androidKt.a(function0, null, ComposableLambdaKt.e(-1738802727, true, new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.i2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.n2(function1, onDismiss, revenueCatOffering, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerK, 54), composerK, ((i4 >> 6) & 14) | 384, 2);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        } else {
            function0 = onDismiss;
            composerK.Q();
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2() { // from class: cz.mobilesoft.coreblock.scene.more.settings.developer.j2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return DeveloperSettingsDialogsKt.s2(revenueCatOffering, function1, function0, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}
