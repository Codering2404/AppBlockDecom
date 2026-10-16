package androidx.compose.foundation;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@JvmInline
public final class MarqueeAnimationMode {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f5025b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f5026c = c(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f5027d = c(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f5028a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return MarqueeAnimationMode.f5027d;
        }

        private Companion() {
        }
    }

    private /* synthetic */ MarqueeAnimationMode(int i3) {
        this.f5028a = i3;
    }

    public static final /* synthetic */ MarqueeAnimationMode b(int i3) {
        return new MarqueeAnimationMode(i3);
    }

    public static boolean d(int i3, Object obj) {
        return (obj instanceof MarqueeAnimationMode) && i3 == ((MarqueeAnimationMode) obj).h();
    }

    public static final boolean e(int i3, int i4) {
        return i3 == i4;
    }

    public static int f(int i3) {
        return Integer.hashCode(i3);
    }

    public static String g(int i3) {
        if (e(i3, f5026c)) {
            return "Immediately";
        }
        if (e(i3, f5027d)) {
            return "WhileFocused";
        }
        throw new IllegalStateException(("invalid value: " + i3).toString());
    }

    public boolean equals(Object obj) {
        return d(this.f5028a, obj);
    }

    public final /* synthetic */ int h() {
        return this.f5028a;
    }

    public int hashCode() {
        return f(this.f5028a);
    }

    public String toString() {
        return g(this.f5028a);
    }

    private static int c(int i3) {
        return i3;
    }
}
