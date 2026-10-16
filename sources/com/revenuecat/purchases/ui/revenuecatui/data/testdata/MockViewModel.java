package com.revenuecat.purchases.ui.revenuecatui.data.testdata;

import android.app.Activity;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.components.PreviewHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.data.MockPurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallStateKt;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.data.testdata.TestData;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallWarning;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class MockViewModel extends ViewModel implements PaywallViewModel {
    public static final int $stable = 0;
    private static final Companion Companion = new Companion(null);
    private static final long MILLIS_2025_01_25 = 1737763200000L;

    @Deprecated
    public static final long fakePurchaseDelayMillis = 2000;
    private final MutableState<PurchasesError> _actionError;
    private final MutableState<Boolean> _actionInProgress;
    private final MutableStateFlow<PaywallState> _state;
    private final boolean allowsPurchases;
    private int clearActionErrorCallCount;
    private int closePaywallCallCount;
    private int getWebCheckoutUrlCallCount;
    private List<PaywallAction.External.LaunchWebCheckout> getWebCheckoutUrlParams;
    private int handleBackNavigationCallCount;
    private boolean handleBackNavigationResult;
    private int handlePackagePurchaseCount;
    private List<Pair<Activity, Package>> handlePackagePurchaseParams;
    private int handleRestorePurchasesCallCount;
    private int handleWorkflowActionCallCount;
    private List<Pair<String, WorkflowTriggerType>> handleWorkflowActionParams;
    private int invalidateCustomerInfoCacheCallCount;
    private int preloadExitOfferingCallCount;
    private final State<Offering> preloadedExitOffering;
    private final State<Boolean> purchaseCompleted;
    private int purchaseSelectedPackageCallCount;
    private List<String> purchaseSelectedPackageIdentifiers;
    private List<Activity> purchaseSelectedPackageParams;
    private int refreshStateIfColorsChangedCallCount;
    private int refreshStateIfLocaleChangedCallCount;
    private int restorePurchasesCallCount;
    private int selectPackageCallCount;
    private List<TemplateConfiguration.PackageInfo> selectPackageCallParams;
    private final boolean shouldErrorOnUnsupportedMethods;
    private int trackComponentInteractionCallCount;
    private final List<PaywallComponentInteractionData> trackComponentInteractionParams;
    private int trackExitOfferCallCount;
    private List<Pair<ExitOfferType, String>> trackExitOfferParams;
    private int trackPaywallImpressionIfNeededCallCount;
    private int updateOptionsCallCount;
    private List<PaywallOptions> updateOptionsParams;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$awaitSimulateActionInProgress$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel", f = "TestData.kt", l = {730}, m = "awaitSimulateActionInProgress")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MockViewModel.this.awaitSimulateActionInProgress(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$simulateActionInProgress$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$simulateActionInProgress$1", f = "TestData.kt", l = {724}, m = "invokeSuspend")
    static final class C26701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C26701(Continuation<? super C26701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MockViewModel.this.new C26701(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MockViewModel mockViewModel = MockViewModel.this;
                this.label = 1;
                if (mockViewModel.awaitSimulateActionInProgress(this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26701) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public /* synthetic */ MockViewModel(PaywallMode paywallMode, Offering offering, PaywallWarning paywallWarning, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? PaywallMode.Companion.getDefault() : paywallMode, offering, (i3 & 4) != 0 ? null : paywallWarning, (i3 & 8) != 0 ? false : z2, (i3 & 16) != 0 ? true : z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object awaitSimulateActionInProgress(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$awaitSimulateActionInProgress$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$awaitSimulateActionInProgress$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$awaitSimulateActionInProgress$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r0 = r0.L$0
            com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel r0 = (com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel) r0
            kotlin.ResultKt.b(r5)
            goto L4f
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L35:
            kotlin.ResultKt.b(r5)
            androidx.compose.runtime.MutableState<java.lang.Boolean> r5 = r4._actionInProgress
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            r5.setValue(r2)
            r0.L$0 = r4
            r0.label = r3
            r2 = 2000(0x7d0, double:9.88E-321)
            java.lang.Object r5 = kotlinx.coroutines.DelayKt.b(r2, r0)
            if (r5 != r1) goto L4e
            return r1
        L4e:
            r0 = r4
        L4f:
            androidx.compose.runtime.MutableState<java.lang.Boolean> r5 = r0._actionInProgress
            r0 = 0
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.a(r0)
            r5.setValue(r0)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel.awaitSimulateActionInProgress(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void simulateActionInProgress() {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C26701(null), 3, null);
    }

    private final void unsupportedMethod(String str) {
        if (this.shouldErrorOnUnsupportedMethods) {
            throw new IllegalStateException(str.toString());
        }
    }

    static /* synthetic */ void unsupportedMethod$default(MockViewModel mockViewModel, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "Not supported";
        }
        mockViewModel.unsupportedMethod(str);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void clearActionError() {
        this.clearActionErrorCallCount++;
        this._actionError.setValue(null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void closePaywall(PaywallResult paywallResult) {
        this.closePaywallCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getActionInProgress() {
        return this._actionInProgress;
    }

    public final int getClearActionErrorCallCount() {
        return this.clearActionErrorCallCount;
    }

    public final int getClosePaywallCallCount() {
        return this.closePaywallCallCount;
    }

    public final int getGetWebCheckoutUrlCallCount() {
        return this.getWebCheckoutUrlCallCount;
    }

    public final List<PaywallAction.External.LaunchWebCheckout> getGetWebCheckoutUrlParams() {
        return this.getWebCheckoutUrlParams;
    }

    public final int getHandleBackNavigationCallCount() {
        return this.handleBackNavigationCallCount;
    }

    public final boolean getHandleBackNavigationResult() {
        return this.handleBackNavigationResult;
    }

    public final int getHandlePackagePurchaseCount() {
        return this.handlePackagePurchaseCount;
    }

    public final List<Pair<Activity, Package>> getHandlePackagePurchaseParams() {
        return this.handlePackagePurchaseParams;
    }

    public final int getHandleRestorePurchasesCallCount() {
        return this.handleRestorePurchasesCallCount;
    }

    public final int getHandleWorkflowActionCallCount() {
        return this.handleWorkflowActionCallCount;
    }

    public final List<Pair<String, WorkflowTriggerType>> getHandleWorkflowActionParams() {
        return this.handleWorkflowActionParams;
    }

    public final int getInvalidateCustomerInfoCacheCallCount() {
        return this.invalidateCustomerInfoCacheCallCount;
    }

    public final int getPreloadExitOfferingCallCount() {
        return this.preloadExitOfferingCallCount;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Offering> getPreloadedExitOffering() {
        return this.preloadedExitOffering;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getPurchaseCompleted() {
        return this.purchaseCompleted;
    }

    public final int getPurchaseSelectedPackageCallCount() {
        return this.purchaseSelectedPackageCallCount;
    }

    public final List<String> getPurchaseSelectedPackageIdentifiers() {
        return this.purchaseSelectedPackageIdentifiers;
    }

    public final List<Activity> getPurchaseSelectedPackageParams() {
        return this.purchaseSelectedPackageParams;
    }

    public final int getRefreshStateIfColorsChangedCallCount() {
        return this.refreshStateIfColorsChangedCallCount;
    }

    public final int getRefreshStateIfLocaleChangedCallCount() {
        return this.refreshStateIfLocaleChangedCallCount;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public ResourceProvider getResourceProvider() {
        return new MockResourceProvider(null, null, null, null, null, 31, null);
    }

    public final int getRestorePurchasesCallCount() {
        return this.restorePurchasesCallCount;
    }

    public final int getSelectPackageCallCount() {
        return this.selectPackageCallCount;
    }

    public final List<TemplateConfiguration.PackageInfo> getSelectPackageCallParams() {
        return this.selectPackageCallParams;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public StateFlow<PaywallState> getState() {
        return FlowKt.c(this._state);
    }

    public final int getTrackComponentInteractionCallCount() {
        return this.trackComponentInteractionCallCount;
    }

    public final List<PaywallComponentInteractionData> getTrackComponentInteractionParams() {
        return this.trackComponentInteractionParams;
    }

    public final int getTrackExitOfferCallCount() {
        return this.trackExitOfferCallCount;
    }

    public final List<Pair<ExitOfferType, String>> getTrackExitOfferParams() {
        return this.trackExitOfferParams;
    }

    public final int getTrackPaywallImpressionIfNeededCallCount() {
        return this.trackPaywallImpressionIfNeededCallCount;
    }

    public final int getUpdateOptionsCallCount() {
        return this.updateOptionsCallCount;
    }

    public final List<PaywallOptions> getUpdateOptionsParams() {
        return this.updateOptionsParams;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        this.getWebCheckoutUrlCallCount++;
        this.getWebCheckoutUrlParams.add(launchWebCheckout);
        return null;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public boolean handleBackNavigation() {
        this.handleBackNavigationCallCount++;
        return this.handleBackNavigationResult;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public Object handlePackagePurchase(Activity activity, Package r2, ResolvedOffer resolvedOffer, Continuation<? super Unit> continuation) {
        this.handlePackagePurchaseCount++;
        this.handlePackagePurchaseParams.add(TuplesKt.a(activity, r2));
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't purchase mock view model");
        }
        return Unit.f139807a;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public Object handleRestorePurchases(Continuation<? super Unit> continuation) {
        this.handleRestorePurchasesCallCount++;
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't restore purchases");
        }
        return Unit.f139807a;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void handleWorkflowAction(String componentId, WorkflowTriggerType triggerType) {
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        this.handleWorkflowActionCallCount++;
        this.handleWorkflowActionParams.add(TuplesKt.a(componentId, triggerType));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void invalidateCustomerInfoCache() {
        this.invalidateCustomerInfoCacheCallCount++;
    }

    public final PaywallState.Loaded.Legacy loadedLegacyState() {
        return PaywallStateKt.loadedLegacy((PaywallState) getState().getValue());
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void preloadExitOffering() {
        this.preloadExitOfferingCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void purchaseSelectedPackage(Activity activity) {
        MutableState<TemplateConfiguration.PackageInfo> selectedPackage;
        TemplateConfiguration.PackageInfo packageInfo;
        Package rcPackage;
        this.purchaseSelectedPackageCallCount++;
        this.purchaseSelectedPackageParams.add(activity);
        List<String> list = this.purchaseSelectedPackageIdentifiers;
        PaywallState.Loaded.Legacy legacyLoadedLegacyState = loadedLegacyState();
        list.add((legacyLoadedLegacyState == null || (selectedPackage = legacyLoadedLegacyState.getSelectedPackage()) == null || (packageInfo = (TemplateConfiguration.PackageInfo) selectedPackage.getValue()) == null || (rcPackage = packageInfo.getRcPackage()) == null) ? null : rcPackage.getIdentifier());
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't purchase mock view model");
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean z2) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.refreshStateIfColorsChangedCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfLocaleChanged() {
        this.refreshStateIfLocaleChangedCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void restorePurchases() {
        this.restorePurchasesCallCount++;
        if (this.allowsPurchases) {
            simulateActionInProgress();
        } else {
            unsupportedMethod("Can't restore purchases");
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void selectPackage(TemplateConfiguration.PackageInfo packageToSelect) {
        Unit unit;
        Intrinsics.checkNotNullParameter(packageToSelect, "packageToSelect");
        this.selectPackageCallCount++;
        this.selectPackageCallParams.add(packageToSelect);
        PaywallState.Loaded.Legacy legacyLoadedLegacyState = loadedLegacyState();
        if (legacyLoadedLegacyState != null) {
            legacyLoadedLegacyState.selectPackage(packageToSelect);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            unsupportedMethod$default(this, null, 1, null);
        }
    }

    public final void setHandleBackNavigationResult(boolean z2) {
        this.handleBackNavigationResult = z2;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackComponentInteraction(PaywallComponentType paywallComponentType, String str, String str2, String str3) {
        PaywallViewModel.DefaultImpls.trackComponentInteraction(this, paywallComponentType, str, str2, str3);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier) {
        Intrinsics.checkNotNullParameter(exitOfferType, "exitOfferType");
        Intrinsics.checkNotNullParameter(exitOfferingIdentifier, "exitOfferingIdentifier");
        this.trackExitOfferCallCount++;
        this.trackExitOfferParams.add(new Pair<>(exitOfferType, exitOfferingIdentifier));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackPaywallImpressionIfNeeded() {
        this.trackPaywallImpressionIfNeededCallCount++;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackComponentInteraction(PaywallComponentInteractionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.trackComponentInteractionCallCount++;
        this.trackComponentInteractionParams.add(data);
    }

    public final void updateOptions(PaywallOptions paywallOptions) {
        Intrinsics.checkNotNullParameter(paywallOptions, KrzujOtzIk.PVI);
        this.updateOptionsCallCount++;
        this.updateOptionsParams.add(paywallOptions);
    }

    public MockViewModel(PaywallMode mode, Offering offering, PaywallWarning paywallWarning, boolean z2, boolean z3) {
        Object componentsPaywallState$default;
        Intrinsics.checkNotNullParameter(mode, "mode");
        Intrinsics.checkNotNullParameter(offering, "offering");
        this.allowsPurchases = z2;
        this.shouldErrorOnUnsupportedMethods = z3;
        Boolean bool = Boolean.FALSE;
        this.purchaseCompleted = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.preloadedExitOffering = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        PaywallValidationResult paywallValidationResultValidatedPaywall = OfferingToStateMapperKt.validatedPaywall(offering, TestData.Constants.INSTANCE.getCurrentColorScheme(), getResourceProvider());
        if (paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Legacy) {
            PaywallValidationResult.Legacy legacy = (PaywallValidationResult.Legacy) paywallValidationResultValidatedPaywall;
            componentsPaywallState$default = OfferingToStateMapperKt.toLegacyPaywallState(offering, new VariableDataProvider(getResourceProvider(), false, 2, null), mode, legacy.getDisplayablePaywall(), legacy.getTemplate(), false, "US", paywallWarning);
        } else if (paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Components) {
            componentsPaywallState$default = OfferingToStateMapperKt.toComponentsPaywallState$default(offering, (PaywallValidationResult.Components) paywallValidationResultValidatedPaywall, null, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.testdata.MockViewModel$_state$1
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date(PreviewHelpersKt.MILLIS_2025_01_25);
                }
            }, new MockPurchasesType(null, null, null, null, 15, null), null, null, 48, null);
        } else {
            throw new NoWhenBranchMatchedException();
        }
        this._state = StateFlowKt.a(componentsPaywallState$default);
        this._actionInProgress = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this._actionError = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.trackExitOfferParams = new ArrayList();
        this.trackComponentInteractionParams = new ArrayList();
        this.selectPackageCallParams = new ArrayList();
        this.getWebCheckoutUrlParams = new ArrayList();
        this.purchaseSelectedPackageParams = new ArrayList();
        this.purchaseSelectedPackageIdentifiers = new ArrayList();
        this.handlePackagePurchaseParams = new ArrayList();
        this.handleWorkflowActionParams = new ArrayList();
        this.updateOptionsParams = new ArrayList();
    }
}
