package androidx.compose.foundation.text;

import androidx.compose.foundation.text.selection.SelectionManagerKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextPainter;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.ImeOptions;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputSession;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;

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
public final class TextFieldDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f9925a = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void c(Canvas canvas, long j3, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint) {
            int iB = offsetMapping.b(TextRange.l(j3));
            int iB2 = offsetMapping.b(TextRange.k(j3));
            if (iB != iB2) {
                canvas.x(textLayoutResult.z(iB, iB2), paint);
            }
        }

        public final TransformedText a(long j3, TransformedText transformedText) {
            int iB = transformedText.a().b(TextRange.n(j3));
            int iB2 = transformedText.a().b(TextRange.i(j3));
            int iMin = Math.min(iB, iB2);
            int iMax = Math.max(iB, iB2);
            AnnotatedString.Builder builder = new AnnotatedString.Builder(transformedText.b());
            builder.f(new SpanStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, TextDecoration.f29625b.d(), (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 61439, (DefaultConstructorMarker) null), iMin, iMax);
            return new TransformedText(builder.t(), transformedText.a());
        }

        public final void b(Canvas canvas, TextFieldValue textFieldValue, long j3, long j4, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Paint paint, long j5) throws Throwable {
            if (!TextRange.h(j3)) {
                paint.u(j5);
                c(canvas, j3, offsetMapping, textLayoutResult, paint);
            } else if (!TextRange.h(j4)) {
                Color colorN = Color.n(textLayoutResult.l().i().j());
                if (colorN.B() == 16) {
                    colorN = null;
                }
                long jB = colorN != null ? colorN.B() : Color.f25715b.a();
                paint.u(Color.r(jB, Color.u(jB) * 0.2f, 0.0f, 0.0f, 0.0f, 14, null));
                c(canvas, j4, offsetMapping, textLayoutResult, paint);
            } else if (!TextRange.h(textFieldValue.h())) {
                paint.u(j5);
                c(canvas, textFieldValue.h(), offsetMapping, textLayoutResult, paint);
            }
            TextPainter.f28920a.a(canvas, textLayoutResult);
        }

        public final Triple d(TextDelegate textDelegate, long j3, LayoutDirection layoutDirection, TextLayoutResult textLayoutResult) {
            TextLayoutResult textLayoutResultL = textDelegate.l(j3, layoutDirection, textLayoutResult);
            return new Triple(Integer.valueOf((int) (textLayoutResultL.B() >> 32)), Integer.valueOf((int) (textLayoutResultL.B() & 4294967295L)), textLayoutResultL);
        }

        public final void e(TextFieldValue textFieldValue, TextDelegate textDelegate, TextLayoutResult textLayoutResult, LayoutCoordinates layoutCoordinates, TextInputSession textInputSession, boolean z2, OffsetMapping offsetMapping) {
            if (z2) {
                int iB = offsetMapping.b(TextRange.k(textFieldValue.h()));
                Rect rectD = iB < textLayoutResult.l().j().length() ? textLayoutResult.d(iB) : iB != 0 ? textLayoutResult.d(iB - 1) : new Rect(0.0f, 0.0f, 1.0f, (int) (TextFieldDelegateKt.b(textDelegate.j(), textDelegate.a(), textDelegate.b(), null, 0, 24, null) & 4294967295L));
                long jX0 = layoutCoordinates.x0(Offset.e((((long) Float.floatToRawIntBits(rectD.r())) & 4294967295L) | (((long) Float.floatToRawIntBits(rectD.o())) << 32)));
                textInputSession.c(RectKt.c(Offset.e((((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jX0 & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(Float.intBitsToFloat((int) (jX0 >> 32)))) << 32)), Size.d((((long) Float.floatToRawIntBits(rectD.i() - rectD.r())) & 4294967295L) | (((long) Float.floatToRawIntBits(rectD.p() - rectD.o())) << 32))));
            }
        }

        public final void f(TextInputSession textInputSession, EditProcessor editProcessor, Function1 function1) {
            function1.invoke(TextFieldValue.d(editProcessor.f(), null, 0L, null, 3, null));
            textInputSession.a();
        }

        public final void g(List list, EditProcessor editProcessor, Function1 function1, TextInputSession textInputSession) {
            TextFieldValue textFieldValueB = editProcessor.b(list);
            if (textInputSession != null) {
                textInputSession.d(null, textFieldValueB);
            }
            function1.invoke(textFieldValueB);
        }

        public final TextInputSession h(TextInputService textInputService, TextFieldValue textFieldValue, EditProcessor editProcessor, ImeOptions imeOptions, Function1 function1, Function1 function12) {
            return i(textInputService, textFieldValue, editProcessor, imeOptions, function1, function12);
        }

        public final TextInputSession i(TextInputService textInputService, TextFieldValue textFieldValue, final EditProcessor editProcessor, ImeOptions imeOptions, final Function1 function1, Function1 function12) {
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            TextInputSession textInputSessionD = textInputService.d(textFieldValue, imeOptions, new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.foundation.text.TextFieldDelegate$Companion$restartInput$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((List) obj);
                    return Unit.f139807a;
                }

                public final void invoke(List list) {
                    TextFieldDelegate.f9925a.g(list, editProcessor, function1, (TextInputSession) objectRef.f140144a);
                }
            }, function12);
            objectRef.f140144a = textInputSessionD;
            return textInputSessionD;
        }

        public final void j(long j3, TextLayoutResultProxy textLayoutResultProxy, EditProcessor editProcessor, OffsetMapping offsetMapping, Function1 function1) {
            function1.invoke(TextFieldValue.d(editProcessor.f(), null, TextRangeKt.a(offsetMapping.a(TextLayoutResultProxy.e(textLayoutResultProxy, j3, false, 2, null))), null, 5, null));
        }

        public final void k(TextInputSession textInputSession, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResultProxy textLayoutResultProxy) {
            LayoutCoordinates layoutCoordinatesB;
            final LayoutCoordinates layoutCoordinatesC = textLayoutResultProxy.c();
            if (layoutCoordinatesC == null || !layoutCoordinatesC.m() || (layoutCoordinatesB = textLayoutResultProxy.b()) == null) {
                return;
            }
            textInputSession.e(textFieldValue, offsetMapping, textLayoutResultProxy.f(), new Function1<Matrix, Unit>() { // from class: androidx.compose.foundation.text.TextFieldDelegate$Companion$updateTextLayoutResult$1$1$1
                {
                    super(1);
                }

                public final void c(float[] fArr) {
                    if (layoutCoordinatesC.m()) {
                        LayoutCoordinatesKt.d(layoutCoordinatesC).Y(layoutCoordinatesC, fArr);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    c(((Matrix) obj).p());
                    return Unit.f139807a;
                }
            }, SelectionManagerKt.i(layoutCoordinatesC), layoutCoordinatesC.j0(layoutCoordinatesB, false));
        }

        private Companion() {
        }
    }
}
