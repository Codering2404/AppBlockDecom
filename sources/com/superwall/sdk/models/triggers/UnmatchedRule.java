package com.superwall.sdk.models.triggers;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

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
public final class UnmatchedRule {
    private final String experimentId;
    private final Source source;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Source {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Source[] $VALUES;
        public static final Source EXPRESSION = new Source("EXPRESSION", 0, "EXPRESSION");
        public static final Source OCCURRENCE = new Source("OCCURRENCE", 1, "OCCURRENCE");
        private final String rawValue;

        private static final /* synthetic */ Source[] $values() {
            return new Source[]{EXPRESSION, OCCURRENCE};
        }

        static {
            Source[] sourceArr$values = $values();
            $VALUES = sourceArr$values;
            $ENTRIES = EnumEntriesKt.a(sourceArr$values);
        }

        private Source(String str, int i3, String str2) {
            this.rawValue = str2;
        }

        public static EnumEntries<Source> getEntries() {
            return $ENTRIES;
        }

        public static Source valueOf(String str) {
            return (Source) Enum.valueOf(Source.class, str);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        public final String getRawValue() {
            return this.rawValue;
        }
    }

    public UnmatchedRule(Source source, String experimentId) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        this.source = source;
        this.experimentId = experimentId;
    }

    public static /* synthetic */ UnmatchedRule copy$default(UnmatchedRule unmatchedRule, Source source, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            source = unmatchedRule.source;
        }
        if ((i3 & 2) != 0) {
            str = unmatchedRule.experimentId;
        }
        return unmatchedRule.copy(source, str);
    }

    public final Source component1() {
        return this.source;
    }

    public final String component2() {
        return this.experimentId;
    }

    public final UnmatchedRule copy(Source source, String experimentId) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(experimentId, "experimentId");
        return new UnmatchedRule(source, experimentId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnmatchedRule)) {
            return false;
        }
        UnmatchedRule unmatchedRule = (UnmatchedRule) obj;
        return this.source == unmatchedRule.source && Intrinsics.areEqual(this.experimentId, unmatchedRule.experimentId);
    }

    public final String getExperimentId() {
        return this.experimentId;
    }

    public final Source getSource() {
        return this.source;
    }

    public int hashCode() {
        return (this.source.hashCode() * 31) + this.experimentId.hashCode();
    }

    public String toString() {
        return "UnmatchedRule(source=" + this.source + ", experimentId=" + this.experimentId + ")";
    }
}
