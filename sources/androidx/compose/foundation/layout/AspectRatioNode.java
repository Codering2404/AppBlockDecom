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
import androidx.compose.ui.unit.IntSize;
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
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f6611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6612b;

    public AspectRatioNode(float f3, boolean z2) {
        this.f6611a = f3;
        this.f6612b = z2;
    }

    private final long m2(long j3) {
        if (this.f6612b) {
            long jP2 = p2(j3, true);
            IntSize.Companion companion = IntSize.f29998b;
            if (!IntSize.e(jP2, companion.a())) {
                return jP2;
            }
            long jQ2 = q2(j3, true);
            if (!IntSize.e(jQ2, companion.a())) {
                return jQ2;
            }
            long jR2 = r2(j3, true);
            if (!IntSize.e(jR2, companion.a())) {
                return jR2;
            }
            long jS2 = s2(j3, true);
            if (!IntSize.e(jS2, companion.a())) {
                return jS2;
            }
            long jP22 = p2(j3, false);
            if (!IntSize.e(jP22, companion.a())) {
                return jP22;
            }
            long jQ22 = q2(j3, false);
            if (!IntSize.e(jQ22, companion.a())) {
                return jQ22;
            }
            long jR22 = r2(j3, false);
            if (!IntSize.e(jR22, companion.a())) {
                return jR22;
            }
            long jS22 = s2(j3, false);
            if (!IntSize.e(jS22, companion.a())) {
                return jS22;
            }
        } else {
            long jQ23 = q2(j3, true);
            IntSize.Companion companion2 = IntSize.f29998b;
            if (!IntSize.e(jQ23, companion2.a())) {
                return jQ23;
            }
            long jP23 = p2(j3, true);
            if (!IntSize.e(jP23, companion2.a())) {
                return jP23;
            }
            long jS23 = s2(j3, true);
            if (!IntSize.e(jS23, companion2.a())) {
                return jS23;
            }
            long jR23 = r2(j3, true);
            if (!IntSize.e(jR23, companion2.a())) {
                return jR23;
            }
            long jQ24 = q2(j3, false);
            if (!IntSize.e(jQ24, companion2.a())) {
                return jQ24;
            }
            long jP24 = p2(j3, false);
            if (!IntSize.e(jP24, companion2.a())) {
                return jP24;
            }
            long jS24 = s2(j3, false);
            if (!IntSize.e(jS24, companion2.a())) {
                return jS24;
            }
            long jR24 = r2(j3, false);
            if (!IntSize.e(jR24, companion2.a())) {
                return jR24;
            }
        }
        return IntSize.f29998b.a();
    }

    private final long p2(long j3, boolean z2) {
        int iRound;
        int iK = Constraints.k(j3);
        return (iK == Integer.MAX_VALUE || (iRound = Math.round(((float) iK) * this.f6611a)) <= 0 || (z2 && !AspectRatioKt.c(j3, iRound, iK))) ? IntSize.f29998b.a() : IntSize.c((((long) iRound) << 32) | (((long) iK) & 4294967295L));
    }

    private final long q2(long j3, boolean z2) {
        int iRound;
        int iL = Constraints.l(j3);
        return (iL == Integer.MAX_VALUE || (iRound = Math.round(((float) iL) / this.f6611a)) <= 0 || (z2 && !AspectRatioKt.c(j3, iL, iRound))) ? IntSize.f29998b.a() : IntSize.c((((long) iL) << 32) | (((long) iRound) & 4294967295L));
    }

    private final long r2(long j3, boolean z2) {
        int iM = Constraints.m(j3);
        int iRound = Math.round(iM * this.f6611a);
        return (iRound <= 0 || (z2 && !AspectRatioKt.c(j3, iRound, iM))) ? IntSize.f29998b.a() : IntSize.c((((long) iRound) << 32) | (((long) iM) & 4294967295L));
    }

    private final long s2(long j3, boolean z2) {
        int iN = Constraints.n(j3);
        int iRound = Math.round(iN / this.f6611a);
        return (iRound <= 0 || (z2 && !AspectRatioKt.c(j3, iN, iRound))) ? IntSize.f29998b.a() : IntSize.c((((long) iN) << 32) | (((long) iRound) & 4294967295L));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return i3 != Integer.MAX_VALUE ? Math.round(i3 / this.f6611a) : intrinsicMeasurable.I(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return i3 != Integer.MAX_VALUE ? Math.round(i3 * this.f6611a) : intrinsicMeasurable.l0(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        long jM2 = m2(j3);
        if (!IntSize.e(jM2, IntSize.f29998b.a())) {
            j3 = Constraints.f29963b.c((int) (jM2 >> 32), (int) (jM2 & 4294967295L));
        }
        final Placeable placeableN0 = measurable.n0(j3);
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
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
        return i3 != Integer.MAX_VALUE ? Math.round(i3 / this.f6611a) : intrinsicMeasurable.d0(i3);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        return i3 != Integer.MAX_VALUE ? Math.round(i3 * this.f6611a) : intrinsicMeasurable.k0(i3);
    }

    public final void n2(float f3) {
        this.f6611a = f3;
    }

    public final void o2(boolean z2) {
        this.f6612b = z2;
    }
}
