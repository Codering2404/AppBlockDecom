package com.google.firebase.sessions;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

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
public final class SessionData {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final KSerializer[] f90011d = {null, null, new LinkedHashMapSerializer(StringSerializer.f142891a, ProcessData$$serializer.f89997a)};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SessionDetails f90012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Time f90013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f90014c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SessionData> serializer() {
            return SessionData$$serializer.f90015a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SessionData(int i3, SessionDetails sessionDetails, Time time, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, SessionData$$serializer.f90015a.getDescriptor());
        }
        this.f90012a = sessionDetails;
        if ((i3 & 2) == 0) {
            this.f90013b = null;
        } else {
            this.f90013b = time;
        }
        if ((i3 & 4) == 0) {
            this.f90014c = null;
        } else {
            this.f90014c = map;
        }
    }

    public static /* synthetic */ SessionData c(SessionData sessionData, SessionDetails sessionDetails, Time time, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            sessionDetails = sessionData.f90012a;
        }
        if ((i3 & 2) != 0) {
            time = sessionData.f90013b;
        }
        if ((i3 & 4) != 0) {
            map = sessionData.f90014c;
        }
        return sessionData.b(sessionDetails, time, map);
    }

    public static final /* synthetic */ void g(SessionData sessionData, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        KSerializer[] kSerializerArr = f90011d;
        compositeEncoder.C(serialDescriptor, 0, SessionDetails$$serializer.f90022a, sessionData.f90012a);
        if (compositeEncoder.z(serialDescriptor, 1) || sessionData.f90013b != null) {
            compositeEncoder.i(serialDescriptor, 1, Time$$serializer.f90119a, sessionData.f90013b);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && sessionData.f90014c == null) {
            return;
        }
        compositeEncoder.i(serialDescriptor, 2, kSerializerArr[2], sessionData.f90014c);
    }

    public final SessionData b(SessionDetails sessionDetails, Time time, Map map) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        return new SessionData(sessionDetails, time, map);
    }

    public final Time d() {
        return this.f90013b;
    }

    public final Map e() {
        return this.f90014c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionData)) {
            return false;
        }
        SessionData sessionData = (SessionData) obj;
        return Intrinsics.areEqual(this.f90012a, sessionData.f90012a) && Intrinsics.areEqual(this.f90013b, sessionData.f90013b) && Intrinsics.areEqual(this.f90014c, sessionData.f90014c);
    }

    public final SessionDetails f() {
        return this.f90012a;
    }

    public int hashCode() {
        int iHashCode = this.f90012a.hashCode() * 31;
        Time time = this.f90013b;
        int iHashCode2 = (iHashCode + (time == null ? 0 : time.hashCode())) * 31;
        Map map = this.f90014c;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        return "SessionData(sessionDetails=" + this.f90012a + ", backgroundTime=" + this.f90013b + ", processDataMap=" + this.f90014c + ')';
    }

    public SessionData(SessionDetails sessionDetails, Time time, Map map) {
        Intrinsics.checkNotNullParameter(sessionDetails, "sessionDetails");
        this.f90012a = sessionDetails;
        this.f90013b = time;
        this.f90014c = map;
    }

    public /* synthetic */ SessionData(SessionDetails sessionDetails, Time time, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(sessionDetails, (i3 & 2) != 0 ? null : time, (i3 & 4) != 0 ? null : map);
    }
}
