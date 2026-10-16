package coil.util;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import coil.RealImageLoader;
import coil.network.EmptyNetworkObserver;
import coil.network.NetworkObserver;
import coil.network.NetworkObserverKt;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class SystemCallbacks implements ComponentCallbacks2, NetworkObserver.Listener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Companion f56242g = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f56243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f56244b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final NetworkObserver f56245c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f56246d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f56247f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SystemCallbacks(RealImageLoader realImageLoader, Context context, boolean z2) {
        this.f56243a = context;
        this.f56244b = new WeakReference(realImageLoader);
        NetworkObserver networkObserverA = z2 ? NetworkObserverKt.a(context, this, realImageLoader.h()) : new EmptyNetworkObserver();
        this.f56245c = networkObserverA;
        this.f56246d = networkObserverA.a();
        this.f56247f = new AtomicBoolean(false);
    }

    @Override // coil.network.NetworkObserver.Listener
    public void a(boolean z2) {
        RealImageLoader realImageLoader = (RealImageLoader) this.f56244b.get();
        Unit unit = null;
        if (realImageLoader != null) {
            Logger loggerH = realImageLoader.h();
            if (loggerH != null && loggerH.getLevel() <= 4) {
                loggerH.a("NetworkObserver", 4, z2 ? "ONLINE" : "OFFLINE", null);
            }
            this.f56246d = z2;
            unit = Unit.f139807a;
        }
        if (unit == null) {
            d();
        }
    }

    public final boolean b() {
        return this.f56246d;
    }

    public final void c() {
        this.f56243a.registerComponentCallbacks(this);
    }

    public final void d() {
        if (this.f56247f.getAndSet(true)) {
            return;
        }
        this.f56243a.unregisterComponentCallbacks(this);
        this.f56245c.shutdown();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        if (((RealImageLoader) this.f56244b.get()) == null) {
            d();
            Unit unit = Unit.f139807a;
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        onTrimMemory(80);
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i3) {
        RealImageLoader realImageLoader = (RealImageLoader) this.f56244b.get();
        Unit unit = null;
        if (realImageLoader != null) {
            Logger loggerH = realImageLoader.h();
            if (loggerH != null && loggerH.getLevel() <= 2) {
                loggerH.a("NetworkObserver", 2, "trimMemory, level=" + i3, null);
            }
            realImageLoader.l(i3);
            unit = Unit.f139807a;
        }
        if (unit == null) {
            d();
        }
    }
}
