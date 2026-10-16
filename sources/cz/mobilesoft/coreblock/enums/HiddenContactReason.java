package cz.mobilesoft.coreblock.enums;

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
public final class HiddenContactReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ HiddenContactReason[] $VALUES;
    public static final HiddenContactReason EmergencyFeedback = new HiddenContactReason("EmergencyFeedback", 0, "Emergency Feedback", 1);
    public static final HiddenContactReason StreaksBetaFeedback = new HiddenContactReason("StreaksBetaFeedback", 1, "Streaks Beta Feedback", 2);
    private final int priority;
    private final String reason;

    private static final /* synthetic */ HiddenContactReason[] $values() {
        return new HiddenContactReason[]{EmergencyFeedback, StreaksBetaFeedback};
    }

    static {
        HiddenContactReason[] hiddenContactReasonArr$values = $values();
        $VALUES = hiddenContactReasonArr$values;
        $ENTRIES = EnumEntriesKt.a(hiddenContactReasonArr$values);
    }

    private HiddenContactReason(String str, int i3, String str2, int i4) {
        this.reason = str2;
        this.priority = i4;
    }

    public static EnumEntries<HiddenContactReason> getEntries() {
        return $ENTRIES;
    }

    public static HiddenContactReason valueOf(String str) {
        return (HiddenContactReason) Enum.valueOf(HiddenContactReason.class, str);
    }

    public static HiddenContactReason[] values() {
        return (HiddenContactReason[]) $VALUES.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getReason() {
        return this.reason;
    }
}
