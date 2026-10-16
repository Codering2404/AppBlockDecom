package cz.mobilesoft.coreblock.scene.schedule.blockingmode;

import cz.mobilesoft.coreblock.base.ViewState;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
public final class BlockingModeSettingsViewState implements ViewState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f115078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f115079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f115080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Profile.BlockingMode f115081d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final PremiumState f115082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f115083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ProfileType f115084h;

    public BlockingModeSettingsViewState(List selectionList, boolean z2, boolean z3, Profile.BlockingMode blockingMode, PremiumState premiumState, boolean z4, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(selectionList, "selectionList");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        this.f115078a = selectionList;
        this.f115079b = z2;
        this.f115080c = z3;
        this.f115081d = blockingMode;
        this.f115082f = premiumState;
        this.f115083g = z4;
        this.f115084h = profileType;
    }

    public static /* synthetic */ BlockingModeSettingsViewState b(BlockingModeSettingsViewState blockingModeSettingsViewState, List list, boolean z2, boolean z3, Profile.BlockingMode blockingMode, PremiumState premiumState, boolean z4, ProfileType profileType, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            list = blockingModeSettingsViewState.f115078a;
        }
        if ((i3 & 2) != 0) {
            z2 = blockingModeSettingsViewState.f115079b;
        }
        if ((i3 & 4) != 0) {
            z3 = blockingModeSettingsViewState.f115080c;
        }
        if ((i3 & 8) != 0) {
            blockingMode = blockingModeSettingsViewState.f115081d;
        }
        if ((i3 & 16) != 0) {
            premiumState = blockingModeSettingsViewState.f115082f;
        }
        if ((i3 & 32) != 0) {
            z4 = blockingModeSettingsViewState.f115083g;
        }
        if ((i3 & 64) != 0) {
            profileType = blockingModeSettingsViewState.f115084h;
        }
        boolean z5 = z4;
        ProfileType profileType2 = profileType;
        PremiumState premiumState2 = premiumState;
        boolean z6 = z3;
        return blockingModeSettingsViewState.a(list, z2, z6, blockingMode, premiumState2, z5, profileType2);
    }

    public final BlockingModeSettingsViewState a(List selectionList, boolean z2, boolean z3, Profile.BlockingMode blockingMode, PremiumState premiumState, boolean z4, ProfileType profileType) {
        Intrinsics.checkNotNullParameter(selectionList, "selectionList");
        Intrinsics.checkNotNullParameter(blockingMode, "blockingMode");
        Intrinsics.checkNotNullParameter(premiumState, "premiumState");
        return new BlockingModeSettingsViewState(selectionList, z2, z3, blockingMode, premiumState, z4, profileType);
    }

    public final boolean c() {
        return this.f115083g;
    }

    public final boolean d() {
        return this.f115080c;
    }

    public final Profile.BlockingMode e() {
        return this.f115081d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BlockingModeSettingsViewState)) {
            return false;
        }
        BlockingModeSettingsViewState blockingModeSettingsViewState = (BlockingModeSettingsViewState) obj;
        return Intrinsics.areEqual(this.f115078a, blockingModeSettingsViewState.f115078a) && this.f115079b == blockingModeSettingsViewState.f115079b && this.f115080c == blockingModeSettingsViewState.f115080c && this.f115081d == blockingModeSettingsViewState.f115081d && Intrinsics.areEqual(this.f115082f, blockingModeSettingsViewState.f115082f) && this.f115083g == blockingModeSettingsViewState.f115083g && this.f115084h == blockingModeSettingsViewState.f115084h;
    }

    public final PremiumState f() {
        return this.f115082f;
    }

    public final ProfileType g() {
        return this.f115084h;
    }

    public final List h() {
        return this.f115078a;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.f115078a.hashCode() * 31) + Boolean.hashCode(this.f115079b)) * 31) + Boolean.hashCode(this.f115080c)) * 31) + this.f115081d.hashCode()) * 31) + this.f115082f.hashCode()) * 31) + Boolean.hashCode(this.f115083g)) * 31;
        ProfileType profileType = this.f115084h;
        return iHashCode + (profileType == null ? 0 : profileType.hashCode());
    }

    public final boolean i() {
        return this.f115079b;
    }

    public String toString() {
        return "BlockingModeSettingsViewState(selectionList=" + this.f115078a + ", isFirstViewShown=" + this.f115079b + ", animateSecondView=" + this.f115080c + ", blockingMode=" + this.f115081d + ", premiumState=" + this.f115082f + ", allowlistEnabled=" + this.f115083g + ", selectedProfileType=" + this.f115084h + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ BlockingModeSettingsViewState(List list, boolean z2, boolean z3, Profile.BlockingMode blockingMode, PremiumState premiumState, boolean z4, ProfileType profileType, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 1) != 0) {
            Boolean bool = Boolean.FALSE;
            list = CollectionsKt.listOf((Object[]) new Boolean[]{bool, bool, bool, bool, bool, bool, bool});
        }
        this(list, (i3 & 2) != 0 ? true : z2, (i3 & 4) != 0 ? false : z3, (i3 & 8) != 0 ? Profile.BlockingMode.Blocklist : blockingMode, (i3 & 16) != 0 ? PremiumState.None.INSTANCE : premiumState, (i3 & 32) != 0 ? true : z4, (i3 & 64) != 0 ? null : profileType);
    }
}
