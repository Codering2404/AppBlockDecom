package kotlinx.coroutines.guava;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

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
final class JobListenableFuture<T> implements ListenableFuture<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Job f142416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SettableFuture f142417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f142418c;

    private final Object c(Object obj) throws Throwable {
        if (obj instanceof Cancelled) {
            throw new CancellationException().initCause(((Cancelled) obj).f142415a);
        }
        return obj;
    }

    public final boolean a(Object obj) {
        return this.f142417b.B(obj);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.f142417b.addListener(runnable, executor);
    }

    public final boolean b(Throwable th) {
        if (th instanceof CancellationException) {
            return this.f142417b.B(new Cancelled((CancellationException) th));
        }
        boolean zC = this.f142417b.C(th);
        if (zC) {
            this.f142418c = true;
        }
        return zC;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z2) {
        if (!this.f142417b.cancel(z2)) {
            return false;
        }
        Job.DefaultImpls.b(this.f142416a, null, 1, null);
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get() {
        return c(this.f142417b.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        boolean z2;
        if (this.f142417b.isCancelled()) {
            return true;
        }
        if (isDone() && !this.f142418c) {
            try {
                z2 = Uninterruptibles.a(this.f142417b) instanceof Cancelled;
            } catch (CancellationException unused) {
                z2 = true;
            } catch (ExecutionException unused2) {
                this.f142418c = true;
                z2 = false;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f142417b.isDone();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isDone()) {
            try {
                Object objA = Uninterruptibles.a(this.f142417b);
                if (objA instanceof Cancelled) {
                    sb.append("CANCELLED, cause=[" + ((Cancelled) objA).f142415a + ']');
                } else {
                    sb.append("SUCCESS, result=[" + objA + ']');
                }
            } catch (CancellationException unused) {
                sb.append("CANCELLED");
            } catch (ExecutionException e3) {
                sb.append("FAILURE, cause=[" + e3.getCause() + ']');
            } catch (Throwable th) {
                sb.append("UNKNOWN, cause=[" + th.getClass() + " thrown from get()]");
            }
        } else {
            sb.append("PENDING, delegate=[" + this.f142417b + ']');
        }
        sb.append(']');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j3, TimeUnit timeUnit) {
        return c(this.f142417b.get(j3, timeUnit));
    }
}
