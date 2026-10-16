package com.airbnb.lottie.network;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public enum FileExtension {
    JSON(".json"),
    ZIP(".zip");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56940a;

    FileExtension(String str) {
        this.f56940a = str;
    }

    public String b() {
        return ".temp" + this.f56940a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f56940a;
    }
}
