package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.LineHeightStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class TypographyKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final LineHeightStyle f15141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final TextStyle f15142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ProvidableCompositionLocal f15143c;

    static {
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.f29596b.a(), LineHeightStyle.Trim.f29606b.b(), (DefaultConstructorMarker) null);
        f15141a = lineHeightStyle;
        f15142b = TextStyle.e(TextStyle.f28924d.a(), 0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, DefaultPlatformTextStyle_androidKt.a(), lineHeightStyle, 0, 0, null, 15204351, null);
        f15143c = CompositionLocalKt.g(new Function0<Typography>() { // from class: androidx.compose.material.TypographyKt$LocalTypography$1
            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Typography invoke() {
                return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
            }
        });
    }

    public static final TextStyle b() {
        return f15142b;
    }

    public static final ProvidableCompositionLocal c() {
        return f15143c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle d(TextStyle textStyle, FontFamily fontFamily) {
        return textStyle.l() != null ? textStyle : TextStyle.e(textStyle, 0L, 0L, null, null, null, fontFamily, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777183, null);
    }
}
