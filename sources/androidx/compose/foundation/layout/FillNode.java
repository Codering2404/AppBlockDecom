package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
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
final class FillNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Direction f6770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f6771b;

    public FillNode(Direction direction, float f3) {
        this.f6770a = direction;
        this.f6771b = f3;
    }

    public final void m2(Direction direction) {
        this.f6770a = direction;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        int iN;
        int iL;
        int iK;
        int iK2;
        if (!Constraints.h(j3) || this.f6770a == Direction.f6756a) {
            iN = Constraints.n(j3);
            iL = Constraints.l(j3);
        } else {
            int iRound = Math.round(Constraints.l(j3) * this.f6771b);
            int iN2 = Constraints.n(j3);
            iN = Constraints.l(j3);
            if (iRound < iN2) {
                iRound = iN2;
            }
            if (iRound <= iN) {
                iN = iRound;
            }
            iL = iN;
        }
        if (!Constraints.g(j3) || this.f6770a == Direction.f6757b) {
            int iM = Constraints.m(j3);
            iK = Constraints.k(j3);
            iK2 = iM;
        } else {
            int iRound2 = Math.round(Constraints.k(j3) * this.f6771b);
            int iM2 = Constraints.m(j3);
            iK2 = Constraints.k(j3);
            if (iRound2 < iM2) {
                iRound2 = iM2;
            }
            if (iRound2 <= iK2) {
                iK2 = iRound2;
            }
            iK = iK2;
        }
        final Placeable placeableN0 = measurable.n0(ConstraintsKt.a(iN, iL, iK2, iK));
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.FillNode$measure$1
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

    public final void n2(float f3) {
        this.f6771b = f3;
    }
}
