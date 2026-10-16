package com.superwall.sdk.logger;

import com.facebook.GraphRequest;
import com.facebook.appevents.integrity.IntegrityManager;
import com.revenuecat.purchases.strings.Emojis;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class LogLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LogLevel[] $VALUES;
    private final int level;
    public static final LogLevel debug = new LogLevel(GraphRequest.DEBUG_PARAM, 0, 10);
    public static final LogLevel info = new LogLevel(GraphRequest.DEBUG_SEVERITY_INFO, 1, 20);
    public static final LogLevel warn = new LogLevel("warn", 2, 30);
    public static final LogLevel error = new LogLevel("error", 3, 40);
    public static final LogLevel none = new LogLevel(IntegrityManager.INTEGRITY_TYPE_NONE, 4, 99);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            try {
                iArr[LogLevel.debug.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogLevel.info.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogLevel.warn.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogLevel.error.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogLevel.none.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ LogLevel[] $values() {
        return new LogLevel[]{debug, info, warn, error, none};
    }

    static {
        LogLevel[] logLevelArr$values = $values();
        $VALUES = logLevelArr$values;
        $ENTRIES = EnumEntriesKt.a(logLevelArr$values);
    }

    private LogLevel(String str, int i3, int i4) {
        this.level = i4;
    }

    public static EnumEntries<LogLevel> getEntries() {
        return $ENTRIES;
    }

    public static LogLevel valueOf(String str) {
        return (LogLevel) Enum.valueOf(LogLevel.class, str);
    }

    public static LogLevel[] values() {
        return (LogLevel[]) $VALUES.clone();
    }

    public final String getDescriptionEmoji() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            return "💬";
        }
        if (i3 == 2) {
            return Emojis.INFO;
        }
        if (i3 == 3) {
            return Emojis.WARNING;
        }
        if (i3 == 4) {
            return Emojis.DOUBLE_EXCLAMATION;
        }
        if (i3 == 5) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getLevel() {
        return this.level;
    }

    @Override // java.lang.Enum
    public String toString() {
        int i3 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i3 == 1) {
            return "DEBUG";
        }
        if (i3 == 2) {
            return "INFO";
        }
        if (i3 == 3) {
            return "WARN";
        }
        if (i3 == 4) {
            return "ERROR";
        }
        if (i3 == 5) {
            return "NONE";
        }
        throw new NoWhenBranchMatchedException();
    }
}
