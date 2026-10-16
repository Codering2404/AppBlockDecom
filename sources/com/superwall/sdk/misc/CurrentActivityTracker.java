package com.superwall.sdk.misc;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class CurrentActivityTracker implements Application.ActivityLifecycleCallbacks, ActivityProvider {
    private final MutableStateFlow<Activity> activityState = StateFlowKt.a(null);
    private WeakReference<Activity> currentActivity;

    /* JADX INFO: renamed from: awaitActivity-VtjQ1oo, reason: not valid java name */
    public final Object m1274awaitActivityVtjQ1oo(long j3, Continuation<? super Activity> continuation) {
        Activity activity;
        WeakReference<Activity> weakReference = this.currentActivity;
        return (weakReference == null || (activity = weakReference.get()) == null) ? TimeoutKt.f(j3, new CurrentActivityTracker$awaitActivity$2(this, null), continuation) : activity;
    }

    @Override // com.superwall.sdk.misc.ActivityProvider
    public Activity getCurrentActivity() {
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! getCurrentActivity: " + this.currentActivity, (Map) null, (Throwable) null, 24, (Object) null);
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! onActivityCreated: " + activity, (Map) null, (Throwable) null, 24, (Object) null);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! onActivityDestroyed: " + activity, (Map) null, (Throwable) null, 24, (Object) null);
        WeakReference<Activity> weakReference = this.currentActivity;
        if ((weakReference != null ? weakReference.get() : null) == activity) {
            this.currentActivity = null;
            this.activityState.setValue(null);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! onActivityResumed: " + activity, (Map) null, (Throwable) null, 24, (Object) null);
        this.currentActivity = new WeakReference<>(activity);
        this.activityState.setValue(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.all, "!! onActivityStarted: " + activity, (Map) null, (Throwable) null, 24, (Object) null);
        this.currentActivity = new WeakReference<>(activity);
        this.activityState.setValue(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        WeakReference<Activity> weakReference = this.currentActivity;
        if ((weakReference != null ? weakReference.get() : null) == activity) {
            this.currentActivity = null;
            this.activityState.setValue(null);
        }
    }
}
