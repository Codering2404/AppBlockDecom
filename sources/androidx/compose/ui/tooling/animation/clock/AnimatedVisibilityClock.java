package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.Transition;
import androidx.compose.ui.tooling.animation.AnimatedVisibilityComposeAnimation;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;

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
public final class AnimatedVisibilityClock implements ComposeAnimationClock<AnimatedVisibilityComposeAnimation, AnimatedVisibilityState> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimatedVisibilityComposeAnimation f29889a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f29890b;

    public AnimatedVisibilityClock(AnimatedVisibilityComposeAnimation animatedVisibilityComposeAnimation) {
        this.f29889a = animatedVisibilityComposeAnimation;
        this.f29890b = ((Boolean) b().a().i()).booleanValue() ? AnimatedVisibilityState.f29907b.b() : AnimatedVisibilityState.f29907b.a();
    }

    private final Pair e(String str) {
        Boolean bool;
        Boolean bool2;
        if (AnimatedVisibilityState.f(str, AnimatedVisibilityState.f29907b.a())) {
            bool = Boolean.FALSE;
            bool2 = Boolean.TRUE;
        } else {
            bool = Boolean.TRUE;
            bool2 = Boolean.FALSE;
        }
        return TuplesKt.a(bool, bool2);
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long a() {
        Transition transitionB = b().b();
        if (transitionB != null) {
            return Utils_androidKt.d(transitionB.r());
        }
        return 0L;
    }

    public AnimatedVisibilityComposeAnimation b() {
        return this.f29889a;
    }

    public String c() {
        return this.f29890b;
    }

    public void d(long j3) {
        Transition transitionA = b().a();
        Pair pairE = e(c());
        Boolean bool = (Boolean) pairE.a();
        bool.booleanValue();
        Boolean bool2 = (Boolean) pairE.b();
        bool2.booleanValue();
        transitionA.H(bool, bool2, j3);
    }
}
