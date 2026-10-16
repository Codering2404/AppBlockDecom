package androidx.paging;

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
public final class GenerationalViewportHint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f49805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ViewportHint f49806b;

    public GenerationalViewportHint(int i3, ViewportHint hint) {
        Intrinsics.checkNotNullParameter(hint, "hint");
        this.f49805a = i3;
        this.f49806b = hint;
    }

    public final int a() {
        return this.f49805a;
    }

    public final ViewportHint b() {
        return this.f49806b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GenerationalViewportHint)) {
            return false;
        }
        GenerationalViewportHint generationalViewportHint = (GenerationalViewportHint) obj;
        return this.f49805a == generationalViewportHint.f49805a && Intrinsics.areEqual(this.f49806b, generationalViewportHint.f49806b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f49805a) * 31) + this.f49806b.hashCode();
    }

    public String toString() {
        return "GenerationalViewportHint(generationId=" + this.f49805a + ", hint=" + this.f49806b + ')';
    }
}
