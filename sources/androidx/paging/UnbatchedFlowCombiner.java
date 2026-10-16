package androidx.paging;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class UnbatchedFlowCombiner<T1, T2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function4 f50702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CompletableDeferred f50703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Mutex f50704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CompletableDeferred[] f50705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object[] f50706e;

    public UnbatchedFlowCombiner(Function4 send) {
        Intrinsics.checkNotNullParameter(send, "send");
        this.f50702a = send;
        this.f50703b = CompletableDeferredKt.b(null, 1, null);
        this.f50704c = MutexKt.b(false, 1, null);
        CompletableDeferred[] completableDeferredArr = new CompletableDeferred[2];
        for (int i3 = 0; i3 < 2; i3++) {
            completableDeferredArr[i3] = CompletableDeferredKt.b(null, 1, null);
        }
        this.f50705d = completableDeferredArr;
        Object[] objArr = new Object[2];
        for (int i4 = 0; i4 < 2; i4++) {
            objArr[i4] = FlowExtKt.f49739a;
        }
        this.f50706e = objArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0086, code lost:
    
        if (r2.await(r3) == r4) goto L56;
     */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3 A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:34:0x00ac, B:36:0x00b3, B:43:0x00c4, B:45:0x00cc, B:48:0x00d6, B:50:0x00db, B:54:0x00e5, B:52:0x00e0, B:53:0x00e3, B:39:0x00bd), top: B:64:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cc A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:34:0x00ac, B:36:0x00b3, B:43:0x00c4, B:45:0x00cc, B:48:0x00d6, B:50:0x00db, B:54:0x00e5, B:52:0x00e0, B:53:0x00e3, B:39:0x00bd), top: B:64:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00db A[Catch: all -> 0x00c0, TryCatch #0 {all -> 0x00c0, blocks: (B:34:0x00ac, B:36:0x00b3, B:43:0x00c4, B:45:0x00cc, B:48:0x00d6, B:50:0x00db, B:54:0x00e5, B:52:0x00e0, B:53:0x00e3, B:39:0x00bd), top: B:64:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object a(int r17, java.lang.Object r18, kotlin.coroutines.Continuation r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.UnbatchedFlowCombiner.a(int, java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
