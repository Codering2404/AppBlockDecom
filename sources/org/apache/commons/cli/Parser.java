package org.apache.commons.cli;

import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class Parser implements CommandLineParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected CommandLine f145230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Options f145231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List f145232c;

    @Override // org.apache.commons.cli.CommandLineParser
    public CommandLine a(Options options, String[] strArr, boolean z2) {
        return f(options, strArr, null, z2);
    }

    protected void b() throws MissingOptionException {
        if (!e().isEmpty()) {
            throw new MissingOptionException(e());
        }
    }

    protected abstract String[] c(Options options, String[] strArr, boolean z2);

    protected Options d() {
        return this.f145231b;
    }

    protected List e() {
        return this.f145232c;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.apache.commons.cli.CommandLine f(org.apache.commons.cli.Options r6, java.lang.String[] r7, java.util.Properties r8, boolean r9) throws org.apache.commons.cli.UnrecognizedOptionException, org.apache.commons.cli.AlreadySelectedException, org.apache.commons.cli.MissingOptionException, org.apache.commons.cli.MissingArgumentException {
        /*
            r5 = this;
            java.util.List r0 = r6.f()
            java.util.Iterator r0 = r0.iterator()
        L8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L18
            java.lang.Object r1 = r0.next()
            org.apache.commons.cli.Option r1 = (org.apache.commons.cli.Option) r1
            r1.c()
            goto L8
        L18:
            r5.j(r6)
            org.apache.commons.cli.CommandLine r6 = new org.apache.commons.cli.CommandLine
            r6.<init>()
            r5.f145230a = r6
            r6 = 0
            if (r7 != 0) goto L27
            java.lang.String[] r7 = new java.lang.String[r6]
        L27:
            org.apache.commons.cli.Options r0 = r5.d()
            java.lang.String[] r7 = r5.c(r0, r7, r9)
            java.util.List r7 = java.util.Arrays.asList(r7)
            java.util.ListIterator r7 = r7.listIterator()
        L37:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L9d
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r1 = "--"
            boolean r2 = r1.equals(r0)
            r3 = 1
            if (r2 == 0) goto L4e
        L4c:
            r6 = r3
            goto L83
        L4e:
            java.lang.String r2 = "-"
            boolean r4 = r2.equals(r0)
            if (r4 == 0) goto L5f
            if (r9 == 0) goto L59
            goto L4c
        L59:
            org.apache.commons.cli.CommandLine r2 = r5.f145230a
            r2.a(r0)
            goto L83
        L5f:
            boolean r2 = r0.startsWith(r2)
            if (r2 == 0) goto L7b
            if (r9 == 0) goto L77
            org.apache.commons.cli.Options r2 = r5.d()
            boolean r2 = r2.e(r0)
            if (r2 != 0) goto L77
            org.apache.commons.cli.CommandLine r6 = r5.f145230a
            r6.a(r0)
            goto L4c
        L77:
            r5.h(r0, r7)
            goto L83
        L7b:
            org.apache.commons.cli.CommandLine r2 = r5.f145230a
            r2.a(r0)
            if (r9 == 0) goto L83
            goto L4c
        L83:
            if (r6 == 0) goto L37
        L85:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L37
            java.lang.Object r0 = r7.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = r1.equals(r0)
            if (r2 != 0) goto L85
            org.apache.commons.cli.CommandLine r2 = r5.f145230a
            r2.a(r0)
            goto L85
        L9d:
            r5.i(r8)
            r5.b()
            org.apache.commons.cli.CommandLine r6 = r5.f145230a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.cli.Parser.f(org.apache.commons.cli.Options, java.lang.String[], java.util.Properties, boolean):org.apache.commons.cli.CommandLine");
    }

    public void g(Option option, ListIterator listIterator) throws MissingArgumentException {
        while (true) {
            if (!listIterator.hasNext()) {
                break;
            }
            String str = (String) listIterator.next();
            if (d().e(str) && str.startsWith("-")) {
                listIterator.previous();
                break;
            } else {
                try {
                    option.b(Util.a(str));
                } catch (RuntimeException unused) {
                    listIterator.previous();
                }
            }
        }
        if (option.m() == null && !option.t()) {
            throw new MissingArgumentException(option);
        }
    }

    protected void h(String str, ListIterator listIterator) throws UnrecognizedOptionException, AlreadySelectedException, MissingArgumentException {
        if (!d().e(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unrecognized option: ");
            stringBuffer.append(str);
            throw new UnrecognizedOptionException(stringBuffer.toString(), str);
        }
        Option option = (Option) d().b(str).clone();
        if (option.v()) {
            e().remove(option.h());
        }
        if (d().c(option) != null) {
            OptionGroup optionGroupC = d().c(option);
            if (optionGroupC.c()) {
                e().remove(optionGroupC);
            }
            optionGroupC.d(option);
        }
        if (option.o()) {
            g(option, listIterator);
        }
        this.f145230a.b(option);
    }

    protected void i(Properties properties) {
        if (properties == null) {
            return;
        }
        Enumeration<?> enumerationPropertyNames = properties.propertyNames();
        while (enumerationPropertyNames.hasMoreElements()) {
            String string = enumerationPropertyNames.nextElement().toString();
            if (!this.f145230a.d(string)) {
                Option optionB = d().b(string);
                String property = properties.getProperty(string);
                if (optionB.o()) {
                    if (optionB.m() == null || optionB.m().length == 0) {
                        try {
                            optionB.b(property);
                        } catch (RuntimeException unused) {
                        }
                    }
                } else if (!"yes".equalsIgnoreCase(property) && !ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(property) && !AppEventsConstants.EVENT_PARAM_VALUE_YES.equalsIgnoreCase(property)) {
                    return;
                }
                this.f145230a.b(optionB);
            }
        }
    }

    protected void j(Options options) {
        this.f145231b = options;
        this.f145232c = new ArrayList(options.d());
    }
}
