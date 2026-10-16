package cz.mobilesoft.coreblock.scene.insights.usecase;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.usecase.CreateIntervalsUseCase$createTrendIntervals$devShowAllTrendIntervals$1", f = "CreateIntervalsUseCase.kt", l = {140}, m = "invokeSuspend", v = 1)
final class CreateIntervalsUseCase$createTrendIntervals$devShowAllTrendIntervals$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f103673a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CreateIntervalsUseCase f103674b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateIntervalsUseCase$createTrendIntervals$devShowAllTrendIntervals$1(CreateIntervalsUseCase createIntervalsUseCase, Continuation continuation) {
        super(2, continuation);
        this.f103674b = createIntervalsUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new CreateIntervalsUseCase$createTrendIntervals$devShowAllTrendIntervals$1(this.f103674b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f103673a;
        if (i3 != 0) {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        ResultKt.b(obj);
        Flow flowU0 = this.f103674b.k().U0();
        this.f103673a = 1;
        Object objD = FlowKt.D(flowU0, this);
        return objD == objF ? objF : objD;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CreateIntervalsUseCase$createTrendIntervals$devShowAllTrendIntervals$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
