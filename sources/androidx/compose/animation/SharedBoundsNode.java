package androidx.compose.animation;

import androidx.compose.animation.SharedTransitionScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class SharedBoundsNode extends Modifier.Node implements ApproachLayoutModifierNode, DrawModifierNode, ModifierLocalModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SharedElementInternalState f3597a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private GraphicsLayer f3598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ModifierLocalMap f3599c;

    public SharedBoundsNode(SharedElementInternalState sharedElementInternalState) {
        this.f3597a = sharedElementInternalState;
        this.f3598b = sharedElementInternalState.i();
        this.f3599c = ModifierLocalModifierNodeKt.b(TuplesKt.a(SharedContentNodeKt.a(), sharedElementInternalState));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B2(LayoutCoordinates layoutCoordinates) {
        w2().p(RectKt.c(u2().S(layoutCoordinates, Offset.f25596b.c()), Size.d((((long) Float.floatToRawIntBits((int) (layoutCoordinates.a() >> 32))) << 32) | (((long) Float.floatToRawIntBits((int) (layoutCoordinates.a() & 4294967295L))) & 4294967295L))));
    }

    private final MeasureResult s2(MeasureScope measureScope, final Placeable placeable) {
        if (!w2().d()) {
            return MeasureScope.B0(measureScope, placeable.X0(), placeable.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$approachPlace$1
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
                    LayoutCoordinates layoutCoordinatesD = placementScope.d();
                    if (layoutCoordinatesD != null) {
                        this.f3600a.B2(layoutCoordinatesD);
                    }
                    Placeable.PlacementScope.i(placementScope, placeable, 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        long jA = this.f3597a.m().a(y2().a(), IntSize.c((((long) placeable.X0()) << 32) | (((long) placeable.O0()) & 4294967295L)));
        return MeasureScope.B0(measureScope, (int) (jA >> 32), (int) (jA & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$approachPlace$2
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
                LayoutCoordinates layoutCoordinatesD;
                if (this.f3602a.w2().h() != null) {
                    BoundsAnimation boundsAnimationT2 = this.f3602a.t2();
                    Rect rectC = this.f3602a.w2().c();
                    Intrinsics.checkNotNull(rectC);
                    Rect rectH = this.f3602a.w2().h();
                    Intrinsics.checkNotNull(rectH);
                    boundsAnimationT2.a(rectC, rectH);
                }
                Rect rectH2 = this.f3602a.t2().h();
                LayoutCoordinates layoutCoordinatesD2 = placementScope.d();
                Offset offsetD = layoutCoordinatesD2 != null ? Offset.d(this.f3602a.u2().S(layoutCoordinatesD2, Offset.f25596b.c())) : null;
                if (rectH2 != null) {
                    if (this.f3602a.t2().f()) {
                        this.f3602a.w2().p(rectH2);
                    }
                    jT = rectH2.t();
                } else {
                    if (this.f3602a.t2().f() && (layoutCoordinatesD = placementScope.d()) != null) {
                        this.f3602a.B2(layoutCoordinatesD);
                    }
                    Rect rectC2 = this.f3602a.w2().c();
                    Intrinsics.checkNotNull(rectC2);
                    jT = rectC2.t();
                }
                long jP = offsetD != null ? Offset.p(jT, offsetD.u()) : Offset.f25596b.c();
                Placeable.PlacementScope.i(placementScope, placeable, Math.round(Float.intBitsToFloat((int) (jP >> 32))), Math.round(Float.intBitsToFloat((int) (jP & 4294967295L))), 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BoundsAnimation t2() {
        return this.f3597a.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates u2() {
        return w2().f().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates v2() {
        return w2().f().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SharedElement w2() {
        return this.f3597a.p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LayoutCoordinates y2() {
        return this.f3597a.p().f().x(DelegatableNodeKt.m(this));
    }

    private final void z2(GraphicsLayer graphicsLayer) {
        if (graphicsLayer == null) {
            GraphicsLayer graphicsLayer2 = this.f3598b;
            if (graphicsLayer2 != null) {
                DelegatableNodeKt.l(this).b(graphicsLayer2);
            }
        } else {
            this.f3597a.x(graphicsLayer);
        }
        this.f3598b = graphicsLayer;
    }

    public final void A2(SharedElementInternalState sharedElementInternalState) {
        if (Intrinsics.areEqual(sharedElementInternalState, this.f3597a)) {
            return;
        }
        this.f3597a = sharedElementInternalState;
        if (isAttached()) {
            r1(SharedContentNodeKt.a(), sharedElementInternalState);
            this.f3597a.A((SharedElementInternalState) u(SharedContentNodeKt.a()));
            this.f3597a.x(this.f3598b);
            this.f3597a.y(new Function0<LayoutCoordinates>() { // from class: androidx.compose.animation.SharedBoundsNode$state$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final LayoutCoordinates invoke() {
                    return this.f3611a.y2();
                }
            });
        }
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public MeasureResult N0(ApproachMeasureScope approachMeasureScope, Measurable measurable, long j3) {
        if (w2().d()) {
            Rect rectH = t2().h();
            if (rectH == null) {
                rectH = w2().c();
            }
            if (rectH != null) {
                long jC = IntSizeKt.c(rectH.q());
                int i3 = (int) (jC >> 32);
                int i4 = (int) (jC & 4294967295L);
                if (i3 == Integer.MAX_VALUE || i4 == Integer.MAX_VALUE) {
                    throw new IllegalArgumentException(("Error: Infinite width/height is invalid. animated bounds: " + t2().h() + ", current bounds: " + w2().c()).toString());
                }
                j3 = Constraints.f29963b.c(RangesKt.f(i3, 0), RangesKt.f(i4, 0));
            }
        }
        return s2(approachMeasureScope, measurable.n0(j3));
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode
    public boolean S0(long j3) {
        return w2().d() && this.f3597a.p().f().p();
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(final ContentDrawScope contentDrawScope) {
        this.f3597a.w(true);
        SharedElementInternalState sharedElementInternalState = this.f3597a;
        SharedTransitionScope.OverlayClip overlayClipK = sharedElementInternalState.k();
        SharedTransitionScope.SharedContentState sharedContentStateT = this.f3597a.t();
        Rect rectC = w2().c();
        Intrinsics.checkNotNull(rectC);
        sharedElementInternalState.v(overlayClipK.a(sharedContentStateT, rectC, contentDrawScope.getLayoutDirection(), DelegatableNodeKt.k(this)));
        GraphicsLayer graphicsLayerI = this.f3597a.i();
        if (graphicsLayerI != null) {
            DrawScope.a2(contentDrawScope, graphicsLayerI, 0L, new Function1<DrawScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode.draw.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((DrawScope) obj);
                    return Unit.f139807a;
                }

                public final void invoke(DrawScope drawScope) {
                    contentDrawScope.i2();
                }
            }, 1, null);
            if (this.f3597a.s()) {
                GraphicsLayerKt.a(contentDrawScope, graphicsLayerI);
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Error: Layer is null when accessed for shared bounds/element : " + w2().e() + ",target: " + this.f3597a.g().f() + ", is attached: " + isAttached()).toString());
    }

    @Override // androidx.compose.ui.layout.ApproachLayoutModifierNode, androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(j3);
        float fX0 = placeableN0.X0();
        final long jD = Size.d((((long) Float.floatToRawIntBits(placeableN0.O0())) & 4294967295L) | (Float.floatToRawIntBits(fX0) << 32));
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SharedBoundsNode$measure$1
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
                Offset offsetD;
                LayoutCoordinates layoutCoordinatesD = placementScope.d();
                if (layoutCoordinatesD != null) {
                    SharedBoundsNode sharedBoundsNode = this;
                    long j4 = jD;
                    long jS = sharedBoundsNode.v2().S(layoutCoordinatesD, Offset.f25596b.c());
                    if (sharedBoundsNode.w2().c() == null) {
                        sharedBoundsNode.w2().p(RectKt.c(jS, j4));
                    }
                    offsetD = Offset.d(jS);
                } else {
                    offsetD = null;
                }
                Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                if (offsetD != null) {
                    SharedBoundsNode sharedBoundsNode2 = this;
                    sharedBoundsNode2.w2().m(sharedBoundsNode2.x2(), jD, offsetD.u());
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap n0() {
        return this.f3599c;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        r1(SharedContentNodeKt.a(), this.f3597a);
        this.f3597a.A((SharedElementInternalState) u(SharedContentNodeKt.a()));
        z2(DelegatableNodeKt.l(this).a());
        this.f3597a.y(new Function0<LayoutCoordinates>() { // from class: androidx.compose.animation.SharedBoundsNode.onAttach.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final LayoutCoordinates invoke() {
                return SharedBoundsNode.this.y2();
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        super.onDetach();
        z2(null);
        this.f3597a.A(null);
        this.f3597a.y(new Function0() { // from class: androidx.compose.animation.SharedBoundsNode.onDetach.1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Void invoke() {
                return null;
            }
        });
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        GraphicsLayer graphicsLayer = this.f3598b;
        if (graphicsLayer != null) {
            DelegatableNodeKt.l(this).b(graphicsLayer);
        }
        z2(DelegatableNodeKt.l(this).a());
    }

    public final SharedElementInternalState x2() {
        return this.f3597a;
    }
}
