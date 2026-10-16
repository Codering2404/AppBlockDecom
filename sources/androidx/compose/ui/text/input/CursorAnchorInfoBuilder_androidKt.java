package androidx.compose.ui.text.input;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.Metadata;
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
public final class CursorAnchorInfoBuilder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0064  */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final android.view.inputmethod.CursorAnchorInfo.Builder a(android.view.inputmethod.CursorAnchorInfo.Builder r17, int r18, int r19, androidx.compose.ui.text.input.OffsetMapping r20, androidx.compose.ui.text.TextLayoutResult r21, androidx.compose.ui.geometry.Rect r22) {
        /*
            r0 = r19
            r1 = r20
            r2 = r18
            r3 = r22
            int r4 = r1.b(r2)
            int r5 = r1.b(r0)
            int r6 = r5 - r4
            int r6 = r6 * 4
            float[] r6 = new float[r6]
            androidx.compose.ui.text.MultiParagraph r7 = r21.w()
            long r8 = androidx.compose.ui.text.TextRangeKt.b(r4, r5)
            r5 = 0
            r7.a(r8, r6, r5)
            r11 = r2
        L23:
            if (r11 >= r0) goto L8b
            int r2 = r1.b(r11)
            int r5 = r2 - r4
            int r5 = r5 * 4
            androidx.compose.ui.geometry.Rect r7 = new androidx.compose.ui.geometry.Rect
            r8 = r6[r5]
            int r9 = r5 + 1
            r9 = r6[r9]
            int r10 = r5 + 2
            r10 = r6[r10]
            int r5 = r5 + 3
            r5 = r6[r5]
            r7.<init>(r8, r9, r10, r5)
            boolean r5 = r3.z(r7)
            float r8 = r7.o()
            float r9 = r7.r()
            boolean r8 = c(r3, r8, r9)
            if (r8 == 0) goto L64
            float r8 = r7.p()
            float r9 = r7.i()
            boolean r8 = c(r3, r8, r9)
            if (r8 != 0) goto L61
            goto L64
        L61:
            r8 = r21
            goto L67
        L64:
            r5 = r5 | 2
            goto L61
        L67:
            androidx.compose.ui.text.style.ResolvedTextDirection r2 = r8.c(r2)
            androidx.compose.ui.text.style.ResolvedTextDirection r9 = androidx.compose.ui.text.style.ResolvedTextDirection.f29613b
            if (r2 != r9) goto L71
            r5 = r5 | 4
        L71:
            r16 = r5
            float r12 = r7.o()
            float r13 = r7.r()
            float r14 = r7.p()
            float r15 = r7.i()
            r10 = r17
            r10.addCharacterBounds(r11, r12, r13, r14, r15, r16)
            int r11 = r11 + 1
            goto L23
        L8b:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.CursorAnchorInfoBuilder_androidKt.a(android.view.inputmethod.CursorAnchorInfo$Builder, int, int, androidx.compose.ui.text.input.OffsetMapping, androidx.compose.ui.text.TextLayoutResult, androidx.compose.ui.geometry.Rect):android.view.inputmethod.CursorAnchorInfo$Builder");
    }

    public static final CursorAnchorInfo b(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z2, boolean z3, boolean z4, boolean z5) {
        builder.reset();
        builder.setMatrix(matrix);
        int iL = TextRange.l(textFieldValue.h());
        builder.setSelectionRange(iL, TextRange.k(textFieldValue.h()));
        if (z2) {
            d(builder, iL, offsetMapping, textLayoutResult, rect);
        }
        if (z3) {
            TextRange textRangeG = textFieldValue.g();
            int iL2 = textRangeG != null ? TextRange.l(textRangeG.r()) : -1;
            TextRange textRangeG2 = textFieldValue.g();
            int iK = textRangeG2 != null ? TextRange.k(textRangeG2.r()) : -1;
            if (iL2 >= 0 && iL2 < iK) {
                builder.setComposingText(iL2, textFieldValue.i().subSequence(iL2, iK));
                a(builder, iL2, iK, offsetMapping, textLayoutResult, rect);
            }
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 33 && z4) {
            CursorAnchorInfoApi33Helper.a(builder, rect2);
        }
        if (i3 >= 34 && z5) {
            CursorAnchorInfoApi34Helper.a(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    private static final boolean c(Rect rect, float f3, float f4) {
        float fO = rect.o();
        if (f3 > rect.p() || fO > f3) {
            return false;
        }
        return f4 <= rect.i() && rect.r() <= f4;
    }

    private static final CursorAnchorInfo.Builder d(CursorAnchorInfo.Builder builder, int i3, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        if (i3 < 0) {
            return builder;
        }
        int iB = offsetMapping.b(i3);
        Rect rectE = textLayoutResult.e(iB);
        float fO = RangesKt.o(rectE.o(), 0.0f, (int) (textLayoutResult.B() >> 32));
        boolean zC = c(rect, fO, rectE.r());
        boolean zC2 = c(rect, fO, rectE.i());
        boolean z2 = textLayoutResult.c(iB) == ResolvedTextDirection.f29613b;
        int i4 = (zC || zC2) ? 1 : 0;
        if (!zC || !zC2) {
            i4 |= 2;
        }
        if (z2) {
            i4 |= 4;
        }
        builder.setInsertionMarkerLocation(fO, rectE.r(), rectE.i(), rectE.i(), i4);
        return builder;
    }
}
