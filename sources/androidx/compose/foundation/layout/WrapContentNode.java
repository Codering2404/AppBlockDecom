package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

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
final class WrapContentNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Direction f7317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Function2 f7319c;

    public WrapContentNode(Direction direction, boolean z2, Function2 function2) {
        this.f7317a = direction;
        this.f7318b = z2;
        this.f7319c = function2;
    }

    public final Function2 m2() {
        return this.f7319c;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(final MeasureScope measureScope, Measurable measurable, long j3) {
        Direction direction = this.f7317a;
        Direction direction2 = Direction.f6756a;
        int iN = direction != direction2 ? 0 : Constraints.n(j3);
        Direction direction3 = this.f7317a;
        Direction direction4 = Direction.f6757b;
        int iM = direction3 == direction4 ? Constraints.m(j3) : 0;
        Direction direction5 = this.f7317a;
        int iK = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        int iL = (direction5 == direction2 || !this.f7318b) ? Constraints.l(j3) : Integer.MAX_VALUE;
        if (this.f7317a == direction4 || !this.f7318b) {
            iK = Constraints.k(j3);
        }
        final Placeable placeableN0 = measurable.n0(ConstraintsKt.a(iN, iL, iM, iK));
        final int iP = RangesKt.p(placeableN0.X0(), Constraints.n(j3), Constraints.l(j3));
        final int iP2 = RangesKt.p(placeableN0.O0(), Constraints.m(j3), Constraints.k(j3));
        return MeasureScope.B0(measureScope, iP, iP2, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.WrapContentNode$measure$1
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
                Function2 function2M2 = this.f7320a.m2();
                int iX0 = iP - placeableN0.X0();
                long j4 = ((long) iX0) << 32;
                Placeable.PlacementScope.k(placementScope, placeableN0, ((IntOffset) function2M2.invoke(IntSize.b(IntSize.c((((long) (iP2 - placeableN0.O0())) & 4294967295L) | j4)), measureScope.getLayoutDirection())).r(), 0.0f, 2, null);
            }
        }, 4, null);
    }

    public final void n2(Function2 function2) {
        this.f7319c = function2;
    }

    public final void o2(Direction direction) {
        this.f7317a = direction;
    }

    public final void p2(boolean z2) {
        this.f7318b = z2;
    }
}
