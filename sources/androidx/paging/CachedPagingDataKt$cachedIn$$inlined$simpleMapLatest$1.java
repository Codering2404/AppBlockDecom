package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;

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
@DebugMetadata(c = "androidx.paging.CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1", f = "CachedPagingData.kt", l = {105}, m = "invokeSuspend")
public final class CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super MulticastedPagingData<Object>>, PagingData<Object>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49623a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f49624b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ Object f49625c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f49626d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ActiveFlowTracker f49627f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(Continuation continuation, CoroutineScope coroutineScope, ActiveFlowTracker activeFlowTracker) {
        super(3, continuation);
        this.f49626d = coroutineScope;
        this.f49627f = activeFlowTracker;
    }

    @Override // kotlin.jvm.functions.Function3
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(FlowCollector flowCollector, Object obj, Continuation continuation) {
        CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1 = new CachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1(continuation, this.f49626d, this.f49627f);
        cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1.f49624b = flowCollector;
        cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1.f49625c = obj;
        return cachedPagingDataKt$cachedIn$$inlined$simpleMapLatest$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49623a;
        if (i3 == 0) {
            ResultKt.b(obj);
            FlowCollector flowCollector = (FlowCollector) this.f49624b;
            MulticastedPagingData multicastedPagingData = new MulticastedPagingData(this.f49626d, (PagingData) this.f49625c, this.f49627f);
            this.f49623a = 1;
            if (flowCollector.emit(multicastedPagingData, this) == objF) {
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
