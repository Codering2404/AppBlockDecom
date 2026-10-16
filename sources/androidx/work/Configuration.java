package androidx.work;

import androidx.core.util.Consumer;
import androidx.work.impl.DefaultRunnableScheduler;
import com.google.android.gms.common.api.Api;
import java.util.concurrent.Executor;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class Configuration {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Companion f54446p = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f54447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f54448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Clock f54449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WorkerFactory f54450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final InputMergerFactory f54451e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RunnableScheduler f54452f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Consumer f54453g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Consumer f54454h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f54455i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f54456j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f54457k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final int f54458l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final int f54459m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f54460n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f54461o;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Executor f54462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private WorkerFactory f54463b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private InputMergerFactory f54464c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Executor f54465d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Clock f54466e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private RunnableScheduler f54467f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Consumer f54468g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Consumer f54469h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f54470i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f54472k;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f54471j = 4;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private int f54473l = Api.BaseClientBuilder.API_PRIORITY_OTHER;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private int f54474m = 20;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private int f54475n = ConfigurationKt.c();

        public final Configuration a() {
            return new Configuration(this);
        }

        public final Clock b() {
            return this.f54466e;
        }

        public final int c() {
            return this.f54475n;
        }

        public final String d() {
            return this.f54470i;
        }

        public final Executor e() {
            return this.f54462a;
        }

        public final Consumer f() {
            return this.f54468g;
        }

        public final InputMergerFactory g() {
            return this.f54464c;
        }

        public final int h() {
            return this.f54471j;
        }

        public final int i() {
            return this.f54473l;
        }

        public final int j() {
            return this.f54474m;
        }

        public final int k() {
            return this.f54472k;
        }

        public final RunnableScheduler l() {
            return this.f54467f;
        }

        public final Consumer m() {
            return this.f54469h;
        }

        public final Executor n() {
            return this.f54465d;
        }

        public final WorkerFactory o() {
            return this.f54463b;
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

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Provider {
        Configuration b();
    }

    public Configuration(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Executor executorE = builder.e();
        this.f54447a = executorE == null ? ConfigurationKt.b(false) : executorE;
        this.f54461o = builder.n() == null;
        Executor executorN = builder.n();
        this.f54448b = executorN == null ? ConfigurationKt.b(true) : executorN;
        Clock clockB = builder.b();
        this.f54449c = clockB == null ? new SystemClock() : clockB;
        WorkerFactory workerFactoryO = builder.o();
        if (workerFactoryO == null) {
            workerFactoryO = WorkerFactory.c();
            Intrinsics.checkNotNullExpressionValue(workerFactoryO, "getDefaultWorkerFactory()");
        }
        this.f54450d = workerFactoryO;
        InputMergerFactory inputMergerFactoryG = builder.g();
        this.f54451e = inputMergerFactoryG == null ? NoOpInputMergerFactory.f54549a : inputMergerFactoryG;
        RunnableScheduler runnableSchedulerL = builder.l();
        this.f54452f = runnableSchedulerL == null ? new DefaultRunnableScheduler() : runnableSchedulerL;
        this.f54456j = builder.h();
        this.f54457k = builder.k();
        this.f54458l = builder.i();
        this.f54460n = builder.j();
        this.f54453g = builder.f();
        this.f54454h = builder.m();
        this.f54455i = builder.d();
        this.f54459m = builder.c();
    }

    public final Clock a() {
        return this.f54449c;
    }

    public final int b() {
        return this.f54459m;
    }

    public final String c() {
        return this.f54455i;
    }

    public final Executor d() {
        return this.f54447a;
    }

    public final Consumer e() {
        return this.f54453g;
    }

    public final InputMergerFactory f() {
        return this.f54451e;
    }

    public final int g() {
        return this.f54458l;
    }

    public final int h() {
        return this.f54460n;
    }

    public final int i() {
        return this.f54457k;
    }

    public final int j() {
        return this.f54456j;
    }

    public final RunnableScheduler k() {
        return this.f54452f;
    }

    public final Consumer l() {
        return this.f54454h;
    }

    public final Executor m() {
        return this.f54448b;
    }

    public final WorkerFactory n() {
        return this.f54450d;
    }
}
