package cz.mobilesoft.coreblock.storage.room.dto.blocking;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.Application;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.ApplicationProfileRelation;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.PomodoroSession;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class ProfileWithBlockedItems {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Profile f126360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f126361b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List f126362c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f126363d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List f126364e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ApplicationProfileRelationWithApplication {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f126365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ApplicationProfileRelation f126366b;

        public ApplicationProfileRelationWithApplication(Application application, ApplicationProfileRelation applicationProfileRelation) {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(applicationProfileRelation, "applicationProfileRelation");
            this.f126365a = application;
            this.f126366b = applicationProfileRelation;
        }

        public final Application a() {
            return this.f126365a;
        }

        public final ApplicationProfileRelation b() {
            return this.f126366b;
        }

        public final String c() {
            return this.f126365a.b();
        }

        public final String d() {
            return this.f126365a.d();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ApplicationProfileRelationWithApplication)) {
                return false;
            }
            ApplicationProfileRelationWithApplication applicationProfileRelationWithApplication = (ApplicationProfileRelationWithApplication) obj;
            return Intrinsics.areEqual(this.f126365a, applicationProfileRelationWithApplication.f126365a) && Intrinsics.areEqual(this.f126366b, applicationProfileRelationWithApplication.f126366b);
        }

        public int hashCode() {
            return (this.f126365a.hashCode() * 31) + this.f126366b.hashCode();
        }

        public String toString() {
            return "ApplicationProfileRelationWithApplication(application=" + this.f126365a + ", applicationProfileRelation=" + this.f126366b + ")";
        }
    }

    public ProfileWithBlockedItems(Profile profile, List applications, List websites, List pomodoroSessions, List subApps) {
        Intrinsics.checkNotNullParameter(profile, "profile");
        Intrinsics.checkNotNullParameter(applications, "applications");
        Intrinsics.checkNotNullParameter(websites, "websites");
        Intrinsics.checkNotNullParameter(pomodoroSessions, "pomodoroSessions");
        Intrinsics.checkNotNullParameter(subApps, "subApps");
        this.f126360a = profile;
        this.f126361b = applications;
        this.f126362c = websites;
        this.f126363d = pomodoroSessions;
        this.f126364e = subApps;
    }

    public final List a() {
        return this.f126361b;
    }

    public final PomodoroSession b() {
        Object next;
        Iterator it = this.f126363d.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PomodoroSession) next).t()) {
                break;
            }
        }
        return (PomodoroSession) next;
    }

    public final Profile c() {
        return this.f126360a;
    }

    public final List d() {
        return this.f126364e;
    }

    public final List e() {
        return this.f126362c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProfileWithBlockedItems)) {
            return false;
        }
        ProfileWithBlockedItems profileWithBlockedItems = (ProfileWithBlockedItems) obj;
        return Intrinsics.areEqual(this.f126360a, profileWithBlockedItems.f126360a) && Intrinsics.areEqual(this.f126361b, profileWithBlockedItems.f126361b) && Intrinsics.areEqual(this.f126362c, profileWithBlockedItems.f126362c) && Intrinsics.areEqual(this.f126363d, profileWithBlockedItems.f126363d) && Intrinsics.areEqual(this.f126364e, profileWithBlockedItems.f126364e);
    }

    public final boolean f() {
        return this.f126360a.o() == Profile.BlockingMode.Allowlist || !this.f126361b.isEmpty() || !this.f126362c.isEmpty() || this.f126360a.j() || this.f126360a.k() || this.f126360a.i() || this.f126360a.n();
    }

    public int hashCode() {
        return (((((((this.f126360a.hashCode() * 31) + this.f126361b.hashCode()) * 31) + this.f126362c.hashCode()) * 31) + this.f126363d.hashCode()) * 31) + this.f126364e.hashCode();
    }

    public String toString() {
        return "ProfileWithBlockedItems(profile=" + this.f126360a + ", applications=" + this.f126361b + ", websites=" + this.f126362c + ", pomodoroSessions=" + this.f126363d + ", subApps=" + this.f126364e + ")";
    }
}
