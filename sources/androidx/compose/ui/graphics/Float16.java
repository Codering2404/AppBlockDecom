package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class Float16 implements Comparable<Float16> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25749b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final short f25750c = c(5120);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final short f25751d = c(-1025);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final short f25752f = c(31743);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final short f25753g = c(1024);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final short f25754h = c(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final short f25755i = c(32256);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final short f25756j = c(-1024);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final short f25757k = c(Short.MIN_VALUE);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final short f25758l = c(31744);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final short f25759m = c(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final short f25760a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int b(short s2, short s3) {
        if (f(s2)) {
            return !f(s3) ? 1 : 0;
        }
        if (f(s3)) {
            return -1;
        }
        return Intrinsics.compare((s2 & Short.MIN_VALUE) != 0 ? 32768 - (s2 & 65535) : s2 & 65535, (s3 & Short.MIN_VALUE) != 0 ? 32768 - (s3 & 65535) : s3 & 65535);
    }

    public static boolean d(short s2, Object obj) {
        return (obj instanceof Float16) && s2 == ((Float16) obj).i();
    }

    public static int e(short s2) {
        return Short.hashCode(s2);
    }

    public static final boolean f(short s2) {
        return (s2 & Short.MAX_VALUE) > 31744;
    }

    public static final float g(short s2) {
        int i3;
        int i4;
        int i5;
        int i6 = Short.MIN_VALUE & s2;
        int i7 = ((65535 & s2) >>> 10) & 31;
        int i8 = s2 & 1023;
        if (i7 != 0) {
            int i9 = i8 << 13;
            if (i7 == 31) {
                i3 = 255;
                if (i9 != 0) {
                    i9 |= 4194304;
                }
            } else {
                i3 = i7 + 112;
            }
            int i10 = i3;
            i4 = i9;
            i5 = i10;
        } else {
            if (i8 != 0) {
                float fIntBitsToFloat = Float.intBitsToFloat(i8 + 1056964608) - Float16Kt.f25761a;
                return i6 == 0 ? fIntBitsToFloat : -fIntBitsToFloat;
            }
            i5 = 0;
            i4 = 0;
        }
        return Float.intBitsToFloat((i5 << 23) | (i6 << 16) | i4);
    }

    public static String h(short s2) {
        return String.valueOf(g(s2));
    }

    public int a(short s2) {
        return b(this.f25760a, s2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Float16 float16) {
        return a(float16.i());
    }

    public boolean equals(Object obj) {
        return d(this.f25760a, obj);
    }

    public int hashCode() {
        return e(this.f25760a);
    }

    public final /* synthetic */ short i() {
        return this.f25760a;
    }

    public String toString() {
        return h(this.f25760a);
    }

    public static short c(short s2) {
        return s2;
    }
}
