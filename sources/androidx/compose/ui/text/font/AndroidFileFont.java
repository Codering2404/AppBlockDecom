package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontVariation;
import java.io.File;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidFileFont extends AndroidPreloadedFont {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final File f29087i;

    public /* synthetic */ AndroidFileFont(File file, FontWeight fontWeight, int i3, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, fontWeight, i3, settings);
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public android.graphics.Typeface f(Context context) {
        return TypefaceBuilderCompat.f29269a.b(this.f29087i, context, e());
    }

    public String toString() {
        return "Font(file=" + this.f29087i + ", weight=" + b() + ", style=" + ((Object) FontStyle.h(d())) + ')';
    }

    private AndroidFileFont(File file, FontWeight fontWeight, int i3, FontVariation.Settings settings) {
        super(fontWeight, i3, settings, null);
        this.f29087i = file;
        h(f(null));
    }
}
