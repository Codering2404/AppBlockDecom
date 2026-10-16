package cz.mobilesoft.coreblock.repository;

import android.util.Log;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.interfaces.SyncPurchasesCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncPurchases$2", f = "PremiumRepositoryV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2$syncPurchases$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function0 f97841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumRepositoryV2 f97842c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumRepositoryV2$syncPurchases$2(Function0 function0, PremiumRepositoryV2 premiumRepositoryV2, Continuation continuation) {
        super(2, continuation);
        this.f97841b = function0;
        this.f97842c = premiumRepositoryV2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PremiumRepositoryV2$syncPurchases$2(this.f97841b, this.f97842c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f97840a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Purchases sharedInstance = Purchases.Companion.getSharedInstance();
        final Function0 function0 = this.f97841b;
        final PremiumRepositoryV2 premiumRepositoryV2 = this.f97842c;
        sharedInstance.syncPurchases(new SyncPurchasesCallback() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncPurchases$2.1
            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onError(PurchasesError error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Log.d("PremiumRepository", "Error syncing purchases: " + error);
            }

            @Override // com.revenuecat.purchases.interfaces.SyncPurchasesCallback
            public void onSuccess(CustomerInfo customerInfo) {
                Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
                function0.invoke();
                BuildersKt__Builders_commonKt.d(premiumRepositoryV2.f97695a, null, null, new PremiumRepositoryV2$syncPurchases$2$1$onSuccess$1(premiumRepositoryV2, customerInfo, null), 3, null);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PremiumRepositoryV2$syncPurchases$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
