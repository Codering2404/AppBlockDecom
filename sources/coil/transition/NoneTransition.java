package coil.transition;

import coil.request.ErrorResult;
import coil.request.ImageResult;
import coil.request.SuccessResult;
import coil.transition.Transition;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class NoneTransition implements Transition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransitionTarget f56201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ImageResult f56202b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Factory implements Transition.Factory {
        @Override // coil.transition.Transition.Factory
        public Transition a(TransitionTarget transitionTarget, ImageResult imageResult) {
            return new NoneTransition(transitionTarget, imageResult);
        }

        public boolean equals(Object obj) {
            return obj instanceof Factory;
        }

        public int hashCode() {
            return Factory.class.hashCode();
        }
    }

    public NoneTransition(TransitionTarget transitionTarget, ImageResult imageResult) {
        this.f56201a = transitionTarget;
        this.f56202b = imageResult;
    }

    @Override // coil.transition.Transition
    public void a() {
        ImageResult imageResult = this.f56202b;
        if (imageResult instanceof SuccessResult) {
            this.f56201a.c(((SuccessResult) imageResult).a());
        } else if (imageResult instanceof ErrorResult) {
            this.f56201a.e(imageResult.a());
        }
    }
}
