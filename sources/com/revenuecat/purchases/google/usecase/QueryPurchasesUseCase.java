package com.revenuecat.purchases.google.usecase;

import androidx.appcompat.app.jE.vxrlPPpdv;
import com.android.billingclient.api.BillingClient;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class QueryPurchasesUseCase extends BillingClientUseCase<Map<String, ? extends StoreTransaction>> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<Map<String, StoreTransaction>, Unit> onSuccess;
    private final QueryPurchasesUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryInApps(Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.useCaseParams.getDateProvider(), this.useCaseParams.getDiagnosticsTrackerIfEnabled(), this.useCaseParams.getAppInBackground(), "inapp"), function1, function12, this.withConnectedClient, getExecuteRequestOnUIThread()), 0L, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void querySubscriptions(Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.useCaseParams.getDateProvider(), this.useCaseParams.getDiagnosticsTrackerIfEnabled(), this.useCaseParams.getAppInBackground(), "subs"), function1, function12, this.withConnectedClient, getExecuteRequestOnUIThread()), 0L, 1, null);
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new Function1<BillingClient, Unit>() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase.executeAsync.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((BillingClient) obj);
                return Unit.f139807a;
            }

            public final void invoke(BillingClient invoke) {
                Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
                final QueryPurchasesUseCase queryPurchasesUseCase = QueryPurchasesUseCase.this;
                queryPurchasesUseCase.querySubscriptions(new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase.executeAsync.1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Map<String, StoreTransaction>) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(final Map<String, StoreTransaction> activeSubs) {
                        Intrinsics.checkNotNullParameter(activeSubs, "activeSubs");
                        final QueryPurchasesUseCase queryPurchasesUseCase2 = queryPurchasesUseCase;
                        queryPurchasesUseCase2.queryInApps(new Function1<Map<String, ? extends StoreTransaction>, Unit>() { // from class: com.revenuecat.purchases.google.usecase.QueryPurchasesUseCase.executeAsync.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Map<String, StoreTransaction>) obj);
                                return Unit.f139807a;
                            }

                            public final void invoke(Map<String, StoreTransaction> unconsumedInApps) {
                                Intrinsics.checkNotNullParameter(unconsumedInApps, "unconsumedInApps");
                                queryPurchasesUseCase2.onOk2(MapsKt.plus(activeSubs, unconsumedInApps));
                            }
                        }, queryPurchasesUseCase.getOnError());
                    }
                }, QueryPurchasesUseCase.this.getOnError());
            }
        });
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public String getErrorMessage() {
        return "Error when querying purchases";
    }

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<Map<String, StoreTransaction>, Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    @Override // com.revenuecat.purchases.google.usecase.BillingClientUseCase
    public /* bridge */ /* synthetic */ void onOk(Map<String, ? extends StoreTransaction> map) {
        onOk2((Map<String, StoreTransaction>) map);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public QueryPurchasesUseCase(QueryPurchasesUseCaseParams useCaseParams, Function1<? super Map<String, StoreTransaction>, Unit> onSuccess, Function1<? super PurchasesError, Unit> function1, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> executeRequestOnUIThread) {
        super(useCaseParams, function1, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onSuccess, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, vxrlPPpdv.AiLFtFwIG);
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onSuccess = onSuccess;
        this.onError = function1;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: renamed from: onOk, reason: avoid collision after fix types in other method */
    public void onOk2(Map<String, StoreTransaction> received) {
        Intrinsics.checkNotNullParameter(received, "received");
        this.onSuccess.invoke(received);
    }
}
