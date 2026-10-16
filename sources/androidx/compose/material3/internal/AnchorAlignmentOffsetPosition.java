package androidx.compose.material3.internal;

import androidx.compose.material3.internal.MenuPosition;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.unit.LayoutDirection;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnchorAlignmentOffsetPosition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AnchorAlignmentOffsetPosition f21785a = new AnchorAlignmentOffsetPosition();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Horizontal implements MenuPosition.Horizontal {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Alignment.Horizontal f21786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Alignment.Horizontal f21787b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f21788c;

        public Horizontal(Alignment.Horizontal horizontal, Alignment.Horizontal horizontal2, int i3) {
            this.f21786a = horizontal;
            this.f21787b = horizontal2;
            this.f21788c = i3;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Horizontal
        public int a(IntRect intRect, long j3, int i3, LayoutDirection layoutDirection) {
            int iA = this.f21787b.a(0, intRect.l(), layoutDirection);
            return intRect.g() + iA + (-this.f21786a.a(0, i3, layoutDirection)) + (layoutDirection == LayoutDirection.f30001a ? this.f21788c : -this.f21788c);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Horizontal)) {
                return false;
            }
            Horizontal horizontal = (Horizontal) obj;
            return Intrinsics.areEqual(this.f21786a, horizontal.f21786a) && Intrinsics.areEqual(this.f21787b, horizontal.f21787b) && this.f21788c == horizontal.f21788c;
        }

        public int hashCode() {
            return (((this.f21786a.hashCode() * 31) + this.f21787b.hashCode()) * 31) + Integer.hashCode(this.f21788c);
        }

        public String toString() {
            return "Horizontal(menuAlignment=" + this.f21786a + ", anchorAlignment=" + this.f21787b + ", offset=" + this.f21788c + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Vertical implements MenuPosition.Vertical {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Alignment.Vertical f21789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Alignment.Vertical f21790b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f21791c;

        public Vertical(Alignment.Vertical vertical, Alignment.Vertical vertical2, int i3) {
            this.f21789a = vertical;
            this.f21790b = vertical2;
            this.f21791c = i3;
        }

        @Override // androidx.compose.material3.internal.MenuPosition.Vertical
        public int a(IntRect intRect, long j3, int i3) {
            int iA = this.f21790b.a(0, intRect.f());
            return intRect.j() + iA + (-this.f21789a.a(0, i3)) + this.f21791c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Vertical)) {
                return false;
            }
            Vertical vertical = (Vertical) obj;
            return Intrinsics.areEqual(this.f21789a, vertical.f21789a) && Intrinsics.areEqual(this.f21790b, vertical.f21790b) && this.f21791c == vertical.f21791c;
        }

        public int hashCode() {
            return (((this.f21789a.hashCode() * 31) + this.f21790b.hashCode()) * 31) + Integer.hashCode(this.f21791c);
        }

        public String toString() {
            return "Vertical(menuAlignment=" + this.f21789a + ", anchorAlignment=" + this.f21790b + ", offset=" + this.f21791c + ')';
        }
    }

    private AnchorAlignmentOffsetPosition() {
    }
}
