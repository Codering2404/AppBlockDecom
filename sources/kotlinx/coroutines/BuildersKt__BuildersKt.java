package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
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
public final /* synthetic */ class BuildersKt__BuildersKt {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlin.coroutines.CoroutineContext r4, kotlin.jvm.functions.Function2 r5) {
        /*
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            kotlin.coroutines.ContinuationInterceptor$Key r1 = kotlin.coroutines.ContinuationInterceptor.t8
            kotlin.coroutines.CoroutineContext$Element r1 = r4.get(r1)
            kotlin.coroutines.ContinuationInterceptor r1 = (kotlin.coroutines.ContinuationInterceptor) r1
            if (r1 != 0) goto L1f
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.f141011a
            kotlinx.coroutines.EventLoop r1 = r1.b()
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.f140958a
            kotlin.coroutines.CoroutineContext r4 = r4.plus(r1)
            kotlin.coroutines.CoroutineContext r4 = kotlinx.coroutines.CoroutineContextKt.k(r2, r4)
            goto L42
        L1f:
            boolean r2 = r1 instanceof kotlinx.coroutines.EventLoop
            r3 = 0
            if (r2 == 0) goto L27
            kotlinx.coroutines.EventLoop r1 = (kotlinx.coroutines.EventLoop) r1
            goto L28
        L27:
            r1 = r3
        L28:
            if (r1 == 0) goto L36
            boolean r2 = r1.w1()
            if (r2 == 0) goto L31
            r3 = r1
        L31:
            if (r3 != 0) goto L34
            goto L36
        L34:
            r1 = r3
            goto L3c
        L36:
            kotlinx.coroutines.ThreadLocalEventLoop r1 = kotlinx.coroutines.ThreadLocalEventLoop.f141011a
            kotlinx.coroutines.EventLoop r1 = r1.a()
        L3c:
            kotlinx.coroutines.GlobalScope r2 = kotlinx.coroutines.GlobalScope.f140958a
            kotlin.coroutines.CoroutineContext r4 = kotlinx.coroutines.CoroutineContextKt.k(r2, r4)
        L42:
            kotlinx.coroutines.BlockingCoroutine r2 = new kotlinx.coroutines.BlockingCoroutine
            r2.<init>(r4, r0, r1)
            kotlinx.coroutines.CoroutineStart r4 = kotlinx.coroutines.CoroutineStart.f140916a
            r2.e1(r4, r2, r5)
            java.lang.Object r4 = r2.f1()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.BuildersKt__BuildersKt.a(kotlin.coroutines.CoroutineContext, kotlin.jvm.functions.Function2):java.lang.Object");
    }

    public static /* synthetic */ Object b(CoroutineContext coroutineContext, Function2 function2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.f139889a;
        }
        return BuildersKt.e(coroutineContext, function2);
    }
}
