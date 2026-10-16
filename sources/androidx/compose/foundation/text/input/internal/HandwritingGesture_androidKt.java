package androidx.compose.foundation.text.input.internal;

import android.graphics.PointF;
import androidx.compose.foundation.text.LegacyTextFieldState;
import androidx.compose.foundation.text.TextLayoutResultProxy;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.TextGranularity;
import androidx.compose.ui.text.TextInclusionStrategy;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditingBuffer;
import kotlin.Metadata;

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
public final class HandwritingGesture_androidKt {
    private static final boolean A(int i3) {
        int type = Character.getType(i3);
        return type == 14 || type == 13 || i3 == 10;
    }

    private static final boolean B(int i3) {
        int type = Character.getType(i3);
        return type == 23 || type == 20 || type == 22 || type == 30 || type == 29 || type == 24 || type == 21;
    }

    private static final boolean C(int i3) {
        return Character.isWhitespace(i3) || i3 == 160;
    }

    private static final boolean D(int i3) {
        return C(i3) && !A(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long E(CharSequence charSequence, int i3) {
        int iCharCount = i3;
        while (iCharCount > 0) {
            int iC = CodepointHelpers_jvmKt.c(charSequence, iCharCount);
            if (!C(iC)) {
                break;
            }
            iCharCount -= Character.charCount(iC);
        }
        while (i3 < charSequence.length()) {
            int iB = CodepointHelpers_jvmKt.b(charSequence, i3);
            if (!C(iB)) {
                break;
            }
            i3 += CodepointHelpers_jvmKt.a(iB);
        }
        return TextRangeKt.b(iCharCount, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long F(PointF pointF) {
        float f3 = pointF.x;
        float f4 = pointF.y;
        return Offset.e((((long) Float.floatToRawIntBits(f3)) << 32) | (((long) Float.floatToRawIntBits(f4)) & 4294967295L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long m(long j3, CharSequence charSequence) {
        int iN = TextRange.n(j3);
        int i3 = TextRange.i(j3);
        int iCodePointBefore = iN > 0 ? Character.codePointBefore(charSequence, iN) : 10;
        int iCodePointAt = i3 < charSequence.length() ? Character.codePointAt(charSequence, i3) : 10;
        if (D(iCodePointBefore) && (C(iCodePointAt) || B(iCodePointAt))) {
            do {
                iN -= Character.charCount(iCodePointBefore);
                if (iN == 0) {
                    break;
                }
                iCodePointBefore = Character.codePointBefore(charSequence, iN);
            } while (D(iCodePointBefore));
            return TextRangeKt.b(iN, i3);
        }
        if (!D(iCodePointAt)) {
            return j3;
        }
        if (!C(iCodePointBefore) && !B(iCodePointBefore)) {
            return j3;
        }
        do {
            i3 += Character.charCount(iCodePointAt);
            if (i3 == charSequence.length()) {
                break;
            }
            iCodePointAt = Character.codePointAt(charSequence, i3);
        } while (D(iCodePointAt));
        return TextRangeKt.b(iN, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EditCommand n(final EditCommand... editCommandArr) {
        return new EditCommand() { // from class: androidx.compose.foundation.text.input.internal.HandwritingGesture_androidKt$compoundEditCommand$1
            @Override // androidx.compose.ui.text.input.EditCommand
            public void a(EditingBuffer editingBuffer) {
                for (EditCommand editCommand : editCommandArr) {
                    editCommand.a(editingBuffer);
                }
            }
        };
    }

    private static final long o(long j3, long j4) {
        return TextRangeKt.b(Math.min(TextRange.n(j3), TextRange.n(j3)), Math.max(TextRange.i(j4), TextRange.i(j4)));
    }

    private static final int p(MultiParagraph multiParagraph, long j3, ViewConfiguration viewConfiguration) {
        float fH = viewConfiguration != null ? viewConfiguration.h() : 0.0f;
        int i3 = (int) (4294967295L & j3);
        int iQ = multiParagraph.q(Float.intBitsToFloat(i3));
        if (Float.intBitsToFloat(i3) >= multiParagraph.v(iQ) - fH && Float.intBitsToFloat(i3) <= multiParagraph.l(iQ) + fH) {
            int i4 = (int) (j3 >> 32);
            if (Float.intBitsToFloat(i4) >= (-fH) && Float.intBitsToFloat(i4) <= multiParagraph.D() + fH) {
                return iQ;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int q(LegacyTextFieldState legacyTextFieldState, long j3, ViewConfiguration viewConfiguration) {
        TextLayoutResult textLayoutResultF;
        MultiParagraph multiParagraphW;
        TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState.l();
        if (textLayoutResultProxyL == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null || (multiParagraphW = textLayoutResultF.w()) == null) {
            return -1;
        }
        return s(multiParagraphW, j3, legacyTextFieldState.k(), viewConfiguration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int r(TextLayoutState textLayoutState, long j3, ViewConfiguration viewConfiguration) {
        MultiParagraph multiParagraphW;
        TextLayoutResult textLayoutResultF = textLayoutState.f();
        if (textLayoutResultF == null || (multiParagraphW = textLayoutResultF.w()) == null) {
            return -1;
        }
        return s(multiParagraphW, j3, textLayoutState.j(), viewConfiguration);
    }

    private static final int s(MultiParagraph multiParagraph, long j3, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        long jX;
        int iP;
        if (layoutCoordinates == null || (iP = p(multiParagraph, (jX = layoutCoordinates.x(j3)), viewConfiguration)) == -1) {
            return -1;
        }
        return multiParagraph.x(Offset.g(jX, 0.0f, (multiParagraph.v(iP) + multiParagraph.l(iP)) / 2.0f, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long t(TextLayoutResult textLayoutResult, long j3, long j4, LayoutCoordinates layoutCoordinates, ViewConfiguration viewConfiguration) {
        if (textLayoutResult == null || layoutCoordinates == null) {
            return TextRange.f28921b.a();
        }
        long jX = layoutCoordinates.x(j3);
        long jX2 = layoutCoordinates.x(j4);
        int iP = p(textLayoutResult.w(), jX, viewConfiguration);
        int iP2 = p(textLayoutResult.w(), jX2, viewConfiguration);
        if (iP != -1) {
            if (iP2 != -1) {
                iP = Math.min(iP, iP2);
            }
            iP2 = iP;
        } else if (iP2 == -1) {
            return TextRange.f28921b.a();
        }
        float fV = (textLayoutResult.v(iP2) + textLayoutResult.m(iP2)) / 2;
        int i3 = (int) (jX >> 32);
        int i4 = (int) (jX2 >> 32);
        return textLayoutResult.w().C(new Rect(Math.min(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), fV - 0.1f, Math.max(Float.intBitsToFloat(i3), Float.intBitsToFloat(i4)), fV + 0.1f), TextGranularity.f28879b.a(), TextInclusionStrategy.f28883a.g());
    }

    private static final long u(MultiParagraph multiParagraph, Rect rect, LayoutCoordinates layoutCoordinates, int i3, TextInclusionStrategy textInclusionStrategy) {
        return (multiParagraph == null || layoutCoordinates == null) ? TextRange.f28921b.a() : multiParagraph.C(rect.B(layoutCoordinates.x(Offset.f25596b.c())), i3, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(LegacyTextFieldState legacyTextFieldState, Rect rect, int i3, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult textLayoutResultF;
        TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState.l();
        return u((textLayoutResultProxyL == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null) ? null : textLayoutResultF.w(), rect, legacyTextFieldState.k(), i3, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(TextLayoutState textLayoutState, Rect rect, int i3, TextInclusionStrategy textInclusionStrategy) {
        TextLayoutResult textLayoutResultF = textLayoutState.f();
        return u(textLayoutResultF != null ? textLayoutResultF.w() : null, rect, textLayoutState.j(), i3, textInclusionStrategy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long x(LegacyTextFieldState legacyTextFieldState, Rect rect, Rect rect2, int i3, TextInclusionStrategy textInclusionStrategy) {
        long jV = v(legacyTextFieldState, rect, i3, textInclusionStrategy);
        if (TextRange.h(jV)) {
            return TextRange.f28921b.a();
        }
        long jV2 = v(legacyTextFieldState, rect2, i3, textInclusionStrategy);
        return TextRange.h(jV2) ? TextRange.f28921b.a() : o(jV, jV2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long y(TextLayoutState textLayoutState, Rect rect, Rect rect2, int i3, TextInclusionStrategy textInclusionStrategy) {
        long jW = w(textLayoutState, rect, i3, textInclusionStrategy);
        if (TextRange.h(jW)) {
            return TextRange.f28921b.a();
        }
        long jW2 = w(textLayoutState, rect2, i3, textInclusionStrategy);
        return TextRange.h(jW2) ? TextRange.f28921b.a() : o(jW, jW2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean z(TextLayoutResult textLayoutResult, int i3) {
        int iQ = textLayoutResult.q(i3);
        return (i3 == textLayoutResult.u(iQ) || i3 == TextLayoutResult.p(textLayoutResult, iQ, false, 2, null)) ? textLayoutResult.y(i3) != textLayoutResult.c(i3) : textLayoutResult.c(i3) != textLayoutResult.c(i3 - 1);
    }
}
