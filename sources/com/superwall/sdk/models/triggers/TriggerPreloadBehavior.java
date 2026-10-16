package com.superwall.sdk.models.triggers;

import com.superwall.sdk.models.triggers.TriggerPreloadBehavior;
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
public final class TriggerPreloadBehavior {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TriggerPreloadBehavior[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;
    public static final Companion Companion;
    private final String rawValue;

    @SerialName
    public static final TriggerPreloadBehavior IF_TRUE = new TriggerPreloadBehavior("IF_TRUE", 0, "IF_TRUE");

    @SerialName
    public static final TriggerPreloadBehavior ALWAYS = new TriggerPreloadBehavior("ALWAYS", 1, "ALWAYS");

    @SerialName
    public static final TriggerPreloadBehavior NEVER = new TriggerPreloadBehavior("NEVER", 2, "NEVER");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) TriggerPreloadBehavior.$cachedSerializer$delegate.getValue();
        }

        public final KSerializer<TriggerPreloadBehavior> serializer() {
            return get$cachedSerializer();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ TriggerPreloadBehavior[] $values() {
        return new TriggerPreloadBehavior[]{IF_TRUE, ALWAYS, NEVER};
    }

    static {
        TriggerPreloadBehavior[] triggerPreloadBehaviorArr$values = $values();
        $VALUES = triggerPreloadBehaviorArr$values;
        $ENTRIES = EnumEntriesKt.a(triggerPreloadBehaviorArr$values);
        Companion = new Companion(null);
        $cachedSerializer$delegate = LazyKt.a(LazyThreadSafetyMode.f139762b, new Function0() { // from class: i0.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return TriggerPreloadBehavior._init_$_anonymous_();
            }
        });
    }

    private TriggerPreloadBehavior(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.a("com.superwall.sdk.models.triggers.TriggerPreloadBehavior", values(), new String[]{"IF_TRUE", "ALWAYS", "NEVER"}, new Annotation[][]{null, null, null}, null);
    }

    public static EnumEntries<TriggerPreloadBehavior> getEntries() {
        return $ENTRIES;
    }

    public static TriggerPreloadBehavior valueOf(String str) {
        return (TriggerPreloadBehavior) Enum.valueOf(TriggerPreloadBehavior.class, str);
    }

    public static TriggerPreloadBehavior[] values() {
        return (TriggerPreloadBehavior[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
