package androidx.compose.runtime;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class RememberedCoroutineScope implements CoroutineScope, RememberObserver {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Companion f24158f = new Companion(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f24159g = 8;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final CoroutineContext f24160h = new CancelledCoroutineContext();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CoroutineContext f24161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CoroutineContext f24162b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f24163c = this;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile CoroutineContext f24164d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public RememberedCoroutineScope(CoroutineContext coroutineContext, CoroutineContext coroutineContext2) {
        this.f24161a = coroutineContext;
        this.f24162b = coroutineContext2;
    }

    public final void a() {
        synchronized (this.f24163c) {
            try {
                CoroutineContext coroutineContext = this.f24164d;
                if (coroutineContext == null) {
                    this.f24164d = f24160h;
                } else {
                    JobKt.c(coroutineContext, new ForgottenCoroutineScopeException());
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
        a();
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        a();
    }

    @Override // kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        CoroutineContext coroutineContextPlus;
        CoroutineContext coroutineContext = this.f24164d;
        if (coroutineContext == null || coroutineContext == f24160h) {
            synchronized (this.f24163c) {
                try {
                    coroutineContextPlus = this.f24164d;
                    if (coroutineContextPlus == null) {
                        CoroutineContext coroutineContext2 = this.f24161a;
                        coroutineContextPlus = coroutineContext2.plus(JobKt.a((Job) coroutineContext2.get(Job.v8))).plus(this.f24162b);
                    } else if (coroutineContextPlus == f24160h) {
                        CoroutineContext coroutineContext3 = this.f24161a;
                        CompletableJob completableJobA = JobKt.a((Job) coroutineContext3.get(Job.v8));
                        completableJobA.cancel((CancellationException) new ForgottenCoroutineScopeException());
                        coroutineContextPlus = coroutineContext3.plus(completableJobA).plus(this.f24162b);
                    }
                    this.f24164d = coroutineContextPlus;
                    Unit unit = Unit.f139807a;
                } catch (Throwable th) {
                    throw th;
                }
            }
            coroutineContext = coroutineContextPlus;
        }
        Intrinsics.checkNotNull(coroutineContext);
        return coroutineContext;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
    }
}
