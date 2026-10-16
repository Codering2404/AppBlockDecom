package com.revenuecat.purchases.common.events;

import com.revenuecat.purchases.ads.events.AdEvent;
import com.revenuecat.purchases.common.events.BackendEvent;
import com.revenuecat.purchases.common.events.BackendStoredEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterImpressionEvent;
import com.revenuecat.purchases.customercenter.events.CustomerCenterSurveyOptionChosenEvent;
import com.revenuecat.purchases.paywalls.events.BackendPaywallComponentFields;
import com.revenuecat.purchases.paywalls.events.CustomPaywallEvent;
import com.revenuecat.purchases.paywalls.events.ExitOfferType;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.paywalls.events.PaywallEventKt;
import com.revenuecat.purchases.paywalls.events.PaywallEventType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
/* JADX INFO: loaded from: classes5.dex */
@Metadata
public final class BackendStoredEventKt {
    public static final BackendEvent toBackendEvent(BackendStoredEvent backendStoredEvent) {
        Intrinsics.checkNotNullParameter(backendStoredEvent, "<this>");
        if (backendStoredEvent instanceof BackendStoredEvent.Paywalls) {
            return ((BackendStoredEvent.Paywalls) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.CustomerCenter) {
            return ((BackendStoredEvent.CustomerCenter) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.Ad) {
            return ((BackendStoredEvent.Ad) backendStoredEvent).getEvent();
        }
        if (backendStoredEvent instanceof BackendStoredEvent.CustomPaywall) {
            return ((BackendStoredEvent.CustomPaywall) backendStoredEvent).getEvent();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(PaywallEvent paywallEvent, String appUserID) {
        Intrinsics.checkNotNullParameter(paywallEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        if (paywallEvent.getType() == PaywallEventType.PURCHASE_INITIATED || paywallEvent.getType() == PaywallEventType.PURCHASE_ERROR) {
            return null;
        }
        BackendPaywallComponentFields backendComponentFields = PaywallEventKt.toBackendComponentFields(paywallEvent.getComponentInteraction());
        String string = paywallEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        String value = paywallEvent.getType().getValue();
        String string2 = paywallEvent.getData().getSessionIdentifier().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "data.sessionIdentifier.toString()");
        String offeringIdentifier = paywallEvent.getData().getPresentedOfferingContext().getOfferingIdentifier();
        String paywallIdentifier = paywallEvent.getData().getPaywallIdentifier();
        int paywallRevision = paywallEvent.getData().getPaywallRevision();
        long time = paywallEvent.getCreationData().getDate().getTime();
        String displayMode = paywallEvent.getData().getDisplayMode();
        boolean darkMode = paywallEvent.getData().getDarkMode();
        String localeIdentifier = paywallEvent.getData().getLocaleIdentifier();
        BackendEvent.PresentedOfferingContextData presentedOfferingContextDataFromContext = BackendEvent.PresentedOfferingContextData.Companion.fromContext(paywallEvent.getData().getPresentedOfferingContext());
        ExitOfferType exitOfferType = paywallEvent.getData().getExitOfferType();
        return new BackendStoredEvent.Paywalls(new BackendEvent.Paywalls(string, 1, value, appUserID, string2, offeringIdentifier, paywallIdentifier, paywallRevision, time, displayMode, darkMode, localeIdentifier, presentedOfferingContextDataFromContext, exitOfferType != null ? exitOfferType.getValue() : null, paywallEvent.getData().getExitOfferingIdentifier(), paywallEvent.getData().getPackageIdentifier(), paywallEvent.getData().getProductIdentifier(), paywallEvent.getData().getErrorCode(), paywallEvent.getData().getErrorMessage(), backendComponentFields.getComponentType(), backendComponentFields.getComponentName(), backendComponentFields.getComponentValue(), backendComponentFields.getComponentUrl(), backendComponentFields.getOriginIndex(), backendComponentFields.getDestinationIndex(), backendComponentFields.getOriginContextName(), backendComponentFields.getDestinationContextName(), backendComponentFields.getDefaultIndex(), backendComponentFields.getOriginPackageIdentifier(), backendComponentFields.getDestinationPackageIdentifier(), backendComponentFields.getDefaultPackageIdentifier(), backendComponentFields.getOriginProductIdentifier(), backendComponentFields.getDestinationProductIdentifier(), backendComponentFields.getDefaultProductIdentifier(), backendComponentFields.getCurrentPackageIdentifier(), backendComponentFields.getResultingPackageIdentifier(), backendComponentFields.getCurrentProductIdentifier(), backendComponentFields.getResultingProductIdentifier()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterImpressionEvent customerCenterImpressionEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(customerCenterImpressionEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = customerCenterImpressionEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterImpressionEvent.getData().getRevisionID(), customerCenterImpressionEvent.getData().getType(), appUserID, appSessionID, customerCenterImpressionEvent.getData().getTimestamp().getTime(), customerCenterImpressionEvent.getData().getDarkMode(), customerCenterImpressionEvent.getData().getLocale(), customerCenterImpressionEvent.getData().getDisplayMode(), null, null, null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomerCenterSurveyOptionChosenEvent customerCenterSurveyOptionChosenEvent, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(customerCenterSurveyOptionChosenEvent, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = customerCenterSurveyOptionChosenEvent.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomerCenter(new BackendEvent.CustomerCenter(string, customerCenterSurveyOptionChosenEvent.getData().getRevisionID(), customerCenterSurveyOptionChosenEvent.getData().getType(), appUserID, appSessionID, customerCenterSurveyOptionChosenEvent.getData().getTimestamp().getTime(), customerCenterSurveyOptionChosenEvent.getData().getDarkMode(), customerCenterSurveyOptionChosenEvent.getData().getLocale(), customerCenterSurveyOptionChosenEvent.getData().getDisplayMode(), customerCenterSurveyOptionChosenEvent.getData().getPath(), customerCenterSurveyOptionChosenEvent.getData().getUrl(), customerCenterSurveyOptionChosenEvent.getData().getSurveyOptionID()));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Open open, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(open, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(open.getId(), open.getEventVersion(), open.getType().getValue(), open.getTimestamp(), open.getNetworkName(), open.mo470getMediatorNameGyoM_N4(), open.mo469getAdFormaty0COY5Q(), open.getPlacement(), open.getAdUnitId(), open.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, (Integer) null, 61440, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Displayed displayed, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(displayed, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(displayed.getId(), displayed.getEventVersion(), displayed.getType().getValue(), displayed.getTimestamp(), displayed.getNetworkName(), displayed.mo470getMediatorNameGyoM_N4(), displayed.mo469getAdFormaty0COY5Q(), displayed.getPlacement(), displayed.getAdUnitId(), displayed.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, (Integer) null, 61440, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Revenue revenue, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(revenue, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(revenue.getId(), revenue.getEventVersion(), revenue.getType().getValue(), revenue.getTimestamp(), revenue.getNetworkName(), revenue.mo470getMediatorNameGyoM_N4(), revenue.mo469getAdFormaty0COY5Q(), revenue.getPlacement(), revenue.getAdUnitId(), revenue.getImpressionId(), appUserID, appSessionID, Long.valueOf(revenue.getRevenueMicros()), revenue.getCurrency(), revenue.m471getPrecisionrAcPn4k(), (Integer) null, 32768, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.Loaded loaded, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(loaded, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(loaded.getId(), loaded.getEventVersion(), loaded.getType().getValue(), loaded.getTimestamp(), loaded.getNetworkName(), loaded.mo470getMediatorNameGyoM_N4(), loaded.mo469getAdFormaty0COY5Q(), loaded.getPlacement(), loaded.getAdUnitId(), loaded.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, (Integer) null, 61440, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(AdEvent.FailedToLoad failedToLoad, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(failedToLoad, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        return new BackendStoredEvent.Ad(new BackendEvent.Ad(failedToLoad.getId(), failedToLoad.getEventVersion(), failedToLoad.getType().getValue(), failedToLoad.getTimestamp(), (String) null, failedToLoad.mo470getMediatorNameGyoM_N4(), failedToLoad.mo469getAdFormaty0COY5Q(), failedToLoad.getPlacement(), failedToLoad.getAdUnitId(), failedToLoad.getImpressionId(), appUserID, appSessionID, (Long) null, (String) null, (String) null, failedToLoad.getMediatorErrorCode(), 28688, (DefaultConstructorMarker) null));
    }

    public static final /* synthetic */ BackendStoredEvent toBackendStoredEvent(CustomPaywallEvent.Impression impression, String appUserID, String appSessionID) {
        Intrinsics.checkNotNullParameter(impression, "<this>");
        Intrinsics.checkNotNullParameter(appUserID, "appUserID");
        Intrinsics.checkNotNullParameter(appSessionID, "appSessionID");
        String string = impression.getCreationData().getId().toString();
        Intrinsics.checkNotNullExpressionValue(string, "creationData.id.toString()");
        return new BackendStoredEvent.CustomPaywall(new BackendEvent.CustomPaywall(string, 1, "custom_paywall_impression", appUserID, appSessionID, impression.getCreationData().getDate().getTime(), impression.getData().getPaywallId(), impression.getData().getOfferingId()));
    }
}
