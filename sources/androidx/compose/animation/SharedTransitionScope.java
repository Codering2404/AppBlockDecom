package androidx.compose.animation;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;

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
public interface SharedTransitionScope extends LookaheadScope {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface OverlayClip {
        Path a(SharedContentState sharedContentState, Rect rect, LayoutDirection layoutDirection, Density density);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface PlaceHolderSize {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f3640a = new Companion();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final PlaceHolderSize f3641b = new PlaceHolderSize() { // from class: androidx.compose.animation.SharedTransitionScope$PlaceHolderSize$Companion$animatedSize$1
                @Override // androidx.compose.animation.SharedTransitionScope.PlaceHolderSize
                public final long a(long j3, long j4) {
                    return j4;
                }
            };

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private static final PlaceHolderSize f3642c = new PlaceHolderSize() { // from class: androidx.compose.animation.SharedTransitionScope$PlaceHolderSize$Companion$contentSize$1
                @Override // androidx.compose.animation.SharedTransitionScope.PlaceHolderSize
                public final long a(long j3, long j4) {
                    return j3;
                }
            };

            private Companion() {
            }
        }

        long a(long j3, long j4);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface ResizeMode {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f3645a = new Companion();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private static final ResizeMode f3646b = RemeasureImpl.f3579a;

            private Companion() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SharedContentState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f3647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final MutableState f3648b;

        private final SharedElementInternalState d() {
            SharedElementInternalState sharedElementInternalStateB = b();
            if (sharedElementInternalStateB != null) {
                return sharedElementInternalStateB;
            }
            throw new IllegalArgumentException("Error: SharedContentState has not been added to a sharedElement/sharedBoundsmodifier yet. Therefore the internal state has not bee initialized.");
        }

        public final Path a() {
            return d().h();
        }

        public final SharedElementInternalState b() {
            return (SharedElementInternalState) this.f3648b.getValue();
        }

        public final Object c() {
            return this.f3647a;
        }

        public final SharedContentState e() {
            SharedElementInternalState sharedElementInternalStateL = d().l();
            if (sharedElementInternalStateL != null) {
                return sharedElementInternalStateL.t();
            }
            return null;
        }

        public final boolean f() {
            SharedElement sharedElementP;
            SharedElementInternalState sharedElementInternalStateB = b();
            if (sharedElementInternalStateB == null || (sharedElementP = sharedElementInternalStateB.p()) == null) {
                return false;
            }
            return sharedElementP.d();
        }

        public final void g(SharedElementInternalState sharedElementInternalState) {
            this.f3648b.setValue(sharedElementInternalState);
        }
    }

    boolean p();
}
