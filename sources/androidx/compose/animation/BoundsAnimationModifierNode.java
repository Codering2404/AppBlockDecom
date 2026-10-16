package androidx.compose.animation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class BoundsAnimationModifierNode extends Modifier.Node implements ApproachLayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LookaheadScope f3409a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BoundsTransform f3410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function2 f3411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f3412d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f3413f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final BoundsTransformDeferredAnimation f3414g = new BoundsTransformDeferredAnimation();

    public BoundsAnimationModifierNode(LookaheadScope lookaheadScope, BoundsTransform boundsTransform, Function2 function2, boolean z2) {
        this.f3409a = lookaheadScope;
        this.f3410b = boundsTransform;
        this.f3411c = function2;
        this.f3412d = z2;
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public MeasureResult N0(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3) {
        long jE = this.f3414g.d() == 9205357640488583168L ? IntSizeKt.e(approachMeasureScope.P0()) : this.f3414g.d();
        Rect rectE = this.f3414g.e();
        if (rectE != null) {
            jE = rectE.q();
        }
        long jC = IntSizeKt.c(jE);
        long jR = ((Constraints) this.f3411c.invoke(IntSize.b(jC), Constraints.a(j3))).r();
        final Placeable placeableN0 = measurable.n0(jR);
        long jD = ConstraintsKt.d(jR, jC);
        return MeasureScope.B0(approachMeasureScope, (int) (jD >> 32), (int) (jD & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.BoundsAnimationModifierNode$approachMeasure$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                long jT;
                Rect rectE2 = this.f3415a.f3414g.e();
                LookaheadScope lookaheadScopeO2 = this.f3415a.o2();
                BoundsAnimationModifierNode boundsAnimationModifierNode = this.f3415a;
                LayoutCoordinates layoutCoordinatesD = placementScope.d();
                Offset offsetD = layoutCoordinatesD != null ? Offset.d(lookaheadScopeO2.z(placementScope).Q(layoutCoordinatesD, Offset.f25596b.c(), boundsAnimationModifierNode.n2())) : null;
                if (rectE2 != null) {
                    this.f3415a.f3414g.h(rectE2.t(), rectE2.q());
                    jT = rectE2.t();
                } else {
                    Rect rectC = this.f3415a.f3414g.c();
                    jT = rectC != null ? rectC.t() : Offset.f25596b.c();
                }
                long jP = offsetD != null ? Offset.p(jT, offsetD.u()) : Offset.f25596b.c();
                Placeable.PlacementScope.i(placementScope, placeableN0, Math.round(Float.intBitsToFloat((int) (jP >> 32))), Math.round(Float.intBitsToFloat((int) (jP & 4294967295L))), 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean S0(long j3) {
        this.f3414g.k(IntSizeKt.e(j3));
        return !this.f3414g.f();
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean k2(Placeable.PlacementScope placementScope, LayoutCoordinates layoutCoordinates) {
        this.f3414g.j(this.f3409a, placementScope, getCoroutineScope(), this.f3413f, this.f3412d, this.f3410b);
        this.f3413f = this.f3412d;
        return !this.f3414g.f();
    }

    public final boolean n2() {
        return this.f3412d;
    }

    public final LookaheadScope o2() {
        return this.f3409a;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        this.f3413f = true;
    }

    public final void p2(boolean z2) {
        this.f3412d = z2;
    }

    public final void q2(BoundsTransform boundsTransform) {
        this.f3410b = boundsTransform;
    }

    public final void r2(LookaheadScope lookaheadScope) {
        this.f3409a = lookaheadScope;
    }

    public final void s2(Function2 function2) {
        this.f3411c = function2;
    }
}
