package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
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
public final class ContactReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ContactReason[] $VALUES;
    private final int priority;
    private final String reason;
    private final int textResId;
    public static final ContactReason ProblemsWithPremium = new ContactReason("ProblemsWithPremium", 0, "Premium", R.string.Bq, 3);
    public static final ContactReason ProblemsWithBlocking = new ContactReason("ProblemsWithBlocking", 1, "Problem", R.string.Aq, 2);
    public static final ContactReason EmergencyUnblocking = new ContactReason("EmergencyUnblocking", 2, "Unlock Code", R.string.id, 4);
    public static final ContactReason FeatureSuggestion = new ContactReason("FeatureSuggestion", 3, "Feature Request", R.string.je, 1);
    public static final ContactReason Other = new ContactReason("Other", 4, "Other", R.string.HD, 2);

    private static final /* synthetic */ ContactReason[] $values() {
        return new ContactReason[]{ProblemsWithPremium, ProblemsWithBlocking, EmergencyUnblocking, FeatureSuggestion, Other};
    }

    static {
        ContactReason[] contactReasonArr$values = $values();
        $VALUES = contactReasonArr$values;
        $ENTRIES = EnumEntriesKt.a(contactReasonArr$values);
    }

    private ContactReason(String str, int i3, String str2, int i4, int i5) {
        this.reason = str2;
        this.textResId = i4;
        this.priority = i5;
    }

    public static EnumEntries<ContactReason> getEntries() {
        return $ENTRIES;
    }

    public static ContactReason valueOf(String str) {
        return (ContactReason) Enum.valueOf(ContactReason.class, str);
    }

    public static ContactReason[] values() {
        return (ContactReason[]) $VALUES.clone();
    }

    public final int getPriority() {
        return this.priority;
    }

    public final String getReason() {
        return this.reason;
    }

    public final int getTextResId() {
        return this.textResId;
    }
}
