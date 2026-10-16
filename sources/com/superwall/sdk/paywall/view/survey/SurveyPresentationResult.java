package com.superwall.sdk.paywall.view.survey;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SurveyPresentationResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SurveyPresentationResult[] $VALUES;
    private final String rawValue;
    public static final SurveyPresentationResult SHOW = new SurveyPresentationResult("SHOW", 0, "show");
    public static final SurveyPresentationResult HOLDOUT = new SurveyPresentationResult("HOLDOUT", 1, "holdout");
    public static final SurveyPresentationResult NOSHOW = new SurveyPresentationResult("NOSHOW", 2, "noShow");

    private static final /* synthetic */ SurveyPresentationResult[] $values() {
        return new SurveyPresentationResult[]{SHOW, HOLDOUT, NOSHOW};
    }

    static {
        SurveyPresentationResult[] surveyPresentationResultArr$values = $values();
        $VALUES = surveyPresentationResultArr$values;
        $ENTRIES = EnumEntriesKt.a(surveyPresentationResultArr$values);
    }

    private SurveyPresentationResult(String str, int i3, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<SurveyPresentationResult> getEntries() {
        return $ENTRIES;
    }

    public static SurveyPresentationResult valueOf(String str) {
        return (SurveyPresentationResult) Enum.valueOf(SurveyPresentationResult.class, str);
    }

    public static SurveyPresentationResult[] values() {
        return (SurveyPresentationResult[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
