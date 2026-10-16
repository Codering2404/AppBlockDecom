package androidx.work.impl.background.greedy;

import androidx.work.RunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncher;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class TimeLimiter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RunnableScheduler f54769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WorkLauncher f54770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f54771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f54772d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f54773e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher launcher) {
        this(runnableScheduler, launcher, 0L, 4, null);
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(TimeLimiter this$0, StartStopToken token) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(token, "$token");
        this$0.f54770b.d(token, 3);
    }

    public final void b(StartStopToken token) {
        Runnable runnable;
        Intrinsics.checkNotNullParameter(token, "token");
        synchronized (this.f54772d) {
            runnable = (Runnable) this.f54773e.remove(token);
        }
        if (runnable != null) {
            this.f54769a.a(runnable);
        }
    }

    public final void c(final StartStopToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.a
            @Override // java.lang.Runnable
            public final void run() {
                TimeLimiter.d(this.f54774a, token);
            }
        };
        synchronized (this.f54772d) {
        }
        this.f54769a.b(this.f54771c, runnable);
    }

    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher launcher, long j3) {
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.f54769a = runnableScheduler;
        this.f54770b = launcher;
        this.f54771c = j3;
        this.f54772d = new Object();
        this.f54773e = new LinkedHashMap();
    }

    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnableScheduler, workLauncher, (i3 & 4) != 0 ? TimeUnit.MINUTES.toMillis(90L) : j3);
    }
}
