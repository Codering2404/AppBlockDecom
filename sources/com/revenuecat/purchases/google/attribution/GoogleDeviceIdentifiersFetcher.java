package com.revenuecat.purchases.google.attribution;

import android.app.Application;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import com.revenuecat.purchases.strings.AttributionStrings;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class GoogleDeviceIdentifiersFetcher implements DeviceIdentifiersFetcher {
    private final Dispatcher dispatcher;
    private final String noPermissionAdvertisingIdValue;

    public GoogleDeviceIdentifiersFetcher(Dispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        this.noPermissionAdvertisingIdValue = "00000000-0000-0000-0000-000000000000";
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final String getAdvertisingID(Application application) throws Throwable {
        LogHandler currentLogHandler;
        String str;
        String str2;
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(application);
            if (!advertisingIdInfo.isLimitAdTrackingEnabled()) {
                if (!Intrinsics.areEqual(advertisingIdInfo.getId(), this.noPermissionAdvertisingIdValue)) {
                    return advertisingIdInfo.getId();
                }
                final LogIntent logIntent = LogIntent.WARNING;
                Function0<String> function0 = new Function0<String>() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final String invoke() {
                        return CollectionsKt.joinToString$default(logIntent.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AttributionStrings.GOOGLE_PLAY_ADVERTISING_ID_NOT_AVAILABLE;
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
        } catch (GooglePlayServicesNotAvailableException e3) {
            final LogIntent logIntent2 = LogIntent.GOOGLE_ERROR;
            Function0<String> function02 = new Function0<String>() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent2.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_NOT_INSTALLED_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e3.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
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
        } catch (GooglePlayServicesRepairableException e4) {
            final LogIntent logIntent3 = LogIntent.GOOGLE_ERROR;
            Function0<String> function03 = new Function0<String>() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent3.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.GOOGLE_PLAY_SERVICES_REPAIRABLE_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e4.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                case 1:
                    LogLevel logLevel21 = LogLevel.DEBUG;
                    LogHandler currentLogHandler18 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                        currentLogHandler18.d("[Purchases] - " + logLevel21.name(), (String) function03.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel22 = LogLevel.WARN;
                    LogHandler currentLogHandler19 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                        currentLogHandler19.w("[Purchases] - " + logLevel22.name(), (String) function03.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel23 = LogLevel.INFO;
                    LogHandler currentLogHandler20 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                        currentLogHandler20.i("[Purchases] - " + logLevel23.name(), (String) function03.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel24 = LogLevel.DEBUG;
                    LogHandler currentLogHandler21 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                        currentLogHandler21.d("[Purchases] - " + logLevel24.name(), (String) function03.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel25 = LogLevel.INFO;
                    LogHandler currentLogHandler22 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                        currentLogHandler22.i("[Purchases] - " + logLevel25.name(), (String) function03.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel26 = LogLevel.DEBUG;
                    LogHandler currentLogHandler23 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                        currentLogHandler23.d("[Purchases] - " + logLevel26.name(), (String) function03.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel27 = LogLevel.DEBUG;
                    LogHandler currentLogHandler24 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                        currentLogHandler24.d("[Purchases] - " + logLevel27.name(), (String) function03.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel28 = LogLevel.WARN;
                    LogHandler currentLogHandler25 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel28) <= 0) {
                        currentLogHandler25.w("[Purchases] - " + logLevel28.name(), (String) function03.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel29 = LogLevel.WARN;
                    LogHandler currentLogHandler26 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel29) <= 0) {
                        currentLogHandler26.w("[Purchases] - " + logLevel29.name(), (String) function03.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel30 = LogLevel.WARN;
                    LogHandler currentLogHandler27 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel30) <= 0) {
                        currentLogHandler27.w("[Purchases] - " + logLevel30.name(), (String) function03.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function03.invoke(), null);
                    break;
            }
        } catch (IOException e5) {
            final LogIntent logIntent4 = LogIntent.GOOGLE_ERROR;
            Function0<String> function04 = new Function0<String>() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent4.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.IO_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e5.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent4.ordinal()]) {
                case 1:
                    LogLevel logLevel31 = LogLevel.DEBUG;
                    LogHandler currentLogHandler28 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel31) <= 0) {
                        currentLogHandler28.d("[Purchases] - " + logLevel31.name(), (String) function04.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel32 = LogLevel.WARN;
                    LogHandler currentLogHandler29 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel32) <= 0) {
                        currentLogHandler29.w("[Purchases] - " + logLevel32.name(), (String) function04.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel33 = LogLevel.INFO;
                    LogHandler currentLogHandler30 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel33) <= 0) {
                        currentLogHandler30.i("[Purchases] - " + logLevel33.name(), (String) function04.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel34 = LogLevel.DEBUG;
                    LogHandler currentLogHandler31 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel34) <= 0) {
                        currentLogHandler31.d("[Purchases] - " + logLevel34.name(), (String) function04.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel35 = LogLevel.INFO;
                    LogHandler currentLogHandler32 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel35) <= 0) {
                        currentLogHandler32.i("[Purchases] - " + logLevel35.name(), (String) function04.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel36 = LogLevel.DEBUG;
                    LogHandler currentLogHandler33 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel36) <= 0) {
                        currentLogHandler33.d("[Purchases] - " + logLevel36.name(), (String) function04.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel37 = LogLevel.DEBUG;
                    LogHandler currentLogHandler34 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel37) <= 0) {
                        currentLogHandler34.d("[Purchases] - " + logLevel37.name(), (String) function04.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel38 = LogLevel.WARN;
                    LogHandler currentLogHandler35 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel38) <= 0) {
                        currentLogHandler35.w("[Purchases] - " + logLevel38.name(), (String) function04.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel39 = LogLevel.WARN;
                    LogHandler currentLogHandler36 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel39) <= 0) {
                        currentLogHandler36.w("[Purchases] - " + logLevel39.name(), (String) function04.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel40 = LogLevel.WARN;
                    LogHandler currentLogHandler37 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel40) <= 0) {
                        currentLogHandler37.w("[Purchases] - " + logLevel40.name(), (String) function04.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function04.invoke(), null);
                    break;
            }
        } catch (NoSuchMethodError unused) {
            final LogIntent logIntent5 = LogIntent.GOOGLE_ERROR;
            Function0<String> function05 = new Function0<String>() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$7
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return CollectionsKt.joinToString$default(logIntent5.getEmojiList(), "", null, null, 0, null, null, 62, null) + ' ' + AttributionStrings.NO_SUCH_METHOD_WHEN_FETCHING_ADVERTISING_IDENTIFIER;
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent5.ordinal()]) {
                case 1:
                    LogLevel logLevel41 = LogLevel.DEBUG;
                    LogHandler currentLogHandler38 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel41) <= 0) {
                        currentLogHandler38.d("[Purchases] - " + logLevel41.name(), (String) function05.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel42 = LogLevel.WARN;
                    LogHandler currentLogHandler39 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel42) <= 0) {
                        currentLogHandler39.w("[Purchases] - " + logLevel42.name(), (String) function05.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel43 = LogLevel.INFO;
                    LogHandler currentLogHandler40 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel43) <= 0) {
                        currentLogHandler40.i("[Purchases] - " + logLevel43.name(), (String) function05.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel44 = LogLevel.DEBUG;
                    LogHandler currentLogHandler41 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel44) <= 0) {
                        currentLogHandler41.d("[Purchases] - " + logLevel44.name(), (String) function05.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel45 = LogLevel.INFO;
                    LogHandler currentLogHandler42 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel45) <= 0) {
                        currentLogHandler42.i("[Purchases] - " + logLevel45.name(), (String) function05.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel46 = LogLevel.DEBUG;
                    LogHandler currentLogHandler43 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel46) <= 0) {
                        currentLogHandler43.d("[Purchases] - " + logLevel46.name(), (String) function05.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel47 = LogLevel.DEBUG;
                    LogHandler currentLogHandler44 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel47) <= 0) {
                        currentLogHandler44.d("[Purchases] - " + logLevel47.name(), (String) function05.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel48 = LogLevel.WARN;
                    LogHandler currentLogHandler45 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel48) <= 0) {
                        currentLogHandler45.w("[Purchases] - " + logLevel48.name(), (String) function05.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel49 = LogLevel.WARN;
                    LogHandler currentLogHandler46 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel49) <= 0) {
                        currentLogHandler46.w("[Purchases] - " + logLevel49.name(), (String) function05.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel50 = LogLevel.WARN;
                    LogHandler currentLogHandler47 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel50) <= 0) {
                        currentLogHandler47.w("[Purchases] - " + logLevel50.name(), (String) function05.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function05.invoke(), null);
                    break;
            }
        } catch (NullPointerException e6) {
            final LogIntent logIntent6 = LogIntent.GOOGLE_ERROR;
            Function0<String> function06 = new Function0<String>() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent6.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.NULL_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e6.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent6.ordinal()]) {
                case 1:
                    LogLevel logLevel51 = LogLevel.DEBUG;
                    LogHandler currentLogHandler48 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel51) <= 0) {
                        currentLogHandler48.d("[Purchases] - " + logLevel51.name(), (String) function06.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function06.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel52 = LogLevel.WARN;
                    LogHandler currentLogHandler49 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel52) <= 0) {
                        currentLogHandler49.w("[Purchases] - " + logLevel52.name(), (String) function06.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel53 = LogLevel.INFO;
                    LogHandler currentLogHandler50 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel53) <= 0) {
                        currentLogHandler50.i("[Purchases] - " + logLevel53.name(), (String) function06.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel54 = LogLevel.DEBUG;
                    LogHandler currentLogHandler51 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel54) <= 0) {
                        currentLogHandler51.d("[Purchases] - " + logLevel54.name(), (String) function06.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function06.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel55 = LogLevel.INFO;
                    LogHandler currentLogHandler52 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel55) <= 0) {
                        currentLogHandler52.i("[Purchases] - " + logLevel55.name(), (String) function06.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel56 = LogLevel.DEBUG;
                    LogHandler currentLogHandler53 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel56) <= 0) {
                        currentLogHandler53.d("[Purchases] - " + logLevel56.name(), (String) function06.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel57 = LogLevel.DEBUG;
                    LogHandler currentLogHandler54 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel57) <= 0) {
                        currentLogHandler54.d("[Purchases] - " + logLevel57.name(), (String) function06.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel58 = LogLevel.WARN;
                    LogHandler currentLogHandler55 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel58) <= 0) {
                        currentLogHandler55.w("[Purchases] - " + logLevel58.name(), (String) function06.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel59 = LogLevel.WARN;
                    LogHandler currentLogHandler56 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel59) <= 0) {
                        currentLogHandler56.w("[Purchases] - " + logLevel59.name(), (String) function06.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function06.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel60 = LogLevel.WARN;
                    LogHandler currentLogHandler57 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel60) <= 0) {
                        currentLogHandler57.w("[Purchases] - " + logLevel60.name(), (String) function06.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function06.invoke(), null);
                    break;
            }
        } catch (TimeoutException e7) {
            final LogIntent logIntent7 = LogIntent.GOOGLE_ERROR;
            Function0<String> function07 = new Function0<String>() { // from class: com.revenuecat.purchases.google.attribution.GoogleDeviceIdentifiersFetcher$getAdvertisingID$$inlined$log$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    StringBuilder sb = new StringBuilder();
                    sb.append(CollectionsKt.joinToString$default(logIntent7.getEmojiList(), "", null, null, 0, null, null, 62, null));
                    sb.append(' ');
                    String str3 = String.format(AttributionStrings.TIMEOUT_EXCEPTION_WHEN_FETCHING_ADVERTISING_IDENTIFIER, Arrays.copyOf(new Object[]{e7.getLocalizedMessage()}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    sb.append(str3);
                    return sb.toString();
                }
            };
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent7.ordinal()]) {
                case 1:
                    LogLevel logLevel61 = LogLevel.DEBUG;
                    LogHandler currentLogHandler58 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel61) <= 0) {
                        currentLogHandler58.d("[Purchases] - " + logLevel61.name(), (String) function07.invoke());
                    }
                    break;
                case 2:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function07.invoke(), null);
                    break;
                case 3:
                    LogLevel logLevel62 = LogLevel.WARN;
                    LogHandler currentLogHandler59 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel62) <= 0) {
                        currentLogHandler59.w("[Purchases] - " + logLevel62.name(), (String) function07.invoke());
                    }
                    break;
                case 4:
                    LogLevel logLevel63 = LogLevel.INFO;
                    LogHandler currentLogHandler60 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel63) <= 0) {
                        currentLogHandler60.i("[Purchases] - " + logLevel63.name(), (String) function07.invoke());
                    }
                    break;
                case 5:
                    LogLevel logLevel64 = LogLevel.DEBUG;
                    LogHandler currentLogHandler61 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel64) <= 0) {
                        currentLogHandler61.d("[Purchases] - " + logLevel64.name(), (String) function07.invoke());
                    }
                    break;
                case 6:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function07.invoke(), null);
                    break;
                case 7:
                    LogLevel logLevel65 = LogLevel.INFO;
                    LogHandler currentLogHandler62 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel65) <= 0) {
                        currentLogHandler62.i("[Purchases] - " + logLevel65.name(), (String) function07.invoke());
                    }
                    break;
                case 8:
                    LogLevel logLevel66 = LogLevel.DEBUG;
                    LogHandler currentLogHandler63 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel66) <= 0) {
                        currentLogHandler63.d("[Purchases] - " + logLevel66.name(), (String) function07.invoke());
                    }
                    break;
                case 9:
                    LogLevel logLevel67 = LogLevel.DEBUG;
                    LogHandler currentLogHandler64 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel67) <= 0) {
                        currentLogHandler64.d("[Purchases] - " + logLevel67.name(), (String) function07.invoke());
                    }
                    break;
                case 10:
                    LogLevel logLevel68 = LogLevel.WARN;
                    LogHandler currentLogHandler65 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel68) <= 0) {
                        currentLogHandler65.w("[Purchases] - " + logLevel68.name(), (String) function07.invoke());
                    }
                    break;
                case 11:
                    LogLevel logLevel69 = LogLevel.WARN;
                    LogHandler currentLogHandler66 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel69) <= 0) {
                        currentLogHandler66.w("[Purchases] - " + logLevel69.name(), (String) function07.invoke());
                    }
                    break;
                case 12:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function07.invoke(), null);
                    break;
                case 13:
                    LogLevel logLevel70 = LogLevel.WARN;
                    LogHandler currentLogHandler67 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel70) <= 0) {
                        currentLogHandler67.w("[Purchases] - " + logLevel70.name(), (String) function07.invoke());
                    }
                    break;
                case 14:
                    LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) function07.invoke(), null);
                    break;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getDeviceIdentifiers$lambda$0(GoogleDeviceIdentifiersFetcher googleDeviceIdentifiersFetcher, Application application, Function1 function1) throws Throwable {
        function1.invoke(MapExtensionsKt.filterNotNullValues(MapsKt.mapOf(TuplesKt.a(SubscriberAttributeKey.DeviceIdentifiers.GPSAdID.INSTANCE.getBackendKey(), googleDeviceIdentifiersFetcher.getAdvertisingID(application)), TuplesKt.a(SubscriberAttributeKey.DeviceIdentifiers.IP.INSTANCE.getBackendKey(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE), TuplesKt.a(SubscriberAttributeKey.DeviceIdentifiers.DeviceVersion.INSTANCE.getBackendKey(), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE))));
    }

    @Override // com.revenuecat.purchases.common.subscriberattributes.DeviceIdentifiersFetcher
    public void getDeviceIdentifiers(final Application applicationContext, final Function1<? super Map<String, String>, Unit> completion) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(completion, "completion");
        Dispatcher.enqueue$default(this.dispatcher, new Runnable() { // from class: com.revenuecat.purchases.google.attribution.a
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                GoogleDeviceIdentifiersFetcher.getDeviceIdentifiers$lambda$0(this.f92269a, applicationContext, completion);
            }
        }, null, 2, null);
    }
}
