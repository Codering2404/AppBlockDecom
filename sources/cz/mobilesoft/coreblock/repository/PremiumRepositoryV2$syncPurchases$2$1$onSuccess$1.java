package cz.mobilesoft.coreblock.repository;

import com.revenuecat.purchases.CustomerInfo;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$syncPurchases$2$1$onSuccess$1", f = "PremiumRepositoryV2.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2$syncPurchases$2$1$onSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97845a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PremiumRepositoryV2 f97846b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CustomerInfo f97847c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumRepositoryV2$syncPurchases$2$1$onSuccess$1(PremiumRepositoryV2 premiumRepositoryV2, CustomerInfo customerInfo, Continuation continuation) {
        super(2, continuation);
        this.f97846b = premiumRepositoryV2;
        this.f97847c = customerInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PremiumRepositoryV2$syncPurchases$2$1$onSuccess$1(this.f97846b, this.f97847c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f97845a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.f97846b.e0(this.f97847c);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PremiumRepositoryV2$syncPurchases$2$1$onSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
