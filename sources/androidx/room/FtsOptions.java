package androidx.room;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class FtsOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FtsOptions f52155a = new FtsOptions();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MatchInfo {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final MatchInfo f52156a = new MatchInfo("FTS3", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final MatchInfo f52157b = new MatchInfo("FTS4", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ MatchInfo[] f52158c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f52159d;

        static {
            MatchInfo[] matchInfoArrA = a();
            f52158c = matchInfoArrA;
            f52159d = EnumEntriesKt.a(matchInfoArrA);
        }

        private MatchInfo(String str, int i3) {
        }

        private static final /* synthetic */ MatchInfo[] a() {
            return new MatchInfo[]{f52156a, f52157b};
        }

        public static MatchInfo valueOf(String str) {
            return (MatchInfo) Enum.valueOf(MatchInfo.class, str);
        }

        public static MatchInfo[] values() {
            return (MatchInfo[]) f52158c.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Order {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Order f52160a = new Order("ASC", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Order f52161b = new Order("DESC", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Order[] f52162c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f52163d;

        static {
            Order[] orderArrA = a();
            f52162c = orderArrA;
            f52163d = EnumEntriesKt.a(orderArrA);
        }

        private Order(String str, int i3) {
        }

        private static final /* synthetic */ Order[] a() {
            return new Order[]{f52160a, f52161b};
        }

        public static Order valueOf(String str) {
            return (Order) Enum.valueOf(Order.class, str);
        }

        public static Order[] values() {
            return (Order[]) f52162c.clone();
        }
    }

    private FtsOptions() {
    }
}
