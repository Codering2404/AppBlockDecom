package cz.mobilesoft.coreblock.scene.dashboard.blocking;

import cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.BlockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1", f = "BlockingScreenViewModel.kt", l = {189}, m = "invokeSuspend", v = 1)
public final class BlockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super Long>, Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f99630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f99631c;

    public BlockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1(Continuation continuation) {
        super(3, continuation);
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FlowCollector flowCollector, Object obj, Continuation continuation) {
        BlockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1 blockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1 = new BlockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1(continuation);
        blockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1.f99630b = flowCollector;
        blockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1.f99631c = obj;
        return blockingScreenViewModel$20$invokeSuspend$$inlined$flatMapLatest$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f99629a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f99630b;
            Object obj2 = this.f99631c;
            Long l3 = (Long) obj2;
            Flow flowK = l3 == null ? FlowKt.K(null) : TimeHelperExt.f128663a.a(l3.longValue(), TimeUnit.SECONDS.toMillis(1L));
            this.f99630b = SpillingKt.a(flowCollector);
            this.f99631c = SpillingKt.a(obj2);
            this.f99629a = 1;
            if (FlowKt.A(flowCollector, flowK, this) == objF) {
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
}
