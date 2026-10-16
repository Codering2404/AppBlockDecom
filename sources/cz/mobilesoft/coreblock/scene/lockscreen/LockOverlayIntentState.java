package cz.mobilesoft.coreblock.scene.lockscreen;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.enums.StrictModeOption;
import cz.mobilesoft.coreblock.storage.room.dto.blocking.ProfileWithConfiguration;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.UsageLimit;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class LockOverlayIntentState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f105374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final UrlDto f105375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Long f105376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UsageLimit.PeriodType f105377d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ProfileWithConfiguration f105378e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f105379f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final StrictModeOption f105380g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final boolean f105381h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f105382i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f105383j;

    public LockOverlayIntentState(String str, UrlDto urlDto, Long l3, UsageLimit.PeriodType periodType, ProfileWithConfiguration profileWithConfiguration, String str2, StrictModeOption strictModeOption, boolean z2, boolean z3, boolean z4) {
        this.f105374a = str;
        this.f105375b = urlDto;
        this.f105376c = l3;
        this.f105377d = periodType;
        this.f105378e = profileWithConfiguration;
        this.f105379f = str2;
        this.f105380g = strictModeOption;
        this.f105381h = z2;
        this.f105382i = z3;
        this.f105383j = z4;
    }

    public final Long a() {
        return this.f105376c;
    }

    public final String b() {
        return this.f105379f;
    }

    public final UrlDto c() {
        return this.f105375b;
    }

    public final String d() {
        return this.f105374a;
    }

    public final ProfileWithConfiguration e() {
        return this.f105378e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LockOverlayIntentState)) {
            return false;
        }
        LockOverlayIntentState lockOverlayIntentState = (LockOverlayIntentState) obj;
        return Intrinsics.areEqual(this.f105374a, lockOverlayIntentState.f105374a) && Intrinsics.areEqual(this.f105375b, lockOverlayIntentState.f105375b) && Intrinsics.areEqual(this.f105376c, lockOverlayIntentState.f105376c) && this.f105377d == lockOverlayIntentState.f105377d && Intrinsics.areEqual(this.f105378e, lockOverlayIntentState.f105378e) && Intrinsics.areEqual(this.f105379f, lockOverlayIntentState.f105379f) && this.f105380g == lockOverlayIntentState.f105380g && this.f105381h == lockOverlayIntentState.f105381h && this.f105382i == lockOverlayIntentState.f105382i && this.f105383j == lockOverlayIntentState.f105383j;
    }

    public final boolean f() {
        return this.f105382i;
    }

    public final StrictModeOption g() {
        return this.f105380g;
    }

    public final UsageLimit.PeriodType h() {
        return this.f105377d;
    }

    public int hashCode() {
        String str = this.f105374a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        UrlDto urlDto = this.f105375b;
        int iHashCode2 = (iHashCode + (urlDto == null ? 0 : urlDto.hashCode())) * 31;
        Long l3 = this.f105376c;
        int iHashCode3 = (iHashCode2 + (l3 == null ? 0 : l3.hashCode())) * 31;
        UsageLimit.PeriodType periodType = this.f105377d;
        int iHashCode4 = (iHashCode3 + (periodType == null ? 0 : periodType.hashCode())) * 31;
        ProfileWithConfiguration profileWithConfiguration = this.f105378e;
        int iHashCode5 = (iHashCode4 + (profileWithConfiguration == null ? 0 : profileWithConfiguration.hashCode())) * 31;
        String str2 = this.f105379f;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        StrictModeOption strictModeOption = this.f105380g;
        return ((((((iHashCode6 + (strictModeOption != null ? strictModeOption.hashCode() : 0)) * 31) + Boolean.hashCode(this.f105381h)) * 31) + Boolean.hashCode(this.f105382i)) * 31) + Boolean.hashCode(this.f105383j);
    }

    public final boolean i() {
        return this.f105383j;
    }

    public final boolean j() {
        return this.f105381h;
    }

    public String toString() {
        return "LockOverlayIntentState(packageName=" + this.f105374a + ", dto=" + this.f105375b + ", blockUntil=" + this.f105376c + ", usageLimitPeriodType=" + this.f105377d + ", profile=" + this.f105378e + ", blockingScreenCustomTitle=" + this.f105379f + ", strictModeOption=" + this.f105380g + ", isUnsupportedBrowser=" + this.f105381h + ", showUsageLimitRanOut=" + this.f105382i + ", isPopup=" + this.f105383j + ")";
    }
}
