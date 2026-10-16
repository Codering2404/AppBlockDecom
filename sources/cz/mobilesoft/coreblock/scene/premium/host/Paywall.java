package cz.mobilesoft.coreblock.scene.premium.host;

import android.content.Context;
import android.content.Intent;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
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
public final class Paywall {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Paywall f113165a = new Paywall();

    private Paywall() {
    }

    private final Class a(PaywallTarget paywallTarget) {
        return PaywallSpecTableKt.C(paywallTarget, null, 2, null).h() ? PaywallHostOwnTaskActivity.class : PaywallHostActivity.class;
    }

    public static /* synthetic */ Intent c(Paywall paywall, Context context, PaywallTarget paywallTarget, String str, String str2, boolean z2, boolean z3, boolean z4, Integer num, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            str2 = null;
        }
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        if ((i3 & 32) != 0) {
            z3 = true;
        }
        if ((i3 & 64) != 0) {
            z4 = false;
        }
        if ((i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
            num = null;
        }
        return paywall.b(context, paywallTarget, str, str2, z2, z3, z4, num);
    }

    public final Intent b(Context context, PaywallTarget target, String entrances, String str, boolean z2, boolean z3, boolean z4, Integer num) {
        String offeringFromDeeplink;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(entrances, "entrances");
        Intent intent = new Intent(context, (Class<?>) a(target));
        if (PaywallSpecTableKt.C(target, null, 2, null).h()) {
            intent.setFlags(268468224);
        }
        intent.putExtra("paywall_target", target);
        PaywallTarget.Discount discount = target instanceof PaywallTarget.Discount ? (PaywallTarget.Discount) target : null;
        if (discount != null && (offeringFromDeeplink = discount.getOfferingFromDeeplink()) != null) {
            intent.putExtra("OFFERING_FROM_DEEPLINK", offeringFromDeeplink);
        }
        intent.putExtra("EVENT_ENTRANCES", entrances);
        intent.putExtra("EVENT_ENTRANCES_DETAIL", str);
        intent.putExtra("IS_FIRST_START", z2);
        intent.putExtra("WITH_CLOSE_BUTTON", z3);
        intent.putExtra("paywall_with_skip_text", z4);
        if (num != null) {
            intent.putExtra("PROFILE_TYPE_COMBINATIONS", num.intValue());
        }
        return intent;
    }
}
