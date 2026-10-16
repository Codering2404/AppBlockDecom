package cz.mobilesoft.coreblock.activity.rating;

import cz.mobilesoft.coreblock.base.ViewState;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class RatingFlowState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f96136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f96137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f96138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f96139d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f96140f;

    public RatingFlowState(boolean z2, boolean z3, boolean z4, String str, String str2) {
        this.f96136a = z2;
        this.f96137b = z3;
        this.f96138c = z4;
        this.f96139d = str;
        this.f96140f = str2;
    }

    public static /* synthetic */ RatingFlowState b(RatingFlowState ratingFlowState, boolean z2, boolean z3, boolean z4, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = ratingFlowState.f96136a;
        }
        if ((i3 & 2) != 0) {
            z3 = ratingFlowState.f96137b;
        }
        if ((i3 & 4) != 0) {
            z4 = ratingFlowState.f96138c;
        }
        if ((i3 & 8) != 0) {
            str = ratingFlowState.f96139d;
        }
        if ((i3 & 16) != 0) {
            str2 = ratingFlowState.f96140f;
        }
        String str3 = str2;
        boolean z5 = z4;
        return ratingFlowState.a(z2, z3, z5, str, str3);
    }

    public final RatingFlowState a(boolean z2, boolean z3, boolean z4, String str, String str2) {
        return new RatingFlowState(z2, z3, z4, str, str2);
    }

    public final String c() {
        return this.f96140f;
    }

    public final String d() {
        return this.f96139d;
    }

    public final boolean e() {
        return this.f96137b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RatingFlowState)) {
            return false;
        }
        RatingFlowState ratingFlowState = (RatingFlowState) obj;
        return this.f96136a == ratingFlowState.f96136a && this.f96137b == ratingFlowState.f96137b && this.f96138c == ratingFlowState.f96138c && Intrinsics.areEqual(this.f96139d, ratingFlowState.f96139d) && Intrinsics.areEqual(this.f96140f, ratingFlowState.f96140f);
    }

    public final boolean f() {
        return this.f96138c;
    }

    public int hashCode() {
        int iHashCode = ((((Boolean.hashCode(this.f96136a) * 31) + Boolean.hashCode(this.f96137b)) * 31) + Boolean.hashCode(this.f96138c)) * 31;
        String str = this.f96139d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f96140f;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "RatingFlowState(showRatingFlow=" + this.f96136a + ", isContentReady=" + this.f96137b + ", isReviewInfoAvailable=" + this.f96138c + ", nowTimeFormated=" + this.f96139d + ", futureTimeFormated=" + this.f96140f + ")";
    }

    public /* synthetic */ RatingFlowState(boolean z2, boolean z3, boolean z4, String str, String str2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2, (i3 & 2) != 0 ? false : z3, (i3 & 4) != 0 ? false : z4, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? null : str2);
    }
}
