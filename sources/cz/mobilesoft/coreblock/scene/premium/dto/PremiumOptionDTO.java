package cz.mobilesoft.coreblock.scene.premium.dto;

import android.content.Context;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.models.GoogleSubscriptionOption;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.PricingPhase;
import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.premium.enums.PremiumOptionPeriod;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumOptionDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final PremiumOptionPeriod f113057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f113058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f113059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f113060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f113061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f113062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f113063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Integer f113064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final GoogleSubscriptionOption f113065i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f113066a;

        static {
            int[] iArr = new int[Period.Unit.values().length];
            try {
                iArr[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Period.Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Period.Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f113066a = iArr;
        }
    }

    public PremiumOptionDTO(PremiumOptionPeriod premiumOptionPeriod, boolean z2, String productId, String str, String basePriceText, String str2, String str3, Integer num, GoogleSubscriptionOption googleSubscriptionOption) {
        Intrinsics.checkNotNullParameter(premiumOptionPeriod, "premiumOptionPeriod");
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(basePriceText, "basePriceText");
        this.f113057a = premiumOptionPeriod;
        this.f113058b = z2;
        this.f113059c = productId;
        this.f113060d = str;
        this.f113061e = basePriceText;
        this.f113062f = str2;
        this.f113063g = str3;
        this.f113064h = num;
        this.f113065i = googleSubscriptionOption;
    }

    public final String a() {
        return this.f113061e;
    }

    public final Integer b() {
        return this.f113064h;
    }

    public final String c() {
        Integer num = this.f113064h;
        if (num == null) {
            return null;
        }
        return num.intValue() + " %";
    }

    public final String d() {
        return this.f113063g;
    }

    public final String e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PremiumOptionPeriod premiumOptionPeriod = this.f113057a;
        if (premiumOptionPeriod == PremiumOptionPeriod.Lifetime) {
            return null;
        }
        if (premiumOptionPeriod == PremiumOptionPeriod.Monthly) {
            return context.getString(R.string.fC);
        }
        String str = this.f113063g;
        if (str != null) {
            return context.getString(R.string.eC, str, 12, this.f113061e);
        }
        String str2 = this.f113060d;
        return str2 != null ? context.getString(R.string.dC, str2, this.f113061e) : context.getString(R.string.fC);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PremiumOptionDTO)) {
            return false;
        }
        PremiumOptionDTO premiumOptionDTO = (PremiumOptionDTO) obj;
        return this.f113057a == premiumOptionDTO.f113057a && this.f113058b == premiumOptionDTO.f113058b && Intrinsics.areEqual(this.f113059c, premiumOptionDTO.f113059c) && Intrinsics.areEqual(this.f113060d, premiumOptionDTO.f113060d) && Intrinsics.areEqual(this.f113061e, premiumOptionDTO.f113061e) && Intrinsics.areEqual(this.f113062f, premiumOptionDTO.f113062f) && Intrinsics.areEqual(this.f113063g, premiumOptionDTO.f113063g) && Intrinsics.areEqual(this.f113064h, premiumOptionDTO.f113064h) && Intrinsics.areEqual(this.f113065i, premiumOptionDTO.f113065i);
    }

    public final String f() {
        String offerId;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f113059c);
        GoogleSubscriptionOption googleSubscriptionOption = this.f113065i;
        if (googleSubscriptionOption != null && (offerId = googleSubscriptionOption.getOfferId()) != null) {
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
            sb.append(offerId);
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "with(...)");
        return string;
    }

    public final boolean g() {
        GoogleSubscriptionOption googleSubscriptionOption = this.f113065i;
        return (googleSubscriptionOption != null ? googleSubscriptionOption.getIntroPhase() : null) != null;
    }

    public final boolean h() {
        GoogleSubscriptionOption googleSubscriptionOption = this.f113065i;
        return (googleSubscriptionOption != null ? googleSubscriptionOption.getFreePhase() : null) != null;
    }

    public int hashCode() {
        int iHashCode = ((((this.f113057a.hashCode() * 31) + Boolean.hashCode(this.f113058b)) * 31) + this.f113059c.hashCode()) * 31;
        String str = this.f113060d;
        int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f113061e.hashCode()) * 31;
        String str2 = this.f113062f;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f113063g;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.f113064h;
        int iHashCode5 = (iHashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        GoogleSubscriptionOption googleSubscriptionOption = this.f113065i;
        return iHashCode5 + (googleSubscriptionOption != null ? googleSubscriptionOption.hashCode() : 0);
    }

    public final String i() {
        return this.f113062f;
    }

    public final PremiumOptionPeriod j() {
        return this.f113057a;
    }

    public final String k() {
        return this.f113059c;
    }

    public final GoogleSubscriptionOption l() {
        return this.f113065i;
    }

    public final int m() {
        PricingPhase freePhase;
        Period billingPeriod;
        GoogleSubscriptionOption googleSubscriptionOption = this.f113065i;
        if (googleSubscriptionOption == null || (freePhase = googleSubscriptionOption.getFreePhase()) == null || (billingPeriod = freePhase.getBillingPeriod()) == null) {
            return 7;
        }
        int i3 = WhenMappings.f113066a[billingPeriod.getUnit().ordinal()];
        if (i3 == 1) {
            return billingPeriod.getValue();
        }
        if (i3 == 2) {
            return billingPeriod.getValue() * 7;
        }
        if (i3 == 3) {
            return billingPeriod.getValue() * 30;
        }
        if (i3 != 4) {
            return 7;
        }
        return billingPeriod.getValue() * 365;
    }

    public final String n() {
        return this.f113060d;
    }

    public final boolean o() {
        return this.f113058b;
    }

    public String toString() {
        return "PremiumOptionDTO(premiumOptionPeriod=" + this.f113057a + ", isCurrentlyActive=" + this.f113058b + ", productId=" + this.f113059c + ", trialDurationText=" + this.f113060d + ", basePriceText=" + this.f113061e + ", monthlyPriceText=" + this.f113062f + ", discountedPriceText=" + this.f113063g + ", discountPercent=" + this.f113064h + ", subscriptionOption=" + this.f113065i + ")";
    }
}
