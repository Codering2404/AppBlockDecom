package cz.mobilesoft.appblock.view;

import android.content.Intent;
import cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity;
import cz.mobilesoft.coreblock.util.CrashHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$closeAndFinishBlockingTest$1", f = "LockScreenProvider.kt", l = {834, 835}, m = "invokeSuspend", v = 1)
final class LockScreenProvider$closeAndFinishBlockingTest$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f95181a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LockScreenProvider f95182b;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.view.LockScreenProvider$closeAndFinishBlockingTest$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.view.LockScreenProvider$closeAndFinishBlockingTest$1$1", f = "LockScreenProvider.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f95183a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LockScreenProvider f95184b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LockScreenProvider lockScreenProvider, Continuation continuation) {
            super(2, continuation);
            this.f95184b = lockScreenProvider;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f95184b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f95183a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f95184b.f95145b.a();
            try {
                Intent intentB = IntroScheduleActivity.Companion.b(IntroScheduleActivity.f104813g, this.f95184b.f95160r, false, 2, null);
                intentB.setFlags(268468224);
                this.f95184b.f95160r.startActivity(intentB);
            } catch (Exception e3) {
                CrashHelper.j(e3);
            }
            this.f95184b.U();
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockScreenProvider$closeAndFinishBlockingTest$1(LockScreenProvider lockScreenProvider, Continuation continuation) {
        super(1, continuation);
        this.f95182b = lockScreenProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new LockScreenProvider$closeAndFinishBlockingTest$1(this.f95182b, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r6, r1, r5) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r5.f95181a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r6)
            goto L47
        L12:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1a:
            kotlin.ResultKt.b(r6)
            goto L32
        L1e:
            kotlin.ResultKt.b(r6)
            cz.mobilesoft.appblock.view.LockScreenProvider r6 = r5.f95182b
            cz.mobilesoft.coreblock.storage.datastore.CoreDataStore r6 = cz.mobilesoft.appblock.view.LockScreenProvider.A(r6)
            r5.f95181a = r3
            r3 = 0
            java.lang.Object r6 = r6.H4(r3, r5)
            if (r6 != r0) goto L32
            goto L46
        L32:
            kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.appblock.view.LockScreenProvider$closeAndFinishBlockingTest$1$1 r1 = new cz.mobilesoft.appblock.view.LockScreenProvider$closeAndFinishBlockingTest$1$1
            cz.mobilesoft.appblock.view.LockScreenProvider r3 = r5.f95182b
            r4 = 0
            r1.<init>(r3, r4)
            r5.f95181a = r2
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.g(r6, r1, r5)
            if (r6 != r0) goto L47
        L46:
            return r0
        L47:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.view.LockScreenProvider$closeAndFinishBlockingTest$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((LockScreenProvider$closeAndFinishBlockingTest$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
