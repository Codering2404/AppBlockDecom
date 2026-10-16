package com.superwall.sdk.network;

import kotlin.Metadata;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class NetworkError extends Throwable {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Decoding extends NetworkError {
        /* JADX WARN: Multi-variable type inference failed */
        public Decoding() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public /* synthetic */ Decoding(Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : th);
        }

        public Decoding(Throwable th) {
            super("Decoding error " + (th != null ? th.getMessage() : null), th, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class InvalidUrl extends NetworkError {
        /* JADX WARN: Multi-variable type inference failed */
        public InvalidUrl() {
            super("URL invalid.", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotAuthenticated extends NetworkError {
        /* JADX WARN: Multi-variable type inference failed */
        public NotAuthenticated() {
            super("Unauthorized.", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class NotFound extends NetworkError {
        /* JADX WARN: Multi-variable type inference failed */
        public NotFound() {
            super("Not found.", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Timeout extends NetworkError {
        public static final Timeout INSTANCE = new Timeout();

        /* JADX WARN: Multi-variable type inference failed */
        private Timeout() {
            super("Timeout occured.", null, 2, 0 == true ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Unknown extends NetworkError {
        private final Throwable cause;

        /* JADX WARN: Multi-variable type inference failed */
        public Unknown() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, Throwable th, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                th = unknown.cause;
            }
            return unknown.copy(th);
        }

        public final Throwable component1() {
            return this.cause;
        }

        public final Unknown copy(Throwable th) {
            return new Unknown(th);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unknown) && Intrinsics.areEqual(this.cause, ((Unknown) obj).cause);
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th == null) {
                return 0;
            }
            return th.hashCode();
        }

        @Override // java.lang.Throwable
        public String toString() {
            return "Unknown(cause=" + this.cause + ")";
        }

        public /* synthetic */ Unknown(Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public Unknown(Throwable th) {
            String message;
            DefaultConstructorMarker defaultConstructorMarker = null;
            if (th == null || (message = th.getLocalizedMessage()) == null) {
                message = th != null ? th.getMessage() : null;
                if (message == null) {
                    message = "Unknown error occurred.";
                }
            }
            super(message, th, defaultConstructorMarker);
            this.cause = th;
        }
    }

    public /* synthetic */ NetworkError(String str, Throwable th, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, th);
    }

    public /* synthetic */ NetworkError(String str, Throwable th, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : th, null);
    }

    private NetworkError(String str, Throwable th) {
        super(str, th);
    }
}
