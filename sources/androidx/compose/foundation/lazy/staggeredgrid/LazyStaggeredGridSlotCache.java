package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class LazyStaggeredGridSlotCache implements LazyGridStaggeredGridSlotsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f8538a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8539b = ConstraintsKt.b(0, 0, 0, 0, 15, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f8540c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LazyStaggeredGridSlots f8541d;

    public LazyStaggeredGridSlotCache(Function2 function2) {
        this.f8538a = function2;
    }

    @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyGridStaggeredGridSlotsProvider
    public LazyStaggeredGridSlots a(Density density, long j3) {
        if (this.f8541d != null && Constraints.f(this.f8539b, j3) && this.f8540c == density.getDensity()) {
            LazyStaggeredGridSlots lazyStaggeredGridSlots = this.f8541d;
            Intrinsics.checkNotNull(lazyStaggeredGridSlots);
            return lazyStaggeredGridSlots;
        }
        this.f8539b = j3;
        this.f8540c = density.getDensity();
        LazyStaggeredGridSlots lazyStaggeredGridSlots2 = (LazyStaggeredGridSlots) this.f8538a.invoke(density, Constraints.a(j3));
        this.f8541d = lazyStaggeredGridSlots2;
        return lazyStaggeredGridSlots2;
    }
}
