package androidx.compose.ui.tooling.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.tooling.ComposeAnimation;
import androidx.compose.animation.tooling.ComposeAnimationType;
import java.util.Set;
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
public final class TransitionComposeAnimation<T> implements ComposeAnimation, TransitionBasedAnimation<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Transition f29874a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set f29875b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f29876c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ComposeAnimationType f29877d = ComposeAnimationType.TRANSITION_ANIMATION;

    public TransitionComposeAnimation(Transition transition, Set set, String str) {
        this.f29874a = transition;
        this.f29875b = set;
        this.f29876c = str;
    }

    @Override // androidx.compose.ui.tooling.animation.TransitionBasedAnimation
    public Transition a() {
        return this.f29874a;
    }
}
