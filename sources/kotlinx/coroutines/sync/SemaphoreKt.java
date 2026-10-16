package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

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
public final class SemaphoreKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f142659a = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Symbol f142660b = new Symbol("PERMIT");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Symbol f142661c = new Symbol("TAKEN");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Symbol f142662d = new Symbol("BROKEN");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Symbol f142663e = new Symbol("CANCELLED");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f142664f = SystemPropsKt__SystemProps_commonKt.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);

    public static final Semaphore a(int i3, int i4) {
        return new SemaphoreImpl(i3, i4);
    }

    public static /* synthetic */ Semaphore b(int i3, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return a(i3, i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SemaphoreSegment j(long j3, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j3, semaphoreSegment, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object k(kotlinx.coroutines.sync.Semaphore r4, kotlin.jvm.functions.Function0 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = (kotlinx.coroutines.sync.SemaphoreKt$withPermit$1) r0
            int r1 = r0.f142668d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f142668d = r1
            goto L18
        L13:
            kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 r0 = new kotlinx.coroutines.sync.SemaphoreKt$withPermit$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f142667c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f142668d
            r3 = 1
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r4 = r0.f142666b
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.f142665a
            kotlinx.coroutines.sync.Semaphore r4 = (kotlinx.coroutines.sync.Semaphore) r4
            kotlin.ResultKt.b(r6)
            goto L4a
        L32:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3a:
            kotlin.ResultKt.b(r6)
            r0.f142665a = r4
            r0.f142666b = r5
            r0.f142668d = r3
            java.lang.Object r6 = r4.d(r0)
            if (r6 != r1) goto L4a
            return r1
        L4a:
            java.lang.Object r5 = r5.invoke()     // Catch: java.lang.Throwable -> L58
            kotlin.jvm.internal.InlineMarker.b(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.a(r3)
            return r5
        L58:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.b(r3)
            r4.release()
            kotlin.jvm.internal.InlineMarker.a(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.sync.SemaphoreKt.k(kotlinx.coroutines.sync.Semaphore, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
