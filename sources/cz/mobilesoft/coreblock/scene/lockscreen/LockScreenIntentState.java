package cz.mobilesoft.coreblock.scene.lockscreen;

import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
public final class LockScreenIntentState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f105384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Long f105385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ProfileType f105386c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UsageLimit.PeriodType f105387d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f105388e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f105389f;

    public LockScreenIntentState(String str, Long l3, ProfileType profileType, UsageLimit.PeriodType periodType, String profileTitle, long j3) {
        Intrinsics.checkNotNullParameter(profileTitle, "profileTitle");
        this.f105384a = str;
        this.f105385b = l3;
        this.f105386c = profileType;
        this.f105387d = periodType;
        this.f105388e = profileTitle;
        this.f105389f = j3;
    }

    public final Long a() {
        return this.f105385b;
    }

    public final String b() {
        return this.f105384a;
    }

    public final String c() {
        return this.f105388e;
    }

    public final ProfileType d() {
        return this.f105386c;
    }

    public final UsageLimit.PeriodType e() {
        return this.f105387d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LockScreenIntentState)) {
            return false;
        }
        LockScreenIntentState lockScreenIntentState = (LockScreenIntentState) obj;
        return Intrinsics.areEqual(this.f105384a, lockScreenIntentState.f105384a) && Intrinsics.areEqual(this.f105385b, lockScreenIntentState.f105385b) && this.f105386c == lockScreenIntentState.f105386c && this.f105387d == lockScreenIntentState.f105387d && Intrinsics.areEqual(this.f105388e, lockScreenIntentState.f105388e) && this.f105389f == lockScreenIntentState.f105389f;
    }

    public int hashCode() {
        String str = this.f105384a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l3 = this.f105385b;
        int iHashCode2 = (iHashCode + (l3 == null ? 0 : l3.hashCode())) * 31;
        ProfileType profileType = this.f105386c;
        int iHashCode3 = (iHashCode2 + (profileType == null ? 0 : profileType.hashCode())) * 31;
        UsageLimit.PeriodType periodType = this.f105387d;
        return ((((iHashCode3 + (periodType != null ? periodType.hashCode() : 0)) * 31) + this.f105388e.hashCode()) * 31) + Long.hashCode(this.f105389f);
    }

    public String toString() {
        return "LockScreenIntentState(packageName=" + this.f105384a + ", blockUntil=" + this.f105385b + ", profileType=" + this.f105386c + ", usageLimitPeriodType=" + this.f105387d + ", profileTitle=" + this.f105388e + ", profileId=" + this.f105389f + ")";
    }

    public /* synthetic */ LockScreenIntentState(String str, Long l3, ProfileType profileType, UsageLimit.PeriodType periodType, String str2, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, l3, profileType, periodType, str2, (i3 & 32) != 0 ? -1L : j3);
    }
}
