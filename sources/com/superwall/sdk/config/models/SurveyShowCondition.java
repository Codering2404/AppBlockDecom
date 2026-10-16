package com.superwall.sdk.config.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

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
@Serializable(with = SurveyShowConditionSerializer.class)
public final class SurveyShowCondition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyShowCondition[] $VALUES;
    public static final Companion Companion;

    @SerialName
    public static final SurveyShowCondition ON_MANUAL_CLOSE = new SurveyShowCondition("ON_MANUAL_CLOSE", 0, "ON_MANUAL_CLOSE");

    @SerialName
    public static final SurveyShowCondition ON_PURCHASE = new SurveyShowCondition("ON_PURCHASE", 1, "ON_PURCHASE");
    private final String rawValue;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SurveyShowCondition> serializer() {
            return SurveyShowConditionSerializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ SurveyShowCondition[] $values() {
        return new SurveyShowCondition[]{ON_MANUAL_CLOSE, ON_PURCHASE};
    }

    static {
        SurveyShowCondition[] surveyShowConditionArr$values = $values();
        $VALUES = surveyShowConditionArr$values;
        $ENTRIES = EnumEntriesKt.a(surveyShowConditionArr$values);
        Companion = new Companion(null);
    }

    private SurveyShowCondition(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<SurveyShowCondition> getEntries() {
        return $ENTRIES;
    }

    public static SurveyShowCondition valueOf(String str) {
        return (SurveyShowCondition) Enum.valueOf(SurveyShowCondition.class, str);
    }

    public static SurveyShowCondition[] values() {
        return (SurveyShowCondition[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
