package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.Channel;

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
public final class TransformableKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object e(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, androidx.compose.foundation.gestures.ScrollConfig r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1 r0 = (androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1) r0
            int r1 = r0.f6310d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6310d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1 r0 = new androidx.compose.foundation.gestures.TransformableKt$awaitCtrlMouseScrollOrNull$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f6309c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6310d
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r5 = r0.f6308b
            r6 = r5
            androidx.compose.foundation.gestures.ScrollConfig r6 = (androidx.compose.foundation.gestures.ScrollConfig) r6
            java.lang.Object r5 = r0.f6307a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
            kotlin.ResultKt.b(r7)
            goto L4b
        L33:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3b:
            kotlin.ResultKt.b(r7)
            r0.f6307a = r5
            r0.f6308b = r6
            r0.f6310d = r4
            java.lang.Object r7 = androidx.compose.ui.input.pointer.AwaitPointerEventScope.e0(r5, r3, r0, r4, r3)
            if (r7 != r1) goto L4b
            return r1
        L4b:
            androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
            int r0 = r7.f()
            boolean r0 = androidx.compose.ui.input.pointer.PointerEvent_androidKt.b(r0)
            if (r0 == 0) goto L9c
            int r0 = r7.h()
            androidx.compose.ui.input.pointer.PointerEventType$Companion r1 = androidx.compose.ui.input.pointer.PointerEventType.f26835b
            int r1 = r1.f()
            boolean r0 = androidx.compose.ui.input.pointer.PointerEventType.j(r0, r1)
            if (r0 != 0) goto L68
            goto L9c
        L68:
            long r0 = r5.a()
            long r5 = r6.c(r5, r7, r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.f25596b
            long r0 = r0.c()
            boolean r0 = androidx.compose.ui.geometry.Offset.j(r5, r0)
            if (r0 == 0) goto L7d
            return r3
        L7d:
            java.util.List r7 = r7.c()
            r0 = r7
            java.util.Collection r0 = (java.util.Collection) r0
            int r0 = r0.size()
            r1 = 0
        L89:
            if (r1 >= r0) goto L97
            java.lang.Object r2 = r7.get(r1)
            androidx.compose.ui.input.pointer.PointerInputChange r2 = (androidx.compose.ui.input.pointer.PointerInputChange) r2
            r2.a()
            int r1 = r1 + 1
            goto L89
        L97:
            androidx.compose.ui.geometry.Offset r5 = androidx.compose.ui.geometry.Offset.d(r5)
            return r5
        L9c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.e(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.ScrollConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0049 -> B:18:0x004c). Please report as a decompilation issue!!! */
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
    public static final java.lang.Object f(androidx.compose.ui.input.pointer.AwaitPointerEventScope r5, androidx.compose.foundation.gestures.ScrollConfig r6, kotlin.coroutines.Continuation r7) {
        /*
            boolean r0 = r7 instanceof androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = (androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1) r0
            int r1 = r0.f6314d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f6314d = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1 r0 = new androidx.compose.foundation.gestures.TransformableKt$awaitFirstCtrlMouseScroll$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f6313c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f6314d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r5 = r0.f6312b
            androidx.compose.foundation.gestures.ScrollConfig r5 = (androidx.compose.foundation.gestures.ScrollConfig) r5
            java.lang.Object r6 = r0.f6311a
            androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
            kotlin.ResultKt.b(r7)
            r4 = r6
            r6 = r5
            r5 = r4
            goto L4c
        L34:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3c:
            kotlin.ResultKt.b(r7)
        L3f:
            r0.f6311a = r5
            r0.f6312b = r6
            r0.f6314d = r3
            java.lang.Object r7 = e(r5, r6, r0)
            if (r7 != r1) goto L4c
            return r1
        L4c:
            androidx.compose.ui.geometry.Offset r7 = (androidx.compose.ui.geometry.Offset) r7
            if (r7 == 0) goto L3f
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.f(androidx.compose.ui.input.pointer.AwaitPointerEventScope, androidx.compose.foundation.gestures.ScrollConfig, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x02c0, code lost:
    
        if (r6 != 0) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x02c2, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:0x02c7 A[EDGE_INSN: B:103:0x02c7->B:92:0x02c7 BREAK  A[LOOP:0: B:86:0x02b2->B:91:0x02c4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0152 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02da  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:84:0x0294 -> B:85:0x02a1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object g(androidx.compose.ui.input.pointer.AwaitPointerEventScope r29, boolean r30, kotlinx.coroutines.channels.Channel r31, kotlin.jvm.functions.Function1 r32, kotlin.coroutines.Continuation r33) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 760
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt.g(androidx.compose.ui.input.pointer.AwaitPointerEventScope, boolean, kotlinx.coroutines.channels.Channel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object h(PointerInputScope pointerInputScope, Channel channel, ScrollConfig scrollConfig, Continuation continuation) {
        Object objC0 = pointerInputScope.c0(new TransformableKt$detectZoomByCtrlMouseScroll$2(continuation.getContext(), scrollConfig, channel, null), continuation);
        return objC0 == IntrinsicsKt.f() ? objC0 : Unit.f139807a;
    }
}
