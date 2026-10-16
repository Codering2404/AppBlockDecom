package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import android.util.Patterns;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.text.KeyboardActionScope;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.OutlinedTextFieldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.unit.Dp;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonConfig;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.composables.SettingsButtonKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final /* synthetic */ class CreateSupportTicketViewKt {
    private static final int MAX_DESCRIPTION_LENGTH = 250;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketContent(final EmailInputState emailInputState, final DescriptionInputState descriptionInputState, final boolean z2, final CustomerCenterConfigData.Localization localization, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(1823655295);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(emailInputState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(descriptionInputState) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(localization) ? 2048 : 1024;
        }
        if ((i4 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1823655295, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketContent (CreateSupportTicketView.kt:191)");
            }
            Modifier.Companion companion = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion, 0.0f, 1, null);
            CustomerCenterConstants.Layout layout = CustomerCenterConstants.Layout.INSTANCE;
            Modifier modifierG = ScrollKt.g(PaddingKt.i(modifierF, layout.m964getSECTION_SPACINGD9Ej5fM()), ScrollKt.c(0, composerK, 0, 1), false, null, false, 14, null);
            MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composerK, 0);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierG);
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
            Updater.e(composerA, modifierF2, companion2.f());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.f6666a;
            int i5 = (i4 >> 6) & 112;
            EmailInputField(emailInputState, localization, (FocusManager) composerK.q(CompositionLocalsKt.g()), composerK, (i4 & 14) | i5);
            SpacerKt.a(SizeKt.i(companion, layout.m965getSECTION_TITLE_BOTTOM_PADDINGD9Ej5fM()), composerK, 6);
            DescriptionInputField(descriptionInputState, localization, composerK, ((i4 >> 3) & 14) | i5);
            SpacerKt.a(SizeKt.i(companion, layout.m964getSECTION_SPACINGD9Ej5fM()), composerK, 6);
            SubmitTicketButton(emailInputState.getEmail(), descriptionInputState.getDescription(), z2, descriptionInputState.getOnSubmit(), localization, composerK, (i4 & 896) | ((i4 << 3) & 57344));
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketContent.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    CreateSupportTicketViewKt.CreateSupportTicketContent(emailInputState, descriptionInputState, z2, localization, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x027d  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:158:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01c5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void CreateSupportTicketView(final com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData r27, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r28, androidx.compose.ui.Modifier r29, java.lang.String r30, java.lang.String r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 947
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView(com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateSupportTicketView$lambda$1(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    private static final boolean CreateSupportTicketView$lambda$10(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$11(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean CreateSupportTicketView$lambda$12(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$13(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CreateSupportTicketView$lambda$3(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$4(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    private static final boolean CreateSupportTicketView$lambda$5(MutableState<Boolean> mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView$lambda$6(MutableState<Boolean> mutableState, boolean z2) {
        mutableState.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CreateSupportTicketView$lambda$8(MutableState<String> mutableState) {
        return (String) mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(1094842373);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1094842373, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_Preview (CreateSupportTicketView.kt:119)");
            }
            final CreateSupportTicketData createSupportTicketData = new CreateSupportTicketData(new Function4<String, String, Function0<? extends Unit>, Function0<? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_Preview$mockData$1
                public final void invoke(String str, String str2, Function0<Unit> function0, Function0<Unit> function02) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(function0, "<anonymous parameter 2>");
                    Intrinsics.checkNotNullParameter(function02, "<anonymous parameter 3>");
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((String) obj, (String) obj2, (Function0<Unit>) obj3, (Function0<Unit>) obj4);
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_Preview$mockData$2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1028invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1028invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_Preview$mockData$3
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1029invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1029invoke();
                    return Unit.f139807a;
                }
            });
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(-1460784282, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_Preview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1460784282, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_Preview.<anonymous> (CreateSupportTicketView.kt:126)");
                    }
                    Modifier modifierD = BackgroundKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), MaterialTheme.f18110a.a(composer2, MaterialTheme.f18111b).c(), null, 2, null);
                    CreateSupportTicketData createSupportTicketData2 = createSupportTicketData;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
                    ComposeUiNode.Companion companion = ComposeUiNode.f8;
                    Function0 function0A = companion.a();
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    CreateSupportTicketViewKt.CreateSupportTicketView(createSupportTicketData2, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), null, null, null, composer2, 0, 28);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_Preview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    CreateSupportTicketViewKt.CreateSupportTicketView_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CreateSupportTicketView_WithDataPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1452070229);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1452070229, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_WithDataPreview (CreateSupportTicketView.kt:141)");
            }
            final CreateSupportTicketData createSupportTicketData = new CreateSupportTicketData(new Function4<String, String, Function0<? extends Unit>, Function0<? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_WithDataPreview$mockData$1
                public final void invoke(String str, String str2, Function0<Unit> function0, Function0<Unit> function02) {
                    Intrinsics.checkNotNullParameter(str, "<anonymous parameter 0>");
                    Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 1>");
                    Intrinsics.checkNotNullParameter(function0, "<anonymous parameter 2>");
                    Intrinsics.checkNotNullParameter(function02, "<anonymous parameter 3>");
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                    invoke((String) obj, (String) obj2, (Function0<Unit>) obj3, (Function0<Unit>) obj4);
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_WithDataPreview$mockData$2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1030invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1030invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$CreateSupportTicketView_WithDataPreview$mockData$3
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1031invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1031invoke();
                    return Unit.f139807a;
                }
            });
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(1169956790, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_WithDataPreview.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1169956790, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketView_WithDataPreview.<anonymous> (CreateSupportTicketView.kt:148)");
                    }
                    Modifier modifierD = BackgroundKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), MaterialTheme.f18110a.a(composer2, MaterialTheme.f18111b).c(), null, 2, null);
                    CreateSupportTicketData createSupportTicketData2 = createSupportTicketData;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, modifierD);
                    ComposeUiNode.Companion companion = ComposeUiNode.f8;
                    Function0 function0A = companion.a();
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
                    Updater.e(composerA, measurePolicyG, companion.e());
                    Updater.e(composerA, compositionLocalMapU, companion.g());
                    Function2 function2B = companion.b();
                    if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                        composerA.w(Integer.valueOf(iA));
                        composerA.p(Integer.valueOf(iA), function2B);
                    }
                    Updater.e(composerA, modifierF, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    CreateSupportTicketViewKt.CreateSupportTicketView(createSupportTicketData2, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), null, "user@example.com", "I'm having an issue with my subscription.", composer2, 27648, 4);
                    composer2.y();
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 6);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.CreateSupportTicketView_WithDataPreview.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    CreateSupportTicketViewKt.CreateSupportTicketView_WithDataPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void DescriptionInputField(final DescriptionInputState descriptionInputState, final CustomerCenterConfigData.Localization localization, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-202186622);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(descriptionInputState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(localization) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-202186622, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputField (CreateSupportTicketView.kt:278)");
            }
            final String strO = StringsKt.O(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.CHARACTERS_REMAINING), "{{ count }}", descriptionInputState.getDescription().length() + " / 250", false, 4, null);
            final State stateP = SnapshotStateKt.p(descriptionInputState.getOnSubmit(), composerK, 0);
            String description = descriptionInputState.getDescription();
            int i5 = i4;
            Function1<String, Unit> onDescriptionChange = descriptionInputState.getOnDescriptionChange();
            boolean enabled = descriptionInputState.getEnabled();
            Modifier modifierA = TestTagKt.a(SizeKt.i(SizeKt.h(Modifier.b8, 0.0f, 1, null), Dp.g(200)), "description_field");
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, 0, ImeAction.f29348b.b(), null, null, null, 119, null);
            composerK.a0(248605445);
            boolean Z = composerK.Z(stateP) | ((i5 & 14) == 4);
            Object objG = composerK.G();
            if (Z || objG == Composer.f23746a.a()) {
                objG = new Function1<KeyboardActionScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$DescriptionInputField$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyboardActionScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        if (!descriptionInputState.getShowDone() || StringsKt.p0(descriptionInputState.getDescription())) {
                            return;
                        }
                        CreateSupportTicketViewKt.DescriptionInputField$lambda$23(stateP).invoke();
                    }
                };
                composerK.w(objG);
            }
            composerK.U();
            composer2 = composerK;
            OutlinedTextFieldKt.b(description, onDescriptionChange, modifierA, enabled, false, null, ComposableLambdaKt.e(870248988, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.DescriptionInputField.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(870248988, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputField.<anonymous> (CreateSupportTicketView.kt:291)");
                    }
                    TextKt.c(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DESCRIPTION), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), null, null, null, null, null, ComposableLambdaKt.e(-1857613335, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.DescriptionInputField.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1857613335, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.DescriptionInputField.<anonymous> (CreateSupportTicketView.kt:298)");
                    }
                    TextKt.c(strO, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composer3, MaterialTheme.f18111b).d(), composer3, 0, 0, 65534);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), false, null, keyboardOptions, new KeyboardActions((Function1) objG, null, null, null, null, null, 62, null), false, 10, 6, null, null, null, composer2, 1573248, 906166656, 0, 7499696);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.DescriptionInputField.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    CreateSupportTicketViewKt.DescriptionInputField(descriptionInputState, localization, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> DescriptionInputField$lambda$23(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void EmailInputField(final EmailInputState emailInputState, final CustomerCenterConfigData.Localization localization, final FocusManager focusManager, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(449665849);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(emailInputState) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(localization) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(focusManager) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(449665849, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField (CreateSupportTicketView.kt:228)");
            }
            String email = emailInputState.getEmail();
            int i5 = i4;
            Function1<String, Unit> onEmailChange = emailInputState.getOnEmailChange();
            boolean showError = emailInputState.getShowError();
            composerK.a0(464966584);
            ComposableLambda composableLambdaE = emailInputState.getShowError() ? ComposableLambdaKt.e(-959949005, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-959949005, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField.<anonymous> (CreateSupportTicketView.kt:249)");
                    }
                    TextKt.c(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.INVALID_EMAIL_ERROR), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54) : null;
            composerK.U();
            boolean enabled = emailInputState.getEnabled();
            Modifier modifierH = SizeKt.h(Modifier.b8, 0.0f, 1, null);
            composerK.a0(464980338);
            boolean z2 = (i5 & 14) == 4;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function1<FocusState, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$EmailInputField$2$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((FocusState) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(FocusState focusState) {
                        Intrinsics.checkNotNullParameter(focusState, "focusState");
                        emailInputState.getOnFocusChanged().invoke(Boolean.valueOf(focusState.a()));
                    }
                };
                composerK.w(objG);
            }
            composerK.U();
            Modifier modifierA = TestTagKt.a(FocusChangedModifierKt.a(modifierH, (Function1) objG), "email_field");
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, null, KeyboardType.f29379b.c(), ImeAction.f29348b.d(), null, null, null, 115, null);
            composerK.a0(464991337);
            boolean zI = composerK.I(focusManager);
            Object objG2 = composerK.G();
            if (zI || objG2 == Composer.f23746a.a()) {
                objG2 = new Function1<KeyboardActionScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt$EmailInputField$3$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((KeyboardActionScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(KeyboardActionScope $receiver) {
                        Intrinsics.checkNotNullParameter($receiver, "$this$$receiver");
                        focusManager.e(FocusDirection.f25444b.a());
                    }
                };
                composerK.w(objG2);
            }
            composerK.U();
            composer2 = composerK;
            OutlinedTextFieldKt.b(email, onEmailChange, modifierA, enabled, false, null, ComposableLambdaKt.e(-664568609, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.4
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-664568609, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField.<anonymous> (CreateSupportTicketView.kt:233)");
                    }
                    TextKt.c(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.EMAIL), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), ComposableLambdaKt.e(1544555872, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.5
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    if ((i6 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1544555872, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.EmailInputField.<anonymous> (CreateSupportTicketView.kt:240)");
                    }
                    TextKt.c(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.ENTER_EMAIL), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer3, 0, 0, 131070);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), null, null, null, null, composableLambdaE, showError, null, keyboardOptions, new KeyboardActions(null, null, (Function1) objG2, null, null, null, 59, null), true, 0, 0, null, null, null, composer2, 14155776, 12779520, 0, 8146736);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.EmailInputField.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i6) {
                    CreateSupportTicketViewKt.EmailInputField(emailInputState, localization, focusManager, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void ErrorSnackbar(final boolean r16, final kotlin.jvm.functions.Function0<kotlin.Unit> r17, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r18, androidx.compose.ui.Modifier r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instruction units count: 309
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.ErrorSnackbar(boolean, kotlin.jvm.functions.Function0, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0<Unit> ErrorSnackbar$lambda$26(State<? extends Function0<Unit>> state) {
        return (Function0) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SubmitTicketButton(final String str, final String str2, final boolean z2, Function0<Unit> function0, final CustomerCenterConfigData.Localization localization, Composer composer, final int i3) {
        int i4;
        Function0<Unit> function02;
        Composer composerK = composer.k(-1201248039);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(str) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(str2) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.b(z2) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(function0) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(localization) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            function02 = function0;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1201248039, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.SubmitTicketButton (CreateSupportTicketView.kt:324)");
            }
            function02 = function0;
            SettingsButtonKt.SettingsButton(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SUBMIT_TICKET), function02, new SettingsButtonConfig((z2 || !isValidEmail(str) || StringsKt.p0(str2)) ? false : true, z2), null, null, composerK, (i4 >> 6) & 112, 24);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function0<Unit> function03 = function02;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.CreateSupportTicketViewKt.SubmitTicketButton.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    CreateSupportTicketViewKt.SubmitTicketButton(str, str2, z2, function03, localization, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final boolean isValidEmail(String str) {
        return !StringsKt.p0(str) && Patterns.EMAIL_ADDRESS.matcher(str).matches();
    }
}
