package androidx.compose.ui.layout;

import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
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
public interface BeyondBoundsLayout {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface BeyondBoundsScope {
        boolean a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    @JvmInline
    public static final class LayoutDirection {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f27041b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f27042c = g(1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f27043d = g(2);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f27044e = g(3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f27045f = g(4);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f27046g = g(5);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f27047h = g(6);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27048a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        /* JADX INFO: loaded from: classes.dex */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final int a() {
                return LayoutDirection.f27046g;
            }

            public final int b() {
                return LayoutDirection.f27043d;
            }

            public final int c() {
                return LayoutDirection.f27042c;
            }

            public final int d() {
                return LayoutDirection.f27047h;
            }

            public final int e() {
                return LayoutDirection.f27044e;
            }

            public final int f() {
                return LayoutDirection.f27045f;
            }

            private Companion() {
            }
        }

        public static int g(int i3) {
            return i3;
        }

        public static boolean h(int i3, Object obj) {
            return (obj instanceof LayoutDirection) && i3 == ((LayoutDirection) obj).l();
        }

        public static final boolean i(int i3, int i4) {
            return i3 == i4;
        }

        public static int j(int i3) {
            return Integer.hashCode(i3);
        }

        public boolean equals(Object obj) {
            return h(this.f27048a, obj);
        }

        public int hashCode() {
            return j(this.f27048a);
        }

        public final /* synthetic */ int l() {
            return this.f27048a;
        }

        public String toString() {
            return k(this.f27048a);
        }

        public static String k(int i3) {
            return i(i3, f27042c) ? cJfnYMIyomoWf.PzW : i(i3, f27043d) ? "After" : i(i3, f27044e) ? "Left" : i(i3, f27045f) ? "Right" : i(i3, f27046g) ? "Above" : i(i3, f27047h) ? "Below" : "invalid LayoutDirection";
        }
    }

    Object i0(int i3, Function1 function1);
}
