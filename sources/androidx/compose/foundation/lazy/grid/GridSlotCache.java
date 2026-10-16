package androidx.compose.foundation.lazy.grid;

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
final class GridSlotCache implements LazyGridSlotsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function2 f7640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7641b = ConstraintsKt.b(0, 0, 0, 0, 15, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LazyGridSlots f7643d;

    public GridSlotCache(Function2 function2) {
        this.f7640a = function2;
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridSlotsProvider
    public LazyGridSlots a(Density density, long j3) {
        if (this.f7643d != null && Constraints.f(this.f7641b, j3) && this.f7642c == density.getDensity()) {
            LazyGridSlots lazyGridSlots = this.f7643d;
            Intrinsics.checkNotNull(lazyGridSlots);
            return lazyGridSlots;
        }
        this.f7641b = j3;
        this.f7642c = density.getDensity();
        LazyGridSlots lazyGridSlots2 = (LazyGridSlots) this.f7640a.invoke(density, Constraints.a(j3));
        this.f7643d = lazyGridSlots2;
        return lazyGridSlots2;
    }
}
