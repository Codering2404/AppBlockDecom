package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import com.applovin.sdk.AppLovinEventTypes;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class ContentPainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Painter f55558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Alignment f55559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ContentScale f55560d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f55561f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ColorFilter f55562g;

    public ContentPainterModifier(Painter painter, Alignment alignment, ContentScale contentScale, float f3, ColorFilter colorFilter) {
        final Painter painter2;
        final Alignment alignment2;
        final ContentScale contentScale2;
        final float f4;
        final ColorFilter colorFilter2;
        Function1<InspectorInfo, Unit> function1A;
        if (InspectableValueKt.b()) {
            painter2 = painter;
            alignment2 = alignment;
            contentScale2 = contentScale;
            f4 = f3;
            colorFilter2 = colorFilter;
            function1A = new Function1<InspectorInfo, Unit>() { // from class: coil.compose.ContentPainterModifier$special$$inlined$debugInspectorInfo$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(InspectorInfo inspectorInfo) {
                    Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                    inspectorInfo.d(AppLovinEventTypes.USER_VIEWED_CONTENT);
                    inspectorInfo.b().c("painter", painter2);
                    inspectorInfo.b().c("alignment", alignment2);
                    inspectorInfo.b().c("contentScale", contentScale2);
                    inspectorInfo.b().c("alpha", Float.valueOf(f4));
                    inspectorInfo.b().c("colorFilter", colorFilter2);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c((InspectorInfo) obj);
                    return Unit.f139807a;
                }
            };
        } else {
            painter2 = painter;
            alignment2 = alignment;
            contentScale2 = contentScale;
            f4 = f3;
            colorFilter2 = colorFilter;
            function1A = InspectableValueKt.a();
        }
        super(function1A);
        this.f55558b = painter2;
        this.f55559c = alignment2;
        this.f55560d = contentScale2;
        this.f55561f = f4;
        this.f55562g = colorFilter2;
    }

    private final long c(long j3) {
        if (Size.k(j3)) {
            return Size.f25617b.b();
        }
        long jL = this.f55558b.l();
        if (jL == Size.f25617b.a()) {
            return j3;
        }
        float fI = Size.i(jL);
        if (Float.isInfinite(fI) || Float.isNaN(fI)) {
            fI = Size.i(j3);
        }
        float fG = Size.g(jL);
        if (Float.isInfinite(fG) || Float.isNaN(fG)) {
            fG = Size.g(j3);
        }
        long jA = SizeKt.a(fI, fG);
        return ScaleFactorKt.a(jA, this.f55560d.a(jA, j3));
    }

    private final long d(long j3) {
        float fN;
        int iM;
        float fA;
        boolean zJ = Constraints.j(j3);
        boolean zI = Constraints.i(j3);
        if (!zJ || !zI) {
            boolean z2 = Constraints.h(j3) && Constraints.g(j3);
            long jL = this.f55558b.l();
            if (jL != Size.f25617b.a()) {
                if (z2 && (zJ || zI)) {
                    fN = Constraints.l(j3);
                    iM = Constraints.k(j3);
                } else {
                    float fI = Size.i(jL);
                    float fG = Size.g(jL);
                    fN = (Float.isInfinite(fI) || Float.isNaN(fI)) ? Constraints.n(j3) : UtilsKt.b(j3, fI);
                    if (!Float.isInfinite(fG) && !Float.isNaN(fG)) {
                        fA = UtilsKt.a(j3, fG);
                        long jC = c(SizeKt.a(fN, fA));
                        return Constraints.d(j3, ConstraintsKt.g(j3, MathKt.d(Size.i(jC))), 0, ConstraintsKt.f(j3, MathKt.d(Size.g(jC))), 0, 10, null);
                    }
                    iM = Constraints.m(j3);
                }
                fA = iM;
                long jC2 = c(SizeKt.a(fN, fA));
                return Constraints.d(j3, ConstraintsKt.g(j3, MathKt.d(Size.i(jC2))), 0, ConstraintsKt.f(j3, MathKt.d(Size.g(jC2))), 0, 10, null);
            }
            if (z2) {
                return Constraints.d(j3, Constraints.l(j3), 0, Constraints.k(j3), 0, 10, null);
            }
        }
        return j3;
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        long jC = c(contentDrawScope.b());
        long jA = this.f55559c.a(UtilsKt.f(jC), UtilsKt.f(contentDrawScope.b()), contentDrawScope.getLayoutDirection());
        float fD = IntOffset.d(jA);
        float fE = IntOffset.e(jA);
        contentDrawScope.Q1().e().e(fD, fE);
        this.f55558b.j(contentDrawScope, jC, this.f55561f, this.f55562g);
        contentDrawScope.Q1().e().e(-fD, -fE);
        contentDrawScope.i2();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ContentPainterModifier)) {
            return false;
        }
        ContentPainterModifier contentPainterModifier = (ContentPainterModifier) obj;
        return Intrinsics.areEqual(this.f55558b, contentPainterModifier.f55558b) && Intrinsics.areEqual(this.f55559c, contentPainterModifier.f55559c) && Intrinsics.areEqual(this.f55560d, contentPainterModifier.f55560d) && Float.compare(this.f55561f, contentPainterModifier.f55561f) == 0 && Intrinsics.areEqual(this.f55562g, contentPainterModifier.f55562g);
    }

    public int hashCode() {
        int iHashCode = ((((((this.f55558b.hashCode() * 31) + this.f55559c.hashCode()) * 31) + this.f55560d.hashCode()) * 31) + Float.hashCode(this.f55561f)) * 31;
        ColorFilter colorFilter = this.f55562g;
        return iHashCode + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (this.f55558b.l() == Size.f25617b.a()) {
            return intrinsicMeasurable.I(i3);
        }
        int I = intrinsicMeasurable.I(Constraints.l(d(ConstraintsKt.b(0, i3, 0, 0, 13, null))));
        return Math.max(MathKt.d(Size.g(c(SizeKt.a(i3, I)))), I);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (this.f55558b.l() == Size.f25617b.a()) {
            return intrinsicMeasurable.l0(i3);
        }
        int iL0 = intrinsicMeasurable.l0(Constraints.k(d(ConstraintsKt.b(0, 0, 0, i3, 7, null))));
        return Math.max(MathKt.d(Size.i(c(SizeKt.a(iL0, i3)))), iL0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo45measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j3) {
        final Placeable placeableN0 = measurable.n0(d(j3));
        return MeasureScope.B0(measureScope, placeableN0.X0(), placeableN0.O0(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.ContentPainterModifier$measure$1
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

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (this.f55558b.l() == Size.f25617b.a()) {
            return intrinsicMeasurable.d0(i3);
        }
        int iD0 = intrinsicMeasurable.d0(Constraints.l(d(ConstraintsKt.b(0, i3, 0, 0, 13, null))));
        return Math.max(MathKt.d(Size.g(c(SizeKt.a(i3, iD0)))), iD0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i3) {
        if (this.f55558b.l() == Size.f25617b.a()) {
            return intrinsicMeasurable.k0(i3);
        }
        int iK0 = intrinsicMeasurable.k0(Constraints.k(d(ConstraintsKt.b(0, 0, 0, i3, 7, null))));
        return Math.max(MathKt.d(Size.i(c(SizeKt.a(iK0, i3)))), iK0);
    }

    public String toString() {
        return "ContentPainterModifier(painter=" + this.f55558b + ", alignment=" + this.f55559c + ", contentScale=" + this.f55560d + ", alpha=" + this.f55561f + ", colorFilter=" + this.f55562g + ')';
    }
}
