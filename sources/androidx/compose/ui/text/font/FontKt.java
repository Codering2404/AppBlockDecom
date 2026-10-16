package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.FontVariation;
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
public final class FontKt {
    public static final Font a(int i3, FontWeight fontWeight, int i4, int i5) {
        return new ResourceFont(i3, fontWeight, i4, new FontVariation.Settings(new FontVariation.Setting[0]), i5, null);
    }

    public static /* synthetic */ Font b(int i3, FontWeight fontWeight, int i4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            fontWeight = FontWeight.f29233b.g();
        }
        if ((i6 & 4) != 0) {
            i4 = FontStyle.f29211b.b();
        }
        if ((i6 & 8) != 0) {
            i5 = FontLoadingStrategy.f29206b.b();
        }
        return a(i3, fontWeight, i4, i5);
    }

    public static final FontFamily c(Font font) {
        return FontFamilyKt.c(font);
    }
}
