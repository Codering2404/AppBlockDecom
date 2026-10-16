package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
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
public final class CacheTextLayoutInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TextLayoutInput f28687a;

    public CacheTextLayoutInput(TextLayoutInput textLayoutInput) {
        this.f28687a = textLayoutInput;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput textLayoutInput = this.f28687a;
        CacheTextLayoutInput cacheTextLayoutInput = (CacheTextLayoutInput) obj;
        return Intrinsics.areEqual(textLayoutInput.j(), cacheTextLayoutInput.f28687a.j()) && textLayoutInput.i().I(cacheTextLayoutInput.f28687a.i()) && Intrinsics.areEqual(textLayoutInput.g(), cacheTextLayoutInput.f28687a.g()) && textLayoutInput.e() == cacheTextLayoutInput.f28687a.e() && textLayoutInput.h() == cacheTextLayoutInput.f28687a.h() && TextOverflow.h(textLayoutInput.f(), cacheTextLayoutInput.f28687a.f()) && Intrinsics.areEqual(textLayoutInput.b(), cacheTextLayoutInput.f28687a.b()) && textLayoutInput.d() == cacheTextLayoutInput.f28687a.d() && textLayoutInput.c() == cacheTextLayoutInput.f28687a.c() && Constraints.f(textLayoutInput.a(), cacheTextLayoutInput.f28687a.a());
    }

    public int hashCode() {
        TextLayoutInput textLayoutInput = this.f28687a;
        return (((((((((((((((((textLayoutInput.j().hashCode() * 31) + textLayoutInput.i().J()) * 31) + textLayoutInput.g().hashCode()) * 31) + textLayoutInput.e()) * 31) + Boolean.hashCode(textLayoutInput.h())) * 31) + TextOverflow.i(textLayoutInput.f())) * 31) + textLayoutInput.b().hashCode()) * 31) + textLayoutInput.d().hashCode()) * 31) + textLayoutInput.c().hashCode()) * 31) + Constraints.o(textLayoutInput.a());
    }
}
