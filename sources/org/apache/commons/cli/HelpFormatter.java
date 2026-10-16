package org.apache.commons.cli;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class HelpFormatter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f145201a = 74;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f145202b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f145203c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f145204d = "usage: ";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f145205e = System.getProperty("line.separator");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f145206f = "-";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f145207g = "--";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f145208h = "arg";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Comparator f145209i = new OptionComparator();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class OptionComparator implements Comparator {
        private OptionComparator() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Option) obj).h().compareToIgnoreCase(((Option) obj2).h());
        }
    }

    protected String a(int i3) {
        StringBuffer stringBuffer = new StringBuffer(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            stringBuffer.append(' ');
        }
        return stringBuffer.toString();
    }

    protected int b(String str, int i3, int i4) {
        char cCharAt;
        char cCharAt2;
        int iIndexOf = str.indexOf(10, i4);
        if ((iIndexOf != -1 && iIndexOf <= i3) || ((iIndexOf = str.indexOf(9, i4)) != -1 && iIndexOf <= i3)) {
            return iIndexOf + 1;
        }
        int i5 = i3 + i4;
        if (i5 >= str.length()) {
            return -1;
        }
        int i6 = i5;
        while (i6 >= i4 && (cCharAt2 = str.charAt(i6)) != ' ' && cCharAt2 != '\n' && cCharAt2 != '\r') {
            i6--;
        }
        if (i6 > i4) {
            return i6;
        }
        while (i5 <= str.length() && (cCharAt = str.charAt(i5)) != ' ' && cCharAt != '\n' && cCharAt != '\r') {
            i5++;
        }
        if (i5 == str.length()) {
            return -1;
        }
        return i5;
    }

    public int c() {
        return this.f145203c;
    }

    public int d() {
        return this.f145202b;
    }

    public Comparator e() {
        return this.f145209i;
    }

    public int f() {
        return this.f145201a;
    }

    public void g(PrintWriter printWriter, int i3, Options options, int i4, int i5) {
        StringBuffer stringBuffer = new StringBuffer();
        h(stringBuffer, i3, options, i4, i5);
        printWriter.println(stringBuffer.toString());
    }

    protected StringBuffer h(StringBuffer stringBuffer, int i3, Options options, int i4, int i5) {
        String strA = a(i4);
        String strA2 = a(i5);
        ArrayList arrayList = new ArrayList();
        List<Option> listF = options.f();
        Collections.sort(listF, e());
        int i6 = 0;
        int length = 0;
        for (Option option : listF) {
            StringBuffer stringBuffer2 = new StringBuffer(8);
            if (option.j() == null) {
                stringBuffer2.append(strA);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("   ");
                stringBuffer3.append(this.f145207g);
                stringBuffer2.append(stringBuffer3.toString());
                stringBuffer2.append(option.i());
            } else {
                stringBuffer2.append(strA);
                stringBuffer2.append(this.f145206f);
                stringBuffer2.append(option.j());
                if (option.r()) {
                    stringBuffer2.append(',');
                    stringBuffer2.append(this.f145207g);
                    stringBuffer2.append(option.i());
                }
            }
            if (option.o()) {
                if (option.p()) {
                    stringBuffer2.append(" <");
                    stringBuffer2.append(option.e());
                    stringBuffer2.append(">");
                } else {
                    stringBuffer2.append(' ');
                }
            }
            arrayList.add(stringBuffer2);
            if (stringBuffer2.length() > length) {
                length = stringBuffer2.length();
            }
        }
        Iterator it = listF.iterator();
        while (it.hasNext()) {
            Option option2 = (Option) it.next();
            int i7 = i6 + 1;
            StringBuffer stringBuffer4 = new StringBuffer(arrayList.get(i6).toString());
            if (stringBuffer4.length() < length) {
                stringBuffer4.append(a(length - stringBuffer4.length()));
            }
            stringBuffer4.append(strA2);
            int i8 = length + i5;
            if (option2.g() != null) {
                stringBuffer4.append(option2.g());
            }
            i(stringBuffer, i3, i8, stringBuffer4.toString());
            if (it.hasNext()) {
                stringBuffer.append(this.f145205e);
            }
            i6 = i7;
        }
        return stringBuffer;
    }

    protected StringBuffer i(StringBuffer stringBuffer, int i3, int i4, String str) {
        int iB = b(str, i3, 0);
        if (iB == -1) {
            stringBuffer.append(j(str));
            return stringBuffer;
        }
        stringBuffer.append(j(str.substring(0, iB)));
        stringBuffer.append(this.f145205e);
        if (i4 >= i3) {
            i4 = 1;
        }
        String strA = a(i4);
        while (true) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(strA);
            stringBuffer2.append(str.substring(iB).trim());
            str = stringBuffer2.toString();
            iB = b(str, i3, 0);
            if (iB == -1) {
                stringBuffer.append(str);
                return stringBuffer;
            }
            if (str.length() > i3 && iB == i4 - 1) {
                iB = i3;
            }
            stringBuffer.append(j(str.substring(0, iB)));
            stringBuffer.append(this.f145205e);
        }
    }

    protected String j(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        while (length > 0 && Character.isWhitespace(str.charAt(length - 1))) {
            length--;
        }
        return str.substring(0, length);
    }
}
