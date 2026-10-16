package cz.mobilesoft.coreblock.util.helperextension;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.Package;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import cz.mobilesoft.coreblock.enums.Entitlement;
import cz.mobilesoft.coreblock.enums.SubscriptionOfferId;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
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
public final class RevenueCatExtKt {
    public static final List a(CustomerInfo customerInfo) {
        EntitlementInfo entitlementInfo;
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        EnumEntries<Entitlement> entries = Entitlement.getEntries();
        ArrayList arrayList = new ArrayList();
        for (Entitlement entitlement : entries) {
            Entitlement entitlement2 = entitlement;
            if (customerInfo.getEntitlements().getAll().keySet().contains(entitlement2.getId()) && (entitlementInfo = customerInfo.getEntitlements().getAll().get(entitlement2.getId())) != null && entitlementInfo.isActive()) {
                Date expirationDate = entitlementInfo.getExpirationDate();
                if (expirationDate != null) {
                    if (TimeHelperExt.f128663a.z(expirationDate.getTime())) {
                    }
                }
                arrayList.add(entitlement);
            }
        }
        return arrayList;
    }

    public static final boolean b(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        return a(customerInfo).contains(Entitlement.FreeMonthPremium) && !a(customerInfo).contains(Entitlement.Premium);
    }

    public static final EntitlementInfo c(CustomerInfo customerInfo) {
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        List listA = a(customerInfo);
        Entitlement entitlement = Entitlement.Premium;
        if (listA.contains(entitlement)) {
            return customerInfo.getEntitlements().getAll().get(entitlement.getId());
        }
        List listA2 = a(customerInfo);
        Entitlement entitlement2 = Entitlement.FreeMonthPremium;
        if (listA2.contains(entitlement2)) {
            return customerInfo.getEntitlements().getAll().get(entitlement2.getId());
        }
        return null;
    }

    public static final boolean d(CustomerInfo customerInfo) {
        Date unsubscribeDetectedAt;
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        EntitlementInfo entitlementInfoC = c(customerInfo);
        if (entitlementInfoC == null || (unsubscribeDetectedAt = entitlementInfoC.getUnsubscribeDetectedAt()) == null) {
            return false;
        }
        return !TimeHelperExt.f128663a.z(unsubscribeDetectedAt.getTime());
    }

    public static final EntitlementInfo e(CustomerInfo customerInfo) {
        Object next;
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        Iterator<T> it = customerInfo.getEntitlements().getAll().values().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((EntitlementInfo) next).getPeriodType() == PeriodType.TRIAL) {
                break;
            }
        }
        return (EntitlementInfo) next;
    }

    public static final boolean f(Collection collection) {
        SubscriptionOptions subscriptionOptions;
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return false;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            StoreProduct product = ((Package) it.next()).getProduct();
            GoogleStoreProduct googleStoreProduct = product instanceof GoogleStoreProduct ? (GoogleStoreProduct) product : null;
            if (googleStoreProduct != null && (subscriptionOptions = googleStoreProduct.getSubscriptionOptions()) != null && !subscriptionOptions.isEmpty()) {
                for (SubscriptionOption subscriptionOption : subscriptionOptions) {
                    GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
                    if (Intrinsics.areEqual(googleSubscriptionOption != null ? googleSubscriptionOption.getOfferId() : null, SubscriptionOfferId.ID_TRIAL.getId())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
