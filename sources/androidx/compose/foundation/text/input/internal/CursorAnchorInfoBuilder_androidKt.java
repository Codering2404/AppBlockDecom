package androidx.compose.foundation.text.input.internal;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CursorAnchorInfoBuilder_androidKt {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0054  */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final android.view.inputmethod.CursorAnchorInfo.Builder a(android.view.inputmethod.CursorAnchorInfo.Builder r14, int r15, int r16, androidx.compose.ui.text.TextLayoutResult r17, androidx.compose.ui.geometry.Rect r18) {
        /*
            r0 = r16
            r1 = r18
            int r2 = r0 - r15
            int r2 = r2 * 4
            float[] r2 = new float[r2]
            androidx.compose.ui.text.MultiParagraph r3 = r17.w()
            long r4 = androidx.compose.ui.text.TextRangeKt.b(r15, r16)
            r6 = 0
            r3.a(r4, r2, r6)
            r8 = r15
        L17:
            if (r8 >= r0) goto L79
            int r3 = r8 - r15
            int r3 = r3 * 4
            androidx.compose.ui.geometry.Rect r4 = new androidx.compose.ui.geometry.Rect
            r5 = r2[r3]
            int r6 = r3 + 1
            r6 = r2[r6]
            int r7 = r3 + 2
            r7 = r2[r7]
            int r3 = r3 + 3
            r3 = r2[r3]
            r4.<init>(r5, r6, r7, r3)
            boolean r3 = r1.z(r4)
            float r5 = r4.o()
            float r6 = r4.r()
            boolean r5 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.c(r1, r5, r6)
            if (r5 == 0) goto L54
            float r5 = r4.p()
            float r6 = r4.i()
            boolean r5 = androidx.compose.foundation.text.input.internal.LegacyCursorAnchorInfoBuilder_androidKt.c(r1, r5, r6)
            if (r5 != 0) goto L51
            goto L54
        L51:
            r5 = r17
            goto L57
        L54:
            r3 = r3 | 2
            goto L51
        L57:
            androidx.compose.ui.text.style.ResolvedTextDirection r6 = r5.c(r8)
            androidx.compose.ui.text.style.ResolvedTextDirection r7 = androidx.compose.ui.text.style.ResolvedTextDirection.f29613b
            if (r6 != r7) goto L61
            r3 = r3 | 4
        L61:
            r13 = r3
            float r9 = r4.o()
            float r10 = r4.r()
            float r11 = r4.p()
            float r12 = r4.i()
            r7 = r14
            r7.addCharacterBounds(r8, r9, r10, r11, r12, r13)
            int r8 = r8 + 1
            goto L17
        L79:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.text.input.internal.CursorAnchorInfoBuilder_androidKt.a(android.view.inputmethod.CursorAnchorInfo$Builder, int, int, androidx.compose.ui.text.TextLayoutResult, androidx.compose.ui.geometry.Rect):android.view.inputmethod.CursorAnchorInfo$Builder");
    }

    public static final CursorAnchorInfo b(CursorAnchorInfo.Builder builder, CharSequence charSequence, long j3, TextRange textRange, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z2, boolean z3, boolean z4, boolean z5) {
        builder.reset();
        builder.setMatrix(matrix);
        int iL = TextRange.l(j3);
        builder.setSelectionRange(iL, TextRange.k(j3));
        if (z2) {
            c(builder, iL, textLayoutResult, rect);
        }
        if (z3) {
            int iL2 = textRange != null ? TextRange.l(textRange.r()) : -1;
            int iK = textRange != null ? TextRange.k(textRange.r()) : -1;
            if (iL2 >= 0 && iL2 < iK) {
                builder.setComposingText(iL2, charSequence.subSequence(iL2, iK));
                a(builder, iL2, iK, textLayoutResult, rect);
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

    private static final CursorAnchorInfo.Builder c(CursorAnchorInfo.Builder builder, int i3, TextLayoutResult textLayoutResult, Rect rect) {
        if (i3 < 0) {
            return builder;
        }
        Rect rectE = textLayoutResult.e(i3);
        float fO = RangesKt.o(rectE.o(), 0.0f, (int) (textLayoutResult.B() >> 32));
        boolean zC = LegacyCursorAnchorInfoBuilder_androidKt.c(rect, fO, rectE.r());
        boolean zC2 = LegacyCursorAnchorInfoBuilder_androidKt.c(rect, fO, rectE.i());
        boolean z2 = textLayoutResult.c(i3) == ResolvedTextDirection.f29613b;
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
