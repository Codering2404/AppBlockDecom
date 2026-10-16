package androidx.paging;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.paging.PagedList$dispatchStateChangeAsync$1", f = "PagedList.kt", l = {}, m = "invokeSuspend")
final class PagedList$dispatchStateChangeAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f50282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ PagedList f50283b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LoadType f50284c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LoadState f50285d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PagedList$dispatchStateChangeAsync$1(PagedList pagedList, LoadType loadType, LoadState loadState, Continuation continuation) {
        super(2, continuation);
        this.f50283b = pagedList;
        this.f50284c = loadType;
        this.f50285d = loadState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new PagedList$dispatchStateChangeAsync$1(this.f50283b, this.f50284c, this.f50285d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f50282a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        CollectionsKt.removeAll(this.f50283b.f50265j, (Function1) new Function1<WeakReference<Function2<? super LoadType, ? super LoadState, ? extends Unit>>, Boolean>() { // from class: androidx.paging.PagedList$dispatchStateChangeAsync$1.1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(WeakReference it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(it.get() == null);
            }
        });
        List list = this.f50283b.f50265j;
        LoadType loadType = this.f50284c;
        LoadState loadState = this.f50285d;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Function2 function2 = (Function2) ((WeakReference) it.next()).get();
            if (function2 != null) {
                function2.invoke(loadType, loadState);
            }
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PagedList$dispatchStateChangeAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
