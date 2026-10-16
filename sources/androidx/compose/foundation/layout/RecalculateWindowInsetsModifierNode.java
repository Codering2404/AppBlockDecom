package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
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
final class RecalculateWindowInsetsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutModifierNode, GlobalPositionAwareModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ValueInsets f7081a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f7082b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ModifierLocalMap f7083c;

    public RecalculateWindowInsetsModifierNode() {
        ValueInsets valueInsets = new ValueInsets(new InsetsValues(0, 0, 0, 0), "reset");
        this.f7081a = valueInsets;
        this.f7082b = IntOffset.f29988b.b();
        this.f7083c = ModifierLocalModifierNodeKt.b(TuplesKt.a(WindowInsetsPaddingKt.b(), valueInsets));
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void I(LayoutCoordinates layoutCoordinates) {
        long jD = IntOffsetKt.d(LayoutCoordinatesKt.f(layoutCoordinates));
        boolean zJ = IntOffset.j(this.f7082b, jD);
        this.f7082b = jD;
        if (zJ) {
            return;
        }
        LayoutModifierNodeKt.c(this);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public final ValueInsets m2() {
        return this.f7081a;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return intrinsicMeasurable.I(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return intrinsicMeasurable.l0(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, final Measurable measurable, long j3) {
        if (Constraints.j(j3) && Constraints.i(j3)) {
            final int iL = Constraints.l(j3);
            final int iK = Constraints.k(j3);
            return MeasureScope.B0(measureScope, iL, iK, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$measure$2
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
                    Object objM2;
                    LayoutCoordinates layoutCoordinatesD = placementScope.d();
                    if (layoutCoordinatesD != null) {
                        this.f7085a.n2(IntOffsetKt.d(LayoutCoordinatesKt.f(layoutCoordinatesD)));
                    }
                    if (layoutCoordinatesD == null) {
                        objM2 = (WindowInsets) this.f7085a.u(WindowInsetsPaddingKt.b());
                    } else {
                        long jF = LayoutCoordinatesKt.f(layoutCoordinatesD);
                        long jA = layoutCoordinatesD.a();
                        long jX0 = layoutCoordinatesD.x0(Offset.e((((long) Float.floatToRawIntBits((int) (jA & 4294967295L))) & 4294967295L) | (Float.floatToRawIntBits((int) (jA >> 32)) << 32)));
                        long jA2 = LayoutCoordinatesKt.d(layoutCoordinatesD).a();
                        int iRound = Math.round(Float.intBitsToFloat((int) (jF >> 32)));
                        int iRound2 = Math.round(Float.intBitsToFloat((int) (jF & 4294967295L)));
                        int iRound3 = ((int) (jA2 >> 32)) - Math.round(Float.intBitsToFloat((int) (jX0 >> 32)));
                        int iRound4 = ((int) (jA2 & 4294967295L)) - Math.round(Float.intBitsToFloat((int) (jX0 & 4294967295L)));
                        InsetsValues insetsValuesE = this.f7085a.m2().e();
                        if (insetsValuesE.b() != iRound || insetsValuesE.d() != iRound2 || insetsValuesE.c() != iRound3 || insetsValuesE.a() != iRound4) {
                            this.f7085a.m2().f(new InsetsValues(iRound, iRound2, iRound3, iRound4));
                        }
                        objM2 = this.f7085a.m2();
                    }
                    this.f7085a.r1(WindowInsetsPaddingKt.b(), objM2);
                    Placeable.PlacementScope.i(placementScope, measurable.n0(Constraints.f29963b.c(iL, iK)), 0, 0, 0.0f, 4, null);
                }
            }, 4, null);
        }
        r1(WindowInsetsPaddingKt.b(), u(WindowInsetsPaddingKt.b()));
        final Placeable placeableN0 = measurable.n0(j3);
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.i(placementScope, placeableN0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return intrinsicMeasurable.d0(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return intrinsicMeasurable.k0(i3);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap n0() {
        return this.f7083c;
    }

    public final void n2(long j3) {
        this.f7082b = j3;
    }
}
