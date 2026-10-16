package com.google.firebase.crashlytics.internal.settings;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.DeliveryMechanism;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.common.SystemCurrentTimeProvider;
import com.google.firebase.crashlytics.internal.concurrency.CrashlyticsWorkers;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class SettingsController implements SettingsProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f89068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SettingsRequest f89069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SettingsJsonParser f89070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CurrentTimeProvider f89071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CachedSettingsIo f89072e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SettingsSpiCall f89073f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final DataCollectionArbiter f89074g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicReference f89075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final AtomicReference f89076i;

    /* JADX INFO: renamed from: com.google.firebase.crashlytics.internal.settings.SettingsController$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements SuccessContinuation<Void, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ CrashlyticsWorkers f89077a;

        AnonymousClass1(CrashlyticsWorkers crashlyticsWorkers) {
            this.f89077a = crashlyticsWorkers;
        }

        @Override // com.google.android.gms.tasks.SuccessContinuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Task then(Void r5) throws Throwable {
            JSONObject jSONObject = (JSONObject) this.f89077a.f88494d.c().submit(new Callable() { // from class: com.google.firebase.crashlytics.internal.settings.a
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    SettingsController.AnonymousClass1 anonymousClass1 = this.f89089a;
                    return SettingsController.this.f89073f.a(SettingsController.this.f89069b, true);
                }
            }).get();
            if (jSONObject != null) {
                Settings settingsB = SettingsController.this.f89070c.b(jSONObject);
                SettingsController.this.f89072e.c(settingsB.f89053c, jSONObject);
                SettingsController.this.q(jSONObject, "Loaded settings: ");
                SettingsController settingsController = SettingsController.this;
                settingsController.r(settingsController.f89069b.f89085f);
                SettingsController.this.f89075h.set(settingsB);
                ((TaskCompletionSource) SettingsController.this.f89076i.get()).trySetResult(settingsB);
            }
            return Tasks.forResult(null);
        }
    }

    SettingsController(Context context, SettingsRequest settingsRequest, CurrentTimeProvider currentTimeProvider, SettingsJsonParser settingsJsonParser, CachedSettingsIo cachedSettingsIo, SettingsSpiCall settingsSpiCall, DataCollectionArbiter dataCollectionArbiter) {
        AtomicReference atomicReference = new AtomicReference();
        this.f89075h = atomicReference;
        this.f89076i = new AtomicReference(new TaskCompletionSource());
        this.f89068a = context;
        this.f89069b = settingsRequest;
        this.f89071d = currentTimeProvider;
        this.f89070c = settingsJsonParser;
        this.f89072e = cachedSettingsIo;
        this.f89073f = settingsSpiCall;
        this.f89074g = dataCollectionArbiter;
        atomicReference.set(DefaultSettingsJsonTransform.b(currentTimeProvider));
    }

    public static SettingsController l(Context context, String str, IdManager idManager, HttpRequestFactory httpRequestFactory, String str2, String str3, FileStore fileStore, DataCollectionArbiter dataCollectionArbiter) {
        String strG = idManager.g();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        return new SettingsController(context, new SettingsRequest(str, idManager.h(), idManager.i(), idManager.j(), idManager, CommonUtils.h(CommonUtils.m(context), str, str3, str2), str3, str2, DeliveryMechanism.b(strG).c()), systemCurrentTimeProvider, new SettingsJsonParser(systemCurrentTimeProvider), new CachedSettingsIo(fileStore), new DefaultSettingsSpiCall(String.format(Locale.US, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str), httpRequestFactory), dataCollectionArbiter);
    }

    private Settings m(SettingsCacheBehavior settingsCacheBehavior) throws Throwable {
        Settings settings = null;
        try {
            if (!SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingsCacheBehavior)) {
                JSONObject jSONObjectB = this.f89072e.b();
                if (jSONObjectB != null) {
                    Settings settingsB = this.f89070c.b(jSONObjectB);
                    if (settingsB == null) {
                        Logger.f().e("Failed to parse cached settings data.", null);
                        return null;
                    }
                    q(jSONObjectB, "Loaded cached settings: ");
                    long currentTimeMillis = this.f89071d.getCurrentTimeMillis();
                    if (!SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingsCacheBehavior) && settingsB.a(currentTimeMillis)) {
                        Logger.f().i("Cached settings have expired.");
                        return null;
                    }
                    try {
                        Logger.f().i("Returning cached settings.");
                        return settingsB;
                    } catch (Exception e3) {
                        e = e3;
                        settings = settingsB;
                        Logger.f().e("Failed to get cached settings", e);
                        return settings;
                    }
                }
                Logger.f().b("No cached settings data found.");
            }
            return null;
        } catch (Exception e4) {
            e = e4;
        }
    }

    private String n() {
        return CommonUtils.q(this.f89068a).getString("existing_instance_identifier", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(JSONObject jSONObject, String str) {
        Logger.f().b(str + jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r(String str) {
        SharedPreferences.Editor editorEdit = CommonUtils.q(this.f89068a).edit();
        editorEdit.putString("existing_instance_identifier", str);
        editorEdit.apply();
        return true;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Task a() {
        return ((TaskCompletionSource) this.f89076i.get()).getTask();
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsProvider
    public Settings b() {
        return (Settings) this.f89075h.get();
    }

    boolean k() {
        return !n().equals(this.f89069b.f89085f);
    }

    public Task o(CrashlyticsWorkers crashlyticsWorkers) {
        return p(SettingsCacheBehavior.USE_CACHE, crashlyticsWorkers);
    }

    public Task p(SettingsCacheBehavior settingsCacheBehavior, CrashlyticsWorkers crashlyticsWorkers) throws Throwable {
        Settings settingsM;
        if (!k() && (settingsM = m(settingsCacheBehavior)) != null) {
            this.f89075h.set(settingsM);
            ((TaskCompletionSource) this.f89076i.get()).trySetResult(settingsM);
            return Tasks.forResult(null);
        }
        Settings settingsM2 = m(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        if (settingsM2 != null) {
            this.f89075h.set(settingsM2);
            ((TaskCompletionSource) this.f89076i.get()).trySetResult(settingsM2);
        }
        return this.f89074g.k().onSuccessTask(crashlyticsWorkers.f88491a, new AnonymousClass1(crashlyticsWorkers));
    }
}
