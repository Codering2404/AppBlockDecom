package com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AndroidAlertDialog_androidKt;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.emergetools.snapshots.annotations.EmergeSnapshotConfig;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

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
public final /* synthetic */ class RestorePurchasesDialogKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RestorePurchasesState.values().length];
            try {
                iArr[RestorePurchasesState.PURCHASES_RECOVERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RestorePurchasesState.PURCHASES_NOT_FOUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RestorePurchasesState.RESTORING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void PurchasesNotFoundDialog(final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r25, final kotlin.jvm.functions.Function0<kotlin.Unit> r26, kotlin.jvm.functions.Function0<kotlin.Unit> r27, androidx.compose.runtime.Composer r28, final int r29, final int r30) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesNotFoundDialog(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchasesRecoveredDialog(final CustomerCenterConfigData.Localization localization, final Function0<Unit> function0, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(1735282777);
        if ((i3 & 6) == 0) {
            i4 = i3 | (composerK.I(localization) ? 4 : 2);
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function0) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1735282777, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog (RestorePurchasesDialog.kt:78)");
            }
            composer2 = composerK;
            AndroidAlertDialog_androidKt.a(function0, ComposableLambdaKt.e(1752184593, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    if ((i5 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1752184593, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous> (RestorePurchasesDialog.kt:98)");
                    }
                    Function0<Unit> function02 = function0;
                    final CustomerCenterConfigData.Localization localization2 = localization;
                    ButtonKt.e(function02, null, false, null, null, null, null, null, null, ComposableLambdaKt.e(-1528989004, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.1.1
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                            invoke((RowScope) obj, (Composer) obj2, ((Number) obj3).intValue());
                            return Unit.f139807a;
                        }

                        public final void invoke(RowScope TextButton, Composer composer4, int i6) {
                            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                            if ((i6 & 17) == 16 && composer4.l()) {
                                composer4.Q();
                                return;
                            }
                            if (ComposerKt.M()) {
                                ComposerKt.U(-1528989004, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous>.<anonymous> (RestorePurchasesDialog.kt:99)");
                            }
                            TextKt.c(localization2.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.DONE), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer4, 0, 0, 131070);
                            if (ComposerKt.M()) {
                                ComposerKt.T();
                            }
                        }
                    }, composer3, 54), composer3, 805306368, 510);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), null, null, null, ComposableLambdaKt.e(90877325, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    if ((i5 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(90877325, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous> (RestorePurchasesDialog.kt:82)");
                    }
                    TextKt.c(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_RECOVERED), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composer3, MaterialTheme.f18111b).j(), composer3, 0, 0, 65534);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), ComposableLambdaKt.e(-324449492, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.3
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    if ((i5 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-324449492, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.PurchasesRecoveredDialog.<anonymous> (RestorePurchasesDialog.kt:90)");
                    }
                    TextKt.c(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_RECOVERED_EXPLANATION), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composer3, MaterialTheme.f18111b).b(), composer3, 0, 0, 65534);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, ((i4 >> 3) & 14) | 1769520, 0, 16284);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.PurchasesRecoveredDialog.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    RestorePurchasesDialogKt.PurchasesRecoveredDialog(localization, function0, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final /* synthetic */ void RestorePurchasesDialog(final RestorePurchasesState state, CustomerCenterConfigData.Localization localization, Function0 onDismiss, final Function0 onRestore, Function0 function0, Composer composer, final int i3) {
        int i4;
        Function0 function02;
        final CustomerCenterConfigData.Localization localization2;
        Function0 function03;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(localization, "localization");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        Intrinsics.checkNotNullParameter(onRestore, "onRestore");
        Composer composerK = composer.k(-1558153315);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(state) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(localization) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(onDismiss) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i3 & 3072) == 0) {
            i4 |= composerK.I(onRestore) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i4 |= composerK.I(function0) ? 16384 : Utility.DEFAULT_STREAM_BUFFER_SIZE;
        }
        if ((i4 & 9363) == 9362 && composerK.l()) {
            composerK.Q();
            function02 = onDismiss;
            localization2 = localization;
            function03 = function0;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1558153315, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialog (RestorePurchasesDialog.kt:28)");
            }
            int i5 = WhenMappings.$EnumSwitchMapping$0[state.ordinal()];
            if (i5 == 1) {
                function02 = onDismiss;
                localization2 = localization;
                function03 = function0;
                composerK.a0(-583327083);
                PurchasesRecoveredDialog(localization2, function02, composerK, (i4 >> 3) & 126);
                composerK.U();
            } else if (i5 != 2) {
                if (i5 != 3) {
                    composerK.a0(-902851391);
                    composerK.U();
                } else {
                    composerK.a0(-583314999);
                    RestoringDialog(localization, composerK, (i4 >> 3) & 14);
                    Unit unit = Unit.f139807a;
                    onRestore.invoke();
                    composerK.U();
                }
                function02 = onDismiss;
                localization2 = localization;
                function03 = function0;
            } else {
                composerK.a0(-583322607);
                function02 = onDismiss;
                PurchasesNotFoundDialog(localization, function02, function0, composerK, ((i4 >> 3) & 126) | ((i4 >> 6) & 896), 0);
                localization2 = localization;
                function03 = function0;
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            final Function0 function04 = function03;
            final Function0 function05 = function02;
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialog.2
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
                    RestorePurchasesDialogKt.RestorePurchasesDialog(state, localization2, function05, onRestore, function04, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(ignore = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    public static final void RestorePurchasesDialogNotFoundPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-789679044);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-789679044, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogNotFoundPreview (RestorePurchasesDialog.kt:185)");
            }
            RestorePurchasesDialog(RestorePurchasesState.PURCHASES_NOT_FOUND, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m996invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m996invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m997invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m997invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.3
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m998invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m998invoke();
                    return Unit.f139807a;
                }
            }, composerK, 28038);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview.4
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
                    RestorePurchasesDialogKt.RestorePurchasesDialogNotFoundPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(ignore = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    public static final void RestorePurchasesDialogRecoveredPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(1527727452);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(1527727452, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogRecoveredPreview (RestorePurchasesDialog.kt:172)");
            }
            RestorePurchasesDialog(RestorePurchasesState.PURCHASES_RECOVERED, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m999invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m999invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1000invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1000invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.3
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1001invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1001invoke();
                    return Unit.f139807a;
                }
            }, composerK, 28038);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview.4
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
                    RestorePurchasesDialogKt.RestorePurchasesDialogRecoveredPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @EmergeSnapshotConfig(ignore = PaywallActivityArgsKt.DEFAULT_DISPLAY_DISMISS_BUTTON)
    public static final void RestorePurchasesDialogRestoringPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(2037934116);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(2037934116, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogRestoringPreview (RestorePurchasesDialog.kt:159)");
            }
            RestorePurchasesDialog(RestorePurchasesState.RESTORING, CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null).getLocalization(), new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1002invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1002invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.2
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1003invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1003invoke();
                    return Unit.f139807a;
                }
            }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.3
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1004invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1004invoke();
                    return Unit.f139807a;
                }
            }, composerK, 28038);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview.4
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
                    RestorePurchasesDialogKt.RestorePurchasesDialogRestoringPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RestoringDialog(final CustomerCenterConfigData.Localization localization, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        Composer composerK = composer.k(-1621839505);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(localization) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i4 & 3) == 2 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1621839505, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestoringDialog (RestorePurchasesDialog.kt:50)");
            }
            C25941 c25941 = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestoringDialog.1
                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m1005invoke() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m1005invoke();
                    return Unit.f139807a;
                }
            };
            ComposableSingletons$RestorePurchasesDialogKt composableSingletons$RestorePurchasesDialogKt = ComposableSingletons$RestorePurchasesDialogKt.INSTANCE;
            composer2 = composerK;
            AndroidAlertDialog_androidKt.a(c25941, composableSingletons$RestorePurchasesDialogKt.m994getLambda1$revenuecatui_defaultsBc8Release(), null, null, null, ComposableLambdaKt.e(1131714747, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestoringDialog.2
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    if ((i5 & 3) == 2 && composer3.l()) {
                        composer3.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1131714747, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestoringDialog.<anonymous> (RestorePurchasesDialog.kt:54)");
                    }
                    TextKt.c(localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.PURCHASES_RESTORING), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.f18110a.c(composer3, MaterialTheme.f18111b).j(), composer3, 0, 0, 65534);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composableSingletons$RestorePurchasesDialogKt.m995getLambda2$revenuecatui_defaultsBc8Release(), null, 0L, 0L, 0L, 0L, 0.0f, null, composer2, 1769526, 0, 16284);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesDialogKt.RestoringDialog.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    RestorePurchasesDialogKt.RestoringDialog(localization, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
