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
public abstract class ExitTransition {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f3566a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ExitTransition f3567b = new ExitTransitionImpl(new TransitionData(null, null, null, null, false, null, 63, null));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ExitTransition f3568c = new ExitTransitionImpl(new TransitionData(null, null, null, null, true, null, 47, null));

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ExitTransition a() {
            return ExitTransition.f3567b;
        }

        private Companion() {
        }
    }

    public /* synthetic */ ExitTransition(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract TransitionData b();

    public final ExitTransition c(ExitTransition exitTransition) {
        Fade fadeC = exitTransition.b().c();
        if (fadeC == null) {
            fadeC = b().c();
        }
        Slide slideF = exitTransition.b().f();
        if (slideF == null) {
            slideF = b().f();
        }
        ChangeSize changeSizeA = exitTransition.b().a();
        if (changeSizeA == null) {
            changeSizeA = b().a();
        }
        Scale scaleE = exitTransition.b().e();
        if (scaleE == null) {
            scaleE = b().e();
        }
        return new ExitTransitionImpl(new TransitionData(fadeC, slideF, changeSizeA, scaleE, exitTransition.b().d() || b().d(), MapsKt.plus(b().b(), exitTransition.b().b())));
    }

    public boolean equals(Object obj) {
        return (obj instanceof ExitTransition) && Intrinsics.areEqual(((ExitTransition) obj).b(), b());
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        if (Intrinsics.areEqual(this, f3567b)) {
            return "ExitTransition.None";
        }
        if (Intrinsics.areEqual(this, f3568c)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        TransitionData transitionDataB = b();
        StringBuilder sb = new StringBuilder();
        sb.append("ExitTransition: \nFade - ");
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
        sb.append(",\nKeepUntilTransitionsFinished - ");
        sb.append(transitionDataB.d());
        return sb.toString();
    }

    private ExitTransition() {
    }
}
