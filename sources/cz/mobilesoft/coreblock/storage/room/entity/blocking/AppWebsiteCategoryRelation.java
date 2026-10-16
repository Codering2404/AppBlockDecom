package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import cz.mobilesoft.coreblock.enums.Category;
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
public final class AppWebsiteCategoryRelation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f126382a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f126383b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Category f126384c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f126385d;

    public AppWebsiteCategoryRelation(String packageName, String str, Category category, boolean z2) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(category, "category");
        this.f126382a = packageName;
        this.f126383b = str;
        this.f126384c = category;
        this.f126385d = z2;
    }

    public final Category a() {
        return this.f126384c;
    }

    public final String b() {
        return this.f126383b;
    }

    public final String c() {
        return this.f126382a;
    }

    public final boolean d() {
        return this.f126385d;
    }

    public final void e(String str) {
        this.f126383b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppWebsiteCategoryRelation)) {
            return false;
        }
        AppWebsiteCategoryRelation appWebsiteCategoryRelation = (AppWebsiteCategoryRelation) obj;
        return Intrinsics.areEqual(this.f126382a, appWebsiteCategoryRelation.f126382a) && Intrinsics.areEqual(this.f126383b, appWebsiteCategoryRelation.f126383b) && this.f126384c == appWebsiteCategoryRelation.f126384c && this.f126385d == appWebsiteCategoryRelation.f126385d;
    }

    public int hashCode() {
        int iHashCode = this.f126382a.hashCode() * 31;
        String str = this.f126383b;
        return ((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f126384c.hashCode()) * 31) + Boolean.hashCode(this.f126385d);
    }

    public String toString() {
        return "AppWebsiteCategoryRelation(packageName=" + this.f126382a + ", hostname=" + this.f126383b + ", category=" + this.f126384c + ", isPreset=" + this.f126385d + ")";
    }
}
