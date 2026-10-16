package androidx.privacysandbox.ads.adservices.customaudience;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.AdSelectionSignals;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import java.time.Instant;
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
public final class CustomAudience {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AdTechIdentifier f51208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f51209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Uri f51210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Uri f51211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f51212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Instant f51213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Instant f51214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AdSelectionSignals f51215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final TrustedBiddingData f51216i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {
    }

    public final Instant a() {
        return this.f51213f;
    }

    public final List b() {
        return this.f51212e;
    }

    public final Uri c() {
        return this.f51211d;
    }

    public final AdTechIdentifier d() {
        return this.f51208a;
    }

    public final Uri e() {
        return this.f51210c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomAudience)) {
            return false;
        }
        CustomAudience customAudience = (CustomAudience) obj;
        return Intrinsics.areEqual(this.f51208a, customAudience.f51208a) && Intrinsics.areEqual(this.f51209b, customAudience.f51209b) && Intrinsics.areEqual(this.f51213f, customAudience.f51213f) && Intrinsics.areEqual(this.f51214g, customAudience.f51214g) && Intrinsics.areEqual(this.f51210c, customAudience.f51210c) && Intrinsics.areEqual(this.f51215h, customAudience.f51215h) && Intrinsics.areEqual(this.f51216i, customAudience.f51216i) && Intrinsics.areEqual(this.f51212e, customAudience.f51212e);
    }

    public final Instant f() {
        return this.f51214g;
    }

    public final String g() {
        return this.f51209b;
    }

    public final TrustedBiddingData h() {
        return this.f51216i;
    }

    public int hashCode() {
        int iHashCode = ((this.f51208a.hashCode() * 31) + this.f51209b.hashCode()) * 31;
        Instant instant = this.f51213f;
        int iHashCode2 = (iHashCode + (instant != null ? instant.hashCode() : 0)) * 31;
        Instant instant2 = this.f51214g;
        int iHashCode3 = (((iHashCode2 + (instant2 != null ? instant2.hashCode() : 0)) * 31) + this.f51210c.hashCode()) * 31;
        AdSelectionSignals adSelectionSignals = this.f51215h;
        int iHashCode4 = (iHashCode3 + (adSelectionSignals != null ? adSelectionSignals.hashCode() : 0)) * 31;
        TrustedBiddingData trustedBiddingData = this.f51216i;
        return ((((iHashCode4 + (trustedBiddingData != null ? trustedBiddingData.hashCode() : 0)) * 31) + this.f51211d.hashCode()) * 31) + this.f51212e.hashCode();
    }

    public final AdSelectionSignals i() {
        return this.f51215h;
    }

    public String toString() {
        return "CustomAudience: buyer=" + this.f51211d + ", name=" + this.f51209b + ", activationTime=" + this.f51213f + ", expirationTime=" + this.f51214g + ", dailyUpdateUri=" + this.f51210c + ", userBiddingSignals=" + this.f51215h + ", trustedBiddingSignals=" + this.f51216i + ", biddingLogicUri=" + this.f51211d + ", ads=" + this.f51212e;
    }
}
