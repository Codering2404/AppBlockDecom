package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.util.Base64OutputStream;
import androidx.core.os.UserManagerCompat;
import com.facebook.stetho.common.Utf8Charset;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Lazy;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class DefaultHeartBeatController implements HeartBeatController, HeartBeatInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Provider f89187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f89188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Provider f89189c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set f89190d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Executor f89191e;

    private DefaultHeartBeatController(final Context context, final String str, Set set, Provider provider, Executor executor) {
        this(new Lazy(new Provider() { // from class: com.google.firebase.heartbeatinfo.d
            @Override // com.google.firebase.inject.Provider
            public final Object get() {
                return DefaultHeartBeatController.d(context, str);
            }
        }), set, executor, provider, context);
    }

    public static /* synthetic */ String c(DefaultHeartBeatController defaultHeartBeatController) {
        String string;
        synchronized (defaultHeartBeatController) {
            try {
                HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage) defaultHeartBeatController.f89187a.get();
                List listG = heartBeatInfoStorage.g();
                heartBeatInfoStorage.f();
                JSONArray jSONArray = new JSONArray();
                for (int i3 = 0; i3 < listG.size(); i3++) {
                    HeartBeatResult heartBeatResult = (HeartBeatResult) listG.get(i3);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("agent", heartBeatResult.c());
                    jSONObject.put("dates", new JSONArray((Collection) heartBeatResult.b()));
                    jSONArray.put(jSONObject);
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("heartbeats", jSONArray);
                jSONObject2.put("version", "2");
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                    try {
                        gZIPOutputStream.write(jSONObject2.toString().getBytes(Utf8Charset.NAME));
                        gZIPOutputStream.close();
                        base64OutputStream.close();
                        string = byteArrayOutputStream.toString(Utf8Charset.NAME);
                    } finally {
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return string;
    }

    public static /* synthetic */ HeartBeatInfoStorage d(Context context, String str) {
        return new HeartBeatInfoStorage(context, str);
    }

    public static /* synthetic */ DefaultHeartBeatController e(Qualified qualified, ComponentContainer componentContainer) {
        return new DefaultHeartBeatController((Context) componentContainer.a(Context.class), ((FirebaseApp) componentContainer.a(FirebaseApp.class)).q(), componentContainer.f(HeartBeatConsumer.class), componentContainer.g(UserAgentPublisher.class), (Executor) componentContainer.e(qualified));
    }

    public static /* synthetic */ Void f(DefaultHeartBeatController defaultHeartBeatController) {
        synchronized (defaultHeartBeatController) {
            ((HeartBeatInfoStorage) defaultHeartBeatController.f89187a.get()).o(System.currentTimeMillis(), ((UserAgentPublisher) defaultHeartBeatController.f89189c.get()).a());
        }
        return null;
    }

    public static Component g() {
        final Qualified qualifiedA = Qualified.a(Background.class, Executor.class);
        return Component.f(DefaultHeartBeatController.class, HeartBeatController.class, HeartBeatInfo.class).b(Dependency.l(Context.class)).b(Dependency.l(FirebaseApp.class)).b(Dependency.o(HeartBeatConsumer.class)).b(Dependency.n(UserAgentPublisher.class)).b(Dependency.k(qualifiedA)).f(new ComponentFactory() { // from class: com.google.firebase.heartbeatinfo.c
            @Override // com.google.firebase.components.ComponentFactory
            public final Object a(ComponentContainer componentContainer) {
                return DefaultHeartBeatController.e(qualifiedA, componentContainer);
            }
        }).d();
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatController
    public Task a() {
        return !UserManagerCompat.a(this.f89188b) ? Tasks.forResult("") : Tasks.call(this.f89191e, new Callable() { // from class: com.google.firebase.heartbeatinfo.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultHeartBeatController.c(this.f89202a);
            }
        });
    }

    @Override // com.google.firebase.heartbeatinfo.HeartBeatInfo
    public synchronized HeartBeatInfo.HeartBeat b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HeartBeatInfoStorage heartBeatInfoStorage = (HeartBeatInfoStorage) this.f89187a.get();
        if (!heartBeatInfoStorage.m(jCurrentTimeMillis)) {
            return HeartBeatInfo.HeartBeat.NONE;
        }
        heartBeatInfoStorage.k();
        return HeartBeatInfo.HeartBeat.GLOBAL;
    }

    public Task h() {
        return this.f89190d.size() <= 0 ? Tasks.forResult(null) : !UserManagerCompat.a(this.f89188b) ? Tasks.forResult(null) : Tasks.call(this.f89191e, new Callable() { // from class: com.google.firebase.heartbeatinfo.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return DefaultHeartBeatController.f(this.f89203a);
            }
        });
    }

    DefaultHeartBeatController(Provider provider, Set set, Executor executor, Provider provider2, Context context) {
        this.f89187a = provider;
        this.f89190d = set;
        this.f89191e = executor;
        this.f89189c = provider2;
        this.f89188b = context;
    }
}
