package cz.mobilesoft.coreblock.repository;

import android.content.Context;
import com.revenuecat.purchases.PurchaseResult;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import cz.mobilesoft.coreblock.LockieApplication;
import cz.mobilesoft.coreblock.service.worker.ServerSyncWorker;
import cz.mobilesoft.coreblock.util.analytics.AppsFlyerLogger;
import cz.mobilesoft.coreblock.util.runnability.JobHelper;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onPurchaseFinished$1", f = "PremiumRepositoryV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2$onPurchaseFinished$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97778a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PurchaseResult f97779b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumRepositoryV2 f97780c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ StoreProduct f97781d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumRepositoryV2$onPurchaseFinished$1(PurchaseResult purchaseResult, PremiumRepositoryV2 premiumRepositoryV2, StoreProduct storeProduct, Continuation continuation) {
        super(1, continuation);
        this.f97779b = purchaseResult;
        this.f97780c = premiumRepositoryV2;
        this.f97781d = storeProduct;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PremiumRepositoryV2$onPurchaseFinished$1(this.f97779b, this.f97780c, this.f97781d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f97778a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PurchaseResult purchaseResult = this.f97779b;
        if (purchaseResult != null) {
            this.f97780c.f97704k.setValue(purchaseResult.getCustomerInfo());
        }
        JobHelper.c();
        this.f97780c.G().e(this.f97781d);
        if (this.f97781d.getSubscriptionOptions() != null) {
            SubscriptionOptions subscriptionOptions = this.f97781d.getSubscriptionOptions();
            if (subscriptionOptions == null || subscriptionOptions.isEmpty()) {
                this.f97780c.G().g(this.f97781d);
            } else {
                Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
                while (it.hasNext()) {
                    if (it.next().getFreePhase() != null) {
                        this.f97780c.G().f(this.f97781d);
                        break;
                    }
                }
                this.f97780c.G().g(this.f97781d);
            }
        }
        AppsFlyerLogger.f128214a.a(this.f97781d);
        ServerSyncWorker.Companion companion = ServerSyncWorker.f123944h;
        Context contextG = LockieApplication.g();
        Intrinsics.checkNotNullExpressionValue(contextG, "getContext(...)");
        companion.a(contextG);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PremiumRepositoryV2$onPurchaseFinished$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
