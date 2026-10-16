package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.collections.MapsKt;
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
public abstract class EnterTransition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f3563a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final EnterTransition f3564b = new EnterTransitionImpl(new TransitionData(null, null, null, null, false, null, 63, null));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EnterTransition a() {
            return EnterTransition.f3564b;
        }

        private Companion() {
        }
    }

    public /* synthetic */ EnterTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TransitionData b();

    public final EnterTransition c(EnterTransition enterTransition) {
        Fade fadeC = enterTransition.b().c();
        if (fadeC == null) {
            fadeC = b().c();
        }
        Slide slideF = enterTransition.b().f();
        if (slideF == null) {
            slideF = b().f();
        }
        ChangeSize changeSizeA = enterTransition.b().a();
        if (changeSizeA == null) {
            changeSizeA = b().a();
        }
        Scale scaleE = enterTransition.b().e();
        if (scaleE == null) {
            scaleE = b().e();
        }
        return new EnterTransitionImpl(new TransitionData(fadeC, slideF, changeSizeA, scaleE, false, MapsKt.plus(b().b(), enterTransition.b().b()), 16, null));
    }

    public boolean equals(Object obj) {
        return (obj instanceof EnterTransition) && Intrinsics.areEqual(((EnterTransition) obj).b(), b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        if (Intrinsics.areEqual(this, f3564b)) {
            return "EnterTransition.None";
        }
        TransitionData transitionDataB = b();
        StringBuilder sb = new StringBuilder();
        sb.append("EnterTransition: \nFade - ");
        Fade fadeC = transitionDataB.c();
        sb.append(fadeC != null ? fadeC.toString() : null);
        sb.append(",\nSlide - ");
        Slide slideF = transitionDataB.f();
        sb.append(slideF != null ? slideF.toString() : null);
        sb.append(",\nShrink - ");
        ChangeSize changeSizeA = transitionDataB.a();
        sb.append(changeSizeA != null ? changeSizeA.toString() : null);
        sb.append(",\nScale - ");
        Scale scaleE = transitionDataB.e();
        sb.append(scaleE != null ? scaleE.toString() : null);
        return sb.toString();
    }

    private EnterTransition() {
    }
}
