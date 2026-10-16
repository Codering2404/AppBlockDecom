package androidx.compose.foundation.text;

import androidx.compose.foundation.text.input.internal.CursorAnimationState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.WindowInfo;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
public final class TextFieldCursorKt {
    public static final Modifier a(Modifier modifier, final LegacyTextFieldState legacyTextFieldState, final TextFieldValue textFieldValue, final OffsetMapping offsetMapping, final Brush brush, boolean z2) {
        return z2 ? ComposedModifierKt.c(modifier, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            public final Modifier c(Modifier modifier2, Composer composer, int i3) {
                Modifier modifierD;
                composer.a0(-84507373);
                if (ComposerKt.M()) {
                    ComposerKt.U(-84507373, i3, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:46)");
                }
                boolean zBooleanValue = ((Boolean) composer.q(CompositionLocalsKt.e())).booleanValue();
                boolean zB = composer.b(zBooleanValue);
                Object objG = composer.G();
                if (zB || objG == Composer.f23746a.a()) {
                    objG = new CursorAnimationState(zBooleanValue);
                    composer.w(objG);
                }
                final CursorAnimationState cursorAnimationState = (CursorAnimationState) objG;
                Brush brush2 = brush;
                boolean z3 = ((brush2 instanceof SolidColor) && ((SolidColor) brush2).a() == 16) ? false : true;
                if (((WindowInfo) composer.q(CompositionLocalsKt.u())).b() && legacyTextFieldState.f() && TextRange.h(textFieldValue.h()) && z3) {
                    composer.a0(808460990);
                    AnnotatedString annotatedStringF = textFieldValue.f();
                    TextRange textRangeB = TextRange.b(textFieldValue.h());
                    boolean zI = composer.I(cursorAnimationState);
                    Object objG2 = composer.G();
                    if (zI || objG2 == Composer.f23746a.a()) {
                        objG2 = new TextFieldCursorKt$cursor$1$1$1(cursorAnimationState, null);
                        composer.w(objG2);
                    }
                    EffectsKt.f(annotatedStringF, textRangeB, (Function2) objG2, composer, 0);
                    boolean zI2 = composer.I(cursorAnimationState) | composer.I(offsetMapping) | composer.Z(textFieldValue) | composer.I(legacyTextFieldState) | composer.Z(brush);
                    final OffsetMapping offsetMapping2 = offsetMapping;
                    final TextFieldValue textFieldValue2 = textFieldValue;
                    final LegacyTextFieldState legacyTextFieldState2 = legacyTextFieldState;
                    final Brush brush3 = brush;
                    Object objG3 = composer.G();
                    if (zI2 || objG3 == Composer.f23746a.a()) {
                        Object obj = new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                                invoke((ContentDrawScope) obj2);
                                return Unit.f139807a;
                            }

                            public final void invoke(ContentDrawScope contentDrawScope) {
                                Rect rect;
                                TextLayoutResult textLayoutResultF;
                                contentDrawScope.i2();
                                float fE = cursorAnimationState.e();
                                if (fE == 0.0f) {
                                    return;
                                }
                                int iB = offsetMapping2.b(TextRange.n(textFieldValue2.h()));
                                TextLayoutResultProxy textLayoutResultProxyL = legacyTextFieldState2.l();
                                if (textLayoutResultProxyL == null || (textLayoutResultF = textLayoutResultProxyL.f()) == null || (rect = textLayoutResultF.e(iB)) == null) {
                                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                                }
                                float fE2 = RangesKt.e((float) Math.floor(contentDrawScope.M1(TextFieldCursor_androidKt.a())), 1.0f);
                                float f3 = fE2 / 2;
                                float fE3 = RangesKt.e(RangesKt.j(rect.o() + f3, Float.intBitsToFloat((int) (contentDrawScope.b() >> 32)) - f3), f3);
                                float fFloor = ((int) fE2) % 2 == 1 ? ((float) Math.floor(fE3)) + 0.5f : (float) Math.rint(fE3);
                                DrawScope.h2(contentDrawScope, brush3, Offset.e((((long) Float.floatToRawIntBits(fFloor)) << 32) | (((long) Float.floatToRawIntBits(rect.r())) & 4294967295L)), Offset.e((((long) Float.floatToRawIntBits(rect.i())) & 4294967295L) | (((long) Float.floatToRawIntBits(fFloor)) << 32)), fE2, 0, null, fE, null, 0, 432, null);
                            }
                        };
                        composer.w(obj);
                        objG3 = obj;
                    }
                    modifierD = DrawModifierKt.d(modifier2, (Function1) objG3);
                    composer.U();
                } else {
                    composer.a0(810474750);
                    composer.U();
                    modifierD = Modifier.b8;
                }
                if (ComposerKt.M()) {
                    ComposerKt.T();
                }
                composer.U();
                return modifierD;
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return c((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }
        }, 1, null) : modifier;
    }
}
