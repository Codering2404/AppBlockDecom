package com.facebook.bolts;

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
public class TaskCompletionSource<TResult> {
    private final Task<TResult> task = new Task<>();

    public final Task<TResult> getTask() {
        return this.task;
    }

    public final void setCancelled() {
        if (!trySetCancelled()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public final void setError(Exception exc) {
        if (!trySetError(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public final void setResult(TResult tresult) {
        if (!trySetResult(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public final boolean trySetCancelled() {
        return this.task.trySetCancelled();
    }

    public final boolean trySetError(Exception exc) {
        return this.task.trySetError(exc);
    }

    public final boolean trySetResult(TResult tresult) {
        return this.task.trySetResult(tresult);
    }
}
