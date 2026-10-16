package com.facebook.bolts;

import java.io.Closeable;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CancellationTokenRegistration implements Closeable {
    private Runnable action;
    private boolean closed;
    private CancellationTokenSource tokenSource;

    public CancellationTokenRegistration(CancellationTokenSource tokenSource, Runnable runnable) {
        Intrinsics.checkNotNullParameter(tokenSource, "tokenSource");
        this.action = runnable;
        this.tokenSource = tokenSource;
    }

    private final void throwIfClosed() {
        if (this.closed) {
            throw new IllegalStateException("Object already closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            try {
                if (this.closed) {
                    return;
                }
                this.closed = true;
                CancellationTokenSource cancellationTokenSource = this.tokenSource;
                if (cancellationTokenSource != null) {
                    cancellationTokenSource.unregister$facebook_bolts_release(this);
                }
                this.tokenSource = null;
                this.action = null;
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void runAction$facebook_bolts_release() {
        synchronized (this) {
            try {
                throwIfClosed();
                Runnable runnable = this.action;
                if (runnable != null) {
                    runnable.run();
                }
                close();
                Unit unit = Unit.f139807a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
