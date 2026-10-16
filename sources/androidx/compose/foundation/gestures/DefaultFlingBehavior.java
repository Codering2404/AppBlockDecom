package androidx.compose.foundation.gestures;

import androidx.compose.animation.SplineBasedDecayKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.ui.MotionDurationScale;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

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
public final class DefaultFlingBehavior implements ScrollableDefaultFlingBehavior {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DecayAnimationSpec f5606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MotionDurationScale f5607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f5608c;

    public DefaultFlingBehavior(DecayAnimationSpec decayAnimationSpec, MotionDurationScale motionDurationScale) {
        this.f5606a = decayAnimationSpec;
        this.f5607b = motionDurationScale;
    }

    @Override // androidx.compose.foundation.gestures.FlingBehavior
    public Object a(ScrollScope scrollScope, float f3, Continuation continuation) {
        this.f5608c = 0;
        return BuildersKt.g(this.f5607b, new DefaultFlingBehavior$performFling$2(f3, this, scrollScope, null), continuation);
    }

    public final int e() {
        return this.f5608c;
    }

    public final void f(int i3) {
        this.f5608c = i3;
    }

    public void g(Density density) {
        this.f5606a = SplineBasedDecayKt.c(density);
    }

    public /* synthetic */ DefaultFlingBehavior(DecayAnimationSpec decayAnimationSpec, MotionDurationScale motionDurationScale, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(decayAnimationSpec, (i3 & 2) != 0 ? ScrollableKt.f() : motionDurationScale);
    }
}
