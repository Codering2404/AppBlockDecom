package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface StaggeredGridCells {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Adaptive implements StaggeredGridCells {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f8597a;

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] a(Density density, int i3, int i4) {
            return LazyStaggeredGridCellsKt.b(i3, Math.max((i3 + i4) / (density.z0(this.f8597a) + i4), 1), i4);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Adaptive) && Dp.i(this.f8597a, ((Adaptive) obj).f8597a);
        }

        public int hashCode() {
            return Dp.j(this.f8597a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Fixed implements StaggeredGridCells {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f8598a;

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] a(Density density, int i3, int i4) {
            return LazyStaggeredGridCellsKt.b(i3, this.f8598a, i4);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Fixed) && this.f8598a == ((Fixed) obj).f8598a;
        }

        public int hashCode() {
            return -this.f8598a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FixedSize implements StaggeredGridCells {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f8599a;

        @Override // androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
        public int[] a(Density density, int i3, int i4) {
            int iZ0 = density.z0(this.f8599a);
            int i5 = iZ0 + i4;
            int i6 = i4 + i3;
            if (i5 >= i6) {
                return new int[]{i3};
            }
            int i7 = i6 / i5;
            int[] iArr = new int[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                iArr[i8] = iZ0;
            }
            return iArr;
        }

        public boolean equals(Object obj) {
            return (obj instanceof FixedSize) && Dp.i(this.f8599a, ((FixedSize) obj).f8599a);
        }

        public int hashCode() {
            return Dp.j(this.f8599a);
        }
    }

    int[] a(Density density, int i3, int i4);
}
