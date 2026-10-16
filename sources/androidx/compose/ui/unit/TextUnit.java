package androidx.compose.ui.unit;

import androidx.compose.ui.unit.TextUnitType;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
@JvmInline
public final class TextUnit {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30006b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final TextUnitType[] f30007c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f30008d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f30009a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return TextUnit.f30008d;
        }

        private Companion() {
        }
    }

    static {
        TextUnitType.Companion companion = TextUnitType.f30010b;
        f30007c = new TextUnitType[]{TextUnitType.d(companion.c()), TextUnitType.d(companion.b()), TextUnitType.d(companion.a())};
        f30008d = TextUnitKt.l(0L, Float.NaN);
    }

    private /* synthetic */ TextUnit(long j3) {
        this.f30009a = j3;
    }

    public static final /* synthetic */ TextUnit b(long j3) {
        return new TextUnit(j3);
    }

    public static boolean d(long j3, Object obj) {
        return (obj instanceof TextUnit) && j3 == ((TextUnit) obj).m();
    }

    public static final boolean e(long j3, long j4) {
        return j3 == j4;
    }

    public static final long f(long j3) {
        return j3 & 1095216660480L;
    }

    public static final long g(long j3) {
        return f30007c[(int) (f(j3) >>> 32)].j();
    }

    public static final float h(long j3) {
        return Float.intBitsToFloat((int) (j3 & 4294967295L));
    }

    public static int i(long j3) {
        return Long.hashCode(j3);
    }

    public static final boolean j(long j3) {
        return f(j3) == 8589934592L;
    }

    public static final boolean k(long j3) {
        return f(j3) == 4294967296L;
    }

    public static String l(long j3) {
        long jG = g(j3);
        TextUnitType.Companion companion = TextUnitType.f30010b;
        if (TextUnitType.g(jG, companion.c())) {
            return "Unspecified";
        }
        if (TextUnitType.g(jG, companion.b())) {
            return h(j3) + ".sp";
        }
        if (!TextUnitType.g(jG, companion.a())) {
            return "Invalid";
        }
        return h(j3) + ".em";
    }

    public boolean equals(Object obj) {
        return d(this.f30009a, obj);
    }

    public int hashCode() {
        return i(this.f30009a);
    }

    public final /* synthetic */ long m() {
        return this.f30009a;
    }

    public String toString() {
        return l(this.f30009a);
    }

    public static long c(long j3) {
        return j3;
    }
}
