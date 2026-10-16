package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
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
@ExperimentalFeatures.Ext10OptIn
@Metadata
public final class PersistAdSelectionResultRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f51161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AdTechIdentifier f51162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f51163c;

    public final android.adservices.adselection.PersistAdSelectionResultRequest a() {
        PersistAdSelectionResultRequest.Builder adSelectionId = m0.a().setAdSelectionId(this.f51161a);
        AdTechIdentifier adTechIdentifier = this.f51162b;
        android.adservices.adselection.PersistAdSelectionResultRequest persistAdSelectionResultRequestBuild = adSelectionId.setSeller(adTechIdentifier != null ? adTechIdentifier.a() : null).setAdSelectionResult(this.f51163c).build();
        Intrinsics.checkNotNullExpressionValue(persistAdSelectionResultRequestBuild, "Builder()\n            .s…ult)\n            .build()");
        return persistAdSelectionResultRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) obj;
        return this.f51161a == persistAdSelectionResultRequest.f51161a && Intrinsics.areEqual(this.f51162b, persistAdSelectionResultRequest.f51162b) && Arrays.equals(this.f51163c, persistAdSelectionResultRequest.f51163c);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f51161a) * 31;
        AdTechIdentifier adTechIdentifier = this.f51162b;
        int iHashCode2 = (iHashCode + (adTechIdentifier != null ? adTechIdentifier.hashCode() : 0)) * 31;
        byte[] bArr = this.f51163c;
        return iHashCode2 + (bArr != null ? bArr.hashCode() : 0);
    }

    public String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=" + this.f51161a + ", seller=" + this.f51162b + ", adSelectionResult=" + this.f51163c;
    }
}
