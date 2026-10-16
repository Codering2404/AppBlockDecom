package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
@Serializable
public final class SessionDetails {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f90018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f90019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f90020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f90021d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SessionDetails> serializer() {
            return SessionDetails$$serializer.f90022a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SessionDetails(int i3, String str, String str2, int i4, long j3, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i3 & 15)) {
            PluginExceptionsKt.b(i3, 15, SessionDetails$$serializer.f90022a.getDescriptor());
        }
        this.f90018a = str;
        this.f90019b = str2;
        this.f90020c = i4;
        this.f90021d = j3;
    }

    public static final /* synthetic */ void e(SessionDetails sessionDetails, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.y(serialDescriptor, 0, sessionDetails.f90018a);
        compositeEncoder.y(serialDescriptor, 1, sessionDetails.f90019b);
        compositeEncoder.w(serialDescriptor, 2, sessionDetails.f90020c);
        compositeEncoder.F(serialDescriptor, 3, sessionDetails.f90021d);
    }

    public final String a() {
        return this.f90019b;
    }

    public final String b() {
        return this.f90018a;
    }

    public final int c() {
        return this.f90020c;
    }

    public final long d() {
        return this.f90021d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionDetails)) {
            return false;
        }
        SessionDetails sessionDetails = (SessionDetails) obj;
        return Intrinsics.areEqual(this.f90018a, sessionDetails.f90018a) && Intrinsics.areEqual(this.f90019b, sessionDetails.f90019b) && this.f90020c == sessionDetails.f90020c && this.f90021d == sessionDetails.f90021d;
    }

    public int hashCode() {
        return (((((this.f90018a.hashCode() * 31) + this.f90019b.hashCode()) * 31) + Integer.hashCode(this.f90020c)) * 31) + Long.hashCode(this.f90021d);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.f90018a + ", firstSessionId=" + this.f90019b + ", sessionIndex=" + this.f90020c + ", sessionStartTimestampUs=" + this.f90021d + ')';
    }

    public SessionDetails(String sessionId, String firstSessionId, int i3, long j3) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        Intrinsics.checkNotNullParameter(firstSessionId, "firstSessionId");
        this.f90018a = sessionId;
        this.f90019b = firstSessionId;
        this.f90020c = i3;
        this.f90021d = j3;
    }
}
