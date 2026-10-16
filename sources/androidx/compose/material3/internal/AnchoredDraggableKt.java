package androidx.compose.material3.internal;

import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public final class AnchoredDraggableKt {
    public static final DraggableAnchors a(Function1 function1) {
        DraggableAnchorsConfig draggableAnchorsConfig = new DraggableAnchorsConfig();
        function1.invoke(draggableAnchorsConfig);
        return new MapDraggableAnchors(draggableAnchorsConfig.b());
    }

    public static final Modifier d(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z2, boolean z3, MutableInteractionSource mutableInteractionSource) {
        return DraggableKt.h(modifier, anchoredDraggableState.u(), orientation, z2, mutableInteractionSource, anchoredDraggableState.y(), null, new AnchoredDraggableKt$anchoredDraggable$1(anchoredDraggableState, null), z3, 32, null);
    }

    public static /* synthetic */ Modifier e(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, boolean z2, boolean z3, MutableInteractionSource mutableInteractionSource, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = true;
        }
        boolean z4 = z2;
        if ((i3 & 8) != 0) {
            z3 = false;
        }
        boolean z5 = z3;
        if ((i3 & 16) != 0) {
            mutableInteractionSource = null;
        }
        return d(modifier, anchoredDraggableState, orientation, z4, z5, mutableInteractionSource);
    }

    public static final Object f(AnchoredDraggableState anchoredDraggableState, Object obj, float f3, Continuation continuation) throws Throwable {
        Object objK = AnchoredDraggableState.k(anchoredDraggableState, obj, null, new AnchoredDraggableKt$animateTo$2(anchoredDraggableState, f3, null), continuation, 2, null);
        return objK == IntrinsicsKt.f() ? objK : Unit.f139807a;
    }

    public static /* synthetic */ Object g(AnchoredDraggableState anchoredDraggableState, Object obj, float f3, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            f3 = anchoredDraggableState.v();
        }
        return f(anchoredDraggableState, obj, f3, continuation);
    }

    public static final Modifier h(Modifier modifier, AnchoredDraggableState anchoredDraggableState, Orientation orientation, Function2 function2) {
        return modifier.then(new DraggableAnchorsElement(anchoredDraggableState, function2, orientation));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MapDraggableAnchors i() {
        return new MapDraggableAnchors(MapsKt.emptyMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object j(kotlin.jvm.functions.Function0 r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1 r0 = (androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1) r0
            int r1 = r0.f21810b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f21810b = r1
            goto L18
        L13:
            androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1 r0 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f21809a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f21810b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L43
            goto L43
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2 r6 = new androidx.compose.material3.internal.AnchoredDraggableKt$restartable$2     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L43
            r2 = 0
            r6.<init>(r4, r5, r2)     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L43
            r0.f21810b = r3     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L43
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.f(r6, r0)     // Catch: androidx.compose.material3.internal.AnchoredDragFinishedSignal -> L43
            if (r4 != r1) goto L43
            return r1
        L43:
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.internal.AnchoredDraggableKt.j(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
