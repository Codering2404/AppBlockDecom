package androidx.privacysandbox.ads.adservices.measurement;

import android.net.Uri;
import android.view.InputEvent;
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
public final class WebSourceRegistrationRequest {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f51340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f51341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final InputEvent f51342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Uri f51343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Uri f51344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Uri f51345f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    public final android.adservices.measurement.WebSourceRegistrationRequest a() {
        b0.a();
        android.adservices.measurement.WebSourceRegistrationRequest webSourceRegistrationRequestBuild = a0.a(WebSourceParams.f51337c.a(this.f51340a), this.f51341b).setWebDestination(this.f51344e).setAppDestination(this.f51343d).setInputEvent(this.f51342c).setVerifiedDestination(this.f51345f).build();
        Intrinsics.checkNotNullExpressionValue(webSourceRegistrationRequestBuild, "Builder(\n               …ion)\n            .build()");
        return webSourceRegistrationRequestBuild;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSourceRegistrationRequest)) {
            return false;
        }
        WebSourceRegistrationRequest webSourceRegistrationRequest = (WebSourceRegistrationRequest) obj;
        return Intrinsics.areEqual(this.f51340a, webSourceRegistrationRequest.f51340a) && Intrinsics.areEqual(this.f51344e, webSourceRegistrationRequest.f51344e) && Intrinsics.areEqual(this.f51343d, webSourceRegistrationRequest.f51343d) && Intrinsics.areEqual(this.f51341b, webSourceRegistrationRequest.f51341b) && Intrinsics.areEqual(this.f51342c, webSourceRegistrationRequest.f51342c) && Intrinsics.areEqual(this.f51345f, webSourceRegistrationRequest.f51345f);
    }

    public int hashCode() {
        int iHashCode = (this.f51340a.hashCode() * 31) + this.f51341b.hashCode();
        InputEvent inputEvent = this.f51342c;
        if (inputEvent != null) {
            iHashCode = (iHashCode * 31) + inputEvent.hashCode();
        }
        Uri uri = this.f51343d;
        if (uri != null) {
            iHashCode = (iHashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.f51344e;
        if (uri2 != null) {
            iHashCode = (iHashCode * 31) + uri2.hashCode();
        }
        int iHashCode2 = (iHashCode * 31) + this.f51341b.hashCode();
        InputEvent inputEvent2 = this.f51342c;
        if (inputEvent2 != null) {
            iHashCode2 = (iHashCode2 * 31) + inputEvent2.hashCode();
        }
        Uri uri3 = this.f51345f;
        return uri3 != null ? (iHashCode2 * 31) + uri3.hashCode() : iHashCode2;
    }

    public String toString() {
        return "WebSourceRegistrationRequest { " + ("WebSourceParams=[" + this.f51340a + "], TopOriginUri=" + this.f51341b + ", InputEvent=" + this.f51342c + ", AppDestination=" + this.f51343d + ", WebDestination=" + this.f51344e + ", VerifiedDestination=" + this.f51345f) + " }";
    }
}
