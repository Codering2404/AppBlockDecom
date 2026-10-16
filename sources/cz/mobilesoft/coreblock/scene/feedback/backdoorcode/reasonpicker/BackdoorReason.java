package cz.mobilesoft.coreblock.scene.feedback.backdoorcode.reasonpicker;

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
public final class BackdoorReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BackdoorReason[] $VALUES;
    private final String reason;
    public static final BackdoorReason NO_SELF_CONTROL = new BackdoorReason("NO_SELF_CONTROL", 0, "no_self_control");
    public static final BackdoorReason BLOCKING_WHAT_IT_SHOULDNT = new BackdoorReason("BLOCKING_WHAT_IT_SHOULDNT", 1, "sm_blocking_what_it_shouldnt");
    public static final BackdoorReason DIDNT_MEET_EXPECTATIONS = new BackdoorReason("DIDNT_MEET_EXPECTATIONS", 2, "sm_didnt_meet_expectations");
    public static final BackdoorReason URGENT_ACCESS_TO_APP = new BackdoorReason("URGENT_ACCESS_TO_APP", 3, "sm_urgent_access_to_app");

    private static final /* synthetic */ BackdoorReason[] $values() {
        return new BackdoorReason[]{NO_SELF_CONTROL, BLOCKING_WHAT_IT_SHOULDNT, DIDNT_MEET_EXPECTATIONS, URGENT_ACCESS_TO_APP};
    }

    static {
        BackdoorReason[] backdoorReasonArr$values = $values();
        $VALUES = backdoorReasonArr$values;
        $ENTRIES = EnumEntriesKt.a(backdoorReasonArr$values);
    }

    private BackdoorReason(String str, int i3, String str2) {
        this.reason = str2;
    }

    public static EnumEntries<BackdoorReason> getEntries() {
        return $ENTRIES;
    }

    public static BackdoorReason valueOf(String str) {
        return (BackdoorReason) Enum.valueOf(BackdoorReason.class, str);
    }

    public static BackdoorReason[] values() {
        return (BackdoorReason[]) $VALUES.clone();
    }

    public final String getReason() {
        return this.reason;
    }
}
