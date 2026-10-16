package com.facebook.appevents.gps.topics;

import android.adservices.topics.GetTopicsRequest;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.adservices.topics.TopicsManager;
import android.content.Context;
import android.os.Build;
import android.os.OutcomeReceiver;
import android.util.Log;
import androidx.core.os.a;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class GpsTopicsManager {
    public static final GpsTopicsManager INSTANCE = new GpsTopicsManager();
    private static final boolean RECORD_OBSERVATION = true;
    private static final String TAG;
    private static final Lazy executor$delegate;
    private static final AtomicBoolean isTopicsObservationEnabled;

    static {
        String string = GpsTopicsManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(string, "GpsTopicsManager::class.java.toString()");
        TAG = string;
        executor$delegate = LazyKt.b(new Function0<ExecutorService>() { // from class: com.facebook.appevents.gps.topics.GpsTopicsManager$executor$2
            @Override // kotlin.jvm.functions.Function0
            public final ExecutorService invoke() {
                return Executors.newCachedThreadPool();
            }
        });
        isTopicsObservationEnabled = new AtomicBoolean(false);
    }

    private GpsTopicsManager() {
    }

    public static final /* synthetic */ String access$getTAG$p() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return null;
        }
    }

    public static final /* synthetic */ List access$processObservedTopics(GpsTopicsManager gpsTopicsManager, GetTopicsResponse getTopicsResponse) {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            return gpsTopicsManager.processObservedTopics(getTopicsResponse);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void enableTopicsObservation() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return;
        }
        try {
            isTopicsObservationEnabled.set(true);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
        }
    }

    private final Executor getExecutor() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Object value = executor$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "<get-executor>(...)");
            return (Executor) value;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final CompletableFuture<List<TopicData>> getTopics() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return null;
        }
        try {
            if (!shouldObserveTopics()) {
                CompletableFuture<List<TopicData>> completableFutureCompletedFuture = CompletableFuture.completedFuture(CollectionsKt.emptyList());
                Intrinsics.checkNotNullExpressionValue(completableFutureCompletedFuture, "completedFuture(emptyList())");
                return completableFutureCompletedFuture;
            }
            final CompletableFuture<List<TopicData>> completableFuture = new CompletableFuture<>();
            try {
                Context applicationContext = FacebookSdk.getApplicationContext();
                OutcomeReceiver outcomeReceiverA = a.a(new OutcomeReceiver() { // from class: com.facebook.appevents.gps.topics.GpsTopicsManager$getTopics$callback$1
                    public void onError(Exception error) {
                        Intrinsics.checkNotNullParameter(error, "error");
                        Log.w(GpsTopicsManager.access$getTAG$p(), "GPS_TOPICS_OBSERVATION_FAILURE", error);
                        completableFuture.completeExceptionally(error);
                    }

                    public void onResult(GetTopicsResponse response) {
                        Intrinsics.checkNotNullParameter(response, "response");
                        try {
                            completableFuture.complete(GpsTopicsManager.access$processObservedTopics(GpsTopicsManager.INSTANCE, response));
                        } catch (Throwable th) {
                            Log.w(GpsTopicsManager.access$getTAG$p(), "GPS_TOPICS_PROCESSING_FAILURE", th);
                            completableFuture.completeExceptionally(th);
                        }
                    }
                });
                GetTopicsRequest.Builder builder = new GetTopicsRequest.Builder();
                builder.c(true);
                builder.b(applicationContext.getPackageName());
                TopicsManager topicsManager = (TopicsManager) applicationContext.getSystemService(TopicsManager.class);
                if (topicsManager != null) {
                    topicsManager.b(builder.a(), INSTANCE.getExecutor(), outcomeReceiverA);
                    return completableFuture;
                }
            } catch (Throwable th) {
                Log.w(TAG, "GPS_TOPICS_OBSERVATION_FAILURE", th);
                completableFuture.completeExceptionally(th);
            }
            return completableFuture;
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, GpsTopicsManager.class);
            return null;
        }
    }

    private final List<TopicData> processObservedTopics(GetTopicsResponse getTopicsResponse) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            List listA = getTopicsResponse.a();
            Intrinsics.checkNotNullExpressionValue(listA, "response.topics");
            List<Topic> list = listA;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Topic topic : list) {
                arrayList.add(new TopicData(topic.b(), topic.a(), topic.c()));
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    @JvmStatic
    public static final boolean shouldObserveTopics() {
        if (CrashShieldHandler.isObjectCrashing(GpsTopicsManager.class)) {
            return false;
        }
        try {
            if (isTopicsObservationEnabled.get()) {
                return Build.VERSION.SDK_INT >= 33;
            }
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsTopicsManager.class);
            return false;
        }
    }
}
