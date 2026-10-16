package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
@Metadata
public final class RevenueCatOffering {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RevenueCatOffering[] $VALUES;
    public static final Companion Companion;
    private static final Lazy<List<RevenueCatOffering>> discountedOfferings$delegate;
    private final boolean isDiscount;
    private final String offeringId;
    public static final RevenueCatOffering PaywallTest = new RevenueCatOffering("PaywallTest", 0, "paywall_test", false, 2, null);
    public static final RevenueCatOffering Default = new RevenueCatOffering("Default", 1, "default_offer", false, 2, null);
    public static final RevenueCatOffering TrialToggle = new RevenueCatOffering("TrialToggle", 2, "trial_toggle", false, 2, null);
    public static final RevenueCatOffering Campaign = new RevenueCatOffering("Campaign", 3, "campaign_offer", true);
    public static final RevenueCatOffering ExSub = new RevenueCatOffering("ExSub", 4, "ex_subscribers_discount_offer", true);
    public static final RevenueCatOffering FirstDiscount = new RevenueCatOffering("FirstDiscount", 5, "first_discount_offer", true);
    public static final RevenueCatOffering SecondDiscount = new RevenueCatOffering("SecondDiscount", 6, "second_discount_offer", true);
    public static final RevenueCatOffering ThirdDiscount = new RevenueCatOffering("ThirdDiscount", 7, "third_discount_offer", true);
    public static final RevenueCatOffering PriceIncrease = new RevenueCatOffering("PriceIncrease", 8, "price_increase", true);
    public static final RevenueCatOffering ExitPaywall = new RevenueCatOffering("ExitPaywall", 9, "exit_paywall_offer", true);
    public static final RevenueCatOffering TrialRetention = new RevenueCatOffering("TrialRetention", 10, "trial_retention_offer", true);
    public static final RevenueCatOffering OnetimeToSub = new RevenueCatOffering("OnetimeToSub", 11, "onetime_to_sub_offer", true);
    public static final RevenueCatOffering Referral = new RevenueCatOffering("Referral", 12, "third_discount_offer", true);
    public static final RevenueCatOffering GuestPass = new RevenueCatOffering("GuestPass", 13, "guest_pass_offer", false, 2, null);
    public static final RevenueCatOffering PromoTrialUpgrade = new RevenueCatOffering("PromoTrialUpgrade", 14, "promo_trial_upgrade_offer", true);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RevenueCatOffering a(String str) {
            RevenueCatOffering next;
            Iterator<RevenueCatOffering> it = RevenueCatOffering.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getOfferingId(), str)) {
                    break;
                }
            }
            return next;
        }

        public final List b() {
            return (List) RevenueCatOffering.discountedOfferings$delegate.getValue();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Converter implements PrefConverter<RevenueCatOffering, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Converter f97038a = new Converter();

        private Converter() {
        }

        public RevenueCatOffering a(String str) {
            return RevenueCatOffering.Companion.a(str);
        }

        @Override // cz.mobilesoft.coreblock.storage.sharedprefs.PrefConverter
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String getId(RevenueCatOffering revenueCatOffering) {
            if (revenueCatOffering != null) {
                return revenueCatOffering.name();
            }
            return null;
        }
    }

    private static final /* synthetic */ RevenueCatOffering[] $values() {
        return new RevenueCatOffering[]{PaywallTest, Default, TrialToggle, Campaign, ExSub, FirstDiscount, SecondDiscount, ThirdDiscount, PriceIncrease, ExitPaywall, TrialRetention, OnetimeToSub, Referral, GuestPass, PromoTrialUpgrade};
    }

    static {
        RevenueCatOffering[] revenueCatOfferingArr$values = $values();
        $VALUES = revenueCatOfferingArr$values;
        $ENTRIES = EnumEntriesKt.a(revenueCatOfferingArr$values);
        Companion = new Companion(null);
        discountedOfferings$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.h0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return RevenueCatOffering.discountedOfferings_delegate$lambda$0();
            }
        });
    }

    private RevenueCatOffering(String str, int i3, String str2, boolean z2) {
        this.offeringId = str2;
        this.isDiscount = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List discountedOfferings_delegate$lambda$0() {
        EnumEntries<RevenueCatOffering> entries = getEntries();
        ArrayList arrayList = new ArrayList();
        for (RevenueCatOffering revenueCatOffering : entries) {
            if (revenueCatOffering.isDiscount) {
                arrayList.add(revenueCatOffering);
            }
        }
        return arrayList;
    }

    public static EnumEntries<RevenueCatOffering> getEntries() {
        return $ENTRIES;
    }

    public static RevenueCatOffering valueOf(String str) {
        return (RevenueCatOffering) Enum.valueOf(RevenueCatOffering.class, str);
    }

    public static RevenueCatOffering[] values() {
        return (RevenueCatOffering[]) $VALUES.clone();
    }

    public final String getOfferingId() {
        return this.offeringId;
    }

    public final boolean isDiscount() {
        return this.isDiscount;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + "(" + this.offeringId + ")";
    }

    /* synthetic */ RevenueCatOffering(String str, int i3, String str2, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, (i4 & 2) != 0 ? false : z2);
    }
}
