package androidx.paging.compose;

import androidx.paging.PagingData;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@DebugMetadata(c = "androidx.paging.compose.LazyPagingItems$collectPagingData$2", f = "LazyPagingItems.kt", l = {179}, m = "invokeSuspend")
final class LazyPagingItems$collectPagingData$2<T> extends SuspendLambda implements Function2<PagingData<T>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f50764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyPagingItems f50765c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyPagingItems$collectPagingData$2(LazyPagingItems lazyPagingItems, Continuation continuation) {
        super(2, continuation);
        this.f50765c = lazyPagingItems;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LazyPagingItems$collectPagingData$2 lazyPagingItems$collectPagingData$2 = new LazyPagingItems$collectPagingData$2(this.f50765c, continuation);
        lazyPagingItems$collectPagingData$2.f50764b = obj;
        return lazyPagingItems$collectPagingData$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(PagingData pagingData, Continuation continuation) {
        return ((LazyPagingItems$collectPagingData$2) create(pagingData, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50763a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PagingData pagingData = (PagingData) this.f50764b;
            LazyPagingItems$pagingDataPresenter$1 lazyPagingItems$pagingDataPresenter$1 = this.f50765c.f50759c;
            this.f50763a = 1;
            if (lazyPagingItems$pagingDataPresenter$1.n(pagingData, this) == objF) {
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
