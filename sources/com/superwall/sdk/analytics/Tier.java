package com.superwall.sdk.analytics;

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
public final class Tier {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Tier[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final String raw;

    @SerialName
    public static final Tier ULTRA_LOW = new Tier("ULTRA_LOW", 0, "ultra_low");

    @SerialName
    public static final Tier LOW = new Tier("LOW", 1, "low");

    @SerialName
    public static final Tier MID = new Tier("MID", 2, "mid");

    @SerialName
    public static final Tier HIGH = new Tier("HIGH", 3, "high");

    @SerialName
    public static final Tier ULTRA_HIGH = new Tier("ULTRA_HIGH", 4, "ultra_high");

    @SerialName
    public static final Tier UNKNOWN = new Tier("UNKNOWN", 5, "unknown");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) Tier.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<Tier> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ Tier[] $values() {
        return new Tier[]{ULTRA_LOW, LOW, MID, HIGH, ULTRA_HIGH, UNKNOWN};
    }

    static {
        Tier[] tierArr$values = $values();
        $VALUES = tierArr$values;
        $ENTRIES = EnumEntriesKt.a(tierArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.analytics.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Tier._init_$_anonymous_();
            }
        });
    }

    private Tier(String str, int i3, String str2) {
        this.raw = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.analytics.Tier", values(), new String[]{"ULTRA_LOW", "LOW", "MID", "HIGH", "ULTRA_HIGH", "UNKNOWN"}, new Annotation[][]{null, null, null, null, null, null}, null);
    }

    public static EnumEntries<Tier> getEntries() {
        return $ENTRIES;
    }

    public static Tier valueOf(String str) {
        return (Tier) Enum.valueOf(Tier.class, str);
    }

    public static Tier[] values() {
        return (Tier[]) $VALUES.clone();
    }

    public final String getRaw() {
        return this.raw;
    }
}
