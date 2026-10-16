package coil.request;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;

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
public final class GlobalLifecycle extends Lifecycle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final GlobalLifecycle f56045a = new GlobalLifecycle();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final GlobalLifecycle$owner$1 f56046b = new LifecycleOwner() { // from class: coil.request.GlobalLifecycle$owner$1
        @Override // androidx.lifecycle.LifecycleOwner
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public GlobalLifecycle getLifecycle() {
            return GlobalLifecycle.f56045a;
        }
    };

    private GlobalLifecycle() {
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver lifecycleObserver) {
        if (!(lifecycleObserver instanceof DefaultLifecycleObserver)) {
            throw new IllegalArgumentException((lifecycleObserver + " must implement androidx.lifecycle.DefaultLifecycleObserver.").toString());
        }
        DefaultLifecycleObserver defaultLifecycleObserver = (DefaultLifecycleObserver) lifecycleObserver;
        GlobalLifecycle$owner$1 globalLifecycle$owner$1 = f56046b;
        defaultLifecycleObserver.onCreate(globalLifecycle$owner$1);
        defaultLifecycleObserver.onStart(globalLifecycle$owner$1);
        defaultLifecycleObserver.onResume(globalLifecycle$owner$1);
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return Lifecycle.State.f39951f;
    }

    public String toString() {
        return "coil.request.GlobalLifecycle";
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver lifecycleObserver) {
    }
}
