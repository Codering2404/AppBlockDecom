package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
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
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterConstants;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class RelevantPurchasesListViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveSubscriptionsViewNoDescription_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-611911312);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-611911312, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewNoDescription_Preview (RelevantPurchasesListView.kt:250)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screenCopy$default = CustomerCenterConfigData.Screen.copy$default(screen, null, null, null, null, null, 27, null);
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(1539230767, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewNoDescription_Preview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1539230767, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewNoDescription_Preview.<anonymous> (RelevantPurchasesListView.kt:255)");
                    }
                    CustomerCenterConfigData.Screen screen2 = screenCopy$default;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    Modifier.Companion companion = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion);
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen2.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewNoDescription_Preview$1$1$1
                        public final void invoke(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchaseInformation) obj);
                            return Unit.f139807a;
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewNoDescription_Preview$1$1$2
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, null, CollectionsKt.emptyList(), composer2, 819462576, Function.MAX_NARGS);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewNoDescription_Preview.2
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
                    RelevantPurchasesListViewKt.NoActiveSubscriptionsViewNoDescription_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveSubscriptionsViewPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1881756972);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1881756972, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewPreview (RelevantPurchasesListView.kt:178)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(329820115, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewPreview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(329820115, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveSubscriptionsViewPreview.<anonymous> (RelevantPurchasesListView.kt:182)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    Modifier.Companion companion = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion);
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewPreview$1$1$1
                        public final void invoke(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchaseInformation) obj);
                            return Unit.f139807a;
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$NoActiveSubscriptionsViewPreview$1$1$2
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, null, CollectionsKt.emptyList(), composer2, 819462576, Function.MAX_NARGS);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.NoActiveSubscriptionsViewPreview.2
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
                    RelevantPurchasesListViewKt.NoActiveSubscriptionsViewPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void PurchaseListSection(final Set<PurchaseInformation> set, final CustomerCenterConfigData.Localization localization, final int i3, final Function1<? super PurchaseInformation, Unit> function1, Composer composer, final int i4) {
        char c3;
        Composer composerK = composer.k(-1017442857);
        int i5 = (i4 & 6) == 0 ? (composerK.I(set) ? 4 : 2) | i4 : i4;
        CustomerCenterConfigData.Localization localization2 = localization;
        if ((i4 & 48) == 0) {
            i5 |= composerK.I(localization2) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i5 |= composerK.e(i3) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 3072) == 0) {
            i5 |= composerK.I(function1) ? 2048 : 1024;
        }
        if ((i5 & 1171) == 1170 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1017442857, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.PurchaseListSection (RelevantPurchasesListView.kt:118)");
            }
            if (!set.isEmpty()) {
                int i6 = 0;
                for (Object obj : set) {
                    int i7 = i6 + 1;
                    if (i6 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    final PurchaseInformation purchaseInformation = (PurchaseInformation) obj;
                    composerK.a0(-980519695);
                    if (i6 > 0) {
                        SpacerKt.a(SizeKt.v(Modifier.b8, CustomerCenterConstants.Layout.INSTANCE.m963getITEMS_SPACINGD9Ej5fM()), composerK, 6);
                    }
                    composerK.U();
                    ButtonPosition buttonPosition = set.size() == 1 ? ButtonPosition.SINGLE : i6 == 0 ? ButtonPosition.FIRST : i6 == set.size() - 1 ? ButtonPosition.LAST : ButtonPosition.MIDDLE;
                    Function0 function0 = null;
                    Modifier modifierK = PaddingKt.k(SizeKt.h(Modifier.b8, 0.0f, 1, null), CustomerCenterConstants.Layout.INSTANCE.m962getHORIZONTAL_PADDINGD9Ej5fM(), 0.0f, 2, null);
                    boolean z2 = i3 == 1;
                    composerK.a0(-980493404);
                    if (i3 > 1) {
                        composerK.a0(-917850771);
                        boolean zI = ((i5 & 7168) == 2048) | composerK.I(purchaseInformation);
                        Object objG = composerK.G();
                        if (zI || objG == Composer.f23746a.a()) {
                            objG = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$PurchaseListSection$1$1$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public /* bridge */ /* synthetic */ Object invoke() {
                                    m1058invoke();
                                    return Unit.f139807a;
                                }

                                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                                public final void m1058invoke() {
                                    function1.invoke(purchaseInformation);
                                }
                            };
                            composerK.w(objG);
                        }
                        composerK.U();
                        function0 = (Function0) objG;
                        c3 = 2048;
                    } else {
                        c3 = 2048;
                    }
                    composerK.U();
                    PurchaseInformationCardViewKt.PurchaseInformationCardView(purchaseInformation, localization2, modifierK, buttonPosition, z2, function0, composerK, (i5 & 112) | 384, 0);
                    localization2 = localization;
                    i6 = i7;
                }
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.PurchaseListSection.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i8) {
                    RelevantPurchasesListViewKt.PurchaseListSection(set, localization, i3, function1, composer2, RecomposeScopeImplKt.a(i4 | 1));
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x011f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void RelevantPurchasesListView(final java.util.List<com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath> r42, final java.lang.String r43, final com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies r44, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance r45, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r46, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets r47, final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation, kotlin.Unit> r48, final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction, kotlin.Unit> r49, androidx.compose.ui.Modifier r50, java.util.List<com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54) {
        /*
            Method dump skipped, instruction units count: 969
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListView(java.util.List, java.lang.String, com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Appearance, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, java.util.List, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-29475920);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-29475920, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewPreview (RelevantPurchasesListView.kt:156)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(-2112866129, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewPreview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-2112866129, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewPreview.<anonymous> (RelevantPurchasesListView.kt:160)");
                    }
                    Modifier modifierF = SizeKt.f(Modifier.b8, 0.0f, 1, null);
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    MeasurePolicy measurePolicyG = BoxKt.g(Alignment.f25072a.o(), false);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF2 = ComposedModifierKt.f(composer2, modifierF);
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
                    Updater.e(composerA, modifierF2, companion.f());
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.f6642a;
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewPreview$1$1$1
                        public final void invoke(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchaseInformation) obj);
                            return Unit.f139807a;
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewPreview$1$1$2
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, null, CollectionsKt.listOf(CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing()), composer2, 14156208, Function.MAX_NARGS);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewPreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithLifetimePurchasePreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1781255744);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1781255744, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithLifetimePurchasePreview (RelevantPurchasesListView.kt:200)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(623687999, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithLifetimePurchasePreview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(623687999, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithLifetimePurchasePreview.<anonymous> (RelevantPurchasesListView.kt:204)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    Modifier.Companion companion = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion);
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(screen3.getPaths(), "support@revenuecat.com", null, customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithLifetimePurchasePreview$1$1$1
                        public final void invoke(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchaseInformation) obj);
                            return Unit.f139807a;
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithLifetimePurchasePreview$1$1$2
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, null, CollectionsKt.listOf(CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationLifetime()), composer2, 14156208, Function.MAX_NARGS);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithLifetimePurchasePreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithLifetimePurchasePreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(531462629);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(531462629, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview (RelevantPurchasesListView.kt:308)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(1494673350, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1494673350, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview.<anonymous> (RelevantPurchasesListView.kt:312)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    Modifier.Companion companion = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion);
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
                    List<CustomerCenterConfigData.HelpPath> paths = screen3.getPaths();
                    CustomerCenterConfigData.Appearance appearance = customerCenterConfigData.getAppearance();
                    CustomerCenterConfigData.Localization localization = customerCenterConfigData.getLocalization();
                    CustomerCenterConfigData.Support.SupportTickets supportTickets = customerCenterConfigData.getSupport().getSupportTickets();
                    CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(paths, "support@revenuecat.com", customerCenterConfigTestData.getFiveVirtualCurrencies(), appearance, localization, supportTickets, new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview$1$1$1
                        public final void invoke(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchaseInformation) obj);
                            return Unit.f139807a;
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview$1$1$2
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, null, CollectionsKt.listOf((Object[]) new PurchaseInformation[]{customerCenterConfigTestData.getPurchaseInformationMonthlyRenewing(), customerCenterConfigTestData.getPurchaseInformationLifetime()}), composer2, 14155824, Function.MAX_NARGS);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesAndVirtualCurrenciesPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithMultiplePurchasesPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(666289000);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(666289000, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesPreview (RelevantPurchasesListView.kt:278)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(-2089866295, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesPreview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-2089866295, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithMultiplePurchasesPreview.<anonymous> (RelevantPurchasesListView.kt:282)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    Modifier.Companion companion = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion);
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
                    List<CustomerCenterConfigData.HelpPath> paths = screen3.getPaths();
                    CustomerCenterConfigData.Appearance appearance = customerCenterConfigData.getAppearance();
                    CustomerCenterConfigData.Localization localization = customerCenterConfigData.getLocalization();
                    CustomerCenterConfigData.Support.SupportTickets supportTickets = customerCenterConfigData.getSupport().getSupportTickets();
                    CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(paths, "support@revenuecat.com", null, appearance, localization, supportTickets, new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesPreview$1$1$1
                        public final void invoke(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchaseInformation) obj);
                            return Unit.f139807a;
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithMultiplePurchasesPreview$1$1$2
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, null, CollectionsKt.listOf((Object[]) new PurchaseInformation[]{customerCenterConfigTestData.getPurchaseInformationMonthlyRenewing(), customerCenterConfigTestData.getPurchaseInformationYearlyExpiring()}), composer2, 14156208, Function.MAX_NARGS);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesPreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithMultiplePurchasesPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-577177921);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-577177921, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview (RelevantPurchasesListView.kt:224)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(1430822974, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview.1
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
                    if ((i4 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(1430822974, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview.<anonymous> (RelevantPurchasesListView.kt:228)");
                    }
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
                    Modifier.Companion companion = Modifier.b8;
                    MeasurePolicy measurePolicyA = ColumnKt.a(Arrangement.f6574a.h(), Alignment.f25072a.k(), composer2, 0);
                    int iA = ComposablesKt.a(composer2, 0);
                    CompositionLocalMap compositionLocalMapU = composer2.u();
                    Modifier modifierF = ComposedModifierKt.f(composer2, companion);
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
                    List<CustomerCenterConfigData.HelpPath> paths = screen3.getPaths();
                    CustomerCenterConfigData.Appearance appearance = customerCenterConfigData.getAppearance();
                    CustomerCenterConfigData.Localization localization = customerCenterConfigData.getLocalization();
                    CustomerCenterConfigData.Support.SupportTickets supportTickets = customerCenterConfigData.getSupport().getSupportTickets();
                    CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(paths, "support@revenuecat.com", null, appearance, localization, supportTickets, new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview$1$1$1
                        public final void invoke(PurchaseInformation it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((PurchaseInformation) obj);
                            return Unit.f139807a;
                        }
                    }, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt$RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview$1$1$2
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, null, CollectionsKt.listOf((Object[]) new PurchaseInformation[]{customerCenterConfigTestData.getPurchaseInformationMonthlyRenewing(), customerCenterConfigTestData.getPurchaseInformationYearlyExpiring(), customerCenterConfigTestData.getPurchaseInformationLifetime()}), composer2, 14156208, Function.MAX_NARGS);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview.2
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
                    RelevantPurchasesListViewKt.RelevantPurchasesListViewWithSubscriptionsAndLifetimePurchasePreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
