package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import androidx.compose.ui.tooling.animation.states.AnimatedVisibilityState;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

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
public final class AnimatedVisibilityComposeAnimation implements ComposeAnimation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Transition f29804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f29805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ComposeAnimationType f29806c = ComposeAnimationType.ANIMATED_VISIBILITY;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f29807d;

    public AnimatedVisibilityComposeAnimation(Transition transition, String str) {
        this.f29804a = transition;
        this.f29805b = str;
        AnimatedVisibilityState.Companion companion = AnimatedVisibilityState.f29907b;
        this.f29807d = SetsKt.setOf((Object[]) new AnimatedVisibilityState[]{AnimatedVisibilityState.c(companion.a()), AnimatedVisibilityState.c(companion.b())});
    }

    public Transition a() {
        return this.f29804a;
    }

    public final Transition b() {
        Object orNull = CollectionsKt.getOrNull(a().s(), 0);
        if (orNull instanceof Transition) {
            return (Transition) orNull;
        }
        return null;
    }
}
