package androidx.privacysandbox.ads.adservices.customaudience;

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
public final class TrustedBiddingData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f51229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f51230b;

    public final List a() {
        return this.f51230b;
    }

    public final Uri b() {
        return this.f51229a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrustedBiddingData)) {
            return false;
        }
        TrustedBiddingData trustedBiddingData = (TrustedBiddingData) obj;
        return Intrinsics.areEqual(this.f51229a, trustedBiddingData.f51229a) && Intrinsics.areEqual(this.f51230b, trustedBiddingData.f51230b);
    }

    public int hashCode() {
        return (this.f51229a.hashCode() * 31) + this.f51230b.hashCode();
    }

    public String toString() {
        return "TrustedBiddingData: trustedBiddingUri=" + this.f51229a + " trustedBiddingKeys=" + this.f51230b;
    }
}
