package androidx.compose.ui.unit;

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
public final class TextUnitType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f30010b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f30011c = e(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long f30012d = e(4294967296L);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final long f30013e = e(8589934592L);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f30014a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return TextUnitType.f30013e;
        }

        public final long b() {
            return TextUnitType.f30012d;
        }

        public final long c() {
            return TextUnitType.f30011c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextUnitType(long j3) {
        this.f30014a = j3;
    }

    public static final /* synthetic */ TextUnitType d(long j3) {
        return new TextUnitType(j3);
    }

    public static boolean f(long j3, Object obj) {
        return (obj instanceof TextUnitType) && j3 == ((TextUnitType) obj).j();
    }

    public static final boolean g(long j3, long j4) {
        return j3 == j4;
    }

    public static int h(long j3) {
        return Long.hashCode(j3);
    }

    public static String i(long j3) {
        return g(j3, f30011c) ? "Unspecified" : g(j3, f30012d) ? "Sp" : g(j3, f30013e) ? "Em" : "Invalid";
    }

    public boolean equals(Object obj) {
        return f(this.f30014a, obj);
    }

    public int hashCode() {
        return h(this.f30014a);
    }

    public final /* synthetic */ long j() {
        return this.f30014a;
    }

    public String toString() {
        return i(this.f30014a);
    }

    public static long e(long j3) {
        return j3;
    }
}
