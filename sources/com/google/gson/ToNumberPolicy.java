package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import java.io.IOException;
import java.math.BigDecimal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum ToNumberPolicy implements ToNumberStrategy {
    DOUBLE { // from class: com.google.gson.ToNumberPolicy.1
        @Override // com.google.gson.ToNumberStrategy
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Double a(JsonReader jsonReader) {
            return Double.valueOf(jsonReader.K());
        }
    },
    LAZILY_PARSED_NUMBER { // from class: com.google.gson.ToNumberPolicy.2
        @Override // com.google.gson.ToNumberStrategy
        public Number a(JsonReader jsonReader) {
            return new LazilyParsedNumber(jsonReader.e0());
        }
    },
    LONG_OR_DOUBLE { // from class: com.google.gson.ToNumberPolicy.3
        @Override // com.google.gson.ToNumberStrategy
        public Number a(JsonReader jsonReader) throws IOException {
            String strE0 = jsonReader.e0();
            try {
                try {
                    return Long.valueOf(Long.parseLong(strE0));
                } catch (NumberFormatException unused) {
                    Double dValueOf = Double.valueOf(strE0);
                    if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                        if (!jsonReader.z()) {
                            throw new MalformedJsonException("JSON forbids NaN and infinities: " + dValueOf + "; at path " + jsonReader.n());
                        }
                    }
                    return dValueOf;
                }
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Cannot parse " + strE0 + "; at path " + jsonReader.n(), e3);
            }
        }
    },
    BIG_DECIMAL { // from class: com.google.gson.ToNumberPolicy.4
        @Override // com.google.gson.ToNumberStrategy
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public BigDecimal a(JsonReader jsonReader) throws IOException {
            String strE0 = jsonReader.e0();
            try {
                return new BigDecimal(strE0);
            } catch (NumberFormatException e3) {
                throw new JsonParseException("Cannot parse " + strE0 + "; at path " + jsonReader.n(), e3);
            }
        }
    }
}
