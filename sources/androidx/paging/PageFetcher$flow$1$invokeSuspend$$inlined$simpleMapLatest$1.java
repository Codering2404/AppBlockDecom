package androidx.paging;

import androidx.paging.PageFetcher;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: Add missing generic type declarations: [Value, Key] */
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1", f = "PageFetcher.kt", l = {105}, m = "invokeSuspend")
public final class PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1<Key, Value> extends SuspendLambda implements Function3<FlowCollector<? super PagingData<Value>>, PageFetcher.GenerationInfo<Key, Value>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f50059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f50060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PageFetcher f50061d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ RemoteMediatorAccessor f50062f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(Continuation continuation, PageFetcher pageFetcher, RemoteMediatorAccessor remoteMediatorAccessor) {
        super(3, continuation);
        this.f50061d = pageFetcher;
        this.f50062f = remoteMediatorAccessor;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FlowCollector flowCollector, Object obj, Continuation continuation) {
        PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1 pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1 = new PageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1(continuation, this.f50061d, this.f50062f);
        pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1.f50059b = flowCollector;
        pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1.f50060c = obj;
        return pageFetcher$flow$1$invokeSuspend$$inlined$simpleMapLatest$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50058a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f50059b;
            PageFetcher.GenerationInfo generationInfo = (PageFetcher.GenerationInfo) this.f50060c;
            Flow flowV = FlowKt.V(this.f50061d.j(generationInfo.b(), generationInfo.a(), this.f50062f), new PageFetcher$flow$1$3$downstreamFlow$1(null));
            PageFetcher pageFetcher = this.f50061d;
            PagingData pagingData = new PagingData(flowV, new PageFetcher.PagerUiReceiver(pageFetcher, pageFetcher.f50033e), new PageFetcher.PagerHintReceiver(this.f50061d, generationInfo.b()), null, 8, null);
            this.f50058a = 1;
            if (flowCollector.emit(pagingData, this) == objF) {
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
