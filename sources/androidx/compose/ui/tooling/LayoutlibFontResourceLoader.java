package androidx.compose.ui.tooling;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.ResourceFont;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class LayoutlibFontResourceLoader implements Font.ResourceLoader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f29744a;

    public LayoutlibFontResourceLoader(Context context) {
        this.f29744a = context;
    }

    @Override // androidx.compose.ui.text.font.Font.ResourceLoader
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Typeface a(Font font) {
        if (font instanceof ResourceFont) {
            return ResourceFontHelper.f29763a.a(this.f29744a, (ResourceFont) font);
        }
        throw new IllegalArgumentException("Unknown font type: " + font.getClass().getName());
    }
}
