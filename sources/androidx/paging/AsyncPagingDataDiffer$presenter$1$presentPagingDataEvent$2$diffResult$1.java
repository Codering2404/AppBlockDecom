package androidx.paging;

import androidx.paging.PagingDataEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1", f = "AsyncPagingDataDiffer.kt", l = {}, m = "invokeSuspend")
final class AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PlaceholderPaddedDiffResult>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagingDataEvent.Refresh f49569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ AsyncPagingDataDiffer f49570c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1(PagingDataEvent.Refresh refresh, AsyncPagingDataDiffer asyncPagingDataDiffer, Continuation continuation) {
        super(2, continuation);
        this.f49569b = refresh;
        this.f49570c = asyncPagingDataDiffer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1(this.f49569b, this.f49570c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f49568a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        return PlaceholderPaddedListDiffHelperKt.a(this.f49569b.b(), this.f49569b.a(), this.f49570c.f49542a);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AsyncPagingDataDiffer$presenter$1$presentPagingDataEvent$2$diffResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
