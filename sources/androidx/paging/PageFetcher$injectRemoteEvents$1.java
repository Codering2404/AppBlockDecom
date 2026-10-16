package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [Value] */
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
@DebugMetadata(c = "androidx.paging.PageFetcher$injectRemoteEvents$1", f = "PageFetcher.kt", l = {203}, m = "invokeSuspend")
final class PageFetcher$injectRemoteEvents$1<Value> extends SuspendLambda implements Function2<SimpleProducerScope<PageEvent<Value>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f50069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ RemoteMediatorAccessor f50070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PageFetcherSnapshot f50071d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableLoadStateCollection f50072f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PageFetcher$injectRemoteEvents$1(RemoteMediatorAccessor remoteMediatorAccessor, PageFetcherSnapshot pageFetcherSnapshot, MutableLoadStateCollection mutableLoadStateCollection, Continuation continuation) {
        super(2, continuation);
        this.f50070c = remoteMediatorAccessor;
        this.f50071d = pageFetcherSnapshot;
        this.f50072f = mutableLoadStateCollection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PageFetcher$injectRemoteEvents$1 pageFetcher$injectRemoteEvents$1 = new PageFetcher$injectRemoteEvents$1(this.f50070c, this.f50071d, this.f50072f, continuation);
        pageFetcher$injectRemoteEvents$1.f50069b = obj;
        return pageFetcher$injectRemoteEvents$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(SimpleProducerScope simpleProducerScope, Continuation continuation) {
        return ((PageFetcher$injectRemoteEvents$1) create(simpleProducerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50068a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final SimpleProducerScope simpleProducerScope = (SimpleProducerScope) this.f50069b;
            Flow flowA = SimpleChannelFlowKt.a(new PageFetcher$injectRemoteEvents$1$invokeSuspend$$inlined$combineWithoutBatching$1(this.f50070c.getState(), this.f50071d.u(), null, this.f50072f));
            FlowCollector flowCollector = new FlowCollector() { // from class: androidx.paging.PageFetcher$injectRemoteEvents$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(PageEvent pageEvent, Continuation continuation) {
                    Object objY = simpleProducerScope.y(pageEvent, continuation);
                    return objY == IntrinsicsKt.f() ? objY : Unit.f139807a;
                }
            };
            this.f50068a = 1;
            if (flowA.collect(flowCollector, this) == objF) {
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
