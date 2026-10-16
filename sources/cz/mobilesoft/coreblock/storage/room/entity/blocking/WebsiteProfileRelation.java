package cz.mobilesoft.coreblock.storage.room.entity.blocking;

import cz.mobilesoft.coreblock.dto.WebsiteDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.WebsiteProfileRelation;
import java.io.Serializable;
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
import kotlin.text.Regex;

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
public final class WebsiteProfileRelation implements Serializable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f126514h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f126515i = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f126516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f126517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f126518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final BlockingType f126519d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f126520f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f126521g;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class BlockingType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BlockingType[] $VALUES;
        public static final Companion Companion;
        public static final BlockingType DOMAIN = new BlockingType("DOMAIN", 0, 0);
        public static final BlockingType KEYWORD = new BlockingType("KEYWORD", 1, 1);
        private static final Lazy<Map<Integer, BlockingType>> allById$delegate;
        private final int id;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) BlockingType.allById$delegate.getValue();
            }

            public final BlockingType b(int i3) {
                BlockingType blockingType = (BlockingType) a().get(Integer.valueOf(i3));
                return blockingType == null ? BlockingType.DOMAIN : blockingType;
            }

            public final WebsiteDTO c(WebsiteProfileRelation websiteProfileRelation) {
                Intrinsics.checkNotNullParameter(websiteProfileRelation, "<this>");
                return new WebsiteDTO(websiteProfileRelation.c(), websiteProfileRelation.a(), websiteProfileRelation.e(), false, 8, null);
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final BlockingType a(int i3) {
                return BlockingType.Companion.b(i3);
            }

            public final int b(BlockingType blockingType) {
                Intrinsics.checkNotNullParameter(blockingType, "blockingType");
                return blockingType.getId();
            }
        }

        private static final /* synthetic */ BlockingType[] $values() {
            return new BlockingType[]{DOMAIN, KEYWORD};
        }

        static {
            BlockingType[] blockingTypeArr$values = $values();
            $VALUES = blockingTypeArr$values;
            $ENTRIES = EnumEntriesKt.a(blockingTypeArr$values);
            Companion = new Companion(null);
            allById$delegate = LazyKt.b(new Function0() { // from class: f2.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return WebsiteProfileRelation.BlockingType.allById_delegate$lambda$0();
                }
            });
        }

        private BlockingType(String str, int i3, int i4) {
            this.id = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            BlockingType[] blockingTypeArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(blockingTypeArrValues.length), 16));
            for (BlockingType blockingType : blockingTypeArrValues) {
                linkedHashMap.put(Integer.valueOf(blockingType.id), blockingType);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final BlockingType getById(int i3) {
            return Companion.b(i3);
        }

        public static EnumEntries<BlockingType> getEntries() {
            return $ENTRIES;
        }

        public static BlockingType valueOf(String str) {
            return (BlockingType) Enum.valueOf(BlockingType.class, str);
        }

        public static BlockingType[] values() {
            return (BlockingType[]) $VALUES.clone();
        }

        public final int getId() {
            return this.id;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return new Regex(".+[.].+").k(value);
        }

        private Companion() {
        }
    }

    public WebsiteProfileRelation(long j3, long j4, String name, BlockingType blockingType, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(blockingType, "blockingType");
        this.f126516a = j3;
        this.f126517b = j4;
        this.f126518c = name;
        this.f126519d = blockingType;
        this.f126520f = z2;
        this.f126521g = z3;
    }

    public final BlockingType a() {
        return this.f126519d;
    }

    public final long b() {
        return this.f126516a;
    }

    public final String c() {
        return this.f126518c;
    }

    public final long d() {
        return this.f126517b;
    }

    public final boolean e() {
        return this.f126520f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebsiteProfileRelation)) {
            return false;
        }
        WebsiteProfileRelation websiteProfileRelation = (WebsiteProfileRelation) obj;
        return this.f126516a == websiteProfileRelation.f126516a && this.f126517b == websiteProfileRelation.f126517b && Intrinsics.areEqual(this.f126518c, websiteProfileRelation.f126518c) && this.f126519d == websiteProfileRelation.f126519d && this.f126520f == websiteProfileRelation.f126520f && this.f126521g == websiteProfileRelation.f126521g;
    }

    public final boolean f() {
        return this.f126521g;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.f126516a) * 31) + Long.hashCode(this.f126517b)) * 31) + this.f126518c.hashCode()) * 31) + this.f126519d.hashCode()) * 31) + Boolean.hashCode(this.f126520f)) * 31) + Boolean.hashCode(this.f126521g);
    }

    public String toString() {
        return "WebsiteProfileRelation(id=" + this.f126516a + ", profileId=" + this.f126517b + ", name=" + this.f126518c + ", blockingType=" + this.f126519d + ", isAnywhereInUrl=" + this.f126520f + ", isEnabled=" + this.f126521g + ")";
    }

    public /* synthetic */ WebsiteProfileRelation(long j3, long j4, String str, BlockingType blockingType, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j3, j4, str, blockingType, (i3 & 16) != 0 ? false : z2, (i3 & 32) != 0 ? true : z3);
    }
}
