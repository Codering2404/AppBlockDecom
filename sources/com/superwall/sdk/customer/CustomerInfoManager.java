package com.superwall.sdk.customer;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.models.customer.CustomerInfo;
import com.superwall.sdk.models.customer.CustomerInfoMergingKt;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.storage.LatestCustomerInfo;
import com.superwall.sdk.storage.LatestDeviceCustomerInfo;
import com.superwall.sdk.storage.LatestWebCustomerInfo;
import com.superwall.sdk.storage.Storage;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class CustomerInfoManager {
    private final Function0<SubscriptionStatus> getSubscriptionStatus;
    private final Function0<Boolean> hasExternalPurchaseController;
    private final IOScope ioScope;
    private final Storage storage;
    private final Function1<CustomerInfo, Unit> updateCustomerInfo;

    /* JADX INFO: renamed from: com.superwall.sdk.customer.CustomerInfoManager$updateMergedCustomerInfo$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.customer.CustomerInfoManager$updateMergedCustomerInfo$1", f = "CustomerInfoManager.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return CustomerInfoManager.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CustomerInfo customerInfoMerge;
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (((Boolean) CustomerInfoManager.this.hasExternalPurchaseController.invoke()).booleanValue()) {
                customerInfoMerge = CustomerInfo.Companion.forExternalPurchaseController(CustomerInfoManager.this.storage, (SubscriptionStatus) CustomerInfoManager.this.getSubscriptionStatus.invoke());
                Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.superwallCore, "Built CustomerInfo for external controller - " + customerInfoMerge.getSubscriptions().size() + " subs, " + customerInfoMerge.getEntitlements().size() + " entitlements", (Map) null, (Throwable) null, 24, (Object) null);
            } else {
                customerInfoMerge = (CustomerInfo) CustomerInfoManager.this.storage.read(LatestDeviceCustomerInfo.INSTANCE);
                if (customerInfoMerge == null) {
                    customerInfoMerge = CustomerInfo.Companion.empty();
                }
                CustomerInfo customerInfoEmpty = (CustomerInfo) CustomerInfoManager.this.storage.read(LatestWebCustomerInfo.INSTANCE);
                if (customerInfoEmpty == null) {
                    customerInfoEmpty = CustomerInfo.Companion.empty();
                }
                Logger logger = Logger.INSTANCE;
                LogLevel logLevel = LogLevel.debug;
                LogScope logScope = LogScope.superwallCore;
                Logger.debug$default(logger, logLevel, logScope, "Merging CustomerInfo - Device: " + customerInfoMerge.getSubscriptions().size() + " subs, Web: " + customerInfoEmpty.getSubscriptions().size() + " subs", (Map) null, (Throwable) null, 24, (Object) null);
                if (customerInfoMerge.isPlaceholder$superwall_release() && customerInfoEmpty.isPlaceholder$superwall_release()) {
                    customerInfoMerge = CustomerInfo.Companion.empty();
                } else if (customerInfoMerge.isPlaceholder$superwall_release()) {
                    customerInfoMerge = customerInfoEmpty;
                } else if (!customerInfoEmpty.isPlaceholder$superwall_release()) {
                    customerInfoMerge = CustomerInfoMergingKt.merge(customerInfoMerge, customerInfoEmpty);
                }
                Logger.debug$default(logger, logLevel, logScope, "Merged CustomerInfo - Total: " + customerInfoMerge.getSubscriptions().size() + " subs, " + customerInfoMerge.getEntitlements().size() + " entitlements", (Map) null, (Throwable) null, 24, (Object) null);
            }
            CustomerInfoManager.this.storage.write(LatestCustomerInfo.INSTANCE, customerInfoMerge);
            CustomerInfoManager.this.updateCustomerInfo.invoke(customerInfoMerge);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomerInfoManager(Storage storage, Function1<? super CustomerInfo, Unit> updateCustomerInfo, IOScope ioScope, Function0<Boolean> hasExternalPurchaseController, Function0<? extends SubscriptionStatus> getSubscriptionStatus) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(updateCustomerInfo, "updateCustomerInfo");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(hasExternalPurchaseController, "hasExternalPurchaseController");
        Intrinsics.checkNotNullParameter(getSubscriptionStatus, "getSubscriptionStatus");
        this.storage = storage;
        this.updateCustomerInfo = updateCustomerInfo;
        this.ioScope = ioScope;
        this.hasExternalPurchaseController = hasExternalPurchaseController;
        this.getSubscriptionStatus = getSubscriptionStatus;
    }

    public final void updateMergedCustomerInfo() {
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass1(null), 3, null);
    }
}
