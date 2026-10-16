package cz.mobilesoft.coreblock.scene.schedule;

import java.io.Serializable;
import java.util.List;
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
public final class ApplicationDTO implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f114366a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f114367b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f114368c;

    public ApplicationDTO(String packageName, String label, List categories) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(categories, "categories");
        this.f114366a = packageName;
        this.f114367b = label;
        this.f114368c = categories;
    }

    public final List a() {
        return this.f114368c;
    }

    public final String b() {
        return this.f114367b;
    }

    public final String c() {
        return this.f114366a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationDTO)) {
            return false;
        }
        ApplicationDTO applicationDTO = (ApplicationDTO) obj;
        return Intrinsics.areEqual(this.f114366a, applicationDTO.f114366a) && Intrinsics.areEqual(this.f114367b, applicationDTO.f114367b) && Intrinsics.areEqual(this.f114368c, applicationDTO.f114368c);
    }

    public int hashCode() {
        return (((this.f114366a.hashCode() * 31) + this.f114367b.hashCode()) * 31) + this.f114368c.hashCode();
    }

    public String toString() {
        return "ApplicationDTO(packageName=" + this.f114366a + ", label=" + this.f114367b + ", categories=" + this.f114368c + ")";
    }
}
