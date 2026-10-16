package androidx.privacysandbox.ads.adservices.adid;

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
public final class AdId {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f51106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f51107b;

    public AdId(String adId, boolean z2) {
        Intrinsics.checkNotNullParameter(adId, "adId");
        this.f51106a = adId;
        this.f51107b = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdId)) {
            return false;
        }
        AdId adId = (AdId) obj;
        return Intrinsics.areEqual(this.f51106a, adId.f51106a) && this.f51107b == adId.f51107b;
    }

    public int hashCode() {
        return (this.f51106a.hashCode() * 31) + Boolean.hashCode(this.f51107b);
    }

    public String toString() {
        return "AdId: adId=" + this.f51106a + ", isLimitAdTrackingEnabled=" + this.f51107b;
    }
}
