package androidx.compose.ui.node;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachIntrinsicMeasureScope;
import androidx.compose.ui.layout.ApproachIntrinsicsMeasureScope;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.IntrinsicsMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;

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
public final class NodeMeasuringIntrinsics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NodeMeasuringIntrinsics f27589a = new NodeMeasuringIntrinsics();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ApproachMeasureBlock {
        MeasureResult a(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DefaultIntrinsicMeasurable implements Measurable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntrinsicMeasurable f27590a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IntrinsicMinMax f27591b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IntrinsicWidthHeight f27592c;

        public DefaultIntrinsicMeasurable(IntrinsicMeasurable intrinsicMeasurable, IntrinsicMinMax intrinsicMinMax, IntrinsicWidthHeight intrinsicWidthHeight) {
            this.f27590a = intrinsicMeasurable;
            this.f27591b = intrinsicMinMax;
            this.f27592c = intrinsicWidthHeight;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int I(int i3) {
            return this.f27590a.I(i3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int d0(int i3) {
            return this.f27590a.d0(i3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int k0(int i3) {
            return this.f27590a.k0(i3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int l0(int i3) {
            return this.f27590a.l0(i3);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public Placeable n0(long j3) {
            if (this.f27592c == IntrinsicWidthHeight.f27597a) {
                return new EmptyPlaceable(this.f27591b == IntrinsicMinMax.f27594b ? this.f27590a.l0(Constraints.k(j3)) : this.f27590a.k0(Constraints.k(j3)), Constraints.g(j3) ? Constraints.k(j3) : 32767);
            }
            return new EmptyPlaceable(Constraints.h(j3) ? Constraints.l(j3) : 32767, this.f27591b == IntrinsicMinMax.f27594b ? this.f27590a.I(Constraints.l(j3)) : this.f27590a.d0(Constraints.l(j3)));
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public Object p() {
            return this.f27590a.p();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class IntrinsicMinMax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IntrinsicMinMax f27593a = new IntrinsicMinMax("Min", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IntrinsicMinMax f27594b = new IntrinsicMinMax("Max", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ IntrinsicMinMax[] f27595c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f27596d;

        static {
            IntrinsicMinMax[] intrinsicMinMaxArrA = a();
            f27595c = intrinsicMinMaxArrA;
            f27596d = EnumEntriesKt.a(intrinsicMinMaxArrA);
        }

        private IntrinsicMinMax(String str, int i3) {
        }

        private static final /* synthetic */ IntrinsicMinMax[] a() {
            return new IntrinsicMinMax[]{f27593a, f27594b};
        }

        public static IntrinsicMinMax valueOf(String str) {
            return (IntrinsicMinMax) Enum.valueOf(IntrinsicMinMax.class, str);
        }

        public static IntrinsicMinMax[] values() {
            return (IntrinsicMinMax[]) f27595c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class IntrinsicWidthHeight {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IntrinsicWidthHeight f27597a = new IntrinsicWidthHeight("Width", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IntrinsicWidthHeight f27598b = new IntrinsicWidthHeight("Height", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ IntrinsicWidthHeight[] f27599c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f27600d;

        static {
            IntrinsicWidthHeight[] intrinsicWidthHeightArrA = a();
            f27599c = intrinsicWidthHeightArrA;
            f27600d = EnumEntriesKt.a(intrinsicWidthHeightArrA);
        }

        private IntrinsicWidthHeight(String str, int i3) {
        }

        private static final /* synthetic */ IntrinsicWidthHeight[] a() {
            return new IntrinsicWidthHeight[]{f27597a, f27598b};
        }

        public static IntrinsicWidthHeight valueOf(String str) {
            return (IntrinsicWidthHeight) Enum.valueOf(IntrinsicWidthHeight.class, str);
        }

        public static IntrinsicWidthHeight[] values() {
            return (IntrinsicWidthHeight[]) f27599c.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface MeasureBlock {
        /* JADX INFO: renamed from: measure-3p2s80s */
        MeasureResult mo229measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3);
    }

    private NodeMeasuringIntrinsics() {
    }

    public final int a(ApproachMeasureBlock approachMeasureBlock, ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return approachMeasureBlock.a(new ApproachIntrinsicsMeasureScope(approachIntrinsicMeasureScope, approachIntrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27594b, IntrinsicWidthHeight.f27598b), ConstraintsKt.b(0, i3, 0, 0, 13, null)).getHeight();
    }

    public final int b(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return measureBlock.mo229measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27594b, IntrinsicWidthHeight.f27598b), ConstraintsKt.b(0, i3, 0, 0, 13, null)).getHeight();
    }

    public final int c(ApproachMeasureBlock approachMeasureBlock, ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return approachMeasureBlock.a(new ApproachIntrinsicsMeasureScope(approachIntrinsicMeasureScope, approachIntrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27594b, IntrinsicWidthHeight.f27597a), ConstraintsKt.b(0, 0, 0, i3, 7, null)).getWidth();
    }

    public final int d(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return measureBlock.mo229measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27594b, IntrinsicWidthHeight.f27597a), ConstraintsKt.b(0, 0, 0, i3, 7, null)).getWidth();
    }

    public final int e(ApproachMeasureBlock approachMeasureBlock, ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return approachMeasureBlock.a(new ApproachIntrinsicsMeasureScope(approachIntrinsicMeasureScope, approachIntrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27593a, IntrinsicWidthHeight.f27598b), ConstraintsKt.b(0, i3, 0, 0, 13, null)).getHeight();
    }

    public final int f(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return measureBlock.mo229measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27593a, IntrinsicWidthHeight.f27598b), ConstraintsKt.b(0, i3, 0, 0, 13, null)).getHeight();
    }

    public final int g(ApproachMeasureBlock approachMeasureBlock, ApproachIntrinsicMeasureScope approachIntrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return approachMeasureBlock.a(new ApproachIntrinsicsMeasureScope(approachIntrinsicMeasureScope, approachIntrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27593a, IntrinsicWidthHeight.f27597a), ConstraintsKt.b(0, 0, 0, i3, 7, null)).getWidth();
    }

    public final int h(MeasureBlock measureBlock, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return measureBlock.mo229measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27593a, IntrinsicWidthHeight.f27597a), ConstraintsKt.b(0, 0, 0, i3, 7, null)).getWidth();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class EmptyPlaceable extends Placeable {
        public EmptyPlaceable(int i3, int i4) {
            j1(IntSize.c((((long) i4) & 4294967295L) | (((long) i3) << 32)));
        }

        @Override // androidx.compose.ui.layout.Measured
        public int p0(AlignmentLine alignmentLine) {
            return Integer.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.compose.ui.layout.Placeable
        public void i1(long j3, float f3, Function1 function1) {
        }
    }
}
