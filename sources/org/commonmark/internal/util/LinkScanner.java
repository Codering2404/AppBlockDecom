package org.commonmark.internal.util;

import org.commonmark.internal.inline.Scanner;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public class LinkScanner {
    public static boolean a(Scanner scanner) {
        char cL;
        if (!scanner.e()) {
            return false;
        }
        if (!scanner.i('<')) {
            return b(scanner);
        }
        while (scanner.e() && (cL = scanner.l()) != '\n' && cL != '<') {
            if (cL == '>') {
                scanner.h();
                return true;
            }
            if (cL != '\\') {
                scanner.h();
            } else {
                scanner.h();
                if (Parsing.g(scanner.l())) {
                    scanner.h();
                }
            }
        }
        return false;
    }

    private static boolean b(Scanner scanner) {
        int i3 = 0;
        boolean z2 = true;
        while (scanner.e()) {
            char cL = scanner.l();
            if (cL == ' ') {
                return !z2;
            }
            if (cL == '\\') {
                scanner.h();
                if (Parsing.g(scanner.l())) {
                    scanner.h();
                }
            } else if (cL == '(') {
                i3++;
                if (i3 > 32) {
                    return false;
                }
                scanner.h();
            } else if (cL != ')') {
                if (Character.isISOControl(cL)) {
                    return !z2;
                }
                scanner.h();
            } else {
                if (i3 == 0) {
                    return true;
                }
                i3--;
                scanner.h();
            }
            z2 = false;
        }
        return true;
    }

    public static boolean c(Scanner scanner) {
        while (scanner.e()) {
            switch (scanner.l()) {
                case '[':
                    return false;
                case '\\':
                    scanner.h();
                    if (Parsing.g(scanner.l())) {
                        scanner.h();
                    }
                    break;
                case ']':
                    return true;
                default:
                    scanner.h();
                    break;
            }
        }
        return true;
    }

    public static boolean d(Scanner scanner) {
        if (!scanner.e()) {
            return false;
        }
        char cL = scanner.l();
        char c3 = '\"';
        if (cL != '\"') {
            c3 = '\'';
            if (cL != '\'') {
                if (cL != '(') {
                    return false;
                }
                c3 = ')';
            }
        }
        scanner.h();
        if (!e(scanner, c3) || !scanner.e()) {
            return false;
        }
        scanner.h();
        return true;
    }

    public static boolean e(Scanner scanner, char c3) {
        while (scanner.e()) {
            char cL = scanner.l();
            if (cL == '\\') {
                scanner.h();
                if (Parsing.g(scanner.l())) {
                    scanner.h();
                }
            } else {
                if (cL == c3) {
                    return true;
                }
                if (c3 == ')' && cL == '(') {
                    return false;
                }
                scanner.h();
            }
        }
        return true;
    }
}
