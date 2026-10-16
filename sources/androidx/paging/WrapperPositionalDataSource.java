package androidx.paging;

import androidx.arch.core.util.Function;
import androidx.paging.DataSource;
import androidx.paging.PositionalDataSource;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class WrapperPositionalDataSource<A, B> extends PositionalDataSource<B> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final PositionalDataSource f50746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Function f50747h;

    public WrapperPositionalDataSource(PositionalDataSource source, Function listFunction) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(listFunction, "listFunction");
        this.f50746g = source;
        this.f50747h = listFunction;
    }

    @Override // androidx.paging.DataSource
    public void a(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50746g.a(onInvalidatedCallback);
    }

    @Override // androidx.paging.DataSource
    public void d() {
        this.f50746g.d();
    }

    @Override // androidx.paging.DataSource
    public boolean e() {
        return this.f50746g.e();
    }

    @Override // androidx.paging.DataSource
    public void h(DataSource.InvalidatedCallback onInvalidatedCallback) {
        Intrinsics.checkNotNullParameter(onInvalidatedCallback, "onInvalidatedCallback");
        this.f50746g.h(onInvalidatedCallback);
    }

    @Override // androidx.paging.PositionalDataSource
    public void l(PositionalDataSource.LoadInitialParams params, final PositionalDataSource.LoadInitialCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f50746g.l(params, new PositionalDataSource.LoadInitialCallback<A>() { // from class: androidx.paging.WrapperPositionalDataSource$loadInitial$1
            @Override // androidx.paging.PositionalDataSource.LoadInitialCallback
            public void a(List data, int i3, int i4) {
                Intrinsics.checkNotNullParameter(data, "data");
                callback.a(DataSource.f49686e.a(this.q(), data), i3, i4);
            }
        });
    }

    @Override // androidx.paging.PositionalDataSource
    public void o(PositionalDataSource.LoadRangeParams params, final PositionalDataSource.LoadRangeCallback callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.f50746g.o(params, new PositionalDataSource.LoadRangeCallback<A>() { // from class: androidx.paging.WrapperPositionalDataSource$loadRange$1
            @Override // androidx.paging.PositionalDataSource.LoadRangeCallback
            public void a(List data) {
                Intrinsics.checkNotNullParameter(data, "data");
                callback.a(DataSource.f49686e.a(this.q(), data));
            }
        });
    }

    public final Function q() {
        return this.f50747h;
    }
}
