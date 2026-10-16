package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.AnimationKt;
import androidx.compose.animation.core.AnimationVector;
import androidx.compose.animation.core.TargetBasedAnimation;
import androidx.compose.ui.tooling.animation.AnimateXAsStateComposeAnimation;
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
public final class AnimateXAsStateClock<T, V extends AnimationVector> implements ComposeAnimationClock<AnimateXAsStateComposeAnimation<T, V>, TargetState<T>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimateXAsStateComposeAnimation f29885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TargetState f29886b = new TargetState(b().b().n(), b().b().n());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object f29887c = b().d().getValue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TargetBasedAnimation f29888d = c();

    public AnimateXAsStateClock(AnimateXAsStateComposeAnimation animateXAsStateComposeAnimation) {
        this.f29885a = animateXAsStateComposeAnimation;
    }

    private final TargetBasedAnimation c() {
        return AnimationKt.b(b().c(), b().b().m(), d().a(), d().b(), b().b().o());
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long a() {
        return Utils_androidKt.d(this.f29888d.d());
    }

    public AnimateXAsStateComposeAnimation b() {
        return this.f29885a;
    }

    public TargetState d() {
        return this.f29886b;
    }
}
