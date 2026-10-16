package coil.util;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import kotlin.Metadata;

/* JADX INFO: renamed from: coil.util.-Lifecycles, reason: invalid class name */
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Lifecycles {
    /* JADX WARN: Removed duplicated region for block: B:34:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(androidx.lifecycle.Lifecycle r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof coil.util.Lifecycles$awaitStarted$1
            if (r0 == 0) goto L13
            r0 = r7
            coil.util.-Lifecycles$awaitStarted$1 r0 = (coil.util.Lifecycles$awaitStarted$1) r0
            int r1 = r0.f56210d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f56210d = r1
            goto L18
        L13:
            coil.util.-Lifecycles$awaitStarted$1 r0 = new coil.util.-Lifecycles$awaitStarted$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f56209c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f56210d
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r6 = r0.f56208b
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r0 = r0.f56207a
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            kotlin.ResultKt.b(r7)     // Catch: java.lang.Throwable -> L31
            goto L8c
        L31:
            r7 = move-exception
            goto L98
        L33:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L3b:
            kotlin.ResultKt.b(r7)
            androidx.lifecycle.Lifecycle$State r7 = r6.getCurrentState()
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.f39950d
            boolean r7 = r7.b(r2)
            if (r7 == 0) goto L4d
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L4d:
            kotlin.jvm.internal.Ref$ObjectRef r7 = new kotlin.jvm.internal.Ref$ObjectRef
            r7.<init>()
            r0.f56207a = r6     // Catch: java.lang.Throwable -> L81
            r0.f56208b = r7     // Catch: java.lang.Throwable -> L81
            r0.f56210d = r3     // Catch: java.lang.Throwable -> L81
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl     // Catch: java.lang.Throwable -> L81
            kotlin.coroutines.Continuation r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.c(r0)     // Catch: java.lang.Throwable -> L81
            r2.<init>(r4, r3)     // Catch: java.lang.Throwable -> L81
            r2.C()     // Catch: java.lang.Throwable -> L81
            coil.util.-Lifecycles$awaitStarted$2$1 r3 = new coil.util.-Lifecycles$awaitStarted$2$1     // Catch: java.lang.Throwable -> L81
            r3.<init>()     // Catch: java.lang.Throwable -> L81
            r7.f140144a = r3     // Catch: java.lang.Throwable -> L81
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch: java.lang.Throwable -> L81
            androidx.lifecycle.LifecycleObserver r3 = (androidx.lifecycle.LifecycleObserver) r3     // Catch: java.lang.Throwable -> L81
            r6.addObserver(r3)     // Catch: java.lang.Throwable -> L81
            java.lang.Object r2 = r2.v()     // Catch: java.lang.Throwable -> L81
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()     // Catch: java.lang.Throwable -> L81
            if (r2 != r3) goto L87
            kotlin.coroutines.jvm.internal.DebugProbesKt.c(r0)     // Catch: java.lang.Throwable -> L81
            goto L87
        L81:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
            goto L98
        L87:
            if (r2 != r1) goto L8a
            return r1
        L8a:
            r0 = r6
            r6 = r7
        L8c:
            java.lang.Object r6 = r6.f140144a
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto L95
            r0.removeObserver(r6)
        L95:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        L98:
            java.lang.Object r6 = r6.f140144a
            androidx.lifecycle.LifecycleObserver r6 = (androidx.lifecycle.LifecycleObserver) r6
            if (r6 == 0) goto La1
            r0.removeObserver(r6)
        La1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: coil.util.Lifecycles.a(androidx.lifecycle.Lifecycle, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void b(Lifecycle lifecycle, LifecycleObserver lifecycleObserver) {
        lifecycle.removeObserver(lifecycleObserver);
        lifecycle.addObserver(lifecycleObserver);
    }
}
