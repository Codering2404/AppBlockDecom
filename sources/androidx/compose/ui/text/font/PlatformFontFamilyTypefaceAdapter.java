package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.AndroidTypeface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
public final class PlatformFontFamilyTypefaceAdapter implements FontFamilyTypefaceAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PlatformTypefaces f29260a = PlatformTypefaces_androidKt.a();

    public TypefaceResult a(TypefaceRequest typefaceRequest, PlatformFontLoader platformFontLoader, Function1 function1, Function1 function12) {
        android.graphics.Typeface typefaceA;
        FontFamily fontFamilyC = typefaceRequest.c();
        if (fontFamilyC == null ? true : fontFamilyC instanceof DefaultFontFamily) {
            typefaceA = this.f29260a.b(typefaceRequest.f(), typefaceRequest.d());
        } else if (fontFamilyC instanceof GenericFontFamily) {
            typefaceA = this.f29260a.a((GenericFontFamily) typefaceRequest.c(), typefaceRequest.f(), typefaceRequest.d());
        } else {
            if (!(fontFamilyC instanceof LoadedFontFamily)) {
                return null;
            }
            Typeface typefaceG = ((LoadedFontFamily) typefaceRequest.c()).g();
            Intrinsics.checkNotNull(typefaceG, "null cannot be cast to non-null type androidx.compose.ui.text.platform.AndroidTypeface");
            typefaceA = ((AndroidTypeface) typefaceG).a(typefaceRequest.f(), typefaceRequest.d(), typefaceRequest.e());
        }
        return new TypefaceResult.Immutable(typefaceA, false, 2, null);
    }
}
