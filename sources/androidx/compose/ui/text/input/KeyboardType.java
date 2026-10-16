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
public final class KeyboardType {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f29379b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f29380c = l(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f29381d = l(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f29382e = l(2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f29383f = l(3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f29384g = l(4);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f29385h = l(5);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f29386i = l(6);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f29387j = l(7);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f29388k = l(8);

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f29389l = l(9);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f29390a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return KeyboardType.f29382e;
        }

        public final int b() {
            return KeyboardType.f29389l;
        }

        public final int c() {
            return KeyboardType.f29386i;
        }

        public final int d() {
            return KeyboardType.f29383f;
        }

        public final int e() {
            return KeyboardType.f29388k;
        }

        public final int f() {
            return KeyboardType.f29387j;
        }

        public final int g() {
            return KeyboardType.f29384g;
        }

        public final int h() {
            return KeyboardType.f29381d;
        }

        public final int i() {
            return KeyboardType.f29380c;
        }

        public final int j() {
            return KeyboardType.f29385h;
        }

        private Companion() {
        }
    }

    private /* synthetic */ KeyboardType(int i3) {
        this.f29390a = i3;
    }

    public static final /* synthetic */ KeyboardType k(int i3) {
        return new KeyboardType(i3);
    }

    public static boolean m(int i3, Object obj) {
        return (obj instanceof KeyboardType) && i3 == ((KeyboardType) obj).q();
    }

    public static final boolean n(int i3, int i4) {
        return i3 == i4;
    }

    public static int o(int i3) {
        return Integer.hashCode(i3);
    }

    public static String p(int i3) {
        return n(i3, f29380c) ? "Unspecified" : n(i3, f29381d) ? "Text" : n(i3, f29382e) ? "Ascii" : n(i3, f29383f) ? "Number" : n(i3, f29384g) ? "Phone" : n(i3, f29385h) ? "Uri" : n(i3, f29386i) ? "Email" : n(i3, f29387j) ? "Password" : n(i3, f29388k) ? "NumberPassword" : n(i3, f29389l) ? "Decimal" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m(this.f29390a, obj);
    }

    public int hashCode() {
        return o(this.f29390a);
    }

    public final /* synthetic */ int q() {
        return this.f29390a;
    }

    public String toString() {
        return p(this.f29390a);
    }

    private static int l(int i3) {
        return i3;
    }
}
