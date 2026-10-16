package com.google.android.libraries.places.internal;

import com.google.android.libraries.places.api.model.Place;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzjl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableMap f78023a = ImmutableMap.a().g(Place.Field.ACCESSIBILITY_OPTIONS, "accessibilityOptions").g(Place.Field.ADDRESS_COMPONENTS, "addressComponents").g(Place.Field.ADR_FORMAT_ADDRESS, "adrFormatAddress").g(Place.Field.ALLOWS_DOGS, "allowsDogs").g(Place.Field.BUSINESS_STATUS, "businessStatus").g(Place.Field.CONSUMER_ALERT, "consumerAlert").g(Place.Field.CURBSIDE_PICKUP, "curbsidePickup").g(Place.Field.CURRENT_OPENING_HOURS, "currentOpeningHours").g(Place.Field.CURRENT_SECONDARY_OPENING_HOURS, "currentSecondaryOpeningHours").g(Place.Field.DELIVERY, "delivery").g(Place.Field.DINE_IN, "dineIn").g(Place.Field.DISPLAY_NAME, "displayName").g(Place.Field.EDITORIAL_SUMMARY, "editorialSummary").g(Place.Field.EV_CHARGE_AMENITY_SUMMARY, "evChargeAmenitySummary").g(Place.Field.EV_CHARGE_OPTIONS, "evChargeOptions").g(Place.Field.FORMATTED_ADDRESS, "formattedAddress").g(Place.Field.FUEL_OPTIONS, "fuelOptions").g(Place.Field.GENERATIVE_SUMMARY, "generativeSummary").g(Place.Field.GOOD_FOR_CHILDREN, "goodForChildren").g(Place.Field.GOOD_FOR_GROUPS, "goodForGroups").g(Place.Field.GOOD_FOR_WATCHING_SPORTS, "goodForWatchingSports").g(Place.Field.GOOGLE_MAPS_LINKS, "googleMapsLinks").g(Place.Field.GOOGLE_MAPS_URI, "googleMapsUri").g(Place.Field.ICON_BACKGROUND_COLOR, "iconBackgroundColor").g(Place.Field.ICON_MASK_URL, "iconMaskBaseUri").g(Place.Field.ID, "id").g(Place.Field.INTERNATIONAL_PHONE_NUMBER, "internationalPhoneNumber").g(Place.Field.LIVE_MUSIC, "liveMusic").g(Place.Field.LOCATION, "location").g(Place.Field.MENU_FOR_CHILDREN, "menuForChildren").g(Place.Field.NATIONAL_PHONE_NUMBER, "nationalPhoneNumber").g(Place.Field.NEIGHBORHOOD_SUMMARY, "neighborhoodSummary").g(Place.Field.OPENING_HOURS, "regularOpeningHours").g(Place.Field.OUTDOOR_SEATING, "outdoorSeating").g(Place.Field.PARKING_OPTIONS, "parkingOptions").g(Place.Field.PAYMENT_OPTIONS, "paymentOptions").g(Place.Field.PHOTO_METADATAS, "photos").g(Place.Field.PLUS_CODE, "plusCode").g(Place.Field.PRICE_LEVEL, "priceLevel").g(Place.Field.PRICE_RANGE, "priceRange").g(Place.Field.PRIMARY_TYPE, "primaryType").g(Place.Field.PRIMARY_TYPE_DISPLAY_NAME, "primaryTypeDisplayName").g(Place.Field.PURE_SERVICE_AREA_BUSINESS, "pureServiceAreaBusiness").g(Place.Field.RATING, "rating").g(Place.Field.RESERVABLE, "reservable").g(Place.Field.RESOURCE_NAME, "name").g(Place.Field.RESTROOM, "restroom").g(Place.Field.REVIEWS, "reviews").g(Place.Field.REVIEW_SUMMARY, "reviewSummary").g(Place.Field.SECONDARY_OPENING_HOURS, "regularSecondaryOpeningHours").g(Place.Field.SERVES_BEER, "servesBeer").g(Place.Field.SERVES_BREAKFAST, "servesBreakfast").g(Place.Field.SERVES_BRUNCH, "servesBrunch").g(Place.Field.SERVES_COCKTAILS, "servesCocktails").g(Place.Field.SERVES_COFFEE, "servesCoffee").g(Place.Field.SERVES_DESSERT, "servesDessert").g(Place.Field.SERVES_DINNER, "servesDinner").g(Place.Field.SERVES_LUNCH, "servesLunch").g(Place.Field.SERVES_VEGETARIAN_FOOD, "servesVegetarianFood").g(Place.Field.SERVES_WINE, "servesWine").g(Place.Field.SHORT_FORMATTED_ADDRESS, "shortFormattedAddress").g(Place.Field.SUB_DESTINATIONS, "subDestinations").g(Place.Field.TAKEOUT, "takeout").g(Place.Field.TYPES, "types").g(Place.Field.USER_RATING_COUNT, "userRatingCount").g(Place.Field.UTC_OFFSET, "utcOffsetMinutes").g(Place.Field.VIEWPORT, "viewport").g(Place.Field.WEBSITE_URI, "websiteUri").d();

    public static List a(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) f78023a.get((Place.Field) it.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
