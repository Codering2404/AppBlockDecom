package com.superwall.sdk.billing;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ConsumeParams;
import com.android.billingclient.api.ConsumeResponseListener;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ConsumePurchaseUseCase extends BillingClientUseCase<String> {
    private final Function1<String, Unit> onReceive;
    private final ConsumePurchaseUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ConsumePurchaseUseCase(ConsumePurchaseUseCaseParams useCaseParams, Function1<? super String, Unit> onReceive, Function1<? super BillingError, Unit> onError, Function1<? super Function1<? super BillingClient, Unit>, Unit> withConnectedClient, Function2<? super Long, ? super Function1<? super BillingError, Unit>, Unit> executeRequestOnUIThread) {
        super(useCaseParams, onError, executeRequestOnUIThread);
        Intrinsics.checkNotNullParameter(useCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(onReceive, "onReceive");
        Intrinsics.checkNotNullParameter(onError, "onError");
        Intrinsics.checkNotNullParameter(withConnectedClient, "withConnectedClient");
        Intrinsics.checkNotNullParameter(executeRequestOnUIThread, "executeRequestOnUIThread");
        this.useCaseParams = useCaseParams;
        this.onReceive = onReceive;
        this.withConnectedClient = withConnectedClient;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit executeAsync$lambda$1(final ConsumePurchaseUseCase consumePurchaseUseCase, BillingClient withConnectedClient) {
        Intrinsics.checkNotNullParameter(withConnectedClient, "$this$withConnectedClient");
        ConsumeParams consumeParamsA = ConsumeParams.b().b(consumePurchaseUseCase.useCaseParams.getPurchaseToken()).a();
        Intrinsics.checkNotNullExpressionValue(consumeParamsA, "build(...)");
        withConnectedClient.b(consumeParamsA, new ConsumeResponseListener() { // from class: com.superwall.sdk.billing.b
            @Override // com.android.billingclient.api.ConsumeResponseListener
            public final void c(BillingResult billingResult, String str) {
                ConsumePurchaseUseCase.executeAsync$lambda$1$lambda$0(this.f93456a, billingResult, str);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void executeAsync$lambda$1$lambda$0(ConsumePurchaseUseCase consumePurchaseUseCase, BillingResult billingResult, String purchaseToken) {
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(purchaseToken, "purchaseToken");
        BillingClientUseCase.processResult$default(consumePurchaseUseCase, billingResult, purchaseToken, null, null, 12, null);
    }

    @Override // com.superwall.sdk.billing.BillingClientUseCase
    public void executeAsync() {
        this.withConnectedClient.invoke(new Function1() { // from class: com.superwall.sdk.billing.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ConsumePurchaseUseCase.executeAsync$lambda$1(this.f93457a, (BillingClient) obj);
            }
        });
    }

    @Override // com.superwall.sdk.billing.BillingClientUseCase
    public void onOk(String received) {
        Intrinsics.checkNotNullParameter(received, "received");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.productsManager, "Successfully consumed purchase with token " + this.useCaseParams.getPurchaseToken(), (Map) null, (Throwable) null, 24, (Object) null);
        this.onReceive.invoke(received);
    }
}
