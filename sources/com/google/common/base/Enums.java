package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class Enums {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map f83284a = new WeakHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Class f83285b;

        @Override // com.google.common.base.Converter, com.google.common.base.Function
        public boolean equals(Object obj) {
            if (obj instanceof StringConverter) {
                return this.f83285b.equals(((StringConverter) obj).f83285b);
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public String d(Enum r12) {
            return r12.name();
        }

        public int hashCode() {
            return this.f83285b.hashCode();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Enum e(String str) {
            return Enum.valueOf(this.f83285b, str);
        }

        public String toString() {
            return "Enums.stringConverter(" + this.f83285b.getName() + ".class)";
        }
    }
}
