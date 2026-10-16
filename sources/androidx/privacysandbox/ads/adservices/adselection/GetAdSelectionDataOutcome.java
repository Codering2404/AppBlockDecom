package androidx.privacysandbox.ads.adservices.adselection;

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
public final class GetAdSelectionDataOutcome {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f51155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f51156b;

    public GetAdSelectionDataOutcome(long j3, byte[] bArr) {
        this.f51155a = j3;
        this.f51156b = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataOutcome)) {
            return false;
        }
        GetAdSelectionDataOutcome getAdSelectionDataOutcome = (GetAdSelectionDataOutcome) obj;
        return this.f51155a == getAdSelectionDataOutcome.f51155a && Arrays.equals(this.f51156b, getAdSelectionDataOutcome.f51156b);
    }

    public int hashCode() {
        int iHashCode = Long.hashCode(this.f51155a) * 31;
        byte[] bArr = this.f51156b;
        return iHashCode + (bArr != null ? bArr.hashCode() : 0);
    }

    public String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.f51155a + ", adSelectionData=" + this.f51156b;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GetAdSelectionDataOutcome(android.adservices.adselection.GetAdSelectionDataOutcome response) {
        this(response.getAdSelectionId(), response.getAdSelectionData());
        Intrinsics.checkNotNullParameter(response, "response");
    }
}
