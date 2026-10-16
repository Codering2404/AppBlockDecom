package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public interface GridCells {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Adaptive implements GridCells {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f7636a;

        public /* synthetic */ Adaptive(float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3);
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List a(Density density, int i3, int i4) {
            return LazyGridDslKt.f(i3, Math.max((i3 + i4) / (density.z0(this.f7636a) + i4), 1), i4);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Adaptive) && Dp.i(this.f7636a, ((Adaptive) obj).f7636a);
        }

        public int hashCode() {
            return Dp.j(this.f7636a);
        }

        private Adaptive(float f3) {
            this.f7636a = f3;
            if (Dp.f(f3, Dp.g((float) 0)) > 0) {
                return;
            }
            InlineClassHelperKt.a("Provided min size should be larger than zero.");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Fixed implements GridCells {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f7637a;

        public Fixed(int i3) {
            this.f7637a = i3;
            if (i3 > 0) {
                return;
            }
            InlineClassHelperKt.a("Provided count should be larger than zero");
        }

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List a(Density density, int i3, int i4) {
            return LazyGridDslKt.f(i3, this.f7637a, i4);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Fixed) && this.f7637a == ((Fixed) obj).f7637a;
        }

        public int hashCode() {
            return -this.f7637a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FixedSize implements GridCells {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f7638a;

        @Override // androidx.compose.foundation.lazy.grid.GridCells
        public List a(Density density, int i3, int i4) {
            int iZ0 = density.z0(this.f7638a);
            int i5 = iZ0 + i4;
            int i6 = i4 + i3;
            if (i5 >= i6) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(Integer.valueOf(i3));
                return arrayList;
            }
            int i7 = i6 / i5;
            ArrayList arrayList2 = new ArrayList(i7);
            for (int i8 = 0; i8 < i7; i8++) {
                arrayList2.add(Integer.valueOf(iZ0));
            }
            return arrayList2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof FixedSize) && Dp.i(this.f7638a, ((FixedSize) obj).f7638a);
        }

        public int hashCode() {
            return Dp.j(this.f7638a);
        }
    }

    List a(Density density, int i3, int i4);
}
