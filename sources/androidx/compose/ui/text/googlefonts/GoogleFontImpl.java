package androidx.compose.ui.text.googlefonts;

import androidx.compose.ui.text.font.AndroidFont;
import androidx.compose.ui.text.font.FontLoadingStrategy;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontVariation;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.googlefonts.GoogleFont;
import androidx.core.provider.FontRequest;
import com.facebook.internal.ServerProtocol;
import java.util.List;
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
public final class GoogleFontImpl extends AndroidFont {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f29295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final GoogleFont.Provider f29296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final FontWeight f29297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f29298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f29299i;

    public /* synthetic */ GoogleFontImpl(String str, GoogleFont.Provider provider, FontWeight fontWeight, int i3, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, provider, fontWeight, i3, z2);
    }

    private final String f() {
        return this.f29299i ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }

    private final int h(int i3) {
        return FontStyle.f(i3, FontStyle.f29211b.a()) ? 1 : 0;
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight b() {
        return this.f29297g;
    }

    @Override // androidx.compose.ui.text.font.Font
    public int d() {
        return this.f29298h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleFontImpl)) {
            return false;
        }
        GoogleFontImpl googleFontImpl = (GoogleFontImpl) obj;
        return Intrinsics.areEqual(this.f29295e, googleFontImpl.f29295e) && Intrinsics.areEqual(this.f29296f, googleFontImpl.f29296f) && Intrinsics.areEqual(b(), googleFontImpl.b()) && FontStyle.f(d(), googleFontImpl.d()) && this.f29299i == googleFontImpl.f29299i;
    }

    public final FontRequest g() {
        String str = "name=" + this.f29295e + "&weight=" + b().n() + "&italic=" + h(d()) + "&besteffort=" + f();
        List listA = this.f29296f.a();
        return listA != null ? new FontRequest(this.f29296f.c(), this.f29296f.d(), str, listA) : new FontRequest(this.f29296f.c(), this.f29296f.d(), str, this.f29296f.b());
    }

    public int hashCode() {
        return (((((((this.f29295e.hashCode() * 31) + this.f29296f.hashCode()) * 31) + b().hashCode()) * 31) + FontStyle.g(d())) * 31) + Boolean.hashCode(this.f29299i);
    }

    public final int i() {
        boolean zF = FontStyle.f(d(), FontStyle.f29211b.a());
        boolean z2 = b().compareTo(FontWeight.f29233b.b()) >= 0;
        if (zF && z2) {
            return 3;
        }
        if (zF) {
            return 2;
        }
        return z2 ? 1 : 0;
    }

    public String toString() {
        return "Font(GoogleFont(\"" + this.f29295e + "\", bestEffort=" + this.f29299i + "), weight=" + b() + ", style=" + ((Object) FontStyle.h(d())) + ')';
    }

    private GoogleFontImpl(String str, GoogleFont.Provider provider, FontWeight fontWeight, int i3, boolean z2) {
        super(FontLoadingStrategy.f29206b.a(), GoogleFontTypefaceLoader.f29300a, new FontVariation.Settings(new FontVariation.Setting[0]), null);
        this.f29295e = str;
        this.f29296f = provider;
        this.f29297g = fontWeight;
        this.f29298h = i3;
        this.f29299i = z2;
    }
}
