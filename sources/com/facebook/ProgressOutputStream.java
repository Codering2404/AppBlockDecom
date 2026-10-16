package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.Map;
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
public final class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    public long batchProgress;
    public RequestProgress currentRequestProgress;
    public long lastReportedProgress;
    public final long maxProgress;
    public final Map<GraphRequest, RequestProgress> progressMap;
    public final GraphRequestBatch requests;
    public final long threshold;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProgressOutputStream(OutputStream out, GraphRequestBatch requests, Map<GraphRequest, RequestProgress> progressMap, long j3) {
        super(out);
        Intrinsics.checkNotNullParameter(out, "out");
        Intrinsics.checkNotNullParameter(requests, "requests");
        Intrinsics.checkNotNullParameter(progressMap, "progressMap");
        this.requests = requests;
        this.progressMap = progressMap;
        this.maxProgress = j3;
        this.threshold = FacebookSdk.getOnProgressThreshold();
    }

    private final void addProgress(long j3) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j3);
        }
        long j4 = this.batchProgress + j3;
        this.batchProgress = j4;
        if (j4 >= this.lastReportedProgress + this.threshold || j4 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private final void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (final GraphRequestBatch.Callback callback : this.requests.getCallbacks()) {
                if (callback instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    if (callbackHandler != null) {
                        callbackHandler.post(new Runnable() { // from class: com.facebook.x
                            @Override // java.lang.Runnable
                            public final void run() {
                                ProgressOutputStream.reportBatchProgress$lambda$0(callback, this);
                            }
                        });
                    } else {
                        ((GraphRequestBatch.OnProgressCallback) callback).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    public static final void reportBatchProgress$lambda$0(GraphRequestBatch.Callback callback, ProgressOutputStream this$0) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((GraphRequestBatch.OnProgressCallback) callback).onBatchProgress(this$0.requests, this$0.batchProgress, this$0.maxProgress);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        super.close();
        Iterator<RequestProgress> it = this.progressMap.values().iterator();
        while (it.hasNext()) {
            it.next().reportProgress();
        }
        reportBatchProgress();
    }

    public final long getBatchProgress() {
        return this.batchProgress;
    }

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] buffer) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ((FilterOutputStream) this).out.write(buffer);
        addProgress(buffer.length);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] buffer, int i3, int i4) throws IOException {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        ((FilterOutputStream) this).out.write(buffer, i3, i4);
        addProgress(i4);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i3) throws IOException {
        ((FilterOutputStream) this).out.write(i3);
        addProgress(1L);
    }
}
