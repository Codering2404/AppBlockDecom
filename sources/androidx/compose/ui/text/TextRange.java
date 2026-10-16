package androidx.compose.ui.text;

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
public final class TextRange {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f28921b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final long f28922c = TextRangeKt.a(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f28923a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return TextRange.f28922c;
        }

        private Companion() {
        }
    }

    private /* synthetic */ TextRange(long j3) {
        this.f28923a = j3;
    }

    public static final /* synthetic */ TextRange b(long j3) {
        return new TextRange(j3);
    }

    public static final boolean d(long j3, long j4) {
        return (l(j3) <= l(j4)) & (k(j4) <= k(j3));
    }

    public static final boolean e(long j3, int i3) {
        return i3 < k(j3) && l(j3) <= i3;
    }

    public static boolean f(long j3, Object obj) {
        return (obj instanceof TextRange) && j3 == ((TextRange) obj).r();
    }

    public static final boolean g(long j3, long j4) {
        return j3 == j4;
    }

    public static final boolean h(long j3) {
        return n(j3) == i(j3);
    }

    public static final int i(long j3) {
        return (int) (j3 & 4294967295L);
    }

    public static final int j(long j3) {
        return k(j3) - l(j3);
    }

    public static final int k(long j3) {
        return Math.max(n(j3), i(j3));
    }

    public static final int l(long j3) {
        return Math.min(n(j3), i(j3));
    }

    public static final boolean m(long j3) {
        return n(j3) > i(j3);
    }

    public static final int n(long j3) {
        return (int) (j3 >> 32);
    }

    public static int o(long j3) {
        return Long.hashCode(j3);
    }

    public static final boolean p(long j3, long j4) {
        return (l(j3) < k(j4)) & (l(j4) < k(j3));
    }

    public static String q(long j3) {
        return "TextRange(" + n(j3) + ", " + i(j3) + ')';
    }

    public boolean equals(Object obj) {
        return f(this.f28923a, obj);
    }

    public int hashCode() {
        return o(this.f28923a);
    }

    public final /* synthetic */ long r() {
        return this.f28923a;
    }

    public String toString() {
        return q(this.f28923a);
    }

    public static long c(long j3) {
        return j3;
    }
}
