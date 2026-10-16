package cz.mobilesoft.coreblock.enums;

import androidx.compose.ui.graphics.ColorKt;
import cz.mobilesoft.coreblock.R;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class AppDistractionType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AppDistractionType[] $VALUES;
    public static final Companion Companion;
    public static final AppDistractionType Distractive = new AppDistractionType("Distractive", 0, ColorKt.d(4288104447L), R.string.Ag, R.drawable.f95548o2, "distracting");
    public static final AppDistractionType Neutral = new AppDistractionType("Neutral", 1, ColorKt.d(4281308927L), R.string.Eg, R.drawable.f95552p2, "neutral");
    public static final AppDistractionType Productive = new AppDistractionType("Productive", 2, ColorKt.d(4281648985L), R.string.Fg, R.drawable.f95556q2, "productive");
    private final long color;
    private final int iconRes;
    private final int nameRes;
    private final String parseName;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AppDistractionType a(String str) {
            AppDistractionType next;
            Iterator<AppDistractionType> it = AppDistractionType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.name(), str)) {
                    break;
                }
            }
            return next;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AppDistractionType[] $values() {
        return new AppDistractionType[]{Distractive, Neutral, Productive};
    }

    static {
        AppDistractionType[] appDistractionTypeArr$values = $values();
        $VALUES = appDistractionTypeArr$values;
        $ENTRIES = EnumEntriesKt.a(appDistractionTypeArr$values);
        Companion = new Companion(null);
    }

    private AppDistractionType(String str, int i3, long j3, int i4, int i5, String str2) {
        this.color = j3;
        this.nameRes = i4;
        this.iconRes = i5;
        this.parseName = str2;
    }

    public static EnumEntries<AppDistractionType> getEntries() {
        return $ENTRIES;
    }

    public static AppDistractionType valueOf(String str) {
        return (AppDistractionType) Enum.valueOf(AppDistractionType.class, str);
    }

    public static AppDistractionType[] values() {
        return (AppDistractionType[]) $VALUES.clone();
    }

    /* JADX INFO: renamed from: getColor-0d7_KjU, reason: not valid java name */
    public final long m1357getColor0d7_KjU() {
        return this.color;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getNameRes() {
        return this.nameRes;
    }

    public final String getParseName() {
        return this.parseName;
    }
}
