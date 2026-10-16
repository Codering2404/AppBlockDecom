package androidx.compose.ui.text.font;

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
public final class ResourceFont implements Font {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29264b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final FontWeight f29265c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f29266d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final FontVariation.Settings f29267e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f29268f;

    public /* synthetic */ ResourceFont(int i3, FontWeight fontWeight, int i4, FontVariation.Settings settings, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, fontWeight, i4, settings, i5);
    }

    public final int a() {
        return this.f29264b;
    }

    @Override // androidx.compose.ui.text.font.Font
    public FontWeight b() {
        return this.f29265c;
    }

    @Override // androidx.compose.ui.text.font.Font
    public int c() {
        return this.f29268f;
    }

    @Override // androidx.compose.ui.text.font.Font
    public int d() {
        return this.f29266d;
    }

    public final FontVariation.Settings e() {
        return this.f29267e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResourceFont)) {
            return false;
        }
        ResourceFont resourceFont = (ResourceFont) obj;
        return this.f29264b == resourceFont.f29264b && Intrinsics.areEqual(b(), resourceFont.b()) && FontStyle.f(d(), resourceFont.d()) && Intrinsics.areEqual(this.f29267e, resourceFont.f29267e) && FontLoadingStrategy.f(c(), resourceFont.c());
    }

    public int hashCode() {
        return (((((((this.f29264b * 31) + b().hashCode()) * 31) + FontStyle.g(d())) * 31) + FontLoadingStrategy.g(c())) * 31) + this.f29267e.hashCode();
    }

    public String toString() {
        return "ResourceFont(resId=" + this.f29264b + ", weight=" + b() + ", style=" + ((Object) FontStyle.h(d())) + ", loadingStrategy=" + ((Object) FontLoadingStrategy.h(c())) + ')';
    }

    private ResourceFont(int i3, FontWeight fontWeight, int i4, FontVariation.Settings settings, int i5) {
        this.f29264b = i3;
        this.f29265c = fontWeight;
        this.f29266d = i4;
        this.f29267e = settings;
        this.f29268f = i5;
    }
}
