package com.google.firebase.crashlytics.internal.metadata;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class EventMetadata {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f88513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f88514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f88515c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public EventMetadata(String sessionId, long j3) {
        this(sessionId, j3, null, 4, null);
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
    }

    public final Map a() {
        return this.f88515c;
    }

    public final String b() {
        return this.f88513a;
    }

    public final long c() {
        return this.f88514b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EventMetadata)) {
            return false;
        }
        EventMetadata eventMetadata = (EventMetadata) obj;
        return Intrinsics.areEqual(this.f88513a, eventMetadata.f88513a) && this.f88514b == eventMetadata.f88514b && Intrinsics.areEqual(this.f88515c, eventMetadata.f88515c);
    }

    public int hashCode() {
        return (((this.f88513a.hashCode() * 31) + Long.hashCode(this.f88514b)) * 31) + this.f88515c.hashCode();
    }

    public String toString() {
        return "EventMetadata(sessionId=" + this.f88513a + ", timestamp=" + this.f88514b + ", additionalCustomKeys=" + this.f88515c + ')';
    }

    public EventMetadata(String sessionId, long j3, Map additionalCustomKeys) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(additionalCustomKeys, "additionalCustomKeys");
        this.f88513a = sessionId;
        this.f88514b = j3;
        this.f88515c = additionalCustomKeys;
    }

    public /* synthetic */ EventMetadata(String str, long j3, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j3, (i3 & 4) != 0 ? MapsKt.emptyMap() : map);
    }
}
