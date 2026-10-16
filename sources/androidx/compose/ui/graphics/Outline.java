package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import kotlin.Metadata;
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
public abstract class Outline {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Generic extends Outline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Path f25818a;

        public Generic(Path path) {
            super(null);
            this.f25818a = path;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public Rect a() {
            return this.f25818a.getBounds();
        }

        public final Path b() {
            return this.f25818a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Rectangle extends Outline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Rect f25819a;

        public Rectangle(Rect rect) {
            super(null);
            this.f25819a = rect;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public Rect a() {
            return this.f25819a;
        }

        public final Rect b() {
            return this.f25819a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rectangle) && Intrinsics.areEqual(this.f25819a, ((Rectangle) obj).f25819a);
        }

        public int hashCode() {
            return this.f25819a.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Rounded extends Outline {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RoundRect f25820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Path f25821b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Rounded(RoundRect roundRect) {
            super(0 == true ? 1 : 0);
            Path path = null;
            this.f25820a = roundRect;
            if (!RoundRectKt.g(roundRect)) {
                Path pathA = AndroidPath_androidKt.a();
                Path.s(pathA, roundRect, null, 2, null);
                path = pathA;
            }
            this.f25821b = path;
        }

        @Override // androidx.compose.ui.graphics.Outline
        public Rect a() {
            return RoundRectKt.f(this.f25820a);
        }

        public final RoundRect b() {
            return this.f25820a;
        }

        public final Path c() {
            return this.f25821b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rounded) && Intrinsics.areEqual(this.f25820a, ((Rounded) obj).f25820a);
        }

        public int hashCode() {
            return this.f25820a.hashCode();
        }
    }

    public /* synthetic */ Outline(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract Rect a();

    private Outline() {
    }
}
