package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScopeKt;

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
final class SliderDraggableState implements DraggableState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f13761a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableState f13762b = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DragScope f13763c = new DragScope() { // from class: androidx.compose.material.SliderDraggableState$dragScope$1
        @Override // androidx.compose.foundation.gestures.DragScope
        public void a(float f3) {
            this.f13769a.g().invoke(Float.valueOf(f3));
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutatorMutex f13764d = new MutatorMutex();

    public SliderDraggableState(Function1 function1) {
        this.f13761a = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(boolean z2) {
        this.f13762b.setValue(Boolean.valueOf(z2));
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public Object a(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new SliderDraggableState$drag$2(this, mutatePriority, function2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void b(float f3) {
        this.f13761a.invoke(Float.valueOf(f3));
    }

    public final Function1 g() {
        return this.f13761a;
    }

    public final boolean h() {
        return ((Boolean) this.f13762b.getValue()).booleanValue();
    }
}
