package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
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
import androidx.compose.ui.util.MathHelpersKt;
import com.google.android.gms.common.api.Api;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
final class OutlinedTextFieldMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f13473a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f13474b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f13475c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PaddingValues f13476d;

    public OutlinedTextFieldMeasurePolicy(Function1 function1, boolean z2, float f3, PaddingValues paddingValues) {
        this.f13473a = function1;
        this.f13474b = z2;
        this.f13475c = f3;
        this.f13476d = paddingValues;
    }

    private final int d(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3, Function2 function2) {
        Object obj;
        Object obj2;
        int iO;
        int iIntValue;
        Object obj3;
        int iIntValue2;
        Object obj4;
        int size = list.size();
        int i4 = 0;
        while (true) {
            obj = null;
            if (i4 >= size) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj2), "Leading")) {
                break;
            }
            i4++;
        }
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj2;
        if (intrinsicMeasurable != null) {
            iO = OutlinedTextFieldKt.o(i3, intrinsicMeasurable.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            iIntValue = ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(i3))).intValue();
        } else {
            iO = i3;
            iIntValue = 0;
        }
        int size2 = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size2) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i5);
            if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj3), "Trailing")) {
                break;
            }
            i5++;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj3;
        if (intrinsicMeasurable2 != null) {
            iO = OutlinedTextFieldKt.o(iO, intrinsicMeasurable2.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            iIntValue2 = ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i3))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size3) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i6);
            if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj4), "Label")) {
                break;
            }
            i6++;
        }
        Object obj5 = (IntrinsicMeasurable) obj4;
        int iIntValue3 = obj5 != null ? ((Number) function2.invoke(obj5, Integer.valueOf(MathHelpersKt.c(iO, i3, this.f13475c)))).intValue() : 0;
        int size4 = list.size();
        for (int i7 = 0; i7 < size4; i7++) {
            Object obj6 = list.get(i7);
            if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj6), "TextField")) {
                int iIntValue4 = ((Number) function2.invoke(obj6, Integer.valueOf(iO))).intValue();
                int size5 = list.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size5) {
                        break;
                    }
                    Object obj7 = list.get(i8);
                    if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj7), "Hint")) {
                        obj = obj7;
                        break;
                    }
                    i8++;
                }
                Object obj8 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.k(iIntValue, iIntValue2, iIntValue4, iIntValue3, obj8 != null ? ((Number) function2.invoke(obj8, Integer.valueOf(iO))).intValue() : 0, this.f13475c, TextFieldImplKt.h(), intrinsicMeasureScope.getDensity(), this.f13476d);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int e(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3, Function2 function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Object obj5 = list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj5), "TextField")) {
                int iIntValue = ((Number) function2.invoke(obj5, Integer.valueOf(i3))).intValue();
                int size2 = list.size();
                int i5 = 0;
                while (true) {
                    obj = null;
                    if (i5 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj2), "Label")) {
                        break;
                    }
                    i5++;
                }
                IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj2;
                int iIntValue2 = intrinsicMeasurable != null ? ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(i3))).intValue() : 0;
                int size3 = list.size();
                int i6 = 0;
                while (true) {
                    if (i6 >= size3) {
                        obj3 = null;
                        break;
                    }
                    obj3 = list.get(i6);
                    if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj3), "Trailing")) {
                        break;
                    }
                    i6++;
                }
                IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj3;
                int iIntValue3 = intrinsicMeasurable2 != null ? ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i3))).intValue() : 0;
                int size4 = list.size();
                int i7 = 0;
                while (true) {
                    if (i7 >= size4) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list.get(i7);
                    if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj4), "Leading")) {
                        break;
                    }
                    i7++;
                }
                IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj4;
                int iIntValue4 = intrinsicMeasurable3 != null ? ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(i3))).intValue() : 0;
                int size5 = list.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size5) {
                        break;
                    }
                    Object obj6 = list.get(i8);
                    if (Intrinsics.areEqual(TextFieldImplKt.f((IntrinsicMeasurable) obj6), "Hint")) {
                        obj = obj6;
                        break;
                    }
                    i8++;
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.l(iIntValue4, iIntValue3, iIntValue, iIntValue2, intrinsicMeasurable4 != null ? ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(i3))).intValue() : 0, this.f13475c, TextFieldImplKt.h(), intrinsicMeasureScope.getDensity(), this.f13476d);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return d(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy.maxIntrinsicHeight.1
            public final Integer c(IntrinsicMeasurable intrinsicMeasurable, int i4) {
                return Integer.valueOf(intrinsicMeasurable.I(i4));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return e(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy.maxIntrinsicWidth.1
            public final Integer c(IntrinsicMeasurable intrinsicMeasurable, int i4) {
                return Integer.valueOf(intrinsicMeasurable.l0(i4));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* JADX INFO: renamed from: measure-3p2s80s */
    public MeasureResult mo10measure3p2s80s(final MeasureScope measureScope, List list, long j3) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        final OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
        MeasureScope measureScope2 = measureScope;
        int iZ0 = measureScope2.z0(outlinedTextFieldMeasurePolicy.f13476d.a());
        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
        int size = list.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i3);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj), "Leading")) {
                break;
            }
            i3++;
        }
        Measurable measurable = (Measurable) obj;
        Placeable placeableN0 = measurable != null ? measurable.n0(jD) : null;
        int iJ = TextFieldImplKt.j(placeableN0);
        int size2 = list.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj2), "Trailing")) {
                break;
            }
            i4++;
        }
        Measurable measurable2 = (Measurable) obj2;
        Placeable placeableN02 = measurable2 != null ? measurable2.n0(ConstraintsKt.j(jD, -iJ, 0, 2, null)) : null;
        int iJ2 = iJ + TextFieldImplKt.j(placeableN02);
        int iZ02 = measureScope2.z0(outlinedTextFieldMeasurePolicy.f13476d.b(measureScope2.getLayoutDirection())) + measureScope2.z0(outlinedTextFieldMeasurePolicy.f13476d.c(measureScope2.getLayoutDirection()));
        int i5 = -iJ2;
        int i6 = -iZ0;
        long jI = ConstraintsKt.i(jD, MathHelpersKt.c(i5 - iZ02, -iZ02, outlinedTextFieldMeasurePolicy.f13475c), i6);
        int size3 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i7);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj3), "Label")) {
                break;
            }
            i7++;
        }
        Measurable measurable3 = (Measurable) obj3;
        final Placeable placeableN03 = measurable3 != null ? measurable3.n0(jI) : null;
        outlinedTextFieldMeasurePolicy.f13473a.invoke(Size.c(placeableN03 != null ? SizeKt.a(placeableN03.X0(), placeableN03.O0()) : Size.f25617b.b()));
        long j4 = j3;
        long jD2 = Constraints.d(ConstraintsKt.i(j4, i5, i6 - Math.max(TextFieldImplKt.i(placeableN03) / 2, measureScope2.z0(outlinedTextFieldMeasurePolicy.f13476d.d()))), 0, 0, 0, 0, 11, null);
        int size4 = list.size();
        int i8 = 0;
        while (i8 < size4) {
            Measurable measurable4 = (Measurable) list.get(i8);
            if (Intrinsics.areEqual(LayoutIdKt.a(measurable4), "TextField")) {
                Placeable placeableN04 = measurable4.n0(jD2);
                long jD3 = Constraints.d(jD2, 0, 0, 0, 0, 14, null);
                int size5 = list.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size5) {
                        obj4 = null;
                        break;
                    }
                    obj4 = list.get(i9);
                    if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj4), "Hint")) {
                        break;
                    }
                    i9++;
                }
                Measurable measurable5 = (Measurable) obj4;
                final Placeable placeableN05 = measurable5 != null ? measurable5.n0(jD3) : null;
                int iL = OutlinedTextFieldKt.l(TextFieldImplKt.j(placeableN0), TextFieldImplKt.j(placeableN02), placeableN04.X0(), TextFieldImplKt.j(placeableN03), TextFieldImplKt.j(placeableN05), outlinedTextFieldMeasurePolicy.f13475c, j4, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.f13476d);
                int iK = OutlinedTextFieldKt.k(TextFieldImplKt.i(placeableN0), TextFieldImplKt.i(placeableN02), placeableN04.O0(), TextFieldImplKt.i(placeableN03), TextFieldImplKt.i(placeableN05), outlinedTextFieldMeasurePolicy.f13475c, j3, measureScope.getDensity(), outlinedTextFieldMeasurePolicy.f13476d);
                int size6 = list.size();
                int i10 = 0;
                while (i10 < size6) {
                    Measurable measurable6 = (Measurable) list.get(i10);
                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable6), "border")) {
                        final Placeable placeableN06 = measurable6.n0(ConstraintsKt.a(iL != Integer.MAX_VALUE ? iL : 0, iL, iK != Integer.MAX_VALUE ? iK : 0, iK));
                        final Placeable placeable = placeableN04;
                        final int i11 = iL;
                        final Placeable placeable2 = placeableN02;
                        final int i12 = iK;
                        final Placeable placeable3 = placeableN0;
                        return MeasureScope.B0(measureScope, i11, i12, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy$measure$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj5) {
                                invoke((Placeable.PlacementScope) obj5);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                OutlinedTextFieldKt.n(placementScope, i12, i11, placeable3, placeable2, placeable, placeableN03, placeableN05, placeableN06, outlinedTextFieldMeasurePolicy.f13475c, outlinedTextFieldMeasurePolicy.f13474b, measureScope.getDensity(), measureScope.getLayoutDirection(), outlinedTextFieldMeasurePolicy.f13476d);
                            }
                        }, 4, null);
                    }
                    i10++;
                    placeableN04 = placeableN04;
                    iL = iL;
                    placeableN0 = placeableN0;
                    iK = iK;
                    outlinedTextFieldMeasurePolicy = this;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i8++;
            outlinedTextFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            j4 = j3;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return d(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy.minIntrinsicHeight.1
            public final Integer c(IntrinsicMeasurable intrinsicMeasurable, int i4) {
                return Integer.valueOf(intrinsicMeasurable.d0(i4));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }
        });
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return e(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material.OutlinedTextFieldMeasurePolicy.minIntrinsicWidth.1
            public final Integer c(IntrinsicMeasurable intrinsicMeasurable, int i4) {
                return Integer.valueOf(intrinsicMeasurable.k0(i4));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return c((IntrinsicMeasurable) obj, ((Number) obj2).intValue());
            }
        });
    }
}
