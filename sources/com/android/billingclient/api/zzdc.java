package com.android.billingclient.api;

import com.android.billingclient.api.BillingResult;
import com.revenuecat.purchases.google.ErrorsKt;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdc {
    static final BillingResult A;
    static final BillingResult B;
    static final BillingResult C;
    static final BillingResult D;
    static final BillingResult E;
    static final BillingResult F;
    static final BillingResult G;
    static final BillingResult H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final BillingResult f57551a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final BillingResult f57552b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final BillingResult f57553c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final BillingResult f57554d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final BillingResult f57555e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final BillingResult f57556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final BillingResult f57557g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final BillingResult f57558h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final BillingResult f57559i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final BillingResult f57560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final BillingResult f57561k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    static final BillingResult f57562l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    static final BillingResult f57563m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    static final BillingResult f57564n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    static final BillingResult f57565o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    static final BillingResult f57566p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    static final BillingResult f57567q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    static final BillingResult f57568r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    static final BillingResult f57569s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    static final BillingResult f57570t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    static final BillingResult f57571u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    static final BillingResult f57572v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    static final BillingResult f57573w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final BillingResult f57574x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final BillingResult f57575y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final BillingResult f57576z;

    static {
        BillingResult.Builder builderD = BillingResult.d();
        builderD.d(3);
        builderD.b(ErrorsKt.IN_APP_BILLING_LESS_THAN_3_ERROR_MESSAGE);
        builderD.a();
        BillingResult.Builder builderD2 = BillingResult.d();
        builderD2.d(3);
        builderD2.b("Google Play In-app Billing API version is less than 9");
        f57551a = builderD2.a();
        BillingResult.Builder builderD3 = BillingResult.d();
        builderD3.d(3);
        builderD3.b("Billing service unavailable on device.");
        f57552b = builderD3.a();
        BillingResult.Builder builderD4 = BillingResult.d();
        builderD4.d(2);
        builderD4.b("Billing service unavailable on device.");
        f57553c = builderD4.a();
        BillingResult.Builder builderD5 = BillingResult.d();
        builderD5.d(5);
        builderD5.b("Client is already in the process of connecting to billing service.");
        f57554d = builderD5.a();
        BillingResult.Builder builderD6 = BillingResult.d();
        builderD6.d(5);
        builderD6.b("The list of SKUs can't be empty.");
        builderD6.a();
        BillingResult.Builder builderD7 = BillingResult.d();
        builderD7.d(5);
        builderD7.b("SKU type can't be empty.");
        builderD7.a();
        BillingResult.Builder builderD8 = BillingResult.d();
        builderD8.d(5);
        builderD8.b("Product type can't be empty.");
        f57555e = builderD8.a();
        BillingResult.Builder builderD9 = BillingResult.d();
        builderD9.d(-2);
        builderD9.b("Client does not support extra params.");
        f57556f = builderD9.a();
        BillingResult.Builder builderD10 = BillingResult.d();
        builderD10.d(5);
        builderD10.b("Invalid purchase token.");
        f57557g = builderD10.a();
        BillingResult.Builder builderD11 = BillingResult.d();
        builderD11.d(6);
        builderD11.b("An internal error occurred.");
        f57558h = builderD11.a();
        BillingResult.Builder builderD12 = BillingResult.d();
        builderD12.d(5);
        builderD12.b("SKU can't be null.");
        builderD12.a();
        BillingResult.Builder builderD13 = BillingResult.d();
        builderD13.d(0);
        f57559i = builderD13.a();
        BillingResult.Builder builderD14 = BillingResult.d();
        builderD14.d(-1);
        builderD14.b("Service connection is disconnected.");
        f57560j = builderD14.a();
        BillingResult.Builder builderD15 = BillingResult.d();
        builderD15.d(2);
        builderD15.b("Timeout communicating with service.");
        f57561k = builderD15.a();
        BillingResult.Builder builderD16 = BillingResult.d();
        builderD16.d(-2);
        builderD16.b("Client does not support subscriptions.");
        f57562l = builderD16.a();
        BillingResult.Builder builderD17 = BillingResult.d();
        builderD17.d(-2);
        builderD17.b("Client does not support subscriptions update.");
        f57563m = builderD17.a();
        BillingResult.Builder builderD18 = BillingResult.d();
        builderD18.d(-2);
        builderD18.b("Client does not support get purchase history.");
        builderD18.a();
        BillingResult.Builder builderD19 = BillingResult.d();
        builderD19.d(-2);
        builderD19.b("Client does not support price change confirmation.");
        f57564n = builderD19.a();
        BillingResult.Builder builderD20 = BillingResult.d();
        builderD20.d(-2);
        builderD20.b("Play Store version installed does not support cross selling products.");
        f57565o = builderD20.a();
        BillingResult.Builder builderD21 = BillingResult.d();
        builderD21.d(-2);
        builderD21.b("Client does not support multi-item purchases.");
        f57566p = builderD21.a();
        BillingResult.Builder builderD22 = BillingResult.d();
        builderD22.d(-2);
        builderD22.b("Client does not support offer_id_token.");
        f57567q = builderD22.a();
        BillingResult.Builder builderD23 = BillingResult.d();
        builderD23.d(-2);
        builderD23.b("Client does not support ProductDetails.");
        f57568r = builderD23.a();
        BillingResult.Builder builderD24 = BillingResult.d();
        builderD24.d(-2);
        builderD24.b("Client does not support in-app messages.");
        f57569s = builderD24.a();
        BillingResult.Builder builderD25 = BillingResult.d();
        builderD25.d(-2);
        builderD25.b("Client does not support user choice billing.");
        builderD25.a();
        BillingResult.Builder builderD26 = BillingResult.d();
        builderD26.d(-2);
        builderD26.b("Play Store version installed does not support external offer.");
        f57570t = builderD26.a();
        BillingResult.Builder builderD27 = BillingResult.d();
        builderD27.d(-2);
        builderD27.b("Play Store version installed does not support multi-item purchases with season pass in one cart.");
        f57571u = builderD27.a();
        BillingResult.Builder builderD28 = BillingResult.d();
        builderD28.d(-2);
        builderD28.b("Play Store version installed does not support querying AutoPay plan purchase.");
        f57572v = builderD28.a();
        BillingResult.Builder builderD29 = BillingResult.d();
        builderD29.d(-2);
        builderD29.b("Play Store version installed does not support including suspended subscriptions.");
        f57573w = builderD29.a();
        BillingResult.Builder builderD30 = BillingResult.d();
        builderD30.d(5);
        builderD30.b("Unknown feature");
        f57574x = builderD30.a();
        BillingResult.Builder builderD31 = BillingResult.d();
        builderD31.d(-2);
        builderD31.b("Play Store version installed does not support get billing config.");
        f57575y = builderD31.a();
        BillingResult.Builder builderD32 = BillingResult.d();
        builderD32.d(-2);
        builderD32.b("Query product details with serialized docid is not supported.");
        f57576z = builderD32.a();
        BillingResult.Builder builderD33 = BillingResult.d();
        builderD33.d(-2);
        builderD33.b("Play Store version installed does not support launching external offer flow.");
        builderD33.a();
        BillingResult.Builder builderD34 = BillingResult.d();
        builderD34.d(4);
        builderD34.b("Item is unavailable for purchase.");
        A = builderD34.a();
        BillingResult.Builder builderD35 = BillingResult.d();
        builderD35.d(-2);
        builderD35.b("Query product details with developer specified account is not supported.");
        B = builderD35.a();
        BillingResult.Builder builderD36 = BillingResult.d();
        builderD36.d(-2);
        builderD36.b("Play Store version installed does not support alternative billing only.");
        C = builderD36.a();
        BillingResult.Builder builderD37 = BillingResult.d();
        builderD37.d(5);
        builderD37.b("To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        D = builderD37.a();
        BillingResult.Builder builderD38 = BillingResult.d();
        builderD38.d(6);
        builderD38.b("An error occurred while retrieving billing override.");
        E = builderD38.a();
        BillingResult.Builder builderD39 = BillingResult.d();
        builderD39.d(-2);
        builderD39.b("Play Store version installed does not support the provided billing program.");
        F = builderD39.a();
        BillingResult.Builder builderD40 = BillingResult.d();
        builderD40.d(-2);
        builderD40.b("Play Store version installed does not support launching external links.");
        G = builderD40.a();
        BillingResult.Builder builderD41 = BillingResult.d();
        builderD41.d(5);
        builderD41.b("A DeveloperProvidedBillingListener must be provided when initializing the BillingClient in order to use multiple payment options for this billing program.");
        H = builderD41.a();
    }

    static BillingResult a(int i3, String str) {
        BillingResult.Builder builderD = BillingResult.d();
        builderD.d(i3);
        builderD.b(str);
        return builderD.a();
    }
}
