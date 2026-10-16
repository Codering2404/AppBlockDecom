package cz.mobilesoft.coreblock.util.helperextension;

import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt$launchOnceStarted$1", f = "CoroutinesHelperExt.kt", l = {112}, m = "invokeSuspend", v = 1)
final class CoroutinesHelperExtKt$launchOnceStarted$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f128482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f128483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f128484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Object f128485d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f128486f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f128487g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    boolean f128488h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f128489i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private /* synthetic */ Object f128490j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final /* synthetic */ LifecycleOwner f128491k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final /* synthetic */ Function1 f128492l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CoroutinesHelperExtKt$launchOnceStarted$1(LifecycleOwner lifecycleOwner, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f128491k = lifecycleOwner;
        this.f128492l = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CoroutinesHelperExtKt$launchOnceStarted$1 coroutinesHelperExtKt$launchOnceStarted$1 = new CoroutinesHelperExtKt$launchOnceStarted$1(this.f128491k, this.f128492l, continuation);
        coroutinesHelperExtKt$launchOnceStarted$1.f128490j = obj;
        return coroutinesHelperExtKt$launchOnceStarted$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = r10.f128490j
            r1 = r0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r10.f128489i
            r3 = 1
            if (r2 == 0) goto L2d
            if (r2 != r3) goto L25
            java.lang.Object r0 = r10.f128485d
            kotlinx.coroutines.MainCoroutineDispatcher r0 = (kotlinx.coroutines.MainCoroutineDispatcher) r0
            java.lang.Object r0 = r10.f128484c
            androidx.lifecycle.Lifecycle$State r0 = (androidx.lifecycle.Lifecycle.State) r0
            java.lang.Object r0 = r10.f128483b
            androidx.lifecycle.Lifecycle r0 = (androidx.lifecycle.Lifecycle) r0
            java.lang.Object r0 = r10.f128482a
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            kotlin.ResultKt.b(r11)
            goto Lb4
        L25:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L2d:
            kotlin.ResultKt.b(r11)
            androidx.lifecycle.LifecycleOwner r11 = r10.f128491k
            kotlin.jvm.functions.Function1 r2 = r10.f128492l
            androidx.lifecycle.Lifecycle r4 = r11.getLifecycle()
            androidx.lifecycle.Lifecycle$State r5 = androidx.lifecycle.Lifecycle.State.f39950d
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
            kotlinx.coroutines.MainCoroutineDispatcher r7 = r6.w0()
            kotlin.coroutines.CoroutineContext r6 = r10.getContext()
            boolean r6 = r7.e0(r6)
            if (r6 != 0) goto L80
            androidx.lifecycle.Lifecycle$State r8 = r4.getCurrentState()
            androidx.lifecycle.Lifecycle$State r9 = androidx.lifecycle.Lifecycle.State.f39947a
            if (r8 == r9) goto L7a
            androidx.lifecycle.Lifecycle$State r8 = r4.getCurrentState()
            int r8 = r8.compareTo(r5)
            if (r8 < 0) goto L80
            r11 = 0
            kotlinx.coroutines.CompletableJob r0 = kotlinx.coroutines.SupervisorKt.b(r11, r3, r11)
            kotlinx.coroutines.CoroutineExceptionHandler r3 = cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt.b()
            kotlin.coroutines.CoroutineContext r0 = r0.plus(r3)
            cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt$launchOnceStarted$1$1$1 r4 = new cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt$launchOnceStarted$1$1$1
            r4.<init>(r2, r11)
            r5 = 2
            r6 = 0
            r3 = 0
            r2 = r0
            kotlinx.coroutines.BuildersKt.d(r1, r2, r3, r4, r5, r6)
            kotlin.Unit r11 = kotlin.Unit.f139807a
            goto Lb4
        L7a:
            androidx.lifecycle.LifecycleDestroyedException r11 = new androidx.lifecycle.LifecycleDestroyedException
            r11.<init>()
            throw r11
        L80:
            cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt$launchOnceStarted$1$invokeSuspend$$inlined$withStarted$1 r8 = new cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt$launchOnceStarted$1$invokeSuspend$$inlined$withStarted$1
            r8.<init>()
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r1)
            r10.f128490j = r1
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r11)
            r10.f128482a = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r4)
            r10.f128483b = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r5)
            r10.f128484c = r11
            java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.a(r7)
            r10.f128485d = r11
            r11 = 0
            r10.f128486f = r11
            r10.f128487g = r11
            r10.f128488h = r6
            r10.f128489i = r3
            r9 = r10
            java.lang.Object r11 = androidx.lifecycle.WithLifecycleStateKt.a(r4, r5, r6, r7, r8, r9)
            if (r11 != r0) goto Lb4
            return r0
        Lb4:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt$launchOnceStarted$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((CoroutinesHelperExtKt$launchOnceStarted$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
