package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
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
public interface AnimatedContentTransitionScope<S> extends Transition.Segment<S> {
    ContentTransform b(ContentTransform contentTransform, SizeTransform sizeTransform);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @JvmInline
    public static final class SlideDirection {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Companion f3237b = new Companion(null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final int f3238c = a(0);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final int f3239d = a(1);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f3240e = a(2);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final int f3241f = a(3);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final int f3242g = a(4);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final int f3243h = a(5);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f3244a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public static boolean b(int i3, Object obj) {
            return (obj instanceof SlideDirection) && i3 == ((SlideDirection) obj).f();
        }

        public static final boolean c(int i3, int i4) {
            return i3 == i4;
        }

        public static int d(int i3) {
            return Integer.hashCode(i3);
        }

        public static String e(int i3) {
            return c(i3, f3238c) ? "Left" : c(i3, f3239d) ? "Right" : c(i3, f3240e) ? "Up" : c(i3, f3241f) ? "Down" : c(i3, f3242g) ? "Start" : c(i3, f3243h) ? "End" : "Invalid";
        }

        public boolean equals(Object obj) {
            return b(this.f3244a, obj);
        }

        public final /* synthetic */ int f() {
            return this.f3244a;
        }

        public int hashCode() {
            return d(this.f3244a);
        }

        public String toString() {
            return e(this.f3244a);
        }

        public static int a(int i3) {
            return i3;
        }
    }
}
