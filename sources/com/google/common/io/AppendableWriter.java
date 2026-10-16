package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class AppendableWriter extends Writer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Appendable f85180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f85181b;

    private void a() throws IOException {
        if (this.f85181b) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f85181b = true;
        Appendable appendable = this.f85180a;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() throws IOException {
        a();
        Appendable appendable = this.f85180a;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i3, int i4) throws IOException {
        a();
        this.f85180a.append(new String(cArr, i3, i4));
    }

    @Override // java.io.Writer
    public void write(int i3) throws IOException {
        a();
        this.f85180a.append((char) i3);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c3) throws IOException {
        a();
        this.f85180a.append(c3);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str) throws IOException {
        Preconditions.t(str);
        a();
        this.f85180a.append(str);
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) throws IOException {
        a();
        this.f85180a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i3, int i4) throws IOException {
        a();
        this.f85180a.append(charSequence, i3, i4);
        return this;
    }

    @Override // java.io.Writer
    public void write(String str, int i3, int i4) throws IOException {
        Preconditions.t(str);
        a();
        this.f85180a.append(str, i3, i4 + i3);
    }
}
