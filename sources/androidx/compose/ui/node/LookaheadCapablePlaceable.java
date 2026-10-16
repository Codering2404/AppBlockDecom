package androidx.compose.ui.node;

import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.VerticalAlignmentLine;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.unit.IntOffset;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Companion f27427o = new Companion(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final Function1 f27428p = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        public final void c(PlaceableResult placeableResult) {
            if (placeableResult.a1()) {
                placeableResult.a().q1(placeableResult);
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            c((PlaceableResult) obj);
            return Unit.f139807a;
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private RulerScope f27429g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27430h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f27431i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f27432j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Placeable.PlacementScope f27433k = PlaceableKt.a(this);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MutableObjectFloatMap f27434l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MutableObjectFloatMap f27435m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private MutableScatterMap f27436n;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private final void P1(Ruler ruler) {
        MutableScatterMap mutableScatterMap = s1(ruler).f27436n;
        MutableScatterSet mutableScatterSet = mutableScatterMap != null ? (MutableScatterSet) mutableScatterMap.u(ruler) : null;
        if (mutableScatterSet != null) {
            c2(mutableScatterSet);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c2(MutableScatterSet mutableScatterSet) {
        LayoutNode layoutNode;
        Object[] objArr = mutableScatterSet.f3116b;
        long[] jArr = mutableScatterSet.f3115a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i3 << 3) + i5]).get()) != null) {
                        if (q0()) {
                            layoutNode.z1(false);
                        } else {
                            layoutNode.D1(false);
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:63:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0162  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q1(final androidx.compose.ui.node.PlaceableResult r28) {
        /*
            Method dump skipped, instruction units count: 363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.q1(androidx.compose.ui.node.PlaceableResult):void");
    }

    private final LookaheadCapablePlaceable s1(Ruler ruler) {
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap mutableObjectFloatMap = lookaheadCapablePlaceable.f27434l;
            if (mutableObjectFloatMap != null && mutableObjectFloatMap.a(ruler)) {
                return lookaheadCapablePlaceable;
            }
            LookaheadCapablePlaceable lookaheadCapablePlaceableA1 = lookaheadCapablePlaceable.A1();
            if (lookaheadCapablePlaceableA1 == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = lookaheadCapablePlaceableA1;
        }
    }

    public abstract LookaheadCapablePlaceable A1();

    public final Placeable.PlacementScope B1() {
        return this.f27433k;
    }

    public abstract long C1();

    public final RulerScope J1() {
        RulerScope rulerScope = this.f27429g;
        return rulerScope == null ? new RulerScope() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$rulerScope$1
            @Override // androidx.compose.ui.unit.FontScaling
            public float K1() {
                return this.f27446a.K1();
            }

            @Override // androidx.compose.ui.unit.Density
            public float getDensity() {
                return this.f27446a.getDensity();
            }
        } : rulerScope;
    }

    protected final void N1(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLinesZ;
        NodeCoordinator nodeCoordinatorX2 = nodeCoordinator.X2();
        if (!Intrinsics.areEqual(nodeCoordinatorX2 != null ? nodeCoordinatorX2.X1() : null, nodeCoordinator.X1())) {
            nodeCoordinator.M2().z().m();
            return;
        }
        AlignmentLinesOwner alignmentLinesOwnerU = nodeCoordinator.M2().U();
        if (alignmentLinesOwnerU == null || (alignmentLinesZ = alignmentLinesOwnerU.z()) == null) {
            return;
        }
        alignmentLinesZ.m();
    }

    public boolean R1() {
        return this.f27430h;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult U1(final int i3, final int i4, final Map map, final Function1 function1, final Function1 function12) {
        if (!((i3 & (-16777216)) == 0 && ((-16777216) & i4) == 0)) {
            InlineClassHelperKt.c("Size(" + i3 + " x " + i4 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$layout$1
            @Override // androidx.compose.ui.layout.MeasureResult
            public void A() {
                function12.invoke(this.B1());
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1 B() {
                return function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return i4;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return i3;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map z() {
                return map;
            }
        };
    }

    public final boolean W1() {
        return this.f27432j;
    }

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode X1();

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void Z(boolean z2) {
        LookaheadCapablePlaceable lookaheadCapablePlaceableA1 = A1();
        LayoutNode layoutNodeX1 = lookaheadCapablePlaceableA1 != null ? lookaheadCapablePlaceableA1.X1() : null;
        if (Intrinsics.areEqual(layoutNodeX1, X1())) {
            j2(z2);
            return;
        }
        if ((layoutNodeX1 != null ? layoutNodeX1.h0() : null) != LayoutNode.LayoutState.f27386c) {
            if ((layoutNodeX1 != null ? layoutNodeX1.h0() : null) != LayoutNode.LayoutState.f27387d) {
                return;
            }
        }
        j2(z2);
    }

    public final boolean b2() {
        return this.f27431i;
    }

    public abstract void d2();

    public void j2(boolean z2) {
        this.f27430h = z2;
    }

    public final void k2(boolean z2) {
        this.f27432j = z2;
    }

    public final void l2(boolean z2) {
        this.f27431i = z2;
    }

    public abstract int o1(AlignmentLine alignmentLine);

    @Override // androidx.compose.ui.layout.Measured
    public final int p0(AlignmentLine alignmentLine) {
        int iO1;
        if (w1() && (iO1 = o1(alignmentLine)) != Integer.MIN_VALUE) {
            return iO1 + (alignmentLine instanceof VerticalAlignmentLine ? IntOffset.k(N0()) : IntOffset.l(N0()));
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean q0() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void r1(androidx.compose.ui.layout.MeasureResult r14) {
        /*
            r13 = this;
            if (r14 == 0) goto Lb
            androidx.compose.ui.node.PlaceableResult r0 = new androidx.compose.ui.node.PlaceableResult
            r0.<init>(r14, r13)
            r13.q1(r0)
            return
        Lb:
            androidx.collection.MutableScatterMap r14 = r13.f27436n
            if (r14 == 0) goto L54
            java.lang.Object[] r0 = r14.f3110c
            long[] r14 = r14.f3108a
            int r1 = r14.length
            int r1 = r1 + (-2)
            if (r1 < 0) goto L54
            r2 = 0
            r3 = r2
        L1a:
            r4 = r14[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L4f
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L34:
            if (r8 >= r6) goto L4d
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L49
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            androidx.collection.MutableScatterSet r9 = (androidx.collection.MutableScatterSet) r9
            r13.c2(r9)
        L49:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L34
        L4d:
            if (r6 != r7) goto L54
        L4f:
            if (r3 == r1) goto L54
            int r3 = r3 + 1
            goto L1a
        L54:
            androidx.collection.MutableScatterMap r14 = r13.f27436n
            if (r14 == 0) goto L5b
            r14.k()
        L5b:
            androidx.collection.MutableObjectFloatMap r14 = r13.f27434l
            if (r14 == 0) goto L62
            r14.h()
        L62:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LookaheadCapablePlaceable.r1(androidx.compose.ui.layout.MeasureResult):void");
    }

    public abstract LookaheadCapablePlaceable t1();

    public abstract LayoutCoordinates u1();

    public abstract boolean w1();

    public abstract MeasureResult x1();
}
