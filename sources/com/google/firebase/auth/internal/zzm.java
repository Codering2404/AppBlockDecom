package com.google.firebase.auth.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class zzm extends zzi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f87987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f87988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f87989c;

    @Override // com.google.firebase.auth.internal.zzi
    public final zzi a(String str) {
        this.f87988b = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzi
    public final zzj b() {
        return new zzn(this.f87987a, this.f87988b, this.f87989c);
    }

    @Override // com.google.firebase.auth.internal.zzi
    public final zzi c(String str) {
        this.f87989c = str;
        return this;
    }

    @Override // com.google.firebase.auth.internal.zzi
    public final zzi d(String str) {
        this.f87987a = str;
        return this;
    }
}
