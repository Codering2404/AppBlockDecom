package com.revenuecat.purchases.ui.revenuecatui.data;

import android.app.Activity;
import android.os.LocaleList;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.applovin.impl.mediation.nativeAds.xNe.qRMDmh;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesAreCompletedBy;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.common.workflows.PublishedWorkflow;
import com.revenuecat.purchases.common.workflows.WorkflowDataResult;
import com.revenuecat.purchases.common.workflows.WorkflowScreen;
import com.revenuecat.purchases.common.workflows.WorkflowStep;
import com.revenuecat.purchases.common.workflows.WorkflowTriggerType;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.ExitOffer;
import com.revenuecat.purchases.paywalls.components.common.ExitOffers;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallComponentInteractionData;
import com.revenuecat.purchases.paywalls.events.PaywallComponentType;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import com.revenuecat.purchases.ui.revenuecatui.CustomVariableValue;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.PaywallListener;
import com.revenuecat.purchases.ui.revenuecatui.PaywallMode;
import com.revenuecat.purchases.ui.revenuecatui.PaywallModeKt;
import com.revenuecat.purchases.ui.revenuecatui.PaywallOptions;
import com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallResult;
import com.revenuecat.purchases.ui.revenuecatui.components.PaywallAction;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallState;
import com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.TemplateConfiguration;
import com.revenuecat.purchases.ui.revenuecatui.data.processed.VariableDataProvider;
import com.revenuecat.purchases.ui.revenuecatui.errors.PaywallValidationError;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.helpers.NonEmptyList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.OfferingToStateMapperKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallProductIdentifierKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallValidationResult;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ResourceProvider;
import com.revenuecat.purchases.ui.revenuecatui.helpers.WebCheckoutUrlResolverKt;
import com.revenuecat.purchases.ui.revenuecatui.strings.PaywallValidationErrorStrings;
import com.revenuecat.purchases.ui.revenuecatui.workflow.WorkflowNavigator;
import com.revenuecat.purchases.ui.revenuecatui.workflow.WorkflowScreenMapper;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
public final class PaywallViewModelImpl extends ViewModel implements PaywallViewModel {
    public static final int $stable = 0;
    private final MutableState<PurchasesError> _actionError;
    private final MutableState<Boolean> _actionInProgress;
    private final MutableStateFlow<ColorScheme> _colorScheme;
    private final MutableStateFlow<LocaleListCompat> _lastLocaleList;
    private final MutableState<Offering> _preloadedExitOffering;
    private final MutableState<Boolean> _purchaseCompleted;
    private final MutableStateFlow<PaywallState> _state;
    private Offerings currentWorkflowOfferings;
    private PresentedOfferingContext currentWorkflowPresentedOfferingContext;
    private WorkflowDataResult currentWorkflowResult;
    private boolean isDarkMode;
    private PaywallOptions options;
    private PaywallEvent.Data paywallPresentationData;
    private final ProductChangeCalculator productChangeCalculator;
    private final PurchasesType purchases;
    private final ResourceProvider resourceProvider;
    private final Function1<CustomerInfo, Boolean> shouldDisplayBlock;
    private final VariableDataProvider variableDataProvider;
    private WorkflowNavigator workflowNavigator;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PaywallPresentationFingerprint {
        private final boolean darkMode;
        private final String displayMode;
        private final String localeIdentifier;
        private final String paywallIdentifier;
        private final int paywallRevision;
        private final PresentedOfferingContext presentedOfferingContext;

        public PaywallPresentationFingerprint(String str, PresentedOfferingContext presentedOfferingContext, int i3, String displayMode, String localeIdentifier, boolean z2) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            this.paywallIdentifier = str;
            this.presentedOfferingContext = presentedOfferingContext;
            this.paywallRevision = i3;
            this.displayMode = displayMode;
            this.localeIdentifier = localeIdentifier;
            this.darkMode = z2;
        }

