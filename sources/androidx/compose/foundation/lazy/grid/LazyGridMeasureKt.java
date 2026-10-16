package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
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
public final class LazyGridMeasureKt {
    private static final void a(List list, Object[] objArr) {
        for (Object obj : objArr) {
            list.add(obj);
        }
    }

    private static final List b(List list, List list2, List list3, int i3, int i4, int i5, int i6, int i7, boolean z2, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z3, Density density) {
        int i8 = z2 ? i4 : i3;
        boolean z4 = i5 < Math.min(i8, i6);
        if (z4) {
            if (!(i7 == 0)) {
                InlineClassHelperKt.c("non-zero firstLineScrollOffset");
            }
        }
        List list4 = list;
        int size = list4.size();
        int length = 0;
        for (int i9 = 0; i9 < size; i9++) {
            length += ((LazyGridMeasuredLine) list.get(i9)).b().length;
        }
        ArrayList arrayList = new ArrayList(length);
        if (z4) {
            if (!(list2.isEmpty() && list3.isEmpty())) {
                InlineClassHelperKt.a("no items");
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i10 = 0; i10 < size2; i10++) {
                iArr[i10] = ((LazyGridMeasuredLine) list.get(c(i10, z3, size2))).c();
            }
            int[] iArr2 = new int[size2];
            if (z2) {
                if (vertical == null) {
                    InlineClassHelperKt.b("null verticalArrangement");
                    throw new KotlinNothingValueException();
                }
                vertical.b(density, i8, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    InlineClassHelperKt.b("null horizontalArrangement");
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
                    int iC = iArr2[iG];
                    LazyGridMeasuredLine lazyGridMeasuredLine = (LazyGridMeasuredLine) list.get(c(iG, z3, size2));
                    if (z3) {
                        iC = (i8 - iC) - lazyGridMeasuredLine.c();
                    }
                    a(arrayList, lazyGridMeasuredLine.f(iC, i3, i4));
                    if (iG == iH) {
                        break;
                    }
                    iG += iL;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int iM = i7;
                while (true) {
                    int i11 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = (LazyGridMeasuredItem) list2.get(size3);
                    iM -= lazyGridMeasuredItem.m();
                    lazyGridMeasuredItem.l(iM, 0, i3, i4);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i11 < 0) {
                        break;
                    }
                    size3 = i11;
                }
            }
            int size4 = list4.size();
            int iM2 = i7;
            for (int i12 = 0; i12 < size4; i12++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = (LazyGridMeasuredLine) list.get(i12);
                a(arrayList, lazyGridMeasuredLine2.f(iM2, i3, i4));
                iM2 += lazyGridMeasuredLine2.d();
            }
            int size5 = list3.size();
            for (int i13 = 0; i13 < size5; i13++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) list3.get(i13);
                lazyGridMeasuredItem2.l(iM2, 0, i3, i4);
                arrayList.add(lazyGridMeasuredItem2);
                iM2 += lazyGridMeasuredItem2.m();
            }
        }
        return arrayList;
    }

    private static final int c(int i3, boolean z2, int i4) {
        return !z2 ? i3 : (i4 - i3) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad A[LOOP:1: B:25:0x0072->B:39:0x00ad, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00b0 A[EDGE_INSN: B:49:0x00b0->B:40:0x00b0 BREAK  A[LOOP:1: B:25:0x0072->B:39:0x00ad], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List d(int r6, int r7, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r8, boolean r9, java.util.List r10, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r11) {
        /*
            r0 = 0
            if (r9 == 0) goto Lb0
            if (r11 == 0) goto Lb0
            java.util.List r9 = r11.h()
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto Lb0
            java.util.List r9 = r11.h()
            int r1 = r9.size()
            int r1 = r1 + (-1)
        L1b:
            r2 = -1
            if (r2 >= r1) goto L44
            java.lang.Object r2 = r9.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r2 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r2
            int r2 = r2.getIndex()
            if (r2 <= r6) goto L41
            if (r1 == 0) goto L3a
            int r2 = r1 + (-1)
            java.lang.Object r2 = r9.get(r2)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r2 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r2
            int r2 = r2.getIndex()
            if (r2 > r6) goto L41
        L3a:
            java.lang.Object r6 = r9.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r6 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r6
            goto L45
        L41:
            int r1 = r1 + (-1)
            goto L1b
        L44:
            r6 = r0
        L45:
            java.util.List r9 = r11.h()
            java.lang.Object r9 = kotlin.collections.CollectionsKt.last(r9)
            androidx.compose.foundation.lazy.grid.LazyGridItemInfo r9 = (androidx.compose.foundation.lazy.grid.LazyGridItemInfo) r9
            java.lang.Object r10 = kotlin.collections.CollectionsKt.lastOrNull(r10)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r10 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r10
            r11 = 0
            if (r10 == 0) goto L5f
            int r10 = r10.a()
            int r10 = r10 + 1
            goto L60
        L5f:
            r10 = r11
        L60:
            if (r6 == 0) goto Lb0
            int r6 = r6.getIndex()
            int r9 = r9.getIndex()
            int r7 = r7 + (-1)
            int r7 = java.lang.Math.min(r9, r7)
            if (r6 > r7) goto Lb0
        L72:
            if (r0 == 0) goto L9b
            r9 = r0
            java.util.Collection r9 = (java.util.Collection) r9
            int r9 = r9.size()
            r1 = r11
        L7c:
            if (r1 >= r9) goto L9b
            java.lang.Object r2 = r0.get(r1)
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r2 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine) r2
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem[] r2 = r2.b()
            int r3 = r2.length
            r4 = r11
        L8a:
            if (r4 >= r3) goto L98
            r5 = r2[r4]
            int r5 = r5.getIndex()
            if (r5 != r6) goto L95
            goto Lab
        L95:
            int r4 = r4 + 1
            goto L8a
        L98:
            int r1 = r1 + 1
            goto L7c
        L9b:
            if (r0 != 0) goto La2
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        La2:
            androidx.compose.foundation.lazy.grid.LazyGridMeasuredLine r9 = r8.c(r10)
            int r10 = r10 + 1
            r0.add(r9)
        Lab:
            if (r6 == r7) goto Lb0
            int r6 = r6 + 1
            goto L72
        Lb0:
            if (r0 != 0) goto Lb7
            java.util.List r6 = kotlin.collections.CollectionsKt.emptyList()
            return r6
        Lb7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.d(int, int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, boolean, java.util.List, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:185:0x0445  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.compose.foundation.lazy.grid.LazyGridMeasureResult e(int r55, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider r56, final androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider r57, int r58, int r59, int r60, int r61, int r62, int r63, float r64, long r65, boolean r67, androidx.compose.foundation.layout.Arrangement.Vertical r68, androidx.compose.foundation.layout.Arrangement.Horizontal r69, boolean r70, androidx.compose.ui.unit.Density r71, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator r72, int r73, java.util.List r74, boolean r75, final boolean r76, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo r77, kotlinx.coroutines.CoroutineScope r78, final androidx.compose.runtime.MutableState r79, androidx.compose.ui.graphics.GraphicsContext r80, kotlin.jvm.functions.Function1 r81, androidx.compose.foundation.lazy.layout.StickyItemsPlacement r82, kotlin.jvm.functions.Function3 r83) {
        /*
            Method dump skipped, instruction units count: 1204
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt.e(int, androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider, androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider, int, int, int, int, int, int, float, long, boolean, androidx.compose.foundation.layout.Arrangement$Vertical, androidx.compose.foundation.layout.Arrangement$Horizontal, boolean, androidx.compose.ui.unit.Density, androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator, int, java.util.List, boolean, boolean, androidx.compose.foundation.lazy.grid.LazyGridLayoutInfo, kotlinx.coroutines.CoroutineScope, androidx.compose.runtime.MutableState, androidx.compose.ui.graphics.GraphicsContext, kotlin.jvm.functions.Function1, androidx.compose.foundation.lazy.layout.StickyItemsPlacement, kotlin.jvm.functions.Function3):androidx.compose.foundation.lazy.grid.LazyGridMeasureResult");
    }
}
