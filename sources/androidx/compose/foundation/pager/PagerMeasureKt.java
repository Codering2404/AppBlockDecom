package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

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
public final class PagerMeasureKt {
    private static final MeasuredPage b(int i3, List list, int i4, int i5, int i6, SnapPosition snapPosition, int i7) {
        Object obj;
        if (list.isEmpty()) {
            obj = null;
        } else {
            Object obj2 = list.get(0);
            MeasuredPage measuredPage = (MeasuredPage) obj2;
            float f3 = -Math.abs(SnapPositionKt.a(i3, i4, i5, i6, measuredPage.getOffset(), measuredPage.getIndex(), snapPosition, i7));
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i8 = 1;
                while (true) {
                    Object obj3 = list.get(i8);
                    MeasuredPage measuredPage2 = (MeasuredPage) obj3;
                    float f4 = -Math.abs(SnapPositionKt.a(i3, i4, i5, i6, measuredPage2.getOffset(), measuredPage2.getIndex(), snapPosition, i7));
                    if (Float.compare(f3, f4) < 0) {
                        f3 = f4;
                        obj2 = obj3;
                    }
                    if (i8 == lastIndex) {
                        break;
                    }
                    i8++;
                }
            }
            obj = obj2;
        }
        return (MeasuredPage) obj;
    }

    private static final List c(LazyLayoutMeasureScope lazyLayoutMeasureScope, List list, List list2, List list3, int i3, int i4, int i5, int i6, int i7, Orientation orientation, boolean z2, Density density, int i8, int i9) {
        ArrayList arrayList;
        int i10 = i7;
        int i11 = i9 + i8;
        int i12 = orientation == Orientation.f6031a ? i4 : i3;
        int i13 = 0;
        boolean z3 = i5 < Math.min(i12, i6);
        if (z3) {
            if (!(i10 == 0)) {
                InlineClassHelperKt.c("non-zero pagesScrollOffset=" + i10);
            }
        }
        ArrayList arrayList2 = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.a("No extra pages");
            }
            int size = list.size();
            int[] iArr = new int[size];
            while (i13 < size) {
                iArr[i13] = i9;
                i13++;
            }
            int[] iArr2 = new int[size];
            Arrangement.HorizontalOrVertical horizontalOrVerticalE = Arrangement.Absolute.f6583a.e(lazyLayoutMeasureScope.F(i8));
            if (orientation == Orientation.f6031a) {
                horizontalOrVerticalE.b(density, i12, iArr, iArr2);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                horizontalOrVerticalE.c(density, i12, iArr, LayoutDirection.f30001a, iArr2);
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.y(indices);
            }
            int iG = indices.g();
            int iH = indices.h();
            int iL = indices.l();
            if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
                while (true) {
                    int iF = iArr2[iG];
                    MeasuredPage measuredPage = (MeasuredPage) list.get(d(iG, z2, size));
                    if (z2) {
                        iF = (i12 - iF) - measuredPage.f();
                    }
                    measuredPage.h(iF, i3, i4);
                    arrayList.add(measuredPage);
                    if (iG == iH) {
                        break;
                    }
                    iG += iL;
                }
            }
        } else {
            arrayList = arrayList2;
            int size2 = list2.size();
            int i14 = i10;
            for (int i15 = 0; i15 < size2; i15++) {
                MeasuredPage measuredPage2 = (MeasuredPage) list2.get(i15);
                i14 -= i11;
                measuredPage2.h(i14, i3, i4);
                arrayList.add(measuredPage2);
            }
            int size3 = list.size();
            for (int i16 = 0; i16 < size3; i16++) {
                MeasuredPage measuredPage3 = (MeasuredPage) list.get(i16);
                measuredPage3.h(i10, i3, i4);
                arrayList.add(measuredPage3);
                i10 += i11;
            }
            int size4 = list3.size();
            while (i13 < size4) {
                MeasuredPage measuredPage4 = (MeasuredPage) list3.get(i13);
                measuredPage4.h(i10, i3, i4);
                arrayList.add(measuredPage4);
                i10 += i11;
                i13++;
            }
        }
        return arrayList;
    }

    private static final int d(int i3, boolean z2, int i4) {
        return !z2 ? i3 : (i4 - i3) - 1;
    }

    private static final List e(int i3, int i4, int i5, List list, Function1 function1) {
        int iMin = Math.min(i5 + i3, i4 - 1);
        int i6 = i3 + 1;
        ArrayList arrayList = null;
        if (i6 <= iMin) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i6)));
                if (i6 == iMin) {
                    break;
                }
                i6++;
            }
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            int iIntValue = ((Number) list.get(i7)).intValue();
            if (iMin + 1 <= iIntValue && iIntValue < i4) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List f(int i3, int i4, List list, Function1 function1) {
        int iMax = Math.max(0, i3 - i4);
        int i5 = i3 - 1;
        ArrayList arrayList = null;
        if (iMax <= i5) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i5)));
                if (i5 == iMax) {
                    break;
                }
                i5--;
            }
        }
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            int iIntValue = ((Number) list.get(i6)).intValue();
            if (iIntValue < iMax) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(iIntValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasuredPage g(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i3, long j3, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j4, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z2, int i4) {
        return new MeasuredPage(i3, i4, lazyLayoutMeasureScope.m0(i3, j3), j4, pagerLazyLayoutItemProvider.d(i3), orientation, horizontal, vertical, layoutDirection, z2, null);
    }

    public static final PagerMeasureResult h(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i3, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i4, int i5, int i6, int i7, int i8, int i9, long j3, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z2, final long j4, final int i10, int i11, List list, SnapPosition snapPosition, final MutableState mutableState, CoroutineScope coroutineScope, Function3 function3) {
        int i12;
        boolean z3;
        int iMax;
        int i13;
        int i14;
        int i15;
        List arrayList;
        List arrayList2;
        List arrayList3;
        int i16;
        if (!(i5 >= 0)) {
            InlineClassHelperKt.a("negative beforeContentPadding");
        }
        if (!(i6 >= 0)) {
            InlineClassHelperKt.a("negative afterContentPadding");
        }
        int iF = RangesKt.f(i10 + i7, 0);
        if (i3 <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i10, i7, i6, orientation, -i5, i4 + i6, false, i11, null, null, 0.0f, 0, false, snapPosition, (MeasureResult) function3.invoke(Integer.valueOf(Constraints.n(j3)), Integer.valueOf(Constraints.m(j3)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                public final void invoke(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Placeable.PlacementScope) obj);
                    return Unit.f139807a;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        Orientation orientation2 = orientation;
        Orientation orientation3 = Orientation.f6031a;
        final long jB = ConstraintsKt.b(0, orientation2 == orientation3 ? Constraints.l(j3) : i10, 0, orientation2 != orientation3 ? Constraints.k(j3) : i10, 5, null);
        int i17 = i8;
        int i18 = i9;
        while (i17 > 0 && i18 > 0) {
            i17--;
            i18 -= iF;
        }
        int i19 = i18 * (-1);
        if (i17 >= i3) {
            i17 = i3 - 1;
            i19 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i20 = -i5;
        int i21 = (i7 < 0 ? i7 : 0) + i20;
        int i22 = i19 + i21;
        int iMax2 = 0;
        while (i22 < 0 && i17 > 0) {
            int i23 = i17 - 1;
            MeasuredPage measuredPageG = g(lazyLayoutMeasureScope, i23, jB, pagerLazyLayoutItemProvider, j4, orientation2, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z2, i10);
            arrayDeque.add(0, measuredPageG);
            iMax2 = Math.max(iMax2, measuredPageG.b());
            i22 += iF;
            i21 = i21;
            i17 = i23;
            orientation2 = orientation;
        }
        int i24 = i21;
        int i25 = iMax2;
        if (i22 < i24) {
            i22 = i24;
        }
        int i26 = i22 - i24;
        int i27 = i4 + i6;
        int i28 = i17;
        int iF2 = RangesKt.f(i27, 0);
        int i29 = -i26;
        int i30 = i28;
        int i31 = 0;
        boolean z4 = false;
        while (i31 < arrayDeque.size()) {
            if (i29 >= iF2) {
                arrayDeque.remove(i31);
                z4 = true;
            } else {
                i30++;
                i29 += iF;
                i31++;
            }
        }
        int iMax3 = i25;
        int i32 = i30;
        boolean z5 = z4;
        int i33 = i26;
        while (i32 < i3 && (i29 < iF2 || i29 <= 0 || arrayDeque.isEmpty())) {
            int i34 = iF2;
            int i35 = i32;
            MeasuredPage measuredPageG2 = g(lazyLayoutMeasureScope, i35, jB, pagerLazyLayoutItemProvider, j4, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z2, i10);
            int i36 = i33;
            int i37 = i3 - 1;
            i29 += i35 == i37 ? i10 : iF;
            if (i29 > i24 || i35 == i37) {
                iMax3 = Math.max(iMax3, measuredPageG2.b());
                arrayDeque.add(measuredPageG2);
                i16 = i28;
                i33 = i36;
            } else {
                i16 = i35 + 1;
                i33 = i36 - iF;
                z5 = true;
            }
            i32 = i35 + 1;
            i28 = i16;
            iF2 = i34;
        }
        int i38 = i33;
        if (i29 < i4) {
            int i39 = i4 - i29;
            i13 = i38 - i39;
            i29 += i39;
            iMax = iMax3;
            i14 = i28;
            while (i13 < i5 && i14 > 0) {
                int i40 = i14 - 1;
                MeasuredPage measuredPageG3 = g(lazyLayoutMeasureScope, i40, jB, pagerLazyLayoutItemProvider, j4, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z2, i10);
                arrayDeque.add(0, measuredPageG3);
                iMax = Math.max(iMax, measuredPageG3.b());
                i13 += iF;
                i32 = i32;
                i14 = i40;
            }
            i12 = i32;
            z3 = false;
            if (i13 < 0) {
                i29 += i13;
                i13 = 0;
            }
        } else {
            i12 = i32;
            z3 = false;
            iMax = iMax3;
            i13 = i38;
            i14 = i28;
        }
        if (!(i13 >= 0 ? true : z3)) {
            InlineClassHelperKt.a("invalid currentFirstPageScrollOffset");
        }
        int i41 = iMax;
        int i42 = -i13;
        MeasuredPage measuredPage = (MeasuredPage) arrayDeque.first();
        if (i5 > 0 || i7 < 0) {
            int size = arrayDeque.size();
            i15 = i42;
            int i43 = 0;
            while (i43 < size && i13 != 0 && iF <= i13 && i43 != CollectionsKt.getLastIndex(arrayDeque)) {
                i13 -= iF;
                i43++;
                measuredPage = (MeasuredPage) arrayDeque.get(i43);
            }
        } else {
            i15 = i42;
        }
        int i44 = i13;
        MeasuredPage measuredPage2 = measuredPage;
        List listF = f(i14, i11, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final MeasuredPage c(int i45) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.g(lazyLayoutMeasureScope2, i45, jB, pagerLazyLayoutItemProvider, j4, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z2, i10);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).intValue());
            }
        });
        int size2 = listF.size();
        int iMax4 = i41;
        int i45 = 0;
        while (i45 < size2) {
            iMax4 = Math.max(iMax4, ((MeasuredPage) listF.get(i45)).b());
            i45++;
            listF = listF;
        }
        List list2 = listF;
        List listE = e(((MeasuredPage) arrayDeque.last()).getIndex(), i3, i11, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final MeasuredPage c(int i46) {
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
                return PagerMeasureKt.g(lazyLayoutMeasureScope2, i46, jB, pagerLazyLayoutItemProvider, j4, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z2, i10);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).intValue());
            }
        });
        int size3 = listE.size();
        for (int i46 = 0; i46 < size3; i46++) {
            iMax4 = Math.max(iMax4, ((MeasuredPage) listE.get(i46)).b());
        }
        boolean z6 = Intrinsics.areEqual(measuredPage2, arrayDeque.first()) && list2.isEmpty() && listE.isEmpty();
        Orientation orientation4 = Orientation.f6031a;
        int iG = ConstraintsKt.g(j3, orientation == orientation4 ? iMax4 : i29);
        if (orientation == orientation4) {
            iMax4 = i29;
        }
        int iF3 = ConstraintsKt.f(j3, iMax4);
        int i47 = i12;
        int i48 = i29;
        final List listC = c(lazyLayoutMeasureScope, arrayDeque, list2, listE, iG, iF3, i48, i4, i15, orientation, z2, lazyLayoutMeasureScope, i7, i10);
        if (z6) {
            arrayList = listC;
        } else {
            arrayList = new ArrayList(listC.size());
            int size4 = listC.size();
            int i49 = 0;
            while (i49 < size4) {
                Object obj = listC.get(i49);
                MeasuredPage measuredPage3 = (MeasuredPage) obj;
                MeasuredPage measuredPage4 = measuredPage2;
                int i50 = i47;
                if (measuredPage3.getIndex() >= ((MeasuredPage) arrayDeque.first()).getIndex() && measuredPage3.getIndex() <= ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList.add(obj);
                }
                i49++;
                i47 = i50;
                measuredPage2 = measuredPage4;
            }
        }
        MeasuredPage measuredPage5 = measuredPage2;
        int i51 = i47;
        if (list2.isEmpty()) {
            arrayList2 = CollectionsKt.emptyList();
        } else {
            arrayList2 = new ArrayList(listC.size());
            int size5 = listC.size();
            for (int i52 = 0; i52 < size5; i52++) {
                Object obj2 = listC.get(i52);
                if (((MeasuredPage) obj2).getIndex() < ((MeasuredPage) arrayDeque.first()).getIndex()) {
                    arrayList2.add(obj2);
                }
            }
        }
        List list3 = arrayList2;
        if (listE.isEmpty()) {
            arrayList3 = CollectionsKt.emptyList();
        } else {
            arrayList3 = new ArrayList(listC.size());
            int size6 = listC.size();
            for (int i53 = 0; i53 < size6; i53++) {
                Object obj3 = listC.get(i53);
                if (((MeasuredPage) obj3).getIndex() > ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList3.add(obj3);
                }
            }
        }
        List list4 = arrayList3;
        MeasuredPage measuredPageB = b(i4 + i5 + i6, arrayList, i5, i6, iF, snapPosition, i3);
        return new PagerMeasureResult(arrayList, i10, i7, i6, orientation, i20, i27, z2, i11, measuredPage5, measuredPageB, iF == 0 ? 0.0f : RangesKt.o((snapPosition.a(r0, i10, i5, i6, measuredPageB != null ? measuredPageB.getIndex() : 0, i3) - (measuredPageB != null ? measuredPageB.getOffset() : 0)) / iF, -0.5f, 0.5f), i44, i51 < i3 || i48 > i4, snapPosition, (MeasureResult) function3.invoke(Integer.valueOf(iG), Integer.valueOf(iF3), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                invoke((Placeable.PlacementScope) obj4);
                return Unit.f139807a;
            }

            public final void invoke(Placeable.PlacementScope placementScope) {
                final List list5 = listC;
                placementScope.B(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                        invoke((Placeable.PlacementScope) obj4);
                        return Unit.f139807a;
                    }

                    public final void invoke(Placeable.PlacementScope placementScope2) {
                        List list6 = list5;
                        int size7 = list6.size();
                        for (int i54 = 0; i54 < size7; i54++) {
                            ((MeasuredPage) list6.get(i54)).g(placementScope2);
                        }
                    }
                });
                ObservableScopeInvalidator.a(mutableState);
            }
        }), z5, list3, list4, coroutineScope);
    }
}
