package com.superwall.sdk.misc;

import java.lang.Throwable;
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
public abstract class Either<T, E extends Throwable> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Failure<E extends Throwable> extends Either {
        private final E error;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Failure(E error) {
            super(null);
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Failure copy$default(Failure failure, Throwable th, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                th = failure.error;
            }
            return failure.copy(th);
        }

        public final E component1() {
            return this.error;
        }

        public final Failure<E> copy(E error) {
            Intrinsics.checkNotNullParameter(error, "error");
            return new Failure<>(error);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual(this.error, ((Failure) obj).error);
        }

        public final E getError() {
            return this.error;
        }

        public int hashCode() {
            return this.error.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.error + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Success<T, E extends Throwable> extends Either<T, E> {
        private final T value;

        public Success(T t2) {
            super(null);
            this.value = t2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, Object obj, int i3, Object obj2) {
            if ((i3 & 1) != 0) {
                obj = success.value;
            }
            return success.copy(obj);
        }

        public final T component1() {
            return this.value;
        }

        public final Success<T, E> copy(T t2) {
            return new Success<>(t2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.value, ((Success) obj).value);
        }

        public final T getValue() {
            return this.value;
        }

        public int hashCode() {
            T t2 = this.value;
            if (t2 == null) {
                return 0;
            }
            return t2.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.value + ")";
        }
    }

    public /* synthetic */ Either(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final T getSuccess() {
        if (this instanceof Success) {
            return (T) ((Success) this).getValue();
        }
        return null;
    }

    public final E getThrowable() {
        if (this instanceof Failure) {
            return (E) ((Failure) this).getError();
        }
        return null;
    }

    private Either() {
    }
}
