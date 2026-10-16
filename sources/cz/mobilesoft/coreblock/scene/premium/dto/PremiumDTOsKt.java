package cz.mobilesoft.coreblock.scene.premium.dto;

import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import cz.mobilesoft.coreblock.enums.SubscriptionOfferId;
import java.util.Iterator;
import java.util.Map;
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
public final class PremiumDTOsKt {
    public static final GoogleSubscriptionOption a(GoogleStoreProduct googleStoreProduct, String str, boolean z2) {
        SubscriptionOption basePlan;
        SubscriptionOption next;
        SubscriptionOptions subscriptionOptions;
        SubscriptionOption next2;
        Intrinsics.checkNotNullParameter(googleStoreProduct, "<this>");
        if (str == null || (subscriptionOptions = googleStoreProduct.getSubscriptionOptions()) == null) {
            basePlan = null;
        } else {
            Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                SubscriptionOption subscriptionOption = next2;
                GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
                if (Intrinsics.areEqual(googleSubscriptionOption != null ? googleSubscriptionOption.getOfferId() : null, str)) {
                    break;
                }
            }
            basePlan = next2;
        }
        if (basePlan == null && z2) {
            SubscriptionOptions subscriptionOptions2 = googleStoreProduct.getSubscriptionOptions();
            if (subscriptionOptions2 != null) {
                Iterator<SubscriptionOption> it2 = subscriptionOptions2.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it2.next();
                    SubscriptionOption subscriptionOption2 = next;
                    GoogleSubscriptionOption googleSubscriptionOption2 = subscriptionOption2 instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption2 : null;
                    if (Intrinsics.areEqual(googleSubscriptionOption2 != null ? googleSubscriptionOption2.getOfferId() : null, SubscriptionOfferId.ID_TRIAL.getId())) {
                        break;
                    }
                }
                basePlan = next;
            } else {
                basePlan = null;
            }
        }
        if (basePlan == null) {
            SubscriptionOptions subscriptionOptions3 = googleStoreProduct.getSubscriptionOptions();
            basePlan = subscriptionOptions3 != null ? subscriptionOptions3.getBasePlan() : null;
        }
        if (basePlan instanceof GoogleSubscriptionOption) {
            return (GoogleSubscriptionOption) basePlan;
        }
        return null;
    }

    public static final double b(Price price) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        return price.getAmountMicros() / ((double) 1000000);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ed  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO c(com.revenuecat.purchases.models.GoogleStoreProduct r13, boolean r14, boolean r15, boolean r16, java.util.Map r17) {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.premium.dto.PremiumDTOsKt.c(com.revenuecat.purchases.models.GoogleStoreProduct, boolean, boolean, boolean, java.util.Map):cz.mobilesoft.coreblock.scene.premium.dto.PremiumOptionDTO");
    }

    public static /* synthetic */ PremiumOptionDTO d(GoogleStoreProduct googleStoreProduct, boolean z2, boolean z3, boolean z4, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = false;
        }
        if ((i3 & 2) != 0) {
            z3 = false;
        }
        if ((i3 & 4) != 0) {
            z4 = false;
        }
        return c(googleStoreProduct, z2, z3, z4, map);
    }
}
