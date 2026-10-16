package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class WebTriggerRegistrationRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f51349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f51350b;

    public final android.adservices.measurement.WebTriggerRegistrationRequest a() {
        i0.a();
        android.adservices.measurement.WebTriggerRegistrationRequest webTriggerRegistrationRequestBuild = h0.a(WebTriggerParams.f51346c.a(this.f51349a), this.f51350b).build();
        Intrinsics.checkNotNullExpressionValue(webTriggerRegistrationRequestBuild, "Builder(\n               …   )\n            .build()");
        return webTriggerRegistrationRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebTriggerRegistrationRequest)) {
            return false;
        }
        WebTriggerRegistrationRequest webTriggerRegistrationRequest = (WebTriggerRegistrationRequest) obj;
        return Intrinsics.areEqual(this.f51349a, webTriggerRegistrationRequest.f51349a) && Intrinsics.areEqual(this.f51350b, webTriggerRegistrationRequest.f51350b);
    }

    public int hashCode() {
        return (this.f51349a.hashCode() * 31) + this.f51350b.hashCode();
    }

    public String toString() {
        return "WebTriggerRegistrationRequest { WebTriggerParams=" + this.f51349a + ", Destination=" + this.f51350b;
    }
}
