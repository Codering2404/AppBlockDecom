package com.google.firebase.installations.local;

import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.local.PersistedInstallationEntry;
import cz.mobilesoft.coreblock.scene.lockscreen.EI.MrGIhy;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class AutoValue_PersistedInstallationEntry extends PersistedInstallationEntry {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f89268b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PersistedInstallation.RegistrationStatus f89269c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f89270d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f89271e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f89272f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f89273g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f89274h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class Builder extends PersistedInstallationEntry.Builder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f89275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PersistedInstallation.RegistrationStatus f89276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f89277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f89278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f89279e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f89280f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f89281g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private byte f89282h;

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry a() {
            if (this.f89282h == 3 && this.f89276b != null) {
                return new AutoValue_PersistedInstallationEntry(this.f89275a, this.f89276b, this.f89277c, this.f89278d, this.f89279e, this.f89280f, this.f89281g);
            }
            StringBuilder sb = new StringBuilder();
            if (this.f89276b == null) {
                sb.append(" registrationStatus");
            }
            if ((this.f89282h & 1) == 0) {
                sb.append(" expiresInSecs");
            }
            if ((this.f89282h & 2) == 0) {
                sb.append(" tokenCreationEpochInSecs");
            }
            throw new IllegalStateException("Missing required properties:" + ((Object) sb));
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder b(String str) {
            this.f89277c = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder c(long j3) {
            this.f89279e = j3;
            this.f89282h = (byte) (this.f89282h | 1);
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder d(String str) {
            this.f89275a = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder e(String str) {
            this.f89281g = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder f(String str) {
            this.f89278d = str;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder g(PersistedInstallation.RegistrationStatus registrationStatus) {
            if (registrationStatus == null) {
                throw new NullPointerException("Null registrationStatus");
            }
            this.f89276b = registrationStatus;
            return this;
        }

        @Override // com.google.firebase.installations.local.PersistedInstallationEntry.Builder
        public PersistedInstallationEntry.Builder h(long j3) {
            this.f89280f = j3;
            this.f89282h = (byte) (this.f89282h | 2);
            return this;
        }

        Builder() {
        }

        private Builder(PersistedInstallationEntry persistedInstallationEntry) {
            this.f89275a = persistedInstallationEntry.d();
            this.f89276b = persistedInstallationEntry.g();
            this.f89277c = persistedInstallationEntry.b();
            this.f89278d = persistedInstallationEntry.f();
            this.f89279e = persistedInstallationEntry.c();
            this.f89280f = persistedInstallationEntry.h();
            this.f89281g = persistedInstallationEntry.e();
            this.f89282h = (byte) 3;
        }
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String b() {
        return this.f89270d;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long c() {
        return this.f89272f;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String d() {
        return this.f89268b;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String e() {
        return this.f89274h;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof PersistedInstallationEntry) {
            PersistedInstallationEntry persistedInstallationEntry = (PersistedInstallationEntry) obj;
            String str4 = this.f89268b;
            if (str4 != null ? str4.equals(persistedInstallationEntry.d()) : persistedInstallationEntry.d() == null) {
                if (this.f89269c.equals(persistedInstallationEntry.g()) && ((str = this.f89270d) != null ? str.equals(persistedInstallationEntry.b()) : persistedInstallationEntry.b() == null) && ((str2 = this.f89271e) != null ? str2.equals(persistedInstallationEntry.f()) : persistedInstallationEntry.f() == null) && this.f89272f == persistedInstallationEntry.c() && this.f89273g == persistedInstallationEntry.h() && ((str3 = this.f89274h) != null ? str3.equals(persistedInstallationEntry.e()) : persistedInstallationEntry.e() == null)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public String f() {
        return this.f89271e;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public PersistedInstallation.RegistrationStatus g() {
        return this.f89269c;
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public long h() {
        return this.f89273g;
    }

    public int hashCode() {
        String str = this.f89268b;
        int iHashCode = ((((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.f89269c.hashCode()) * 1000003;
        String str2 = this.f89270d;
        int iHashCode2 = (iHashCode ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f89271e;
        int iHashCode3 = (iHashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        long j3 = this.f89272f;
        int i3 = (iHashCode3 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003;
        long j4 = this.f89273g;
        int i4 = (i3 ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003;
        String str4 = this.f89274h;
        return i4 ^ (str4 != null ? str4.hashCode() : 0);
    }

    @Override // com.google.firebase.installations.local.PersistedInstallationEntry
    public PersistedInstallationEntry.Builder n() {
        return new Builder(this);
    }

    private AutoValue_PersistedInstallationEntry(String str, PersistedInstallation.RegistrationStatus registrationStatus, String str2, String str3, long j3, long j4, String str4) {
        this.f89268b = str;
        this.f89269c = registrationStatus;
        this.f89270d = str2;
        this.f89271e = str3;
        this.f89272f = j3;
        this.f89273g = j4;
        this.f89274h = str4;
    }

    public String toString() {
        return "PersistedInstallationEntry{firebaseInstallationId=" + this.f89268b + ", registrationStatus=" + this.f89269c + ", authToken=" + this.f89270d + MrGIhy.YytTIs + this.f89271e + ", expiresInSecs=" + this.f89272f + ", tokenCreationEpochInSecs=" + this.f89273g + ", fisError=" + this.f89274h + "}";
    }
}
