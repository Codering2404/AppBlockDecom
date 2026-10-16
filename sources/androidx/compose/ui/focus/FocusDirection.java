package androidx.compose.ui.focus;

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
public final class FocusDirection {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f25444b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f25445c = j(1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f25446d = j(2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f25447e = j(3);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f25448f = j(4);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f25449g = j(5);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f25450h = j(6);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f25451i = j(7);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f25452j = j(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f25453a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return FocusDirection.f25450h;
        }

        public final int b() {
            return FocusDirection.f25451i;
        }

        public final int c() {
            return FocusDirection.f25452j;
        }

        public final int d() {
            return FocusDirection.f25447e;
        }

        public final int e() {
            return FocusDirection.f25445c;
        }

        public final int f() {
            return FocusDirection.f25446d;
        }

        public final int g() {
            return FocusDirection.f25448f;
        }

        public final int h() {
            return FocusDirection.f25449g;
        }

        private Companion() {
        }
    }

    private /* synthetic */ FocusDirection(int i3) {
        this.f25453a = i3;
    }

    public static final /* synthetic */ FocusDirection i(int i3) {
        return new FocusDirection(i3);
    }

    public static boolean k(int i3, Object obj) {
        return (obj instanceof FocusDirection) && i3 == ((FocusDirection) obj).o();
    }

    public static final boolean l(int i3, int i4) {
        return i3 == i4;
    }

    public static int m(int i3) {
        return Integer.hashCode(i3);
    }

    public static String n(int i3) {
        return l(i3, f25445c) ? "Next" : l(i3, f25446d) ? "Previous" : l(i3, f25447e) ? "Left" : l(i3, f25448f) ? "Right" : l(i3, f25449g) ? "Up" : l(i3, f25450h) ? "Down" : l(i3, f25451i) ? "Enter" : l(i3, f25452j) ? "Exit" : "Invalid FocusDirection";
    }

    public boolean equals(Object obj) {
        return k(this.f25453a, obj);
    }

    public int hashCode() {
        return m(this.f25453a);
    }

    public final /* synthetic */ int o() {
        return this.f25453a;
    }

    public String toString() {
        return n(this.f25453a);
    }

    public static int j(int i3) {
        return i3;
    }
}
