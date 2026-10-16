package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontVariation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
final class DeviceFontFamilyNameFont extends AndroidFont {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f29150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FontWeight f29151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f29152g;

    public /* synthetic */ DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i3, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, fontWeight, i3, settings);
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight b() {
        return this.f29151f;
    }

    @Override // androidx.compose.ui.text.font.Font
    public int d() {
        return this.f29152g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceFontFamilyNameFont)) {
            return false;
        }
        DeviceFontFamilyNameFont deviceFontFamilyNameFont = (DeviceFontFamilyNameFont) obj;
        return DeviceFontFamilyName.c(this.f29150e, deviceFontFamilyNameFont.f29150e) && Intrinsics.areEqual(b(), deviceFontFamilyNameFont.b()) && FontStyle.f(d(), deviceFontFamilyNameFont.d()) && Intrinsics.areEqual(e(), deviceFontFamilyNameFont.e());
    }

    public final android.graphics.Typeface f(Context context) {
        return PlatformTypefaces_androidKt.a().c(this.f29150e, b(), d(), e(), context);
    }

    public int hashCode() {
        return (((((DeviceFontFamilyName.d(this.f29150e) * 31) + b().hashCode()) * 31) + FontStyle.g(d())) * 31) + e().hashCode();
    }

    public String toString() {
        return "Font(familyName=\"" + ((Object) DeviceFontFamilyName.e(this.f29150e)) + "\", weight=" + b() + ", style=" + ((Object) FontStyle.h(d())) + ')';
    }

    private DeviceFontFamilyNameFont(String str, FontWeight fontWeight, int i3, FontVariation.Settings settings) {
        super(FontLoadingStrategy.f29206b.c(), NamedFontLoader.f29259a, settings, null);
        this.f29150e = str;
        this.f29151f = fontWeight;
        this.f29152g = i3;
    }
}
