package androidx.window.layout.adapter.extensions;

import android.app.Activity;
import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.core.ConsumerAdapter;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import androidx.window.layout.adapter.WindowBackend;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ExtensionWindowBackendApi1 implements WindowBackend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowLayoutComponent f54379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConsumerAdapter f54380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantLock f54381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f54382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map f54383e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map f54384f;

    public ExtensionWindowBackendApi1(WindowLayoutComponent component, ConsumerAdapter consumerAdapter) {
        Intrinsics.checkNotNullParameter(component, "component");
        Intrinsics.checkNotNullParameter(consumerAdapter, "consumerAdapter");
        this.f54379a = component;
        this.f54380b = consumerAdapter;
        this.f54381c = new ReentrantLock();
        this.f54382d = new LinkedHashMap();
        this.f54383e = new LinkedHashMap();
        this.f54384f = new LinkedHashMap();
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(Consumer callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = this.f54381c;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f54383e.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f54382d.get(context);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.c(callback);
            this.f54383e.remove(callback);
            if (multicastConsumer.b()) {
                this.f54382d.remove(context);
                ConsumerAdapter.Subscription subscription = (ConsumerAdapter.Subscription) this.f54384f.remove(multicastConsumer);
                if (subscription != null) {
                    subscription.dispose();
                }
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void b(Context context, Executor executor, Consumer callback) {
        Unit unit;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(executor, "executor");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = this.f54381c;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f54382d.get(context);
            if (multicastConsumer != null) {
                multicastConsumer.a(callback);
                this.f54383e.put(callback, context);
                unit = Unit.f139807a;
            } else {
                unit = null;
            }
            if (unit == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(context);
                this.f54382d.put(context, multicastConsumer2);
                this.f54383e.put(callback, context);
                multicastConsumer2.a(callback);
                if (!(context instanceof Activity)) {
                    multicastConsumer2.accept(new WindowLayoutInfo(CollectionsKt.emptyList()));
                    reentrantLock.unlock();
                    return;
                } else {
                    this.f54384f.put(multicastConsumer2, this.f54380b.c(this.f54379a, Reflection.b(WindowLayoutInfo.class), "addWindowLayoutInfoListener", "removeWindowLayoutInfoListener", (Activity) context, new ExtensionWindowBackendApi1$registerLayoutChangeCallback$1$2$disposableToken$1(multicastConsumer2)));
                }
            }
            Unit unit2 = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
