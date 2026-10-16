package com.facebook.bolts;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class CancellationTokenSource implements Closeable {
    private boolean cancellationRequested;
    private boolean closed;
    private ScheduledFuture<?> scheduledCancellation;
    private final Object lock = new Object();
    private final List<CancellationTokenRegistration> registrations = new ArrayList();
    private final ScheduledExecutorService executor = BoltsExecutors.Companion.scheduled$facebook_bolts_release();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelAfter$lambda$6$lambda$5(CancellationTokenSource this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.lock) {
            this$0.scheduledCancellation = null;
            Unit unit = Unit.f139807a;
        }
        this$0.cancel();
    }

    private final void cancelScheduledCancellation() {
        ScheduledFuture<?> scheduledFuture = this.scheduledCancellation;
        if (scheduledFuture == null) {
            return;
        }
        scheduledFuture.cancel(true);
        this.scheduledCancellation = null;
    }

    private final void notifyListeners(List<CancellationTokenRegistration> list) {
        Iterator<CancellationTokenRegistration> it = list.iterator();
        while (it.hasNext()) {
            it.next().runAction$facebook_bolts_release();
        }
    }

    private final void throwIfClosed() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    public final void cancel() {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                return;
            }
            cancelScheduledCancellation();
            this.cancellationRequested = true;
            ArrayList arrayList = new ArrayList(this.registrations);
            Unit unit = Unit.f139807a;
            notifyListeners(arrayList);
        }
    }

    public final void cancelAfter(long j3) {
        cancelAfter(j3, TimeUnit.MILLISECONDS);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.lock) {
            try {
                if (this.closed) {
                    return;
                }
                cancelScheduledCancellation();
                Iterator<CancellationTokenRegistration> it = this.registrations.iterator();
                while (it.hasNext()) {
                    it.next().close();
                }
                this.registrations.clear();
                this.closed = true;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final CancellationToken getToken() {
        CancellationToken cancellationToken;
        synchronized (this.lock) {
            throwIfClosed();
            cancellationToken = new CancellationToken(this);
        }
        return cancellationToken;
    }

    public final boolean isCancellationRequested() {
        boolean z2;
        synchronized (this.lock) {
            throwIfClosed();
            z2 = this.cancellationRequested;
        }
        return z2;
    }

    public final CancellationTokenRegistration register$facebook_bolts_release(Runnable runnable) {
        CancellationTokenRegistration cancellationTokenRegistration;
        synchronized (this.lock) {
            try {
                throwIfClosed();
                cancellationTokenRegistration = new CancellationTokenRegistration(this, runnable);
                if (this.cancellationRequested) {
                    cancellationTokenRegistration.runAction$facebook_bolts_release();
                    Unit unit = Unit.f139807a;
                } else {
                    this.registrations.add(cancellationTokenRegistration);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return cancellationTokenRegistration;
    }

    public final void throwIfCancellationRequested$facebook_bolts_release() throws CancellationException {
        synchronized (this.lock) {
            throwIfClosed();
            if (this.cancellationRequested) {
                throw new CancellationException();
            }
            Unit unit = Unit.f139807a;
        }
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
        String str = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{CancellationTokenSource.class.getName(), Integer.toHexString(hashCode()), Boolean.toString(isCancellationRequested())}, 3));
        Intrinsics.checkNotNullExpressionValue(str, "format(locale, format, *args)");
        return str;
    }

    public final void unregister$facebook_bolts_release(CancellationTokenRegistration registration) {
        Intrinsics.checkNotNullParameter(registration, "registration");
        synchronized (this.lock) {
            throwIfClosed();
            this.registrations.remove(registration);
        }
    }

    private final void cancelAfter(long j3, TimeUnit timeUnit) {
        if (j3 < -1) {
            throw new IllegalArgumentException("Delay must be >= -1");
        }
        if (j3 == 0) {
            cancel();
            return;
        }
        synchronized (this.lock) {
            try {
                if (this.cancellationRequested) {
                    return;
                }
                cancelScheduledCancellation();
                if (j3 != -1) {
                    this.scheduledCancellation = this.executor.schedule(new Runnable() { // from class: com.facebook.bolts.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            CancellationTokenSource.cancelAfter$lambda$6$lambda$5(this.f68082a);
                        }
                    }, j3, timeUnit);
                }
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
