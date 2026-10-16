package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class JsonPrimitive extends JsonElement {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f90295a;

    public JsonPrimitive(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f90295a = bool;
    }

    private static boolean u(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.f90295a;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // com.google.gson.JsonElement
    public int a() {
        return v() ? s().intValue() : Integer.parseInt(f());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || JsonPrimitive.class != obj.getClass()) {
            return false;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (this.f90295a == null) {
            return jsonPrimitive.f90295a == null;
        }
        if (u(this) && u(jsonPrimitive)) {
            return s().longValue() == jsonPrimitive.s().longValue();
        }
        Object obj2 = this.f90295a;
        if (!(obj2 instanceof Number) || !(jsonPrimitive.f90295a instanceof Number)) {
            return obj2.equals(jsonPrimitive.f90295a);
        }
        double dDoubleValue = s().doubleValue();
        double dDoubleValue2 = jsonPrimitive.s().doubleValue();
        return dDoubleValue == dDoubleValue2 || (Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2));
    }

    @Override // com.google.gson.JsonElement
    public String f() {
        Object obj = this.f90295a;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (v()) {
            return s().toString();
        }
        if (t()) {
            return ((Boolean) this.f90295a).toString();
        }
        throw new AssertionError("Unexpected value type: " + this.f90295a.getClass());
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f90295a == null) {
            return 31;
        }
        if (u(this)) {
            jDoubleToLongBits = s().longValue();
        } else {
            Object obj = this.f90295a;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(s().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public boolean o() {
        return t() ? ((Boolean) this.f90295a).booleanValue() : Boolean.parseBoolean(f());
    }

    public double p() {
        return v() ? s().doubleValue() : Double.parseDouble(f());
    }

    public long q() {
        return v() ? s().longValue() : Long.parseLong(f());
    }

    public Number s() {
        Object obj = this.f90295a;
        if (obj instanceof Number) {
            return (Number) obj;
        }
        if (obj instanceof String) {
            return new LazilyParsedNumber((String) obj);
        }
        throw new UnsupportedOperationException("Primitive is neither a number nor a string");
    }

    public boolean t() {
        return this.f90295a instanceof Boolean;
    }

    public boolean v() {
        return this.f90295a instanceof Number;
    }

    public boolean w() {
        return this.f90295a instanceof String;
    }

    public JsonPrimitive(Number number) {
        Objects.requireNonNull(number);
        this.f90295a = number;
    }

    public JsonPrimitive(String str) {
        Objects.requireNonNull(str);
        this.f90295a = str;
    }
}
