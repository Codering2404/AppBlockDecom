package com.google.firebase.remoteconfig.internal.rollouts;

import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.rollouts.RolloutsStateSubscriptionsHandler;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsState;
import com.google.firebase.remoteconfig.interop.rollouts.RolloutsStateSubscriber;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class RolloutsStateSubscriptionsHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConfigCacheClient f89834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RolloutsStateFactory f89835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Executor f89836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set f89837d = Collections.newSetFromMap(new ConcurrentHashMap());

    public RolloutsStateSubscriptionsHandler(ConfigCacheClient configCacheClient, RolloutsStateFactory rolloutsStateFactory, Executor executor) {
        this.f89834a = configCacheClient;
        this.f89835b = rolloutsStateFactory;
        this.f89836c = executor;
    }

    public static /* synthetic */ void a(RolloutsStateSubscriptionsHandler rolloutsStateSubscriptionsHandler, Task task, final RolloutsStateSubscriber rolloutsStateSubscriber, ConfigContainer configContainer) {
        rolloutsStateSubscriptionsHandler.getClass();
        try {
            ConfigContainer configContainer2 = (ConfigContainer) task.getResult();
            if (configContainer2 != null) {
                final RolloutsState rolloutsStateB = rolloutsStateSubscriptionsHandler.f89835b.b(configContainer2);
                rolloutsStateSubscriptionsHandler.f89836c.execute(new Runnable() { // from class: y.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        rolloutsStateSubscriber.a(rolloutsStateB);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e3) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscriber. Continuing to listen for changes.", e3);
        }
    }

    public void d(ConfigContainer configContainer) {
        try {
            final RolloutsState rolloutsStateB = this.f89835b.b(configContainer);
            for (final RolloutsStateSubscriber rolloutsStateSubscriber : this.f89837d) {
                this.f89836c.execute(new Runnable() { // from class: y.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        rolloutsStateSubscriber.a(rolloutsStateB);
                    }
                });
            }
        } catch (FirebaseRemoteConfigException e3) {
            Log.w("FirebaseRemoteConfig", "Exception publishing RolloutsState to subscribers. Continuing to listen for changes.", e3);
        }
    }

    public void e(final RolloutsStateSubscriber rolloutsStateSubscriber) {
        this.f89837d.add(rolloutsStateSubscriber);
        final Task taskE = this.f89834a.e();
        taskE.addOnSuccessListener(this.f89836c, new OnSuccessListener() { // from class: y.b
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                RolloutsStateSubscriptionsHandler.a(this.f147580a, taskE, rolloutsStateSubscriber, (ConfigContainer) obj);
            }
        });
    }
}
