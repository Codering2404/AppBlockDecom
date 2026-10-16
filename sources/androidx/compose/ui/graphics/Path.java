package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.graphics.PathIterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

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
public interface Path {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f25826a = Companion.f25827a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f25827a = new Companion();

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Direction {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Direction f25828a = new Direction("CounterClockwise", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Direction f25829b = new Direction("Clockwise", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ Direction[] f25830c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f25831d;

        static {
            Direction[] directionArrA = a();
            f25830c = directionArrA;
            f25831d = EnumEntriesKt.a(directionArrA);
        }

        private Direction(String str, int i3) {
        }

        private static final /* synthetic */ Direction[] a() {
            return new Direction[]{f25828a, f25829b};
        }

        public static Direction valueOf(String str) {
            return (Direction) Enum.valueOf(Direction.class, str);
        }

        public static Direction[] values() {
            return (Direction[]) f25830c.clone();
        }
    }

    static /* synthetic */ void d(Path path, Rect rect, Direction direction, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRect");
        }
        if ((i3 & 2) != 0) {
            direction = Direction.f25828a;
        }
        path.o(rect, direction);
    }

    static /* synthetic */ void l(Path path, Rect rect, Direction direction, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addOval");
        }
        if ((i3 & 2) != 0) {
            direction = Direction.f25828a;
        }
        path.n(rect, direction);
    }

    static /* synthetic */ void s(Path path, RoundRect roundRect, Direction direction, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addRoundRect");
        }
        if ((i3 & 2) != 0) {
            direction = Direction.f25828a;
        }
        path.z(roundRect, direction);
    }

    static /* synthetic */ void u(Path path, Path path2, long j3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
        }
        if ((i3 & 2) != 0) {
            j3 = Offset.f25596b.c();
        }
        path.y(path2, j3);
    }

    void a(float f3, float f4);

    void b(float f3, float f4, float f5, float f6, float f7, float f8);

    void c(float f3, float f4);

    void close();

    boolean e();

    void f(float f3, float f4);

    void g(float f3, float f4, float f5, float f6, float f7, float f8);

    Rect getBounds();

    void h(float f3, float f4, float f5, float f6);

    default PathIterator i(PathIterator.ConicEvaluation conicEvaluation, float f3) {
        return AndroidPathIterator_androidKt.a(this, conicEvaluation, f3);
    }

    boolean isEmpty();

    void j(float f3, float f4, float f5, float f6);

    void k(int i3);

    default void m(float f3, float f4, float f5, float f6) {
        h(f3, f4, f5, f6);
    }

    void n(Rect rect, Direction direction);

    void o(Rect rect, Direction direction);

    void p(long j3);

    default void q(float f3, float f4, float f5, float f6) {
        j(f3, f4, f5, f6);
    }

    default void r() {
        reset();
    }

    void reset();

    int t();

    boolean v(Path path, Path path2, int i3);

    void w(Rect rect, float f3, float f4, boolean z2);

    void x(float f3, float f4);

    void y(Path path, long j3);

    void z(RoundRect roundRect, Direction direction);
}
