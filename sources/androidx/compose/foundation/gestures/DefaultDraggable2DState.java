package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
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
final class DefaultDraggable2DState implements Draggable2DState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function1 f5587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Drag2DScope f5588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutatorMutex f5589c;

    @Override // androidx.compose.foundation.gestures.Draggable2DState
    public Object a(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new DefaultDraggable2DState$drag$2(this, mutatePriority, function2, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public final Function1 d() {
        return this.f5587a;
    }
}
