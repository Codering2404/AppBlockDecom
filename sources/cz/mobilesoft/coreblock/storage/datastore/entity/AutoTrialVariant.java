package cz.mobilesoft.coreblock.storage.datastore.entity;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AutoTrialVariant {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AutoTrialVariant[] $VALUES;
    public static final Companion Companion;
    private final String id;
    public static final AutoTrialVariant Off = new AutoTrialVariant("Off", 0, "A");
    public static final AutoTrialVariant LabelWithRcPaywall = new AutoTrialVariant("LabelWithRcPaywall", 1, "B");
    public static final AutoTrialVariant CardWithRetentionFlow = new AutoTrialVariant("CardWithRetentionFlow", 2, "C");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AutoTrialVariant a(String str) {
            AutoTrialVariant next;
            Iterator<AutoTrialVariant> it = AutoTrialVariant.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getId(), str)) {
                    break;
                }
            }
            AutoTrialVariant autoTrialVariant = next;
            return autoTrialVariant == null ? AutoTrialVariant.Off : autoTrialVariant;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AutoTrialVariant[] $values() {
        return new AutoTrialVariant[]{Off, LabelWithRcPaywall, CardWithRetentionFlow};
    }

    static {
        AutoTrialVariant[] autoTrialVariantArr$values = $values();
        $VALUES = autoTrialVariantArr$values;
        $ENTRIES = EnumEntriesKt.a(autoTrialVariantArr$values);
        Companion = new Companion(null);
    }

    private AutoTrialVariant(String str, int i3, String str2) {
        this.id = str2;
    }

    public static EnumEntries<AutoTrialVariant> getEntries() {
        return $ENTRIES;
    }

    public static AutoTrialVariant valueOf(String str) {
        return (AutoTrialVariant) Enum.valueOf(AutoTrialVariant.class, str);
    }

    public static AutoTrialVariant[] values() {
        return (AutoTrialVariant[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }

    public final boolean getShowsCard() {
        return this == CardWithRetentionFlow || this == Off;
    }

    public final boolean getShowsLabel() {
        return this == LabelWithRcPaywall;
    }
}
