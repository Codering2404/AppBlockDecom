package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

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
public final class TextDrawStyleKt {
    public static final TextForegroundStyle b(TextForegroundStyle textForegroundStyle, TextForegroundStyle textForegroundStyle2, float f3) {
        boolean z2 = textForegroundStyle instanceof BrushStyle;
        return (z2 || (textForegroundStyle2 instanceof BrushStyle)) ? (z2 && (textForegroundStyle2 instanceof BrushStyle)) ? TextForegroundStyle.f29638a.a((Brush) SpanStyleKt.d(((BrushStyle) textForegroundStyle).e(), ((BrushStyle) textForegroundStyle2).e(), f3), MathHelpersKt.b(textForegroundStyle.a(), textForegroundStyle2.a(), f3)) : (TextForegroundStyle) SpanStyleKt.d(textForegroundStyle, textForegroundStyle2, f3) : TextForegroundStyle.f29638a.b(ColorKt.i(textForegroundStyle.d(), textForegroundStyle2.d(), f3));
    }

    public static final long c(long j3, float f3) {
        return (Float.isNaN(f3) || f3 >= 1.0f) ? j3 : Color.r(j3, Color.u(j3) * f3, 0.0f, 0.0f, 0.0f, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float d(float f3, Function0 function0) {
        return Float.isNaN(f3) ? ((Number) function0.invoke()).floatValue() : f3;
    }
}
