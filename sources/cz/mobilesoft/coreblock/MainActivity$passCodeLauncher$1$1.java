package cz.mobilesoft.coreblock;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import cz.mobilesoft.coreblock.scene.dashboard.DashboardActivity;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$passCodeLauncher$1$1", f = "MainActivity.kt", l = {70, 72, 83}, m = "invokeSuspend", v = 1)
final class MainActivity$passCodeLauncher$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f95408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f95409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ActivityResult f95410c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.MainActivity$passCodeLauncher$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.MainActivity$passCodeLauncher$1$1$1", f = "MainActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f95411a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ActivityResult f95412b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MainActivity f95413c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ActivityResult activityResult, MainActivity mainActivity, Continuation continuation) {
            super(2, continuation);
            this.f95412b = activityResult;
            this.f95413c = mainActivity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f95412b, this.f95413c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f95411a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (this.f95412b.d() == -1) {
                Intent intent = new Intent(this.f95413c, (Class<?>) DashboardActivity.class);
                intent.putExtra("SHOW_OREO_NOTIFICATION_DIALOG", this.f95413c.f95373x);
                intent.putExtra("OPEN_BLOCK_NOTIFICATIONS", this.f95413c.f95374y);
                intent.putExtra("OPEN_CHANGELOG", this.f95413c.f95375z);
                intent.putExtra("STATISTICS_INTERVAL", this.f95413c.A);
                intent.putExtra("IS_TILE_SERVICE", this.f95413c.B);
                String str = this.f95413c.E;
                if (str != null) {
                    intent.putExtra("SHORTCUT_ACTION", str);
                }
                intent.addFlags(603979776);
                this.f95413c.startActivity(intent);
            }
            this.f95413c.finish();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$passCodeLauncher$1$1(MainActivity mainActivity, ActivityResult activityResult, Continuation continuation) {
        super(2, continuation);
        this.f95409b = mainActivity;
        this.f95410c = activityResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MainActivity$passCodeLauncher$1$1(this.f95409b, this.f95410c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r2, r4, r18) != r1) goto L26;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.lang.Throwable {
        /*
            r18 = this;
            r0 = r18
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f95408a
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L2a
            if (r2 == r5) goto L26
            if (r2 == r4) goto L20
            if (r2 != r3) goto L18
            kotlin.ResultKt.b(r19)
            goto La1
        L18:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L20:
            kotlin.ResultKt.b(r19)
            r2 = r19
            goto L53
        L26:
            kotlin.ResultKt.b(r19)
            goto L40
        L2a:
            kotlin.ResultKt.b(r19)
            cz.mobilesoft.coreblock.MainActivity r2 = r0.f95409b
            cz.mobilesoft.coreblock.storage.datastore.PassCodeDataStore r2 = cz.mobilesoft.coreblock.MainActivity.F0(r2)
            long r6 = java.lang.System.currentTimeMillis()
            r0.f95408a = r5
            java.lang.Object r2 = r2.G(r6, r0)
            if (r2 != r1) goto L40
            goto La0
        L40:
            cz.mobilesoft.coreblock.MainActivity r2 = r0.f95409b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r2 = cz.mobilesoft.coreblock.MainActivity.B0(r2)
            kotlinx.coroutines.flow.Flow r2 = r2.z2()
            r0.f95408a = r4
            java.lang.Object r2 = kotlinx.coroutines.flow.FlowKt.D(r2, r0)
            if (r2 != r1) goto L53
            goto La0
        L53:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L8a
            cz.mobilesoft.coreblock.util.SessionManager r2 = cz.mobilesoft.coreblock.util.SessionManager.f127910a
            boolean r2 = r2.r()
            if (r2 != 0) goto L8a
            cz.mobilesoft.coreblock.MainActivity r1 = r0.f95409b
            androidx.activity.result.ActivityResultLauncher r1 = cz.mobilesoft.coreblock.MainActivity.L0(r1)
            cz.mobilesoft.coreblock.scene.more.signin.SignInActivity$Companion r2 = cz.mobilesoft.coreblock.scene.more.signin.SignInActivity.f110366h
            cz.mobilesoft.coreblock.MainActivity r3 = r0.f95409b
            cz.mobilesoft.coreblock.scene.more.signin.SignInConfig r4 = new cz.mobilesoft.coreblock.scene.more.signin.SignInConfig
            cz.mobilesoft.coreblock.enums.SignInEntryPoint r5 = cz.mobilesoft.coreblock.enums.SignInEntryPoint.STARTUP
            r16 = 1982(0x7be, float:2.777E-42)
            r17 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 1
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            android.content.Intent r2 = r2.a(r3, r4)
            r1.b(r2)
            goto La1
        L8a:
            kotlinx.coroutines.MainCoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.MainActivity$passCodeLauncher$1$1$1 r4 = new cz.mobilesoft.coreblock.MainActivity$passCodeLauncher$1$1$1
            androidx.activity.result.ActivityResult r5 = r0.f95410c
            cz.mobilesoft.coreblock.MainActivity r6 = r0.f95409b
            r7 = 0
            r4.<init>(r5, r6, r7)
            r0.f95408a = r3
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.g(r2, r4, r0)
            if (r2 != r1) goto La1
        La0:
            return r1
        La1:
            kotlin.Unit r1 = kotlin.Unit.f139807a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.MainActivity$passCodeLauncher$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MainActivity$passCodeLauncher$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
