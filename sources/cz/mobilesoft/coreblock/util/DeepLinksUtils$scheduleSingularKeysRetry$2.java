package cz.mobilesoft.coreblock.util;

import android.app.Activity;
import android.util.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.util.DeepLinksUtils$scheduleSingularKeysRetry$2", f = "DeepLinksUtils.kt", l = {61, 66}, m = "invokeSuspend", v = 1)
final class DeepLinksUtils$scheduleSingularKeysRetry$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f127827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f127828b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f127829c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Activity f127830d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f127831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f127832g;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.util.DeepLinksUtils$scheduleSingularKeysRetry$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.util.DeepLinksUtils$scheduleSingularKeysRetry$2$1", f = "DeepLinksUtils.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f127833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f127834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f127835c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f127836d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f127837f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function1 f127838g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, String str, String str2, Function1 function1, Function1 function12, Continuation continuation) {
            super(2, continuation);
            this.f127834b = activity;
            this.f127835c = str;
            this.f127836d = str2;
            this.f127837f = function1;
            this.f127838g = function12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f127834b, this.f127835c, this.f127836d, this.f127837f, this.f127838g, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f127833a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.f127834b.isFinishing() || this.f127834b.isDestroyed()) {
                return Boxing.d(Log.d("initSingular", "retry preload succeeded, but activity already finishing/destroyed"));
            }
            DeepLinksUtils.f127818a.k(this.f127834b, this.f127835c, this.f127836d, this.f127837f, this.f127838g);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DeepLinksUtils$scheduleSingularKeysRetry$2(Activity activity, Function1 function1, Function1 function12, Continuation continuation) {
        super(1, continuation);
        this.f127830d = activity;
        this.f127831f = function1;
        this.f127832g = function12;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new DeepLinksUtils$scheduleSingularKeysRetry$2(this.f127830d, this.f127831f, this.f127832g, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r15, r7, r14) == r0) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r15) throws java.lang.Throwable {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r14.f127829c
            r2 = 2
            r3 = 1
            java.lang.String r4 = "retry flag cleared"
            r5 = 0
            java.lang.String r6 = "initSingular"
            if (r1 == 0) goto L32
            if (r1 == r3) goto L2e
            if (r1 != r2) goto L26
            java.lang.Object r0 = r14.f127828b
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Object r0 = r14.f127827a
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            goto L8a
        L1f:
            r0 = move-exception
            r15 = r0
            goto Lb0
        L23:
            r0 = move-exception
            r15 = r0
            goto L91
        L26:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L2e:
            kotlin.ResultKt.b(r15)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            goto L4b
        L32:
            kotlin.ResultKt.b(r15)
            cz.mobilesoft.coreblock.util.DeepLinksUtils r15 = cz.mobilesoft.coreblock.util.DeepLinksUtils.f127818a     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            android.app.Activity r1 = r14.f127830d     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            android.content.Context r1 = r1.getApplicationContext()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.String r7 = "getApplicationContext(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            r14.f127829c = r3     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.Object r15 = r15.n(r1, r14)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            if (r15 != r0) goto L4b
            goto L80
        L4b:
            java.lang.String r9 = cz.mobilesoft.coreblock.util.DeepLinksUtils.c()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.String r10 = cz.mobilesoft.coreblock.util.DeepLinksUtils.d()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            if (r9 == 0) goto L81
            if (r10 == 0) goto L81
            java.lang.String r15 = "retry preload succeeded, initializing on main"
            android.util.Log.d(r6, r15)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            kotlinx.coroutines.MainCoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.c()     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            cz.mobilesoft.coreblock.util.DeepLinksUtils$scheduleSingularKeysRetry$2$1 r7 = new cz.mobilesoft.coreblock.util.DeepLinksUtils$scheduleSingularKeysRetry$2$1     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            android.app.Activity r8 = r14.f127830d     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            kotlin.jvm.functions.Function1 r11 = r14.f127831f     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            kotlin.jvm.functions.Function1 r12 = r14.f127832g     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            r13 = 0
            r7.<init>(r8, r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r9)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            r14.f127827a = r1     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.Object r1 = kotlin.coroutines.jvm.internal.SpillingKt.a(r10)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            r14.f127828b = r1     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            r14.f127829c = r2     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            java.lang.Object r15 = kotlinx.coroutines.BuildersKt.g(r15, r7, r14)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            if (r15 != r0) goto L8a
        L80:
            return r0
        L81:
            java.lang.String r15 = "retry preload finished, but keys are still null"
            int r15 = android.util.Log.d(r6, r15)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
            kotlin.coroutines.jvm.internal.Boxing.d(r15)     // Catch: java.lang.Throwable -> L1f java.lang.Exception -> L23
        L8a:
            cz.mobilesoft.coreblock.util.DeepLinksUtils.i(r5)
            android.util.Log.d(r6, r4)
            goto Lad
        L91:
            java.lang.String r0 = r15.getMessage()     // Catch: java.lang.Throwable -> L1f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1f
            r1.<init>()     // Catch: java.lang.Throwable -> L1f
            java.lang.String r2 = "retry preload failed: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L1f
            r1.append(r0)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L1f
            android.util.Log.d(r6, r0)     // Catch: java.lang.Throwable -> L1f
            cz.mobilesoft.coreblock.util.CrashHelper.j(r15)     // Catch: java.lang.Throwable -> L1f
            goto L8a
        Lad:
            kotlin.Unit r15 = kotlin.Unit.f139807a
            return r15
        Lb0:
            cz.mobilesoft.coreblock.util.DeepLinksUtils.i(r5)
            android.util.Log.d(r6, r4)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.util.DeepLinksUtils$scheduleSingularKeysRetry$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((DeepLinksUtils$scheduleSingularKeysRetry$2) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
