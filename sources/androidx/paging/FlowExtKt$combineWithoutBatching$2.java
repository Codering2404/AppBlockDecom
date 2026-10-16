package androidx.paging;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt__JobKt;
import kotlinx.coroutines.flow.Flow;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2", f = "FlowExt.kt", l = {161}, m = "invokeSuspend")
public final class FlowExtKt$combineWithoutBatching$2 extends SuspendLambda implements Function2<SimpleProducerScope<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Flow f49742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Flow f49743d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function4 f49744f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowExtKt$combineWithoutBatching$2(Flow flow, Flow flow2, Function4 function4, Continuation continuation) {
        super(2, continuation);
        this.f49742c = flow;
        this.f49743d = flow2;
        this.f49744f = function4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        FlowExtKt$combineWithoutBatching$2 flowExtKt$combineWithoutBatching$2 = new FlowExtKt$combineWithoutBatching$2(this.f49742c, this.f49743d, this.f49744f, continuation);
        flowExtKt$combineWithoutBatching$2.f49741b = obj;
        return flowExtKt$combineWithoutBatching$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SimpleProducerScope simpleProducerScope, Continuation continuation) {
        return ((FlowExtKt$combineWithoutBatching$2) create(simpleProducerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49740a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.f49741b;
            AtomicInteger atomicInteger = new AtomicInteger(2);
            UnbatchedFlowCombiner unbatchedFlowCombiner = new UnbatchedFlowCombiner(new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(simpleProducerScope, this.f49744f, null));
            final CompletableJob completableJobB = JobKt__JobKt.b(null, 1, null);
            int i4 = 0;
            Flow[] flowArr = {this.f49742c, this.f49743d};
            int i5 = 0;
            while (i5 < 2) {
                SimpleProducerScope simpleProducerScope2 = simpleProducerScope;
                simpleProducerScope = simpleProducerScope2;
                BuildersKt__Builders_commonKt.d(simpleProducerScope, completableJobB, null, new FlowExtKt$combineWithoutBatching$2$1$1(flowArr[i5], atomicInteger, simpleProducerScope2, unbatchedFlowCombiner, i4, null), 2, null);
                i5++;
                atomicInteger = atomicInteger;
                i4++;
                unbatchedFlowCombiner = unbatchedFlowCombiner;
            }
            Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.paging.FlowExtKt$combineWithoutBatching$2.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m349invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m349invoke() {
                    Job.DefaultImpls.b(completableJobB, null, 1, null);
                }
            };
            this.f49740a = 1;
            if (simpleProducerScope.M(function0, this) == objF) {
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
