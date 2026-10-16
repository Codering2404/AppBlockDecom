package cz.mobilesoft.coreblock.storage.room.dto.blocking;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
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
public final class ProfileWithIntervals {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Profile f126379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f126380b;

    public ProfileWithIntervals(Profile profile, List intervals) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(intervals, "intervals");
        this.f126379a = profile;
        this.f126380b = intervals;
    }

    public final List a() {
        return this.f126380b;
    }

    public final Profile b() {
        return this.f126379a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileWithIntervals)) {
            return false;
        }
        ProfileWithIntervals profileWithIntervals = (ProfileWithIntervals) obj;
        return Intrinsics.areEqual(this.f126379a, profileWithIntervals.f126379a) && Intrinsics.areEqual(this.f126380b, profileWithIntervals.f126380b);
    }

    public int hashCode() {
        return (this.f126379a.hashCode() * 31) + this.f126380b.hashCode();
    }

    public String toString() {
        return "ProfileWithIntervals(profile=" + this.f126379a + ", intervals=" + this.f126380b + ")";
    }
}
