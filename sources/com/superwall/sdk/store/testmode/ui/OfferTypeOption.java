package com.superwall.sdk.store.testmode.ui;

import com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;

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
@Serializable
public final class OfferTypeOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OfferTypeOption[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final String displayName;
    public static final OfferTypeOption None = new OfferTypeOption("None", 0, "None");
    public static final OfferTypeOption Trial = new OfferTypeOption("Trial", 1, "Trial");
    public static final OfferTypeOption Promotional = new OfferTypeOption("Promotional", 2, "Promotional");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) OfferTypeOption.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<OfferTypeOption> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[OfferTypeOption.values().length];
            try {
                iArr[OfferTypeOption.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[OfferTypeOption.Trial.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[OfferTypeOption.Promotional.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ OfferTypeOption[] $values() {
        return new OfferTypeOption[]{None, Trial, Promotional};
    }

    static {
        OfferTypeOption[] offerTypeOptionArr$values = $values();
        $VALUES = offerTypeOptionArr$values;
        $ENTRIES = EnumEntriesKt.a(offerTypeOptionArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.store.testmode.ui.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return OfferTypeOption._init_$_anonymous_();
            }
        });
    }

    private OfferTypeOption(String str, int i3, String str2) {
        this.displayName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.b("com.superwall.sdk.store.testmode.ui.OfferTypeOption", values());
    }

    public static EnumEntries<OfferTypeOption> getEntries() {
        return $ENTRIES;
    }

    public static OfferTypeOption valueOf(String str) {
        return (OfferTypeOption) Enum.valueOf(OfferTypeOption.class, str);
    }

    public static OfferTypeOption[] values() {
        return (OfferTypeOption[]) $VALUES.clone();
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final LatestPeriodType toPeriodType() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            return null;
        }
        if (i3 == 2) {
            return LatestPeriodType.TRIAL;
        }
        if (i3 == 3) {
            return LatestPeriodType.PROMOTIONAL;
        }
        throw new NoWhenBranchMatchedException();
    }
}
