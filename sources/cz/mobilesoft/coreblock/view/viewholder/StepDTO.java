package cz.mobilesoft.coreblock.view.viewholder;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class StepDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f133488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharSequence f133489b;

    public StepDTO(int i3, CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.f133488a = i3;
        this.f133489b = text;
    }

    public final int a() {
        return this.f133488a;
    }

    public final CharSequence b() {
        return this.f133489b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StepDTO)) {
            return false;
        }
        StepDTO stepDTO = (StepDTO) obj;
        return this.f133488a == stepDTO.f133488a && Intrinsics.areEqual(this.f133489b, stepDTO.f133489b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f133488a) * 31) + this.f133489b.hashCode();
    }

    public String toString() {
        return "StepDTO(number=" + this.f133488a + ", text=" + ((Object) this.f133489b) + ")";
    }
}
