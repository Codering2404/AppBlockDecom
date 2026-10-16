package com.google.firebase.sessions.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public interface SessionSubscriber {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Name {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Name f90138a = new Name("CRASHLYTICS", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Name f90139b = new Name("PERFORMANCE", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Name f90140c = new Name("MATT_SAYS_HI", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ Name[] f90141d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f90142f;

        static {
            Name[] nameArrA = a();
            f90141d = nameArrA;
            f90142f = EnumEntriesKt.a(nameArrA);
        }

        private Name(String str, int i3) {
        }

        private static final /* synthetic */ Name[] a() {
            return new Name[]{f90138a, f90139b, f90140c};
        }

        public static Name valueOf(String str) {
            return (Name) Enum.valueOf(Name.class, str);
        }

        public static Name[] values() {
            return (Name[]) f90141d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class SessionDetails {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f90143a;

        public SessionDetails(String sessionId) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            this.f90143a = sessionId;
        }

        public final String a() {
            return this.f90143a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionDetails) && Intrinsics.areEqual(this.f90143a, ((SessionDetails) obj).f90143a);
        }

        public int hashCode() {
            return this.f90143a.hashCode();
        }

        public String toString() {
            return "SessionDetails(sessionId=" + this.f90143a + ')';
        }
    }

    boolean a();

    Name b();

    void c(SessionDetails sessionDetails);
}
