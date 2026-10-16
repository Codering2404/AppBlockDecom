package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNodeCoordinator;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class ApproachMeasureScopeImpl implements ApproachMeasureScope, MeasureScope, LookaheadScope {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutModifierNodeCoordinator f27032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ApproachLayoutModifierNode f27033b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f27034c;

    public ApproachMeasureScopeImpl(LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, ApproachLayoutModifierNode approachLayoutModifierNode) {
        this.f27032a = layoutModifierNodeCoordinator;
        this.f27033b = approachLayoutModifierNode;
    }

    @Override // androidx.compose.ui.unit.Density
    public float F(int i3) {
        return this.f27032a.F(i3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float G(float f3) {
        return this.f27032a.G(f3);
    }

    public final boolean H() {
        return this.f27034c;
    }

    public final ApproachLayoutModifierNode I() {
        return this.f27033b;
    }

    @Override // androidx.compose.ui.unit.Density
    public float J0(long j3) {
        return this.f27032a.J0(j3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float K1() {
        return this.f27032a.K1();
    }

    @Override // androidx.compose.ui.unit.Density
    public long M(long j3) {
        return this.f27032a.M(j3);
    }

    @Override // androidx.compose.ui.unit.Density
    public float M1(float f3) {
        return this.f27032a.M1(f3);
    }

    public final LayoutModifierNodeCoordinator N() {
        return this.f27032a;
    }

    public final void O(boolean z2) {
        this.f27034c = z2;
    }

    @Override // androidx.compose.ui.layout.ApproachIntrinsicMeasureScope
    public long P0() {
        LookaheadDelegate lookaheadDelegateS2 = this.f27032a.S2();
        Intrinsics.checkNotNull(lookaheadDelegateS2);
        MeasureResult measureResultX1 = lookaheadDelegateS2.x1();
        return IntSize.c((((long) measureResultX1.getWidth()) << 32) | (((long) measureResultX1.getHeight()) & 4294967295L));
    }

    public final void Q(ApproachLayoutModifierNode approachLayoutModifierNode) {
        this.f27033b = approachLayoutModifierNode;
    }

    @Override // androidx.compose.ui.unit.Density
    public int T1(long j3) {
        return this.f27032a.T1(j3);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult U1(final int i3, final int i4, final Map map, final Function1 function1, final Function1 function12) {
        if (!((i3 & (-16777216)) == 0 && ((-16777216) & i4) == 0)) {
            InlineClassHelperKt.c("Size(" + i3 + " x " + i4 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult(i3, i4, map, function1, function12, this) { // from class: androidx.compose.ui.layout.ApproachMeasureScopeImpl$layout$1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final int f27035a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f27036b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Map f27037c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final Function1 f27038d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            final /* synthetic */ Function1 f27039e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ ApproachMeasureScopeImpl f27040f;

            {
                this.f27039e = function12;
                this.f27040f = this;
                this.f27035a = i3;
                this.f27036b = i4;
                this.f27037c = map;
                this.f27038d = function1;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void A() {
                this.f27039e.invoke(this.f27040f.N().B1());
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1 B() {
                return this.f27038d;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.f27036b;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.f27035a;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map z() {
                return this.f27037c;
            }
        };
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult c1(int i3, int i4, Map map, Function1 function1) {
        return this.f27032a.c1(i3, i4, map, function1);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.f27032a.getDensity();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.f27032a.getLayoutDirection();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public long n(float f3) {
        return this.f27032a.n(f3);
    }

    @Override // androidx.compose.ui.unit.Density
    public long o(long j3) {
        return this.f27032a.o(j3);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float q(long j3) {
        return this.f27032a.q(j3);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean q0() {
        return false;
    }

    @Override // androidx.compose.ui.unit.Density
    public long v(float f3) {
        return this.f27032a.v(f3);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates z(Placeable.PlacementScope placementScope) {
        NodeCoordinator nodeCoordinatorZ;
        LayoutNode layoutNodeL0 = this.f27032a.X1().l0();
        if (layoutNodeL0 == null) {
            InlineClassHelperKt.b("Error: Requesting LookaheadScopeCoordinates is not permitted from outside of a LookaheadScope.");
            throw new KotlinNothingValueException();
        }
        if (!layoutNodeL0.W0()) {
            return layoutNodeL0.x0();
        }
        LayoutNode layoutNodeB0 = layoutNodeL0.B0();
        return (layoutNodeB0 == null || (nodeCoordinatorZ = layoutNodeB0.Z()) == null) ? ((LayoutNode) layoutNodeL0.O().get(0)).x0() : nodeCoordinatorZ;
    }

    @Override // androidx.compose.ui.unit.Density
    public int z0(float f3) {
        return this.f27032a.z0(f3);
    }

    @Override // androidx.compose.ui.layout.LookaheadScope
    public LayoutCoordinates x(LayoutCoordinates layoutCoordinates) {
        LookaheadLayoutCoordinates lookaheadLayoutCoordinatesT2;
        if (layoutCoordinates instanceof LookaheadLayoutCoordinates) {
            return layoutCoordinates;
        }
        if (layoutCoordinates instanceof NodeCoordinator) {
            LookaheadDelegate lookaheadDelegateS2 = ((NodeCoordinator) layoutCoordinates).S2();
            return (lookaheadDelegateS2 == null || (lookaheadLayoutCoordinatesT2 = lookaheadDelegateS2.t2()) == null) ? layoutCoordinates : lookaheadLayoutCoordinatesT2;
        }
        InlineClassHelperKt.b(MrGIhy.OQspAzzfjgWmMPK);
        throw new KotlinNothingValueException();
    }
}
