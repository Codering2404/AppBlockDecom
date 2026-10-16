package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class GlideException extends Exception {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final StackTraceElement[] f66484h = new StackTraceElement[0];
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f66485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Key f66486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private DataSource f66487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Class f66488d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f66489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Exception f66490g;

    public GlideException(String str) {
        this(str, Collections.EMPTY_LIST);
    }

    private void a(Throwable th, List list) {
        if (th instanceof GlideException) {
            Iterator it = ((GlideException) th).e().iterator();
            while (it.hasNext()) {
                a((Throwable) it.next(), list);
            }
        } else if (th != null) {
            list.add(th);
        }
    }

    private static void b(List list, Appendable appendable) {
        try {
            c(list, appendable);
        } catch (IOException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static void c(List list, Appendable appendable) throws IOException {
        int size = list.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            appendable.append("Cause (").append(String.valueOf(i4)).append(" of ").append(String.valueOf(size)).append("): ");
            Throwable th = (Throwable) list.get(i3);
            if (th instanceof GlideException) {
                ((GlideException) th).h(appendable);
            } else {
                d(th, appendable);
            }
            i3 = i4;
        }
    }

    private static void d(Throwable th, Appendable appendable) {
        try {
            appendable.append(th.getClass().toString()).append(": ").append(th.getMessage()).append('\n');
        } catch (IOException unused) {
            throw new RuntimeException(th);
        }
    }

    private void h(Appendable appendable) {
        d(this, appendable);
        b(e(), new IndentedAppendable(appendable));
    }

    public List e() {
        return this.f66485a;
    }

    public List f() {
        ArrayList arrayList = new ArrayList();
        a(this, arrayList);
        return arrayList;
    }

    public void g(String str) {
        List listF = f();
        int size = listF.size();
        int i3 = 0;
        while (i3 < size) {
            StringBuilder sb = new StringBuilder();
            sb.append("Root cause (");
            int i4 = i3 + 1;
            sb.append(i4);
            sb.append(" of ");
            sb.append(size);
            sb.append(")");
            Log.i(str, sb.toString(), (Throwable) listF.get(i3));
            i3 = i4;
        }
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(71);
        sb.append(this.f66489f);
        sb.append(this.f66488d != null ? ", " + this.f66488d : "");
        sb.append(this.f66487c != null ? ", " + this.f66487c : "");
        sb.append(this.f66486b != null ? ", " + this.f66486b : "");
        List<Throwable> listF = f();
        if (listF.isEmpty()) {
            return sb.toString();
        }
        if (listF.size() == 1) {
            sb.append("\nThere was 1 root cause:");
        } else {
            sb.append("\nThere were ");
            sb.append(listF.size());
            sb.append(" root causes:");
        }
        for (Throwable th : listF) {
            sb.append('\n');
            sb.append(th.getClass().getName());
            sb.append('(');
            sb.append(th.getMessage());
            sb.append(')');
        }
        sb.append("\n call GlideException#logRootCauses(String) for more detail");
        return sb.toString();
    }

    void i(Key key, DataSource dataSource) {
        j(key, dataSource, null);
    }

    void j(Key key, DataSource dataSource, Class cls) {
        this.f66486b = key;
        this.f66487c = dataSource;
        this.f66488d = cls;
    }

    public void k(Exception exc) {
        this.f66490g = exc;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    public GlideException(String str, Throwable th) {
        this(str, Collections.singletonList(th));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        h(printStream);
    }

    public GlideException(String str, List list) {
        this.f66489f = str;
        setStackTrace(f66484h);
        this.f66485a = list;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        h(printWriter);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class IndentedAppendable implements Appendable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Appendable f66491a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f66492b = true;

        IndentedAppendable(Appendable appendable) {
            this.f66491a = appendable;
        }

        private CharSequence a(CharSequence charSequence) {
            return charSequence == null ? "" : charSequence;
        }

        @Override // java.lang.Appendable
        public Appendable append(char c3) throws IOException {
            if (this.f66492b) {
                this.f66492b = false;
                this.f66491a.append("  ");
            }
            this.f66492b = c3 == '\n';
            this.f66491a.append(c3);
            return this;
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence) {
            CharSequence charSequenceA = a(charSequence);
            return append(charSequenceA, 0, charSequenceA.length());
        }

        @Override // java.lang.Appendable
        public Appendable append(CharSequence charSequence, int i3, int i4) throws IOException {
            CharSequence charSequenceA = a(charSequence);
            boolean z2 = false;
            if (this.f66492b) {
                this.f66492b = false;
                this.f66491a.append("  ");
            }
            if (charSequenceA.length() > 0 && charSequenceA.charAt(i4 - 1) == '\n') {
                z2 = true;
            }
            this.f66492b = z2;
            this.f66491a.append(charSequenceA, i3, i4);
            return this;
        }
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }
}
