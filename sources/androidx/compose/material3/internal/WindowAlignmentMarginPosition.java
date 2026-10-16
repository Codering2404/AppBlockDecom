package androidx.compose.material3.internal;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class WindowAlignmentMarginPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WindowAlignmentMarginPosition f22193a = new WindowAlignmentMarginPosition();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Horizontal implements MenuPosition.Horizontal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Alignment.Horizontal f22194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22195b;

        public Horizontal(Alignment.Horizontal horizontal, int i3) {
            this.f22194a = horizontal;
            this.f22195b = i3;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
        public int a(IntRect intRect, long j3, int i3, LayoutDirection layoutDirection) {
            return i3 >= IntSize.g(j3) - (this.f22195b * 2) ? Alignment.f25072a.g().a(i3, IntSize.g(j3), layoutDirection) : RangesKt.p(this.f22194a.a(i3, IntSize.g(j3), layoutDirection), this.f22195b, (IntSize.g(j3) - this.f22195b) - i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Horizontal)) {
                return false;
            }
            Horizontal horizontal = (Horizontal) obj;
            return Intrinsics.areEqual(this.f22194a, horizontal.f22194a) && this.f22195b == horizontal.f22195b;
        }

        public int hashCode() {
            return (this.f22194a.hashCode() * 31) + Integer.hashCode(this.f22195b);
        }

        public String toString() {
            return "Horizontal(alignment=" + this.f22194a + ", margin=" + this.f22195b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Vertical implements MenuPosition.Vertical {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Alignment.Vertical f22196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f22197b;

        public Vertical(Alignment.Vertical vertical, int i3) {
            this.f22196a = vertical;
            this.f22197b = i3;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Vertical
        public int a(IntRect intRect, long j3, int i3) {
            return i3 >= IntSize.f(j3) - (this.f22197b * 2) ? Alignment.f25072a.i().a(i3, IntSize.f(j3)) : RangesKt.p(this.f22196a.a(i3, IntSize.f(j3)), this.f22197b, (IntSize.f(j3) - this.f22197b) - i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Vertical)) {
                return false;
            }
            Vertical vertical = (Vertical) obj;
            return Intrinsics.areEqual(this.f22196a, vertical.f22196a) && this.f22197b == vertical.f22197b;
        }

        public int hashCode() {
            return (this.f22196a.hashCode() * 31) + Integer.hashCode(this.f22197b);
        }

        public String toString() {
            return "Vertical(alignment=" + this.f22196a + ", margin=" + this.f22197b + ')';
        }
    }

    private WindowAlignmentMarginPosition() {
    }
}
