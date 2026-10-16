package cz.mobilesoft.coreblock.scene.more.referral;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ReferralViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Integer f108000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Boolean f108001b;

    public ReferralViewState(Integer num, Boolean bool) {
        this.f108000a = num;
        this.f108001b = bool;
    }

    public static /* synthetic */ ReferralViewState b(ReferralViewState referralViewState, Integer num, Boolean bool, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            num = referralViewState.f108000a;
        }
        if ((i3 & 2) != 0) {
            bool = referralViewState.f108001b;
        }
        return referralViewState.a(num, bool);
    }

    public final ReferralViewState a(Integer num, Boolean bool) {
        return new ReferralViewState(num, bool);
    }

    public final Integer c() {
        return this.f108000a;
    }

    public final Boolean d() {
        return this.f108001b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReferralViewState)) {
            return false;
        }
        ReferralViewState referralViewState = (ReferralViewState) obj;
        return Intrinsics.areEqual(this.f108000a, referralViewState.f108000a) && Intrinsics.areEqual(this.f108001b, referralViewState.f108001b);
    }

    public int hashCode() {
        Integer num = this.f108000a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Boolean bool = this.f108001b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "ReferralViewState(discountPercent=" + this.f108000a + ", isSubscriptionUser=" + this.f108001b + ")";
    }

    public /* synthetic */ ReferralViewState(Integer num, Boolean bool, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : num, (i3 & 2) != 0 ? null : bool);
    }
}
