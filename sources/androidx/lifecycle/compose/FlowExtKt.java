package androidx.lifecycle.compose;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

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
public final class FlowExtKt {
    public static final State a(Flow flow, Object obj, Lifecycle lifecycle, Lifecycle.State state, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        if ((i4 & 4) != 0) {
            state = Lifecycle.State.f39950d;
        }
        Lifecycle.State state2 = state;
        if ((i4 & 8) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.M()) {
            ComposerKt.U(1977777920, i3, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:174)");
        }
        Object[] objArr = {flow, lifecycle, state2, coroutineContext2};
        boolean zI = composer.I(lifecycle) | ((((i3 & 7168) ^ 3072) > 2048 && composer.e(state2.ordinal())) || (i3 & 3072) == 2048) | composer.I(coroutineContext2) | composer.I(flow);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            FlowExtKt$collectAsStateWithLifecycle$1$1 flowExtKt$collectAsStateWithLifecycle$1$1 = new FlowExtKt$collectAsStateWithLifecycle$1$1(lifecycle, state2, coroutineContext2, flow, null);
            composer.w(flowExtKt$collectAsStateWithLifecycle$1$1);
            objG = flowExtKt$collectAsStateWithLifecycle$1$1;
        }
        State stateN = SnapshotStateKt.n(obj, objArr, (Function2) objG, composer, (i3 >> 3) & 14);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateN;
    }

    public static final State b(Flow flow, Object obj, LifecycleOwner lifecycleOwner, Lifecycle.State state, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.q(LocalLifecycleOwnerKt.c());
        }
        if ((i4 & 4) != 0) {
            state = Lifecycle.State.f39950d;
        }
        Lifecycle.State state2 = state;
        if ((i4 & 8) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.M()) {
            ComposerKt.U(-1485997211, i3, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:138)");
        }
        State stateA = a(flow, obj, lifecycleOwner.getLifecycle(), state2, coroutineContext2, composer, (i3 & 14) | (((i3 >> 3) & 8) << 3) | (i3 & 112) | (i3 & 7168) | (57344 & i3), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    public static final State c(StateFlow stateFlow, LifecycleOwner lifecycleOwner, Lifecycle.State state, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            lifecycleOwner = (LifecycleOwner) composer.q(LocalLifecycleOwnerKt.c());
        }
        if ((i4 & 2) != 0) {
            state = Lifecycle.State.f39950d;
        }
        Lifecycle.State state2 = state;
        if ((i4 & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.M()) {
            ComposerKt.U(743249048, i3, -1, "androidx.lifecycle.compose.collectAsStateWithLifecycle (FlowExt.kt:62)");
        }
        int i5 = i3 << 3;
        State stateA = a(stateFlow, stateFlow.getValue(), lifecycleOwner.getLifecycle(), state2, coroutineContext2, composer, (i3 & 14) | (i5 & 7168) | (i5 & 57344), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }
}
