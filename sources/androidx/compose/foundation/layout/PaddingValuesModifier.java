package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.internal.InlineClassHelperKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
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
final class PaddingValuesModifier extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PaddingValues f7076a;

    public PaddingValuesModifier(PaddingValues paddingValues) {
        this.f7076a = paddingValues;
    }

    public final void m2(PaddingValues paddingValues) {
        this.f7076a = paddingValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        float fB = this.f7076a.b(measureScope.getLayoutDirection());
        float fD = this.f7076a.d();
        float fC = this.f7076a.c(measureScope.getLayoutDirection());
        float fA = this.f7076a.a();
        float f3 = 0;
        if (!((Dp.f(fA, Dp.g(f3)) >= 0) & (Dp.f(fB, Dp.g(f3)) >= 0) & (Dp.f(fD, Dp.g(f3)) >= 0) & (Dp.f(fC, Dp.g(f3)) >= 0))) {
            InlineClassHelperKt.a("Padding must be non-negative");
        }
        final int iZ0 = measureScope.z0(fB);
        int iZ02 = measureScope.z0(fC) + iZ0;
        final int iZ03 = measureScope.z0(fD);
        int iZ04 = measureScope.z0(fA) + iZ03;
        final Placeable placeableN0 = measurable.n0(ConstraintsKt.i(j3, -iZ02, -iZ04));
        return MeasureScope.B0(measureScope, ConstraintsKt.g(j3, placeableN0.X0() + iZ02), ConstraintsKt.f(j3, placeableN0.O0() + iZ04), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.PaddingValuesModifier$measure$2
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
                Placeable.PlacementScope.i(placementScope, placeableN0, iZ0, iZ03, 0.0f, 4, null);
            }
        }, 4, null);
    }
}
