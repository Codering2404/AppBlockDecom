package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
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
public final class LazyStaggeredGridMeasureKt {
    private static final List a(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque[] arrayDequeArr, int[] iArr, int i3, int i4, int i5) {
        int size = 0;
        for (ArrayDeque arrayDeque : arrayDequeArr) {
            size += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(size);
        while (true) {
            for (ArrayDeque arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i6 = -1;
                    int i7 = Integer.MAX_VALUE;
                    for (int i8 = 0; i8 < length; i8++) {
                        LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i8].firstOrNull();
                        int index = lazyStaggeredGridMeasuredItem != null ? lazyStaggeredGridMeasuredItem.getIndex() : Integer.MAX_VALUE;
                        if (i7 > index) {
                            i6 = i8;
                            i7 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDequeArr[i6].removeFirst();
                    if (lazyStaggeredGridMeasuredItem2.e() == i6) {
                        long jA = SpanRange.a(lazyStaggeredGridMeasuredItem2.e(), lazyStaggeredGridMeasuredItem2.i());
                        int iG = g(iArr, jA);
                        int i9 = lazyStaggeredGridMeasureContext.p().a()[i6];
                        if (lazyStaggeredGridMeasuredItem2.q() + iG >= i4 && iG <= i5) {
                            lazyStaggeredGridMeasuredItem2.t(iG, i9, i3);
                            arrayList.add(lazyStaggeredGridMeasuredItem2);
                        }
                        int i10 = (int) (jA & 4294967295L);
                        for (int i11 = (int) (jA >> 32); i11 < i10; i11++) {
                            iArr[i11] = lazyStaggeredGridMeasuredItem2.m() + iG;
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    private static final void b(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i3) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i4 = length - 1;
            while (true) {
                if (iArr[length] < i3 && lazyStaggeredGridMeasureContext.j().a(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = c(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.t(lazyStaggeredGridMeasureContext.h(), iArr[length])) {
                lazyStaggeredGridMeasureContext.j().l(iArr[length], length);
            }
            if (i4 < 0) {
                return;
            } else {
                length = i4;
            }
        }
    }

    private static final int c(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i3, int i4) {
        return lazyStaggeredGridMeasureContext.j().f(i3, i4);
    }

    private static final int d(int[] iArr) {
        int length = iArr.length;
        int i3 = -1;
        int i4 = Integer.MIN_VALUE;
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = iArr[i5];
            if (i4 < i6) {
                i3 = i5;
                i4 = i6;
            }
        }
        return i3;
    }

    public static final int e(int[] iArr, int i3) {
        int length = iArr.length;
        int i4 = -1;
        int i5 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = i3 + 1;
            int i8 = iArr[i6];
            if (i7 <= i8 && i8 < i5) {
                i4 = i6;
                i5 = i8;
            }
        }
        return i4;
    }

    public static /* synthetic */ int f(int[] iArr, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = Integer.MIN_VALUE;
        }
        return e(iArr, i3);
    }

    private static final int g(int[] iArr, long j3) {
        int i3 = (int) (j3 & 4294967295L);
        int iMax = Integer.MIN_VALUE;
        for (int i4 = (int) (j3 >> 32); i4 < i3; i4++) {
            iMax = Math.max(iMax, iArr[i4]);
        }
        return iMax;
    }

    /* JADX WARN: Code restructure failed: missing block: B:145:0x02f2, code lost:
    
        r4 = f(r7, 0, 1, null);
        r6 = d(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02fd, code lost:
    
        if (r4 == r6) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0303, code lost:
    
        if (r7[r4] != r7[r6]) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0305, code lost:
    
        r4 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0307, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0308, code lost:
    
        r6 = r28[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x030b, code lost:
    
        if (r6 != (-1)) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x030d, code lost:
    
        r6 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x030e, code lost:
    
        r6 = c(r0, r6, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0312, code lost:
    
        if (r6 >= 0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0314, code lost:
    
        r8 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0316, code lost:
    
        if (r1 != false) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x031c, code lost:
    
        if (j(r8, r0, r7, r4) == false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x031e, code lost:
    
        if (r49 == false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0320, code lost:
    
        r0.j().j();
        r1 = r8.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x032b, code lost:
    
        if (r3 >= r1) goto L565;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x032d, code lost:
    
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0334, code lost:
    
        r1 = r7.length;
        r3 = new int[r1];
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0338, code lost:
    
        if (r5 >= r1) goto L566;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x033a, code lost:
    
        r3[r5] = r7[r4];
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x0348, code lost:
    
        return h(r0, r29, r2, r3, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0351, code lost:
    
        r8 = r28;
        r11 = r29;
        r25 = r14;
        r13 = r0.r(r0.h(), r6, r4);
        r4 = r0.j();
        r15 = r1;
        r46 = r2;
        r1 = (int) (r13 & 4294967295L);
        r27 = r3;
        r2 = (int) (r13 >> 32);
        r3 = r1 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0373, code lost:
    
        if (r3 == 1) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x0375, code lost:
    
        r2 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x0377, code lost:
    
        r2 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0379, code lost:
    
        r4.l(r6, r2);
        r2 = r0.n().e(r6, r13);
        r4 = g(r7, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x0389, code lost:
    
        if (r3 == 1) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x038b, code lost:
    
        r3 = r0.j().g(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0394, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0395, code lost:
    
        r14 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0397, code lost:
    
        if (r14 >= r1) goto L562;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x039b, code lost:
    
        if (r7[r14] == r4) goto L183;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x039d, code lost:
    
        r15 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x039e, code lost:
    
        r48[r14].addFirst(r2);
        r8[r14] = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x03a5, code lost:
    
        if (r3 != null) goto L186;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x03a7, code lost:
    
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x03a9, code lost:
    
        r13 = r3[r14];
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03ab, code lost:
    
        r7[r14] = (r4 + r2.m()) + r13;
        r14 = r14 + 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:329:0x06a8  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x071b  */
    /* JADX WARN: Removed duplicated region for block: B:353:0x0723 A[LOOP:21: B:312:0x066e->B:353:0x0723, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:354:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:379:0x078a  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x07b2  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07de  */
    /* JADX WARN: Removed duplicated region for block: B:449:0x08f1  */
    /* JADX WARN: Removed duplicated region for block: B:540:0x0735 A[EDGE_INSN: B:540:0x0735->B:355:0x0735 BREAK  A[LOOP:21: B:312:0x066e->B:353:0x0723], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult h(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext r45, int r46, int[] r47, int[] r48, boolean r49) {
        /*
            Method dump skipped, instruction units count: 2773
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt.h(androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext, int, int[], int[], boolean):androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureResult");
    }

    private static final boolean i(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (iArr2[i3] < Math.max(-lazyStaggeredGridMeasureContext.l(), 0) && i4 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean j(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i3) {
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (c(lazyStaggeredGridMeasureContext, iArr[i4], i4) == -1 && iArr2[i4] != iArr2[i3]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i5 = 0; i5 < length2; i5++) {
            if (c(lazyStaggeredGridMeasureContext, iArr[i5], i5) != -1 && iArr2[i5] >= iArr2[i3]) {
                return true;
            }
        }
        int iH = lazyStaggeredGridMeasureContext.j().h(0);
        return (iH == 0 || iH == -1 || iH == -2) ? false : true;
    }

    public static final LazyStaggeredGridMeasureResult k(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j3, boolean z2, boolean z3, long j4, int i3, int i4, int i5, int i6, CoroutineScope coroutineScope, boolean z4, boolean z5, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        int iG;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j3, z2, lazyLayoutMeasureScope, i3, j4, i5, i6, z3, i4, coroutineScope, z4, z5, lazyStaggeredGridLayoutInfo, graphicsContext, null);
        int[] iArrR = lazyStaggeredGridState.R(lazyStaggeredGridItemProvider, lazyStaggeredGridState.H().d());
        int[] iArrG = lazyStaggeredGridState.H().g();
        if (iArrR.length != lazyStaggeredGridMeasureContext.i()) {
            lazyStaggeredGridMeasureContext.j().j();
            int i7 = lazyStaggeredGridMeasureContext.i();
            int[] iArr = new int[i7];
            int i8 = 0;
            while (i8 < i7) {
                if (i8 >= iArrR.length || (iG = iArrR[i8]) == -1) {
                    iG = i8 == 0 ? 0 : g(iArr, SpanRange.a(0, i8)) + 1;
                }
                iArr[i8] = iG;
                lazyStaggeredGridMeasureContext.j().l(iArr[i8], i8);
                i8++;
            }
            iArrR = iArr;
        }
        if (iArrG.length != lazyStaggeredGridMeasureContext.i()) {
            int i9 = lazyStaggeredGridMeasureContext.i();
            int[] iArr2 = new int[i9];
            int i10 = 0;
            while (i10 < i9) {
                iArr2[i10] = i10 < iArrG.length ? iArrG[i10] : i10 == 0 ? 0 : iArr2[i10 - 1];
                i10++;
            }
            iArrG = iArr2;
        }
        return h(lazyStaggeredGridMeasureContext, Math.round(lazyStaggeredGridState.L(z5)), iArrR, iArrG, true);
    }

    private static final void l(int[] iArr, int i3) {
        int length = iArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = iArr[i4] + i3;
        }
    }
}
