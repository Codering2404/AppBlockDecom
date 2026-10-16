package cz.mobilesoft.coreblock.service.passlock;

import android.app.Activity;
import android.content.Intent;
import cz.mobilesoft.coreblock.scene.password.PassCodeActivity;
import cz.mobilesoft.coreblock.scene.password.PassCodeType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.passlock.PassCodeManager$onActivityResumed$1", f = "PassCodeManager.kt", l = {36, 37}, m = "invokeSuspend", v = 1)
final class PassCodeManager$onActivityResumed$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f123541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PassCodeManager f123542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Activity f123543d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.service.passlock.PassCodeManager$onActivityResumed$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.service.passlock.PassCodeManager$onActivityResumed$1$1", f = "PassCodeManager.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f123544a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f123545b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Activity activity, Continuation continuation) {
            super(2, continuation);
            this.f123545b = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f123545b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f123544a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            try {
                Intent intentA = PassCodeActivity.f111670f.a(this.f123545b, PassCodeType.Check);
                intentA.addFlags(268435456);
                this.f123545b.startActivity(intentA);
            } catch (Exception unused) {
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PassCodeManager$onActivityResumed$1(PassCodeManager passCodeManager, Activity activity, Continuation continuation) {
        super(2, continuation);
        this.f123542c = passCodeManager;
        this.f123543d = activity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        PassCodeManager$onActivityResumed$1 passCodeManager$onActivityResumed$1 = new PassCodeManager$onActivityResumed$1(this.f123542c, this.f123543d, continuation);
        passCodeManager$onActivityResumed$1.f123541b = obj;
        return passCodeManager$onActivityResumed$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0093, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r7, r2, r6) == r1) goto L21;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f123541b
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r6.f123540a
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L23
            if (r2 == r4) goto L1f
            if (r2 != r3) goto L17
            kotlin.ResultKt.b(r7)
            goto L96
        L17:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1f:
            kotlin.ResultKt.b(r7)
            goto L73
        L23:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.service.passlock.PassCodeManager r7 = r6.f123542c
            android.app.Activity r2 = r6.f123543d
            boolean r7 = cz.mobilesoft.coreblock.service.passlock.PassCodeManager.b(r7, r2)
            if (r7 == 0) goto L60
            android.app.Activity r7 = r6.f123543d
            java.lang.Class r7 = r7.getClass()
            kotlin.reflect.KClass r7 = kotlin.jvm.internal.Reflection.b(r7)
            java.lang.String r7 = r7.m()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            java.lang.String r7 = " is ignored"
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            java.lang.Class<kotlinx.coroutines.CoroutineScope> r0 = kotlinx.coroutines.CoroutineScope.class
            java.lang.String r0 = r0.getSimpleName()
            java.lang.String r1 = "getSimpleName(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.util.Log.d(r0, r7)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        L60:
            cz.mobilesoft.coreblock.service.passlock.PassCodeManager r7 = r6.f123542c
            android.app.Activity r2 = r6.f123543d
            java.lang.Object r5 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r6.f123541b = r5
            r6.f123540a = r4
            java.lang.Object r7 = cz.mobilesoft.coreblock.service.passlock.PassCodeManager.d(r7, r2, r6)
            if (r7 != r1) goto L73
            goto L95
        L73:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L96
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.service.passlock.PassCodeManager$onActivityResumed$1$1 r2 = new cz.mobilesoft.coreblock.service.passlock.PassCodeManager$onActivityResumed$1$1
            android.app.Activity r4 = r6.f123543d
            r5 = 0
            r2.<init>(r4, r5)
            java.lang.Object r0 = kotlin.coroutines.jvm.internal.SpillingKt.a(r0)
            r6.f123541b = r0
            r6.f123540a = r3
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r2, r6)
            if (r7 != r1) goto L96
        L95:
            return r1
        L96:
            cz.mobilesoft.coreblock.service.passlock.PassCodeManager r7 = r6.f123542c
            cz.mobilesoft.coreblock.service.passlock.PassCodeManager.c(r7)
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.passlock.PassCodeManager$onActivityResumed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((PassCodeManager$onActivityResumed$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
