package com.superwall.sdk.paywall.presentation.rule_logic.cel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
public interface InPeriod {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Period {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Period[] $VALUES;
        public static final Period HOUR = new Period("HOUR", 0);
        public static final Period DAY = new Period("DAY", 1);
        public static final Period WEEK = new Period("WEEK", 2);
        public static final Period MONTH = new Period("MONTH", 3);
        public static final Period YEAR = new Period("YEAR", 4);
        public static final Period INSTALL = new Period("INSTALL", 5);

        private static final /* synthetic */ Period[] $values() {
            return new Period[]{HOUR, DAY, WEEK, MONTH, YEAR, INSTALL};
        }

        static {
            Period[] periodArr$values = $values();
            $VALUES = periodArr$values;
            $ENTRIES = EnumEntriesKt.a(periodArr$values);
        }

        private Period(String str, int i3) {
        }

        public static EnumEntries<Period> getEntries() {
            return $ENTRIES;
        }

        public static Period valueOf(String str) {
            return (Period) Enum.valueOf(Period.class, str);
        }

        public static Period[] values() {
            return (Period[]) $VALUES.clone();
        }
    }

    String getEvent();
}
