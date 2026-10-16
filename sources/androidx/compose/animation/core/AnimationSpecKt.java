package androidx.compose.animation.core;

import androidx.compose.animation.core.KeyframesSpec;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AnimationSpecKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final AnimationVector b(TwoWayConverter twoWayConverter, Object obj) {
        if (obj == null) {
            return null;
        }
        return (AnimationVector) twoWayConverter.a().invoke(obj);
    }

    public static final AnimationSpec c(AnimationSpec animationSpec, long j3) {
        return new StartDelayAnimationSpec(animationSpec, j3);
    }

    public static final InfiniteRepeatableSpec d(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3) {
        return new InfiniteRepeatableSpec(durationBasedAnimationSpec, repeatMode, j3, null);
    }

    public static /* synthetic */ InfiniteRepeatableSpec e(DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            repeatMode = RepeatMode.f4052a;
        }
        if ((i3 & 4) != 0) {
            j3 = StartOffset.c(0, 0, 2, null);
        }
        return d(durationBasedAnimationSpec, repeatMode, j3);
    }

    public static final KeyframesSpec f(Function1 function1) {
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        function1.invoke(keyframesSpecConfig);
        return new KeyframesSpec(keyframesSpecConfig);
    }

    public static final RepeatableSpec g(int i3, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3) {
        return new RepeatableSpec(i3, durationBasedAnimationSpec, repeatMode, j3, null);
    }

    public static /* synthetic */ RepeatableSpec h(int i3, DurationBasedAnimationSpec durationBasedAnimationSpec, RepeatMode repeatMode, long j3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            repeatMode = RepeatMode.f4052a;
        }
        if ((i4 & 8) != 0) {
            j3 = StartOffset.c(0, 0, 2, null);
        }
        return g(i3, durationBasedAnimationSpec, repeatMode, j3);
    }

    public static final SnapSpec i(int i3) {
        return new SnapSpec(i3);
    }

    public static /* synthetic */ SnapSpec j(int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return i(i3);
    }

    public static final SpringSpec k(float f3, float f4, Object obj) {
        return new SpringSpec(f3, f4, obj);
    }

    public static /* synthetic */ SpringSpec l(float f3, float f4, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            f3 = 1.0f;
        }
        if ((i3 & 2) != 0) {
            f4 = 1500.0f;
        }
        if ((i3 & 4) != 0) {
            obj = null;
        }
        return k(f3, f4, obj);
    }

    public static final TweenSpec m(int i3, int i4, Easing easing) {
        return new TweenSpec(i3, i4, easing);
    }

    public static /* synthetic */ TweenSpec n(int i3, int i4, Easing easing, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i3 = 300;
        }
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            easing = EasingKt.d();
        }
        return m(i3, i4, easing);
    }
}
