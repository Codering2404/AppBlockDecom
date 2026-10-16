package androidx.compose.foundation.text.input.internal;

import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;

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
public final class CursorAnimationState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f10309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicReference f10310b = new AtomicReference(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableFloatState f10311c = PrimitiveSnapshotStateKt.a(0.0f);

    public CursorAnimationState(boolean z2) {
        this.f10309a = z2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(float f3) {
        this.f10311c.s(f3);
    }

    public final void c() {
        Job job = (Job) this.f10310b.getAndSet(null);
        if (job != null) {
            Job.DefaultImpls.b(job, null, 1, null);
        }
    }

    public final boolean d() {
        return this.f10309a;
    }

    public final float e() {
        return this.f10311c.c();
    }

    public final Object g(Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new CursorAnimationState$snapToVisibleAndAnimate$2(this, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }
}
