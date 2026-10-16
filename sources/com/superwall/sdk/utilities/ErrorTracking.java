package com.superwall.sdk.utilities;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public interface ErrorTracking {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @Serializable
    public static final class ErrorOccurence {
        public static final Companion Companion = new Companion(null);
        private final boolean isFatal;
        private final String message;
        private final String stacktrace;
        private final long timestamp;
        private final String type;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<ErrorOccurence> serializer() {
                return ErrorTracking$ErrorOccurence$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ ErrorOccurence(int i3, String str, String str2, String str3, long j3, boolean z2, SerializationConstructorMarker serializationConstructorMarker) {
            if (31 != (i3 & 31)) {
                PluginExceptionsKt.b(i3, 31, ErrorTracking$ErrorOccurence$$serializer.INSTANCE.getDescriptor());
            }
            this.type = str;
            this.message = str2;
            this.stacktrace = str3;
            this.timestamp = j3;
            this.isFatal = z2;
        }

        public static /* synthetic */ ErrorOccurence copy$default(ErrorOccurence errorOccurence, String str, String str2, String str3, long j3, boolean z2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = errorOccurence.type;
            }
            if ((i3 & 2) != 0) {
                str2 = errorOccurence.message;
            }
            if ((i3 & 4) != 0) {
                str3 = errorOccurence.stacktrace;
            }
            if ((i3 & 8) != 0) {
                j3 = errorOccurence.timestamp;
            }
            if ((i3 & 16) != 0) {
                z2 = errorOccurence.isFatal;
            }
            boolean z3 = z2;
            String str4 = str3;
            return errorOccurence.copy(str, str2, str4, j3, z3);
        }

        @JvmStatic
        public static final /* synthetic */ void write$Self$superwall_release(ErrorOccurence errorOccurence, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.y(serialDescriptor, 0, errorOccurence.type);
            compositeEncoder.y(serialDescriptor, 1, errorOccurence.message);
            compositeEncoder.y(serialDescriptor, 2, errorOccurence.stacktrace);
            compositeEncoder.F(serialDescriptor, 3, errorOccurence.timestamp);
            compositeEncoder.x(serialDescriptor, 4, errorOccurence.isFatal);
        }

        public final String component1() {
            return this.type;
        }

        public final String component2() {
            return this.message;
        }

        public final String component3() {
            return this.stacktrace;
        }

        public final long component4() {
            return this.timestamp;
        }

        public final boolean component5() {
            return this.isFatal;
        }

        public final ErrorOccurence copy(String type, String message, String stacktrace, long j3, boolean z2) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
            return new ErrorOccurence(type, message, stacktrace, j3, z2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ErrorOccurence)) {
                return false;
            }
            ErrorOccurence errorOccurence = (ErrorOccurence) obj;
            return Intrinsics.areEqual(this.type, errorOccurence.type) && Intrinsics.areEqual(this.message, errorOccurence.message) && Intrinsics.areEqual(this.stacktrace, errorOccurence.stacktrace) && this.timestamp == errorOccurence.timestamp && this.isFatal == errorOccurence.isFatal;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getStacktrace() {
            return this.stacktrace;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public final String getType() {
            return this.type;
        }

        public int hashCode() {
            return (((((((this.type.hashCode() * 31) + this.message.hashCode()) * 31) + this.stacktrace.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Boolean.hashCode(this.isFatal);
        }

        public final boolean isFatal() {
            return this.isFatal;
        }

        public String toString() {
            return "ErrorOccurence(type=" + this.type + ", message=" + this.message + ", stacktrace=" + this.stacktrace + ", timestamp=" + this.timestamp + ", isFatal=" + this.isFatal + ")";
        }

        public ErrorOccurence(String type, String message, String stacktrace, long j3, boolean z2) {
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(stacktrace, "stacktrace");
            this.type = type;
            this.message = message;
            this.stacktrace = stacktrace;
            this.timestamp = j3;
            this.isFatal = z2;
        }

        @SerialName
        public static /* synthetic */ void getMessage$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getStacktrace$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getTimestamp$annotations() {
        }

        @SerialName
        public static /* synthetic */ void getType$annotations() {
        }

        @SerialName
        public static /* synthetic */ void isFatal$annotations() {
        }
    }

    void trackError(Throwable th);
}
