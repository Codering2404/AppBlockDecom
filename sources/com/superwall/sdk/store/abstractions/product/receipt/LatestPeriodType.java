package com.superwall.sdk.store.abstractions.product.receipt;

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
public final class LatestPeriodType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LatestPeriodType[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;

    @SerialName
    public static final LatestPeriodType TRIAL = new LatestPeriodType("TRIAL", 0);

    @SerialName
    public static final LatestPeriodType CODE = new LatestPeriodType("CODE", 1);

    @SerialName
    public static final LatestPeriodType SUBSCRIPTION = new LatestPeriodType("SUBSCRIPTION", 2);

    @SerialName
    public static final LatestPeriodType PROMOTIONAL = new LatestPeriodType("PROMOTIONAL", 3);

    @SerialName
    public static final LatestPeriodType WINBACK = new LatestPeriodType("WINBACK", 4);

    @SerialName
    public static final LatestPeriodType REVOKED = new LatestPeriodType("REVOKED", 5);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) LatestPeriodType.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<LatestPeriodType> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ LatestPeriodType[] $values() {
        return new LatestPeriodType[]{TRIAL, CODE, SUBSCRIPTION, PROMOTIONAL, WINBACK, REVOKED};
    }

    static {
        LatestPeriodType[] latestPeriodTypeArr$values = $values();
        $VALUES = latestPeriodTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(latestPeriodTypeArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.store.abstractions.product.receipt.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LatestPeriodType._init_$_anonymous_();
            }
        });
    }

    private LatestPeriodType(String str, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.store.abstractions.product.receipt.LatestPeriodType", values(), new String[]{"trial", "code", "subscription", "promotional", "winback", "revoked"}, new Annotation[][]{null, null, null, null, null, null}, null);
    }

    public static EnumEntries<LatestPeriodType> getEntries() {
        return $ENTRIES;
    }

    public static LatestPeriodType valueOf(String str) {
        return (LatestPeriodType) Enum.valueOf(LatestPeriodType.class, str);
    }

    public static LatestPeriodType[] values() {
        return (LatestPeriodType[]) $VALUES.clone();
    }
}
