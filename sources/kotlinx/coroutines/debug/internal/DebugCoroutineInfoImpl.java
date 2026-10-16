package kotlinx.coroutines.debug.internal;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.sequences.SequencesKt;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class DebugCoroutineInfoImpl {
    public volatile WeakReference<CoroutineStackFrame> _lastObservedFrame;
    public volatile String _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final StackTraceFrame f141421a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f141422b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final WeakReference f141423c;
    public volatile Thread lastObservedThread;

    private final List b() {
        StackTraceFrame stackTraceFrame = this.f141421a;
        return stackTraceFrame == null ? CollectionsKt.emptyList() : SequencesKt.S(SequencesKt.b(new DebugCoroutineInfoImpl$creationStackTrace$1(this, stackTraceFrame, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004b -> B:25:0x0062). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x005c -> B:24:0x005f). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object i(kotlin.sequences.SequenceScope r5, kotlin.coroutines.jvm.internal.CoroutineStackFrame r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1) r0
            int r1 = r0.f141433g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f141433g = r1
            goto L18
        L13:
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1 r0 = new kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl$yieldFrames$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f141431d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f141433g
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r5 = r0.f141430c
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r5 = (kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl) r5
            java.lang.Object r6 = r0.f141429b
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r6 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r6
            java.lang.Object r2 = r0.f141428a
            kotlin.sequences.SequenceScope r2 = (kotlin.sequences.SequenceScope) r2
            kotlin.ResultKt.b(r7)
            goto L5f
        L35:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3d:
            kotlin.ResultKt.b(r7)
            r7 = r6
            r6 = r4
        L42:
            if (r7 != 0) goto L47
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L47:
            java.lang.StackTraceElement r2 = r7.getStackTraceElement()
            if (r2 == 0) goto L62
            r0.f141428a = r5
            r0.f141429b = r7
            r0.f141430c = r6
            r0.f141433g = r3
            java.lang.Object r2 = r5.a(r2, r0)
            if (r2 != r1) goto L5c
            return r1
        L5c:
            r2 = r5
            r5 = r6
            r6 = r7
        L5f:
            r7 = r6
            r6 = r5
            r5 = r2
        L62:
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = r7.getCallerFrame()
            if (r7 == 0) goto L69
            goto L42
        L69:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl.i(kotlin.sequences.SequenceScope, kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final CoroutineContext c() {
        return (CoroutineContext) this.f141423c.get();
    }

    public final StackTraceFrame d() {
        return this.f141421a;
    }

    public final List e() {
        return b();
    }

    public final CoroutineStackFrame f() {
        WeakReference<CoroutineStackFrame> weakReference = this._lastObservedFrame;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public final String g() {
        return this._state;
    }

    public final List h() {
        CoroutineStackFrame coroutineStackFrameF = f();
        if (coroutineStackFrameF == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        while (coroutineStackFrameF != null) {
            StackTraceElement stackTraceElement = coroutineStackFrameF.getStackTraceElement();
            if (stackTraceElement != null) {
                arrayList.add(stackTraceElement);
            }
            coroutineStackFrameF = coroutineStackFrameF.getCallerFrame();
        }
        return arrayList;
    }

    public String toString() {
        return "DebugCoroutineInfo(state=" + g() + ",context=" + c() + ')';
    }
}
