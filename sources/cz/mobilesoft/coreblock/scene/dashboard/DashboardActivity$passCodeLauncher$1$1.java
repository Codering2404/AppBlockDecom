package cz.mobilesoft.coreblock.scene.dashboard;

import androidx.activity.result.ActivityResult;
import com.facebook.internal.FacebookRequestErrorClassification;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$passCodeLauncher$1$1", f = "DashboardActivity.kt", l = {FacebookRequestErrorClassification.EC_INVALID_TOKEN, 192}, m = "invokeSuspend", v = 1)
final class DashboardActivity$passCodeLauncher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f99213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ DashboardActivity f99214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ActivityResult f99215c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$passCodeLauncher$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$passCodeLauncher$1$1$1", f = "DashboardActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f99216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ActivityResult f99217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ DashboardActivity f99218c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ActivityResult activityResult, DashboardActivity dashboardActivity, Continuation continuation) {
            super(2, continuation);
            this.f99217b = activityResult;
            this.f99218c = dashboardActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f99217b, this.f99218c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f99216a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.f99217b.d() != -1) {
                this.f99218c.finish();
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DashboardActivity$passCodeLauncher$1$1(DashboardActivity dashboardActivity, ActivityResult activityResult, Continuation continuation) {
        super(2, continuation);
        this.f99214b = dashboardActivity;
        this.f99215c = activityResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DashboardActivity$passCodeLauncher$1$1(this.f99214b, this.f99215c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r7, r1, r6) == r0) goto L15;
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
            int r1 = r6.f99213a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r7)
            goto L4b
        L12:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L1a:
            kotlin.ResultKt.b(r7)
            goto L34
        L1e:
            kotlin.ResultKt.b(r7)
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity r7 = r6.f99214b
            cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore r7 = cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity.q2(r7)
            long r4 = java.lang.System.currentTimeMillis()
            r6.f99213a = r3
            java.lang.Object r7 = r7.G(r4, r6)
            if (r7 != r0) goto L34
            goto L4a
        L34:
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$passCodeLauncher$1$1$1 r1 = new cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$passCodeLauncher$1$1$1
            androidx.activity.result.ActivityResult r3 = r6.f99215c
            cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity r4 = r6.f99214b
            r5 = 0
            r1.<init>(r3, r4, r5)
            r6.f99213a = r2
            java.lang.Object r7 = kotlinx.coroutines.BuildersKt.g(r7, r1, r6)
            if (r7 != r0) goto L4b
        L4a:
            return r0
        L4b:
            kotlin.Unit r7 = kotlin.Unit.f139807a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity$passCodeLauncher$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DashboardActivity$passCodeLauncher$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
