package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.ui.tooling.animation.TransitionBasedAnimation;
import androidx.compose.ui.tooling.animation.states.TargetState;
import kotlin.Metadata;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TransitionClock<T> implements ComposeAnimationClock<TransitionBasedAnimation<T>, TargetState<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final TransitionBasedAnimation f29895a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TargetState f29896b = new TargetState(b().a().i(), b().a().q());

    public TransitionClock(TransitionBasedAnimation transitionBasedAnimation) {
        this.f29895a = transitionBasedAnimation;
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long a() {
        return Utils_androidKt.d(b().a().r());
    }

    public TransitionBasedAnimation b() {
        return this.f29895a;
    }
}
