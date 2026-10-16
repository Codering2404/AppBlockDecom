package cz.mobilesoft.statistics.model;

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
public final class ApplicationAppType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f133720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f133721b;

    public ApplicationAppType(String packageName, String appDistractionType) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(appDistractionType, "appDistractionType");
        this.f133720a = packageName;
        this.f133721b = appDistractionType;
    }

    public final String a() {
        return this.f133721b;
    }

    public final String b() {
        return this.f133720a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApplicationAppType)) {
            return false;
        }
        ApplicationAppType applicationAppType = (ApplicationAppType) obj;
        return Intrinsics.areEqual(this.f133720a, applicationAppType.f133720a) && Intrinsics.areEqual(this.f133721b, applicationAppType.f133721b);
    }

    public int hashCode() {
        return (this.f133720a.hashCode() * 31) + this.f133721b.hashCode();
    }

    public String toString() {
        return "ApplicationAppType(packageName=" + this.f133720a + ", appDistractionType=" + this.f133721b + ")";
    }
}
