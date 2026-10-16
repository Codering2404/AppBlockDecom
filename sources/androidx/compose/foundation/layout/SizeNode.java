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
final class SizeNode extends Modifier.Node implements LayoutModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f7151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f7152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f7153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f7154d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7155f;

    public /* synthetic */ SizeNode(float f3, float f4, float f5, float f6, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3, f4, f5, f6, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long m2(androidx.compose.ui.unit.Density r7) {
        /*
            r6 = this;
            float r0 = r6.f7153c
            boolean r0 = java.lang.Float.isNaN(r0)
            r1 = 2147483647(0x7fffffff, float:NaN)
            r2 = 0
            if (r0 != 0) goto L16
            float r0 = r6.f7153c
            int r0 = r7.z0(r0)
            if (r0 >= 0) goto L17
            r0 = r2
            goto L17
        L16:
            r0 = r1
        L17:
            float r3 = r6.f7154d
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L29
            float r3 = r6.f7154d
            int r3 = r7.z0(r3)
            if (r3 >= 0) goto L2a
            r3 = r2
            goto L2a
        L29:
            r3 = r1
        L2a:
            float r4 = r6.f7151a
            boolean r4 = java.lang.Float.isNaN(r4)
            if (r4 != 0) goto L41
            float r4 = r6.f7151a
            int r4 = r7.z0(r4)
            if (r4 >= 0) goto L3b
            r4 = r2
        L3b:
            if (r4 <= r0) goto L3e
            r4 = r0
        L3e:
            if (r4 == r1) goto L41
            goto L42
        L41:
            r4 = r2
        L42:
            float r5 = r6.f7152b
            boolean r5 = java.lang.Float.isNaN(r5)
            if (r5 != 0) goto L59
            float r5 = r6.f7152b
            int r7 = r7.z0(r5)
            if (r7 >= 0) goto L53
            r7 = r2
        L53:
            if (r7 <= r3) goto L56
            r7 = r3
        L56:
            if (r7 == r1) goto L59
            r2 = r7
        L59:
            long r0 = androidx.compose.ui.unit.ConstraintsKt.a(r4, r0, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.layout.SizeNode.m2(androidx.compose.ui.unit.Density):long");
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        long jM2 = m2(intrinsicMeasureScope);
        if (Constraints.i(jM2)) {
            return Constraints.k(jM2);
        }
        if (!this.f7155f) {
            i3 = ConstraintsKt.g(jM2, i3);
        }
        return ConstraintsKt.f(jM2, intrinsicMeasurable.I(i3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        long jM2 = m2(intrinsicMeasureScope);
        if (Constraints.j(jM2)) {
            return Constraints.l(jM2);
        }
        if (!this.f7155f) {
            i3 = ConstraintsKt.f(jM2, i3);
        }
        return ConstraintsKt.g(jM2, intrinsicMeasurable.l0(i3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        int iN;
        int iL;
        int iM;
        int iK;
        long jA;
        long jM2 = m2(measureScope);
        if (this.f7155f) {
            jA = ConstraintsKt.e(j3, jM2);
        } else {
            if (Float.isNaN(this.f7151a)) {
                iN = Constraints.n(j3);
                int iL2 = Constraints.l(jM2);
                if (iN > iL2) {
                    iN = iL2;
                }
            } else {
                iN = Constraints.n(jM2);
            }
            if (Float.isNaN(this.f7153c)) {
                iL = Constraints.l(j3);
                int iN2 = Constraints.n(jM2);
                if (iL < iN2) {
                    iL = iN2;
                }
            } else {
                iL = Constraints.l(jM2);
            }
            if (Float.isNaN(this.f7152b)) {
                iM = Constraints.m(j3);
                int iK2 = Constraints.k(jM2);
                if (iM > iK2) {
                    iM = iK2;
                }
            } else {
                iM = Constraints.m(jM2);
            }
            if (Float.isNaN(this.f7154d)) {
                iK = Constraints.k(j3);
                int iM2 = Constraints.m(jM2);
                if (iK < iM2) {
                    iK = iM2;
                }
            } else {
                iK = Constraints.k(jM2);
            }
            jA = ConstraintsKt.a(iN, iL, iM, iK);
        }
        final Placeable placeableN0 = measurable.n0(jA);
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.SizeNode$measure$1
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
        long jM2 = m2(intrinsicMeasureScope);
        if (Constraints.i(jM2)) {
            return Constraints.k(jM2);
        }
        if (!this.f7155f) {
            i3 = ConstraintsKt.g(jM2, i3);
        }
        return ConstraintsKt.f(jM2, intrinsicMeasurable.d0(i3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        long jM2 = m2(intrinsicMeasureScope);
        if (Constraints.j(jM2)) {
            return Constraints.l(jM2);
        }
        if (!this.f7155f) {
            i3 = ConstraintsKt.f(jM2, i3);
        }
        return ConstraintsKt.g(jM2, intrinsicMeasurable.k0(i3));
    }

    public final void n2(boolean z2) {
        this.f7155f = z2;
    }

    public final void o2(float f3) {
        this.f7154d = f3;
    }

    public final void p2(float f3) {
        this.f7153c = f3;
    }

    public final void q2(float f3) {
        this.f7152b = f3;
    }

    public final void r2(float f3) {
        this.f7151a = f3;
    }

    private SizeNode(float f3, float f4, float f5, float f6, boolean z2) {
        this.f7151a = f3;
        this.f7152b = f4;
        this.f7153c = f5;
        this.f7154d = f6;
        this.f7155f = z2;
    }
}
