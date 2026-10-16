package androidx.compose.ui.text;

import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.unit.Density;
import java.util.List;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ParagraphKt {
    public static final Paragraph a(String str, TextStyle textStyle, long j3, Density density, FontFamily.Resolver resolver, List list, List list2, int i3, int i4) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.b(str, textStyle, list, list2, i3, i4, j3, density, resolver);
    }

    public static final Paragraph c(ParagraphIntrinsics paragraphIntrinsics, long j3, int i3, int i4) {
        return androidx.compose.ui.text.platform.AndroidParagraph_androidKt.a(paragraphIntrinsics, i3, i4, j3);
    }

    public static final int d(float f3) {
        return (int) Math.ceil(f3);
    }
}
