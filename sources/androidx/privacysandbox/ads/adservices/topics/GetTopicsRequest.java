package androidx.privacysandbox.ads.adservices.topics;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class GetTopicsRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f51357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f51358b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f51359a = "";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f51360b = true;

        public final GetTopicsRequest a() {
            return new GetTopicsRequest(this.f51359a, this.f51360b);
        }

        public final Builder b(String adsSdkName) {
            Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
            if (adsSdkName.length() <= 0) {
                throw new IllegalStateException("adsSdkName must be set");
            }
            this.f51359a = adsSdkName;
            return this;
        }

        public final Builder c(boolean z2) {
            this.f51360b = z2;
            return this;
        }
    }

    public GetTopicsRequest(String adsSdkName, boolean z2) {
        Intrinsics.checkNotNullParameter(adsSdkName, "adsSdkName");
        this.f51357a = adsSdkName;
        this.f51358b = z2;
    }

    public final String a() {
        return this.f51357a;
    }

    public final boolean b() {
        return this.f51358b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        return Intrinsics.areEqual(this.f51357a, getTopicsRequest.f51357a) && this.f51358b == getTopicsRequest.f51358b;
    }

    public int hashCode() {
        return (this.f51357a.hashCode() * 31) + Boolean.hashCode(this.f51358b);
    }

    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.f51357a + ", shouldRecordObservation=" + this.f51358b;
    }
}
