package androidx.privacysandbox.ads.adservices.adselection;

import android.net.Uri;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import cz.mobilesoft.coreblock.view.screen.ohO.MHoiDDglUlPJC;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class AdSelectionOutcome {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Companion f51151c = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AdSelectionOutcome f51152d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f51153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Uri f51154b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes3.dex */
    @ExperimentalFeatures.Ext10OptIn
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Uri EMPTY = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(EMPTY, "EMPTY");
        f51152d = new AdSelectionOutcome(0L, EMPTY);
    }

    public AdSelectionOutcome(long j3, Uri uri) {
        Intrinsics.checkNotNullParameter(uri, MHoiDDglUlPJC.SJIchIZvC);
        this.f51153a = j3;
        this.f51154b = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) obj;
        return this.f51153a == adSelectionOutcome.f51153a && Intrinsics.areEqual(this.f51154b, adSelectionOutcome.f51154b);
    }

    public int hashCode() {
        return (Long.hashCode(this.f51153a) * 31) + this.f51154b.hashCode();
    }

    public String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.f51153a + ", renderUri=" + this.f51154b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AdSelectionOutcome(android.adservices.adselection.AdSelectionOutcome response) {
        Intrinsics.checkNotNullParameter(response, "response");
        long adSelectionId = response.getAdSelectionId();
        Uri renderUri = response.getRenderUri();
        Intrinsics.checkNotNullExpressionValue(renderUri, "response.renderUri");
        this(adSelectionId, renderUri);
    }
}
