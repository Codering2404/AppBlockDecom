package androidx.compose.ui.text.input;

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
public final class KeyboardCapitalization {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29372b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29373c = g(-1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29374d = g(0);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29375e = g(1);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29376f = g(2);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f29377g = g(3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29378a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return KeyboardCapitalization.f29375e;
        }

        public final int b() {
            return KeyboardCapitalization.f29374d;
        }

        public final int c() {
            return KeyboardCapitalization.f29377g;
        }

        public final int d() {
            return KeyboardCapitalization.f29373c;
        }

        public final int e() {
            return KeyboardCapitalization.f29376f;
        }

        private Companion() {
        }
    }

    private /* synthetic */ KeyboardCapitalization(int i3) {
        this.f29378a = i3;
    }

    public static final /* synthetic */ KeyboardCapitalization f(int i3) {
        return new KeyboardCapitalization(i3);
    }

    public static boolean h(int i3, Object obj) {
        return (obj instanceof KeyboardCapitalization) && i3 == ((KeyboardCapitalization) obj).l();
    }

    public static final boolean i(int i3, int i4) {
        return i3 == i4;
    }

    public static int j(int i3) {
        return Integer.hashCode(i3);
    }

    public static String k(int i3) {
        return i(i3, f29373c) ? "Unspecified" : i(i3, f29374d) ? "None" : i(i3, f29375e) ? "Characters" : i(i3, f29376f) ? "Words" : i(i3, f29377g) ? "Sentences" : "Invalid";
    }

    public boolean equals(Object obj) {
        return h(this.f29378a, obj);
    }

    public int hashCode() {
        return j(this.f29378a);
    }

    public final /* synthetic */ int l() {
        return this.f29378a;
    }

    public String toString() {
        return k(this.f29378a);
    }

    private static int g(int i3) {
        return i3;
    }
}
