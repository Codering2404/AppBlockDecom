package androidx.compose.foundation.text.input.internal;

import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.text.input.TextFieldBuffer;
import androidx.compose.foundation.text.input.TextFieldBufferKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class ImeEditCommand_androidKt {
    public static final void b(ImeEditCommandScope imeEditCommandScope, final String str, final int i3) {
        imeEditCommandScope.b(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$commitText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(TextFieldBuffer textFieldBuffer) {
                TextRange textRangeH = textFieldBuffer.h();
                if (textRangeH != null) {
                    ImeEditCommand_androidKt.g(textFieldBuffer, TextRange.n(textRangeH.r()), TextRange.i(textRangeH.r()), str);
                } else {
                    ImeEditCommand_androidKt.g(textFieldBuffer, TextRange.n(textFieldBuffer.l()), TextRange.i(textFieldBuffer.l()), str);
                }
                int iN = TextRange.n(textFieldBuffer.l());
                int i4 = i3;
                textFieldBuffer.x(TextRangeKt.a(RangesKt.p(i4 > 0 ? (iN + i4) - 1 : (iN + i4) - str.length(), 0, textFieldBuffer.j())));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldBuffer) obj);
                return Unit.f139807a;
            }
        });
    }

    public static final void c(ImeEditCommandScope imeEditCommandScope, final int i3, final int i4) {
        imeEditCommandScope.b(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$deleteSurroundingText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(TextFieldBuffer textFieldBuffer) {
                int i5 = i3;
                boolean z2 = i5 >= 0 && i4 >= 0;
                int i6 = i4;
                if (!z2) {
                    InlineClassHelperKt.a("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i5 + " and " + i6 + " respectively.");
                }
                int i7 = TextRange.i(textFieldBuffer.l());
                int i8 = i4;
                int iJ = i7 + i8;
                if (((i7 ^ iJ) & (i8 ^ iJ)) < 0) {
                    iJ = textFieldBuffer.j();
                }
                ImeEditCommand_androidKt.f(textFieldBuffer, TextRange.i(textFieldBuffer.l()), Math.min(iJ, textFieldBuffer.j()));
                int iN = TextRange.n(textFieldBuffer.l());
                int i9 = i3;
                int i10 = iN - i9;
                if (((iN ^ i10) & (i9 ^ iN)) < 0) {
                    i10 = 0;
                }
                ImeEditCommand_androidKt.f(textFieldBuffer, Math.max(0, i10), TextRange.n(textFieldBuffer.l()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldBuffer) obj);
                return Unit.f139807a;
            }
        });
    }

    public static final void d(ImeEditCommandScope imeEditCommandScope, final int i3, final int i4) {
        imeEditCommandScope.b(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$deleteSurroundingTextInCodePoints$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(TextFieldBuffer textFieldBuffer) {
                int i5 = i3;
                int i6 = 0;
                boolean z2 = i5 >= 0 && i4 >= 0;
                int i7 = i4;
                if (!z2) {
                    InlineClassHelperKt.a("Expected lengthBeforeCursor and lengthAfterCursor to be non-negative, were " + i5 + " and " + i7 + " respectively.");
                }
                int i8 = 0;
                int iN = 0;
                while (true) {
                    if (i8 < i3) {
                        int i9 = iN + 1;
                        if (TextRange.n(textFieldBuffer.l()) <= i9) {
                            iN = TextRange.n(textFieldBuffer.l());
                            break;
                        } else {
                            iN = ImeEditCommand_androidKt.h(textFieldBuffer.a().charAt((TextRange.n(textFieldBuffer.l()) - i9) - 1), textFieldBuffer.a().charAt(TextRange.n(textFieldBuffer.l()) - i9)) ? iN + 2 : i9;
                            i8++;
                        }
                    } else {
                        break;
                    }
                }
                int iJ = 0;
                while (true) {
                    if (i6 >= i4) {
                        break;
                    }
                    int i10 = iJ + 1;
                    if (TextRange.i(textFieldBuffer.l()) + i10 >= textFieldBuffer.j()) {
                        iJ = textFieldBuffer.j() - TextRange.i(textFieldBuffer.l());
                        break;
                    } else {
                        iJ = ImeEditCommand_androidKt.h(textFieldBuffer.a().charAt((TextRange.i(textFieldBuffer.l()) + i10) - 1), textFieldBuffer.a().charAt(TextRange.i(textFieldBuffer.l()) + i10)) ? iJ + 2 : i10;
                        i6++;
                    }
                }
                ImeEditCommand_androidKt.f(textFieldBuffer, TextRange.i(textFieldBuffer.l()), TextRange.i(textFieldBuffer.l()) + iJ);
                ImeEditCommand_androidKt.f(textFieldBuffer, TextRange.n(textFieldBuffer.l()) - iN, TextRange.n(textFieldBuffer.l()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldBuffer) obj);
                return Unit.f139807a;
            }
        });
    }

    public static final void e(ImeEditCommandScope imeEditCommandScope) {
        imeEditCommandScope.b(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$finishComposingText$1
            public final void c(TextFieldBuffer textFieldBuffer) {
                textFieldBuffer.d();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldBuffer) obj);
                return Unit.f139807a;
            }
        });
    }

    public static final void f(TextFieldBuffer textFieldBuffer, int i3, int i4) {
        TextRange textRangeH = textFieldBuffer.h();
        int iMin = Math.min(i3, i4);
        int iMax = Math.max(i3, i4);
        TextFieldBufferKt.b(textFieldBuffer, iMin, iMax);
        if (textRangeH != null) {
            textRangeH.r();
            long jA = TextFieldBufferKt.a(textRangeH.r(), iMin, iMax, 0);
            if (TextRange.h(jA)) {
                textFieldBuffer.d();
            } else {
                TextFieldBuffer.u(textFieldBuffer, TextRange.l(jA), TextRange.k(jA), null, 4, null);
            }
        }
    }

    public static final void g(TextFieldBuffer textFieldBuffer, int i3, int i4, CharSequence charSequence) {
        int iMin = Math.min(i3, i4);
        int iMax = Math.max(i3, i4);
        int i5 = 0;
        int i6 = iMin;
        while (i6 < iMax && i5 < charSequence.length() && charSequence.charAt(i5) == textFieldBuffer.a().charAt(i6)) {
            i5++;
            i6++;
        }
        int length = charSequence.length();
        while (iMax > i6 && length > i5 && charSequence.charAt(length - 1) == textFieldBuffer.a().charAt(iMax - 1)) {
            length--;
            iMax--;
        }
        if (i6 == iMax && i5 == length) {
            textFieldBuffer.d();
            textFieldBuffer.c();
        } else {
            textFieldBuffer.p(i6, iMax, charSequence.subSequence(i5, length));
        }
        textFieldBuffer.x(TextRangeKt.a(iMin + charSequence.length()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(char c3, char c4) {
        return Character.isHighSurrogate(c3) && Character.isLowSurrogate(c4);
    }

    public static final void i(ImeEditCommandScope imeEditCommandScope, final int i3, final int i4) {
        imeEditCommandScope.b(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setComposingRegion$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(TextFieldBuffer textFieldBuffer) {
                if (textFieldBuffer.m()) {
                    textFieldBuffer.d();
                }
                int iP = RangesKt.p(i3, 0, textFieldBuffer.j());
                int iP2 = RangesKt.p(i4, 0, textFieldBuffer.j());
                if (iP != iP2) {
                    if (iP < iP2) {
                        TextFieldBuffer.u(textFieldBuffer, iP, iP2, null, 4, null);
                    } else {
                        TextFieldBuffer.u(textFieldBuffer, iP2, iP, null, 4, null);
                    }
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldBuffer) obj);
                return Unit.f139807a;
            }
        });
    }

    public static final void j(ImeEditCommandScope imeEditCommandScope, final String str, final int i3, final List list) {
        imeEditCommandScope.b(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setComposingText$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(TextFieldBuffer textFieldBuffer) {
                TextRange textRangeH = textFieldBuffer.h();
                if (textRangeH != null) {
                    ImeEditCommand_androidKt.g(textFieldBuffer, TextRange.n(textRangeH.r()), TextRange.i(textRangeH.r()), str);
                    if (str.length() > 0) {
                        textFieldBuffer.t(TextRange.n(textRangeH.r()), TextRange.n(textRangeH.r()) + str.length(), list);
                    }
                } else {
                    int iN = TextRange.n(textFieldBuffer.l());
                    ImeEditCommand_androidKt.g(textFieldBuffer, iN, TextRange.i(textFieldBuffer.l()), str);
                    if (str.length() > 0) {
                        textFieldBuffer.t(iN, str.length() + iN, list);
                    }
                }
                int iN2 = TextRange.n(textFieldBuffer.l());
                int i4 = i3;
                textFieldBuffer.x(TextRangeKt.a(RangesKt.p(i4 > 0 ? (iN2 + i4) - 1 : (iN2 + i4) - str.length(), 0, textFieldBuffer.j())));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldBuffer) obj);
                return Unit.f139807a;
            }
        });
    }

    public static final void k(final ImeEditCommandScope imeEditCommandScope, final int i3, final int i4) {
        imeEditCommandScope.b(new Function1<TextFieldBuffer, Unit>() { // from class: androidx.compose.foundation.text.input.internal.ImeEditCommand_androidKt$setSelection$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(TextFieldBuffer textFieldBuffer) {
                long jD = imeEditCommandScope.d(TextRangeKt.b(0, textFieldBuffer.j()));
                int i5 = i3;
                int iL = TextRange.l(jD);
                int iK = TextRange.k(jD);
                if (i5 < iL) {
                    i5 = iL;
                }
                if (i5 <= iK) {
                    iK = i5;
                }
                int i6 = i4;
                int iL2 = TextRange.l(jD);
                int iK2 = TextRange.k(jD);
                if (i6 < iL2) {
                    i6 = iL2;
                }
                if (i6 <= iK2) {
                    iK2 = i6;
                }
                textFieldBuffer.x(imeEditCommandScope.e(TextRangeKt.b(iK, iK2)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((TextFieldBuffer) obj);
                return Unit.f139807a;
            }
        });
    }
}
