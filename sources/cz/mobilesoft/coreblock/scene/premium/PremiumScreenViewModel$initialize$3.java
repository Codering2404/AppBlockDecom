package cz.mobilesoft.coreblock.scene.premium;

import com.revenuecat.purchases.CustomerInfo;
import cz.mobilesoft.coreblock.base.viewmodel.BaseBillingViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel$initialize$3", f = "PremiumScreenViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class PremiumScreenViewModel$initialize$3 extends SuspendLambda implements Function3<CustomerInfo, BaseBillingViewModel.RevenueCatProducts, Continuation<? super Pair<? extends CustomerInfo, ? extends BaseBillingViewModel.RevenueCatProducts>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f112407a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f112408b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f112409c;

    PremiumScreenViewModel$initialize$3(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(CustomerInfo customerInfo, BaseBillingViewModel.RevenueCatProducts revenueCatProducts, Continuation continuation) {
        PremiumScreenViewModel$initialize$3 premiumScreenViewModel$initialize$3 = new PremiumScreenViewModel$initialize$3(continuation);
        premiumScreenViewModel$initialize$3.f112408b = customerInfo;
        premiumScreenViewModel$initialize$3.f112409c = revenueCatProducts;
        return premiumScreenViewModel$initialize$3.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CustomerInfo customerInfo = (CustomerInfo) this.f112408b;
        BaseBillingViewModel.RevenueCatProducts revenueCatProducts = (BaseBillingViewModel.RevenueCatProducts) this.f112409c;
        IntrinsicsKt.f();
        if (this.f112407a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return TuplesKt.a(customerInfo, revenueCatProducts);
    }
}
