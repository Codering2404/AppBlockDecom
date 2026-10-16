package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.activity.rating.RatingFlowCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.activity.rating.RatingFlowViewModel$onEvent$11", f = "RatingFlowViewModel.kt", l = {131}, m = "invokeSuspend", v = 1)
final class RatingFlowViewModel$onEvent$11 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f96156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ RatingFlowViewModel f96157b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    RatingFlowViewModel$onEvent$11(RatingFlowViewModel ratingFlowViewModel, Continuation continuation) {
        super(1, continuation);
        this.f96157b = ratingFlowViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new RatingFlowViewModel$onEvent$11(this.f96157b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f96156a;
        if (i3 == 0) {
            ResultKt.b(obj);
            RatingFlowViewModel ratingFlowViewModel = this.f96157b;
            RatingFlowCommand.Close close = new RatingFlowCommand.Close(false);
            this.f96156a = 1;
            if (ratingFlowViewModel.P0(close, this) == objF) {
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
        return ((RatingFlowViewModel$onEvent$11) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
