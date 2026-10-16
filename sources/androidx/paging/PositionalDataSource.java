package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public abstract class PositionalDataSource<T> extends DataSource<Integer, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f50513f = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a(LoadInitialParams params, int i3) {
            Intrinsics.checkNotNullParameter(params, "params");
            int i4 = params.f50514a;
            int i5 = params.f50515b;
            int i6 = params.f50516c;
            return Math.max(0, Math.min(((((i3 - i5) + i6) - 1) / i6) * i6, (i4 / i6) * i6));
        }

        public final int b(LoadInitialParams params, int i3, int i4) {
            Intrinsics.checkNotNullParameter(params, "params");
            return Math.min(i4 - i3, params.f50515b);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadInitialCallback<T> {
        public abstract void a(List list, int i3, int i4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class LoadInitialParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f50514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f50515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f50516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f50517d;

        public LoadInitialParams(int i3, int i4, int i5, boolean z2) {
            this.f50514a = i3;
            this.f50515b = i4;
            this.f50516c = i5;
            this.f50517d = z2;
            if (i3 < 0) {
                throw new IllegalStateException(("invalid start position: " + i3).toString());
            }
            if (i4 < 0) {
                throw new IllegalStateException(("invalid load size: " + i4).toString());
            }
            if (i5 >= 0) {
                return;
            }
            throw new IllegalStateException(("invalid page size: " + i5).toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadRangeCallback<T> {
        public abstract void a(List list);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class LoadRangeParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f50518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f50519b;

        public LoadRangeParams(int i3, int i4) {
            this.f50518a = i3;
            this.f50519b = i4;
        }
    }

    public PositionalDataSource() {
        super(DataSource.KeyType.POSITIONAL);
    }

    public static final int i(LoadInitialParams loadInitialParams, int i3) {
        return f50513f.a(loadInitialParams, i3);
    }

    public static final int j(LoadInitialParams loadInitialParams, int i3, int i4) {
        return f50513f.b(loadInitialParams, i3, i4);
    }

    private final Object n(final LoadRangeParams loadRangeParams, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        o(loadRangeParams, new LoadRangeCallback<T>() { // from class: androidx.paging.PositionalDataSource$loadRange$2$1
            @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
            public void a(List data) {
                Intrinsics.checkNotNullParameter(data, "data");
                int i3 = loadRangeParams.f50518a;
                Integer numValueOf = i3 == 0 ? null : Integer.valueOf(i3);
                if (this.e()) {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(DataSource.BaseResult.f49691f.b()));
                } else {
                    CancellableContinuation cancellableContinuation2 = cancellableContinuationImpl;
                    Result.Companion companion2 = Result.f139772b;
                    cancellableContinuation2.resumeWith(Result.b(new DataSource.BaseResult(data, numValueOf, Integer.valueOf(loadRangeParams.f50518a + data.size()), 0, 0, 24, null)));
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // androidx.paging.DataSource
    public final Object f(DataSource.Params params, Continuation continuation) {
        if (params.e() != LoadType.REFRESH) {
            Object objB = params.b();
            Intrinsics.checkNotNull(objB);
            int iIntValue = ((Number) objB).intValue();
            int iC = params.c();
            if (params.e() == LoadType.PREPEND) {
                iC = Math.min(iC, iIntValue);
                iIntValue -= iC;
            }
            return n(new LoadRangeParams(iIntValue, iC), continuation);
        }
        int iA = params.a();
        int iMax = 0;
        if (params.b() != null) {
            int iIntValue2 = ((Number) params.b()).intValue();
            if (params.d()) {
                iA = Math.max(iA / params.c(), 2) * params.c();
                iMax = Math.max(0, ((iIntValue2 - (iA / 2)) / params.c()) * params.c());
            } else {
                iMax = Math.max(0, iIntValue2 - (iA / 2));
            }
        }
        return m(new LoadInitialParams(iMax, iA, params.c(), params.d()), continuation);
    }

    @Override // androidx.paging.DataSource
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public final Integer b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        throw new IllegalStateException("Cannot get key by item in positionalDataSource");
    }

    public abstract void l(LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback);

    public final Object m(final LoadInitialParams loadInitialParams, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        l(loadInitialParams, new LoadInitialCallback<T>() { // from class: androidx.paging.PositionalDataSource$loadInitial$2$1
            private final void b(PositionalDataSource.LoadInitialParams loadInitialParams2, DataSource.BaseResult baseResult) {
                if (loadInitialParams2.f50517d) {
                    baseResult.e(loadInitialParams2.f50516c);
                }
                cancellableContinuationImpl.resumeWith(Result.b(baseResult));
            }

            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void a(List data, int i3, int i4) {
                Intrinsics.checkNotNullParameter(data, "data");
                if (!this.f50520a.e()) {
                    int size = data.size() + i3;
                    b(loadInitialParams, new DataSource.BaseResult(data, i3 == 0 ? null : Integer.valueOf(i3), size != i4 ? Integer.valueOf(size) : null, i3, (i4 - data.size()) - i3));
                } else {
                    CancellableContinuation cancellableContinuation = cancellableContinuationImpl;
                    Result.Companion companion = Result.f139772b;
                    cancellableContinuation.resumeWith(Result.b(DataSource.BaseResult.f49691f.b()));
                }
            }
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public abstract void o(LoadRangeParams loadRangeParams, LoadRangeCallback loadRangeCallback);

    @Override // androidx.paging.DataSource
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public final PositionalDataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperPositionalDataSource(this, function);
    }
}
