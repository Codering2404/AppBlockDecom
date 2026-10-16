package cz.mobilesoft.coreblock.repository;

import io.reactivex.internal.operators.mixed.yrog.FptyjHFU;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

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
public final class PremiumRepositoryV2Kt {
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean b(com.revenuecat.purchases.CustomerInfo r9, cz.mobilesoft.coreblock.enums.PremiumState r10, boolean r11, boolean r12, boolean r13) {
        /*
            java.lang.String r0 = "premiumState"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1
            r1 = 0
            if (r9 == 0) goto L16
            com.revenuecat.purchases.EntitlementInfo r2 = cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt.c(r9)
            if (r2 == 0) goto L16
            boolean r2 = r2.getWillRenew()
            if (r2 != r0) goto L16
            return r1
        L16:
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r2 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r2 = r2.f()
            r4 = 0
            r5 = 7
            if (r13 == 0) goto L2d
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.DAYS
            long r7 = r13.toMillis(r5)
            long r7 = r7 + r2
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            goto L45
        L2d:
            if (r9 == 0) goto L44
            com.revenuecat.purchases.EntitlementInfo r13 = cz.mobilesoft.coreblock.util.subscription.RevenueCatExtKt.a(r9)
            if (r13 == 0) goto L44
            java.util.Date r13 = r13.getExpirationDate()
            if (r13 == 0) goto L44
            long r7 = r13.getTime()
            java.lang.Long r13 = java.lang.Long.valueOf(r7)
            goto L45
        L44:
            r13 = r4
        L45:
            if (r9 == 0) goto L4b
            com.revenuecat.purchases.EntitlementInfo r4 = cz.mobilesoft.coreblock.util.helperextension.RevenueCatExtKt.e(r9)
        L4b:
            if (r4 == 0) goto L50
            r5 = 3
            goto L59
        L50:
            boolean r10 = r10.e()
            if (r10 == 0) goto L57
            goto L59
        L57:
            r5 = 14
        L59:
            if (r13 == 0) goto L79
            long r9 = r13.longValue()
            int r13 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r13 >= 0) goto L65
        L63:
            r9 = r1
            goto Lb7
        L65:
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.DAYS
            long r4 = r10.toMillis(r5)
            long r2 = r2 + r4
            java.lang.Long r10 = java.lang.Long.valueOf(r2)
            boolean r9 = cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt.e(r9, r10)
            goto Lb7
        L79:
            if (r9 == 0) goto L63
            com.revenuecat.purchases.EntitlementInfos r9 = r9.getEntitlements()
            if (r9 == 0) goto L63
            java.util.Map r9 = r9.getAll()
            if (r9 == 0) goto L63
            cz.mobilesoft.coreblock.enums.Entitlement r10 = cz.mobilesoft.coreblock.enums.Entitlement.Premium
            java.lang.String r10 = r10.getId()
            java.lang.Object r9 = r9.get(r10)
            com.revenuecat.purchases.EntitlementInfo r9 = (com.revenuecat.purchases.EntitlementInfo) r9
            if (r9 == 0) goto L63
            java.util.Date r9 = r9.getExpirationDate()
            if (r9 == 0) goto L63
            long r9 = r9.getTime()
            java.lang.Long r9 = java.lang.Long.valueOf(r9)
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.DAYS
            r4 = 30
            long r4 = r10.toMillis(r4)
            long r2 = r2 - r4
            java.lang.Long r10 = java.lang.Long.valueOf(r2)
            boolean r9 = cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt.c(r9, r10)
            if (r9 != r0) goto L63
            r9 = r0
        Lb7:
            if (r9 != 0) goto Lba
            return r1
        Lba:
            if (r11 == 0) goto Lbd
            return r12
        Lbd:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.repository.PremiumRepositoryV2Kt.b(com.revenuecat.purchases.CustomerInfo, cz.mobilesoft.coreblock.enums.PremiumState, boolean, boolean, boolean):boolean");
    }

    public static final Flow a(Flow customerInfoFlow, Flow flow, Flow showPremiumExpiringCardFlow, Flow showDevPremiumExpiringCardsFlow, Flow showDevPremiumExpiringFlow, boolean z2) {
        Intrinsics.checkNotNullParameter(customerInfoFlow, "customerInfoFlow");
        Intrinsics.checkNotNullParameter(flow, FptyjHFU.twGkvkUFO);
        Intrinsics.checkNotNullParameter(showPremiumExpiringCardFlow, "showPremiumExpiringCardFlow");
        Intrinsics.checkNotNullParameter(showDevPremiumExpiringCardsFlow, "showDevPremiumExpiringCardsFlow");
        Intrinsics.checkNotNullParameter(showDevPremiumExpiringFlow, "showDevPremiumExpiringFlow");
        return FlowKt.p(customerInfoFlow, flow, FlowKt.h(showPremiumExpiringCardFlow, new PremiumRepositoryV2Kt$premiumExpiringCardFlow$1(null)), showDevPremiumExpiringCardsFlow, showDevPremiumExpiringFlow, new PremiumRepositoryV2Kt$premiumExpiringCardFlow$2(z2, null));
    }
}
