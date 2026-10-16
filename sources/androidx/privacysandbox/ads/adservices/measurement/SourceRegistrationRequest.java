package androidx.privacysandbox.ads.adservices.measurement;

import android.view.InputEvent;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@ExperimentalFeatures.RegisterSourceOptIn
public final class SourceRegistrationRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f51335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InputEvent f51336b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    public final InputEvent a() {
        return this.f51336b;
    }

    public final List b() {
        return this.f51335a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SourceRegistrationRequest)) {
            return false;
        }
        SourceRegistrationRequest sourceRegistrationRequest = (SourceRegistrationRequest) obj;
        return Intrinsics.areEqual(this.f51335a, sourceRegistrationRequest.f51335a) && Intrinsics.areEqual(this.f51336b, sourceRegistrationRequest.f51336b);
    }

    public int hashCode() {
        int iHashCode = this.f51335a.hashCode();
        InputEvent inputEvent = this.f51336b;
        return inputEvent != null ? (iHashCode * 31) + inputEvent.hashCode() : iHashCode;
    }

    public String toString() {
        return "AppSourcesRegistrationRequest { " + ("RegistrationUris=[" + this.f51335a + "], InputEvent=" + this.f51336b) + " }";
    }
}
