package cz.mobilesoft.coreblock.scene.premium.host;

import android.app.Application;
import cz.mobilesoft.coreblock.enums.RevenueCatPlacement;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel;
import cz.mobilesoft.coreblock.scene.premium.host.PaywallTarget;
import cz.mobilesoft.coreblock.util.notifications.NotificationHelper;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
public final class DiscountPaywallViewModel extends PaywallHostViewModel {
    private RevenueCatPlacement Z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscountPaywallViewModel(Application application, PaywallTarget target, PaywallSpec spec, PaywallHostViewModel.Launch launch) {
        super(application, target, spec, launch);
        Intrinsics.checkNotNullParameter(application, "application");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(spec, "spec");
        Intrinsics.checkNotNullParameter(launch, "launch");
        if (K2()) {
            return;
        }
        start();
    }

    private final boolean K2() {
        PaywallTarget paywallTargetH2 = H2();
        PaywallTarget.Discount discount = paywallTargetH2 instanceof PaywallTarget.Discount ? (PaywallTarget.Discount) paywallTargetH2 : null;
        return discount != null && discount.isFromDeeplink();
    }

    public final void L2(String str) {
        RevenueCatPlacement revenueCatPlacementA = RevenueCatPlacement.Companion.a(str);
        if (revenueCatPlacementA != null) {
            this.Z = revenueCatPlacementA;
            NotificationHelper.f128940a.g(A0());
            if (K2()) {
                start();
            } else {
                f2();
            }
        }
    }

    @Override // cz.mobilesoft.coreblock.scene.premium.host.PaywallHostViewModel, cz.mobilesoft.coreblock.scene.premium.PremiumScreenViewModel
    public Object h2(Continuation continuation) {
        RevenueCatPlacement revenueCatPlacement = this.Z;
        return revenueCatPlacement == null ? G2().n() : revenueCatPlacement;
    }
}
