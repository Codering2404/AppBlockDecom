package cz.mobilesoft.coreblock.usecase;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.usecase.GetUsageLimitsForCurrentPeriodUseCase$invoke$dayBeginningHour$1", f = "GetUsageLimitsForCurrentPeriodUseCase.kt", l = {35}, m = "invokeSuspend", v = 1)
final class GetUsageLimitsForCurrentPeriodUseCase$invoke$dayBeginningHour$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f127152a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ GetUsageLimitsForCurrentPeriodUseCase f127153b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GetUsageLimitsForCurrentPeriodUseCase$invoke$dayBeginningHour$1(GetUsageLimitsForCurrentPeriodUseCase getUsageLimitsForCurrentPeriodUseCase, Continuation continuation) {
        super(2, continuation);
        this.f127153b = getUsageLimitsForCurrentPeriodUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new GetUsageLimitsForCurrentPeriodUseCase$invoke$dayBeginningHour$1(this.f127153b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f127152a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Flow flowD0 = this.f127153b.g().d0();
        this.f127152a = 1;
        Object objD = FlowKt.D(flowD0, this);
        return objD == objF ? objF : objD;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((GetUsageLimitsForCurrentPeriodUseCase$invoke$dayBeginningHour$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
