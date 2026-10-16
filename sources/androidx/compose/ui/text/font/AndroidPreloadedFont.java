package androidx.compose.ui.text.font;

import android.content.Context;
import androidx.compose.ui.text.font.FontVariation;
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
public abstract class AndroidPreloadedFont extends AndroidFont {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FontWeight f29101e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f29102f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f29103g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private android.graphics.Typeface f29104h;

    public /* synthetic */ AndroidPreloadedFont(FontWeight fontWeight, int i3, FontVariation.Settings settings, DefaultConstructorMarker defaultConstructorMarker) {
        this(fontWeight, i3, settings);
    }

    @Override // androidx.compose.ui.text.font.Font
    public final FontWeight b() {
        return this.f29101e;
    }

    @Override // androidx.compose.ui.text.font.Font
    public final int d() {
        return this.f29102f;
    }

    public abstract android.graphics.Typeface f(Context context);

    public final android.graphics.Typeface g(Context context) {
        if (!this.f29103g && this.f29104h == null) {
            this.f29104h = f(context);
        }
        this.f29103g = true;
        return this.f29104h;
    }

    public final void h(android.graphics.Typeface typeface) {
        this.f29104h = typeface;
    }

    private AndroidPreloadedFont(FontWeight fontWeight, int i3, FontVariation.Settings settings) {
        super(FontLoadingStrategy.f29206b.b(), AndroidPreloadedFontTypefaceLoader.f29105a, settings, null);
        this.f29101e = fontWeight;
        this.f29102f = i3;
    }
}
