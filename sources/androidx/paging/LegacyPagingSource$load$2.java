package androidx.paging;

import androidx.paging.DataSource;
import androidx.paging.PagingSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.paging.LegacyPagingSource$load$2", f = "LegacyPagingSource.jvm.kt", l = {110}, m = "invokeSuspend")
final class LegacyPagingSource$load$2<Key, Value> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PagingSource.LoadResult.Page<Key, Value>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f49869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LegacyPagingSource f49870b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DataSource.Params f49871c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ PagingSource.LoadParams f49872d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyPagingSource$load$2(LegacyPagingSource legacyPagingSource, DataSource.Params params, PagingSource.LoadParams loadParams, Continuation continuation) {
        super(2, continuation);
        this.f49870b = legacyPagingSource;
        this.f49871c = params;
        this.f49872d = loadParams;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new LegacyPagingSource$load$2(this.f49870b, this.f49871c, this.f49872d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f49869a;
        if (i3 == 0) {
            ResultKt.b(obj);
            DataSource dataSourceJ = this.f49870b.j();
            DataSource.Params params = this.f49871c;
            this.f49869a = 1;
            obj = dataSourceJ.f(params, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        PagingSource.LoadParams loadParams = this.f49872d;
        DataSource.BaseResult baseResult = (DataSource.BaseResult) obj;
        List list = baseResult.f49692a;
        return new PagingSource.LoadResult.Page(list, (list.isEmpty() && (loadParams instanceof PagingSource.LoadParams.Prepend)) ? null : baseResult.d(), (baseResult.f49692a.isEmpty() && (loadParams instanceof PagingSource.LoadParams.Append)) ? null : baseResult.c(), baseResult.b(), baseResult.a());
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LegacyPagingSource$load$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
