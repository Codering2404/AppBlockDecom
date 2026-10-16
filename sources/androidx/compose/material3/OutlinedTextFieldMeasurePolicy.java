package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.internal.TextFieldImplKt;
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
    private final Function1 f19110a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f19111b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float f19112c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PaddingValues f19113d;

    public OutlinedTextFieldMeasurePolicy(Function1 function1, boolean z2, float f3, PaddingValues paddingValues) {
        this.f19110a = function1;
        this.f19111b = z2;
        this.f19112c = f3;
        this.f19113d = paddingValues;
    }

    private final int d(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3, Function2 function2) {
        Object obj;
        int iO;
        int iIntValue;
        Object obj2;
        int iIntValue2;
        Object obj3;
        Object obj4;
        int iIntValue3;
        Object obj5;
        int i4;
        Object obj6;
        Object obj7;
        int size = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i5);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj), "Leading")) {
                break;
            }
            i5++;
        }
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj;
        if (intrinsicMeasurable != null) {
            iO = OutlinedTextFieldKt.o(i3, intrinsicMeasurable.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            iIntValue = ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(i3))).intValue();
        } else {
            iO = i3;
            iIntValue = 0;
        }
        int size2 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i6);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj2), "Trailing")) {
                break;
            }
            i6++;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj2;
        if (intrinsicMeasurable2 != null) {
            iO = OutlinedTextFieldKt.o(iO, intrinsicMeasurable2.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            iIntValue2 = ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i3))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i7);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj3), "Label")) {
                break;
            }
            i7++;
        }
        Object obj8 = (IntrinsicMeasurable) obj3;
        int iIntValue4 = obj8 != null ? ((Number) function2.invoke(obj8, Integer.valueOf(MathHelpersKt.c(iO, i3, this.f19112c)))).intValue() : 0;
        int size4 = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i8);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj4), "Prefix")) {
                break;
            }
            i8++;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj4;
        if (intrinsicMeasurable3 != null) {
            iIntValue3 = ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(iO))).intValue();
            iO = OutlinedTextFieldKt.o(iO, intrinsicMeasurable3.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
        } else {
            iIntValue3 = 0;
        }
        int size5 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list.get(i9);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj5), "Suffix")) {
                break;
            }
            i9++;
        }
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj5;
        if (intrinsicMeasurable4 != null) {
            int iIntValue5 = ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(iO))).intValue();
            iO = OutlinedTextFieldKt.o(iO, intrinsicMeasurable4.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            i4 = iIntValue5;
        } else {
            i4 = 0;
        }
        int size6 = list.size();
        for (int i10 = 0; i10 < size6; i10++) {
            Object obj9 = list.get(i10);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj9), "TextField")) {
                int iIntValue6 = ((Number) function2.invoke(obj9, Integer.valueOf(iO))).intValue();
                int size7 = list.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i11);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj6), "Hint")) {
                        break;
                    }
                    i11++;
                }
                Object obj10 = (IntrinsicMeasurable) obj6;
                int iIntValue7 = obj10 != null ? ((Number) function2.invoke(obj10, Integer.valueOf(iO))).intValue() : 0;
                int size8 = list.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size8) {
                        obj7 = null;
                        break;
                    }
                    Object obj11 = list.get(i12);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj11), "Supporting")) {
                        obj7 = obj11;
                        break;
                    }
                    i12++;
                }
                Object obj12 = (IntrinsicMeasurable) obj7;
                return OutlinedTextFieldKt.i(iIntValue, iIntValue2, iIntValue3, i4, iIntValue6, iIntValue4, iIntValue7, obj12 != null ? ((Number) function2.invoke(obj12, Integer.valueOf(i3))).intValue() : 0, this.f19112c, TextFieldImplKt.s(), intrinsicMeasureScope.getDensity(), this.f19113d);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int e(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3, Function2 function2) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            Object obj7 = list.get(i4);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj7), "TextField")) {
                int iIntValue = ((Number) function2.invoke(obj7, Integer.valueOf(i3))).intValue();
                int size2 = list.size();
                int i5 = 0;
                while (true) {
                    obj = null;
                    if (i5 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i5);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj2), "Label")) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj3), "Trailing")) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj4), "Leading")) {
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
                        obj5 = null;
                        break;
                    }
                    obj5 = list.get(i8);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj5), "Prefix")) {
                        break;
                    }
                    i8++;
                }
                IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj5;
                int iIntValue5 = intrinsicMeasurable4 != null ? ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(i3))).intValue() : 0;
                int size6 = list.size();
                int i9 = 0;
                while (true) {
                    if (i9 >= size6) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i9);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj6), "Suffix")) {
                        break;
                    }
                    i9++;
                }
                IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) obj6;
                int iIntValue6 = intrinsicMeasurable5 != null ? ((Number) function2.invoke(intrinsicMeasurable5, Integer.valueOf(i3))).intValue() : 0;
                int size7 = list.size();
                int i10 = 0;
                while (true) {
                    if (i10 >= size7) {
                        break;
                    }
                    Object obj8 = list.get(i10);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj8), "Hint")) {
                        obj = obj8;
                        break;
                    }
                    i10++;
                }
                IntrinsicMeasurable intrinsicMeasurable6 = (IntrinsicMeasurable) obj;
                return OutlinedTextFieldKt.j(iIntValue4, iIntValue3, iIntValue5, iIntValue6, iIntValue, iIntValue2, intrinsicMeasurable6 != null ? ((Number) function2.invoke(intrinsicMeasurable6, Integer.valueOf(i3))).intValue() : 0, this.f19112c, TextFieldImplKt.s(), intrinsicMeasureScope.getDensity(), this.f19113d);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return d(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.maxIntrinsicHeight.1
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
        return e(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.maxIntrinsicWidth.1
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
    public MeasureResult mo10measure3p2s80s(MeasureScope measureScope, List list, long j3) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Placeable placeable;
        Object obj5;
        Object obj6;
        Object obj7;
        final OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = this;
        final MeasureScope measureScope2 = measureScope;
        int iZ0 = measureScope2.z0(outlinedTextFieldMeasurePolicy.f19113d.a());
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
        int iV = TextFieldImplKt.v(placeableN0);
        int iMax = Math.max(0, TextFieldImplKt.t(placeableN0));
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
        Placeable placeableN02 = measurable2 != null ? measurable2.n0(ConstraintsKt.j(jD, -iV, 0, 2, null)) : null;
        int iV2 = iV + TextFieldImplKt.v(placeableN02);
        int iMax2 = Math.max(iMax, TextFieldImplKt.t(placeableN02));
        int size3 = list.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj3), "Prefix")) {
                break;
            }
            i5++;
        }
        Measurable measurable3 = (Measurable) obj3;
        Placeable placeableN03 = measurable3 != null ? measurable3.n0(ConstraintsKt.j(jD, -iV2, 0, 2, null)) : null;
        int iV3 = iV2 + TextFieldImplKt.v(placeableN03);
        int iMax3 = Math.max(iMax2, TextFieldImplKt.t(placeableN03));
        int size4 = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj4), "Suffix")) {
                break;
            }
            i6++;
        }
        Measurable measurable4 = (Measurable) obj4;
        Placeable placeableN04 = measurable4 != null ? measurable4.n0(ConstraintsKt.j(jD, -iV3, 0, 2, null)) : null;
        int iV4 = iV3 + TextFieldImplKt.v(placeableN04);
        int iMax4 = Math.max(iMax3, TextFieldImplKt.t(placeableN04));
        int iZ02 = measureScope2.z0(outlinedTextFieldMeasurePolicy.f19113d.b(measureScope2.getLayoutDirection())) + measureScope2.z0(outlinedTextFieldMeasurePolicy.f19113d.c(measureScope2.getLayoutDirection()));
        int i7 = -iV4;
        int i8 = -iZ0;
        long jI = ConstraintsKt.i(jD, MathHelpersKt.c(i7 - iZ02, -iZ02, outlinedTextFieldMeasurePolicy.f19112c), i8);
        int size5 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size5) {
                placeable = placeableN0;
                obj5 = null;
                break;
            }
            obj5 = list.get(i9);
            int i10 = i9;
            placeable = placeableN0;
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj5), "Label")) {
                break;
            }
            i9 = i10 + 1;
            placeableN0 = placeable;
        }
        Measurable measurable5 = (Measurable) obj5;
        final Placeable placeableN05 = measurable5 != null ? measurable5.n0(jI) : null;
        outlinedTextFieldMeasurePolicy.f19110a.invoke(Size.c(placeableN05 != null ? SizeKt.a(placeableN05.X0(), placeableN05.O0()) : Size.f25617b.b()));
        int size6 = list.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size6) {
                obj6 = null;
                break;
            }
            obj6 = list.get(i11);
            int i12 = size6;
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj6), "Supporting")) {
                break;
            }
            i11++;
            size6 = i12;
        }
        Measurable measurable6 = (Measurable) obj6;
        int iD0 = measurable6 != null ? measurable6.d0(Constraints.n(j3)) : 0;
        int iMax5 = Math.max(TextFieldImplKt.t(placeableN05) / 2, measureScope2.z0(outlinedTextFieldMeasurePolicy.f19113d.d()));
        long jD2 = Constraints.d(ConstraintsKt.i(j3, i7, (i8 - iMax5) - iD0), 0, 0, 0, 0, 11, null);
        int size7 = list.size();
        final Placeable placeable2 = placeableN03;
        int i13 = 0;
        while (i13 < size7) {
            int i14 = size7;
            Measurable measurable7 = (Measurable) list.get(i13);
            final Placeable placeable3 = placeableN04;
            final Placeable placeable4 = placeableN02;
            if (Intrinsics.areEqual(LayoutIdKt.a(measurable7), "TextField")) {
                final Placeable placeableN06 = measurable7.n0(jD2);
                long jD3 = Constraints.d(jD2, 0, 0, 0, 0, 14, null);
                int size8 = list.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list.get(i15);
                    int i16 = size8;
                    int i17 = i15;
                    if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj7), "Hint")) {
                        break;
                    }
                    i15 = i17 + 1;
                    size8 = i16;
                }
                Measurable measurable8 = (Measurable) obj7;
                final Placeable placeableN07 = measurable8 != null ? measurable8.n0(jD3) : null;
                int iMax6 = Math.max(iMax4, Math.max(TextFieldImplKt.t(placeableN06), TextFieldImplKt.t(placeableN07)) + iMax5 + iZ0);
                int iJ = OutlinedTextFieldKt.j(TextFieldImplKt.v(placeable), TextFieldImplKt.v(placeable4), TextFieldImplKt.v(placeable2), TextFieldImplKt.v(placeable3), placeableN06.X0(), TextFieldImplKt.v(placeableN05), TextFieldImplKt.v(placeableN07), outlinedTextFieldMeasurePolicy.f19112c, j3, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.f19113d);
                int i18 = iJ;
                final Placeable placeableN08 = measurable6 != null ? measurable6.n0(Constraints.d(ConstraintsKt.j(jD, 0, -iMax6, 1, null), 0, iJ, 0, 0, 9, null)) : null;
                int iT = TextFieldImplKt.t(placeableN08);
                final int i19 = OutlinedTextFieldKt.i(TextFieldImplKt.t(placeable), TextFieldImplKt.t(placeable4), TextFieldImplKt.t(placeable2), TextFieldImplKt.t(placeable3), placeableN06.O0(), TextFieldImplKt.t(placeableN05), TextFieldImplKt.t(placeableN07), TextFieldImplKt.t(placeableN08), outlinedTextFieldMeasurePolicy.f19112c, j3, measureScope2.getDensity(), outlinedTextFieldMeasurePolicy.f19113d);
                int i20 = i19 - iT;
                int size9 = list.size();
                int i21 = 0;
                while (i21 < size9) {
                    Measurable measurable9 = (Measurable) list.get(i21);
                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable9), "Container")) {
                        final Placeable placeableN09 = measurable9.n0(ConstraintsKt.a(i18 != Integer.MAX_VALUE ? i18 : 0, i18, i20 != Integer.MAX_VALUE ? i20 : 0, i20));
                        final int i22 = i18;
                        final Placeable placeable5 = placeable;
                        return MeasureScope.B0(measureScope, i22, i19, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy$measure$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj8) {
                                invoke((Placeable.PlacementScope) obj8);
                                return Unit.f139807a;
                            }

                            public final void invoke(Placeable.PlacementScope placementScope) {
                                OutlinedTextFieldKt.m(placementScope, i19, i22, placeable5, placeable4, placeable2, placeable3, placeableN06, placeableN05, placeableN07, placeableN09, placeableN08, outlinedTextFieldMeasurePolicy.f19112c, outlinedTextFieldMeasurePolicy.f19111b, measureScope2.getDensity(), measureScope2.getLayoutDirection(), outlinedTextFieldMeasurePolicy.f19113d);
                            }
                        }, 4, null);
                    }
                    i21++;
                    outlinedTextFieldMeasurePolicy = this;
                    measureScope2 = measureScope;
                    i18 = i18;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i13++;
            outlinedTextFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            placeableN02 = placeable4;
            size7 = i14;
            placeableN04 = placeable3;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return d(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.minIntrinsicHeight.1
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
        return e(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.OutlinedTextFieldMeasurePolicy.minIntrinsicWidth.1
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
