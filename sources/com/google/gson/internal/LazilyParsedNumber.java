package com.google.gson.internal;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectStreamException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class LazilyParsedNumber extends Number {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f90356a;

    public LazilyParsedNumber(String str) {
        this.f90356a = str;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("Deserialization is unsupported");
    }

    private Object writeReplace() throws ObjectStreamException {
        return new BigDecimal(this.f90356a);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return Double.parseDouble(this.f90356a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LazilyParsedNumber)) {
            return false;
        }
        String str = this.f90356a;
        String str2 = ((LazilyParsedNumber) obj).f90356a;
        return str == str2 || str.equals(str2);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return Float.parseFloat(this.f90356a);
    }

    public int hashCode() {
        return this.f90356a.hashCode();
    }

    @Override // java.lang.Number
    public int intValue() {
        try {
            try {
                return Integer.parseInt(this.f90356a);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(this.f90356a);
            }
        } catch (NumberFormatException unused2) {
            return new BigDecimal(this.f90356a).intValue();
        }
    }

    @Override // java.lang.Number
    public long longValue() {
        try {
            return Long.parseLong(this.f90356a);
        } catch (NumberFormatException unused) {
            return new BigDecimal(this.f90356a).longValue();
        }
    }

    public String toString() {
        return this.f90356a;
    }
}
