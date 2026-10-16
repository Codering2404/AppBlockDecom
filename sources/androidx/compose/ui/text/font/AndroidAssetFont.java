package androidx.compose.ui.text.font;

import android.content.Context;
import android.content.res.AssetManager;
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
public final class AndroidAssetFont extends AndroidPreloadedFont {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AssetManager f29083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f29084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f29085k;

    public /* synthetic */ AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i3, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(assetManager, str, fontWeight, i3, settings);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidAssetFont)) {
            return false;
        }
        AndroidAssetFont androidAssetFont = (AndroidAssetFont) obj;
        return Intrinsics.areEqual(this.f29084j, androidAssetFont.f29084j) && Intrinsics.areEqual(e(), androidAssetFont.e());
    }

    @Override // androidx.compose.ui.text.font.AndroidPreloadedFont
    public android.graphics.Typeface f(Context context) {
        return TypefaceBuilderCompat.f29269a.a(this.f29083i, this.f29084j, context, e());
    }

    public int hashCode() {
        return (this.f29084j.hashCode() * 31) + e().hashCode();
    }

    public String toString() {
        return "Font(assetManager, path=" + this.f29084j + ", weight=" + b() + ", style=" + ((Object) FontStyle.h(d())) + ')';
    }

    private AndroidAssetFont(AssetManager assetManager, String str, FontWeight fontWeight, int i3, FontVariation.Settings settings) {
        super(fontWeight, i3, settings, null);
        this.f29083i = assetManager;
        this.f29084j = str;
        h(f(null));
        this.f29085k = "asset:" + str;
    }
}
