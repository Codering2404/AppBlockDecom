package com.applovin.impl.sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public class AppLovinError {
    public static final AppLovinError NO_FILL = new AppLovinError(204, "No Fill");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f63129a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f63130b;

    public AppLovinError(int i3, String str) {
        this.f63129a = i3;
        this.f63130b = str;
    }

    protected boolean canEqual(Object obj) {
        return obj instanceof AppLovinError;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AppLovinError)) {
            return false;
        }
        AppLovinError appLovinError = (AppLovinError) obj;
        if (!appLovinError.canEqual(this) || getCode() != appLovinError.getCode()) {
            return false;
        }
        String message = getMessage();
        String message2 = appLovinError.getMessage();
        return message != null ? message.equals(message2) : message2 == null;
    }

    public int getCode() {
        return this.f63129a;
    }

    public String getMessage() {
        return this.f63130b;
    }

    public int hashCode() {
        int code = getCode() + 59;
        String message = getMessage();
        return (code * 59) + (message == null ? 43 : message.hashCode());
    }

    public String toString() {
        return "AppLovinError(code=" + getCode() + ", message=" + getMessage() + ")";
    }
}
