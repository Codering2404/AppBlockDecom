package com.facebook;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.net.HttpURLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public class GraphRequestAsyncTask extends AsyncTask<Void, Void, List<? extends GraphResponse>> {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = GraphRequestAsyncTask.class.getCanonicalName();
    public final HttpURLConnection connection;
    public Exception exception;
    public final GraphRequestBatch requests;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
        }
    }

    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequestBatch requests) {
        Intrinsics.checkNotNullParameter(requests, "requests");
        this.connection = httpURLConnection;
        this.requests = requests;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ List<? extends GraphResponse> doInBackground(Void[] voidArr) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            return doInBackground2(voidArr);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    protected final Exception getException() {
        return this.exception;
    }

    public final GraphRequestBatch getRequests() {
        return this.requests;
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(List<? extends GraphResponse> list) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            onPostExecute2((List<GraphResponse>) list);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            super.onPreExecute();
            if (FacebookSdk.isDebugEnabled()) {
                String str = TAG;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str2 = String.format("execute async task: %s", Arrays.copyOf(new Object[]{this}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                Utility.logd(str, str2);
            }
            if (this.requests.getCallbackHandler() == null) {
                this.requests.setCallbackHandler(Thread.currentThread() instanceof HandlerThread ? new Handler() : new Handler(Looper.getMainLooper()));
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public String toString() {
        String str = "{RequestAsyncTask:  connection: " + this.connection + ", requests: " + this.requests + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        …(\"}\")\n        .toString()");
        return str;
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public List<GraphResponse> doInBackground2(Void... params) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            try {
                HttpURLConnection httpURLConnection = this.connection;
                return httpURLConnection == null ? this.requests.executeAndWait() : GraphRequest.Companion.executeConnectionAndWait(httpURLConnection, this.requests);
            } catch (Exception e3) {
                this.exception = e3;
                return null;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    protected void onPostExecute2(List<GraphResponse> result) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(result, "result");
            super.onPostExecute(result);
            Exception exc = this.exception;
            if (exc != null) {
                String str = TAG;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f140150a;
                String str2 = String.format("onPostExecute: exception encountered during request: %s", Arrays.copyOf(new Object[]{exc.getMessage()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(format, *args)");
                Utility.logd(str, str2);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(GraphRequest... requests) {
        this((HttpURLConnection) null, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(requests, requests.length)));
        Intrinsics.checkNotNullParameter(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(Collection<GraphRequest> requests) {
        this((HttpURLConnection) null, new GraphRequestBatch(requests));
        Intrinsics.checkNotNullParameter(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(GraphRequestBatch requests) {
        this((HttpURLConnection) null, requests);
        Intrinsics.checkNotNullParameter(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, GraphRequest... requests) {
        this(httpURLConnection, new GraphRequestBatch((GraphRequest[]) Arrays.copyOf(requests, requests.length)));
        Intrinsics.checkNotNullParameter(requests, "requests");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GraphRequestAsyncTask(HttpURLConnection httpURLConnection, Collection<GraphRequest> requests) {
        this(httpURLConnection, new GraphRequestBatch(requests));
        Intrinsics.checkNotNullParameter(requests, "requests");
    }
}
