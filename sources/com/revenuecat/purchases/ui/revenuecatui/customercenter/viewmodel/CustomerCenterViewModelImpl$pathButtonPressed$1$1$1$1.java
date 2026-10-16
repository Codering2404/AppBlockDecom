package com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel;

import android.content.Context;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.ui.revenuecatui.customercenter.data.PurchaseInformation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.customercenter.viewmodel.CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1", f = "CustomerCenterViewModel.kt", l = {250}, m = "invokeSuspend")
final class CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option $it;
    final /* synthetic */ CustomerCenterConfigData.HelpPath $path;
    final /* synthetic */ PurchaseInformation $purchaseInformation;
    int label;
    final /* synthetic */ CustomerCenterViewModelImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1(CustomerCenterViewModelImpl customerCenterViewModelImpl, Context context, PurchaseInformation purchaseInformation, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option option, CustomerCenterConfigData.HelpPath helpPath, Continuation<? super CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = customerCenterViewModelImpl;
        this.$context = context;
        this.$purchaseInformation = purchaseInformation;
        this.$it = option;
        this.$path = helpPath;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1(this.this$0, this.$context, this.$purchaseInformation, this.$it, this.$path, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1 customerCenterViewModelImpl$pathButtonPressed$1$1$1$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            CustomerCenterViewModelImpl customerCenterViewModelImpl = this.this$0;
            Context context = this.$context;
            PurchaseInformation purchaseInformation = this.$purchaseInformation;
            StoreProduct product = purchaseInformation != null ? purchaseInformation.getProduct() : null;
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer = this.$it.getPromotionalOffer();
            CustomerCenterConfigData.HelpPath helpPath = this.$path;
            PurchaseInformation purchaseInformation2 = this.$purchaseInformation;
            this.label = 1;
            customerCenterViewModelImpl$pathButtonPressed$1$1$1$1 = this;
            obj = customerCenterViewModelImpl.handlePromotionalOffer(context, product, promotionalOffer, helpPath, purchaseInformation2, customerCenterViewModelImpl$pathButtonPressed$1$1$1$1);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            customerCenterViewModelImpl$pathButtonPressed$1$1$1$1 = this;
        }
        if (!((Boolean) obj).booleanValue()) {
            customerCenterViewModelImpl$pathButtonPressed$1$1$1$1.this$0.goBackToMain();
            customerCenterViewModelImpl$pathButtonPressed$1$1$1$1.this$0.mainPathAction(customerCenterViewModelImpl$pathButtonPressed$1$1$1$1.$path, customerCenterViewModelImpl$pathButtonPressed$1$1$1$1.$context, customerCenterViewModelImpl$pathButtonPressed$1$1$1$1.$purchaseInformation);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CustomerCenterViewModelImpl$pathButtonPressed$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
