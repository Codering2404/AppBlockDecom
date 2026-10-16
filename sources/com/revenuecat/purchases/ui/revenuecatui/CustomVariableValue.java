package com.revenuecat.purchases.ui.revenuecatui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

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
public abstract class CustomVariableValue implements Parcelable {
    public static final int $stable = 0;
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Boolean extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Boolean> CREATOR = new Creator();
        private final boolean value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<Boolean> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Boolean createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Boolean(parcel.readInt() != 0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Boolean[] newArray(int i3) {
                return new Boolean[i3];
            }
        }

        public Boolean(boolean z2) {
            this.value = z2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Boolean) && this.value == ((Boolean) obj).value;
        }

        public final boolean getValue() {
            return this.value;
        }

        public int hashCode() {
            return java.lang.Boolean.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "CustomVariableValue.Boolean(value=" + this.value + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeInt(this.value ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CustomVariableValue from(Object value) {
            Intrinsics.checkNotNullParameter(value, "value");
            if (value instanceof java.lang.String) {
                return new String((java.lang.String) value);
            }
            if (value instanceof Integer) {
                return new Number(((java.lang.Number) value).intValue());
            }
            if (value instanceof Long) {
                return new Number(((java.lang.Number) value).longValue());
            }
            if (value instanceof Double) {
                return new Number(((java.lang.Number) value).doubleValue());
            }
            if (value instanceof Float) {
                return new Number(((java.lang.Number) value).floatValue());
            }
            if (value instanceof java.lang.Boolean) {
                return new Boolean(((java.lang.Boolean) value).booleanValue());
            }
            throw new IllegalArgumentException("Unsupported custom variable type: " + Reflection.b(value.getClass()).m() + ". Supported types are: String, Int, Long, Double, Float, Boolean.");
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Number extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<Number> CREATOR = new Creator();
        private final double value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<Number> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Number createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new Number(parcel.readDouble());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Number[] newArray(int i3) {
                return new Number[i3];
            }
        }

        public Number(double d3) {
            this.value = d3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Number) && this.value == ((Number) obj).value;
        }

        public final double getValue() {
            return this.value;
        }

        public int hashCode() {
            return Double.hashCode(this.value);
        }

        public java.lang.String toString() {
            return "CustomVariableValue.Number(value=" + this.value + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeDouble(this.value);
        }

        public Number(int i3) {
            this(i3);
        }

        public Number(long j3) {
            this(j3);
        }

        public Number(float f3) {
            this(f3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class String extends CustomVariableValue implements Parcelable {
        public static final int $stable = 0;
        public static final Parcelable.Creator<String> CREATOR = new Creator();
        private final java.lang.String value;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Creator implements Parcelable.Creator<String> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final String createFromParcel(Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new String(parcel.readString());
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final String[] newArray(int i3) {
                return new String[i3];
            }
        }

        public String(java.lang.String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.value = value;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            return (obj instanceof String) && Intrinsics.areEqual(this.value, ((String) obj).value);
        }

        public final java.lang.String getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public java.lang.String toString() {
            return "CustomVariableValue.String(value=" + this.value + ')';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel out, int i3) {
            Intrinsics.checkNotNullParameter(out, "out");
            out.writeString(this.value);
        }
    }

    public final java.lang.String getStringValue() {
        if (this instanceof String) {
            return ((String) this).getValue();
        }
        if (this instanceof Number) {
            Number number = (Number) this;
            return number.getValue() % 1.0d == 0.0d ? java.lang.String.valueOf((long) number.getValue()) : java.lang.String.valueOf(number.getValue());
        }
        if (this instanceof Boolean) {
            return java.lang.String.valueOf(((Boolean) this).getValue());
        }
        throw new IllegalStateException("Unknown CustomVariableValue type");
    }
}
