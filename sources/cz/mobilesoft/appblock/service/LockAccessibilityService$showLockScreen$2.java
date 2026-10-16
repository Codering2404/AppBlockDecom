package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.dto.UrlDto;
import cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt;
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
@DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$showLockScreen$2", f = "LockAccessibilityService.kt", l = {1898}, m = "invokeSuspend", v = 1)
final class LockAccessibilityService$showLockScreen$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f94349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f94350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ UrlDto f94351c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LockAccessibilityService f94352d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f94353f;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockAccessibilityService$showLockScreen$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockAccessibilityService$showLockScreen$2$1", f = "LockAccessibilityService.kt", l = {1900, 1902}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f94354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f94355b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f94356c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ UrlDto f94357d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ CoroutineScope f94358f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ LockAccessibilityService f94359g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f94360h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(UrlDto urlDto, CoroutineScope coroutineScope, LockAccessibilityService lockAccessibilityService, String str, Continuation continuation) {
            super(1, continuation);
            this.f94357d = urlDto;
            this.f94358f = coroutineScope;
            this.f94359g = lockAccessibilityService;
            this.f94360h = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass1(this.f94357d, this.f94358f, this.f94359g, this.f94360h, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
        
            if (r2.N(r4, r5) == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
        
            if (r3.N(r4, r5) == r0) goto L18;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            return r0;
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
                int r1 = r5.f94356c
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L23
                if (r1 == r3) goto L1b
                if (r1 != r2) goto L13
                java.lang.Object r0 = r5.f94354a
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                goto L1f
            L13:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1b:
                java.lang.Object r0 = r5.f94354a
                cz.mobilesoft.coreblock.dto.UrlDto r0 = (cz.mobilesoft.coreblock.dto.UrlDto) r0
            L1f:
                kotlin.ResultKt.b(r6)
                goto L59
            L23:
                kotlin.ResultKt.b(r6)
                cz.mobilesoft.coreblock.dto.UrlDto r6 = r5.f94357d
                r1 = 0
                if (r6 == 0) goto L42
                cz.mobilesoft.appblock.service.LockAccessibilityService r2 = r5.f94359g
                cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao r2 = cz.mobilesoft.appblock.service.LockAccessibilityService.u(r2)
                java.lang.String r4 = r6.getDomain()
                r5.f94354a = r6
                r5.f94355b = r1
                r5.f94356c = r3
                java.lang.Object r6 = r2.N(r4, r5)
                if (r6 != r0) goto L59
                goto L58
            L42:
                kotlinx.coroutines.CoroutineScope r6 = r5.f94358f
                cz.mobilesoft.appblock.service.LockAccessibilityService r3 = r5.f94359g
                java.lang.String r4 = r5.f94360h
                cz.mobilesoft.coreblock.storage.room.dao.blocking.BlockSessionDao r3 = cz.mobilesoft.appblock.service.LockAccessibilityService.u(r3)
                r5.f94354a = r6
                r5.f94355b = r1
                r5.f94356c = r2
                java.lang.Object r6 = r3.N(r4, r5)
                if (r6 != r0) goto L59
            L58:
                return r0
            L59:
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockAccessibilityService$showLockScreen$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LockAccessibilityService$showLockScreen$2(UrlDto urlDto, LockAccessibilityService lockAccessibilityService, String str, Continuation continuation) {
        super(2, continuation);
        this.f94351c = urlDto;
        this.f94352d = lockAccessibilityService;
        this.f94353f = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        LockAccessibilityService$showLockScreen$2 lockAccessibilityService$showLockScreen$2 = new LockAccessibilityService$showLockScreen$2(this.f94351c, this.f94352d, this.f94353f, continuation);
        lockAccessibilityService$showLockScreen$2.f94350b = obj;
        return lockAccessibilityService$showLockScreen$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        CoroutineScope coroutineScope = (CoroutineScope) this.f94350b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f94349a;
        if (i3 == 0) {
            ResultKt.b(obj);
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f94351c, coroutineScope, this.f94352d, this.f94353f, null);
            this.f94350b = coroutineScope;
            this.f94349a = 1;
            if (DatabaseExtKt.b(0, 0L, anonymousClass1, this, 3, null) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((LockAccessibilityService$showLockScreen$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
