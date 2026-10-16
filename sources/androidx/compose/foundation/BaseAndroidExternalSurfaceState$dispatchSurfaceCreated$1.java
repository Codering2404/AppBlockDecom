package androidx.compose.foundation;

import android.view.Surface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1", f = "AndroidExternalSurface.android.kt", l = {130, 136}, m = "invokeSuspend")
final class BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f4641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f4642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BaseAndroidExternalSurfaceState f4643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Surface f4644d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f4645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f4646g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1(BaseAndroidExternalSurfaceState baseAndroidExternalSurfaceState, Surface surface, int i3, int i4, Continuation continuation) {
        super(2, continuation);
        this.f4643c = baseAndroidExternalSurfaceState;
        this.f4644d = surface;
        this.f4645f = i3;
        this.f4646g = i4;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1 baseAndroidExternalSurfaceState$dispatchSurfaceCreated$1 = new BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1(this.f4643c, this.f4644d, this.f4645f, this.f4646g, continuation);
        baseAndroidExternalSurfaceState$dispatchSurfaceCreated$1.f4642b = obj;
        return baseAndroidExternalSurfaceState$dispatchSurfaceCreated$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0064, code lost:
    
        if (r3.invoke(r4, r5, r6, r7, r9) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f4641a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L22
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r10)
            goto L67
        L12:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L1a:
            java.lang.Object r1 = r9.f4642b
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            kotlin.ResultKt.b(r10)
            goto L3d
        L22:
            kotlin.ResultKt.b(r10)
            java.lang.Object r10 = r9.f4642b
            r1 = r10
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = r9.f4643c
            kotlinx.coroutines.Job r10 = androidx.compose.foundation.BaseAndroidExternalSurfaceState.a(r10)
            if (r10 == 0) goto L3d
            r9.f4642b = r1
            r9.f4641a = r3
            java.lang.Object r10 = kotlinx.coroutines.JobKt.g(r10, r9)
            if (r10 != r0) goto L3d
            goto L66
        L3d:
            androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1 r4 = new androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1$receiver$1
            androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = r9.f4643c
            r4.<init>(r10, r1)
            androidx.compose.foundation.BaseAndroidExternalSurfaceState r10 = r9.f4643c
            kotlin.jvm.functions.Function5 r3 = androidx.compose.foundation.BaseAndroidExternalSurfaceState.b(r10)
            if (r3 == 0) goto L67
            android.view.Surface r5 = r9.f4644d
            int r10 = r9.f4645f
            java.lang.Integer r6 = kotlin.coroutines.jvm.internal.Boxing.d(r10)
            int r10 = r9.f4646g
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.d(r10)
            r10 = 0
            r9.f4642b = r10
            r9.f4641a = r2
            r8 = r9
            java.lang.Object r10 = r3.invoke(r4, r5, r6, r7, r8)
            if (r10 != r0) goto L67
        L66:
            return r0
        L67:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BaseAndroidExternalSurfaceState$dispatchSurfaceCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
