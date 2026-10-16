package cz.mobilesoft.coreblock.scene.intro.schedule;

import android.content.Intent;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity$close$1", f = "IntroScheduleActivity.kt", l = {171, 172}, m = "invokeSuspend", v = 1)
final class IntroScheduleActivity$close$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f104817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f104818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ IntroScheduleActivity f104819c;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity$close$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity$close$1$1", f = "IntroScheduleActivity.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f104820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IntroScheduleActivity f104821b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Intent f104822c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(IntroScheduleActivity introScheduleActivity, Intent intent, Continuation continuation) {
            super(2, continuation);
            this.f104821b = introScheduleActivity;
            this.f104822c = intent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f104821b, this.f104822c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f104820a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f104821b.startActivity(this.f104822c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    IntroScheduleActivity$close$1(IntroScheduleActivity introScheduleActivity, Continuation continuation) {
        super(1, continuation);
        this.f104819c = introScheduleActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new IntroScheduleActivity$close$1(this.f104819c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0055, code lost:
    
        if (kotlinx.coroutines.BuildersKt.g(r1, r3, r11) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.f104818b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L24
            if (r1 == r3) goto L1f
            if (r1 != r2) goto L17
            java.lang.Object r0 = r11.f104817a
            android.content.Intent r0 = (android.content.Intent) r0
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L58
        L17:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1f:
            kotlin.ResultKt.b(r12)
            r8 = r11
            goto L3b
        L24:
            kotlin.ResultKt.b(r12)
            r12 = r3
            cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity r3 = r11.f104819c
            r11.f104818b = r12
            r4 = 0
            r5 = 1
            r6 = 0
            r7 = 0
            r9 = 13
            r10 = 0
            r8 = r11
            java.lang.Object r12 = cz.mobilesoft.coreblock.scene.premium.utils.IntroPremiumScreenHelperKt.c(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r12 != r0) goto L3b
            goto L57
        L3b:
            android.content.Intent r12 = (android.content.Intent) r12
            kotlinx.coroutines.MainCoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.c()
            cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity$close$1$1 r3 = new cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity$close$1$1
            cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity r4 = r8.f104819c
            r5 = 0
            r3.<init>(r4, r12, r5)
            java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.a(r12)
            r8.f104817a = r12
            r8.f104818b = r2
            java.lang.Object r12 = kotlinx.coroutines.BuildersKt.g(r1, r3, r11)
            if (r12 != r0) goto L58
        L57:
            return r0
        L58:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.intro.schedule.IntroScheduleActivity$close$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((IntroScheduleActivity$close$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
