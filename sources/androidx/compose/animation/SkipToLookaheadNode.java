package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactor;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

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
public final class SkipToLookaheadNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MutableState f3740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f3741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Constraints f3742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f3743d = AnimationModifierKt.c();

    public SkipToLookaheadNode(ScaleToBoundsImpl scaleToBoundsImpl, Function0 function0) {
        this.f3740a = SnapshotStateKt__SnapshotStateKt.e(scaleToBoundsImpl, null, 2, null);
        this.f3741b = SnapshotStateKt__SnapshotStateKt.e(function0, null, 2, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return (intrinsicMeasureScope.q0() || !AnimationModifierKt.d(this.f3743d)) ? intrinsicMeasurable.I(i3) : (int) (this.f3743d & 4294967295L);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return (intrinsicMeasureScope.q0() || !AnimationModifierKt.d(this.f3743d)) ? intrinsicMeasurable.l0(i3) : (int) (this.f3743d >> 32);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        if (measureScope.q0()) {
            this.f3742c = Constraints.a(j3);
        }
        Constraints constraints = this.f3742c;
        Intrinsics.checkNotNull(constraints);
        final Placeable placeableN0 = measurable.n0(constraints.r());
        long jC = IntSize.c((((long) placeableN0.X0()) << 32) | (((long) placeableN0.O0()) & 4294967295L));
        this.f3743d = jC;
        final long jD = ConstraintsKt.d(j3, jC);
        return MeasureScope.B0(measureScope, (int) (jD >> 32), (int) (jD & 4294967295L), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1
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
                final long jA;
                ScaleToBoundsImpl scaleToBoundsImplN2 = this.f3744a.n2();
                if (!((Boolean) this.f3744a.o2().invoke()).booleanValue() || scaleToBoundsImplN2 == null) {
                    Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
                    return;
                }
                ContentScale contentScaleB = scaleToBoundsImplN2.b();
                if (((int) (this.f3744a.f3743d >> 32)) == 0 || ((int) (this.f3744a.f3743d & 4294967295L)) == 0) {
                    jA = ScaleFactor.a((((long) Float.floatToRawIntBits(1.0f)) << 32) | (((long) Float.floatToRawIntBits(1.0f)) & 4294967295L));
                } else {
                    jA = contentScaleB.a(IntSizeKt.e(this.f3744a.f3743d), IntSizeKt.e(jD));
                }
                long jA2 = scaleToBoundsImplN2.a().a(IntSize.c((((long) MathKt.d(((int) (this.f3744a.f3743d & 4294967295L)) * Float.intBitsToFloat((int) (jA & 4294967295L)))) & 4294967295L) | (((long) MathKt.d(((int) (this.f3744a.f3743d >> 32)) * Float.intBitsToFloat((int) (jA >> 32)))) << 32)), jD, measureScope.getLayoutDirection());
                Placeable.PlacementScope.w(placementScope, placeableN0, IntOffset.k(jA2), IntOffset.l(jA2), 0.0f, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.animation.SkipToLookaheadNode$measure$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((GraphicsLayerScope) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(GraphicsLayerScope graphicsLayerScope) {
                        graphicsLayerScope.e(Float.intBitsToFloat((int) (jA >> 32)));
                        graphicsLayerScope.k(Float.intBitsToFloat((int) (jA & 4294967295L)));
                        graphicsLayerScope.A0(TransformOriginKt.a(0.0f, 0.0f));
                    }
                }, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return (intrinsicMeasureScope.q0() || !AnimationModifierKt.d(this.f3743d)) ? intrinsicMeasurable.d0(i3) : (int) (this.f3743d & 4294967295L);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return (intrinsicMeasureScope.q0() || !AnimationModifierKt.d(this.f3743d)) ? intrinsicMeasurable.k0(i3) : (int) (this.f3743d >> 32);
    }

    public final ScaleToBoundsImpl n2() {
        return (ScaleToBoundsImpl) this.f3740a.getValue();
    }

    public final Function0 o2() {
        return (Function0) this.f3741b.getValue();
    }

    public final void p2(Function0 function0) {
        this.f3741b.setValue(function0);
    }

    public final void q2(ScaleToBoundsImpl scaleToBoundsImpl) {
        this.f3740a.setValue(scaleToBoundsImpl);
    }
}
