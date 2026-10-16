package androidx.compose.ui.text.googlefonts;

import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.googlefonts.GoogleFont;
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
public final class GoogleFontKt {
    public static final Font a(GoogleFont googleFont, GoogleFont.Provider provider, FontWeight fontWeight, int i3) {
        return new GoogleFontImpl(googleFont.b(), provider, fontWeight, i3, googleFont.a(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(int i3) {
        return i3 != -4 ? i3 != -3 ? i3 != -2 ? i3 != -1 ? i3 != 1 ? i3 != 2 ? i3 != 3 ? "Unknown error code" : "The given query was not supported by this provider." : "The provider found the queried font, but it is currently unavailable." : "Font not found, please check availability on GoogleFont.Provider.AllFontsList: https://fonts.gstatic.com/s/a/directory.xml" : "The requested provider was not found on this device." : "The given provider cannot be authenticated with the certificates given." : "Generic error loading font, for example variation settings were not parsable" : "Font was not loaded due to security issues. This usually means the font was attempted to load in a restricted context";
    }
}
