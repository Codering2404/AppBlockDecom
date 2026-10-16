package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum zzxh implements zzbdu {
    TEL(0),
    SMS(1),
    CALLTO(2),
    WTAI(3),
    RTSP(4),
    MARKET(5),
    GEO(6),
    SKYPE(7),
    WHATSAPP(8),
    ITMS(20),
    ITMS_BOOKS(9),
    ITMS_BOOKSS(27),
    GLASS(10),
    ITMS_APPS(11),
    f78809q(19),
    ITMS_SERVICES(22),
    GOOGLEASSISTANT(12),
    ASSISTANT_SETTINGS(13),
    SSH(14),
    INTENT(15),
    SIP(16),
    GOOGLEHOME(17),
    CHROMECAST(18),
    PAY(21),
    GOOGLEAPP(23),
    CID(24),
    WEBCAL(25),
    YOUTUBE(26),
    FILE(28),
    CONTENT(29),
    HELPFULINTERRUPTION(30),
    GOOGLECHROMEACTION(31),
    GOOGLECHROME(32),
    GOOGLECHROMES(33),
    GOOGLEPHOTOS(34);


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f78819a;

    zzxh(int i3) {
        this.f78819a = i3;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.f78819a);
    }

    @Override // com.google.android.libraries.places.internal.zzbdu
    public final int zza() {
        return this.f78819a;
    }
}
