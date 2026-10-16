package com.revenuecat.purchases.subscriberattributes;

import android.app.Application;
import androidx.glance.session.ecY.lisODU;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.SubscriberAttributeError;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager;
import com.revenuecat.purchases.subscriberattributes.caching.SubscriberAttributesCache;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class SubscriberAttributesManager {
    private final boolean automaticDeviceIdentifierCollectionEnabled;
    private final SubscriberAttributesPoster backend;
    private final SubscriberAttributesCache deviceCache;
    private final DeviceIdentifiersFetcher deviceIdentifiersFetcher;
    private final ObtainDeviceIdentifiersObservable obtainingDeviceIdentifiersObservable;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class ObtainDeviceIdentifiersObservable extends Observable {
        private final ArrayList<Function0<Unit>> listeners = new ArrayList<>();
        private int numberOfProcesses;

        public ObtainDeviceIdentifiersObservable() {
            addObserver(new Observer() { // from class: com.revenuecat.purchases.subscriberattributes.a
                @Override // java.util.Observer
                public final void update(Observable observable, Object obj) {
                    SubscriberAttributesManager.ObtainDeviceIdentifiersObservable._init_$lambda$2(this.f92316a, observable, obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void _init_$lambda$2(ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable, Observable observable, Object obj) {
            Intrinsics.checkNotNull(observable, "null cannot be cast to non-null type com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.ObtainDeviceIdentifiersObservable");
            if (((ObtainDeviceIdentifiersObservable) observable).numberOfProcesses == 0) {
                synchronized (obtainDeviceIdentifiersObservable) {
                    try {
                        ArrayList<Function0<Unit>> arrayList = obtainDeviceIdentifiersObservable.listeners;
                        int size = arrayList.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Function0<Unit> function0 = arrayList.get(i3);
                            i3++;
                            function0.invoke();
                        }
                        obtainDeviceIdentifiersObservable.listeners.clear();
                        Unit unit = Unit.f139807a;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final synchronized int getNumberOfProcesses() {
            return this.numberOfProcesses;
        }

        public final synchronized void setNumberOfProcesses(int i3) {
            if (this.numberOfProcesses == i3) {
                return;
            }
            this.numberOfProcesses = i3;
            setChanged();
            notifyObservers();
        }

        public final synchronized void waitUntilIdle(final Function0<Unit> completion) {
            try {
                Intrinsics.checkNotNullParameter(completion, "completion");
                if (this.numberOfProcesses == 0) {
                    completion.invoke();
                } else {
                    this.listeners.add(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$ObtainDeviceIdentifiersObservable$waitUntilIdle$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Object invoke() {
                            m668invoke();
                            return Unit.f139807a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                        public final void m668invoke() {
                            completion.invoke();
                        }
                    });
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public SubscriberAttributesManager(SubscriberAttributesCache deviceCache, SubscriberAttributesPoster backend, DeviceIdentifiersFetcher deviceIdentifiersFetcher, boolean z2) {
        Intrinsics.checkNotNullParameter(deviceCache, "deviceCache");
        Intrinsics.checkNotNullParameter(backend, "backend");
        Intrinsics.checkNotNullParameter(deviceIdentifiersFetcher, "deviceIdentifiersFetcher");
        this.deviceCache = deviceCache;
        this.backend = backend;
        this.deviceIdentifiersFetcher = deviceIdentifiersFetcher;
        this.automaticDeviceIdentifierCollectionEnabled = z2;
        this.obtainingDeviceIdentifiersObservable = new ObtainDeviceIdentifiersObservable();
    }

    private final void getDeviceIdentifiers(Application application, final Function1<? super Map<String, String>, Unit> function1) {
        ObtainDeviceIdentifiersObservable obtainDeviceIdentifiersObservable = this.obtainingDeviceIdentifiersObservable;
        obtainDeviceIdentifiersObservable.setNumberOfProcesses(obtainDeviceIdentifiersObservable.getNumberOfProcesses() + 1);
        this.deviceIdentifiersFetcher.getDeviceIdentifiers(application, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.getDeviceIdentifiers.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.f139807a;
            }

            public final void invoke(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                function1.invoke(deviceIdentifiers);
                this.obtainingDeviceIdentifiersObservable.setNumberOfProcesses(r2.getNumberOfProcesses() - 1);
            }
        });
    }

    private final void storeAttributesIfNeeded(Map<String, SubscriberAttribute> map, String str) {
        Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(str);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, SubscriberAttribute> entry : map.entrySet()) {
            String key = entry.getKey();
            SubscriberAttribute value = entry.getValue();
            if (allStoredSubscriberAttributes.containsKey(key)) {
                SubscriberAttribute subscriberAttribute = allStoredSubscriberAttributes.get(key);
                if (!Intrinsics.areEqual(subscriberAttribute != null ? subscriberAttribute.getValue() : null, value.getValue())) {
                }
            }
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        this.deviceCache.setAttributes(str, linkedHashMap);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void synchronizeSubscriberAttributesForAllUsers$default(SubscriberAttributesManager subscriberAttributesManager, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        subscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers(str, function0);
    }

    public final void collectDeviceIdentifiers(final String appUserID, Application applicationContext) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.collectDeviceIdentifiers.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.f139807a;
            }

            public final void invoke(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                SubscriberAttributesManager.this.setAttributes(deviceIdentifiers, appUserID);
            }
        });
    }

    public final synchronized void copyUnsyncedSubscriberAttributes(String originalAppUserId, String newAppUserID) {
        try {
            Intrinsics.checkNotNullParameter(originalAppUserId, "originalAppUserId");
            Intrinsics.checkNotNullParameter(newAppUserID, "newAppUserID");
            Map<String, SubscriberAttribute> unsyncedSubscriberAttributes = this.deviceCache.getUnsyncedSubscriberAttributes(originalAppUserId);
            if (unsyncedSubscriberAttributes.isEmpty()) {
                return;
            }
            LogLevel logLevel = LogLevel.INFO;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str = "[Purchases] - " + logLevel.name();
                String str2 = String.format(AttributionStrings.COPYING_ATTRIBUTES_FROM_TO_USER, Arrays.copyOf(new Object[]{originalAppUserId, newAppUserID}, 2));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                currentLogHandler.i(str, str2);
            }
            this.deviceCache.setAttributes(newAppUserID, unsyncedSubscriberAttributes);
            this.deviceCache.clearAllSubscriberAttributesFromUser(originalAppUserId);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final SubscriberAttributesPoster getBackend() {
        return this.backend;
    }

    public final SubscriberAttributesCache getDeviceCache() {
        return this.deviceCache;
    }

    public final synchronized void getUnsyncedSubscriberAttributes(final String appUserID, final Function1<? super Map<String, SubscriberAttribute>, Unit> completion) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(completion, "completion");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.getUnsyncedSubscriberAttributes.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m669invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m669invoke() {
                completion.invoke(this.getDeviceCache().getUnsyncedSubscriberAttributes(appUserID));
            }
        });
    }

    public final synchronized void markAsSynced(final String appUserID, final Map<String, SubscriberAttribute> attributesToMarkAsSynced, final List<SubscriberAttributeError> attributeErrors) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            Intrinsics.checkNotNullParameter(attributesToMarkAsSynced, "attributesToMarkAsSynced");
            Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
            if (!attributeErrors.isEmpty()) {
                final LogIntent logIntent = LogIntent.RC_ERROR;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$markAsSynced$$inlined$log$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        StringBuilder sb = new StringBuilder();
                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                        sb.append(' ');
                        String str3 = String.format(AttributionStrings.SUBSCRIBER_ATTRIBUTES_ERROR, Arrays.copyOf(new Object[]{attributeErrors}, 1));
                        Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                        sb.append(str3);
                        return sb.toString();
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) function0.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function0.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function0.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) function0.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function0.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) function0.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) function0.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function0.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function0.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function0.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function0.invoke(), null);
                        break;
                }
            }
            if (attributesToMarkAsSynced.isEmpty()) {
                return;
            }
            final LogIntent logIntent2 = LogIntent.INFO;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$markAsSynced$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    StringBuilder sb2 = new StringBuilder();
                    String str3 = String.format(AttributionStrings.MARKING_ATTRIBUTES_SYNCED, Arrays.copyOf(new Object[]{appUserID}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb2.append(str3);
                    sb2.append(CollectionsKt.joinToString$default(attributesToMarkAsSynced.values(), "\n", null, null, 0, null, null, 62, null));
                    sb.append(sb2.toString());
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                case 1:
                    LogLevel logLevel11 = LogLevel.DEBUG;
                    LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        currentLogHandler8.d("[Purchases] - " + logLevel11.name(), (String) function02.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel12 = LogLevel.WARN;
                    LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        currentLogHandler9.w("[Purchases] - " + logLevel12.name(), (String) function02.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel13 = LogLevel.INFO;
                    LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        currentLogHandler10.i("[Purchases] - " + logLevel13.name(), (String) function02.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel14 = LogLevel.DEBUG;
                    LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        currentLogHandler11.d("[Purchases] - " + logLevel14.name(), (String) function02.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel15 = LogLevel.INFO;
                    LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        currentLogHandler12.i("[Purchases] - " + logLevel15.name(), (String) function02.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        currentLogHandler13.d("[Purchases] - " + logLevel16.name(), (String) function02.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel17 = LogLevel.DEBUG;
                    LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        currentLogHandler14.d("[Purchases] - " + logLevel17.name(), (String) function02.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel18 = LogLevel.WARN;
                    LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) function02.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel19 = LogLevel.WARN;
                    LogHandler currentLogHandler16 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                        currentLogHandler16.w("[Purchases] - " + logLevel19.name(), (String) function02.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel20 = LogLevel.WARN;
                    LogHandler currentLogHandler17 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                        currentLogHandler17.w("[Purchases] - " + logLevel20.name(), (String) function02.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function02.invoke(), null);
                    break;
            }
            Map<String, SubscriberAttribute> allStoredSubscriberAttributes = this.deviceCache.getAllStoredSubscriberAttributes(appUserID);
            Map<String, SubscriberAttribute> mutableMap = MapsKt.toMutableMap(allStoredSubscriberAttributes);
            for (Map.Entry<String, SubscriberAttribute> entry : attributesToMarkAsSynced.entrySet()) {
                String key = entry.getKey();
                SubscriberAttribute value = entry.getValue();
                SubscriberAttribute subscriberAttribute = allStoredSubscriberAttributes.get(key);
                if (subscriberAttribute != null) {
                    if (subscriberAttribute.isSynced()) {
                        subscriberAttribute = null;
                    }
                    if (subscriberAttribute != null) {
                        if (!Intrinsics.areEqual(subscriberAttribute.getValue(), value.getValue())) {
                            subscriberAttribute = null;
                        }
                        if (subscriberAttribute != null) {
                            mutableMap.put(key, SubscriberAttribute.copy$default(value, null, null, null, null, true, 15, null));
                        }
                    }
                }
            }
            this.deviceCache.setAttributes(appUserID, mutableMap);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setAppsFlyerConversionData(String appUserID, Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (map == null) {
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String stringValueForPrimitive = MapExtensionsKt.getStringValueForPrimitive(map, "media_source");
        if (stringValueForPrimitive != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE.getBackendKey(), stringValueForPrimitive);
        } else {
            String stringValueForPrimitive2 = MapExtensionsKt.getStringValueForPrimitive(map, "af_status");
            if (stringValueForPrimitive2 != null && StringsKt.F(stringValueForPrimitive2, "Organic", true)) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE.getBackendKey(), "Organic");
            }
        }
        String stringValueForPrimitive3 = MapExtensionsKt.getStringValueForPrimitive(map, "campaign");
        if (stringValueForPrimitive3 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE.getBackendKey(), stringValueForPrimitive3);
        }
        String stringValueForPrimitive4 = MapExtensionsKt.getStringValueForPrimitive(map, "adgroup");
        if (stringValueForPrimitive4 == null) {
            stringValueForPrimitive4 = MapExtensionsKt.getStringValueForPrimitive(map, "adset");
        }
        if (stringValueForPrimitive4 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE.getBackendKey(), stringValueForPrimitive4);
        }
        String stringValueForPrimitive5 = MapExtensionsKt.getStringValueForPrimitive(map, "af_ad");
        if (stringValueForPrimitive5 == null) {
            stringValueForPrimitive5 = MapExtensionsKt.getStringValueForPrimitive(map, "ad_id");
        }
        if (stringValueForPrimitive5 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE.getBackendKey(), stringValueForPrimitive5);
        }
        String stringValueForPrimitive6 = MapExtensionsKt.getStringValueForPrimitive(map, "af_keywords");
        if (stringValueForPrimitive6 == null) {
            stringValueForPrimitive6 = MapExtensionsKt.getStringValueForPrimitive(map, "keyword");
        }
        if (stringValueForPrimitive6 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE.getBackendKey(), stringValueForPrimitive6);
        }
        String stringValueForPrimitive7 = MapExtensionsKt.getStringValueForPrimitive(map, "creative");
        if (stringValueForPrimitive7 == null) {
            stringValueForPrimitive7 = MapExtensionsKt.getStringValueForPrimitive(map, "af_creative");
        }
        if (stringValueForPrimitive7 != null) {
            linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Creative.INSTANCE.getBackendKey(), stringValueForPrimitive7);
        }
        if (linkedHashMap.isEmpty()) {
            return;
        }
        setAttributes(linkedHashMap, appUserID);
    }

    public final synchronized void setAttribute(SubscriberAttributeKey key, String str, String appUserID) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        setAttributes(MapsKt.mapOf(TuplesKt.a(key.getBackendKey(), str)), appUserID);
    }

    public final synchronized void setAttributes(Map<String, String> attributesToSet, String appUserID) {
        try {
            Intrinsics.checkNotNullParameter(attributesToSet, "attributesToSet");
            Intrinsics.checkNotNullParameter(appUserID, "appUserID");
            ArrayList arrayList = new ArrayList(attributesToSet.size());
            for (Map.Entry<String, String> entry : attributesToSet.entrySet()) {
                String key = entry.getKey();
                arrayList.add(TuplesKt.a(key, new SubscriberAttribute(key, entry.getValue(), (DateProvider) null, (Date) null, false, 28, (DefaultConstructorMarker) null)));
            }
            storeAttributesIfNeeded(MapsKt.toMap(arrayList), appUserID);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setAttributionID(final SubscriberAttributeKey.AttributionIds attributionKey, final String str, final String appUserID, Application applicationContext) {
        Intrinsics.checkNotNullParameter(attributionKey, "attributionKey");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        final Function1<Map<String, ? extends String>, Unit> function1 = new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$setAttributionID$setAttributes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, String>) obj);
                return Unit.f139807a;
            }

            public final void invoke(Map<String, String> deviceIdentifiers) {
                Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                this.setAttributes(MapsKt.plus(MapsKt.mapOf(TuplesKt.a(attributionKey.getBackendKey(), str)), deviceIdentifiers), appUserID);
            }
        };
        if (this.automaticDeviceIdentifierCollectionEnabled) {
            getDeviceIdentifiers(applicationContext, new Function1<Map<String, ? extends String>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.setAttributionID.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((Map<String, String>) obj);
                    return Unit.f139807a;
                }

                public final void invoke(Map<String, String> deviceIdentifiers) {
                    Intrinsics.checkNotNullParameter(deviceIdentifiers, "deviceIdentifiers");
                    function1.invoke(deviceIdentifiers);
                }
            });
        } else {
            function1.invoke(MapsKt.emptyMap());
        }
    }

    public final void synchronizeSubscriberAttributesForAllUsers(final String currentAppUserID, final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(currentAppUserID, "currentAppUserID");
        this.obtainingDeviceIdentifiersObservable.waitUntilIdle(new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager.synchronizeSubscriberAttributesForAllUsers.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m670invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m670invoke() {
                LogHandler currentLogHandler;
                String str;
                String str2;
                Map<String, Map<String, SubscriberAttribute>> unsyncedSubscriberAttributes = SubscriberAttributesManager.this.getDeviceCache().getUnsyncedSubscriberAttributes();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, Map<String, SubscriberAttribute>> entry : unsyncedSubscriberAttributes.entrySet()) {
                    if (!StringsKt.p0(entry.getKey())) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    final int size = linkedHashMap.size();
                    Ref.IntRef intRef = new Ref.IntRef();
                    final SubscriberAttributesManager subscriberAttributesManager = SubscriberAttributesManager.this;
                    final Ref.IntRef intRef2 = intRef;
                    final String str3 = currentAppUserID;
                    final Function0<Unit> function02 = function0;
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        final String str4 = (String) entry2.getKey();
                        final Map map = (Map) entry2.getValue();
                        SubscriberAttributesPoster backend = subscriberAttributesManager.getBackend();
                        Map<String, Map<String, Object>> backendMap = BackendHelpersKt.toBackendMap(map);
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Object invoke() {
                                m671invoke();
                                return Unit.f139807a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                            public final void m671invoke() {
                                LogHandler currentLogHandler2;
                                String str5;
                                String str6;
                                subscriberAttributesManager.markAsSynced(str4, map, CollectionsKt.emptyList());
                                final LogIntent logIntent = LogIntent.RC_SUCCESS;
                                final String str7 = str4;
                                Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$1$invoke$$inlined$log$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                        sb.append(' ');
                                        String str8 = String.format(AttributionStrings.ATTRIBUTES_SYNC_SUCCESS, Arrays.copyOf(new Object[]{str7}, 1));
                                        Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                                        sb.append(str8);
                                        return sb.toString();
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                            str5 = "[Purchases] - " + logLevel.name();
                                            str6 = (String) function04.invoke();
                                            currentLogHandler2.d(str5, str6);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel2 = LogLevel.WARN;
                                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel3 = LogLevel.INFO;
                                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel4 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                            str5 = "[Purchases] - " + logLevel4.name();
                                            str6 = (String) function04.invoke();
                                            currentLogHandler2.d(str5, str6);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel5 = LogLevel.INFO;
                                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel6 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                            str5 = "[Purchases] - " + logLevel6.name();
                                            str6 = (String) function04.invoke();
                                            currentLogHandler2.d(str5, str6);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel7 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                            str5 = "[Purchases] - " + logLevel7.name();
                                            str6 = (String) function04.invoke();
                                            currentLogHandler2.d(str5, str6);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel8 = LogLevel.WARN;
                                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                            currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel9 = LogLevel.WARN;
                                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                            currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel10 = LogLevel.WARN;
                                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                            currentLogHandler8.w("[Purchases] - " + logLevel10.name(), (String) function04.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                                        break;
                                }
                                if (!Intrinsics.areEqual(str3, str4)) {
                                    subscriberAttributesManager.getDeviceCache().clearSubscriberAttributesIfSyncedForSubscriber(str4);
                                }
                                Ref.IntRef intRef3 = intRef2;
                                int i3 = intRef3.f140142a + 1;
                                intRef3.f140142a = i3;
                                Function0<Unit> function05 = function02;
                                if (function05 == null || i3 != size) {
                                    return;
                                }
                                function05.invoke();
                            }
                        };
                        String str5 = str3;
                        final Ref.IntRef intRef3 = intRef2;
                        final Function0<Unit> function04 = function02;
                        Function3<PurchasesError, Boolean, List<? extends SubscriberAttributeError>, Unit> function3 = new Function3<PurchasesError, Boolean, List<? extends SubscriberAttributeError>, Unit>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue(), (List<SubscriberAttributeError>) obj3);
                                return Unit.f139807a;
                            }

                            public final void invoke(final PurchasesError error, boolean z2, List<SubscriberAttributeError> attributeErrors) {
                                LogHandler currentLogHandler2;
                                String str6;
                                String str7;
                                Intrinsics.checkNotNullParameter(error, "error");
                                Intrinsics.checkNotNullParameter(attributeErrors, "attributeErrors");
                                if (z2) {
                                    subscriberAttributesManager.markAsSynced(str4, map, attributeErrors);
                                }
                                final LogIntent logIntent = LogIntent.RC_ERROR;
                                final String str8 = str4;
                                Function0<String> function05 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$2$2$invoke$$inlined$log$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final String invoke() {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null));
                                        sb.append(' ');
                                        String str9 = String.format(AttributionStrings.ATTRIBUTES_SYNC_ERROR, Arrays.copyOf(new Object[]{str8, error}, 2));
                                        Intrinsics.checkNotNullExpressionValue(str9, "format(...)");
                                        sb.append(str9);
                                        return sb.toString();
                                    }
                                };
                                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                                    case 1:
                                        LogLevel logLevel = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                            str6 = "[Purchases] - " + logLevel.name();
                                            str7 = (String) function05.invoke();
                                            currentLogHandler2.d(str6, str7);
                                        }
                                        break;
                                    case 2:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                                        break;
                                    case 3:
                                        LogLevel logLevel2 = LogLevel.WARN;
                                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                            currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) function05.invoke());
                                        }
                                        break;
                                    case 4:
                                        LogLevel logLevel3 = LogLevel.INFO;
                                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                            currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) function05.invoke());
                                        }
                                        break;
                                    case 5:
                                        LogLevel logLevel4 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                            str6 = "[Purchases] - " + logLevel4.name();
                                            str7 = (String) function05.invoke();
                                            currentLogHandler2.d(str6, str7);
                                        }
                                        break;
                                    case 6:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                                        break;
                                    case 7:
                                        LogLevel logLevel5 = LogLevel.INFO;
                                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                            currentLogHandler5.i("[Purchases] - " + logLevel5.name(), (String) function05.invoke());
                                        }
                                        break;
                                    case 8:
                                        LogLevel logLevel6 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                            str6 = "[Purchases] - " + logLevel6.name();
                                            str7 = (String) function05.invoke();
                                            currentLogHandler2.d(str6, str7);
                                        }
                                        break;
                                    case 9:
                                        LogLevel logLevel7 = LogLevel.DEBUG;
                                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                            str6 = "[Purchases] - " + logLevel7.name();
                                            str7 = (String) function05.invoke();
                                            currentLogHandler2.d(str6, str7);
                                        }
                                        break;
                                    case 10:
                                        LogLevel logLevel8 = LogLevel.WARN;
                                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                            currentLogHandler6.w("[Purchases] - " + logLevel8.name(), (String) function05.invoke());
                                        }
                                        break;
                                    case 11:
                                        LogLevel logLevel9 = LogLevel.WARN;
                                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                            currentLogHandler7.w("[Purchases] - " + logLevel9.name(), (String) function05.invoke());
                                        }
                                        break;
                                    case 12:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                                        break;
                                    case 13:
                                        LogLevel logLevel10 = LogLevel.WARN;
                                        LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                            currentLogHandler8.w("[Purchases] - " + logLevel10.name(), (String) function05.invoke());
                                        }
                                        break;
                                    case 14:
                                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                                        break;
                                }
                                Ref.IntRef intRef4 = intRef3;
                                int i3 = intRef4.f140142a + 1;
                                intRef4.f140142a = i3;
                                Function0<Unit> function06 = function04;
                                if (function06 == null || i3 != size) {
                                    return;
                                }
                                function06.invoke();
                            }
                        };
                        function02 = function04;
                        intRef2 = intRef3;
                        backend.postSubscriberAttributes(backendMap, str4, function03, function3);
                        str3 = str5;
                    }
                    return;
                }
                final LogIntent logIntent = LogIntent.DEBUG;
                Function0<String> function05 = new Function0<String>() { // from class: com.revenuecat.purchases.subscriberattributes.SubscriberAttributesManager$synchronizeSubscriberAttributesForAllUsers$1$invoke$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AttributionStrings.NO_SUBSCRIBER_ATTRIBUTES_TO_SYNCHRONIZE;
                    }
                };
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) function05.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            currentLogHandler2.w("[Purchases] - " + logLevel2.name(), (String) function05.invoke());
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            currentLogHandler3.i("[Purchases] - " + logLevel3.name(), (String) function05.invoke());
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) function05.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            currentLogHandler4.i("[Purchases] - " + logLevel5.name(), (String) function05.invoke());
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) function05.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) function05.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            currentLogHandler5.w("[Purchases] - " + logLevel8.name(), (String) function05.invoke());
                        }
                        break;
                    case 11:
                        LogLevel logLevel9 = LogLevel.WARN;
                        LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            currentLogHandler6.w("[Purchases] - " + logLevel9.name(), (String) function05.invoke());
                        }
                        break;
                    case 12:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        break;
                    case 13:
                        LogLevel logLevel10 = LogLevel.WARN;
                        LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            currentLogHandler7.w("[Purchases] - " + logLevel10.name(), (String) function05.invoke());
                        }
                        break;
                    case 14:
                        LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                        break;
                }
                Function0<Unit> function06 = function0;
                if (function06 != null) {
                    function06.invoke();
                }
            }
        });
    }

    public final void setAppstackAttributionParams(String appUserID, Map<String, String> data, Application applicationContext) {
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = lisODU.XHuP;
        String str2 = data.get(str);
        if (str2 != null) {
            if (StringsKt.p0(str2)) {
                str2 = null;
            }
            if (str2 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.MediaSource.INSTANCE.getBackendKey(), str2);
                linkedHashMap.put(str, str2);
            }
        }
        String str3 = data.get("appstack_campaign");
        if (str3 != null) {
            if (StringsKt.p0(str3)) {
                str3 = null;
            }
            if (str3 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Campaign.INSTANCE.getBackendKey(), str3);
                linkedHashMap.put("appstack_campaign", str3);
            }
        }
        String str4 = data.get("appstack_adset");
        if (str4 != null) {
            if (StringsKt.p0(str4)) {
                str4 = null;
            }
            if (str4 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.AdGroup.INSTANCE.getBackendKey(), str4);
                linkedHashMap.put("appstack_adset", str4);
            }
        }
        String str5 = data.get("appstack_ad");
        if (str5 != null) {
            if (StringsKt.p0(str5)) {
                str5 = null;
            }
            if (str5 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Ad.INSTANCE.getBackendKey(), str5);
                linkedHashMap.put("appstack_ad", str5);
            }
        }
        String str6 = data.get("appstack_keywords");
        if (str6 != null) {
            if (StringsKt.p0(str6)) {
                str6 = null;
            }
            if (str6 != null) {
                linkedHashMap.put(SubscriberAttributeKey.CampaignParameters.Keyword.INSTANCE.getBackendKey(), str6);
                linkedHashMap.put("appstack_keywords", str6);
            }
        }
        for (String str7 : CollectionsKt.listOf((Object[]) new String[]{"fbclid", "gclid", "wbraid", "gbraid", "ttclid"})) {
            String str8 = data.get(str7);
            if (str8 != null) {
                if (StringsKt.p0(str8)) {
                    str8 = null;
                }
                if (str8 != null) {
                    linkedHashMap.put(str7, str8);
                }
            }
        }
        if (!linkedHashMap.isEmpty()) {
            setAttributes(linkedHashMap, appUserID);
        }
        String str9 = data.get("appstack_id");
        if (str9 != null) {
            String str10 = StringsKt.p0(str9) ? null : str9;
            if (str10 != null) {
                setAttributionID(SubscriberAttributeKey.AttributionIds.Appstack.INSTANCE, str10, appUserID, applicationContext);
            }
        }
    }
}
