package cz.mobilesoft.coreblock.util.subscription;

import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.EntitlementInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
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
public final class RevenueCatExtKt {
    public static final EntitlementInfo a(CustomerInfo customerInfo) {
        Object next;
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet = customerInfo.getEntitlements().getActive().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (((EntitlementInfo) ((Map.Entry) obj).getValue()).isActive()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Date originalPurchaseDate = ((EntitlementInfo) ((Map.Entry) next).getValue()).getOriginalPurchaseDate();
                do {
                    Object next2 = it.next();
                    Date originalPurchaseDate2 = ((EntitlementInfo) ((Map.Entry) next2).getValue()).getOriginalPurchaseDate();
                    if (originalPurchaseDate.compareTo(originalPurchaseDate2) < 0) {
                        next = next2;
                        originalPurchaseDate = originalPurchaseDate2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (EntitlementInfo) entry.getValue();
        }
        return null;
    }

    public static final String b(CustomerInfo customerInfo) {
        Object next;
        EntitlementInfo entitlementInfo;
        Intrinsics.checkNotNullParameter(customerInfo, "<this>");
        Set<Map.Entry<String, EntitlementInfo>> setEntrySet = customerInfo.getEntitlements().getActive().entrySet();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setEntrySet) {
            if (((EntitlementInfo) ((Map.Entry) obj).getValue()).isActive()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                Date originalPurchaseDate = ((EntitlementInfo) ((Map.Entry) next).getValue()).getOriginalPurchaseDate();
                do {
                    Object next2 = it.next();
                    Date originalPurchaseDate2 = ((EntitlementInfo) ((Map.Entry) next2).getValue()).getOriginalPurchaseDate();
                    if (originalPurchaseDate.compareTo(originalPurchaseDate2) < 0) {
                        next = next2;
                        originalPurchaseDate = originalPurchaseDate2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry == null || (entitlementInfo = (EntitlementInfo) entry.getValue()) == null) {
            return null;
        }
        return entitlementInfo.getProductIdentifier();
    }
}
