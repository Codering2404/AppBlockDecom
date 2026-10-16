package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public interface AwaitPointerEventScope extends Density {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object b0(AwaitPointerEventScope awaitPointerEventScope, long j3, Function2 function2, Continuation continuation) {
        return function2.invoke(awaitPointerEventScope, continuation);
    }

    static /* synthetic */ Object e0(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitPointerEvent");
        }
        if ((i3 & 1) != 0) {
            pointerEventPass = PointerEventPass.f26831b;
        }
        return awaitPointerEventScope.T0(pointerEventPass, continuation);
    }

    static /* synthetic */ Object o0(AwaitPointerEventScope awaitPointerEventScope, long j3, Function2 function2, Continuation continuation) {
        return function2.invoke(awaitPointerEventScope, continuation);
    }

    default Object C0(long j3, Function2 function2, Continuation continuation) {
        return b0(this, j3, function2, continuation);
    }

    Object T0(PointerEventPass pointerEventPass, Continuation continuation);

    PointerEvent U0();

    long a();

    ViewConfiguration getViewConfiguration();

    default Object h0(long j3, Function2 function2, Continuation continuation) {
        return o0(this, j3, function2, continuation);
    }

    default long v0() {
        return Size.f25617b.b();
    }
}
