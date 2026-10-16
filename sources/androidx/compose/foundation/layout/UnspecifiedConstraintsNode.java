package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
final class UnspecifiedConstraintsNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7165a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7166b;

    public /* synthetic */ UnspecifiedConstraintsNode(float f3, float f4, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4);
    }

    public final void m2(float f3) {
        this.f7166b = f3;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        int I = intrinsicMeasurable.I(i3);
        int iZ0 = !Float.isNaN(this.f7166b) ? intrinsicMeasureScope.z0(this.f7166b) : 0;
        return I < iZ0 ? iZ0 : I;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        int iL0 = intrinsicMeasurable.l0(i3);
        int iZ0 = !Float.isNaN(this.f7165a) ? intrinsicMeasureScope.z0(this.f7165a) : 0;
        return iL0 < iZ0 ? iZ0 : iL0;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        int iN;
        int iM;
        if (Float.isNaN(this.f7165a) || Constraints.n(j3) != 0) {
            iN = Constraints.n(j3);
        } else {
            int iZ0 = measureScope.z0(this.f7165a);
            iN = Constraints.l(j3);
            if (iZ0 < 0) {
                iZ0 = 0;
            }
            if (iZ0 <= iN) {
                iN = iZ0;
            }
        }
        int iL = Constraints.l(j3);
        if (Float.isNaN(this.f7166b) || Constraints.m(j3) != 0) {
            iM = Constraints.m(j3);
        } else {
            int iZ02 = measureScope.z0(this.f7166b);
            iM = Constraints.k(j3);
            int i3 = iZ02 >= 0 ? iZ02 : 0;
            if (i3 <= iM) {
                iM = i3;
            }
        }
        final Placeable placeableN0 = measurable.n0(ConstraintsKt.a(iN, iL, iM, Constraints.k(j3)));
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.UnspecifiedConstraintsNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.m(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        int iD0 = intrinsicMeasurable.d0(i3);
        int iZ0 = !Float.isNaN(this.f7166b) ? intrinsicMeasureScope.z0(this.f7166b) : 0;
        return iD0 < iZ0 ? iZ0 : iD0;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        int iK0 = intrinsicMeasurable.k0(i3);
        int iZ0 = !Float.isNaN(this.f7165a) ? intrinsicMeasureScope.z0(this.f7165a) : 0;
        return iK0 < iZ0 ? iZ0 : iK0;
    }

    public final void n2(float f3) {
        this.f7165a = f3;
    }

    private UnspecifiedConstraintsNode(float f3, float f4) {
        this.f7165a = f3;
        this.f7166b = f4;
    }
}
