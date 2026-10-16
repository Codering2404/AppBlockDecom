package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.material3.ColorScheme;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.core.os.LocaleListCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.google.android.gms.ads_identifier.mrU.pMpIcGE;
import com.revenuecat.purchases.CreateSupportTicketResult;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.ListenerConversionsCommonKt;
import com.revenuecat.purchases.Offering;
import com.revenuecat.purchases.Offerings;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.PurchasesException;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.SharedConstants;
import com.revenuecat.purchases.common.networking.RCHTTPStatusCodes;
import com.revenuecat.purchases.customercenter.CustomActionData;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.customercenter.CustomerCenterListener;
import com.revenuecat.purchases.customercenter.CustomerCenterManagementOption;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.ui.revenuecatui.OfferingSelection;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivity;
import com.revenuecat.purchases.ui.revenuecatui.activity.PaywallActivityArgs;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CreateSupportTicketData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.FeedbackSurveyData;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterNavigationState;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails;
import com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType;
import com.revenuecat.purchases.ui.revenuecatui.helpers.LocaleHelpersKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter;
import com.revenuecat.purchases.ui.revenuecatui.utils.DefaultDateFormatter;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpener;
import com.revenuecat.purchases.ui.revenuecatui.utils.URLOpeningMethod;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
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
public final class CustomerCenterViewModelImpl extends ViewModel implements CustomerCenterViewModel {
    private static final long STOP_FLOW_TIMEOUT = 5000;
    private final MutableState<PurchasesError> _actionError;
    private final MutableStateFlow<ColorScheme> _colorScheme;
    private final MutableStateFlow<LocaleListCompat> _lastLocaleList;
    private final MutableStateFlow<CustomerCenterState> _state;
    private final ColorScheme colorScheme;
    private final DateFormatter dateFormatter;
    private CustomerCenterImpressionEvent.CreationData impressionCreationData;
    private boolean isDarkMode;
    private final CustomerCenterListener listener;
    private final Locale locale;
    private final PurchasesType purchases;
    private boolean shouldRefreshOnResume;
    private final StateFlow<CustomerCenterState> state;
    private boolean wasBackgrounded;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CustomerCenterConfigData.HelpPath.PathType.values().length];
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.MISSING_PURCHASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CANCEL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CUSTOM_ACTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.REFUND_REQUEST.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.CHANGE_PLANS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[CustomerCenterConfigData.HelpPath.PathType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CustomerCenterConfigData.HelpPath.OpenMethod.values().length];
            try {
                iArr2[CustomerCenterConfigData.HelpPath.OpenMethod.IN_APP.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$createPurchaseInformation$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {797}, m = "createPurchaseInformation")
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.createPurchaseInformation(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$findTargetProduct$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {1257}, m = "findTargetProduct")
    static final class C25971 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C25971(Continuation<? super C25971> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.findTargetProduct(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$getPromotionalSubscriptionOption$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {1232}, m = "getPromotionalSubscriptionOption")
    static final class C25981 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C25981(Continuation<? super C25981> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.getPromotionalSubscriptionOption(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$handleSupportTicketSubmit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$handleSupportTicketSubmit$1", f = "CustomerCenterViewModel.kt", l = {RCHTTPStatusCodes.UNAUTHORIZED}, m = "invokeSuspend")
    static final class C25991 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $description;
        final /* synthetic */ String $email;
        final /* synthetic */ Function0<Unit> $onError;
        final /* synthetic */ Function0<Unit> $onSuccess;
        int label;
        final /* synthetic */ CustomerCenterViewModelImpl this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C25991(String str, String str2, CustomerCenterViewModelImpl customerCenterViewModelImpl, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super C25991> continuation) {
            super(2, continuation);
            this.$email = str;
            this.$description = str2;
            this.this$0 = customerCenterViewModelImpl;
            this.$onSuccess = function0;
            this.$onError = function02;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C25991(this.$email, this.$description, this.this$0, this.$onSuccess, this.$onError, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objAwaitCreateSupportTicket;
            Object value;
            Object objCopy$default;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    Logger.INSTANCE.d("Creating support ticket - email: " + this.$email + ", Description: " + this.$description);
                    PurchasesType purchasesType = this.this$0.purchases;
                    String str = this.$email;
                    String str2 = this.$description;
                    this.label = 1;
                    objAwaitCreateSupportTicket = purchasesType.awaitCreateSupportTicket(str, str2, this);
                    if (objAwaitCreateSupportTicket == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    objAwaitCreateSupportTicket = obj;
                }
                if (((CreateSupportTicketResult) objAwaitCreateSupportTicket).getSuccess()) {
                    Logger.INSTANCE.d("Support ticket created successfully");
                    MutableStateFlow mutableStateFlow = this.this$0._state;
                    do {
                        value = mutableStateFlow.getValue();
                        objCopy$default = (CustomerCenterState) value;
                        if (objCopy$default instanceof CustomerCenterState.Success) {
                            objCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) objCopy$default, null, null, null, null, null, null, ((CustomerCenterState.Success) objCopy$default).getNavigationState().pop(), ((CustomerCenterState.Success) objCopy$default).getNavigationState().pop().getCanNavigateBack() ? CustomerCenterState.NavigationButtonType.BACK : CustomerCenterState.NavigationButtonType.CLOSE, null, true, false, 1343, null);
                        }
                    } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
                    this.$onSuccess.invoke();
                } else {
                    Logger.INSTANCE.e("Support ticket creation returned false");
                    this.$onError.invoke();
                }
            } catch (PurchasesException e3) {
                Logger.INSTANCE.e("Error creating support ticket", e3);
                this.$onError.invoke();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C25991) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$launchRefreshIfPossible$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$launchRefreshIfPossible$1", f = "CustomerCenterViewModel.kt", l = {1109}, m = "invokeSuspend")
    static final class C26001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C26001(Continuation<? super C26001> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomerCenterViewModelImpl.this.new C26001(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                CustomerCenterViewModelImpl customerCenterViewModelImpl = CustomerCenterViewModelImpl.this;
                this.label = 1;
                if (customerCenterViewModelImpl.refreshCustomerCenter(this) == objF) {
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
            return ((C26001) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$loadAndDisplayPromotionalOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {862}, m = "loadAndDisplayPromotionalOffer")
    static final class C26011 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C26011(Continuation<? super C26011> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.loadAndDisplayPromotionalOffer(null, null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$loadCustomerCenter$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {1018, 1019, 1026, 1034}, m = "loadCustomerCenter")
    static final class AnonymousClass2 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.loadCustomerCenter(false, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$loadPurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {704, 719, 741}, m = "loadPurchases")
    static final class C26021 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C26021(Continuation<? super C26021> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.loadPurchases(null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$onAcceptedPromotionalOffer$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {906, 914}, m = "onAcceptedPromotionalOffer")
    static final class C26031 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C26031(Continuation<? super C26031> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.onAcceptedPromotionalOffer(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$2", f = "CustomerCenterViewModel.kt", l = {271}, m = "invokeSuspend")
    static final class C26042 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ CustomerCenterConfigData.HelpPath $path;
        final /* synthetic */ PurchaseInformation $purchaseInformation;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C26042(Context context, PurchaseInformation purchaseInformation, CustomerCenterConfigData.HelpPath helpPath, Continuation<? super C26042> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$purchaseInformation = purchaseInformation;
            this.$path = helpPath;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomerCenterViewModelImpl.this.new C26042(this.$context, this.$purchaseInformation, this.$path, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C26042 c26042;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                CustomerCenterViewModelImpl customerCenterViewModelImpl = CustomerCenterViewModelImpl.this;
                Context context = this.$context;
                PurchaseInformation purchaseInformation = this.$purchaseInformation;
                StoreProduct product = purchaseInformation != null ? purchaseInformation.getProduct() : null;
                CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer = this.$path.getPromotionalOffer();
                CustomerCenterConfigData.HelpPath helpPath = this.$path;
                PurchaseInformation purchaseInformation2 = this.$purchaseInformation;
                this.label = 1;
                c26042 = this;
                obj = customerCenterViewModelImpl.handlePromotionalOffer(context, product, promotionalOffer, helpPath, purchaseInformation2, c26042);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                c26042 = this;
            }
            if (!((Boolean) obj).booleanValue()) {
                CustomerCenterViewModelImpl.this.mainPathAction(c26042.$path, c26042.$context, c26042.$purchaseInformation);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C26042) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$restorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {544, 545, 561}, m = "restorePurchases")
    static final class C26051 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C26051(Continuation<? super C26051> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.restorePurchases(this);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl", f = "CustomerCenterViewModel.kt", l = {1473}, m = "shouldResumeRestorePurchases")
    static final class C26061 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C26061(Continuation<? super C26061> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CustomerCenterViewModelImpl.this.shouldResumeRestorePurchases(null, null, this);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CustomerCenterViewModelImpl(PurchasesType purchasesType, DateFormatter dateFormatter, Locale locale, ColorScheme colorScheme, boolean z2, CustomerCenterListener customerCenterListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        DateFormatter defaultDateFormatter = (i3 & 2) != 0 ? new DefaultDateFormatter() : dateFormatter;
        if ((i3 & 4) != 0) {
            locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        }
        this(purchasesType, defaultDateFormatter, locale, colorScheme, z2, (i3 & 32) != 0 ? null : customerCenterListener);
    }

    private final TransactionDetails.Subscription asTransactionDetails(SubscriptionInfo subscriptionInfo) {
        return new TransactionDetails.Subscription(subscriptionInfo.getProductIdentifier(), subscriptionInfo.getProductPlanIdentifier(), subscriptionInfo.getStore(), subscriptionInfo.isActive(), subscriptionInfo.getWillRenew(), subscriptionInfo.getExpiresDate(), subscriptionInfo.getPeriodType() == PeriodType.TRIAL, subscriptionInfo.getManagementURL(), subscriptionInfo.getPrice(), subscriptionInfo.isSandbox());
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.util.List<com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath> computeMainScreenPaths(com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState.Success r5) {
        /*
            r4 = this;
            java.util.List r0 = r5.getPurchases()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L3f
            java.util.List r0 = r5.getPurchases()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L20
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L20
            goto L3f
        L20:
            java.util.Iterator r0 = r0.iterator()
        L24:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3f
            java.lang.Object r1 = r0.next()
            com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation r1 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation) r1
            boolean r1 = r1.isExpired()
            if (r1 != 0) goto L24
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData r0 = r5.getCustomerCenterConfigData()
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Screen r0 = r0.getManagementScreen()
            goto L47
        L3f:
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData r0 = r5.getCustomerCenterConfigData()
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Screen r0 = r0.getNoActiveScreen()
        L47:
            r1 = 1
            if (r0 == 0) goto L6e
            java.util.List r2 = r5.getPurchases()
            int r2 = r2.size()
            if (r2 != r1) goto L5f
            java.util.List r2 = r5.getPurchases()
            java.lang.Object r2 = kotlin.collections.CollectionsKt.first(r2)
            com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation r2 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation) r2
            goto L60
        L5f:
            r2 = 0
        L60:
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData r3 = r5.getCustomerCenterConfigData()
            com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization r3 = r3.getLocalization()
            java.util.List r0 = r4.supportedPaths(r2, r0, r3)
            if (r0 != 0) goto L72
        L6e:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
        L72:
            java.util.List r5 = r5.getPurchases()
            int r5 = r5.size()
            if (r5 <= r1) goto L83
            com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils r5 = com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PathUtils.INSTANCE
            java.util.List r5 = r5.filterGeneralPaths(r0)
            return r5
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.computeMainScreenPaths(com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState$Success):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createPurchaseInformation(com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails r14, com.revenuecat.purchases.EntitlementInfo r15, com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter r16, java.util.Locale r17, com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r18, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation> r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 216
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.createPurchaseInformation(com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.TransactionDetails, com.revenuecat.purchases.EntitlementInfo, com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter, java.util.Locale, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void displayFeedbackSurvey(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey, Function1<? super CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit> function1) {
        Object value;
        Object objCopy$default;
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            objCopy$default = (CustomerCenterState) value;
            if (objCopy$default instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) objCopy$default;
                objCopy$default = CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().push(new CustomerCenterDestination.FeedbackSurvey(new FeedbackSurveyData(feedbackSurvey, function1), feedbackSurvey.getTitle())), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1855, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
    }

    private final List<TransactionDetails> findActiveTransactions(CustomerInfo customerInfo) {
        Object nonSubscription;
        Collection<SubscriptionInfo> collectionValues = customerInfo.getSubscriptionsByProductIdentifier().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            if (((SubscriptionInfo) obj).isActive()) {
                arrayList.add(obj);
            }
        }
        List listSortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$findActiveTransactions$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return ComparisonsKt.d(((SubscriptionInfo) t2).getExpiresDate(), ((SubscriptionInfo) t3).getExpiresDate());
            }
        });
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listSortedWith) {
            if (((SubscriptionInfo) obj2).getStore() == Store.PLAY_STORE) {
                arrayList2.add(obj2);
            }
        }
        List<Transaction> nonSubscriptionTransactions = customerInfo.getNonSubscriptionTransactions();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj3 : nonSubscriptionTransactions) {
            if (((Transaction) obj3).getStore() == Store.PLAY_STORE) {
                arrayList3.add(obj3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj4 : listSortedWith) {
            if (((SubscriptionInfo) obj4).getStore() != Store.PLAY_STORE) {
                arrayList4.add(obj4);
            }
        }
        List<Transaction> nonSubscriptionTransactions2 = customerInfo.getNonSubscriptionTransactions();
        ArrayList arrayList5 = new ArrayList();
        for (Object obj5 : nonSubscriptionTransactions2) {
            if (((Transaction) obj5).getStore() != Store.PLAY_STORE) {
                arrayList5.add(obj5);
            }
        }
        List listPlus = CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) CollectionsKt.plus((Collection) arrayList2, (Iterable) arrayList3), (Iterable) arrayList4), (Iterable) arrayList5);
        ArrayList arrayList6 = new ArrayList();
        for (Object obj6 : listPlus) {
            if (obj6 instanceof SubscriptionInfo) {
                nonSubscription = asTransactionDetails((SubscriptionInfo) obj6);
            } else if (obj6 instanceof Transaction) {
                Transaction transaction = (Transaction) obj6;
                nonSubscription = new TransactionDetails.NonSubscription(transaction.getProductIdentifier(), transaction.getStore(), transaction.getPrice(), transaction.isSandbox());
            } else {
                nonSubscription = null;
            }
            if (nonSubscription != null) {
                arrayList6.add(nonSubscription);
            }
        }
        return arrayList6;
    }

    private final TransactionDetails.Subscription findLatestExpiredSubscription(CustomerInfo customerInfo) {
        Object next;
        Collection<SubscriptionInfo> collectionValues = customerInfo.getSubscriptionsByProductIdentifier().values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            SubscriptionInfo subscriptionInfo = (SubscriptionInfo) obj;
            if (!subscriptionInfo.isActive() && subscriptionInfo.getExpiresDate() != null) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Date expiresDate = ((SubscriptionInfo) next).getExpiresDate();
                Intrinsics.checkNotNull(expiresDate);
                do {
                    Object next2 = it.next();
                    Date expiresDate2 = ((SubscriptionInfo) next2).getExpiresDate();
                    Intrinsics.checkNotNull(expiresDate2);
                    if (expiresDate.compareTo(expiresDate2) < 0) {
                        next = next2;
                        expiresDate = expiresDate2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        SubscriptionInfo subscriptionInfo2 = (SubscriptionInfo) next;
        if (subscriptionInfo2 != null) {
            return asTransactionDetails(subscriptionInfo2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object findTargetProduct(java.lang.String r11, java.lang.String r12, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.models.StoreProduct> r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.C25971
            if (r0 == 0) goto L13
            r0 = r13
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$findTargetProduct$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.C25971) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$findTargetProduct$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$findTargetProduct$1
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r13)
            goto L5e
        L29:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L31:
            kotlin.ResultKt.b(r13)
            java.lang.String r13 = ":"
            java.lang.String[] r5 = new java.lang.String[]{r13}
            r8 = 6
            r9 = 0
            r6 = 0
            r7 = 0
            r4 = r11
            java.util.List r11 = kotlin.text.StringsKt.V0(r4, r5, r6, r7, r8, r9)
            java.lang.Object r13 = kotlin.collections.CollectionsKt.first(r11)
            java.lang.String r13 = (java.lang.String) r13
            java.lang.Object r11 = kotlin.collections.CollectionsKt.getOrNull(r11, r3)
            java.lang.String r11 = (java.lang.String) r11
            if (r11 != 0) goto L52
            goto L53
        L52:
            r12 = r11
        L53:
            com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType r11 = r10.purchases
            r0.label = r3
            java.lang.Object r13 = r11.awaitGetProduct(r13, r12, r0)
            if (r13 != r1) goto L5e
            return r1
        L5e:
            com.revenuecat.purchases.models.StoreProduct r13 = (com.revenuecat.purchases.models.StoreProduct) r13
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.findTargetProduct(java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
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
            Intrinsics.checkNotNullExpressionValue(localeListCompatA, "{\n            val locale….create(locale)\n        }");
            return localeListCompatA;
        } catch (IllegalArgumentException unused) {
            Logger.INSTANCE.w("Invalid preferred locale format: " + preferredUILocaleOverride + ". Using system default.");
            LocaleListCompat localeListCompatE2 = LocaleListCompat.e();
            Intrinsics.checkNotNullExpressionValue(localeListCompatE2, "{\n            Logger.w(\"…at.getDefault()\n        }");
            return localeListCompatE2;
        }
    }

    private final SubscriptionOption getCustomerCenterSubscriptionOption(String str, StoreProduct storeProduct) {
        SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
        SubscriptionOption subscriptionOption = null;
        if (subscriptionOptions == null) {
            return null;
        }
        Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            SubscriptionOption next = it.next();
            SubscriptionOption subscriptionOption2 = next;
            if ((subscriptionOption2 instanceof GoogleSubscriptionOption) && subscriptionOption2.getTags().contains(SharedConstants.RC_CUSTOMER_CENTER_TAG) && Intrinsics.areEqual(((GoogleSubscriptionOption) subscriptionOption2).getOfferId(), str)) {
                subscriptionOption = next;
                break;
            }
        }
        return subscriptionOption;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0083 A[PHI: r2
      0x0083: PHI (r2v4 com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion) = 
      (r2v3 com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion)
      (r2v12 com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion)
      (r2v14 com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion)
     binds: [B:15:0x0054, B:19:0x0068, B:22:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getPromotionalSubscriptionOption(com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer r8, com.revenuecat.purchases.models.StoreProduct r9, kotlin.coroutines.Continuation<? super com.revenuecat.purchases.models.SubscriptionOption> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 276
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.getPromotionalSubscriptionOption(com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer, com.revenuecat.purchases.models.StoreProduct, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goBackToMain() {
        Object value;
        Object objResetToMainScreen;
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            objResetToMainScreen = (CustomerCenterState) value;
            if (objResetToMainScreen instanceof CustomerCenterState.Success) {
                objResetToMainScreen = resetToMainScreen((CustomerCenterState.Success) objResetToMainScreen);
            }
        } while (!mutableStateFlow.compareAndSet(value, objResetToMainScreen));
    }

    private final void handleCancelPath(Context context, PurchaseInformation purchaseInformation) {
        Object value = this._state.getValue();
        CustomerCenterState.Success success = value instanceof CustomerCenterState.Success ? (CustomerCenterState.Success) value : null;
        if (success == null) {
            return;
        }
        if (purchaseInformation == null) {
            CustomerCenterDestination currentDestination = success.getCurrentDestination();
            purchaseInformation = currentDestination instanceof CustomerCenterDestination.SelectedPurchaseDetail ? ((CustomerCenterDestination.SelectedPurchaseDetail) currentDestination).getPurchaseInformation() : success.getPurchases().size() == 1 ? (PurchaseInformation) CollectionsKt.first(success.getPurchases()) : null;
        }
        if ((purchaseInformation != null ? purchaseInformation.getStore() : null) == Store.PLAY_STORE && purchaseInformation.getProduct() != null) {
            startGoogleProductCancellation(context, purchaseInformation.getProduct());
            return;
        }
        if ((purchaseInformation != null ? purchaseInformation.getStore() : null) == Store.AMAZON && purchaseInformation.getManagementURL() != null) {
            startAmazonCancellation(context, purchaseInformation.getManagementURL());
            return;
        }
        if ((purchaseInformation != null ? purchaseInformation.getManagementURL() : null) != null) {
            startManagementUrlCancellation(context, purchaseInformation.getManagementURL());
        } else {
            Logger.INSTANCE.e("No product or management URL available for cancel path");
        }
    }

    static /* synthetic */ void handleCancelPath$default(CustomerCenterViewModelImpl customerCenterViewModelImpl, Context context, PurchaseInformation purchaseInformation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            purchaseInformation = null;
        }
        customerCenterViewModelImpl.handleCancelPath(context, purchaseInformation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handlePaywallError(String str, PurchasesErrorCode purchasesErrorCode) {
        Logger.INSTANCE.e(str);
        this._actionError.setValue(new PurchasesError(purchasesErrorCode, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object handlePromotionalOffer(Context context, StoreProduct storeProduct, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer, CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation, Continuation<? super Boolean> continuation) {
        return (storeProduct == null || promotionalOffer == null) ? Boxing.a(false) : loadAndDisplayPromotionalOffer(context, storeProduct, promotionalOffer, helpPath, purchaseInformation, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleSupportTicketSubmit(String str, String str2, Function0<Unit> function0, Function0<Unit> function02) {
        if (((CustomerCenterState) this._state.getValue()) instanceof CustomerCenterState.Success) {
            BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C25991(str, str2, this, function0, function02, null), 3, null);
        }
    }

    private final boolean isPathAllowedForStore(CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation) {
        switch (WhenMappings.$EnumSwitchMapping$0[helpPath.getType().ordinal()]) {
            case 2:
                if ((purchaseInformation != null ? purchaseInformation.getStore() : null) != Store.PLAY_STORE) {
                    if ((purchaseInformation != null ? purchaseInformation.getManagementURL() : null) == null) {
                        return false;
                    }
                }
            case 1:
            case 3:
            case 4:
                return true;
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final boolean isPathAllowedForSubscriptionState(CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation) {
        if (helpPath.getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL) {
            return (purchaseInformation == null || !purchaseInformation.isSubscription() || purchaseInformation.isExpired()) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void launchPaywallActivity(Context context, Offering offering) {
        try {
            Logger logger = Logger.INSTANCE;
            logger.d("Showing paywall for offering: " + offering.getIdentifier());
            String identifier = offering.getIdentifier();
            Package r3 = (Package) CollectionsKt.firstOrNull((List) offering.getAvailablePackages());
            PaywallActivityArgs paywallActivityArgs = new PaywallActivityArgs((String) null, new OfferingSelection.IdAndPresentedOfferingContext(identifier, r3 != null ? r3.getPresentedOfferingContext() : null), (Map) null, true, false, false, (Map) null, (Integer) null, 245, (DefaultConstructorMarker) null);
            Intent intent = new Intent(context, (Class<?>) PaywallActivity.class);
            intent.putExtra(PaywallActivity.ARGS_EXTRA, paywallActivityArgs);
            intent.addFlags(268435456);
            context.startActivity(intent);
            logger.d("Successfully launched paywall for offering: " + offering.getIdentifier());
        } catch (ActivityNotFoundException e3) {
            handlePaywallError("PaywallActivity not found: " + e3.getMessage(), PurchasesErrorCode.ConfigurationError);
        } catch (IllegalArgumentException e4) {
            handlePaywallError("Invalid argument for paywall: " + e4.getMessage(), PurchasesErrorCode.UnknownError);
        } catch (SecurityException e5) {
            handlePaywallError("Security error launching paywall: " + e5.getMessage(), PurchasesErrorCode.UnknownError);
        }
    }

    private final void launchRefreshIfPossible() {
        CustomerCenterState customerCenterState = (CustomerCenterState) this._state.getValue();
        if (!(customerCenterState instanceof CustomerCenterState.Success) || ((CustomerCenterState.Success) customerCenterState).isRefreshing()) {
            return;
        }
        BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C26001(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0206, code lost:
    
        if (r1 == r2) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x016f -> B:52:0x0174). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object loadPurchases(com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter r18, java.util.Locale r19, com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Localization r20, kotlin.coroutines.Continuation<? super java.util.List<com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation>> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.loadPurchases(com.revenuecat.purchases.ui.revenuecatui.utils.DateFormatter, java.util.Locale, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$Localization, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mainPathAction(CustomerCenterConfigData.HelpPath helpPath, Context context, PurchaseInformation purchaseInformation) {
        Object value;
        Object objCopy$default;
        String actionIdentifier;
        StoreProduct product;
        int i3 = WhenMappings.$EnumSwitchMapping$0[helpPath.getType().ordinal()];
        if (i3 == 1) {
            MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
            do {
                value = mutableStateFlow.getValue();
                objCopy$default = (CustomerCenterState) value;
                if (objCopy$default instanceof CustomerCenterState.Success) {
                    objCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) objCopy$default, null, null, null, null, RestorePurchasesState.RESTORING, null, null, null, null, false, false, 2031, null);
                }
            } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
            return;
        }
        if (i3 == 2) {
            handleCancelPath(context, purchaseInformation);
            return;
        }
        if (i3 != 3) {
            if (i3 == 4 && (actionIdentifier = helpPath.getActionIdentifier()) != null) {
                onCustomActionSelected(new CustomActionData(actionIdentifier, (purchaseInformation == null || (product = purchaseInformation.getProduct()) == null) ? null : product.getId()));
                return;
            }
            return;
        }
        String url = helpPath.getUrl();
        if (url != null) {
            CustomerCenterConfigData.HelpPath.OpenMethod openMethod = helpPath.getOpenMethod();
            if (openMethod == null) {
                openMethod = CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL;
            }
            openURL(context, url, openMethod);
        }
    }

    static /* synthetic */ void mainPathAction$default(CustomerCenterViewModelImpl customerCenterViewModelImpl, CustomerCenterConfigData.HelpPath helpPath, Context context, PurchaseInformation purchaseInformation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            purchaseInformation = null;
        }
        customerCenterViewModelImpl.mainPathAction(helpPath, context, purchaseInformation);
    }

    private final void notifyListenersForCustomActionSelected(CustomActionData customActionData) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onCustomActionSelected(customActionData.getActionIdentifier(), customActionData.getPurchaseIdentifier());
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onCustomActionSelected(customActionData.getActionIdentifier(), customActionData.getPurchaseIdentifier());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyListenersForFeedbackSurveyCompleted(String str) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onFeedbackSurveyCompleted(str);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onFeedbackSurveyCompleted(str);
        }
    }

    private final void notifyListenersForManageSubscription() {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onShowingManageSubscriptions();
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onShowingManageSubscriptions();
        }
    }

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
    private final void notifyListenersForManagementOptionSelected(CustomerCenterConfigData.HelpPath helpPath, PurchaseInformation purchaseInformation) {
        CustomerCenterManagementOption customUrl;
        String actionIdentifier;
        StoreProduct product;
        int i3 = WhenMappings.$EnumSwitchMapping$0[helpPath.getType().ordinal()];
        if (i3 == 1) {
            customUrl = CustomerCenterManagementOption.MissingPurchase.INSTANCE;
        } else if (i3 != 2) {
            customUrl = null;
            id = null;
            String id = null;
            customUrl = null;
            customUrl = null;
            if (i3 == 3) {
                String url = helpPath.getUrl();
                if (url != null) {
                    customUrl = new CustomerCenterManagementOption.CustomUrl(Uri.parse(url));
                }
            } else if (i3 == 4 && (actionIdentifier = helpPath.getActionIdentifier()) != null) {
                if (purchaseInformation != null && (product = purchaseInformation.getProduct()) != null) {
                    id = product.getId();
                }
                customUrl = new CustomerCenterManagementOption.CustomAction(actionIdentifier, id);
            }
        } else {
            customUrl = CustomerCenterManagementOption.Cancel.INSTANCE;
        }
        if (customUrl != null) {
            CustomerCenterListener customerCenterListener = this.listener;
            if (customerCenterListener != null) {
                customerCenterListener.onManagementOptionSelected(customUrl);
            }
            CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
            if (customerCenterListener2 != null) {
                customerCenterListener2.onManagementOptionSelected(customUrl);
            }
        }
    }

    private final void notifyListenersForPromotionalOfferSucceeded(CustomerInfo customerInfo, StoreTransaction storeTransaction) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onPromotionalOfferSucceeded(customerInfo, storeTransaction);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onPromotionalOfferSucceeded(customerInfo, storeTransaction);
        }
    }

    private final void notifyListenersForRestoreCompleted(CustomerInfo customerInfo) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onRestoreCompleted(customerInfo);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onRestoreCompleted(customerInfo);
        }
    }

    private final void notifyListenersForRestoreFailed(PurchasesError purchasesError) {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onRestoreFailed(purchasesError);
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onRestoreFailed(purchasesError);
        }
    }

    private final void notifyListenersForRestoreStarted() {
        CustomerCenterListener customerCenterListener = this.listener;
        if (customerCenterListener != null) {
            customerCenterListener.onRestoreStarted();
        }
        CustomerCenterListener customerCenterListener2 = this.purchases.getCustomerCenterListener();
        if (customerCenterListener2 != null) {
            customerCenterListener2.onRestoreStarted();
        }
    }

    private final CustomerCenterState.Success preservingUIStateIfRefresh(CustomerCenterState.Success success, boolean z2, CustomerCenterState customerCenterState) {
        if (!z2 || !(customerCenterState instanceof CustomerCenterState.Success)) {
            return success;
        }
        CustomerCenterState.Success success2 = (CustomerCenterState.Success) customerCenterState;
        CustomerCenterNavigationState navigationState = success2.getNavigationState();
        CustomerCenterState.NavigationButtonType navigationButtonType = customerCenterState.getNavigationButtonType();
        return CustomerCenterState.Success.copy$default(success, null, null, null, success2.getDetailScreenPaths(), success2.getRestorePurchasesState(), null, navigationState, navigationButtonType, null, success2.getShowSupportTicketSuccessSnackbar(), false, 1319, null);
    }

    private final CustomerCenterState.Success resetToMainScreen(CustomerCenterState.Success success) {
        return CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().popToMain(), CustomerCenterState.NavigationButtonType.CLOSE, null, false, false, 1839, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object shouldResumeRestorePurchases(com.revenuecat.purchases.customercenter.CustomerCenterListener r7, java.lang.String r8, kotlin.coroutines.Continuation<? super java.lang.Boolean> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.C26061
            if (r0 == 0) goto L13
            r0 = r9
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.C26061) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            com.revenuecat.purchases.customercenter.CustomerCenterListener r7 = (com.revenuecat.purchases.customercenter.CustomerCenterListener) r7
            kotlin.ResultKt.b(r9)
            goto L90
        L31:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L39:
            kotlin.ResultKt.b(r9)
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            kotlinx.coroutines.CancellableContinuationImpl r9 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)
            r9.<init>(r2, r3)
            r9.C()
            com.revenuecat.purchases.ui.revenuecatui.helpers.Logger r2 = com.revenuecat.purchases.ui.revenuecatui.helpers.Logger.INSTANCE
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Restore Purchases Initiated… waiting for "
            r4.append(r5)
            r4.append(r8)
            java.lang.String r8 = " to proceed."
            r4.append(r8)
            java.lang.String r8 = r4.toString()
            r2.d(r8)
            if (r7 == 0) goto L76
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$shouldResume$1$1 r8 = new com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$shouldResumeRestorePurchases$shouldResume$1$1
            r8.<init>()
            r7.onRestoreInitiated(r8)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            goto L77
        L76:
            r7 = 0
        L77:
            if (r7 != 0) goto L80
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r3)
            com.revenuecat.purchases.ui.revenuecatui.helpers.CancellableContinuationExtensionsKt.safeResume(r9, r7)
        L80:
            java.lang.Object r9 = r9.v()
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            if (r9 != r7) goto L8d
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)
        L8d:
            if (r9 != r1) goto L90
            return r1
        L90:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r7 = r9.booleanValue()
            if (r7 == 0) goto L9b
            java.lang.String r8 = "will"
            goto L9d
        L9b:
            java.lang.String r8 = "will not"
        L9d:
            com.revenuecat.purchases.ui.revenuecatui.helpers.Logger r9 = com.revenuecat.purchases.ui.revenuecatui.helpers.Logger.INSTANCE
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Restore Purchases gate complete. The SDK **"
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = "** attempt to restore purchases."
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            r9.d(r8)
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.a(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.shouldResumeRestorePurchases(com.revenuecat.purchases.customercenter.CustomerCenterListener, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void showManageSubscriptions(Context context, String str) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/account/subscriptions?sku=" + str + "&package=" + context.getPackageName())));
        } catch (ActivityNotFoundException e3) {
            Logger.INSTANCE.e("Error opening manage subscriptions", e3);
        }
    }

    private final void startAmazonCancellation(Context context, Uri uri) {
        this.shouldRefreshOnResume = true;
        notifyListenersForManageSubscription();
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("amzn://apps/library/subscriptions")));
        } catch (ActivityNotFoundException unused) {
            String string = uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "managementURL.toString()");
            openURL(context, string, CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL);
        }
    }

    private final void startGoogleProductCancellation(Context context, StoreProduct storeProduct) {
        GoogleStoreProduct googleStoreProduct = storeProduct instanceof GoogleStoreProduct ? (GoogleStoreProduct) storeProduct : null;
        if (googleStoreProduct == null) {
            Logger.INSTANCE.e("Expected GoogleStoreProduct for Play Store cancellation");
            return;
        }
        this.shouldRefreshOnResume = true;
        notifyListenersForManageSubscription();
        showManageSubscriptions(context, googleStoreProduct.getProductId());
    }

    private final void startManagementUrlCancellation(Context context, Uri uri) {
        this.shouldRefreshOnResume = true;
        notifyListenersForManageSubscription();
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "managementURL.toString()");
        openURL(context, string, CustomerCenterConfigData.HelpPath.OpenMethod.EXTERNAL);
    }

    private final List<CustomerCenterConfigData.HelpPath> supportedPaths(PurchaseInformation purchaseInformation, CustomerCenterConfigData.Screen screen, CustomerCenterConfigData.Localization localization) {
        List<CustomerCenterConfigData.HelpPath> paths = screen.getPaths();
        ArrayList arrayList = new ArrayList();
        for (Object obj : paths) {
            if (isPathAllowedForStore((CustomerCenterConfigData.HelpPath) obj, purchaseInformation)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            if (isPathAllowedForSubscriptionState((CustomerCenterConfigData.HelpPath) obj2, purchaseInformation)) {
                arrayList2.add(obj2);
            }
        }
        return transformPathsOnSubscriptionState(arrayList2, purchaseInformation, localization);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackCustomerCenterEventOptionChosen(CustomerCenterConfigData.HelpPath.PathType pathType, String str, String str2) {
        Locale localeD = ((LocaleListCompat) this._lastLocaleList.getValue()).d(0);
        if (localeD == null) {
            localeD = Locale.getDefault();
        }
        Date date = new Date();
        boolean z2 = this.isDarkMode;
        String string = localeD.toString();
        Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
        this.purchases.track(new CustomerCenterSurveyOptionChosenEvent(null, new CustomerCenterSurveyOptionChosenEvent.Data(date, z2, string, 0, 0, null, pathType, str, str2, null, 568, null), 1, null));
    }

    private final List<CustomerCenterConfigData.HelpPath> transformPathsOnSubscriptionState(List<CustomerCenterConfigData.HelpPath> list, PurchaseInformation purchaseInformation, CustomerCenterConfigData.Localization localization) {
        List<CustomerCenterConfigData.HelpPath> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (CustomerCenterConfigData.HelpPath helpPathCopy$default : list2) {
            if (helpPathCopy$default.getType() == CustomerCenterConfigData.HelpPath.PathType.CANCEL && purchaseInformation != null && purchaseInformation.isCancelled()) {
                helpPathCopy$default = CustomerCenterConfigData.HelpPath.copy$default(helpPathCopy$default, null, localization.commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.RESUBSCRIBE), null, null, null, null, null, null, 229, null);
            }
            arrayList.add(helpPathCopy$default);
        }
        return arrayList;
    }

    private final void tryFallbackToCurrentOffering(final Context context) {
        ListenerConversionsCommonKt.getOfferingsWith(Purchases.Companion.getSharedInstance(), new Function1<PurchasesError, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.tryFallbackToCurrentOffering.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((PurchasesError) obj);
                return Unit.f139807a;
            }

            public final void invoke(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                CustomerCenterViewModelImpl.this.handlePaywallError("Failed to get current offering: " + error.getMessage(), error.getCode());
            }
        }, new Function1<Offerings, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.tryFallbackToCurrentOffering.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Offerings) obj);
                return Unit.f139807a;
            }

            public final void invoke(Offerings offerings) {
                Intrinsics.checkNotNullParameter(offerings, "offerings");
                Offering current = offerings.getCurrent();
                if (current == null) {
                    CustomerCenterViewModelImpl.this.handlePaywallError("No offering available for paywall presentation", PurchasesErrorCode.ConfigurationError);
                    return;
                }
                Logger.INSTANCE.d("Falling back to current offering: " + current.getIdentifier());
                CustomerCenterViewModelImpl.this.launchPaywallActivity(context, current);
            }
        });
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void clearActionError() {
        this._actionError.setValue(null);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void dismissPromotionalOffer(Context context, CustomerCenterConfigData.HelpPath originalPath) {
        Object value;
        Object objCopy$default;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(originalPath, "originalPath");
        Object value2 = this._state.getValue();
        CustomerCenterState.Success success = value2 instanceof CustomerCenterState.Success ? (CustomerCenterState.Success) value2 : null;
        CustomerCenterDestination currentDestination = success != null ? success.getCurrentDestination() : null;
        mainPathAction(originalPath, context, currentDestination instanceof CustomerCenterDestination.PromotionalOffer ? ((CustomerCenterDestination.PromotionalOffer) currentDestination).getPurchaseInformation() : null);
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            objCopy$default = (CustomerCenterState) value;
            if (objCopy$default instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success2 = (CustomerCenterState.Success) objCopy$default;
                objCopy$default = CustomerCenterState.Success.copy$default(success2, null, null, null, null, null, null, success2.getNavigationState().popToMain(), CustomerCenterState.NavigationButtonType.CLOSE, null, false, false, 1855, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public Object dismissRestoreDialog(Continuation<? super Unit> continuation) throws Throwable {
        Object objLoadCustomerCenter = loadCustomerCenter(continuation);
        return objLoadCustomerCenter == IntrinsicsKt.f() ? objLoadCustomerCenter : Unit.f139807a;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void dismissSupportTicketSuccessSnackbar() {
        Object value;
        Object objCopy$default;
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            objCopy$default = (CustomerCenterState) value;
            if (objCopy$default instanceof CustomerCenterState.Success) {
                objCopy$default = CustomerCenterState.Success.copy$default((CustomerCenterState.Success) objCopy$default, null, null, null, null, null, null, null, null, null, false, false, 1535, null);
            }
        } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public State<PurchasesError> getActionError() {
        return this._actionError;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public StateFlow<CustomerCenterState> getState() {
        return this.state;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object loadAndDisplayPromotionalOffer(android.content.Context r28, com.revenuecat.purchases.models.StoreProduct r29, com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer r30, com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath r31, com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation r32, kotlin.coroutines.Continuation<? super java.lang.Boolean> r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 269
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.loadAndDisplayPromotionalOffer(android.content.Context, com.revenuecat.purchases.models.StoreProduct, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer, com.revenuecat.purchases.customercenter.CustomerCenterConfigData$HelpPath, com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public Object loadCustomerCenter(Continuation<? super Unit> continuation) throws Throwable {
        Object objLoadCustomerCenter = loadCustomerCenter(false, continuation);
        return objLoadCustomerCenter == IntrinsicsKt.f() ? objLoadCustomerCenter : Unit.f139807a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
    
        if (r6.loadCustomerCenter(r0) == r1) goto L33;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object onAcceptedPromotionalOffer(com.revenuecat.purchases.models.SubscriptionOption r6, android.app.Activity r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.C26031
            if (r0 == 0) goto L13
            r0 = r8
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$onAcceptedPromotionalOffer$1 r0 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.C26031) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$onAcceptedPromotionalOffer$1 r0 = new com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$onAcceptedPromotionalOffer$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L43
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.L$0
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl r6 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl) r6
            kotlin.ResultKt.b(r8)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            goto La1
        L31:
            r7 = move-exception
            goto L8d
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            java.lang.Object r6 = r0.L$0
            com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl r6 = (com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl) r6
            kotlin.ResultKt.b(r8)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            goto L73
        L43:
            kotlin.ResultKt.b(r8)
            if (r7 != 0) goto L60
            com.revenuecat.purchases.ui.revenuecatui.helpers.Logger r6 = com.revenuecat.purchases.ui.revenuecatui.helpers.Logger.INSTANCE
            java.lang.String r7 = "Activity is null when accepting promotional offer"
            r6.e(r7)
            androidx.compose.runtime.MutableState<com.revenuecat.purchases.PurchasesError> r6 = r5._actionError
            com.revenuecat.purchases.PurchasesError r7 = new com.revenuecat.purchases.PurchasesError
            com.revenuecat.purchases.PurchasesErrorCode r8 = com.revenuecat.purchases.PurchasesErrorCode.PurchaseInvalidError
            java.lang.String r0 = "Couldn't perform purchase"
            r7.<init>(r8, r0)
            r6.setValue(r7)
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L60:
            com.revenuecat.purchases.PurchaseParams$Builder r8 = new com.revenuecat.purchases.PurchaseParams$Builder
            r8.<init>(r7, r6)
            com.revenuecat.purchases.ui.revenuecatui.data.PurchasesType r6 = r5.purchases     // Catch: com.revenuecat.purchases.PurchasesException -> L8b
            r0.L$0 = r5     // Catch: com.revenuecat.purchases.PurchasesException -> L8b
            r0.label = r4     // Catch: com.revenuecat.purchases.PurchasesException -> L8b
            java.lang.Object r8 = r6.awaitPurchase(r8, r0)     // Catch: com.revenuecat.purchases.PurchasesException -> L8b
            if (r8 != r1) goto L72
            goto L8a
        L72:
            r6 = r5
        L73:
            com.revenuecat.purchases.PurchaseResult r8 = (com.revenuecat.purchases.PurchaseResult) r8     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            com.revenuecat.purchases.CustomerInfo r7 = r8.getCustomerInfo()     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            com.revenuecat.purchases.models.StoreTransaction r8 = r8.getStoreTransaction()     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            r6.notifyListenersForPromotionalOfferSucceeded(r7, r8)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            r0.L$0 = r6     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            r0.label = r3     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            java.lang.Object r6 = r6.loadCustomerCenter(r0)     // Catch: com.revenuecat.purchases.PurchasesException -> L31
            if (r6 != r1) goto La1
        L8a:
            return r1
        L8b:
            r7 = move-exception
            r6 = r5
        L8d:
            com.revenuecat.purchases.PurchasesErrorCode r8 = r7.getCode()
            com.revenuecat.purchases.PurchasesErrorCode r0 = com.revenuecat.purchases.PurchasesErrorCode.PurchaseCancelledError
            if (r8 == r0) goto La1
            androidx.compose.runtime.MutableState<com.revenuecat.purchases.PurchasesError> r8 = r6._actionError
            com.revenuecat.purchases.PurchasesError r7 = r7.getError()
            r8.setValue(r7)
            r6.goBackToMain()
        La1:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.onAcceptedPromotionalOffer(com.revenuecat.purchases.models.SubscriptionOption, android.app.Activity, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onActivityResumed() {
        if (this.shouldRefreshOnResume) {
            this.shouldRefreshOnResume = false;
            Logger.INSTANCE.d("Refreshing Customer Center after returning from manage subscriptions");
            launchRefreshIfPossible();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onActivityStarted() {
        if (this.wasBackgrounded) {
            this.wasBackgrounded = false;
            if (this.shouldRefreshOnResume) {
                return;
            }
            launchRefreshIfPossible();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onActivityStopped(boolean z2) {
        if (z2) {
            return;
        }
        this.wasBackgrounded = true;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onCustomActionSelected(CustomActionData customActionData) {
        Intrinsics.checkNotNullParameter(customActionData, "customActionData");
        notifyListenersForCustomActionSelected(customActionData);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void onNavigationButtonPressed(Context context, Function0<Unit> onDismiss) {
        Object value;
        Object objCopy$default;
        CustomerCenterState.NavigationButtonType navigationButtonType;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onDismiss, "onDismiss");
        CustomerCenterState customerCenterState = (CustomerCenterState) this._state.getValue();
        if (customerCenterState instanceof CustomerCenterState.Success) {
            CustomerCenterState.Success success = (CustomerCenterState.Success) customerCenterState;
            if (success.getCurrentDestination() instanceof CustomerCenterDestination.PromotionalOffer) {
                CustomerCenterDestination currentDestination = success.getCurrentDestination();
                Intrinsics.checkNotNull(currentDestination, "null cannot be cast to non-null type com.revenuecat.purchases.ui.revenuecatui.customercenter.navigation.CustomerCenterDestination.PromotionalOffer");
                dismissPromotionalOffer(context, ((CustomerCenterDestination.PromotionalOffer) currentDestination).getData().getOriginalPath());
                return;
            }
        }
        CustomerCenterState.NavigationButtonType navigationButtonType2 = ((CustomerCenterState) getState().getValue()).getNavigationButtonType();
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            CustomerCenterState customerCenterState2 = (CustomerCenterState) value;
            if ((customerCenterState2 instanceof CustomerCenterState.Success) && navigationButtonType2 == (navigationButtonType = CustomerCenterState.NavigationButtonType.BACK)) {
                CustomerCenterState.Success success2 = (CustomerCenterState.Success) customerCenterState2;
                if (success2.getNavigationState().getCanNavigateBack()) {
                    CustomerCenterNavigationState customerCenterNavigationStatePop = success2.getNavigationState().pop();
                    if (!customerCenterNavigationStatePop.getCanNavigateBack()) {
                        navigationButtonType = CustomerCenterState.NavigationButtonType.CLOSE;
                    }
                    objCopy$default = CustomerCenterState.Success.copy$default(success2, null, null, null, null, null, null, customerCenterNavigationStatePop, navigationButtonType, null, false, false, 1855, null);
                } else {
                    objCopy$default = CustomerCenterState.NotLoaded.INSTANCE;
                }
            } else {
                objCopy$default = CustomerCenterState.NotLoaded.INSTANCE;
            }
        } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
        if (navigationButtonType2 == CustomerCenterState.NavigationButtonType.CLOSE) {
            onDismiss.invoke();
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void openURL(Context context, String url, CustomerCenterConfigData.HelpPath.OpenMethod method) {
        URLOpeningMethod uRLOpeningMethod;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        int i3 = WhenMappings.$EnumSwitchMapping$1[method.ordinal()];
        if (i3 == 1) {
            uRLOpeningMethod = URLOpeningMethod.IN_APP_BROWSER;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            uRLOpeningMethod = URLOpeningMethod.EXTERNAL_BROWSER;
        }
        URLOpener.INSTANCE.openURL$revenuecatui_defaultsBc8Release(context, url, uRLOpeningMethod);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void pathButtonPressed(final Context context, final CustomerCenterConfigData.HelpPath path, final PurchaseInformation purchaseInformation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(path, "path");
        notifyListenersForManagementOptionSelected(path, purchaseInformation);
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey = path.getFeedbackSurvey();
        if (feedbackSurvey != null) {
            displayFeedbackSurvey(feedbackSurvey, new Function1<CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option) obj);
                    return Unit.f139807a;
                }

                public final void invoke(CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option) {
                    if (option != null) {
                        CustomerCenterViewModelImpl customerCenterViewModelImpl = this.this$0;
                        CustomerCenterConfigData.HelpPath helpPath = path;
                        Context context2 = context;
                        PurchaseInformation purchaseInformation2 = purchaseInformation;
                        customerCenterViewModelImpl.trackCustomerCenterEventOptionChosen(helpPath.getType(), helpPath.getUrl(), option.getId());
                        customerCenterViewModelImpl.notifyListenersForFeedbackSurveyCompleted(option.getId());
                        if (BuildersKt__Builders_commonKt.d(ViewModelKt.a(customerCenterViewModelImpl), null, null, new CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1(customerCenterViewModelImpl, context2, purchaseInformation2, option, helpPath, null), 3, null) != null) {
                            return;
                        }
                    }
                    this.this$0.goBackToMain();
                    Unit unit = Unit.f139807a;
                }
            });
        } else {
            BuildersKt__Builders_commonKt.d(ViewModelKt.a(this), null, null, new C26042(context, purchaseInformation, path, null), 3, null);
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void refreshColors(ColorScheme currentColorScheme, boolean z2) {
        Intrinsics.checkNotNullParameter(currentColorScheme, "currentColorScheme");
        this.isDarkMode = z2;
        this._colorScheme.setValue(currentColorScheme);
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public Object refreshCustomerCenter(Continuation<? super Unit> continuation) throws Throwable {
        Object objLoadCustomerCenter = loadCustomerCenter(true, continuation);
        return objLoadCustomerCenter == IntrinsicsKt.f() ? objLoadCustomerCenter : Unit.f139807a;
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void refreshStateIfLocaleChanged() {
        LocaleListCompat currentLocaleList = getCurrentLocaleList();
        if (Intrinsics.areEqual(this._lastLocaleList.getValue(), currentLocaleList)) {
            return;
        }
        this._lastLocaleList.setValue(currentLocaleList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0121, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0122, code lost:
    
        r2 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x013e, code lost:
    
        r2 = com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState.Success.copy$default((com.revenuecat.purchases.ui.revenuecatui.customercenter.data.CustomerCenterState.Success) r2, null, null, null, null, com.revenuecat.purchases.ui.revenuecatui.customercenter.dialogs.RestorePurchasesState.PURCHASES_NOT_FOUND, null, null, null, null, false, false, 2031, null);
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f8 A[Catch: PurchasesException -> 0x0038, TryCatch #1 {PurchasesException -> 0x0038, blocks: (B:14:0x0033, B:44:0x00cc, B:46:0x00da, B:50:0x00e8, B:51:0x00ed, B:53:0x00f8, B:55:0x00fd, B:58:0x0104, B:57:0x0101, B:59:0x011a), top: B:76:0x0033 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object restorePurchases(kotlin.coroutines.Continuation<? super kotlin.Unit> r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl.restorePurchases(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void selectPurchase(PurchaseInformation purchase) {
        Object value;
        Object error;
        Intrinsics.checkNotNullParameter(purchase, "purchase");
        MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
        do {
            value = mutableStateFlow.getValue();
            error = (CustomerCenterState) value;
            if (error instanceof CustomerCenterState.Success) {
                CustomerCenterState.Success success = (CustomerCenterState.Success) error;
                CustomerCenterConfigData.Screen managementScreen = success.getCustomerCenterConfigData().getManagementScreen();
                if (managementScreen != null) {
                    error = CustomerCenterState.Success.copy$default(success, null, null, null, PathUtils.INSTANCE.filterSubscriptionSpecificPaths(supportedPaths(purchase, managementScreen, success.getCustomerCenterConfigData().getLocalization())), null, null, success.getNavigationState().push(new CustomerCenterDestination.SelectedPurchaseDetail(purchase, managementScreen.getTitle())), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1847, null);
                } else {
                    Logger.INSTANCE.e("No management screen available in the customer center config data");
                    error = new CustomerCenterState.Error(new PurchasesError(PurchasesErrorCode.UnknownError, "No management screen available in the customer center config data"));
                }
            }
        } while (!mutableStateFlow.compareAndSet(value, error));
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void showCreateSupportTicket() {
        Object value;
        Object objCopy$default;
        CustomerCenterState customerCenterState = (CustomerCenterState) this._state.getValue();
        if (customerCenterState instanceof CustomerCenterState.Success) {
            MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
            do {
                value = mutableStateFlow.getValue();
                objCopy$default = (CustomerCenterState) value;
                if (objCopy$default instanceof CustomerCenterState.Success) {
                    CustomerCenterState.Success success = (CustomerCenterState.Success) objCopy$default;
                    objCopy$default = CustomerCenterState.Success.copy$default(success, null, null, null, null, null, null, success.getNavigationState().push(new CustomerCenterDestination.CreateSupportTicket(new CreateSupportTicketData(new Function4<String, String, Function0<? extends Unit>, Function0<? extends Unit>, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$showCreateSupportTicket$1$createSupportTicketDestination$1
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                            invoke((String) obj, (String) obj2, (Function0<Unit>) obj3, (Function0<Unit>) obj4);
                            return Unit.f139807a;
                        }

                        public final void invoke(String email, String description, Function0<Unit> onSuccess, Function0<Unit> onError) {
                            Intrinsics.checkNotNullParameter(email, "email");
                            Intrinsics.checkNotNullParameter(description, "description");
                            Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
                            Intrinsics.checkNotNullParameter(onError, "onError");
                            this.this$0.handleSupportTicketSubmit(email, description, onSuccess, onError);
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$showCreateSupportTicket$1$createSupportTicketDestination$2
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1007invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1007invoke() {
                            this.this$0.goBackToMain();
                        }
                    }, new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$showCreateSupportTicket$1$createSupportTicketDestination$3
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m1008invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m1008invoke() {
                            this.this$0.goBackToMain();
                        }
                    }), ((CustomerCenterState.Success) customerCenterState).getCustomerCenterConfigData().getLocalization().commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.SUPPORT_TICKET_CREATE))), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1855, null);
                }
            } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void showPaywall(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CustomerCenterState customerCenterState = (CustomerCenterState) this._state.getValue();
        if (customerCenterState instanceof CustomerCenterState.Success) {
            Offering noActiveScreenOffering = ((CustomerCenterState.Success) customerCenterState).getNoActiveScreenOffering();
            if (noActiveScreenOffering != null) {
                launchPaywallActivity(context, noActiveScreenOffering);
            } else {
                tryFallbackToCurrentOffering(context);
            }
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void showVirtualCurrencyBalances() {
        Object value;
        Object objCopy$default;
        CustomerCenterState customerCenterState = (CustomerCenterState) this._state.getValue();
        if (customerCenterState instanceof CustomerCenterState.Success) {
            CustomerCenterState.Success success = (CustomerCenterState.Success) customerCenterState;
            if (Intrinsics.areEqual(success.getCustomerCenterConfigData().getSupport().getDisplayVirtualCurrencies(), Boolean.TRUE)) {
                MutableStateFlow<CustomerCenterState> mutableStateFlow = this._state;
                do {
                    value = mutableStateFlow.getValue();
                    objCopy$default = (CustomerCenterState) value;
                    if (objCopy$default instanceof CustomerCenterState.Success) {
                        CustomerCenterState.Success success2 = (CustomerCenterState.Success) objCopy$default;
                        objCopy$default = CustomerCenterState.Success.copy$default(success2, null, null, null, null, null, null, success2.getNavigationState().push(new CustomerCenterDestination.VirtualCurrencyBalances(success.getCustomerCenterConfigData().getLocalization().commonLocalizedString(CustomerCenterConfigData.Localization.CommonLocalizedString.VIRTUAL_CURRENCY_BALANCES_SCREEN_HEADER))), CustomerCenterState.NavigationButtonType.BACK, null, false, false, 1855, null);
                    }
                } while (!mutableStateFlow.compareAndSet(value, objCopy$default));
            }
        }
    }

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void trackImpressionIfNeeded() {
        if (this.impressionCreationData == null) {
            this.impressionCreationData = new CustomerCenterImpressionEvent.CreationData(null, null, 3, null);
            Locale localeD = ((LocaleListCompat) this._lastLocaleList.getValue()).d(0);
            if (localeD == null) {
                localeD = Locale.getDefault();
            }
            Date date = new Date();
            boolean z2 = this.isDarkMode;
            String string = localeD.toString();
            Intrinsics.checkNotNullExpressionValue(string, "locale.toString()");
            this.purchases.track(new CustomerCenterImpressionEvent(null, new CustomerCenterImpressionEvent.Data(date, z2, string, 0, 0, null, 56, null), 1, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException
        */
    public final java.lang.Object loadCustomerCenter(
    /*  JADX ERROR: Method generation error
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r29v0 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.codegen.MethodGen.addMethodArguments(MethodGen.java:224)
        	at jadx.core.codegen.MethodGen.addDefinition(MethodGen.java:169)
        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:407)
        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
        */
    /*  JADX ERROR: NullPointerException in pass: ConstructorVisitor
        java.lang.NullPointerException
        */

    @Override // com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModel
    public void contactSupport(Context context, String supportEmail) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(supportEmail, "supportEmail");
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:" + supportEmail));
        intent.putExtra("android.intent.extra.SUBJECT", "Support Request");
        intent.putExtra(pMpIcGE.uCuwQYCRB, "Support request details...");
        context.startActivity(Intent.createChooser(intent, "Contact Support"));
    }

    public CustomerCenterViewModelImpl(PurchasesType purchases, DateFormatter dateFormatter, Locale locale, ColorScheme colorScheme, boolean z2, CustomerCenterListener customerCenterListener) {
        Intrinsics.checkNotNullParameter(purchases, "purchases");
        Intrinsics.checkNotNullParameter(dateFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(colorScheme, "colorScheme");
        this.purchases = purchases;
        this.dateFormatter = dateFormatter;
        this.locale = locale;
        this.colorScheme = colorScheme;
        this.isDarkMode = z2;
        this.listener = customerCenterListener;
        this._lastLocaleList = StateFlowKt.a(getCurrentLocaleList());
        this._colorScheme = StateFlowKt.a(colorScheme);
        MutableStateFlow<CustomerCenterState> mutableStateFlowA = StateFlowKt.a(CustomerCenterState.NotLoaded.INSTANCE);
        this._state = mutableStateFlowA;
        this.state = FlowKt.h0(FlowKt.W(mutableStateFlowA, new CustomerCenterViewModelImpl$state$1(this, null)), ViewModelKt.a(this), SharingStarted.Companion.b(SharingStarted.f142210a, 5000L, 0L, 2, null), CustomerCenterState.Loading.INSTANCE);
        this._actionError = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
    }
}
