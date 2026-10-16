package cz.mobilesoft.coreblock.scene.premium.host;

import android.os.Bundle;
import com.facebook.appevents.integrity.IntegrityManager;
import cz.mobilesoft.coreblock.storage.datastore.entity.OnboardingPaywallVariant;
import cz.mobilesoft.coreblock.util.monetization.PaywallEngine;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PaywallSpecKt {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113350a;

        static {
            int[] iArr = new int[OnboardingPaywallVariant.values().length];
            try {
                iArr[OnboardingPaywallVariant.RevenueCat.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OnboardingPaywallVariant.Native.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OnboardingPaywallVariant.Superwall.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f113350a = iArr;
        }
    }

    public static final PaywallEngine a(OnboardingPaywallVariant variant) {
        Intrinsics.checkNotNullParameter(variant, "variant");
        int i3 = WhenMappings.f113350a[variant.ordinal()];
        if (i3 == 1) {
            return PaywallEngine.RcHosted;
        }
        if (i3 == 2 || i3 == 3) {
            return PaywallEngine.Native;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Bundle b(PaywallAnalytics paywallAnalytics, String entrances, String str) {
        Intrinsics.checkNotNullParameter(paywallAnalytics, "<this>");
        Intrinsics.checkNotNullParameter(entrances, "entrances");
        if (paywallAnalytics.e() && paywallAnalytics.c() == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("entrances", entrances);
        String strC = paywallAnalytics.c();
        if (strC != null) {
            str = strC;
        }
        bundle.putString("entrances_detail", str);
        bundle.putString("type", paywallAnalytics.f());
        bundle.putString("premium_screen_type", paywallAnalytics.d());
        Long lB = paywallAnalytics.b();
        if (lB != null) {
            bundle.putLong("campaign_value", lB.longValue());
        } else {
            bundle.putString("campaign_value", IntegrityManager.INTEGRITY_TYPE_NONE);
        }
        bundle.putBoolean("is_campaign_active", paywallAnalytics.b() != null);
        return bundle;
    }
}
