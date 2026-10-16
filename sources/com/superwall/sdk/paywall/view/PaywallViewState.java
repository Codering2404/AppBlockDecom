package com.superwall.sdk.paywall.view;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.PaywallPresentationStyle;
import com.superwall.sdk.models.triggers.Experiment;
import com.superwall.sdk.models.triggers.TriggerRuleOccurrence;
import com.superwall.sdk.paywall.manager.PaywallCacheLogic;
import com.superwall.sdk.paywall.presentation.PaywallCloseReason;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.presentation.internal.PresentationRequest;
import com.superwall.sdk.paywall.presentation.internal.request.PresentationInfo;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallResult;
import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.delegate.PaywallLoadingState;
import com.superwall.sdk.paywall.view.survey.SurveyPresentationResult;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
public final class PaywallViewState {
    private final String cacheKey;
    private final boolean callbackInvoked;
    private final boolean closedForBackground;
    private final int crashRetries;
    private final CustomerInfo customerInfo;
    private final boolean didDisableSwipeForSurvey;
    private final Function0<Unit> dismissCompletionBlock;
    private final boolean interceptTouchEvents;
    private final boolean isBrowserViewPresented;
    private final boolean isPresented;
    private final Date lastOpen;
    private final PaywallLoadingState loadingState;
    private final String locale;
    private final Paywall paywall;
    private final PaywallResult paywallResult;
    private final MutableSharedFlow<PaywallState> paywallStatePublisher;
    private final boolean presentationDidFinishPrepare;
    private final boolean presentationIdOpened;
    private final PaywallPresentationStyle presentationStyle;
    private final boolean presentationWillPrepare;
    private final PresentationRequest request;
    private final SurveyPresentationResult surveyPresentationResult;
    private final TriggerRuleOccurrence unsavedOccurrence;
    private final boolean useMultipleUrls;
    private final Function1<Boolean, Unit> viewCreatedCompletion;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class Updates {
        private final Function1<PaywallViewState, PaywallViewState> transform;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class BeginPresentation extends Updates {
            public static final BeginPresentation INSTANCE = new BeginPresentation();

            private BeginPresentation() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.l
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.BeginPresentation._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (!state.getPresentationIdOpened() && state.getPaywall().getPresentationId() != null) {
                    return state;
                }
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : UUID.randomUUID().toString(), (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 8388606, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CallbackInvoked extends Updates {
            public static final CallbackInvoked INSTANCE = new CallbackInvoked();

            private CallbackInvoked() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.m
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.CallbackInvoked._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, true, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16776959, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CleanupAfterDestroy extends Updates {
            public static final CleanupAfterDestroy INSTANCE = new CleanupAfterDestroy();

            private CleanupAfterDestroy() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.n
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.CleanupAfterDestroy._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Function0<Unit> dismissCompletionBlock = state.getDismissCompletionBlock();
                if (dismissCompletionBlock != null) {
                    dismissCompletionBlock.invoke();
                }
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 12533567, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ClearStatePublisher extends Updates {
            public static final ClearStatePublisher INSTANCE = new ClearStatePublisher();

            private ClearStatePublisher() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.o
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ClearStatePublisher._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return PaywallViewState.copy$default(it, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777183, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ClearUnsavedOccurrence extends Updates {
            public static final ClearUnsavedOccurrence INSTANCE = new ClearUnsavedOccurrence();

            private ClearUnsavedOccurrence() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ClearUnsavedOccurrence._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16252927, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ClearViewCreatedCompletion extends Updates {
            public static final ClearViewCreatedCompletion INSTANCE = new ClearViewCreatedCompletion();

            private ClearViewCreatedCompletion() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ClearViewCreatedCompletion._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16776703, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class CrashRetry extends Updates {
            public static final CrashRetry INSTANCE = new CrashRetry();

            private CrashRetry() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.r
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.CrashRetry._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return PaywallViewState.copy$default(it, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, it.getCrashRetries() + 1, null, false, 14680063, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class InitiateDismiss extends Updates {
            private final PaywallCloseReason closeReason;
            private final Function0<Unit> completion;
            private final PaywallResult result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public InitiateDismiss(final PaywallResult result, final PaywallCloseReason closeReason, final Function0<Unit> function0) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.s
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.InitiateDismiss._init_$lambda$0(closeReason, result, function0, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(result, "result");
                Intrinsics.checkNotNullParameter(closeReason, "closeReason");
                this.result = result;
                this.closeReason = closeReason;
                this.completion = function0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallCloseReason paywallCloseReason, PaywallResult paywallResult, Function0 function0, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : paywallCloseReason, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, paywallResult, function0, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777022, null);
            }

            public final PaywallCloseReason getCloseReason() {
                return this.closeReason;
            }

            public final Function0<Unit> getCompletion() {
                return this.completion;
            }

            public final PaywallResult getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class MergePaywall extends Updates {
            private final Paywall from;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public MergePaywall(final Paywall from) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.MergePaywall._init_$lambda$0(from, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(from, "from");
                this.from = from;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(Paywall paywall, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall2 = state.getPaywall();
                Paywall paywallM1294copyBiBlP3E = paywall2.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall2.databaseId : null, ((-553648129) & 2) != 0 ? paywall2.identifier : null, ((-553648129) & 4) != 0 ? paywall2.name : null, ((-553648129) & 8) != 0 ? paywall2.url : null, ((-553648129) & 16) != 0 ? paywall2.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall2.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall2.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall2.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall2.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall2.presentation : null, ((-553648129) & 1024) != 0 ? paywall2.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall2.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall2._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall2._productItemsV3 : paywall.get_productItemsV3$superwall_release(), ((-553648129) & 16384) != 0 ? paywall2._productItems : null, ((-553648129) & 32768) != 0 ? paywall2.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall2.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall2.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall2.productsLoadingInfo : paywall.getProductsLoadingInfo(), ((-553648129) & 524288) != 0 ? paywall2.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall2.productVariables : paywall.getProductVariables(), ((-553648129) & 2097152) != 0 ? paywall2.swProductVariablesTemplate : paywall.getSwProductVariablesTemplate(), ((-553648129) & 4194304) != 0 ? paywall2.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall2.isFreeTrialAvailable : paywall.isFreeTrialAvailable(), ((-553648129) & 16777216) != 0 ? paywall2.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall2.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall2.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall2.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall2.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall2.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall2.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall2.state : null, (254 & 1) != 0 ? paywall2.presentationId : null, (254 & 2) != 0 ? paywall2.urlConfig : null, (254 & 4) != 0 ? paywall2.cacheKey : null, (254 & 8) != 0 ? paywall2.buildId : null, (254 & 16) != 0 ? paywall2.surveys : null, (254 & 32) != 0 ? paywall2.isScrollEnabled : null, (254 & 64) != 0 ? paywall2.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall2.introOfferEligibility : null);
                paywallM1294copyBiBlP3E.setProductItems(paywall.getProductItems());
                return PaywallViewState.copy$default(state, paywallM1294copyBiBlP3E, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777214, null);
            }

            public final Paywall getFrom() {
                return this.from;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PresentationWillBegin extends Updates {
            public static final PresentationWillBegin INSTANCE = new PresentationWillBegin();

            private PresentationWillBegin() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.u
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.PresentationWillBegin._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : PaywallCloseReason.None.INSTANCE, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16776958, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ResetCrashRetry extends Updates {
            public static final ResetCrashRetry INSTANCE = new ResetCrashRetry();

            private ResetCrashRetry() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ResetCrashRetry._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return PaywallViewState.copy$default(it, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 14680063, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ResetPresentationPreparations extends Updates {
            public static final ResetPresentationPreparations INSTANCE = new ResetPresentationPreparations();

            private ResetPresentationPreparations() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ResetPresentationPreparations._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, true, false, false, null, false, 0, null, false, 16580607, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetBrowserPresented extends Updates {
            private final boolean presented;

            public SetBrowserPresented(final boolean z2) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.x
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetBrowserPresented._init_$lambda$0(z2, (PaywallViewState) obj);
                    }
                }, null);
                this.presented = z2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(boolean z2, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, z2, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16776191, null);
            }

            public final boolean getPresented() {
                return this.presented;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetClosedForBackground extends Updates {
            private final boolean closed;

            public SetClosedForBackground(final boolean z2) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetClosedForBackground._init_$lambda$0(z2, (PaywallViewState) obj);
                    }
                }, null);
                this.closed = z2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(boolean z2, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, z2, false, false, false, null, false, 0, null, false, 16744447, null);
            }

            public final boolean getClosed() {
                return this.closed;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetCustomerInfo extends Updates {
            private final CustomerInfo customerInfo;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetCustomerInfo(final CustomerInfo customerInfo) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetCustomerInfo._init_$lambda$0(customerInfo, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                this.customerInfo = customerInfo;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(CustomerInfo customerInfo, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, customerInfo, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777211, null);
            }

            public final CustomerInfo getCustomerInfo() {
                return this.customerInfo;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetInterceptTouchEvents extends Updates {
            private final boolean intercept;

            public SetInterceptTouchEvents(final boolean z2) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetInterceptTouchEvents._init_$lambda$0(z2, (PaywallViewState) obj);
                    }
                }, null);
                this.intercept = z2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(boolean z2, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, z2, null, null, false, false, false, false, false, null, false, 0, null, false, 16775167, null);
            }

            public final boolean getIntercept() {
                return this.intercept;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetLastOpen extends Updates {
            public static final SetLastOpen INSTANCE = new SetLastOpen();

            private SetLastOpen() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.b0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetLastOpen._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, new Date(), true, 4194303, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetLoadingState extends Updates {
            private final PaywallLoadingState newState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetLoadingState(final PaywallLoadingState newState) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.c0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetLoadingState._init_$lambda$0(newState, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(newState, "newState");
                this.newState = newState;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallLoadingState paywallLoadingState, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, paywallLoadingState, false, false, false, false, false, null, false, 0, null, false, 16769023, null);
            }

            public final PaywallLoadingState getNewState() {
                return this.newState;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetPaywallJsVersion extends Updates {
            private final String version;

            public SetPaywallJsVersion(final String str) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.d0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetPaywallJsVersion._init_$lambda$0(str, (PaywallViewState) obj);
                    }
                }, null);
                this.version = str;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(String str, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : str, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777214, null);
            }

            public final String getVersion() {
                return this.version;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetPaywallState extends Updates {
            private final Map<String, Object> state;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetPaywallState(final Map<String, ? extends Object> state) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.e0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetPaywallState._init_$lambda$1(state, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(state, "state");
                this.state = state;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$1(Map map, PaywallViewState viewState) {
                Intrinsics.checkNotNullParameter(viewState, "viewState");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry entry : map.entrySet()) {
                    if (!Intrinsics.areEqual(entry.getKey(), AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Paywall paywall = viewState.getPaywall();
                return PaywallViewState.copy$default(viewState, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : linkedHashMap, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777214, null);
            }

            public final Map<String, Object> getState() {
                return this.state;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetPresentationConfig extends Updates {
            private final Function1<Boolean, Unit> completion;
            private final PaywallPresentationStyle styleOverride;

            /* JADX WARN: Multi-variable type inference failed */
            public SetPresentationConfig(final PaywallPresentationStyle paywallPresentationStyle, final Function1<? super Boolean, Unit> function1) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.f0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetPresentationConfig._init_$lambda$0(paywallPresentationStyle, function1, (PaywallViewState) obj);
                    }
                }, null);
                this.styleOverride = paywallPresentationStyle;
                this.completion = function1;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallPresentationStyle paywallPresentationStyle, Function1 function1, PaywallViewState state) {
                PaywallPresentationStyle style = paywallPresentationStyle;
                Intrinsics.checkNotNullParameter(state, "state");
                if (style == null || (style instanceof PaywallPresentationStyle.None)) {
                    style = state.getPaywall().getPresentation().getStyle();
                }
                return PaywallViewState.copy$default(state, null, null, null, null, style, null, null, null, false, function1, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16776687, null);
            }

            public final Function1<Boolean, Unit> getCompletion() {
                return this.completion;
            }

            public final PaywallPresentationStyle getStyleOverride() {
                return this.styleOverride;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetPresentedAndFinished extends Updates {
            public static final SetPresentedAndFinished INSTANCE = new SetPresentedAndFinished();

            private SetPresentedAndFinished() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.g0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetPresentedAndFinished._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, null, true, false, false, true, false, null, false, 0, null, false, 16629759, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class SetRequest extends Updates {
            private final Experiment experiment;
            private final TriggerRuleOccurrence occurrence;
            private final MutableSharedFlow<PaywallState> publisher;
            private final PresentationRequest req;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SetRequest(final PresentationRequest req, final MutableSharedFlow<PaywallState> mutableSharedFlow, final TriggerRuleOccurrence triggerRuleOccurrence, final Experiment experiment) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.h0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.SetRequest._init_$lambda$0(req, experiment, mutableSharedFlow, triggerRuleOccurrence, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(req, "req");
                this.req = req;
                this.publisher = mutableSharedFlow;
                this.occurrence = triggerRuleOccurrence;
                this.experiment = experiment;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PresentationRequest presentationRequest, Experiment experiment, MutableSharedFlow mutableSharedFlow, TriggerRuleOccurrence triggerRuleOccurrence, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : presentationRequest.getPresentationSourceType(), ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : experiment, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, presentationRequest, null, mutableSharedFlow, null, null, false, null, false, false, null, null, false, false, false, false, false, triggerRuleOccurrence, false, 0, null, false, 16252886, null);
            }

            public final Experiment getExperiment() {
                return this.experiment;
            }

            public final TriggerRuleOccurrence getOccurrence() {
                return this.occurrence;
            }

            public final MutableSharedFlow<PaywallState> getPublisher() {
                return this.publisher;
            }

            public final PresentationRequest getReq() {
                return this.req;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ShimmerEnded extends Updates {
            public static final ShimmerEnded INSTANCE = new ShimmerEnded();

            private ShimmerEnded() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.i0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ShimmerEnded._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : Paywall.LoadingInfo.copy$default(state.getPaywall().getShimmerLoadingInfo(), null, new Date(), null, 5, null), ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777214, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ShimmerStarted extends Updates {
            public static final ShimmerStarted INSTANCE = new ShimmerStarted();

            private ShimmerStarted() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.j0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ShimmerStarted._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : null, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : Paywall.LoadingInfo.copy$default(state.getPaywall().getShimmerLoadingInfo(), new Date(), null, null, 6, null), ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16711678, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class ToggleSpinner extends Updates {
            private final boolean hidden;

            public ToggleSpinner(final boolean z2) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.k0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.ToggleSpinner._init_$lambda$0(z2, (PaywallViewState) obj);
                    }
                }, null);
                this.hidden = z2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(boolean z2, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (z2) {
                    if ((state.getLoadingState() instanceof PaywallLoadingState.ManualLoading) || (state.getLoadingState() instanceof PaywallLoadingState.LoadingPurchase)) {
                        return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, PaywallLoadingState.Ready.INSTANCE, false, false, false, false, false, null, false, 0, null, false, 16769023, null);
                    }
                } else if (state.getLoadingState() instanceof PaywallLoadingState.Ready) {
                    return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, null, PaywallLoadingState.ManualLoading.INSTANCE, false, false, false, false, false, null, false, 0, null, false, 16769023, null);
                }
                return state;
            }

            public static /* synthetic */ ToggleSpinner copy$default(ToggleSpinner toggleSpinner, boolean z2, int i3, Object obj) {
                if ((i3 & 1) != 0) {
                    z2 = toggleSpinner.hidden;
                }
                return toggleSpinner.copy(z2);
            }

            public final boolean component1() {
                return this.hidden;
            }

            public final ToggleSpinner copy(boolean z2) {
                return new ToggleSpinner(z2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof ToggleSpinner) && this.hidden == ((ToggleSpinner) obj).hidden;
            }

            public final boolean getHidden() {
                return this.hidden;
            }

            public int hashCode() {
                return Boolean.hashCode(this.hidden);
            }

            public String toString() {
                return "ToggleSpinner(hidden=" + this.hidden + ")";
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class UpdateSurveyState extends Updates {
            private final SurveyPresentationResult result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public UpdateSurveyState(final SurveyPresentationResult result) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.l0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.UpdateSurveyState._init_$lambda$0(result, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(result, "result");
                this.result = result;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(SurveyPresentationResult surveyPresentationResult, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                return PaywallViewState.copy$default(state, null, null, null, null, null, null, null, null, false, null, false, false, surveyPresentationResult, null, false, false, false, false, false, null, false, 0, null, false, 16773119, null);
            }

            public final SurveyPresentationResult getResult() {
                return this.result;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WebLoadingEnded extends Updates {
            private final Date endAt;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WebLoadingEnded(final Date endAt) {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.m0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.WebLoadingEnded._init_$lambda$0(endAt, (PaywallViewState) obj);
                    }
                }, null);
                Intrinsics.checkNotNullParameter(endAt, "endAt");
                this.endAt = endAt;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(Date date, PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : Paywall.LoadingInfo.copy$default(state.getPaywall().getWebviewLoadingInfo(), null, date, null, 5, null), ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777214, null);
            }

            public final Date getEndAt() {
                return this.endAt;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WebLoadingFailed extends Updates {
            public static final WebLoadingFailed INSTANCE = new WebLoadingFailed();

            private WebLoadingFailed() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.n0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.WebLoadingFailed._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall.LoadingInfo webviewLoadingInfo = state.getPaywall().getWebviewLoadingInfo();
                if (webviewLoadingInfo.getFailAt() == null) {
                    webviewLoadingInfo = Paywall.LoadingInfo.copy$default(webviewLoadingInfo, null, null, new Date(), 3, null);
                }
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : webviewLoadingInfo, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777214, null);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class WebLoadingStarted extends Updates {
            public static final WebLoadingStarted INSTANCE = new WebLoadingStarted();

            private WebLoadingStarted() {
                super(new Function1() { // from class: com.superwall.sdk.paywall.view.o0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return PaywallViewState.Updates.WebLoadingStarted._init_$lambda$0((PaywallViewState) obj);
                    }
                }, null);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final PaywallViewState _init_$lambda$0(PaywallViewState state) {
                Intrinsics.checkNotNullParameter(state, "state");
                Paywall.LoadingInfo webviewLoadingInfo = state.getPaywall().getWebviewLoadingInfo();
                if (webviewLoadingInfo.getStartAt() == null) {
                    webviewLoadingInfo = Paywall.LoadingInfo.copy$default(webviewLoadingInfo, new Date(), null, null, 6, null);
                }
                Paywall paywall = state.getPaywall();
                return PaywallViewState.copy$default(state, paywall.m1294copyBiBlP3E(((-553648129) & 1) != 0 ? paywall.databaseId : null, ((-553648129) & 2) != 0 ? paywall.identifier : null, ((-553648129) & 4) != 0 ? paywall.name : null, ((-553648129) & 8) != 0 ? paywall.url : null, ((-553648129) & 16) != 0 ? paywall.htmlSubstitutions : null, ((-553648129) & 32) != 0 ? paywall.presentationStyle : null, ((-553648129) & 64) != 0 ? paywall.expandedPresentationStyle : null, ((-553648129) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.presentationDelay : 0L, ((-553648129) & Function.MAX_NARGS) != 0 ? paywall.presentationCondition : null, ((-553648129) & 512) != 0 ? paywall.presentation : null, ((-553648129) & 1024) != 0 ? paywall.backgroundColorHex : null, ((-553648129) & 2048) != 0 ? paywall.darkBackgroundColorHex : null, ((-553648129) & 4096) != 0 ? paywall._products : null, ((-553648129) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywall._productItemsV3 : null, ((-553648129) & 16384) != 0 ? paywall._productItems : null, ((-553648129) & 32768) != 0 ? paywall.productIds : null, ((-553648129) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywall.responseLoadingInfo : null, ((-553648129) & 131072) != 0 ? paywall.webviewLoadingInfo : webviewLoadingInfo, ((-553648129) & 262144) != 0 ? paywall.productsLoadingInfo : null, ((-553648129) & 524288) != 0 ? paywall.shimmerLoadingInfo : null, ((-553648129) & 1048576) != 0 ? paywall.productVariables : null, ((-553648129) & 2097152) != 0 ? paywall.swProductVariablesTemplate : null, ((-553648129) & 4194304) != 0 ? paywall.paywalljsVersion : null, ((-553648129) & 8388608) != 0 ? paywall.isFreeTrialAvailable : false, ((-553648129) & 16777216) != 0 ? paywall.presentationSourceType : null, ((-553648129) & 33554432) != 0 ? paywall.featureGating : null, ((-553648129) & 67108864) != 0 ? paywall.computedPropertyRequests : null, ((-553648129) & 134217728) != 0 ? paywall.localNotifications : null, ((-553648129) & 268435456) != 0 ? paywall.onDeviceCache : null, ((-553648129) & 536870912) != 0 ? paywall.experiment : null, ((-553648129) & 1073741824) != 0 ? paywall.closeReason : null, ((-553648129) & Integer.MIN_VALUE) != 0 ? paywall.state : null, (254 & 1) != 0 ? paywall.presentationId : null, (254 & 2) != 0 ? paywall.urlConfig : null, (254 & 4) != 0 ? paywall.cacheKey : null, (254 & 8) != 0 ? paywall.buildId : null, (254 & 16) != 0 ? paywall.surveys : null, (254 & 32) != 0 ? paywall.isScrollEnabled : null, (254 & 64) != 0 ? paywall.rerouteBackButton : null, (254 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywall.introOfferEligibility : null), null, null, null, null, null, null, null, false, null, false, false, null, null, false, false, false, false, false, null, false, 0, null, false, 16777214, null);
            }
        }

        public /* synthetic */ Updates(Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
            this(function1);
        }

        public final Function1<PaywallViewState, PaywallViewState> getTransform() {
            return this.transform;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Updates(Function1<? super PaywallViewState, PaywallViewState> function1) {
            this.transform = function1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallViewState(Paywall paywall, String locale, CustomerInfo customerInfo, PresentationRequest presentationRequest, PaywallPresentationStyle presentationStyle, MutableSharedFlow<PaywallState> mutableSharedFlow, PaywallResult paywallResult, Function0<Unit> function0, boolean z2, Function1<? super Boolean, Unit> function1, boolean z3, boolean z4, SurveyPresentationResult surveyPresentationResult, PaywallLoadingState loadingState, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, TriggerRuleOccurrence triggerRuleOccurrence, boolean z10, int i3, Date date, boolean z11) {
        Intrinsics.checkNotNullParameter(paywall, "paywall");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(presentationStyle, "presentationStyle");
        Intrinsics.checkNotNullParameter(surveyPresentationResult, "surveyPresentationResult");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        this.paywall = paywall;
        this.locale = locale;
        this.customerInfo = customerInfo;
        this.request = presentationRequest;
        this.presentationStyle = presentationStyle;
        this.paywallStatePublisher = mutableSharedFlow;
        this.paywallResult = paywallResult;
        this.dismissCompletionBlock = function0;
        this.callbackInvoked = z2;
        this.viewCreatedCompletion = function1;
        this.isBrowserViewPresented = z3;
        this.interceptTouchEvents = z4;
        this.surveyPresentationResult = surveyPresentationResult;
        this.loadingState = loadingState;
        this.isPresented = z5;
        this.closedForBackground = z6;
        this.presentationWillPrepare = z7;
        this.presentationDidFinishPrepare = z8;
        this.didDisableSwipeForSurvey = z9;
        this.unsavedOccurrence = triggerRuleOccurrence;
        this.useMultipleUrls = z10;
        this.crashRetries = i3;
        this.lastOpen = date;
        this.presentationIdOpened = z11;
        this.cacheKey = PaywallCacheLogic.INSTANCE.key(paywall.getIdentifier(), locale);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PaywallViewState copy$default(PaywallViewState paywallViewState, Paywall paywall, String str, CustomerInfo customerInfo, PresentationRequest presentationRequest, PaywallPresentationStyle paywallPresentationStyle, MutableSharedFlow mutableSharedFlow, PaywallResult paywallResult, Function0 function0, boolean z2, Function1 function1, boolean z3, boolean z4, SurveyPresentationResult surveyPresentationResult, PaywallLoadingState paywallLoadingState, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, TriggerRuleOccurrence triggerRuleOccurrence, boolean z10, int i3, Date date, boolean z11, int i4, Object obj) {
        boolean z12;
        Date date2;
        Paywall paywall2 = (i4 & 1) != 0 ? paywallViewState.paywall : paywall;
        String str2 = (i4 & 2) != 0 ? paywallViewState.locale : str;
        CustomerInfo customerInfo2 = (i4 & 4) != 0 ? paywallViewState.customerInfo : customerInfo;
        PresentationRequest presentationRequest2 = (i4 & 8) != 0 ? paywallViewState.request : presentationRequest;
        PaywallPresentationStyle paywallPresentationStyle2 = (i4 & 16) != 0 ? paywallViewState.presentationStyle : paywallPresentationStyle;
        MutableSharedFlow mutableSharedFlow2 = (i4 & 32) != 0 ? paywallViewState.paywallStatePublisher : mutableSharedFlow;
        PaywallResult paywallResult2 = (i4 & 64) != 0 ? paywallViewState.paywallResult : paywallResult;
        Function0 function02 = (i4 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? paywallViewState.dismissCompletionBlock : function0;
        boolean z13 = (i4 & Function.MAX_NARGS) != 0 ? paywallViewState.callbackInvoked : z2;
        Function1 function12 = (i4 & 512) != 0 ? paywallViewState.viewCreatedCompletion : function1;
        boolean z14 = (i4 & 1024) != 0 ? paywallViewState.isBrowserViewPresented : z3;
        boolean z15 = (i4 & 2048) != 0 ? paywallViewState.interceptTouchEvents : z4;
        SurveyPresentationResult surveyPresentationResult2 = (i4 & 4096) != 0 ? paywallViewState.surveyPresentationResult : surveyPresentationResult;
        PaywallLoadingState paywallLoadingState2 = (i4 & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? paywallViewState.loadingState : paywallLoadingState;
        Paywall paywall3 = paywall2;
        boolean z16 = (i4 & 16384) != 0 ? paywallViewState.isPresented : z5;
        boolean z17 = (i4 & 32768) != 0 ? paywallViewState.closedForBackground : z6;
        boolean z18 = (i4 & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? paywallViewState.presentationWillPrepare : z7;
        boolean z19 = (i4 & 131072) != 0 ? paywallViewState.presentationDidFinishPrepare : z8;
        boolean z20 = (i4 & 262144) != 0 ? paywallViewState.didDisableSwipeForSurvey : z9;
        TriggerRuleOccurrence triggerRuleOccurrence2 = (i4 & 524288) != 0 ? paywallViewState.unsavedOccurrence : triggerRuleOccurrence;
        boolean z21 = (i4 & 1048576) != 0 ? paywallViewState.useMultipleUrls : z10;
        int i5 = (i4 & 2097152) != 0 ? paywallViewState.crashRetries : i3;
        Date date3 = (i4 & 4194304) != 0 ? paywallViewState.lastOpen : date;
        if ((i4 & 8388608) != 0) {
            date2 = date3;
            z12 = paywallViewState.presentationIdOpened;
        } else {
            z12 = z11;
            date2 = date3;
        }
        return paywallViewState.copy(paywall3, str2, customerInfo2, presentationRequest2, paywallPresentationStyle2, mutableSharedFlow2, paywallResult2, function02, z13, function12, z14, z15, surveyPresentationResult2, paywallLoadingState2, z16, z17, z18, z19, z20, triggerRuleOccurrence2, z21, i5, date2, z12);
    }

    public final Paywall component1() {
        return this.paywall;
    }

    public final Function1<Boolean, Unit> component10() {
        return this.viewCreatedCompletion;
    }

    public final boolean component11() {
        return this.isBrowserViewPresented;
    }

    public final boolean component12() {
        return this.interceptTouchEvents;
    }

    public final SurveyPresentationResult component13() {
        return this.surveyPresentationResult;
    }

    public final PaywallLoadingState component14() {
        return this.loadingState;
    }

    public final boolean component15() {
        return this.isPresented;
    }

    public final boolean component16() {
        return this.closedForBackground;
    }

    public final boolean component17() {
        return this.presentationWillPrepare;
    }

    public final boolean component18() {
        return this.presentationDidFinishPrepare;
    }

    public final boolean component19() {
        return this.didDisableSwipeForSurvey;
    }

    public final String component2() {
        return this.locale;
    }

    public final TriggerRuleOccurrence component20() {
        return this.unsavedOccurrence;
    }

    public final boolean component21() {
        return this.useMultipleUrls;
    }

    public final int component22() {
        return this.crashRetries;
    }

    public final Date component23() {
        return this.lastOpen;
    }

    public final boolean component24() {
        return this.presentationIdOpened;
    }

    public final CustomerInfo component3() {
        return this.customerInfo;
    }

    public final PresentationRequest component4() {
        return this.request;
    }

    public final PaywallPresentationStyle component5() {
        return this.presentationStyle;
    }

    public final MutableSharedFlow<PaywallState> component6() {
        return this.paywallStatePublisher;
    }

    public final PaywallResult component7() {
        return this.paywallResult;
    }

    public final Function0<Unit> component8() {
        return this.dismissCompletionBlock;
    }

    public final boolean component9() {
        return this.callbackInvoked;
    }

    public final PaywallViewState copy(Paywall paywall, String locale, CustomerInfo customerInfo, PresentationRequest presentationRequest, PaywallPresentationStyle presentationStyle, MutableSharedFlow<PaywallState> mutableSharedFlow, PaywallResult paywallResult, Function0<Unit> function0, boolean z2, Function1<? super Boolean, Unit> function1, boolean z3, boolean z4, SurveyPresentationResult surveyPresentationResult, PaywallLoadingState loadingState, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, TriggerRuleOccurrence triggerRuleOccurrence, boolean z10, int i3, Date date, boolean z11) {
        Intrinsics.checkNotNullParameter(paywall, "paywall");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(presentationStyle, "presentationStyle");
        Intrinsics.checkNotNullParameter(surveyPresentationResult, "surveyPresentationResult");
        Intrinsics.checkNotNullParameter(loadingState, "loadingState");
        return new PaywallViewState(paywall, locale, customerInfo, presentationRequest, presentationStyle, mutableSharedFlow, paywallResult, function0, z2, function1, z3, z4, surveyPresentationResult, loadingState, z5, z6, z7, z8, z9, triggerRuleOccurrence, z10, i3, date, z11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallViewState)) {
            return false;
        }
        PaywallViewState paywallViewState = (PaywallViewState) obj;
        return Intrinsics.areEqual(this.paywall, paywallViewState.paywall) && Intrinsics.areEqual(this.locale, paywallViewState.locale) && Intrinsics.areEqual(this.customerInfo, paywallViewState.customerInfo) && Intrinsics.areEqual(this.request, paywallViewState.request) && Intrinsics.areEqual(this.presentationStyle, paywallViewState.presentationStyle) && Intrinsics.areEqual(this.paywallStatePublisher, paywallViewState.paywallStatePublisher) && Intrinsics.areEqual(this.paywallResult, paywallViewState.paywallResult) && Intrinsics.areEqual(this.dismissCompletionBlock, paywallViewState.dismissCompletionBlock) && this.callbackInvoked == paywallViewState.callbackInvoked && Intrinsics.areEqual(this.viewCreatedCompletion, paywallViewState.viewCreatedCompletion) && this.isBrowserViewPresented == paywallViewState.isBrowserViewPresented && this.interceptTouchEvents == paywallViewState.interceptTouchEvents && this.surveyPresentationResult == paywallViewState.surveyPresentationResult && Intrinsics.areEqual(this.loadingState, paywallViewState.loadingState) && this.isPresented == paywallViewState.isPresented && this.closedForBackground == paywallViewState.closedForBackground && this.presentationWillPrepare == paywallViewState.presentationWillPrepare && this.presentationDidFinishPrepare == paywallViewState.presentationDidFinishPrepare && this.didDisableSwipeForSurvey == paywallViewState.didDisableSwipeForSurvey && Intrinsics.areEqual(this.unsavedOccurrence, paywallViewState.unsavedOccurrence) && this.useMultipleUrls == paywallViewState.useMultipleUrls && this.crashRetries == paywallViewState.crashRetries && Intrinsics.areEqual(this.lastOpen, paywallViewState.lastOpen) && this.presentationIdOpened == paywallViewState.presentationIdOpened;
    }

    public final String getCacheKey$superwall_release() {
        return this.cacheKey;
    }

    public final boolean getCallbackInvoked() {
        return this.callbackInvoked;
    }

    public final boolean getClosedForBackground() {
        return this.closedForBackground;
    }

    public final int getCrashRetries() {
        return this.crashRetries;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final boolean getDidDisableSwipeForSurvey() {
        return this.didDisableSwipeForSurvey;
    }

    public final Function0<Unit> getDismissCompletionBlock() {
        return this.dismissCompletionBlock;
    }

    public final PaywallInfo getInfo() {
        PresentationInfo presentationInfo;
        Paywall paywall = this.paywall;
        PresentationRequest presentationRequest = this.request;
        PaywallInfo info = paywall.getInfo((presentationRequest == null || (presentationInfo = presentationRequest.getPresentationInfo()) == null) ? null : presentationInfo.getEventData());
        return info.m1323copyBiBlP3E(((-1) & 1) != 0 ? info.databaseId : null, ((-1) & 2) != 0 ? info.identifier : null, ((-1) & 4) != 0 ? info.name : null, ((-1) & 8) != 0 ? info.url : null, ((-1) & 16) != 0 ? info.experiment : null, ((-1) & 32) != 0 ? info.products : null, ((-1) & 64) != 0 ? info.productIds : null, ((-1) & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? info.presentedByEventWithName : null, ((-1) & Function.MAX_NARGS) != 0 ? info.presentedByEventWithId : null, ((-1) & 512) != 0 ? info.presentedByEventAt : null, ((-1) & 1024) != 0 ? info.presentedBy : null, ((-1) & 2048) != 0 ? info.presentationSourceType : null, ((-1) & 4096) != 0 ? info.responseLoadStartTime : null, ((-1) & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0 ? info.responseLoadCompleteTime : null, ((-1) & 16384) != 0 ? info.responseLoadFailTime : null, ((-1) & 32768) != 0 ? info.responseLoadDuration : null, ((-1) & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) != 0 ? info.webViewLoadStartTime : null, ((-1) & 131072) != 0 ? info.webViewLoadCompleteTime : null, ((-1) & 262144) != 0 ? info.webViewLoadFailTime : null, ((-1) & 524288) != 0 ? info.webViewLoadDuration : null, ((-1) & 1048576) != 0 ? info.productsLoadStartTime : null, ((-1) & 2097152) != 0 ? info.productsLoadCompleteTime : null, ((-1) & 4194304) != 0 ? info.productsLoadFailTime : null, ((-1) & 8388608) != 0 ? info.shimmerLoadStartTime : null, ((-1) & 16777216) != 0 ? info.shimmerLoadCompleteTime : null, ((-1) & 33554432) != 0 ? info.productsLoadDuration : null, ((-1) & 67108864) != 0 ? info.paywalljsVersion : null, ((-1) & 134217728) != 0 ? info.isFreeTrialAvailable : false, ((-1) & 268435456) != 0 ? info.featureGatingBehavior : null, ((-1) & 536870912) != 0 ? info.closeReason : null, ((-1) & 1073741824) != 0 ? info.localNotifications : null, ((-1) & Integer.MIN_VALUE) != 0 ? info.computedPropertyRequests : null, (191 & 1) != 0 ? info.surveys : null, (191 & 2) != 0 ? info.presentation : null, (191 & 4) != 0 ? info.buildId : null, (191 & 8) != 0 ? info.cacheKey : null, (191 & 16) != 0 ? info.isScrollEnabled : false, (191 & 32) != 0 ? info.state : null, (191 & 64) != 0 ? info.customerInfo : this.customerInfo, (191 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? info.presentationId : null);
    }

    public final boolean getInterceptTouchEvents() {
        return this.interceptTouchEvents;
    }

    public final Date getLastOpen() {
        return this.lastOpen;
    }

    public final PaywallLoadingState getLoadingState() {
        return this.loadingState;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final Paywall getPaywall() {
        return this.paywall;
    }

    public final PaywallResult getPaywallResult() {
        return this.paywallResult;
    }

    public final MutableSharedFlow<PaywallState> getPaywallStatePublisher() {
        return this.paywallStatePublisher;
    }

    public final boolean getPresentationDidFinishPrepare() {
        return this.presentationDidFinishPrepare;
    }

    public final boolean getPresentationIdOpened() {
        return this.presentationIdOpened;
    }

    public final PaywallPresentationStyle getPresentationStyle() {
        return this.presentationStyle;
    }

    public final boolean getPresentationWillPrepare() {
        return this.presentationWillPrepare;
    }

    public final PresentationRequest getRequest() {
        return this.request;
    }

    public final SurveyPresentationResult getSurveyPresentationResult() {
        return this.surveyPresentationResult;
    }

    public final TriggerRuleOccurrence getUnsavedOccurrence() {
        return this.unsavedOccurrence;
    }

    public final boolean getUseMultipleUrls() {
        return this.useMultipleUrls;
    }

    public final Function1<Boolean, Unit> getViewCreatedCompletion() {
        return this.viewCreatedCompletion;
    }

    public int hashCode() {
        int iHashCode = ((((this.paywall.hashCode() * 31) + this.locale.hashCode()) * 31) + this.customerInfo.hashCode()) * 31;
        PresentationRequest presentationRequest = this.request;
        int iHashCode2 = (((iHashCode + (presentationRequest == null ? 0 : presentationRequest.hashCode())) * 31) + this.presentationStyle.hashCode()) * 31;
        MutableSharedFlow<PaywallState> mutableSharedFlow = this.paywallStatePublisher;
        int iHashCode3 = (iHashCode2 + (mutableSharedFlow == null ? 0 : mutableSharedFlow.hashCode())) * 31;
        PaywallResult paywallResult = this.paywallResult;
        int iHashCode4 = (iHashCode3 + (paywallResult == null ? 0 : paywallResult.hashCode())) * 31;
        Function0<Unit> function0 = this.dismissCompletionBlock;
        int iHashCode5 = (((iHashCode4 + (function0 == null ? 0 : function0.hashCode())) * 31) + Boolean.hashCode(this.callbackInvoked)) * 31;
        Function1<Boolean, Unit> function1 = this.viewCreatedCompletion;
        int iHashCode6 = (((((((((((((((((((iHashCode5 + (function1 == null ? 0 : function1.hashCode())) * 31) + Boolean.hashCode(this.isBrowserViewPresented)) * 31) + Boolean.hashCode(this.interceptTouchEvents)) * 31) + this.surveyPresentationResult.hashCode()) * 31) + this.loadingState.hashCode()) * 31) + Boolean.hashCode(this.isPresented)) * 31) + Boolean.hashCode(this.closedForBackground)) * 31) + Boolean.hashCode(this.presentationWillPrepare)) * 31) + Boolean.hashCode(this.presentationDidFinishPrepare)) * 31) + Boolean.hashCode(this.didDisableSwipeForSurvey)) * 31;
        TriggerRuleOccurrence triggerRuleOccurrence = this.unsavedOccurrence;
        int iHashCode7 = (((((iHashCode6 + (triggerRuleOccurrence == null ? 0 : triggerRuleOccurrence.hashCode())) * 31) + Boolean.hashCode(this.useMultipleUrls)) * 31) + Integer.hashCode(this.crashRetries)) * 31;
        Date date = this.lastOpen;
        return ((iHashCode7 + (date != null ? date.hashCode() : 0)) * 31) + Boolean.hashCode(this.presentationIdOpened);
    }

    public final boolean isBrowserViewPresented() {
        return this.isBrowserViewPresented;
    }

    public final boolean isPresented() {
        return this.isPresented;
    }

    public String toString() {
        return StringsKt.p("PaywallViewState(\n            |  paywallId: " + this.paywall.getIdentifier() + "\n            |  presentationStyle: " + this.presentationStyle + "\n            |  loadingState: " + this.loadingState + "\n            |  isPresented: " + this.isPresented + "\n            |  closedForBackground: " + this.closedForBackground + "\n            |  presentationWillPrepare: " + this.presentationWillPrepare + "\n            |  presentationDidFinishPrepare: " + this.presentationDidFinishPrepare + "\n            |  callbackInvoked: " + this.callbackInvoked + "\n            |  isBrowserViewPresented: " + this.isBrowserViewPresented + "\n            |  interceptTouchEvents: " + this.interceptTouchEvents + "\n            |  surveyPresentationResult: " + this.surveyPresentationResult + "\n            |  paywallResult: " + this.paywallResult + "\n            |  hasRequest: " + (this.request != null) + "\n            |  hasStatePublisher: " + (this.paywallStatePublisher != null) + "\n            |  hasUnsavedOccurrence: " + (this.unsavedOccurrence != null) + "\n            |  hasViewCreatedCompletion: " + (this.viewCreatedCompletion != null) + "\n            |  hasDismissCompletionBlock: " + (this.dismissCompletionBlock != null) + "\n            |  useMultipleUrls: " + this.useMultipleUrls + "\n            |)\n        ", null, 1, null);
    }

    /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
        java.lang.NullPointerException
        */
    public /* synthetic */ PaywallViewState(com.superwall.sdk.models.paywall.Paywall r28, java.lang.String r29, com.superwall.sdk.models.customer.CustomerInfo r30, com.superwall.sdk.paywall.presentation.internal.PresentationRequest r31, com.superwall.sdk.models.paywall.PaywallPresentationStyle r32, kotlinx.coroutines.flow.MutableSharedFlow r33, com.superwall.sdk.paywall.presentation.internal.state.PaywallResult r34, kotlin.jvm.functions.Function0 r35, boolean r36, kotlin.jvm.functions.Function1 r37, boolean r38, boolean r39, com.superwall.sdk.paywall.view.survey.SurveyPresentationResult r40, com.superwall.sdk.paywall.view.delegate.PaywallLoadingState r41, boolean r42, boolean r43, boolean r44, boolean r45, boolean r46, com.superwall.sdk.models.triggers.TriggerRuleOccurrence r47, boolean r48, int r49, java.util.Date r50, boolean r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            Method dump skipped, instruction units count: 236
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.PaywallViewState.<init>(com.superwall.sdk.models.paywall.Paywall, java.lang.String, com.superwall.sdk.models.customer.CustomerInfo, com.superwall.sdk.paywall.presentation.internal.PresentationRequest, com.superwall.sdk.models.paywall.PaywallPresentationStyle, kotlinx.coroutines.flow.MutableSharedFlow, com.superwall.sdk.paywall.presentation.internal.state.PaywallResult, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function1, boolean, boolean, com.superwall.sdk.paywall.view.survey.SurveyPresentationResult, com.superwall.sdk.paywall.view.delegate.PaywallLoadingState, boolean, boolean, boolean, boolean, boolean, com.superwall.sdk.models.triggers.TriggerRuleOccurrence, boolean, int, java.util.Date, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
