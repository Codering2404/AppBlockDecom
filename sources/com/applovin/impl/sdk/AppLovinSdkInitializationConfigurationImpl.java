package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import cz.mobilesoft.coreblock.storage.room.dao.cI.KrzujOtzIk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinSdkInitializationConfigurationImpl extends AppLovinSdkInitializationConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f63135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f63136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f63137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MaxSegmentCollection f63138d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f63139e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List f63140f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f63141g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class BuilderImpl implements AppLovinSdkInitializationConfiguration.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f63142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f63143b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f63144c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private MaxSegmentCollection f63145d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List f63146e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private List f63147f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f63148g;

        public BuilderImpl(String str, Context context) {
            List list = Collections.EMPTY_LIST;
            this.f63146e = list;
            this.f63147f = list;
            this.f63148g = true;
            this.f63142a = str;
            n.e("AppLovinSdkInitializationConfiguration", "Initializing with key: " + str);
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public AppLovinSdkInitializationConfiguration build() {
            return new AppLovinSdkInitializationConfigurationImpl(this);
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public List<String> getAdUnitIds() {
            return this.f63147f;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public String getMediationProvider() {
            return this.f63143b;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public String getPluginVersion() {
            return this.f63144c;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public String getSdkKey() {
            return this.f63142a;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public MaxSegmentCollection getSegmentCollection() {
            return this.f63145d;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public List<String> getTestDeviceAdvertisingIds() {
            return this.f63146e;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public boolean isExceptionHandlerEnabled() {
            return this.f63148g;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public AppLovinSdkInitializationConfiguration.Builder setAdUnitIds(List<String> list) {
            n.e("AppLovinSdkInitializationConfiguration", "setAdUnitIds(adUnitIds=" + list + ")");
            if (list == null) {
                return this;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (StringUtils.isValidString(str) && str.length() > 0) {
                    if (str.length() == 16) {
                        arrayList.add(str);
                    } else {
                        n.h("AppLovinSdkInitializationConfiguration", "Unable to set initialization ad unit id (" + str + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                    }
                }
            }
            this.f63147f = arrayList;
            return this;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public AppLovinSdkInitializationConfiguration.Builder setExceptionHandlerEnabled(boolean z2) {
            n.e("AppLovinSdkInitializationConfiguration", "setExceptionHandlerEnabled(exceptionHandlerEnabled=" + z2 + ")");
            this.f63148g = z2;
            return this;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public AppLovinSdkInitializationConfiguration.Builder setPluginVersion(String str) {
            n.e("AppLovinSdkInitializationConfiguration", "setPluginVersion(pluginVersion=" + str + ")");
            this.f63144c = str;
            return this;
        }

        public AppLovinSdkInitializationConfiguration.Builder setSdkKey(String str) {
            this.f63142a = str;
            return this;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public AppLovinSdkInitializationConfiguration.Builder setSegmentCollection(MaxSegmentCollection maxSegmentCollection) {
            n.e("AppLovinSdkInitializationConfiguration", "setSegmentCollection(segmentCollection=" + maxSegmentCollection + ")");
            this.f63145d = maxSegmentCollection;
            return this;
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public AppLovinSdkInitializationConfiguration.Builder setTestDeviceAdvertisingIds(List<String> list) {
            n.e("AppLovinSdkInitializationConfiguration", "setTestDeviceAdvertisingIds(testDeviceAdvertisingIds=" + list + ")");
            if (list == null) {
                return this;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                if (str == null || str.length() != 36) {
                    n.h("AppLovinSdkInitializationConfiguration", "Unable to set test device advertising id (" + str + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                } else {
                    arrayList.add(str);
                }
            }
            this.f63146e = arrayList;
            return this;
        }

        public String toString() {
            return "AppLovinSdkInitializationConfiguration.Builder{ sdkKey=" + this.f63142a + "mediationProvider=" + this.f63143b + "pluginVersion=" + this.f63144c + "testDeviceAdvertisingIdentifiers=" + this.f63146e + "adUnitIdentifiers=" + this.f63147f + "isExceptionHandlerEnabled=" + this.f63148g + "segmentCollection=" + this.f63145d + "}";
        }

        @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration.Builder
        public AppLovinSdkInitializationConfiguration.Builder setMediationProvider(String str) {
            n.e("AppLovinSdkInitializationConfiguration", "setMediationProvider(mediationProvider=" + str + ")");
            if (str == null || (!str.isEmpty() && str.length() <= 64 && StringUtils.isAlphaNumeric(str))) {
                this.f63143b = str;
                return this;
            }
            n.h("AppLovinSdkInitializationConfiguration", "Mediation provider set to invalid value: " + str + KrzujOtzIk.EOM);
            return this;
        }
    }

    @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration
    public List<String> getAdUnitIds() {
        return this.f63140f;
    }

    @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration
    public String getMediationProvider() {
        return this.f63136b;
    }

    @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration
    public String getPluginVersion() {
        return this.f63137c;
    }

    @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration
    public String getSdkKey() {
        return this.f63135a;
    }

    @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration
    public MaxSegmentCollection getSegmentCollection() {
        return this.f63138d;
    }

    @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration
    public List<String> getTestDeviceAdvertisingIds() {
        return this.f63139e;
    }

    @Override // com.applovin.sdk.AppLovinSdkInitializationConfiguration
    public boolean isExceptionHandlerEnabled() {
        return this.f63141g;
    }

    public String toString() {
        return "AppLovinSdkInitializationConfiguration{ sdkKey=" + this.f63135a + ", mediationProvider=" + this.f63136b + ", pluginVersion=" + this.f63137c + ", testDeviceAdvertisingIds=" + this.f63139e + ", adUnitIdentifiers=" + this.f63140f + ", isExceptionHandlerEnabled=" + this.f63141g + ", segmentCollection=" + this.f63138d + "}";
    }

    private AppLovinSdkInitializationConfigurationImpl(BuilderImpl builderImpl) {
        this.f63135a = builderImpl.f63142a;
        this.f63136b = builderImpl.f63143b;
        this.f63137c = builderImpl.f63144c;
        this.f63138d = builderImpl.f63145d;
        this.f63139e = builderImpl.f63146e;
        this.f63140f = builderImpl.f63147f;
        this.f63141g = builderImpl.f63148g;
    }
}
