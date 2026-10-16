package com.superwall.sdk.models.paywall;

import com.facebook.internal.AnalyticsEvents;
import com.superwall.sdk.models.paywall.IntroOfferEligibility;
import java.lang.annotation.Annotation;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
public final class IntroOfferEligibility {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IntroOfferEligibility[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;

    @SerialName
    public static final IntroOfferEligibility ELIGIBLE = new IntroOfferEligibility("ELIGIBLE", 0);

    @SerialName
    public static final IntroOfferEligibility INELIGIBLE = new IntroOfferEligibility("INELIGIBLE", 1);

    @SerialName
    public static final IntroOfferEligibility AUTOMATIC = new IntroOfferEligibility("AUTOMATIC", 2);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) IntroOfferEligibility.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<IntroOfferEligibility> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ IntroOfferEligibility[] $values() {
        return new IntroOfferEligibility[]{ELIGIBLE, INELIGIBLE, AUTOMATIC};
    }

    static {
        IntroOfferEligibility[] introOfferEligibilityArr$values = $values();
        $VALUES = introOfferEligibilityArr$values;
        $ENTRIES = EnumEntriesKt.a(introOfferEligibilityArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: g0.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return IntroOfferEligibility._init_$_anonymous_();
            }
        });
    }

    private IntroOfferEligibility(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.models.paywall.IntroOfferEligibility", values(), new String[]{"eligible", "ineligible", AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC}, new Annotation[][]{null, null, null}, null);
    }

    public static EnumEntries<IntroOfferEligibility> getEntries() {
        return $ENTRIES;
    }

    public static IntroOfferEligibility valueOf(String str) {
        return (IntroOfferEligibility) Enum.valueOf(IntroOfferEligibility.class, str);
    }

    public static IntroOfferEligibility[] values() {
        return (IntroOfferEligibility[]) $VALUES.clone();
    }
}
