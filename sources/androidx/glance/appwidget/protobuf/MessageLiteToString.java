package androidx.glance.appwidget.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class MessageLiteToString {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f39157a;

    static {
        char[] cArr = new char[80];
        f39157a = cArr;
        Arrays.fill(cArr, ' ');
    }

    private static void a(int i3, StringBuilder sb) {
        while (i3 > 0) {
            char[] cArr = f39157a;
            int length = i3 > cArr.length ? cArr.length : i3;
            sb.append(cArr, 0, length);
            i3 -= length;
        }
    }

    private static boolean b(Object obj) {
        return obj instanceof Boolean ? !((Boolean) obj).booleanValue() : obj instanceof Integer ? ((Integer) obj).intValue() == 0 : obj instanceof Float ? Float.floatToRawIntBits(((Float) obj).floatValue()) == 0 : obj instanceof Double ? Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0 : obj instanceof String ? obj.equals("") : obj instanceof ByteString ? obj.equals(ByteString.f38830b) : obj instanceof MessageLite ? obj == ((MessageLite) obj).g() : (obj instanceof java.lang.Enum) && ((java.lang.Enum) obj).ordinal() == 0;
    }

    private static String c(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i3 = 1; i3 < str.length(); i3++) {
            char cCharAt = str.charAt(i3);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    static void d(StringBuilder sb, int i3, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                d(sb, i3, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                d(sb, i3, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        a(i3, sb);
        sb.append(c(str));
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.c((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof ByteString) {
            sb.append(": \"");
            sb.append(TextFormatEscaper.a((ByteString) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof GeneratedMessageLite) {
            sb.append(" {");
            e((GeneratedMessageLite) obj, sb, i3 + 2);
            sb.append("\n");
            a(i3, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i4 = i3 + 2;
        d(sb, i4, "key", entry.getKey());
        d(sb, i4, "value", entry.getValue());
        sb.append("\n");
        a(i3, sb);
        sb.append("}");
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void e(androidx.glance.appwidget.protobuf.MessageLite r17, java.lang.StringBuilder r18, int r19) {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.glance.appwidget.protobuf.MessageLiteToString.e(androidx.glance.appwidget.protobuf.MessageLite, java.lang.StringBuilder, int):void");
    }

    static String f(MessageLite messageLite, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        e(messageLite, sb, 0);
        return sb.toString();
    }
}
