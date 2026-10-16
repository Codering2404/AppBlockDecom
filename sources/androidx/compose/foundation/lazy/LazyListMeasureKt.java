package androidx.compose.foundation.lazy;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

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
public final class LazyListMeasureKt {
    private static final List a(List list, List list2, List list3, int i3, int i4, int i5, int i6, int i7, boolean z2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z3, Density density) {
        int i8 = z2 ? i4 : i3;
        int i9 = 0;
        boolean z4 = i5 < Math.min(i8, i6);
        if (z4) {
            if (!(i7 == 0)) {
                InlineClassHelperKt.c("non-zero itemsScrollOffset");
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z4) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.a("no extra items");
            }
            int size = list.size();
            int[] iArr = new int[size];
            while (i9 < size) {
                iArr[i9] = ((LazyListMeasuredItem) list.get(b(i9, z3, size))).getSize();
                i9++;
            }
            int[] iArr2 = new int[size];
            if (z2) {
                if (vertical == null) {
                    InlineClassHelperKt.b("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
                vertical.b(density, i8, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    InlineClassHelperKt.b("null horizontalArrangement when isVertical == false");
                    throw new KotlinNothingValueException();
                }
                horizontal.c(density, i8, iArr, LayoutDirection.f30001a, iArr2);
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z3) {
                indices = RangesKt.y(indices);
            }
            int iG = indices.g();
            int iH = indices.h();
            int iL = indices.l();
            if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
                while (true) {
                    int size2 = iArr2[iG];
                    LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) list.get(b(iG, z3, size));
                    if (z3) {
                        size2 = (i8 - size2) - lazyListMeasuredItem.getSize();
                    }
                    lazyListMeasuredItem.q(size2, i3, i4);
                    arrayList.add(lazyListMeasuredItem);
                    if (iG == iH) {
                        break;
                    }
                    iG += iL;
                }
            }
        } else {
            int size3 = list2.size();
            int iM = i7;
            for (int i10 = 0; i10 < size3; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) list2.get(i10);
                iM -= lazyListMeasuredItem2.m();
                lazyListMeasuredItem2.q(iM, i3, i4);
                arrayList.add(lazyListMeasuredItem2);
            }
            int size4 = list.size();
            int iM2 = i7;
            for (int i11 = 0; i11 < size4; i11++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) list.get(i11);
                lazyListMeasuredItem3.q(iM2, i3, i4);
                arrayList.add(lazyListMeasuredItem3);
                iM2 += lazyListMeasuredItem3.m();
            }
            int size5 = list3.size();
            while (i9 < size5) {
                LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) list3.get(i9);
                lazyListMeasuredItem4.q(iM2, i3, i4);
                arrayList.add(lazyListMeasuredItem4);
                iM2 += lazyListMeasuredItem4.m();
                i9++;
            }
        }
        return arrayList;
    }

    private static final int b(int i3, boolean z2, int i4) {
        return !z2 ? i3 : (i4 - i3) - 1;
    }

    private static final List c(List list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i3, int i4, List list2, float f3, boolean z2, LazyListLayoutInfo lazyListLayoutInfo) {
        ArrayList arrayList;
        LazyListItemInfo lazyListItemInfo;
        LazyListMeasuredItem lazyListMeasuredItem;
        Object obj;
        int iM;
        Object obj2;
        int index;
        int iMin;
        LazyListMeasuredItem lazyListMeasuredItem2;
        Object obj3;
        int i5 = i3 - 1;
        int iMin2 = Math.min(((LazyListMeasuredItem) CollectionsKt.last(list)).getIndex() + i4, i5);
        int index2 = ((LazyListMeasuredItem) CollectionsKt.last(list)).getIndex() + 1;
        if (index2 <= iMin2) {
            int i6 = index2;
            arrayList = null;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.e(lazyListMeasuredItemProvider, i6, 0L, 2, null));
                if (i6 == iMin2) {
                    break;
                }
                i6++;
            }
        } else {
            arrayList = null;
        }
        if (z2 && lazyListLayoutInfo != null && !lazyListLayoutInfo.h().isEmpty()) {
            List listH = lazyListLayoutInfo.h();
            int size = listH.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyListItemInfo = null;
                    break;
                }
                if (((LazyListItemInfo) listH.get(size)).getIndex() > iMin2 && (size == 0 || ((LazyListItemInfo) listH.get(size - 1)).getIndex() <= iMin2)) {
                    break;
                }
            }
            lazyListItemInfo = (LazyListItemInfo) listH.get(size);
            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) CollectionsKt.last(lazyListLayoutInfo.h());
            if (lazyListItemInfo != null && (index = lazyListItemInfo.getIndex()) <= (iMin = Math.min(lazyListItemInfo2.getIndex(), i5))) {
                int i7 = index;
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                obj3 = null;
                                break;
                            }
                            obj3 = arrayList.get(i8);
                            if (((LazyListMeasuredItem) obj3).getIndex() == i7) {
                                break;
                            }
                            i8++;
                        }
                        lazyListMeasuredItem2 = (LazyListMeasuredItem) obj3;
                    } else {
                        lazyListMeasuredItem2 = null;
                    }
                    if (lazyListMeasuredItem2 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.e(lazyListMeasuredItemProvider, i7, 0L, 2, null));
                    }
                    if (i7 == iMin) {
                        break;
                    }
                    i7++;
                }
            }
            float fD = ((lazyListLayoutInfo.d() - lazyListItemInfo2.getOffset()) - lazyListItemInfo2.getSize()) - f3;
            if (fD > 0.0f) {
                int index3 = lazyListItemInfo2.getIndex() + 1;
                int i9 = 0;
                while (index3 < i3 && i9 < fD) {
                    if (index3 <= iMin2) {
                        int size3 = list.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size3) {
                                obj2 = null;
                                break;
                            }
                            obj2 = list.get(i10);
                            if (((LazyListMeasuredItem) obj2).getIndex() == index3) {
                                break;
                            }
                            i10++;
                        }
                        lazyListMeasuredItem = (LazyListMeasuredItem) obj2;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= size4) {
                                obj = null;
                                break;
                            }
                            obj = arrayList.get(i11);
                            if (((LazyListMeasuredItem) obj).getIndex() == index3) {
                                break;
                            }
                            i11++;
                        }
                        lazyListMeasuredItem = (LazyListMeasuredItem) obj;
                    } else {
                        lazyListMeasuredItem = null;
                    }
                    if (lazyListMeasuredItem != null) {
                        index3++;
                        iM = lazyListMeasuredItem.m();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.e(lazyListMeasuredItemProvider, index3, 0L, 2, null));
                        index3++;
                        iM = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).m();
                    }
                    i9 += iM;
                }
            }
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex() > iMin2) {
            iMin2 = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i12 = 0; i12 < size5; i12++) {
            int iIntValue = ((Number) list2.get(i12)).intValue();
            if (iIntValue > iMin2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.e(lazyListMeasuredItemProvider, iIntValue, 0L, 2, null));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List d(int i3, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i4, List list) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int iMax = Math.max(0, i3 - i4);
        int i5 = i3 - 1;
        ArrayList arrayList = null;
        if (iMax <= i5) {
            int i6 = i5;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.e(lazyListMeasuredItemProvider2, i6, 0L, 2, null));
                if (i6 == iMax) {
                    break;
                }
                i6--;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i7 = size - 1;
                int iIntValue = ((Number) list.get(size)).intValue();
                if (iIntValue < iMax) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.e(lazyListMeasuredItemProvider2, iIntValue, 0L, 2, null));
                }
                if (i7 < 0) {
                    break;
                }
                size = i7;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:146:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x03c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.foundation.lazy.LazyListMeasureResult e(int r42, final androidx.compose.foundation.lazy.LazyListMeasuredItemProvider r43, int r44, int r45, int r46, int r47, int r48, int r49, float r50, long r51, boolean r53, androidx.compose.foundation.layout.Arrangement.Vertical r54, androidx.compose.foundation.layout.Arrangement.Horizontal r55, boolean r56, androidx.compose.ui.unit.Density r57, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r58, int r59, java.util.List r60, boolean r61, final boolean r62, androidx.compose.foundation.lazy.LazyListLayoutInfo r63, kotlinx.coroutines.CoroutineScope r64, final androidx.compose.runtime.MutableState r65, androidx.compose.ui.graphics.GraphicsContext r66, androidx.compose.foundation.lazy.layout.StickyItemsPlacement r67, kotlin.jvm.functions.Function3 r68) {
        /*
            Method dump skipped, instruction units count: 1119
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListMeasureKt.e(int, androidx.compose.foundation.lazy.LazyListMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, androidx.compose.foundation.lazy.LazyListLayoutInfo, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, androidx.compose.foundation.lazy.layout.StickyItemsPlacement, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.LazyListMeasureResult");
    }
}
