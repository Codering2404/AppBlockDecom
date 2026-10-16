package coil.transition;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.drawable.CrossfadeDrawable;
import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.size.Scale;
import coil.transition.Transition;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CrossfadeTransition implements Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransitionTarget f56195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageResult f56196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f56197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f56198d;

    public CrossfadeTransition(TransitionTarget transitionTarget, ImageResult imageResult, int i3, boolean z2) {
        this.f56195a = transitionTarget;
        this.f56196b = imageResult;
        this.f56197c = i3;
        this.f56198d = z2;
        if (i3 <= 0) {
            throw new IllegalArgumentException("durationMillis must be > 0.");
        }
    }

    @Override // coil.transition.Transition
    public void a() {
        Drawable drawableF = this.f56195a.f();
        Drawable drawableA = this.f56196b.a();
        Scale scaleJ = this.f56196b.b().J();
        int i3 = this.f56197c;
        ImageResult imageResult = this.f56196b;
        CrossfadeDrawable crossfadeDrawable = new CrossfadeDrawable(drawableF, drawableA, scaleJ, i3, ((imageResult instanceof SuccessResult) && ((SuccessResult) imageResult).d()) ? false : true, this.f56198d);
        ImageResult imageResult2 = this.f56196b;
        if (imageResult2 instanceof SuccessResult) {
            this.f56195a.c(crossfadeDrawable);
        } else if (imageResult2 instanceof ErrorResult) {
            this.f56195a.e(crossfadeDrawable);
        }
    }

    public final int b() {
        return this.f56197c;
    }

    public final boolean c() {
        return this.f56198d;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Transition.Factory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f56199c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f56200d;

        public Factory(int i3, boolean z2) {
            this.f56199c = i3;
            this.f56200d = z2;
            if (i3 <= 0) {
                throw new IllegalArgumentException("durationMillis must be > 0.");
            }
        }

        @Override // coil.transition.Transition.Factory
        public Transition a(TransitionTarget transitionTarget, ImageResult imageResult) {
            return !(imageResult instanceof SuccessResult) ? Transition.Factory.f56204b.a(transitionTarget, imageResult) : ((SuccessResult) imageResult).c() == DataSource.MEMORY_CACHE ? Transition.Factory.f56204b.a(transitionTarget, imageResult) : new CrossfadeTransition(transitionTarget, imageResult, this.f56199c, this.f56200d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Factory)) {
                return false;
            }
            Factory factory = (Factory) obj;
            return this.f56199c == factory.f56199c && this.f56200d == factory.f56200d;
        }

        public int hashCode() {
            return (this.f56199c * 31) + Boolean.hashCode(this.f56200d);
        }

        public /* synthetic */ Factory(int i3, boolean z2, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this((i4 & 1) != 0 ? 100 : i3, (i4 & 2) != 0 ? false : z2);
        }
    }
}
