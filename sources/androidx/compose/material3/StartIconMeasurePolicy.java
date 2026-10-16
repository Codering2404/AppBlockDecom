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
final class StartIconMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f20342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f20343b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f20344c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float f20345d;

    public /* synthetic */ StartIconMeasurePolicy(Function0 function0, float f3, float f4, float f5, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, f3, f4, f5);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.l(intrinsicMeasurable), "icon")) {
                int I = intrinsicMeasurable.I(i3);
                int size2 = list.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.l(intrinsicMeasurable2), "label")) {
                        return Math.max(I, intrinsicMeasurable2.I(i3)) + intrinsicMeasureScope.z0(Dp.g(this.f20344c * 2));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.l(intrinsicMeasurable), "icon")) {
                int iL0 = intrinsicMeasurable.l0(i3);
                int size2 = list.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) list.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.l(intrinsicMeasurable2), "label")) {
                        return iL0 + intrinsicMeasurable2.l0(i3) + intrinsicMeasureScope.z0(Dp.g(Dp.g(this.f20343b * 2) + this.f20345d));
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        MeasureScope measureScope2 = measureScope;
        float fFloatValue = ((Number) this.f20342a.invoke()).floatValue();
        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
        float f3 = 2;
        long jI = ConstraintsKt.i(jD, -measureScope2.z0(Dp.g(this.f20343b * f3)), -measureScope2.z0(Dp.g(this.f20344c * f3)));
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            Measurable measurable = (Measurable) list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.a(measurable), "icon")) {
                Placeable placeableN0 = measurable.n0(jI);
                int size2 = list.size();
                int i4 = 0;
                while (i4 < size2) {
                    Measurable measurable2 = (Measurable) list.get(i4);
                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable2), "label")) {
                        Placeable placeableN02 = measurable2.n0(ConstraintsKt.j(jI, -(placeableN0.X0() + measureScope2.z0(this.f20345d)), 0, 2, null));
                        int iX0 = placeableN0.X0() + placeableN02.X0() + measureScope2.z0(Dp.g(this.f20345d + Dp.g(this.f20343b * f3)));
                        int iMax = Math.max(placeableN0.O0(), placeableN02.O0()) + measureScope2.z0(Dp.g(this.f20344c * f3));
                        int iD = MathKt.d(iX0 * fFloatValue);
                        int size3 = list.size();
                        int i5 = 0;
                        while (i5 < size3) {
                            Measurable measurable3 = (Measurable) list.get(i5);
                            if (Intrinsics.areEqual(LayoutIdKt.a(measurable3), "indicatorRipple")) {
                                Placeable placeableN03 = measurable3.n0(ConstraintsKt.e(jD, Constraints.f29963b.c(iX0, iMax)));
                                int size4 = list.size();
                                int i6 = 0;
                                while (i6 < size4) {
                                    Measurable measurable4 = (Measurable) list.get(i6);
                                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable4), "indicator")) {
                                        return NavigationItemKt.k(measureScope2, placeableN02, placeableN0, placeableN03, measurable4.n0(ConstraintsKt.e(jD, Constraints.f29963b.c(iD, iMax))), j3, this.f20345d);
                                    }
                                    i6++;
                                    placeableN0 = placeableN0;
                                    measureScope2 = measureScope;
                                }
                                throw new NoSuchElementException("Collection contains no element matching the predicate.");
                            }
                            i5++;
                            placeableN0 = placeableN0;
                            measureScope2 = measureScope;
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                    i4++;
                    measureScope2 = measureScope;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i3++;
            measureScope2 = measureScope;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private StartIconMeasurePolicy(Function0 function0, float f3, float f4, float f5) {
        this.f20342a = function0;
        this.f20343b = f3;
        this.f20344c = f4;
        this.f20345d = f5;
    }
}
