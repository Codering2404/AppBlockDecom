package androidx.glance.session;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class SessionWorker extends CoroutineWorker {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Companion f39605j = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WorkerParameters f39606d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SessionManager f39607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final TimeoutOptions f39608g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CoroutineDispatcher f39609h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f39610i;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ SessionWorker(Context context, WorkerParameters workerParameters, SessionManager sessionManager, TimeoutOptions timeoutOptions, CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, workerParameters, (i3 & 4) != 0 ? SessionManagerKt.a() : sessionManager, (i3 & 8) != 0 ? new TimeoutOptions(0L, 0L, 0L, null, 15, null) : timeoutOptions, (i3 & 16) != 0 ? Dispatchers.c() : coroutineDispatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0199, code lost:
    
        if (r2.x0(r8) != r9) goto L37;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object k(androidx.glance.session.TimerScope r30, kotlin.coroutines.Continuation r31) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.SessionWorker.k(androidx.glance.session.TimerScope, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object c(kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.glance.session.SessionWorker$doWork$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.glance.session.SessionWorker$doWork$1 r0 = (androidx.glance.session.SessionWorker$doWork$1) r0
            int r1 = r0.f39613c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39613c = r1
            goto L18
        L13:
            androidx.glance.session.SessionWorker$doWork$1 r0 = new androidx.glance.session.SessionWorker$doWork$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f39611a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f39613c
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L49
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L31:
            kotlin.ResultKt.b(r6)
            androidx.glance.session.TimeoutOptions r6 = r5.f39608g
            androidx.glance.session.TimeSource r6 = r6.d()
            androidx.glance.session.SessionWorker$doWork$2 r2 = new androidx.glance.session.SessionWorker$doWork$2
            r4 = 0
            r2.<init>(r5, r4)
            r0.f39613c = r3
            java.lang.Object r6 = androidx.glance.session.TimerScopeKt.d(r6, r2, r0)
            if (r6 != r1) goto L49
            return r1
        L49:
            androidx.work.ListenableWorker$Result r6 = (androidx.work.ListenableWorker.Result) r6
            if (r6 != 0) goto L60
            androidx.work.Data$Builder r6 = new androidx.work.Data$Builder
            r6.<init>()
            java.lang.String r0 = "TIMEOUT_EXIT_REASON"
            androidx.work.Data$Builder r6 = r6.d(r0, r3)
            androidx.work.Data r6 = r6.a()
            androidx.work.ListenableWorker$Result r6 = androidx.work.ListenableWorker.Result.d(r6)
        L60:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.session.SessionWorker.c(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.work.CoroutineWorker
    public CoroutineDispatcher d() {
        return this.f39609h;
    }

    public SessionWorker(Context context, WorkerParameters workerParameters, SessionManager sessionManager, TimeoutOptions timeoutOptions, CoroutineDispatcher coroutineDispatcher) {
        super(context, workerParameters);
        this.f39606d = workerParameters;
        this.f39607f = sessionManager;
        this.f39608g = timeoutOptions;
        this.f39609h = coroutineDispatcher;
        String strJ = getInputData().j(sessionManager.b());
        if (strJ == null) {
            throw new IllegalStateException("SessionWorker must be started with a key");
        }
        this.f39610i = strJ;
    }

    public SessionWorker(Context context, WorkerParameters workerParameters) {
        this(context, workerParameters, SessionManagerKt.a(), null, null, 24, null);
    }
}
