package cz.mobilesoft.statistics.api;

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
public final class AppWithCategoryAndType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f133568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f133569b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f133570c;

    public AppWithCategoryAndType(String packageName, String str, String str2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f133568a = packageName;
        this.f133569b = str;
        this.f133570c = str2;
    }

    public final String a() {
        return this.f133570c;
    }

    public final String b() {
        return this.f133569b;
    }

    public final String c() {
        return this.f133568a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppWithCategoryAndType)) {
            return false;
        }
        AppWithCategoryAndType appWithCategoryAndType = (AppWithCategoryAndType) obj;
        return Intrinsics.areEqual(this.f133568a, appWithCategoryAndType.f133568a) && Intrinsics.areEqual(this.f133569b, appWithCategoryAndType.f133569b) && Intrinsics.areEqual(this.f133570c, appWithCategoryAndType.f133570c);
    }

    public int hashCode() {
        int iHashCode = this.f133568a.hashCode() * 31;
        String str = this.f133569b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f133570c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "AppWithCategoryAndType(packageName=" + this.f133568a + ", category=" + this.f133569b + ", appType=" + this.f133570c + ")";
    }
}
