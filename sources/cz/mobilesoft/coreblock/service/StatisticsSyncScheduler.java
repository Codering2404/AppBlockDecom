package cz.mobilesoft.coreblock.service;

import android.content.Context;
import cz.mobilesoft.coreblock.BuildConfig;
import cz.mobilesoft.coreblock.storage.datastore.dev.DevDataStore;
import cz.mobilesoft.coreblock.util.UsageAccessHelper;
import cz.mobilesoft.coreblock.util.helperextension.CoroutinesHelperExtKt;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.koin.java.KoinJavaComponent;

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
public final class StatisticsSyncScheduler {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f123130e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f123131f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineScope f123132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function2 f123133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1 f123134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Job f123135d;

    /* JADX INFO: renamed from: cz.mobilesoft.coreblock.service.StatisticsSyncScheduler$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "cz.mobilesoft.coreblock.service.StatisticsSyncScheduler$2", f = "StatisticsSyncScheduler.kt", l = {40}, m = "invokeSuspend", v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Long>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f123136a;

        AnonymousClass2(Continuation continuation) {
            super(1, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Continuation continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f123136a;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (BuildConfig.f95357b.booleanValue()) {
                    Flow flowE1 = ((DevDataStore) KoinJavaComponent.c(DevDataStore.class, null, null, 6, null)).e1();
                    this.f123136a = 1;
                    obj = FlowKt.D(flowE1, this);
                    if (obj == objF) {
                        return objF;
                    }
                }
                return Boxing.e(j);
            }
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            long j3 = ((Boolean) obj).booleanValue() ? 30000L : 150000L;
            return Boxing.e(j3);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public StatisticsSyncScheduler() {
        this(null, null, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit b(Context context, Function1 onFinished) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onFinished, "onFinished");
        UsageAccessHelper.s(context, onFinished, null, 4, null);
        return Unit.f139807a;
    }

    public final boolean e() {
        Job job = this.f123135d;
        return job != null && job.isActive();
    }

    public final synchronized void f(Context context, Runnable runnable) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (e()) {
            return;
        }
        this.f123135d = BuildersKt__Builders_commonKt.d(this.f123132a, null, null, new StatisticsSyncScheduler$start$1(this, context, runnable, null), 3, null);
    }

    public final synchronized void g() {
        try {
            Job job = this.f123135d;
            if (job != null) {
                Job.DefaultImpls.b(job, null, 1, null);
            }
            this.f123135d = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public StatisticsSyncScheduler(CoroutineScope scope, Function2 sync, Function1 intervalMs) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(sync, "sync");
        Intrinsics.checkNotNullParameter(intervalMs, "intervalMs");
        this.f123132a = scope;
        this.f123133b = sync;
        this.f123134c = intervalMs;
    }

    public /* synthetic */ StatisticsSyncScheduler(CoroutineScope coroutineScope, Function2 function2, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? CoroutinesHelperExtKt.a(Dispatchers.b()) : coroutineScope, (i3 & 2) != 0 ? new Function2() { // from class: cz.mobilesoft.coreblock.service.d
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return StatisticsSyncScheduler.b((Context) obj, (Function1) obj2);
            }
        } : function2, (i3 & 4) != 0 ? new AnonymousClass2(null) : function1);
    }
}
