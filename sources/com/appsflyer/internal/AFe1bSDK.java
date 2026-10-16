package com.appsflyer.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public abstract class AFe1bSDK extends AFa1tSDK {
    private final boolean AFVersionDeclaration;
    private boolean afErrorLogForExcManagerOnly;
    private final boolean getLevel;

    AFe1bSDK() {
        this(null, null, null, null, null);
    }

    public final boolean AFVersionDeclaration() {
        return this.AFVersionDeclaration;
    }

    public final boolean afErrorLogForExcManagerOnly() {
        return this.afErrorLogForExcManagerOnly;
    }

    public final boolean getLevel() {
        return this.getLevel;
    }

    public AFe1bSDK(String str, String str2, Boolean bool, Boolean bool2, Boolean bool3) {
        super(str, str2, Boolean.valueOf(bool3 != null ? bool3.booleanValue() : false));
        this.getLevel = bool != null ? bool.booleanValue() : true;
        this.AFVersionDeclaration = bool2 != null ? bool2.booleanValue() : true;
    }
}
