package cz.mobilesoft.coreblock.dto;

import cz.mobilesoft.coreblock.dto.UsageAccess;
import cz.mobilesoft.statistics.api.Recordable;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class UsageAccess implements Recordable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f96946g = new Companion(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f96947h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f96948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f96949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f96950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f96951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f96952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f96953f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Companion Companion;
        private static final Lazy<Map<Integer, Type>> allById$delegate;
        private final int typeId;
        public static final Type APPLICATION = new Type("APPLICATION", 0, 0);
        public static final Type WEBSITE = new Type("WEBSITE", 1, 1);
        public static final Type UNLOCK = new Type("UNLOCK", 2, 2);

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final Map a() {
                return (Map) Type.allById$delegate.getValue();
            }

            public final Type b(int i3) {
                Type type = (Type) a().get(Integer.valueOf(i3));
                return type == null ? Type.APPLICATION : type;
            }

            private Companion() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Converter {
            public final Type a(int i3) {
                return Type.Companion.b(i3);
            }

            public final int b(Type type) {
                Intrinsics.checkNotNullParameter(type, "type");
                return type.getTypeId();
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{APPLICATION, WEBSITE, UNLOCK};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.a(typeArr$values);
            Companion = new Companion(null);
            allById$delegate = LazyKt.b(new Function0() { // from class: cz.mobilesoft.coreblock.dto.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return UsageAccess.Type.allById_delegate$lambda$0();
                }
            });
        }

        private Type(String str, int i3, int i4) {
            this.typeId = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Map allById_delegate$lambda$0() {
            Type[] typeArrValues = values();
            LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(typeArrValues.length), 16));
            for (Type type : typeArrValues) {
                linkedHashMap.put(Integer.valueOf(type.typeId), type);
            }
            return linkedHashMap;
        }

        @JvmStatic
        public static final Type getById(int i3) {
            return Companion.b(i3);
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        public final int getTypeId() {
            return this.typeId;
        }
    }

    public UsageAccess(Type type, String name, long j3, long j4, String str, String str2) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(name, "name");
        this.f96948a = type;
        this.f96949b = name;
        this.f96950c = j3;
        this.f96951d = j4;
        this.f96952e = str;
        this.f96953f = str2;
    }

    @Override // cz.mobilesoft.statistics.api.Recordable
    public int a() {
        return this.f96948a.getTypeId();
    }

    @Override // cz.mobilesoft.statistics.api.Recordable
    public String b() {
        return this.f96952e;
    }

    @Override // cz.mobilesoft.statistics.api.Recordable
    public long c() {
        return this.f96951d;
    }

    @Override // cz.mobilesoft.statistics.api.Recordable
    public long d() {
        return this.f96950c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsageAccess)) {
            return false;
        }
        UsageAccess usageAccess = (UsageAccess) obj;
        return this.f96948a == usageAccess.f96948a && Intrinsics.areEqual(this.f96949b, usageAccess.f96949b) && this.f96950c == usageAccess.f96950c && this.f96951d == usageAccess.f96951d && Intrinsics.areEqual(this.f96952e, usageAccess.f96952e) && Intrinsics.areEqual(this.f96953f, usageAccess.f96953f);
    }

    @Override // cz.mobilesoft.statistics.api.Recordable
    public String getCategory() {
        return this.f96953f;
    }

    @Override // cz.mobilesoft.statistics.api.Recordable
    public String getName() {
        return this.f96949b;
    }

    public int hashCode() {
        int iHashCode = ((((((this.f96948a.hashCode() * 31) + this.f96949b.hashCode()) * 31) + Long.hashCode(this.f96950c)) * 31) + Long.hashCode(this.f96951d)) * 31;
        String str = this.f96952e;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f96953f;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "UsageAccess{name='" + getName() + "', parentName='" + b() + "', beginTime=" + d() + ", endTime=" + c() + ", type=" + this.f96948a + "}";
    }

    public /* synthetic */ UsageAccess(Type type, String str, long j3, long j4, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(type, str, j3, j4, (i3 & 16) != 0 ? null : str2, (i3 & 32) != 0 ? null : str3);
    }
}
