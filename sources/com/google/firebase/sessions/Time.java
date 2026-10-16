package com.google.firebase.sessions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
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
public final class Time {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f90116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f90117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f90118c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Time> serializer() {
            return Time$$serializer.f90119a;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ Time(int i3, long j3, long j4, long j5, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i3 & 1)) {
            PluginExceptionsKt.b(i3, 1, Time$$serializer.f90119a.getDescriptor());
        }
        this.f90116a = j3;
        this.f90117b = (i3 & 2) == 0 ? ((long) 1000) * j3 : j4;
        if ((i3 & 4) == 0) {
            this.f90118c = j3 / ((long) 1000);
        } else {
            this.f90118c = j5;
        }
    }

    public static final /* synthetic */ void d(Time time, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.F(serialDescriptor, 0, time.f90116a);
        if (compositeEncoder.z(serialDescriptor, 1) || time.f90117b != time.f90116a * ((long) 1000)) {
            compositeEncoder.F(serialDescriptor, 1, time.f90117b);
        }
        if (!compositeEncoder.z(serialDescriptor, 2) && time.f90118c == time.f90116a / ((long) 1000)) {
            return;
        }
        compositeEncoder.F(serialDescriptor, 2, time.f90118c);
    }

    public final long a() {
        return this.f90118c;
    }

    public final long b() {
        return this.f90117b;
    }

    public final long c(Time time) {
        Intrinsics.checkNotNullParameter(time, "time");
        Duration.Companion companion = Duration.f140631b;
        return DurationKt.t(this.f90116a - time.f90116a, DurationUnit.f140640d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Time) && this.f90116a == ((Time) obj).f90116a;
    }

    public int hashCode() {
        return Long.hashCode(this.f90116a);
    }

    public String toString() {
        return "Time(ms=" + this.f90116a + ')';
    }

    public Time(long j3) {
        this.f90116a = j3;
        long j4 = 1000;
        this.f90117b = j3 * j4;
        this.f90118c = j3 / j4;
    }
}
