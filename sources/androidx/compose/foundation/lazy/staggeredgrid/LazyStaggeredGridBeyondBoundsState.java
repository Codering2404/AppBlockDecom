package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.RangesKt;

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
public final class LazyStaggeredGridBeyondBoundsState implements LazyLayoutBeyondBoundsState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyStaggeredGridState f8295a;

    public LazyStaggeredGridBeyondBoundsState(LazyStaggeredGridState lazyStaggeredGridState) {
        this.f8295a = lazyStaggeredGridState;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public int a() {
        return this.f8295a.y().e();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public int b() {
        if (this.f8295a.y().h().isEmpty()) {
            return 0;
        }
        int iC = LazyStaggeredGridMeasureResultKt.c(this.f8295a.y());
        int iD = LazyStaggeredGridMeasureResultKt.d(this.f8295a.y());
        if (iD == 0) {
            return 1;
        }
        return RangesKt.f(iC / iD, 1);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public boolean c() {
        return !this.f8295a.y().h().isEmpty();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public int d() {
        return this.f8295a.s();
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsState
    public int e() {
        return ((LazyStaggeredGridItemInfo) CollectionsKt.last(this.f8295a.y().h())).getIndex();
    }
}
