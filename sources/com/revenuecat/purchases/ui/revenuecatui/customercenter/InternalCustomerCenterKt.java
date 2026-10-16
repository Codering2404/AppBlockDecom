package com.revenuecat.purchases.ui.revenuecatui.customercenter;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.SnackbarHostKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarColors;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.material3.TopAppBarScrollBehavior;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigDataExtensionsKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterConfigTestData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelFactory;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.NoActiveUserManagementViewKt;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.views.RelevantPurchasesListViewKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesImpl;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.icons.ArrowBackKt;
import com.revenuecat.purchases.ui.revenuecatui.icons.CloseKt;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public final /* synthetic */ class InternalCustomerCenterKt {
    private static final CustomerCenterConfigData previewConfigData;

    /* JADX WARN: Multi-variable type inference failed */
    static {
        CustomerCenterConfigData.Screen.ScreenType screenType = CustomerCenterConfigData.Screen.ScreenType.MANAGEMENT;
        String str = "Manage Subscription";
        String str2 = "Manage subscription subtitle";
        CustomerCenterConfigData.ScreenOffering screenOffering = null;
        Pair pairA = TuplesKt.a(screenType, new CustomerCenterConfigData.Screen(screenType, str, str2, CollectionsKt.listOf(new CustomerCenterConfigData.HelpPath("path-id-1", "Subscription", CustomerCenterConfigData.HelpPath.PathType.CANCEL, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) null, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) null, (String) null, (CustomerCenterConfigData.HelpPath.OpenMethod) null, (String) null, 160, (DefaultConstructorMarker) null)), screenOffering, 16, (DefaultConstructorMarker) (0 == true ? 1 : 0)));
        CustomerCenterConfigData.Screen.ScreenType screenType2 = CustomerCenterConfigData.Screen.ScreenType.NO_ACTIVE;
        Object[] objArr = 0 == true ? 1 : 0;
        Object[] objArr2 = 0 == true ? 1 : 0;
        Object[] objArr3 = 0 == true ? 1 : 0;
        Object[] objArr4 = 0 == true ? 1 : 0;
        String str3 = "No subscriptions found";
        String str4 = "We can try checking your account for any previous purchases";
        CustomerCenterConfigData.ScreenOffering screenOffering2 = null;
        Object[] objArr5 = 0 == true ? 1 : 0;
        Object[] objArr6 = 0 == true ? 1 : 0;
        String str5 = "test@revenuecat.com";
        Boolean bool = null;
        Object[] objArr7 = 0 == true ? 1 : 0;
        Object[] objArr8 = 0 == true ? 1 : 0;
        String str6 = null;
        previewConfigData = new CustomerCenterConfigData(MapsKt.mapOf(pairA, TuplesKt.a(screenType2, new CustomerCenterConfigData.Screen(screenType2, str3, str4, CollectionsKt.listOf(new CustomerCenterConfigData.HelpPath("9q9719171o", "Check for previous purchases", CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) objArr, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) objArr2, (String) objArr3, (CustomerCenterConfigData.HelpPath.OpenMethod) objArr4, (String) null, 248, (DefaultConstructorMarker) null)), screenOffering2, 16, (DefaultConstructorMarker) (0 == true ? 1 : 0)))), new CustomerCenterConfigData.Appearance((CustomerCenterConfigData.Appearance.ColorInformation) null, (CustomerCenterConfigData.Appearance.ColorInformation) (0 == true ? 1 : 0), 3, (DefaultConstructorMarker) (0 == true ? 1 : 0)), new CustomerCenterConfigData.Localization("en_US", MapsKt.mapOf(TuplesKt.a("cancel", "Cancel"), TuplesKt.a("subscription", "Subscription"))), new CustomerCenterConfigData.Support(str5, (Boolean) objArr8, bool, new CustomerCenterConfigData.Support.SupportTickets(false, (CustomerCenterConfigData.Support.SupportTickets.CustomerDetails) objArr6, (CustomerCenterConfigData.Support.SupportTickets.CustomerType) null, 7, (DefaultConstructorMarker) objArr5), 6, (DefaultConstructorMarker) objArr7), str6, 16, (DefaultConstructorMarker) null);
    }

    public static final void CustomerCenterErrorPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(-117134989);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-117134989, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterErrorPreview (InternalCustomerCenter.kt:690)");
            }
            InternalCustomerCenter(new CustomerCenterState.Error(new PurchasesError(PurchasesErrorCode.UnknownBackendError, null, 2, null)), PaddingKt.i(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(10)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterErrorPreview.1
                public final void invoke(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerCenterAction) obj);
                    return Unit.f139807a;
                }
            }, composerK, 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterErrorPreview.2
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
                    InternalCustomerCenterKt.CustomerCenterErrorPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CustomerCenterLoaded(CustomerCenterState.Success success, Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i3) {
        int i4;
        SnackbarHostState snackbarHostState;
        final CustomerCenterState.Success success2;
        Modifier.Companion companion;
        int i5;
        BoxScopeInstance boxScopeInstance;
        final Function1<? super CustomerCenterAction, Unit> function12;
        Composer composerK = composer.k(-1615276070);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(success) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        int i6 = i4;
        if ((i6 & 19) == 18 && composerK.l()) {
            composerK.Q();
            success2 = success;
            function12 = function1;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-1615276070, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterLoaded (InternalCustomerCenter.kt:410)");
            }
            composerK.a0(526827882);
            Object objG = composerK.G();
            Composer.Companion companion2 = Composer.f23746a;
            if (objG == companion2.a()) {
                objG = new SnackbarHostState();
                composerK.w(objG);
            }
            SnackbarHostState snackbarHostState2 = (SnackbarHostState) objG;
            composerK.U();
            State stateP = SnapshotStateKt.p(function1, composerK, (i6 >> 3) & 14);
            State stateP2 = SnapshotStateKt.p(success.getCustomerCenterConfigData().getLocalization().commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SENT), composerK, 0);
            Boolean boolValueOf = Boolean.valueOf(success.getShowSupportTicketSuccessSnackbar());
            composerK.a0(526840544);
            boolean zI = composerK.I(success) | composerK.Z(stateP2) | composerK.Z(stateP);
            Object objG2 = composerK.G();
            if (zI || objG2 == companion2.a()) {
                InternalCustomerCenterKt$CustomerCenterLoaded$1$1 internalCustomerCenterKt$CustomerCenterLoaded$1$1 = new InternalCustomerCenterKt$CustomerCenterLoaded$1$1(success, snackbarHostState2, stateP2, stateP, null);
                snackbarHostState = snackbarHostState2;
                composerK.w(internalCustomerCenterKt$CustomerCenterLoaded$1$1);
                objG2 = internalCustomerCenterKt$CustomerCenterLoaded$1$1;
            } else {
                snackbarHostState = snackbarHostState2;
            }
            composerK.U();
            EffectsKt.g(boolValueOf, (Function2) objG2, composerK, 0);
            final State stateD = AnimateAsStateKt.d(success.isRefreshing() ? 0.5f : 1.0f, AnimationSpecKt.n(300, 0, null, 6, null), 0.0f, "refreshAlpha", null, composerK, 3120, 20);
            Modifier.Companion companion3 = Modifier.b8;
            Modifier modifierF = SizeKt.f(companion3, 0.0f, 1, null);
            Alignment.Companion companion4 = Alignment.f25072a;
            MeasurePolicy measurePolicyG = BoxKt.g(companion4.o(), false);
            int iA = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU = composerK.u();
            Modifier modifierF2 = ComposedModifierKt.f(composerK, modifierF);
            ComposeUiNode.Companion companion5 = ComposeUiNode.f8;
            Function0 function0A = companion5.a();
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
            Updater.e(composerA, measurePolicyG, companion5.e());
            Updater.e(composerA, compositionLocalMapU, companion5.g());
            Function2 function2B = companion5.b();
            if (composerA.i() || !Intrinsics.areEqual(composerA.G(), Integer.valueOf(iA))) {
                composerA.w(Integer.valueOf(iA));
                composerA.p(Integer.valueOf(iA), function2B);
            }
            Updater.e(composerA, modifierF2, companion5.f());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.f6642a;
            Modifier modifierF3 = SizeKt.f(companion3, 0.0f, 1, null);
            composerK.a0(-244583743);
            boolean Z = composerK.Z(stateD);
            Object objG3 = composerK.G();
            if (Z || objG3 == companion2.a()) {
                objG3 = new Function1<GraphicsLayerScope, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterLoaded$2$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayer) {
                        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
                        graphicsLayer.c(InternalCustomerCenterKt.CustomerCenterLoaded$lambda$16(stateD));
                    }
                };
                composerK.w(objG3);
            }
            composerK.U();
            Modifier modifierA = GraphicsLayerModifierKt.a(modifierF3, (Function1) objG3);
            MeasurePolicy measurePolicyG2 = BoxKt.g(companion4.o(), false);
            int iA2 = ComposablesKt.a(composerK, 0);
            CompositionLocalMap compositionLocalMapU2 = composerK.u();
            Modifier modifierF4 = ComposedModifierKt.f(composerK, modifierA);
            Function0 function0A2 = companion5.a();
            if (composerK.m() == null) {
                ComposablesKt.c();
            }
            composerK.L();
            if (composerK.i()) {
                composerK.P(function0A2);
            } else {
                composerK.v();
            }
            Composer composerA2 = Updater.a(composerK);
            Updater.e(composerA2, measurePolicyG2, companion5.e());
            Updater.e(composerA2, compositionLocalMapU2, companion5.g());
            Function2 function2B2 = companion5.b();
            if (composerA2.i() || !Intrinsics.areEqual(composerA2.G(), Integer.valueOf(iA2))) {
                composerA2.w(Integer.valueOf(iA2));
                composerA2.p(Integer.valueOf(iA2), function2B2);
            }
            Updater.e(composerA2, modifierF4, companion5.f());
            CustomerCenterNavHost(success.getCurrentDestination(), success, function1, null, composerK, (i6 << 3) & 1008, 8);
            success2 = success;
            composerK.y();
            composerK.a0(-244573442);
            if (success2.isRefreshing()) {
                i5 = 16;
                boxScopeInstance = boxScopeInstance2;
                companion = companion3;
                ProgressIndicatorKt.d(boxScopeInstance2.f(companion3, companion4.e()), 0L, 0.0f, 0L, 0, composerK, 0, 30);
                composerK = composerK;
            } else {
                companion = companion3;
                i5 = 16;
                boxScopeInstance = boxScopeInstance2;
            }
            composerK.U();
            function12 = function1;
            SnackbarHostKt.b(snackbarHostState, PaddingKt.i(boxScopeInstance.f(companion, companion4.b()), Dp.g(i5)), null, composerK, 6, 4);
            composerK.y();
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoaded.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i7) {
                    InternalCustomerCenterKt.CustomerCenterLoaded(success2, function12, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<CustomerCenterAction, Unit> CustomerCenterLoaded$lambda$13(State<? extends Function1<? super CustomerCenterAction, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String CustomerCenterLoaded$lambda$14(State<String> state) {
        return (String) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float CustomerCenterLoaded$lambda$16(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    public static final void CustomerCenterLoadedPreview(Composer composer, final int i3) {
        List<CustomerCenterConfigData.HelpPath> listEmptyList;
        List listEmptyList2;
        List<CustomerCenterConfigData.HelpPath> paths;
        Composer composerK = composer.k(899134290);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(899134290, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterLoadedPreview (InternalCustomerCenter.kt:702)");
            }
            CustomerCenterConfigData customerCenterConfigData = previewConfigData;
            List listListOf = CollectionsKt.listOf(CustomerCenterConfigTestData.INSTANCE.getPurchaseInformationMonthlyRenewing());
            CustomerCenterConfigData.Screen managementScreen = customerCenterConfigData.getManagementScreen();
            if (managementScreen == null || (listEmptyList = managementScreen.getPaths()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            List<CustomerCenterConfigData.HelpPath> list = listEmptyList;
            CustomerCenterConfigData.Screen managementScreen2 = customerCenterConfigData.getManagementScreen();
            if (managementScreen2 == null || (paths = managementScreen2.getPaths()) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                listEmptyList2 = new ArrayList();
                for (Object obj : paths) {
                    if (((CustomerCenterConfigData.HelpPath) obj).getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
                        listEmptyList2.add(obj);
                    }
                }
            }
            InternalCustomerCenter(new CustomerCenterState.Success(customerCenterConfigData, listListOf, list, listEmptyList2, null, null, null, null, null, false, false, 2032, null), PaddingKt.i(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(10)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadedPreview.2
                public final void invoke(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((CustomerCenterAction) obj2);
                    return Unit.f139807a;
                }
            }, composerK, 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadedPreview.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    invoke((Composer) obj2, ((Number) obj3).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    InternalCustomerCenterKt.CustomerCenterLoadedPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void CustomerCenterLoadingPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(626880743);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(626880743, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterLoadingPreview (InternalCustomerCenter.kt:678)");
            }
            InternalCustomerCenter(CustomerCenterState.Loading.INSTANCE, PaddingKt.i(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(10)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadingPreview.1
                public final void invoke(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerCenterAction) obj);
                    return Unit.f139807a;
                }
            }, composerK, 438, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterLoadingPreview.2
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
                    InternalCustomerCenterKt.CustomerCenterLoadingPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void CustomerCenterMultiplePurchasesPreview(Composer composer, final int i3) {
        List listEmptyList;
        List listEmptyList2;
        List<CustomerCenterConfigData.HelpPath> paths;
        List<CustomerCenterConfigData.HelpPath> paths2;
        Composer composerK = composer.k(348505677);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(348505677, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterMultiplePurchasesPreview (InternalCustomerCenter.kt:721)");
            }
            CustomerCenterConfigData customerCenterConfigData = previewConfigData;
            CustomerCenterConfigTestData customerCenterConfigTestData = CustomerCenterConfigTestData.INSTANCE;
            List listListOf = CollectionsKt.listOf((Object[]) new PurchaseInformation[]{customerCenterConfigTestData.getPurchaseInformationMonthlyRenewing(), customerCenterConfigTestData.getPurchaseInformationYearlyExpiring()});
            CustomerCenterConfigData.Screen managementScreen = customerCenterConfigData.getManagementScreen();
            if (managementScreen == null || (paths2 = managementScreen.getPaths()) == null) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = new ArrayList();
                for (Object obj : paths2) {
                    CustomerCenterConfigData.HelpPath helpPath = (CustomerCenterConfigData.HelpPath) obj;
                    if (helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE || helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL) {
                        listEmptyList.add(obj);
                    }
                }
            }
            List list = listEmptyList;
            CustomerCenterConfigData.Screen managementScreen2 = previewConfigData.getManagementScreen();
            if (managementScreen2 == null || (paths = managementScreen2.getPaths()) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            } else {
                listEmptyList2 = new ArrayList();
                for (Object obj2 : paths) {
                    if (((CustomerCenterConfigData.HelpPath) obj2).getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
                        listEmptyList2.add(obj2);
                    }
                }
            }
            InternalCustomerCenter(new CustomerCenterState.Success(customerCenterConfigData, listListOf, list, listEmptyList2, null, null, null, null, null, false, false, 2032, null), PaddingKt.i(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(10)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterMultiplePurchasesPreview.3
                public final void invoke(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((CustomerCenterAction) obj3);
                    return Unit.f139807a;
                }
            }, composerK, 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterMultiplePurchasesPreview.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj3, Object obj4) {
                    invoke((Composer) obj3, ((Number) obj4).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i4) {
                    InternalCustomerCenterKt.CustomerCenterMultiplePurchasesPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CustomerCenterNavHost(final com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination r17, final com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState.Success r18, final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction, kotlin.Unit> r19, androidx.compose.ui.Modifier r20, androidx.compose.runtime.Composer r21, final int r22, final int r23) {
        /*
            Method dump skipped, instruction units count: 445
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavHost(com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination, com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState$Success, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CustomerCenterNavigationIcon(final CustomerCenterState.NavigationButtonType navigationButtonType, final Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i3) {
        int i4;
        Composer composerK = composer.k(-501948109);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(navigationButtonType) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function1) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-501948109, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNavigationIcon (InternalCustomerCenter.kt:392)");
            }
            composerK.a0(1087660344);
            boolean z2 = (i4 & 112) == 32;
            Object objG = composerK.G();
            if (z2 || objG == Composer.f23746a.a()) {
                objG = new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavigationIcon$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Object invoke() {
                        m983invoke();
                        return Unit.f139807a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                    public final void m983invoke() {
                        function1.invoke(CustomerCenterAction.NavigationButtonPressed.INSTANCE);
                    }
                };
                composerK.w(objG);
            }
            composerK.U();
            IconButtonKt.e((Function0) objG, null, false, null, null, ComposableLambdaKt.e(-1324873520, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavigationIcon.2

                /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$CustomerCenterNavigationIcon$2$WhenMappings */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[CustomerCenterState.NavigationButtonType.values().length];
                        try {
                            iArr[CustomerCenterState.NavigationButtonType.BACK.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[CustomerCenterState.NavigationButtonType.CLOSE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    ImageVector arrowBack;
                    if ((i5 & 3) == 2 && composer2.l()) {
                        composer2.Q();
                        return;
                    }
                    if (ComposerKt.M()) {
                        ComposerKt.U(-1324873520, i5, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNavigationIcon.<anonymous> (InternalCustomerCenter.kt:396)");
                    }
                    int i6 = WhenMappings.$EnumSwitchMapping$0[navigationButtonType.ordinal()];
                    if (i6 == 1) {
                        arrowBack = ArrowBackKt.getArrowBack();
                    } else {
                        if (i6 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        arrowBack = CloseKt.getClose();
                    }
                    IconKt.d(arrowBack, null, null, 0L, composer2, 48, 12);
                    if (ComposerKt.M()) {
                        ComposerKt.T();
                    }
                }
            }, composerK, 54), composerK, 196608, 30);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNavigationIcon.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i5) {
                    InternalCustomerCenterKt.CustomerCenterNavigationIcon(navigationButtonType, function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    public static final void CustomerCenterNoActiveScreenPreview(Composer composer, final int i3) {
        Composer composerK = composer.k(595047360);
        if (i3 == 0 && composerK.l()) {
            composerK.Q();
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(595047360, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterNoActiveScreenPreview (InternalCustomerCenter.kt:661)");
            }
            InternalCustomerCenter(new CustomerCenterState.Success(previewConfigData, CollectionsKt.emptyList(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, null, null, null, null, false, false, 2032, null), PaddingKt.i(SizeKt.f(Modifier.b8, 0.0f, 1, null), Dp.g(10)), new Function1<CustomerCenterAction, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNoActiveScreenPreview.1
                public final void invoke(CustomerCenterAction it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerCenterAction) obj);
                    return Unit.f139807a;
                }
            }, composerK, 432, 0);
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterNoActiveScreenPreview.2
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
                    InternalCustomerCenterKt.CustomerCenterNoActiveScreenPreview(composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void CustomerCenterScaffold(final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction, kotlin.Unit> r22, final com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterScaffoldConfig r23, androidx.compose.ui.Modifier r24, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterScaffold(kotlin.jvm.functions.Function1, com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterScaffoldConfig, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void CustomerCenterTopBar(final CustomerCenterScaffoldConfig customerCenterScaffoldConfig, TopAppBarScrollBehavior topAppBarScrollBehavior, final Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i3) {
        int i4;
        final TopAppBarScrollBehavior topAppBarScrollBehavior2;
        Composer composerK = composer.k(317175815);
        if ((i3 & 6) == 0) {
            i4 = (composerK.Z(customerCenterScaffoldConfig) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.Z(topAppBarScrollBehavior) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= composerK.I(function1) ? Function.MAX_NARGS : ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD;
        }
        if ((i4 & 147) == 146 && composerK.l()) {
            composerK.Q();
            topAppBarScrollBehavior2 = topAppBarScrollBehavior;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(317175815, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar (InternalCustomerCenter.kt:351)");
            }
            TopAppBarDefaults topAppBarDefaults = TopAppBarDefaults.f21543a;
            MaterialTheme materialTheme = MaterialTheme.f18110a;
            int i5 = MaterialTheme.f18111b;
            TopAppBarColors topAppBarColorsP = topAppBarDefaults.p(materialTheme.a(composerK, i5).c(), materialTheme.a(composerK, i5).c(), materialTheme.a(composerK, i5).W(), materialTheme.a(composerK, i5).W(), 0L, composerK, TopAppBarDefaults.f21549g << 15, 16);
            if (customerCenterScaffoldConfig.getShouldUseLargeTopBar()) {
                composerK.a0(1321464226);
                AppBarKt.i(ComposableLambdaKt.e(391648475, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        if ((i6 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(391648475, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:361)");
                        }
                        String title = customerCenterScaffoldConfig.getTitle();
                        if (title != null) {
                            TextKt.c(title, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), null, ComposableLambdaKt.e(389814109, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        if ((i6 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(389814109, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:364)");
                        }
                        InternalCustomerCenterKt.CustomerCenterNavigationIcon(customerCenterScaffoldConfig.getNavigationButtonType(), function1, composer2, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), null, 0.0f, 0.0f, null, topAppBarColorsP, topAppBarScrollBehavior, composerK, ((i4 << 21) & 234881024) | 390, 122);
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                composerK.U();
            } else {
                topAppBarScrollBehavior2 = topAppBarScrollBehavior;
                composerK.a0(1321910068);
                AppBarKt.p(ComposableLambdaKt.e(1110666087, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.3
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        if ((i6 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(1110666087, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:375)");
                        }
                        String title = customerCenterScaffoldConfig.getTitle();
                        if (title != null) {
                            TextKt.c(title, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 131070);
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), null, ComposableLambdaKt.e(237000485, true, new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        invoke((Composer) obj, ((Number) obj2).intValue());
                        return Unit.f139807a;
                    }

                    public final void invoke(Composer composer2, int i6) {
                        if ((i6 & 3) == 2 && composer2.l()) {
                            composer2.Q();
                            return;
                        }
                        if (ComposerKt.M()) {
                            ComposerKt.U(237000485, i6, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.CustomerCenterTopBar.<anonymous> (InternalCustomerCenter.kt:378)");
                        }
                        InternalCustomerCenterKt.CustomerCenterNavigationIcon(customerCenterScaffoldConfig.getNavigationButtonType(), function1, composer2, 0);
                        if (ComposerKt.M()) {
                            ComposerKt.T();
                        }
                    }
                }, composerK, 54), null, 0.0f, null, topAppBarColorsP, null, composerK, 390, 186);
                composerK.U();
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composerK.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.CustomerCenterTopBar.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer2, int i6) {
                    InternalCustomerCenterKt.CustomerCenterTopBar(customerCenterScaffoldConfig, topAppBarScrollBehavior2, function1, composer2, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:189:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0173  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final /* synthetic */ void InternalCustomerCenter(androidx.compose.ui.Modifier r19, com.revenuecat.purchases.customercenter.CustomerCenterListener r20, com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel r21, final kotlin.jvm.functions.Function0 r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instruction units count: 859
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter(androidx.compose.ui.Modifier, com.revenuecat.purchases.customercenter.CustomerCenterListener, com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CustomerCenterState InternalCustomerCenter$lambda$1(State<? extends CustomerCenterState> state) {
        return (CustomerCenterState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainScreenContent(final CustomerCenterState.Success success, Function1<? super CustomerCenterAction, Unit> function1, Composer composer, final int i3) {
        int i4;
        Composer composer2;
        final Function1<? super CustomerCenterAction, Unit> function12 = function1;
        Composer composerK = composer.k(-622947142);
        if ((i3 & 6) == 0) {
            i4 = (composerK.I(success) ? 4 : 2) | i3;
        } else {
            i4 = i3;
        }
        if ((i3 & 48) == 0) {
            i4 |= composerK.I(function12) ? 32 : 16;
        }
        if ((i4 & 19) == 18 && composerK.l()) {
            composerK.Q();
            composer2 = composerK;
        } else {
            if (ComposerKt.M()) {
                ComposerKt.U(-622947142, i4, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.MainScreenContent (InternalCustomerCenter.kt:555)");
            }
            CustomerCenterConfigData customerCenterConfigData = success.getCustomerCenterConfigData();
            if (success.getPurchases().isEmpty()) {
                composer2 = composerK;
                composer2.a0(388207578);
                CustomerCenterConfigData.Screen noActiveScreen = customerCenterConfigData.getNoActiveScreen();
                if (noActiveScreen == null) {
                    function12 = function1;
                } else {
                    function12 = function1;
                    NoActiveUserManagementViewKt.NoActiveUserManagementView(noActiveScreen, customerCenterConfigData.getSupport().getEmail(), customerCenterConfigData.getAppearance(), customerCenterConfigData.getLocalization(), customerCenterConfigData.getSupport().getSupportTickets(), success.getNoActiveScreenOffering(), success.getVirtualCurrencies(), function12, composer2, (i4 << 18) & 29360128, 0);
                    composer2 = composer2;
                    Unit unit = Unit.f139807a;
                }
                composer2.U();
            } else {
                composerK.a0(387234953);
                if (customerCenterConfigData.getManagementScreen() == null) {
                    composer2 = composerK;
                } else {
                    List mainScreenPaths = success.getMainScreenPaths();
                    String email = customerCenterConfigData.getSupport().getEmail();
                    VirtualCurrencies virtualCurrencies = success.getVirtualCurrencies();
                    CustomerCenterConfigData.Appearance appearance = customerCenterConfigData.getAppearance();
                    CustomerCenterConfigData.Localization localization = customerCenterConfigData.getLocalization();
                    CustomerCenterConfigData.Support.SupportTickets supportTickets = customerCenterConfigData.getSupport().getSupportTickets();
                    composerK.a0(684114534);
                    boolean zI = ((i4 & 112) == 32) | composerK.I(success);
                    Object objG = composerK.G();
                    if (zI || objG == Composer.f23746a.a()) {
                        objG = new Function1<PurchaseInformation, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$MainScreenContent$1$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((PurchaseInformation) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(PurchaseInformation purchase) {
                                Intrinsics.checkNotNullParameter(purchase, "purchase");
                                if (success.getPurchases().size() > 1) {
                                    function12.invoke(new CustomerCenterAction.SelectPurchase(purchase));
                                }
                            }
                        };
                        composerK.w(objG);
                    }
                    composerK.U();
                    composer2 = composerK;
                    RelevantPurchasesListViewKt.RelevantPurchasesListView(mainScreenPaths, email, virtualCurrencies, appearance, localization, supportTickets, (Function1) objG, function12, null, success.getPurchases(), composer2, (i4 << 18) & 29360128, Function.MAX_NARGS);
                    Unit unit2 = Unit.f139807a;
                }
                composer2.U();
                function12 = function1;
            }
            if (ComposerKt.M()) {
                ComposerKt.T();
            }
        }
        ScopeUpdateScope scopeUpdateScopeN = composer2.n();
        if (scopeUpdateScopeN != null) {
            scopeUpdateScopeN.a(new Function2<Composer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.MainScreenContent.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.f139807a;
                }

                public final void invoke(Composer composer3, int i5) {
                    InternalCustomerCenterKt.MainScreenContent(success, function12, composer3, RecomposeScopeImplKt.a(i3 | 1));
                }
            });
        }
    }

    private static final ColorScheme createColorScheme(CustomerCenterState customerCenterState, Composer composer, int i3) {
        composer.a0(352157510);
        if (ComposerKt.M()) {
            ComposerKt.U(352157510, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.createColorScheme (InternalCustomerCenter.kt:251)");
        }
        boolean zA = DarkThemeKt.a(composer, 0);
        ColorScheme colorSchemeA = MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b);
        composer.a0(636383891);
        boolean zB = composer.b(zA) | ((((i3 & 14) ^ 6) > 4 && composer.Z(customerCenterState)) || (i3 & 6) == 4) | composer.Z(colorSchemeA);
        Object objG = composer.G();
        if (zB || objG == Composer.f23746a.a()) {
            if (customerCenterState instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) customerCenterState;
                CustomerCenterConfigData.Appearance appearance = success.getCustomerCenterConfigData().getAppearance();
                Color colorForTheme = CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zA, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$createColorScheme$1$accentColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getAccentColor();
                    }
                });
                Color colorForTheme2 = success.getCurrentDestination() instanceof CustomerCenterDestination.PromotionalOffer ? CustomerCenterConfigDataExtensionsKt.getColorForTheme(appearance, zA, new Function1<CustomerCenterConfigData.Appearance.ColorInformation, PaywallColor>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt$createColorScheme$1$backgroundColor$1
                    @Override // kotlin.jvm.functions.Function1
                    public final PaywallColor invoke(CustomerCenterConfigData.Appearance.ColorInformation it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return it.getBackgroundColor();
                    }
                }) : null;
                colorSchemeA = ColorScheme.b(colorSchemeA, colorForTheme != null ? colorForTheme.B() : colorSchemeA.j0(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, colorForTheme2 != null ? colorForTheme2.B() : colorSchemeA.c(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, -8194, 15, null);
            }
            composer.w(colorSchemeA);
            objG = colorSchemeA;
        }
        ColorScheme colorScheme = (ColorScheme) objG;
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return colorScheme;
    }

    private static final ScaffoldConfigData createScaffoldState(CustomerCenterState customerCenterState, Composer composer, int i3) {
        composer.a0(953700373);
        if (ComposerKt.M()) {
            ComposerKt.U(953700373, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.createScaffoldState (InternalCustomerCenter.kt:284)");
        }
        composer.a0(2044243650);
        boolean z2 = (((i3 & 14) ^ 6) > 4 && composer.Z(customerCenterState)) || (i3 & 6) == 4;
        Object objG = composer.G();
        if (z2 || objG == Composer.f23746a.a()) {
            if (customerCenterState instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) customerCenterState;
                String title = success.getNavigationState().getCurrentDestination().getTitle();
                objG = new ScaffoldConfigData(title, customerCenterState.getNavigationButtonType(), (success.getCurrentDestination() instanceof CustomerCenterDestination.Main) && title != null);
            } else {
                objG = new ScaffoldConfigData(null, CustomerCenterState.NavigationButtonType.CLOSE, false);
            }
            composer.w(objG);
        }
        ScaffoldConfigData scaffoldConfigData = (ScaffoldConfigData) objG;
        composer.U();
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer.U();
        return scaffoldConfigData;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final CustomerCenterViewModel getCustomerCenterViewModel(boolean z2, CustomerCenterListener customerCenterListener, PurchasesType purchasesType, CustomerCenterViewModel customerCenterViewModel, Composer composer, int i3, int i4) {
        Composer composer2;
        composer.a0(1278114306);
        Purchases purchases = null;
        Object[] objArr = 0;
        if ((i4 & 2) != 0) {
            customerCenterListener = null;
        }
        if ((i4 & 4) != 0) {
            purchasesType = new PurchasesImpl(purchases, 1, objArr == true ? 1 : 0);
        }
        if ((i4 & 8) != 0) {
            CustomerCenterViewModelFactory customerCenterViewModelFactory = new CustomerCenterViewModelFactory(purchasesType, MaterialTheme.f18110a.a(composer, MaterialTheme.f18111b), z2, customerCenterListener);
            composer.F(1729797275);
            ViewModelStoreOwner viewModelStoreOwnerC = LocalViewModelStoreOwner.f40240a.c(composer, 6);
            if (viewModelStoreOwnerC == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner");
            }
            composer2 = composer;
            ViewModel viewModelB = ViewModelKt.b(Reflection.b(CustomerCenterViewModelImpl.class), viewModelStoreOwnerC, null, customerCenterViewModelFactory, viewModelStoreOwnerC instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) viewModelStoreOwnerC).getDefaultViewModelCreationExtras() : CreationExtras.Empty.f40230c, composer2, 0, 0);
            composer2.Y();
            customerCenterViewModel = (CustomerCenterViewModel) viewModelB;
        } else {
            composer2 = composer;
        }
        if (ComposerKt.M()) {
            ComposerKt.U(1278114306, i3, -1, "com.revenuecat.purchases.ui.revenuecatui.customercenter.getCustomerCenterViewModel (InternalCustomerCenter.kt:611)");
        }
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        composer2.U();
        return customerCenterViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void InternalCustomerCenter(final com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState r15, androidx.compose.ui.Modifier r16, final kotlin.jvm.functions.Function1<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.actions.CustomerCenterAction, kotlin.Unit> r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.InternalCustomerCenterKt.InternalCustomerCenter(com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int, int):void");
    }
}
