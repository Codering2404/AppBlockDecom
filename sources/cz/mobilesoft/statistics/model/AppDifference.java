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
public final class AppDifference {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f133714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f133715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f133716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f133717d;

    public AppDifference(String packageName, long j3, long j4, long j5) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.f133714a = packageName;
        this.f133715b = j3;
        this.f133716c = j4;
        this.f133717d = j5;
    }

    public final long a() {
        return this.f133717d;
    }

    public final String b() {
        return this.f133714a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AppDifference)) {
            return false;
        }
        AppDifference appDifference = (AppDifference) obj;
        return Intrinsics.areEqual(this.f133714a, appDifference.f133714a) && this.f133715b == appDifference.f133715b && this.f133716c == appDifference.f133716c && this.f133717d == appDifference.f133717d;
    }

    public int hashCode() {
        return (((((this.f133714a.hashCode() * 31) + Long.hashCode(this.f133715b)) * 31) + Long.hashCode(this.f133716c)) * 31) + Long.hashCode(this.f133717d);
    }

    public String toString() {
        return "AppDifference(packageName=" + this.f133714a + ", usageFirstInterval=" + this.f133715b + ", usageSecondInterval=" + this.f133716c + ", difference=" + this.f133717d + ")";
    }
}
