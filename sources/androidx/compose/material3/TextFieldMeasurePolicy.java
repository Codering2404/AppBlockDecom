package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingValues;
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
final class TextFieldMeasurePolicy implements MeasurePolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f21021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f21022b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PaddingValues f21023c;

    public TextFieldMeasurePolicy(boolean z2, float f3, PaddingValues paddingValues) {
        this.f21021a = z2;
        this.f21022b = f3;
        this.f21023c = paddingValues;
    }

    private final int d(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3, Function2 function2) {
        Object obj;
        int i4;
        int iP;
        int iIntValue;
        Object obj2;
        int iIntValue2;
        Object obj3;
        Object obj4;
        int iIntValue3;
        Object obj5;
        int i5;
        Object obj6;
        Object obj7;
        int size = list.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                obj = null;
                break;
            }
            obj = list.get(i6);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj), "Leading")) {
                break;
            }
            i6++;
        }
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) obj;
        if (intrinsicMeasurable != null) {
            i4 = i3;
            iP = TextFieldKt.p(i4, intrinsicMeasurable.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            iIntValue = ((Number) function2.invoke(intrinsicMeasurable, Integer.valueOf(i4))).intValue();
        } else {
            i4 = i3;
            iP = i4;
            iIntValue = 0;
        }
        int size2 = list.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list.get(i7);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj2), "Trailing")) {
                break;
            }
            i7++;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) obj2;
        if (intrinsicMeasurable2 != null) {
            iP = TextFieldKt.p(iP, intrinsicMeasurable2.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            iIntValue2 = ((Number) function2.invoke(intrinsicMeasurable2, Integer.valueOf(i4))).intValue();
        } else {
            iIntValue2 = 0;
        }
        int size3 = list.size();
        int i8 = 0;
        while (true) {
            if (i8 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list.get(i8);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj3), "Label")) {
                break;
            }
            i8++;
        }
        Object obj8 = (IntrinsicMeasurable) obj3;
        int iIntValue4 = obj8 != null ? ((Number) function2.invoke(obj8, Integer.valueOf(iP))).intValue() : 0;
        int size4 = list.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list.get(i9);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj4), "Prefix")) {
                break;
            }
            i9++;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) obj4;
        if (intrinsicMeasurable3 != null) {
            iIntValue3 = ((Number) function2.invoke(intrinsicMeasurable3, Integer.valueOf(iP))).intValue();
            iP = TextFieldKt.p(iP, intrinsicMeasurable3.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
        } else {
            iIntValue3 = 0;
        }
        int size5 = list.size();
        int i10 = 0;
        while (true) {
            if (i10 >= size5) {
                obj5 = null;
                break;
            }
            obj5 = list.get(i10);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj5), "Suffix")) {
                break;
            }
            i10++;
        }
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) obj5;
        if (intrinsicMeasurable4 != null) {
            int iIntValue5 = ((Number) function2.invoke(intrinsicMeasurable4, Integer.valueOf(iP))).intValue();
            iP = TextFieldKt.p(iP, intrinsicMeasurable4.l0(Api.BaseClientBuilder.API_PRIORITY_OTHER));
            i5 = iIntValue5;
        } else {
            i5 = 0;
        }
        int size6 = list.size();
        for (int i11 = 0; i11 < size6; i11++) {
            Object obj9 = list.get(i11);
            if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj9), "TextField")) {
                int iIntValue6 = ((Number) function2.invoke(obj9, Integer.valueOf(iP))).intValue();
                int size7 = list.size();
                int i12 = 0;
                while (true) {
                    if (i12 >= size7) {
                        obj6 = null;
                        break;
                    }
                    obj6 = list.get(i12);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj6), "Hint")) {
                        break;
                    }
                    i12++;
                }
                Object obj10 = (IntrinsicMeasurable) obj6;
                int iIntValue7 = obj10 != null ? ((Number) function2.invoke(obj10, Integer.valueOf(iP))).intValue() : 0;
                int size8 = list.size();
                int i13 = 0;
                while (true) {
                    if (i13 >= size8) {
                        obj7 = null;
                        break;
                    }
                    obj7 = list.get(i13);
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj7), "Supporting")) {
                        break;
                    }
                    i13++;
                }
                Object obj11 = (IntrinsicMeasurable) obj7;
                return TextFieldKt.i(iIntValue6, iIntValue4, iIntValue, iIntValue2, iIntValue3, i5, iIntValue7, obj11 != null ? ((Number) function2.invoke(obj11, Integer.valueOf(i4))).intValue() : 0, this.f21022b, TextFieldImplKt.s(), intrinsicMeasureScope.getDensity(), this.f21023c);
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    private final int e(List list, int i3, Function2 function2) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj4), "Prefix")) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj5), "Suffix")) {
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
                    if (Intrinsics.areEqual(TextFieldImplKt.l((IntrinsicMeasurable) obj6), "Leading")) {
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
                return TextFieldKt.j(iIntValue6, iIntValue3, iIntValue4, iIntValue5, iIntValue, iIntValue2, intrinsicMeasurable6 != null ? ((Number) function2.invoke(intrinsicMeasurable6, Integer.valueOf(i3))).intValue() : 0, TextFieldImplKt.s());
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return d(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicHeight.1
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
        return e(list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.maxIntrinsicWidth.1
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
        long j4;
        Placeable placeableN0;
        Object obj3;
        Object obj4;
        int i3;
        final Placeable placeable;
        Placeable placeable2;
        long j5;
        Placeable placeableN02;
        Placeable placeable3;
        Object obj5;
        Placeable placeable4;
        Object obj6;
        Placeable placeable5;
        Object obj7;
        final TextFieldMeasurePolicy textFieldMeasurePolicy = this;
        final MeasureScope measureScope2 = measureScope;
        List list2 = list;
        final int iZ0 = measureScope2.z0(textFieldMeasurePolicy.f21023c.d());
        int iZ02 = measureScope2.z0(textFieldMeasurePolicy.f21023c.a());
        long jD = Constraints.d(j3, 0, 0, 0, 0, 10, null);
        int size = list2.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                obj = null;
                break;
            }
            obj = list2.get(i4);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj), "Leading")) {
                break;
            }
            i4++;
        }
        Measurable measurable = (Measurable) obj;
        Placeable placeableN03 = measurable != null ? measurable.n0(jD) : null;
        int iV = TextFieldImplKt.v(placeableN03);
        int iMax = Math.max(0, TextFieldImplKt.t(placeableN03));
        int size2 = list2.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size2) {
                obj2 = null;
                break;
            }
            obj2 = list2.get(i5);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj2), "Trailing")) {
                break;
            }
            i5++;
        }
        Measurable measurable2 = (Measurable) obj2;
        if (measurable2 != null) {
            j4 = jD;
            placeableN0 = measurable2.n0(ConstraintsKt.j(j4, -iV, 0, 2, null));
        } else {
            j4 = jD;
            placeableN0 = null;
        }
        int iV2 = iV + TextFieldImplKt.v(placeableN0);
        int iMax2 = Math.max(iMax, TextFieldImplKt.t(placeableN0));
        int size3 = list2.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size3) {
                obj3 = null;
                break;
            }
            obj3 = list2.get(i6);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj3), "Prefix")) {
                break;
            }
            i6++;
        }
        Measurable measurable3 = (Measurable) obj3;
        final Placeable placeableN04 = measurable3 != null ? measurable3.n0(ConstraintsKt.j(j4, -iV2, 0, 2, null)) : null;
        int iV3 = iV2 + TextFieldImplKt.v(placeableN04);
        int iMax3 = Math.max(iMax2, TextFieldImplKt.t(placeableN04));
        int size4 = list2.size();
        int i7 = 0;
        while (true) {
            if (i7 >= size4) {
                obj4 = null;
                break;
            }
            obj4 = list2.get(i7);
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj4), "Suffix")) {
                break;
            }
            i7++;
        }
        Measurable measurable4 = (Measurable) obj4;
        if (measurable4 != null) {
            placeable = placeableN0;
            i3 = iV3;
            placeable2 = placeableN03;
            j5 = j4;
            placeableN02 = measurable4.n0(ConstraintsKt.j(j4, -iV3, 0, 2, null));
        } else {
            i3 = iV3;
            placeable = placeableN0;
            placeable2 = placeableN03;
            j5 = j4;
            placeableN02 = null;
        }
        int iV4 = TextFieldImplKt.v(placeableN02) + i3;
        int iMax4 = Math.max(iMax3, TextFieldImplKt.t(placeableN02));
        int i8 = -iV4;
        long jI = ConstraintsKt.i(j5, i8, -iZ02);
        int size5 = list2.size();
        int i9 = 0;
        while (true) {
            if (i9 >= size5) {
                placeable3 = placeableN02;
                obj5 = null;
                break;
            }
            obj5 = list2.get(i9);
            int i10 = i9;
            placeable3 = placeableN02;
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj5), "Label")) {
                break;
            }
            i9 = i10 + 1;
            placeableN02 = placeable3;
        }
        Measurable measurable5 = (Measurable) obj5;
        Placeable placeableN05 = measurable5 != null ? measurable5.n0(jI) : null;
        int size6 = list2.size();
        int i11 = 0;
        while (true) {
            if (i11 >= size6) {
                placeable4 = placeableN05;
                obj6 = null;
                break;
            }
            obj6 = list2.get(i11);
            placeable4 = placeableN05;
            if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj6), "Supporting")) {
                break;
            }
            i11++;
            placeableN05 = placeable4;
        }
        Measurable measurable6 = (Measurable) obj6;
        int iD0 = measurable6 != null ? measurable6.d0(Constraints.n(j3)) : 0;
        int iT = TextFieldImplKt.t(placeable4) + iZ0;
        long j6 = j5;
        long jI2 = ConstraintsKt.i(Constraints.d(j3, 0, 0, 0, 0, 11, null), i8, ((-iT) - iZ02) - iD0);
        int size7 = list2.size();
        int i12 = 0;
        while (i12 < size7) {
            Measurable measurable7 = (Measurable) list2.get(i12);
            int i13 = size7;
            int i14 = iT;
            if (Intrinsics.areEqual(LayoutIdKt.a(measurable7), "TextField")) {
                Placeable placeableN06 = measurable7.n0(jI2);
                long jD2 = Constraints.d(jI2, 0, 0, 0, 0, 14, null);
                int size8 = list2.size();
                int i15 = 0;
                while (true) {
                    if (i15 >= size8) {
                        placeable5 = placeableN06;
                        obj7 = null;
                        break;
                    }
                    obj7 = list2.get(i15);
                    placeable5 = placeableN06;
                    int i16 = size8;
                    if (Intrinsics.areEqual(LayoutIdKt.a((Measurable) obj7), "Hint")) {
                        break;
                    }
                    i15++;
                    size8 = i16;
                    placeableN06 = placeable5;
                }
                Measurable measurable8 = (Measurable) obj7;
                final Placeable placeableN07 = measurable8 != null ? measurable8.n0(jD2) : null;
                int iMax5 = Math.max(iMax4, Math.max(TextFieldImplKt.t(placeable5), TextFieldImplKt.t(placeableN07)) + i14 + iZ02);
                int iJ = TextFieldKt.j(TextFieldImplKt.v(placeable2), TextFieldImplKt.v(placeable), TextFieldImplKt.v(placeableN04), TextFieldImplKt.v(placeable3), placeable5.X0(), TextFieldImplKt.v(placeable4), TextFieldImplKt.v(placeableN07), j3);
                int i17 = iJ;
                final Placeable placeableN08 = measurable6 != null ? measurable6.n0(Constraints.d(ConstraintsKt.j(j6, 0, -iMax5, 1, null), 0, iJ, 0, 0, 9, null)) : null;
                int iT2 = TextFieldImplKt.t(placeableN08);
                int i18 = TextFieldKt.i(placeable5.O0(), TextFieldImplKt.t(placeable4), TextFieldImplKt.t(placeable2), TextFieldImplKt.t(placeable), TextFieldImplKt.t(placeableN04), TextFieldImplKt.t(placeable3), TextFieldImplKt.t(placeableN07), TextFieldImplKt.t(placeableN08), textFieldMeasurePolicy.f21022b, j3, measureScope2.getDensity(), textFieldMeasurePolicy.f21023c);
                int i19 = i18 - iT2;
                int size9 = list2.size();
                int i20 = 0;
                while (i20 < size9) {
                    Measurable measurable9 = (Measurable) list2.get(i20);
                    final int i21 = i18;
                    if (Intrinsics.areEqual(LayoutIdKt.a(measurable9), "Container")) {
                        final Placeable placeableN09 = measurable9.n0(ConstraintsKt.a(i17 != Integer.MAX_VALUE ? i17 : 0, i17, i19 != Integer.MAX_VALUE ? i19 : 0, i19));
                        final int i22 = i17;
                        final Placeable placeable6 = placeable2;
                        final Placeable placeable7 = placeable3;
                        final Placeable placeable8 = placeable4;
                        final Placeable placeable9 = placeable5;
                        return MeasureScope.B0(measureScope, i22, i21, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy$measure$1
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
                                Placeable placeable10 = placeable8;
                                if (placeable10 == null) {
                                    TextFieldKt.n(placementScope, i22, i21, placeable9, placeableN07, placeable6, placeable, placeableN04, placeable7, placeableN09, placeableN08, textFieldMeasurePolicy.f21021a, measureScope2.getDensity(), textFieldMeasurePolicy.f21023c);
                                    return;
                                }
                                int i23 = i22;
                                int i24 = i21;
                                Placeable placeable11 = placeable9;
                                Placeable placeable12 = placeableN07;
                                Placeable placeable13 = placeable6;
                                Placeable placeable14 = placeable;
                                Placeable placeable15 = placeableN04;
                                Placeable placeable16 = placeable7;
                                Placeable placeable17 = placeableN09;
                                Placeable placeable18 = placeableN08;
                                boolean z2 = textFieldMeasurePolicy.f21021a;
                                int i25 = iZ0;
                                TextFieldKt.m(placementScope, i23, i24, placeable11, placeable10, placeable12, placeable13, placeable14, placeable15, placeable16, placeable17, placeable18, z2, i25, i25 + placeable8.O0(), textFieldMeasurePolicy.f21022b, measureScope2.getDensity());
                            }
                        }, 4, null);
                    }
                    i20++;
                    i17 = i17;
                    i18 = i21;
                    textFieldMeasurePolicy = this;
                    measureScope2 = measureScope;
                    list2 = list;
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
            i12++;
            textFieldMeasurePolicy = this;
            measureScope2 = measureScope;
            iT = i14;
            jI2 = jI2;
            size7 = i13;
            list2 = list;
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i3) {
        return d(intrinsicMeasureScope, list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicHeight.1
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
        return e(list, i3, new Function2<IntrinsicMeasurable, Integer, Integer>() { // from class: androidx.compose.material3.TextFieldMeasurePolicy.minIntrinsicWidth.1
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
