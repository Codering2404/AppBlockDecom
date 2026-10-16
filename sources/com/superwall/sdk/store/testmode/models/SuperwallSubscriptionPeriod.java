package com.superwall.sdk.store.testmode.models;

import com.superwall.sdk.store.testmode.models.SuperwallSubscriptionPeriod;
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
public final class SuperwallSubscriptionPeriod {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SuperwallSubscriptionPeriod[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;

    @SerialName
    public static final SuperwallSubscriptionPeriod DAY = new SuperwallSubscriptionPeriod("DAY", 0);

    @SerialName
    public static final SuperwallSubscriptionPeriod WEEK = new SuperwallSubscriptionPeriod("WEEK", 1);

    @SerialName
    public static final SuperwallSubscriptionPeriod MONTH = new SuperwallSubscriptionPeriod("MONTH", 2);

    @SerialName
    public static final SuperwallSubscriptionPeriod YEAR = new SuperwallSubscriptionPeriod("YEAR", 3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) SuperwallSubscriptionPeriod.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<SuperwallSubscriptionPeriod> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ SuperwallSubscriptionPeriod[] $values() {
        return new SuperwallSubscriptionPeriod[]{DAY, WEEK, MONTH, YEAR};
    }

    static {
        SuperwallSubscriptionPeriod[] superwallSubscriptionPeriodArr$values = $values();
        $VALUES = superwallSubscriptionPeriodArr$values;
        $ENTRIES = EnumEntriesKt.a(superwallSubscriptionPeriodArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: m0.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SuperwallSubscriptionPeriod._init_$_anonymous_();
            }
        });
    }

    private SuperwallSubscriptionPeriod(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.store.testmode.models.SuperwallSubscriptionPeriod", values(), new String[]{"day", "week", "month", "year"}, new Annotation[][]{null, null, null, null}, null);
    }

    public static EnumEntries<SuperwallSubscriptionPeriod> getEntries() {
        return $ENTRIES;
    }

    public static SuperwallSubscriptionPeriod valueOf(String str) {
        return (SuperwallSubscriptionPeriod) Enum.valueOf(SuperwallSubscriptionPeriod.class, str);
    }

    public static SuperwallSubscriptionPeriod[] values() {
        return (SuperwallSubscriptionPeriod[]) $VALUES.clone();
    }
}
