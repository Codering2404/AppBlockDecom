package com.superwall.sdk.network.device;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.core.content.ContextCompat;
import androidx.datastore.preferences.core.SfRj.rnFwbPAQmQTnL;
import androidx.legacy.content.Werj.QgXempTBEfV;
import com.facebook.ads.AdError;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.ServerProtocol;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import com.superwall.sdk.BuildConfig;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.DefaultClassifierDataFactory;
import com.superwall.sdk.analytics.DeviceClassifier;
import com.superwall.sdk.analytics.Tier;
import com.superwall.sdk.dependencies.ActiveEntitlementsFactory;
import com.superwall.sdk.dependencies.CustomerInfoFactory;
import com.superwall.sdk.dependencies.ExperimentalPropertiesFactory;
import com.superwall.sdk.dependencies.IdentityInfoFactory;
import com.superwall.sdk.dependencies.IdentityManagerFactory;
import com.superwall.sdk.dependencies.LocaleIdentifierFactory;
import com.superwall.sdk.dependencies.OptionsFactory;
import com.superwall.sdk.dependencies.StoreTransactionFactory;
import com.superwall.sdk.dependencies.StorefrontCountryFactory;
import com.superwall.sdk.identity.PublicIdentityKt;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.models.enrichment.Enrichment;
import com.superwall.sdk.models.entitlements.Entitlement;
import com.superwall.sdk.models.entitlements.SubscriptionStatus;
import com.superwall.sdk.models.internal.DeviceVendorId;
import com.superwall.sdk.models.internal.VendorId;
import com.superwall.sdk.network.JsonFactory;
import com.superwall.sdk.network.SuperwallAPI;
import com.superwall.sdk.network.device.Capability;
import com.superwall.sdk.storage.LastPaywallView;
import com.superwall.sdk.storage.LatestEnrichment;
import com.superwall.sdk.storage.LocalStorage;
import com.superwall.sdk.storage.ReviewCount;
import com.superwall.sdk.storage.ReviewData;
import com.superwall.sdk.storage.TotalPaywallViews;
import com.superwall.sdk.storage.core_data.CoreDataManager;
import com.superwall.sdk.utilities.DateUtils;
import com.superwall.sdk.utilities.DateUtilsKt;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinVersion;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonKt;
import org.threeten.bp.Duration;
import org.threeten.bp.Instant;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class DeviceHelper {
    private final Locale _locale;
    private final Lazy appBuildString$delegate;
    private final PackageInfo appInfo;
    private final Date appInstallDate;
    private final Lazy appVersion$delegate;
    private final Lazy appVersionPadded$delegate;
    private final List<Capability> capabilities;
    private final Lazy capabilitiesConfig$delegate;
    private final DeviceClassifier classifier;
    private final ConnectivityManager connectivityManager;
    private final Context context;
    private final Lazy deviceId$delegate;
    private final Lazy deviceTier$delegate;
    private final Factory factory;
    private InterfaceStyle interfaceStyleOverride;
    private final Json json;
    private final Lazy kotlinVersion$delegate;
    private final MutableStateFlow<Enrichment> lastEnrichment;
    private final SuperwallAPI network;
    private String platformWrapper;
    private String platformWrapperVersion;
    private final Lazy powerManager$delegate;
    private final Lazy sdkVersionPadded$delegate;
    private final LocalStorage storage;
    private final AtomicReference<CachedTemplate> templateCache;
    private final Lazy vendorId$delegate;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class CachedTemplate {
        private final Map<String, Object> base;
        private final String fingerprint;

        public CachedTemplate(String fingerprint, Map<String, ? extends Object> base) {
            Intrinsics.checkNotNullParameter(fingerprint, "fingerprint");
            Intrinsics.checkNotNullParameter(base, "base");
            this.fingerprint = fingerprint;
            this.base = base;
        }

        public final Map<String, Object> getBase() {
            return this.base;
        }

        public final String getFingerprint() {
            return this.fingerprint;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory extends IdentityInfoFactory, LocaleIdentifierFactory, JsonFactory, StoreTransactionFactory, IdentityManagerFactory, ExperimentalPropertiesFactory, OptionsFactory, CustomerInfoFactory, ActiveEntitlementsFactory, StorefrontCountryFactory {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class DefaultImpls {
            public static Json json(Factory factory) {
                return JsonFactory.DefaultImpls.json(factory);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class VolatileTemplateFields {
        private final int daysSinceInstall;
        private final Integer daysSinceLastPaywallView;
        private final String localDate;
        private final String localDateTime;
        private final String localTime;
        private final int minutesSinceInstall;
        private final Integer minutesSinceLastPaywallView;
        private final String utcDate;
        private final String utcDateTime;
        private final String utcTime;

        public VolatileTemplateFields(String utcDate, String localDate, String utcTime, String localTime, String utcDateTime, String localDateTime, int i3, int i4, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(utcDate, "utcDate");
            Intrinsics.checkNotNullParameter(localDate, "localDate");
            Intrinsics.checkNotNullParameter(utcTime, "utcTime");
            Intrinsics.checkNotNullParameter(localTime, "localTime");
            Intrinsics.checkNotNullParameter(utcDateTime, "utcDateTime");
            Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
            this.utcDate = utcDate;
            this.localDate = localDate;
            this.utcTime = utcTime;
            this.localTime = localTime;
            this.utcDateTime = utcDateTime;
            this.localDateTime = localDateTime;
            this.daysSinceInstall = i3;
            this.minutesSinceInstall = i4;
            this.daysSinceLastPaywallView = num;
            this.minutesSinceLastPaywallView = num2;
        }

        public static /* synthetic */ VolatileTemplateFields copy$default(VolatileTemplateFields volatileTemplateFields, String str, String str2, String str3, String str4, String str5, String str6, int i3, int i4, Integer num, Integer num2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                str = volatileTemplateFields.utcDate;
            }
            if ((i5 & 2) != 0) {
                str2 = volatileTemplateFields.localDate;
            }
            if ((i5 & 4) != 0) {
                str3 = volatileTemplateFields.utcTime;
            }
            if ((i5 & 8) != 0) {
                str4 = volatileTemplateFields.localTime;
            }
            if ((i5 & 16) != 0) {
                str5 = volatileTemplateFields.utcDateTime;
            }
            if ((i5 & 32) != 0) {
                str6 = volatileTemplateFields.localDateTime;
            }
            if ((i5 & 64) != 0) {
                i3 = volatileTemplateFields.daysSinceInstall;
            }
            if ((i5 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0) {
                i4 = volatileTemplateFields.minutesSinceInstall;
            }
            if ((i5 & Function.MAX_NARGS) != 0) {
                num = volatileTemplateFields.daysSinceLastPaywallView;
            }
            if ((i5 & 512) != 0) {
                num2 = volatileTemplateFields.minutesSinceLastPaywallView;
            }
            Integer num3 = num;
            Integer num4 = num2;
            int i6 = i3;
            int i7 = i4;
            String str7 = str5;
            String str8 = str6;
            return volatileTemplateFields.copy(str, str2, str3, str4, str7, str8, i6, i7, num3, num4);
        }

        public final Map<String, Object> asOverlay() {
            return MapsKt.mapOf(TuplesKt.a("utcDate", this.utcDate), TuplesKt.a("localDate", this.localDate), TuplesKt.a("utcTime", this.utcTime), TuplesKt.a("localTime", this.localTime), TuplesKt.a("utcDateTime", this.utcDateTime), TuplesKt.a("localDateTime", this.localDateTime), TuplesKt.a("daysSinceInstall", Double.valueOf(this.daysSinceInstall)), TuplesKt.a("minutesSinceInstall", Double.valueOf(this.minutesSinceInstall)), TuplesKt.a("daysSinceLastPaywallView", this.daysSinceLastPaywallView != null ? Double.valueOf(r0.intValue()) : null), TuplesKt.a("minutesSinceLastPaywallView", this.minutesSinceLastPaywallView != null ? Double.valueOf(r0.intValue()) : null));
        }

        public final String component1() {
            return this.utcDate;
        }

        public final Integer component10() {
            return this.minutesSinceLastPaywallView;
        }

        public final String component2() {
            return this.localDate;
        }

        public final String component3() {
            return this.utcTime;
        }

        public final String component4() {
            return this.localTime;
        }

        public final String component5() {
            return this.utcDateTime;
        }

        public final String component6() {
            return this.localDateTime;
        }

        public final int component7() {
            return this.daysSinceInstall;
        }

        public final int component8() {
            return this.minutesSinceInstall;
        }

        public final Integer component9() {
            return this.daysSinceLastPaywallView;
        }

        public final VolatileTemplateFields copy(String utcDate, String localDate, String utcTime, String localTime, String utcDateTime, String localDateTime, int i3, int i4, Integer num, Integer num2) {
            Intrinsics.checkNotNullParameter(utcDate, "utcDate");
            Intrinsics.checkNotNullParameter(localDate, "localDate");
            Intrinsics.checkNotNullParameter(utcTime, "utcTime");
            Intrinsics.checkNotNullParameter(localTime, "localTime");
            Intrinsics.checkNotNullParameter(utcDateTime, "utcDateTime");
            Intrinsics.checkNotNullParameter(localDateTime, "localDateTime");
            return new VolatileTemplateFields(utcDate, localDate, utcTime, localTime, utcDateTime, localDateTime, i3, i4, num, num2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof VolatileTemplateFields)) {
                return false;
            }
            VolatileTemplateFields volatileTemplateFields = (VolatileTemplateFields) obj;
            return Intrinsics.areEqual(this.utcDate, volatileTemplateFields.utcDate) && Intrinsics.areEqual(this.localDate, volatileTemplateFields.localDate) && Intrinsics.areEqual(this.utcTime, volatileTemplateFields.utcTime) && Intrinsics.areEqual(this.localTime, volatileTemplateFields.localTime) && Intrinsics.areEqual(this.utcDateTime, volatileTemplateFields.utcDateTime) && Intrinsics.areEqual(this.localDateTime, volatileTemplateFields.localDateTime) && this.daysSinceInstall == volatileTemplateFields.daysSinceInstall && this.minutesSinceInstall == volatileTemplateFields.minutesSinceInstall && Intrinsics.areEqual(this.daysSinceLastPaywallView, volatileTemplateFields.daysSinceLastPaywallView) && Intrinsics.areEqual(this.minutesSinceLastPaywallView, volatileTemplateFields.minutesSinceLastPaywallView);
        }

        public final int getDaysSinceInstall() {
            return this.daysSinceInstall;
        }

        public final Integer getDaysSinceLastPaywallView() {
            return this.daysSinceLastPaywallView;
        }

        public final String getLocalDate() {
            return this.localDate;
        }

        public final String getLocalDateTime() {
            return this.localDateTime;
        }

        public final String getLocalTime() {
            return this.localTime;
        }

        public final int getMinutesSinceInstall() {
            return this.minutesSinceInstall;
        }

        public final Integer getMinutesSinceLastPaywallView() {
            return this.minutesSinceLastPaywallView;
        }

        public final String getUtcDate() {
            return this.utcDate;
        }

        public final String getUtcDateTime() {
            return this.utcDateTime;
        }

        public final String getUtcTime() {
            return this.utcTime;
        }

        public int hashCode() {
            int iHashCode = ((((((((((((((this.utcDate.hashCode() * 31) + this.localDate.hashCode()) * 31) + this.utcTime.hashCode()) * 31) + this.localTime.hashCode()) * 31) + this.utcDateTime.hashCode()) * 31) + this.localDateTime.hashCode()) * 31) + Integer.hashCode(this.daysSinceInstall)) * 31) + Integer.hashCode(this.minutesSinceInstall)) * 31;
            Integer num = this.daysSinceLastPaywallView;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this.minutesSinceLastPaywallView;
            return iHashCode2 + (num2 != null ? num2.hashCode() : 0);
        }

        public String toString() {
            return "VolatileTemplateFields(utcDate=" + this.utcDate + ", localDate=" + this.localDate + ", utcTime=" + this.utcTime + ", localTime=" + this.localTime + ", utcDateTime=" + this.utcDateTime + ", localDateTime=" + this.localDateTime + ", daysSinceInstall=" + this.daysSinceInstall + ", minutesSinceInstall=" + this.minutesSinceInstall + ", daysSinceLastPaywallView=" + this.daysSinceLastPaywallView + ", minutesSinceLastPaywallView=" + this.minutesSinceLastPaywallView + ")";
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$buildDeviceTemplate$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper", f = "DeviceHelper.kt", l = {644}, m = "buildDeviceTemplate")
    static final class AnonymousClass1 extends ContinuationImpl {
        float F$0;
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        int I$4;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$14;
        Object L$15;
        Object L$16;
        Object L$17;
        Object L$18;
        Object L$19;
        Object L$2;
        Object L$20;
        Object L$21;
        Object L$22;
        Object L$23;
        Object L$24;
        Object L$25;
        Object L$26;
        Object L$27;
        Object L$28;
        Object L$29;
        Object L$3;
        Object L$30;
        Object L$31;
        Object L$32;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceHelper.this.buildDeviceTemplate(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$getComputedDevicePropertiesSinceEvent$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper", f = "DeviceHelper.kt", l = {513}, m = "getComputedDevicePropertiesSinceEvent")
    static final class C28251 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C28251(Continuation<? super C28251> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceHelper.this.getComputedDevicePropertiesSinceEvent(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$getDeviceAttributes$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper", f = "DeviceHelper.kt", l = {495, 498}, m = "getDeviceAttributes")
    static final class C28261 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C28261(Continuation<? super C28261> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceHelper.this.getDeviceAttributes(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$getEnrichment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper", f = "DeviceHelper.kt", l = {724, 729, 733, 734, 736}, m = "getEnrichment-8Mi8wO0")
    static final class C28271 extends ContinuationImpl {
        int I$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C28271(Continuation<? super C28271> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceHelper.this.m1320getEnrichment8Mi8wO0(0, 0L, this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$getEnrichment$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper$getEnrichment$2", f = "DeviceHelper.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass2 extends SuspendLambda implements Function2<Enrichment, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = DeviceHelper.this.new AnonymousClass2(continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Enrichment enrichment, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(enrichment, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            DeviceHelper.this.lastEnrichment.setValue((Enrichment) this.L$0);
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$getEnrichment$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper$getEnrichment$3", f = "DeviceHelper.kt", l = {}, m = "invokeSuspend")
    static final class AnonymousClass3 extends SuspendLambda implements Function2<Enrichment, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = DeviceHelper.this.new AnonymousClass3(continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Enrichment enrichment, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(enrichment, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            IntrinsicsKt.f();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            Enrichment enrichment = (Enrichment) this.L$0;
            DeviceHelper.this.getStorage().write(LatestEnrichment.INSTANCE, enrichment);
            Map<String, Object> user = enrichment.getUser();
            Superwall.Companion companion = Superwall.Companion;
            PublicIdentityKt.setUserAttributes(companion.getInstance(), MapsKt.toMap(user));
            PublicIdentityKt.setUserAttributes(companion.getInstance(), MapsKt.toMap(enrichment.getDevice()));
            return Unit.f139807a;
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$getTemplateDevice$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper", f = "DeviceHelper.kt", l = {664, 665, 673}, m = "getTemplateDevice")
    static final class C28281 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C28281(Continuation<? super C28281> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceHelper.this.getTemplateDevice(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$preloadFingerprint$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper", f = "DeviceHelper.kt", l = {470, 471}, m = "preloadFingerprint")
    static final class C28291 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C28291(Continuation<? super C28291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceHelper.this.preloadFingerprint(this);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.network.device.DeviceHelper$templateFingerprint$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.network.device.DeviceHelper", f = "DeviceHelper.kt", l = {585}, m = "templateFingerprint")
    static final class C28301 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C28301(Continuation<? super C28301> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeviceHelper.this.templateFingerprint(null, this);
        }
    }

    public DeviceHelper(Context context, LocalStorage localStorage, SuperwallAPI superwallAPI, Factory factory, DeviceClassifier classifier) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(localStorage, rnFwbPAQmQTnL.xifGipb);
        Intrinsics.checkNotNullParameter(superwallAPI, QgXempTBEfV.qzhJ);
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        this.context = context;
        this.storage = localStorage;
        this.network = superwallAPI;
        this.factory = factory;
        this.classifier = classifier;
        this.json = JsonKt.b(null, new Function1() { // from class: com.superwall.sdk.network.device.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DeviceHelper.json$lambda$1((JsonBuilder) obj);
            }
        }, 1, null);
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        this.appInfo = packageInfo;
        this.appInstallDate = new Date(packageInfo.firstInstallTime);
        this.lastEnrichment = StateFlowKt.a(localStorage.read(LatestEnrichment.INSTANCE));
        this.appVersion$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.appVersion_delegate$lambda$3(this.f93605a);
            }
        });
        this.appVersionPadded$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.appVersionPadded_delegate$lambda$4(this.f93606a);
            }
        });
        this.vendorId$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.vendorId_delegate$lambda$5(this.f93607a);
            }
        });
        this.deviceId$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.deviceId_delegate$lambda$6(this.f93608a);
            }
        });
        this.deviceTier$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.deviceTier_delegate$lambda$7(this.f93609a);
            }
        });
        this.platformWrapper = "";
        this.platformWrapperVersion = "";
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        this._locale = locale;
        this.powerManager$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.powerManager_delegate$lambda$9(this.f93610a);
            }
        });
        this.sdkVersionPadded$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.sdkVersionPadded_delegate$lambda$12(this.f93601a);
            }
        });
        this.appBuildString$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.appBuildString_delegate$lambda$13(this.f93602a);
            }
        });
        this.kotlinVersion$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.kotlinVersion_delegate$lambda$14();
            }
        });
        this.capabilities = CollectionsKt.listOf((Object[]) new Capability[]{new Capability.PaywallEventReceiver(), Capability.MultiplePaywallUrls.INSTANCE, Capability.ConfigCaching.INSTANCE});
        this.capabilitiesConfig$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.network.device.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper.capabilitiesConfig_delegate$lambda$18(this.f93604a);
            }
        });
        this.templateCache = new AtomicReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Context _init_$lambda$0(Context context) {
        return context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appBuildString_delegate$lambda$13(DeviceHelper deviceHelper) {
        return String.valueOf(deviceHelper.appInfo.versionCode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appVersionPadded_delegate$lambda$4(DeviceHelper deviceHelper) {
        return DeviceHelperKt.asPadded(deviceHelper.getAppVersion());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String appVersion_delegate$lambda$3(DeviceHelper deviceHelper) {
        try {
            String str = deviceHelper.appInfo.versionName;
            return str == null ? AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN : str;
        } catch (Throwable th) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.device, "DeviceHelper: Failed to load version info - " + th, (Map) null, (Throwable) null, 24, (Object) null);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object buildDeviceTemplate(com.superwall.sdk.identity.IdentityInfo r61, com.superwall.sdk.network.device.DeviceHelper.VolatileTemplateFields r62, kotlin.coroutines.Continuation<? super com.superwall.sdk.paywall.view.webview.templating.models.DeviceTemplate> r63) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.device.DeviceHelper.buildDeviceTemplate(com.superwall.sdk.identity.IdentityInfo, com.superwall.sdk.network.device.DeviceHelper$VolatileTemplateFields, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JsonElement capabilitiesConfig_delegate$lambda$18(DeviceHelper deviceHelper) {
        return CapabilityKt.toJson(deviceHelper.capabilities);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String deviceId_delegate$lambda$6(DeviceHelper deviceHelper) {
        return new DeviceVendorId(VendorId.m1285constructorimpl(deviceHelper.getVendorId()), null).getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Tier deviceTier_delegate$lambda$7(DeviceHelper deviceHelper) {
        return deviceHelper.classifier.deviceTier();
    }

    private final String getAppVersionPadded() {
        return (String) this.appVersionPadded$delegate.getValue();
    }

    private final JsonElement getCapabilitiesConfig() {
        return (JsonElement) this.capabilitiesConfig$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0078 -> B:21:0x007c). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getComputedDevicePropertiesSinceEvent(com.superwall.sdk.models.events.EventData r10, java.util.List<com.superwall.sdk.models.config.ComputedPropertyRequest> r11, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r12) throws java.lang.Throwable {
        /*
            r9 = this;
            boolean r0 = r12 instanceof com.superwall.sdk.network.device.DeviceHelper.C28251
            if (r0 == 0) goto L13
            r0 = r12
            com.superwall.sdk.network.device.DeviceHelper$getComputedDevicePropertiesSinceEvent$1 r0 = (com.superwall.sdk.network.device.DeviceHelper.C28251) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.device.DeviceHelper$getComputedDevicePropertiesSinceEvent$1 r0 = new com.superwall.sdk.network.device.DeviceHelper$getComputedDevicePropertiesSinceEvent$1
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L45
            if (r2 != r3) goto L3d
            java.lang.Object r10 = r0.L$4
            com.superwall.sdk.models.config.ComputedPropertyRequest r10 = (com.superwall.sdk.models.config.ComputedPropertyRequest) r10
            java.lang.Object r11 = r0.L$3
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$2
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r4 = r0.L$1
            com.superwall.sdk.models.events.EventData r4 = (com.superwall.sdk.models.events.EventData) r4
            java.lang.Object r5 = r0.L$0
            com.superwall.sdk.network.device.DeviceHelper r5 = (com.superwall.sdk.network.device.DeviceHelper) r5
            kotlin.ResultKt.b(r12)
            goto L7c
        L3d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L45:
            kotlin.ResultKt.b(r12)
            java.util.LinkedHashMap r12 = new java.util.LinkedHashMap
            r12.<init>()
            java.util.Iterator r11 = r11.iterator()
            r5 = r9
            r2 = r12
        L53:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto La8
            java.lang.Object r12 = r11.next()
            com.superwall.sdk.models.config.ComputedPropertyRequest r12 = (com.superwall.sdk.models.config.ComputedPropertyRequest) r12
            com.superwall.sdk.storage.LocalStorage r4 = r5.storage
            com.superwall.sdk.storage.core_data.CoreDataManager r4 = r4.getCoreDataManager()
            r0.L$0 = r5
            r0.L$1 = r10
            r0.L$2 = r2
            r0.L$3 = r11
            r0.L$4 = r12
            r0.label = r3
            java.lang.Object r4 = r4.getComputedPropertySinceEvent(r10, r12, r0)
            if (r4 != r1) goto L78
            return r1
        L78:
            r8 = r4
            r4 = r10
            r10 = r12
            r12 = r8
        L7c:
            java.lang.Integer r12 = (java.lang.Integer) r12
            if (r12 == 0) goto La6
            int r12 = r12.intValue()
            java.lang.Integer r12 = kotlin.coroutines.jvm.internal.Boxing.d(r12)
            com.superwall.sdk.models.config.ComputedPropertyRequest$ComputedPropertyRequestType r6 = r10.getType()
            java.lang.String r6 = r6.getPrefix()
            java.lang.String r10 = r10.getEventName()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r6)
            r7.append(r10)
            java.lang.String r10 = r7.toString()
            r2.put(r10, r12)
        La6:
            r10 = r4
            goto L53
        La8:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.device.DeviceHelper.getComputedDevicePropertiesSinceEvent(com.superwall.sdk.models.events.EventData, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final int getDaysSinceInstall() {
        return (int) Duration.c(Instant.A(this.appInstallDate.getTime()), Instant.z()).w();
    }

    private final Enrichment getEnrichment() {
        return (Enrichment) this.lastEnrichment.getValue();
    }

    private final int getMinutesSinceInstall() {
        return (int) Duration.c(Instant.A(this.appInstallDate.getTime()), Instant.z()).z();
    }

    private final PowerManager getPowerManager() {
        return (PowerManager) this.powerManager$delegate.getValue();
    }

    private final String getRegionCode() {
        String country = this._locale.getCountry();
        Intrinsics.checkNotNullExpressionValue(country, "getCountry(...)");
        return country;
    }

    private final ReviewCount getReviewData() {
        ReviewCount reviewCount = (ReviewCount) this.storage.read(ReviewData.INSTANCE);
        if (reviewCount != null) {
            return reviewCount;
        }
        return new ReviewCount(0, 0L, 3, (DefaultConstructorMarker) null);
    }

    private final String getSdkVersionPadded() {
        return (String) this.sdkVersionPadded$delegate.getValue();
    }

    private final String getSubscriptionStatusString() {
        SubscriptionStatus subscriptionStatus = (SubscriptionStatus) Superwall.Companion.getInstance().getSubscriptionStatus().getValue();
        if (subscriptionStatus == null) {
            return null;
        }
        if (subscriptionStatus instanceof SubscriptionStatus.Active) {
            return "ACTIVE";
        }
        if (subscriptionStatus instanceof SubscriptionStatus.Inactive) {
            return "INACTIVE";
        }
        if (subscriptionStatus instanceof SubscriptionStatus.Unknown) {
            return "UNKNOWN";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final int getTotalPaywallViews() {
        Integer num = (Integer) this.storage.read(TotalPaywallViews.INSTANCE);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private final Currency get_currency() {
        try {
            return Currency.getInstance(this._locale);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit json$lambda$1(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.f(true);
        Json.g(true);
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String kotlinVersion_delegate$lambda$14() {
        try {
            return KotlinVersion.f139754g.toString();
        } catch (Throwable unused) {
            return "UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PowerManager powerManager_delegate$lambda$9(DeviceHelper deviceHelper) {
        Object systemService = deviceHelper.context.getSystemService("power");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.PowerManager");
        return (PowerManager) systemService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence preloadFingerprint$lambda$16(Entitlement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + it.getType().getRaw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String sdkVersionPadded_delegate$lambda$12(DeviceHelper deviceHelper) {
        return DeviceHelperKt.asPadded(deviceHelper.getSdkVersion());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object templateFingerprint(com.superwall.sdk.identity.IdentityInfo r17, kotlin.coroutines.Continuation<? super java.lang.String> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 379
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.device.DeviceHelper.templateFingerprint(com.superwall.sdk.identity.IdentityInfo, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence templateFingerprint$lambda$21(Entitlement it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.getId() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + it.getType().getRaw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String vendorId_delegate$lambda$5(DeviceHelper deviceHelper) {
        return Settings.Secure.getString(deviceHelper.context.getContentResolver(), "android_id");
    }

    private final VolatileTemplateFields volatileTemplateFields() {
        Date date = new Date();
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        TimeZone timeZone2 = TimeZone.getDefault();
        DateUtils dateUtils = DateUtils.INSTANCE;
        SimpleDateFormat simpleDateFormatDateFormat = DateUtilsKt.dateFormat(dateUtils.getYyyy_MM_dd());
        SimpleDateFormat simpleDateFormatDateFormat2 = DateUtilsKt.dateFormat(dateUtils.getHH_mm_ss());
        SimpleDateFormat simpleDateFormatDateFormat3 = DateUtilsKt.dateFormat(dateUtils.getISO_SECONDS());
        Date date2 = (Date) this.storage.read(LastPaywallView.INSTANCE);
        Intrinsics.checkNotNull(timeZone);
        String strVolatileTemplateFields$formatIn = volatileTemplateFields$formatIn(simpleDateFormatDateFormat, date, timeZone);
        Intrinsics.checkNotNull(timeZone2);
        return new VolatileTemplateFields(strVolatileTemplateFields$formatIn, volatileTemplateFields$formatIn(simpleDateFormatDateFormat, date, timeZone2), volatileTemplateFields$formatIn(simpleDateFormatDateFormat2, date, timeZone), volatileTemplateFields$formatIn(simpleDateFormatDateFormat2, date, timeZone2), volatileTemplateFields$formatIn(simpleDateFormatDateFormat3, date, timeZone), volatileTemplateFields$formatIn(simpleDateFormatDateFormat3, date, timeZone2), getDaysSinceInstall(), getMinutesSinceInstall(), date2 != null ? Integer.valueOf(daysSince(date2)) : null, date2 != null ? Integer.valueOf(minutesSince(date2)) : null);
    }

    private static final String volatileTemplateFields$formatIn(SimpleDateFormat simpleDateFormat, Date date, TimeZone timeZone) {
        simpleDateFormat.setTimeZone(timeZone);
        String str = simpleDateFormat.format(date);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final int daysSince(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return (int) Duration.c(Instant.A(date.getTime()), Instant.z()).w();
    }

    public final String getAppBuildString() {
        return (String) this.appBuildString$delegate.getValue();
    }

    public final String getAppInstalledAtString() {
        String str = DateUtilsKt.dateFormat(DateUtils.INSTANCE.getSIMPLE()).format(this.appInstallDate);
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public final String getAppVersion() {
        return (String) this.appVersion$delegate.getValue();
    }

    public final String getBuildTime() {
        return BuildConfig.BUILD_TIME;
    }

    public final String getBundleId() {
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }

    public final Map<String, Object> getCachedTemplate$superwall_release() {
        CachedTemplate cachedTemplate = this.templateCache.get();
        if (cachedTemplate != null) {
            return cachedTemplate.getBase();
        }
        return null;
    }

    public final String getCurrencyCode() {
        String currencyCode;
        Currency currency = get_currency();
        return (currency == null || (currencyCode = currency.getCurrencyCode()) == null) ? "" : currencyCode;
    }

    public final String getCurrencySymbol() {
        String symbol;
        Currency currency = get_currency();
        return (currency == null || (symbol = currency.getSymbol()) == null) ? "" : symbol;
    }

    public final Integer getDemandScore$superwall_release() {
        Map<String, Object> device;
        Object obj;
        Enrichment enrichment = (Enrichment) this.lastEnrichment.getValue();
        if (enrichment == null || (device = enrichment.getDevice()) == null || (obj = device.get("demandScore")) == null) {
            return null;
        }
        return obj instanceof Double ? Integer.valueOf((int) ((Number) obj).doubleValue()) : obj instanceof Float ? Integer.valueOf((int) ((Number) obj).floatValue()) : StringsKt.u(obj.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getDeviceAttributes(com.superwall.sdk.models.events.EventData r7, java.util.List<com.superwall.sdk.models.config.ComputedPropertyRequest> r8, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r9) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.superwall.sdk.network.device.DeviceHelper.C28261
            if (r0 == 0) goto L13
            r0 = r9
            com.superwall.sdk.network.device.DeviceHelper$getDeviceAttributes$1 r0 = (com.superwall.sdk.network.device.DeviceHelper.C28261) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.superwall.sdk.network.device.DeviceHelper$getDeviceAttributes$1 r0 = new com.superwall.sdk.network.device.DeviceHelper$getDeviceAttributes$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L49
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r7 = r0.L$0
            java.util.Map r7 = (java.util.Map) r7
            kotlin.ResultKt.b(r9)
            goto L71
        L30:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L38:
            java.lang.Object r7 = r0.L$2
            r8 = r7
            java.util.List r8 = (java.util.List) r8
            java.lang.Object r7 = r0.L$1
            com.superwall.sdk.models.events.EventData r7 = (com.superwall.sdk.models.events.EventData) r7
            java.lang.Object r2 = r0.L$0
            com.superwall.sdk.network.device.DeviceHelper r2 = (com.superwall.sdk.network.device.DeviceHelper) r2
            kotlin.ResultKt.b(r9)
            goto L5c
        L49:
            kotlin.ResultKt.b(r9)
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r9 = r6.getTemplateDevice(r0)
            if (r9 != r1) goto L5b
            goto L6d
        L5b:
            r2 = r6
        L5c:
            java.util.Map r9 = (java.util.Map) r9
            r0.L$0 = r9
            r4 = 0
            r0.L$1 = r4
            r0.L$2 = r4
            r0.label = r3
            java.lang.Object r7 = r2.getComputedDevicePropertiesSinceEvent(r7, r8, r0)
            if (r7 != r1) goto L6e
        L6d:
            return r1
        L6e:
            r5 = r9
            r9 = r7
            r7 = r5
        L71:
            java.util.Map r9 = (java.util.Map) r9
            java.util.Map r7 = kotlin.collections.MapsKt.plus(r7, r9)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.device.DeviceHelper.getDeviceAttributes(com.superwall.sdk.models.events.EventData, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getDeviceId() {
        return (String) this.deviceId$delegate.getValue();
    }

    public final Tier getDeviceTier() {
        return (Tier) this.deviceTier$delegate.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f6 A[LOOP:0: B:37:0x00f0->B:39:0x00f6, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0122 A[PHI: r12 r15
      0x0122: PHI (r12v4 com.superwall.sdk.network.device.DeviceHelper) = (r12v3 com.superwall.sdk.network.device.DeviceHelper), (r12v11 com.superwall.sdk.network.device.DeviceHelper) binds: [B:41:0x011f, B:21:0x0049] A[DONT_GENERATE, DONT_INLINE]
      0x0122: PHI (r15v20 java.lang.Object) = (r15v15 java.lang.Object), (r15v1 java.lang.Object) binds: [B:41:0x011f, B:21:0x0049] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0134 A[PHI: r12 r15
      0x0134: PHI (r12v5 com.superwall.sdk.network.device.DeviceHelper) = (r12v4 com.superwall.sdk.network.device.DeviceHelper), (r12v13 com.superwall.sdk.network.device.DeviceHelper) binds: [B:44:0x0131, B:20:0x0040] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r15v23 java.lang.Object) = (r15v22 java.lang.Object), (r15v1 java.lang.Object) binds: [B:44:0x0131, B:20:0x0040] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0146 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /* JADX INFO: renamed from: getEnrichment-8Mi8wO0, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m1320getEnrichment8Mi8wO0(int r12, long r13, kotlin.coroutines.Continuation<? super com.superwall.sdk.misc.Either<com.superwall.sdk.models.enrichment.Enrichment, com.superwall.sdk.network.NetworkError>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 327
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.device.DeviceHelper.m1320getEnrichment8Mi8wO0(int, long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Factory getFactory() {
        return this.factory;
    }

    public final float getFontScale() {
        return this.context.getResources().getConfiguration().fontScale;
    }

    public final int getFontSize() {
        return MathKt.d(this.context.getResources().getConfiguration().fontScale * 16);
    }

    public final String getGitSha() {
        return BuildConfig.GIT_SHA;
    }

    public final String getInterfaceStyle() {
        String rawValue;
        InterfaceStyle interfaceStyle = this.interfaceStyleOverride;
        if (interfaceStyle != null && (rawValue = interfaceStyle.getRawValue()) != null) {
            return rawValue;
        }
        int i3 = Build.VERSION.SDK_INT >= 29 ? this.context.getResources().getConfiguration().uiMode & 48 : 0;
        return i3 != 16 ? i3 != 32 ? "Unspecified" : "Dark" : "Light";
    }

    public final InterfaceStyle getInterfaceStyleOverride() {
        return this.interfaceStyleOverride;
    }

    public final String getKotlinVersion() {
        return (String) this.kotlinVersion$delegate.getValue();
    }

    public final String getLanguageCode() {
        String language = this._locale.getLanguage();
        Intrinsics.checkNotNullExpressionValue(language, "getLanguage(...)");
        return language;
    }

    public final String getLocale() {
        String strMakeLocaleIdentifier = this.factory.makeLocaleIdentifier();
        if (strMakeLocaleIdentifier != null) {
            return strMakeLocaleIdentifier;
        }
        String string = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final String getModel() {
        String MODEL = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        return MODEL;
    }

    public final SuperwallAPI getNetwork() {
        return this.network;
    }

    public final String getOsVersion() {
        String str = Build.VERSION.RELEASE;
        return str == null ? "" : str;
    }

    public final String getPlatformWrapper() {
        return this.platformWrapper;
    }

    public final String getPlatformWrapperVersion() {
        return this.platformWrapperVersion;
    }

    public final String getRadioType() {
        if (ContextCompat.checkSelfPermission(this.context, "android.permission.ACCESS_NETWORK_STATE") != 0) {
            return "";
        }
        ConnectivityManager connectivityManager = this.connectivityManager;
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        return (networkCapabilities == null || !networkCapabilities.hasTransport(0)) ? (networkCapabilities == null || !networkCapabilities.hasTransport(1)) ? "" : "Wifi" : "Cellular";
    }

    public final int getReviewRequestCount() {
        return getReviewData().getTimesQueried();
    }

    public final String getSdkVersion() {
        return BuildConfig.SDK_VERSION;
    }

    public final String getSecondsFromGMT() {
        return String.valueOf(TimeZone.getDefault().getRawOffset() / 1000);
    }

    public final LocalStorage getStorage() {
        return this.storage;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object getTemplateDevice(kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.device.DeviceHelper.getTemplateDevice(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getUrlScheme() {
        String packageName = this.context.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "getPackageName(...)");
        return packageName;
    }

    public final String getVendorId() {
        Object value = this.vendorId$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (String) value;
    }

    public final int hoursSince(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return (int) Duration.c(Instant.A(date.getTime()), Instant.z()).x();
    }

    public final boolean isEmulator() {
        String DEVICE = Build.DEVICE;
        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
        if (StringsKt.a0(DEVICE, "generic", false, 2, null)) {
            return true;
        }
        Intrinsics.checkNotNullExpressionValue(DEVICE, "DEVICE");
        return StringsKt.a0(DEVICE, "emulator", false, 2, null);
    }

    public final boolean isFirstAppOpen() {
        return !this.storage.getDidTrackFirstSession();
    }

    public final String isLowPowerModeEnabled() {
        return getPowerManager().isPowerSaveMode() ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : "false";
    }

    public final boolean isSandbox() {
        return (this.context.getApplicationInfo().flags & 2) != 0;
    }

    public final Map<String, Object> latestExperimentalDeviceProperties() {
        return this.factory.experimentalProperties();
    }

    public final int minutesSince(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return (int) Duration.c(Instant.A(date.getTime()), Instant.z()).z();
    }

    public final int monthsSince(Date date) {
        Intrinsics.checkNotNullParameter(date, "date");
        return ((int) Duration.c(Instant.A(date.getTime()), Instant.z()).w()) / 30;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object preloadFingerprint(kotlin.coroutines.Continuation<? super java.lang.String> r18) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.network.device.DeviceHelper.preloadFingerprint(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object reviewRequestsTotal(Continuation<? super Integer> continuation) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, AdError.SERVER_ERROR_CODE);
        Date time = calendar.getTime();
        Date date = new Date();
        CoreDataManager coreDataManager = this.storage.getCoreDataManager();
        Intrinsics.checkNotNull(time);
        return coreDataManager.countEventsByNameInPeriod("review_requested", time, date, continuation);
    }

    public final void setEnrichment$superwall_release(Enrichment enrichment) {
        Intrinsics.checkNotNullParameter(enrichment, "enrichment");
        this.lastEnrichment.setValue(enrichment);
    }

    public final void setInterfaceStyleOverride(InterfaceStyle interfaceStyle) {
        this.interfaceStyleOverride = interfaceStyle;
    }

    public final void setPlatformWrapper(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platformWrapper = str;
    }

    public final void setPlatformWrapperVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.platformWrapperVersion = str;
    }

    public final String getDemandTier$superwall_release() {
        Map<String, Object> device;
        Object obj;
        Enrichment enrichment = (Enrichment) this.lastEnrichment.getValue();
        if (enrichment == null || (device = enrichment.getDevice()) == null || (obj = device.get(MrGIhy.EIbykB)) == null) {
            return null;
        }
        return obj.toString();
    }

    public /* synthetic */ DeviceHelper(final Context context, LocalStorage localStorage, SuperwallAPI superwallAPI, Factory factory, DeviceClassifier deviceClassifier, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, localStorage, superwallAPI, factory, (i3 & 16) != 0 ? new DeviceClassifier(new DefaultClassifierDataFactory(new Function0() { // from class: com.superwall.sdk.network.device.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceHelper._init_$lambda$0(context);
            }
        })) : deviceClassifier);
    }
}
