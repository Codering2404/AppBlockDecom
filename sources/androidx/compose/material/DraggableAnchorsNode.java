package androidx.compose.material;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
final class DraggableAnchorsNode<T> extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AnchoredDraggableState f12704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function2 f12705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Orientation f12706c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f12707d;

    public DraggableAnchorsNode(AnchoredDraggableState anchoredDraggableState, Function2 function2, Orientation orientation) {
        this.f12704a = anchoredDraggableState;
        this.f12705b = function2;
        this.f12706c = orientation;
    }

    public final Orientation m2() {
        return this.f12706c;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(j3);
        if (!measureScope.q0() || !this.f12707d) {
            Pair pair = (Pair) this.f12705b.invoke(IntSize.b(IntSizeKt.a(placeableN0.X0(), placeableN0.O0())), Constraints.a(j3));
            this.f12704a.I((DraggableAnchors) pair.e(), pair.f());
        }
        this.f12707d = measureScope.q0() || this.f12707d;
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.DraggableAnchorsNode$measure$1
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
                float fC = measureScope.q0() ? this.n2().o().c(this.n2().x()) : this.n2().A();
                float f3 = this.m2() == Orientation.f6032b ? fC : 0.0f;
                if (this.m2() != Orientation.f6031a) {
                    fC = 0.0f;
                }
                Placeable.PlacementScope.i(placementScope, placeableN0, MathKt.d(f3), MathKt.d(fC), 0.0f, 4, null);
            }
        }, 4, null);
    }

    public final AnchoredDraggableState n2() {
        return this.f12704a;
    }

    public final void o2(Function2 function2) {
        this.f12705b = function2;
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.f12707d = false;
    }

    public final void p2(Orientation orientation) {
        this.f12706c = orientation;
    }

    public final void q2(AnchoredDraggableState anchoredDraggableState) {
        this.f12704a = anchoredDraggableState;
    }
}
