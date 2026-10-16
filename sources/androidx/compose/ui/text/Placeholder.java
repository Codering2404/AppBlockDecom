package androidx.compose.ui.text;

import androidx.compose.ui.unit.TextUnit;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class Placeholder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f28753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f28754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f28755c;

    public final long a() {
        return this.f28754b;
    }

    public final int b() {
        return this.f28755c;
    }

    public final long c() {
        return this.f28753a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Placeholder)) {
            return false;
        }
        Placeholder placeholder = (Placeholder) obj;
        return TextUnit.e(this.f28753a, placeholder.f28753a) && TextUnit.e(this.f28754b, placeholder.f28754b) && PlaceholderVerticalAlign.j(this.f28755c, placeholder.f28755c);
    }

    public int hashCode() {
        return (((TextUnit.i(this.f28753a) * 31) + TextUnit.i(this.f28754b)) * 31) + PlaceholderVerticalAlign.k(this.f28755c);
    }

    public String toString() {
        return "Placeholder(width=" + ((Object) TextUnit.l(this.f28753a)) + ", height=" + ((Object) TextUnit.l(this.f28754b)) + ", placeholderVerticalAlign=" + ((Object) PlaceholderVerticalAlign.l(this.f28755c)) + ')';
    }
}
