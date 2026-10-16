package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class DefaultLazyListPrefetchStrategy implements LazyListPrefetchStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f7325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7326b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LazyLayoutPrefetchState.PrefetchHandle f7327c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7328d;

    public DefaultLazyListPrefetchStrategy(int i3) {
        this.f7325a = i3;
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void a(NestedPrefetchScope nestedPrefetchScope, int i3) {
        int i4 = this.f7325a;
        for (int i5 = 0; i5 < i4; i5++) {
            nestedPrefetchScope.a(i3 + i5);
        }
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void c(LazyListPrefetchScope lazyListPrefetchScope, float f3, LazyListLayoutInfo lazyListLayoutInfo) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3;
        if (lazyListLayoutInfo.h().isEmpty()) {
            return;
        }
        boolean z2 = f3 < 0.0f;
        int index = z2 ? ((LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.h())).getIndex() + 1 : ((LazyListItemInfo) CollectionsKt.first(lazyListLayoutInfo.h())).getIndex() - 1;
        if (index < 0 || index >= lazyListLayoutInfo.e()) {
            return;
        }
        if (index != this.f7326b) {
            if (this.f7328d != z2 && (prefetchHandle3 = this.f7327c) != null) {
                prefetchHandle3.cancel();
            }
            this.f7328d = z2;
            this.f7326b = index;
            this.f7327c = lazyListPrefetchScope.a(index);
        }
        if (!z2) {
            if (lazyListLayoutInfo.g() - ((LazyListItemInfo) CollectionsKt.first(lazyListLayoutInfo.h())).getOffset() >= f3 || (prefetchHandle = this.f7327c) == null) {
                return;
            }
            prefetchHandle.a();
            return;
        }
        LazyListItemInfo lazyListItemInfo = (LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.h());
        if (((lazyListItemInfo.getOffset() + lazyListItemInfo.getSize()) + lazyListLayoutInfo.f()) - lazyListLayoutInfo.d() >= (-f3) || (prefetchHandle2 = this.f7327c) == null) {
            return;
        }
        prefetchHandle2.a();
    }

    @Override // androidx.compose.foundation.lazy.LazyListPrefetchStrategy
    public void d(LazyListPrefetchScope lazyListPrefetchScope, LazyListLayoutInfo lazyListLayoutInfo) {
        if (this.f7326b == -1 || lazyListLayoutInfo.h().isEmpty()) {
            return;
        }
        if (this.f7326b != (this.f7328d ? ((LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.h())).getIndex() + 1 : ((LazyListItemInfo) CollectionsKt.first(lazyListLayoutInfo.h())).getIndex() - 1)) {
            this.f7326b = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.f7327c;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.f7327c = null;
        }
    }
}
