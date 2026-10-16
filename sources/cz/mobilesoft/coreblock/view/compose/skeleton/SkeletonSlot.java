package cz.mobilesoft.coreblock.view.compose.skeleton;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class SkeletonSlot {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f131965a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BarChartSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f131966b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f131967c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f131968d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f131969e;

        public /* synthetic */ BarChartSlot(int i3, float f3, float f4, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, f3, f4, z2);
        }

        public final int a() {
            return this.f131966b;
        }

        public final float b() {
            return this.f131967c;
        }

        public final float c() {
            return this.f131968d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof BarChartSlot)) {
                return false;
            }
            BarChartSlot barChartSlot = (BarChartSlot) obj;
            return this.f131966b == barChartSlot.f131966b && Dp.i(this.f131967c, barChartSlot.f131967c) && Dp.i(this.f131968d, barChartSlot.f131968d) && this.f131969e == barChartSlot.f131969e;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.f131966b) * 31) + Dp.j(this.f131967c)) * 31) + Dp.j(this.f131968d)) * 31) + Boolean.hashCode(this.f131969e);
        }

        public String toString() {
            return "BarChartSlot(barCount=" + this.f131966b + ", barWidth=" + Dp.k(this.f131967c) + ", chartHeight=" + Dp.k(this.f131968d) + ", uniformHeight=" + this.f131969e + ")";
        }

        private BarChartSlot(int i3, float f3, float f4, boolean z2) {
            super(null);
            this.f131966b = i3;
            this.f131967c = f3;
            this.f131968d = f4;
            this.f131969e = z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CardSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131970b;

        public final float a() {
            return this.f131970b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CardSlot) && Dp.i(this.f131970b, ((CardSlot) obj).f131970b);
        }

        public int hashCode() {
            return Dp.j(this.f131970b);
        }

        public String toString() {
            return "CardSlot(height=" + Dp.k(this.f131970b) + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CenteredCircleSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131971b;

        public final float a() {
            return this.f131971b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CenteredCircleSlot) && Dp.i(this.f131971b, ((CenteredCircleSlot) obj).f131971b);
        }

        public int hashCode() {
            return Dp.j(this.f131971b);
        }

        public String toString() {
            return "CenteredCircleSlot(size=" + Dp.k(this.f131971b) + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CenteredItemSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131972b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f131973c;

        public /* synthetic */ CenteredItemSlot(float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3, f4);
        }

        public final float a() {
            return this.f131973c;
        }

        public final float b() {
            return this.f131972b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CenteredItemSlot)) {
                return false;
            }
            CenteredItemSlot centeredItemSlot = (CenteredItemSlot) obj;
            return Float.compare(this.f131972b, centeredItemSlot.f131972b) == 0 && Dp.i(this.f131973c, centeredItemSlot.f131973c);
        }

        public int hashCode() {
            return (Float.hashCode(this.f131972b) * 31) + Dp.j(this.f131973c);
        }

        public String toString() {
            return "CenteredItemSlot(widthPercent=" + this.f131972b + ", height=" + Dp.k(this.f131973c) + ")";
        }

        private CenteredItemSlot(float f3, float f4) {
            super(null);
            this.f131972b = f3;
            this.f131973c = f4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CircleSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131974b;

        public final float a() {
            return this.f131974b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CircleSlot) && Dp.i(this.f131974b, ((CircleSlot) obj).f131974b);
        }

        public int hashCode() {
            return Dp.j(this.f131974b);
        }

        public String toString() {
            return "CircleSlot(size=" + Dp.k(this.f131974b) + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SkeletonSlot a(int i3, float f3, float f4, boolean z2) {
            return new BarChartSlot(i3, f3, f4, z2, null);
        }

        public final SkeletonSlot b(float f3, float f4) {
            return new CenteredItemSlot(f3, f4, null);
        }

        public final SkeletonSlot c(Function3 content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return new CustomSlot(content);
        }

        public final SkeletonSlot d(float f3, boolean z2, boolean z3) {
            return new ListItemSlot(f3, z2, z3, null);
        }

        public final SkeletonSlot e(Dp dp, float f3) {
            return new RectangleSlot(dp, f3, null);
        }

        public final SkeletonSlot f(int i3, SkeletonSlot slot, float f3) {
            Intrinsics.checkNotNullParameter(slot, "slot");
            return new RepeatWithSpacerSlot(i3, slot, f3, null);
        }

        public final SkeletonSlot g(float f3) {
            return new RoundedItemSlot(f3, null);
        }

        public final SkeletonSlot h(float f3) {
            return new SpacerSlot(f3, null);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class CustomSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Function3 f131975b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CustomSlot(Function3 content) {
            super(null);
            Intrinsics.checkNotNullParameter(content, "content");
            this.f131975b = content;
        }

        public final Function3 a() {
            return this.f131975b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof CustomSlot) && Intrinsics.areEqual(this.f131975b, ((CustomSlot) obj).f131975b);
        }

        public int hashCode() {
            return this.f131975b.hashCode();
        }

        public String toString() {
            return "CustomSlot(content=" + this.f131975b + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ListItemSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131976b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f131977c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f131978d;

        public /* synthetic */ ListItemSlot(float f3, boolean z2, boolean z3, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3, z2, z3);
        }

        public final float a() {
            return this.f131976b;
        }

        public final boolean b() {
            return this.f131977c;
        }

        public final boolean c() {
            return this.f131978d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ListItemSlot)) {
                return false;
            }
            ListItemSlot listItemSlot = (ListItemSlot) obj;
            return Dp.i(this.f131976b, listItemSlot.f131976b) && this.f131977c == listItemSlot.f131977c && this.f131978d == listItemSlot.f131978d;
        }

        public int hashCode() {
            return (((Dp.j(this.f131976b) * 31) + Boolean.hashCode(this.f131977c)) * 31) + Boolean.hashCode(this.f131978d);
        }

        public String toString() {
            return "ListItemSlot(height=" + Dp.k(this.f131976b) + ", showLeadingIcon=" + this.f131977c + ", showTrailingIcon=" + this.f131978d + ")";
        }

        private ListItemSlot(float f3, boolean z2, boolean z3) {
            super(null);
            this.f131976b = f3;
            this.f131977c = z2;
            this.f131978d = z3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RectanglePercentSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f131980c;

        public final float a() {
            return this.f131980c;
        }

        public final float b() {
            return this.f131979b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RectanglePercentSlot)) {
                return false;
            }
            RectanglePercentSlot rectanglePercentSlot = (RectanglePercentSlot) obj;
            return Float.compare(this.f131979b, rectanglePercentSlot.f131979b) == 0 && Dp.i(this.f131980c, rectanglePercentSlot.f131980c);
        }

        public int hashCode() {
            return (Float.hashCode(this.f131979b) * 31) + Dp.j(this.f131980c);
        }

        public String toString() {
            return "RectanglePercentSlot(widthPercent=" + this.f131979b + ", height=" + Dp.k(this.f131980c) + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RectangleSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Dp f131981b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final float f131982c;

        public /* synthetic */ RectangleSlot(Dp dp, float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(dp, f3);
        }

        public final float a() {
            return this.f131982c;
        }

        public final Dp b() {
            return this.f131981b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RectangleSlot)) {
                return false;
            }
            RectangleSlot rectangleSlot = (RectangleSlot) obj;
            return Intrinsics.areEqual(this.f131981b, rectangleSlot.f131981b) && Dp.i(this.f131982c, rectangleSlot.f131982c);
        }

        public int hashCode() {
            Dp dp = this.f131981b;
            return ((dp == null ? 0 : Dp.j(dp.l())) * 31) + Dp.j(this.f131982c);
        }

        public String toString() {
            return "RectangleSlot(width=" + this.f131981b + ", height=" + Dp.k(this.f131982c) + ")";
        }

        private RectangleSlot(Dp dp, float f3) {
            super(null);
            this.f131981b = dp;
            this.f131982c = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RepeatSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f131983b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SkeletonSlot f131984c;

        public final int a() {
            return this.f131983b;
        }

        public final SkeletonSlot b() {
            return this.f131984c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RepeatSlot)) {
                return false;
            }
            RepeatSlot repeatSlot = (RepeatSlot) obj;
            return this.f131983b == repeatSlot.f131983b && Intrinsics.areEqual(this.f131984c, repeatSlot.f131984c);
        }

        public int hashCode() {
            return (Integer.hashCode(this.f131983b) * 31) + this.f131984c.hashCode();
        }

        public String toString() {
            return "RepeatSlot(count=" + this.f131983b + ", slot=" + this.f131984c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RepeatWithSpacerSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f131985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final SkeletonSlot f131986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final float f131987d;

        public /* synthetic */ RepeatWithSpacerSlot(int i3, SkeletonSlot skeletonSlot, float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, skeletonSlot, f3);
        }

        public final int a() {
            return this.f131985b;
        }

        public final SkeletonSlot b() {
            return this.f131986c;
        }

        public final float c() {
            return this.f131987d;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RepeatWithSpacerSlot)) {
                return false;
            }
            RepeatWithSpacerSlot repeatWithSpacerSlot = (RepeatWithSpacerSlot) obj;
            return this.f131985b == repeatWithSpacerSlot.f131985b && Intrinsics.areEqual(this.f131986c, repeatWithSpacerSlot.f131986c) && Dp.i(this.f131987d, repeatWithSpacerSlot.f131987d);
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f131985b) * 31) + this.f131986c.hashCode()) * 31) + Dp.j(this.f131987d);
        }

        public String toString() {
            return "RepeatWithSpacerSlot(count=" + this.f131985b + ", slot=" + this.f131986c + ", spacerHeight=" + Dp.k(this.f131987d) + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private RepeatWithSpacerSlot(int i3, SkeletonSlot slot, float f3) {
            super(null);
            Intrinsics.checkNotNullParameter(slot, "slot");
            this.f131985b = i3;
            this.f131986c = slot;
            this.f131987d = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RoundedItemSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131988b;

        public /* synthetic */ RoundedItemSlot(float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3);
        }

        public final float a() {
            return this.f131988b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof RoundedItemSlot) && Dp.i(this.f131988b, ((RoundedItemSlot) obj).f131988b);
        }

        public int hashCode() {
            return Dp.j(this.f131988b);
        }

        public String toString() {
            return "RoundedItemSlot(height=" + Dp.k(this.f131988b) + ")";
        }

        private RoundedItemSlot(float f3) {
            super(null);
            this.f131988b = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class RowSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final List f131989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Arrangement.Horizontal f131990c;

        public final Arrangement.Horizontal a() {
            return this.f131990c;
        }

        public final List b() {
            return this.f131989b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RowSlot)) {
                return false;
            }
            RowSlot rowSlot = (RowSlot) obj;
            return Intrinsics.areEqual(this.f131989b, rowSlot.f131989b) && Intrinsics.areEqual(this.f131990c, rowSlot.f131990c);
        }

        public int hashCode() {
            return (this.f131989b.hashCode() * 31) + this.f131990c.hashCode();
        }

        public String toString() {
            return "RowSlot(slots=" + this.f131989b + ", horizontalArrangement=" + this.f131990c + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SpacerSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131991b;

        public /* synthetic */ SpacerSlot(float f3, DefaultConstructorMarker defaultConstructorMarker) {
            this(f3);
        }

        public final float a() {
            return this.f131991b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SpacerSlot) && Dp.i(this.f131991b, ((SpacerSlot) obj).f131991b);
        }

        public int hashCode() {
            return Dp.j(this.f131991b);
        }

        public String toString() {
            return "SpacerSlot(height=" + Dp.k(this.f131991b) + ")";
        }

        private SpacerSlot(float f3) {
            super(null);
            this.f131991b = f3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class TextSlot extends SkeletonSlot {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final float f131992b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f131993c;

        public final int a() {
            return this.f131993c;
        }

        public final float b() {
            return this.f131992b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TextSlot)) {
                return false;
            }
            TextSlot textSlot = (TextSlot) obj;
            return Float.compare(this.f131992b, textSlot.f131992b) == 0 && this.f131993c == textSlot.f131993c;
        }

        public int hashCode() {
            return (Float.hashCode(this.f131992b) * 31) + Integer.hashCode(this.f131993c);
        }

        public String toString() {
            return "TextSlot(width=" + this.f131992b + ", lines=" + this.f131993c + ")";
        }
    }

    public /* synthetic */ SkeletonSlot(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SkeletonSlot() {
    }
}
