package androidx.compose.ui.tooling.animation.clock;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec;
import androidx.compose.ui.tooling.animation.InfiniteTransitionComposeAnimation;
import androidx.compose.ui.tooling.animation.states.TargetState;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class InfiniteTransitionClock implements ComposeAnimationClock<InfiniteTransitionComposeAnimation, TargetState<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InfiniteTransitionComposeAnimation f29891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function0 f29892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private TargetState f29893c = new TargetState(0, 0);

    /* JADX INFO: renamed from: androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function0<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f29894a = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Long invoke() {
            return 0L;
        }
    }

    public InfiniteTransitionClock(InfiniteTransitionComposeAnimation infiniteTransitionComposeAnimation, Function0 function0) {
        this.f29891a = infiniteTransitionComposeAnimation;
        this.f29892b = function0;
    }

    private final long c(InfiniteTransition.TransitionAnimationState transitionAnimationState) {
        AnimationSpec animationSpecI = transitionAnimationState.i();
        Intrinsics.checkNotNull(animationSpecI, "null cannot be cast to non-null type androidx.compose.animation.core.InfiniteRepeatableSpec<T of androidx.compose.ui.tooling.animation.clock.InfiniteTransitionClock.getIterationDuration>");
        InfiniteRepeatableSpec infiniteRepeatableSpec = (InfiniteRepeatableSpec) animationSpecI;
        int i3 = infiniteRepeatableSpec.h() == RepeatMode.f4053b ? 2 : 1;
        VectorizedDurationBasedAnimationSpec vectorizedDurationBasedAnimationSpecA = infiniteRepeatableSpec.f().a(transitionAnimationState.q());
        return Utils_androidKt.c(((long) vectorizedDurationBasedAnimationSpecA.c()) + ((long) (vectorizedDurationBasedAnimationSpecA.e() * i3)));
    }

    @Override // androidx.compose.ui.tooling.animation.clock.ComposeAnimationClock
    public long a() {
        return Math.max(d(), ((Number) this.f29892b.invoke()).longValue());
    }

    public InfiniteTransitionComposeAnimation b() {
        return this.f29891a;
    }

    public long d() {
        Long l3;
        Iterator it = b().b().g().iterator();
        if (it.hasNext()) {
            Long lValueOf = Long.valueOf(c((InfiniteTransition.TransitionAnimationState) it.next()));
            while (it.hasNext()) {
                Long lValueOf2 = Long.valueOf(c((InfiniteTransition.TransitionAnimationState) it.next()));
                if (lValueOf.compareTo(lValueOf2) < 0) {
                    lValueOf = lValueOf2;
                }
            }
            l3 = lValueOf;
        } else {
            l3 = null;
        }
        return Utils_androidKt.d(l3 != null ? l3.longValue() : 0L);
    }
}
