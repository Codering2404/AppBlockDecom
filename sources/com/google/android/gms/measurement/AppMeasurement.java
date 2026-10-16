package com.google.android.gms.measurement;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdd;
import com.google.android.gms.measurement.internal.zzic;
import com.google.android.gms.measurement.internal.zzjh;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjq;
import com.google.android.gms.measurement.internal.zzlk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public class AppMeasurement {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile AppMeasurement f73357b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzc f73358a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ConditionalUserProperty {
        public boolean mActive;
        public String mAppId;
        public long mCreationTimestamp;
        public String mExpiredEventName;
        public Bundle mExpiredEventParams;
        public String mName;
        public String mOrigin;
        public long mTimeToLive;
        public String mTimedOutEventName;
        public Bundle mTimedOutEventParams;
        public String mTriggerEventName;
        public long mTriggerTimeout;
        public String mTriggeredEventName;
        public Bundle mTriggeredEventParams;
        public long mTriggeredTimestamp;
        public Object mValue;

        ConditionalUserProperty(Bundle bundle) {
            Preconditions.m(bundle);
            this.mAppId = (String) zzjh.b(bundle, "app_id", String.class, null);
            this.mOrigin = (String) zzjh.b(bundle, "origin", String.class, null);
            this.mName = (String) zzjh.b(bundle, "name", String.class, null);
            this.mValue = zzjh.b(bundle, "value", Object.class, null);
            this.mTriggerEventName = (String) zzjh.b(bundle, "trigger_event_name", String.class, null);
            this.mTriggerTimeout = ((Long) zzjh.b(bundle, "trigger_timeout", Long.class, 0L)).longValue();
            this.mTimedOutEventName = (String) zzjh.b(bundle, "timed_out_event_name", String.class, null);
            this.mTimedOutEventParams = (Bundle) zzjh.b(bundle, "timed_out_event_params", Bundle.class, null);
            this.mTriggeredEventName = (String) zzjh.b(bundle, "triggered_event_name", String.class, null);
            this.mTriggeredEventParams = (Bundle) zzjh.b(bundle, "triggered_event_params", Bundle.class, null);
            this.mTimeToLive = ((Long) zzjh.b(bundle, "time_to_live", Long.class, 0L)).longValue();
            this.mExpiredEventName = (String) zzjh.b(bundle, "expired_event_name", String.class, null);
            this.mExpiredEventParams = (Bundle) zzjh.b(bundle, "expired_event_params", Bundle.class, null);
            this.mActive = ((Boolean) zzjh.b(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
            this.mCreationTimestamp = ((Long) zzjh.b(bundle, "creation_timestamp", Long.class, 0L)).longValue();
            this.mTriggeredTimestamp = ((Long) zzjh.b(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EventInterceptor extends zzjp {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnEventListener extends zzjq {
    }

    public AppMeasurement(zzic zzicVar) {
        this.f73358a = new zza(zzicVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static AppMeasurement getInstance(Context context) {
        if (f73357b == null) {
            synchronized (AppMeasurement.class) {
                if (f73357b == null) {
                    zzlk zzlkVar = (zzlk) FirebaseAnalytics.class.getDeclaredMethod("getScionFrontendApiImplementation", Context.class, Bundle.class).invoke(null, context, null);
                    if (zzlkVar != null) {
                        f73357b = new AppMeasurement(zzlkVar);
                    } else {
                        f73357b = new AppMeasurement(zzic.O(context, new zzdd(0L, 0L, true, null, null), null));
                    }
                }
            }
        }
        return f73357b;
    }

    public void beginAdUnitExposure(String str) {
        this.f73358a.zzm(str);
    }

    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        this.f73358a.c(str, str2, bundle);
    }

    public void endAdUnitExposure(String str) {
        this.f73358a.zzn(str);
    }

    public long generateEventId() {
        return this.f73358a.zzl();
    }

    public String getAppInstanceId() {
        return this.f73358a.zzj();
    }

    public List<ConditionalUserProperty> getConditionalUserProperties(String str, String str2) {
        List listD = this.f73358a.d(str, str2);
        ArrayList arrayList = new ArrayList(listD == null ? 0 : listD.size());
        Iterator it = listD.iterator();
        while (it.hasNext()) {
            arrayList.add(new ConditionalUserProperty((Bundle) it.next()));
        }
        return arrayList;
    }

    public String getCurrentScreenClass() {
        return this.f73358a.zzi();
    }

    public String getCurrentScreenName() {
        return this.f73358a.zzh();
    }

    public String getGmpAppId() {
        return this.f73358a.zzk();
    }

    public int getMaxUserProperties(String str) {
        return this.f73358a.zzr(str);
    }

    protected Map<String, Object> getUserProperties(String str, String str2, boolean z2) {
        return this.f73358a.b(str, str2, z2);
    }

    public void logEventInternal(String str, String str2, Bundle bundle) {
        this.f73358a.a(str, str2, bundle);
    }

    public void setConditionalUserProperty(ConditionalUserProperty conditionalUserProperty) {
        Preconditions.m(conditionalUserProperty);
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.mAppId;
        if (str != null) {
            bundle.putString("app_id", str);
        }
        String str2 = conditionalUserProperty.mOrigin;
        if (str2 != null) {
            bundle.putString("origin", str2);
        }
        String str3 = conditionalUserProperty.mName;
        if (str3 != null) {
            bundle.putString("name", str3);
        }
        Object obj = conditionalUserProperty.mValue;
        if (obj != null) {
            zzjh.a(bundle, obj);
        }
        String str4 = conditionalUserProperty.mTriggerEventName;
        if (str4 != null) {
            bundle.putString("trigger_event_name", str4);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.mTriggerTimeout);
        String str5 = conditionalUserProperty.mTimedOutEventName;
        if (str5 != null) {
            bundle.putString("timed_out_event_name", str5);
        }
        Bundle bundle2 = conditionalUserProperty.mTimedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str6 = conditionalUserProperty.mTriggeredEventName;
        if (str6 != null) {
            bundle.putString("triggered_event_name", str6);
        }
        Bundle bundle3 = conditionalUserProperty.mTriggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.mTimeToLive);
        String str7 = conditionalUserProperty.mExpiredEventName;
        if (str7 != null) {
            bundle.putString("expired_event_name", str7);
        }
        Bundle bundle4 = conditionalUserProperty.mExpiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        zzc zzcVar = this.f73358a;
        bundle.putLong("creation_timestamp", conditionalUserProperty.mCreationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.mActive);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.mTriggeredTimestamp);
        zzcVar.zzo(bundle);
    }

    public AppMeasurement(zzlk zzlkVar) {
        this.f73358a = new zzb(zzlkVar);
    }
}
