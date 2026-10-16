package cz.mobilesoft.appblock.service.lock;

import cz.mobilesoft.coreblock.storage.room.dao.blocking.UsageLimitDao;
import java.util.List;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$incrementLaunchCounts$2$1", f = "UsageLimitCountdown.kt", l = {349, 350}, m = "invokeSuspend", v = 1)
final class UsageLimitCountdown$incrementLaunchCounts$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ UsageLimitCountdown f94976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f94977c;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$incrementLaunchCounts$2$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$incrementLaunchCounts$2$1$1", f = "UsageLimitCountdown.kt", l = {349}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ UsageLimitCountdown f94979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f94980c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UsageLimitCountdown usageLimitCountdown, List list, Continuation continuation) {
            super(1, continuation);
            this.f94979b = usageLimitCountdown;
            this.f94980c = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f94979b, this.f94980c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f94978a;
            if (i3 == 0) {
                ResultKt.b(obj);
                UsageLimitDao usageLimitDaoX = this.f94979b.x();
                List list = this.f94980c;
                this.f94978a = 1;
                if (usageLimitDaoX.r(list, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitCountdown$incrementLaunchCounts$2$1(UsageLimitCountdown usageLimitCountdown, List list, Continuation continuation) {
        super(2, continuation);
        this.f94976b = usageLimitCountdown;
        this.f94977c = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UsageLimitCountdown$incrementLaunchCounts$2$1(this.f94976b, this.f94977c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
    
        if (r11.W1(r3, r10) == r0) goto L15;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f94975a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L20
            if (r1 == r3) goto L1b
            if (r1 != r2) goto L13
            kotlin.ResultKt.b(r11)
            r7 = r10
            goto L51
        L13:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1b:
            kotlin.ResultKt.b(r11)
            r7 = r10
            goto L3c
        L20:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$incrementLaunchCounts$2$1$1 r6 = new cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$incrementLaunchCounts$2$1$1
            cz.mobilesoft.appblock.service.lock.UsageLimitCountdown r11 = r10.f94976b
            java.util.List r1 = r10.f94977c
            r4 = 0
            r6.<init>(r11, r1, r4)
            r10.f94975a = r3
            r3 = 0
            r4 = 0
            r8 = 3
            r9 = 0
            r7 = r10
            java.lang.Object r11 = cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt.b(r3, r4, r6, r7, r8, r9)
            if (r11 != r0) goto L3c
            goto L50
        L3c:
            cz.mobilesoft.appblock.service.lock.UsageLimitCountdown r11 = r7.f94976b
            cz.mobilesoft.coreblock.storage.datastore.EventDataStore r11 = cz.mobilesoft.appblock.service.lock.UsageLimitCountdown.f(r11)
            cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt r1 = cz.mobilesoft.coreblock.util.helperextension.TimeHelperExt.f128663a
            long r3 = r1.f()
            r7.f94975a = r2
            java.lang.Object r11 = r11.W1(r3, r10)
            if (r11 != r0) goto L51
        L50:
            return r0
        L51:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.UsageLimitCountdown$incrementLaunchCounts$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UsageLimitCountdown$incrementLaunchCounts$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
