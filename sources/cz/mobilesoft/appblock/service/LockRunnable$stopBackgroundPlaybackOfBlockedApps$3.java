package cz.mobilesoft.appblock.service;

import cz.mobilesoft.coreblock.rest.exception.CustomDatabaseLockedException;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

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
final class LockRunnable$stopBackgroundPlaybackOfBlockedApps$3<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ LockRunnable f94514a;

    /* JADX INFO: renamed from: cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$2", f = "LockRunnable.kt", l = {}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f94515a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ LockRunnable f94516b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Set f94517c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LockRunnable lockRunnable, Set set, Continuation continuation) {
            super(1, continuation);
            this.f94516b = lockRunnable;
            this.f94517c = set;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(this.f94516b, this.f94517c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.f94515a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            this.f94516b.q0(this.f94517c);
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    LockRunnable$stopBackgroundPlaybackOfBlockedApps$3(LockRunnable lockRunnable) {
        this.f94514a = lockRunnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f(Throwable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        CrashHelper crashHelper = CrashHelper.f127788a;
        String message = it.getMessage();
        if (message == null) {
            message = "Unknown error";
        }
        crashHelper.h("Error resolving blocked media playback in LockRunnable", new CustomDatabaseLockedException(message));
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.util.Set r8, kotlin.coroutines.Continuation r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$emit$1
            if (r0 == 0) goto L14
            r0 = r9
            cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$emit$1 r0 = (cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$emit$1) r0
            int r1 = r0.f94521d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f94521d = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$emit$1 r0 = new cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$emit$1
            r0.<init>(r7, r9)
            goto L12
        L1a:
            java.lang.Object r9 = r6.f94519b
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r6.f94521d
            r2 = 1
            if (r1 == 0) goto L3d
            if (r1 != r2) goto L35
            java.lang.Object r8 = r6.f94518a
            java.util.Set r8 = (java.util.Set) r8
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            goto L5c
        L2f:
            r0 = move-exception
            r8 = r0
            goto L5f
        L32:
            r0 = move-exception
            r8 = r0
            goto L65
        L35:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3d:
            kotlin.ResultKt.b(r9)
            cz.mobilesoft.appblock.service.n0 r4 = new cz.mobilesoft.appblock.service.n0     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            r4.<init>()     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$2 r5 = new cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3$2     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            cz.mobilesoft.appblock.service.LockRunnable r9 = r7.f94514a     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            r1 = 0
            r5.<init>(r9, r8, r1)     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            r6.f94518a = r8     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            r6.f94521d = r2     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            r1 = 20
            r2 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r9 = cz.mobilesoft.coreblock.util.helperextension.DatabaseExtKt.c(r1, r2, r4, r5, r6)     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            if (r9 != r0) goto L5c
            return r0
        L5c:
            kotlin.Unit r9 = (kotlin.Unit) r9     // Catch: java.lang.Exception -> L2f java.util.concurrent.CancellationException -> L32
            goto L62
        L5f:
            cz.mobilesoft.coreblock.util.CrashHelper.j(r8)
        L62:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        L65:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.LockRunnable$stopBackgroundPlaybackOfBlockedApps$3.emit(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
