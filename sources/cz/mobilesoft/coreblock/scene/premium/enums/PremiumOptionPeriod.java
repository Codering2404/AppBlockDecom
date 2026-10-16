package cz.mobilesoft.coreblock.scene.premium.enums;

import com.revenuecat.purchases.models.Period;
import cz.mobilesoft.coreblock.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class PremiumOptionPeriod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PremiumOptionPeriod[] $VALUES;
    public static final Companion Companion;
    private final Integer billedPeriod;
    private final int titleLong;
    private final int titleShort;
    public static final PremiumOptionPeriod Yearly = new PremiumOptionPeriod("Yearly", 0, R.string.iq, R.string.rH, Integer.valueOf(R.string.k3));
    public static final PremiumOptionPeriod Monthly = new PremiumOptionPeriod("Monthly", 1, R.string.Gp, R.string.bk, Integer.valueOf(R.string.j3));
    public static final PremiumOptionPeriod Lifetime = new PremiumOptionPeriod("Lifetime", 2, R.string.Fp, R.string.Wi, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f113073a;

            static {
                int[] iArr = new int[Period.Unit.values().length];
                try {
                    iArr[Period.Unit.YEAR.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Period.Unit.MONTH.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f113073a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PremiumOptionPeriod a(Period.Unit value) {
            Intrinsics.checkNotNullParameter(value, "value");
            int i3 = WhenMappings.f113073a[value.ordinal()];
            return i3 != 1 ? i3 != 2 ? PremiumOptionPeriod.Lifetime : PremiumOptionPeriod.Monthly : PremiumOptionPeriod.Yearly;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PremiumOptionPeriod[] $values() {
        return new PremiumOptionPeriod[]{Yearly, Monthly, Lifetime};
    }

    static {
        PremiumOptionPeriod[] premiumOptionPeriodArr$values = $values();
        $VALUES = premiumOptionPeriodArr$values;
        $ENTRIES = EnumEntriesKt.a(premiumOptionPeriodArr$values);
        Companion = new Companion(null);
    }

    private PremiumOptionPeriod(String str, int i3, int i4, int i5, Integer num) {
        this.titleLong = i4;
        this.titleShort = i5;
        this.billedPeriod = num;
    }

    public static EnumEntries<PremiumOptionPeriod> getEntries() {
        return $ENTRIES;
    }

    public static PremiumOptionPeriod valueOf(String str) {
        return (PremiumOptionPeriod) Enum.valueOf(PremiumOptionPeriod.class, str);
    }

    public static PremiumOptionPeriod[] values() {
        return (PremiumOptionPeriod[]) $VALUES.clone();
    }

    public final Integer getBilledPeriod() {
        return this.billedPeriod;
    }

    public final int getTitleLong() {
        return this.titleLong;
    }

    public final int getTitleShort() {
        return this.titleShort;
    }
}
