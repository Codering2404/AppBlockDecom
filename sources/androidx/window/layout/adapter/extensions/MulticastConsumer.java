package androidx.window.layout.adapter.extensions;

import android.content.Context;
import androidx.core.util.Consumer;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
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
public final class MulticastConsumer implements Consumer<WindowLayoutInfo>, androidx.window.extensions.core.util.function.Consumer<WindowLayoutInfo> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f54390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantLock f54391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private androidx.window.layout.WindowLayoutInfo f54392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f54393d;

    public MulticastConsumer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.f54390a = context;
        this.f54391b = new ReentrantLock();
        this.f54393d = new LinkedHashSet();
    }

    public final void a(Consumer listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.f54391b;
        reentrantLock.lock();
        try {
            androidx.window.layout.WindowLayoutInfo windowLayoutInfo = this.f54392c;
            if (windowLayoutInfo != null) {
                listener.accept(windowLayoutInfo);
            }
            this.f54393d.add(listener);
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final boolean b() {
        return this.f54393d.isEmpty();
    }

    public final void c(Consumer listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.f54391b;
        reentrantLock.lock();
        try {
            this.f54393d.remove(listener);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.core.util.Consumer
    public void accept(WindowLayoutInfo value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ReentrantLock reentrantLock = this.f54391b;
        reentrantLock.lock();
        try {
            androidx.window.layout.WindowLayoutInfo windowLayoutInfoB = ExtensionsWindowLayoutInfoAdapter.f54389a.b(this.f54390a, value);
            this.f54392c = windowLayoutInfoB;
            Iterator it = this.f54393d.iterator();
            while (it.hasNext()) {
                ((Consumer) it.next()).accept(windowLayoutInfoB);
            }
            Unit unit = Unit.f139807a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
