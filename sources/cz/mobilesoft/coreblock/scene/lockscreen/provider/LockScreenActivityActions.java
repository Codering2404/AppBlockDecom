package cz.mobilesoft.coreblock.scene.lockscreen.provider;

import android.content.Context;
import android.content.Intent;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.enums.SettingsScreenType;
import cz.mobilesoft.coreblock.scene.inappupdate.InAppUpdateActivity;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity;
import cz.mobilesoft.coreblock.scene.more.customBlockScreen.CustomBlockScreenActivity;
import cz.mobilesoft.coreblock.scene.more.settings.SettingsActivity;
import cz.mobilesoft.coreblock.scene.premium.dto.CampaignSource;
import cz.mobilesoft.coreblock.scene.premium.enums.DiscountSource;
import cz.mobilesoft.coreblock.scene.premium.host.Paywall;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.CrashHelper;
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
public final class LockScreenActivityActions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LockScreenActivityActions f105773a = new LockScreenActivityActions();

    private LockScreenActivityActions() {
    }

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intentB = SettingsActivity.Companion.b(SettingsActivity.f108043h, context, SettingsScreenType.BLOCKING_PREFERENCES, false, 4, null);
            intentB.setFlags(268468224);
            context.startActivity(intentB);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    public final void b(Context context, long j3, CampaignSource campaignSource, String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(campaignSource, "campaignSource");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            Intent intentC = Paywall.c(Paywall.f113165a, context, new PaywallTarget.Campaign(j3, campaignSource, source), "lock_screen", "lock_screen", false, false, false, null, 240, null);
            intentC.setFlags(268468224);
            context.startActivity(intentC);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intent = new Intent(context, (Class<?>) CustomBlockScreenActivity.class);
            intent.setFlags(268468224);
            context.startActivity(intent);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    public final void d(Context context, String source) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(source, "source");
        try {
            Intent intentA = InAppUpdateActivity.f102432h.a(context, source);
            intentA.setFlags(268468224);
            context.startActivity(intentA);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    public final void e(Context context, Class adClazz) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adClazz, "adClazz");
        try {
            Intent intent = new Intent(context, (Class<?>) adClazz);
            intent.setFlags(268468224);
            context.startActivity(intent);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    public final void f(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Intent intentB = IntroScheduleActivity.Companion.b(IntroScheduleActivity.f104813g, context, false, 2, null);
            intentB.setFlags(268468224);
            context.startActivity(intentB);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    public final void g(Context context, RevenueCatPlacement revenueCatPlacement, DiscountSource discountSource) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.startActivity(Paywall.c(Paywall.f113165a, context, new PaywallTarget.Discount(revenueCatPlacement, discountSource, false, null), "lock_screen", null, false, false, false, null, 248, null));
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }
}
