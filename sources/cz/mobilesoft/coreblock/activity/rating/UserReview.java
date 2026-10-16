package cz.mobilesoft.coreblock.activity.rating;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
final class UserReview {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f96184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f96185b;

    public UserReview(int i3, String userNamer) {
        Intrinsics.checkNotNullParameter(userNamer, "userNamer");
        this.f96184a = i3;
        this.f96185b = userNamer;
    }

    public final int a() {
        return this.f96184a;
    }

    public final String b() {
        return this.f96185b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UserReview)) {
            return false;
        }
        UserReview userReview = (UserReview) obj;
        return this.f96184a == userReview.f96184a && Intrinsics.areEqual(this.f96185b, userReview.f96185b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f96184a) * 31) + this.f96185b.hashCode();
    }

    public String toString() {
        return "UserReview(textRes=" + this.f96184a + ", userNamer=" + this.f96185b + ")";
    }
}
