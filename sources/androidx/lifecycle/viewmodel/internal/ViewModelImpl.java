package androidx.lifecycle.viewmodel.internal;

import f.a;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class ViewModelImpl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SynchronizedObject f40249a = new SynchronizedObject();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f40250b = new LinkedHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set f40251c = new LinkedHashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f40252d;

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                a.a(autoCloseable);
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
        }
    }

    public final void d(AutoCloseable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        if (this.f40252d) {
            g(closeable);
            return;
        }
        synchronized (this.f40249a) {
            this.f40251c.add(closeable);
            Unit unit = Unit.f139807a;
        }
    }

    public final void e(String key, AutoCloseable closeable) {
        AutoCloseable autoCloseable;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        if (this.f40252d) {
            g(closeable);
            return;
        }
        synchronized (this.f40249a) {
            autoCloseable = (AutoCloseable) this.f40250b.put(key, closeable);
        }
        g(autoCloseable);
    }

    public final void f() {
        if (this.f40252d) {
            return;
        }
        this.f40252d = true;
        synchronized (this.f40249a) {
            try {
                Iterator it = this.f40250b.values().iterator();
                while (it.hasNext()) {
                    g((AutoCloseable) it.next());
                }
                Iterator it2 = this.f40251c.iterator();
                while (it2.hasNext()) {
                    g((AutoCloseable) it2.next());
                }
                this.f40251c.clear();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AutoCloseable h(String key) {
        AutoCloseable autoCloseable;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.f40249a) {
            autoCloseable = (AutoCloseable) this.f40250b.get(key);
        }
        return autoCloseable;
    }
}
