package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequest;
import kotlin.Metadata;
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
public final class RequestProgress {
    public final Handler callbackHandler;
    public long lastReportedProgress;
    public long maxProgress;
    public long progress;
    public final GraphRequest request;
    public final long threshold;

    public RequestProgress(Handler handler, GraphRequest request) {
        Intrinsics.checkNotNullParameter(request, "request");
        this.callbackHandler = handler;
        this.request = request;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    public static final void reportProgress$lambda$0(GraphRequest.Callback callback, long j3, long j4) {
        ((GraphRequest.OnProgressCallback) callback).onProgress(j3, j4);
    }

    public final void addProgress(long j3) {
        long j4 = this.progress + j3;
        this.progress = j4;
        if (j4 >= this.lastReportedProgress + this.threshold || j4 >= this.maxProgress) {
            reportProgress();
        }
    }

    public final void addToMax(long j3) {
        this.maxProgress += j3;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    public final long getProgress() {
        return this.progress;
    }

    public final void reportProgress() {
        if (this.progress > this.lastReportedProgress) {
            final GraphRequest.Callback callback = this.request.getCallback();
            final long j3 = this.maxProgress;
            if (j3 <= 0 || !(callback instanceof GraphRequest.OnProgressCallback)) {
                return;
            }
            final long j4 = this.progress;
            Handler handler = this.callbackHandler;
            if (handler != null) {
                handler.post(new Runnable() { // from class: com.facebook.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        RequestProgress.reportProgress$lambda$0(callback, j4, j3);
                    }
                });
            } else {
                ((GraphRequest.OnProgressCallback) callback).onProgress(j4, j3);
            }
            this.lastReportedProgress = this.progress;
        }
    }
}
