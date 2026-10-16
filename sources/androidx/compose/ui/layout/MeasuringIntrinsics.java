package androidx.compose.ui.layout;

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
final class MeasuringIntrinsics {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MeasuringIntrinsics f27164a = new MeasuringIntrinsics();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class DefaultIntrinsicMeasurable implements Measurable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntrinsicMeasurable f27165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IntrinsicMinMax f27166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IntrinsicWidthHeight f27167c;

        public DefaultIntrinsicMeasurable(IntrinsicMeasurable intrinsicMeasurable, IntrinsicMinMax intrinsicMinMax, IntrinsicWidthHeight intrinsicWidthHeight) {
            this.f27165a = intrinsicMeasurable;
            this.f27166b = intrinsicMinMax;
            this.f27167c = intrinsicWidthHeight;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int I(int i3) {
            return this.f27165a.I(i3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int d0(int i3) {
            return this.f27165a.d0(i3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int k0(int i3) {
            return this.f27165a.k0(i3);
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public int l0(int i3) {
            return this.f27165a.l0(i3);
        }

        @Override // androidx.compose.ui.layout.Measurable
        public Placeable n0(long j3) {
            if (this.f27167c == IntrinsicWidthHeight.f27172a) {
                return new EmptyPlaceable(this.f27166b == IntrinsicMinMax.f27169b ? this.f27165a.l0(Constraints.k(j3)) : this.f27165a.k0(Constraints.k(j3)), Constraints.g(j3) ? Constraints.k(j3) : 32767);
            }
            return new EmptyPlaceable(Constraints.h(j3) ? Constraints.l(j3) : 32767, this.f27166b == IntrinsicMinMax.f27169b ? this.f27165a.I(Constraints.l(j3)) : this.f27165a.d0(Constraints.l(j3)));
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasurable
        public Object p() {
            return this.f27165a.p();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class IntrinsicMinMax {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IntrinsicMinMax f27168a = new IntrinsicMinMax("Min", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IntrinsicMinMax f27169b = new IntrinsicMinMax("Max", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ IntrinsicMinMax[] f27170c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f27171d;

        static {
            IntrinsicMinMax[] intrinsicMinMaxArrA = a();
            f27170c = intrinsicMinMaxArrA;
            f27171d = EnumEntriesKt.a(intrinsicMinMaxArrA);
        }

        private IntrinsicMinMax(String str, int i3) {
        }

        private static final /* synthetic */ IntrinsicMinMax[] a() {
            return new IntrinsicMinMax[]{f27168a, f27169b};
        }

        public static IntrinsicMinMax valueOf(String str) {
            return (IntrinsicMinMax) Enum.valueOf(IntrinsicMinMax.class, str);
        }

        public static IntrinsicMinMax[] values() {
            return (IntrinsicMinMax[]) f27170c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class IntrinsicWidthHeight {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final IntrinsicWidthHeight f27172a = new IntrinsicWidthHeight("Width", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final IntrinsicWidthHeight f27173b = new IntrinsicWidthHeight("Height", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ IntrinsicWidthHeight[] f27174c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f27175d;

        static {
            IntrinsicWidthHeight[] intrinsicWidthHeightArrA = a();
            f27174c = intrinsicWidthHeightArrA;
            f27175d = EnumEntriesKt.a(intrinsicWidthHeightArrA);
        }

        private IntrinsicWidthHeight(String str, int i3) {
        }

        private static final /* synthetic */ IntrinsicWidthHeight[] a() {
            return new IntrinsicWidthHeight[]{f27172a, f27173b};
        }

        public static IntrinsicWidthHeight valueOf(String str) {
            return (IntrinsicWidthHeight) Enum.valueOf(IntrinsicWidthHeight.class, str);
        }

        public static IntrinsicWidthHeight[] values() {
            return (IntrinsicWidthHeight[]) f27174c.clone();
        }
    }

    private MeasuringIntrinsics() {
    }

    public final int a(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return layoutModifier.mo45measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27169b, IntrinsicWidthHeight.f27173b), ConstraintsKt.b(0, i3, 0, 0, 13, null)).getHeight();
    }

    public final int b(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return layoutModifier.mo45measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27169b, IntrinsicWidthHeight.f27172a), ConstraintsKt.b(0, 0, 0, i3, 7, null)).getWidth();
    }

    public final int c(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return layoutModifier.mo45measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27168a, IntrinsicWidthHeight.f27173b), ConstraintsKt.b(0, i3, 0, 0, 13, null)).getHeight();
    }

    public final int d(LayoutModifier layoutModifier, IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return layoutModifier.mo45measure3p2s80s(new IntrinsicsMeasureScope(intrinsicMeasureScope, intrinsicMeasureScope.getLayoutDirection()), new DefaultIntrinsicMeasurable(intrinsicMeasurable, IntrinsicMinMax.f27168a, IntrinsicWidthHeight.f27172a), ConstraintsKt.b(0, 0, 0, i3, 7, null)).getWidth();
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
