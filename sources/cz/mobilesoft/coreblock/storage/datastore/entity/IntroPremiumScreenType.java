package cz.mobilesoft.coreblock.storage.datastore.entity;

import kotlin.Deprecated;
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
public final class IntroPremiumScreenType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ IntroPremiumScreenType[] $VALUES;
    public static final Companion Companion;
    private final String id;
    public static final IntroPremiumScreenType NoTrial = new IntroPremiumScreenType("NoTrial", 0, "A");
    public static final IntroPremiumScreenType TrialWithCloseButton = new IntroPremiumScreenType("TrialWithCloseButton", 1, "B");

    @Deprecated
    public static final IntroPremiumScreenType TrialWithSkipText = new IntroPremiumScreenType("TrialWithSkipText", 2, "C");
    public static final IntroPremiumScreenType TrialUnskippable = new IntroPremiumScreenType("TrialUnskippable", 3, "D");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IntroPremiumScreenType a(String id) {
            IntroPremiumScreenType introPremiumScreenType;
            Intrinsics.checkNotNullParameter(id, "id");
            IntroPremiumScreenType[] introPremiumScreenTypeArrValues = IntroPremiumScreenType.values();
            int length = introPremiumScreenTypeArrValues.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    introPremiumScreenType = null;
                    break;
                }
                introPremiumScreenType = introPremiumScreenTypeArrValues[i3];
                if (Intrinsics.areEqual(introPremiumScreenType.getId(), id)) {
                    break;
                }
                i3++;
            }
            return introPremiumScreenType == null ? IntroPremiumScreenType.NoTrial : introPremiumScreenType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ IntroPremiumScreenType[] $values() {
        return new IntroPremiumScreenType[]{NoTrial, TrialWithCloseButton, TrialWithSkipText, TrialUnskippable};
    }

    static {
        IntroPremiumScreenType[] introPremiumScreenTypeArr$values = $values();
        $VALUES = introPremiumScreenTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(introPremiumScreenTypeArr$values);
        Companion = new Companion(null);
    }

    private IntroPremiumScreenType(String str, int i3, String str2) {
        this.id = str2;
    }

    public static EnumEntries<IntroPremiumScreenType> getEntries() {
        return $ENTRIES;
    }

    public static IntroPremiumScreenType valueOf(String str) {
        return (IntroPremiumScreenType) Enum.valueOf(IntroPremiumScreenType.class, str);
    }

    public static IntroPremiumScreenType[] values() {
        return (IntroPremiumScreenType[]) $VALUES.clone();
    }

    public final String getId() {
        return this.id;
    }
}
