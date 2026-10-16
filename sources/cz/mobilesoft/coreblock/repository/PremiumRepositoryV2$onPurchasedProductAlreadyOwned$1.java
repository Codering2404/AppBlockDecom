package cz.mobilesoft.coreblock.repository;

import android.util.Log;
import com.revenuecat.purchases.PurchasesException;
import cz.mobilesoft.coreblock.usecase.RestoreRevenueCatPurchaseUseCase;
import cz.mobilesoft.coreblock.util.CrashHelper;
import cz.mobilesoft.coreblock.util.DataState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onPurchasedProductAlreadyOwned$1", f = "PremiumRepositoryV2.kt", l = {419}, m = "invokeSuspend", v = 1)
final class PremiumRepositoryV2$onPurchasedProductAlreadyOwned$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f97782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f97783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PremiumRepositoryV2 f97784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f97785d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f97786f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PremiumRepositoryV2$onPurchasedProductAlreadyOwned$1(String str, PremiumRepositoryV2 premiumRepositoryV2, Function1 function1, Function1 function12, Continuation continuation) {
        super(1, continuation);
        this.f97783b = str;
        this.f97784c = premiumRepositoryV2;
        this.f97785d = function1;
        this.f97786f = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new PremiumRepositoryV2$onPurchasedProductAlreadyOwned$1(this.f97783b, this.f97784c, this.f97785d, this.f97786f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f97782a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Log.e("PremiumRepository", "Product " + this.f97783b + " already owned");
            Flow flowE = this.f97784c.M().e(RestoreRevenueCatPurchaseUseCase.Params.f127233a);
            final Function1 function1 = this.f97785d;
            final String str = this.f97783b;
            final Function1 function12 = this.f97786f;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2$onPurchasedProductAlreadyOwned$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(DataState dataState, Continuation continuation) {
                    if (dataState instanceof DataState.Success) {
                        function1.invoke(str);
                    } else if (dataState instanceof DataState.Error) {
                        Throwable thC = ((DataState.Error) dataState).c();
                        PurchasesException purchasesException = thC instanceof PurchasesException ? (PurchasesException) thC : null;
                        if (purchasesException != null) {
                            String str2 = str;
                            Function1 function13 = function12;
                            CrashHelper.m(CrashHelper.f127788a, purchasesException, "Product " + str2 + " already owned, error restoring purchases", null, 2, null);
                            function13.invoke(purchasesException.getMessage());
                        }
                    }
                    return Unit.f139807a;
                }
            };
            this.f97782a = 1;
            if (flowE.collect(flowCollector, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((PremiumRepositoryV2$onPurchasedProductAlreadyOwned$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
