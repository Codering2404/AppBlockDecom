package androidx.compose.foundation.gestures;

import androidx.compose.foundation.ComposeFoundationFlags;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.PointerEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.input.pointer.PointerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
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
public final class TapGestureDetectorKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function3 f6184a = new TapGestureDetectorKt$NoPressGesture$1(null);

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, boolean r8, androidx.compose.ui.input.pointer.PointerEventPass r9, kotlin.coroutines.Continuation r10) {
        /*
            boolean r0 = r10 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2) r0
            int r1 = r0.f6190f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6190f = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitFirstDown$2
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f6189d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6190f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r7 = r0.f6188c
            java.lang.Object r8 = r0.f6187b
            androidx.compose.ui.input.pointer.PointerEventPass r8 = (androidx.compose.ui.input.pointer.PointerEventPass) r8
            java.lang.Object r9 = r0.f6186a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r9 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r9
            kotlin.ResultKt.b(r10)
            r6 = r8
            r8 = r7
            r7 = r9
            r9 = r6
            goto L51
        L37:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3f:
            kotlin.ResultKt.b(r10)
        L42:
            r0.f6186a = r7
            r0.f6187b = r9
            r0.f6188c = r8
            r0.f6190f = r3
            java.lang.Object r10 = r7.T0(r9, r0)
            if (r10 != r1) goto L51
            return r1
        L51:
            androidx.compose.ui.input.pointer.PointerEvent r10 = (androidx.compose.ui.input.pointer.PointerEvent) r10
            r2 = 2
            r4 = 0
            r5 = 0
            boolean r2 = p(r10, r8, r5, r2, r4)
            if (r2 == 0) goto L42
            java.util.List r7 = r10.c()
            java.lang.Object r7 = r7.get(r5)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.e(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object f(AwaitPointerEventScope awaitPointerEventScope, boolean z2, PointerEventPass pointerEventPass, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        if ((i3 & 2) != 0) {
            pointerEventPass = PointerEventPass.f26831b;
        }
        return e(awaitPointerEventScope, z2, pointerEventPass, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x004e -> B:18:0x0051). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, boolean r6, androidx.compose.ui.input.pointer.PointerEventPass r7, kotlin.coroutines.Continuation r8) {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1) r0
            int r1 = r0.f6195f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6195f = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$awaitPrimaryFirstDown$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f6194d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6195f
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            boolean r5 = r0.f6193c
            java.lang.Object r6 = r0.f6192b
            androidx.compose.ui.input.pointer.PointerEventPass r6 = (androidx.compose.ui.input.pointer.PointerEventPass) r6
            java.lang.Object r7 = r0.f6191a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r7 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r7
            kotlin.ResultKt.b(r8)
            r4 = r6
            r6 = r5
            r5 = r7
            r7 = r4
            goto L51
        L37:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3f:
            kotlin.ResultKt.b(r8)
        L42:
            r0.f6191a = r5
            r0.f6192b = r7
            r0.f6193c = r6
            r0.f6195f = r3
            java.lang.Object r8 = r5.T0(r7, r0)
            if (r8 != r1) goto L51
            return r1
        L51:
            androidx.compose.ui.input.pointer.PointerEvent r8 = (androidx.compose.ui.input.pointer.PointerEvent) r8
            boolean r2 = o(r8, r6, r3)
            if (r2 == 0) goto L42
            java.util.List r5 = r8.c()
            r6 = 0
            java.lang.Object r5 = r5.get(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object h(AwaitPointerEventScope awaitPointerEventScope, boolean z2, PointerEventPass pointerEventPass, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z2 = true;
        }
        if ((i3 & 2) != 0) {
            pointerEventPass = PointerEventPass.f26831b;
        }
        return g(awaitPointerEventScope, z2, pointerEventPass, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i(AwaitPointerEventScope awaitPointerEventScope, PointerInputChange pointerInputChange, Continuation continuation) {
        return awaitPointerEventScope.h0(awaitPointerEventScope.getViewConfiguration().a(), new TapGestureDetectorKt$awaitSecondDown$2(pointerInputChange, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055 A[LOOP:0: B:19:0x0053->B:20:0x0055, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0041 -> B:18:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object j(androidx.compose.ui.input.pointer.AwaitPointerEventScope r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1) r0
            int r1 = r0.f6202c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6202c = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$consumeUntilUp$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f6201b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6202c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r8 = r0.f6200a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r8 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r8
            kotlin.ResultKt.b(r9)
            goto L44
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            kotlin.ResultKt.b(r9)
        L38:
            r0.f6200a = r8
            r0.f6202c = r3
            r9 = 0
            java.lang.Object r9 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.e0(r8, r9, r0, r3, r9)
            if (r9 != r1) goto L44
            return r1
        L44:
            androidx.compose.ui.input.pointer.PointerEvent r9 = (androidx.compose.ui.input.pointer.PointerEvent) r9
            java.util.List r2 = r9.c()
            r4 = r2
            java.util.Collection r4 = (java.util.Collection) r4
            int r4 = r4.size()
            r5 = 0
            r6 = r5
        L53:
            if (r6 >= r4) goto L61
            java.lang.Object r7 = r2.get(r6)
            androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
            r7.a()
            int r6 = r6 + 1
            goto L53
        L61:
            java.util.List r9 = r9.c()
            r2 = r9
            java.util.Collection r2 = (java.util.Collection) r2
            int r2 = r2.size()
        L6c:
            if (r5 >= r2) goto L7e
            java.lang.Object r4 = r9.get(r5)
            androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
            boolean r4 = r4.i()
            if (r4 == 0) goto L7b
            goto L38
        L7b:
            int r5 = r5 + 1
            goto L6c
        L7e:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.j(androidx.compose.ui.input.pointer.AwaitPointerEventScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object k(PointerInputScope pointerInputScope, Function3 function3, Function1 function1, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new TapGestureDetectorKt$detectTapAndPress$2(pointerInputScope, function3, function1, new PressGestureScopeImpl(pointerInputScope), null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public static final Object l(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function3 function3, Function1 function13, Continuation continuation) {
        Object objF = CoroutineScopeKt.f(new TapGestureDetectorKt$detectTapGestures$2(pointerInputScope, function3, function12, function1, function13, null), continuation);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public static /* synthetic */ Object m(PointerInputScope pointerInputScope, Function1 function1, Function1 function12, Function3 function3, Function1 function13, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            function1 = null;
        }
        if ((i3 & 2) != 0) {
            function12 = null;
        }
        if ((i3 & 4) != 0) {
            function3 = f6184a;
        }
        if ((i3 & 8) != 0) {
            function13 = null;
        }
        return l(pointerInputScope, function1, function12, function3, function13, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CoroutineStart n() {
        return ComposeFoundationFlags.f4888d ? CoroutineStart.f140919d : CoroutineStart.f140916a;
    }

    private static final boolean o(PointerEvent pointerEvent, boolean z2, boolean z3) {
        if (z3) {
            List listC = pointerEvent.c();
            int size = listC.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    if (!PointerType.h(((PointerInputChange) listC.get(i3)).n(), PointerType.f26922b.b())) {
                        break;
                    }
                    i3++;
                } else if (!PointerEvent_androidKt.c(pointerEvent.b())) {
                    return false;
                }
            }
        }
        List listC2 = pointerEvent.c();
        int size2 = listC2.size();
        for (int i4 = 0; i4 < size2; i4++) {
            PointerInputChange pointerInputChange = (PointerInputChange) listC2.get(i4);
            if (!(z2 ? PointerEventKt.a(pointerInputChange) : PointerEventKt.b(pointerInputChange))) {
                return false;
            }
        }
        return true;
    }

    static /* synthetic */ boolean p(PointerEvent pointerEvent, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z3 = TapGestureDetector_androidKt.a();
        }
        return o(pointerEvent, z2, z3);
    }

    private static final Job q(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2 function2) {
        return BuildersKt__Builders_commonKt.d(coroutineScope, null, coroutineStart, new TapGestureDetectorKt$launchAwaitingReset$1(job, function2, null), 1, null);
    }

    static /* synthetic */ Job r(CoroutineScope coroutineScope, Job job, CoroutineStart coroutineStart, Function2 function2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            coroutineStart = n();
        }
        return q(coroutineScope, job, coroutineStart, function2);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object s(androidx.compose.ui.input.pointer.AwaitPointerEventScope r7, androidx.compose.ui.input.pointer.PointerEventPass r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            boolean r0 = r9 instanceof androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1 r0 = (androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1) r0
            int r1 = r0.f6275c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6275c = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1 r0 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f6274b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6275c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r7 = r0.f6273a
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            kotlin.ResultKt.b(r9)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            goto L5b
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L35:
            kotlin.ResultKt.b(r9)
            kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
            r9.<init>()
            androidx.compose.foundation.gestures.LongPressResult$Canceled r2 = androidx.compose.foundation.gestures.LongPressResult.Canceled.f5955a
            r9.f140144a = r2
            androidx.compose.ui.platform.ViewConfiguration r2 = r7.getViewConfiguration()     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            long r4 = r2.c()     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2 r2 = new androidx.compose.foundation.gestures.TapGestureDetectorKt$waitForLongPress$2     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            r6 = 0
            r2.<init>(r8, r9, r6)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            r0.f6273a = r9     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            r0.f6275c = r3     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            java.lang.Object r7 = r7.C0(r4, r2, r0)     // Catch: androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException -> L5e
            if (r7 != r1) goto L5a
            return r1
        L5a:
            r7 = r9
        L5b:
            java.lang.Object r7 = r7.f140144a
            return r7
        L5e:
            androidx.compose.foundation.gestures.LongPressResult$Success r7 = androidx.compose.foundation.gestures.LongPressResult.Success.f5957a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.s(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object t(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            pointerEventPass = PointerEventPass.f26831b;
        }
        return s(awaitPointerEventScope, pointerEventPass, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c6, code lost:
    
        if (r0 == r2) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00c6 -> B:13:0x0037). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object u(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, androidx.compose.ui.input.pointer.PointerEventPass r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 248
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TapGestureDetectorKt.u(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.ui.input.pointer.PointerEventPass, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object v(AwaitPointerEventScope awaitPointerEventScope, PointerEventPass pointerEventPass, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            pointerEventPass = PointerEventPass.f26831b;
        }
        return u(awaitPointerEventScope, pointerEventPass, continuation);
    }
}
