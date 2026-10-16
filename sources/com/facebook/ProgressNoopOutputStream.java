package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
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
public final class ProgressNoopOutputStream extends OutputStream implements RequestOutputStream {
    public final Handler callbackHandler;
    public GraphRequest currentRequest;
    public RequestProgress currentRequestProgress;
    public int maxProgress;
    public final Map<GraphRequest, RequestProgress> progressMap = new HashMap();

    public ProgressNoopOutputStream(Handler handler) {
        this.callbackHandler = handler;
    }

    public final void addProgress(long j3) {
        GraphRequest graphRequest = this.currentRequest;
        if (graphRequest == null) {
            return;
        }
        if (this.currentRequestProgress == null) {
            RequestProgress requestProgress = new RequestProgress(this.callbackHandler, graphRequest);
            this.currentRequestProgress = requestProgress;
            this.progressMap.put(graphRequest, requestProgress);
        }
        RequestProgress requestProgress2 = this.currentRequestProgress;
        if (requestProgress2 != null) {
            requestProgress2.addToMax(j3);
        }
        this.maxProgress += (int) j3;
    }

    public final int getMaxProgress() {
        return this.maxProgress;
    }

    public final Map<GraphRequest, RequestProgress> getProgressMap() {
        return this.progressMap;
    }

    @Override // com.facebook.RequestOutputStream
    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequest = graphRequest;
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        addProgress(buffer.length);
    }

    @Override // java.io.OutputStream
    public void write(byte[] buffer, int i3, int i4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        addProgress(i4);
    }

    @Override // java.io.OutputStream
    public void write(int i3) {
        addProgress(1L);
    }
}
