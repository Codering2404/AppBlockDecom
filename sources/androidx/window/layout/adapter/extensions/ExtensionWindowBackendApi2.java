package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.layout.adapter.WindowBackend;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class ExtensionWindowBackendApi2 implements WindowBackend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WindowLayoutComponent f54385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f54386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f54387c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map f54388d;

    public ExtensionWindowBackendApi2(WindowLayoutComponent component) {
        Intrinsics.checkNotNullParameter(component, "component");
        this.f54385a = component;
        this.f54386b = new ReentrantLock();
        this.f54387c = new LinkedHashMap();
        this.f54388d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.adapter.WindowBackend
    public void a(Consumer callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = this.f54386b;
        reentrantLock.lock();
        try {
            Context context = (Context) this.f54388d.get(callback);
            if (context == null) {
                reentrantLock.unlock();
                return;
            }
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f54387c.get(context);
            if (multicastConsumer == null) {
                reentrantLock.unlock();
                return;
            }
            multicastConsumer.c(callback);
            this.f54388d.remove(callback);
            if (multicastConsumer.b()) {
                this.f54387c.remove(context);
                this.f54385a.removeWindowLayoutInfoListener(multicastConsumer);
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
        ReentrantLock reentrantLock = this.f54386b;
        reentrantLock.lock();
        try {
            MulticastConsumer multicastConsumer = (MulticastConsumer) this.f54387c.get(context);
            if (multicastConsumer != null) {
                multicastConsumer.a(callback);
                this.f54388d.put(callback, context);
                unit = Unit.f139807a;
            } else {
                unit = null;
            }
            if (unit == null) {
                MulticastConsumer multicastConsumer2 = new MulticastConsumer(context);
                this.f54387c.put(context, multicastConsumer2);
                this.f54388d.put(callback, context);
                multicastConsumer2.a(callback);
                this.f54385a.addWindowLayoutInfoListener(context, multicastConsumer2);
            }
            Unit unit2 = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
