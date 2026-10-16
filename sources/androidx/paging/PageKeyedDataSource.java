package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;

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
@Deprecated
@Metadata
public abstract class PageKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadCallback<Key, Value> {
        public abstract void a(List list, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadInitialCallback<Key, Value> {
        public abstract void a(List list, int i3, int i4, Object obj, Object obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class LoadInitialParams<Key> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f50242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f50243b;

        public LoadInitialParams(int i3, boolean z2) {
            this.f50242a = i3;
            this.f50243b = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class LoadParams<Key> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f50244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f50245b;

        public LoadParams(Object key, int i3) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f50244a = key;
            this.f50245b = i3;
        }
    }

    public PageKeyedDataSource() {
        super(DataSource.KeyType.PAGE_KEYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LoadCallback j(final CancellableContinuation cancellableContinuation, final boolean z2) {
        return new LoadCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$continuationAsCallback$1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public void a(List data, Object obj) {
                Intrinsics.checkNotNullParameter(data, "data");
                CancellableContinuation cancellableContinuation2 = cancellableContinuation;
                Result.Companion companion = Result.f139772b;
                boolean z3 = z2;
                cancellableContinuation2.resumeWith(Result.b(new DataSource.BaseResult(data, z3 ? null : obj, z3 ? obj : null, 0, 0, 24, null)));
            }
        };
    }

    private final Object k(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        l(loadParams, j(cancellableContinuationImpl, true));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    private final Object m(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        n(loadParams, j(cancellableContinuationImpl, false));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    private final Object o(LoadInitialParams loadInitialParams, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        p(loadInitialParams, new LoadInitialCallback<Key, Value>() { // from class: androidx.paging.PageKeyedDataSource$loadInitial$2$1
            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void a(List data, int i3, int i4, Object obj, Object obj2) {
                Intrinsics.checkNotNullParameter(data, "data");
                CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                Result.Companion companion = Result.f139772b;
                cancellableContinuation.resumeWith(Result.b(new DataSource.BaseResult(data, obj, obj2, i3, (i4 - data.size()) - i3)));
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // androidx.paging.DataSource
    public Object b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        throw new IllegalStateException("Cannot get key by item in pageKeyedDataSource");
    }

    @Override // androidx.paging.DataSource
    public final Object f(DataSource.Params params, Continuation continuation) {
        if (params.e() == LoadType.REFRESH) {
            return o(new LoadInitialParams(params.a(), params.d()), continuation);
        }
        if (params.b() == null) {
            return DataSource.BaseResult.f49691f.b();
        }
        if (params.e() == LoadType.PREPEND) {
            return m(new LoadParams(params.b(), params.c()), continuation);
        }
        if (params.e() == LoadType.APPEND) {
            return k(new LoadParams(params.b(), params.c()), continuation);
        }
        throw new IllegalArgumentException("Unsupported type " + params.e());
    }

    public abstract void l(LoadParams loadParams, LoadCallback loadCallback);

    public abstract void n(LoadParams loadParams, LoadCallback loadCallback);

    public abstract void p(LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback);

    @Override // androidx.paging.DataSource
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final PageKeyedDataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPageKeyedDataSource(this, function);
    }
}
