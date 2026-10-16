package androidx.datastore.core;

import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.datastore.core.MulticastFileObserver$Companion$observe$1", f = "MulticastFileObserver.android.kt", l = {84, 85}, m = "invokeSuspend")
final class MulticastFileObserver$Companion$observe$1 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f35783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f35784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f35785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ File f35786d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MulticastFileObserver$Companion$observe$1(File file, Continuation continuation) {
        super(2, continuation);
        this.f35786d = file;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MulticastFileObserver$Companion$observe$1 multicastFileObserver$Companion$observe$1 = new MulticastFileObserver$Companion$observe$1(this.f35786d, continuation);
        multicastFileObserver$Companion$observe$1.f35785c = obj;
        return multicastFileObserver$Companion$observe$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((MulticastFileObserver$Companion$observe$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0063, code lost:
    
        if (kotlinx.coroutines.channels.ProduceKt.a(r3, r7, r6) == r0) goto L16;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f35784b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L26
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L66
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            java.lang.Object r1 = r6.f35783a
            kotlinx.coroutines.DisposableHandle r1 = (kotlinx.coroutines.DisposableHandle) r1
            java.lang.Object r3 = r6.f35785c
            kotlinx.coroutines.channels.ProducerScope r3 = (kotlinx.coroutines.channels.ProducerScope) r3
            kotlin.ResultKt.b(r7)
            goto L53
        L26:
            kotlin.ResultKt.b(r7)
            java.lang.Object r7 = r6.f35785c
            kotlinx.coroutines.channels.ProducerScope r7 = (kotlinx.coroutines.channels.ProducerScope) r7
            androidx.datastore.core.MulticastFileObserver$Companion$observe$1$flowObserver$1 r1 = new androidx.datastore.core.MulticastFileObserver$Companion$observe$1$flowObserver$1
            java.io.File r4 = r6.f35786d
            r1.<init>()
            androidx.datastore.core.MulticastFileObserver$Companion r4 = androidx.datastore.core.MulticastFileObserver.f35778c
            java.io.File r5 = r6.f35786d
            java.io.File r5 = r5.getParentFile()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            kotlinx.coroutines.DisposableHandle r1 = androidx.datastore.core.MulticastFileObserver.Companion.b(r4, r5, r1)
            kotlin.Unit r4 = kotlin.Unit.f139807a
            r6.f35785c = r7
            r6.f35783a = r1
            r6.f35784b = r3
            java.lang.Object r3 = r7.y(r4, r6)
            if (r3 != r0) goto L52
            goto L65
        L52:
            r3 = r7
        L53:
            androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1 r7 = new androidx.datastore.core.MulticastFileObserver$Companion$observe$1$1
            r7.<init>()
            r1 = 0
            r6.f35785c = r1
            r6.f35783a = r1
            r6.f35784b = r2
            java.lang.Object r7 = kotlinx.coroutines.channels.ProduceKt.a(r3, r7, r6)
            if (r7 != r0) goto L66
        L65:
            return r0
        L66:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.MulticastFileObserver$Companion$observe$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
