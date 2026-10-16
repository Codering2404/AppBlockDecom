package cz.mobilesoft.coreblock.enums;

import com.facebook.FacebookSdk;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
public final class SocialMedia {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SocialMedia[] $VALUES;
    private final String analyticsID;
    private final int iconRes;
    private final int outlinedIconRes;
    private final int titleRes;
    private final String url;
    public static final SocialMedia Instagram = new SocialMedia("Instagram", 0, R.drawable.O2, R.drawable.Y3, R.string.nf, "https://www.instagram.com/appblock.app/", FacebookSdk.INSTAGRAM);
    public static final SocialMedia Facebook = new SocialMedia("Facebook", 1, R.drawable.r2, R.drawable.X3, R.string.lf, "https://www.facebook.com/AppBlockStayFocused", "fb");
    public static final SocialMedia YouTube = new SocialMedia("YouTube", 2, R.drawable.Z6, R.drawable.b4, R.string.rf, "https://www.youtube.com/@appblockapp/subscribe", "youtube");
    public static final SocialMedia TikTok = new SocialMedia("TikTok", 3, R.drawable.l6, R.drawable.Z3, R.string.pf, "https://www.tiktok.com/@appblock.app", "tiktok");
    public static final SocialMedia Twitter = new SocialMedia("Twitter", 4, R.drawable.G6, R.drawable.a4, R.string.qf, "https://twitter.com/appblock_app", "twitter");
    public static final SocialMedia Discord = new SocialMedia("Discord", 5, R.drawable.S1, R.drawable.W3, R.string.rc, "https://discord.gg/5yTsfjFqGp", "discord");

    private static final /* synthetic */ SocialMedia[] $values() {
        return new SocialMedia[]{Instagram, Facebook, YouTube, TikTok, Twitter, Discord};
    }

    static {
        SocialMedia[] socialMediaArr$values = $values();
        $VALUES = socialMediaArr$values;
        $ENTRIES = EnumEntriesKt.a(socialMediaArr$values);
    }

    private SocialMedia(String str, int i3, int i4, int i5, int i6, String str2, String str3) {
        this.iconRes = i4;
        this.outlinedIconRes = i5;
        this.titleRes = i6;
        this.url = str2;
        this.analyticsID = str3;
    }

    public static EnumEntries<SocialMedia> getEntries() {
        return $ENTRIES;
    }

    public static SocialMedia valueOf(String str) {
        return (SocialMedia) Enum.valueOf(SocialMedia.class, str);
    }

    public static SocialMedia[] values() {
        return (SocialMedia[]) $VALUES.clone();
    }

    public final String getAnalyticsID() {
        return this.analyticsID;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getOutlinedIconRes() {
        return this.outlinedIconRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final String getUrl() {
        return this.url;
    }
}
