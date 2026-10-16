package com.google.gson;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public enum FieldNamingPolicy implements FieldNamingStrategy {
    IDENTITY { // from class: com.google.gson.FieldNamingPolicy.1
        @Override // com.google.gson.FieldNamingStrategy
        public String a(Field field) {
            return field.getName();
        }
    },
    UPPER_CAMEL_CASE { // from class: com.google.gson.FieldNamingPolicy.2
        @Override // com.google.gson.FieldNamingStrategy
        public String a(Field field) {
            return FieldNamingPolicy.c(field.getName());
        }
    },
    UPPER_CAMEL_CASE_WITH_SPACES { // from class: com.google.gson.FieldNamingPolicy.3
        @Override // com.google.gson.FieldNamingStrategy
        public String a(Field field) {
            return FieldNamingPolicy.c(FieldNamingPolicy.b(field.getName(), ' '));
        }
    },
    UPPER_CASE_WITH_UNDERSCORES { // from class: com.google.gson.FieldNamingPolicy.4
        @Override // com.google.gson.FieldNamingStrategy
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '_').toUpperCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_UNDERSCORES { // from class: com.google.gson.FieldNamingPolicy.5
        @Override // com.google.gson.FieldNamingStrategy
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '_').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DASHES { // from class: com.google.gson.FieldNamingPolicy.6
        @Override // com.google.gson.FieldNamingStrategy
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '-').toLowerCase(Locale.ENGLISH);
        }
    },
    LOWER_CASE_WITH_DOTS { // from class: com.google.gson.FieldNamingPolicy.7
        @Override // com.google.gson.FieldNamingStrategy
        public String a(Field field) {
            return FieldNamingPolicy.b(field.getName(), '.').toLowerCase(Locale.ENGLISH);
        }
    };

    static String b(String str, char c3) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isUpperCase(cCharAt) && sb.length() != 0) {
                sb.append(c3);
            }
            sb.append(cCharAt);
        }
        return sb.toString();
    }

    static String c(String str) {
        int length = str.length();
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            char cCharAt = str.charAt(i3);
            if (!Character.isLetter(cCharAt)) {
                i3++;
            } else if (!Character.isUpperCase(cCharAt)) {
                char upperCase = Character.toUpperCase(cCharAt);
                if (i3 == 0) {
                    return upperCase + str.substring(1);
                }
                return str.substring(0, i3) + upperCase + str.substring(i3 + 1);
            }
        }
        return str;
    }
}
