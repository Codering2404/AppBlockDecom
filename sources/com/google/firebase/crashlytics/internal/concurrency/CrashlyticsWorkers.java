package com.google.firebase.crashlytics.internal.concurrency;

import android.os.Looper;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class CrashlyticsWorkers {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f88489e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f88490f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CrashlyticsWorker f88491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CrashlyticsWorker f88492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CrashlyticsWorker f88493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CrashlyticsWorker f88494d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String h() {
            return "Must be called on a background thread, was called on " + CrashlyticsWorkers.f88489e.o() + '.';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String j() {
            return "Must be called on a blocking thread, was called on " + CrashlyticsWorkers.f88489e.o() + '.';
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String l() {
            return "Must not be called on a main thread, was called on " + CrashlyticsWorkers.f88489e.o() + '.';
        }

        private final void m(Function0 function0, Function0 function02) {
            if (((Boolean) function0.invoke()).booleanValue()) {
                return;
            }
            Logger.f().b((String) function02.invoke());
            n();
        }

        private final String o() {
            return Thread.currentThread().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean p() {
            String strO = o();
            Intrinsics.checkNotNullExpressionValue(strO, "<get-threadName>(...)");
            return StringsKt.a0(strO, "Firebase Background Thread #", false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean q() {
            String strO = o();
            Intrinsics.checkNotNullExpressionValue(strO, "<get-threadName>(...)");
            return StringsKt.a0(strO, "Firebase Blocking Thread #", false, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean r() {
            return !Looper.getMainLooper().isCurrentThread();
        }

        public final void g() {
            m(new CrashlyticsWorkers$Companion$checkBackgroundThread$1(this), new Function0() { // from class: com.google.firebase.crashlytics.internal.concurrency.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CrashlyticsWorkers.Companion.h();
                }
            });
        }

        public final void i() {
            m(new CrashlyticsWorkers$Companion$checkBlockingThread$1(this), new Function0() { // from class: com.google.firebase.crashlytics.internal.concurrency.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CrashlyticsWorkers.Companion.j();
                }
            });
        }

        public final void k() {
            m(new CrashlyticsWorkers$Companion$checkNotMainThread$1(this), new Function0() { // from class: com.google.firebase.crashlytics.internal.concurrency.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return CrashlyticsWorkers.Companion.l();
                }
            });
        }

        public final boolean n() {
            return CrashlyticsWorkers.f88490f;
        }

        public final void s(boolean z2) {
            CrashlyticsWorkers.f88490f = z2;
        }

        private Companion() {
        }
    }

    public CrashlyticsWorkers(ExecutorService backgroundExecutorService, ExecutorService blockingExecutorService) {
        Intrinsics.checkNotNullParameter(backgroundExecutorService, "backgroundExecutorService");
        Intrinsics.checkNotNullParameter(blockingExecutorService, "blockingExecutorService");
        this.f88491a = new CrashlyticsWorker(backgroundExecutorService);
        this.f88492b = new CrashlyticsWorker(backgroundExecutorService);
        this.f88493c = new CrashlyticsWorker(backgroundExecutorService);
        this.f88494d = new CrashlyticsWorker(blockingExecutorService);
    }

    public static final void c() {
        f88489e.g();
    }

    public static final void d() {
        f88489e.i();
    }

    public static final void e() {
        f88489e.k();
    }

    public static final void f(boolean z2) {
        f88489e.s(z2);
    }
}
