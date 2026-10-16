package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
final /* synthetic */ class SnapshotStateKt__SnapshotFlowKt {
    public static final State b(Flow flow, Object obj, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        if ((i4 & 2) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.M()) {
            ComposerKt.U(-606625098, i3, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:64)");
        }
        boolean zI = composer.I(coroutineContext2) | composer.I(flow);
        Object objG = composer.G();
        if (zI || objG == Composer.f23746a.a()) {
            objG = new SnapshotStateKt__SnapshotFlowKt$collectAsState$1$1(coroutineContext2, flow, null);
            composer.w(objG);
        }
        State stateL = SnapshotStateKt.l(obj, flow, coroutineContext2, (Function2) objG, composer, ((i3 >> 3) & 14) | ((i3 << 3) & 112) | (i3 & 896));
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateL;
    }

    public static final State c(StateFlow stateFlow, CoroutineContext coroutineContext, Composer composer, int i3, int i4) {
        if ((i4 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        CoroutineContext coroutineContext2 = coroutineContext;
        if (ComposerKt.M()) {
            ComposerKt.U(-1439883919, i3, -1, "androidx.compose.runtime.collectAsState (SnapshotFlow.kt:48)");
        }
        State stateA = SnapshotStateKt.a(stateFlow, stateFlow.getValue(), coroutineContext2, composer, (i3 & 14) | ((i3 << 3) & 896), 0);
        if (ComposerKt.M()) {
            ComposerKt.T();
        }
        return stateA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean d(androidx.collection.MutableScatterSet r13, java.util.Set r14) {
        /*
            java.lang.Object[] r0 = r13.f3116b
            long[] r13 = r13.f3115a
            int r1 = r13.length
            int r1 = r1 + (-2)
            r2 = 0
            if (r1 < 0) goto L48
            r3 = r2
        Lb:
            r4 = r13[r3]
            long r6 = ~r4
            r8 = 7
            long r6 = r6 << r8
            long r6 = r6 & r4
            r8 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r6 = r6 & r8
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto L43
            int r6 = r3 - r1
            int r6 = ~r6
            int r6 = r6 >>> 31
            r7 = 8
            int r6 = 8 - r6
            r8 = r2
        L25:
            if (r8 >= r6) goto L41
            r9 = 255(0xff, double:1.26E-321)
            long r9 = r9 & r4
            r11 = 128(0x80, double:6.3E-322)
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 >= 0) goto L3d
            int r9 = r3 << 3
            int r9 = r9 + r8
            r9 = r0[r9]
            boolean r9 = r14.contains(r9)
            if (r9 == 0) goto L3d
            r13 = 1
            return r13
        L3d:
            long r4 = r4 >> r7
            int r8 = r8 + 1
            goto L25
        L41:
            if (r6 != r7) goto L48
        L43:
            if (r3 == r1) goto L48
            int r3 = r3 + 1
            goto Lb
        L48:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt.d(androidx.collection.MutableScatterSet, java.util.Set):boolean");
    }

    public static final Flow e(Function0 function0) {
        return FlowKt.I(new SnapshotStateKt__SnapshotFlowKt$snapshotFlow$1(function0, null));
    }
}
