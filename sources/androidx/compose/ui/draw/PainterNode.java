package androidx.compose.ui.draw;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.google.android.gms.common.api.Api;
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
final class PainterNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Painter f25418a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f25419b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Alignment f25420c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ContentScale f25421d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f25422f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ColorFilter f25423g;

    public PainterNode(Painter painter, boolean z2, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter) {
        this.f25418a = painter;
        this.f25419b = z2;
        this.f25420c = alignment;
        this.f25421d = contentScale;
        this.f25422f = f3;
        this.f25423g = colorFilter;
    }

    private final long m2(long j3) {
        if (!p2()) {
            return j3;
        }
        long jD = Size.d((((long) Float.floatToRawIntBits(!r2(this.f25418a.l()) ? Float.intBitsToFloat((int) (j3 >> 32)) : Float.intBitsToFloat((int) (this.f25418a.l() >> 32)))) << 32) | (((long) Float.floatToRawIntBits(!q2(this.f25418a.l()) ? Float.intBitsToFloat((int) (j3 & 4294967295L)) : Float.intBitsToFloat((int) (this.f25418a.l() & 4294967295L)))) & 4294967295L));
        return (Float.intBitsToFloat((int) (j3 >> 32)) == 0.0f || Float.intBitsToFloat((int) (j3 & 4294967295L)) == 0.0f) ? Size.f25617b.b() : ScaleFactorKt.a(jD, this.f25421d.a(jD, j3));
    }

    private final boolean p2() {
        return this.f25419b && this.f25418a.l() != 9205357640488583168L;
    }

    private final boolean q2(long j3) {
        return !Size.f(j3, Size.f25617b.a()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 & 4294967295L))) & Api.BaseClientBuilder.API_PRIORITY_OTHER) < 2139095040;
    }

    private final boolean r2(long j3) {
        return !Size.f(j3, Size.f25617b.a()) && (Float.floatToRawIntBits(Float.intBitsToFloat((int) (j3 >> 32))) & Api.BaseClientBuilder.API_PRIORITY_OTHER) < 2139095040;
    }

    private final long s2(long j3) {
        boolean z2 = false;
        boolean z3 = Constraints.h(j3) && Constraints.g(j3);
        if (Constraints.j(j3) && Constraints.i(j3)) {
            z2 = true;
        }
        if ((!p2() && z3) || z2) {
            return Constraints.d(j3, Constraints.l(j3), 0, Constraints.k(j3), 0, 10, null);
        }
        long jL = this.f25418a.l();
        int iRound = r2(jL) ? Math.round(Float.intBitsToFloat((int) (jL >> 32))) : Constraints.n(j3);
        int iRound2 = q2(jL) ? Math.round(Float.intBitsToFloat((int) (jL & 4294967295L))) : Constraints.m(j3);
        long jM2 = m2(Size.d((((long) Float.floatToRawIntBits(ConstraintsKt.f(j3, iRound2))) & 4294967295L) | (((long) Float.floatToRawIntBits(ConstraintsKt.g(j3, iRound))) << 32)));
        return Constraints.d(j3, ConstraintsKt.g(j3, Math.round(Float.intBitsToFloat((int) (jM2 >> 32)))), 0, ConstraintsKt.f(j3, Math.round(Float.intBitsToFloat((int) (jM2 & 4294967295L)))), 0, 10, null);
    }

    public final void c(float f3) {
        this.f25422f = f3;
    }

    @Override // androidx.compose.ui.node.DrawModifierNode
    public void draw(ContentDrawScope contentDrawScope) {
        long jL = this.f25418a.l();
        float fIntBitsToFloat = r2(jL) ? Float.intBitsToFloat((int) (jL >> 32)) : Float.intBitsToFloat((int) (contentDrawScope.b() >> 32));
        long jD = Size.d((((long) Float.floatToRawIntBits(q2(jL) ? Float.intBitsToFloat((int) (jL & 4294967295L)) : Float.intBitsToFloat((int) (contentDrawScope.b() & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32));
        long jB = (Float.intBitsToFloat((int) (contentDrawScope.b() >> 32)) == 0.0f || Float.intBitsToFloat((int) (contentDrawScope.b() & 4294967295L)) == 0.0f) ? Size.f25617b.b() : ScaleFactorKt.a(jD, this.f25421d.a(jD, contentDrawScope.b()));
        long jA = this.f25420c.a(IntSize.c((((long) Math.round(Float.intBitsToFloat((int) (jB & 4294967295L)))) & 4294967295L) | (((long) Math.round(Float.intBitsToFloat((int) (jB >> 32)))) << 32)), IntSize.c((((long) Math.round(Float.intBitsToFloat((int) (contentDrawScope.b() >> 32)))) << 32) | (((long) Math.round(Float.intBitsToFloat((int) (contentDrawScope.b() & 4294967295L)))) & 4294967295L)), contentDrawScope.getLayoutDirection());
        float fK = IntOffset.k(jA);
        float fL = IntOffset.l(jA);
        contentDrawScope.Q1().e().e(fK, fL);
        try {
            this.f25418a.j(contentDrawScope, jB, this.f25422f, this.f25423g);
            contentDrawScope.Q1().e().e(-fK, -fL);
            contentDrawScope.i2();
        } catch (Throwable th) {
            contentDrawScope.Q1().e().e(-fK, -fL);
            throw th;
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (!p2()) {
            return intrinsicMeasurable.I(i3);
        }
        long jS2 = s2(ConstraintsKt.b(0, i3, 0, 0, 13, null));
        return Math.max(Constraints.m(jS2), intrinsicMeasurable.I(i3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (!p2()) {
            return intrinsicMeasurable.l0(i3);
        }
        long jS2 = s2(ConstraintsKt.b(0, 0, 0, i3, 7, null));
        return Math.max(Constraints.n(jS2), intrinsicMeasurable.l0(i3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo11measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(s2(j3));
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.ui.draw.PainterNode$measure$1
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
        if (!p2()) {
            return intrinsicMeasurable.d0(i3);
        }
        long jS2 = s2(ConstraintsKt.b(0, i3, 0, 0, 13, null));
        return Math.max(Constraints.m(jS2), intrinsicMeasurable.d0(i3));
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (!p2()) {
            return intrinsicMeasurable.k0(i3);
        }
        long jS2 = s2(ConstraintsKt.b(0, 0, 0, i3, 7, null));
        return Math.max(Constraints.n(jS2), intrinsicMeasurable.k0(i3));
    }

    public final Painter n2() {
        return this.f25418a;
    }

    public final boolean o2() {
        return this.f25419b;
    }

    public final void t2(Alignment alignment) {
        this.f25420c = alignment;
    }

    public String toString() {
        return "PainterModifier(painter=" + this.f25418a + ", sizeToIntrinsics=" + this.f25419b + ", alignment=" + this.f25420c + ", alpha=" + this.f25422f + ", colorFilter=" + this.f25423g + ')';
    }

    public final void u2(ColorFilter colorFilter) {
        this.f25423g = colorFilter;
    }

    public final void v2(ContentScale contentScale) {
        this.f25421d = contentScale;
    }

    public final void w2(Painter painter) {
        this.f25418a = painter;
    }

    public final void x2(boolean z2) {
        this.f25419b = z2;
    }
}
