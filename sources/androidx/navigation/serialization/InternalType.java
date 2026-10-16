package androidx.navigation.serialization;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
final class InternalType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final InternalType f49431a = new InternalType("INT", 0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InternalType f49432b = new InternalType("INT_NULLABLE", 1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InternalType f49433c = new InternalType("BOOL", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final InternalType f49434d = new InternalType("BOOL_NULLABLE", 3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final InternalType f49435f = new InternalType("DOUBLE", 4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final InternalType f49436g = new InternalType("DOUBLE_NULLABLE", 5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final InternalType f49437h = new InternalType("FLOAT", 6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final InternalType f49438i = new InternalType("FLOAT_NULLABLE", 7);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final InternalType f49439j = new InternalType("LONG", 8);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final InternalType f49440k = new InternalType("LONG_NULLABLE", 9);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final InternalType f49441l = new InternalType("STRING", 10);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final InternalType f49442m = new InternalType("STRING_NULLABLE", 11);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final InternalType f49443n = new InternalType("INT_ARRAY", 12);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final InternalType f49444o = new InternalType("BOOL_ARRAY", 13);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final InternalType f49445p = new InternalType("DOUBLE_ARRAY", 14);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final InternalType f49446q = new InternalType("FLOAT_ARRAY", 15);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final InternalType f49447r = new InternalType("LONG_ARRAY", 16);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final InternalType f49448s = new InternalType("ARRAY", 17);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final InternalType f49449t = new InternalType("LIST", 18);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final InternalType f49450u = new InternalType("ENUM", 19);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final InternalType f49451v = new InternalType("ENUM_NULLABLE", 20);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final InternalType f49452w = new InternalType("UNKNOWN", 21);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private static final /* synthetic */ InternalType[] f49453x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f49454y;

    static {
        InternalType[] internalTypeArrA = a();
        f49453x = internalTypeArrA;
        f49454y = EnumEntriesKt.a(internalTypeArrA);
    }

    private InternalType(String str, int i3) {
    }

    private static final /* synthetic */ InternalType[] a() {
        return new InternalType[]{f49431a, f49432b, f49433c, f49434d, f49435f, f49436g, f49437h, f49438i, f49439j, f49440k, f49441l, f49442m, f49443n, f49444o, f49445p, f49446q, f49447r, f49448s, f49449t, f49450u, f49451v, f49452w};
    }

    public static InternalType valueOf(String str) {
        return (InternalType) Enum.valueOf(InternalType.class, str);
    }

    public static InternalType[] values() {
        return (InternalType[]) f49453x.clone();
    }
}
