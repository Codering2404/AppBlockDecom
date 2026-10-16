package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final NodeCoordinator f27447q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Map f27449s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private MeasureResult f27451u;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f27448r = IntOffset.f29988b.b();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LookaheadLayoutCoordinates f27450t = new LookaheadLayoutCoordinates(this);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableObjectIntMap f27452v = ObjectIntMapKt.b();

    public LookaheadDelegate(NodeCoordinator nodeCoordinator) {
        this.f27447q = nodeCoordinator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A2(MeasureResult measureResult) {
        Unit unit;
        Map map;
        if (measureResult != null) {
            j1(IntSize.c((((long) measureResult.getHeight()) & 4294967295L) | (((long) measureResult.getWidth()) << 32)));
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            j1(IntSize.f29998b.a());
        }
        if (!Intrinsics.areEqual(this.f27451u, measureResult) && measureResult != null && ((((map = this.f27449s) != null && !map.isEmpty()) || !measureResult.z().isEmpty()) && !Intrinsics.areEqual(measureResult.z(), this.f27449s))) {
            o2().z().m();
            Map linkedHashMap = this.f27449s;
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
                this.f27449s = linkedHashMap;
            }
            linkedHashMap.clear();
            linkedHashMap.putAll(measureResult.z());
        }
        this.f27451u = measureResult;
    }

    private final void w2(long j3) {
        if (!IntOffset.j(C1(), j3)) {
            z2(j3);
            LookaheadPassDelegate lookaheadPassDelegateV = X1().f0().v();
            if (lookaheadPassDelegateV != null) {
                lookaheadPassDelegateV.n2();
            }
            N1(this.f27447q);
        }
        if (W1()) {
            return;
        }
        r1(x1());
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable A1() {
        NodeCoordinator nodeCoordinatorY2 = this.f27447q.Y2();
        if (nodeCoordinatorY2 != null) {
            return nodeCoordinatorY2.S2();
        }
        return null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public long C1() {
        return this.f27448r;
    }

    public int I(int i3) {
        NodeCoordinator nodeCoordinatorX2 = this.f27447q.X2();
        Intrinsics.checkNotNull(nodeCoordinatorX2);
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinatorX2.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.I(i3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f27447q.K1();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode X1() {
        return this.f27447q.X1();
    }

    public int d0(int i3) {
        NodeCoordinator nodeCoordinatorX2 = this.f27447q.X2();
        Intrinsics.checkNotNull(nodeCoordinatorX2);
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinatorX2.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.d0(i3);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void d2() {
        i1(C1(), 0.0f, null);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f27447q.getDensity();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.f27447q.getLayoutDirection();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    public final void i1(long j3, float f3, Function1 function1) {
        w2(j3);
        if (b2()) {
            return;
        }
        v2();
    }

    public int k0(int i3) {
        NodeCoordinator nodeCoordinatorX2 = this.f27447q.X2();
        Intrinsics.checkNotNull(nodeCoordinatorX2);
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinatorX2.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.k0(i3);
    }

    public int l0(int i3) {
        NodeCoordinator nodeCoordinatorX2 = this.f27447q.X2();
        Intrinsics.checkNotNull(nodeCoordinatorX2);
        LookaheadDelegate lookaheadDelegateS2 = nodeCoordinatorX2.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        return lookaheadDelegateS2.l0(i3);
    }

    public AlignmentLinesOwner o2() {
        AlignmentLinesOwner alignmentLinesOwnerP = this.f27447q.X1().f0().p();
        Intrinsics.checkNotNull(alignmentLinesOwnerP);
        return alignmentLinesOwnerP;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object p() {
        return this.f27447q.p();
    }

    public final int p2(AlignmentLine alignmentLine) {
        return this.f27452v.e(alignmentLine, Integer.MIN_VALUE);
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean q0() {
        return true;
    }

    protected final MutableObjectIntMap q2() {
        return this.f27452v;
    }

    public final long r2() {
        return V0();
    }

    public final NodeCoordinator s2() {
        return this.f27447q;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable t1() {
        NodeCoordinator nodeCoordinatorX2 = this.f27447q.X2();
        if (nodeCoordinatorX2 != null) {
            return nodeCoordinatorX2.S2();
        }
        return null;
    }

    public final LookaheadLayoutCoordinates t2() {
        return this.f27450t;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates u1() {
        return this.f27450t;
    }

    public final long u2() {
        return IntSize.c((((long) O0()) & 4294967295L) | (((long) X0()) << 32));
    }

    protected void v2() {
        x1().A();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean w1() {
        return this.f27451u != null;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult x1() {
        MeasureResult measureResult = this.f27451u;
        if (measureResult != null) {
            return measureResult;
        }
        InlineClassHelperKt.d("LookaheadDelegate has not been measured yet when measureResult is requested.");
        throw new KotlinNothingValueException();
    }

    public final void x2(long j3) {
        w2(IntOffset.o(j3, N0()));
    }

    public final long y2(LookaheadDelegate lookaheadDelegate, boolean z2) {
        long jB = IntOffset.f29988b.b();
        LookaheadDelegate lookaheadDelegateS2 = this;
        while (!Intrinsics.areEqual(lookaheadDelegateS2, lookaheadDelegate)) {
            if (!lookaheadDelegateS2.R1() || !z2) {
                jB = IntOffset.o(jB, lookaheadDelegateS2.C1());
            }
            NodeCoordinator nodeCoordinatorY2 = lookaheadDelegateS2.f27447q.Y2();
            Intrinsics.checkNotNull(nodeCoordinatorY2);
            lookaheadDelegateS2 = nodeCoordinatorY2.S2();
            Intrinsics.checkNotNull(lookaheadDelegateS2);
        }
        return jB;
    }

    public void z2(long j3) {
        this.f27448r = j3;
    }
}
