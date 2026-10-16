package cz.mobilesoft.coreblock.service;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.service.StatisticsSyncScheduler$start$1", f = "StatisticsSyncScheduler.kt", l = {74, 74}, m = "invokeSuspend", v = 1)
final class StatisticsSyncScheduler$start$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f123137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f123138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ StatisticsSyncScheduler f123139c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Context f123140d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Runnable f123141f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatisticsSyncScheduler$start$1(StatisticsSyncScheduler statisticsSyncScheduler, Context context, Runnable runnable, Continuation continuation) {
        super(2, continuation);
        this.f123139c = statisticsSyncScheduler;
        this.f123140d = context;
        this.f123141f = runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(Runnable runnable, boolean z2) {
        if (runnable != null) {
            runnable.run();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StatisticsSyncScheduler$start$1 statisticsSyncScheduler$start$1 = new StatisticsSyncScheduler$start$1(this.f123139c, this.f123140d, this.f123141f, continuation);
        statisticsSyncScheduler$start$1.f123138b = obj;
        return statisticsSyncScheduler$start$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0022  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0079  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0076 -> B:11:0x0022). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f123138b
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r7.f123137a
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L1f
            if (r2 == r4) goto L1b
            if (r2 != r3) goto L13
            goto L1f
        L13:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1b:
            kotlin.ResultKt.b(r8)
            goto L68
        L1f:
            kotlin.ResultKt.b(r8)
        L22:
            boolean r8 = kotlinx.coroutines.CoroutineScopeKt.h(r0)
            if (r8 == 0) goto L79
            cz.mobilesoft.coreblock.service.StatisticsSyncScheduler r8 = r7.f123139c
            android.content.Context r2 = r7.f123140d
            java.lang.Runnable r5 = r7.f123141f
            kotlin.Result$Companion r6 = kotlin.Result.f139772b     // Catch: java.lang.Throwable -> L43
            kotlin.jvm.functions.Function2 r8 = cz.mobilesoft.coreblock.service.StatisticsSyncScheduler.d(r8)     // Catch: java.lang.Throwable -> L43
            cz.mobilesoft.coreblock.service.e r6 = new cz.mobilesoft.coreblock.service.e     // Catch: java.lang.Throwable -> L43
            r6.<init>()     // Catch: java.lang.Throwable -> L43
            r8.invoke(r2, r6)     // Catch: java.lang.Throwable -> L43
            kotlin.Unit r8 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L43
            java.lang.Object r8 = kotlin.Result.b(r8)     // Catch: java.lang.Throwable -> L43
            goto L4e
        L43:
            r8 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.f139772b
            java.lang.Object r8 = kotlin.ResultKt.a(r8)
            java.lang.Object r8 = kotlin.Result.b(r8)
        L4e:
            java.lang.Throwable r8 = kotlin.Result.e(r8)
            if (r8 == 0) goto L57
            cz.mobilesoft.coreblock.util.CrashHelper.j(r8)
        L57:
            cz.mobilesoft.coreblock.service.StatisticsSyncScheduler r8 = r7.f123139c
            kotlin.jvm.functions.Function1 r8 = cz.mobilesoft.coreblock.service.StatisticsSyncScheduler.c(r8)
            r7.f123138b = r0
            r7.f123137a = r4
            java.lang.Object r8 = r8.invoke(r7)
            if (r8 != r1) goto L68
            goto L78
        L68:
            java.lang.Number r8 = (java.lang.Number) r8
            long r5 = r8.longValue()
            r7.f123138b = r0
            r7.f123137a = r3
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.b(r5, r7)
            if (r8 != r1) goto L22
        L78:
            return r1
        L79:
            kotlin.Unit r8 = kotlin.Unit.f139807a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.service.StatisticsSyncScheduler$start$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatisticsSyncScheduler$start$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
