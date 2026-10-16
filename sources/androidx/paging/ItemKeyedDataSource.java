package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
public abstract class ItemKeyedDataSource<Key, Value> extends DataSource<Key, Value> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadCallback<Value> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static abstract class LoadInitialCallback<Value> extends LoadCallback<Value> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class LoadInitialParams<Key> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f49828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f49830c;

        public LoadInitialParams(Object obj, int i3, boolean z2) {
            this.f49828a = obj;
            this.f49829b = i3;
            this.f49830c = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class LoadParams<Key> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f49831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49832b;

        public LoadParams(Object key, int i3) {
            Intrinsics.checkNotNullParameter(key, "key");
            this.f49831a = key;
            this.f49832b = i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f49833a;

        static {
            int[] iArr = new int[LoadType.values().length];
            try {
                iArr[LoadType.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadType.PREPEND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadType.APPEND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49833a = iArr;
        }
    }

    public ItemKeyedDataSource() {
        super(DataSource.KeyType.ITEM_KEYED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ItemKeyedDataSource$asCallback$1 j(final CancellableContinuation cancellableContinuation) {
        return new LoadCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$asCallback$1
        };
    }

    @Override // androidx.paging.DataSource
    public Object b(Object item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return k(item);
    }

    @Override // androidx.paging.DataSource
    public final Object f(DataSource.Params params, Continuation continuation) {
        int i3 = WhenMappings.f49833a[params.e().ordinal()];
        if (i3 == 1) {
            return q(new LoadInitialParams(params.b(), params.a(), params.d()), continuation);
        }
        if (i3 == 2) {
            Object objB = params.b();
            Intrinsics.checkNotNull(objB);
            return o(new LoadParams(objB, params.c()), continuation);
        }
        if (i3 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Object objB2 = params.b();
        Intrinsics.checkNotNull(objB2);
        return m(new LoadParams(objB2, params.c()), continuation);
    }

    public abstract Object k(Object obj);

    public abstract void l(LoadParams loadParams, LoadCallback loadCallback);

    public final Object m(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        l(loadParams, j(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public abstract void n(LoadParams loadParams, LoadCallback loadCallback);

    public final Object o(LoadParams loadParams, Continuation continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        n(loadParams, j(cancellableContinuationImpl));
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    public abstract void p(LoadInitialParams loadInitialParams, LoadInitialCallback loadInitialCallback);

    public final Object q(LoadInitialParams loadInitialParams, Continuation continuation) {
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.c(continuation), 1);
        cancellableContinuationImpl.C();
        p(loadInitialParams, new LoadInitialCallback<Value>() { // from class: androidx.paging.ItemKeyedDataSource$loadInitial$2$1
        });
        Object objV = cancellableContinuationImpl.v();
        if (objV == IntrinsicsKt.f()) {
            DebugProbesKt.c(continuation);
        }
        return objV;
    }

    @Override // androidx.paging.DataSource
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public final ItemKeyedDataSource g(Function function) {
        Intrinsics.checkNotNullParameter(function, "function");
        return new WrapperItemKeyedDataSource(this, function);
    }
}
