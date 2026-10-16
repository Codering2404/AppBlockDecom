package cz.mobilesoft.coreblock.enums;

import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class LockScreenColor implements SelectableColor {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LockScreenColor[] $VALUES;
    public static final Companion Companion;
    public static final LockScreenColor GreenVariant;
    public static final LockScreenColor PurpleVariant4;
    private static final Lazy<Map<Integer, LockScreenColor>> colors$delegate;
    private final String hex;
    private final int id;
    private final boolean isPremium;
    public static final LockScreenColor BrandBlue = new LockScreenColor("BrandBlue", 0, 0, false, "#2F96FF", 2, null);
    public static final LockScreenColor BlueVariant = new LockScreenColor("BlueVariant", 1, 1, false, "#2132CD", 2, null);
    public static final LockScreenColor DarkBlue = new LockScreenColor(rnFwbPAQmQTnL.oXGwFL, 2, 2, false, "#00123F", 2, null);
    public static final LockScreenColor LightPurple = new LockScreenColor("LightPurple", 3, 3, false, "#9747FF", 2, null);
    public static final LockScreenColor PurpleVariant1 = new LockScreenColor("PurpleVariant1", 4, 4, false, "#5D24A8", 2, null);
    public static final LockScreenColor PurpleVariant2 = new LockScreenColor("PurpleVariant2", 5, 5, false, "#310E5F", 2, null);
    public static final LockScreenColor Pink = new LockScreenColor("Pink", 6, 6, false, "#CF30FF", 2, null);
    public static final LockScreenColor PurpleVariant3 = new LockScreenColor("PurpleVariant3", 7, 7, false, "#921EB5", 2, null);
    public static final LockScreenColor LightRed = new LockScreenColor("LightRed", 9, 9, false, "#FF3B30", 2, null);
    public static final LockScreenColor RedVariant1 = new LockScreenColor("RedVariant1", 10, 10, false, "#B7140A", 2, null);
    public static final LockScreenColor RedVariant2 = new LockScreenColor("RedVariant2", 11, 11, false, "#650F0A", 2, null);
    public static final LockScreenColor Orange = new LockScreenColor("Orange", 12, 12, false, "#FF9500", 2, null);
    public static final LockScreenColor OrangeVariant1 = new LockScreenColor("OrangeVariant1", 13, 13, false, "#C17100", 2, null);
    public static final LockScreenColor OrangeVariant2 = new LockScreenColor("OrangeVariant2", 14, 14, false, "#6E4100", 2, null);
    public static final LockScreenColor LightGreen = new LockScreenColor("LightGreen", 15, 15, false, "#7AE13B", 2, null);
    public static final LockScreenColor Green = new LockScreenColor("Green", 16, 16, false, "#34C759", 2, null);
    public static final LockScreenColor Black = new LockScreenColor("Black", 18, 18, false, "#000000", 2, null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LockScreenColor a(String hex) {
            LockScreenColor next;
            Intrinsics.checkNotNullParameter(hex, "hex");
            Iterator<LockScreenColor> it = LockScreenColor.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (Intrinsics.areEqual(next.getHex(), hex)) {
                    break;
                }
            }
            return next;
        }

        public final Map b() {
            return (Map) LockScreenColor.colors$delegate.getValue();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ LockScreenColor[] $values() {
        return new LockScreenColor[]{BrandBlue, BlueVariant, DarkBlue, LightPurple, PurpleVariant1, PurpleVariant2, Pink, PurpleVariant3, PurpleVariant4, LightRed, RedVariant1, RedVariant2, Orange, OrangeVariant1, OrangeVariant2, LightGreen, Green, GreenVariant, Black};
    }

    private LockScreenColor(String str, int i3, int i4, boolean z2, String str2) {
        this.id = i4;
        this.isPremium = z2;
        this.hex = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map colors_delegate$lambda$0() {
        EnumEntries<LockScreenColor> entries = getEntries();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entries, 10)), 16));
        for (LockScreenColor lockScreenColor : entries) {
            linkedHashMap.put(Integer.valueOf(lockScreenColor.ordinal()), lockScreenColor);
        }
        return linkedHashMap;
    }

    public static EnumEntries<LockScreenColor> getEntries() {
        return $ENTRIES;
    }

    public static LockScreenColor valueOf(String str) {
        return (LockScreenColor) Enum.valueOf(LockScreenColor.class, str);
    }

    public static LockScreenColor[] values() {
        return (LockScreenColor[]) $VALUES.clone();
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableColor
    public String getHex() {
        return this.hex;
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableItem
    public int getId() {
        return this.id;
    }

    @Override // cz.mobilesoft.coreblock.enums.SelectableItem
    public boolean isPremium() {
        return this.isPremium;
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        PurpleVariant4 = new LockScreenColor("PurpleVariant4", 8, 8, false, "#56126A", 2, defaultConstructorMarker);
        GreenVariant = new LockScreenColor("GreenVariant", 17, 17, false, "#055B1B", 2, defaultConstructorMarker);
        LockScreenColor[] lockScreenColorArr$values = $values();
        $VALUES = lockScreenColorArr$values;
        $ENTRIES = EnumEntriesKt.a(lockScreenColorArr$values);
        Companion = new Companion(null);
        colors$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.enums.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return LockScreenColor.colors_delegate$lambda$0();
            }
        });
    }

    /* synthetic */ LockScreenColor(String str, int i3, int i4, boolean z2, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, i4, (i5 & 2) != 0 ? false : z2, str2);
    }
}
