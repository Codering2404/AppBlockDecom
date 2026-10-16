package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.ItemKeyedDataSource;
import java.util.IdentityHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class WrapperItemKeyedDataSource<K, A, B> extends ItemKeyedDataSource<K, B> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ItemKeyedDataSource f50729f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function f50730g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final IdentityHashMap f50731h;

    public WrapperItemKeyedDataSource(ItemKeyedDataSource source, Function listFunction) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(listFunction, "listFunction");
        this.f50729f = source;
        this.f50730g = listFunction;
        this.f50731h = new IdentityHashMap();
    }

    @Override // androidx.paging.DataSource
    public void a(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50729f.a(onInvalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public void d() {
        this.f50729f.d();
    }

    @Override // androidx.paging.DataSource
    public boolean e() {
        return this.f50729f.e();
    }

    @Override // androidx.paging.DataSource
    public void h(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50729f.h(onInvalidatedCallback);
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public Object k(Object item) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "item");
        synchronized (this.f50731h) {
            obj = this.f50731h.get(item);
            Intrinsics.checkNotNull(obj);
        }
        return obj;
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void l(ItemKeyedDataSource.LoadParams params, final ItemKeyedDataSource.LoadCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f50729f.l(params, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource$loadAfter$1
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void n(ItemKeyedDataSource.LoadParams params, final ItemKeyedDataSource.LoadCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f50729f.n(params, new ItemKeyedDataSource.LoadCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource$loadBefore$1
        });
    }

    @Override // androidx.paging.ItemKeyedDataSource
    public void p(ItemKeyedDataSource.LoadInitialParams params, final ItemKeyedDataSource.LoadInitialCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f50729f.p(params, new ItemKeyedDataSource.LoadInitialCallback<A>() { // from class: androidx.paging.WrapperItemKeyedDataSource$loadInitial$1
        });
    }
}
