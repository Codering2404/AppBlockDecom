package org.apache.commons.cli;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
class OptionValidator {
    private static boolean a(char c3) {
        return Character.isJavaIdentifierPart(c3);
    }

    private static boolean b(char c3) {
        return a(c3) || c3 == ' ' || c3 == '?' || c3 == '@';
    }

    static void c(String str) {
        if (str == null) {
            return;
        }
        if (str.length() == 1) {
            char cCharAt = str.charAt(0);
            if (b(cCharAt)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("illegal option value '");
            stringBuffer.append(cCharAt);
            stringBuffer.append("'");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (!a(charArray[i3])) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("opt contains illegal character value '");
                stringBuffer2.append(charArray[i3]);
                stringBuffer2.append("'");
                throw new IllegalArgumentException(stringBuffer2.toString());
            }
        }
    }
}