        public static /* synthetic */ PaywallPresentationFingerprint copy$default(PaywallPresentationFingerprint paywallPresentationFingerprint, String str, PresentedOfferingContext presentedOfferingContext, int i3, String str2, String str3, boolean z2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = paywallPresentationFingerprint.paywallIdentifier;
            }
            if ((i4 & 2) != 0) {
                presentedOfferingContext = paywallPresentationFingerprint.presentedOfferingContext;
            }
            if ((i4 & 4) != 0) {
                i3 = paywallPresentationFingerprint.paywallRevision;
            }
            if ((i4 & 8) != 0) {
                str2 = paywallPresentationFingerprint.displayMode;
            }
            if ((i4 & 16) != 0) {
                str3 = paywallPresentationFingerprint.localeIdentifier;
            }
            if ((i4 & 32) != 0) {
                z2 = paywallPresentationFingerprint.darkMode;
            }
            String str4 = str3;
            boolean z3 = z2;
            return paywallPresentationFingerprint.copy(str, presentedOfferingContext, i3, str2, str4, z3);
        }

        public final String component1() {
            return this.paywallIdentifier;
        }

        public final PresentedOfferingContext component2() {
            return this.presentedOfferingContext;
        }

        public final int component3() {
            return this.paywallRevision;
        }

        public final String component4() {
            return this.displayMode;
        }

        public final String component5() {
            return this.localeIdentifier;
        }

        public final boolean component6() {
            return this.darkMode;
        }

        public final PaywallPresentationFingerprint copy(String str, PresentedOfferingContext presentedOfferingContext, int i3, String displayMode, String localeIdentifier, boolean z2) {
            Intrinsics.checkNotNullParameter(presentedOfferingContext, "presentedOfferingContext");
            Intrinsics.checkNotNullParameter(displayMode, "displayMode");
            Intrinsics.checkNotNullParameter(localeIdentifier, "localeIdentifier");
            return new PaywallPresentationFingerprint(str, presentedOfferingContext, i3, displayMode, localeIdentifier, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallPresentationFingerprint)) {
                return false;
            }
            PaywallPresentationFingerprint paywallPresentationFingerprint = (PaywallPresentationFingerprint) obj;
            return Intrinsics.areEqual(this.paywallIdentifier, paywallPresentationFingerprint.paywallIdentifier) && Intrinsics.areEqual(this.presentedOfferingContext, paywallPresentationFingerprint.presentedOfferingContext) && this.paywallRevision == paywallPresentationFingerprint.paywallRevision && Intrinsics.areEqual(this.displayMode, paywallPresentationFingerprint.displayMode) && Intrinsics.areEqual(this.localeIdentifier, paywallPresentationFingerprint.localeIdentifier) && this.darkMode == paywallPresentationFingerprint.darkMode;
        }

        public final boolean getDarkMode() {
            return this.darkMode;
        }

        public final String getDisplayMode() {
            return this.displayMode;
        }

        public final String getLocaleIdentifier() {
            return this.localeIdentifier;
        }

        public final String getPaywallIdentifier() {
            return this.paywallIdentifier;
        }

        public final int getPaywallRevision() {
            return this.paywallRevision;
        }

        public final PresentedOfferingContext getPresentedOfferingContext() {
            return this.presentedOfferingContext;
        }

        public int hashCode() {
            String str = this.paywallIdentifier;
            return ((((((((((str == null ? 0 : str.hashCode()) * 31) + this.presentedOfferingContext.hashCode()) * 31) + Integer.hashCode(this.paywallRevision)) * 31) + this.displayMode.hashCode()) * 31) + this.localeIdentifier.hashCode()) * 31) + Boolean.hashCode(this.darkMode);
        }

        public String toString() {
            return "PaywallPresentationFingerprint(paywallIdentifier=" + this.paywallIdentifier + ", presentedOfferingContext=" + this.presentedOfferingContext + ", paywallRevision=" + this.paywallRevision + ", displayMode=" + this.displayMode + ", localeIdentifier=" + this.localeIdentifier + ", darkMode=" + this.darkMode + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PurchasesAreCompletedBy.values().length];
            try {
                iArr[PurchasesAreCompletedBy.MY_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PurchasesAreCompletedBy.REVENUECAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handlePackagePurchase$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", f = "PaywallViewModel.kt", l = {478, 494}, m = "handlePackagePurchase")
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
            return PaywallViewModelImpl.this.handlePackagePurchase(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handleRestorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", f = "PaywallViewModel.kt", l = {1106, 411, FacebookRequestErrorClassification.EC_APP_NOT_INSTALLED, 414, 445}, m = "handleRestorePurchases")
    static final class C26591 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C26591(Continuation<? super C26591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.handleRestorePurchases(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performPurchase$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", f = "PaywallViewModel.kt", l = {1106, 544, 563, 566, 610}, m = "performPurchase")
    static final class C26601 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C26601(Continuation<? super C26601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.performPurchase(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$preloadExitOffering$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$preloadExitOffering$1", f = "PaywallViewModel.kt", l = {281}, m = "invokeSuspend")
    static final class C26611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        C26611(Continuation<? super C26611> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C26611(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Offering offering;
            String offeringId;
            MutableState mutableState;
            MutableState mutableState2;
            Offering.PaywallComponents paywallComponents;
            PaywallComponentsData data;
            ExitOffers exitOffers;
            ExitOffer dismiss;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
            } catch (PurchasesException e3) {
                Logger.INSTANCE.e("Failed to preload exit offering", e3);
            }
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallState paywallState = (PaywallState) PaywallViewModelImpl.this._state.getValue();
                offering = null;
                Offering offering2 = paywallState instanceof PaywallState.Loaded.Legacy ? ((PaywallState.Loaded.Legacy) paywallState).getOffering() : paywallState instanceof PaywallState.Loaded.Components ? ((PaywallState.Loaded.Components) paywallState).getOffering() : null;
                offeringId = (offering2 == null || (paywallComponents = offering2.getPaywallComponents()) == null || (data = paywallComponents.getData()) == null || (exitOffers = data.getExitOffers()) == null || (dismiss = exitOffers.getDismiss()) == null) ? null : dismiss.getOfferingId();
                mutableState = PaywallViewModelImpl.this._preloadedExitOffering;
                if (offeringId != null) {
                    PurchasesType purchasesType = PaywallViewModelImpl.this.purchases;
                    this.L$0 = offeringId;
                    this.L$1 = mutableState;
                    this.label = 1;
                    Object objAwaitOfferings = purchasesType.awaitOfferings(this);
                    if (objAwaitOfferings == objF) {
                        return objF;
                    }
                    mutableState2 = mutableState;
                    obj = objAwaitOfferings;
                }
                mutableState.setValue(offering);
                return Unit.f139807a;
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mutableState2 = (MutableState) this.L$1;
            offeringId = (String) this.L$0;
            ResultKt.b(obj);
            offering = ((Offerings) obj).get(offeringId);
            if (offering == null) {
                Logger.INSTANCE.e("Exit offering with ID '" + offeringId + "' not found in available offerings. Exit offer will not be displayed.");
            }
            mutableState = mutableState2;
            mutableState.setValue(offering);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26611) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$purchaseSelectedPackage$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$purchaseSelectedPackage$1", f = "PaywallViewModel.kt", l = {318}, m = "invokeSuspend")
    static final class C26621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26621(Activity activity, Continuation<? super C26621> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C26621(this.$activity, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallViewModelImpl paywallViewModelImpl = PaywallViewModelImpl.this;
                Activity activity = this.$activity;
                this.label = 1;
                if (PaywallViewModel.DefaultImpls.handlePackagePurchase$default(paywallViewModelImpl, activity, null, null, this, 4, null) == objF) {
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
            return ((C26621) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$restorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$restorePurchases$1", f = "PaywallViewModel.kt", l = {324}, m = "invokeSuspend")
    static final class C26631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C26631(Continuation<? super C26631> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C26631(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallViewModelImpl paywallViewModelImpl = PaywallViewModelImpl.this;
                this.label = 1;
                if (paywallViewModelImpl.handleRestorePurchases(this) == objF) {
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
            return ((C26631) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateState$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateState$1", f = "PaywallViewModel.kt", l = {645}, m = "invokeSuspend")
    static final class C26641 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C26641(Continuation<? super C26641> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return PaywallViewModelImpl.this.new C26641(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    PaywallViewModelImpl paywallViewModelImpl = PaywallViewModelImpl.this;
                    OfferingSelection offeringSelection$revenuecatui_defaultsBc8Release = paywallViewModelImpl.options.getOfferingSelection$revenuecatui_defaultsBc8Release();
                    this.label = 1;
                    if (paywallViewModelImpl.updateStateFromOffering(offeringSelection$revenuecatui_defaultsBc8Release, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (PurchasesException e3) {
                PaywallViewModelImpl.this._state.setValue(new PaywallState.Error("Error " + e3.getCode().getCode() + ": " + e3.getCode().getDescription()));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26641) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$updateStateFromOffering$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl", f = "PaywallViewModel.kt", l = {681, 690}, m = "updateStateFromOffering")
    static final class C26651 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C26651(Continuation<? super C26651> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PaywallViewModelImpl.this.updateStateFromOffering(null, this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ PaywallViewModelImpl(ResourceProvider resourceProvider, PurchasesType purchasesType, PaywallOptions paywallOptions, ColorScheme colorScheme, boolean z2, Function1 function1, boolean z3, ProductChangeCalculator productChangeCalculator, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        PurchasesType purchasesImpl = (i3 & 2) != 0 ? new PurchasesImpl(null, 1, 0 == true ? 1 : 0) : purchasesType;
        this(resourceProvider, purchasesImpl, paywallOptions, colorScheme, z2, function1, (i3 & 64) != 0 ? false : z3, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new ProductChangeCalculator(purchasesImpl) : productChangeCalculator);
    }

    private final PaywallState calculateState(Offering offering, ColorScheme colorScheme, String str, PaywallMode paywallMode) {
        if (offering.getAvailablePackages().isEmpty()) {
            return new PaywallState.Error("No packages available");
        }
        PaywallValidationResult paywallValidationResultValidatedPaywall = OfferingToStateMapperKt.validatedPaywall(offering, colorScheme, getResourceProvider());
        if ((paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Components) && !PaywallModeKt.isFullScreen(paywallMode)) {
            paywallValidationResultValidatedPaywall = OfferingToStateMapperKt.fallbackPaywall(offering, colorScheme, getResourceProvider(), PaywallValidationError.InvalidModeForComponentsPaywall.INSTANCE);
        }
        NonEmptyList<PaywallValidationError> errors = paywallValidationResultValidatedPaywall.getErrors();
        if (errors != null) {
            Iterator<PaywallValidationError> it = errors.iterator();
            while (it.hasNext()) {
                Logger.INSTANCE.e(it.next().associatedErrorString(offering));
            }
            Logger.INSTANCE.e(PaywallValidationErrorStrings.DISPLAYING_DEFAULT);
        }
        if (paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Legacy) {
            PaywallValidationResult.Legacy legacy = (PaywallValidationResult.Legacy) paywallValidationResultValidatedPaywall;
            return OfferingToStateMapperKt.toLegacyPaywallState(offering, this.variableDataProvider, paywallMode, legacy.getDisplayablePaywall(), legacy.getTemplate(), this.options.getShouldDisplayDismissButton$revenuecatui_defaultsBc8Release(), str, legacy.getWarning());
        }
        if (paywallValidationResultValidatedPaywall instanceof PaywallValidationResult.Components) {
            return OfferingToStateMapperKt.toComponentsPaywallState(offering, (PaywallValidationResult.Components) paywallValidationResultValidatedPaywall, str, new Function0<Date>() { // from class: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.calculateState.2
                @Override // kotlin.jvm.functions.Function0
                public final Date invoke() {
                    return new Date();
                }
            }, this.purchases, this.options.getCustomVariables(), extractDefaultCustomVariables(offering));
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PaywallPresentationFingerprint computePresentationFingerprint() {
        PaywallState paywallState = (PaywallState) this._state.getValue();
        if (paywallState instanceof PaywallState.Loaded.Legacy) {
            return presentationFingerprintLegacy((PaywallState.Loaded.Legacy) paywallState, getMode(), (LocaleListCompat) this._lastLocaleList.getValue(), this.isDarkMode);
        }
        if (paywallState instanceof PaywallState.Loaded.Components) {
            return presentationFingerprintComponents((PaywallState.Loaded.Components) paywallState, getMode(), this.isDarkMode);
        }
        if (paywallState instanceof PaywallState.Error ? true : paywallState instanceof PaywallState.Loading) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    private final PaywallEvent.Data createEventData() {
        PaywallState paywallState = (PaywallState) getState().getValue();
        if (paywallState instanceof PaywallState.Loaded.Legacy) {
            return createEventData((PaywallState.Loaded.Legacy) paywallState);
        }
        if (paywallState instanceof PaywallState.Loaded.Components) {
            return createEventData((PaywallState.Loaded.Components) paywallState);
        }
        if (!(paywallState instanceof PaywallState.Error ? true : paywallState instanceof PaywallState.Loading)) {
            throw new NoWhenBranchMatchedException();
        }
        Logger.INSTANCE.e("Unexpected state trying to create event data: " + paywallState);
        return null;
    }

    private final Map<String, CustomVariableValue> extractDefaultCustomVariables(Offering offering) {
        UiConfig uiConfig;
        Map customVariables;
        Offering.PaywallComponents paywallComponents = offering.getPaywallComponents();
        if (paywallComponents == null || (uiConfig = paywallComponents.getUiConfig()) == null || (customVariables = uiConfig.getCustomVariables()) == null) {
            return MapsKt.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(customVariables.size()));
        for (Map.Entry entry : customVariables.entrySet()) {
            linkedHashMap.put(entry.getKey(), CustomVariableValue.Companion.from(((UiConfig.CustomVariableDefinition) entry.getValue()).getDefaultValue()));
        }
        return linkedHashMap;
    }

    private final void finishAction() {
        this._actionInProgress.setValue(Boolean.FALSE);
    }

    private final LocaleListCompat getCurrentLocaleList() {
        String preferredUILocaleOverride = this.purchases.getPreferredUILocaleOverride();
        if (preferredUILocaleOverride == null) {
            LocaleListCompat localeListCompatE = LocaleListCompat.e();
            Intrinsics.checkNotNullExpressionValue(localeListCompatE, "getDefault()");
            return localeListCompatE;
        }
        try {
            LocaleListCompat localeListCompatA = LocaleListCompat.a(LocaleHelpersKt.createLocaleFromString(preferredUILocaleOverride));
            Intrinsics.checkNotNullExpressionValue(localeListCompatA, "create(locale)");
            return localeListCompatA;
        } catch (IllegalArgumentException e3) {
            Logger.INSTANCE.e("Invalid preferred locale format: " + preferredUILocaleOverride + ". Using system default.", e3);
            LocaleListCompat localeListCompatE2 = LocaleListCompat.e();
            Intrinsics.checkNotNullExpressionValue(localeListCompatE2, "{\n            Logger.e(\"…at.getDefault()\n        }");
            return localeListCompatE2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaywallListener getListener() {
        return this.options.getListener();
    }

    private final PaywallMode getMode() {
        return this.options.getMode$revenuecatui_defaultsBc8Release();
    }

    private final PresentedOfferingContext getPresentedOfferingContext(Offering offering) {
        PresentedOfferingContext presentedOfferingContext;
        Package r02 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
        return (r02 == null || (presentedOfferingContext = r02.getPresentedOfferingContext()) == null) ? new PresentedOfferingContext(offering.getIdentifier()) : presentedOfferingContext;
    }

    private final PaywallPurchaseLogic getPurchaseLogic() {
        return this.options.getPurchaseLogic();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0278 A[Catch: PurchasesException -> 0x0135, TRY_ENTER, TryCatch #1 {PurchasesException -> 0x0135, blocks: (B:97:0x0247, B:99:0x024d, B:105:0x0278, B:107:0x027c, B:108:0x0280, B:110:0x0284, B:112:0x028c, B:59:0x0132, B:65:0x0141, B:68:0x0153, B:69:0x0171, B:71:0x0177, B:72:0x017a, B:74:0x0180, B:76:0x0189, B:79:0x019e, B:80:0x01d3, B:77:0x0197, B:89:0x0218, B:92:0x0220, B:94:0x022f, B:113:0x0295, B:114:0x029c), top: B:128:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01fc A[Catch: PurchasesException -> 0x0049, TryCatch #4 {PurchasesException -> 0x0049, blocks: (B:16:0x0044, B:84:0x01eb, B:86:0x01fc, B:87:0x0207, B:23:0x005e, B:103:0x025f), top: B:133:0x002e }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0218 A[Catch: PurchasesException -> 0x0135, TRY_ENTER, TryCatch #1 {PurchasesException -> 0x0135, blocks: (B:97:0x0247, B:99:0x024d, B:105:0x0278, B:107:0x027c, B:108:0x0280, B:110:0x0284, B:112:0x028c, B:59:0x0132, B:65:0x0141, B:68:0x0153, B:69:0x0171, B:71:0x0177, B:72:0x017a, B:74:0x0180, B:76:0x0189, B:79:0x019e, B:80:0x01d3, B:77:0x0197, B:89:0x0218, B:92:0x0220, B:94:0x022f, B:113:0x0295, B:114:0x029c), top: B:128:0x0132 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x024d A[Catch: PurchasesException -> 0x0135, TRY_LEAVE, TryCatch #1 {PurchasesException -> 0x0135, blocks: (B:97:0x0247, B:99:0x024d, B:105:0x0278, B:107:0x027c, B:108:0x0280, B:110:0x0284, B:112:0x028c, B:59:0x0132, B:65:0x0141, B:68:0x0153, B:69:0x0171, B:71:0x0177, B:72:0x017a, B:74:0x0180, B:76:0x0189, B:79:0x019e, B:80:0x01d3, B:77:0x0197, B:89:0x0218, B:92:0x0220, B:94:0x022f, B:113:0x0295, B:114:0x029c), top: B:128:0x0132 }] */
    /* JADX WARN: Type inference failed for: r0v25, types: [com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType] */
    /* JADX WARN: Type inference failed for: r14v0, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r2v12, types: [com.revenuecat.purchases.ui.revenuecatui.data.ProductChangeCalculator] */
    /* JADX WARN: Type inference failed for: r2v20, types: [com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType] */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$performPurchase$1, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r3v24 */
    /* JADX WARN: Type inference failed for: r3v25 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.revenuecat.purchases.Package] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r7v1, types: [com.revenuecat.purchases.ui.revenuecatui.PaywallPurchaseLogic] */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object performPurchase(android.app.Activity r18, com.revenuecat.purchases.Package r19, com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig r20, com.revenuecat.purchases.models.SubscriptionOption r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 728
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.performPurchase(android.app.Activity, com.revenuecat.purchases.Package, com.revenuecat.purchases.paywalls.components.common.ProductChangeConfig, com.revenuecat.purchases.models.SubscriptionOption, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object performPurchase$default(PaywallViewModelImpl paywallViewModelImpl, Activity activity, Package r8, ProductChangeConfig productChangeConfig, SubscriptionOption subscriptionOption, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            productChangeConfig = null;
        }
        return paywallViewModelImpl.performPurchase(activity, r8, productChangeConfig, subscriptionOption, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object performPurchaseIfNecessary(Activity activity, PaywallState.Loaded.Components.SelectedPackageInfo selectedPackageInfo, ProductChangeConfig productChangeConfig, Continuation<? super Unit> continuation) throws Throwable {
        if (selectedPackageInfo == null) {
            Logger.INSTANCE.w("Ignoring purchase request as no package is selected");
            return Unit.f139807a;
        }
        Package rcPackage = selectedPackageInfo.getRcPackage();
        ResolvedOffer resolvedOffer = selectedPackageInfo.getResolvedOffer();
        Object objPerformPurchase = performPurchase(activity, rcPackage, productChangeConfig, resolvedOffer != null ? resolvedOffer.getSubscriptionOption() : null, continuation);
        return objPerformPurchase == IntrinsicsKt.f() ? objPerformPurchase : Unit.f139807a;
    }

    private final PaywallPresentationFingerprint presentationFingerprint(PaywallEvent.Data data) {
        return new PaywallPresentationFingerprint(data.getPaywallIdentifier(), data.getPresentedOfferingContext(), data.getPaywallRevision(), data.getDisplayMode(), data.getLocaleIdentifier(), data.getDarkMode());
    }

    private final PaywallPresentationFingerprint presentationFingerprintComponents(PaywallState.Loaded.Components components, PaywallMode paywallMode, boolean z2) {
        Offering.PaywallComponents paywallComponents = components.getOffering().getPaywallComponents();
        if (paywallComponents == null) {
            return null;
        }
        String id = paywallComponents.getData().getId();
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext(components.getOffering());
        int revision = paywallComponents.getData().getRevision();
        String lowerCase = paywallMode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new PaywallPresentationFingerprint(id, presentedOfferingContext, revision, lowerCase, components.getLocale().toString(), z2);
    }

    private final PaywallPresentationFingerprint presentationFingerprintLegacy(PaywallState.Loaded.Legacy legacy, PaywallMode paywallMode, LocaleListCompat localeListCompat, boolean z2) {
        PaywallComponentsData data;
        int revision;
        String str;
        PaywallComponentsData data2;
        String id;
        PaywallData paywall = legacy.getOffering().getPaywall();
        String id2 = null;
        if (paywall != null) {
            revision = paywall.getRevision();
        } else {
            Offering.PaywallComponents paywallComponents = legacy.getOffering().getPaywallComponents();
            if (paywallComponents == null || (data = paywallComponents.getData()) == null) {
                return null;
            }
            revision = data.getRevision();
        }
        int i3 = revision;
        PaywallData paywall2 = legacy.getOffering().getPaywall();
        if (paywall2 == null || (id = paywall2.getId()) == null) {
            Offering.PaywallComponents paywallComponents2 = legacy.getOffering().getPaywallComponents();
            if (paywallComponents2 != null && (data2 = paywallComponents2.getData()) != null) {
                id2 = data2.getId();
            }
            str = id2;
        } else {
            str = id;
        }
        Locale localeD = localeListCompat.d(0);
        if (localeD == null) {
            localeD = Locale.getDefault();
        }
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext(legacy.getOffering());
        String lowerCase = paywallMode.name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = localeD.toString();
        Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
        return new PaywallPresentationFingerprint(str, presentedOfferingContext, i3, lowerCase, string, z2);
    }

    private final LocaleList toFrameworkLocaleList(LocaleListCompat localeListCompat) {
        int iH = localeListCompat.h();
        Locale[] localeArr = new Locale[iH];
        for (int i3 = 0; i3 < iH; i3++) {
            Locale localeD = localeListCompat.d(i3);
            Intrinsics.checkNotNull(localeD);
            localeArr[i3] = localeD;
        }
        return new LocaleList((Locale[]) Arrays.copyOf(localeArr, iH));
    }

    private final void track(PaywallEventType paywallEventType) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data != null) {
            UUID uuidRandomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
            this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), data, paywallEventType, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
            return;
        }
        Logger.INSTANCE.e("Paywall event data is null, not tracking event " + paywallEventType);
    }

    private final void trackPaywallCancel() {
        track(PaywallEventType.CANCEL);
    }

    private final void trackPaywallClose() {
        if (this.paywallPresentationData != null) {
            track(PaywallEventType.CLOSE);
        }
    }

    private final void trackPaywallPurchaseError(Package r25, PurchasesError purchasesError) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking purchase error event");
            return;
        }
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, null, null, r25.getIdentifier(), PaywallProductIdentifierKt.paywallProductIdentifier(r25.getProduct()), Integer.valueOf(purchasesError.getCode().getCode()), purchasesError.getMessage(), 511, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.PURCHASE_ERROR, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
    }

    private final void trackPaywallPurchaseInitiated(Package r25) {
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking purchase initiated event");
            return;
        }
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, null, null, r25.getIdentifier(), PaywallProductIdentifierKt.paywallProductIdentifier(r25.getProduct()), null, null, 6655, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.PURCHASE_INITIATED, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
    }

    private final void updateState() {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C26641(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateStateFromOffering(com.revenuecat.purchases.ui.revenuecatui.OfferingSelection r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.updateStateFromOffering(com.revenuecat.purchases.ui.revenuecatui.OfferingSelection, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateStateFromWorkflow(WorkflowDataResult workflowDataResult, Offerings offerings, PresentedOfferingContext presentedOfferingContext) {
        PublishedWorkflow workflow = workflowDataResult.getWorkflow();
        WorkflowStep workflowStep = workflow.getSteps().get(workflow.getInitialStepId());
        if (workflowStep != null) {
            this.currentWorkflowResult = workflowDataResult;
            this.currentWorkflowOfferings = offerings;
            this.currentWorkflowPresentedOfferingContext = presentedOfferingContext;
            this.workflowNavigator = new WorkflowNavigator(workflow);
            buildStateFromStep(workflowStep, workflow, offerings, presentedOfferingContext);
            return;
        }
        this._state.setValue(new PaywallState.Error("Initial step '" + workflow.getInitialStepId() + "' not found in workflow '" + workflow.getId() + '\''));
    }

    private final void validateState() {
        if (this.purchases.getPurchasesAreCompletedBy() == PurchasesAreCompletedBy.MY_APP && this.options.getPurchaseLogic() == null) {
            this._state.setValue(new PaywallState.Error("myAppPurchaseLogic is null, but is required when purchases.purchasesAreCompletedBy is .MY_APP. App purchases will not be successful."));
        }
    }

    private final String validateStep(WorkflowStep workflowStep, PublishedWorkflow publishedWorkflow, Offerings offerings) {
        String screenId = workflowStep.getScreenId();
        if (screenId == null) {
            return "Step '" + workflowStep.getId() + "' has no screen_id in workflow '" + publishedWorkflow.getId() + '\'';
        }
        WorkflowScreen workflowScreen = publishedWorkflow.getScreens().get(screenId);
        if (workflowScreen == null) {
            return "Screen '" + screenId + "' not found in workflow '" + publishedWorkflow.getId() + '\'';
        }
        String offeringIdentifier = workflowScreen.getOfferingIdentifier();
        if (offeringIdentifier == null) {
            return "Screen '" + screenId + "' has no offering_id in workflow '" + publishedWorkflow.getId() + '\'';
        }
        if (offerings.get(offeringIdentifier) != null) {
            return null;
        }
        return "Offering '" + offeringIdentifier + "' not found for screen '" + screenId + '\'';
    }

    private final boolean verifyNoActionInProgressOrStartAction() {
        if (((Boolean) this._actionInProgress.getValue()).booleanValue()) {
            Logger.INSTANCE.d("Ignoring purchase or restore because there already is an action in progress");
            return true;
        }
        this._actionInProgress.setValue(Boolean.TRUE);
        return false;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void clearActionError() {
        this._actionError.setValue(null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void closePaywall(PaywallResult paywallResult) {
        Logger.INSTANCE.d("Paywalls: Close paywall initiated");
        trackPaywallClose();
        Offering offering = !((Boolean) this._purchaseCompleted.getValue()).booleanValue() ? (Offering) this._preloadedExitOffering.getValue() : null;
        if (offering != null) {
            trackExitOffer(ExitOfferType.DISMISS, offering.getIdentifier());
        }
        this.paywallPresentationData = null;
        Function2<Offering, PaywallResult, Unit> dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release = this.options.getDismissRequestWithExitOffering$revenuecatui_defaultsBc8Release();
        if (dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release != null) {
            dismissRequestWithExitOffering$revenuecatui_defaultsBc8Release.invoke(offering, paywallResult);
        } else {
            this.options.getDismissRequest().invoke();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getActionInProgress() {
        return this._actionInProgress;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Offering> getPreloadedExitOffering() {
        return this._preloadedExitOffering;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public State<Boolean> getPurchaseCompleted() {
        return this._purchaseCompleted;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public ResourceProvider getResourceProvider() {
        return this.resourceProvider;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public StateFlow<PaywallState> getState() {
        return FlowKt.c(this._state);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public String getWebCheckoutUrl(PaywallAction.External.LaunchWebCheckout launchWebCheckout) {
        Intrinsics.checkNotNullParameter(launchWebCheckout, "launchWebCheckout");
        Object value = getState().getValue();
        PaywallState.Loaded.Components components = value instanceof PaywallState.Loaded.Components ? (PaywallState.Loaded.Components) value : null;
        if (components != null) {
            return WebCheckoutUrlResolverKt.resolveWebCheckoutUrlForInteraction(components, launchWebCheckout);
        }
        Logger.INSTANCE.e("Web checkout URL can only be constructed for loaded Components paywalls");
        return null;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public boolean handleBackNavigation() {
        WorkflowDataResult workflowDataResult;
        Offerings offerings;
        WorkflowStep peekBackStep;
        WorkflowNavigator workflowNavigator = this.workflowNavigator;
        if (workflowNavigator == null || !workflowNavigator.getCanNavigateBack() || (workflowDataResult = this.currentWorkflowResult) == null || (offerings = this.currentWorkflowOfferings) == null || (peekBackStep = workflowNavigator.getPeekBackStep()) == null) {
            return false;
        }
        String strValidateStep = validateStep(peekBackStep, workflowDataResult.getWorkflow(), offerings);
        if (strValidateStep == null) {
            WorkflowStep workflowStepNavigateBack = workflowNavigator.navigateBack();
            if (workflowStepNavigateBack == null) {
                return false;
            }
            buildStateFromStep(workflowStepNavigateBack, workflowDataResult.getWorkflow(), offerings, this.currentWorkflowPresentedOfferingContext);
            return true;
        }
        Logger.INSTANCE.e("Cannot navigate back to step '" + peekBackStep.getId() + "': " + strValidateStep);
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0074, code lost:
    
        if (performPurchase$default(r1, r10, r11, null, null, r6, 4, null) == r0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
    
        if (performPurchaseIfNecessary(r10, r3, r11, r6) == r0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b5, code lost:
    
        return r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handlePackagePurchase(android.app.Activity r10, com.revenuecat.purchases.Package r11, com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.handlePackagePurchase(android.app.Activity, com.revenuecat.purchases.Package, com.revenuecat.purchases.ui.revenuecatui.helpers.ResolvedOffer, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void handleWorkflowAction(String componentId, WorkflowTriggerType triggerType) {
        WorkflowDataResult workflowDataResult;
        Offerings offerings;
        WorkflowStep workflowStepPeekTriggerStep;
        Intrinsics.checkNotNullParameter(componentId, "componentId");
        Intrinsics.checkNotNullParameter(triggerType, "triggerType");
        WorkflowNavigator workflowNavigator = this.workflowNavigator;
        if (workflowNavigator == null || (workflowDataResult = this.currentWorkflowResult) == null || (offerings = this.currentWorkflowOfferings) == null || (workflowStepPeekTriggerStep = workflowNavigator.peekTriggerStep(componentId, triggerType)) == null) {
            return;
        }
        String strValidateStep = validateStep(workflowStepPeekTriggerStep, workflowDataResult.getWorkflow(), offerings);
        if (strValidateStep == null) {
            WorkflowStep workflowStepTriggerAction = workflowNavigator.triggerAction(componentId, triggerType);
            if (workflowStepTriggerAction == null) {
                return;
            }
            buildStateFromStep(workflowStepTriggerAction, workflowDataResult.getWorkflow(), offerings, this.currentWorkflowPresentedOfferingContext);
            return;
        }
        Logger.INSTANCE.e("Cannot navigate to step '" + workflowStepPeekTriggerStep.getId() + "': " + strValidateStep);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void invalidateCustomerInfoCache() {
        this.purchases.invalidateVirtualCurrenciesCache();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void preloadExitOffering() {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C26611(null), 3, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void purchaseSelectedPackage(Activity activity) {
        if (activity == null) {
            Logger.INSTANCE.e("Activity is null, not initiating package purchase");
        } else {
            BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C26621(activity, null), 3, null);
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfColorsChanged(ColorScheme colorScheme, boolean z2) {
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        if (this.isDarkMode != z2) {
            this.isDarkMode = z2;
        }
        if (Intrinsics.areEqual(this._colorScheme.getValue(), colorScheme)) {
            return;
        }
        this._colorScheme.setValue(colorScheme);
        updateState();
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void refreshStateIfLocaleChanged() {
        LocaleListCompat currentLocaleList = getCurrentLocaleList();
        if (Intrinsics.areEqual(this._lastLocaleList.getValue(), currentLocaleList)) {
            return;
        }
        this._lastLocaleList.setValue(currentLocaleList);
        PaywallState paywallState = (PaywallState) this._state.getValue();
        if (paywallState instanceof PaywallState.Loaded.Components) {
            PaywallState.Loaded.Components.update$default((PaywallState.Loaded.Components) paywallState, toFrameworkLocaleList(currentLocaleList), null, null, 6, null);
        } else {
            updateState();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void restorePurchases() {
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C26631(null), 3, null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void selectPackage(TemplateConfiguration.PackageInfo packageToSelect) {
        Intrinsics.checkNotNullParameter(packageToSelect, "packageToSelect");
        PaywallState paywallState = (PaywallState) this._state.getValue();
        if (paywallState instanceof PaywallState.Loaded.Legacy) {
            ((PaywallState.Loaded.Legacy) paywallState).selectPackage(packageToSelect);
            return;
        }
        Logger.INSTANCE.e("Unexpected state trying to select package: " + paywallState);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackComponentInteraction(PaywallComponentType paywallComponentType, String str, String str2, String str3) {
        PaywallViewModel.DefaultImpls.trackComponentInteraction(this, paywallComponentType, str, str2, str3);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackExitOffer(ExitOfferType exitOfferType, String exitOfferingIdentifier) {
        Intrinsics.checkNotNullParameter(exitOfferType, "exitOfferType");
        Intrinsics.checkNotNullParameter(exitOfferingIdentifier, "exitOfferingIdentifier");
        PaywallEvent.Data data = this.paywallPresentationData;
        if (data == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking exit offer event");
            return;
        }
        PaywallEvent.Data dataCopy$default = PaywallEvent.Data.copy$default(data, null, null, 0, null, null, null, false, exitOfferType, exitOfferingIdentifier, null, null, null, null, 7807, null);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), dataCopy$default, PaywallEventType.EXIT_OFFER, (PaywallComponentInteractionData) null, 8, (DefaultConstructorMarker) null));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackPaywallImpressionIfNeeded() {
        PaywallPresentationFingerprint paywallPresentationFingerprintComputePresentationFingerprint = computePresentationFingerprint();
        if (paywallPresentationFingerprintComputePresentationFingerprint == null) {
            return;
        }
        PaywallEvent.Data data = this.paywallPresentationData;
        if (Intrinsics.areEqual(data != null ? presentationFingerprint(data) : null, paywallPresentationFingerprintComputePresentationFingerprint)) {
            return;
        }
        if (data != null) {
            track(PaywallEventType.CLOSE);
            this.paywallPresentationData = null;
        }
        PaywallEvent.Data dataCreateEventData = createEventData();
        if (dataCreateEventData == null) {
            return;
        }
        this.paywallPresentationData = dataCreateEventData;
        track(PaywallEventType.IMPRESSION);
    }

    public final void updateOptions(PaywallOptions options) {
        Intrinsics.checkNotNullParameter(options, "options");
        boolean z2 = this.options.hashCode() != options.hashCode();
        this.options = options;
        if (z2) {
            updateState();
        }
    }

    private final void buildStateFromStep(WorkflowStep workflowStep, PublishedWorkflow publishedWorkflow, Offerings offerings, PresentedOfferingContext presentedOfferingContext) {
        Offering offeringCopy;
        String screenId = workflowStep.getScreenId();
        if (screenId == null) {
            this._state.setValue(new PaywallState.Error("Step '" + workflowStep.getId() + "' has no screen_id in workflow '" + publishedWorkflow.getId() + '\''));
            return;
        }
        WorkflowScreen workflowScreen = publishedWorkflow.getScreens().get(screenId);
        String str = qRMDmh.KxGqNmqwMw;
        if (workflowScreen == null) {
            this._state.setValue(new PaywallState.Error(str + screenId + "' not found in workflow '" + publishedWorkflow.getId() + '\''));
            return;
        }
        String offeringIdentifier = workflowScreen.getOfferingIdentifier();
        if (offeringIdentifier == null) {
            this._state.setValue(new PaywallState.Error(str + screenId + "' has no offering_id in workflow '" + publishedWorkflow.getId() + '\''));
            return;
        }
        Offering offering = offerings.get(offeringIdentifier);
        if (offering != null) {
            Offering offering2 = new Offering(offering.getIdentifier(), offering.getServerDescription(), offering.getMetadata(), offering.getAvailablePackages(), null, WorkflowScreenMapper.INSTANCE.toPaywallComponents(workflowScreen, screenId, publishedWorkflow.getUiConfig()), offering.getWebCheckoutURL(), 16, null);
            if (presentedOfferingContext != null && (offeringCopy = offering2.copy(presentedOfferingContext)) != null) {
                offering2 = offeringCopy;
            }
            this._state.setValue(calculateState(offering2, (ColorScheme) this._colorScheme.getValue(), this.purchases.getStorefrontCountryCode(), this.options.getMode$revenuecatui_defaultsBc8Release()));
            return;
        }
        this._state.setValue(new PaywallState.Error("Offering '" + offeringIdentifier + "' not found for screen '" + screenId + '\''));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01d7 A[Catch: PurchasesException -> 0x003d, TryCatch #1 {PurchasesException -> 0x003d, blocks: (B:16:0x0038, B:77:0x0153, B:79:0x0172, B:80:0x0175, B:82:0x0179, B:84:0x0185, B:23:0x004c, B:99:0x01d1, B:101:0x01d7, B:103:0x01e3), top: B:122:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x01fa A[Catch: PurchasesException -> 0x005a, TRY_ENTER, TryCatch #2 {PurchasesException -> 0x005a, blocks: (B:26:0x0055, B:93:0x01bd, B:95:0x01c3, B:105:0x01fa, B:107:0x01fe, B:109:0x0202, B:111:0x020a, B:90:0x01ae, B:60:0x00f9, B:62:0x00ff, B:64:0x0106, B:67:0x0118, B:68:0x0134, B:70:0x013a, B:72:0x013f, B:73:0x0144, B:87:0x019f, B:112:0x0210, B:113:0x0217), top: B:122:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0172 A[Catch: PurchasesException -> 0x003d, TryCatch #1 {PurchasesException -> 0x003d, blocks: (B:16:0x0038, B:77:0x0153, B:79:0x0172, B:80:0x0175, B:82:0x0179, B:84:0x0185, B:23:0x004c, B:99:0x01d1, B:101:0x01d7, B:103:0x01e3), top: B:122:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0179 A[Catch: PurchasesException -> 0x003d, TryCatch #1 {PurchasesException -> 0x003d, blocks: (B:16:0x0038, B:77:0x0153, B:79:0x0172, B:80:0x0175, B:82:0x0179, B:84:0x0185, B:23:0x004c, B:99:0x01d1, B:101:0x01d7, B:103:0x01e3), top: B:122:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01bd A[Catch: PurchasesException -> 0x005a, PHI: r2 r15
      0x01bd: PHI (r2v17 com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl) = 
      (r2v36 com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl)
      (r2v37 com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl)
     binds: [B:91:0x01ba, B:26:0x0055] A[DONT_GENERATE, DONT_INLINE]
      0x01bd: PHI (r15v32 java.lang.Object) = (r15v31 java.lang.Object), (r15v1 java.lang.Object) binds: [B:91:0x01ba, B:26:0x0055] A[DONT_GENERATE, DONT_INLINE], TryCatch #2 {PurchasesException -> 0x005a, blocks: (B:26:0x0055, B:93:0x01bd, B:95:0x01c3, B:105:0x01fa, B:107:0x01fe, B:109:0x0202, B:111:0x020a, B:90:0x01ae, B:60:0x00f9, B:62:0x00ff, B:64:0x0106, B:67:0x0118, B:68:0x0134, B:70:0x013a, B:72:0x013f, B:73:0x0144, B:87:0x019f, B:112:0x0210, B:113:0x0217), top: B:122:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01c3 A[Catch: PurchasesException -> 0x005a, TRY_LEAVE, TryCatch #2 {PurchasesException -> 0x005a, blocks: (B:26:0x0055, B:93:0x01bd, B:95:0x01c3, B:105:0x01fa, B:107:0x01fe, B:109:0x0202, B:111:0x020a, B:90:0x01ae, B:60:0x00f9, B:62:0x00ff, B:64:0x0106, B:67:0x0118, B:68:0x0134, B:70:0x013a, B:72:0x013f, B:73:0x0144, B:87:0x019f, B:112:0x0210, B:113:0x0217), top: B:122:0x0028 }] */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl$handleRestorePurchases$1, java.lang.Object, kotlin.coroutines.Continuation] */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v33 */
    /* JADX WARN: Type inference failed for: r0v34 */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r10v10, types: [kotlin.jvm.functions.Function2] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r15v23, types: [com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType] */
    /* JADX WARN: Type inference failed for: r15v36, types: [com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v34 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl] */
    /* JADX WARN: Type inference failed for: r2v5 */
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
    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object handleRestorePurchases(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 588
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModelImpl.handleRestorePurchases(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.data.PaywallViewModel
    public void trackComponentInteraction(PaywallComponentInteractionData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        PaywallEvent.Data data2 = this.paywallPresentationData;
        if (data2 == null) {
            Logger.INSTANCE.e("Paywall event data is null, not tracking paywall component interaction");
            return;
        }
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        this.purchases.track(new PaywallEvent(new PaywallEvent.CreationData(uuidRandomUUID, new Date()), data2, PaywallEventType.COMPONENT_INTERACTION, data));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallViewModelImpl(ResourceProvider resourceProvider, PurchasesType purchases, PaywallOptions options, ColorScheme colorScheme, boolean z2, Function1<? super CustomerInfo, Boolean> function1, boolean z3, ProductChangeCalculator productChangeCalculator) {
        Intrinsics.checkNotNullParameter(resourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        Intrinsics.checkNotNullParameter(productChangeCalculator, "productChangeCalculator");
        this.resourceProvider = resourceProvider;
        this.purchases = purchases;
        this.options = options;
        this.isDarkMode = z2;
        this.shouldDisplayBlock = function1;
        this.productChangeCalculator = productChangeCalculator;
        this.variableDataProvider = new VariableDataProvider(getResourceProvider(), z3);
        this._state = StateFlowKt.a(PaywallState.Loading.INSTANCE);
        Boolean bool = Boolean.FALSE;
        this._actionInProgress = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this._actionError = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this._purchaseCompleted = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this._preloadedExitOffering = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this._lastLocaleList = StateFlowKt.a(getCurrentLocaleList());
        this._colorScheme = StateFlowKt.a(colorScheme);
        updateState();
        validateState();
    }

    private final PaywallEvent.Data createEventData(PaywallState.Loaded.Legacy legacy) {
        PaywallComponentsData data;
        int revision;
        String str;
        PaywallComponentsData data2;
        String id;
        Offering offering = legacy.getOffering();
        PaywallData paywall = legacy.getOffering().getPaywall();
        String id2 = null;
        if (paywall != null) {
            revision = paywall.getRevision();
        } else {
            Offering.PaywallComponents paywallComponents = legacy.getOffering().getPaywallComponents();
            if (paywallComponents == null || (data = paywallComponents.getData()) == null) {
                Logger.INSTANCE.e("Null paywall revision trying to create event data");
                return null;
            }
            revision = data.getRevision();
        }
        int i3 = revision;
        PaywallData paywall2 = legacy.getOffering().getPaywall();
        if (paywall2 == null || (id = paywall2.getId()) == null) {
            Offering.PaywallComponents paywallComponents2 = legacy.getOffering().getPaywallComponents();
            if (paywallComponents2 != null && (data2 = paywallComponents2.getData()) != null) {
                id2 = data2.getId();
            }
            str = id2;
        } else {
            str = id;
        }
        Locale localeD = ((LocaleListCompat) this._lastLocaleList.getValue()).d(0);
        if (localeD == null) {
            localeD = Locale.getDefault();
        }
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext(offering);
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        String lowerCase = getMode().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String string = localeD.toString();
        Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
        return new PaywallEvent.Data(str, presentedOfferingContext, i3, uuidRandomUUID, lowerCase, string, this.isDarkMode, null, null, null, null, null, null, 8064, null);
    }

    private final PaywallEvent.Data createEventData(PaywallState.Loaded.Components components) {
        Offering offering = components.getOffering();
        Offering.PaywallComponents paywallComponents = components.getOffering().getPaywallComponents();
        if (paywallComponents == null) {
            Logger.INSTANCE.e("Null paywall revision trying to create event data");
            return null;
        }
        String id = paywallComponents.getData().getId();
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext(offering);
        int revision = paywallComponents.getData().getRevision();
        UUID uuidRandomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(uuidRandomUUID, "randomUUID()");
        String lowerCase = getMode().name().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new PaywallEvent.Data(id, presentedOfferingContext, revision, uuidRandomUUID, lowerCase, components.getLocale().toString(), this.isDarkMode, null, null, null, null, null, null, 8064, null);
    }
}
