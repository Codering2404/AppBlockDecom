package kotlin.text;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class CharDirectionality {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f140484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Lazy f140485c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CharDirectionality f140486d = new CharDirectionality("UNDEFINED", 0, -1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CharDirectionality f140487f = new CharDirectionality("LEFT_TO_RIGHT", 1, 0);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final CharDirectionality f140488g = new CharDirectionality("RIGHT_TO_LEFT", 2, 1);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CharDirectionality f140489h = new CharDirectionality("RIGHT_TO_LEFT_ARABIC", 3, 2);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final CharDirectionality f140490i = new CharDirectionality("EUROPEAN_NUMBER", 4, 3);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final CharDirectionality f140491j = new CharDirectionality("EUROPEAN_NUMBER_SEPARATOR", 5, 4);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CharDirectionality f140492k = new CharDirectionality("EUROPEAN_NUMBER_TERMINATOR", 6, 5);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final CharDirectionality f140493l = new CharDirectionality("ARABIC_NUMBER", 7, 6);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final CharDirectionality f140494m = new CharDirectionality("COMMON_NUMBER_SEPARATOR", 8, 7);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final CharDirectionality f140495n = new CharDirectionality("NONSPACING_MARK", 9, 8);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final CharDirectionality f140496o = new CharDirectionality("BOUNDARY_NEUTRAL", 10, 9);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final CharDirectionality f140497p = new CharDirectionality("PARAGRAPH_SEPARATOR", 11, 10);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final CharDirectionality f140498q = new CharDirectionality("SEGMENT_SEPARATOR", 12, 11);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final CharDirectionality f140499r = new CharDirectionality("WHITESPACE", 13, 12);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final CharDirectionality f140500s = new CharDirectionality("OTHER_NEUTRALS", 14, 13);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final CharDirectionality f140501t = new CharDirectionality("LEFT_TO_RIGHT_EMBEDDING", 15, 14);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final CharDirectionality f140502u = new CharDirectionality("LEFT_TO_RIGHT_OVERRIDE", 16, 15);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final CharDirectionality f140503v = new CharDirectionality("RIGHT_TO_LEFT_EMBEDDING", 17, 16);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final CharDirectionality f140504w = new CharDirectionality("RIGHT_TO_LEFT_OVERRIDE", 18, 17);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final CharDirectionality f140505x = new CharDirectionality("POP_DIRECTIONAL_FORMAT", 19, 18);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final /* synthetic */ CharDirectionality[] f140506y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f140507z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f140508a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        CharDirectionality[] charDirectionalityArrB = b();
        f140506y = charDirectionalityArrB;
        f140507z = EnumEntriesKt.a(charDirectionalityArrB);
        f140484b = new Companion(null);
        f140485c = LazyKt.b(new Function0() { // from class: kotlin.text.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return CharDirectionality.c();
            }
        });
    }

    private CharDirectionality(String str, int i3, int i4) {
        this.f140508a = i4;
    }

    private static final /* synthetic */ CharDirectionality[] b() {
        return new CharDirectionality[]{f140486d, f140487f, f140488g, f140489h, f140490i, f140491j, f140492k, f140493l, f140494m, f140495n, f140496o, f140497p, f140498q, f140499r, f140500s, f140501t, f140502u, f140503v, f140504w, f140505x};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map c() {
        EnumEntries enumEntriesD = d();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.f(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(enumEntriesD, 10)), 16));
        for (Object obj : enumEntriesD) {
            linkedHashMap.put(Integer.valueOf(((CharDirectionality) obj).f140508a), obj);
        }
        return linkedHashMap;
    }

    public static EnumEntries d() {
        return f140507z;
    }

    public static CharDirectionality valueOf(String str) {
        return (CharDirectionality) Enum.valueOf(CharDirectionality.class, str);
    }

    public static CharDirectionality[] values() {
        return (CharDirectionality[]) f140506y.clone();
    }
}
