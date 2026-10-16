package androidx.compose.foundation.lazy.layout;

import android.view.Choreographer;
import android.view.View;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class AndroidPrefetchScheduler implements PrefetchScheduler, RememberObserver, Runnable, Choreographer.FrameCallback {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f7967h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f7968i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static long f7969j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final View f7970a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7972c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f7974f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f7975g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MutableVector f7971b = new MutableVector(new PrefetchRequest[16], 0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Choreographer f7973d = Choreographer.getInstance();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void b(android.view.View r5) {
            /*
                r4 = this;
                long r0 = androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler.b()
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 != 0) goto L2c
                android.view.Display r0 = r5.getDisplay()
                boolean r5 = r5.isInEditMode()
                if (r5 != 0) goto L21
                if (r0 == 0) goto L21
                float r5 = r0.getRefreshRate()
                r0 = 1106247680(0x41f00000, float:30.0)
                int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
                if (r0 < 0) goto L21
                goto L23
            L21:
                r5 = 1114636288(0x42700000, float:60.0)
            L23:
                r0 = 1000000000(0x3b9aca00, float:0.0047237873)
                float r0 = (float) r0
                float r0 = r0 / r5
                long r0 = (long) r0
                androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler.f(r0)
            L2c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.AndroidPrefetchScheduler.Companion.b(android.view.View):void");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PrefetchRequestScopeImpl implements PrefetchRequestScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f7976a;

        public PrefetchRequestScopeImpl(long j3) {
            this.f7976a = j3;
        }

        @Override // androidx.compose.foundation.lazy.layout.PrefetchRequestScope
        public long a() {
            return Math.max(0L, this.f7976a - System.nanoTime());
        }
    }

    public AndroidPrefetchScheduler(View view) {
        this.f7970a = view;
        f7967h.b(view);
    }

    @Override // androidx.compose.foundation.lazy.layout.PrefetchScheduler
    public void a(PrefetchRequest prefetchRequest) {
        this.f7971b.b(prefetchRequest);
        if (this.f7972c) {
            return;
        }
        this.f7972c = true;
        this.f7970a.post(this);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void c() {
        this.f7974f = true;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j3) {
        if (this.f7974f) {
            this.f7975g = j3;
            this.f7970a.post(this);
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void e() {
        this.f7974f = false;
        this.f7970a.removeCallbacks(this);
        this.f7973d.removeFrameCallback(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f7971b.o() == 0 || !this.f7972c || !this.f7974f || this.f7970a.getWindowVisibility() != 0) {
            this.f7972c = false;
            return;
        }
        PrefetchRequestScopeImpl prefetchRequestScopeImpl = new PrefetchRequestScopeImpl(this.f7975g + f7969j);
        boolean z2 = false;
        while (this.f7971b.o() != 0 && !z2) {
            if (prefetchRequestScopeImpl.a() <= 0 || ((PrefetchRequest) this.f7971b.f24389a[0]).b(prefetchRequestScopeImpl)) {
                z2 = true;
            } else {
                this.f7971b.u(0);
            }
        }
        if (z2) {
            this.f7973d.postFrameCallback(this);
        } else {
            this.f7972c = false;
        }
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void d() {
    }
}
