package androidx.compose.ui.text.font;

import android.content.res.AssetManager;
import androidx.compose.ui.text.font.FontVariation;
import java.io.File;
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
public final class AndroidFontKt {
    public static final Font a(File file, FontWeight fontWeight, int i3, FontVariation.Settings settings) {
        return new AndroidFileFont(file, fontWeight, i3, settings, null);
    }

    public static /* synthetic */ Font b(File file, FontWeight fontWeight, int i3, FontVariation.Settings settings, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            fontWeight = FontWeight.f29233b.g();
        }
        if ((i4 & 4) != 0) {
            i3 = FontStyle.f29211b.b();
        }
        if ((i4 & 8) != 0) {
            settings = FontVariation.f29221a.a(fontWeight, i3, new FontVariation.Setting[0]);
        }
        return a(file, fontWeight, i3, settings);
    }

    public static final Font c(String str, AssetManager assetManager, FontWeight fontWeight, int i3, FontVariation.Settings settings) {
        return new AndroidAssetFont(assetManager, str, fontWeight, i3, settings, null);
    }

    public static /* synthetic */ Font d(String str, AssetManager assetManager, FontWeight fontWeight, int i3, FontVariation.Settings settings, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            fontWeight = FontWeight.f29233b.g();
        }
        if ((i4 & 8) != 0) {
            i3 = FontStyle.f29211b.b();
        }
        if ((i4 & 16) != 0) {
            settings = FontVariation.f29221a.a(fontWeight, i3, new FontVariation.Setting[0]);
        }
        return c(str, assetManager, fontWeight, i3, settings);
    }
}
