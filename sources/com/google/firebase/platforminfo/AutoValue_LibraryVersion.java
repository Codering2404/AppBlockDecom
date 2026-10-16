package com.google.firebase.platforminfo;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_LibraryVersion extends LibraryVersion {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f89614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89615b;

    AutoValue_LibraryVersion(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f89614a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f89615b = str2;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public String b() {
        return this.f89614a;
    }

    @Override // com.google.firebase.platforminfo.LibraryVersion
    public String c() {
        return this.f89615b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LibraryVersion) {
            LibraryVersion libraryVersion = (LibraryVersion) obj;
            if (this.f89614a.equals(libraryVersion.b()) && this.f89615b.equals(libraryVersion.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f89614a.hashCode() ^ 1000003) * 1000003) ^ this.f89615b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f89614a + ", version=" + this.f89615b + "}";
    }
}
