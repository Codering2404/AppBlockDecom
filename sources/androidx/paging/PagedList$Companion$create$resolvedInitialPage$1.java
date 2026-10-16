package androidx.paging;

import androidx.paging.PagingSource;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
@DebugMetadata(c = "androidx.paging.PagedList$Companion$create$resolvedInitialPage$1", f = "PagedList.kt", l = {178}, m = "invokeSuspend")
final class PagedList$Companion$create$resolvedInitialPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.LoadResult.Page<Object, Object>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50266a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagingSource f50267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PagingSource.LoadParams.Refresh f50268c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagedList$Companion$create$resolvedInitialPage$1(PagingSource pagingSource, PagingSource.LoadParams.Refresh refresh, Continuation continuation) {
        super(2, continuation);
        this.f50267b = pagingSource;
        this.f50268c = refresh;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PagedList$Companion$create$resolvedInitialPage$1(this.f50267b, this.f50268c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f50266a;
        if (i3 == 0) {
            ResultKt.b(obj);
            PagingSource pagingSource = this.f50267b;
            PagingSource.LoadParams.Refresh refresh = this.f50268c;
            this.f50266a = 1;
            obj = pagingSource.g(refresh, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        PagingSource.LoadResult loadResult = (PagingSource.LoadResult) obj;
        if (loadResult instanceof PagingSource.LoadResult.Page) {
            return (PagingSource.LoadResult.Page) loadResult;
        }
        if (loadResult instanceof PagingSource.LoadResult.Error) {
            throw ((PagingSource.LoadResult.Error) loadResult).a();
        }
        if (loadResult instanceof PagingSource.LoadResult.Invalid) {
            throw new IllegalStateException("Failed to create PagedList. The provided PagingSource returned LoadResult.Invalid, but a LoadResult.Page was expected. To use a PagingSource which supports invalidation, use a PagedList builder that accepts a factory method for PagingSource or DataSource.Factory, such as LivePagedList.");
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PagedList$Companion$create$resolvedInitialPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
