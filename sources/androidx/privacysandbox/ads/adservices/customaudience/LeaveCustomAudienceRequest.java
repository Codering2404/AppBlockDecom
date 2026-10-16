package androidx.privacysandbox.ads.adservices.customaudience;

import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
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
public final class LeaveCustomAudienceRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdTechIdentifier f51227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f51228b;

    public final AdTechIdentifier a() {
        return this.f51227a;
    }

    public final String b() {
        return this.f51228b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LeaveCustomAudienceRequest)) {
            return false;
        }
        LeaveCustomAudienceRequest leaveCustomAudienceRequest = (LeaveCustomAudienceRequest) obj;
        return Intrinsics.areEqual(this.f51227a, leaveCustomAudienceRequest.f51227a) && Intrinsics.areEqual(this.f51228b, leaveCustomAudienceRequest.f51228b);
    }

    public int hashCode() {
        return (this.f51227a.hashCode() * 31) + this.f51228b.hashCode();
    }

    public String toString() {
        return "LeaveCustomAudience: buyer=" + this.f51227a + ", name=" + this.f51228b;
    }
}
