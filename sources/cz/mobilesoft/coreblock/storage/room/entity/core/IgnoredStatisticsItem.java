package cz.mobilesoft.coreblock.storage.room.entity.core;

import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.coreblock.storage.room.entity.core.IgnoredStatisticsItem;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

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
public final class IgnoredStatisticsItem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f126562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final UsageAccess.Type f126563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ItemSourceType f126564d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f126565e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f126566f;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ItemSourceType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ItemSourceType[] $VALUES;
        public static final Companion Companion;
        private static final Lazy<Map<Integer, ItemSourceType>> allById$delegate;
        private final int id;
        public static final ItemSourceType DEFAULT = new ItemSourceType("DEFAULT", 0, 0);
        public static final ItemSourceType CUSTOM = new ItemSourceType("CUSTOM", 1, 1);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) ItemSourceType.allById$delegate.getValue();
            }

            public final ItemSourceType b(int i3) {
                ItemSourceType itemSourceType = (ItemSourceType) a().get(Integer.valueOf(i3));
                return itemSourceType == null ? ItemSourceType.CUSTOM : itemSourceType;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final ItemSourceType a(int i3) {
                return ItemSourceType.Companion.b(i3);
            }

            public final int b(ItemSourceType sourceType) {
                Intrinsics.checkNotNullParameter(sourceType, "sourceType");
                return sourceType.getId();
            }
        }

        private static final /* synthetic */ ItemSourceType[] $values() {
            return new ItemSourceType[]{DEFAULT, CUSTOM};
        }

        static {
            ItemSourceType[] itemSourceTypeArr$values = $values();
            $VALUES = itemSourceTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(itemSourceTypeArr$values);
            Companion = new Companion(null);
            allById$delegate = LazyKt.b(new Function0() { // from class: g2.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return IgnoredStatisticsItem.ItemSourceType.allById_delegate$lambda$0();
                }
            });
        }

        private ItemSourceType(String str, int i3, int i4) {
            this.id = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            ItemSourceType[] itemSourceTypeArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(itemSourceTypeArrValues.length), 16));
            for (ItemSourceType itemSourceType : itemSourceTypeArrValues) {
                linkedHashMap.put(Integer.valueOf(itemSourceType.id), itemSourceType);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final ItemSourceType getById(int i3) {
            return Companion.b(i3);
        }

        public static EnumEntries<ItemSourceType> getEntries() {
            return $ENTRIES;
        }

        public static ItemSourceType valueOf(String str) {
            return (ItemSourceType) Enum.valueOf(ItemSourceType.class, str);
        }

        public static ItemSourceType[] values() {
            return (ItemSourceType[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    public IgnoredStatisticsItem(long j3, String name, UsageAccess.Type type, ItemSourceType itemSourceType, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(itemSourceType, "itemSourceType");
        this.f126561a = j3;
        this.f126562b = name;
        this.f126563c = type;
        this.f126564d = itemSourceType;
        this.f126565e = z2;
        this.f126566f = z3;
    }

    public final long a() {
        return this.f126561a;
    }

    public final ItemSourceType b() {
        return this.f126564d;
    }

    public final String c() {
        return this.f126562b;
    }

    public final UsageAccess.Type d() {
        return this.f126563c;
    }

    public final boolean e() {
        return this.f126565e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IgnoredStatisticsItem)) {
            return false;
        }
        IgnoredStatisticsItem ignoredStatisticsItem = (IgnoredStatisticsItem) obj;
        return this.f126561a == ignoredStatisticsItem.f126561a && Intrinsics.areEqual(this.f126562b, ignoredStatisticsItem.f126562b) && this.f126563c == ignoredStatisticsItem.f126563c && this.f126564d == ignoredStatisticsItem.f126564d && this.f126565e == ignoredStatisticsItem.f126565e && this.f126566f == ignoredStatisticsItem.f126566f;
    }

    public final boolean f() {
        return this.f126566f;
    }

    public final void g(boolean z2) {
        this.f126565e = z2;
    }

    public final void h(boolean z2) {
        this.f126566f = z2;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f126561a) * 31) + this.f126562b.hashCode()) * 31) + this.f126563c.hashCode()) * 31) + this.f126564d.hashCode()) * 31) + Boolean.hashCode(this.f126565e)) * 31) + Boolean.hashCode(this.f126566f);
    }

    public final void i(ItemSourceType itemSourceType) {
        Intrinsics.checkNotNullParameter(itemSourceType, "<set-?>");
        this.f126564d = itemSourceType;
    }

    public String toString() {
        return "IgnoredStatisticsItem(id=" + this.f126561a + ", name=" + this.f126562b + ", type=" + this.f126563c + ", itemSourceType=" + this.f126564d + ", isActive=" + this.f126565e + ", isInstalled=" + this.f126566f + ")";
    }

    public /* synthetic */ IgnoredStatisticsItem(long j3, String str, UsageAccess.Type type, ItemSourceType itemSourceType, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, str, type, itemSourceType, (i3 & 16) != 0 ? true : z2, (i3 & 32) != 0 ? false : z3);
    }
}
