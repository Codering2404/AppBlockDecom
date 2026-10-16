package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class AndroidFont implements Font {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29088b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TypefaceLoader f29089c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FontVariation.Settings f29090d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface TypefaceLoader {
        Object a(Context context, AndroidFont androidFont, Continuation continuation);

        android.graphics.Typeface b(Context context, AndroidFont androidFont);
    }

    public /* synthetic */ AndroidFont(int i3, TypefaceLoader typefaceLoader, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, typefaceLoader, settings);
    }

    public final TypefaceLoader a() {
        return this.f29089c;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final int c() {
        return this.f29088b;
    }

    public final FontVariation.Settings e() {
        return this.f29090d;
    }

    private AndroidFont(int i3, TypefaceLoader typefaceLoader, FontVariation.Settings settings) {
        this.f29088b = i3;
        this.f29089c = typefaceLoader;
        this.f29090d = settings;
    }
}
