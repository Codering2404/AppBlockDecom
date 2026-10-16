package androidx.paging;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

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
public final class SingleRunner {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f50658b = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Holder f50659a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CancelIsolatedRunnerException extends CancellationException {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SingleRunner f50660a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public CancelIsolatedRunnerException(SingleRunner runner) {
            super("Cancelled isolated runner");
            Intrinsics.checkNotNullParameter(runner, "runner");
            this.f50660a = runner;
        }

        public final SingleRunner a() {
            return this.f50660a;
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class Holder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SingleRunner f50661a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f50662b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Mutex f50663c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Job f50664d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f50665e;

        public Holder(SingleRunner singleRunner, boolean z2) {
            Intrinsics.checkNotNullParameter(singleRunner, "singleRunner");
            this.f50661a = singleRunner;
            this.f50662b = z2;
            this.f50663c = MutexKt.b(false, 1, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(kotlinx.coroutines.Job r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.SingleRunner$Holder$onFinish$1
                if (r0 == 0) goto L13
                r0 = r7
                androidx.paging.SingleRunner$Holder$onFinish$1 r0 = (androidx.paging.SingleRunner$Holder$onFinish$1) r0
                int r1 = r0.f50671g
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50671g = r1
                goto L18
            L13:
                androidx.paging.SingleRunner$Holder$onFinish$1 r0 = new androidx.paging.SingleRunner$Holder$onFinish$1
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f50669d
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50671g
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L40
                if (r2 != r3) goto L38
                java.lang.Object r6 = r0.f50668c
                kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
                java.lang.Object r1 = r0.f50667b
                kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
                java.lang.Object r0 = r0.f50666a
                androidx.paging.SingleRunner$Holder r0 = (androidx.paging.SingleRunner.Holder) r0
                kotlin.ResultKt.b(r7)
                r7 = r6
                r6 = r1
                goto L55
            L38:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L40:
                kotlin.ResultKt.b(r7)
                kotlinx.coroutines.sync.Mutex r7 = r5.f50663c
                r0.f50666a = r5
                r0.f50667b = r6
                r0.f50668c = r7
                r0.f50671g = r3
                java.lang.Object r0 = r7.f(r4, r0)
                if (r0 != r1) goto L54
                return r1
            L54:
                r0 = r5
            L55:
                kotlinx.coroutines.Job r1 = r0.f50664d     // Catch: java.lang.Throwable -> L5c
                if (r6 != r1) goto L5e
                r0.f50664d = r4     // Catch: java.lang.Throwable -> L5c
                goto L5e
            L5c:
                r6 = move-exception
                goto L66
            L5e:
                kotlin.Unit r6 = kotlin.Unit.f139807a     // Catch: java.lang.Throwable -> L5c
                r7.i(r4)
                kotlin.Unit r6 = kotlin.Unit.f139807a
                return r6
            L66:
                r7.i(r4)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.Holder.a(kotlinx.coroutines.Job, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.lang.Object, kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v14 */
        /* JADX WARN: Type inference failed for: r11v15 */
        /* JADX WARN: Type inference failed for: r11v4, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r1v1 */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.Job] */
        /* JADX WARN: Type inference failed for: r2v5 */
        /* JADX WARN: Type inference failed for: r2v8 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object b(int r10, kotlinx.coroutines.Job r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
            /*
                r9 = this;
                boolean r0 = r12 instanceof androidx.paging.SingleRunner$Holder$tryEnqueue$1
                if (r0 == 0) goto L13
                r0 = r12
                androidx.paging.SingleRunner$Holder$tryEnqueue$1 r0 = (androidx.paging.SingleRunner$Holder$tryEnqueue$1) r0
                int r1 = r0.f50678h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f50678h = r1
                goto L18
            L13:
                androidx.paging.SingleRunner$Holder$tryEnqueue$1 r0 = new androidx.paging.SingleRunner$Holder$tryEnqueue$1
                r0.<init>(r9, r12)
            L18:
                java.lang.Object r12 = r0.f50676f
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r2 = r0.f50678h
                r3 = 2
                r4 = 1
                r5 = 0
                if (r2 == 0) goto L59
                if (r2 == r4) goto L47
                if (r2 != r3) goto L3f
                int r10 = r0.f50675d
                java.lang.Object r11 = r0.f50674c
                kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
                java.lang.Object r1 = r0.f50673b
                kotlinx.coroutines.Job r1 = (kotlinx.coroutines.Job) r1
                java.lang.Object r0 = r0.f50672a
                androidx.paging.SingleRunner$Holder r0 = (androidx.paging.SingleRunner.Holder) r0
                kotlin.ResultKt.b(r12)     // Catch: java.lang.Throwable -> L3c
                goto Laa
            L3c:
                r10 = move-exception
                goto Lb8
            L3f:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r11)
                throw r10
            L47:
                int r10 = r0.f50675d
                java.lang.Object r11 = r0.f50674c
                kotlinx.coroutines.sync.Mutex r11 = (kotlinx.coroutines.sync.Mutex) r11
                java.lang.Object r2 = r0.f50673b
                kotlinx.coroutines.Job r2 = (kotlinx.coroutines.Job) r2
                java.lang.Object r6 = r0.f50672a
                androidx.paging.SingleRunner$Holder r6 = (androidx.paging.SingleRunner.Holder) r6
                kotlin.ResultKt.b(r12)
                goto L72
            L59:
                kotlin.ResultKt.b(r12)
                kotlinx.coroutines.sync.Mutex r12 = r9.f50663c
                r0.f50672a = r9
                r0.f50673b = r11
                r0.f50674c = r12
                r0.f50675d = r10
                r0.f50678h = r4
                java.lang.Object r2 = r12.f(r5, r0)
                if (r2 != r1) goto L6f
                goto La7
            L6f:
                r6 = r9
                r2 = r11
                r11 = r12
            L72:
                kotlinx.coroutines.Job r12 = r6.f50664d     // Catch: java.lang.Throwable -> L3c
                if (r12 == 0) goto L89
                boolean r7 = r12.isActive()     // Catch: java.lang.Throwable -> L3c
                if (r7 == 0) goto L89
                int r7 = r6.f50665e     // Catch: java.lang.Throwable -> L3c
                if (r7 < r10) goto L89
                if (r7 != r10) goto L87
                boolean r7 = r6.f50662b     // Catch: java.lang.Throwable -> L3c
                if (r7 == 0) goto L87
                goto L89
            L87:
                r4 = 0
                goto Lb0
            L89:
                if (r12 == 0) goto L95
                androidx.paging.SingleRunner$CancelIsolatedRunnerException r7 = new androidx.paging.SingleRunner$CancelIsolatedRunnerException     // Catch: java.lang.Throwable -> L3c
                androidx.paging.SingleRunner r8 = r6.f50661a     // Catch: java.lang.Throwable -> L3c
                r7.<init>(r8)     // Catch: java.lang.Throwable -> L3c
                r12.cancel(r7)     // Catch: java.lang.Throwable -> L3c
            L95:
                if (r12 == 0) goto Lac
                r0.f50672a = r6     // Catch: java.lang.Throwable -> L3c
                r0.f50673b = r2     // Catch: java.lang.Throwable -> L3c
                r0.f50674c = r11     // Catch: java.lang.Throwable -> L3c
                r0.f50675d = r10     // Catch: java.lang.Throwable -> L3c
                r0.f50678h = r3     // Catch: java.lang.Throwable -> L3c
                java.lang.Object r12 = r12.join(r0)     // Catch: java.lang.Throwable -> L3c
                if (r12 != r1) goto La8
            La7:
                return r1
            La8:
                r1 = r2
                r0 = r6
            Laa:
                r6 = r0
                r2 = r1
            Lac:
                r6.f50664d = r2     // Catch: java.lang.Throwable -> L3c
                r6.f50665e = r10     // Catch: java.lang.Throwable -> L3c
            Lb0:
                java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.a(r4)     // Catch: java.lang.Throwable -> L3c
                r11.i(r5)
                return r10
            Lb8:
                r11.i(r5)
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.Holder.b(int, kotlinx.coroutines.Job, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    public SingleRunner(boolean z2) {
        this.f50659a = new Holder(this, z2);
    }

    public static /* synthetic */ Object c(SingleRunner singleRunner, int i3, Function1 function1, Continuation continuation, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i3 = 0;
        }
        return singleRunner.b(i3, function1, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(int r5, kotlin.jvm.functions.Function1 r6, kotlin.coroutines.Continuation r7) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.paging.SingleRunner$runInIsolation$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.paging.SingleRunner$runInIsolation$1 r0 = (androidx.paging.SingleRunner$runInIsolation$1) r0
            int r1 = r0.f50682d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f50682d = r1
            goto L18
        L13:
            androidx.paging.SingleRunner$runInIsolation$1 r0 = new androidx.paging.SingleRunner$runInIsolation$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.f50680b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f50682d
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r5 = r0.f50679a
            androidx.paging.SingleRunner r5 = (androidx.paging.SingleRunner) r5
            kotlin.ResultKt.b(r7)     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L2d
            goto L53
        L2d:
            r6 = move-exception
            goto L4d
        L2f:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L37:
            kotlin.ResultKt.b(r7)
            androidx.paging.SingleRunner$runInIsolation$2 r7 = new androidx.paging.SingleRunner$runInIsolation$2     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4b
            r2 = 0
            r7.<init>(r4, r5, r6, r2)     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4b
            r0.f50679a = r4     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4b
            r0.f50682d = r3     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4b
            java.lang.Object r5 = kotlinx.coroutines.CoroutineScopeKt.f(r7, r0)     // Catch: androidx.paging.SingleRunner.CancelIsolatedRunnerException -> L4b
            if (r5 != r1) goto L53
            return r1
        L4b:
            r6 = move-exception
            r5 = r4
        L4d:
            androidx.paging.SingleRunner r7 = r6.a()
            if (r7 != r5) goto L56
        L53:
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L56:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SingleRunner.b(int, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public /* synthetic */ SingleRunner(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z2);
    }
}
