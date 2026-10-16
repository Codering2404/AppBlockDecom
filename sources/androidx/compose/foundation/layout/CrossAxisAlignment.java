package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public abstract class CrossAxisAlignment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f6736a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final CrossAxisAlignment f6737b = CenterCrossAxisAlignment.f6741e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final CrossAxisAlignment f6738c = StartCrossAxisAlignment.f6744e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final CrossAxisAlignment f6739d = EndCrossAxisAlignment.f6742e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class AlignmentLineCrossAxisAlignment extends CrossAxisAlignment {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AlignmentLineProvider f6740e;

        public AlignmentLineCrossAxisAlignment(AlignmentLineProvider alignmentLineProvider) {
            super(null);
            this.f6740e = alignmentLineProvider;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int a(int i3, LayoutDirection layoutDirection, Placeable placeable, int i4) {
            int iA = this.f6740e.a(placeable);
            if (iA == Integer.MIN_VALUE) {
                return 0;
            }
            int i5 = i4 - iA;
            return layoutDirection == LayoutDirection.f30002b ? i3 - i5 : i5;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public Integer b(Placeable placeable) {
            return Integer.valueOf(this.f6740e.a(placeable));
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public boolean c() {
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CenterCrossAxisAlignment extends CrossAxisAlignment {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final CenterCrossAxisAlignment f6741e = new CenterCrossAxisAlignment();

        private CenterCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int a(int i3, LayoutDirection layoutDirection, Placeable placeable, int i4) {
            return i3 / 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CrossAxisAlignment a(AlignmentLineProvider alignmentLineProvider) {
            return new AlignmentLineCrossAxisAlignment(alignmentLineProvider);
        }

        public final CrossAxisAlignment b(Alignment.Horizontal horizontal) {
            return new HorizontalCrossAxisAlignment(horizontal);
        }

        public final CrossAxisAlignment c(Alignment.Vertical vertical) {
            return new VerticalCrossAxisAlignment(vertical);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class EndCrossAxisAlignment extends CrossAxisAlignment {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final EndCrossAxisAlignment f6742e = new EndCrossAxisAlignment();

        private EndCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int a(int i3, LayoutDirection layoutDirection, Placeable placeable, int i4) {
            if (layoutDirection == LayoutDirection.f30001a) {
                return i3;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class HorizontalCrossAxisAlignment extends CrossAxisAlignment {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Alignment.Horizontal f6743e;

        public HorizontalCrossAxisAlignment(Alignment.Horizontal horizontal) {
            super(null);
            this.f6743e = horizontal;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int a(int i3, LayoutDirection layoutDirection, Placeable placeable, int i4) {
            return this.f6743e.a(0, i3, layoutDirection);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof HorizontalCrossAxisAlignment) && Intrinsics.areEqual(this.f6743e, ((HorizontalCrossAxisAlignment) obj).f6743e);
        }

        public int hashCode() {
            return this.f6743e.hashCode();
        }

        public String toString() {
            return "HorizontalCrossAxisAlignment(horizontal=" + this.f6743e + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class StartCrossAxisAlignment extends CrossAxisAlignment {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final StartCrossAxisAlignment f6744e = new StartCrossAxisAlignment();

        private StartCrossAxisAlignment() {
            super(null);
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int a(int i3, LayoutDirection layoutDirection, Placeable placeable, int i4) {
            if (layoutDirection == LayoutDirection.f30001a) {
                return 0;
            }
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class VerticalCrossAxisAlignment extends CrossAxisAlignment {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Alignment.Vertical f6745e;

        public VerticalCrossAxisAlignment(Alignment.Vertical vertical) {
            super(null);
            this.f6745e = vertical;
        }

        @Override // androidx.compose.foundation.layout.CrossAxisAlignment
        public int a(int i3, LayoutDirection layoutDirection, Placeable placeable, int i4) {
            return this.f6745e.a(0, i3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof VerticalCrossAxisAlignment) && Intrinsics.areEqual(this.f6745e, ((VerticalCrossAxisAlignment) obj).f6745e);
        }

        public int hashCode() {
            return this.f6745e.hashCode();
        }

        public String toString() {
            return "VerticalCrossAxisAlignment(vertical=" + this.f6745e + ')';
        }
    }

    public /* synthetic */ CrossAxisAlignment(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract int a(int i3, LayoutDirection layoutDirection, Placeable placeable, int i4);

    public Integer b(Placeable placeable) {
        return null;
    }

    public boolean c() {
        return false;
    }

    private CrossAxisAlignment() {
    }
}
