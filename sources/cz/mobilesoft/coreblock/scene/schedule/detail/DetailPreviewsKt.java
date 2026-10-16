package cz.mobilesoft.coreblock.scene.schedule.detail;

import com.facebook.FacebookSdk;
import cz.mobilesoft.coreblock.dto.Category;
import cz.mobilesoft.coreblock.enums.Permission;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.ProfileType;
import cz.mobilesoft.coreblock.enums.ScheduleEmoji;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import cz.mobilesoft.coreblock.util.Success;
import cz.mobilesoft.coreblock.util.permissions.PermissionDTO;
import kotlin.Metadata;
import kotlinx.collections.immutable.ExtensionsKt;
import kotlinx.collections.immutable.PersistentList;

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
public final class DetailPreviewsKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final PersistentList f116543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final PersistentList f116544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final PersistentList f116545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ScheduleViewState f116546d;

    static {
        Category category = Category.NEWS;
        f116543a = ExtensionsKt.b(new App("com.airbnb.android", "Airbnb", ExtensionsKt.b(category)), new App("com.facebook.katana", "Facebook", ExtensionsKt.b(category)), new App("com.imgur.mobile", "Imgur", ExtensionsKt.b(category)), new App("com.netflix.mediaclient", "Netflix", ExtensionsKt.b(category)), new App("com.ninegag.android.app", "9gag", ExtensionsKt.b(category)), new App("com.slack", "Slack", ExtensionsKt.b(category)), new App("com.waze", "Waze", ExtensionsKt.b(category)), new App("com.whatsapp", "Whatsapp", ExtensionsKt.b(category)), new App("cz.alza.eshop", "Alza", ExtensionsKt.b(category)));
        f116544b = ExtensionsKt.b(new WebOrKeyword(FacebookSdk.FACEBOOK_COM), new WebOrKeyword(FacebookSdk.INSTAGRAM_COM), new WebOrKeyword("imgur.com"), new WebOrKeyword("appblock.app"), new WebOrKeyword("seznam.cz"), new WebOrKeyword("pornhub.com"));
        f116545c = ExtensionsKt.b(new WebOrKeyword("bbc"), new WebOrKeyword("cnn"), new WebOrKeyword("fox"));
        f116546d = new ScheduleViewState(new ScheduleViewState.DetailViewState(Success.f128020a, null, "Create", false, false, ExtensionsKt.b(new Condition(ProfileType.TIME, "Weekend", "10:00 - 12:00", false, false, false, 56, null)), null, null, false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, ScheduleEmoji.Bat, null, 50331610, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, 65534, null);
    }

    public static final ScheduleViewState a() {
        return f116546d;
    }

    public static final ScheduleViewState b() {
        return new ScheduleViewState(new ScheduleViewState.DetailViewState(Success.f128020a, null, "Save", false, false, ExtensionsKt.b(new Condition(ProfileType.TIME, "Weekend", "10:00 - 12:00", false, false, false, 56, null), new Condition(ProfileType.LOCATION, "Hradec Králové", "Veverkova 1343", false, false, false, 56, null)), null, new Blocking(null, null, false, f116543a, f116544b, null, f116545c, null, 167, null), false, null, new MissingPermissions(ExtensionsKt.b(new PermissionDTO(Permission.LOCATION.f96999d, false, false, 6, null), new PermissionDTO(Permission.SYSTEM_OVERLAY.f97003d, false, false, 6, null)), false, 2, null), null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67107674, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, 65534, null);
    }

    public static final ScheduleViewState c() {
        return new ScheduleViewState(new ScheduleViewState.DetailViewState(Success.f128020a, null, "Save", false, true, null, null, new Blocking(Profile.BlockingMode.Blocklist, null, false, f116543a, f116544b, null, f116545c, null, 166, null), false, null, null, null, null, false, false, null, false, false, false, false, false, false, false, null, null, null, 67108714, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, PremiumState.Subscription.Yearly.INSTANCE, 65534, null);
    }
}
