package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import com.google.android.libraries.places.api.model.Place;
import com.google.common.collect.ImmutableMap;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzlw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ImmutableMap f78179a = ImmutableMap.a().g(Place.Field.ADDRESS_COMPONENTS, "address_components").g(Place.Field.BUSINESS_STATUS, "business_status").g(Place.Field.CURBSIDE_PICKUP, "curbside_pickup").g(Place.Field.CURRENT_OPENING_HOURS, "current_opening_hours").g(Place.Field.DELIVERY, "delivery").g(Place.Field.DINE_IN, "dine_in").g(Place.Field.DISPLAY_NAME, "name").g(Place.Field.EDITORIAL_SUMMARY, "editorial_summary").g(Place.Field.FORMATTED_ADDRESS, "formatted_address").g(Place.Field.ICON_BACKGROUND_COLOR, "icon_background_color").g(Place.Field.ICON_MASK_URL, "icon_mask_base_uri").g(Place.Field.ID, "place_id").g(Place.Field.INTERNATIONAL_PHONE_NUMBER, "international_phone_number").g(Place.Field.LOCATION, "geometry/location").g(Place.Field.OPENING_HOURS, "opening_hours").g(Place.Field.PHOTO_METADATAS, "photos").g(Place.Field.PLUS_CODE, "plus_code").g(Place.Field.PRICE_LEVEL, "price_level").g(Place.Field.RATING, "rating").g(Place.Field.RESERVABLE, "reservable").g(Place.Field.SECONDARY_OPENING_HOURS, "secondary_opening_hours").g(Place.Field.SERVES_BEER, "serves_beer").g(Place.Field.SERVES_BREAKFAST, "serves_breakfast").g(Place.Field.SERVES_BRUNCH, "serves_brunch").g(Place.Field.SERVES_DINNER, "serves_dinner").g(Place.Field.SERVES_LUNCH, "serves_lunch").g(Place.Field.SERVES_VEGETARIAN_FOOD, "serves_vegetarian_food").g(Place.Field.SERVES_WINE, "serves_wine").g(Place.Field.TAKEOUT, "takeout").g(Place.Field.TYPES, "types").g(Place.Field.USER_RATING_COUNT, "user_ratings_total").g(Place.Field.UTC_OFFSET, "utc_offset").g(Place.Field.VIEWPORT, "geometry/viewport").g(Place.Field.WEBSITE_URI, cJfnYMIyomoWf.WjIJbqyTraQx).d();

    public static List a(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) f78179a.get((Place.Field) it.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public static String b(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) f78179a.get((Place.Field) it.next());
            if (!TextUtils.isEmpty(str)) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }
}
