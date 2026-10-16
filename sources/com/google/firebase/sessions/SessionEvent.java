package com.google.firebase.sessions;

import com.google.firebase.encoders.annotations.Encodable;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@Metadata
@Encodable
public final class SessionEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final EventType f90023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SessionInfo f90024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ApplicationInfo f90025c;

    public SessionEvent(EventType eventType, SessionInfo sessionData, ApplicationInfo applicationInfo) {
        Intrinsics.checkNotNullParameter(eventType, "eventType");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        this.f90023a = eventType;
        this.f90024b = sessionData;
        this.f90025c = applicationInfo;
    }

    public final ApplicationInfo a() {
        return this.f90025c;
    }

    public final EventType b() {
        return this.f90023a;
    }

    public final SessionInfo c() {
        return this.f90024b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionEvent)) {
            return false;
        }
        SessionEvent sessionEvent = (SessionEvent) obj;
        return this.f90023a == sessionEvent.f90023a && Intrinsics.areEqual(this.f90024b, sessionEvent.f90024b) && Intrinsics.areEqual(this.f90025c, sessionEvent.f90025c);
    }

    public int hashCode() {
        return (((this.f90023a.hashCode() * 31) + this.f90024b.hashCode()) * 31) + this.f90025c.hashCode();
    }

    public String toString() {
        return "SessionEvent(eventType=" + this.f90023a + ", sessionData=" + this.f90024b + ", applicationInfo=" + this.f90025c + ')';
    }
}
