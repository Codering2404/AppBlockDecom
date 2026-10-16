package androidx.room.concurrent;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class CloseBarrier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Function0 f52488a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AtomicInteger f52489b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final AtomicBoolean f52490c;

    public CloseBarrier(Function0 closeAction) {
        Intrinsics.checkNotNullParameter(closeAction, "closeAction");
        this.f52488a = closeAction;
        this.f52489b = new AtomicInteger(0);
        this.f52490c = new AtomicBoolean(false);
    }

    private final boolean c() {
        return this.f52490c.get();
    }

    public final boolean a() {
        synchronized (this) {
            if (c()) {
                return false;
            }
            this.f52489b.incrementAndGet();
            return true;
        }
    }

    public final void b() {
        synchronized (this) {
            if (this.f52490c.compareAndSet(false, true)) {
                Unit unit = Unit.f139807a;
                while (this.f52489b.get() != 0) {
                }
                this.f52488a.invoke();
            }
        }
    }

    public final void d() {
        synchronized (this) {
            this.f52489b.decrementAndGet();
            if (this.f52489b.get() < 0) {
                throw new IllegalStateException("Unbalanced call to unblock() detected.");
            }
            Unit unit = Unit.f139807a;
        }
    }
}
