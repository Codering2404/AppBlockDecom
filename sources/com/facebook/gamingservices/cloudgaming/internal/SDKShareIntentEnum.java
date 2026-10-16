package com.facebook.gamingservices.cloudgaming.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum SDKShareIntentEnum {
    INVITE("INVITE"),
    REQUEST("REQUEST"),
    CHALLENGE("CHALLENGE"),
    SHARE("SHARE");

    private final String mStringValue;

    SDKShareIntentEnum(String str) {
        this.mStringValue = str;
    }

    public static SDKShareIntentEnum fromString(String str) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(str)) {
                return sDKShareIntentEnum;
            }
        }
        return null;
    }

    public static String validate(String str) {
        for (SDKShareIntentEnum sDKShareIntentEnum : values()) {
            if (sDKShareIntentEnum.toString().equals(str)) {
                return str;
            }
        }
        return null;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.mStringValue;
    }
}
