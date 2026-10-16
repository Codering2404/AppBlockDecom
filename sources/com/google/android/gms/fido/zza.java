package com.google.android.gms.fido;

import com.google.android.gms.common.Feature;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class zza {
    public static final Feature A;
    public static final Feature B;
    public static final Feature C;
    public static final Feature[] D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Feature f72781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Feature f72782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Feature f72783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Feature f72784d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Feature f72785e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Feature f72786f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Feature f72787g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Feature f72788h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Feature f72789i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Feature f72790j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Feature f72791k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Feature f72792l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Feature f72793m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Feature f72794n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Feature f72795o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Feature f72796p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Feature f72797q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Feature f72798r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final Feature f72799s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Feature f72800t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Feature f72801u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Feature f72802v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final Feature f72803w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Feature f72804x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Feature f72805y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final Feature f72806z;

    static {
        Feature feature = new Feature("cancel_target_direct_transfer", 1L);
        f72781a = feature;
        Feature feature2 = new Feature("delete_credential", 1L);
        f72782b = feature2;
        Feature feature3 = new Feature("delete_device_public_key", 1L);
        f72783c = feature3;
        Feature feature4 = new Feature("get_or_generate_device_public_key", 1L);
        f72784d = feature4;
        Feature feature5 = new Feature("get_passkeys", 1L);
        f72785e = feature5;
        Feature feature6 = new Feature("update_passkey", 1L);
        f72786f = feature6;
        Feature feature7 = new Feature("is_user_verifying_platform_authenticator_available_for_credential", 1L);
        f72787g = feature7;
        Feature feature8 = new Feature("is_user_verifying_platform_authenticator_available", 1L);
        f72788h = feature8;
        Feature feature9 = new Feature("privileged_api_list_credentials", 2L);
        f72789i = feature9;
        Feature feature10 = new Feature("start_target_direct_transfer", 1L);
        f72790j = feature10;
        Feature feature11 = new Feature("first_party_api_get_link_info", 1L);
        f72791k = feature11;
        Feature feature12 = new Feature("zero_party_api_register", 3L);
        f72792l = feature12;
        Feature feature13 = new Feature("zero_party_api_sign", 3L);
        f72793m = feature13;
        Feature feature14 = new Feature("zero_party_api_list_discoverable_credentials", 2L);
        f72794n = feature14;
        Feature feature15 = new Feature("zero_party_api_authenticate_passkey", 3L);
        f72795o = feature15;
        Feature feature16 = new Feature("zero_party_api_register_passkey", 1L);
        f72796p = feature16;
        Feature feature17 = new Feature("zero_party_api_register_passkey_with_sync_account", 1L);
        f72797q = feature17;
        Feature feature18 = new Feature("zero_party_api_get_hybrid_client_registration_pending_intent", 1L);
        f72798r = feature18;
        Feature feature19 = new Feature("zero_party_api_get_hybrid_client_sign_pending_intent", 1L);
        f72799s = feature19;
        Feature feature20 = new Feature("get_browser_hybrid_client_sign_pending_intent", 1L);
        f72800t = feature20;
        Feature feature21 = new Feature("get_browser_hybrid_client_registration_pending_intent", 1L);
        f72801u = feature21;
        Feature feature22 = new Feature("privileged_authenticate_passkey", 2L);
        f72802v = feature22;
        Feature feature23 = new Feature("privileged_register_passkey_with_sync_account", 1L);
        f72803w = feature23;
        Feature feature24 = new Feature("zero_party_api_get_privileged_hybrid_client_registration_pending_intent", 1L);
        f72804x = feature24;
        Feature feature25 = new Feature("zero_party_api_get_privileged_hybrid_client_sign_pending_intent", 1L);
        f72805y = feature25;
        Feature feature26 = new Feature("zero_party_api_get_fido_security_key_only_sign_pending_intent", 1L);
        f72806z = feature26;
        Feature feature27 = new Feature("zero_party_api_get_fido_security_key_only_registration_pending_intent", 1L);
        A = feature27;
        Feature feature28 = new Feature("zero_party_api_get_privileged_fido_security_key_only_sign_pending_intent", 1L);
        B = feature28;
        Feature feature29 = new Feature("zero_party_api_get_privileged_fido_security_key_only_registration_pending_intent", 1L);
        C = feature29;
        D = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7, feature8, feature9, feature10, feature11, feature12, feature13, feature14, feature15, feature16, feature17, feature18, feature19, feature20, feature21, feature22, feature23, feature24, feature25, feature26, feature27, feature28, feature29};
    }
}
