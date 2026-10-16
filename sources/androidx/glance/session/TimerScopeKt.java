package androidx.glance.session;

import androidx.compose.animation.core.h;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TimerScopeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AtomicReference atomicReference, Function1 function1) {
        Object obj;
        do {
            obj = atomicReference.get();
        } while (!h.a(atomicReference, obj, function1.invoke(obj)));
    }

    public static final Object c(TimeSource timeSource, Function2 function2, Continuation continuation) {
        return CoroutineScopeKt.f(new TimerScopeKt$withTimer$2(function2, timeSource, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object d(androidx.glance.session.TimeSource r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.glance.session.TimerScopeKt$withTimerOrNull$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.glance.session.TimerScopeKt$withTimerOrNull$1 r0 = (androidx.glance.session.TimerScopeKt$withTimerOrNull$1) r0
            int r1 = r0.f39699c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39699c = r1
            goto L18
        L13:
            androidx.glance.session.TimerScopeKt$withTimerOrNull$1 r0 = new androidx.glance.session.TimerScopeKt$withTimerOrNull$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f39698b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39699c
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.f39697a
            r5 = r4
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            kotlin.ResultKt.b(r6)     // Catch: androidx.glance.session.TimeoutCancellationException -> L2e
            return r6
        L2e:
            r4 = move-exception
            goto L47
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            kotlin.ResultKt.b(r6)
            r0.f39697a = r5     // Catch: androidx.glance.session.TimeoutCancellationException -> L2e
            r0.f39699c = r3     // Catch: androidx.glance.session.TimeoutCancellationException -> L2e
            java.lang.Object r4 = c(r4, r5, r0)     // Catch: androidx.glance.session.TimeoutCancellationException -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            return r4
        L47:
            int r6 = r4.b()
            int r5 = r5.hashCode()
            if (r6 != r5) goto L53
            r4 = 0
            return r4
        L53:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.TimerScopeKt.d(androidx.glance.session.TimeSource, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
