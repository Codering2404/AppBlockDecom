package androidx.compose.material3;

import androidx.compose.material3.internal.TextFieldImplKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class TopIconOrIconOnlyMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f21561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f21562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f21563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final float f21564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final float f21565f;

    public /* synthetic */ TopIconOrIconOnlyMeasurePolicy(boolean z2, Function0 function0, float f3, float f4, float f5, float f6, DefaultConstructorMarker defaultConstructorMarker) {
        this(z2, function0, f3, f4, f5, f6);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        Object obj;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.l(intrinsicMeasurable), "icon")) {
                int I = intrinsicMeasurable.I(i3);
                int size2 = list.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size2) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj), "label")) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj;
                int I2 = intrinsicMeasurable2 != null ? intrinsicMeasurable2.I(i3) : 0;
                float f3 = 2;
                return I + I2 + intrinsicMeasureScope.z0(Dp.g(Dp.g(Dp.g(this.f21565f * f3) + Dp.g(this.f21563d * f3)) + this.f21564e));
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        MeasureScope measureScope2 = measureScope;
        float fFloatValue = ((Number) this.f21561b.invoke()).floatValue();
        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i4 < size) {
            Measurable measurable = (Measurable) list.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "icon")) {
                float f3 = 2;
                Placeable placeableN0 = measurable.n0(ConstraintsKt.i(jD, -measureScope2.z0(Dp.g(this.f21562c * f3)), -measureScope2.z0(Dp.g(this.f21563d * f3))));
                int iX0 = placeableN0.X0() + measureScope2.z0(Dp.g(this.f21562c * f3));
                int iO0 = placeableN0.O0() + measureScope2.z0(Dp.g(this.f21563d * f3));
                int iD = MathKt.d(iX0 * fFloatValue);
                int size2 = list.size();
                int i5 = 0;
                while (i5 < size2) {
                    Measurable measurable2 = (Measurable) list.get(i5);
                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable2), "indicatorRipple")) {
                        Placeable placeableN02 = measurable2.n0(ConstraintsKt.e(jD, Constraints.f29963b.c(iX0, iO0)));
                        int size3 = list.size();
                        int i6 = 0;
                        while (i6 < size3) {
                            Measurable measurable3 = (Measurable) list.get(i6);
                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable3), "indicator")) {
                                Placeable placeableN03 = measurable3.n0(ConstraintsKt.e(jD, Constraints.f29963b.c(iD, iO0)));
                                if (!this.f21560a) {
                                    return NavigationItemKt.j(measureScope2, placeableN0, placeableN02, placeableN03, j3);
                                }
                                int size4 = list.size();
                                while (i3 < size4) {
                                    Measurable measurable4 = (Measurable) list.get(i3);
                                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable4), "label")) {
                                        return NavigationItemKt.l(measureScope2, measurable4.n0(ConstraintsKt.j(jD, 0, -(placeableN03.O0() + measureScope2.z0(this.f21564e)), 1, null)), placeableN0, placeableN02, placeableN03, j3, this.f21564e, this.f21563d, this.f21565f);
                                    }
                                    i3++;
                                    placeableN0 = placeableN0;
                                    placeableN03 = placeableN03;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i6++;
                            placeableN0 = placeableN0;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    i5++;
                    measureScope2 = measureScope;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i4++;
            measureScope2 = measureScope;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private TopIconOrIconOnlyMeasurePolicy(boolean z2, Function0 function0, float f3, float f4, float f5, float f6) {
        this.f21560a = z2;
        this.f21561b = function0;
        this.f21562c = f3;
        this.f21563d = f4;
        this.f21564e = f5;
        this.f21565f = f6;
    }
}
