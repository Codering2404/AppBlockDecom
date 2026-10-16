package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.LayoutHelper;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextLayoutGetRangeForRectExtensions_androidKt {
    private static final float a(int i3, int i4, float[] fArr) {
        return fArr[(i3 - i4) * 2];
    }

    private static final float b(int i3, int i4, float[] fArr) {
        return fArr[((i3 - i4) * 2) + 1];
    }

    private static final int c(LayoutHelper.BidiRun bidiRun, RectF rectF, int i3, int i4, int i5, float f3, float f4, float[] fArr, SegmentFinder segmentFinder, Function2 function2) {
        int iB;
        int iC;
        if (!g(rectF, f3, f4)) {
            return -1;
        }
        if ((bidiRun.c() || rectF.right < f4) && (!bidiRun.c() || rectF.left > f3)) {
            iB = bidiRun.b();
            int iA = bidiRun.a();
            while (iA - iB > 1) {
                int i6 = (iA + iB) / 2;
                float fA = a(i6, i3, fArr);
                if ((bidiRun.c() || fA <= rectF.right) && (!bidiRun.c() || fA >= rectF.left)) {
                    iB = i6;
                } else {
                    iA = i6;
                }
            }
            if (bidiRun.c()) {
                iB = iA;
            }
        } else {
            iB = bidiRun.a() - 1;
        }
        int iB2 = segmentFinder.b(iB + 1);
        if (iB2 == -1 || (iC = segmentFinder.c(iB2)) <= bidiRun.b()) {
            return -1;
        }
        int iF = RangesKt.f(iB2, bidiRun.b());
        int iK = RangesKt.k(iC, bidiRun.a());
        RectF rectF2 = new RectF(0.0f, i4, 0.0f, i5);
        while (true) {
            rectF2.left = bidiRun.c() ? a(iK - 1, i3, fArr) : a(iF, i3, fArr);
            rectF2.right = bidiRun.c() ? b(iF, i3, fArr) : b(iK - 1, i3, fArr);
            if (((Boolean) function2.invoke(rectF2, rectF)).booleanValue()) {
                return iK;
            }
            iK = segmentFinder.d(iK);
            if (iK == -1 || iK <= bidiRun.b()) {
                break;
            }
            iF = RangesKt.f(segmentFinder.b(iK), bidiRun.b());
        }
        return -1;
    }

    public static final int[] d(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, RectF rectF, int i3, Function2 function2) {
        int i4;
        SegmentFinder wordSegmentFinder = i3 == 1 ? new WordSegmentFinder(textLayout.G(), textLayout.I()) : SegmentFinder_androidKt.a(textLayout.G(), textLayout.H());
        int lineForVertical = layout.getLineForVertical((int) rectF.top);
        if (rectF.top > textLayout.l(lineForVertical) && (lineForVertical = lineForVertical + 1) >= textLayout.m()) {
            return null;
        }
        int i5 = lineForVertical;
        int lineForVertical2 = layout.getLineForVertical((int) rectF.bottom);
        if (lineForVertical2 == 0 && rectF.bottom < textLayout.w(0)) {
            return null;
        }
        int iF = f(textLayout, layout, layoutHelper, i5, rectF, wordSegmentFinder, function2, true);
        while (true) {
            i4 = i5;
            if (iF != -1 || i4 >= lineForVertical2) {
                break;
            }
            i5 = i4 + 1;
            iF = f(textLayout, layout, layoutHelper, i5, rectF, wordSegmentFinder, function2, true);
        }
        if (iF == -1) {
            return null;
        }
        int iF2 = f(textLayout, layout, layoutHelper, lineForVertical2, rectF, wordSegmentFinder, function2, false);
        while (iF2 == -1 && i4 < lineForVertical2) {
            int i6 = lineForVertical2 - 1;
            iF2 = f(textLayout, layout, layoutHelper, i6, rectF, wordSegmentFinder, function2, false);
            lineForVertical2 = i6;
        }
        if (iF2 == -1) {
            return null;
        }
        return new int[]{wordSegmentFinder.b(iF + 1), wordSegmentFinder.c(iF2 - 1)};
    }

    private static final int e(LayoutHelper.BidiRun bidiRun, RectF rectF, int i3, int i4, int i5, float f3, float f4, float[] fArr, SegmentFinder segmentFinder, Function2 function2) {
        int iB;
        int iB2;
        if (!g(rectF, f3, f4)) {
            return -1;
        }
        if ((bidiRun.c() || rectF.left > f3) && (!bidiRun.c() || rectF.right < f4)) {
            iB = bidiRun.b();
            int iA = bidiRun.a();
            while (iA - iB > 1) {
                int i6 = (iA + iB) / 2;
                float fA = a(i6, i3, fArr);
                if ((bidiRun.c() || fA <= rectF.left) && (!bidiRun.c() || fA >= rectF.right)) {
                    iB = i6;
                } else {
                    iA = i6;
                }
            }
            if (bidiRun.c()) {
                iB = iA;
            }
        } else {
            iB = bidiRun.b();
        }
        int iC = segmentFinder.c(iB);
        if (iC == -1 || (iB2 = segmentFinder.b(iC)) >= bidiRun.a()) {
            return -1;
        }
        int iF = RangesKt.f(iB2, bidiRun.b());
        int iK = RangesKt.k(iC, bidiRun.a());
        RectF rectF2 = new RectF(0.0f, i4, 0.0f, i5);
        while (true) {
            rectF2.left = bidiRun.c() ? a(iK - 1, i3, fArr) : a(iF, i3, fArr);
            rectF2.right = bidiRun.c() ? b(iF, i3, fArr) : b(iK - 1, i3, fArr);
            if (((Boolean) function2.invoke(rectF2, rectF)).booleanValue()) {
                return iF;
            }
            iF = segmentFinder.a(iF);
            if (iF == -1 || iF >= bidiRun.a()) {
                break;
            }
            iK = RangesKt.k(segmentFinder.c(iF), bidiRun.a());
        }
        return -1;
    }

    private static final int f(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, int i3, RectF rectF, SegmentFinder segmentFinder, Function2 function2, boolean z2) {
        int lineTop = layout.getLineTop(i3);
        int lineBottom = layout.getLineBottom(i3);
        int lineStart = layout.getLineStart(i3);
        int lineEnd = layout.getLineEnd(i3);
        if (lineStart == lineEnd) {
            return -1;
        }
        float[] fArr = new float[(lineEnd - lineStart) * 2];
        textLayout.b(i3, fArr);
        LayoutHelper.BidiRun[] bidiRunArrD = layoutHelper.d(i3);
        IntProgression indices = z2 ? ArraysKt.getIndices(bidiRunArrD) : RangesKt.v(ArraysKt.getLastIndex(bidiRunArrD), 0);
        int iG = indices.g();
        int iH = indices.h();
        int iL = indices.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            int i4 = iG;
            while (true) {
                LayoutHelper.BidiRun bidiRun = bidiRunArrD[i4];
                float fA = bidiRun.c() ? a(bidiRun.a() - 1, lineStart, fArr) : a(bidiRun.b(), lineStart, fArr);
                float fB = bidiRun.c() ? b(bidiRun.b(), lineStart, fArr) : b(bidiRun.a() - 1, lineStart, fArr);
                int iE = z2 ? e(bidiRun, rectF, lineStart, lineTop, lineBottom, fA, fB, fArr, segmentFinder, function2) : c(bidiRun, rectF, lineStart, lineTop, lineBottom, fA, fB, fArr, segmentFinder, function2);
                if (iE < 0) {
                    if (i4 == iH) {
                        break;
                    }
                    i4 += iL;
                } else {
                    return iE;
                }
            }
        }
        return -1;
    }

    private static final boolean g(RectF rectF, float f3, float f4) {
        return f4 >= rectF.left && f3 <= rectF.right;
    }
}
