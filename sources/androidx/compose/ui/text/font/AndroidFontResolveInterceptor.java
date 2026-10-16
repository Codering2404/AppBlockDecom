package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

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
public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f29100b;

    public AndroidFontResolveInterceptor(int i3) {
        this.f29100b = i3;
    }

    @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
    public FontWeight a(FontWeight fontWeight) {
        int i3 = this.f29100b;
        return (i3 == 0 || i3 == Integer.MAX_VALUE) ? fontWeight : new FontWeight(RangesKt.p(fontWeight.n() + this.f29100b, 1, 1000));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidFontResolveInterceptor) && this.f29100b == ((AndroidFontResolveInterceptor) obj).f29100b;
    }

    public int hashCode() {
        return Integer.hashCode(this.f29100b);
    }

    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.f29100b + ')';
    }
}
