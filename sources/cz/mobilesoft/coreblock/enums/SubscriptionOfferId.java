package cz.mobilesoft.coreblock.enums;

import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
@Metadata
public final class SubscriptionOfferId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SubscriptionOfferId[] $VALUES;
    public static final Companion Companion;
    public static final SubscriptionOfferId ID_30_REFERRAL;
    public static final SubscriptionOfferId ID_BASE;
    public static final SubscriptionOfferId ID_INTRO;
    public static final String ID_PREFIX = "id-";
    public static final SubscriptionOfferId ID_TRIAL;
    public static final SubscriptionOfferId ID_TRIAL_MANUAL;
    private static final Lazy<List<SubscriptionOfferId>> discountOffers$delegate;
    private final String id;
    private final boolean isDiscount;
    private final boolean isPromo;
    public static final SubscriptionOfferId ID_20_LIMIT = new SubscriptionOfferId("ID_20_LIMIT", 3, "id-20-limit", true, false, 4, null);
    public static final SubscriptionOfferId ID_50_LIMIT = new SubscriptionOfferId("ID_50_LIMIT", 4, "id-50-limit", true, false, 4, null);
    public static final SubscriptionOfferId ID_50_BLOCK = new SubscriptionOfferId("ID_50_BLOCK", 5, "id-50-block", true, false, 4, null);
    public static final SubscriptionOfferId ID_50_EXSUB = new SubscriptionOfferId("ID_50_EXSUB", 6, "id-50-exsub", true, false, 4, null);
    public static final SubscriptionOfferId ID_50_ONETIME = new SubscriptionOfferId("ID_50_ONETIME", 7, "id-50-onetime", true, false, 4, null);
    public static final SubscriptionOfferId ID_50_CAMPAIGN = new SubscriptionOfferId("ID_50_CAMPAIGN", 8, "id-50-campaign", true, false, 4, null);
    public static final SubscriptionOfferId ID_30_PROMO = new SubscriptionOfferId("ID_30_PROMO", 9, "id-30-promo", true, true);
    public static final SubscriptionOfferId ID_50_PROMO = new SubscriptionOfferId("ID_50_PROMO", 10, "id-50-promo", true, true);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ SubscriptionOfferId[] $values() {
        return new SubscriptionOfferId[]{ID_BASE, ID_TRIAL, ID_INTRO, ID_20_LIMIT, ID_50_LIMIT, ID_50_BLOCK, ID_50_EXSUB, ID_50_ONETIME, ID_50_CAMPAIGN, ID_30_PROMO, ID_50_PROMO, ID_30_REFERRAL, ID_TRIAL_MANUAL};
    }

    static {
        boolean z2 = false;
        ID_BASE = new SubscriptionOfferId("ID_BASE", 0, "id-base", false, z2, 6, null);
        boolean z3 = false;
        ID_TRIAL = new SubscriptionOfferId("ID_TRIAL", 1, "id-trial", z2, z3, 6, null);
        ID_INTRO = new SubscriptionOfferId("ID_INTRO", 2, "introprice", z3, false, 6, null);
        boolean z4 = false;
        ID_30_REFERRAL = new SubscriptionOfferId("ID_30_REFERRAL", 11, "id-30-referral", true, z4, 4, null);
        ID_TRIAL_MANUAL = new SubscriptionOfferId("ID_TRIAL_MANUAL", 12, "id-trial-manual", z4, false, 6, null);
        SubscriptionOfferId[] subscriptionOfferIdArr$values = $values();
        $VALUES = subscriptionOfferIdArr$values;
        $ENTRIES = EnumEntriesKt.a(subscriptionOfferIdArr$values);
        Companion = new Companion(null);
        discountOffers$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SubscriptionOfferId.discountOffers_delegate$lambda$0();
            }
        });
    }

    private SubscriptionOfferId(String str, int i3, String str2, boolean z2, boolean z3) {
        this.id = str2;
        this.isDiscount = z2;
        this.isPromo = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List discountOffers_delegate$lambda$0() {
        SubscriptionOfferId[] subscriptionOfferIdArrValues = values();
        ArrayList arrayList = new ArrayList();
        for (SubscriptionOfferId subscriptionOfferId : subscriptionOfferIdArrValues) {
            if (subscriptionOfferId.isDiscount) {
                arrayList.add(subscriptionOfferId);
            }
        }
        return arrayList;
    }

    public static EnumEntries<SubscriptionOfferId> getEntries() {
        return $ENTRIES;
    }

    public static SubscriptionOfferId valueOf(String str) {
        return (SubscriptionOfferId) Enum.valueOf(SubscriptionOfferId.class, str);
    }

    public static SubscriptionOfferId[] values() {
        return (SubscriptionOfferId[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }

    public final boolean isDiscount() {
        return this.isDiscount;
    }

    public final boolean isPromo() {
        return this.isPromo;
    }

    /* synthetic */ SubscriptionOfferId(String str, int i3, String str2, boolean z2, boolean z3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, (i4 & 2) != 0 ? false : z2, (i4 & 4) != 0 ? false : z3);
    }
}
