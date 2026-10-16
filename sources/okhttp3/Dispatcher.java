package okhttp3;

import com.google.android.gms.common.api.Api;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealCall;

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
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class Dispatcher {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Runnable f144057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ExecutorService f144058d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f144055a = 64;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f144056b = 5;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ArrayDeque f144059e = new ArrayDeque();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayDeque f144060f = new ArrayDeque();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ArrayDeque f144061g = new ArrayDeque();

    private final RealCall.AsyncCall d(String str) {
        for (RealCall.AsyncCall asyncCall : this.f144060f) {
            if (Intrinsics.areEqual(asyncCall.d(), str)) {
                return asyncCall;
            }
        }
        for (RealCall.AsyncCall asyncCall2 : this.f144059e) {
            if (Intrinsics.areEqual(asyncCall2.d(), str)) {
                return asyncCall2;
            }
        }
        return null;
    }

    private final void e(Deque deque, Object obj) {
        Runnable runnableH;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnableH = h();
            Unit unit = Unit.f139807a;
        }
        if (k() || runnableH == null) {
            return;
        }
        runnableH.run();
    }

    private final boolean k() {
        int i3;
        boolean z2;
        if (Util.f144281h && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = this.f144059e.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    RealCall.AsyncCall asyncCall = (RealCall.AsyncCall) it.next();
                    if (this.f144060f.size() >= i()) {
                        break;
                    }
                    if (asyncCall.c().get() < j()) {
                        it.remove();
                        asyncCall.c().incrementAndGet();
                        Intrinsics.checkNotNullExpressionValue(asyncCall, "asyncCall");
                        arrayList.add(asyncCall);
                        this.f144060f.add(asyncCall);
                    }
                }
                z2 = l() > 0;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i3 = 0; i3 < size; i3++) {
            ((RealCall.AsyncCall) arrayList.get(i3)).a(c());
        }
        return z2;
    }

    public final void a(RealCall.AsyncCall call) {
        RealCall.AsyncCall asyncCallD;
        Intrinsics.checkNotNullParameter(call, "call");
        synchronized (this) {
            try {
                this.f144059e.add(call);
                if (!call.b().q() && (asyncCallD = d(call.d())) != null) {
                    call.e(asyncCallD);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
        k();
    }

    public final synchronized void b(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        this.f144061g.add(call);
    }

    public final synchronized ExecutorService c() {
        ExecutorService executorService;
        try {
            if (this.f144058d == null) {
                this.f144058d = new ThreadPoolExecutor(0, Api.BaseClientBuilder.API_PRIORITY_OTHER, 60L, TimeUnit.SECONDS, new SynchronousQueue(), Util.N(Intrinsics.stringPlus(Util.f144282i, " Dispatcher"), false));
            }
            executorService = this.f144058d;
            Intrinsics.checkNotNull(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final void f(RealCall.AsyncCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        call.c().decrementAndGet();
        e(this.f144060f, call);
    }

    public final void g(RealCall call) {
        Intrinsics.checkNotNullParameter(call, "call");
        e(this.f144061g, call);
    }

    public final synchronized Runnable h() {
        return this.f144057c;
    }

    public final synchronized int i() {
        return this.f144055a;
    }

    public final synchronized int j() {
        return this.f144056b;
    }

    public final synchronized int l() {
        return this.f144060f.size() + this.f144061g.size();
    }
}
