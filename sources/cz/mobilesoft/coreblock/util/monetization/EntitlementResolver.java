package cz.mobilesoft.coreblock.util.monetization;

import cz.mobilesoft.coreblock.enums.Entitlement;
import cz.mobilesoft.coreblock.enums.PremiumState;
import cz.mobilesoft.coreblock.enums.Product;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
public final class EntitlementResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EntitlementResolver f128866a = new EntitlementResolver();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f128867a;

        static {
            int[] iArr = new int[Product.SubscriptionPeriod.values().length];
            try {
                iArr[Product.SubscriptionPeriod.LIFETIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Product.SubscriptionPeriod.MONTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Product.SubscriptionPeriod.YEAR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f128867a = iArr;
        }
    }

    private EntitlementResolver() {
    }

    private final PremiumState c(PremiumEntitlement premiumEntitlement) {
        if (!premiumEntitlement.c()) {
            return new PremiumState.Subscription.External(premiumEntitlement.b());
        }
        Product productA = Product.Companion.a(premiumEntitlement.a());
        Product.SubscriptionPeriod subscriptionPeriod = productA != null ? productA.getSubscriptionPeriod() : null;
        int i3 = subscriptionPeriod == null ? -1 : WhenMappings.f128867a[subscriptionPeriod.ordinal()];
        return i3 != 1 ? i3 != 2 ? i3 != 3 ? a(premiumEntitlement.a()) : PremiumState.Subscription.Yearly.INSTANCE : PremiumState.Subscription.Monthly.INSTANCE : PremiumState.Lifetime.INSTANCE;
    }

    public final PremiumState a(String productId) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        String lowerCase = productId.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return StringsKt.a0(lowerCase, "year", false, 2, null) ? PremiumState.Subscription.Yearly.INSTANCE : StringsKt.a0(lowerCase, "month", false, 2, null) ? PremiumState.Subscription.Monthly.INSTANCE : PremiumState.Lifetime.INSTANCE;
    }

    public final PremiumState b(EntitlementSnapshot snapshot, PremiumState premiumState) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        if (premiumState != null) {
            return premiumState;
        }
        PremiumEntitlement premiumEntitlementB = snapshot.b();
        if (premiumEntitlementB != null) {
            return f128866a.c(premiumEntitlementB);
        }
        if (snapshot.a().contains(Entitlement.OldOnetime)) {
            return PremiumState.OldFull.INSTANCE;
        }
        Set setC = Product.Companion.c();
        ArrayList arrayList = new ArrayList();
        for (Object obj : setC) {
            if (snapshot.a().contains(((Product) obj).getEntitlement())) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return PremiumState.None.INSTANCE;
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            arrayList2.add(((Product) obj2).getProductId());
        }
        return new PremiumState.OldPartial(arrayList2);
    }
}
