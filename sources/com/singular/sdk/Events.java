package com.singular.sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
public enum Events {
    sngRate("sng_rate"),
    sngSpentCredits("sng_spent_credits"),
    sngTutorialComplete("sng_tutorial_complete"),
    sngLogin("sng_login"),
    sngStartTrial("sng_start_trial"),
    sngSubscribe("sng_subscribe"),
    sngBook("sng_book"),
    sngContentViewList("sng_content_view_list"),
    sngInvite("sng_invite"),
    sngShare("sng_share"),
    sngSubmitApplication("sng_submit_application"),
    sngUpdate("sng_update"),
    sngEcommercePurchase("sng_ecommerce_purchase"),
    sngViewCart("sng_view_cart"),
    sngAchievementUnlocked("sng_achievement_unlocked"),
    sngAddPaymentInfo("sng_add_payment_info"),
    sngAddToCart("sng_add_to_cart"),
    sngAddToWishlist("sng_add_to_wishlist"),
    sngCheckoutInitiated("sng_checkout_initiated"),
    sngCompleteRegistration("sng_complete_registration"),
    sngContentView("sng_content_view"),
    sngLevelAchieved("sng_level_achieved"),
    sngSearch("sng_search");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f92402a;

    Events(String str) {
        this.f92402a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f92402a;
    }
}
