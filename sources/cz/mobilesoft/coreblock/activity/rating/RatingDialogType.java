package cz.mobilesoft.coreblock.activity.rating;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

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
public final class RatingDialogType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RatingDialogType[] $VALUES;
    public static final Companion Companion;
    private final String remoteConfigValue;
    public static final RatingDialogType Native = new RatingDialogType("Native", 0, "A");
    public static final RatingDialogType RatingFlow = new RatingDialogType("RatingFlow", 1, "B");
    public static final RatingDialogType SimpleDialog = new RatingDialogType("SimpleDialog", 2, "C");
    public static final RatingDialogType RatingDialog = new RatingDialogType("RatingDialog", 3, "D");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RatingDialogType a(String str) {
            RatingDialogType next;
            Iterator<RatingDialogType> it = RatingDialogType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (StringsKt.F(next.getRemoteConfigValue(), str, true)) {
                    break;
                }
            }
            RatingDialogType ratingDialogType = next;
            return ratingDialogType == null ? RatingDialogType.Native : ratingDialogType;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ RatingDialogType[] $values() {
        return new RatingDialogType[]{Native, RatingFlow, SimpleDialog, RatingDialog};
    }

    static {
        RatingDialogType[] ratingDialogTypeArr$values = $values();
        $VALUES = ratingDialogTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(ratingDialogTypeArr$values);
        Companion = new Companion(null);
    }

    private RatingDialogType(String str, int i3, String str2) {
        this.remoteConfigValue = str2;
    }

    public static EnumEntries<RatingDialogType> getEntries() {
        return $ENTRIES;
    }

    public static RatingDialogType valueOf(String str) {
        return (RatingDialogType) Enum.valueOf(RatingDialogType.class, str);
    }

    public static RatingDialogType[] values() {
        return (RatingDialogType[]) $VALUES.clone();
    }

    public final String getRemoteConfigValue() {
        return this.remoteConfigValue;
    }
}
