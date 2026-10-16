package com.google.firebase.sessions.settings;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
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
public final class SessionConfigs {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Boolean f90194a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Double f90195b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Integer f90196c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Integer f90197d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Long f90198e;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<SessionConfigs> serializer() {
            return SessionConfigs$$serializer.f90199a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ SessionConfigs(int i3, Boolean bool, Double d3, Integer num, Integer num2, Long l3, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i3 & 31)) {
            PluginExceptionsKt.b(i3, 31, SessionConfigs$$serializer.f90199a.getDescriptor());
        }
        this.f90194a = bool;
        this.f90195b = d3;
        this.f90196c = num;
        this.f90197d = num2;
        this.f90198e = l3;
    }

    public static final /* synthetic */ void f(SessionConfigs sessionConfigs, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.i(serialDescriptor, 0, BooleanSerializer.f142767a, sessionConfigs.f90194a);
        compositeEncoder.i(serialDescriptor, 1, DoubleSerializer.f142796a, sessionConfigs.f90195b);
        IntSerializer intSerializer = IntSerializer.f142823a;
        compositeEncoder.i(serialDescriptor, 2, intSerializer, sessionConfigs.f90196c);
        compositeEncoder.i(serialDescriptor, 3, intSerializer, sessionConfigs.f90197d);
        compositeEncoder.i(serialDescriptor, 4, LongSerializer.f142836a, sessionConfigs.f90198e);
    }

    public final Integer a() {
        return this.f90197d;
    }

    public final Long b() {
        return this.f90198e;
    }

    public final Double c() {
        return this.f90195b;
    }

    public final Integer d() {
        return this.f90196c;
    }

    public final Boolean e() {
        return this.f90194a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SessionConfigs)) {
            return false;
        }
        SessionConfigs sessionConfigs = (SessionConfigs) obj;
        return Intrinsics.areEqual(this.f90194a, sessionConfigs.f90194a) && Intrinsics.areEqual((Object) this.f90195b, (Object) sessionConfigs.f90195b) && Intrinsics.areEqual(this.f90196c, sessionConfigs.f90196c) && Intrinsics.areEqual(this.f90197d, sessionConfigs.f90197d) && Intrinsics.areEqual(this.f90198e, sessionConfigs.f90198e);
    }

    public int hashCode() {
        Boolean bool = this.f90194a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Double d3 = this.f90195b;
        int iHashCode2 = (iHashCode + (d3 == null ? 0 : d3.hashCode())) * 31;
        Integer num = this.f90196c;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f90197d;
        int iHashCode4 = (iHashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Long l3 = this.f90198e;
        return iHashCode4 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.f90194a + ", sessionSamplingRate=" + this.f90195b + ", sessionTimeoutSeconds=" + this.f90196c + ", cacheDurationSeconds=" + this.f90197d + ", cacheUpdatedTimeSeconds=" + this.f90198e + ')';
    }

    public SessionConfigs(Boolean bool, Double d3, Integer num, Integer num2, Long l3) {
        this.f90194a = bool;
        this.f90195b = d3;
        this.f90196c = num;
        this.f90197d = num2;
        this.f90198e = l3;
    }
}
