package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import java.util.List;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class WrapperPageKeyedDataSource<K, A, B> extends PageKeyedDataSource<K, B> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PageKeyedDataSource f50738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Function f50739g;

    public WrapperPageKeyedDataSource(PageKeyedDataSource source, Function listFunction) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(listFunction, "listFunction");
        this.f50738f = source;
        this.f50739g = listFunction;
    }

    @Override // androidx.paging.DataSource
    public void a(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50738f.a(onInvalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public void d() {
        this.f50738f.d();
    }

    @Override // androidx.paging.DataSource
    public boolean e() {
        return this.f50738f.e();
    }

    @Override // androidx.paging.DataSource
    public void h(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50738f.h(onInvalidatedCallback);
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void n(PageKeyedDataSource.LoadParams params, final PageKeyedDataSource.LoadCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f50738f.n(params, new PageKeyedDataSource.LoadCallback<K, A>() { // from class: androidx.paging.WrapperPageKeyedDataSource$loadBefore$1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public void a(List data, Object obj) {
                Intrinsics.checkNotNullParameter(data, "data");
                callback.a(DataSource.f49686e.a(this.f50739g, data), obj);
            }
        });
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void p(PageKeyedDataSource.LoadInitialParams params, final PageKeyedDataSource.LoadInitialCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f50738f.p(params, new PageKeyedDataSource.LoadInitialCallback<K, A>() { // from class: androidx.paging.WrapperPageKeyedDataSource$loadInitial$1
            @Override // androidx.paging.PageKeyedDataSource.LoadInitialCallback
            public void a(List data, int i3, int i4, Object obj, Object obj2) {
                Intrinsics.checkNotNullParameter(data, "data");
                callback.a(DataSource.f49686e.a(this.f50744a.f50739g, data), i3, i4, obj, obj2);
            }
        });
    }

    @Override // androidx.paging.PageKeyedDataSource
    public void l(PageKeyedDataSource.LoadParams params, final PageKeyedDataSource.LoadCallback loadCallback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(loadCallback, MHoiDDglUlPJC.FxnUicBDA);
        this.f50738f.l(params, new PageKeyedDataSource.LoadCallback<K, A>() { // from class: androidx.paging.WrapperPageKeyedDataSource$loadAfter$1
            @Override // androidx.paging.PageKeyedDataSource.LoadCallback
            public void a(List data, Object obj) {
                Intrinsics.checkNotNullParameter(data, "data");
                loadCallback.a(DataSource.f49686e.a(this.f50739g, data), obj);
            }
        });
    }
}
