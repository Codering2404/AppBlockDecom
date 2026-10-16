package cz.mobilesoft.coreblock.scene.dashboard.profile.type;

import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
public final class ProfileSectionItemType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProfileSectionItemType[] $VALUES;
    public static final ProfileSectionItemType AdsRelevance;
    public static final ProfileSectionItemType AppIcon;
    public static final ProfileSectionItemType BlockingPreferences;
    public static final ProfileSectionItemType CustomBlockingScreen;
    public static final ProfileSectionItemType DiscordCommunity;
    public static final ProfileSectionItemType GuestPass;
    public static final ProfileSectionItemType Help;
    public static final ProfileSectionItemType InviteFriend;
    public static final ProfileSectionItemType MacOsxApp;
    public static final ProfileSectionItemType MonthlyTrial;
    public static final ProfileSectionItemType MyPremium;
    public static final ProfileSectionItemType MyProductPlan;
    public static final ProfileSectionItemType MySubscription;
    public static final ProfileSectionItemType News;
    public static final ProfileSectionItemType Notifications;
    public static final ProfileSectionItemType RateUsOnGooglePlay;
    public static final ProfileSectionItemType RestorePurchase;
    public static final ProfileSectionItemType Statistics;
    public static final ProfileSectionItemType TimeNudge;
    public static final ProfileSectionItemType Troubleshooting;
    private final int iconResId;
    private final boolean isNew;
    private final int titleResId;
    public static final ProfileSectionItemType Account = new ProfileSectionItemType("Account", 0, R.drawable.O6, R.string.f95834q, false, 4, null);
    public static final ProfileSectionItemType GeneralSettings = new ProfileSectionItemType("GeneralSettings", 1, R.drawable.h5, R.string.Ee, false, 4, null);
    public static final ProfileSectionItemType Academy = new ProfileSectionItemType("Academy", 2, R.drawable.Y, R.string.wD, false, 4, null);
    public static final ProfileSectionItemType BlockedNotifications = new ProfileSectionItemType("BlockedNotifications", 3, R.drawable.U3, R.string.f95838r, false, 4, null);
    public static final ProfileSectionItemType Backup = new ProfileSectionItemType("Backup", 4, R.drawable.O0, R.string.yD, false, 4, null);
    public static final ProfileSectionItemType Premium = new ProfileSectionItemType("Premium", 5, R.drawable.t4, R.string.JD, false, 4, null);

    private static final /* synthetic */ ProfileSectionItemType[] $values() {
        return new ProfileSectionItemType[]{Account, GeneralSettings, Academy, BlockedNotifications, Backup, Premium, MyPremium, MySubscription, MyProductPlan, MonthlyTrial, Troubleshooting, Help, InviteFriend, News, MacOsxApp, DiscordCommunity, RestorePurchase, Notifications, TimeNudge, BlockingPreferences, Statistics, RateUsOnGooglePlay, AdsRelevance, CustomBlockingScreen, AppIcon, GuestPass};
    }

    static {
        int i3 = R.drawable.g6;
        MyPremium = new ProfileSectionItemType("MyPremium", 6, i3, R.string.uk, false, 4, null);
        int i4 = R.string.vk;
        int i5 = 4;
        DefaultConstructorMarker defaultConstructorMarker = null;
        boolean z2 = false;
        MySubscription = new ProfileSectionItemType("MySubscription", 7, i3, i4, z2, i5, defaultConstructorMarker);
        MyProductPlan = new ProfileSectionItemType("MyProductPlan", 8, i3, i4, z2, i5, defaultConstructorMarker);
        MonthlyTrial = new ProfileSectionItemType("MonthlyTrial", 9, i3, i4, z2, i5, defaultConstructorMarker);
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        Troubleshooting = new ProfileSectionItemType("Troubleshooting", 10, R.drawable.F6, R.string.GE, false, 4, defaultConstructorMarker2);
        Help = new ProfileSectionItemType("Help", 11, R.drawable.H2, R.string.CD, false, 4, null);
        int i6 = R.drawable.P2;
        InviteFriend = new ProfileSectionItemType("InviteFriend", 12, i6, R.string.Zh, false, 4, null);
        News = new ProfileSectionItemType("News", 13, R.drawable.W6, R.string.gH, false, 4, null);
        MacOsxApp = new ProfileSectionItemType("MacOsxApp", 14, R.drawable.P1, R.string.A1, false, 4, null);
        DiscordCommunity = new ProfileSectionItemType("DiscordCommunity", 15, R.drawable.S1, R.string.rc, false, 4, null);
        RestorePurchase = new ProfileSectionItemType("RestorePurchase", 16, R.drawable.M4, R.string.Uo, false, 4, defaultConstructorMarker2);
        Notifications = new ProfileSectionItemType("Notifications", 17, R.drawable.Q0, R.string.GD, false, 4, null);
        TimeNudge = new ProfileSectionItemType("TimeNudge", 18, R.drawable.o6, R.string.pD, false, 4, null);
        BlockingPreferences = new ProfileSectionItemType("BlockingPreferences", 19, R.drawable.W, R.string.ow, false, 4, null);
        Statistics = new ProfileSectionItemType("Statistics", 20, R.drawable.H5, R.string.OD, false, 4, null);
        RateUsOnGooglePlay = new ProfileSectionItemType("RateUsOnGooglePlay", 21, R.drawable.K8, R.string.Br, false, 4, null);
        AdsRelevance = new ProfileSectionItemType("AdsRelevance", 22, R.drawable.a5, R.string.Bo, false, 4, null);
        CustomBlockingScreen = new ProfileSectionItemType("CustomBlockingScreen", 23, R.drawable.b5, R.string.E3, false, 4, null);
        AppIcon = new ProfileSectionItemType("AppIcon", 24, R.drawable.A0, R.string.f95776c1, false, 4, null);
        GuestPass = new ProfileSectionItemType("GuestPass", 25, i6, R.string.Ye, false, 4, null);
        ProfileSectionItemType[] profileSectionItemTypeArr$values = $values();
        $VALUES = profileSectionItemTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(profileSectionItemTypeArr$values);
    }

    private ProfileSectionItemType(String str, int i3, int i4, int i5, boolean z2) {
        this.iconResId = i4;
        this.titleResId = i5;
        this.isNew = z2;
    }

    public static EnumEntries<ProfileSectionItemType> getEntries() {
        return $ENTRIES;
    }

    public static ProfileSectionItemType valueOf(String str) {
        return (ProfileSectionItemType) Enum.valueOf(ProfileSectionItemType.class, str);
    }

    public static ProfileSectionItemType[] values() {
        return (ProfileSectionItemType[]) $VALUES.clone();
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getTitleResId() {
        return this.titleResId;
    }

    public final boolean isNew() {
        return this.isNew;
    }

    /* synthetic */ ProfileSectionItemType(String str, int i3, int i4, int i5, boolean z2, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, i5, (i6 & 4) != 0 ? false : z2);
    }
}
