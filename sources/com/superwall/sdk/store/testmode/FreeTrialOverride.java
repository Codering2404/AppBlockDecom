package com.superwall.sdk.store.testmode;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
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
public final class FreeTrialOverride {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ FreeTrialOverride[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final String displayName;
    public static final FreeTrialOverride UseDefault = new FreeTrialOverride("UseDefault", 0, "Use Default");
    public static final FreeTrialOverride ForceAvailable = new FreeTrialOverride("ForceAvailable", 1, "Force Available");
    public static final FreeTrialOverride ForceUnavailable = new FreeTrialOverride("ForceUnavailable", 2, "Force Unavailable");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) FreeTrialOverride.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<FreeTrialOverride> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ FreeTrialOverride[] $values() {
        return new FreeTrialOverride[]{UseDefault, ForceAvailable, ForceUnavailable};
    }

    static {
        FreeTrialOverride[] freeTrialOverrideArr$values = $values();
        $VALUES = freeTrialOverrideArr$values;
        $ENTRIES = EnumEntriesKt.a(freeTrialOverrideArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: com.superwall.sdk.store.testmode.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return FreeTrialOverride._init_$_anonymous_();
            }
        });
    }

    private FreeTrialOverride(String str, int i3, String str2) {
        this.displayName = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.b("com.superwall.sdk.store.testmode.FreeTrialOverride", values());
    }

    public static EnumEntries<FreeTrialOverride> getEntries() {
        return $ENTRIES;
    }

    public static FreeTrialOverride valueOf(String str) {
        return (FreeTrialOverride) Enum.valueOf(FreeTrialOverride.class, str);
    }

    public static FreeTrialOverride[] values() {
        return (FreeTrialOverride[]) $VALUES.clone();
    }

    public final String getDisplayName() {
        return this.displayName;
    }
}
