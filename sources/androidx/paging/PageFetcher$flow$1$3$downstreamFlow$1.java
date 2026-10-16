package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [Value] */
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
@DebugMetadata(c = "androidx.paging.PageFetcher$flow$1$3$downstreamFlow$1", f = "PageFetcher.kt", l = {}, m = "invokeSuspend")
final class PageFetcher$flow$1$3$downstreamFlow$1<Value> extends SuspendLambda implements Function2<PageEvent<Value>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f50056b;

    PageFetcher$flow$1$3$downstreamFlow$1(Continuation continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PageFetcher$flow$1$3$downstreamFlow$1 pageFetcher$flow$1$3$downstreamFlow$1 = new PageFetcher$flow$1$3$downstreamFlow$1(continuation);
        pageFetcher$flow$1$3$downstreamFlow$1.f50056b = obj;
        return pageFetcher$flow$1$3$downstreamFlow$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PageEvent pageEvent, Continuation continuation) {
        return ((PageFetcher$flow$1$3$downstreamFlow$1) create(pageEvent, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f50055a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PageEvent pageEvent = (PageEvent) this.f50056b;
        PagingLogger pagingLogger = PagingLogger.f50484a;
        if (pagingLogger.a(2)) {
            pagingLogger.b(2, "Sent " + pageEvent, null);
        }
        return Unit.f139807a;
    }
}
