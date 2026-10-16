package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.compose.runtime.MonotonicFrameClock;
import androidx.core.os.HandlerCompat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
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
public final class AndroidUiDispatcher extends CoroutineDispatcher {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Companion f27887m = new Companion(null);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f27888n = 8;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final Lazy f27889o = LazyKt.b(new Function0<CoroutineContext>() { // from class: androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2
        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final CoroutineContext invoke() {
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(AndroidUiDispatcher_androidKt.b() ? Choreographer.getInstance() : (Choreographer) BuildersKt.e(Dispatchers.c(), new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(null)), HandlerCompat.a(Looper.getMainLooper()), null);
            return androidUiDispatcher.plus(androidUiDispatcher.t1());
        }
    });

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final ThreadLocal f27890p = new ThreadLocal<CoroutineContext>() { // from class: androidx.compose.ui.platform.AndroidUiDispatcher$Companion$currentThread$1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoroutineContext initialValue() {
            Choreographer choreographer = Choreographer.getInstance();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                throw new IllegalStateException("no Looper on this thread");
            }
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, HandlerCompat.a(looperMyLooper), null);
            return androidUiDispatcher.plus(androidUiDispatcher.t1());
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Choreographer f27891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Handler f27892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f27893d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f27894f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private List f27895g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private List f27896h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f27897i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f27898j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AndroidUiDispatcher$dispatchCallback$1 f27899k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final MonotonicFrameClock f27900l;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CoroutineContext a() {
            if (AndroidUiDispatcher_androidKt.b()) {
                return b();
            }
            CoroutineContext coroutineContext = (CoroutineContext) AndroidUiDispatcher.f27890p.get();
            if (coroutineContext != null) {
                return coroutineContext;
            }
            throw new IllegalStateException("no AndroidUiDispatcher for this thread");
        }

        public final CoroutineContext b() {
            return (CoroutineContext) AndroidUiDispatcher.f27889o.getValue();
        }

        private Companion() {
        }
    }

    public /* synthetic */ AndroidUiDispatcher(Choreographer choreographer, Handler handler, DefaultConstructorMarker defaultConstructorMarker) {
        this(choreographer, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A1() {
        boolean z2;
        do {
            Runnable runnableU1 = u1();
            while (runnableU1 != null) {
                runnableU1.run();
                runnableU1 = u1();
            }
            synchronized (this.f27893d) {
                if (this.f27894f.isEmpty()) {
                    z2 = false;
                    this.f27897i = false;
                } else {
                    z2 = true;
                }
            }
        } while (z2);
    }

    private final Runnable u1() {
        Runnable runnable;
        synchronized (this.f27893d) {
            runnable = (Runnable) this.f27894f.removeFirstOrNull();
        }
        return runnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w1(long j3) {
        synchronized (this.f27893d) {
            if (this.f27898j) {
                this.f27898j = false;
                List list = this.f27895g;
                this.f27895g = this.f27896h;
                this.f27896h = list;
                int size = list.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((Choreographer.FrameCallback) list.get(i3)).doFrame(j3);
                }
                list.clear();
            }
        }
    }

    public final void B1(Choreographer.FrameCallback frameCallback) {
        synchronized (this.f27893d) {
            try {
                this.f27895g.add(frameCallback);
                if (!this.f27898j) {
                    this.f27898j = true;
                    this.f27891b.postFrameCallback(this.f27899k);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void I1(Choreographer.FrameCallback frameCallback) {
        synchronized (this.f27893d) {
            this.f27895g.remove(frameCallback);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void M(CoroutineContext coroutineContext, Runnable runnable) {
        synchronized (this.f27893d) {
            try {
                this.f27894f.addLast(runnable);
                if (!this.f27897i) {
                    this.f27897i = true;
                    this.f27892c.post(this.f27899k);
                    if (!this.f27898j) {
                        this.f27898j = true;
                        this.f27891b.postFrameCallback(this.f27899k);
                    }
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final Choreographer o1() {
        return this.f27891b;
    }

    public final MonotonicFrameClock t1() {
        return this.f27900l;
    }

    private AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        this.f27891b = choreographer;
        this.f27892c = handler;
        this.f27893d = new Object();
        this.f27894f = new ArrayDeque();
        this.f27895g = new ArrayList();
        this.f27896h = new ArrayList();
        this.f27899k = new AndroidUiDispatcher$dispatchCallback$1(this);
        this.f27900l = new AndroidUiFrameClock(choreographer, this);
    }
}
