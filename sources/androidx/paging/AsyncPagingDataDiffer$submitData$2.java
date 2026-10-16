package androidx.paging;

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
@DebugMetadata(c = "androidx.paging.AsyncPagingDataDiffer$submitData$2", f = "AsyncPagingDataDiffer.kt", l = {397}, m = "invokeSuspend")
final class AsyncPagingDataDiffer$submitData$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AsyncPagingDataDiffer f49584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f49585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PagingData f49586d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AsyncPagingDataDiffer$submitData$2(AsyncPagingDataDiffer asyncPagingDataDiffer, int i3, PagingData pagingData, Continuation continuation) {
        super(2, continuation);
        this.f49584b = asyncPagingDataDiffer;
        this.f49585c = i3;
        this.f49586d = pagingData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new AsyncPagingDataDiffer$submitData$2(this.f49584b, this.f49585c, this.f49586d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49583a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f49584b.f49549h.get() == this.f49585c) {
                PagingDataPresenter pagingDataPresenterN = this.f49584b.n();
                PagingData pagingData = this.f49586d;
                this.f49583a = 1;
                if (pagingDataPresenterN.n(pagingData, this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((AsyncPagingDataDiffer$submitData$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
