package androidx.compose.foundation.layout;

import androidx.collection.IntIntPair;
import androidx.compose.foundation.layout.FlowLayoutBuildingBlocks;
import androidx.compose.foundation.layout.FlowLayoutOverflow;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class FlowLayoutOverflowState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FlowLayoutOverflow.OverflowType f6873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6876d = "Accessing shownItemCount before it is set. Are you calling this in the Composition phase, rather than in the draw phase? Consider our samples on how to use it during the draw phase or consider using ContextualFlowRow/ContextualFlowColumn which initializes this method in the composition phase.";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f6877e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f6878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Measurable f6879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Placeable f6880h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Measurable f6881i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Placeable f6882j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private IntIntPair f6883k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private IntIntPair f6884l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Function2 f6885m;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6886a;

        static {
            int[] iArr = new int[FlowLayoutOverflow.OverflowType.values().length];
            try {
                iArr[FlowLayoutOverflow.OverflowType.f6866a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.f6867b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.f6868c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FlowLayoutOverflow.OverflowType.f6869d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f6886a = iArr;
        }
    }

    public FlowLayoutOverflowState(FlowLayoutOverflow.OverflowType overflowType, int i3, int i4) {
        this.f6873a = overflowType;
        this.f6874b = i3;
        this.f6875c = i4;
    }

    public final FlowLayoutBuildingBlocks.WrapEllipsisInfo e(boolean z2, int i3, int i4) {
        Measurable measurable;
        IntIntPair intIntPair;
        Placeable placeable;
        Measurable measurable2;
        Placeable placeable2;
        int i5 = WhenMappings.f6886a[this.f6873a.ordinal()];
        if (i5 == 1 || i5 == 2) {
            return null;
        }
        if (i5 != 3 && i5 != 4) {
            throw new NoWhenBranchMatchedException();
        }
        if (z2) {
            Function2 function2 = this.f6885m;
            if (function2 == null || (measurable = (Measurable) function2.invoke(Boolean.TRUE, Integer.valueOf(j()))) == null) {
                measurable = this.f6879g;
            }
            intIntPair = this.f6883k;
            if (this.f6885m == null) {
                placeable = this.f6880h;
                measurable2 = measurable;
                placeable2 = placeable;
            }
            measurable2 = measurable;
            placeable2 = null;
        } else {
            if (i3 < this.f6874b - 1 || i4 < this.f6875c) {
                measurable = null;
            } else {
                Function2 function22 = this.f6885m;
                if (function22 == null || (measurable = (Measurable) function22.invoke(Boolean.FALSE, Integer.valueOf(j()))) == null) {
                    measurable = this.f6881i;
                }
            }
            intIntPair = this.f6884l;
            if (this.f6885m == null) {
                placeable = this.f6882j;
                measurable2 = measurable;
                placeable2 = placeable;
            }
            measurable2 = measurable;
            placeable2 = null;
        }
        if (measurable2 == null) {
            return null;
        }
        Intrinsics.checkNotNull(intIntPair);
        return new FlowLayoutBuildingBlocks.WrapEllipsisInfo(measurable2, placeable2, intIntPair.i(), false, 8, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlowLayoutOverflowState)) {
            return false;
        }
        FlowLayoutOverflowState flowLayoutOverflowState = (FlowLayoutOverflowState) obj;
        return this.f6873a == flowLayoutOverflowState.f6873a && this.f6874b == flowLayoutOverflowState.f6874b && this.f6875c == flowLayoutOverflowState.f6875c;
    }

    public final IntIntPair f(boolean z2, int i3, int i4) {
        int i5 = WhenMappings.f6886a[this.f6873a.ordinal()];
        if (i5 != 1 && i5 != 2) {
            if (i5 != 3) {
                if (i5 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                if (z2) {
                    return this.f6883k;
                }
                if (i3 + 1 < this.f6874b || i4 < this.f6875c) {
                    return null;
                }
                return this.f6884l;
            }
            if (z2) {
                return this.f6883k;
            }
        }
        return null;
    }

    public final int g() {
        return this.f6878f;
    }

    public final int h() {
        return this.f6877e;
    }

    public int hashCode() {
        return (((this.f6873a.hashCode() * 31) + Integer.hashCode(this.f6874b)) * 31) + Integer.hashCode(this.f6875c);
    }

    public final int i() {
        return this.f6874b;
    }

    public final int j() {
        int i3 = this.f6877e;
        if (i3 != -1) {
            return i3;
        }
        throw new IllegalStateException(this.f6876d);
    }

    public final String k() {
        return this.f6876d;
    }

    public final FlowLayoutOverflow.OverflowType l() {
        return this.f6873a;
    }

    public final void m(int i3) {
        this.f6878f = i3;
    }

    public final void n(int i3) {
        this.f6877e = i3;
    }

    public final void o(final FlowLineMeasurePolicy flowLineMeasurePolicy, Measurable measurable, Measurable measurable2, long j3) {
        LayoutOrientation layoutOrientation = flowLineMeasurePolicy.b() ? LayoutOrientation.f6996a : LayoutOrientation.f6997b;
        long jH = OrientationIndependentConstraints.h(OrientationIndependentConstraints.e(OrientationIndependentConstraints.c(j3, layoutOrientation), 0, 0, 0, 0, 10, null), layoutOrientation);
        if (measurable != null) {
            FlowLayoutKt.k(measurable, flowLineMeasurePolicy, jH, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$setOverflowMeasurables$3$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(Placeable placeable) {
                    int iE;
                    int iF;
                    if (placeable != null) {
                        FlowLineMeasurePolicy flowLineMeasurePolicy2 = flowLineMeasurePolicy;
                        iE = flowLineMeasurePolicy2.e(placeable);
                        iF = flowLineMeasurePolicy2.f(placeable);
                    } else {
                        iE = 0;
                        iF = 0;
                    }
                    this.f6887a.f6883k = IntIntPair.a(IntIntPair.b(iE, iF));
                    this.f6887a.f6880h = placeable;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Placeable) obj);
                    return Unit.f139807a;
                }
            });
            this.f6879g = measurable;
        }
        if (measurable2 != null) {
            FlowLayoutKt.k(measurable2, flowLineMeasurePolicy, jH, new Function1<Placeable, Unit>() { // from class: androidx.compose.foundation.layout.FlowLayoutOverflowState$setOverflowMeasurables$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(Placeable placeable) {
                    int iE;
                    int iF;
                    if (placeable != null) {
                        FlowLineMeasurePolicy flowLineMeasurePolicy2 = flowLineMeasurePolicy;
                        iE = flowLineMeasurePolicy2.e(placeable);
                        iF = flowLineMeasurePolicy2.f(placeable);
                    } else {
                        iE = 0;
                        iF = 0;
                    }
                    this.f6889a.f6884l = IntIntPair.a(IntIntPair.b(iE, iF));
                    this.f6889a.f6882j = placeable;
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((Placeable) obj);
                    return Unit.f139807a;
                }
            });
            this.f6881i = measurable2;
        }
    }

    public final void p(IntrinsicMeasurable intrinsicMeasurable, IntrinsicMeasurable intrinsicMeasurable2, boolean z2, long j3) {
        long jC = OrientationIndependentConstraints.c(j3, z2 ? LayoutOrientation.f6996a : LayoutOrientation.f6997b);
        if (intrinsicMeasurable != null) {
            int iJ = FlowLayoutKt.j(intrinsicMeasurable, z2, Constraints.k(jC));
            this.f6883k = IntIntPair.a(IntIntPair.b(iJ, FlowLayoutKt.h(intrinsicMeasurable, z2, iJ)));
            this.f6879g = intrinsicMeasurable instanceof Measurable ? (Measurable) intrinsicMeasurable : null;
            this.f6880h = null;
        }
        if (intrinsicMeasurable2 != null) {
            int iJ2 = FlowLayoutKt.j(intrinsicMeasurable2, z2, Constraints.k(jC));
            this.f6884l = IntIntPair.a(IntIntPair.b(iJ2, FlowLayoutKt.h(intrinsicMeasurable2, z2, iJ2)));
            this.f6881i = intrinsicMeasurable2 instanceof Measurable ? (Measurable) intrinsicMeasurable2 : null;
            this.f6882j = null;
        }
    }

    public final void q(FlowLineMeasurePolicy flowLineMeasurePolicy, long j3, Function2 function2) {
        this.f6877e = 0;
        this.f6885m = function2;
        o(flowLineMeasurePolicy, (Measurable) function2.invoke(Boolean.TRUE, 0), (Measurable) function2.invoke(Boolean.FALSE, 0), j3);
    }

    public String toString() {
        return "FlowLayoutOverflowState(type=" + this.f6873a + ", minLinesToShowCollapse=" + this.f6874b + ", minCrossAxisSizeToShowCollapse=" + this.f6875c + ')';
    }
}
