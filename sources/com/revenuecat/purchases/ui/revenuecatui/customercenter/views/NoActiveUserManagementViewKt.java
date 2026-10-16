package com.revenuecat.purchases.ui.revenuecatui.customercenter.views;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.MaterialTheme;
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
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.theme.CustomerCenterPreviewThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class NoActiveUserManagementViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void ContentUnavailableView(final java.lang.String r20, final java.lang.String r21, androidx.compose.ui.Modifier r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 225
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.ContentUnavailableView(java.lang.String, java.lang.String, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:143:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0148  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void NoActiveUserManagementView(final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen r24, final java.lang.String r25, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance r26, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r27, final com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Support.SupportTickets r28, final com.revenuecat.purchases.Offering r29, com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies r30, final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction, kotlin.Unit> r31, androidx.compose.runtime.Composer r32, final int r33, final int r34) {
        /*
            Method dump skipped, instruction units count: 757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Screen, java.lang.String, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Appearance, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Support$SupportTickets, com.revenuecat.purchases.Offering, com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveUserManagementView_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(109169625);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(109169625, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_Preview (NoActiveUserManagementView.kt:157)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(403847802, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_Preview.1
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
                        ComposerKt.U(403847802, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_Preview.<anonymous> (NoActiveUserManagementView.kt:162)");
                    }
                    Modifier modifierD = BackgroundKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), MaterialTheme.f18110a.a(composer2, MaterialTheme.f18111b).c(), null, 2, null);
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
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
                    NoActiveUserManagementViewKt.NoActiveUserManagementView(screen3, "support@example.com", CustomerCenterConfigTestData.INSTANCE.getStandardAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), null, null, new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt$NoActiveUserManagementView_Preview$1$1$1
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, composer2, 12779568, 64);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_Preview.2
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
                    NoActiveUserManagementViewKt.NoActiveUserManagementView_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void NoActiveUserManagementView_WithVCs_Preview(Composer composer, final int i3) {
        Composer composerK = composer.k(-1469396296);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1469396296, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_WithVCs_Preview (NoActiveUserManagementView.kt:189)");
            }
            final CustomerCenterConfigData customerCenterConfigDataCustomerCenterData$default = CustomerCenterConfigTestData.customerCenterData$default(CustomerCenterConfigTestData.INSTANCE, false, false, 3, null);
            CustomerCenterConfigData.Screen screen = customerCenterConfigDataCustomerCenterData$default.getScreens().get(CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE);
            Intrinsics.checkNotNull(screen);
            final CustomerCenterConfigData.Screen screen2 = screen;
            CustomerCenterPreviewThemeKt.CustomerCenterPreviewTheme(ComposableLambdaKt.e(-793311143, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_WithVCs_Preview.1
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
                        ComposerKt.U(-793311143, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementView_WithVCs_Preview.<anonymous> (NoActiveUserManagementView.kt:194)");
                    }
                    Modifier modifierD = BackgroundKt.d(SizeKt.f(Modifier.b8, 0.0f, 1, null), MaterialTheme.f18110a.a(composer2, MaterialTheme.f18111b).c(), null, 2, null);
                    CustomerCenterConfigData.Screen screen3 = screen2;
                    CustomerCenterConfigData customerCenterConfigData = customerCenterConfigDataCustomerCenterData$default;
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
                    CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
                    NoActiveUserManagementViewKt.NoActiveUserManagementView(screen3, "support@example.com", customerCenterConfigTestData.getStandardAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), null, customerCenterConfigTestData.getFiveVirtualCurrencies(), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt$NoActiveUserManagementView_WithVCs_Preview$1$1$1
                        public final void invoke(CustomerCenterAction it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((CustomerCenterAction) obj);
                            return Unit.f139807a;
                        }
                    }, composer2, 12779568, 0);
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
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt.NoActiveUserManagementView_WithVCs_Preview.2
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
                    NoActiveUserManagementViewKt.NoActiveUserManagementView_WithVCs_Preview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }
}
